package javathon16.Controllers;

import javathon16.Models.Company;
import javathon16.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    CompanyRepository companyRepository;

    @Autowired
    CompanyController(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @GetMapping("/api/company/getbyid")
    public Company getById(@RequestParam(value = "id") Long id){
        return companyRepository.findById(id).get();
    }

}
