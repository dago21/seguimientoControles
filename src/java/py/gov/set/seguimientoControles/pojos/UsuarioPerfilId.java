package py.gov.set.seguimientoControles.pojos;
// Generated 12/09/2017 09:21:01 AM by Hibernate Tools 4.3.1



/**
 * UsuarioPerfilId generated by hbm2java
 */
public class UsuarioPerfilId  implements java.io.Serializable {


     private String idUsuario;
     private int idPerfil;

    public UsuarioPerfilId() {
    }

    public UsuarioPerfilId(String idUsuario, int idPerfil) {
       this.idUsuario = idUsuario;
       this.idPerfil = idPerfil;
    }
   
    public String getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdPerfil() {
        return this.idPerfil;
    }
    
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UsuarioPerfilId) ) return false;
		 UsuarioPerfilId castOther = ( UsuarioPerfilId ) other; 
         
		 return ( (this.getIdUsuario()==castOther.getIdUsuario()) || ( this.getIdUsuario()!=null && castOther.getIdUsuario()!=null && this.getIdUsuario().equals(castOther.getIdUsuario()) ) )
 && (this.getIdPerfil()==castOther.getIdPerfil());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdUsuario() == null ? 0 : this.getIdUsuario().hashCode() );
         result = 37 * result + this.getIdPerfil();
         return result;
   }   


}

