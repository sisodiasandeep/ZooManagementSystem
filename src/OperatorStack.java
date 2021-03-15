public class OperatorStack
{
    int top = -1;
    int size = 100;
    char operatorStack[] = new char[100]; // Backed by array

    public void push(char element)
    {
        if(top >= size)
        {
            System.out.println("Overflow stack");
            return;
        }
        top++;
        operatorStack[top] = element;
    }

    public char pop()
    {
        if(top == -1)
        {
            System.out.println("Underflow Stack");
            return '#';
        }
        char element = operatorStack[top];
        top--;
        return element;
    }
    public char peek()
    {
        return operatorStack[top];
    }

    public boolean isEmpty()
    {
        return top == -1;
    }
}