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
public class Consumidor {
    
    String rutConsumidor;
    int puntos;
    int activoCupon;
    String nombre;
    String apellidop;
    Categoria categoria;
    Tienda tienda;

        public Categoria getCategoria() {
                return categoria;
        }

        public void setCategoria(Categoria categoria) {
                this.categoria = categoria;
        }

        public Tienda getTienda() {
                return tienda;
        }

        public void setTienda(Tienda tienda) {
                this.tienda = tienda;
        }



        public int getActivocupon() {
                return activoCupon;
        }

        public void setActivocupon(int activocupon) {
                this.activoCupon = activocupon;
        }
    
    ///
    //atributos de ofertas , tienda y categoria de p preferidas
    
    

    public String getRutconsumidor() {
        return rutConsumidor;
    }

    public void setRutconsumidor(String rutconsumidor) {
        this.rutConsumidor = rutconsumidor;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }
    
}
