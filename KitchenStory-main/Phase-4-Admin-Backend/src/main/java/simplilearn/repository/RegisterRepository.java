package simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simplilearn.model.User;

@Repository
public interface RegisterRepository extends JpaRepository<User, Integer> {
	
	public User findByEmailId(String emailId);
	
	public User findByEmailIdAndPassword(String emailId, String password);
	
	public User findByUserName(String userName);
	
	public User getUserById(int id);

}
