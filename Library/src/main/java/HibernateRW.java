


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateRW implements BookDao {
	
	private SessionFactory sessionFactory;
	public HibernateRW(SessionFactory sessionFactory){
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
		// TODO Auto-generated method stub
		
	}

	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	public void getAllBooks() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
