import java.util.ArrayList;

public class ZooManagementSystem
{
    public static int getDefaultCapacityOfCage=2;
    private static int starting_id=0;
    private static ArrayList<Zone> zones = new ArrayList<>();
    public static void main(String[] args)
    {
        ZooManagementSystem zoo = new ZooManagementSystem();
        zoo.addAnimal(new Tiger("White tiger",20,40));
        zoo.addAnimal(new Peacock("White Peacock",10,15));
        zoo.addAnimal(new Crocodile("Dare Devil",8,45));
        zoo.addAnimal(new Peacock("Red Peacock",5,10));
        zoo.addAnimal(new Crocodile("Rocky",15,50));
        zoo.addAnimal(new Crocodile("Old man",60,60));
        zoo.addAnimal(new Lion("King",30,55));
        zoo.removeAnimal(6);
        zoo.addAnimal(new Lion("Queen",24,45));
        zoo.displayAllAnimals();

        //zoo.displayAll();
    }

    ZooManagementSystem()
    {
        addZone("Zone1","Mammal");
        addZone("Zone2","Reptile");
        addZone("Zone3","Bird",true,true);
    }

    private void addZone(String zone_name, String zone_category, boolean canteen, boolean park)
    {
        zones.add(new Zone(zone_name,zone_category,canteen,park));
    }

    void addZone(String zone_name,String zone_category)
    {
        zones.add(new Zone(zone_name,zone_category));
    }

    void addAnimal(Animal animal)
    {
        for (int x=0;x<zones.size();x++)
        {
            if (animal.category.equalsIgnoreCase(zones.get(x).zone_category))
            {
                zones.get(x).addAnimal(animal);
                System.out.println("to zone "+zones.get(x).zone_name);
            }
        }
    }
    void removeAnimal(int id)
    {
        for (Zone zone:zones)
        {
            ArrayList<Cage> cages=zone.getCages();
            for (Cage cage:cages)
            {
                ArrayList<Animal> animals=cage.getAnimals();
                {
                    for (Animal animal:animals)
                    {
                        if (animal.id==id)
                        {
                            animals.remove(animal);
                            System.out.println("Removed "+animal.name+" from zone "+zone.zone_name);
                            break;
                        }
                    }
                }
            }
        }
    }

    static int generateId()
    {
        starting_id+=1;
        return starting_id;
    }

    static String generateName(String name)
    {
        return name+"_"+starting_id;
    }

    void displayAll()
    {
        for (Zone zone : zones)
        {
            System.out.println("============================= > > >\t\t"+ zone.zone_name+"\t\t< < < ============================\n");
            System.out.println("Zone category = " + zone.zone_category);
            ArrayList<Cage> cages = zone.getCages();
            for (int y = 0; y < cages.size(); y++)
            {
                Cage cage = cages.get(y);
                if(!cage.getAnimals().isEmpty())
                {
                    System.out.println("\tCage " + (y + 1));
                    System.out.println("\tCage Capacity = " + cage.getCapacity());
                    System.out.println("\tAnimals in cage = " + cage.getAnimals().size());
                    ArrayList<Animal> animals = cage.getAnimals();
                    for (int z = 0; z < animals.size(); z++)
                    {
                        animals.get(z).printAnimalDetails();
                    }
                }
                else
                {
                    System.out.println("No animal present in this Cage");
                }
            }
            System.out.println("====================================  Zone Ends Here  ================================\n");
        }
    }
    void displayAllAnimals()
    {
        for (Zone zone : zones)
        {
            ArrayList<Cage> cages = zone.getCages();
            for (Cage cage : cages)
            {
                if (!cage.getAnimals().isEmpty())
                {
                    ArrayList<Animal> animals = cage.getAnimals();
                    for (Animal animal : animals)
                    {
                        System.out.println(animal.id + " - " + animal.name);
                    }
                }
            }
        }
    }
}
