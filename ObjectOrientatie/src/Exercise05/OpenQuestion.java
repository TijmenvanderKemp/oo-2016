/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise05;

/**
 * an open question
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */

public class OpenQuestion extends Question {
    private String question; // the question
    private String answer; // the answer
    private int weight; //weight of the question
    
    /**
     * constructor for open question
     * @param question the question
     * @param answer the answer
     * @param weight the weight of the question if between 1 and 5 else default is 3
     */
    public OpenQuestion(String question, String answer, int weight){
        super(question, weight);
        this.answer = answer;
        
    }
    
     /**
     * constructor for multiple choice question without specified weight, putting it to the default 3
     * @param question the question
     * @param answer the correct answer
     */
    public OpenQuestion(String question, String answer){
        super(question, 3);
        this.answer = answer;
    }
    
    /**
     * a string of an open question
     * @return the question
     */
    @Override
    public String toString(){
        return question;
    }
    
    /**
     * determines whether the given answer is correct
     * @param answer the answer to check if correct
     * @return whether the given answer equals the correct answer.
     */
    @Override
    public boolean isCorrect(String answer){
        return(answer.equalsIgnoreCase(this.answer));
    }
    
    /**
     * gives the correct answer
     * @return the correct answer
     */
    @Override
    public String correctAnswer() {
        return answer;
    }
    
    /**
     * duplicates the open question
     * @return the same question
     */
    @Override
    public OpenQuestion duplicate(){
        return this;
    }
}
