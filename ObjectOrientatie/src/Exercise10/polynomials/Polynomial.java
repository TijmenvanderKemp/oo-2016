package Exercise10.polynomials;

import static java.lang.Math.pow;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        // Sort the polynomial
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
        // Sort the polynomial
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

    /**
     * adds a polynomial to this polynomial
     * @param b the polynomial to be added
     */
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
        terms = terms.stream().filter((tThis) -> (tThis.getCoef() != 0)).collect(Collectors.toList());
        
        // Sort the polynomial
        Collections.sort(terms, (Term o1, Term o2) -> o1.getExp() - o2.getExp());
    }


    /**
     * Subtracts a polynomial from this polynomial
     * @param b the polynomial to be subtracted
     */
    public void minus(Polynomial b) {
        List<String> negativeTerms = new LinkedList<>();
        b.terms.stream().forEach((t) -> {
            negativeTerms.add(0-t.getCoef() + " " + t.getExp());
        });
        Polynomial negativeB = new Polynomial(String.join(" ", negativeTerms));
        this.plus(negativeB);
        // Polynomial is already sorted since this.plus() was called
    }


    /**
     * multiplies a polynomial by this polynomial
     * @param b the polynomial to be multiplied with
     */
    public void times(Polynomial b) {
        List<Polynomial> polyList = new LinkedList<>();
        
        // Multiply each term from this polynomial with the whole list of terms of b.
        terms.stream().forEach((termThis) -> {
            List<Term> termList = new LinkedList<>();
            b.terms.stream().forEach((termB) -> {
               termList.add(new Term(termThis.getCoef() * termB.getCoef(),
                                     termThis.getExp()  + termB.getExp()));
            });
            Polynomial newPoly = new Polynomial();
            newPoly.terms = termList;
            polyList.add(newPoly);
        });
        
        // Reduce the list of polynomials to 1 polynomial by adding them together.
        Polynomial finalPolynomial = new Polynomial();
        polyList.stream().forEach((p) -> {
            finalPolynomial.plus(p);
        });
        
        this.terms = finalPolynomial.terms;
        
        // Sort the polynomial
        Collections.sort(terms, (Term o1, Term o2) -> o1.getExp() - o2.getExp());
    }

    public void divide(Polynomial b) {
    }

    @Override
    public boolean equals(Object other_poly) {
        return this.toString().equals(other_poly.toString());
    }
    
    /**
     * Calculates the value of the polynomial with a given input
     * @param in the given input variable
     * @return the value of the polynomial with the given input
     */
    public double apply (double in) {
        double result = 0;
        for (Term t : terms) {
            result += t.getCoef()*pow(in, t.getExp());
        }
        return result;
    }

}
