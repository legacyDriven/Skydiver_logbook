package pl.skydive.logbook.skydiver_logbook.dao;

import pl.skydive.logbook.skydiver_logbook.domain.User;
import pl.skydive.logbook.skydiver_logbook.infrastructure.UserRepository;


public class UserDaoImpl implements UserDao {

    private UserRepository userRepository;

    @Override
    public void addUser(UserDto userDto) {
        userRepository.save(User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .emailAsLogin(userDto.getEmail())
                .build());
    }

    @Override
    public boolean userExists(UserDto userDto) {
//        userRepository.findById()
        return false;
    }
}
