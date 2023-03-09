package simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simplilearn.model.User;
import simplilearn.repository.RegisterRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegisterRepository registerRepository;
	
	public List<User> viewUsers(){
		return registerRepository.findAll();
	}

	public User registerUser(User user) {
		return registerRepository.save(user);
	}

	public User getUserBYEmailId(String emailId) {
		return registerRepository.findByEmailId(emailId);
	}
	public User getUserBYEmailIdAndPassword(String emailId, String password) {
		return registerRepository.findByEmailIdAndPassword(emailId, password);
	}
	public User getUserByUserName(String userName) {
		return registerRepository.findByUserName(userName);
	}
	public User updateUser(User user, int id) {
		return registerRepository.save(user);
	}
//	public User getUserById(int id) throws UserPrincipalNotFoundException {
//		Optional<User> result = registerRepository.findById(id);
//		if(result.isPresent()) {
//			return result.get();
//		}
//		throw new UserPrincipalNotFoundException("User not found");
//	}
}