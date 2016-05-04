import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCWriter {

	

	
	
	
	public void addNewBook(Book book) throws SQLException{
	
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Library", "postgres", "Password1");
		Statement statement = (Statement) connection.createStatement();
		((java.sql.Statement) statement).executeUpdate("insert into book(isbn, title) values ('"+ book.getIsbn()+"','"+book.getTitle()+"')");
		((Connection) statement).close();	
		}
	
	public void updateBook(Book book) throws SQLException{
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Library", "postgres", "Password1");
		Statement statement = (Statement) connection.createStatement();
		((java.sql.Statement) statement).executeUpdate("insert into book(isbn, title) values ('"+ book.getIsbn()+"','"+book.getTitle()+"')");
		((Connection) statement).close();	
		}
		

	
	public void deleteBook(Book book){
		
		
	}
	public /*Book[]*/ void getAllBooks(){
		
		return ;
	}
}
