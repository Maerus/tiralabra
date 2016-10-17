/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Incognito
 */
public class MinMathTest {
    
    public MinMathTest() {
    }

    /**
     * Test of intAbs method, of class MinMath.
     */
    @Test
    public void testIntAbs() {
        int a = MinMath.intAbs(-123);
        int b = MinMath.intAbs(0);
        int c = MinMath.intAbs(4);
        assertEquals(123, a);
        assertEquals(0, b);
        assertEquals(4, c);
    }

    /**
     * Test of intMin method, of class MinMath.
     */
    @Test
    public void testIntMin() {
        int a = MinMath.intMin(12, 24);
        int b = MinMath.intMin(-12, 24);
        int c = MinMath.intMin(-12, -24);
        assertEquals(12, a);
        assertEquals(-12, b);
        assertEquals(-24, c);
    }
    
}
