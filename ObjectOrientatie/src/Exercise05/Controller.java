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
    
    int cakePoints = 0; // points for questions answered in 1 try
    int cakePoints2 = 0; //points for questions answered in 2 tries
    Model model; //model
    View view; //view
    
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
        
        int rotation = 1;
        view.print("Answer all the questions correctly and you will get cake!");
        
        askQuestions(rotation);
        
        rotation = 2;
        boolean secondRoundNecessary = (model.questionsLeft(rotation) >= 1);
        
        askQuestions(rotation);
        
        view.print("The cake was a lie!\nBut you scored "
                    + String.valueOf(cakePoints)
                    + " points!\n");
        if (secondRoundNecessary) {
            view.print("You scored "
                    + String.valueOf(cakePoints2)
                    + " points on your second try.");
        }
    }
    
    /**
     * asks the questions that are left 
     * @param rotation the integer which round of questions you are in
     */
    private void askQuestions (int rotation) {
        while (model.questionsLeft(rotation) > 0) {
            
            Question nextQuestion = model.giveNextQuestion(rotation);
            view.poseQuestion(nextQuestion);
            String answer = view.giveAnswer();
            
            // Use 42 if you want to cheat. Useful for saving time.
            if (nextQuestion.isCorrect(answer) || answer.equals("42")) {
                view.print("That's the correct answer!\n");
                if (rotation == 1) {
                    cakePoints += nextQuestion.getPoints();
                }
                else {
                    cakePoints2 += nextQuestion.getPoints();
                }
            }
            else {
                view.print("That's the incorrect answer!\n");
                // Add to the end of the list, if it's the first time you are answering the question.
                if (rotation == 1) {
                    model.addQuestion(nextQuestion);
                }
            }
        }
        
    }
    
}