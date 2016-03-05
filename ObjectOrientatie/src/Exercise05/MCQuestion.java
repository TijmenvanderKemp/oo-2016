/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise05;

import java.util.Random;

/**
 * a multiple choice question
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */

public class MCQuestion extends Question {
    
    private String question; // the question
    private String[] answers; // the possible answers
    private int correct; // the number of the correct answer
    private int weight; // weight of the question
    
    /**
     * constructor for multiple choice question
     * @param question the question
     * @param answers the possible answers
     * @param correct the number of the correct answer
     * @param weight the weight of the question if between 1 and 5 else default is 3
     */
    public MCQuestion(String question, String[] answers, int correct, int weight){
        super(question, weight);
        this.answers = answers;
        this.correct = correct;
        
    }
    
    /**
     * constructor for multiple choice question without specified weight, putting it to the default 3
     * @param question the question
     * @param answers the possible answers
     * @param correct the number of the correct answer
     */
    public MCQuestion(String question, String[] answers, int correct){
        super(question, 3);
        this.answers = answers;
        this.correct = correct;
        
    }
    
    /**
     * gives a string to output a multiple choice question
     * @return a string of the question following all possible answers
     */
    @Override
    public String toString(){
        String output = question;
        for(String answer:answers){
            output += '\n' + answer;
        }
        return output;
    }
    
    /**
     * determines whether a given answer is correct
     * @param answer a string of an integer
     * @return whether the integer given is the same as the correct integer and thus the given answer is correct
     */
    @Override
    public boolean isCorrect(String answer){
        return Integer.parseInt(answer) == correct;
    }
    
    /**
     * gives the correct answer to the question
     * @return the correct answer
     */
    @Override
    public String correctAnswer() {
        return answers[correct];
    }
    
    /**
     * duplicates a multiple choice question and rotates around the answers
     * @return the same multiple choice question with the answers rotated and the correct answer changed accordingly
     */
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
