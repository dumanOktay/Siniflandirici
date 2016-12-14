import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by okt on 12/13/16.
 */
public class MyFile {
    String fileName;
    String content;

    List<String> wordList = new ArrayList<>();

    List<Line> lineList = new ArrayList<>();


    HashMap<String,Float> olasilikHashMap;
    HashMap<String,Float> categorySonucHashMap;
    MyFile(String fileName) {
        this.fileName = fileName;

        olasilikHashMap = new HashMap<>();

        categorySonucHashMap = new HashMap<>();
        this.content="";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
//                System.out.println(sCurrentLine);
                content+=sCurrentLine;
                Line line = new Line(sCurrentLine);
                System.out.println(line);
                lineList.add(line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String,Integer> categoryHashMap = new HashMap<>();
        for (Line l:lineList){

            for (String s:l.words){
                if (!wordList.contains(s)){
                    wordList.add(s);
                }
            }

            if (categoryHashMap.containsKey(l.category)){
                int j = categoryHashMap.get(l.category);

                j++;
                categoryHashMap.put(l.category,j);
                System.out.println(" Category "+ l.category + "  "+ j);

            }else {
                System.out.println(" Category "+ l.category + "  "+ 1);
                categoryHashMap.put(l.category,1);
            }
        }

        for (String key:categoryHashMap.keySet()){
            float dd = (float)categoryHashMap.get(key)/(float) lineList.size();

            System.out.println(" Cate "+ key +" : "+dd);
            categorySonucHashMap.put(key, dd);
           for (String s:wordList){
               int syay=0; int wordCount = 0;
               for (Line l:lineList){
                   if (l.category.equalsIgnoreCase(key)){
                      for (String w:l.words){
                          wordCount++;
                          if(w.equalsIgnoreCase(s)){
                              syay++;
                          }
                      }

                   }
               }
               float oran = (float)(syay+1)/((float)wordCount+ wordList.size());
               System.out.println("  : "+ s+" : "+( syay+1) +" oran : " +oran);
               String myKey =s+"_"+key;
               olasilikHashMap.put(myKey,oran);

           }
        }
    }

    public void kiyasla(Line line){
        double deger = 1d;
        double degers[] = new double[categorySonucHashMap.size()];
        int index =0;
        for (String key:categorySonucHashMap.keySet()){
            deger = 1d;
            for (String w:line.words){
               if (olasilikHashMap.containsKey(w+"_"+key) ){
                   System.out.println(" Oran   "+olasilikHashMap.get(w+"_"+key) );
                   deger = deger*olasilikHashMap.get(w+"_"+key);
               }else {

               }
            }
            deger = deger*categorySonucHashMap.get(key);
            degers[index] = deger;
            System.out.println(" Değer "+ String.format("%.100f", deger));
            index++;
        }

    }


    public String getContent() {
        return content;
    }
}
