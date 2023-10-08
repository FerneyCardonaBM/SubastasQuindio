package com.example.subastasquindio.utils;

import com.example.subastasquindio.model.Enums.TipoProducto;
import com.example.subastasquindio.model.Producto;
import com.example.subastasquindio.model.Subasta;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;




public class Persistencia {


    //SubastasQuindio/src/main/resources/persistencia/archivoClientes.txt
    public static final String RUTA_ARCHIVO_PRODUCTOS = "src/main/resources/persistencia/archivoProductos.txt";
    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/persistencia/log/SubastaLog.txt";

    public static final String RUTA_ARCHIVO_MODELO_SUBASTA_BINARIO = "src/main/resources/persistencia/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_SUBASTA_XML = "src/main/resources/persistencia/model.xml";
//	C:\td\persistencia



    public static void cargarDatosArchivos(Subasta subasta) throws FileNotFoundException, IOException {
        //cargar archivo de productos
        ArrayList<Producto> productosCargados = cargarProductos();
        if(productosCargados.size() > 0)
            subasta.getListaProductos().addAll(productosCargados);



    }

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param
     * @throws IOException
     */
    public static void guardarProductos(ArrayList<Producto> listaProductos) throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Producto producto : listaProductos)
        {
            contenido+= producto.getNombre()+","+producto.getId()+","+producto.getTipoProducto()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PRODUCTOS, contenido, false);
    }






//	----------------------LOADS------------------------

    /**
     * @param
     * @param
     * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<Producto> cargarProductos() throws FileNotFoundException, IOException
    {
        ArrayList<Producto> productos =new ArrayList<Producto>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PRODUCTOS);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Producto producto = new Producto();
            producto.setNombre(linea.split(",")[0]);
            producto.setId(linea.split(",")[1]);
            producto.setTipoProducto(TipoProducto.valueOf(linea.split(",")[2]));
            productos.add(producto);
        }
        return productos;
    }




    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }





//	----------------------SAVES------------------------

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param ruta
     * @throws IOException
     */

    public static void guardarObjetos(ArrayList<Producto> listaProductos, String ruta) throws IOException  {
        String contenido = "";

        for(Producto productoAux:listaProductos) {
            contenido+= productoAux.getNombre()+","+productoAux.getId()+","+productoAux.getTipoProducto()+"\n";
        }
        ArchivoUtil.guardarArchivo(ruta, contenido, true);
    }





    //------------------------------------SERIALIZACIÓN  y XML


    public static Subasta cargarRecursoSubastaBinario() {

        Subasta subasta = null;

        try {
            subasta = (Subasta) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTA_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subasta;
    }

    public static void guardarRecursoSubastaBinario(Subasta subasta) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTA_BINARIO, subasta);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static Subasta cargarRecursoSubastaXML() {

        Subasta subasta = null;

        try {
            subasta = (Subasta) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTA_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subasta;

    }



    public static void guardarRecursoSubastaXML(Subasta subasta) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTA_XML, subasta);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }










}

