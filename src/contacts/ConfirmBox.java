/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contacts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    static boolean answer;
    
    public static boolean response(String message){
        Stage window = new Stage();
        window.setTitle("Warning");
        
        window.initModality(Modality.APPLICATION_MODAL);
        /*
        *Contents of the ConfirmBox to prompt for a response
        */
        Label label = new Label(message);
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");
        
        yesBtn.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noBtn.setOnAction(e -> {
            answer = false;
            window.close();
        });
        
        VBox msg = new VBox();
        msg.getChildren().add(label);
        msg.setAlignment(Pos.CENTER);
        
        HBox btnlayout = new HBox(10);
        btnlayout.getChildren().addAll(yesBtn, noBtn);
        btnlayout.setAlignment(Pos.CENTER);
        
        BorderPane layout = new BorderPane();
        layout.setTop(msg);
        layout.setCenter(btnlayout);
        
        Scene scene = new Scene(layout, 200, 100);
        window.setScene(scene);
        window.showAndWait();
        
        return answer;
    }
    
    
}
