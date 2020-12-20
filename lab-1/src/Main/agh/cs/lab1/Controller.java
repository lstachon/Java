package agh.cs.lab1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class Controller {

    public boolean keyIsPressed = true;

    @FXML
    public void startSimulation1(ActionEvent actionEvent) {
        if(keyIsPressed){
            keyIsPressed= false;
        }
        else{
            keyIsPressed = true;
        }
    }


}



