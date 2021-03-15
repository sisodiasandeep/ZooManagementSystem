public class Lion extends Mammal
{
    public Lion(String name,int age, int weight)
    {
        super(ZooManagementSystem.generateId(),ZooManagementSystem.generateName(name), "Mammal", age, weight, "Roar");
    }
}
