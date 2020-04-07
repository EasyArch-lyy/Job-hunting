package basics.annotation;

import java.lang.annotation.*;

/**
 * @author lyy
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {
    public String name();
    public String setFuncName() default "setField";
    public String getFuncName() default "getField"; 
    public boolean defaultDBValue() default false;
}

