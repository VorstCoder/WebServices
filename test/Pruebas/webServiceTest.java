package Pruebas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ModeloAdministracion.Usuario;
import ModeloPortal.Categoria;
import ModeloPortal.Consumidor;
import ModeloPortal.Oferta;
import ModeloPortal.Descuento;
import ModeloPortal.Tienda;
import Servicios.webService;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class webServiceTest {
    
    public webServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loginUsuario method, of class webService.
     */
    @Test
    public void testLoginUsuario() {
        
            System.out.println("loginUsuario");
        String usuario = "admin655";
        String clave = "admin344";       
        webService instance = new webService();
       // boolean expResult = true;
       Usuario expResult = new Usuario();
       expResult.setIdTipoUsuario(1);
     //   boolean result = instance.loginUsuario(usuario, clave);
        Usuario result = instance.loginUsuario(usuario, clave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result.getIdTipoUsuario() != expResult.getIdTipoUsuario()){
            fail("Prueba fallida");
       
        }
    }

    /**
     * Prueba del método loginConsumidor, de la clase webService.
     */
    @Test
    public void testLoginConsumidor() {
        System.out.println("loginConsumidor");
        String rut = "17435365";
        String clave = "clave1";
        webService instance = new webService();
        boolean expResult = true;
        boolean result = instance.loginConsumidor(rut, clave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Prueba fallida, no se ha podido ingresar el rut o la clave son incorrectos");
        }
    }

    /**
     * Prueba del método CrearConsumidor , de la clase webService.
     */
//    @Test
//    public void testCrearConsumidor() {
//        System.out.println("CrearConsumidor");
//        int idperfil = 4;
//        String nombre = "lupita";
//        String apellidop = "juares";
//        String apellidom = "gonzales";
//        String correo = "lupita@gmoil.cl";
//        String rut = "12999999";
//        String clave = "lupita";
//        char estado = 'n';
//        webService instance = new webService();
//        boolean expResult = true;
//        boolean result = instance.CrearConsumidor(idperfil, nombre, apellidop, apellidom, correo, rut, clave, estado);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        if(result != expResult){
//        fail("Prueba fallida");
//        }
//    }

    /**
     * Prueba del método SelectMaxIdPerfil , de la clase webService.
     */
    @Test
    public void testSelectMaxIdPerfil() {
        System.out.println("SelectMaxIdPerfil");
        webService instance = new webService();
        int expResult = 4;
        int result = instance.SelectMaxIdPerfil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult){
        fail("Prueba fallida");
        }
    }

    /**
     * Prueba del método crearVisualizacionOferta , de la clase webService.
     */
    @Test
    public void testCrearVisualizacionOferta() {
        System.out.println("crearVisualizacionOferta");
        String rut = "17435365";
        int ofertaid = 1;
        webService instance = new webService();
        boolean expResult = true;
        boolean result = instance.crearVisualizacionOferta(rut, ofertaid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Prueba fallida");
        }
    }

    /**
     * Test of traerCategoriaProducto method, of class webService.
     */
    @Test
    public void testTraerCategoriaProducto() throws Exception {
        System.out.println("traerCategoriaProducto");
        webService instance = new webService();
        ArrayList<Categoria> expResult = null;
        ArrayList<Categoria> result = instance.traerCategorias();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        if(result == expResult){
            fail("Prueba fallida");
        }
    }

    /**
     * Prueba del método traerTiendaProducto, of class webService, se compara el resultado del método, que 
     * debe ser un ArrayList con un valor nulo, en caso de ser iguales se muestra un error.
     */
    @Test
    public void testTraerTiendaProducto() throws Exception {
        System.out.println("traerTiendaProducto");
        webService instance = new webService();
        ArrayList<Tienda> expResult = null;
        ArrayList<Tienda> result = instance.traerTiendas();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        if(result == expResult){
            fail("Prueba fallida, no se encontraron datos");
        }
    }

    /**
     * Test of traerOfertasxCategoria method, of class webService, se compara el resultado del método, que 
     * debe ser un ArrayList con un valor nulo, en caso de ser iguales se muestra un error.
     */
    @Test
    public void testTraerOfertasxCategoria() throws Exception {
        System.out.println("traerOfertasxCategoria");
        int idcategoria = 0;
        webService instance = new webService();
        ArrayList<Oferta> expResult = null;
        ArrayList<Oferta> result = instance.traerOfertasxCategoria(idcategoria);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        if(result == expResult){
            fail("Prueba fallida, no se encontraron datos");
        }
    }

    /**
     * Test of traerOfertasxTienda method, of class webService, se compara el resultado del método, que 
     * debe ser un ArrayList con un valor nulo, en caso de ser iguales se muestra un error.
     */
    @Test
    public void testTraerOfertasxTienda() throws Exception {
        System.out.println("traerOfertasxTienda");
        int idtienda = 0;
        webService instance = new webService();
        ArrayList<Oferta> expResult = null;
        ArrayList<Oferta> result = instance.traerOfertasxTienda(idtienda);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        if(result == expResult){
        fail("Prueba fallida, no se encontraron datos");
        }
    }

    /**
     * Prueba del método traerRubro, de la clase webService.
     */
    @Test
    public void testTraerRubro() throws Exception {
        System.out.println("traerRubro");
        webService instance = new webService();
        ArrayList<Descuento> expResult = null;
        ArrayList<Descuento> result = instance.traerRubro();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        if(result == expResult){
        fail("Prueba fallida, no se encontraron datos");
        }
    }

    /**
     * Prueba del método traerDetalleRubro, de la clase webService,se compara el resultado del método, que 
     * debe ser un ArrayList con un valor nulo, en caso de ser iguales se muestra un error.
     */
    @Test
    public void testTraerDetalleRubro() throws Exception {
        System.out.println("traerDetalleRubro");
        int idrubro = 0;
        webService instance = new webService();
        ArrayList<Descuento> expResult = null;
        ArrayList<Descuento> result = instance.traerDetalleRubro(idrubro);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        if(result == expResult){
        fail("Prueba fallida,no se encontraron datos");
        }
    }

    /**
     * Prueba del método traerConsumidor, de la clase webService. Se comprueba que el método retorne un
     * usuario tipo Consumidor, comparando el resultado del metodo con un valor nulo
     * en caso de retornar un valor nulo se muestra un error.
     */
    @Test
    public void testTraerConsumidor() throws Exception {
        System.out.println("traerConsumidor");
        String rutconsumidor = "17435365";
        webService instance = new webService();
        ArrayList<Consumidor> expResult = null;
        ArrayList<Consumidor> result = instance.traerConsumidor(rutconsumidor);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        if(result == expResult){
            fail("Prueba fallida,el rut no se ha encontrado");
        }
    }

    /**
     * Prueba del método SelectMaxIdValoracion, de la clase webService, en este método se verifica que el valor 
     * retornado sea el ultimo id de valoración registrado y se compara con el dato escogido, 
     * en caso de ser diferentes se muestra un error.
     */
    @Test
    public void testSelectMaxIdValoracion() {
        System.out.println("SelectMaxIdValoracion");
        webService instance = new webService();
        int expResult = 2;
        int result = instance.SelectMaxIdValoracion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
        fail("Prueba fallida");
        }
    }

    /**
     * prueba del método ComprobarValoracionAnterior, de la clase webService, se comparan el resultado del método
     * con el id oferta y rut escogidos, si estos son distintos se muestra un error.
     */
    @Test
    public void testComprobarValoracionAnterior() {
        System.out.println("ComprobarValoracionAnterior");
        int idoferta = 1;
        String rut = "17435365";
        webService instance = new webService();
        boolean expResult = true;
        boolean result = instance.ComprobarValoracionAnterior(idoferta, rut);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult)
        {
            fail("Prueba fallida, no se encontraron valoraciones");
        }
    }

    /**
     * Prueba del método registrarValoracion, de la clase webService, se verifica que al registrar una valoración
     * el valor retornado sea "true" em caso contrario se mostrará un error.
     */
    @Test
    public void testRegistrarValoracion() {
        System.out.println("registrarValoracion");
        int idvaloracion = 1;
        int tipovaloracion = 3 ;
        int idoferta = 1;
        String codigobarra = "9956773";
        String rut = "17435365";
        webService instance = new webService();
        boolean expResult = true;
        boolean result = instance.registrarValoracion(idvaloracion, tipovaloracion, idoferta, codigobarra, rut);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult)
        {
            fail("Prueba fallida, no se pudo registrar la valoración");
        }
    }

    /**
     * Prueba del método SumarPuntosConsumidor, de la clase webService, se comprueba que se sumen puntos al
     * consumidor con el rut especificado.
     */
    @Test
    public void testSumarPuntosConsumidor() {
        System.out.println("SumarPuntosConsumidor");
        String rut = "17435365";
        webService instance = new webService();
        boolean expResult = true;
        boolean result = instance.sumarPuntosConsumidor(rut);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult)
        {
            fail("Prueba fallida");
        }
    }

    /**
     * Prueba del método registroDescuento, de la clase webService, se utilizan el id descuento, id rubro y rut escogidos
     * como paramentros del método y se compara el resultado con un valor boolean, en caso de ser distintos se muestra
     * un error.
     */
    @Test
    public void testRegistroDescuento() {
        System.out.println("registroDescuento");
        int idescuento = 1;
        int idrubro = 2;
        String rut = "17435365";
        webService instance = new webService();
        boolean expResult = true;
        boolean result = instance.registroDescuento(idescuento, idrubro, rut);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Prueba fallida, ocurrió un error al registrar la valoración, verifique los datos");
    }

    /**
     * Prueba del método SelectMaxIdDescuento, de la clase webService, se verifica que el método retorne el valor 
     * correpondiente al siguiente de ultimo id de descuento registrado.
     */
    @Test
    public void testSelectMaxIdDescuento() {
        System.out.println("SelectMaxIdDescuento");
        webService instance = new webService();
        int expResult = 3;
        int result = instance.selectMaxIdDescuento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
        fail("Prueba fallida");
        }
    }

    /**
     * Prueba del método RestarPuntos, de la clase webService, se utilizan los valores puntos y rut como parametros
     * del método, y se compara el resultado del método con un valor boolean, en caso de ser distintos
     * se muestra un error.
     */
    @Test
    public void testRestarPuntos() {
        System.out.println("RestarPuntos");
        int puntos = 100;
        String rut = "17435365";
        webService instance = new webService();
        boolean expResult = true;
        boolean result = instance.restarPuntos(puntos, rut);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result!= expResult){
        fail("Prueba fallida, un error ocurrió al restar puntos");
        }
    }

    /**
     * Prueba del método TraerOfertasxPreferencia, de la clase webService, se compara el resultado del método, que 
     * debe ser un ArrayList con un valor nulo, en caso de ser iguales se muestra un error.
     */
    @Test
    public void testTraerOfertasxPreferencia() throws Exception {
        System.out.println("TraerOfertasxPreferencia");
        int idcategoria = 1;
        webService instance = new webService();
        ArrayList<Oferta> expResult = null;
        ArrayList<Oferta> result = instance.TraerOfertasxPreferencia(idcategoria);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        if(result== expResult){
        fail("Prueba fallida, no se encontraron ofertas");
        }
    }

    /**
     * Prueba del método traerInformacionConsumidor, de la clase webService, se compara el resultado del método, que 
     * debe ser un ArrayList con un valor nulo, en caso de ser iguales se muestra un error.
     */
    @Test
    public void testTraerInformacionConsumidor() throws Exception {
        System.out.println("traerInformacionConsumidor");
        String rut = "17435365";
        webService instance = new webService();
        ArrayList<Consumidor> expResult = null;
        ArrayList<Consumidor> result = instance.traerInformacionConsumidor(rut);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        if(result== expResult){
        fail("Prueba fallida, no se ha encontrado el consumidor");
        }
    }

    /**
     * Prueba del método traerTodasOfertas, de la clase webService, se compara el resultado del método, que 
     * debe ser un ArrayList con un valor nulo, en caso de ser iguales se muestra un error.
     */
    @Test
    public void testTraerTodasOfertas() throws Exception {
        System.out.println("traerTodasOfertas");
        webService instance = new webService();
        ArrayList<Oferta> expResult = null;
        ArrayList<Oferta> result = instance.traerTodasOfertas();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        if(result== expResult){
        fail("Prueba fallida, no se han encontrado ofertas");
        }
    }
    
}
