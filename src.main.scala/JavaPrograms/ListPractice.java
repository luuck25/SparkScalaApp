package JavaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListPractice {

    public static void main(String[] args) {

        // maintains insertion order
        // can have duplicates

        // ways to create list
        List<String> l= new ArrayList<String>(); // default capacity 10
        //  List<String> l= new ArrayList<String>(20); // custom capacity
        ArrayList<String> l2= new ArrayList<String>();
        List<String> l3 = new ArrayList<String>(){{add("a");add("n");}};
        List<String> l4= new ArrayList<String>(Arrays.asList("a","b"));
        l.add("a");

        // access list
        for(int i=0;i<l4.size();i++)
        {
            System.out.println(l4.get(i));

        }

        for (String element: l4)
        {
            System.out.println(" element is "+element);
        }

        l4.forEach((x) -> System.out.println(x));



    }
}
