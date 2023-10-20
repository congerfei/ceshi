package code.collection.tree.tree;


import code.object.Person;

public class TreeNode<T> implements Comparable<T> {

    T t;

    TreeNode left;

    TreeNode right;

    public TreeNode(){

    }

    public TreeNode(T t) {
        this.t = t;
    }


    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public int compareTo(T o) {
        Person per = (Person) t;
        Person other = (Person) o;
        return per.getAge() > other.getAge() ? 1 : 0;
    }
}
