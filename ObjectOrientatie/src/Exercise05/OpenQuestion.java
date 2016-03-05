/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise05;

/**
 * 
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */

public class OpenQuestion extends Question {
    protected String answer;
    
    public OpenQuestion(String question, String answer, int weight){
        super(question, weight);
        this.answer = answer;
        
    }
    
    public OpenQuestion(String question, String answer){
        super(question, 3);
        this.answer = answer;
    }
    
    @Override
    public String toString(){
        return question;
    }
    
    @Override
    public boolean isCorrect(String answer){
        return(answer.equalsIgnoreCase(this.answer));
    }
    
    @Override
    public String correctAnswer() {
        return answer;
    }
    
    @Override
    public OpenQuestion duplicate(){
        return this;
    }
}
