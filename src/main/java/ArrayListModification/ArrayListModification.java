package ArrayListModification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListModification {
    public static void main(String[] args) {
     /*   List<Integer> arraylist = new ArrayList<>();
        arraylist.add(10);
        arraylist.add(20);
        arraylist.add(30);
        arraylist.add(40);
        arraylist.add(50);
        arraylist.add(60);
        Iterator<Integer> iterator = arraylist.listIterator();
        while(iterator.hasNext()){
            int value = iterator.next();
            System.out.println("......");
           int valuetoremove = iterator.next();
            //System.out.println(valuetoremove);
            if(value==30){
                iterator.remove();
            }
        }

        int count=0;
        for (int i:arraylist)
        {

            if (i ==30)
            {
                arraylist.remove(count);
            }

            count++;
        }
        System.out.println(arraylist);*/
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(100);
        arrayList.add(200);

        for (Integer element:arrayList) {
            if(element==20){
                arrayList.remove(element);
            }
        }
        System.out.println(arrayList);





      /*  List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(7);
        list.add(10);
        list.add(50);
        list.add(80);
        list.add(70);
        list.add(100);


        for(Integer element : list)
        {
            list.indexOf(element);


        }

        System.out.println(list); //[5, 8, 8, 10, 15, 20, 25]
        for (int i = 0; i < list.size(); i++) {
            // if (l.equals(8))
            System.out.println("List value of : "+ list.get(i) +i);
            if (list.get(i).equals(8)){
                list.remove(i);
                //      list.add(i+1,9); //[5,9,9,10]
            }
        }
        System.out.println(list);//[5, 10]*/

        }
    }


