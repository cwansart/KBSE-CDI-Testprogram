package de.ksw.kbse.cdi.testprogram;

import de.ksw.kbse.cdi.testprogram.factories.StudentFactory;
import de.ksw.kbse.cdi.testprogram.interfaces.Person;
import de.ksw.kbse.cdi.testprogram.model.Student;
import de.ksw.kbse.cdi.testprogram.model.Verwaltung;
import de.ksw.kbse.di.CDIC;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Christian
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        //----------------------------------------------
        // CDI
        CDIC cdic = new CDIC();
        final Verwaltung verwaltung = cdic.init(Verwaltung.class);
        final ObservableList<Person> observableList = FXCollections.observableArrayList(verwaltung.getStudentenListe());

        // TABLE
        TableView tableView = new TableView();
        TableColumn firstnameCol = new TableColumn("Vorname");
        TableColumn lastnameCol = new TableColumn("Nachname");
        TableColumn carCol = new TableColumn("Auto");
        TableColumn motherCol = new TableColumn("Mutter");
        tableView.getColumns().addAll(firstnameCol, lastnameCol, carCol, motherCol);

        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        carCol.setCellValueFactory(new PropertyValueFactory<>("auto"));
        motherCol.setCellValueFactory(new PropertyValueFactory<>("mutterStr"));
        tableView.setItems(observableList);

        //----------------------------------------------
        // ADD NEW USER
        HBox hBox = new HBox();
        hBox.setSpacing(3);
        
        final TextField firstnameTextField = new TextField();
        firstnameTextField.setPromptText("Vorname");
        firstnameTextField.setMaxWidth(firstnameTextField.getPrefWidth());
        final TextField lastnameTextField = new TextField();
        lastnameTextField.setPromptText("Nachname");
        lastnameTextField.setMaxWidth(lastnameTextField.getPrefWidth());
        Button addButton = new Button("Hinzufügen");
        addButton.setOnAction((ActionEvent event) -> {
            Student student = StudentFactory.getStudent();
            student.setVorname(firstnameTextField.getText());
            student.setNachname(lastnameTextField.getText());
            verwaltung.addStudent(student);
            observableList.add(student);
            firstnameTextField.clear();
            lastnameTextField.clear();
        });
        hBox.getChildren().addAll(firstnameTextField, lastnameTextField, addButton);
        
        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().addAll(tableView, hBox);
        
        StackPane root = new StackPane();
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 400, 250);

        primaryStage.setTitle("Verwaltung");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
