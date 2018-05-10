/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rallinomit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author s1500542
 */
public class Rallinomit extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainMenuPane mainmenu = new MainMenuPane();
        LeaderboardPane leaderboard = new LeaderboardPane();

        Scene scene = new Scene(mainmenu.getMainPane());

        primaryStage.setTitle("Rallinomit '97");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
