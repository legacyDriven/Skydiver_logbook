package pl.skydive.logbook.skydiver_logbook.dao;

public interface UserDao {

    void addUser(UserDto userDto);

    boolean userExists(UserDto userDto);
}
