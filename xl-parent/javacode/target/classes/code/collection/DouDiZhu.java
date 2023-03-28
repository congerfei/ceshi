package code.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Author: xl
 * date :2020/12/29 10:57
 * description:斗地主洗牌
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class DouDiZhu {
    public static void main(String[] args) {
        // 创建HashMap，键是编号，值是牌面
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        // 创建ArrayList，存储编号
        ArrayList<Integer> array = new ArrayList<Integer>();
        // 创建花色数组和点数数组
        String[] colors = { "♦", "♣", "♥", "♠" };
        String[] numbers = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };
        // 从0开始往HashMap里面存储编号并存储对应的牌面，同时往ArrayList里面存储编号
        int index = 0;
        for (String number : numbers) {
            for (String color : colors) {
                hm.put(index, color + number);
                array.add(index);
                index++;
            }
        }
        hm.put(index, "小王");
        array.add(index);
        index++;
        hm.put(index, "大王");
        array.add(index);
        // 洗牌(洗的是编号)
        Collections.shuffle(array);
        // 发牌(发的是编号)
        TreeSet<Integer> playerSet1 = new TreeSet<Integer>();
        TreeSet<Integer> playerSet2 = new TreeSet<Integer>();
        TreeSet<Integer> playerSet3 = new TreeSet<Integer>();
        TreeSet<Integer> dpSet = new TreeSet<Integer>();
        for (int i = 0; i < array.size(); i++) {
            int x = array.get(i);
            if (i >= array.size() - 3) {
                dpSet.add(x);
            } else if (i % 3 == 0) {
                playerSet1.add(x);
            } else if (i % 3 == 1) {
                playerSet2.add(x);
            } else if (i % 3 == 2) {
                playerSet3.add(x);
            }
        }
        // 调用看牌方法
        lookPoker("player1", playerSet1, hm);
        lookPoker("player2", playerSet2, hm);
        lookPoker("player3", playerSet3, hm);
        lookPoker("dp", dpSet, hm);
    }

    /**
     * 看牌方法
     * @param name 玩家名称
     * @param ts   牌面编号
     * @param hm   牌面集合
     */
    public static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
        System.out.print(name + ": ");
        for (Integer key : ts) {
            String poker = hm.get(key);
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
