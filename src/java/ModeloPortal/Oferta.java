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
public class Oferta {
    
     int idOferta;
     String fechaInicio;
     String fechaTermino;
     int precioOferta;  
     int cantidadOfertaProducto;
     Tienda tienda;
     Producto producto;
     Sucursal sucursal;
      Categoria categoria;
   
        public Producto getProducto() {
                return producto;
        }

        public void setProducto(Producto producto) {
                this.producto = producto;
        }
 

        public Categoria getCategoria() {
                return categoria;
        }

        public void setCategoria(Categoria categoria) {
                this.categoria = categoria;
        }


   
        public Sucursal getSucursal() {
                return sucursal;
        }

        public void setSucursal(Sucursal sucursal) {
                this.sucursal = sucursal;
        }


    public int getIdoferta() {
        return idOferta;
    }

    public void setIdoferta(int idoferta) {
        this.idOferta = idoferta;
    }

        public Tienda getTienda() {
                return tienda;
        }

        public void setTienda(Tienda tienda) {
                this.tienda = tienda;
        }


    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

 

    public int getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(int precioOferta) {
        this.precioOferta = precioOferta;
    }

    public int getCantidadOfertaProducto() {
        return cantidadOfertaProducto;
    }

    public void setCantidadOfertaProducto(int cantidadOfertaProducto) {
        this.cantidadOfertaProducto = cantidadOfertaProducto;
    }



    
    
}
