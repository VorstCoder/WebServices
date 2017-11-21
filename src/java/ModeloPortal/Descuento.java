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
public class Descuento {
    
    int idDescuento;
    int idRubro;
    String nombreRubro;
    int tope;
    int descuento;
    int puntos;

        public int getIdDescuento() {
                return idDescuento;
        }

        public void setIdDescuento(int idDescuento) {
                this.idDescuento = idDescuento;
        }

        public int getIdRubro() {
                return idRubro;
        }

        public void setIdRubro(int idRubro) {
                this.idRubro = idRubro;
        }

        public String getNombreRubro() {
                return nombreRubro;
        }

        public void setNombreRubro(String nombreRubro) {
                this.nombreRubro = nombreRubro;
        }
    

    public int getIdrubro() {
        return idRubro;
    }

    public void setIdrubro(int idrubro) {
        this.idRubro = idrubro;
    }

    public String getNombrerubro() {
        return nombreRubro;
    }

    public void setNombrerubro(String nombrerubro) {
        this.nombreRubro = nombrerubro;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
}
