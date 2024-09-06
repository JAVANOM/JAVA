package ch14;

import java.io.BufferedReader;
import java.io.FileReader;

//문자기반의 보조스트림
// 입출력의 효율을 높이는 역할
public class BufferedReaderEx1 {
    public static void main(String[] args) {


        //System.out.println("Current working directory: " + System.getProperty("user.dir"));
        try {
            FileReader fr = new FileReader("BufferedReaderEx1.java");
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            for (int i = 0; (line = br.readLine()) != null; i++) {
                // ";" 를 포함한 라인을 출력한다.
                if(line.indexOf(";") != -1)
                    System.out.println(i + ":" +line);
            }
            br.close();
            
        }catch (Exception e){
            e.printStackTrace();
        }

    }// main
}
