package svs.twitter.dao;

import svs.twitter.Tweet;

import java.sql.*;
import java.util.List;

/**
 * Created by Kristinata on 4/27/2016.
 */
public class TweetDaoJDBC implements TweetDao {

public void addTweet(Tweet tweet) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TwitterDatabase", "postgres", "Password1");
        Statement statement = (Statement) connection.createStatement();

   // ((java.sql.Statement) statement).executeUpdate("insert into tweet(tweet, date, nick) values ('"+ tweet.getTweet() + "','"+tweet.getDate() +","+ tweet.getNickName()+"')");
   // ((Connection) statement).close();
    PreparedStatement preparedStatement = connection.prepareStatement("insert into tweet(tweet, date, nick) values (?, ?, ?)");
    preparedStatement.setString(1, tweet.getTweet());
    preparedStatement.setString(2, tweet.getDate().toString());
    preparedStatement.setString(3, tweet.getNickName());
    preparedStatement.executeUpdate();
    preparedStatement.close();
}

public List<Tweet> listAllTweets()  throws SQLException{
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TwitterDatabase", "postgres", "Password1");
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from tweet ORDER BY date DESC");
    List<Tweet> results = null;
    while (resultSet.next()) {
       // Long id = resultSet.getInt("id");
        String tweet = resultSet.getString("tweet");
        String nickName = resultSet.getString("nick");
        String date = resultSet.getString("date");
        results.add(new Tweet(tweet, nickName, date));
       // System.out.println(nickName + " \n " + tweet + "\n " + date);
        }

    statement.close();
        return results;
}









}
