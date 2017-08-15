package br.com.megalaser.hinelabel.ui;

import br.com.megalaser.hinelabel.printerconfig.PrinterConfigArgox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

/**
 * Created by RODRIGO.CASTRO on 07/08/2017.
 * Class Principal
 */
public class HineLabelForm extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Etiquetas Hine");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(5, 5, 5, 5));

        Scene scene = new Scene(grid, 300, 170);
        primaryStage.setScene(scene);

        Label purchaseOrder = new Label("Pedido de Venda");
        grid.add(purchaseOrder, 0, 1);

        TextField purchaseOrderField = new TextField();
        grid.add(purchaseOrderField, 1, 1);

        Label itemCode = new Label("Código do Item");
        grid.add(itemCode, 0, 2);

        TextField itemCodeField = new TextField();
        grid.add(itemCodeField, 1, 2);

        Label date = new Label("Data");
        grid.add(date, 0, 3);

        DatePicker dateField = new DatePicker();
        grid.add(dateField, 1, 3);
        dateField.setValue(LocalDate.now());

        Label quantity = new Label("Qtd. de Impressões");
        grid.add(quantity, 0, 4);

        TextField quantityField = new TextField();
        grid.add(quantityField, 1, 4);

        Button print = new Button("Imprimir");
        HBox hbuton = new HBox(10);
        hbuton.setAlignment(Pos.BOTTOM_RIGHT);
        hbuton.getChildren().add(print);
        grid.add(hbuton, 1, 5);

        String printerPath;
        Properties prop = getProperties();
        printerPath = prop.getProperty("prop.printer.path");

        print.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if ((purchaseOrderField.getText().isEmpty()) || (itemCodeField.getText().isEmpty()) ||
                        (quantityField.getText().isEmpty())) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("Alerta, verifique se exite um campo em branco");
                    alert.showAndWait();
                } else {
                    PrinterConfigArgox printerConfigArgox = new PrinterConfigArgox();

                    printerConfigArgox.setPurchaseOrderMegalaser(purchaseOrderField.getText());
                    printerConfigArgox.setQuantityLabelPrint(Integer.parseInt(quantityField.getText()));
                    printerConfigArgox.setItemCode(itemCodeField.getText());
                    printerConfigArgox.setDate(converter(dateField.getValue()));

                    try {
                        FileOutputStream file = new FileOutputStream(printerPath);
                        PrintWriter out = new PrintWriter(file);
                        out.println(printerConfigArgox.toString());
                        out.close();
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        primaryStage.show();
    }

    /**
     *
     * @param date
     * @return date formatted in Brazilian location "dd/MM/yyyy"
     */
    private static String converter(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(dateTimeFormatter);
    }

    /**
     * Return printer path
     * @return props
     */
    private static Properties getProperties() {
        Properties props = new Properties();
        try {
            FileInputStream file = new FileInputStream("./properties/printer.properties");
            props.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
}
