package hibernate_001;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;

import com.jinan.www.entity.Students;

public class StudentsTest2 {
	public static void main(String[] args) {
		
		//创建配置对象
		Configuration configuration  = new Configuration().configure();
		//创建会话工厂对象
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//创建session
		Session session = sessionFactory.openSession();
		//创建事务对象，开启事务  @1为了更改session的自动提交功能，让session实现dowork方法来代替transaction事务的开启和提交。
//		Transaction transaction =session.beginTransaction();
		
		Students s1 = new Students(4, "lisisi", "男", new Date(), "武当山");
		/**
		 * 增加的dowork方法,亲测没有通过，可能是hibernate版本的问题，暂时不处理。
		 */
		session.doWork(new Work() {
			
			@Override
			public void execute(Connection arg0) throws SQLException {
				arg0.setAutoCommit(true);
			}
		});
		session.save(s1);
		session.flush();
//		transaction.commit();
		session.close();
		sessionFactory.close();
		
		
	}

}
