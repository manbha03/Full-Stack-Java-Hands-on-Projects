package simplilearn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import simplilearn.model.User;
import simplilearn.repository.RegisterRepository;
import simplilearn.service.RegistrationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {

	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private RegisterRepository registerRepository;

	

	@GetMapping("/viewusers")
	public List<User> viewUsers() {
		return registrationService.viewUsers();
	}

	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			User userObj = registrationService.getUserBYEmailId(tempEmailId);
			if (userObj != null) {
				throw new Exception("User with " + tempEmailId + " already exists");
			}
		}
		User userObj = null;
		userObj = registrationService.registerUser(user);
		return userObj;
	}

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword();
		User userObj = null;

		if (tempEmailId != null && tempPassword != null) {
			userObj = registrationService.getUserBYEmailIdAndPassword(tempEmailId, tempPassword);
		}
		if (userObj == null) {
			throw new Exception("User does not exists");
		}
		return userObj;
	}

	@PostMapping("/search")
	public User searchByUsername(@RequestBody User user) throws Exception {
		String tempUserName = user.getUserName();
		if (tempUserName != null && !"".equals(tempUserName)) {
			User userObj = registrationService.getUserByUserName(tempUserName);
			if (userObj == null) {
				throw new Exception("User with " + tempUserName + " not found");
			}
		}
		User userobj = null;
		userobj = registrationService.getUserByUserName(tempUserName);
		return userobj;
	}

	// update User
	@PutMapping("/viewusers/{id}")
	public ResponseEntity<User> updateById(@RequestBody User userDetails, @PathVariable int id) throws Exception {
		User userObj = registerRepository.findById(id).get();
		if (userObj != null) {

			userObj.setEmailId(userDetails.getEmailId());
			userObj.setPassword(userDetails.getPassword());
			userObj.setUserName(userDetails.getUserName());

			User updateDetails = registrationService.updateUser(userObj, id);
			return ResponseEntity.ok(updateDetails);
		} else {
			throw new Exception("User not found");
		}

	}

	// get User By Id
	@GetMapping("/viewusers/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) throws Exception {
		User user = registerRepository.findById(id).get();
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			throw new Exception("User Not Found");
		}
	}

	@DeleteMapping("/viewusers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id) throws Exception {
		User user = registerRepository.findById(id).get();
		if (user != null) {
			registerRepository.delete(user);
			Map<String, Boolean> response = new HashMap<>();
			response.put("Deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);

		} else {
			throw new Exception("User Not Found");
		}
	}

}
