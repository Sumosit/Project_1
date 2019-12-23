package goa.demo;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final ClientRepository clientRepository;

    public Controller(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("get")
    public List<Client> doGet(@RequestParam(required = false, defaultValue = "0") Integer page) {

        return clientRepository.findAll(PageRequest.of(page, 5)).getContent();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onExpeption() {
        return "Wrong page number";
    }
}
