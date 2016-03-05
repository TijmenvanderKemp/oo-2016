/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise05;

import java.util.Random;

/**
 * 
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */

public class MCQuestion extends Question {
    
    private String question;
    private String[] answers;
    private int correct;
    private int weight;
    
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
    
    @Override
    public MCQuestion duplicate(){
        Random random = new Random();
        int shift = random.nextInt(answers.length);
        String [] newAnswers = new String [answers.length];
        for (int i = 0; i < answers.length; i ++) {
            newAnswers[(i + shift) % answers.length] = answers[i];
        }
        return new MCQuestion (
                this.question,
                newAnswers,
                (this.correct + shift) % answers.length,
                this.weight
        );
    }
    
}
