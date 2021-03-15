public class Animal
{
    int id;
    String name;
    String category;
    int age;
    int weight;
    String sound;

    public Animal(int id, String name, String category, int age, int weight, String sound)
    {
        this.id = id;
        this.name = name;
        this.category = category;
        this.age = age;
        this.weight = weight;
        this.sound = sound;
    }

    public void printAnimalDetails()
    {
        System.out.print("\t\t"+"Id = "+id);
        System.out.print("\t\t"+"Animal name = "+name);
        System.out.print("\t\t"+"Animal category = "+category);
        System.out.print("\n\t\t"+"Animal age = "+age);
        System.out.print("\t\t"+"Animal weight = "+weight);
        System.out.print("\t\t"+"Animal sound = "+sound);
        System.out.println("\n\t\t-----------------------------------------------------------------------");
    }
}
