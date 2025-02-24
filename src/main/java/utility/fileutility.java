package utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileutility {
    public static boolean createfile(String Filenamewithpath){
        File file= new File(Filenamewithpath);
        boolean filecreated=false;
        try {
            filecreated= file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filecreated;
    }
    public static void readandprintfile(String filename) {
        Scanner scanner=null;
        try{
            File file=new File(filename);
            scanner =new Scanner(file);
            while(scanner.hasNext()){
                String line=scanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if(scanner!=null){
                scanner.close();
            }
        }

    }
    public static ArrayList<String> readandsaveittoList(String filename) {
        ArrayList<String> strings = new ArrayList<String>();
        Scanner scanner = null;
        try {
            File file = new File(filename);
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                strings.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return strings;
    }
    public static void main(String[] args) {
        String Filename="C:/Users/user/IdeaProjects/TechCodingMafia/data/file/"+"NationalAnthem.txt";
        boolean created=createfile(Filename);
        System.out.println("File created"+created);
        readandprintfile(Filename);
        ArrayList<String>array=readandsaveittoList(Filename);
        System.out.print(array.size());

    }


}
