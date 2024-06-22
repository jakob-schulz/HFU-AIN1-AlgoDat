package Aufgabe_08;

import java.util.LinkedList; //Fuer linked list
import java.util.TreeSet; //Fuer balancierten Baum
import java.util.ArrayList;
import java.util.HashSet;//Fuer HashTabelle
import java.util.Iterator;

public class UmgangCollections {
    public static void main(String[] args) {
        LinkedList<String> li = new LinkedList<>();
        li.add("Montag");
        li.add("Dienstag");
        li.add("Mittwoch");
        li.add("Donnerstag");
        li.add("Freitag");
        li.add("Samstag");
        li.add("Sonntag");
        TreeSet<String> bb = new TreeSet<String>();
        HashSet<String> ht = new HashSet<>(15, 0.75f);
        for (int i = 0; i < li.size(); i++) {
            bb.add(li.get(i));
            ht.add(li.get(i));
        }
        System.out.print("Ausgabe von LinkedList, balancierter Baum, HashTabelle mit einer for each-Schleife\nli: ");
        for (String s : li) {
            System.out.print(s + ", ");
        }
        System.out.print("\nbb: ");
        for (String s : bb) {
            System.out.print(s + ", ");
        }
        System.out.print("\nht: ");
        for (String s : ht) {
            System.out.print(s + ", ");
        }

        // Aufgabe 2: Ausgabe jedes zweiten Elements aus li, bb und ht mit Hilfe von
        // Iteratoren

        // Fuer Linked List:
        Iterator<String> it = li.iterator();
        int index = 0;
        System.out.print("\n\nIterieren ueber die Liste (Jedes zweite Element wird ausgegeben): ");
        while (it.hasNext()) // schaut, ob current == null ist. Bedeutet also, wenn das naechste Element null
                             // ist, hat es trotzdem ein naechstes Element mehr. Nur null hat kein naechstes
                             // Element
        {
            String temp = it.next(); // wird benoetigt, weil next nicht nur das aktuelle Element ausgibt, sondern
                                     // auch zum nachesten Element weiter "springt"
            if ((index % 2) == 0) {
                System.out.print(temp + ", ");
            }
            index++;
        }
        // Fuer balancierten Baum:
        it = bb.iterator();
        index = 0;
        System.out.print("\nIterieren ueber den balancierten Baum (Jedes zweite Element wird ausgegeben): ");
        while (it.hasNext()) // schaut, ob current == null ist. Bedeutet also, wenn das naechste Element null
                             // ist, hat es trotzdem ein naechstes Element mehr. Nur null hat kein naechstes
                             // Element
        {
            String temp = it.next(); // wird benoetigt, weil next nicht nur das aktuelle Element ausgibt, sondern
                                     // auch zum nachesten Element weiter "springt"
            if ((index % 2) == 0) {
                System.out.print(temp + ", ");
            }
            index++;
        }
        // Fuer Hashtabelle:
        it = ht.iterator();
        index = 0;
        System.out.print("\nIterieren ueber den balancierten Baum (Jedes zweite Element wird ausgegeben): ");
        while (it.hasNext()) // schaut, ob current == null ist. Bedeutet also, wenn das naechste Element null
                             // ist, hat es trotzdem ein naechstes Element mehr. Nur null hat kein naechstes
                             // Element
        {
            String temp = it.next(); // wird benoetigt, weil next nicht nur das aktuelle Element ausgibt, sondern
                                     // auch zum nachesten Element weiter "springt"
            if ((index % 2) == 0) {
                System.out.print(temp + ", ");
            }
            index++;
        }

        // Aufgabe 3: Saemtliche Primzahlen von 2 bis 1000 ermitteln (Teilaufgabe von 4: Diese gefundenen Primzahlen in eine ArrayList eintragen)
        int n = 1000;
        LinkedList<Integer> zahlen = new LinkedList<Integer>();
        ArrayList<Integer> primzahlen = new ArrayList<>(); //Fuer Aufgabe 4
        //Zahlen der groesse nach in Liste einsortieren
        for (int i = 2; i <= n; i++) {
            zahlen.add(i);
        }
        System.out.println("\n\nAusgabe aller Primzahlen von 2 bis " + n);
        //Verfahern: Sieb des Eratosthenes??
        while (!zahlen.isEmpty()) {
            //Das erste Element ist bei diesem Verfahren immmer eine Primzahl
            int prim = zahlen.getFirst();
            System.out.print(prim + ", ");
            primzahlen.add(prim); //Fuer Aufgabe 4
            //Durch die Liste iterieren und vielfache des ersten Elements (der Primzahl) entfernen
            Iterator<Integer> i = zahlen.iterator();
            while (i.hasNext()) {
                int temp = i.next();
                if(temp % prim == 0)
                {
                    i.remove();
                }
            }
        }

        //Aufgabe 4: ArrayList mit einer Schleife durchlaufen und Primzahlzwillinge ausgeben:
        System.out.println("\n\nAusgabe aller Primzahlzwillinge von 2 bis " + n);
        for(int pos = 0; pos < primzahlen.size() - 1; pos++)
        {
            if(primzahlen.get(pos + 1) - primzahlen.get(pos) == 2) //Ist die Differenz zweier aufeinander folgender Primzahlen 2, handelt es sich um Primzahlzwillinge
            {
                System.out.print("(" + String.valueOf(primzahlen.get(pos)) + " " + String.valueOf(primzahlen.get(pos + 1)) + "), "); //Ohne " " muesste man String.valueOf(Integer) fuer jeweils beide Primzahlen man machen, weil sonst die beiden Primzahlen addiert werden
            }
        }
    }
}
