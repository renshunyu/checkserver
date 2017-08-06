package check.checkserver;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import check.checkserver.dao.*;
import check.checkserver.service.*;
/**
 * Hello world!
 *
 */
public class App 
{
    static Logger logger= Logger.getLogger(App.class);
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        iapqueryapppython qu = new iapqueryapppython();
        qu.ora("select * from iap_account");
        mPrint p1 =  new mPrint();
        p1.mPrint();
        ClassPathXmlApplicationContext tt = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println( "renshunyu" );
        //mPrint p2 = tt。getBean("mPrint",mPrint.class);
        mPrint p2 = tt.getBean("mPrint", mPrint.class);
        p2.mPrint();
        tt.close();
        

		logger.info("Spring quartztask will run as your configuration . . good luck ");
		ClassPathXmlApplicationContext actx = new ClassPathXmlApplicationContext("jd-spring.xml");
		actx.close();
        
    }
}
