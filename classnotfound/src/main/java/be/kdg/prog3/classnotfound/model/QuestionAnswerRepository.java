package be.kdg.prog3.classnotfound.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface QuestionAnswerRepository extends CrudRepository<QuestionAnswer, Long> {
    List<QuestionAnswer> findTop10ByOrderByTimestampDesc();
}
