package StackQueueAdapter;

import java.util.Stack;
public class Stack_queue {
   static Stack<Integer> Helperstack = new Stack<>();
   static Stack<Integer> stack = new Stack<>();

   static void enQueue(int value){
       while (!Helperstack.isEmpty())
       {
           stack.push(Helperstack.pop());
           //s1.pop();
       }

       Helperstack.push(value);

       // Push everything back to helper
       while (!stack.isEmpty())
       {
           Helperstack.push(stack.pop());

       }
   }
    static int deQueue()
    {
        // if first stack is empty
        if (Helperstack.isEmpty())
        {
            System.out.println("Q is Empty");
            System.exit(0);
        }

        // Return top of Helperstack
        int x = Helperstack.peek();
        Helperstack.pop();
        return x;
    }

    public static void main(String[] args){
       Stack_queue queue = new Stack_queue();
       queue.enQueue( 5);
        queue.enQueue( 10);
        queue.enQueue( 15);
        queue.enQueue( 20);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }


}
