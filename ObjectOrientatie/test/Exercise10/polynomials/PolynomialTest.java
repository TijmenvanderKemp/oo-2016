/*
 * Created by Joep Veldhoven and Tijmen van der Kemp for the course Object Orientation 2016
 * Joep Veldhoven - s4456556
 * Tijmen van der Kemp - s4446887
 */
package Exercise10.polynomials;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * 
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
    @Test
    public void testToString() {
        System.out.println("toString");
        Polynomial instance = new Polynomial("1 0 1 2");
        String expResult = "1.000000 + 1.000000x^2";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of plus method, of class Polynomial.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Polynomial p1 = new Polynomial("1 2 1 0");
        Polynomial p2 = new Polynomial("4 1 3 0");
        Polynomial p3 = new Polynomial("1 2 4 1 4 0");
        Polynomial p4 = new Polynomial(p1);
        Polynomial p5 = new Polynomial(p2);
        Polynomial p6 = new Polynomial(p3);
        Polynomial p7 = new Polynomial(p1);
        Polynomial p8 = new Polynomial(p2);
        Polynomial p9 = new Polynomial(p3);
        Polynomial p10 = new Polynomial(p1);
        Polynomial p11 = new Polynomial(p2);
        Polynomial p12 = new Polynomial(p1);
        Polynomial p13 = new Polynomial(p2);
        p1.plus(p2);
        assertEquals(p1,p3);
        p4.plus(p5);
        p4.plus(p6);
        p8.plus(p9);
        p7.plus(p8);
        assertEquals(p4,p7);
        p10.plus(p11);
        p13.plus(p12);
        assertEquals(p13,p10);
    }

    /**
     * Test of minus method, of class Polynomial.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        Polynomial p1 = new Polynomial("1 2 4 1 4 0");
        Polynomial p2 = new Polynomial("1 2 1 0");
        Polynomial p3 = new Polynomial("4 1 3 0");
        p1.minus(p2);
        assertEquals(p1,p3);
        
    }

    /**
     * Test of times method, of class Polynomial.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        Polynomial p1 = new Polynomial("1 2 1 0");
        Polynomial p2 = new Polynomial("4 1 3 0");
        Polynomial p3 = new Polynomial("4 3 3 2 4 1 3 0");
        Polynomial p4 = new Polynomial(p1);
        Polynomial p5 = new Polynomial(p2);
        Polynomial p6 = new Polynomial(p3);
        Polynomial p7 = new Polynomial(p1);
        Polynomial p8 = new Polynomial(p2);
        Polynomial p9 = new Polynomial(p3);
        Polynomial p10 = new Polynomial(p1);
        Polynomial p11 = new Polynomial(p2);
        Polynomial p12 = new Polynomial(p1);
        Polynomial p13 = new Polynomial(p2);
        p1.times(p2);
        assertEquals(p1,p3);
        p4.times(p5);
        p4.times(p6);
        p8.times(p9);
        p7.times(p8);
        assertEquals(p4,p7);
        p10.times(p11);
        p13.times(p12);
        assertEquals(p13,p10);
    }

    /**
     * Test of divide method, of class Polynomial.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        Polynomial b = null;
        Polynomial instance = new Polynomial();
        instance.divide(b);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class Polynomial.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Polynomial p1 = new Polynomial("1 2 1 1");
        Polynomial p2 = new Polynomial("1 1 1 2");
        assertEquals(true,p1.equals(p1));
        assertEquals(true,p1.equals(p2));
    }
    
    /**
     * Test of distributivity.
     */
    @Test
    public void testDistributivity() {
        System.out.println("distributivity");
        Polynomial p1 = new Polynomial("1 2 1 0");
        Polynomial p2 = new Polynomial("4 1 3 0");
        Polynomial p3 = new Polynomial("5 2 3 1");
        
        Polynomial pa = new Polynomial(p1);
        pa.plus(p2);
        pa.times(p3);
        
        Polynomial px = new Polynomial(p3);
        px.times(p1);
        Polynomial py = new Polynomial(p3);
        py.times(p2);
        px.plus(py);
        
        assertEquals(pa, px);
    }
    
    /**
     * Test of apply method, of class Polynomial.
     */
    @Test
    public void testApply() {
        System.out.println("apply");
        Polynomial p1 = new Polynomial("4 3 3 2 4 1 3 0");
        double expected = 55.0;
        assertEquals(p1.apply(2), expected, 0.0);
    }
    
}
