package py.gov.set.seguimientoControles.pojos;
// Generated 12/09/2017 09:21:01 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * SuspensionProcesos generated by hbm2java
 */
public class SuspensionProcesos  implements java.io.Serializable {


     private int idSuspension;
     private ProcesoCabecera procesoCabecera;
     private Date fechaDesde;
     private Date fechaHasta;
     private Integer cantidadDias;

    public SuspensionProcesos() {
    }

	
    public SuspensionProcesos(int idSuspension, ProcesoCabecera procesoCabecera) {
        this.idSuspension = idSuspension;
        this.procesoCabecera = procesoCabecera;
    }
    public SuspensionProcesos(int idSuspension, ProcesoCabecera procesoCabecera, Date fechaDesde, Date fechaHasta, Integer cantidadDias) {
       this.idSuspension = idSuspension;
       this.procesoCabecera = procesoCabecera;
       this.fechaDesde = fechaDesde;
       this.fechaHasta = fechaHasta;
       this.cantidadDias = cantidadDias;
    }
   
    public int getIdSuspension() {
        return this.idSuspension;
    }
    
    public void setIdSuspension(int idSuspension) {
        this.idSuspension = idSuspension;
    }
    public ProcesoCabecera getProcesoCabecera() {
        return this.procesoCabecera;
    }
    
    public void setProcesoCabecera(ProcesoCabecera procesoCabecera) {
        this.procesoCabecera = procesoCabecera;
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
    public Integer getCantidadDias() {
        return this.cantidadDias;
    }
    
    public void setCantidadDias(Integer cantidadDias) {
        this.cantidadDias = cantidadDias;
    }




}

