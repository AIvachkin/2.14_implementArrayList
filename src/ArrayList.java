import Exceptions.ArgumentException;
import Exceptions.IndexOutOfBoundExceptions;
import Exceptions.WrongElementException;

import java.util.Arrays;
import java.util.Objects;

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
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] == null) {
                arrayList[i] = item;
                indexDefault++;
                return item;
            }
        }
        int tempIndex = arrayList.length;
        resize(arrayList.length * 2);
        arrayList[tempIndex] = item;
        return item;
    }


    public void resize(int newLength) {
        String[] newArrayList = new String[newLength];
        System.arraycopy(arrayList, 0, newArrayList, 0, arrayList.length);
        arrayList = newArrayList;
    }

    @Override
    public String add(int index, String item) throws WrongElementException, IndexOutOfBoundExceptions {
        if (item == null) {
            throw new WrongElementException("Введено нулевое значение элемента массива");
        }
        if (index > arrayList.length - 1) {
            throw new IndexOutOfBoundExceptions("Индекс выходит за пределы массива");
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
    public String set(int index, String item) throws WrongElementException, IndexOutOfBoundExceptions {
        if (index > arrayList.length - 1) {
            throw new IndexOutOfBoundExceptions("Индекс выходит за пределы массива");
        }
        if (item == null) {
            throw new WrongElementException("Введено нулевое значение элемента массива");
        }
        arrayList[index] = item;

        return item;
    }

    @Override
    public String remove(String item) throws WrongElementException {
        if (item == null) {
            throw new WrongElementException("Введено нулевое значение элемента массива");
        }

        for (int i = 0; i < arrayList.length; i++) {
            if (Objects.equals(arrayList[i], item)) {
                String[] newArrayList = new String[arrayList.length - 1];
                for (int j = 0; j < i; j++) {
                    newArrayList[j] = arrayList[j];
                }
                for (int j = i + 1; j < newArrayList.length; j++) {
                    newArrayList[j - 1] = arrayList[j];
                }
                arrayList = newArrayList;
                indexDefault--;
                return item;
//            } else {
            }
        }
        throw new WrongElementException("Такого элемента нет в списке");
//        return item;
    }

    @Override
    public String remove(int index) throws IndexOutOfBoundExceptions {

        if (arrayList[index] != null) {
            String item = arrayList[index];
            String[] newArrayList = new String[arrayList.length - 1];
            if (index != arrayList.length - 1 && index != 0) {
                for (int j = 0; j < index; j++) {
                    newArrayList[j] = arrayList[j];
                }
                for (int j = index + 1; j < newArrayList.length; j++) {
                    newArrayList[j - 1] = arrayList[j];
                }
            } else if (index == 0) {
                System.arraycopy(arrayList, 1, newArrayList, 0, arrayList.length - 1);

            } else if (index == arrayList.length - 1) {
                System.arraycopy(arrayList, 0, newArrayList, 0, arrayList.length - 1);
            } else {
                throw new IndexOutOfBoundExceptions("Элемента с таким индексом нет в списке");
            }
            arrayList = newArrayList;
            indexDefault--;
            return item;
        }
        return null;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < arrayList.length; i++) {
            if (Objects.equals(arrayList[i], item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < arrayList.length; i++) {
            if (Objects.equals(arrayList[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = arrayList.length - 1; i > 0; i--) {
            if (Objects.equals(arrayList[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) throws IndexOutOfBoundExceptions {
        if (index <= arrayList.length - 1) {
            return arrayList[index];
        } else {
            throw new IndexOutOfBoundExceptions("Нет элемента с таким индексом");
        }
    }

    @Override
    public boolean equals(StringList[] otherList) throws WrongElementException {
//        if (otherList == null) {
//            throw new WrongElementException("Введен нулевоЙ массив");
//        }
        Boolean result = Arrays.equals(otherList, arrayList);
        return false;

    }

    @Override
    public int size() {
        return arrayList.length;
    }

    @Override
    public boolean isEmpty() {
        if (arrayList.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
arrayList = new String[0];
    }

    @Override
    public String[] toArray() throws ArgumentException {
        String [] arr = new String[5];
        return arr;
    }

    @Override
    public String toString() {
        return Arrays.toString(arrayList);
    }
}
