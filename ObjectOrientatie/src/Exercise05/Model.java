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
    
    

    private final List<Question> questions = new LinkedList<>();
    private final List<Question> secondTryQuestions = new LinkedList<>();
    
    public Model () {
        
        addNewQuestions();
    
    }
    
    public Question giveNextQuestion(int rotation) {
        // Give the question and simultaneously remove it from the list.
        if (rotation == 1) {
            return questions.remove(0);
        }
        else {
            return secondTryQuestions.remove(0);
        }
    }
    
    public void addQuestion(Question q) {
        // For when the answer was wrong

        secondTryQuestions.add(q.duplicate());
    }
    
    public int questionsLeft(int rotation) {
        if (rotation == 1) {
            return questions.size();
        }
        else {
            return secondTryQuestions.size();
        }
    }
    
    private void addNewQuestions () {
        questions.add(new OpenQuestion (
            "Wat is de complexiteit van binair zoeken?",
            "O(log N)"
            )
        );
        questions.add(new OpenQuestion (
            "Hoe lees je in Java een integer i uit een scanner s?",
            "i = s.nextInt();",
            2
            )
        );
        questions.add(new OpenQuestion (
            "Is er verschil tussen een interface en een abstracte klasse?",
            "Ja",
            5
            )
        );
        questions.add(new OpenQuestion (
            "Hoeveel constructoren je minstens maken bij een klasse in Java?",
            "0",
            2
            )
        );
        questions.add(new OpenQuestion (
            "Is er een maximum aantal constructoren van een klasse in Java?",
            "Nee"
            )
        );
        questions.add(new MCQuestion(
            "Wat is de complexiteit van slim in situ sorteren?",
            new String [] {
                "O(N^2)",
                "O(N log N)",
                "O(N)",
                "O(log N)"},
            1,
            4
            )
        );
        questions.add(new MCQuestion(
            "Hoe print je \"Hello world\" op een regel in Java?",
            new String [] {
                "System.out.print(\"Hello world\");",
                "System.out.println(\"Hello world\");",
                "cout << \"Hello world\";"}, 
            1
            )
        );
        questions.add(new MCQuestion(
            "Hoe lees je in Java een niet leeg woord uit scanner s?",
            new String []{
                "s.nextline()",
                "s.next(\"\\S+\")",
                "s.next(\"\\a*\")",
                "s.next(\"\\S*\")",
                "s.next(\"\\\\s+\")",
                "s.next(\"\\s+\")",
                "s.nextString(\"\\s*\")",
                "s.next(\"\\\\S+\")",
                "s.nextString()"},
            7,
            1
            )
        );
        questions.add(new TCQuestion(
            "Een rij heeft in Java een vaste grootte",
            "Goed",
            "Fout",
            0
            )
        );
        questions.add(new TCQuestion(
            "Een lijst heeft in Java een vaste lengte",
            "Goed",
            "Fout",
            1
            )
        );
    }
    
}
