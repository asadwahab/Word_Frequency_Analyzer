import utility.KeywordCount;
import utility.fileutility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

// in java we can't use multiple classes simultaneously but interface can, that why
//we are using runnable
public class FileReaderRunnable implements Runnable{
    public String Filename;
    public int filesize;

    public FileReaderRunnable(String Filename){
       this.Filename=Filename;
    }

    @Override
    public void run() {

        ArrayList<String> lines = fileutility.readandsaveittoList(Filename);

        Map<String, Integer> keywordCounter = new HashMap<>();

        for (String line : lines) {
            String[] words = line.split("\\s+"); // Split the line into words
            for (String word : words) {
                word = word.toLowerCase(); // Convert to lowercase to avoid case sensitivity
                if (!keywordCounter.containsKey(word)) {
                    keywordCounter.put(word, 1);
                } else {
                    Integer value = keywordCounter.get(word);
                    keywordCounter.put(word, value + 1);
                }
            }
        }

        // Create and sort the keyword count list
        ArrayList<KeywordCount> keywordCountArrayList = new ArrayList<>();
        for (String keyword : keywordCounter.keySet()) {
            KeywordCount keywordCount = new KeywordCount(keyword, keywordCounter.get(keyword));
            keywordCountArrayList.add(keywordCount);
        }
        Collections.sort(keywordCountArrayList, new Comparator<KeywordCount>() {
            @Override
            public int compare(KeywordCount o1, KeywordCount o2) {
                if(o2.count==o1.count){
                    return o1.keyword.compareTo(o2.keyword);
                }
                return o2.count-o1.count;
            }
        });


        for (KeywordCount keywordCount:keywordCountArrayList){
            System.out.println(keywordCount.keyword +" "+ keywordCount.count);
        }
    }
    public static void main(String[] args) {
        FileReaderRunnable National=new FileReaderRunnable("C:/Users/user/IdeaProjects/TechCodingMafia/data/file/"+"NationalAnthem.txt");
        Thread runnable1=new Thread(National);
        runnable1.start();
    }

}
