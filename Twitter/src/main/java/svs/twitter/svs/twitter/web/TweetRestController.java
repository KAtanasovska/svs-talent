package svs.twitter.svs.twitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import svs.twitter.Tweet;
import svs.twitter.dao.TweetDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Kristinata on 5/4/2016.
 */
@RestController()
@RequestMapping("/api/tweets")
public class TweetRestController {

        @Autowired
    TweetDao tweetDao;
        @RequestMapping(method = RequestMethod.GET)
        public List<Tweet> listBooks() throws SQLException {
            return tweetDao.listAllTweets();
        }
        @RequestMapping(method = RequestMethod.POST)
        public Tweet addTweet(@RequestBody Tweet tweet) throws SQLException {
            tweetDao.addTweet(tweet);
            return tweet;
        }
    }




