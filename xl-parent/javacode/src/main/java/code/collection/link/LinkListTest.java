package code.collection.link;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkListTest {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList<>(); //单链表

        linkedList.add("string");

        Iterator iterator = linkedList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

}
