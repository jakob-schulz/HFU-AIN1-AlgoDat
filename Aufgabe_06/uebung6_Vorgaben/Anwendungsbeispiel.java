package Aufgabe_06.uebung6_Vorgaben;
import Aufgabe_05.Sortierung;

public class Anwendungsbeispiel {
   public static void main(String[] args) {
      /*
       * Zahlungsmittel geld[] = { new USD_Muenze(0.10), new USD_Schein(20), new
       * SFR_Schein(5),
       * new SFR_Muenze(0.50), new USD_Muenze(0.50), new EUR_Schein(50),
       * new USD_Schein(100), new USD_Muenze(0.2), new USD_Muenze(0.25),
       * new EUR_Muenze(0.01), new SFR_Schein(200), new USD_Schein(100),
       * new EUR_Muenze(2), new EUR_Schein(5), new USD_Muenze(0.25),
       * new SFR_Muenze(0.10), new SFR_Muenze(0.01), new USD_Muenze(0.50),
       * new USD_Schein(100), new USD_Schein(100), new USD_Muenze(0.2),
       * new USD_Muenze(0.01), new SFR_Schein(20), new SFR_Muenze(0.50),
       * new USD_Muenze(0.50), new EUR_Schein(50), new USD_Schein(5),
       * new EUR_Muenze(0.50), new EUR_Muenze(0.01), new SFR_Schein(10),
       * new SFR_Schein(20), new SFR_Muenze(0.50), new SFR_Muenze(0.02) };
       */
      Zahlungsmittel geld[] = { new USD_Muenze(0.10), new EUR_Schein(20), new SFR_Muenze(5),
            new SFR_Muenze(0.50), new USD_Muenze(0.50), new EUR_Schein(50),
            new USD_Schein(100), new EUR_Muenze(0.2), new USD_Muenze(0.25) };

      // Ermitteln der gueltigen bzw. ungueltigen werte (Aufgabenteil 1)
      int ungueltig = 0;
      System.out.print("Aufgabenteil 1\nGueltige Werte: ");
      for (int i = 0; i < geld.length; i++) {
         if (geld[i].wertIstGueltig()) {
            System.out.print(geld[i].toString() + ", "); // Ausgabe der gueltigen Werte mit
                                                         // Waehrung
         } else {
            ungueltig++;
         }
      }
      System.out.println("\nAnzahl ungueltige Werte: " + ungueltig); // Anzahl der ungeueltigen Werte

      // Gesamtwert aller Zahlungsmittel nach Waehrung getrennt (Aufgabenteil 2)
      double euro = 0;
      double franken = 0;
      double dollar = 0;
      for (int i = 0; i < geld.length; i++) {
         if (geld[i].wertIstGueltig()) {
            switch (geld[i].getWaehrung()) {
               case "EUR":
                  euro = euro + geld[i].getWert();
                  break;
               case "USD":
                  dollar = dollar + geld[i].getWert();
                  break;
               case "SFR":
                  franken = franken + geld[i].getWert();
                  break;
               default:
                  throw new Error("Waehrung nicht erkannt");
            }
         }
      }
      System.out.println("Aufgabenteil 2:\nBetraege: " + euro + " EUR, " + franken + " SFR, " + dollar + " USD");

      // Gesamtgewicht aller Muenzen und Gesamtflaeche aller Banknoten berechnen (Aufgabenteil 3)
      double gewichtMuenzen = 0;
      double flaecheScheine = 0;
      for (int i = 0; i < geld.length; i++) {
         if (geld[i].wertIstGueltig()) {
            if (geld[i] instanceof Muenze) //Ueberpruefen, ob das Zahlungsmitel das Interface Muenze implementiert
            {
               gewichtMuenzen = gewichtMuenzen + ((Muenze) geld[i]).getGewicht(); //Expliziter Cast ausfuehren und gewicht der Muenzen addieren
            }
            if(geld[i] instanceof Schein) //Ueberpruefen, ob das Zahlungsmitel das Interface Schein implementiert
            {
               flaecheScheine = flaecheScheine + (((Schein)geld[i]).getBreite() * ((Schein)geld[i]).getLaenge() / 100); //Errechnen des gesamten flaecheninhalts inklusive umrechnen in Quadratzentimeter
            }
         }
      }
      System.out.println("Aufgabenteil 3:\nGewicht der Muenzen: " + gewichtMuenzen + "Gramm\nGesamtflaeche der Scheine: " + flaecheScheine + "cm^2");

      //Ermitteln der Hoehe des Stapels aller Muenzen in Zentimeter (Aufgabenteil 4)
      double hoeheMuenzen = 0; 
      for(int i = 0; i < geld.length; i++)
      {
         if(geld[i].wertIstGueltig())
         {
            if(geld[i] instanceof Muenze)
            {
               hoeheMuenzen = hoeheMuenzen + (((Muenze)geld[i]).getDicke() / 10);
            }
         }
      }
      System.out.println("Aufgabenteil 4:\nHoehe des Stapels aller Muenzen: " + hoeheMuenzen + "cm");

      //Geld mit mergesort sortieren (Aufgabe 5)
      Sortierung.mergesort(geld);
      System.out.print("Sortieren des Geldes nach Zahlen: ");
      for(int i = 0; i < geld.length; i++)
      {
         System.out.print("["+geld[i].toString()+"]");  
      }
   }
}

// Abspeichern der gueltigen Zahlungsmittel waere moeglich durch:
/*
 * Zahlungsmittel gueltigeZahlungsmittel[] = new Zahlungsmittel[geld.length -
 * ungueltig]; //array mit gueltigen Zahlungsmitteln in Abhaengigkeit von geld
 * int input = 0;
 * for(int i = 0; i < geld.length; i++)
 * {
 * if(geld[i].wertIstGueltig())
 * {
 * gueltigeZahlungsmittel[input] = geld[i];
 * input++;
 * }
 * }
 */