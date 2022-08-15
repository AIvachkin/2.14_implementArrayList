import static Constants.ArrayListConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    private final ArrayList out = new ArrayList();

    @org.junit.jupiter.api.Test
    void shouldReturnAddArray() {
        String[] expected = new String[]{FIRST, SECOND, THIRD, FOURTH, FIFTH};
        out.add(FIRST);
        out.add(SECOND);
        out.add(THIRD);
        out.add(FOURTH);
        out.add(FIFTH);
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldReturnAddArrayFromIndex() {
        String[] expected = new String[]{FIRST, SECOND, THIRD, FOURTH, FIFTH};
        out.add(FIRST);
        out.add(SECOND);
        out.add(FOURTH);
        out.add(FIFTH);
        out.add(2,THIRD);
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }


    @org.junit.jupiter.api.Test
    void shouldReturnSetFromIndex() {
        String[] expected = new String[]{FIRST, SECOND, THIRD, FOURTH, FIFTH};
        out.add(FIRST);
        out.add(SECOND);
        out.add("Moscow");
        out.add(FOURTH);
        out.add(FIFTH);
        out.set(2,THIRD);
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldReturnARemoveElementToArray() {
        String[] expected = new String[]{FIRST, FOURTH, FIFTH};
        out.add(FIRST);
        out.add(SECOND);
        out.add(FOURTH);
        out.add(FIFTH);
        out.remove(SECOND);
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldReturnARemoveElementToIndexArray() {
        String[] expected = new String[]{FIRST, FOURTH, FIFTH};
        out.add(FIRST);
        out.add(SECOND);
        out.add(FOURTH);
        out.add(FIFTH);
        out.remove(1);
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void mustCheckTheExistenceOfTheElement() {
        out.add(FIRST);
        out.add(SECOND);
        out.add(THIRD);
        out.add(FOURTH);
        out.add(FIFTH);
        Boolean actual1 = out.contains(SECOND);
        Boolean actual2 = out.contains("Moscow");
        Boolean expected1 = true;
        Boolean expected2 = false;
        expected1.equals(actual1);
        expected2.equals(actual2);

    }

    @org.junit.jupiter.api.Test
    void shouldReturnIndexOf() {
        out.add(FIRST);
        out.add(SECOND);
        out.add(THIRD);
        out.add(FOURTH);
        out.add(FIFTH);
        Integer actual = out.indexOf(THIRD);
        Integer expected = 2;
        actual.equals(expected);
    }

    @org.junit.jupiter.api.Test
    void shouldReturnLastIndexOf() {
        out.add(FIRST);
        out.add(SECOND);
        out.add(THIRD);
        out.add(FOURTH);
        out.add(FIFTH);
        Integer actual = out.indexOf(THIRD);
        Integer expected = 2;
        actual.equals(expected);
    }

    @org.junit.jupiter.api.Test
    void shouldGetTheElementByIndex() {
        out.add(FIRST);
        out.add(SECOND);
        out.add(THIRD);
        out.add(FOURTH);
        out.add(FIFTH);
        String actual = out.get(2);
        String expected = THIRD;
        actual.equals(expected);
    }

    @org.junit.jupiter.api.Test
    void mustCompareTwoArrays() {
        String[] expectedStr = new String[]{FIRST, SECOND, THIRD, FOURTH, FIFTH};
        out.add(FIRST);
        out.add(SECOND);
        out.add(THIRD);
        out.add(FOURTH);
        out.add(FIFTH);
        Boolean expected = true;
        String[] actualStr = out.toArray();
        Boolean actual = expectedStr.equals(actualStr);
        actual.equals(expected);
    }

    @org.junit.jupiter.api.Test
    void mustReturnTheSize() {
        out.add(FIRST);
        out.add(SECOND);
        out.add(THIRD);
        out.add(FOURTH);
        out.add(FIFTH);
        Integer expected = 5;
        Integer actual = out.size();
        actual.equals(expected);
    }

    @org.junit.jupiter.api.Test
    void mustCheckForMissingElements() {
        out.add(FIRST);
        out.add(SECOND);
        out.add(THIRD);
        out.add(FOURTH);
        out.add(FIFTH);
        String[] actualStr = out.toArray();
        Boolean expected = false;
        Boolean actual = out.isEmpty();
        actual.equals(expected);
    }

}