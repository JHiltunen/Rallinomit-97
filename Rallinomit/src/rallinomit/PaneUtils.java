/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rallinomit;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Aleksi Rautiainen
 */
public class PaneUtils {

    /**
     * 
     * @param currentPane Pane (nykyinen, this), josta vaihdetaan seuraavaan paneen
     * @param nextPane Pane, johon vaihdetaan
     */
    public static void vaihdaIkkuna(Pane currentPane, Pane nextPane) {
        Stage stage = (Stage) currentPane.getScene().getWindow();
        stage.setScene(new Scene(nextPane));
    }
}
