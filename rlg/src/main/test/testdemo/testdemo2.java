package testdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class testdemo2 {


    @Test
    public void c(){
        String A = null;
        System.out.println(A.equals(null));
    }
    @Test
    public void a(){
        System.out.println(ladder(11)+"|"+ladder(9));
    }

    public int ladder(int n ){
        if (n==1){
            return 1;
        }else if (n==2){
            return 2;
        }else{
            return ladder(n-1)+ladder(n-2);
        }
    }
}
