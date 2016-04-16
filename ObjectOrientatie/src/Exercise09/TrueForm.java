
package Exercise09;

/**
 *
 * @author Joep
 */


public class TrueForm implements Form {
    public void accept( FormVisitor v ) {
        v.visit(this);
    }
    
    public String toString(){
        return "True";
    }
}
