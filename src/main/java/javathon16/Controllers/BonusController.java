package javathon16.Controllers;

import javathon16.Models.Client;
import javathon16.Repositories.BonusRepository;
import javathon16.Repositories.ClientRepository;
import javathon16.Models.Bonus;
import javathon16.Repositories.CompanyRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class BonusController {
    BonusRepository bonusRepository;

    @Autowired
    public BonusController(BonusRepository bonusRepository){
        this.bonusRepository = bonusRepository;
    }

    @GetMapping("/api/client/getbyid")
    public Bonus getBonusByClientIdAndCompanyName(@RequestParam(value = "id") Long clientId,
                                                  @RequestParam(value = "id") Long companyId)
    {
        return bonusRepository.findById(clientId).get(); // TODO!!! Дописать запрос по двум параметрам
    }

    @PostMapping("/api/bonus/add")
    public String addBonus (@RequestParam( value = "id" ) int value){
        bonusRepository.save(new Bonus(value));
        return "Succsessfuly added new bonus with value " + value;
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
