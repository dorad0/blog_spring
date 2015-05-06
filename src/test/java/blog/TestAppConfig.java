package blog;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Properties;

@Configuration //Specifies the class as configuration
@ComponentScan(basePackages = { "blog.dao.*", "blog.entity" }, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebSecurity.class),
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableTransactionManagement.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ComponentScan.class)
})
@EnableTransactionManagement
public class TestAppConfig {

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost:3306/blog_mvc_test";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "root";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "1234";

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder builder =
                new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("blog.entity")
                .addProperties(getHibernateProperties());

        return builder.buildSessionFactory();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.format_sql", "true");
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.dialect",
                "org.hibernate.dialect.MySQL5Dialect");
//        prop.put("hibernate.hbm2ddl.auto", "create");

        return prop;
    }

    @Bean(name = "dataSource")
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
        ds.setUrl(PROPERTY_NAME_DATABASE_URL);
        ds.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
        ds.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);

        return ds;
    }

    @Bean
    public HibernateTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory());
    }

}
