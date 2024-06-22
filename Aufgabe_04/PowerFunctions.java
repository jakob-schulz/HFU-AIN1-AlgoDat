package Aufgabe_04;

import Aufgabe_01.Counter;

public class PowerFunctions {
    private static Counter countPower = new Counter(); //Zaehlt Anzahl der Multiplikationen in power
    private static Counter countFastPower = new Counter(); //Zaehlt Anzahl der Multiplikationen in fastPower
    
    //Berechnung von x^n mit einer Schleife
    public static double power(double x, int n) {
        double result = 1;
        for (int i = 0; i < n; i++) {
            result = result * x;
            countPower.increment();
        }
        return result;
    }

    //Berechnung von x^n mit Hilfe des Square-Multiply Verfahren
    public static double fastPower(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if(n < 0)
        {
            return 1 / fastPower(x, -n);

        }
        if((n % 2) == 0)
        {
            countFastPower.increment();
            return fastPower(x*x, n/2);
        }
        countFastPower.increment();
        return fastPower(x*x, (n-1) / 2) * x;
    }

    public static void resetCounters() //setzt beide Zahler auf 0 zurueck
    {
        countPower.reset();
        countFastPower.reset();
    }
    public static int getCountPower()
    {
        return countPower.get();
    }
    public static int getCountFastPower()
    {
        return countFastPower.get();
    }

}