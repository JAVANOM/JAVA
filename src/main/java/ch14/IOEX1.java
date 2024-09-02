package ch14;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEX1 {
    public static void main(String[] args) {
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;

        //inSrc 입력 소스로 사용
        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;

        while((data = input.read()) != -1){
            output.write(data); // void write(int b)
        }

        outSrc = output.toByteArray(); // 스트림의 내용을 byte 배열로 반환

        System.out.println("Input Source : " + Arrays.toString(inSrc));
        System.out.println("Output Source : " + Arrays.toString(outSrc));

    }
}
