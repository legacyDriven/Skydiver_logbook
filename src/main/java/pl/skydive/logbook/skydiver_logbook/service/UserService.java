package pl.skydive.logbook.skydiver_logbook.service;

import pl.skydive.logbook.skydiver_logbook.domain.User;
import pl.skydive.logbook.skydiver_logbook.infrastructure.UserRepository;

import java.util.regex.Pattern;

public class UserService {

    private final UserRepository userRepository;

    private static final Pattern RFC = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user){

    }

    private static boolean validEmail(String emailAddress){
        return RFC.matcher(emailAddress).matches();
    }

}
