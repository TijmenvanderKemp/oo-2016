/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise05;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */

public class Model {
    
    // When this class gets requests for questions, it will pick one of the
    // questions from the Question classes. It will then notify the Model that
    // it has another Question.
    
    
<<<<<<< HEAD
    private List<Question> questions = new LinkedList<>();
=======
    private final List<Question> questions = new LinkedList<>();
    private final List<Question> secondTryQuestions = new LinkedList<>();
>>>>>>> origin/master
    
    public Model () {
        // Add questions 
    }
    
    public Question giveNextQuestion(boolean secondRun) {
        // Give the question and simultaneously remove it from the list.
        if (!secondRun) {
            return questions.remove(0);
        }
        else {
            return secondTryQuestions.remove(0);
        }
    }
    
    public void addQuestion(Question q) {
        // For when the answer was wrong
<<<<<<< HEAD
        questions.add(q);
=======
        secondTryQuestions.add(q.duplicate());
>>>>>>> origin/master
    }
    
    public int questionsLeft(boolean secondRun) {
        if (!secondRun) {
            return questions.size();
        }
        else {
            return secondTryQuestions.size();
        }
    }
    
}
