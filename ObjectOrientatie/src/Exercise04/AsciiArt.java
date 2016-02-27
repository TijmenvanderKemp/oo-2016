/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package Exercise04;

/**
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class AsciiArt implements TekenLoipe{
    private Loipe loipe;
    
    public AsciiArt(Loipe loipe){
        this.loipe = loipe;
    }
    
    
    @Override
    public void teken(){
        for (int i = 0; i < loipe.getWidth(); i++){
            for (int j = 0; j < loipe.getHeight(); j++){
                Fragment fragment = loipe.getFragment(new Punt(i,j));
                switch (fragment){
                    case NZ:
                      System.out.println("|") ;
                    case OW:
                      System.out.println("-");
                    case NO:
                      System.out.println("`");
                    case NW:
                      System.out.println("'");
                    case ZO:
                      System.out.println(",");
                    case ZW:
                      System.out.println("."); 
                    case KR:
                      System.out.println("+");  
                }
            }                
        }
    }
    
    @Override
    public void setPosition(Punt p){
        
    }
}
