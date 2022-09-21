package pl.skydive.logbook.skydiver_logbook.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import pl.skydive.logbook.skydiver_logbook.domain.User;
import pl.skydive.logbook.skydiver_logbook.infrastructure.UserRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final UserRepository userRepository;

    public AppStartupEvent(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
//        User user = new User();
//        user.setFirstName("EugeniuszImie");
//        user.setLastName("sniezkonazwisko");
//        user.setEmailAsLogin("twojastara@gmail.com");
//        this.userRepository.save(user);
//        Iterable<User> users = this.userRepository.findAll();
//        users.forEach(System.out::println);
    }
}
