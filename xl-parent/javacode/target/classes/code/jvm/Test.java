package code.jvm;

public class Test {
    public static void main(String[] args) {
        int i=1;
        i=i++;//i的值是不会变的，将i的值1 赋值给i 之前的i变成2，但是后面用的都是新的i
        i=i++;
        System.out.println(i);
    }
}
