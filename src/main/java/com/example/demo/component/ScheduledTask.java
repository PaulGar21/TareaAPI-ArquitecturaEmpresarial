
package com.example.demo.component;
import com.example.demo.Service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
     private final UserService userService;

    public ScheduledTask(UserService postService) {
        this.userService = postService;
    }

    @Scheduled(fixedRate = 3600000) // 1 hora = 3600000 milisegundos
    public void fetchDataAndSave() {
        userService.fetchDataAndSaveToDatabase();
    }
}


