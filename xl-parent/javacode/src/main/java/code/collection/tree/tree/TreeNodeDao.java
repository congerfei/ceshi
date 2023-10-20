package code.collection.tree.tree;

import code.object.Person;

public class TreeNodeDao {

    private TreeNode rootNode;
    /**
     *  默认是已经排序，例如升序，左边比父小，右边比父大
     *
     *
     * @param node
     */
    public TreeNode find(TreeNode<Person> node){
        TreeNode<Person> current = rootNode;
        while(current != node){
            if(node.getT().getAge()<current.getT().getAge() ){
                //节点比当前要对比的节点小,此时设置下一个要对比的节点为左节点
                current = current.left;
            }else if(node.getT().getAge() > current.getT().getAge()){
                current = current.right;
            }
        }

            return current;


    }

    public void insert(TreeNode<Person> node){
        if(rootNode == null){
            rootNode = node;
        }else{
            TreeNode<Person> current = rootNode;
            while(current != node){
                if(node.getT().getAge()<current.getT().getAge() ){
                    //节点比当前要对比的节点小,此时设置下一个要对比的节点为左节点
                    current = current.left;
                }else if(node.getT().getAge() > current.getT().getAge()){
                    current = current.right;
                }
            }

        }
    }


    public void delete(TreeNode node){

    }

    /**
     * 查询某个节点下面所以得节点，如果是root则输出所有的节点
     * @param node
     */
    public void all(TreeNode node){

    }




}
