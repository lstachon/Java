package agh.cs.lab1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    double width = 400;
    double height = 400;
    double maxheight = 600;
    double maxwidth = 865;


    @Override
    public void start(Stage primaryStage) throws IOException, ParseException, InterruptedException {

            Pane root = (Pane) FXMLLoader.load(Main.class.getResource("simulation_view.fxml"));

            Pane rootwindow = (Pane) root.lookup("#rootnode");

            StackPane root1 = (StackPane) root.lookup("#simulation1window");
            StackPane root2 = (StackPane) root.lookup("#simulation2window");
            Pane animalStatistics1 = (Pane) root.lookup("#staticStatistic1");
            Pane animalStatistics2 = (Pane) root.lookup("#staticStatistic2");
            Pane animal1statistic = (Pane) root.lookup("#animal1statistic");
            Pane animal2statistic = (Pane) root.lookup("#animal2statistic");

            Text animalsinformation = new Text();
            animalsinformation.setX(2);
            animalsinformation.setY(12);
            animalStatistics1.getChildren().addAll(animalsinformation);

            Text animialsinformation2 = new Text();
            animialsinformation2.setX(2);
            animialsinformation2.setY(12);
            animalStatistics2.getChildren().addAll(animialsinformation2);


            propertiesLoader properties = new propertiesLoader();

            IWorldMap map = new GrassField(properties.getWidth(), properties.getHeight(), properties.getStartEnergy(), properties.getMoveEnergy(), properties.getPlantEnergy(), properties.getJungleRatio(), properties.getStartAnimals());
            SimulationEngine engine = new SimulationEngine(map, properties.getStartAnimals());

            IWorldMap map2 = new GrassField(properties.getWidth(), properties.getHeight(), properties.getStartEnergy(), properties.getMoveEnergy(), properties.getPlantEnergy(), properties.getJungleRatio(), properties.getStartAnimals());
            SimulationEngine engine2 = new SimulationEngine(map2, properties.getStartAnimals());

            Grid grid2 = new Grid(properties.getWidth(), properties.getHeight(), width, height, map2, properties.getJungleRatio());

             Grid grid = new Grid(properties.getWidth(), properties.getHeight(), width, height, map, properties.getJungleRatio());

            startstopSimulationButton ss = new startstopSimulationButton(map);
            Pane ssbutton = (Pane) root.lookup("#firstSimulationButton");
            ss.makePaintable(ssbutton);

             startstopSimulationButton ss2 = new startstopSimulationButton(map2);
            Pane ss2button = (Pane) root.lookup("#secondSimulationButton");
            ss2.makePaintable(ss2button);


            String btn = "Helvetica";
            double sizebutton1text = 10;
            TextFlow buttons = new TextFlow();
            buttons.setLayoutX(6);
            buttons.setLayoutY(6);
            Text button1Text = new Text("Start/Stop 1");
            button1Text.setFont(Font.font(btn, FontPosture.ITALIC, sizebutton1text));
            buttons.getChildren().addAll(button1Text);
            Group b1 = new Group(buttons);
            ssbutton.getChildren().add(b1);


            String btn2 = "Helvetica";
            TextFlow buttons2 = new TextFlow();
            buttons2.setLayoutX(6);
            buttons2.setLayoutY(6);
            Text button2Text = new Text("Start/Stop 2");
            button2Text.setFont(Font.font(btn2, FontPosture.ITALIC, sizebutton1text));
            buttons2.getChildren().addAll(button2Text);
            Group b2 = new Group(buttons2);
            ss2button.getChildren().add(b2);

        new Thread(()-> {
                new AnimationTimer() {
                    public void handle(long currentNanoTime) {

                        try {
                            grid.nextday();
                            animalsinformation.setText(map.mapParametersToString());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }.start();

        }).start();

        new Thread(()-> {

            new AnimationTimer() {
                public void handle(long currentNanoTime) {

                    try {
                        grid2.nextday();
                        animialsinformation2.setText(map2.mapParametersToString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

            }.start();

        }).start();


        root1.getChildren().addAll(grid);
        root2.getChildren().addAll(grid2);


            Scene scene = new Scene(rootwindow, maxwidth, maxheight);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);

            primaryStage.show();


    }


}





