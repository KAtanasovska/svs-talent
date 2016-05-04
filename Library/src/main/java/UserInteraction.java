import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;



public class UserInteraction {

	private JDBCWriter jdbcWriter;
	private Book book = new Book();
	private BookDao bookDao;
	private Magazine magazine = new Magazine();
	private MagazineDao magazineDao;
	public UserInteraction(JDBCWriter jdbcW) throws SQLException  {
		
		jdbcWriter = jdbcW;
		int what = operationWanted();
		switch (what) {
		case 1:
			getInfo();
			jdbcWriter.addNewBook(book);
			break;
		case 2:

			jdbcWriter.getAllBooks();
			break;
		case 3:
			getInfo();
			jdbcWriter.updateBook(book);
			break;
		case 4:
			getInfo();
			jdbcWriter.deleteBook(book);
			break;
		}
	}

	public UserInteraction(BookDao bookDao) {
		this.bookDao = bookDao;
		
		/*int what = operationWanted();
		switch (what) {
		case 1:
			getInfo();
			bookDao.addNewBook(book);
			break;
		case 2:

			bookDao.getAllBooks();
			break;
		case 3:
			getInfo();
			bookDao.updateBook(book);
			break;
		case 4:
			getInfo();
			bookDao.deleteBook(book);
			break;
		}*/
		book = new Book("Troy", "aaa");
		bookDao.addNewBook(book);
		List<Book> list = bookDao.getAllBooks();
		for(Book book:list){
			book.printBook();
		}
		
		
		
		

	}
	public  UserInteraction(MagazineDao magazineDao) {
		this.magazineDao = magazineDao;
		magazine = new Magazine("Some Magazine", "bbb");
		magazineDao.addNewMagazine(magazine);
		List<Magazine> list = magazineDao.getAllMagazines();
		for(Magazine magazine:list){
			magazine.printMagazine();
		}
		
	}

	public int operationWanted() {
		System.out.println(
				"Press 1 for register book , 2 for list registered books, 3 for update a book registration, 4 unregister books");

		Scanner scanner = new Scanner(System.in);
		int what = scanner.nextInt();
		scanner.close();
		return what;

		/*
		 * switch(what){ case 1: //jdbcWriter.addNewBook(book); break; case 2:
		 * //jdbcReader.getAllBooks(book); break; case 3:
		 * //jdbcWriter.updateBook(book); break; case 4:
		 * //jdbcWriter.deleteBook(book); break; }
		 * 
		 */

	}

	private void getInfo() {
		System.out.println("Insert the isbn");
		Scanner scanner = new Scanner(System.in);
		book.setIsbn(scanner.nextLine());
		System.out.println("Insert the title");
		book.setTitle(scanner.nextLine());
		scanner.close();

	}

}
