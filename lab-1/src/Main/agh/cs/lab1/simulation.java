package agh.cs.lab1;

import com.sun.jdi.LongValue;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import java.lang.Object;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.rmi.server.ExportException;

public class simulation extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    double width = 250;
    double height = 250;
    double maxheight = 400;
    double maxwidth = 600;


    @Override
    public void start(Stage primaryStage) throws IOException, ParseException {

            Pane root = (Pane) FXMLLoader.load(simulation.class.getResource("simulation_view.fxml"));

            Pane rootwindow = (Pane) root.lookup("#rootnode");

            StackPane root1 = (StackPane) root.lookup("#simulation1window");
            StackPane root2 = (StackPane) root.lookup("#simulation2window");
            Pane animalStatistics1 = (Pane) root.lookup("#staticStatistic1");


            String family = "Helvetica";
            double size = 8;

            TextFlow textFlow = new TextFlow();
            textFlow.setLayoutX(4);
            textFlow.setLayoutY(4);
            Text text1 = new Text("Most popular Gene: \n\n");
            text1.setFont(Font.font(family, FontPosture.ITALIC, size));
            Text text2 = new Text("Animals ammount: \n\n");
            text2.setFont(Font.font(family, FontPosture.ITALIC, size));
            Text text3 = new Text(" Grass ammount: \n\n");

            text3.setFont(Font.font(family, FontPosture.ITALIC, size));
            textFlow.getChildren().addAll(text1, text2, text3);

            Group group = new Group(textFlow);

            animalStatistics1.getChildren().add(group);

            propertiesLoader properties = new propertiesLoader();

            IWorldMap map = new GrassField(properties.getWidth(), properties.getHeight(), properties.getStartEnergy(), properties.getMoveEnergy(), properties.getPlantEnergy(), properties.getJungleRatio(), properties.getStartAnimals());
            SimulationEngine engine = new SimulationEngine(map, properties.getStartAnimals());

            IWorldMap map2 = new GrassField(properties.getWidth(), properties.getHeight(), properties.getStartEnergy(), properties.getMoveEnergy(), properties.getPlantEnergy(), properties.getJungleRatio(), properties.getStartAnimals());
            SimulationEngine engine2 = new SimulationEngine(map2, properties.getStartAnimals());

            Grid grid = new Grid(properties.getWidth(), properties.getHeight(), width, height, map, properties.getJungleRatio());

            Grid grid2 = new Grid(properties.getWidth(), properties.getHeight(), width, height, map2, properties.getJungleRatio());

//            grid.nextday();

            root1.getChildren().addAll(grid);

            root2.getChildren().addAll(grid2);


            Scene scene = new Scene(rootwindow, maxwidth, maxheight);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);

            primaryStage.show();

//        (new Thread(loop)).start();

    }

}





