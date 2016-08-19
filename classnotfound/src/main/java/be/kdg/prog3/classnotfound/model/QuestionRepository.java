package be.kdg.prog3.classnotfound.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findTop10ByOrderByTimestampDesc();
}
