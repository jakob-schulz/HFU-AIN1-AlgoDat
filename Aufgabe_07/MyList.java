package Aufgabe_07;

public class MyList<E> {
    //Wird eine Klasse innerhalb einer anderen angelegt kann man Objekte dieser erstellen und man kann trozt private innerhalb der aeusseren Klasse zugreifen.
    private class ListNode {
        private E element;
        private ListNode next;
        
        private ListNode(E element, ListNode next)
        {
            this.element = element;
            this.next = next;
        }
    }

    ListNode first = null;
    ListNode last = null;
    int size = 0;

    public MyList()
    {}

    public void add(E x)
    {
        //Ist noch keine Liste vorhanden wird eine neue Node erstellt und first zeigt auf diese.
        if(first == null)
        {
            first = new ListNode(x, null);
            size++;
            last = first;
            return;
        }
        //Hinzufuegen am Ende soll unabhaengig von der Laenge der Liste erfolgen. Deshalb hinzufuegen eines Zeigers auf das letzte Element
        last.next = new ListNode(x, null);
        last = last.next;
        size++;


        /*Wenn man komplette Liste durchgeht und letztes Element einfuegen will:
        ListNode current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(x, null);
        size++;
        */
    }
    public int size()
    {
        return size;
    }

    public E get(int index)
    {
        if(first == null)
        {
            throw new Error("Die Liste enthaelt noch keine Elemente.");
        }
        ListNode current = first;
        int i = 0;
        //Man geht solange Liste durch, bis man am Index oder am Ende der Liste angelangt ist.
        while (i < index && current != null) {
            current = current.next; 
            i++;           
        }
        if(current == null)
        {
            throw new Error("Der Index ist groesser als die Liste. (get)");
        }
        return current.element;
    }

    public E remove(int index)
    {
        if(first == null)
        {
            throw new Error("Die Liste enthaelt noch keine Elemente.");
        }
        ListNode current = first;
        int i = 0;
        //Die Liste wird durchgegangen, bis ein Element kurz vor dem zu löschenden Element
        while (i < index - 1 && current != null) {
            current = current.next; 
            i++;           
        }
        if(current == null)
        {
            throw new Error("Der Index ist zu groesser als die Liste.");
        }
        if(current.next == null)
        {
            throw new Error("Der Index ist groesser als die Liste.");
        }
        //Ist der Index nicht ausserhalb der Liste wird der Inhalt des zu loeschenden Elements gespeichert
        E content = current.next.element;
        //Das Element wird geloescht, indem das Element davor auf das uebernaechste Element zeigt. 
        current.next = current.next.next;
        if(current.next == null)
        {
            //War das geloeschte current das letzte Element muss der Zeiger last entsprechend angepasst werden.
            last = current;
        }
        //Groesse der Liste wird angepasst:
        size--;
        //Geloeschter Inhalt wird zurueck gegeben
        return content;
    }
}
