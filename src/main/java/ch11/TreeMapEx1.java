package ch11;

import java.util.*;

public class TreeMapEx1 {
    public static void main(String[] args) {
        String[] data = {"A","K","A","K","D","K","A","K","K","Z","D"};

        TreeMap map = new TreeMap();

        for (int i = 0; i < data.length; i++) {
            if(map.containsKey(data[i])){
                Integer value = (Integer)map.get(data[i]);
                map.put(data[i], new Integer(value.intValue()+1));

            }else{
                map.put(data[i], new Integer(1));
            }
        }
        Iterator it = map.entrySet().iterator();
        System.out.println("= 기본정렬 =");
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            int value = ((Integer)entry.getValue()).intValue(); // int로 변환
            System.out.println(entry.getKey()+" : " + printBar('#',value) + " " + value);
        }
        System.out.println();

        Set set = map.entrySet();
        List list = new ArrayList(set); //ArrayList(Collection c)

        //static void sort(List list, Comparator c), list를 비교기를 사용하여 정렬
        Collections.sort(list, new ValueComparator()); //compare 메서드는 자동으로 호출

        it = list.iterator();

        System.out.println("= 값의 크기가 큰 순서로 정렬 =");
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            int value = ((Integer)entry.getValue()).intValue();
            System.out.println(entry.getKey() +" : " + printBar('#',value) + " " + value);
        }

    }// main

    static class ValueComparator implements Comparator{
        public int compare(Object o1, Object o2) {
            if(o1 instanceof Map.Entry && o2 instanceof Map.Entry){
                Map.Entry e1 = (Map.Entry)o1;
                Map.Entry e2 = (Map.Entry)o2;

                int v1 = ((Integer)e1.getValue()).intValue();
                int v2 = ((Integer)e2.getValue()).intValue();

                return v2 - v1; //내림차순. 즉, 값이 큰 항목이 먼저 오도록 합니다.
            }
            return -1;
        }// 반환값에 따라 두 객체의 순서를 결정 / v1이 3이고 v2가 5이면 5 - 3은 양수이므로 e2가 e1보다 앞에 위치
    }// ValueComparator implements Comparator{}

    public static String printBar(char ch, int value){
        char[] bar = new char[value];

        for (int i = 0; i < bar.length; i++) {
            bar[i] = ch;

        }
        return new String(bar);
    }
}
