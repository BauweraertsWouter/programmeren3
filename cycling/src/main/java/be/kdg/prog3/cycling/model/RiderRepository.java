package be.kdg.prog3.cycling.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RiderRepository extends CrudRepository<Rider, Long> {
}
