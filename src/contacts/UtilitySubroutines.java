package contacts;

import javafx.stage.Stage;

public class UtilitySubroutines {
    public static void closeProgram(Stage window){
        boolean res = ConfirmBox.response("Are you sure you want to close?");
        if(res){
            window.close();
        }
    }
}
