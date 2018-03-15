/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rallinomit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author Aleksi Rautiainen
 */
public class MainMenuPane implements Initializable {

    @FXML
    private Button playButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // playButtonin toiminnallisuus. -- TÄYTETÄÄN MYÖHEMMIN --
        playButton.setOnAction((ActionEvent event) -> {

        });

    }

}
