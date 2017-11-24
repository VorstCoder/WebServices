/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloPortal;

/**
 *
 * @author Alex
 */
public class Sucursal {
        
         int idSucursal;
          String ciudad;
    String[] direccion;
    String direcionUnica;
    String region;

        public String getRegion() {
                return region;
        }

        public void setRegion(String region) {
                this.region = region;
        }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDirecionUnica() {
        return direcionUnica;
    }

    public void setDirecionUnica(String direcionUnica) {
        this.direcionUnica = direcionUnica;
    }

        public int getIdsucursal() {
                return idSucursal;
        }

        public void setIdsucursal(int idsucursal) {
                this.idSucursal = idsucursal;
        }

        public String getCiudad() {
                return ciudad;
        }

        public void setCiudad(String ciudad) {
                this.ciudad = ciudad;
        }

        public String[] getDireccion() {
                return direccion;
        }

        public void setDireccion(String[] direccion) {
                this.direccion = direccion;
        }
        
        
}
