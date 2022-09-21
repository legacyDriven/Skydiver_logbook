package pl.skydive.logbook.skydiver_logbook.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.skydive.logbook.skydiver_logbook.domain.Entry;
import pl.skydive.logbook.skydiver_logbook.domain.User;
import pl.skydive.logbook.skydiver_logbook.infrastructure.UserRepository;
import pl.skydive.logbook.skydiver_logbook.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class LogBookRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
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

    @GetMapping("/getUser")
    @ResponseBody
    public User getUserById(@RequestParam Long id){//@PathVariable("id") Long id){

        User ten = User.builder().firstName("get").lastName("juzer").emailAsLogin("mail@ff.com").build();
        userRepository.save(ten);
        return ten;
    }

    @GetMapping("/getUserOther")
    @ResponseBody
    public User getUserByIdOther(@RequestParam Long id){//@PathVariable("id") Long id){

        User ten = new User(null, "bez", "bildera", "besbildera@gmail.com", null, null);

        return ten;
    }

    @GetMapping("/getentry")
    @ResponseBody
    public ResponseEntity<Entry> getEntry(){
        Entry e = new Entry("chuju", "muju");
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping("/getall")
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.FOUND);
    }

    @PostMapping("/createuser")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        userService.createUser(user);
        System.out.println("created new user");
    }


    @PostMapping("/addrandom")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRandom(){
        userRepository.save(User.builder().firstName("imierandom" + counter).lastName("nazwiskoRandom").emailAsLogin("chujumuju@gmail.com").build());
        counter++;
    }


}
