package Aufgabe_06.uebung6_Vorgaben;

public abstract class EUR extends Zahlungsmittel {
   public EUR(double wert) {
	   super("EUR", wert);
   }
   public abstract boolean wertIstGueltig();
}

