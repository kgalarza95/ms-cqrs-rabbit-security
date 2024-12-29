package ec.com.sofka;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PingController {

    @GetMapping("/ping")
    public String sendMessage() {
        return "Hola mundo;";
    }
}
