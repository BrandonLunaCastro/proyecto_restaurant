/*package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import model.Plato;
import repository.PlatoRepository;

public class PlatoView {

    private final PlatoRepository repo = new PlatoRepository();
    private final ObservableList<Plato> datos = FXCollections.observableArrayList();
    private final VBox root = new VBox(10);

    private final TextField tfId        = new TextField();
    private final TextField tfNombre    = new TextField();
    private final TextField tfPrecio    = new TextField();
    private final TextField tfCategoria = new TextField();

    public PlatoView() {
        construirUI();
    }

    private void construirUI() {
        root.setPadding(new Insets(16));

        // --- Tabla ---
        TableView<Plato> tabla = new TableView<>(datos);

        TableColumn<Plato, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Plato, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("name"));   // ← name

        TableColumn<Plato, Double> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("price"));  // ← price

        TableColumn<Plato, String> colCategoria = new TableColumn<>("Categoría");
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("category")); // ← category

        tabla.getColumns().addAll(colId, colNombre, colPrecio, colCategoria);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setVgrow(tabla, Priority.ALWAYS);

        // --- Formulario ---
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(8);

        tfId.setPromptText("ID");
        tfNombre.setPromptText("Nombre");
        tfPrecio.setPromptText("Precio");
        tfCategoria.setPromptText("Categoría");

        form.addRow(0, new Label("ID:"), tfId, new Label("Nombre:"), tfNombre);
        form.addRow(1, new Label("Precio:"), tfPrecio, new Label("Categoría:"), tfCategoria);

        // --- Botones ---
        Button btnAgregar  = new Button("Agregar");
        Button btnEliminar = new Button("Eliminar");
        Button btnLimpiar  = new Button("Limpiar");

        btnAgregar.setOnAction(e -> agregar());
        btnEliminar.setOnAction(e -> eliminar(tabla));
        btnLimpiar.setOnAction(e -> limpiarFormulario());

        // Seleccionar fila → cargar en formulario
        tabla.getSelectionModel().selectedItemProperty().addListener((obs, old, sel) -> {
            if (sel != null) {
                tfId.setText(String.valueOf(sel.getId()));
                tfNombre.setText(sel.getName());         // ← getName()
                tfPrecio.setText(String.valueOf(sel.getPrice()));    // ← getPrice()
                tfCategoria.setText(sel.getCategory());  // ← getCategory()
            }
        });

        HBox botones = new HBox(10, btnAgregar, btnEliminar, btnLimpiar);

        root.getChildren().addAll(tabla, form, botones);
        actualizarTabla();
    }

    private void agregar() {
        try {
            int id        = Integer.parseInt(tfId.getText().trim());
            String nombre = tfNombre.getText().trim();
            double precio = Double.parseDouble(tfPrecio.getText().trim());
            String cat    = tfCategoria.getText().trim();

            if (nombre.isEmpty() || cat.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Nombre y Categoría no pueden estar vacíos").showAndWait();
                return;
            }

            repo.add(new Plato(id, nombre, precio, cat));
            actualizarTabla();
            limpiarFormulario();
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.ERROR, "ID debe ser entero y Precio debe ser numérico").showAndWait();
        }
    }

    private void eliminar(TableView<Plato> tabla) {
        Plato sel = tabla.getSelectionModel().getSelectedItem();
        if (sel != null) {
            repo.delete(sel.getId());
            actualizarTabla();
            limpiarFormulario();
        } else {
            new Alert(Alert.AlertType.WARNING, "Seleccioná un plato de la tabla para eliminar").showAndWait();
        }
    }

    private void actualizarTabla() {
        datos.setAll(repo.getPlatos());
    }

    private void limpiarFormulario() {
        tfId.clear();
        tfNombre.clear();
        tfPrecio.clear();
        tfCategoria.clear();
    }

    public VBox getRoot() {
        return root;
    }
}
 */
package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import model.Plato;
import repository.PlatoRepository;

public class PlatoView {

    private final PlatoRepository repo = new PlatoRepository();
    private final ObservableList<Plato> datos = FXCollections.observableArrayList();
    private final VBox root = new VBox(10);

    private final TextField tfId        = new TextField();
    private final TextField tfNombre    = new TextField();
    private final TextField tfPrecio    = new TextField();
    private final TextField tfCategoria = new TextField();

    public PlatoView() {
        construirUI();
    }

    private void construirUI() {
        root.setPadding(new Insets(16));

        // --- Tabla ---
        TableView<Plato> tabla = new TableView<>(datos);

        TableColumn<Plato, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Plato, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Plato, Double> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Plato, String> colCategoria = new TableColumn<>("Categoría");
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("category"));

        tabla.getColumns().addAll(colId, colNombre, colPrecio, colCategoria);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setVgrow(tabla, Priority.ALWAYS);

        // --- Formulario ---
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(8);

        tfId.setPromptText("ID");
        tfNombre.setPromptText("Nombre");
        tfPrecio.setPromptText("Precio");
        tfCategoria.setPromptText("Categoría (1-4)");  // ← aclaración

        form.addRow(0, new Label("ID:"), tfId, new Label("Nombre:"), tfNombre);
        form.addRow(1, new Label("Precio:"), tfPrecio, new Label("Categoría:"), tfCategoria);

        // --- Botones ---
        Button btnAgregar  = new Button("Agregar");
        Button btnEditar   = new Button("Editar");    // ← NUEVO
        Button btnEliminar = new Button("Eliminar");
        Button btnLimpiar  = new Button("Limpiar");

        btnAgregar.setOnAction(e -> agregar());
        btnEditar.setOnAction(e -> editar());         // ← NUEVO
        btnEliminar.setOnAction(e -> eliminar(tabla));
        btnLimpiar.setOnAction(e -> limpiarFormulario());

        // Seleccionar fila → cargar en formulario
        tabla.getSelectionModel().selectedItemProperty().addListener((obs, old, sel) -> {
            if (sel != null) {
                tfId.setText(String.valueOf(sel.getId()));
                tfNombre.setText(sel.getName());
                tfPrecio.setText(String.valueOf(sel.getPrice()));
                tfCategoria.setText(sel.getCategory());
            }
        });

        HBox botones = new HBox(10, btnAgregar, btnEditar, btnEliminar, btnLimpiar);

        root.getChildren().addAll(tabla, form, botones);
        actualizarTabla();
    }

    // --- Agregar ---
    private void agregar() {
        try {
            String nombre = tfNombre.getText().trim();
            double precio = Double.parseDouble(tfPrecio.getText().trim());
            String cat    = tfCategoria.getText().trim();

            if (nombre.isEmpty() || cat.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Nombre y Categoría no pueden estar vacíos").showAndWait();
                return;
            }

            repo.add(new Plato(0, nombre, precio, cat)); // ← id 0 porque MySQL lo genera solo
            actualizarTabla();
            limpiarFormulario();

        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.ERROR, "Precio debe ser numérico").showAndWait();
        }
    }

    // --- Editar ---
    private void editar() {
        try {
            int id        = Integer.parseInt(tfId.getText().trim());
            String nombre = tfNombre.getText().trim();
            double precio = Double.parseDouble(tfPrecio.getText().trim());
            String cat    = tfCategoria.getText().trim();

            if (nombre.isEmpty() || cat.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Nombre y Categoría no pueden estar vacíos").showAndWait();
                return;
            }

            repo.update(new Plato(id, nombre, precio, cat));
            actualizarTabla();
            limpiarFormulario();

        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.ERROR, "ID debe ser entero y Precio debe ser numérico").showAndWait();
        }
    }

    // --- Eliminar ---
    private void eliminar(TableView<Plato> tabla) {
        Plato sel = tabla.getSelectionModel().getSelectedItem();
        if (sel != null) {
            repo.delete(sel.getId());
            actualizarTabla();
            limpiarFormulario();
        } else {
            new Alert(Alert.AlertType.WARNING, "Seleccioná un plato de la tabla para eliminar").showAndWait();
        }
    }

    private void actualizarTabla() {
        datos.setAll(repo.getPlatos());
    }

    private void limpiarFormulario() {
        tfId.clear();
        tfNombre.clear();
        tfPrecio.clear();
        tfCategoria.clear();
    }

    public VBox getRoot() {
        return root;
    }
}