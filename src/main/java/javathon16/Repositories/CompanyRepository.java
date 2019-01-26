package javathon16.Repositories;

import javathon16.Models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company,Integer> {
    Company findByName(String name);
}
