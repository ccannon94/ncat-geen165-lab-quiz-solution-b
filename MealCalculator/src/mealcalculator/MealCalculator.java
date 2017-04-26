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
        TextField priceTextField = new TextField();
        dataPane.add(priceTextField, 1, 0);
        dataPane.add(new Label("Discount:"), 0, 1);
        TextField discountTextField = new TextField();
        dataPane.add(discountTextField, 1, 1);
        dataPane.add(new Label("Tip %:"), 0, 2);
        TextField tipTextField = new TextField();
        dataPane.add(tipTextField, 1, 2);
        dataPane.add(new Label("Total Bill:"), 0, 3);
        Label totalBillLabel = new Label("$0.00");
        dataPane.add(totalBillLabel, 1, 3);
        pane.setCenter(dataPane);
        
        HBox commandPane = new HBox();
        Button resetButton = new Button("Reset");
        Button submitButton = new Button("Submit");
        commandPane.getChildren().addAll(resetButton, submitButton);
        pane.setBottom(commandPane);
        
        Scene calculator = new Scene(pane, 300, 200);
        primaryStage.setScene(calculator);
        primaryStage.show();
    }

    @Override
    public void handle(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
