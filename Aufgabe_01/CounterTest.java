package Aufgabe_01;

public class CounterTest {
    public static void main(String[] args) {
        testing();
    }

    static void testing() // Methode, in der Testing durchgeführt wird
    {
        Counter test = new Counter(); // Es wird ein neues Objekt der Klasse Counter erstellt
        for (int count = 0; count < 20; count++) {
            test.increment();
        }
        for (int count = 0; count < 9; count++) {
            test.decrement();
        }
        System.out.println(test.get()); //Terminal sollte 11 ausgeben
        test.restore(); //Fehlermeldung sollte im Terminal erscheinen
        test.save();
        test.reset();
        System.out.println(test.get()); //Terminal sollte 0 ausgeben
        test.restore();
        System.out.println(test.get()); //Terminal sollte 11 ausgeben
    }
}