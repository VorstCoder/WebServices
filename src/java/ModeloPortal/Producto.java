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
public class Producto {
         int codigoBarra;
      String marca;
    String nombreProducto;
    int precioProducto; 
    String rutaImagen;
      String fechaExpiracion;

        public int getCodigobarra() {
                return codigoBarra;
        }

        public void setCodigobarra(int codigobarra) {
                this.codigoBarra = codigobarra;
        }

        public String getMarca() {
                return marca;
        }

        public void setMarca(String marca) {
                this.marca = marca;
        }

        public String getNombreproducto() {
                return nombreProducto;
        }

        public void setNombreproducto(String nombreproducto) {
                this.nombreProducto = nombreproducto;
        }

        public int getPrecioProducto() {
                return precioProducto;
        }

        public void setPrecioProducto(int precioProducto) {
                this.precioProducto = precioProducto;
        }

        public String getRutaimagen() {
                return rutaImagen;
        }

        public void setRutaimagen(String rutaimagen) {
                this.rutaImagen = rutaimagen;
        }

        public String getFechaExpiracion() {
                return fechaExpiracion;
        }

        public void setFechaExpiracion(String fechaExpiracion) {
                this.fechaExpiracion = fechaExpiracion;
        }
}
