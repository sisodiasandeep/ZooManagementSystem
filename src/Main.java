public class Main
{
    public static void main(String[] args) throws Exception
    {
        Queue q = new Queue(4);
        q.printQueue();

        // inserting elements in the queue
        q.addToQueue(20);
        q.addToQueue(30);
        q.addToQueue(40);
        q.addToQueue(50);

        // print Queue elements
        q.printQueue();

        // insert element in the queue
        //q.addToQueue(60);

        // print Queue elements
        q.printQueue();

        q.removeFromQueue();
        q.removeFromQueue();
        System.out.printf("\n\nafter two node deletion\n\n");

        // print Queue elements
        q.printQueue();

        // print front of the queue
        System.out.println(q.getFront());
    }
}
