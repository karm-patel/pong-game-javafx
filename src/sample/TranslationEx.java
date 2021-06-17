package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class TranslationEx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
       Rectangle rect1 = new Rectangle(100,100, 200,200), rect2 = new Rectangle(100,100, 200,200);
       rect1.setFill(Color.AQUA);
       rect2.setFill(Color.AZURE);
       Circle c1 = new Circle(400,400,20), c2 = new Circle(450,400,20);
       Group root = new Group();
       root.getChildren().addAll(rect1,rect2,c1,c2);

        Rotate rt = new Rotate();
        rt.setAngle(35);

        rt.setPivotX(200);
        rt.setPivotY(200);
        rect2.getTransforms().add(rt);

        Scale scale = new Scale();
        scale.setX(3);
        scale.setY(5);
        scale.setPivotX(430);
        scale.setPivotY(360);
        c2.getTransforms().add(scale);
        Scene scene = new Scene(root,1000,1000);
       primaryStage.setScene(scene);
       primaryStage.show();

    }
}
