package javathon16.Controllers;

import javathon16.Models.Client;
import javathon16.Models.Company;
import javathon16.Repositories.BonusRepository;
import javathon16.Repositories.ClientRepository;
import javathon16.Models.Bonus;
import javathon16.Repositories.CompanyRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class BonusController {
    BonusRepository bonusRepository;
    CompanyRepository companyRepository;
    ClientRepository clientRepository;

    @Autowired
    public BonusController(BonusRepository bonusRepository,
                           CompanyRepository companyRepository,
                           ClientRepository clientRepository){

        this.bonusRepository = bonusRepository;
        this.companyRepository = companyRepository;
        this.clientRepository = clientRepository;
        bonusRepository.save(new Bonus(2,1));
    }

    @GetMapping("/api/bonus/findbonus")
    public Bonus getBonusByClientIdAndCompanyName(@RequestParam(value = "clientId") int clientId,
                                                        @RequestParam(value = "companyId") int companyId)
    {
        return bonusRepository.findByClientIdAndCompanyId(clientId, companyId);
    }

    @PostMapping("/api/bonus/add")
    public void addBonus(@RequestParam(value = "clientPhoneNumber") Long phoneNumber,
                         @RequestParam(value = "companyName") String name) {
        Company company = companyRepository.findByName(name);
        Client client = clientRepository.findByPhoneNumber(phoneNumber);
        bonusRepository.save(new Bonus(company.getId(), client.getId()));
    }

    @GetMapping("/api/bonus/increase")
    public Bonus increaseBonus(@RequestParam(value = "clientPhoneNumber") String phoneNumber,
                         @RequestParam(value = "companyName") String name) {
        Company company = companyRepository.findByName(name);
        System.out.println(company.getId());
        Client client = clientRepository.findByPhoneNumber(Long.parseLong(phoneNumber));
        System.out.println(client.getId());
        Bonus tmp = bonusRepository.findByClientIdAndCompanyId(1, 2);
        System.out.println(tmp);
        tmp.setValue(tmp.getValue() + 1);
        bonusRepository.save(tmp);
        return tmp;
    }
    @PostMapping("/api/bonus/resetBonuses")
    public String resetBonuses(@RequestParam(value = "clientPhoneNumber") Long phoneNumber,
                             @RequestParam(value = "companyName") String name){
        Company company = companyRepository.findByName(name);
        Client client = clientRepository.findByPhoneNumber(phoneNumber);
        Bonus tmp = bonusRepository.findByClientIdAndCompanyId(1, 2);
        tmp.setValue(0);
        bonusRepository.save(tmp);
        return "На вашем счете 0 бонусов";
    }

}
