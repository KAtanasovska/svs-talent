package svs.twitter.svs.twitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import svs.twitter.Tweet;

import svs.twitter.dao.TweetDao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Kristinata on 5/4/2016.
 */
@Controller
@RequestMapping("/tweets")
public class TweetController {
    @Autowired
    TweetDao tweetDao;

    @ModelAttribute("tweets")
    public List<Tweet> tweets() throws SQLException {

            return tweetDao.listAllTweets();

    }

    @ModelAttribute("tweet")
    public Tweet tweet() {
        return new Tweet();
    }
    @RequestMapping(method = RequestMethod.GET)
    public String listTweets() {
        return "tweets";
                }

    @RequestMapping(method = RequestMethod.POST)
    public String registerTweet(@ModelAttribute("tweet") Tweet tweet) throws SQLException {

                tweet.setDate(new Date());
                if(tweet.getNickName().trim().equals("")){
                    tweet.setNickName("Anonymous");
                }
                if(!tweet.getTweet().trim().equals("")) {
                    tweetDao.addTweet(tweet);
                }


        return "redirect:/tweets";
    }



    }
