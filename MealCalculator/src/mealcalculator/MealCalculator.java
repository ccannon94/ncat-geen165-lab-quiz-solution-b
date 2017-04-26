/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealcalculator;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author CCannon
 */
public class MealCalculator extends Application implements EventHandler{

    private TextField priceTextField;
    private TextField discountTextField;
    private TextField tipTextField;
    private Label totalBillLabel;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        
        Label title = new Label("Bill Calculator");
        pane.setTop(title);
        
        GridPane dataPane = new GridPane();
        dataPane.add(new Label("Menu Price:"), 0, 0);
        priceTextField = new TextField();
        dataPane.add(priceTextField, 1, 0);
        dataPane.add(new Label("Discount:"), 0, 1);
        discountTextField = new TextField();
        dataPane.add(discountTextField, 1, 1);
        dataPane.add(new Label("Tip %:"), 0, 2);
        tipTextField = new TextField();
        dataPane.add(tipTextField, 1, 2);
        dataPane.add(new Label("Total Bill:"), 0, 3);
        totalBillLabel = new Label("$0.00");
        dataPane.add(totalBillLabel, 1, 3);
        pane.setCenter(dataPane);
        
        HBox commandPane = new HBox();
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(this);
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(this);
        commandPane.getChildren().addAll(resetButton, submitButton);
        pane.setBottom(commandPane);
        
        Scene calculator = new Scene(pane, 300, 200);
        primaryStage.setScene(calculator);
        primaryStage.show();
    }

    @Override
    public void handle(Event event) {
        Button pressed = (Button) event.getSource();
        
        if(pressed.getText().equals("Reset")){
            priceTextField.clear();
            discountTextField.clear();
            tipTextField.clear();
            totalBillLabel.setText("$0.00");
        }else{
            double totalBill = 0.0;
            
            double price = Double.parseDouble(priceTextField.getText().trim());
            double discount = Double.parseDouble(discountTextField.getText().trim());
            double tip = Double.parseDouble(tipTextField.getText().trim());
            
            totalBill = price * ((100-discount)/100) * ((100+tip)/100);
            
            totalBillLabel.setText("$"+totalBill);
        }
    }
    
}
