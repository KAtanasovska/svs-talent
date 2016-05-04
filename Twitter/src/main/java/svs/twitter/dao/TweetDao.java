package svs.twitter.dao;
import svs.twitter.Tweet;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Kristinata on 4/27/2016.
 */
public interface TweetDao {
    public void addTweet(Tweet tweet) throws SQLException;
    public List<Tweet> listAllTweets() throws SQLException;

}
