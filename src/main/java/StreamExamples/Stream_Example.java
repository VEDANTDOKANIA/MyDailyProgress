package StreamExamples;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class Stream_Example {
    public static void main(String[] args) {
        while (true) {

       /* File file = new File("/home/vedant/JunitMaven/src/main/java/Sample_Json");
        StringBuilder fileValue = new StringBuilder();
        fileValue.append("{");
        try{
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((bufferedReader.readLine())!=null){
                fileValue.append(bufferedReader.readLine());

            }
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }*/

            HashMap<Integer, String> hashMap = new HashMap<>();
            hashMap.put(1, "vedant");
            hashMap.put(2, "Pruthvi");
            hashMap.put(3, "umang");
            hashMap.put(4, "Aadarsh");
            //System.out.println(hashMap.entrySet());

            //System.out.println(hashMap.entrySet().stream().filter(value -> value.getValue().equals("vedant")).findFirst());
            List l1 = hashMap.entrySet().stream().
                    map(x -> x.getValue().toUpperCase(Locale.ROOT)).
                    filter(x -> (x.equalsIgnoreCase("vedant") || x.equalsIgnoreCase("pruthvi"))).
                    reduce((s1, s2) -> s1 + "+" + s2).
                    stream().
                    toList();
            System.out.println(l1);
            List l2 = hashMap.entrySet().parallelStream().
                    map(x -> x.getValue().toUpperCase(Locale.ROOT)).
                    toList();
            System.out.println(l2);
            final int[] count = {0};
            int value = 2;

            List l3 = hashMap.entrySet().stream().map(x -> {
                        count[0]++;

                        if (hashMap.size() == 0) {
                            x.getValue().concat("ABC");
                        } else {
                            x.getValue().concat("DEF");
                        }
                        return x;
                    }
            ).toList();
            System.out.println(l3);



        /*System.out.println(fileValue.toString());
        fileValue.append("}");
        JSONObject jsonObject= new JSONObject(fileValue.toString());*/
       /* Map<String, Object> hashMap = new HashMap<>();
        hashMap = jsonObject.toMap();
        System.out.println(hashMap);*/
        }
    }
}
