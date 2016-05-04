




import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;




public class BookDao  {
	
	private SessionFactory sessionFactory;
	public BookDao(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		
	}
	
	public void addNewBook(Book book){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = (Transaction) session.beginTransaction();
			session.save(book);
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null){tx.rollback();}
		}finally{
			session.close();
		}
		
		
		
	}

	public void updateBook(Book book) {
		
		
	}

	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		
		
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
			String hql = "FROM Book";
			Query query = session.createQuery(hql);
			List<Book> results = query.list();
			return results;
			
		
		
	}
	
	
	
	
	
	
}
