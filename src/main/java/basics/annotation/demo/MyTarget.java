package basics.annotation.demo;
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
  
/**
 * @author lyy
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTarget {
}