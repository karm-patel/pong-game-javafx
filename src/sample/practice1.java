package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

public class practice1 extends Application {
    static SequentialTransition sqt[] = new SequentialTransition[20];
    static TranslateTransition tt[] = new TranslateTransition[20];
    static TranslateTransition tt2[] = new TranslateTransition[20];
    public static void RightSide(Circle c[]){
        for (int i=0;i<20;i++){
            tt[i] = new TranslateTransition();
            tt2[i] = new TranslateTransition();
            tt[i].setByX(500);
            tt[i].setByY(0);
            tt[i].setDuration(Duration.seconds(3));
            tt[i].setNode(c[i]);
            tt[i].setCycleCount(1);
            //tt[i].play();

            tt2[i].setByY(i*10);
            tt2[i].setByX(10*(19-i));
            tt2[i].setDuration(Duration.seconds(3));
            tt2[i].setNode(c[i]);
            tt2[i].setCycleCount(1);
            // tt2[i].play();
            sqt[i] = new SequentialTransition(tt[i],tt2[i]);
            sqt[i].play();
        }

    }

    public static void LeftSide(Circle c[]){
        for (int i=0;i<20;i++){
            tt[i] = new TranslateTransition();
            tt2[i] = new TranslateTransition();

            tt2[i].setByY((19-i)*10);
            tt2[i].setByX(10*(i));
            tt2[i].setDuration(Duration.seconds(3));
            tt2[i].setNode(c[i]);
            tt2[i].setCycleCount(1);


            tt[i].setByX(-500);
            tt[i].setByY(0);
            tt[i].setDuration(Duration.seconds(3));
            tt[i].setNode(c[i]);
            tt[i].setCycleCount(1);
            //tt[i].play();


            // tt2[i].play();
            sqt[i] = new SequentialTransition(tt2[i],tt[i]);
            sqt[i].play();
        }
    }
   

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Circle cir[] = new Circle[20];


        for (int i=0;i<20;i++){
            cir[i] = new Circle(10*i,20,10);
            cir[i].setFill(Color.rgb(i*10,i*10,i*10));
        }
        Button right = new Button("right");
        right.setLayoutX(100);
        right.setLayoutY(400);
        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RightSide(cir);
            }
        });

        Button left = new Button("left");
        left.setLayoutX(150);
        left.setLayoutY(400);
        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LeftSide(cir);
            }
        });


        Group root = new Group();
        root.getChildren().addAll(cir);
        root.getChildren().addAll(right,left);
        Scene scene = new Scene(root,1000,1000);
        primaryStage.setScene(scene);
        primaryStage.setTitle("basic snake");
        primaryStage.show();
    }
}
