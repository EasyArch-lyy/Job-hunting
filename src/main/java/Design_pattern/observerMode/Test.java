package Design_pattern.observerMode;

/**
 * 观察者模式
 *
 * @author lyy
 */
public class Test {
    
    public static void main(String[] args) {
        WechatServer server = new WechatServer();
        
        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");
        
        server.registerObserver((java.util.Observer) userZhang);
        server.registerObserver((java.util.Observer) userLi);
        server.registerObserver((java.util.Observer) userWang);
        server.setInfomation("PHP是世界上最好用的语言！");
        
        System.out.println("----------------------------------------------");
        server.removeObserver((java.util.Observer) userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");
        
    }
}