package HashmapFunctions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class HashmapFunction implements Serializable {

    public static void main(String[] args) {

        HashMap<Integer,String > hashMap = new HashMap<>();
        HashMap<Integer,String > hashMapCopy = new HashMap<>();
        hashMap.put(1,"vedant");
        hashMap.put(2,"Pruthvi");
        hashMap.put(3,"umang");
        hashMap.put(4,"Aadarsh");
        /*hashMapCopy.put(1,"vedant");
        hashMapCopy.put(2,"Pruthvi");
        hashMapCopy.put(3,"umang");
        hashMapCopy.put(4,"Aadarsh");*/
        System.out.println(hashMap);
        //System.out.println(hashMap.get(1));
        // No change
        hashMap.computeIfAbsent(1,k->"abc");

        hashMap.computeIfAbsent(5,k->"abc");
        System.out.println(hashMap);

        hashMap.computeIfPresent(1,(key,value)->"abc");
        System.out.println(hashMap);
        hashMap.computeIfPresent(6,(key,value)->"abc");
        System.out.println(hashMap);

        hashMap.compute(1,(key,value)->"def");
        System.out.println(hashMap);
        hashMap.compute(7,(key,value)->"def");
        System.out.println(hashMap);
        hashMap.compute(null,(key,value)->"def");
        System.out.println(hashMap);
        System.out.println(hashMap.get(null));
        hashMap.compute(null,(key,value)->null);
        System.out.println(hashMap);
        /*hashMap.compute(1,(key,value)->null);
        System.out.println(hashMap);*/
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.getClass());
        /*hashMap.clear();
        System.out.println(hashMap);*/
        hashMap.replace(1,"abc");
        System.out.println(hashMap);


        hashMap.putAll(hashMapCopy);
        System.out.println(".....");
        System.out.println(hashMap);
        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.containsValue("vedant"));

        hashMap.replaceAll((key,value)->value.toUpperCase(Locale.ROOT));
        System.out.println(hashMap);
        /*String value = hashMap.getOrDefault(2,"DefaultValue"); //Value already there
        System.out.println(value);
        String valuenew = hashMap.getOrDefault(100,"100 is not there");
        System.out.println(valuenew);*/

        /*hashMap.forEach((key,value)-> {
                    value = value.concat("ABC");
                    //hashMap.put(key,value);
                }

                );*/
        System.out.println(hashMap);

            // create a HashMap
        List<Integer> list = new ArrayList<>();
        int[] Lastkey = new int[1];
      int count =0;

    hashMap.forEach((key,value)-> {
       // list.add(Integer.valueOf(value));
        Lastkey[0] = key;
        System.out.println(Lastkey[0]);
    });
        System.out.println(list);
        System.out.println(Lastkey[0]);
        Lastkey[0] = 20;
        System.out.println(Lastkey[0]);


    }


}
