import Exceptions.*;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList implements StringList {

    private int size;
    private String[] arrayList;
//    private int indexDefault = 0;


    public ArrayList() {
        arrayList = new String[5];
    }


    public ArrayList(int size) throws ArgumentException {
        if (size < 0) {
            throw new ArgumentException("Задана некорректная длина массива");
        }
        arrayList = new String[size];
    }

    @Override
    public String add(String item) {
//        if (item == null) {
//            throw new WrongElementException("Введено нулевое значение элемента массива");
//        }
//        for (int i = 0; i < arrayList.length; i++) {
//            if (arrayList[i] == null) {
//                arrayList[i] = item;
//                indexDefault++;
//                return item;

        validateSize();
        validateItem(item);
        arrayList[size++] = item;
        return item;
    }

//    int tempIndex = arrayList.length;
//
//    resize(arrayList.length *2);
//
//    arrayList[tempIndex]=item;
//        return item;


    public void resize(int newLength) {
        String[] newArrayList = new String[newLength];
        System.arraycopy(arrayList, 0, newArrayList, 0, arrayList.length);
        arrayList = newArrayList;
    }

    @Override
    public String add(int index, String item) {
//        if (item == null) {
//            throw new WrongElementException("Введено нулевое значение элемента массива");
//        }
//        if (index > arrayList.length - 1) {
//            throw new IndexOutOfBoundExceptions("Индекс выходит за пределы массива");
//        }
//
//        if (indexDefault == arrayList.length || arrayList[arrayList.length - 1] != null) {
//            resize(arrayList.length * 2);
//        }
//        if (arrayList[index] == null) {
//            arrayList[index] = item;
//        } else {
//            if (arrayList.length - 1 - index >= 0)
//                System.arraycopy(arrayList, index, arrayList, index + 1, arrayList.length - 1 - index);
//            arrayList[index] = item;
//            indexDefault++;
//            return item;
//        }
        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size) {
            arrayList[size++] = item;
            return item;
        }
        System.arraycopy(arrayList, index, arrayList, index + 1, size - index);
        arrayList[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);

        arrayList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
//        if (item == null) {
//            throw new WrongElementException("Введено нулевое значение элемента массива");
//        }
//
//        for (int i = 0; i < arrayList.length; i++) {
//            if (Objects.equals(arrayList[i], item)) {
//                String[] newArrayList = new String[arrayList.length - 1];
//                for (int j = 0; j < i; j++) {
//                    newArrayList[j] = arrayList[j];
//                }
//                for (int j = i + 1; j < newArrayList.length; j++) {
//                    newArrayList[j - 1] = arrayList[j];
//                }
//                arrayList = newArrayList;
//                indexDefault--;
        validateItem(item);

        int index = indexOf(item);
        if (index == -1) {
            throw new WrongElementException();
        }
//        if (index != size) {
//            System.arraycopy(arrayList, index + 1, arrayList, index, size - index);
//        }
//        size--;
        return remove(index);
//
    }

    @Override
    public String remove(int index) {

//        if (arrayList[index] != null) {
//            String item = arrayList[index];
//            String[] newArrayList = new String[arrayList.length - 1];
//            if (index != arrayList.length - 1 && index != 0) {
//                for (int j = 0; j < index; j++) {
//                    newArrayList[j] = arrayList[j];
//                }
//                for (int j = index + 1; j < newArrayList.length; j++) {
//                    newArrayList[j - 1] = arrayList[j];
//                }
//            } else if (index == 0) {
//                System.arraycopy(arrayList, 1, newArrayList, 0, arrayList.length - 1);
//
//            } else if (index == arrayList.length - 1) {
//                System.arraycopy(arrayList, 0, newArrayList, 0, arrayList.length - 1);
//            } else {
//                throw new IndexOutOfBoundExceptions("Элемента с таким индексом нет в списке");
//            }
//            arrayList = newArrayList;
////            indexDefault--;
//            return item;
//        }
//        return null;
        validateIndex(index);

        String item = arrayList[index];
        if (index != size) {
            System.arraycopy(arrayList, index + 1, arrayList, index, size - index);
        }
        size--;
        return item;
//
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) > -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return arrayList[index];
    }

    @Override
    public boolean equals(StringList otherList) throws ArgumentException {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
//        arrayList = new String[0];
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(arrayList, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(arrayList);
    }

    private void validateItem(String item) throws WrongElementException {
        if (item == null) {
            throw new WrongElementException("Введено нулевое значение элемента массива");
        }
    }

    private void validateSize() {
        if (size == arrayList.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

}
