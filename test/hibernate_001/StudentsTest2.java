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
		
		//�������ö���
		Configuration configuration  = new Configuration().configure();
		//�����Ự��������
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//����session
		Session session = sessionFactory.openSession();
		//����������󣬿�������  @1Ϊ�˸���session���Զ��ύ���ܣ���sessionʵ��dowork����������transaction����Ŀ������ύ��
//		Transaction transaction =session.beginTransaction();
		
		Students s1 = new Students(4, "lisisi", "��", new Date(), "�䵱ɽ");
		/**
		 * ���ӵ�dowork����,�ײ�û��ͨ����������hibernate�汾�����⣬��ʱ������
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
