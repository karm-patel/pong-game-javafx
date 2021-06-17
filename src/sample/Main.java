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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

class Main extends Application
{
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        Circle circle = new Circle(20, 20, 20);
        pane.getChildren().add(circle);
        pane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP : {
                    circle.setCenterY(circle.getCenterY() >
                            circle.getRadius() ? circle.getCenterY() - 10 :
                            circle.getCenterY());
                    break;
                }
                case DOWN : {
                    circle.setCenterY(circle.getCenterY() <
                            pane.getHeight() - circle.getRadius() ?
                            circle.getCenterY() + 10 : circle.getCenterY());
                    break;
                }
                case LEFT : {
                    circle.setCenterX(circle.getCenterX() >
                            circle.getRadius() ? circle.getCenterX() - 10 :
                            circle.getCenterX());
                    break;
                }
                case RIGHT : {
                    circle.setCenterX(circle.getCenterX() <
                            pane.getWidth() - circle.getRadius() ?
                            circle.getCenterX() + 10: circle.getCenterX());
                    break;

                }
            }});

            Scene scene = new Scene(pane, 200, 200);
            primaryStage.setTitle("Move event");
            primaryStage.setScene(scene);
            primaryStage.show();
            pane.requestFocus();


    }
}
