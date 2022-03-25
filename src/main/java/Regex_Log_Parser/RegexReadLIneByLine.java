package Regex_Log_Parser;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReadLIneByLine{
    public static void main(String[] args){
        File file = new File("/home/vedant/JunitMaven/src/main/java/logs.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            Pattern pattern
                    = Pattern.compile("\\d+\\-\\w+\\-\\d+\\s+\\d+\\s+\\d+\\:\\d+\\:\\d+\\.\\d+\\s+\\w+\\s+\\[\\w+\\]");
            int count=0;
            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<String> arrayList = new ArrayList<>();
            while((line=bufferedReader.readLine())!=null){
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()){
                    count++;
                    arrayList.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }else{
                    stringBuilder.append(line);
                }

            }
            System.out.println(count);
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }
}
