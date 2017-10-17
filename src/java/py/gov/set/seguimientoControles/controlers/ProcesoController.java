/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.set.seguimientoControles.controlers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import py.gov.set.seguimientoControles.pojos.DptoOperativo;
import py.gov.set.seguimientoControles.pojos.Obligaciones;
import py.gov.set.seguimientoControles.pojos.ProcesoCabecera;
import py.gov.set.seguimientoControles.pojos.ProcesoPeriodos;
import py.gov.set.seguimientoControles.pojos.TipoControl;
import py.gov.set.seguimientoControles.utils.ProcesoUtils;
import py.gov.set.seguimientoControles.vistas.ProcesoPeriodoView;

/**
 *
 * @author agomez
 */
@ManagedBean(name = "proceso")
@ViewScoped
public class ProcesoController {

//utiles
    private ProcesoUtils utilsProceso = new ProcesoUtils();
// listas
    private List<SelectItem> tipoControlList = new ArrayList<SelectItem>();
    private List<SelectItem> dptoList = new ArrayList<SelectItem>();
    private List<SelectItem> categ = new ArrayList<SelectItem>();
    private List<SelectItem> taxList = new ArrayList<SelectItem>();
    private List<ProcesoPeriodoView> taxSelectedList = new ArrayList<ProcesoPeriodoView>();
    List<ProcesoPeriodos> taxProcesList = new ArrayList<ProcesoPeriodos>();

//variables
    private String selectedTipoControl = "";
    private int nroProceso;
    private String selectedDate = "";
    private String nroOrden = "";
    private String selectedDpto = "";
    private String ruc = "";
    private String razonSocial = "";
    private String selectedCategoria = "";
    private String actEconomica = "";
    private int selectedTax;
    private String periodo = "";
    private String periodoPattern = "99/9999";
    private String selectedPeriodicidad = "";

    /**
     * Creates a new instance of ProcesoController
     */
    public ProcesoController() {
    }

    private void limpiarVariables() {
        //listas
        categ.clear();
        tipoControlList.clear();
        dptoList.clear();
        taxList.clear();
        taxSelectedList.clear();
        //variables

        selectedDate = "";
        nroProceso = 0;
        nroOrden = "";
        selectedDpto = "";
        ruc = "";
        razonSocial = "";
        selectedCategoria = "";
        actEconomica = "";
        periodoPattern = "";
        selectedPeriodicidad = "";
    }

    public void agregarPeriodo() {
        System.out.println("Ingreso al metodo agregarPeriodo() con siguientes valores:"
                + selectedTax + " Periodo " + periodo);
        System.out.println("Largo de la lista antes de la inserción" + taxSelectedList.size());
        Obligaciones taxAux = utilsProceso.buscarObligacion(new BigDecimal(selectedTax));
        ProcesoPeriodos taxProces = new ProcesoPeriodos();

        taxProces.setCodObligacion(selectedTax);
        taxProces.setObligacion(taxAux.getSigla());
        taxProces.setPeriodoFiscal(new Date(periodo));
        taxProcesList.add(taxProces);

        //carga la vista para mostrar en la tabla.
        ProcesoPeriodoView ppv = new ProcesoPeriodoView();
        ppv.setCodObligacion(selectedTax);
        ppv.setNombreObligacion(taxAux.getSigla());
        System.out.println("Obligacion: " + selectedTax);
        System.out.println("Periodo: " + periodo);
        System.out.println("Periodicidad" + utilsProceso.buscarObligacion(new BigDecimal(selectedTax)).getPeriodicidad());
        if(utilsProceso.buscarObligacion(new BigDecimal(selectedTax)).getPeriodicidad().equals("ANUAL")) {
            System.out.println("Entra ANUAL");
            ppv.setPeriodo(periodo.substring(periodo.length()-4,periodo.length()));
        } else {
            System.out.println("NO EXTRA ANUAL");
            ppv.setPeriodo(periodo.substring(3, periodo.length()));
        }
        
        taxSelectedList.add(ppv);
        

        System.out.println("Largo de la lista luego de inserción" + taxSelectedList.size());

        //limpia variables utilizadas.
        selectedTax = 0;
        periodo = "";
    }
    
    public void crearProceso() {
        ProcesoCabecera pc = new ProcesoCabecera();
        pc.setNroProceso(nroProceso);
        System.out.println("id DPto: " + selectedDpto);
        DptoOperativo dpo = utilsProceso.buscarDpto(Integer.parseInt(selectedDpto));
        System.out.println("Dpto. Recuperado: " + dpo.getNombre());
        pc.setDptoOperativo(dpo);
        TipoControl tc = utilsProceso.buscarTipoControl(Integer.parseInt(selectedTipoControl));
        System.out.println("Tipo Control Seleccionado: " + tc.getDescripcion());
        pc.setTipoControl(tc);
        pc.setRuc(ruc);
        pc.setRazonSocial(razonSocial);
        pc.setFechaAsignacion(new Date(selectedDate));
        pc.setEstadoProceso("NO INICIADO");
        
        
    } 
    
    public void definirPattern() {
        if(selectedPeriodicidad.equals("ANUAL")) {
            periodoPattern = "9999";
        } else {
            periodoPattern = "99/9999";
        }
    }

    @PostConstruct
    public void init() {
        limpiarVariables();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String userId = (String) session.getAttribute("SPRING_SECURITY_LAST_USERNAME");

        //if(userId != null) {
        //carga la lista de valores de las categorías de los contribuyentes.
        categ.add(new SelectItem(0, ""));
        categ.add(new SelectItem(1, "PEQUEÑO"));
        categ.add(new SelectItem(2, "MEDIANO"));
        categ.add(new SelectItem(3, "GRANDE"));

        //carga la lista de valores de los tipos de controles
        tipoControlList.add(new SelectItem(0, " "));
        List<TipoControl> tpList = utilsProceso.listControles();
        for (int k = 0; k < tpList.size(); k++) {
            tipoControlList.add(new SelectItem(tpList.get(k).getIdTipo(), tpList.get(k).getDescripcion()));
        }

        //CARGA LA LISTA DE LOS DEPARTAMENTOS OPERATIVOS.
        dptoList.add(new SelectItem(0, ""));
        List<DptoOperativo> dop = utilsProceso.listDepartamentos();
        for (DptoOperativo aux : dop) {
            dptoList.add(new SelectItem(aux.getIdDpto(), aux.getSigla()));
        }

        //CARGA LA LISTA DE OBLIGACIONES
        taxList.add(new SelectItem(0, ""));
        List<Obligaciones> taxes = utilsProceso.listObligaciones();
        for (Obligaciones aux : taxes) {
            taxList.add(new SelectItem(aux.getCodObligacion(), aux.getCodObligacion() + "-" + aux.getSigla()));
        }

        //}
        System.out.println("largo lista" + tipoControlList.size());
    }

    
    //GETERS Y SETERS 
    public String getSelectedTipoControl() {
        return selectedTipoControl;
    }

    public void setSelectedTipoControl(String selectedTipoControl) {
        this.selectedTipoControl = selectedTipoControl;
    }

    public List<SelectItem> getTipoControlList() {
        return tipoControlList;
    }

    public void setTipoControlList(List<SelectItem> tipoControlList) {
        this.tipoControlList = tipoControlList;
    }

    public int getNroProceso() {
        return nroProceso;
    }

    public void setNroProceso(int nroProceso) {
        this.nroProceso = nroProceso;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public List<SelectItem> getDptoList() {
        return dptoList;
    }

    public void setDptoList(List<SelectItem> dptoList) {
        this.dptoList = dptoList;
    }

    public String getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(String nroOrden) {
        this.nroOrden = nroOrden;
    }

    public String getSelectedDpto() {
        return selectedDpto;
    }

    public void setSelectedDpto(String selectedDpto) {
        this.selectedDpto = selectedDpto;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(String selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    public String getActEconomica() {
        return actEconomica;
    }

    public void setActEconomica(String actEconomica) {
        this.actEconomica = actEconomica;
    }

    public List<SelectItem> getCateg() {
        return categ;
    }

    public List<SelectItem> getTaxList() {
        return taxList;
    }

    public void setTaxList(List<SelectItem> taxList) {
        this.taxList = taxList;
    }

    public int getSelectedTax() {
        return selectedTax;
    }

    public void setSelectedTax(int selectedTax) {
        this.selectedTax = selectedTax;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<ProcesoPeriodoView> getTaxSelectedList() {
        return taxSelectedList;
    }

    public void setTaxSelectedList(List<ProcesoPeriodoView> taxSelectedList) {
        this.taxSelectedList = taxSelectedList;
    }

    public List<ProcesoPeriodos> getTaxProcesList() {
        return taxProcesList;
    }

    public void setTaxProcesList(List<ProcesoPeriodos> taxProcesList) {
        this.taxProcesList = taxProcesList;
    }

    public String getPeriodoPattern() {
        return periodoPattern;
    }

    public void setPeriodoPattern(String periodoPattern) {
        this.periodoPattern = periodoPattern;
    }

    public String getSelectedPeriodicidad() {
        return selectedPeriodicidad;
    }

    public void setSelectedPeriodicidad(String selectedPeriodicidad) {
        this.selectedPeriodicidad = selectedPeriodicidad;
    }

}
