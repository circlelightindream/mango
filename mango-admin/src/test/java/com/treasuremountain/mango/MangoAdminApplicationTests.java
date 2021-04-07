package com.treasuremountain.mango;

import com.treasuremountain.mango.admin.MangoAdminApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@SpringBootTest(classes = MangoAdminApplication.class)
class MangoAdminApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {

        Set<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        treeSet.add("HashSet");
        treeSet.add("ArrayList");
        treeSet.add("TreeMap");
        treeSet.add("LinkedList");
        System.out.println("按升序排序：");
        for (String string :
                treeSet) {
            System.out.println(string + " ");
        }
    }

}
