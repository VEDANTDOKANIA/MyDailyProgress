package StackQueueAdapter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class queue_stack {

    static Queue<Integer> Helper = new LinkedList<Integer>();
    static Queue<Integer> queue = new LinkedList<Integer>();

    // To maintain current number of
    // elements
    static int curr_size;

    queue_stack()
    {
        curr_size = 0;
    }

    static void push(int value)
    {
        curr_size++;

        // Push x first in empty q2
        queue.add(value);

        // Push all the remaining
        // elements in q1 to q2.
        while (!Helper.isEmpty()) {
            queue.add(Helper.peek());
            Helper.remove();
        }

        // swap the names of two queues
        Queue<Integer> q = Helper;
        Helper = queue;
        queue = q;
    }

    static void pop()
    {

        // if no elements are there in q1
        if (Helper.isEmpty())
            return;
        Helper.remove();
        curr_size--;
    }

    static int top()
    {
        if (Helper.isEmpty())
            return -1;
        return Helper.peek();
    }

    static int size()
    {
        return curr_size;
    }



    public static void main(String[] args)
    {
        queue_stack s = new queue_stack();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size: " + s.size());
        Stack<Integer> stack = new Stack<>();
    }

}
