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


public abstract class Question {
    
    public final int weight;
    protected final String question;
    
    public Question(String v, int w){
        question = v;
        if(1 <= w && w <= 5){
            weight = w;
        }
        else
            weight = 3;
    }
            
    
    @Override
    public String toString() {
        return "";
    }
    
    public abstract boolean isCorrect(String answer);           
    
    public abstract String correctAnswer();
    
    public Question duplicate(){
        return this;
    }
    
}
