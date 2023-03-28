package code.collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class HashTestTest2 {

    @Test
    public void test1(){

        Set<String>  hash1 = new HashSet<>();
        hash1.add("1");
        hash1.add("2");
        hash1.add("3");

        Set<String>  hash2 = new HashSet<>();
        hash2.add("1");
        hash2.add("4");
        hash2.add("5");

        hash1.addAll(hash2);
        System.out.println(hash1.toString());



    }

}
