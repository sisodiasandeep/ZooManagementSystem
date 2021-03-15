import java.util.ArrayList;

public class Zone
{
    private ArrayList<Cage> cages = new ArrayList<>();
    String zone_name;
    String zone_category;
    Boolean park;
    Boolean canteen;
    public Zone(String zone_name,String zone_category,boolean park,boolean canteen)
    {
        this.zone_name=zone_name;
        this.zone_category=zone_category;
        addCage();
    }
    public Zone(String zone_name,String zone_category)
    {
        this(zone_name,zone_category,false,false);
    }

    void addAnimal(Animal animal)
    {
        boolean new_cage_required=true;
        for (Cage cage : cages)
        {
            if (!cage.isFull())
            {
                cage.addAnimal(animal);
                new_cage_required = false;
            }
        }
        if(new_cage_required)
        {
            addCage();
            addAnimal(animal);
        }
    }
    void addCage()
    {
        addCage(new Cage(ZooManagementSystem.getDefaultCapacityOfCage));
    }
    void addCage(Cage cage)
    {
        cages.add(cage);
    }
    void removeCage(int index)
    {
        cages.remove(index);
    }
    public ArrayList<Cage> getCages()
    {
        return cages;
    }
}
