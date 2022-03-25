package Regex_Log_Parser;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Path path = Paths.get("/home/vedant/JunitMaven/src/main/java/logs.txt");

        String FileValue = null;
        try {
            FileValue = String.valueOf(Files.readAllLines(path));
        } catch (Exception E) {
            System.out.printf(String.valueOf(E));
        }
        String Filedata = FileValue.replaceAll("\n","\t");
        Filedata = Filedata.replaceAll(",,",",");
        String str = "\\{,";
        Filedata =Filedata.replaceAll(str,"{");
        System.out.println(Filedata);

            /*JSONObject jsonObject = new JSONObject(FileValue.substring(1));// FIle se json object read ho raha hain
            HashMap<String, Object> configmap = (HashMap<String, Object>) jsonObject.toMap();*/


            // Create a pattern from regex
            Pattern pattern
                    = Pattern.compile("\\d+\\-\\w+\\-\\d+\\s+\\d+\\s+\\d+\\:\\d+\\:\\d+\\.\\d+\\s+\\w+\\s+\\[\\w+\\]");

            Matcher matcher = pattern.matcher(Filedata);

            // Create a matcher for the input String



        int count =0;
        int index =0;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        while (matcher.find()) {
            if(count ==0){
                ArrayList<Integer> arrInner = new ArrayList<>();
                index = Filedata.indexOf(matcher.group(0));
                arrInner.add(index);
                int length = matcher.group(0).length();
                arrInner.add(length);
                arrayLists.add(arrInner);
            }
            else{
                ArrayList<Integer> arrInner = new ArrayList<>();
                index = Filedata.indexOf(matcher.group(0),index+1);
                arrInner.add(index);
                int length = matcher.group(0).length();
                arrInner.add(length);
                arrayLists.add(arrInner);;

            }
            count++;
        }
        ArrayList<String> BlockData = new ArrayList<>();
        for(int i =0 ;i<arrayLists.size()-1;i++){
            ArrayList<Integer> arr1 = arrayLists.get(i);
            ArrayList<Integer> arr2 = arrayLists.get(i+1);
            if(i==0){
                int startIndex = arr1.get(1)+2;
                int EndIndex = arr2.get(0)-2;
                String st = Filedata.substring(startIndex,EndIndex);
                BlockData.add(st);
            }else{
                int startIndex = arr1.get(0)+arr1.get(1);
                int EndIndex = arr2.get(0)-2;
                String st = Filedata.substring(startIndex,EndIndex);
                BlockData.add(st);
            }

           /* for(String strnew:BlockData){
                System.out.println(strnew);
            }*/
        }

       /* JSONObject jsonObject = new JSONObject();// FIle se json object read ho raha hain
        HashMap<String, Object> configmap = (HashMap<String, Object>) jsonObject.toMap();
        System.out.printf(String.valueOf(configmap));*/

        }
    }
