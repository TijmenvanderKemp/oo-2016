/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise05;

/**
 * two choice question
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */


public class TCQuestion extends MCQuestion {
    
    /**
     * constructor of an two choice question
     * @param question question
     * @param answer1 first possible answer
     * @param answer2 second possible answer
     * @param correct number of the correct answer
     * @param weight weight of the question
     */
    public TCQuestion(String question, String answer1, String answer2, int correct, int weight){
        super(question, new String[]{answer1,answer2}, correct, weight);
    }
    
     /**
     * constructor for multiple choice question without specified weight, putting it to the default 3
     * @param question the question
     * @param answer1 the first possible answer
     * @param answer2 the second possible answer
     * @param correct the number of the correct answer
     */
    public TCQuestion(String question, String answer1, String answer2, int correct){
        super(question, new String []{answer1, answer2}, correct);
    }
    
    /**
     * gives a way to output a two choice question
     * @return the two answers following the question
     */
    @Override
    public String toString(){
        return answers[0] + " or " +answers[1] + ":" + question;
    }
    
    /**
     * determines whether a given answer is correct
     * @param answer the answer to check if correct
     * @return whether the answer is the same as the correct answer
     */
    @Override
    public boolean isCorrect(String answer){
        return(answer.equalsIgnoreCase(answers[correct]));
    }
    
    /**
     * gives the correct
     * @return 
     */
    @Override
    public String correctAnswer() {
        return answers[correct];
    }
    
    
    
}
