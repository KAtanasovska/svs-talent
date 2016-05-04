

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Library {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(Book.class).addAnnotatedClass(Magazine.class).addAnnotatedClass(Member.class).addAnnotatedClass(Loan.class)
				.buildSessionFactory(serviceRegistry);

		
		//JDBCWriter jdbcWriter = new JDBCWriter();
	//	UserInteraction userInteractionJDBC = new UserInteraction(jdbcWriter);
		BookDao bookDao = new BookDao(sessionFactory);
		MagazineDao magazineDao = new MagazineDao(sessionFactory);
		//Book book = new Book("Troy","aaa");
		//bookDao.addNewBook(book);
		UserInteraction userInteraction = new UserInteraction(bookDao);
		userInteraction = new UserInteraction(magazineDao);
		sessionFactory.close();

	}

}
