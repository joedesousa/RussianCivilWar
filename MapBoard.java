
/**
 * Write a description of class MapBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapBoard
{
    // instance variables 
    private Square[][] boardData;
    private Unit unitToMove;
    private boolean unitIsInMotion;
    private int movingUnitX, movingUnitY;
    private int xDim, yDim;
    
    private boolean gridStatus, ownStatus;

    /**
     * Constructor for objects of class MapBoard
     */
    public MapBoard()
    {
        // initialise instance variables
        boardData = new Square[10][10];
        xDim = 10;
        yDim = 10;
        
        //flags used by the panel renderer to decide whether to print a map component
        gridStatus = true;
        ownStatus = false;
        
        for(int i=0; i<10; i++){
          for(int j=0; j<10; j++){
              Square newSquare = new Square(); // create new Square
              boardData[i][j] = newSquare;     // initialize board with a new square
          }
      }
    }
    public MapBoard(int rows, int cols)
    {
        // initialise instance variables
        boardData = new Square[rows][cols];
        xDim = rows;
        yDim = cols;
        gridStatus = true;
        ownStatus = false;
        
        for(int i=0; i<rows; i++){
          for(int j=0; j<cols; j++){
              Square newSquare = new Square(); // create new Square
              boardData[i][j] = newSquare;     // initialize board with a new square
          }
      }
      // test line - adding a dummy unit
      Unit dummyUnit1 = new Unit("TestUnit",2,3,4,5);
      boardData[3][5].dropUnit(dummyUnit1);
      Unit dummyUnit2 = new Unit("TestUnit",1,4,0,0);
      boardData[5][2].dropUnit(dummyUnit2);   
    }

    /**
     * Methods  
     */
    public Square Square(int xValue,int yValue)
    {
        // simply returns the square for that index
        return boardData[xValue][yValue];
    }
    
    // boolean status in next two methods refers to whether unit is in motion
    public boolean getUnit(int xValue, int yValue)
    {
        if (boardData[xValue][yValue].hasAUnit())
        {
            unitToMove = boardData[xValue][yValue].pullUnit();
            this.updateMovingUnitLocation(xValue, yValue);
            unitIsInMotion = true;
            return unitIsInMotion;
        }
        else 
        {
            unitIsInMotion = false;
            return unitIsInMotion;
        }
    }
    
    public boolean dropUnit(int xValue, int yValue)
    {
        if (boardData[xValue][yValue].hasAUnit()) 
        {
            // if square is occupied, don't place the moving unit
            this.updateMovingUnitLocation(xValue, yValue);
            unitIsInMotion = true;
            return unitIsInMotion;
        }
        else
        {
            boardData[xValue][yValue].dropUnit(unitToMove);
            unitToMove = null;
            unitIsInMotion = false;
            return unitIsInMotion;
        }
    }
    
    public boolean hasAUnit(int xValue, int yValue)
    {
        if (boardData[xValue][yValue].hasAUnit())
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public Unit showUnit(int xValue, int yValue)
    {
        if (boardData[xValue][yValue].hasAUnit())
        {
            return boardData[xValue][yValue].showUnit();
        }
        else return null;
    }
    
    public boolean unitInMotion()
    {
        return unitIsInMotion;
    }
    
    public Unit unitToMove()
    {
        return unitToMove;
    }
    
    public void updateMovingUnitLocation(int xValue, int yValue)
    {
        movingUnitX = xValue;
        movingUnitY = yValue;
    }
    
    public int returnMovingX()
    {
        return movingUnitX;
    }
    
    public int returnMovingY()
    {
        return movingUnitY;
    }

    public int rows()
    {
        return xDim;
    }
    
    public int cols()
    {
        return yDim;
    }
    
    public void toggleGridStatus()
    {
        if (gridStatus) gridStatus = false;
                   else gridStatus = true;
    }
    
    public void toggleOwnStatus()
    {
        if (ownStatus)  ownStatus = false;
                   else ownStatus = true;
    }
    
    public boolean printGrid()
    {
        return gridStatus;
    }
    
    public boolean printOwnership()
    {
        return ownStatus;
    }
    
    public int squareOwnership(int xValue, int yValue)
    {
        return boardData[xValue][yValue].faction();
    }
}
