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
    }

    @GetMapping("/api/client/findbonus")
    public List<Bonus> getBonusByClientIdAndCompanyName(@RequestParam(value = "id") Long clientId,
                                                        @RequestParam(value = "id") Long companyId)
    {
        return bonusRepository.findAllByClientIdAndCompanyId(clientId, companyId);
    }

    @PostMapping("/api/bonus/add")
    public void addBonus(@RequestParam(value = "clientPhoneNumber") String phoneNumber,
                         @RequestParam(value = "companyName") String name) {
        Company company =
    }
    public String checkBonusAdge (@RequestParam(value = "id") Long clientId,
                                  @RequestParam(value = "id") Long companyId)
    {
        if (clientRepository.findById(clientId).getBonus == companyRepository.findById(companyId).get().getMaxBonus)
        {
            clientRepository.findById(clientId).get().set(companyId);
            return " You can get the prize!";
        }
        return "Not enoughth bonuses to get a prize!";
    }

}
