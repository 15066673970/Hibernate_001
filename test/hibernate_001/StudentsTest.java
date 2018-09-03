package hibernate_001;
//测试类



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
		Students student = new Students(1, "zs", "男", new Date(), "武当山");
		System.out.println(student);
		session.save(student);//保存对象进入数据库
		System.out.println(session);
		
	}

	
	
}
