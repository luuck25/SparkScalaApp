package JavaPrograms;

import java.util.Iterator;
import java.util.LinkedList;


public class LinkedlistPratice {

    public static void main(String[] args) {

        // maintains insertion order
        // can have duplicates

        LinkedList<String> l1= new LinkedList<String>();

        l1.add("e");
        l1.addFirst("a");
        l1.addLast("dd");
        l1.add("dd");

        Iterator<String> s =l1.iterator();
        while(s.hasNext())
        {
            System.out.println(s.next());
        }

      //  System.out.println(l1.get(1));
    }
}
