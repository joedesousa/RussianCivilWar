import java.awt.Color;
 
/**
 * Simple holder for Unit class (Army/Division)
 */
public class Unit
{
    // instance variables
    private String unitName;
    private int faction;
    
    private int cavalry;
    private int infantry;
    private int artillery;

    /**
     * Constructor for objects of class Unit
     */
    public Unit()
    {
        // initialise instance variables
        unitName = "";
        faction = 0;
        cavalry = 0;
        infantry = 0;
        artillery = 0;
    }
    public Unit(String assignedName, int assignedFaction)
    {
        unitName = assignedName;
        faction = assignedFaction;
        cavalry = 0;
        infantry = 0;
        artillery = 0;
    }
    public Unit(int cav, int inf, int art)
    {
        // initialise instance variables
        unitName = "";
        faction = 0;
        cavalry = cav;
        infantry = inf;
        artillery = art;
    }
    public Unit(String assignedName, int assignedFaction, int cav, int inf, int art)
    {
        unitName = assignedName;
        faction = assignedFaction;
        cavalry = cav;
        infantry = inf;
        artillery = art;
    }
    
    /**
     * Methods 
     */
    
    public void changeUnitName(String newName)
    {
        unitName = newName;
    }
    public void changeFaction(int newFaction)
    {
        faction = newFaction;
    }
    public void populateUnit(int cav, int inf, int art)
    {
        cavalry = cav;
        infantry = inf;
        artillery = art;
    }
    public int cavalry()
    {
        // put your code here
        return cavalry;
    }
    public int infantry()
    {
        // put your code here
        return infantry;
    }
    public int artillery()
    {
        // put your code here
        return artillery;
    }
    public String name()
    {
        return unitName;
    }
    public int getFaction()
    {
        if ((faction > 0) && (faction < 6))
        {
             return faction;
        }
        else return 0;
    }
}
