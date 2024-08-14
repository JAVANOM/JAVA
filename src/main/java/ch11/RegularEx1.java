package ch11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx1 {
    public static void main(String[] args) {
        String[] data = {"bat", "bady", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count",
        "date", "disc"};
        // Pattern은 정규식을 정의하는데 사용
        Pattern p = Pattern.compile("c[a-z]*"); //c로 시작하는 소문자열 단어
        // Macher 정규식 패턴을 데이터와 비교하는 역항
        for (int i = 0; i < data.length; i++) {
            Matcher m = p.matcher(data[i]);
            if(m.matches()){
                System.out.print(data[i] + ",");
            }
        }
    }
}