package repo;
import java.util.*;
public class Driver {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
////		User testUser = new User( "jordanthegreat", "password", "jordan", "morgan", 4 );
////		dao.insertUser(testUser);
////		Set<User> users = dao.findAll();
////		for (User u: users) {
////			System.out.println(u.getFirstName());
//		}
	
		dao.deleteById(7);
		

	}

}
