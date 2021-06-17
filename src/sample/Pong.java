package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;


public class Pong extends Application {
static double x = 100,dx=2;
static double y = 300,dy=1;
static int rad = 10;
static int speed=5;
static int width=500,height=500;
static int plate_height=70,plate_width=10;
static Timeline runninggame;
static boolean game_running = false;
static boolean game_started = false;
static int score_no=0;
static boolean cpuplayer=false;
    public static void main(String[] args) {
        launch(args);
    }

    double getdy(int yc,int total_h){
        int perc = (int)(100*yc/total_h);
        System.out.println(perc+"%");
        if(perc>=0 && perc<=20){
            dy=-2.5;

        }
        else if (perc>20 && perc<=40){
            dy=-2;
        }
        else if(perc>40 && perc <=60){
            dy=1;
        }
        else if(perc>60 && perc<=80){
            dy=2;
        }
        else {
            dy=2.5;
        }
        return dy;
    }
    @Override
    public void start(Stage primaryStage) throws IOException {

        Rectangle leftplate = new Rectangle(0,150,10,70);
        leftplate.setFill(Color.WHITE);
        Rectangle rightplate = new Rectangle(width-10,150,10,70);
        rightplate.setFill(Color.WHITE);

        Circle ball = new Circle(x,y,rad,Color.YELLOW);

        Text gameover = new Text();
        gameover.setFill(Color.RED);
        gameover.setX(180);
        gameover.setY(height/2+30);
        gameover.setStyle("-fx-font-size:20px");

        Text pong = new Text("P O N G");
        pong.setFill(Color.YELLOW);
        pong.setFont(Font.font("Sawasdee", FontWeight.BOLD,70));
        pong.setY(120);
        pong.setX(100);

        Button start = new Button("START");
        start.setTextFill(Color.ORANGE);
        start.setStyle("-fx-background-color:green;");
        start.setLayoutX(width/2-80);
        start.setLayoutY(height/2+50);

        Button multiplayer = new Button("MULTIPLAYER");
        multiplayer.setTextFill(Color.WHITE);
        multiplayer.setStyle("-fx-background-color:black; -fx-border-color:white; -fx-border-width: 3; -fx-display:  inline-block; -fx-color:white;");
        multiplayer.setLayoutX(width/2-60);
        multiplayer.setLayoutY(height/2+50);

        Button singleplayer = new Button("SINGLEPLAYER");
        singleplayer.setTextFill(Color.WHITE);
        singleplayer.setStyle("-fx-background-color:black; -fx-border-color:white; -fx-border-width: 3; -fx-display:  inline-block; -fx-color:white;");
        singleplayer.setLayoutX(width/2-60);
        singleplayer.setLayoutY(height/2+110);

        Text score = new Text("0");
        score.setFill(Color.WHITE);
        score.setY(60);
        score.setX(240);
        score.setStyle("-fx-font-size:50px");

        Text final_score = new Text("YOUR SCORE:0");
        final_score.setX(140);
        final_score.setY(200);
        final_score.setStyle("-fx-font-size:25px");
        final_score.setFill(Color.GREEN);

        FileInputStream input = new FileInputStream("pong.png");
        Image img = new Image(input);
        BackgroundImage bgimg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background bg = new Background(bgimg);
        Pane pane = new Pane();
        pane.setBackground(bg);
        pane.getChildren().addAll(leftplate,rightplate,ball,score);

        Scene scene = new Scene(pane, width, height);
        FileInputStream input1 = new FileInputStream("pong1.png");
        Image img1 = new Image(input1);
        BackgroundImage bgimg1 = new BackgroundImage(img1, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));
        Background bg1 = new Background(bgimg1);
        Pane gpane = new Pane();
        gpane.setBackground(bg1);
        gpane.getChildren().addAll(gameover,final_score,singleplayer,multiplayer);
        //gpane.setStyle("-fx-background-size : cover;");
        Scene scene1 = new Scene(gpane,width,height);


        pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (dx > 0) {
                    if (cpuplayer){
                        //rightplate.setY(ball.getCenterY()+plate_width/2);
                    }
                    else {
                        rightplate.setY(event.getY());
                    }
                } else {
                        leftplate.setY(event.getY());


                }

            }
        });
        runninggame = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (game_running) {
                    game_started=true;
                    scene.setFill(Color.BLACK);
                    if (dx>0 && cpuplayer){
                        rightplate.setY(ball.getCenterY()- 0.2*plate_height*(score_no%5));}

                    if (ball.getCenterX() < rad) {
                        if (ball.getCenterY() >= leftplate.getY() && ball.getCenterY() <= leftplate.getY() + 70) {
                            speed += 0.5;
                            runninggame.setRate(speed);
                            dy = -1 * getdy((int) (plate_height + leftplate.getY() - ball.getCenterY()), plate_height);
                            System.out.println(dy);
                            dx *= -1;
                            ball.setFill(Color.hsb(Math.random(), 0.1, 0.9));
                            score_no++;
                            score.setText(Integer.toString(score_no));
                        } else {
                            System.out.println("Game Over");
                            game_running = false;
                            dx *= -1;
                        }
                    }
                    if (ball.getCenterX() > width - rad) {

                        if (ball.getCenterY() >= rightplate.getY() && ball.getCenterY() <= rightplate.getY() + 70) {
                            dx *= -1;
                            dy = -1 * getdy((int) (plate_height + rightplate.getY() - ball.getCenterY()), plate_height);
                            System.out.println(dy);
                            speed += 0.5;
                            runninggame.setRate(speed);
                            ball.setFill(Color.hsb(Math.random(), 0.1, 0.9));
                            if (!cpuplayer)
                            score_no++;
                            score.setText(Integer.toString(score_no));
                        } else {
                            System.out.println("Game Over");
                            game_running = false;
                            dx *= -1;
                        }
                    }

                    if (ball.getCenterY() < rad || ball.getCenterY() > height - rad) {
                        //ball.setCenterY(ball.getCenterY() + 1);
                        dy *= -1;
                    }
                    //System.out.println(dx+" "+dy);
                    ball.setCenterX(ball.getCenterX() + dx);
                    ball.setCenterY(ball.getCenterY() + dy);


                    primaryStage.setScene(scene);
                }
                else {
                    gameover.setText("GAME OVER");
                    gameover.setFill(Color.RED);
                    start.setText("RESTART");
                    final_score.setText("YOUR SCORE:"+score_no);
                    if (!game_started){
                        final_score.setText("");
                        gameover.setText("");
                        gameover.setFill(Color.GREEN);
                        //start.setText("START");
                    }
                    scene.setFill(Color.BLACK);
                    singleplayer.setOnAction(event1 -> {
                        cpuplayer=true;
                        score_no=0;
                        game_running = true;
                    });
                    multiplayer.setOnAction(event1 -> {
                        cpuplayer=false;
                        score_no=0;
                        game_running = true;
                    });

                    score.setText("0");
                    primaryStage.setScene(scene1);
                }
            }
        }));
        runninggame.setCycleCount(Timeline.INDEFINITE);
        runninggame.setRate(speed);
        runninggame.play();


        primaryStage.setTitle("PONG"); // Set the stage title
         // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }
}
