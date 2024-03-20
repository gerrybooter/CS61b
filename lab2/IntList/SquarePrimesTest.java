package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSimple2() {
        IntList lst = IntList.of(14, 15, 16, 17, 18, 7, 2);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18 -> 49 -> 4", lst.toString());
        assertTrue(changed);

    }
    @Test
    public void testSquarePrimesSimple3() {
        IntList lst = IntList.of(14, 15, 16, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 18", lst.toString());
        assertTrue(!changed);
    }

    @Test
    public void testSquarePrimesSimple4() {
        IntList lst = IntList.of(3, 8);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("9 -> 8", lst.toString());
        assertTrue(changed);
    }
    @Test
    public void testSquarePrimesSimple5() {
        IntList lst = IntList.of(2, 2, 2, 3, 3, 3, 3);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 4 -> 4 -> 9 -> 9 -> 9 -> 9", lst.toString());
        assertTrue(changed);

    }
    @Test
    public void testSquarePrimesSimple6() {
        IntList lst = IntList.of(4, 15, 16, 10, 18, 6, 9, 8, 2);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 15 -> 16 -> 10 -> 18 -> 6 -> 9 -> 8 -> 4", lst.toString());
        assertTrue(changed);
    }
}
