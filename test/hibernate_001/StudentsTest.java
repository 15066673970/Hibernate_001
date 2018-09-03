package hibernate_001;
//������



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jinan.www.entity.Students;

public class StudentsTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init() {
	/**
 			hibernate4.2֮ǰ�İ汾����д���򱾻�hibernate5.3.5����û�в����Ƿ�ͨ��
		//�������ö���
		Configuration configuration = new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//�����ػ���������
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//�����Ự����
		session = sessionFactory.openSession();
		//��������
		transaction = session.beginTransaction();
		**/
		
		/**	�ײ����ͨ��
		 
	     //��������ע�����
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //�����Ự��������
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        //�Ự����
        session = sessionFactory.openSession();
        //��������
        transaction = session.beginTransaction();
        **/
		
		/**
		 * ����4.3�汾�����������������������û��ͨ��
		 
        //�������ö���  
        Configuration config = new Configuration().configure();
        //��������ע�����  
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config .getProperties()).build();
        //�����Ự��������  
        sessionFactory = config.buildSessionFactory(serviceRegistry);
        //�Ự����  
        session = sessionFactory.openSession();
        //��������  
        transaction = session.beginTransaction();
		*/
		
		/**
		 * ����hibernate5֮�������������ͨ��������
		 */
		   //�������ö���(��ȡ�����ĵ�)
        Configuration config = new Configuration().configure();
        //�����Ự��������
        sessionFactory = config.buildSessionFactory();
        //�Ự����
        session = sessionFactory.openSession();
        //��������
        transaction = session.beginTransaction();
		
		
		
		
	}
	
	@After
	public void destory() {
		
		transaction.commit();//�ύ����
		session.close();//�رջỰ
		sessionFactory.close();//�رջػ�����
	}
	
	@Test
	public void testSaveStudents() {
		
		//����ѧ������
		Students student = new Students(1, "zs", "��", new Date(), "�䵱ɽ");
		System.out.println(student);
		session.save(student);//�������������ݿ�
		System.out.println(session);
		
	}

	
	
}
