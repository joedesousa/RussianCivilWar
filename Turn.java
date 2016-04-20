
/**
 * Turn class acts as the manager of phases during a turn (movement, combat and unit purchase)
 * and also keeps track of the turn number.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Turn
{
    // instance variables - replace the example below with your own
    private int turnNumber;
    private int phaseNumber;
    private boolean unitInMotion;
    private MapBoard map;

    /**
     * Constructor for objects of class Turn
     */
    public Turn()
    {
        // initialise instance variables
        map = new MapBoard();
        turnNumber = 0;
        phaseNumber = 0;
        unitInMotion = false;
    }
    public Turn(int rows, int cols)
    {
        // initialise instance variables
        map = new MapBoard(rows, cols);
        turnNumber = 0;
        phaseNumber = 0;
        unitInMotion = false;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void singleClick(int xValue, int yValue)
    {
        // test code
        System.out.printf("Click registered in ( %d ,", xValue);
        System.out.printf("%d ) -> ", yValue);
        System.out.print(unitInMotion);
        System.out.printf(".\n");
        
        if (unitInMotion) 
        {
            unitInMotion = map.dropUnit(xValue, yValue);
        }
        else 
        {
            unitInMotion = map.getUnit(xValue, yValue);;
        }
    }
    
    public void mouseMoved(int xValue, int yValue)
    {
        if (unitInMotion) 
        {
            //update the xValue and yValue for the moving unit
            map.updateMovingUnitLocation(xValue, yValue);
        }
        else 
        {
            //do nothing
        }
    }
    
    public MapBoard getCurrentMap()
    {
        return map;
    }
}
