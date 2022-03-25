package ArrayListModification;

import java.util.*;

import java.lang.*;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {

        /*Stack< Integer> st = new Stack< >();
        st.push(10);

        System.out.println(st + "->" + st.peek() + " " + st.size());
        st.push(20);
        System.out.println(st + "->" + st.peek() + " " + st.size());
        st.push(30);
        System.out.println(st + "->" + st.peek() + " " + st.size());
        st.push(40);
        System.out.println(st + "->" + st.peek() + " " + st.size());
        System.out.println("Is Stack Empty: " + st.empty());
        st.pop();
        System.out.println(st + "->" + st.peek() + " " + st.size());
        st.pop();
        System.out.println(st + "->" + st.peek() + " " + st.size());
        st.pop();
        System.out.println(st + "->" + st.peek() + " " + st.size());
        st.pop();
        System.out.println(st + "->" + " " + st.size());*/


        /*Queue<Integer> queue = new ArrayDeque<>();


        //System.out.println(queue);
        System.out.println(queue.peek());

       System.out.println(queue);
        System.out.println(queue.poll());*/
        //Poll - Element remove bhi kardenga
        //Peek - Element remove nahi karenga
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList1 = new ArrayList<>();


        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);


        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(3);

        HashSet<ArrayList> set = new HashSet<>();
       set.add(arrayList);
       set.add(arrayList1);
        System.out.println(set);

    }
}
