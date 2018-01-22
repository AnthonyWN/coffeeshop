package contacts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    
    public static void display(String title, String message){
    Stage window = new Stage();
    
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    Label label = new Label(message);
    Button btn = new Button("Ok");
    
    //button to close
    btn.setOnAction(e -> window.close());
    
    VBox layout = new VBox(10);
    layout.getChildren().addAll(label, btn);
    layout.setAlignment(Pos.CENTER);
    
    Scene contents = new Scene(layout, 200, 100);
    window.setScene(contents);
    window.showAndWait();
   }
   
     public static void display(String title, String message, String label1){
    Stage window = new Stage();
    
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    Label label = new Label(message);
    Label msg = new Label(label1);
    Button btn = new Button("Ok");
    
    //button to close
    btn.setOnAction(e -> window.close());
    
    VBox layout = new VBox(10);
    layout.getChildren().addAll(label, msg, btn);
    layout.setAlignment(Pos.CENTER);
    
    Scene contents = new Scene(layout, 200, 100);
    window.setScene(contents);
    window.showAndWait();
   }
}
