
// Import the basic graphics classes.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BasicJPanel extends JPanel{
    
    MapBoard map;
    Unit unitToRender;
    int x, y; // used for x and y values of moving unit when there is a unit in motion
    
    Color[] ownColor = new Color[6];
    
  // Create a constructor method
  public BasicJPanel(){
      super();
      
      map = new MapBoard();
      
      ownColor[0] = new Color(255,255,  0,100);
      ownColor[1] = new Color(255,255,255,100);
      ownColor[2] = new Color(255,  0,  0,100);
      ownColor[3] = new Color(  0,255,  0,100);
      ownColor[4] = new Color(  0,  0,255,100);
      ownColor[5] = new Color(  0,  0,  0,100);
      
      repaint();
  }
  public BasicJPanel(MapBoard currentMap)
  {
      super();
      
      map = currentMap;
      
      ownColor[0] = new Color(255,255,  0,100);
      ownColor[1] = new Color(255,255,255,100);
      ownColor[2] = new Color(255,  0,  0,100);
      ownColor[3] = new Color(  0,255,  0,100);
      ownColor[4] = new Color(  0,  0,255,100);
      ownColor[5] = new Color(  0,  0,  0,100);
      
      repaint();
  }

  // The following methods are instance methods.

  /* Create a paintComponent() method to override the one in
    JPanel.This is where the drawing happens. We don't have 
    to call it in our program, it gets called automatically 
    whenever the panel needs to be redrawn, like when it is 
    made visible or moved or whatever.
  */
 
  public void paintComponent(Graphics g){
      g.setColor(Color.BLACK);
      
      if (map.printGrid())
      {
        for(int i=1; i<=(map.cols()+1); i++){
            for(int j=1; j<=(map.rows()+1); j++){
                g.drawLine(50,i*50,(map.rows()*50+50),i*50); // Draw horizontal line
                g.drawLine(j*50,50,j*50,(map.cols()*50+50)); // Draw vertical line
            }
        }
      }
      
      //Map graphics renderer
      //print terrain
      for(int i=0; i<map.rows(); i++){
          for(int j=0; j<map.cols(); j++){
              // call terrain from square
              // draw terrain at that square on map grid
          }
      }
      
      //print units
      for(int i=0; i<map.rows(); i++){
          for(int j=0; j<map.cols(); j++){
              if (map.hasAUnit(i,j)) 
              {
                  unitToRender = map.showUnit(i,j);
                  switch (unitToRender.getFaction())
                  {
                      case 1:  g.setColor(Color.WHITE); //Tsarist forces
                               break;
                      case 2:  g.setColor(Color.RED);   //Bolsheviks
                               break;
                      case 3:  g.setColor(Color.GREEN); //Peasant rebels
                               break;
                      case 4:  g.setColor(Color.BLUE);  //Nationalists
                               break;
                      case 5:  g.setColor(Color.BLACK); //Anarchists
                               break;
                      default: g.setColor(Color.CYAN);  //Unassigned
                               break;
                  }
                  g.fillRect(i*50+60,j*50+60,30,30);
                  //account for Anarchist units
                  if (unitToRender.getFaction()==5) g.setColor(Color.WHITE);
                                               else g.setColor(Color.BLACK);
                  g.drawRect(i*50+60,j*50+60,30,30); // Draw a box where the unit is
                  // draw division designation
                  g.drawLine(i*50+67,j*50+52,i*50+73,j*50+58);
                  g.drawLine(i*50+73,j*50+52,i*50+67,j*50+58);
                  g.drawLine(i*50+77,j*50+52,i*50+83,j*50+58);
                  g.drawLine(i*50+83,j*50+52,i*50+77,j*50+58);
                  // unit type drawing section
                  if (unitToRender.cavalry()>0)
                  {
                      g.drawLine(i*50+60,j*50+60+30,i*50+60+30,j*50+60);
                  }
                  if (unitToRender.infantry()>0)
                  {
                      g.drawLine(i*50+60,j*50+60+30,i*50+60+30,j*50+60);
                      g.drawLine(i*50+60,j*50+60,i*50+60+30,j*50+60+30);
                  }
                  if (unitToRender.artillery()>0)
                  {
                      g.fillOval(i*50+60+12,j*50+60+12,6,6);
                  }
                  g.setColor(Color.BLACK);
                  // end unit drawing section
              }
          }
      }
      
      //Map ownership renderer
      //Filled colored translucent squares denote region control
      if (map.printOwnership())
      {
          for(int i=0; i<map.rows(); i++){
              for(int j=0; j<map.cols(); j++){
                // call ownership status from square
                // fill square with appropriate translucent box on map grid
                
                g.setColor(ownColor[map.squareOwnership(i,j)]);
                g.fillRect(i*50+50,j*50+50,50,50);
              }
          }
          g.setColor(Color.BLACK);
      }//end ownership renderer
      
      //print unit in transit
      
      //In remarks below, a trace of unit transit statis:
      //System.out.printf("Is a unit in motion? ->");
      //System.out.print(map.unitInMotion());
      //System.out.printf(".\n");
      
      if (map.unitInMotion()) 
      {
          unitToRender = map.unitToMove();
          x = map.returnMovingX();
          y = map.returnMovingY();
          switch (unitToRender.getFaction())
          {
              case 1:  g.setColor(Color.WHITE); //Tsarist forces
                       break;
              case 2:  g.setColor(Color.RED);   //Bolsheviks
                       break;
              case 3:  g.setColor(Color.GREEN); //Peasant rebels
                       break;
              case 4:  g.setColor(Color.BLUE);  //Nationalists
                       break;
              case 5:  g.setColor(Color.BLACK); //Anarchists
                       break;
              default: g.setColor(Color.CYAN);  //Unassigned
                       break;
          }
          g.fillRect(x+60,y+60,30,30);
          //account for Anarchist units
          if (unitToRender.getFaction()==5) g.setColor(Color.WHITE);
                                       else g.setColor(Color.BLACK);
          g.drawRect(x+60,y+60,30,30); // Draw a box where the unit is
          // draw division designation
          g.drawLine(x+67,y+52,x+73,y+58);
          g.drawLine(x+73,y+52,x+67,y+58);
          g.drawLine(x+77,y+52,x+83,y+58);
          g.drawLine(x+83,y+52,x+77,y+58);
          // unit type drawing section
          if (unitToRender.cavalry()>0)
          {
              g.drawLine(x+60,y+60+30,x+60+30,y+60);
          }
          if (unitToRender.infantry()>0)
          {
              g.drawLine(x+60,y+60+30,x+60+30,y+60);
              g.drawLine(x+60,y+60,x+60+30,y+60+30);
          }
          if (unitToRender.artillery()>0)
          {
              g.fillOval(x+60+12,y+60+12,6,6);
          }
          g.setColor(Color.BLACK);
      }
      
     //?print arrows?
      
  }
  
}
