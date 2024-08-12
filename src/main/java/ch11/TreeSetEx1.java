package ch11;

import java.util.TreeSet;

public class TreeSetEx1 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet<>();

        String from = "b";
        String to = "d";

        set.add("abc");
        set.add("alien");
        set.add("bat");
        set.add("Car");
        set.add("car");
        set.add("disc");
        set.add("dance");
        set.add("dzzzz");
        set.add("dZZZZ");
        set.add("elephant");
        set.add("elevator");
        set.add("fan");
        set.add("flower");

        System.out.println(set);
        System.out.println("range search : from" + from + " to" + to);
        // subSet을 이용해서 범위검색을 할 때 시작범위는 포함되지만, 끝 범위는 포함되지 않는다.
        System.out.println("result1 :" + set.subSet(from, to) );
        System.out.println("result1 :" + set.subSet(from, to+"zzz"));

    }
}
