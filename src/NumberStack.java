public class NumberStack
{
    int top = -1;
    LinkedList list = new LinkedList(); // Backed by LinkedList

    public void push(int element)
    {
        if(top >= list.size())
        {
            System.out.println("Overflow stack");
            return;
        }
        top++;
        list.addToFront(element);
    }

    public int pop()
    {
        if(top == -1)
        {
            System.out.println("Underflow Stack");
            return -1;
        }
        int element = list.removeFromFront();
        top--;
        return element;
    }
    public int peek()
    {
        return list.getHead();
    }
    public boolean isEmpty()
    {
        return top == -1;
    }
}