import Exceptions.ArgumentException;
import Exceptions.WrongElementException;

public class Main {
    public static void main(String[] args) throws ArgumentException, WrongElementException {

        ArrayList arrayList = new ArrayList(  4);

        arrayList.add("Earth");
        arrayList.add(3, "Moon");
        arrayList.add(3, "Water");
        arrayList.add("Star");
//        arrayList.add(null);

//        System.out.println("arrayList.add(\"Earth\") = " + arrayList.add("Earth"));
//
//        System.out.println("arrayList.add(0,\"Man\") = " + arrayList.add(0, "Man"));

        System.out.println("arrayList = " + arrayList);
    }


}