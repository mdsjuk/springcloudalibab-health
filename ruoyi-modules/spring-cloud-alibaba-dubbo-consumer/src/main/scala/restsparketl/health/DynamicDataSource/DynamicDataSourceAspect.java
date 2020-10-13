package restsparketl.health.DynamicDataSource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author:wxb
 * @description:
 * @date:22:032019/12/3
 */

@Aspect
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(restsparketl.health.DynamicDataSource.DataBase)")
    @SuppressWarnings("rawtypes")
    public void beforeSwitchDS(JoinPoint point){
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource = DataSourceType.DEFAULT_DS;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@DS注解
            if (method.isAnnotationPresent(DataBase.class)) {
                DataBase annotation = method.getAnnotation(DataBase.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
                System.out.println("当前数据源"+dataSource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源

        DataSourceType.setString(dataSource);
    }

    @After("@annotation(restsparketl.health.DynamicDataSource.DataBase)")
    public void afterSwitchDS(JoinPoint point){
        DataSourceType.clearString();
    }
}