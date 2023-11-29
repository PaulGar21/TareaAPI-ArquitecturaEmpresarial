
package com.example.demo.Service;
import com.example.demo.JpaRepository.UserRepository;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
     private final UserRepository userRepository;
    private final String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

    public UserService(UserRepository postRepository) {
        this.userRepository = postRepository;
    }
    public void fetchDataAndSaveToDatabase() {
        // Hacer la solicitud a la API
        RestTemplate restTemplate = new RestTemplate();
        User post = restTemplate.getForObject(apiUrl, User.class);

        // Guardar en la base de datos
        if (post != null) {
            userRepository.save(post);
        }
    }
}


