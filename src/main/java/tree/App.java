import org.hibernate.Session;
import org.hibernate.Transaction;

import tree.config.HibernateUtil;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Start session with db
		Session session = new HibernateUtil().getSessionFactory().openSession();		
		//Start the transaction
		Transaction transaction = session.beginTransaction();
	}
}
