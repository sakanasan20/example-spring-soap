package tw.niq.example.spring.soap;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import jakarta.annotation.PostConstruct;
import tw.niq.example.user_web_service.User;

@Component
public class UserRepository {
	
	private static final Map<String, User> users = new HashMap<>();

	@PostConstruct
	public void initData() {
		
		User johnDoe = new User();
		johnDoe.setFirstName("John");
		johnDoe.setLastName("Doe");
		johnDoe.setEmail("john.doe@example.com");

		users.put(johnDoe.getEmail(), johnDoe);
	}

	public User findUser(String email) {
		Assert.notNull(email, "User not found");
		return users.get(email);
	}
	
}
