package ch11;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx1 {
    public static void main(String[] args) {

        HashMap map = new HashMap();
        map.put("castello", "1234");
        map.put("daniel", "1111");
        map.put("daniel", "1234");

       Scanner s = new Scanner(System.in);
       while(true) {
           System.out.println("id와password를 입력해주세요");
           System.out.println("id:");
           String id = s.nextLine().trim();
           System.out.println("password:");
           String password = s.nextLine().trim();
           System.out.println();

           if (!map.containsKey(id)) {
               System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요");
               continue;
           } else {
               if(!password.equals(map.get(id))) {
                   System.out.println("입력하신 Password와 일치하지 않습니다. 다시 입력해주세요");
               }else{
                   System.out.println("id와 password과 일치합니다.");
                   break;
               }

           }
       }//while

    }//main



}
