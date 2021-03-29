package pl.edu.pw.pik.pikactivitytrackerserver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SampleClassTest {

    @Test
    public void testTwoPlusTwoEqualsFour(){
        Integer number1 = 2;
        Integer number2 = 2;
        assertEquals(4, SampleClass.addTwoIntegers(number1,number2));
    }

}