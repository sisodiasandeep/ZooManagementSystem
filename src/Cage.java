import java.util.ArrayList;

public class Cage
{
    int capacity;
    ArrayList<Animal> animals = new ArrayList<>();
    public Cage(int capacity)
    {
        this.capacity = capacity;
    }

    public void addAnimal(Animal animal)
    {
        animals.add(animal);
        System.out.print("Added successfully "+animal.name+" of age "+animal.age+"years and weight "+animal.weight+"Kg ");
    }
    public boolean isFull()
    {
        return animals.size()==capacity;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public ArrayList<Animal> getAnimals()
    {
        return animals;
    }
}
