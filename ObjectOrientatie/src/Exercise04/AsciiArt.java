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
            String outputString = "";
            for (int j = 0; j < loipe.getHeight(); j++){
                Fragment fragment = loipe.getFragment(new Punt(i, j));
                if (fragment == null) {
                    outputString += " ";
                } else {
                    switch (fragment){
                        case NZ:
                            outputString += "|";
                            break;
                        case OW:
                            outputString += "-";
                            break;
                        case NO:
                            outputString += "`";
                            break;
                        case NW:
                            outputString += "'";
                            break;
                        case ZO:
                            outputString += ",";
                            break;
                        case ZW:
                            outputString += ".";
                            break; 
                        case KR:
                            outputString += "+";
                            break; 
                    }
                }
            }
            System.out.println(outputString);
        }
    }
    
    @Override
    public void setPosition(Punt p){
        
    }
}
