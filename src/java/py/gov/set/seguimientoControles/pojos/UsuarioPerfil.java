package py.gov.set.seguimientoControles.pojos;
// Generated 12/09/2017 09:21:01 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * UsuarioPerfil generated by hbm2java
 */
public class UsuarioPerfil  implements java.io.Serializable {


     private UsuarioPerfilId id;
     private Perfiles perfiles;
     private Usuarios usuarios;
     private Date fechaDesde;
     private Date fechaHasta;

    public UsuarioPerfil() {
    }

	
    public UsuarioPerfil(UsuarioPerfilId id, Perfiles perfiles, Usuarios usuarios) {
        this.id = id;
        this.perfiles = perfiles;
        this.usuarios = usuarios;
    }
    public UsuarioPerfil(UsuarioPerfilId id, Perfiles perfiles, Usuarios usuarios, Date fechaDesde, Date fechaHasta) {
       this.id = id;
       this.perfiles = perfiles;
       this.usuarios = usuarios;
       this.fechaDesde = fechaDesde;
       this.fechaHasta = fechaHasta;
    }
   
    public UsuarioPerfilId getId() {
        return this.id;
    }
    
    public void setId(UsuarioPerfilId id) {
        this.id = id;
    }
    public Perfiles getPerfiles() {
        return this.perfiles;
    }
    
    public void setPerfiles(Perfiles perfiles) {
        this.perfiles = perfiles;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
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

