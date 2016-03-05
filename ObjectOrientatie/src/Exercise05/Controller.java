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
    
    
    int cakePoints = 0;
    int cakePoints2 = 0;
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
        
        view.print("Answer all the questions correctly and you will get cake!");
        
        askQuestions(/*second run =*/ false);
        
        if (model.questionsLeft(true) == 0) {
            cakePoints2 = -1; // Disable this so we don't display it later.
        }
        
        askQuestions(/*second run =*/ true);
        
        view.print("The cake was a lie!\nBut you scored "
                    + String.valueOf(cakePoints)
                    + " points!\n");
        if (cakePoints2 > -1) {
            view.print("You scored "
                    + String.valueOf(cakePoints2)
                    + " points on your second try.");
        }
    }
    
    private void askQuestions (boolean secondRun) {
        while (model.questionsLeft(secondRun) > 0) {
            
            Question nextQuestion = model.giveNextQuestion(secondRun);
            view.poseQuestion(nextQuestion);
            String answer = view.giveAnswer();
<<<<<<< HEAD
            if (nextQuestion.isCorrect(answer)) {
                view.print("That's the correct answer!");
            }
            else {
                view.print("That's the incorrect answer!");
                // Add to the end of the list.
                model.addQuestion(nextQuestion);
=======
            // Use 42 if you want to cheat. Useful for saving time.
            if (nextQuestion.isCorrect(answer) || answer.equals("42")) {
                view.print("That's the correct answer!\n");
                if (!secondRun) {
                    cakePoints += nextQuestion.getPoints();
                }
                else {
                    cakePoints2 += nextQuestion.getPoints();
                }
            }
            else {
                view.print("That's the incorrect answer!\n");
                // Add to the end of the list, if it's the first time you are answering the question.
                if (!secondRun) {
                    model.addQuestion(nextQuestion);
                }
>>>>>>> origin/master
            }
        }
        
    }
    
}
