package hibernate_001;
//������



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.Date;

import org.hibernate.Hibernate;
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

import oracle.net.aso.s;

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
		Students student = new Students();
		student.setSname("zs");
		student.setGender("��");
		student.setBirthday(new Date());
		student.setAddress("��üɽ");
		System.out.println(student);
		session.save(student);//�������������ݿ�
		System.out.println(session);
		
	}

	@Test	
	public void testWriteBlob() throws Exception {
		Students s1 = new Students(4, "lisisi", "��", new Date(), "�䵱ɽ");
		//�Ȼ����Ƭ�ļ�
		File file  = new File("d:"+File.separator+"1.jpg");
		//�����Ƭ�ļ���������
		InputStream inputStream = new FileInputStream(file);
		
		//����һ��blob����
		Blob image = Hibernate.getLobCreator(session).createBlob(inputStream,inputStream.available());
		
		//������Ƭ����
		s1.setPicture(image);
		
		//����ѧ��
		session.save(s1);
	}
	
	@Test
	public void testReadBlob() throws Exception{
		//���Ȼ��ѧ������
		Students s1 =(Students) session.get(Students.class, 4);
		//���blob����
		Blob  image= s1.getPicture();
		//�����Ƭ��������
		InputStream inputStream  = image.getBinaryStream();
		//���������
		File file= new File("d:"+File.separator+"2.jpg");
		//��ȡ�����
		OutputStream outputStream = new FileOutputStream(file);
		//����������
		byte[] buff = new byte[inputStream.available()];
		inputStream.read(buff);
		outputStream.write(buff);
		outputStream.flush();
		inputStream.close();
		outputStream.close();
		
	}
	
	
}
