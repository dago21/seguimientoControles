package py.gov.set.seguimientoControles.pojos;
// Generated 12/09/2017 09:21:01 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * ProcesoActuantes generated by hbm2java
 */
public class ProcesoActuantes  implements java.io.Serializable {


     private int idProcesoActuante;
     private ProcesoCabecera procesoCabecera;
     private Integer ciActuante;
     private Date fechaDesde;
     private Date fechaHasta;

    public ProcesoActuantes() {
    }

	
    public ProcesoActuantes(int idProcesoActuante) {
        this.idProcesoActuante = idProcesoActuante;
    }
    public ProcesoActuantes(int idProcesoActuante, ProcesoCabecera procesoCabecera, Integer ciActuante, Date fechaDesde, Date fechaHasta) {
       this.idProcesoActuante = idProcesoActuante;
       this.procesoCabecera = procesoCabecera;
       this.ciActuante = ciActuante;
       this.fechaDesde = fechaDesde;
       this.fechaHasta = fechaHasta;
    }
   
    public int getIdProcesoActuante() {
        return this.idProcesoActuante;
    }
    
    public void setIdProcesoActuante(int idProcesoActuante) {
        this.idProcesoActuante = idProcesoActuante;
    }
    public ProcesoCabecera getProcesoCabecera() {
        return this.procesoCabecera;
    }
    
    public void setProcesoCabecera(ProcesoCabecera procesoCabecera) {
        this.procesoCabecera = procesoCabecera;
    }
    public Integer getCiActuante() {
        return this.ciActuante;
    }
    
    public void setCiActuante(Integer ciActuante) {
        this.ciActuante = ciActuante;
    }
    public Date getFechaDesde() {
        return this.fechaDesde;
    }
    
    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
    public Date getFechaHasta() {
        return this.fechaHasta;
    }
    
    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }




}

