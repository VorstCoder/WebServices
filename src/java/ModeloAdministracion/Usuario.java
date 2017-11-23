/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloAdministracion;

/**
 *
 * @author Alex
 */
public class Usuario {
        
  
    int idUsuario;
    String usuario;
    String clave;
    int idTipoUsuario;
    int idTienda;

        public int getIdUsuario() {
                return idUsuario;
        }

        public void setIdUsuario(int idUsuario) {
                this.idUsuario = idUsuario;
        }

        public String getUsuario() {
                return usuario;
        }

        public void setUsuario(String usuario) {
                this.usuario = usuario;
        }

        public String getClave() {
                return clave;
        }

        public void setClave(String clave) {
                this.clave = clave;
        }

        public int getIdTipoUsuario() {
                return idTipoUsuario;
        }

        public void setIdTipoUsuario(int idTipoUsuario) {
                this.idTipoUsuario = idTipoUsuario;
        }

        public int getIdTienda() {
                return idTienda;
        }

        public void setIdTienda(int idTienda) {
                this.idTienda = idTienda;
        }
        
      
        
        
}
