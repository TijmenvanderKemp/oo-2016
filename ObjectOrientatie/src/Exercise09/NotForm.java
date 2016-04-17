/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise09;

/**
 * A formula based on a Not-construction
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */


public class NotForm implements Form{
    private final Form Operand;//The operand of the Not
            
    public NotForm(Form o){
        Operand = o;
    }
    
    public Form getOperand () {
        return Operand;
    }
            
    @Override
    public <R> R accept( FormVisitor<R> v ) {
        return v.visit(this);
    }
    
    @Override
    public String toString(){
        return "";
    }
}
