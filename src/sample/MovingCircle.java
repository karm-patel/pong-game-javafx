package sample;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingCircle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Circle cir = new Circle(20);
        Rectangle rct = new Rectangle(100,100,100,100);
        cir.setTranslateX(20);
        cir.setTranslateY(400);
        int pos_x=20;
        TranslateTransition tt = new TranslateTransition();
        Pane pane = new Pane();
        pane.getChildren().addAll(rct,cir);


        pane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cir.setFill(Color.RED);
                tt.setByX(0);
                tt.setByY(100000000);
                tt.setCycleCount(1);
                tt.setDuration(Duration.seconds(1000));
                tt.setNode(cir);
                tt.play();
            }
        });
        pane.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cir.setFill(Color.YELLOW);
                tt.pause();
            }
        });

        pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                rct.setFill(Color.YELLOW);
            }
        });
        //jenerel code

        Scene scene = new Scene(pane,800,800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
