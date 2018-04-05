/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rallinomit;

/**
 *
 * @author s1500542
 */
public enum Driver {

    JOONAS("Joonas", "17", "Taitaja", "\"Old Taitaja, but still young!\" That's what Joonas told me in our radio interview with him back in 1996.\n"
            + "Joonas began his racing hobby ever since his parents gave him their old Ford Fiesta. Joonas tuned his Fiesta field car everyday after school, and during weekends he and his friends would always have a fiesta in his Fiesta, and that meant pushing the car to its absolute limits by driving it around on the fields. Joonas enslaved himself by following the sheepish career path of coding, which he knew would lead him to a dead-end job. He quit school after the second term and began to follow his dreams to become a racecar driver. Joonas is now racing against two other good-for-nothing hicks in a race of his lifetime. It's now or never!"),
    TAVI("Tavi", "19", "Pumping Iron", "Aleksi has made it loud and clear that he's just in for the money. He barely even knows how to drive. Aleksi's current girlfriend had driven him in to a financial crisis because of her crippling gambling addiction caused by the slot machines at the nearby supermarket. He had no other choice."),
    ALEKSI("Aleksi", "18", "Crossfit", "\"I don't know\" said Tavi when he was asked about his chances of winning. Little has been documented about this failed musician. Rumors say he likes to run around aimlessly in the forest next to the solitary confinement he calls home.");

    private final String name;
    private final String age;
    private final String hobby;
    private final String info;

    /*
    Konstruktori Driver enumille. Esim. Driver.Joonas kutsutaan Driver enumin konstruktoria Jokainen enum vakio on olio, jonka takia tarvitsemme konstruktorin.
    Normaaliin tapaan oliolla on omat muuttujansa.
    */
    Driver(String nimi, String ika, String harrastus, String tieto) {
        name = nimi;
        age = ika;
        hobby = harrastus;
        info = tieto;
    }

    /*
    Palautetaan Joonas enum.
    */
    public static Driver getJOONAS() {
        return JOONAS;
    }

    /*
    Palautetaan Tavi enum.
    */
    public static Driver getTAVI() {
        return TAVI;
    }

    /*
    Palautetaan Aleksi enum.
    */
    public static Driver getALEKSI() {
        return ALEKSI;
    }

    /*
    Palautetaan kutsutun enum vakion nimi.
    */
    public String getName() {
        return name;
    }

    /*
    Palautetaan kutsutun enum vakion ikä.
    */
    public String getAge() {
        return age;
    }

    /*
    Palautetaan kutsutun enum vakion harrastus.
    */
    public String getHobby() {
        return hobby;
    }

    /*
    Palautetaan kutsutun enum vakion "tarina" eli info
    */
    public String getInfo() {
        return info;
    }

}
