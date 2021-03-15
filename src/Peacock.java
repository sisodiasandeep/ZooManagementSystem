public class Peacock extends Bird
{
    public Peacock(String name, int age, int weight)
    {
        super(ZooManagementSystem.generateId(),ZooManagementSystem.generateName(name), "Bird", age, weight, "scream");
    }
}
