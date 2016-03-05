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


public class TCQuestion extends MCQuestion{
    
    private String question;
    private String[] answers;
    private int correct;
    private int weight;
    
    public TCQuestion(String question, String answer1, String answer2, int correct, int weight){
        super(question,String[] as = [answer1,answer2],correct,weight);
    }
    
    public TCQuestion(String question, String answer1, String answer2, int correct){
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.correct = correct;
        this.weight = 3;
    }
    
    @Override
    public String toString(){
        return question;
    }
    
    @Override
    public boolean isCorrect(String answer){
        return(answer.equalsIgnoreCase(answers[correct]));
    }
    
    @Override
    public String correctAnswer() {
        return answers[correct];
    }
    
}
