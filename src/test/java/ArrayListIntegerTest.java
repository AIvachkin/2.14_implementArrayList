import static Constants.ArrayListConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class ArrayListIntegerTest {
    private final ArrayListInteger out = new ArrayListInteger(7);

    @org.junit.jupiter.api.Test
    void shouldReturnAddArray() {
        Integer[] expected = new Integer[]{ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN};
        out.add(1);
        out.add(2);
        out.add(3);
        out.add(4);
        out.add(5);
        out.add(6);
        out.add(7);
        Integer[] actual = out.toArray(7);
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldReturnSortedArray() {
        Integer[] expected = new Integer[]{ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN};
        out.add(1);
        out.add(5);
        out.add(7);
        out.add(3);
        out.add(4);
        out.add(6);
        out.add(2);
        Integer[] actual = out.toArray(7);
        out.sortInsertion(actual);
        assertArrayEquals(expected, actual);
    }


    @org.junit.jupiter.api.Test
    void shouldReturnAddArrayFromIndex() {
        Integer[] expected = new Integer[]{ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN};
        out.add(1);
        out.add(2);
        out.add(4);
        out.add(5);
        out.add(6);
        out.add(7);
        out.add(2, 3);
        Integer[] actual = out.toArray(7);
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldReturnSetFromIndex() {
        Integer[] expected = new Integer[]{ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN};
        out.add(1);
        out.add(2);
        out.add(3);
        out.add(15);
        out.add(5);
        out.add(6);
        out.add(7);
        out.set(3, 4);
        Integer[] actual = out.toArray(7);
        assertArrayEquals(expected, actual);
    }

//    @org.junit.jupiter.api.Test
//    void shouldReturnARemoveElementToArray() {
//        Integer[] expected = new Integer[]{ONE, TWO, THREE, FIVE, SIX, SEVEN};
//        out.add(1);
//        out.add(2);
//        out.add(3);
//        out.add(4);
//        out.add(5);
//        out.add(6);
//        out.add(7);
//        out.remove(4);
//        Integer[] actual = out.toArray(6);
//        assertArrayEquals(expected, actual);
//    }

//    @org.junit.jupiter.api.Test
//    void shouldReturnARemoveElementToIndexArray() {
//        Integer[] expected = new Integer[]{ONE, TWO, THREE, FIVE, SIX, SEVEN};
//        out.add(1);
//        out.add(2);
//        out.add(3);
//        out.add(4);
//        out.add(5);
//        out.add(6);
//        out.add(7);
//        out.removeByIndex(3);
//        Integer[] actual = out.toArray(6);
//        assertArrayEquals(expected, actual);
//    }

    @org.junit.jupiter.api.Test
    void mustCheckTheExistenceOfTheElement() {
        out.add(1);
        out.add(5);
        out.add(7);
        out.add(3);
        out.add(4);
        out.add(6);
        out.add(2);
        Integer[] actual = out.toArray(7);
        out.sortInsertion(actual);

        Boolean actual1 = out.contains(4);
        Boolean actual2 = out.contains(9);
        Boolean expected1 = true;
        Boolean expected2 = false;
        expected1.equals(actual1);
        expected2.equals(actual2);

    }

    @org.junit.jupiter.api.Test
    void shouldReturnIndexOf() {
        out.add(1);
        out.add(5);
        out.add(7);
        out.add(3);
        out.add(4);
        out.add(6);
        out.add(2);
        Integer actual = out.indexOf(2);
        Integer expected = 7;
        actual.equals(expected);
    }

    @org.junit.jupiter.api.Test
    void shouldReturnLastIndexOf() {
        out.add(1);
        out.add(5);
        out.add(7);
        out.add(3);
        out.add(4);
        out.add(6);
        out.add(2);
        Integer actual = out.lastIndexOf(2);
        Integer expected = 7;
        actual.equals(expected);
    }

    @org.junit.jupiter.api.Test
    void shouldGetTheElementByIndex() {
        out.add(1);
        out.add(5);
        out.add(7);
        out.add(3);
        out.add(4);
        out.add(6);
        out.add(2);
        Integer actual = out.get(1);
        Integer expected = FIVE;
        actual.equals(expected);
    }

}