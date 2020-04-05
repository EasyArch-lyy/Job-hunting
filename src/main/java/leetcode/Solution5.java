package leetcode;


/**
 * @author lyy
 */
public class Solution5 {
    private int a=0;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void run(TreeNode root) {
        int b=0;
        if(root.left!=null){
            a++;
            run(root.left);
        }else if(root.right!=null){
            a++;
            run(root.right);
        }
        //return b;
    }
    public static void main(String[]args){
        Solution5 s=new Solution5();
        System.out.println(s.getA());
    }
}
