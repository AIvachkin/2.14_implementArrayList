import Exceptions.ArgumentException;
import Exceptions.IndexOutOfBoundExceptions;
import Exceptions.WrongElementException;

public class Main {
    public static void main(String[] args) throws ArgumentException, WrongElementException, IndexOutOfBoundExceptions {

        ArrayList arrayList = new ArrayList(5);


        arrayList.add("Earth");
        arrayList.add(3, "Moon");
        arrayList.add(3, "Water");
        arrayList.set(2,"Monkey");
//        arrayList.add("Star");
//        arrayList.add(null);

//        System.out.println("arrayList.add(\"Earth\") = " + arrayList.add("Earth"));
//
//        System.out.println("arrayList.add(0,\"Man\") = " + arrayList.add(0, "Man"));

        System.out.println("arrayList = " + arrayList);
        arrayList.set(1, "Fruit");
        System.out.println("arrayList = " + arrayList);
        arrayList.remove("Moon");
        System.out.println("arrayList = " + arrayList);
//        arrayList.remove(3);
        System.out.println("arrayList = " + arrayList);
//        arrayList.add("Fruits");
//        arrayList.add("Monkey");
//        arrayList.add("Donkey");
//        arrayList.add("Fan");
//        arrayList.add("Man");
        System.out.println("arrayList = " + arrayList);
        System.out.println("arrayList.contains(\"Woman\") = " + arrayList.contains("Woman"));
//        System.out.println("arrayList.indexOf(\"Fan\") = " + arrayList.indexOf("Fan"));
        System.out.println("arrayList.lastIndexOf(\"Donkey\") = " + arrayList.lastIndexOf("Donkey"));
        System.out.println("arrayList.get(2) = " + arrayList.get(2));
//        arrayList.get(20);
        System.out.println(arrayList);
    }


}