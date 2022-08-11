import Exceptions.ArgumentException;
import Exceptions.WrongElementException;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws  WrongElementException {

        ArrayListInteger arrayListInteger = new ArrayListInteger(10);
        Integer[] out = arrayListInteger.toArray();
        Integer [] arr1 = Arrays.copyOf(out,10);
        Integer [] arr2 = Arrays.copyOf(out,10);
        Integer [] arr3 = Arrays.copyOf(out,10);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }


}