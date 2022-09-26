package pl.skydive.logbook.skydiver_logbook.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skydive.logbook.skydiver_logbook.dao.UserDto;
import pl.skydive.logbook.skydiver_logbook.domain.User;
import pl.skydive.logbook.skydiver_logbook.exceptions.InvalidEmailFormatException;
import pl.skydive.logbook.skydiver_logbook.exceptions.UserExistsException;
import pl.skydive.logbook.skydiver_logbook.exceptions.UserNotExistsException;
import pl.skydive.logbook.skydiver_logbook.infrastructure.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private static final Pattern RFC = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static boolean validEmail(String emailAddress){
        return RFC.matcher(emailAddress).matches();
    }

    public void createUser(UserDto userDto) throws UserExistsException, InvalidEmailFormatException {
        Optional<User> user = userRepository.findByEmailAsLogin(userDto.getEmailAsLogin());
        if(user.isPresent()) throw new UserExistsException("Can not create user with same email");
        if(!UserService.validEmail(userDto.getEmailAsLogin())){
            throw new InvalidEmailFormatException("Provided email does not comply to RFC security standards");
        }

        User newUser = new User();
        BeanUtils.copyProperties(userDto,newUser);
        newUser.setAccountCreated(LocalDateTime.now());

        userRepository.save(newUser);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(n-> new UserDto(n.getFirstName(), n.getLastName(), n.getEmailAsLogin()))
                .collect(Collectors.toList());
    }

    public UserDto getUserByLogin(String email) throws UserNotExistsException {
        Optional<User> toMap = userRepository.findByEmailAsLogin(email);
        if(toMap.isPresent())
            return new UserDto(toMap.get().getFirstName(), toMap.get().getLastName(), toMap.get().getEmailAsLogin());
        else
            throw new UserNotExistsException(String.format("User with email: %s does not exist", email));
    }
}
