 Error reading included file Templates/UnitTests/Templates/Licenses/license-object-orientation.txtreading included file Templates/UnitTests/Templates/Licenses/license-object-orientation.txt
package Exercise10.polynomials.polynomial;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Joep
 */


@org.junit.runner.RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({PolynomialTest.class, TermTest.class})
public class PolynomialSuite {

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    
}
