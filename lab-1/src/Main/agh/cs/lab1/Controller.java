package agh.cs.lab1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class Controller {

    private boolean keyIsPressed;

    @FXML
    public void startSimulation1(ActionEvent actionEvent){

        if(this.keyIsPressed) {
            this.keyIsPressed = false;
        }
        else {
            this.keyIsPressed = true;
        }
        System.out.println(this.keyIsPressed);

    }

    }



