package basics.annotation.test7;

import java.lang.annotation.*;


/**
 * @author lyy
 */
public class Test7 {
    public static void main(String[] args) {
        String pkgName="basics.annotation.test7";
        Package pkg=Package.getPackage(pkgName);
        Annotation[]annotations=pkg.getAnnotations();
        for(Annotation an:annotations){
            if(an instanceof PkgAnnotation){
                System.out.println("这个包被定义了PkgAnnotation注释");
            }
        }
    }
}
/**
 * 注解操作
 * MyAnnotation myAnn = (PkgAnnotation)an;
 * 还可以操作该注解包下的所有类，比如初始化，检查等等
 * 类似Struts的@Namespace，可以放到包名上，标明一个包的namespace路径
 */