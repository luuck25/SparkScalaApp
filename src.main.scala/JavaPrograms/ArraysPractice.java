package JavaPrograms;

import java.util.Arrays;

public class ArraysPractice {

    public static void main(String[] args) {

        // diff ways to declare array
        int[] arr= new int[5];
        int arr1[]= new int[5];
        int arr2[]= new int[]{1,2,3,4,5};
        int arr3[]={1,2,3,4,5};

       // access array

       for(int i=0;i<arr3.length;i++)     {     System.out.println("element is "+arr3[i]);
       }

       for (int element: arr3)
       {  System.out.println(element);
       }
       // tostring with Arrays Class
        System.out.println(Arrays.toString(arr3));

       Arrays.stream(arr3).forEach((x)-> System.out.println("Stream for each "+x));



    }
}
