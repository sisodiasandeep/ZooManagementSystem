public class Tiger extends Mammal
{
    public Tiger(String name,int age, int weight)
    {
        super(ZooManagementSystem.generateId(),ZooManagementSystem.generateName(name), "Mammal", age, weight, "Roar");
    }
}
