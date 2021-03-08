package Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {

    private Array<Integer> integerArray;
    private Array<String> stringArray;

    @Before
    public void setup() {
        integerArray = new Array<Integer>(3);
        stringArray = new Array<String>(2);
    }

    @Test
    public void InsertAnItemToIntegerArray() throws Exception {
        integerArray.insert(1);
        integerArray.insert(2);
        integerArray.insert(3);
        integerArray.insert(4);
    }

    @Test
    public void removeAnItemFromIntegerArray() throws Exception {
        integerArray.insert(1);
        integerArray.insert(1);
        integerArray.insert(2);
        integerArray.insert(2);
        integerArray.insert(2);
        integerArray.removeAt(0);
        integerArray.removeAt(1);
    }

    @Test
    public void CheckInsertionsForIntegerArray() throws Exception {
        integerArray.insert(0);
        integerArray.insert(1);
        integerArray.insert(2);
        integerArray.insert(3);
        integerArray.insert(4);
        integerArray.insert(5);
        integerArray.insert(6);
        Assert.assertEquals("[0, 1, 2, 3, 4, 5, 6]", integerArray.toString());
    }

    @Test
    public void checkDeletionForIntegerArray() throws Exception {
        integerArray.insert(1);
        integerArray.insert(2);
        integerArray.insert(3);
        integerArray.insert(4);
        integerArray.insert(5);
        integerArray.insert(6);
        integerArray.removeAt(0);
        Assert.assertEquals("[2, 3, 4, 5, 6]", integerArray.toString());

    }

    @Test
    public void CheckIndexOfWithBunchOfInsertionAndDeletionForIntegerArray() throws Exception {
        integerArray.insert(0);
        integerArray.insert(1);
        integerArray.insert(2);
        integerArray.insert(3);
        integerArray.removeAt(3);
        integerArray.removeAt(2);
        integerArray.insert(10);
        Assert.assertEquals(1, integerArray.indexOf(1));
        Assert.assertEquals(2, integerArray.indexOf(10));
    }

    @Test
    public void insertionForOtherTypesLikeStringArray() throws Exception {
        bunchOfInsertion();
        Assert.assertEquals("[a, b, c, d]", stringArray.toString());
    }

    @Test
    public void bunchOfInsertionAndDeletionForOtherTypesLikeStringArray() throws Exception {
        bunchOfInsertion();
        stringArray.removeAt(0);
        stringArray.removeAt(0);
        stringArray.removeAt(0);
        stringArray.insert("e");
        stringArray.insert("f");
        Assert.assertEquals("[d, e, f]", stringArray.toString());
    }

    @Test
    public void indexOfStringItemInStringArray() throws Exception {
        bunchOfInsertion();
        stringArray.removeAt(0);
        stringArray.removeAt(0);
        stringArray.removeAt(0);
        stringArray.insert("e");
        stringArray.insert("f");
        Assert.assertEquals(1, stringArray.indexOf("e"));

    }

    @Test
    public void ArrayWithLengthOfZero() throws Exception {
        integerArray.insert(1);
        integerArray.insert(2);
        integerArray.insert(3);
        integerArray.insert(4);
        integerArray.insert(5);
        integerArray.insert(6);
        integerArray.removeAt(0);
        integerArray.removeAt(0);
        integerArray.removeAt(0);
        integerArray.removeAt(0);
        integerArray.removeAt(0);
        integerArray.removeAt(0);
        Assert.assertEquals("[]", integerArray.toString());
    }

    @Test
    public void maximumValueInAnArray() throws Exception {
        integerArray.insert(1);
        integerArray.insert(2);
        integerArray.insert(3);
        integerArray.insert(10);
        integerArray.insert(5);
        integerArray.insert(6);
        Assert.assertEquals("10", integerArray.max().toString());
    }

    @Test
    public void maximumValueInStringArray() throws Exception {
        stringArray.insert("a");
        stringArray.insert("b");
        stringArray.insert("c");
        stringArray.insert("d");
        stringArray.insert("e");
        Assert.assertEquals("e", stringArray.max().toString());
    }

    @Test
    public void checkReverseOfArray() throws Exception {
        integerArray.insert(1);
        integerArray.insert(2);
        integerArray.insert(3);
        Assert.assertEquals("[3, 2, 1]", integerArray.reverse().toString());
    }

    @Test
    public void checkInsertAtInArrayAtFirst() throws Exception {
        integerArray.insertAt(0, 1);
        integerArray.insertAt(0, 2);
        integerArray.insertAt(0, 3);
        integerArray.insertAt(0, 10);
        Assert.assertEquals("[10, 3, 2, 1]", integerArray.toString());
    }

    @Test
    public void checkInsertAtInTheMiddleOfArray() throws Exception {
        integerArray.insertAt(0, 1);
        integerArray.insertAt(1, 2);
        integerArray.insertAt(2, 3);
        integerArray.insertAt(1, 10);

        Assert.assertEquals("[1, 10, 2, 3]", integerArray.toString());
    }

    @Test
    public void checkInsertAtArrayAtLast() throws Exception {

        integerArray.insertAt(0, 1);
        integerArray.insertAt(1, 2);
        integerArray.insertAt(2, 3);
        integerArray.insertAt(3, 10);

        Assert.assertEquals("[1, 2, 3, 10]", integerArray.toString());
    }

    @Test
    public void intersectCheck() throws Exception {
        var integerArray1 = new Array<Integer>(3);
        var integerArray2 = new Array<Integer>(3);
        integerArray1.insert(1);
        integerArray1.insert(2);
        integerArray1.insert(3);
        integerArray1.insert(4);
        integerArray2.insert(1);
        integerArray2.insert(2);
        integerArray2.insert(3);
        integerArray2.insert(4);
        integerArray2.insert(5);
        Assert.assertEquals("[1, 2, 3, 4]", integerArray1.intersect(integerArray2).toString());
    }

    @Test
    public void intersectCheckForStringArray() throws Exception {
        var stringArray1 = new Array<String>(3);
        var stringArray2 = new Array<String>(3);
        stringArray1.insert("a");
        stringArray1.insert("b");
        stringArray1.insert("c");
        stringArray1.insert("d");
        stringArray2.insert("a");
        stringArray2.insert("b");
        stringArray2.insert("c");
        stringArray2.insert("d");
        Assert.assertEquals("[a, b, c, d]", stringArray1.intersect(stringArray2).toString());

    }

    private void bunchOfInsertion() {
        stringArray.insert("a");
        stringArray.insert("b");
        stringArray.insert("c");
        stringArray.insert("d");
    }

}
