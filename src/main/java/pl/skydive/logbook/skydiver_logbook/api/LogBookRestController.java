package pl.skydive.logbook.skydiver_logbook.api;


import org.springframework.web.bind.annotation.*;
import pl.skydive.logbook.skydiver_logbook.domain.Entry;
import pl.skydive.logbook.skydiver_logbook.domain.User;


@RestController
@RequestMapping
public class LogBookRestController {

    @GetMapping
    @ResponseBody
    String welcomeSomeone(){
        return "welcome here";
    }

    @GetMapping("/getUser")
    @ResponseBody
    public User getUserById(){//@PathVariable("id") Long id){
        return new User();
    }

    @GetMapping("/getentry")
    @ResponseBody
    public Entry getEntry(){
        return new Entry("chuju", "muju");

    }

    @PostMapping("/createUser")
    public void createUser(){
        System.out.println("created new user");
    }
}
