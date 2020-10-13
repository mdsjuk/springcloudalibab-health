package restsparketl.health.DynamicDataSource;

/**
 * @author:wxb
 * @description:多源数据注解DataBase
 * @date:22:022019/12/3
 */



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DataBase {
    String value() default "db2";
}
