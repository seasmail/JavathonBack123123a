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
        clientRepository.save(new Client(789, "jeffff"));
        clientRepository.save(new Client(555, "hhhh"));
    }

    @GetMapping("/api/client/getbyid")
    public Client getClientById(@RequestParam(value = "id") Long id){
        return clientRepository.findById(id).get();
    }

    @PostMapping("/api/client/add")
    public String addclient(@RequestParam(value = "name") String name,
                            @RequestParam(value = "phoneNumber") int phoneNumber){
        clientRepository.save(new Client(phoneNumber, name));
        return "success!";
    }

    @GetMapping("/api/client/deletebyid")
    public String deleteClient(@RequestParam(value = "id") Long id){

        clientRepository.deleteById(id);
        return "success!";

    }




}
