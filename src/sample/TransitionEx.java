package sample;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TransitionEx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Rectangle cir = new Rectangle(50,50,130,30);
        cir.setFill(Color.BROWN);
        RotateTransition rt = new RotateTransition();
        rt.setCycleCount(2);
        rt.setByAngle(360);
        rt.setDuration(Duration.seconds(3));
        rt.setNode(cir);
        rt.setAutoReverse(true);
        //rt.play();


        TranslateTransition tt = new TranslateTransition();
        tt.setToX(500);
        tt.setToY(100);
        tt.setDuration(Duration.seconds(2));
        tt.setAutoReverse(true);
        tt.setCycleCount(2);
        tt.setNode(cir);
        //tt.play();

        ScaleTransition st = new ScaleTransition();
        st.setByX(-2);

        st.setByY(2);

        st.setDuration(Duration.seconds(2));
        st.setCycleCount(4);
        st.setAutoReverse(true);
        st.setNode(cir);
        //st.play();

        SequentialTransition SeqT = new SequentialTransition(rt,st,tt);
        SeqT.play();
        Group root = new Group();
        root.getChildren().add(cir);
        Scene scene = new Scene(root,1000,1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
