 Error reading included file Templates/UnitTests/Templates/Licenses/license-object-orientation.txtreading included file Templates/UnitTests/Templates/Licenses/license-object-orientation.txt
package Exercise10.polynomials.polynomial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joep
 */


public class PolynomialTest {
    
    public PolynomialTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Polynomial.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        Polynomial instance = new Polynomial();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plus method, of class Polynomial.
     */
    @org.junit.Test
    public void testPlus() {
        System.out.println("plus");
        Polynomial b = null;
        Polynomial instance = new Polynomial();
        instance.plus(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minus method, of class Polynomial.
     */
    @org.junit.Test
    public void testMinus() {
        System.out.println("minus");
        Polynomial b = null;
        Polynomial instance = new Polynomial();
        instance.minus(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of times method, of class Polynomial.
     */
    @org.junit.Test
    public void testTimes() {
        System.out.println("times");
        Polynomial b = null;
        Polynomial instance = new Polynomial();
        instance.times(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divide method, of class Polynomial.
     */
    @org.junit.Test
    public void testDivide() {
        System.out.println("divide");
        Polynomial b = null;
        Polynomial instance = new Polynomial();
        instance.divide(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Polynomial.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("equals");
        Object other_poly = null;
        Polynomial instance = new Polynomial();
        boolean expResult = false;
        boolean result = instance.equals(other_poly);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
