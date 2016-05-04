package svs.twitter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import svs.twitter.Tweet;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Kristinata on 4/27/2016.
 */
@Repository
public class TweetDaoHibernate implements TweetDao  {
    private SessionFactory sessionFactory;

    @Autowired
    public TweetDaoHibernate(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    public void addTweet(Tweet tweet) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = (Transaction) session.beginTransaction();
            session.save(tweet);
            tx.commit();
        }catch(RuntimeException e){
            if(tx != null){tx.rollback();}
        }finally{
            session.close();
        }

    }

    public List<Tweet> listAllTweets() throws SQLException {
        Session session = sessionFactory.openSession();

        String hql = "FROM Tweet order by date DESC ";
        Query query = session.createQuery(hql);
        List<Tweet> results = query.list();
        return results;

    }
}
