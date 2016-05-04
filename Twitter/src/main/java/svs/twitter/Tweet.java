package svs.twitter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Kristinata on 4/27/2016.
 */
@Entity
@DiscriminatorValue("tweet")
public class Tweet {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String tweet;
    @Column
    private Date date;
    @Column(name = "nick")
    private String nickName;
    public Tweet (){}
    public String getTweet() {
        return tweet;
    }
    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public Long getId() {
        return id;
    }
    public void setId(String tweet) {
        this.id = id;
    }

    public Tweet(String body, String nickName, String date){
        this.tweet = body;
        this.nickName = nickName;
        this.date = new Date(date);
    }
    public Tweet(String body, String nickName){
        this.tweet = body;
        this.nickName = nickName;
        date = new Date();
    }
    public Tweet(String body){
        this.tweet = body;
        nickName = "Anonymous";
        date = new Date();
    }
    public String toString(){
        return "\nFrom: " + nickName + "\n" + tweet + "\nDate: "+date.toString();
    }

}


