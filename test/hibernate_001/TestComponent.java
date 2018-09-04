package hibernate_001;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jinan.www.entity.Address;
import com.jinan.www.entity.Teacher;

public class TestComponent {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session  = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Address address = new Address("2", "2","2");
		Teacher teacher=new Teacher("1", "nan", 1, null,address);
		session.save(teacher);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	
		
		
		
	}

}
