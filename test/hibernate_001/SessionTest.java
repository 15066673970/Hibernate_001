package hibernate_001;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class SessionTest {

	@Test
	public void testOpenSession() {
		//创建配置对象
		Configuration configuration = new Configuration().configure();
		//创建SessionFactory对象
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//创建session对象
		Session session = sessionFactory.openSession();
		Session session2 = sessionFactory.openSession();
		if(session!=session2) {
			System.out.println("session hashcode="+session.hashCode());
			System.out.println("session2 hashcode="+session2.hashCode());
			System.out.println("两个session不是同一个对象");
		}
		if(session!=null) {
			System.out.println("session创建成功");
		}
		else {
			System.out.println("session创建失败");
		}
		
	}
	
	@Test
	public void testGetCurrentSession() {
		//创建配置对象
		Configuration configuration = new Configuration().configure();
		//创建sessionFactory工厂对象
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//创建session
		Session session = sessionFactory.getCurrentSession();
		Session session2 = sessionFactory.getCurrentSession();
		if(session==session2) {
			System.out.println("session hashcode="+session.hashCode());
			System.out.println("session2 hashcode="+session2.hashCode());
			System.out.println("是一个对象，两个session是同一个");
		}
		if(session!=null) {
			System.out.println("session创建成功");
		}else {
			System.out.println("session创建失败");
		}
	}
	
	
}
