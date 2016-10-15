package be.kdg.prog3.cycling.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findByUciCode(String uciCode);
}
