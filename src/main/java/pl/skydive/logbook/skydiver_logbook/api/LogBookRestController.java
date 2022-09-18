package pl.skydive.logbook.skydiver_logbook.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.skydive.logbook.skydiver_logbook.domain.Entry;
import pl.skydive.logbook.skydiver_logbook.domain.User;
import pl.skydive.logbook.skydiver_logbook.service.UserService;


@RestController
@RequestMapping("/api")
public class LogBookRestController {
    private UserService userService;

    @GetMapping
    @ResponseBody
    String welcomeSomeone(){
        return "welcome here";
    }

    @GetMapping("/getUser")
    @ResponseBody
    public User getUserById(@RequestParam Long id){//@PathVariable("id") Long id){
        return new User();
    }

    @GetMapping("/getentry")
    @ResponseBody
    public ResponseEntity<Entry> getEntry(){
        Entry e = new Entry("chuju", "muju");
        return new ResponseEntity<>(e, HttpStatus.OK);

    }

    @PostMapping("/createuser")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        userService.createUser(user);
        System.out.println("created new user");
    }
}
