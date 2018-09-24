/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import controller.GestionListaEnMemoria;
import javafx.util.converter.IntegerStringConverter;

import model.Armak;


/**
 *
 * @author idoia
 */
public class MainWindow extends Application {

    private final TableView<Armak> table = new TableView<>();

    final HBox hb = new HBox();
    
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        
        ObservableList<Armak> data = GestionListaEnMemoria.cargarDatos();
        
        stage.setTitle("Datuen Taula");
        stage.setWidth(650);
        stage.setHeight(550);
        final Label label = new Label("Armak");
        label.setFont(new Font("Arial", 20));
        
        table.setEditable(true);
        
        TableColumn<Armak, String> nameCol = new TableColumn<>("Izena");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(
            new PropertyValueFactory<>("name"));
        nameCol.setCellFactory(TextFieldTableCell.<Armak>forTableColumn());
        nameCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Armak, String> t) -> {
            ((Armak) t.getTableView().getItems().get(
            t.getTablePosition().getRow())
            ).setName(t.getNewValue());
            });
        
        TableColumn<Armak, String> jatorriCol = new TableColumn<>("Jatorria");
        jatorriCol.setMinWidth(100);
        jatorriCol.setCellValueFactory(
            new PropertyValueFactory<>("jatorria"));
        jatorriCol.setCellFactory(TextFieldTableCell.<Armak>forTableColumn());
        jatorriCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Armak, String> t) -> {
            ((Armak) t.getTableView().getItems().get(
            t.getTablePosition().getRow())
            ).setJatorria(t.getNewValue());
            });
        
        TableColumn<Armak, String> deskribCol = new TableColumn<>("Deskribapena");
        deskribCol.setMinWidth(300);
        deskribCol.setCellValueFactory(
        new PropertyValueFactory<>("desk"));
        deskribCol.setCellFactory(TextFieldTableCell.<Armak>forTableColumn());
        deskribCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Armak, String> t) -> {
                ((Armak) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setDesk(t.getNewValue());
            });
        
        TableColumn<Armak, Integer> urteaCol = new TableColumn<>("Urtea");
        urteaCol.setMinWidth(100);
        urteaCol.setCellValueFactory(
        new PropertyValueFactory<>("urtea"));
        urteaCol.setCellFactory(TextFieldTableCell.<Armak , Integer>forTableColumn(new IntegerStringConverter()));
        urteaCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Armak, Integer> t) -> {
                ((Armak) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setUrtea(t.getNewValue());
            });
        
        
        table.setItems(data);
        table.getColumns().addAll(nameCol, jatorriCol, deskribCol, urteaCol);
        final TextField addName = new TextField();
        addName.setPromptText("name");
        addName.setMaxWidth(nameCol.getPrefWidth());
        final TextField addJatorri = new TextField();
        addJatorri.setMaxWidth(jatorriCol.getPrefWidth());
        addJatorri.setPromptText("jatorria");
        final TextField adddesk = new TextField();
        adddesk.setMaxWidth(deskribCol.getPrefWidth());
        adddesk.setPromptText("desk");
        final TextField addurtea = new TextField();
        addurtea.setMaxWidth(deskribCol.getPrefWidth());
        addurtea.setPromptText("urtea");
       
        final Button addButton = new Button("Gehitu");        
        addButton.setOnAction((ActionEvent e) -> {
            Armak p = new Armak(
                addName.getText(),
                addJatorri.getText(),
                adddesk.getText(),
                Integer.parseInt(addurtea.getText()));
            data.add(p);
            
            addName.clear();
            addJatorri.clear();
            adddesk.clear();
            adddesk.clear();
            addurtea.clear();
        });
        
        final Button removeButton = new Button("Ezabatu");        
        removeButton.setOnAction((ActionEvent e) -> {
            Armak person = table.getSelectionModel().getSelectedItem();    
            data.remove(person);
        });
        
        hb.getChildren().addAll(addName, addJatorri, adddesk, addurtea, addButton, removeButton);
        hb.setSpacing(3);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
