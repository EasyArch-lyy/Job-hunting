package leetcode;


/**
 *  现有一个 3x3 规格的 Android 智能手机锁屏程序和两个正整数 m 和 n ，请计算出使用最少m 个键和最多 n个键可以解锁该屏幕的所有有效模式总数。
 * 其中有效模式是指：
 * 1、每个模式必须连接至少m个键和最多n个键；
 * 2、所有的键都必须是不同的；
 * 3、如果在模式中连接两个连续键的行通过任何其他键，则其他键必须在模式中选择，不允许跳过非选择键（如图）；
 * 4、顺序相关，单键有效（这里可能跟部分手机不同）。
 */

/**
 * 点类
 */
class Point{
   /**
    *点的位置类型
    * 1--角点
    * 2--边点
    * 3--心点
    */
    private int kind;
   /**
    * 点的数量
    */
    private int num;
   /**
    * 下一个点可选的数量
    */
    private int nextNum;
   /**
    * 下一个点
    */
    private Point nextPoint;

    public Point(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public void test(Point point){
        if(point.num>1){
            if(point.kind==1){
                nextNum=5;
                point.
                test(point.nextPoint);
            }else if(point.kind==2){
                nextNum=7;
            }else {
                nextNum=8;
            }
        }
    }
}

/**
 * @author lyy
 */
public class Test5 {
    public int get(int m,int n){
        Point point=new Point(m);

        int a=0;
        //角点有5个可连接点
        int i=5;
        //边点有6个可连接点
        int j=6;
        if(m==1){
            i=5;
            j=6;
        }
        switch (m){
            case 1:
                a=9;
                break;
            case 2:
                a=56+9;
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;

        }
        return a;
    }
}