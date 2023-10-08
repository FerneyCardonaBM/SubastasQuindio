package com.example.subastasquindio.controller;

import com.example.subastasquindio.controller.services.IModelFactoryService;
import com.example.subastasquindio.exceptions.ProductoException;
import com.example.subastasquindio.mapping.dto.ProductoDto;
import com.example.subastasquindio.mapping.mappers.SubastaMapper;
import com.example.subastasquindio.model.Producto;
import com.example.subastasquindio.model.Subasta;
import com.example.subastasquindio.utils.Persistencia;
import com.example.subastasquindio.utils.SubastaUtils;

import java.io.IOException;
import java.util.List;

public class ModelFactoryController implements IModelFactoryService {
    Subasta subasta = new Subasta();



      SubastaMapper mapper = SubastaMapper.INSTANCE.INSTANCE;
    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        //1. inicializar datos y luego guardarlo en archivos
        System.out.println("invocación clase singleton");
      //  cargarDatosBase();
       // salvarDatosPrueba();

        //2. Cargar los datos de los archivos
       // cargarDatosDesdeArchivos();

        //3. Guardar y Cargar el recurso serializable binario
      //  cargarResourceBinario();
      //  guardarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML
      //  guardarResourceXML();
        cargarResourceXML();

        //Siempre se debe verificar si la raiz del recurso es null

        if(subasta == null){
            cargarDatosBase();
            guardarResourceXML();
        }
        registrarAccionesSistema("Inicio de sesión", 1, "inicioSesión");
    }

    private void cargarDatosDesdeArchivos() {
        subasta = new Subasta();
        try {
            Persistencia.cargarDatosArchivos(subasta);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void salvarDatosPrueba() {
        try {
            Persistencia.guardarProductos(getSubasta().getListaProductos());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarDatosBase() {
        subasta = SubastaUtils.inicializarDatos();
    }
    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta banco) {
        this.subasta = subasta;
    }

    @Override
    public List<ProductoDto> obtenerProductos() {
        return  mapper.getListProductosDto1(subasta.getListaProductos());
    }

    @Override
    public boolean agregarProducto(ProductoDto productoDto) {
        try {
            if (!subasta.verificarProductoExistente(productoDto.id())) {
                Producto producto = mapper.productoDtoToProducto1(productoDto);
                getSubasta().agregarProducto(producto);
                guardarResourceXML();
                guardarResourceBinario();
                guardarProductosTxt();

            }
            return  true;
        } catch (ProductoException e) {
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarProducto(String id) {
        boolean flagExiste = false;
        try {
            flagExiste = getSubasta().eliminarProducto(id);
            guardarResourceXML();
            guardarResourceBinario();
            guardarProductosTxt();
        } catch (ProductoException e) {

            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarProducto(String idActual, ProductoDto productoDto) {
        try {
            Producto producto = mapper.productoDtoToProducto1(productoDto);
            getSubasta().actualizarProducto(idActual, producto);
            guardarResourceXML();
            guardarResourceBinario();
            guardarProductosTxt();
            return true;

        } catch (ProductoException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void cargarResourceXML() {
        subasta = Persistencia.cargarRecursoSubastaXML();
    }

    private void guardarResourceXML() {
        Persistencia.guardarRecursoSubastaXML(subasta);
    }

    private void guardarProductosTxt() {
        try {
            Persistencia.guardarProductos(subasta.getListaProductos());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarResourceBinario() {
        subasta = Persistencia.cargarRecursoSubastaBinario();
    }

    private void guardarResourceBinario() {
        Persistencia.guardarRecursoSubastaBinario(subasta);
    }

    public void registrarAccionesSistema(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }
}
