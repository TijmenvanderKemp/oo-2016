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

public class MCQuestion extends Question {
    
    protected String[] answers;
    protected int correct;
    
    public MCQuestion(String question, String[] answers, int correct, int weight){
        super(question, weight);
        this.answers = answers;
        this.correct = correct;
        
    }
    
    public MCQuestion(String question, String[] answers, int correct){
        super(question, 3);
        this.answers = answers;
        this.correct = correct;
        
    }
    
    @Override
    public String toString(){
        String output = question;
        for(String answer:answers){
            output += '\n' + answer;
        }
        return output;
    }
    
    @Override
    public boolean isCorrect(String answer){
        return Integer.parseInt(answer) == correct;
    }
    
    @Override
    public String correctAnswer() {
        return answers[correct];
    }
    
}
