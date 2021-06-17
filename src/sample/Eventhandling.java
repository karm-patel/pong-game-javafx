package sample;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

@SuppressWarnings("Convert2Lambda")
public class Eventhandling extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Circle cir = new Circle();
        cir.setRadius(50);
        cir.setFill(Color.BROWN);
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        Button btn1 = new Button();
        btn1.setText("yellow");
        btn1.setTextFill(Color.YELLOW);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cir.setFill(Color.YELLOW);
            }
        });
        Button btn2 = new Button();
        btn2.setText("purple");
        btn2.setTextFill(Color.PURPLE);

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cir.setFill(Color.PURPLE);
            }
        });
        root.add(btn1,1,2);
        root.add(btn2,2,2);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cir.setFill(Color.RED);
            }
        });

        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cir.setFill(Color.BLUE);
            }
        });
        root.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                cir.setFill(Color.BROWN);
            }
        });
  /*      root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.KP_UP){
                    cir.setFill(Color.BLACK);
                }
                else {
                    cir.setFill(Color.WHITE);
                }
            }
        });*/
        root.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.DOWN){
                cir.setFill(Color.YELLOW);
            }
        });
        //root.setGridLinesVisible(true);
        root.add(cir,1,1);

        Text msj = new Text("Hii i am moving");

        TranslateTransition right = new TranslateTransition();

        right.setByX(500);
        right.setByY(0);
        right.setAutoReverse(true);
        right.setDuration(Duration.seconds(5));
        right.setCycleCount(Animation.INDEFINITE);
        right.setNode(msj);
        right.play();

        TranslateTransition left = new TranslateTransition();
        /*ToggleGroup grp = new ToggleGroup();
        RadioButton rbtn1 = new RadioButton("Red");
        RadioButton rbtn2 = new RadioButton("Purple");
        rbtn1.setToggleGroup(grp);
        rbtn2.setToggleGroup(grp);

        rbtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                msj.setFill(Color.RED);
            }
        });

        rbtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // msj.setStroke(Color.PURPLE);
                msj.setFill(Color.PURPLE);
            }
        });*/

        root.add(msj,1,3);
        /*root.add(rbtn1,1,4);
        root.add(rbtn2,2,4);*/
        Scene scene = new Scene(root,800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
