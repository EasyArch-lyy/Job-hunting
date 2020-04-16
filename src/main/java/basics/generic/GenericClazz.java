package basics.generic;

/**
 * @author lyy
 */
public class GenericClazz<T> {

    /**key这个成员变量的类型为T,T的类型由外部指定*/
    private T key;

    /**泛型构造方法形参key的类型也为T，T的类型由外部指定*/
    public GenericClazz(T key){
        this.key=key;
    }

    /**泛型方法getKey的返回值类型为T，T的类型由外部指定*/
    public T getKey(){
        return key;
    }

    public static void main(String[] args) {
        GenericClazz<Integer>genericInter=new GenericClazz<>(123456);
        GenericClazz<String>genericString=new GenericClazz<>("key_value");
        System.out.println("泛型测试key is "+genericInter.getKey());
        System.out.println("泛型测试key is "+genericString.getKey());
        GenericClazz<Integer>gInteger=new GenericClazz<>(123);
        GenericClazz<Number>gNumber=new GenericClazz<>(456);
        showKeyValue1(gNumber);
        showKeyValue2(gInteger);
    }

    private static void showKeyValue1(GenericClazz<Number>obj){
        System.out.println("泛型测试 key value "+obj.getKey());
    }

    private static void showKeyValue2(GenericClazz<?>obj){
        System.out.println("泛型测试 key value "+obj.getKey());
    }
}

