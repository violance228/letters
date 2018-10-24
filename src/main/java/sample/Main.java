package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.scene.control.*;
import java.io.IOException;

public class Main extends Application {

    private BorderPane rootLayout;
    private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Letter Game");

        initRootLayout();
        startTheGame();
    }

    public void initRootLayout() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("sample.fxml"));
            rootLayout = (BorderPane)fxmlLoader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startTheGame() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("letterGame.fxml"));
            AnchorPane pane = (AnchorPane) fxmlLoader.load();

            rootLayout.setCenter(pane);
            LetterGame letterGame = fxmlLoader.getController();
            letterGame.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
