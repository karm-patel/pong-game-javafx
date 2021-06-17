package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Uicontrols extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("click");
        btn.setWrapText(true);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("button clicked");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().addAll(btn);
        Scene scene = new Scene(root,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
