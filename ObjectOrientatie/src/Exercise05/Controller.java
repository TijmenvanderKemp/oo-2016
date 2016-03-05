/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise05;

/**
 * Runs the quiz.
 * In a cycle:
 *   - gets a question from the model
 *   - poses it to the user
 *   - gets a response from the user
 *   - checks the answer and adds it to the list again if it's incorrect
 * 
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */


public class Controller {
    
    
    
    Model model;
    View view;
    
    public void addModel (Model m) {
        this.model = m;
    }
    public void addView (View v) {
        this.view = v;
    }
    
    /**
     * Run the quiz.
     * Asks questions while there are questions left to ask.
     */
    public void run() {
        while (model.questionsLeft() > 0) {
            Question nextQuestion = model.giveNextQuestion();
            view.poseQuestion(nextQuestion);
            String answer = view.giveAnswer();
            if (nextQuestion.isCorrect(answer)) {
                view.print("That's the correct answer!\n");
            }
            else {
                view.print("That's the incorrect answer!\n");
                // Add to the end of the list.
                model.addQuestion(nextQuestion);
            }
        }
    }
    
}
