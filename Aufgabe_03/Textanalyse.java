package Aufgabe_03;

public class Textanalyse {
    public static void main(String[] args) {
        int argcount = args.length; // Zaehlt die Anzahl der Argumente
        //Ausgabe der Argumente:
        System.out.print("Argumente: ");
        for(int position = 0; position < argcount; position++)
        {
            System.out.print(args[position] + " ");
        }
        System.out.println("\nAnzahl der Argumente: " + argcount);
        int[] anzahlBuchstaben = new int[26]; 
        for (int argument = 0; argument < argcount; argument++)
        {
            //Ausgabe der Laenge der Argumente
            System.out.println("Laenge des " + (argument +1) + ". Arguments: " + args[argument].length());
            //Einlesen der Buchstaben jedes Argumentes
            for (int buchtstabe = 0; buchtstabe < args[argument].length(); buchtstabe++) 
            {
                if(gross(args[argument].charAt(buchtstabe)) >= 'A' && gross(args[argument].charAt(buchtstabe)) <= 'Z')
                {
                int position = (int)gross(args[argument].charAt(buchtstabe)) - (int)'A'; //bestimmen der alphabetischen Position des Buchstaben: char wird in ascii Wert umgewandelt. Dann wird ascii Wert von A abgezogen
                anzahlBuchstaben[position] = anzahlBuchstaben[position] + 1; //entspechnde Position um 1 erhoehen
                }
            }
        }
        //Anzahl der Buchstaben ausgeben:
        System.out.println("Anzahl der Buchstaben:");
        for(int position = 0; position < anzahlBuchstaben.length; position++) 
        {
            if(anzahlBuchstaben[position] != 0)
            {
                char buchtstabe = (char)(position + (int)'A'); //Explizieter Cast zu char
                System.out.println(buchtstabe + ": " + anzahlBuchstaben[position]);
            }
        }
    }

    private static char gross(char c)
    {
        if( c >= 'a' && c <= 'z')
        {
            int asciiGrossBuchstabe = (int)c + ((int)'A' - (int)'a'); //Umwandlung in Grossbuchstaben durch Ascii Berrechnungen
            return (char)asciiGrossBuchstabe; 
        }
        return c;
        //Alternative:
        //return Character.toUpperCase(c);
    }
}