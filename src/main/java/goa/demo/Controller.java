package goa.demo;

import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView users(Model model) {
        ModelAndView mw = new ModelAndView("index");
        List users = (List) usersRepository.findAll();
        mw.addObject("users", users);
        return mw;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onExpeption() {
        return "Wrong page number";
    }
}
