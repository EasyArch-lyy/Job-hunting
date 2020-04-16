package basics.classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*
* 自定义类加载器
* */
public class MyTest16 extends ClassLoader{

    private String classLoaderName;
    private final String fileExtension=".class";

    public MyTest16(String classLoaderName){
        super();//将系统类加载器当作该类加载器的父加载器
        this.classLoaderName=classLoaderName;
    }
    //自己指定双亲类加载器
    public MyTest16(ClassLoader parent,String classLoaderName){
        super(parent);//显式指定该类加载器的父加载器
        this.classLoaderName=classLoaderName;
    }

    @Override
    public String toString(){
        System.out.println(this.classLoaderName);
        return "["+this.classLoaderName+"]";
    }

    @Override
    protected Class<?> findClass(String classname) throws ClassNotFoundException {
        byte[]data=this.loadClassData(classname);
        return this.defineClass(classname, data, 0/*起始*/, data.length/*结束*/);
    }

    private byte[]loadClassData(String name){
        InputStream is=null;
        byte[]data=null;
        ByteArrayOutputStream baos=null;
        try {
            this.classLoaderName=this.classLoaderName.replace(".","/");
            is=new FileInputStream(new File(name+this.fileExtension));
            baos=new ByteArrayOutputStream();
            int ch=0;
            while (-1!=(ch=is.read())){
                baos.write(ch);
            }
            data=baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
                baos.close();
            }catch (Exception ex){
                ex.printStackTrace();;
            }
        }
        return data;
    }
    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?>clazz=classLoader.loadClass("jvm.test.MyTest1");
        Object object=clazz.newInstance();
        System.out.println(object);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyTest16 loader=new MyTest16("loder1");
        test(loader);
    }
}
