package goa.demo;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private final UsersRepository usersRepository;

    Controller(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/")
    String hello() {
        return "Hello world";
    }

    @GetMapping("/users")
    Iterable<Users> users() {
        return usersRepository.findAll();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onExpeption() {
        return "Wrong page number";
    }
}
