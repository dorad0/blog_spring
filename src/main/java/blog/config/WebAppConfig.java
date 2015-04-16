package blog.config;

import blog.config.logging.SystemArchitecture;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Properties;

/**
 * Created by user on 15.01.2015.
 * A Config class, define the view’s technology and imports above SecurityConfig.java.
 */
@Configuration //Specifies the class as configuration
@ComponentScan("blog") //Specifies which package to scan
@EnableWebMvc //Enables to use Spring's annotations in the code
@EnableTransactionManagement
@EnableAspectJAutoProxy
@Import({SecurityConfig.class})
public class WebAppConfig extends WebMvcConfigurerAdapter {

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost:3306/blog_mvc";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "root";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "1234";

//    @Bean
//    public SystemArchitecture myAspect() {
//        return new SystemArchitecture();
//    }

//    @Bean
//    public UrlBasedViewResolver setupViewResolver() {
////        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/pages/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
//        return resolver;
//    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver
                = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("login");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder builder =
                new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("blog.entity")
                .addProperties(getHibernateProperties());

        return builder.buildSessionFactory();
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

    //Create a transaction manager
    @Bean
    public HibernateTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory());
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

//    //Configure static content handling
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/blog/**")
//                .addResourceLocations("classpath:/blog/");
//        registry.addResourceHandler("/css/**")
//                .addResourceLocations("/css/");
//        registry.addResourceHandler("/img/**")
//                .addResourceLocations("/img/");
//        registry.addResourceHandler("/js/**")
//                .addResourceLocations("/js/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/static/");
    }

//    //for image
//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver getMultipartResolver() {
//        return new CommonsMultipartResolver();
//    }

//    @Bean(name="simpleMappingExceptionResolver")
//    public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
//        SimpleMappingExceptionResolver r =
//                new SimpleMappingExceptionResolver();
//
//        Properties mappings = new Properties();
//        mappings.setProperty("DatabaseException", "databaseError");
//        mappings.setProperty("InvalidCreditCardException", "creditCardError");
//
//        r.setExceptionMappings(mappings);  // None by default
//        r.setDefaultErrorView("error");    // No default
//        r.setExceptionAttribute("ex");     // Default is "exception"
//        r.setWarnLogCategory("example.MvcLogger");     // No default
//        return r;
//    }

}
