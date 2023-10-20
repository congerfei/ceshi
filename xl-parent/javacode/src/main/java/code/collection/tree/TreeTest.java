package code.collection.tree;

import code.collection.tree.tree.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

/**
 *  二叉搜索数：
 *  遍历树是一种特定的顺序访问树的每一个节点，比较常用的有前序遍历、中序遍历和后续遍历。而二叉搜索树最常用的就是 中序遍历 ，
 *  相对于根节点而言的，根节点先遍历就是前序遍历，根节点在中间就说中序遍历，根节点在后面就是后续遍历的，左节点永远比右节点先遍历
 *
 *  随便给一个队列(可以是无序的)，经过二叉树后 然后进行中序遍历 都是排序好的序列，
 *  极端情况下，二叉搜索树 退化成链表，此时引入AVL树概念
 *  向AVL树中插入一个节点后，树的所有节点的左右孩子节点的高度差的绝对值小于等于1. 即左右树的层级高度不能相差大于1
 *
 *  每次插入都容易影响平衡，于是就引出了红黑树概念
 *  红黑树：1.根是黑色 2.红色节点的子节点都是黑色 3.叶子节点（外部节点，空节点）都是黑色  4.从任一节点到叶子节点的所有路径都包含相同数目的黑色节点
 *  红黑树可以自平衡，它靠的是什么？三种操作：左旋、右旋和变色
 * 变色：节点的颜色由红变黑或由黑变红
 * 左旋：以某个节点作为支点(旋转节点)，其右子节点变为旋转节点的父节点，右子节点的左子节点变为旋转节点的右子节点，左子节点保持不变。
 * 右旋：以某个节点作为支点(旋转节点)，其左子节点变为旋转节点的父节点，左子节点的右子节点变为旋转节点的左子节点，右子节点保持不变
 *
 *
 * 红黑树保证最长路径不超过最短路径的二倍，因而近似平衡（最短路径就是全黑节点，最长路径就是一个红节点一个黑节点，当从根节点到叶子节点的路径上黑色节点相同时，最长路径刚好是最短路径的两倍
 * 每一个节点都是有一个或者2个null节点的  距离是根节点到空节点的个数
 */
@Slf4j
public class TreeTest {

    @Before
    public void before(){
        TreeNode<Integer> root = new TreeNode<>(0);
        TreeNode<Integer> left1 = new TreeNode<>(-2);
        TreeNode<Integer> right1 = new TreeNode<>(4);

    }

    /**
     * 递归打印N的阶乘
     */
    @Test
    public void test1(){
        log.info("请输入一个正整数N");
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine(); //在Test下面可能不生效 需要在edit custom VM Options 配置 -Deditable.java.test.console=true
        int n = Integer.parseInt(next.trim());
        int tmp= 1;
        int total=0;
        while(tmp<=n){
            log.info("tmp此时的值："+tmp);
            total = tmp * tmp++;
        }
        log.info("总数："+total);

    }




}
