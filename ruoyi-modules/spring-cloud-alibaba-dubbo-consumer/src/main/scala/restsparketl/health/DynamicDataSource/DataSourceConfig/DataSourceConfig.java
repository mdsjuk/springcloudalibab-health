package restsparketl.health.DynamicDataSource.DataSourceConfig;


import restsparketl.health.DynamicDataSource.DynamicDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//import org.springframework.boot.jdbc.DataSourceBuilder;

/**
 * @author:wxb
 * @description:
 * @date:21:282019/12/3
 * @
 */


@Configuration
@MapperScan(basePackages = "restsparketl.health.Mapper", sqlSessionFactoryRef = "SqlSessionFactory")
public class DataSourceConfig {
    @Primary
    @Bean(name = "test1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.db1")
    public DataSource getDateSource1() {
        return new DruidDataSource();
    }

    @Bean(name = "test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.db2")
    public DataSource getDateSource2() {
        return new DruidDataSource();
    }

    @Bean(name = "dynamicDataSource")
    public DynamicDataSource DataSource(@Qualifier("test1DataSource") DataSource test1DataSource,
                                        @Qualifier("test2DataSource") DataSource test2DataSource) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put("db1", test1DataSource);
        targetDataSource.put("db2", test2DataSource);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(test1DataSource);
        return dataSource;
    }

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory test1SqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
//            bean.setMapperLocations(
//                    new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/*.xml"));
        return bean.getObject();
    }
}
