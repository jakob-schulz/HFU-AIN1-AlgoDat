//Ein Counter, welcher zusätzlich die maximale Kapazität speichert
public class RestrictedCounter extends Counter //Die Klasse RestrictedCounter wird von der Klasse Counter abgeleitet
{
    private int capacity;
    public RestrictedCounter(int capacity) 
    {
        //Der Konstruktor der Klasse Counter wird aufgerufen. Zusätzlich wird die Kapazität gespeichert
        super();
        this.capacity = capacity;
    }

    public void increment()
    {
        //Ist die maximale Kapazität noch nicht erreicht wird increment der Klasse Counter aufgerufen
        if(capacity > super.get())
        {
            super.increment();
        }
        else
        {
            System.out.println("Die maximale Kapazität ist erreicht");
        }
    }

    //Kapazität, die noch frei ist
    public int freeCapacity()
    {
        return capacity - super.get();
    }
}
