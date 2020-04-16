package basics.reflex.readPreperties;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author lyy
 * 我们利用反射和配置文件，可以使：应用程序更新时，对源码无需进行任何修改
 * 我们只需要将新类发送给客户端，并修改配置文件即可
 */
public class Demo {
	public static void main(String[] args) throws Exception {
		//通过反射获取Class对象
		Class stuClass = Class.forName(getValue("className"));
		//2获取show()方法
		Method m = stuClass.getMethod(getValue("methodName"));
		//3.调用show()方法
		m.invoke(stuClass.getConstructor().newInstance());
	}
	
	//此方法接收一个key，在配置文件中获取相应的value
	public static String getValue(String key) throws IOException {
		//获取配置文件的对象
		Properties pro = new Properties();
		FileReader in = new FileReader("/home/lyy/桌面/Job-hunting/src/main/java/basics.reflex/readPreperties/pro");
		//将流加载到配置文件对象中
		pro.load(in);
		in.close();
		//返回根据key获取的value值
		return pro.getProperty(key);
	}
}