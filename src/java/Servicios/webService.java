/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import ModeloAdministracion.Usuario;
import ModeloPortal.Categoria;
import ModeloPortal.Conexion;
import ModeloPortal.Consumidor;
import ModeloPortal.Oferta;
import ModeloPortal.Producto;
import ModeloPortal.Descuento;
import ModeloPortal.Sucursal;
import ModeloPortal.Tienda;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Alex
 */
@WebService(serviceName = "webService")
public class webService {


    /**
     * Web service operation
         * @param usuario
         * @param clave
         * @return 
     */
    @WebMethod(operationName = "loginUsuario")
    public Usuario loginUsuario(@WebParam(name = "usuario") String usuario, @WebParam(name = "clave") String clave) {
        
         Usuario usu = new Usuario();
        try{
        String query = "{call LoginUsuario(?,?)}";
       
        CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
        ps.setString(1, usuario);
        ps.setString(2, clave);
       // ps.registerOutParameter(1, Types.VARCHAR);
        
       ps.registerOutParameter(1, Types.VARCHAR);
       ps.registerOutParameter(2, Types.VARCHAR);
       ps.registerOutParameter(3, Types.INTEGER);
         ps.execute();
    
         usu.setUsuario(ps.getString(1));
         usu.setClave(ps.getString(2));
         usu.setIdTipoUsuario(ps.getInt(3));
        
         return usu;
        
        }
        
        catch(SQLException | ClassNotFoundException Ex){
           
           
        }
        
        usu.setIdTipoUsuario(0);
        return usu;
    }

    /**
     * Web service operation
         * @param rut
         * @param clave
         * @return 
     */
    @WebMethod(operationName = "loginConsumidor")
    public boolean loginConsumidor(@WebParam(name = "rut") String rut, @WebParam(name = "clave") String clave) {
     
        try{
        String query = "{call LoginConsumidor(?,?)}";
        
        CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
        ps.setString(1, rut);
        ps.setString(2, clave);
        
        ps.execute();
        
        return true;
        }
        catch(SQLException | ClassNotFoundException Ex){}
        
        return false;
    }

    /**
     * Web service operation
     * @param idperfil
     * @param nombre
     * @param apellidop
     * @param rut
     * @param apellidom
     * @param correo
     * @param clave
     * @param estado
     * @return 
     */
    @WebMethod(operationName = "CrearConsumidor")
    public boolean CrearConsumidor(@WebParam(name = "idperfil") int idperfil, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellidop") String apellidop, @WebParam(name = "apellidom") String apellidom, @WebParam(name = "correo") String correo,@WebParam(name = "rut") String rut,@WebParam(name = "clave") String clave,@WebParam(name = "estado") char estado) {
       
        try{
        String query = "{call CrearPerfilConsumidor(?,?,?,?,?)}";
        CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
        ps.setInt(1, idperfil);
        ps.setString(2, nombre);
        ps.setString(3, apellidop);
        ps.setString(4, apellidom);
        ps.setString(5, correo);
            
        
        ps.execute();
        
        
        String query2 = "{call CrearConsumidor(?,?,?,?,?,?,?)}";
        CallableStatement ps2 = Conexion.getInstancia().getConnection().prepareCall(query2);
        
        ps2.setString(1, rut);
        ps2.setString(2, clave);
        ps2.setInt(3, 0);
        ps2.setString(4,String.valueOf(estado) );
        ps2.setInt(5, idperfil);
        ps2.setBoolean(6, true);
        ps2.setInt(7, 0);
        
        ps2.execute();
        
        return true;
        }
        catch(SQLException | ClassNotFoundException ex){}
        
        
        return false;
    }

    /**
     * Web service operation
         * @return 
     */
    @WebMethod(operationName = "SelectMaxIdPerfil")
    public int SelectMaxIdPerfil() {
        
        int idperfil = 0;
        try{
            String query = "{call SelectMaxIdPerfil(?)}";
            CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
            
            
           ps.setInt(1, idperfil);
           ps.registerOutParameter(1, Types.INTEGER);
           ps.execute();
           
           return ps.getInt(1);
        
        }
        
        catch(SQLException | ClassNotFoundException ex){
        
        }
        
        
        
        return 0;
    }
    
    /**
     * Web service operation
         * @param rut
         * @param ofertaid
         * @return 
     */
    @WebMethod(operationName = "crearVisualizacionOferta")
    public boolean crearVisualizacionOferta(@WebParam(name = "rut") String rut, @WebParam(name = "ofertaid") int ofertaid) {
       
       try{
        String query = "{call REGISTRARVISUALIZACIONOFERTA(?,?)}";
        CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
        
      
        ps.setString(1, rut);
         ps.setInt(2, ofertaid);
    
        ps.executeQuery();
        
        return true;
          }
          
          catch(SQLException | ClassNotFoundException ex){}
        
        return false;
        
        
    }

    

    /**
     * Web service operation
         * @return 
         * @throws java.io.IOException
     */
    @WebMethod(operationName = "traerCategorias")
    public ArrayList<Categoria> traerCategorias() throws IOException {
        
       
        
        ArrayList<Categoria> listado = new ArrayList();
          Categoria categoria;
        try{
            
            String query = "{call listarMenuCategoriaProductos(?)}";
            CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
            
            
            ps.registerOutParameter(1, OracleTypes.CURSOR);
            
            
              ps.executeUpdate();
              
              ResultSet rs = (ResultSet) ps.getObject(1);
            
            while(rs.next()){
                
              categoria = new Categoria();
              categoria.setIdcategoria(rs.getInt(1));
              categoria.setNombrecategoria(rs.getString(2));
              
              listado.add(categoria);
            
            }
            rs.close();
        
        }
        
        catch(SQLException | ClassNotFoundException ex){}
        
        return listado;
    }
    
     @WebMethod(operationName = "traerTiendas")
    public ArrayList<Tienda> traerTiendas() throws IOException {

        
        ArrayList<Tienda> listado = new ArrayList();
        
        
        try{
            
            String query = "{call listarMenuTiendaProductos(?)}";
            CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);

            
            ps.registerOutParameter(1, OracleTypes.CURSOR);
            
           ps.executeQuery();
           
           ResultSet rs = (ResultSet) ps.getObject(1);
            
            while(rs.next()){
          
         Tienda tienda = new Tienda();
                tienda.setIdtienda(rs.getInt(1));
                tienda.setNombretienda(rs.getString(2));
                
                listado.add(tienda);
            }
            rs.close();
        }
        
        catch(SQLException | ClassNotFoundException ex){
        
        
        }
        
        
        return listado;
        
    }

    /**
     * Web service operation
         * @param idcategoria
         * @return 
         * @throws java.io.IOException
     */
    @WebMethod(operationName = "traerOfertasxCategoria")
    public ArrayList<Oferta> traerOfertasxCategoria(@WebParam(name = "idcategoria") int idcategoria) throws IOException {
       
        ArrayList<Oferta> listado = new ArrayList();
        try{
        
            String query = "{call traerOfertasxCategoria(?,?)}";
           CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
           
           ps.setInt(1, idcategoria);
            ps.registerOutParameter(2, OracleTypes.CURSOR);
            
            ps.executeQuery();
            
            try (ResultSet rs = (ResultSet) ps.getObject(2)) {
                while(rs.next()){
                    Oferta o = new Oferta();
                      Sucursal s = new Sucursal();
                      Categoria c = new Categoria();
                      Tienda t = new Tienda();
                      Producto p = new Producto();
                     
                    int idoferta = rs.getInt(1);                  
                    o.setIdoferta(idoferta);                   
                    t.setNombretienda(rs.getString(2));
                    o.setTienda(t);       
                    s.setCiudad(rs.getString(3));          
                   String cadenadireccion = rs.getString(4);
                   String [] arreglo = cadenadireccion.split(",");               
                   s.setDireccion(arreglo);
                   p.setCodigobarra(rs.getInt(5));
                   p.setMarca(rs.getString(6));
                   p.setNombreproducto(rs.getString(7));
                   p.setPrecioProducto(rs.getInt(8));                
                    // no agregar stock
                    p.setRutaimagen(rs.getString(10));             
                    o.setFechaInicio(rs.getString(11));
                    o.setFechaTermino(rs.getString(12));
                    p.setFechaExpiracion(rs.getString(13));
                    o.setPrecioOferta(rs.getInt(14));
                    o.setCantidadOfertaProducto(rs.getInt(15));
                   s.setIdsucursal(rs.getInt(16));
                   c.setIdcategoria(rs.getInt(17));
                    o.setCategoria(c);
                    o.setSucursal(s);
                      o.setProducto(p);
                    listado.add(o);
                }
            }
        }
        
        catch(SQLException | ClassNotFoundException ex){}
        
        return listado;
        
    }
    
    
    /**
     * Web service operation
         * @param idtienda
         * @return 
         * @throws java.io.IOException
     */
    @WebMethod(operationName = "traerOfertasxTienda")
    public ArrayList<Oferta> traerOfertasxTienda(@WebParam(name = "idtienda") int idtienda) throws IOException {
            
            
             ArrayList<Oferta> listado = new ArrayList();
        try{
        
            String query = "{call traerOfertasxTienda(?,?)}";
           CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
           
           ps.setInt(1, idtienda);
            ps.registerOutParameter(2, OracleTypes.CURSOR);
            
            ps.executeQuery();
            
            try (ResultSet rs = (ResultSet) ps.getObject(2)) {
                while(rs.next()){
                 Oferta o = new Oferta();
                      Sucursal s = new Sucursal();
                      Categoria c = new Categoria();
                      Tienda t = new Tienda();
                      Producto p = new Producto();
                      
                    int idoferta = rs.getInt(1);                  
                    o.setIdoferta(idoferta);                   
                    t.setNombretienda(rs.getString(2));
                    o.setTienda(t);       
                    s.setCiudad(rs.getString(3));          
                   String cadenadireccion = rs.getString(4);
                   String [] arreglo = cadenadireccion.split(",");               
                   s.setDireccion(arreglo);
                   p.setCodigobarra(rs.getInt(5));
                   p.setMarca(rs.getString(6));
                   p.setNombreproducto(rs.getString(7));
                   p.setPrecioProducto(rs.getInt(8));                
                    // no agregar stock
                    p.setRutaimagen(rs.getString(10));             
                    o.setFechaInicio(rs.getString(11));
                    o.setFechaTermino(rs.getString(12));
                    p.setFechaExpiracion(rs.getString(13));
                    o.setPrecioOferta(rs.getInt(14));
                    o.setCantidadOfertaProducto(rs.getInt(15));
                   s.setIdsucursal(rs.getInt(16));
                   c.setIdcategoria(rs.getInt(17));
                    o.setCategoria(c);
                    o.setSucursal(s);
                      o.setProducto(p);
                    listado.add(o);
                }
            }
        }
        
        catch(SQLException | ClassNotFoundException ex){}
        
        return listado;
            
            
    }
    

    /**
     * Web service operation
         * @return 
         * @throws java.io.IOException
     */
    @WebMethod(operationName = "traerRubro")
    public ArrayList<Descuento> traerRubro() throws IOException {
         
        ArrayList<Descuento> listado = new ArrayList();
        
        try{
            
             String query = "{call listarMenuRubro(?)}";
          CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
        
          ps.registerOutParameter(1, OracleTypes.CURSOR);
          
          ps.executeQuery();
          
          ResultSet rs = (ResultSet) ps.getObject(1);
          
          while(rs.next()){
          
              Descuento r = new Descuento();
              r.setIdrubro(rs.getInt(1));
              r.setNombrerubro(rs.getString(2));
              
              listado.add(r);
          
          }
          rs.close();
          
        }
        catch(SQLException | ClassNotFoundException ex){}
        
        
        return listado;
    }

    /**
     * Web service operation
         * @param idrubro
         * @return 
         * @throws java.io.IOException
     */
    @WebMethod(operationName = "traerDetalleRubro")
    public ArrayList<Descuento> traerDetalleRubro(@WebParam(name = "idrubro") int idrubro) throws IOException {
       ArrayList<Descuento> rubros = new ArrayList();
       Descuento r = new Descuento();
        try{
        
            String query = "{call traerInformacionRubro(?,?,?,?)}";         
            CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
            
            ps.setInt(1, idrubro);
            ps.registerOutParameter(2, Types.INTEGER);
            ps.registerOutParameter(3, Types.INTEGER);
            ps.registerOutParameter(4, Types.INTEGER);
            
            ps.execute();
            
            r.setTope(ps.getInt(2));
            r.setDescuento(ps.getInt(3));
            r.setPuntos(ps.getInt(4));
            
            rubros.add(r);
        }
        
        catch(SQLException | ClassNotFoundException ex){}
        
        
        return rubros;
    }

    /**
     * Web service operation
         * @param rutconsumidor
         * @return 
         * @throws java.io.IOException 
     */
    @WebMethod(operationName = "traerConsumidor")
    public ArrayList<Consumidor> traerConsumidor(@WebParam(name = "rutconsumidor") String rutconsumidor)throws IOException  {
       
        ArrayList<Consumidor> datos = new ArrayList();
        Consumidor c = new Consumidor();
        try{
            String query = "{call traerDatosConsumidor(?,?,?,?,?,?)}";
        CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
        
        ps.setString(1, rutconsumidor);
        ps.registerOutParameter(2, Types.VARCHAR);
        ps.registerOutParameter(3, Types.VARCHAR);
        ps.registerOutParameter(4, Types.VARCHAR);
        ps.registerOutParameter(5, Types.INTEGER);
        ps.registerOutParameter(6, Types.INTEGER);
        ps.executeQuery();
        
        c.setRutconsumidor(ps.getString(2));
        c.setNombre(ps.getString(3));
        c.setApellidop(ps.getString(4));
        c.setPuntos(ps.getInt(5));
        c.setActivocupon(ps.getInt(6));
        
        datos.add(c);
        
        }
        
        catch(SQLException | ClassNotFoundException ex){}
        
        
        return datos;
    }

    /**
     * Web service operation
         * @return 
     */
    @WebMethod(operationName = "SelectMaxIdValoracion")
    public int SelectMaxIdValoracion() {
       
       
        int idvaloracion = 0;
        try{
            String query = "{call SelectMaxIdValoracion(?)}";
            CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
            
            
           ps.setInt(1, idvaloracion);
           ps.registerOutParameter(1, Types.INTEGER);
           ps.execute();
           
           return ps.getInt(1);
        
        }
        
        catch(SQLException | ClassNotFoundException ex){
        
        }
        
        
        
        return 0;
        
        
    }

    /**
     * Web service operation
         * @param idoferta
         * @param rut
         * @return 
     */
    @WebMethod(operationName = "ComprobarValoracionAnterior")
    public boolean ComprobarValoracionAnterior(@WebParam(name = "idoferta") int idoferta, @WebParam(name = "rut") String rut) {
        boolean estado = false;
        try{
            String query = "{call ComprobarValoracionAnterior(?,?,?)}";
            
            CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
            ps.setInt(1, idoferta);
            ps.setString(2, rut);
            
            ps.registerOutParameter(3, OracleTypes.CURSOR);
  
            
            ps.executeQuery();
            
            ResultSet rs = (ResultSet) ps.getObject(3);
            
            while(rs.next()){
            
                estado = true;
               
            }
            rs.close();
       
        
        }
        
        catch(SQLException | ClassNotFoundException ex){}
        
        
        return estado;
    }

    /**
     * Web service operation
         * @param idvaloracion
         * @param tipovaloracion
         * @param idoferta
         * @param codigobarra
         * @param rut
         * @return 
     */
    @WebMethod(operationName = "registrarValoracion")
    public boolean registrarValoracion(@WebParam(name = "idvaloracion") int idvaloracion, @WebParam(name = "tipovaloracion") int tipovaloracion, @WebParam(name = "idoferta") int idoferta, @WebParam(name = "codigobarra") String codigobarra, @WebParam(name = "rut") String rut) {
       
        boolean estado = false;
        
        try{
        
            String query = "{call CrearValoracion(?,?,?,?,?)}";
            
            CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
            
            ps.setInt(1, idvaloracion);
            ps.setInt(2, tipovaloracion);
            ps.setInt(3, idoferta);
            ps.setString(4, codigobarra);
            ps.setString(5, rut);
            
            ps.executeQuery();
            
            estado = true;
            return estado;
            
        
        }
        
        
        catch(SQLException | ClassNotFoundException ex){}
        
        
        
        return estado;
    }

    /**
     * Web service operation
         * @param rut
         * @return 
     */
    @WebMethod(operationName = "sumarPuntosConsumidor")
    public boolean sumarPuntosConsumidor(@WebParam(name = "rut") String rut) {
        
        
         boolean estado = false;
        
        try{
        
            String query = "{call SumarPuntos(?)}";
            
            CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
            
            ps.setString(1, rut);
            
            ps.executeQuery();
            
            estado = true;
            return estado;
            
        
        }
        
        
        catch(SQLException | ClassNotFoundException ex){}
        
        
        
        return estado;
        
    }

    /**
     * Web service operation
         * @param idescuento
         * @param idrubro
         * @param rut
         * @return 
     */
    @WebMethod(operationName = "registroDescuento")
    public boolean registroDescuento(@WebParam(name = "idescuento") int idescuento, @WebParam(name = "idrubro") int idrubro, @WebParam(name = "rut") String rut) {
       
         boolean estado = false;
        
        try{
        
            String query = "{call registrarDescuento(?,?,?)}";
            
            CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
            
            ps.setInt(1, idescuento);
            ps.setInt(2, idrubro);
            ps.setString(3, rut);
            ps.executeQuery();
            
            estado = true;
            return estado;
            
        
        }
        
        
        catch(SQLException | ClassNotFoundException ex){}
        
        
        
        return estado;
        
        
        
    }

    /**
     * Web service operation
         * @return 
     */
    @WebMethod(operationName = "selectMaxIdDescuento")
    public int selectMaxIdDescuento() {
        
          int idescuento = 0;
        try{
            String query = "{call SelectMaxIdDescuento(?)}";
            CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
            
            
           ps.setInt(1, idescuento);
           ps.registerOutParameter(1, Types.INTEGER);
           ps.execute();
           
           return ps.getInt(1);
        
        }
        
        catch(SQLException | ClassNotFoundException ex){
        
        }
        
        
        
        return 0;
        
        
    }

    /**
     * Web service operation
         * @param puntos
         * @param rut
         * @return 
     */
    @WebMethod(operationName = "restarPuntos")
    public boolean restarPuntos(@WebParam(name = "puntos") int puntos, @WebParam(name = "rut") String rut) {
      
         boolean estado = false;
        
        try{
        
            String query = "{call descontarPuntos(?,?)}";
            
            CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
            
            ps.setInt(1, puntos);
            ps.setString(2, rut);
            
            ps.executeQuery();
            
            estado = true;
            return estado;
            
        
        }
        
        
        catch(SQLException | ClassNotFoundException ex){}
        
        
        
        return estado;
        
        
    }
    
    
    @WebMethod(operationName = "DeshabilitarDescargaCupon")
    public boolean DeshabilitarDescargaCupon(@WebParam(name = "rut") String rut) {
      
         boolean estado = false;
        
        try{
        
            String query = "{call cambiarEstadoCupon(?)}";
            
            CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
            
            ps.setString(1, rut);
            
            ps.executeQuery();
            
            estado = true;
            return estado;
            
        
        }
        
        
        catch(SQLException | ClassNotFoundException ex){}
        
        
        
        return estado;
        
        
    }
    
    
    
    
    

    /**
     * Web service operation
         * @param idcategoria
         * @return 
         * @throws java.io.IOException 
     */
    @WebMethod(operationName = "TraerOfertasxPreferencia")
    public ArrayList<Oferta> TraerOfertasxPreferencia(@WebParam(name = "idcategoria") int idcategoria) throws IOException {
       
        
       ArrayList<Oferta> listado = new ArrayList();
        try{
        
            String query = "{call traerOfertasxPreferencia(?,?)}";
           CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
           
           ps.setInt(1, idcategoria);
            ps.registerOutParameter(2, OracleTypes.CURSOR);
            
            ps.executeQuery();
            
            try (ResultSet rs = (ResultSet) ps.getObject(2)) {
                while(rs.next()){
                     Oferta o = new Oferta();
                      Sucursal s = new Sucursal();
                      Categoria c = new Categoria();
                      Tienda t = new Tienda();
                      Producto p = new Producto();
                      
                    int idoferta = rs.getInt(1);                  
                    o.setIdoferta(idoferta);                   
                    t.setNombretienda(rs.getString(2));
                    o.setTienda(t);       
                    s.setCiudad(rs.getString(3));          
                   String cadenadireccion = rs.getString(4);
                   String [] arreglo = cadenadireccion.split(",");               
                   s.setDireccion(arreglo);
                   p.setCodigobarra(rs.getInt(5));
                   p.setMarca(rs.getString(6));
                   p.setNombreproducto(rs.getString(7));
                   p.setPrecioProducto(rs.getInt(8));                
                    // no agregar stock
                    p.setRutaimagen(rs.getString(10));             
                    o.setFechaInicio(rs.getString(11));
                    o.setFechaTermino(rs.getString(12));
                    p.setFechaExpiracion(rs.getString(13));
                    o.setPrecioOferta(rs.getInt(14));
                    o.setCantidadOfertaProducto(rs.getInt(15));
                   s.setIdsucursal(rs.getInt(16));
                   c.setIdcategoria(rs.getInt(17));
                    o.setCategoria(c);
                    o.setSucursal(s);
                      o.setProducto(p);
                    listado.add(o);
                }
            }
        }
        
        catch(SQLException | ClassNotFoundException ex){}
        
        return listado;  
        
        
    }

    /**
     * Web service operation
         * @param rut
         * @return 
         * @throws java.io.IOException
     */
    @WebMethod(operationName = "traerInformacionConsumidor")
    public ArrayList<Consumidor> traerInformacionConsumidor(@WebParam(name = "rut") String rut) throws IOException  {
        
        Consumidor c = new Consumidor();
        Categoria cat = new Categoria();
        Tienda t = new Tienda();
        ArrayList<Consumidor> listado = new ArrayList();
        try{
        
            String query = "{call traerInformacionConsumidor(?,?)}";
           CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
           
           ps.setString(1, rut);
            ps.registerOutParameter(2, OracleTypes.CURSOR);
            
            ps.executeQuery();
            
            try (ResultSet rs = (ResultSet) ps.getObject(2)) {
                while(rs.next()){
                
              cat.setNombrecategoria(rs.getString("nombrecategoria"));
              t.setNombretienda(rs.getString("nombretienda"));     
              cat.setIdcategoria(rs.getInt("idcategoria"));

              
              c.setCategoria(cat);
              c.setTienda(t);
                }
                listado.add(c);
            }
        }
        
        catch(SQLException | ClassNotFoundException ex){}
        
        return listado;  
        
            
        
    }

        /**
         * Web service operation
         * @return 
         * @throws java.io.IOException 
         */
        @WebMethod(operationName = "traerTodasOfertas")
        public ArrayList<Oferta> traerTodasOfertas() throws IOException {
              
                
        ArrayList<Oferta> listado = new ArrayList();
        try{
        
            String query = "{call traerTodasOfertas(?)}";
           CallableStatement ps = Conexion.getInstancia().getConnection().prepareCall(query);
           

            ps.registerOutParameter(1, OracleTypes.CURSOR);
            
            ps.executeQuery();
            
            try (ResultSet rs = (ResultSet) ps.getObject(1)) {
                while(rs.next()){
                    Oferta o = new Oferta();
                      Sucursal s = new Sucursal();
                      Categoria c = new Categoria();
                      Tienda t = new Tienda();
                      Producto p = new Producto();
                      
                    int idoferta = rs.getInt(1);                  
                    o.setIdoferta(idoferta);                   
                    t.setNombretienda(rs.getString(2));
                    o.setTienda(t);       
                    s.setCiudad(rs.getString(3));          
                   String cadenadireccion = rs.getString(4);
                   String [] arreglo = cadenadireccion.split(",");               
                   s.setDireccion(arreglo);
                   p.setCodigobarra(rs.getInt(5));
                   p.setMarca(rs.getString(6));
                   p.setNombreproducto(rs.getString(7));
                   p.setPrecioProducto(rs.getInt(8));                
                    // no agregar stock
                    p.setRutaimagen(rs.getString(10));             
                    o.setFechaInicio(rs.getString(11));
                    o.setFechaTermino(rs.getString(12));
                    p.setFechaExpiracion(rs.getString(13));
                    o.setPrecioOferta(rs.getInt(14));
                    o.setCantidadOfertaProducto(rs.getInt(15));
                   s.setIdsucursal(rs.getInt(16));
                   c.setIdcategoria(rs.getInt(17));
                    o.setCategoria(c);
                    o.setSucursal(s);
                    o.setProducto(p);
                    listado.add(o);
                }
            }
        }
        
        catch(SQLException | ClassNotFoundException ex){}
        
        return listado;
                
                
        }

    
   
    
    
}
