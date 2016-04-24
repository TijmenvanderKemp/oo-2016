package Exercise10.polynomials;

import java.util.Collections;
import java.util.Comparator;
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
        Collections.sort(terms, (Term o1, Term o2) -> o1.getExp() - o2.getExp());
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
        Collections.sort(terms, (Term o1, Term o2) -> o1.getExp() - o2.getExp());
    }
    
    /**
     * A straightforward conversion of a Polynomial into a string based on the
     * toString for terms
     *
     * @return a readable string representation of this
     */
    @Override
    public String toString() {
        // Add " + " to each term and reduce to one big string
        String polynomial = "";
        polynomial = terms.stream().map((t) -> t.toString() + " + ").reduce(polynomial, String::concat);
        
        // Strip the last " + "
        if (polynomial.length() >= 3) {
            polynomial = polynomial.substring(0, polynomial.length()-3);
        }
        
        return polynomial;
    }

    public void plus(Polynomial b) {
        // Add up all the terms with the same coefficient
        terms.stream().forEach((termThis) -> {
            b.terms.stream().filter((termB) -> (termThis.getExp() == termB.getExp())).forEach((termB) -> {
                termThis.plus(termB);
            });
        });
        
        // Add all terms from B without a match in This to This
        b.terms.stream().forEach((termB) -> {
            if(terms.stream().noneMatch((termThis) -> (termThis.getExp() == termB.getExp()))) {
                terms.add(termB);
            }
        });
        
        // Remove all terms from This with a coefficient of 0
        terms.stream().filter((tThis) -> (tThis.getCoef() == 0)).forEach((tThis) -> {
            terms.remove(tThis);
        });
        
        // Sort the polynomial
        Collections.sort(terms, (Term o1, Term o2) -> o1.getExp() - o2.getExp());
    }


    public void minus(Polynomial b) {
        List<String> newTerms = new LinkedList<>();
        b.terms.stream().forEach((t) -> {
            newTerms.add(0-t.getCoef() + " " + t.getExp());
        });
        String newTermsString = String.join(" ", newTerms);
        Polynomial negativeB = new Polynomial(newTermsString);
        System.out.println(negativeB);
        System.out.println(this);
        this.plus(negativeB);
        System.out.println(this);
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
