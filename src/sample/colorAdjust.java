package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class colorAdjust extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    Circle circle = new Circle(50,50,50);
    circle.setFill(Color.BLUE);
    circle.setStroke(Color.BLUE);

        ColorAdjust c = new ColorAdjust();
        c.setBrightness(0.8);
        c.setContrast(0.5);
        c.setHue(0.8);
        //c.setInput(0.9);

    Text text = new Text();
    text.setText("hii here!");
    text.setX(0);
    text.setY(100);
    text.setStroke(Color.GREEN);
        Image image = new Image("https://www.google.com/search?q=car&sxsrf=ALeKk02Qj45wWuRSfoBNxzws-Lk4QJV3cw:1585677793130&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiiwNmMpsXoAhVMWH0KHXjEDK0Q_AUoAXoECA8QAw&biw=1366&bih=669#imgrc=9UgXvqu1TroG-M");
        ImageInput imageinput = new ImageInput(image,100,50);
        circle.setEffect(imageinput);
    Group grp = new Group();
    grp.getChildren().addAll(circle,text);
    Scene scene = new Scene(grp,500,500);
    primaryStage.setScene(scene);
    primaryStage.show();

    }
}
