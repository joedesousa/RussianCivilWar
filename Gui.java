import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame
{
    private JPanel mousePanel;
    private JLabel statusBar;
    private Turn turnManager;
    private MapBoard currentMap;
    private static int LENGTH, WIDTH, SQUARESIZE;
    
    public Gui()
    {
        super("Test");
        
        WIDTH = 10;
        LENGTH = 30;
        SQUARESIZE = 50;
        
        turnManager = new Turn(LENGTH, WIDTH);
        currentMap = turnManager.getCurrentMap();
        
        mousePanel = new BasicJPanel(turnManager.getCurrentMap());
        mousePanel.setBackground(Color.WHITE);
        add(mousePanel, BorderLayout.CENTER);
        
        statusBar = new JLabel("Default");
        add(statusBar, BorderLayout.SOUTH);
        
        HandlerClass handler = new HandlerClass();
        mousePanel.addMouseListener(handler);
        mousePanel.addMouseMotionListener(handler);
        this.addKeyListener(handler);
        
    }

      //MAP GRAPHICS GENERATOR (initializes, then called (repaint()?) as a series of frames (every 100 ms?))
      //needs a means to find out what the map data is
    
    private class HandlerClass implements MouseListener, MouseMotionListener, KeyListener
    {
        public void mouseClicked(MouseEvent event)
        {
            statusBar.setText( String.format( "Clicked at %d, %d", event.getX(), event.getY() ) );
// This needs to be moved - change to a method call to the data array object that updates the map data
            if (  (event.getX()>50) && (event.getX()<(SQUARESIZE*LENGTH+50) )
                &&(event.getY()>50) && (event.getY()<(SQUARESIZE*WIDTH +50) ) )
                {
                    statusBar.setText( String.format( "Clicked in square %d, %d", event.getX()/SQUARESIZE, event.getY()/SQUARESIZE ) );
                    //call the method that handles a single click on a square
                    turnManager.singleClick( (event.getX()/SQUARESIZE)-1 , (event.getY()/SQUARESIZE)-1 );
                    turnManager.mouseMoved( event.getX()-SQUARESIZE-LENGTH , event.getY()-SQUARESIZE-LENGTH );
                }
            repaint();
        }
        public void mousePressed(MouseEvent event)
        {
            statusBar.setText("You pressed the mouse button.");
        }
        public void mouseReleased(MouseEvent event)
        {
            statusBar.setText("You released the mouse button.");
        }
        public void mouseEntered(MouseEvent event)
        {
            statusBar.setText("You entered the bound area.");
        }
        public void mouseExited(MouseEvent event)
        {
            statusBar.setText("You exited the bound area.");
        } 
        public void mouseDragged(MouseEvent event)
        {
            statusBar.setText("You dragged the mouse.");
            turnManager.mouseMoved( event.getX()-SQUARESIZE-LENGTH , event.getY()-SQUARESIZE-LENGTH );
            repaint();
        }
        public void mouseMoved(MouseEvent event)
        {
            statusBar.setText("You moved the mouse.");
            turnManager.mouseMoved( event.getX()-SQUARESIZE-LENGTH , event.getY()-SQUARESIZE-LENGTH );
            repaint();
        }
        public void keyTyped(KeyEvent event)
        {
            char char1 = event.getKeyChar();
            statusBar.setText("You typed " + char1 + " character from keyboard");
        }
        public void keyReleased(KeyEvent event)
        {
            char char1 = event.getKeyChar();
            statusBar.setText("You released " + char1 + " character from keyboard"); 
        }
        public void keyPressed(KeyEvent event)
        {
            char char1 = event.getKeyChar();
            statusBar.setText("You pressed " + char1 + " character from keyboard");
            if (char1=='g' || char1=='G')
            {
                currentMap.toggleGridStatus();
                repaint();
            }
            if (char1=='t' || char1=='T')
            {
                currentMap.toggleOwnStatus();
                repaint();
            }
        }
    }// end HandlerClass
    
}
    