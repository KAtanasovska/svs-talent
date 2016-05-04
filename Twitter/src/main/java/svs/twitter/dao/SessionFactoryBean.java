package svs.twitter.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import svs.twitter.Tweet;

/**
 * Created by Kristinata on 5/3/2016.
 */
@Configuration
public class SessionFactoryBean {
    @Bean
    public SessionFactory getSessionFactory(){
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.addAnnotatedClass(Tweet.class)
                .buildSessionFactory(serviceRegistry);
        return sessionFactory;

    }
}
