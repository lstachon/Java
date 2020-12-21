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

            Pane rootWindow = (Pane) root.lookup("#rootnode");

            StackPane firstMapPane = (StackPane) root.lookup("#simulation1window");
            StackPane secondMapPane = (StackPane) root.lookup("#simulation2window");
            Pane animalStatistics1 = (Pane) root.lookup("#staticStatistic1");
            Pane animalStatistics2 = (Pane) root.lookup("#staticStatistic2");
            Pane animal1Statistic = (Pane) root.lookup("#animal1Statistic");
            Pane animal2Statistic = (Pane) root.lookup("#animal2Statistic");
            Pane firstMapToFile = (Pane) root.lookup("#firstMapToFile");
            Pane secondMapToFile = (Pane) root.lookup("#secondMapToFile");
            Pane showGenoms1 = (Pane) root.lookup("#showGenoms1");
            Pane showGenoms2 = (Pane) root.lookup("#showGenoms2");

            Text animalsinformation = new Text();
            animalsinformation.setX(2);
            animalsinformation.setY(12);
            animalStatistics1.getChildren().addAll(animalsinformation);

            Text animialsinformation2 = new Text();
            animialsinformation2.setX(2);
            animialsinformation2.setY(12);
            animalStatistics2.getChildren().addAll(animialsinformation2);

            Text animalfollowmap1 = new Text();
            animalfollowmap1.setX(2);
            animalfollowmap1.setY(12);
            animal1Statistic.getChildren().addAll(animalfollowmap1);

            Text animalfollowmap2 = new Text();
            animalfollowmap2.setX(2);
            animalfollowmap2.setY(12);
            animal2Statistic.getChildren().addAll(animalfollowmap2);

            propertiesLoader properties = new propertiesLoader();

            IWorldMap map = new GrassField(properties.getWidth(), properties.getHeight(), properties.getStartEnergy(), properties.getMoveEnergy(), properties.getPlantEnergy(), properties.getJungleRatio(), properties.getStartAnimals());
            SimulationEngine engine = new SimulationEngine(map, properties.getStartAnimals());

            IWorldMap map2 = new GrassField(properties.getWidth(), properties.getHeight(), properties.getStartEnergy(), properties.getMoveEnergy(), properties.getPlantEnergy(), properties.getJungleRatio(), properties.getStartAnimals());
            SimulationEngine engine2 = new SimulationEngine(map2, properties.getStartAnimals());

            Grid grid2 = new Grid(properties.getWidth(), properties.getHeight(), width, height, map2, properties.getJungleRatio());

            Grid grid = new Grid(properties.getWidth(), properties.getHeight(), width, height, map, properties.getJungleRatio());

            startstopSimulationButton startStop = new startstopSimulationButton(map);
            Pane startStopButton1 = (Pane) root.lookup("#firstSimulationButton");
            startStop.addEventHandler(startStopButton1);

            startstopSimulationButton startStop2 = new startstopSimulationButton(map2);
            Pane startStopButton2 = (Pane) root.lookup("#secondSimulationButton");
            startStop2.addEventHandler(startStopButton2);

            String btn = "Helvetica";
            double sizebutton1text = 10;
            TextFlow buttons = new TextFlow();
            buttons.setLayoutX(6);
            buttons.setLayoutY(6);
            Text button1Text = new Text("Start/Stop 1");
            button1Text.setFont(Font.font(btn, FontPosture.ITALIC, sizebutton1text));
            buttons.getChildren().addAll(button1Text);
            Group b1 = new Group(buttons);
            startStopButton1.getChildren().add(b1);


            String btn2 = "Helvetica";
            TextFlow buttons2 = new TextFlow();
            buttons2.setLayoutX(6);
            buttons2.setLayoutY(6);
            Text button2Text = new Text("Start/Stop 2");
            button2Text.setFont(Font.font(btn2, FontPosture.ITALIC, sizebutton1text));
            buttons2.getChildren().addAll(button2Text);
            Group b2 = new Group(buttons2);
            startStopButton2.getChildren().add(b2);

            Text maptofile = new Text("to file 1");
            maptofile.setX(12);
            maptofile.setY(15);
            firstMapToFile.getChildren().addAll(maptofile);
            WriteButton tofile1 = new WriteButton(map);
            tofile1.makePaintable(firstMapToFile);

            Text map2tofild = new Text("to file 2");
            map2tofild.setX(12);
            map2tofild.setY(15);
            secondMapToFile.getChildren().addAll(map2tofild);
            WriteButton tofile2 = new WriteButton(map2);
            tofile2.makePaintable(secondMapToFile);


            Text genometext1 = new Text("show where\nmost \npopular\ngenome");
            genometext1.setX(2);
            genometext1.setY(15);
            showGenoms1.getChildren().addAll(genometext1);
            HoverButton showG1 = new HoverButton(map);
            showG1.addEventHandler(showGenoms1);

            Text genometext2 = new Text("show where\nmost \npopular\ngenome");
            genometext2.setX(2);
            genometext2.setY(15);
            showGenoms2.getChildren().addAll(genometext2);
            HoverButton showG2 = new HoverButton(map2);
            showG2.addEventHandler(showGenoms2);

        new Thread(()-> {
                new AnimationTimer() {
                    public void handle(long currentNanoTime) {
                        grid.nextDay();
                        animalsinformation.setText(map.mapParametersToString());
                        animalfollowmap1.setText(map.followedAnimalParameters());
                    }
                }.start();
        }).start();

        Thread.sleep(30);

        new Thread(()-> {

            new AnimationTimer() {
                public void handle(long currentNanoTime) {
                    grid2.nextDay();
                    animialsinformation2.setText(map2.mapParametersToString());
                    animalfollowmap2.setText(map2.followedAnimalParameters());
                }
            }.start();
        }).start();

        firstMapPane.getChildren().addAll(grid);
        secondMapPane.getChildren().addAll(grid2);

        Scene scene = new Scene(rootWindow, maxwidth, maxheight);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}





