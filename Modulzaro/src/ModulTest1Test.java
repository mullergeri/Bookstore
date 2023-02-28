import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModulTest1Test {

    @Test
    void getLastNumber_emptyArray() {
        int expected = -1;
        int actual = ModulTest1.getLastNumber(new int[0]);
        assertEquals(expected, actual);
    }

    @Test
    void countEvenNumbers_emptyArray() {
        int expected = -1;
        int actual = ModulTest1.countEvenNumbers(new int[0]);
        assertEquals(expected, actual);
    }

    @Test
    void findNumber_emptyArray() {
        int expected = -1;
        int actual = ModulTest1.findNumber(new int[0], 1);
        assertEquals(expected, actual);
    }

    @Test
    void countSameNumbers_emptyArray() {
        int expected = -1;
        int actual = ModulTest1.countSameNumbers(new int[0], new int[0]);
        assertEquals(expected, actual);
    }

    @Test
    void findMaxIndex_emptyArray() {
        int expected = -1;
        int actual = ModulTest1.findMaxIndex(new int[0]);
        assertEquals(expected, actual);
    }


    @Test
    void willWizardsBeTogether_shouldReturnTrue() {
        assertTrue(ModulTest1.willWizardsBeTogether(1,1,1,1));
    }


    @Test
    void willWizardsBeTogether_shouldReturnFalse() {
        assertFalse(ModulTest1.willWizardsBeTogether(2,2,5,3));
    }

    @Test
    void findTheOneSock_scenario1() {
        int expected = 20;
       int actual = ModulTest1.findTheOneSock(new int[] {30,20,30,30,30,40,40});
       assertEquals(expected, actual);

    }
}