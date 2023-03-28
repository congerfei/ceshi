package code.collection.stack;

import java.util.Stack;

/**
 * 栈结构 ，使用数组或者链表进行实现的
 *  java.util.Stack 中是通过继承Vector  ，而Vector是继承
 *
 */
public class StackTest {

    public static void main(String[] args) {

        Stack<Object> stack1 = new Stack<>();
        stack1.push("1");
        stack1.push("2");
        Object peek = stack1.peek();
        System.out.println(peek);//查看当前栈顶对象



        Object pop = stack1.pop();
        System.out.println(pop);//查看当前出栈对象


    }


}




