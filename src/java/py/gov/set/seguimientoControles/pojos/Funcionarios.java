package py.gov.set.seguimientoControles.pojos;
// Generated 12/09/2017 09:21:01 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Funcionarios generated by hbm2java
 */
public class Funcionarios  implements java.io.Serializable {


     private FuncionariosId id;
     private DptoOperativo dptoOperativo;
     private String nombre;
     private String primerApellido;
     private String segundoApellido;
     private String cargo;
     private Date fechaDesde;
     private Date fechaHasta;

    public Funcionarios() {
    }

	
    public Funcionarios(FuncionariosId id, DptoOperativo dptoOperativo) {
        this.id = id;
        this.dptoOperativo = dptoOperativo;
    }
    public Funcionarios(FuncionariosId id, DptoOperativo dptoOperativo, String nombre, String primerApellido, String segundoApellido, String cargo, Date fechaDesde, Date fechaHasta) {
       this.id = id;
       this.dptoOperativo = dptoOperativo;
       this.nombre = nombre;
       this.primerApellido = primerApellido;
       this.segundoApellido = segundoApellido;
       this.cargo = cargo;
       this.fechaDesde = fechaDesde;
       this.fechaHasta = fechaHasta;
    }
   
    public FuncionariosId getId() {
        return this.id;
    }
    
    public void setId(FuncionariosId id) {
        this.id = id;
    }
    public DptoOperativo getDptoOperativo() {
        return this.dptoOperativo;
    }
    
    public void setDptoOperativo(DptoOperativo dptoOperativo) {
        this.dptoOperativo = dptoOperativo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrimerApellido() {
        return this.primerApellido;
    }
    
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public String getSegundoApellido() {
        return this.segundoApellido;
    }
    
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
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

