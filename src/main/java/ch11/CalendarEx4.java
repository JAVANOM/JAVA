package ch11;

import java.sql.SQLOutput;
import java.util.Calendar;

public class CalendarEx4 {
    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();

        date.set(2024, 7, 31); //2005.8.31
        System.out.println(toString(date));

        System.out.println("= 1주일 후 =");
        date.add(Calendar.DATE,1);
        System.out.println(toString(date));

        System.out.println("= 6달 전 =");
        date.add(Calendar.MONTH,-6);
        System.out.println(toString(date));

        System.out.println("= 31일 후 (roll) =");
        date.roll(Calendar.DATE, 31); // 월이나 연도를 넘어가지 않도록 한다, 예외적으로 말일 월필드가 변경
        System.out.println(toString(date));

        System.out.println("= 31일 후 (add) =");
        date.add(Calendar.DATE,31);
        System.out.println(toString(date));

    }
    public static String toString(Calendar date) {
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH) + 1;
        int day = date.get(Calendar.DATE);

        return year + "-" + month + "-" + day;

    }
}
