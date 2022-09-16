package pl.skydive.logbook.skydiver_logbook.api;


import org.springframework.web.bind.annotation.*;
import pl.skydive.logbook.skydiver_logbook.domain.User;

@RestController
@RequestMapping("/api")
public class LogBookRestController {

    @GetMapping("getUser")
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id){
        return new User();
    }

    @PostMapping("createUser")
    public void createUser(){

    }
}
