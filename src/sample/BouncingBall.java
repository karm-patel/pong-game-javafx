package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.channels.ClosedByInterruptException;

public class BouncingBall extends Application {
    static int dx=1,dy=1;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Circle ball = new Circle(30,100,20);
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (ball.getCenterX() < 20) {
                    //ball.setCenterX(ball.getCenterX() + 1);
                    dx=1;
                }
                if (ball.getCenterX() > 230) {
                    //ball.setCenterX(ball.getCenterX() - 1);
                    dx=-1;
                }
                if (ball.getCenterY() < 20) {
                    //ball.setCenterY(ball.getCenterY() + 1);
                    dy=1;
                } else if (ball.getCenterY() > 230) {
                    System.out.println("y is grater than 230");
                    //ball.setCenterY(ball.getCenterY() - 1);
                    dy=-1;
                }
                //System.out.println(dx+" "+dy);
                ball.setCenterX(ball.getCenterX()+dx);
                ball.setCenterY(ball.getCenterY()+dy);
            }
        }));
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
        tl.setRate(5);

        Pane pane = new Pane();
        pane.getChildren().add(ball);
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("TimelineDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
