import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("book")
public class Book extends Publication {

	@Column(name = "isbn")
	private String isbn;

	public Book(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

	public Book() {

	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;

	}

	public Long getId() {
		return super.getId();
	}
	
	
	public void printBook(){
		System.out.println("Id - " + id + " Title - " + title + " isbn - " +isbn);
		
		
	}
}
