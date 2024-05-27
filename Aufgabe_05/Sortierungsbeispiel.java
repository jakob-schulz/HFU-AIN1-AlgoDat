public class Sortierungsbeispiel {
    public static void main(String[] args) {
        Integer[] a = { 15, 3, 8, 9, 20, 70, 4, 6 };
        Sortierung.mergesort(a);
        System.out.print("a: ");
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        // Testen von mergesort mit strings:
        String[] obst = { "Kiwi", "Banane", "Orange", "Ananas", "Apfel", "Erdbeere" };
        Sortierung.mergesort(obst);
        System.out.print("Obst: ");
        for (int i = 0; i < obst.length; ++i) {
            System.out.print(obst[i] + " ");
        }
        System.out.println();
        // Testen von mergesort mit Bruechen
        Bruch[] brueche = {new Bruch(1, 2), new Bruch(1, 5), new Bruch(1, 9), new Bruch(185, 4), new Bruch(6, 200) };
        Sortierung.mergesort(brueche);
        System.out.print("Brueche: ");
        for (int i = 0; i < brueche.length; ++i) {
            System.out.print(brueche[i].get() + " ");
        }
    }

}
