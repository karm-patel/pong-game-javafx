package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Ex3Dshapes extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Box box = new Box();

        box.setDepth(100);
        box.setWidth(200);
        box.setHeight(200);
        box.setCullFace(CullFace.NONE);

        Sphere sphere = new Sphere();
        sphere.setTranslateX(200);
        sphere.setTranslateY(200);
        sphere.setRadius(100);
        sphere.setCullFace(CullFace.NONE);

        Cylinder cy = new Cylinder();
        cy.setHeight(300);
        cy.setRadius(50);
        cy.setTranslateX(500);
        cy.setTranslateY(500);
        cy.setCullFace(CullFace.BACK);



        PhongMaterial mat = new PhongMaterial();

        cy.setMaterial(mat);

        FileInputStream fi = new FileInputStream("/home/kinetic/IdeaProjects/helloworld/car.jpg");
        Image img = new Image(fi);
        ImageView imgv = new ImageView(img);
        imgv.setFitHeight(200);
        imgv.setFitWidth(350);
       /* PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateX(200);
        camera.setTranslateY(200);
        camera.setTranslateZ(100);*/

        Group root = new Group();
        root.getChildren().addAll(box,sphere,cy,imgv);
        Scene scene = new Scene(root,1000,1000);
        /*scene.setCamera(camera);*/
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
