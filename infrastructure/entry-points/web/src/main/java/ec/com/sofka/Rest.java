package ec.com.sofka;

import ec.com.sofka.data.RequestDTO;
import ec.com.sofka.data.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Rest {

    private final Handler handler;

    public Rest(Handler handler) {
        this.handler = handler;
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<ResponseDTO> getAccountById(@PathVariable String id){
        return new ResponseEntity<>(handler.getAccountById(id), HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody RequestDTO requestDTO){
        return new ResponseEntity<>(handler.createAccount(requestDTO), HttpStatus.CREATED);
    }

}
