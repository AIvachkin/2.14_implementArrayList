import Exceptions.ArgumentException;
import Exceptions.WrongElementException;

import java.util.Arrays;

public class ArrayList implements StringList {

    private int size;
    private String[] arrayList;
    private int indexDefault = 0;


    public ArrayList(int size) throws ArgumentException {
        if (size < 0) {
            throw new ArgumentException("Задана некорректная длина массива");
        }
        arrayList = new String[size];
    }

    @Override
    public String add(String item) throws WrongElementException {
        if (item == null) {
            throw new WrongElementException("Введено нулевое значение элемента массива");
        }
        if (indexDefault == arrayList.length) {
            resize(arrayList.length * 2);
        }
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] == null) {
                arrayList[i] = item;
                indexDefault++;
                return item;
            }


        }
        return item;
    }

    public void resize(int newLength) {
        String[] newArrayList = new String[newLength];
        System.arraycopy(arrayList, 0, newArrayList, 0, arrayList.length);
        arrayList = newArrayList;
    }

    @Override
    public String add(int index, String item) throws WrongElementException {
        if (item == null) {
            throw new WrongElementException("Введено нулевое значение элемента массива");
        }
        if (indexDefault == arrayList.length || arrayList[arrayList.length - 1] != null) {
            resize(arrayList.length * 2);
        }
        if (arrayList[index] == null) {
            arrayList[index] = item;
        } else {
            if (arrayList.length - 1 - index >= 0)
                System.arraycopy(arrayList, index, arrayList, index + 1, arrayList.length - 1 - index);
            arrayList[index] = item;
            indexDefault++;
            return item;
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        return null;
    }

    @Override
    public String remove(String item) {
        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(arrayList);
    }
}
