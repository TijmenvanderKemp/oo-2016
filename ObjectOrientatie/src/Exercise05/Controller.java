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


public class Controller {
    
    // Sends questions to the View to be displayed, gets answers from the View
    // to check, sends requests to the Model for new questions, gets questions
    // from the Model to pose to the View.
    
    Model model;
    View view;
    
    public void addModel (Model m) {
        this.model = m;
    }
    public void addView (View v) {
        this.view = v;
    }
    
    public void run() {
        // Run the quiz
        while (model.questionsLeft() > 0) {
            Question nextQuestion = model.giveNextQuestion();
            view.poseQuestion(nextQuestion);
            String answer = view.giveAnswer();
            // If answer == rightanswer
            // Correct answer!
            // Else
            // Not the correct answer!
            // Add this question to end of list.
        }
    }
    
}
