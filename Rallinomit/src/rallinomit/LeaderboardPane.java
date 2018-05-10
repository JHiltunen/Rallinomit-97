/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rallinomit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author s1500542
 */
public class LeaderboardPane {

    private TableView<Rank> tulosTaulukko;

    private TableColumn sijoitusSarake;

    private TableColumn pelaajaSarake;

    private TableColumn aikaSarake;

    private AnchorPane leaderboard;

    private TextField hakuKentta;

    private ComboBox<String> hakuFiltteri;

    private ObservableList<Rank> tuloksetTiedostosta;

    public LeaderboardPane() {
        this.leaderboard = new AnchorPane();
        this.leaderboard.setPrefSize(640, 400);

        this.tulosTaulukko = new TableView();
        this.tulosTaulukko.setPrefSize(500, 310);

        this.sijoitusSarake = new TableColumn("Rank");

        this.pelaajaSarake = new TableColumn("Player");

        this.aikaSarake = new TableColumn("Time");

        this.tulosTaulukko.getColumns().add(sijoitusSarake);
        this.tulosTaulukko.getColumns().add(pelaajaSarake);
        this.tulosTaulukko.getColumns().add(aikaSarake);

        this.tuloksetTiedostosta = FXCollections.observableArrayList();

        this.hakuKentta = new TextField();
        this.hakuFiltteri = new ComboBox<>(FXCollections.observableArrayList("All tracks", "LandeRally", "MikkoRally", "DatanomiRally"));
        this.hakuFiltteri.setValue("All tracks");


    }

    public Pane getLeaderboardPane() {


        // lisätään taulukkoon data        
        // tässä kohtaa pitäisi lukea tiedostosta (alla on vain demo dataa)
        tuloksetTiedostosta.add(new Rank(1, "Joonas", 50));
        tuloksetTiedostosta.add(new Rank(2, "Petteri", 100));
        tuloksetTiedostosta.add(new Rank(3, "Mikko", 150));
        tuloksetTiedostosta.add(new Rank(4, "Matti", 180));
        tuloksetTiedostosta.add(new Rank(5, "Teppo", 210));
        tulosTaulukko.setItems(tuloksetTiedostosta);
        /*
         * lisätään jokaiselle solulle CellValueFactory Javadocista: The cell
         * factory is responsible for rendering the data contained within each
         * TableCell for a single table column.
         */
        this.sijoitusSarake.setCellValueFactory(new PropertyValueFactory("sijoitus"));
        this.pelaajaSarake.setCellValueFactory(new PropertyValueFactory("pelaaja"));
        this.aikaSarake.setCellValueFactory(new PropertyValueFactory("aika"));


        //tästä alkaa varsinainen käyttöliittymän kokoaminen
        Image lahdeKuva = new Image("file:rallinomi.png");

        PixelReader kuvanLukija = lahdeKuva.getPixelReader();

        int leveys = (int) lahdeKuva.getWidth();
        int korkeus = (int) lahdeKuva.getHeight();

        WritableImage kohdeKuva = new WritableImage(leveys, korkeus);
        PixelWriter kuvanKirjoittaja = kohdeKuva.getPixelWriter();

        int yKoordinaatti = 0;
        while (yKoordinaatti < korkeus) {
            int xKoordinaatti = 0;
            while (xKoordinaatti < leveys) {

                Color vari = kuvanLukija.getColor(xKoordinaatti, yKoordinaatti);
                double punainen = vari.getRed();
                double vihrea = vari.getGreen();
                double sininen = vari.getBlue();
                double lapinakyvyys = vari.getOpacity();

                Color uusiVari = new Color(punainen, vihrea, sininen, lapinakyvyys);

                kuvanKirjoittaja.setColor(xKoordinaatti, yKoordinaatti, uusiVari);

                xKoordinaatti++;
            }

            yKoordinaatti++;
        }

        ImageView kuva = new ImageView(kohdeKuva);


        MainMenuPane mainmenuPane = new MainMenuPane();


        Button button = new Button("main menu");

        Label haku = new Label("Search ");

        HBox ylaAsettelu = new HBox(haku, this.hakuKentta, this.hakuFiltteri);
        ylaAsettelu.setSpacing(10);

        HBox jutut = new HBox(button, ylaAsettelu);
        jutut.setSpacing(193);

        VBox ylaJaAla = new VBox(jutut, this.tulosTaulukko);
        ylaJaAla.setSpacing(20);

        BorderPane asettelu = new BorderPane();

        asettelu.setPadding(new Insets(20, 20, 20, 20));
        asettelu.setCenter(ylaJaAla);
        leaderboard.getChildren().add(kuva);
        leaderboard.getChildren().add(asettelu);

        button.setOnAction((event) -> {
            PaneUtils.vaihdaIkkuna(leaderboard, mainmenuPane.getMainPane());
        });

        return leaderboard;
    }

}
