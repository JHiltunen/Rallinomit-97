/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rallinomit;

import static javafx.application.Application.STYLESHEET_CASPIAN;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author s1500542
 */
public class MainMenuPane {

    private BorderPane mainmenuPane;

    public MainMenuPane() {
        this.mainmenuPane = new BorderPane();

    }

    public Pane getMainPane() {

        LeaderboardPane leaderboard = new LeaderboardPane();

        mainmenuPane.setPrefSize(640, 400);

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


        Label title = new Label("Rallinomit '97");
        title.setFont(Font.font(STYLESHEET_CASPIAN, 25));
        Label credits = new Label("Aleksi R., Aleksi T. and Joonas H.");

        Button playButton = new Button("Play");
        playButton.setPadding(new Insets(5, 40, 5, 40));
        playButton.setFont(Font.font(STYLESHEET_MODENA, 15));
        Button leaderboardButton = new Button("Leaderboard");
        leaderboardButton.setPadding(new Insets(5, 40, 5, 40));
        leaderboardButton.setFont(Font.font(STYLESHEET_MODENA, 15));


        VBox buttons = new VBox();

        buttons.setSpacing(10);
        buttons.setPadding(new Insets(10, 10, 10, 10));
        buttons.setAlignment(Pos.BOTTOM_LEFT);
        buttons.getChildren().add(playButton);
        buttons.getChildren().add(leaderboardButton);


        VBox info = new VBox();
        info.setSpacing(4);
        info.setPadding(new Insets(10, 10, 10, 10));
        info.setAlignment(Pos.TOP_LEFT);
        info.getChildren().add(title);
        info.getChildren().add(credits);

        //        mainmenuPane.setPadding(new Insets(110, 110, 110, 110));    
        mainmenuPane.getChildren().add(kuva);
        mainmenuPane.setBottom(buttons);
        mainmenuPane.setTop(info);


        leaderboardButton.setOnAction((event) -> {

            PaneUtils.vaihdaIkkuna(mainmenuPane, leaderboard.getLeaderboardPane());
        });

        return mainmenuPane;
    }

}
