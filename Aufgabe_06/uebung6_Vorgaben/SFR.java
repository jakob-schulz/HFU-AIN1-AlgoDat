package Aufgabe_06.uebung6_Vorgaben;

public abstract class SFR extends Zahlungsmittel {
   protected SFR(double wert) {
	   super("SFR", wert);
   }
   public abstract boolean wertIstGueltig();
}
