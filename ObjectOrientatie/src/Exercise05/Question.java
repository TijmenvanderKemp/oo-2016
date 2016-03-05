/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise05;

/**
 * a question
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */


public abstract class Question {
    
    public final int weight; //weight of question
    protected final String question; // the question
    
    /**
     * constructor of question
     * @param q question
     * @param w weight of question
     */
    public Question(String q, int w){
        question = q;
        if(1 <= w && w <= 5){
            weight = w;
        }
        else
            weight = 3;
    }
            
    /**
     * string of question
     * @return the question
     */
    @Override
    public String toString() {
        return question;
    }
    
    /**
     * determines whether a guessed answer is correct
     * @param answer answer to check whether it is correct
     * @return whether the guessed answer is correct
     */
    public abstract boolean isCorrect(String answer);           
    
    /**
     * a way to get the correct answer
     * @return the correct answer
     */
    public abstract String correctAnswer();
    
    /**
     * duplicate a question
     * @return the same question
     */
    public Question duplicate(){
        return this;
    }
    
    /**
     * getter for the weight
     * @return the weight
     */
    public int getPoints() {
        return weight;
    }
    
}
