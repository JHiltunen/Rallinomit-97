/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rallinomit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    private ObservableList<Rank> tuloksetTiedostosta;

    public LeaderboardPane() {
        this.tulosTaulukko = new TableView();
        
        this.sijoitusSarake = new TableColumn("Rank");
        
        this.pelaajaSarake = new TableColumn("Player");
        
        this.aikaSarake = new TableColumn("Time");
        
        this.tuloksetTiedostosta = FXCollections.observableArrayList();

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
        
        // lisätään taulukkoon data        
        // tässä kohtaa pitäisi lukea tiedostosta (alla on vain demo dataa)
        tuloksetTiedostosta.add(new Rank(1, "Joobas", 50));
        tuloksetTiedostosta.add(new Rank(2, "Petteri", 100));
        tuloksetTiedostosta.add(new Rank(3, "Mikko", 150));
        tuloksetTiedostosta.add(new Rank(4, "Matti", 180));
        tuloksetTiedostosta.add(new Rank(5, "Teppo", 210));
        tulosTaulukko.setItems(tuloksetTiedostosta);
        /*
        lisätään jokaiselle solulle CellValueFactory
        Javadocista: The cell factory is responsible for rendering the data contained within each TableCell for a single table column.
        */
        this.sijoitusSarake.setCellValueFactory(new PropertyValueFactory("sijoitus"));
        this.pelaajaSarake.setCellValueFactory(new PropertyValueFactory("pelaaja"));
        this.aikaSarake.setCellValueFactory(new PropertyValueFactory("aika"));
    }
}
