package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

class NewBall extends Circle{
    int x;
    int y;
    int rad;
    int dx=1,dy=1;
    NewBall(int x,int y,int rad){
        super(x,y,rad);
        this.x = x;
        this.y = y;
        this.rad = rad;
    }
}
public class MultipleBouncingBall extends Application {
    //static int dx=1,dy=1;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        NewBall ball = new NewBall(30,60,20);
        ball.setFill(Color.hsb(Math.random(),Math.random(),Math.random(),0.5));
        Rectangle bg = new Rectangle(10,30,240,220);
        bg.setFill(Color.WHEAT);
        Pane pane = new BorderPane();
        HBox hbox = new HBox();

        Button btadd = new Button("+");
        btadd.setText("+");
        btadd.setLayoutX(0);
        Button btsub = new Button("-");
        hbox.getChildren().addAll(btadd,btsub);
        pane.getChildren().addAll(hbox,bg);
        btsub.setLayoutX(50);
        btadd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NewBall newBall = new NewBall(10+new Random().nextInt(200),30+new Random().nextInt(200),20);
                pane.getChildren().add(newBall);
                newBall.setFill(Color.hsb(Math.random(),Math.random(),0.8,0.5));
//                C/*ircle newBall = new Circle(40,50,20);
//                pane.getChildren().add(newBall);
//                */
            }
        });
        btsub.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pane.getChildren().size()>0){
                    pane.getChildren().remove(pane.getChildren().size()-1);
                }

            }
        }));
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (Node node : pane.getChildren()) {
                    if (node.getClass() == NewBall.class) {

                    NewBall tempball = (NewBall) node;
                        if (tempball.getCenterX() < 30) {
                            //ball.setCenterX(ball.getCenterX() + 1);
                            tempball.dx=1;
                        }
                        if (tempball.getCenterX() > 230) {
                            //ball.setCenterX(ball.getCenterX() - 1);
                            tempball.dx=-1;
                        }
                        if (tempball.getCenterY() < 50) {
                            //ball.setCenterY(ball.getCenterY() + 1);
                            tempball.dy=1;
                        } else if (tempball.getCenterY() > 230) {
                            System.out.println("y is grater than 230");
                            //ball.setCenterY(ball.getCenterY() - 1);
                            tempball.dy=-1;
                        }
                        //System.out.println(dx+" "+dy);
                        tempball.setCenterX(tempball.getCenterX()+tempball.dx);
                        tempball.setCenterY(tempball.getCenterY()+tempball.dy);
                }
            }
            }
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setRate(5);
        animation.play();
        pane.getChildren().add(ball);
        Scene scene = new Scene(pane, 280, 280);
        primaryStage.setTitle("TimelineDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}

