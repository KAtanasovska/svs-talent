import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MagazineDao {
	private SessionFactory sessionFactory;
	public MagazineDao(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		
	}
	
	public void addNewMagazine(Magazine magazine){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = (Transaction) session.beginTransaction();
			session.save(magazine);
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null){tx.rollback();}
		}finally{
			session.close();
		}
}
	public List<Magazine> getAllMagazines() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
			String hql = "FROM Magazine";
			Query query = session.createQuery(hql);
			List<Magazine> results = query.list();
			return results;
			
		
		
	}
	
}
