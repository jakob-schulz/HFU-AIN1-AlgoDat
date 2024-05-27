public class Sortierung {
    public static void mergesort(Comparable[] x) { // Objekte, deren Klassen das Interface Comparable implementieren
                                                   // koennen hier sortiert werden?
        if (x.length == 1) {
            return;
        }
        // Aufteilen des arrays in linken und rechten array
        int m = x.length / 2;
        Comparable[] l = new Comparable[m];
        Comparable[] r;
        if (x.length % 2 != 0) { //Falls array eine ungerade Anzahl an Elementen hat
            r = new Comparable[m + 1];
            r[m] = x[x.length - 1]; //letztes Element fuer rechten Teilarray wird eingefuegt, weil for-Schleife dies nicht beruecksichtigt
        }
        else
        {
             r = new Comparable[m];
        }
        for (int pos = 0; pos < m; pos++) {
            l[pos] = x[pos];
            r[pos] = x[pos + m];
        }
        mergesort(l);
        mergesort(r);
        // Mergen des linken und rechten arrays
        int lpos = 0;
        int rpos = 0;
        for (int pos = 0; pos < x.length; pos++) {
            // ist linker array einsortiert kann rechter uebernommen werden
            if (lpos == l.length) {
                for (; rpos < r.length; rpos++) {
                    x[pos] = r[rpos];
                    pos++;
                }
                break;
            }
            // ist rechter array einsortiert kann linker array uebernomme werden
            if (rpos == r.length) {
                for (; lpos < l.length; lpos++) {
                    x[pos] = l[lpos];
                    pos++;
                }
                break;
            }
            // einsortieren des kleineren elements und erhoehen des entsprechenden arrays
            if (l[lpos].compareTo(r[rpos]) < 0) {
                x[pos] = l[lpos];
                lpos++;
            } else {
                x[pos] = r[rpos];
                rpos++;
            }
        }
    }
}

// Codefragmente zum Ueberpruefen von Fehlern:
/*
 * // Eisetzen anstelle der Auteilung in linkes und rechtes array
 * System.out.print("\n L:");
 * for (int pos = 0; pos < m; pos++) {
 * l[pos] = x[pos];
 * System.out.print(l[pos] + ", ");
 * }
 * System.out.print("\n R:");
 * for (int pos = 0; pos < m; pos++) {
 * r[pos] = x[pos + m];
 * System.out.print(r[pos] + ", ");
 * }
 */
/*
 * // Eistetzen nach merge
 * System.out.print("\nX: ");
 * for(int pos = 0; pos < x.length; pos++)
 * {
 * System.out.print(x[pos] + ", ");
 * }
 */