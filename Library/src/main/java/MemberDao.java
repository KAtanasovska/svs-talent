import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MemberDao {

	private SessionFactory sessionFactory;
	public MemberDao(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		
	}
	
	public void addNewMember(Book member){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = (Transaction) session.beginTransaction();
			session.save(member);
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null){tx.rollback();}
		}finally{
			session.close();
		}
		
		
		
	}
	public List<Member> getAllBooks() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
			String hql = "FROM Book";
			Query query = session.createQuery(hql);
			List<Member> results = query.list();
			return results;
			
		
		
	}
}
