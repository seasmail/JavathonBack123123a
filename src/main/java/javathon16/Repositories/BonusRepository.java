package javathon16.Repositories;

import javathon16.Models.Bonus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BonusRepository extends CrudRepository<Bonus, Integer> {

    Bonus findByClientIdAndCompanyId(int clientId, int companyId);

}
