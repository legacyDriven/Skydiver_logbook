package pl.skydive.logbook.skydiver_logbook.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.skydive.logbook.skydiver_logbook.dao.UserDto;
import pl.skydive.logbook.skydiver_logbook.exceptions.InvalidEmailFormatException;
import pl.skydive.logbook.skydiver_logbook.exceptions.UserExistsException;
import pl.skydive.logbook.skydiver_logbook.exceptions.UserNotExistsException;
import pl.skydive.logbook.skydiver_logbook.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    private static int counter = 0;

    @GetMapping("/welcome/{name}") //URL/welcome/name
    @ResponseBody
    ResponseEntity<String> welcomeSomeoneViaPathVariable(@PathVariable String name){
        return new ResponseEntity<>("Welcome here, " + name, HttpStatus.OK);
    }

    @GetMapping("/welcome/")
    @ResponseBody
    ResponseEntity<String> welcomeSomeoneViaRequestParam(){
        return new ResponseEntity<>("Welcome here, ", HttpStatus.OK);
    }

    @GetMapping("/getuser")
    @ResponseBody
    public ResponseEntity<UserDto> getUserByLogin(@RequestParam String email) throws UserNotExistsException {//@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getUserByLogin(email), HttpStatus.OK);
    }

    @GetMapping("/getall")
    @ResponseBody
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }

    @PostMapping("/createuser")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDto userDto) throws UserExistsException, InvalidEmailFormatException {
        userService.createUser(userDto);
        System.out.println("created new user");
    }

}
