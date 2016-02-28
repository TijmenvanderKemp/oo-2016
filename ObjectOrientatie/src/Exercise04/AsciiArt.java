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
    private final Loipe loipe; //loipe die getekend moet worden
    private Punt currentPunt; //punt waar de wandelaar op dat moment is
    
    /**
     * maakt een object aan waarmee een loipe getekend kan worden
     * @param loipe de loipe die getekend moet worden
     */
    public AsciiArt(Loipe loipe){
        this.loipe = loipe;
        currentPunt = loipe.start();
    }
    
    /**
     * tekent een loipe met asciiart
     */
    @Override
    public void teken(){
        for (int j = 0; j < loipe.getHeight(); j++){
            String outputString = "";
            for (int i = 0; i < loipe.getWidth(); i++){
                Fragment fragment = loipe.getFragment(new Punt(i, j));
                if (currentPunt.getY() == j && currentPunt.getX() == i) {
                    outputString += "*";
                } else if (fragment == null) {
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
    
    /**
     * zet de positie van de wandelaar
     * @param p het punt waar de wandelaar op dat moment is.
     */
    @Override
    public void setPosition(Punt p){
        currentPunt = p;
    }
}
