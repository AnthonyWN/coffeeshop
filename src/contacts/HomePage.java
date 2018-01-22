/*
 * 
 *This class contains the scenes and methods of 
 *the contents of the working area
 */

package contacts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import products.*;

public class HomePage {
    
    
    public static Scene homeScrene(){
        /****Declarations****/
        Stage window;
        TreeView <String> tree;
        TableView<Coffee> table;
        MenuBar menuBar;
        
        
        window = new Stage();
        window.setTitle("Torris");
        
        /*
        *The menubar at th top of the application window
        */
        Menu fileMenu = new Menu("File");
        fileMenu.getItems().add(new MenuItem("New..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Database..."));
        fileMenu.getItems().add(new MenuItem("Calendar..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        MenuItem exit = new MenuItem("exit");
        fileMenu.getItems().add(exit);
        exit.setOnAction(e -> UtilitySubroutines.closeProgram(window));
        
        Menu optMenu = new Menu("_Options");
        optMenu.getItems().add(new MenuItem("Currencies..."));
        optMenu.getItems().add(new MenuItem("Mode..."));
        optMenu.getItems().add(new MenuItem("Views..."));
        
        menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,optMenu);

        /*
        *The tree views for the varoius products
        *Making a Tree on the left side of the borderpane
        *
        */
        TreeItem <String> root, drinks, foods, hot, cold;
        
        root = new TreeItem<>();
        root.setExpanded(true);
        
        /*making the branches*/
        drinks = makeBranch("drinks", root);
        hot = makeBranch("Hot", drinks);
        makeBranch("Coffee", hot);
        makeBranch("Tea", hot);
        makeBranch("Latte", hot);
        cold = makeBranch("Cold", drinks);
        makeBranch("Passion Juice", cold);
        makeBranch("Mango Juice", cold);
        makeBranch("wine", cold);
        
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        
        /*
        *Th table with product statistics
        *The center of the borderpane
        */
        TableColumn<Coffee, CoffeeTypes> descCol = new TableColumn<>("Description");
        descCol.setMinWidth(200);
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        TableColumn<Coffee, String> size = new TableColumn<>("Size");
        size.setMinWidth(150);
        size.setCellValueFactory(new PropertyValueFactory<>("size"));
        
        TableColumn<Coffee, Double> number = new TableColumn<>("Number");
        number.setMinWidth(100);
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        
        table = new TableView<>();
        table.setItems(getCoffee());
        table.getColumns().addAll(descCol, size, number);
        
        
        /*
        *Layout
        */
        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);
        layout.setLeft(tree);
        layout.setCenter(table);
        
        
        Scene home = new Scene(layout);       
        
        return home;
    }
    
    private static TreeItem <String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
    
    public static ObservableList<Coffee> getCoffee(){
        ObservableList<Coffee> coffee = FXCollections.observableArrayList();
        coffee.add(new Coffee(CoffeeTypes.BLACK, "Large", 26.0));
        coffee.add(new Coffee(CoffeeTypes.BLACK, "Medium",53.0 ));
        coffee.add(new Coffee(CoffeeTypes.WHITE, "Large", 17.0));
        coffee.add(new Coffee(CoffeeTypes.WHITE, "Medium", 7.0));
        coffee.add(new Coffee(CoffeeTypes.CAPUCHINO, "Large", 7.0));
        coffee.add(new Coffee(CoffeeTypes.CAPUCHINO, "Medium", 12.0));
        coffee.add(new Coffee(CoffeeTypes.LATTE, "Large", 32.0));
        coffee.add(new Coffee(CoffeeTypes.LATTE, "Medium", 29.0));
        return coffee;
    }
    
}
