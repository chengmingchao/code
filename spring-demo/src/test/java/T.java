import com.cmc.bean.Student;
import com.cmc.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beanDI.xml");
        User user = (User) context.getBean("user2");
        User user1 = (User) context.getBean("user2");
        System.out.println(user==user1);

    }
}
