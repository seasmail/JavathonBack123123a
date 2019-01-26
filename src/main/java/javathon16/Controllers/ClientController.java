package javathon16.Controllers;

import javathon16.Models.Client;
import javathon16.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @GetMapping("/api/getClientById")
    public Client getClientById(@RequestParam(value = "id") Long id){
        return clientRepository.findById(id).get();
    }

    @GetMapping("/qqq")
    public String qqq(){
        clientRepository.save(new Client(999, "qwe"));
        return "qqq";
    }




}
