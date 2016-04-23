package Exercise10.polynomials;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * A skeleton class for representing Polynomials
 *
 * @author Sjaak Smetsers
 * @date 19-04-2016
 */
public class Polynomial {

    /**
     * A polynomial is a sequence of terms here kept in an List
     */
    List<Term> terms;

    /**
     * A constructor for creating the zero Polynomial zero is presented as an
     * empty list of terms and not as a single term with 0 as a coefficient
     */
    public Polynomial() {
        terms = new LinkedList<>();
    }

    /**
     * A Constructor creating a polynomial from the argument string.
     *
     * @param s a String representing a list of terms which is converted to a
     * scanner and passed to scanTerm for reading each individual term
     */
    public Polynomial( String s ) {
        terms = new LinkedList<>();
        Scanner scan = new Scanner( s );

        for (Term t = Term.scanTerm(scan); t != null; t = Term.scanTerm(scan)) {
            terms.add(t);
        }
    }

    /**
     * The copy constructor for making a deep copy
     *
     * @param p the copied polynomial
     *
     */
    public Polynomial( Polynomial p ) {
        terms = new LinkedList<>();
        for (Term t : p.terms) {
            terms.add(new Term(t));
        }
    }
    
    /**
     * A straightforward conversion of a Polynomial into a string based on the
     * toString for terms
     *
     * @return a readable string representation of this
     */
    @Override
    public String toString() {
        String polynomial = "";
        for(Term t : terms){
            polynomial += t.toString();
        }
        return polynomial;
    }

    public void plus(Polynomial b) {
        for(Term t1 : terms){
            for(Term t2 : b.terms){
                if (t1.getExp() == t2.getExp()){
                    t1.plus(t2);
                }
            }
                
        }
        for(Term t3 : b.terms){
            for(Term t4 : terms){
                if (t3.getExp() == t4.getExp()){
                    break;
                }
            }
                
        }
    }


    public void minus(Polynomial b) {
        for(Term t1 : terms){
            for(Term t2 : b.terms){
                if (t1.getExp() == t2.getExp()){
                    Term t3 = new Term(-t2.getCoef(), t2.getExp());
                    t1.plus(t3);
                }
            }
                
        }
    }


    public void times(Polynomial b) {
    }

    public void divide(Polynomial b) {
    }

    @Override
    public boolean equals(Object other_poly) {
        return false;
    }

}
