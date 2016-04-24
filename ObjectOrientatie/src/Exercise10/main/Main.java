package Exercise10.main;

import Exercise10.polynomials.Polynomial;

/**
 *
 * @author Sjaak Smetsers
 */
public class Main {

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial("1 2 1 0");
        Polynomial p2 = new Polynomial("4 1 3 0");
        Polynomial p3 = new Polynomial("4 3 3 2 4 1 3 0");
        Polynomial p4 = new Polynomial( "6 1" );
        
        p1.times(p2);

        System.out.println( p1 );
        System.out.println( p2 );
        System.out.println( p3 );
        System.out.println( p4 );
        
        System.out.println(p1.apply(2));
   }

}
