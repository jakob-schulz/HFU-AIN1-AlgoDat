package Aufgabe_02;

public class BruchTest {
    public static void main(String[] args) {
        Bruch x = new Bruch(1, 2);
        Bruch y = new Bruch(2, 3);
        y.plus(x);
        System.out.println("y = " + y.get());
        x.minus(y);
        System.out.println("x = " + x.get());
        Bruch a = new Bruch(17, 35);
        a.mal(y);
        System.out.println("a = " + a.get());
        Bruch b = new Bruch(12, 34);
        b.geteilt(a);
        System.out.println("b = " + b.get());
        // Erwarteter Output: y = 7/6, x = -2/3, a = 17/30, b = 180/289

        // Teilaufgabe 2 (Tests):
        Bruch summe = new Bruch(1, 1);
        for (int i = 2; i <= 12; i++) {
            summe.plus(new Bruch(1, i));
        }
        System.out.println("Teilaufgabe 2 (12 Wdh.): " + summe.get());
        // Erwartetes Ergebnis: 86021/27720
        BruchTest t = new BruchTest();
        Bruch e = t.e(8);
        System.out.println("Die Eulersche Zahl e angenaehert: " + e.get());
    }

    //Ab n=9 annaeherung falsch, weil Zahlen zu groß werden.
    private Bruch e(int n) {
        Bruch summe = new Bruch(1, 1);
        for (int anzahl = 1; anzahl <= n; anzahl++) {
            //Berechnen des Nenners, also der Fakultaet
            int fakultaet = anzahl;
            int i = anzahl;
            while (i > 2) {
                fakultaet = fakultaet * (i - 1);
                i = i - 1;
            }
            //Aufaddieren der einzelnen Brueche
            summe.plus(new Bruch(1, fakultaet));
        }
        return summe;
    }
}