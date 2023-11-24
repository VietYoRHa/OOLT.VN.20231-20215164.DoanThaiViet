package hust.soict.hedspi.lab03.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args){
        String fileName = "src/hust/soict/hedspi/lab03/test.txt";
        long startTime, endTime;

        try {
            //Read file
            String inputString = readFile(fileName);

            //String
            startTime = System.currentTimeMillis();
            String s = "";
            for (int i = 0; i < inputString.length(); i++){
                s += inputString.charAt(i);
            }
            endTime = System.currentTimeMillis();
            System.out.println("String: " + (endTime - startTime));

            //StringBuilder
            startTime = System.currentTimeMillis();
            StringBuilder sbd = new StringBuilder();
            for (int i = 0; i < inputString.length(); i++){
                sbd.append(inputString.charAt(i));
            }
            s = sbd.toString();
            endTime = System.currentTimeMillis();
            System.out.println("StringBuilder: " + (endTime - startTime));

            //StringBuffer
            startTime = System.currentTimeMillis();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < inputString.length(); i++){
                sbf.append(inputString.charAt(i));
            }
            s = sbf.toString();
            endTime = System.currentTimeMillis();
            System.out.println("StringBuffer: " + (endTime - startTime));

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String readFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return String.join("", Files.readAllLines(path));
    }
}
