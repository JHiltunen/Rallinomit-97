/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rallinomit;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author s1601378
 */
public class MainMenuPane extends AnchorPane {
    
    @FXML
    private Button playButton;

    @FXML
    private Button leaderboardButton;

    public MainMenuPane() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenuPane.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() {
        // playButtonin toiminnallisuus -- TÄYTETÄÄN MYÖHEMMIN --
        playButton.setOnAction((ActionEvent event) -> {

        });

        // leaderboardButtonin toiminallisuus
        leaderboardButton.setOnAction((ActionEvent event) -> {
            PaneUtils.vaihdaIkkuna(this, new LeaderboardPane());
        });
    }
}
