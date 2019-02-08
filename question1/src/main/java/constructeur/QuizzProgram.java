package constructeur;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuizzProgram {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("constructeur/spring-config.xml");
        QuizzMasterService quizzMasterService =
                (QuizzMasterService) applicationContext.getBean("QuizzMasterService");
    }

}
