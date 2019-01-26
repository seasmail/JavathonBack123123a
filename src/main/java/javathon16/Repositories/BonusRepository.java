package javathon16.Repositories;

import javathon16.Models.Bonus;
import org.springframework.data.repository.CrudRepository;

public interface BonusRepository extends CrudRepository<Bonus, Long> {

    Iterable<Bonus> findAllByIdClientAndIdCompany(Long idClient, Long idCompany);

}
