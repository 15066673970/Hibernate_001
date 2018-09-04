package hibernate_001;
//测试类



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
 			hibernate4.2之前的版本这样写。因本机hibernate5.3.5，故没有测试是否通过
		//创建配置对象
		Configuration configuration = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建回话工厂对象
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//创建会话对象
		session = sessionFactory.openSession();
		//开启事务
		transaction = session.beginTransaction();
		**/
		
		/**	亲测可以通过
		 
	     //创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //创建会话工厂对象
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        //会话对象
        session = sessionFactory.openSession();
        //开启事务
        transaction = session.beginTransaction();
        **/
		
		/**
		 * 网传4.3版本后可以这样做，我这样做后没有通过
		 
        //创建配置对象  
        Configuration config = new Configuration().configure();
        //创建服务注册对象  
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config .getProperties()).build();
        //创建会话工厂对象  
        sessionFactory = config.buildSessionFactory(serviceRegistry);
        //会话对象  
        session = sessionFactory.openSession();
        //开启事务  
        transaction = session.beginTransaction();
		*/
		
		/**
		 * 网传hibernate5之后可以这样做，通过！！！
		 */
		   //创建配置对象(读取配置文档)
        Configuration config = new Configuration().configure();
        //创建会话工厂对象
        sessionFactory = config.buildSessionFactory();
        //会话对象
        session = sessionFactory.openSession();
        //开启事务
        transaction = session.beginTransaction();
		
		
		
		
	}
	
	@After
	public void destory() {
		
		transaction.commit();//提交事务
		session.close();//关闭会话
		sessionFactory.close();//关闭回话工厂
	}
	
	@Test
	public void testSaveStudents() {
		
		//生成学生对象
		Students student = new Students();
		student.setSname("zs");
		student.setGender("男");
		student.setBirthday(new Date());
		student.setAddress("峨眉山");
		System.out.println(student);
		session.save(student);//保存对象进入数据库
		System.out.println(session);
		
	}

	@Test	
	public void testWriteBlob() throws Exception {
		Students s1 = new Students(4, "lisisi", "男", new Date(), "武当山");
		//先获得照片文件
		File file  = new File("d:"+File.separator+"1.jpg");
		//获得照片文件的输入流
		InputStream inputStream = new FileInputStream(file);
		
		//创建一个blob对象
		Blob image = Hibernate.getLobCreator(session).createBlob(inputStream,inputStream.available());
		
		//设置照片属性
		s1.setPicture(image);
		
		//保存学生
		session.save(s1);
	}
	
	@Test
	public void testReadBlob() throws Exception{
		//首先获得学生对象
		Students s1 =(Students) session.get(Students.class, 4);
		//获得blob对象
		Blob  image= s1.getPicture();
		//获得照片的输入流
		InputStream inputStream  = image.getBinaryStream();
		//创建输出流
		File file= new File("d:"+File.separator+"2.jpg");
		//获取输出流
		OutputStream outputStream = new FileOutputStream(file);
		//创建缓冲区
		byte[] buff = new byte[inputStream.available()];
		inputStream.read(buff);
		outputStream.write(buff);
		outputStream.flush();
		inputStream.close();
		outputStream.close();
		
	}
	
	
}
