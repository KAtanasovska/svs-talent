package svs.twitter;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import svs.twitter.dao.TweetDao;
import svs.twitter.dao.TweetDaoFile;
import svs.twitter.dao.TweetDaoHibernate;
import svs.twitter.dao.TweetDaoJDBC;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



/**
 * Created by Kristinata on 4/27/2016.
 */

@EnableAutoConfiguration
@SpringBootApplication
public class TwitterLauncher  implements CommandLineRunner, ApplicationContextAware {
    private ApplicationContext applicationContext;
    public static void main(String [] args){
        SpringApplication.run(TwitterLauncher.class, args);
        // TweetDao tweetDao = new TweetDaoFile();
        //TweetDao tweetDao = new TweetDaoJDBC();




        /*
        TweetDao tweetDao = new TweetDaoHibernate(sessionFactory);

        Twitter twitter = new Twitter(tweetDao);
        */


    }

    @Override
    public void run(String... strings) throws Exception {
        applicationContext.getBean(Twitter.class).run();

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
