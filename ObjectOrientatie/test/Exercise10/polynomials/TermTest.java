/*
 * Created by Joep Veldhoven and Tijmen van der Kemp for the course Object Orientation 2016
 * Joep Veldhoven - s4456556
 * Tijmen van der Kemp - s4446887
 */
package Exercise10.polynomials;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tijmen
 */
public class TermTest {
    
    public TermTest() {
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
     * Test of getExp method, of class Term.
     */
    @Test
    public void testGetExp() {
        System.out.println("getExp");
        Term instance = null;
        int expResult = 0;
        int result = instance.getExp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoef method, of class Term.
     */
    @Test
    public void testGetCoef() {
        System.out.println("getCoef");
        Term instance = null;
        double expResult = 0.0;
        double result = instance.getCoef();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plus method, of class Term.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Term t1 = new Term(2,3);
        Term t2 = new Term(3,3);
        Term t3 = new Term(5,3);
        Term t4 = new Term(t1);
        Term t5 = new Term(t2);
        Term t6 = new Term(t3);
        Term t7 = new Term(t1);
        Term t8 = new Term(t1);
        Term t9 = new Term(t1);
        Term t10 = new Term(t2);
        Term t11 = new Term (t2);
        t1.plus(t2);
        assertEquals(t1,t3);
        t4.plus(t2);
        t4.plus(t3);
        t5.plus(t6);
        t7.plus(t5);
        assertEquals(t4,t7);
        t8.plus(t10);
        t11.plus(t9);
        assertEquals(t8,t11);
        
        
    }

    /**
     * Test of times method, of class Term.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        Term t1 = new Term(2,3);
        Term t2 = new Term(3,3);
        Term t3 = new Term(6,6);
        Term t4 = new Term(t1);
        Term t5 = new Term(t2);
        Term t6 = new Term(t3);
        Term t7 = new Term(t1);
        Term t8 = new Term(t1);
        Term t9 = new Term(t1);
        Term t10 = new Term(t2);
        Term t11 = new Term (t2);
        t1.times(t2);
        assertEquals(t1,t3);
        t4.times(t2);
        t4.times(t3);
        t5.times(t6);
        t7.times(t5);
        assertEquals(t4,t7);
        t8.times(t10);
        t11.times(t9);
        assertEquals(t8,t11);
    }

    /**
     * Test of toString method, of class Term.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Term instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Term.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object may_be_term = null;
        Term instance = null;
        boolean expResult = false;
        boolean result = instance.equals(may_be_term);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scanTerm method, of class Term.
     */
    @Test
    public void testScanTerm() {
        System.out.println("scanTerm");
        Scanner s = null;
        Term expResult = null;
        Term result = Term.scanTerm(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
