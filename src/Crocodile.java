public class Crocodile extends Reptile
{
    public Crocodile(String name, int age, int weight)
    {
        super(ZooManagementSystem.generateId(),ZooManagementSystem.generateName(name), "Reptile", age, weight, "hiss");
    }
}
