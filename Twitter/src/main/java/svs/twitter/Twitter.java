package svs.twitter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import svs.twitter.dao.TweetDao;
/**
 * Created by Kristinata on 4/27/2016.
 */
@Service
public class Twitter implements CommandLineRunner {

    TweetDao tweetDao;


    @Autowired
    public Twitter(TweetDao tweetDao) {

        this.tweetDao = tweetDao;

    }

    public void twitterStarter() {
        System.out.println("Choose the number of the action you want");
        Scanner scanner = new Scanner(System.in);
        int action = 0;
        while (action!=3) {
            System.out.println("1 - Tweet a message. \n2 - List all tweets. \n3 - Exit");
            try {
                action = Integer.parseInt(scanner.nextLine());
                switch (action) {
                    case 1: {
                        Tweet tweet = new Tweet();
                        System.out.println("Insert your nickname or press a if you want to be anonymous");
                        // tweetDao.addTweet();
                        String input = scanner.nextLine();
                        if (!input.equals("a")) {
                            tweet.setNickName(input);

                        } else {
                            tweet.setNickName("Anonymous");
                        }
                        {
                            System.out.println("Write your tweet");
                            tweet.setTweet(scanner.nextLine());
                            tweet.setDate(new Date());
                        }
                        try {
                            tweetDao.addTweet(tweet);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 2: {

                            listTweets();

                        break;
                    }

                }
            }catch (NumberFormatException e){
                System.out.println("Please input 1,2 or 3 ");
            }
        }
        scanner.close();
        System.out.println("Thank you for using Twitter");
        System.exit(0);

    }
    public void listTweets(){
        List<Tweet> results = null;
        try {
            results = tweetDao.listAllTweets();
            for(Tweet tweet : results){

                System.out.println("\nFrom: " + tweet.getNickName() + "\n" + tweet.getTweet() + "\nDate: "+tweet.getDate().toString());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void run(String... strings) throws Exception {
        twitterStarter();
    }
}


