package Exercise04;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Pieter Koopman
 */
public class LoipePlaatje extends JFrame implements TekenLoipe
{
   /** Used for painting the tiles.
    *  We assume that all tiles have same width and height.
    */
   private final int UNIT;

   /** Color for painting the background. */
   private static final Color SNOW = new Color(212, 240, 255);
   
   /**
    * The icons for drawing
    */
   private final ImageIcon nz, ow, no, nw, zo, zw, nzow;
   
   private JPanel panel;

   /**
    * the loipe to be painted and a boolean indicating whether it is okay
    */
   private InfoLoipe loipe;
   private boolean loipeOK = true;
   /**
    * previous position for walking the loipe
    */
   private Punt previousPos = null;

   /**
    * Constructor. Fill all icons. Check loipe and paint it
    * @param s: the loipe to be drawn
    */
    public LoipePlaatje(InfoLoipe s) {
        super("Loipe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nz = plaatje("nz");
        ow = plaatje("ow");
        no = plaatje("no");
        nw = plaatje("nw");
        zo = plaatje("zo");
        zw = plaatje("zw");
        nzow = plaatje("nzow");
        UNIT = nz.getIconWidth();
        setLoipe(s);
        if (loipeOK) {
            panel = new JPanel();
            add(panel);
            panel.setBackground(SNOW);
        }
    }

   /**
    * Creates a LoipePlaatje object based on the track information in <code>Loipe</code>.
    * @param s this Loipe contains the 2D track information
    */
   private void setLoipe (InfoLoipe s) {
      loipe = s;
      checkLoipe();
   }

   /**
    * Checks validity of the input track description. Terminates normally
    * when the track is valid, prints a message otherwise.
    */
   private void checkLoipe() {
      if (loipe == null)
      {
         System.err.println("Illegale loipe: null pointer");
         loipeOK = false;
      }
      else if (loipe.getHeight() == 0)
      {
         System.err.println("Illegale loipe: height should be at least 1");
         loipeOK = false;
      }
      else if (loipe.getWidth() == 0)
      {
         System.err.println("Illegale loipe: width should be at least 1");
         loipeOK = false;
      }
  }
   /**
    * Gets the preferred size of this component.
    *
    * @return a dimension object indicating this component's preferred size.
    */
   @Override
    public Dimension getPreferredSize() {
        return new Dimension(loipe.getWidth() * UNIT, loipe.getHeight() * UNIT);
    }

    /**
     * try to read a picture with the given name
     * @param naam "name.png" is filename of picture
     * @return the picture
     * @throws IllegalArgumentexception if file is not found
     */
    private ImageIcon plaatje (String name) {
        name += ".png";
        URL resource = getClass().getClassLoader().getResource(name);
        if (resource != null) {
            return new ImageIcon (resource);
        } else {
            System.err.printf ("ERROR: Resource \"%s\" not found... aborting...\n", name);
            System.err.println("For NetBeans the file should be placed in the src folder.");
            throw new IllegalArgumentException ("Image " + name + " not found!");
        }
    }

    /**
     * paint everything again when the window has to be repainted
     */
    @Override
    public void repaint() {
        paint(getGraphics());
    }
   /**
    * Update graphics according to stored track.
    * @param g the graphics context to use for painting.
    */
   @Override
   public void paint(Graphics g) {
        super.paint(g);
        g = panel.getGraphics();
        for (int i = 0; i < loipe.getWidth(); i += 1) {
            for (int j = 0; j < loipe.getHeight(); j += 1) {
                tekenFragment(g, i, j);
            }
        }
        if (previousPos != null) {
            g.setColor(Color.RED);
            g.fillOval(previousPos.getX() * UNIT + UNIT / 4, previousPos.getY() * UNIT + UNIT / 4, UNIT / 2, UNIT / 2);
        }
   }
   
   /**
    * Draw the fragment from the loipe at the given position
    * @param g
    * @param x
    * @param y 
    */
   private void tekenFragment(Graphics g, int x, int y) {
       Fragment f = loipe.getFragment(new Punt(x, y));
       ImageIcon plaatje;
       if (f != null) {
           switch (f) {
               case NZ: plaatje = nz; break;
               case OW: plaatje = ow; break;
               case NO: plaatje = no; break;
               case NW: plaatje = nw; break;
               case ZO: plaatje = zo; break;
               case ZW: plaatje = zw; break;
               default: plaatje = nzow;
           }
           if (plaatje != null) {
               plaatje.paintIcon(this, g, x * UNIT, y * UNIT);
           }
       }
   }
   /**
    * The method to call in order to draw a window with the given track.
    * You are supposed to use this method once for each object.
    */
   @Override
   public void teken() {
       if (loipeOK) {
           setSize(loipe.getWidth() * UNIT, loipe.getHeight() * UNIT + UNIT / 2);
           setVisible(true);     // make frame visible
       }
       else
           System.err.println("LoipePlaatje kan niet tekenen. Loipe is ongeldig of plaatjes niet gevonden");
   }
   
   @Override
   public void setPosition(Punt p) {
       Graphics g = panel.getGraphics();
       if (previousPos != null) {
           g.setColor(SNOW);
           g.fillRect(previousPos.getX() * UNIT, previousPos.getY() * UNIT, UNIT, UNIT);
           tekenFragment(g,previousPos.getX(), previousPos.getY());
       }
       g.setColor(Color.RED);
       g.fillOval(p.getX() * UNIT + UNIT / 4, p.getY() * UNIT + UNIT / 4, UNIT / 2, UNIT / 2);
       previousPos = p;
   }
}