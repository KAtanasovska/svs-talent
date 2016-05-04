package svs.twitter.dao;
import svs.twitter.Tweet;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Kristinata on 4/27/2016.
 */
public class TweetDaoFile implements TweetDao {


    public void addTweet(Tweet tweet) {
        // TODO Auto-generated method stub
        try {

            String filename = "TweetDatabase.txt";
            FileWriter fw = new FileWriter(filename, true);
            fw.write(tweet.toString());
            fw.close();

        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }

    }


    public List<Tweet> listAllTweets() {
        List<Tweet> results = null;
        try {
            List<String> lines = Files.readAllLines(Paths.get("TweetDatabase.txt"));
            for (int i = lines.size() - 1; i >= 0; i--) {
                System.out.println(lines.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return results;
    }

}

