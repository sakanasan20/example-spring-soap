package tw.niq.example.spring.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import tw.niq.example.user_web_service.GetUserRequest;
import tw.niq.example.user_web_service.GetUserResponse;

@Endpoint
public class UserEndPoint {

	private static final String NAMESPACE_URI = "http://niq.tw/example/user-web-service";
	
	private final UserRepository userRepository;

	public UserEndPoint(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
		
		System.out.println(request);
		
		GetUserResponse response = new GetUserResponse();
		response.setUser(userRepository.findUser(request.getEmail()));

		return response;
	}
	
}
