package ch11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx3 {
    public static void main(String[] args) {

        String source = "HP:011-1111-1111, HOME:02-999-9999";
        String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);

        // 괄호를 이용해 정규식을 세부분으로 나눔, group() 사용하여 그룹을 반환가능, group(), group(0)은 전체를 나타냄
        // find()는 주어진 소스 내에서 패턴과 일치하는 부분을 찾아내면 true를 반환하고 찾지못하면 false 반환
        int i = 0;
        while (m.find()) {
            System.out.println(++i + ": " + m.group() + " -> " + m.group(1) + ", " + m.group(2) + ", " + m.group(3));
        }
    }
}
