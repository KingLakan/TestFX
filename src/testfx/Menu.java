/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfx;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author Lakan
 */
public class Menu {

public VBox addVBox(Stage theStage){
            
    VBox vbox = new VBox();
    vbox.setPadding(new Insets(10));
    vbox.setSpacing(8);

    Text title = new Text("Data");
    title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
    vbox.getChildren().add(title);

    /*Hyperlink options[] = new Hyperlink[] {
        new Hyperlink("Sales"),
        new Hyperlink("Marketing"),
        new Hyperlink("Distribution"),
        new Hyperlink("Costs")};
    */
    Button button[] = new Button[]{
        new Button("Sales"),
        new Button("Marketing"),
        new Button("Distribution"),
        new Button("Costs"),
     };
    
    button[0].setOnAction(new EventHandler<ActionEvent>() {
        @Override 
        public void handle(ActionEvent e) {
        
               GridPane root = new GridPane();

   root.setAlignment(Pos.CENTER);
root.setHgap(10);
root.setVgap(10);
root.setPadding(new Insets(0, 10, 0, 10));
root.setGridLinesVisible(true);
  Scene  theScene = new Scene( root, 512, 512 );//add node to scene
  theStage.setScene( theScene );//add scene to staget      
            
            System.out.println("Accepted");
    }
   });


    for (int i=0; i<4; i++) {
        VBox.setMargin(button[i], new Insets(0, 0, 0, 8));
        vbox.getChildren().add(button[i]);
    }

    return vbox;
}

public Button addButton(String buttonName){
    Button addbutton = new Button(buttonName);
    addbutton.setPrefSize(100, 20);
    
    return addbutton;
}

}
