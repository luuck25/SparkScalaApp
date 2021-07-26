package JavaPrograms;

import javax.xml.bind.SchemaOutputResolver;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {20,35,-15,7,55,1,-22 };

        for (int firstsortedindex=1;firstsortedindex< arr.length;firstsortedindex++)
        {
            int newElement=arr[firstsortedindex];

            int i;
           for(i=firstsortedindex; i>0 && arr[i-1]>newElement;i-- )
           {

               arr[i]=arr[i-1];

           }

           arr[i]=newElement;


        }

        System.out.println(arr);

    }
}
