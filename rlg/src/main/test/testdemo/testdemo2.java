package testdemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class testdemo2 {
    @Test
    public void c(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        DriverManagerDataSource ds = (DriverManagerDataSource)ac.getBean("dataSource1");
        String url = ds.getUrl();
        System.out.println(url);
    }
}
