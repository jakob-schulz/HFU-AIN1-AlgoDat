package Aufgabe_01;

public class Counter {
    private int count; // Zaehlerstand
    private int savedCount;
    private boolean isSaved = false;

    public Counter() // Konstruktor
    {
        count = 0;
    }

    public void increment() // Hochzaehlen
    {
        count++;
    }

    public int get() // Auslesen
    {
        return count;
    }

    public void reset() // Zuruecksetzen
    {
        count = 0;
    }

    public void decrement() { // Zaehlerstand wird um 1 verringert
        if (count > 0) {
            count = count - 1;
        }
    }

    public void save() {
        savedCount = count;
        isSaved = true;
    }

    public void restore()
    {
        if(isSaved)
        {
            count = savedCount;
        }
        else
        {
            System.out.println("Es gibt keinen gespeicherten Wert");
        }
    }
}