public class PowerFunctionsTest {
    public static void main(String[] args) {
        int calculations = 10000; //Anzahl der Berechnungen
        int allExponents = 0; //speichert Summe aller Exponenten
        int allPower = 0; //speichert Summe aller Multiplikationen von Power
        int allFastPower = 0; //speichert Summe aller Multiplikationen von fastPower

        for(int i = 0; i < calculations; i++)
        {
            double x = Math.random();
            int n = (int)(1000 * Math.random());
            PowerFunctions.resetCounters();
            PowerFunctions.power(x, n);
            PowerFunctions.fastPower(x, n);
            allExponents = allExponents + n;
            allPower = allPower + PowerFunctions.getCountPower();
            allFastPower = allFastPower + PowerFunctions.getCountFastPower();
        }
        System.out.println("Durchschnittlich verwendeter Exponent: " + allExponents/calculations + "\nDurchschnittliche Anzahl notwendiger Multiplikationen in power: " + allPower/calculations + "\nDurchschnittliche Anzahl notwendiger Multiplikationen in fastPower: " + allFastPower/calculations);
    }
    //Test, ob power Methoden von PowerFunctions korrekte Werte liefern
    /*
    public static void main(String[] args)
    {
        System.out.println("Ergebnis power: " + PowerFunctions.power(0.25, 234) + "\nErgebnis fastPower: "+ PowerFunctions.power(0.25, 234));
    }*/
}
