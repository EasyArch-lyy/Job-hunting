package data_struct.tree;

/**
 * 二叉树
 * @author lyy
 */
public class Tree {

    /**每一个节点的值*/
    public Integer data;
    /**根节点(有且仅有一个)*/
    public static Tree root;
    /**父节点*/
    public Tree father;
    /**左子节点*/
    public Tree leftSon;
    /**右子节点*/
    public Tree rightSon;
    
    /**左树是否为空*/
    public boolean hasLeftSon(){
        return leftSon!=null;
    }
    /**右树是否为空*/
    public boolean hasRightSon(){
        return rightSon!=null;
    }
    /**插入节点*/
    public void insert(Integer data,Tree father){
        /**
         * 思想：先让data和root中的值进行比较，大于0插入右边，小于0插入左边，计划使用递归思想
         */
        //等于root.data
        if(data.compareTo(father.data)==0){
            return;
        }
        //大于root.data
        if(data.compareTo(father.data)>0){
            //父节点没有右节点
            if(!father.hasRightSon()){
                //生成一个右节点
                father.rightSon = new Tree();
                //给右节点赋值
                father.rightSon.data=data;
                //指定右节点的父亲是谁
                father.rightSon.father=father;
            }else{
                insert(data,father.rightSon);
            }
        }
        
        //小于同上
        if(data.compareTo(father.data)<0){
            //父节点没有左节点
            if(!father.hasLeftSon()){
                //生成一个右节点
                father.leftSon = new Tree();
                //给右节点赋值
                father.leftSon.data=data;
                //指定右节点的父亲是谁
                father.leftSon.father=father;
            }else{
                insert(data,father.leftSon);
            }
        }
    }
    
    /**
     * 总体插入操作
     * 1.判断是否有树根，没有的话将数据添加到树根里
     * 2.有树根调用insert的重载方法，判断插入到左son还是右son
     * @param data
     */
    public void insert(Integer data){
        if(root==null){
            root = new Tree();
            root.data=data;
            return;
        }else{
            insert(data,root);
        }
    }
}