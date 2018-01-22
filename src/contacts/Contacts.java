/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contacts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Tony
 */
public class Contacts extends Application {
    public Stage window;
    Scene loginScene, signupScene, homeScene;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)throws Exception{
        window = primaryStage;
        window.setTitle("Torris");
        window.setOnCloseRequest(e ->{
            e.consume();
            UtilitySubroutines.closeProgram(window);
        });
        
        
        
        /*
        *These are the contents of the 
        *LoginScene
        */
        
       //creating the contents of scene
        Label label1 = new Label("Cheers");
        
        HBox top = new HBox();
        top.getChildren().add(label1);
        top.setAlignment(Pos.CENTER);
       
        //Contents of the center of the borderpane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        Label username = new Label("Username: ");
        GridPane.setConstraints(username, 0, 0);
        
        TextField usr = new TextField();
        GridPane.setConstraints(usr, 1, 0);
        
        Label password = new Label("Password: ");
        GridPane.setConstraints(password, 0, 1);
        
        TextField pass = new TextField();
        GridPane.setConstraints(pass, 1, 1);
        
        grid.getChildren().addAll(username, usr, password, pass);
        grid.setAlignment(Pos.CENTER);
        
        //Right panel
        Button login = new Button(">>>>");
        Button close = new Button("Close");
        Button signup = new Button("Signup");
        
        login.setOnAction(e -> {
            boolean res = ConfirmBox.response("Set this info??");
            if(res){
                System.out.println("Welcome to the mix "+ usr.getText());
                String success = "Welcome to the mix "+ usr.getText();
                AlertBox.display("Ok", "Logging in...", success);
                homeScene = HomePage.homeScrene();
                window.setScene(homeScene);
            }else{
                System.out.println("Try Again Please!!");
            }
        });
        
        close.setOnAction(e -> {
            UtilitySubroutines.closeProgram(window);
        });
        
        /*Chaonging Scene to signupScene*/
        signup.setOnAction(e -> window.setScene(signupScene));
        
        VBox bottom = new VBox(20);
        bottom.getChildren().addAll(login, signup, close);
        bottom.setAlignment(Pos.CENTER);
        
        //Compiling the entire layout
        
        BorderPane layout = new BorderPane();
        layout.setTop(top);
        layout.setCenter(grid);
        layout.setRight(bottom);    
                
        loginScene = new Scene(layout, 300, 200);
        loginScene.getStylesheets().add(getClass().getResource("viper.css").toExternalForm());
        
        signupScene = signupscene();
                       
        /*
        *Default Scene to be displayed on startup
        *and the Show() function
        */        
        window.setScene(loginScene);
        window.show();
    }
 
    
    private Scene signupscene(){
         /*
        *Contents of the 
        *SignupScene
        *Biodata for new users
        *Let it be a borderpane layout
        */
        
        /*
        *Top section
        */
        Label label = new Label("Cheers!! Lets Sign you up..");
        VBox top = new VBox(5);
        top.getChildren().add(label);
        top.setAlignment(Pos.CENTER);
        
        /*
        *Cetre of the layout
        *Containing user info
        */        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        /*Last name*/
        Label Lname = new Label("Last Name: ");
        GridPane.setConstraints(Lname, 0, 0);
        
        TextField lname = new TextField();
        lname.setPromptText("Doe");
        GridPane.setConstraints(lname, 1, 0);
        
        /*First name*/
        Label Fname = new Label("First Name: ");
        GridPane.setConstraints(Fname, 0, 1);
        
        TextField fname = new TextField();
        fname.setPromptText("John");
        GridPane.setConstraints(fname, 1, 1);
        
        /*Password*/
        Label passwd = new Label("Enter Password: ");
        GridPane.setConstraints(passwd, 0, 2);
        
        TextField pass = new TextField();
        pass.setPromptText("/-password-/");
        GridPane.setConstraints(pass, 1, 2);
        
        /*Age*/
        Label gender = new Label("Sex: ");
        GridPane.setConstraints(gender, 0, 3);
        
        ChoiceBox<String> sex = new ChoiceBox<>();
        sex.getItems().addAll("Male", "Female");
        sex.setValue("Female");
        GridPane.setConstraints(sex, 1, 3);
        
        grid.getChildren().addAll(Lname, lname, Fname, fname, passwd, pass, gender, sex);
        grid.setAlignment(Pos.CENTER);
        
        /*
        *Bottom of the layout, with operating buttons
        */
        Button snp = new Button("Sign Up >");
        Button back = new Button("< Back");
        
        /*Defining Buttons functionality*/
        back.setOnAction(e -> window.setScene(loginScene));
        
        snp.setOnAction(e -> {
            AlertBox.display("Ok", "User has been registered");
        });
        
        HBox btm = new HBox(20);
        btm.getChildren().addAll(back, snp);
        btm.setAlignment(Pos.CENTER);
        
        /*
        *Putting together the whole layout
        */
        BorderPane layout = new BorderPane();
        layout.setTop(top);
        layout.setCenter(grid);
        layout.setBottom(btm);
        
        /*setting the scene*/
        Scene sgnpScene = new Scene(layout);
        return sgnpScene;
    }
}
