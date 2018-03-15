/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rallinomit;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Aleksi Rautiainen
 */
public class LeaderboardPane extends AnchorPane {

    @FXML
    private TableView<Rank> tulosTaulukko;
    @FXML
    private TableColumn sijoitusSarake;
    @FXML
    private TableColumn pelaajaSarake;
    @FXML
    private TableColumn aikaSarake;

    @FXML
    private TextField hakuKentta;
    @FXML
    private ComboBox<String> hakuFiltteri;

    private ArrayList<Rank> tuloksetTiedostosta;

    public LeaderboardPane() {
        this.tulosTaulukko = new TableView();
        this.pelaajaSarake = new TableColumn("Rank");
        this.sijoitusSarake = new TableColumn("Player");
        this.aikaSarake = new TableColumn("Time");
        this.tuloksetTiedostosta = new ArrayList<>();

        this.hakuKentta = new TextField();
        this.hakuFiltteri = new ComboBox<>(FXCollections.observableArrayList("LandeRally", "MikkoRally", "DatanomiRally"));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LeaderboardPane.fxml"));
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
        // Aluksi lisätään tulostaulukkoon sarakkeet
        tulosTaulukko.getColumns().addAll(pelaajaSarake, sijoitusSarake, aikaSarake);

        // Lisätään sarakkeisiin CellFactoryt
        sijoitusSarake.setCellFactory(new PropertyValueFactory("sijoitus"));
        pelaajaSarake.setCellFactory(new PropertyValueFactory("pelaaja"));
        aikaSarake.setCellFactory(new PropertyValueFactory("aika"));

        // Haetaan tiedot tiedostosta
        tuloksetTiedostosta.add(new Rank(1, "Joonas", System.nanoTime()));
        tuloksetTiedostosta.add(new Rank(2, "Aleksi R.", System.nanoTime()));

        // Upotetaan lista tulosTaulukon tiedoiksi 
        tulosTaulukko.setItems(FXCollections.observableList(tuloksetTiedostosta));
    }
}
