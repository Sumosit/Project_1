package goa.demo;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @GetMapping("/")
    String hello() {
        return "Hello world";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onExpeption() {
        return "Wrong page number";
    }
}
