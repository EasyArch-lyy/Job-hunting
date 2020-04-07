package encoder;

/**
 * 不使用库函数十进制转二进制
 * @author lyy
 */
public class Binary {

    public static String testBinary(int n){
        char a[]=new char[32];
        int i=0;
        while (n>0){
            a[i++]=(char)(n%2+48);
            n=n>>1;
        }
        StringBuffer str=new StringBuffer();
        for(i=i-1;i>=0;i--){
            //倒取数组转换为字符串
            str.append(a[i]);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(testBinary(2));
    }
}
