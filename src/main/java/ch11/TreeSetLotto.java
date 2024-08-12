package ch11;

import java.util.Set;
import java.util.TreeSet;

//이진검색트리는
// - 모든 노드는 최대 두개의 자식노드를 가질 수 있다.
// - 왼쪽 자식노드의 값은 부모노드의 값보다 작고 오른쪽자식노드의 값은 부모노드의 값보다 커야한다.
// - 노드의 추가 삭제에 시간이 걸인다.(순차적으로 저장하지 않으므로)
// - 검색과 정렬에 유리하다.
public class TreeSetLotto {
    public static void main(String[] args) {

        Set set = new TreeSet<>();

        for (int i = 0; set.size() < 6; i++) {
            int num = (int)(Math.random()*45)+1;
            set.add(num);
        }
        System.out.println(set);
    }

}
