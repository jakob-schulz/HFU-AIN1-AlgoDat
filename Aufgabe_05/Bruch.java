public class Bruch implements Comparable<Bruch>{
    private int zaehler;
    private int nenner;

    private int ggT(int a, int b) {
        a = Math.abs(a); //Der Betrag wird erstellt, damit auch negative Zahlen behandelt werden können
        b = Math.abs(b);
        if (b > a) {
            return ggT(b, a);
        } else {
            if (b == 0) {
                return a;
            } else {
                return ggT(b, a % b);
            }
        }
    }

    //Ermoeglicht das vergleichen von Bruechen mit Hilfe des Methode compareTo
    public int compareTo(Bruch b) 
    {
        if((zaehler/nenner) > (b.zaehler/b.nenner))
        {
            return 1;
        }
        if((zaehler/nenner) < (b.zaehler/b.nenner))
        {
            return -1;
        }
        return 0;
    }

    private void kuerzen() {
        // kuerzen der Zaehler und der Nenner
        int ggt = ggT(zaehler, nenner);
        nenner = nenner / ggt;
        zaehler = zaehler / ggt;
    }

    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        //Ist der Nenner 0 wird eine Exception geworfen
        if(nenner == 0)
        {
            throw new ArithmeticException("Der Nenner ist 0. Es ist nicht moeglich durch 0 zu teilen");
        }
        else
        {
        this.nenner = nenner;
        }
    }

    public int getNenner() {
        return nenner;
    }

    public int getZaehler() {
        return zaehler;
    }

    // Gibt den Bruch als String zurueck
    public String get() {
        return zaehler + "/" + nenner;
    }

    public void mal(Bruch b) {
        // Zaehler und Nenner werden multipliziert
        zaehler = zaehler * b.getZaehler();
        nenner = nenner * b.getNenner();
        kuerzen();
    }

    public void geteilt(Bruch b) {
        // Der Bruch wird mit dem Kehrbruch multipliziert
        Bruch kehrBruch = new Bruch(b.nenner, b.zaehler);
        this.mal(kehrBruch);
        kuerzen();
    }

    public void plus(Bruch b) {
        // Die Brueche muessen erweitert werden, damit sie einen gemeinsamen Nenner haben. Dann werden sie gekuerzt.
        zaehler = zaehler * b.nenner + b.zaehler * nenner;
        nenner = nenner * b.nenner;
        kuerzen();
    }

    public void minus(Bruch b) {
        // Die Brueche muessen erweitert werden, damit sie einen gemeinsamen Nenner haben. Dann werden sie gekuerzt.
        zaehler = zaehler * b.nenner - b.zaehler * nenner;
        nenner = nenner * b.nenner;
        kuerzen();
    }
}