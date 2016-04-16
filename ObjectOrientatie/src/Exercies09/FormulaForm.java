
package Exercies09;

/**
 *
 * @author Joep
 */


public class FormulaForm implements Form {
    String Formula;
    
    FormulaForm(String f){
        Formula = f;
    }
    
    public void accept( FormVisitor v ) {
        v.visit(this);
    }
    
    public String toString(){
        return Formula;
    }
}
