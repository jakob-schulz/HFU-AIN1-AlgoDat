package Aufgabe_07.Vorgaben;
import Aufgabe_07.MyList;
import Aufgabe_06.uebung6_Vorgaben.*;

public class MyListTest {

public static void main(String[] args) {
     MyList<Integer> l= new MyList<Integer>();
     for (int i=1; i<=10; ++i)
        l.add(8*i);
     l.remove(2);
     for (int i=l.size()-1; i>=0; --i)
         System.out.print(" " + l.get(i));
     System.out.println();
     MyList<Zahlungsmittel> geld = new MyList<Zahlungsmittel>();
     geld.add(new EUR_Muenze(0.01));
     geld.add(new EUR_Muenze(0.02));
     geld.add(new EUR_Muenze(0.03));
     geld.remove(2);
     geld.add(new EUR_Muenze(0.05));
     geld.add(new EUR_Muenze(0.10));
     geld.add(new EUR_Muenze(0.20));
     geld.add(new EUR_Muenze(0.50));
     geld.add(new EUR_Muenze(1.00));
     geld.add(new EUR_Muenze(2.00));
     System.out.print("Euromuenzen: ");
     for(int i = 0; i< geld.size(); i++)
     {
      System.out.print(geld.get(i) + " ");
     }
   }
}
