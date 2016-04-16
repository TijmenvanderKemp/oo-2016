
package Exercise09;

/**
 *
 * @author Joep
 */


public class NotForm implements Form{
    private Form Operand;
            
    public NotForm(Form o){
        Operand = o;
    }
            
    public void accept( FormVisitor v ) {
        v.visit(this);
    }
    
    public String toString(){
        return "¬" + Operand.toString();
    }
}
