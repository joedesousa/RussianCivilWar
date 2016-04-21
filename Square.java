
/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square
{
    // instance variables
    private int terrain;
    private Unit unitHolder;
    private int arrowDirection;
    private int owningFaction;
    private boolean unitInSquare;

    /**
     * Constructor for objects of class Square
     */
    public Square()
    {
        // initialise instance variables
        unitHolder = null;
        unitInSquare = false;
        terrain = 0;
        owningFaction = 0;
        arrowDirection = 0;
    }
    
    public Square(int newTerrain)
    {
        // initialise instance variables
        unitHolder = null;
        unitInSquare = false;
        terrain = newTerrain;
        owningFaction = 0;
        arrowDirection = 0;
    }
    
    public Square(Unit newUnit)
    {
        // initialise instance variables
        unitHolder = newUnit;
        unitInSquare = true;
        owningFaction = 0;
        arrowDirection = 0;
    }

    /**
     * Methods 
     */
    
    public Unit showUnit()
    {
        return unitHolder;
    }
    public Unit pullUnit()
    {
        Unit unitToMove = unitHolder;
        unitHolder = null;
        unitInSquare = false;
        return unitToMove;
    }
    public void dropUnit(Unit droppedUnit)
    {
        //System.out.printf("dropUnit reached \n");
        unitHolder = droppedUnit;
        owningFaction = droppedUnit.getFaction();
        unitInSquare = true;
    }
    
    public boolean hasAUnit()
    {
        //System.out.printf("Unit in Square -> ");
        //System.out.printf("%s", unitInSquare ? " true " : " false "); 
        //System.out.printf(".\n");
        return unitInSquare;
    }
    
    public int arrowDirection()
    {
        return arrowDirection;
    }
    
    public int terrain()
    {
        return terrain;
    }
    
    public void changeOwner(int newFaction)
    {
        owningFaction = newFaction;
    }
    
    public int faction()
    {
        return owningFaction;
    }
}
