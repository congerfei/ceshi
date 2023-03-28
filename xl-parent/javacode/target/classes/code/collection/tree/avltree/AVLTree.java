package code.collection.tree.avltree;


import java.util.ArrayList;

public class AVLTree {
    /**
     * 根节点
     */
    AVLTreeNode root;

    /**
     *  用于存放节点便于遍历
     */
    ArrayList values = new ArrayList<Integer>();

    /**
     * 添加节点
     * @return
     */
    public boolean add(Integer value){
        //判断是否第一个节点
        if(root == null){

            root = new AVLTreeNode(value);
            values.add(value);
            return true;
        }else {

            /**
             *  如果新增的不是第一个节点 ，我们设置一个要比较的当前节点，默认从root开始比较
             * 要比较的当前节点 先定义为root节点
             */
            AVLTreeNode current = root;
            while(true){
                if(value < current.value){  //和当前节点的值比较，如果小于进入左子树
                    if(current.left == null){
                        //左子树无节点，直接插入
                        current.left = new AVLTreeNode(value);
                        values.add(value);
                        return true;
                    }else{
                        //左子树有节点,则当前节点指向左子树的头节点，然后重新进入循环
                        current = current.left;
                    }
                }else { //进入右子树

                    if(current.right == null){  //右子树无节点，直接插入
                        current.right = new AVLTreeNode(value);
                        values.add(value);
                        return true;
                    }else {   //右子树有节点，则当前节点指向右子树的头节点，然后重新进入循环
                        current = current.right;
                    }
                }
            }

        }

    }


    public void  treetoString() {
        System.out.println(values.toString());;
    }




    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.add(50);
        avlTree.add(20);
        avlTree.add(70);
        avlTree.add(21);
        avlTree.treetoString();
        System.out.println(avlTree.root.value);
        System.out.println(avlTree.root.left.value);
        System.out.println(avlTree.root.right.value);
        System.out.println(avlTree.root.left.right.value);



    }

}
