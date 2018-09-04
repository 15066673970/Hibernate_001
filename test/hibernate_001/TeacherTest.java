package hibernate_001;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jinan.www.entity.Address;
import com.jinan.www.entity.Teacher;

public class TeacherTest {
	Configuration configuration;
	SessionFactory  sessionFactory;
	Session session;
	Transaction transaction;
	@Before
	public void init() {
		configuration=new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		
	}
	@After
	public void destory() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	@Test
	public void TestSave() {
		Address address = new Address("253104","010-58596335", "济南市历下区经十路山东现代学院");
		Teacher t1 = new Teacher("T.Wang", "Man", 20, null, address);
		session.save(t1);
	}
	@Test
	public void TestDelete() {
		Teacher t1 = session.get(Teacher.class,1);
		session.delete(t1);
	}
	@Test
	public void TestUpdate() {
		Teacher t1 = session.get(Teacher.class,1);
		t1.setGender("Woman");
		session.update(t1);
	}
	@Test
	public void TestLoad() {
		Teacher t1 = session.get(Teacher.class,1);
		System.out.println(t1);
	}
	@Test
	public void TestGet() {
		Teacher t2 = session.load(Teacher.class,1);
		System.out.println(t2);
		
	}

}
