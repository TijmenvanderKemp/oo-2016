/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise05;

/**
 * Links the Model, View, and Controller together. Usable if you want multiple
 * combinations of the three.
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */

public class Glue {
    
    public Glue () {
        Model model = new Model();
        View view = new View();
    
        Controller controller = new Controller();
        controller.addModel(model);
        controller.addView(view);
    }
    
}
