// Import the basic graphics classes.
import java.awt.*;
import javax.swing.*;

class GameDriver
{
    public static void main(String arg[]){
        Gui frame = new Gui();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600,650);

        // Create a new identifier for a BasicJPanel called "panel",
        // then create a new BasicJPanel object for it to refer to.
        
        //BasicJPanel panel = new BasicJPanel();

        // Make the panel object the content pane of the JFrame.
        // This puts it into the drawable area of frame, and now
        // we do all our drawing to panel, using paintComponent(), above.
        
        //frame.setContentPane(panel);
        frame.setVisible(true);
  }
}