package com.example.subastasquindio.viewController;

import com.example.subastasquindio.controller.ProductoControllerService;
import com.example.subastasquindio.mapping.dto.ProductoDto;
import com.example.subastasquindio.model.Enums.TipoProducto;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ProductoViewController {

    ProductoControllerService productoControllerService;
    ObservableList<ProductoDto> listaProductosDto = FXCollections.observableArrayList();
    ProductoDto productoSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private ComboBox<TipoProducto> cbTipoProducto;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableView<ProductoDto> tableProductos;

    @FXML
    private TableColumn<ProductoDto, String> tcId;

    @FXML
    private TableColumn<ProductoDto, String> tcNombre;

    @FXML
    private TableColumn<ProductoDto, TipoProducto> tcTipoProducto; // Cambio en el tipo de columna

    @FXML
    void initialize() {
        productoControllerService = new ProductoControllerService();
        intiView();
    }

    private void intiView() {
        initDataBinding();
        obtenerProductos();
        tableProductos.getItems().clear();
        tableProductos.setItems(listaProductosDto);
        listenerSelection();
        configurarComboBoxTipoProducto();
    }

    private void configurarComboBoxTipoProducto() {
        cbTipoProducto.setItems(FXCollections.observableArrayList(TipoProducto.values()));
    }

    private void initDataBinding() {
        tcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().id()));
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));

        // Configurar la columna de Tipo de Producto
        tcTipoProducto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().tipoProducto()));
        tcTipoProducto.setCellFactory(column -> {
            return new TableCell<ProductoDto, TipoProducto>() {
                @Override
                protected void updateItem(TipoProducto item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                }
            };
        });
    }

    private void obtenerProductos() {
        listaProductosDto.addAll(productoControllerService.obtenerProductos());
    }

    private void listenerSelection() {
        tableProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            mostrarInformacionProducto(productoSeleccionado);
        });
    }

    private void mostrarInformacionProducto(ProductoDto productoSeleccionado) {
        if (productoSeleccionado != null) {
            txtId.setText(productoSeleccionado.id());
            txtNombre.setText(productoSeleccionado.nombre());
            cbTipoProducto.setValue(productoSeleccionado.tipoProducto());
        }
    }

    @FXML
    void nuevoProductoAction(ActionEvent event) {
        txtId.setText("Ingrese el id");
        txtNombre.setText("Ingrese el nombre");
        cbTipoProducto.setValue(null);
    }

    @FXML
    void agregarProductoAction(ActionEvent event) {
        crearProducto();
    }

    @FXML
    void eliminarProductoAction(ActionEvent event) {
        eliminarProducto();
    }

    @FXML
    void actualizarProductoAction(ActionEvent event) {
        actualizarProducto();
    }

    private void crearProducto() {
        ProductoDto productoDto = construirProductoDto();
        if (datosValidos(productoDto)) {
            if (productoControllerService.agregarProducto(productoDto)) {
                listaProductosDto.add(productoDto);
                mostrarMensaje("Notificación Producto", "Producto creado", "El Producto se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposProducto();
              //  registrarAcciones("",);
            } else {
                mostrarMensaje("Notificación Producto", "Producto no creado", "El Producto no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Notificación Producto", "Producto no creado", "Los datos ingresados son inválidos", Alert.AlertType.ERROR);
        }
    }

    private void eliminarProducto() {
        boolean productoEliminado = false;
        if (productoSeleccionado != null) {
            if (mostrarMensajeConfirmacion("¿Estás seguro de eliminar el Producto?")) {
                productoEliminado = productoControllerService.eliminarProducto(productoSeleccionado.id());
                if (productoEliminado) {
                    listaProductosDto.remove(productoSeleccionado);
                    productoSeleccionado = null;
                    tableProductos.getSelectionModel().clearSelection();
                    limpiarCamposProducto();
                    mostrarMensaje("Notificación Producto", "Producto eliminado", "El Producto se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Notificación Producto", "Producto no eliminado", "El Producto no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Notificación Producto", "Producto no seleccionado", "Selecciona un Producto de la lista", Alert.AlertType.WARNING);
        }
    }

    private void actualizarProducto() {
        boolean productoActualizado = false;
        String idActual = productoSeleccionado.id();
        ProductoDto productoDto = construirProductoDto();
        if (productoSeleccionado != null) {
            if (datosValidos(productoDto)) {
                productoActualizado = productoControllerService.actualizarProducto(idActual, productoDto);
                if (productoActualizado) {
                    listaProductosDto.remove(productoSeleccionado);
                    listaProductosDto.add(productoDto);
                    tableProductos.refresh();
                    mostrarMensaje("Notificación Producto", "Producto actualizado", "El Producto se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposProducto();
                } else {
                    mostrarMensaje("Notificación Producto", "Producto no actualizado", "El Producto no se ha actualizado con éxito", Alert.AlertType.ERROR);
                }
            } else {
                mostrarMensaje("Notificación Producto", "Producto no creado", "Los datos ingresados son inválidos", Alert.AlertType.ERROR);
            }
        }
    }

    private ProductoDto construirProductoDto() {
        return new ProductoDto(
                txtId.getText(),
                txtNombre.getText(),
                cbTipoProducto.getValue()
        );
    }

    private void limpiarCamposProducto() {
        txtId.setText("");
        txtNombre.setText("");
        cbTipoProducto.setValue(null);
    }

    private boolean datosValidos(ProductoDto productoDto) {
        String mensaje = "";
        if (productoDto.id() == null || productoDto.id().isEmpty())
            mensaje += "El id es inválido\n";
        if (productoDto.nombre() == null || productoDto.nombre().isEmpty())
            mensaje += "El nombre es inválido\n";
        if (productoDto.tipoProducto() == null)
            mensaje += "El tipo de producto es inválido\n";
        if (mensaje.isEmpty()) {
            return true;
        } else {
            mostrarMensaje("Notificación cliente", "Datos inválidos del producto", mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        return action.isPresent() && action.get() == ButtonType.OK;
    }

   /* public void registrarAcciones(String mensaje){

        productoControllerService.registrarAcciones()

    }*/

}
