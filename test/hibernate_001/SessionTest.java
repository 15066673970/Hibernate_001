package hibernate_001;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class SessionTest {

	@Test
	public void testOpenSession() {
		//�������ö���
		Configuration configuration = new Configuration().configure();
		//����SessionFactory����
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//����session����
		Session session = sessionFactory.openSession();
		Session session2 = sessionFactory.openSession();
		if(session!=session2) {
			System.out.println("session hashcode="+session.hashCode());
			System.out.println("session2 hashcode="+session2.hashCode());
			System.out.println("����session����ͬһ������");
		}
		if(session!=null) {
			System.out.println("session�����ɹ�");
		}
		else {
			System.out.println("session����ʧ��");
		}
		
	}
	
	@Test
	public void testGetCurrentSession() {
		//�������ö���
		Configuration configuration = new Configuration().configure();
		//����sessionFactory��������
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//����session
		Session session = sessionFactory.getCurrentSession();
		Session session2 = sessionFactory.getCurrentSession();
		if(session==session2) {
			System.out.println("session hashcode="+session.hashCode());
			System.out.println("session2 hashcode="+session2.hashCode());
			System.out.println("��һ����������session��ͬһ��");
		}
		if(session!=null) {
			System.out.println("session�����ɹ�");
		}else {
			System.out.println("session����ʧ��");
		}
	}
	
	
}
