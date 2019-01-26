package javathon16.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @RequestMapping("/q")
    public String q(){
        return "qqq";
    }
}
