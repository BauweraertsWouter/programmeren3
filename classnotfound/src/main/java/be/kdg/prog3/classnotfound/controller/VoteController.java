package be.kdg.prog3.classnotfound.controller;

import be.kdg.prog3.classnotfound.model.QuestionAnswer;
import be.kdg.prog3.classnotfound.model.QuestionAnswerRepository;
import be.kdg.prog3.classnotfound.model.Vote;
import be.kdg.prog3.classnotfound.model.VoteRepository;
import be.kdg.prog3.classnotfound.security.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {
    private VoteRepository voteRepository;
    private QuestionAnswerRepository questionAnswerRepository;

    @Autowired
    public VoteController(VoteRepository voteRepository, QuestionAnswerRepository questionAnswerRepository) {
        this.voteRepository = voteRepository;
        this.questionAnswerRepository = questionAnswerRepository;
    }

    @PostMapping("/vote/{qaId}/{upOrDown}")
    public void castVote(@PathVariable long qaId, @PathVariable String upOrDown, @AuthenticationPrincipal UserDetails userDetails) {
        final QuestionAnswer qa = this.questionAnswerRepository.findOne(qaId);
        if (qa != null) {
            final Vote vote = new Vote(userDetails.getUser(), qa, upOrDown.equals("up"));
            this.voteRepository.save(vote);

            qa.setScore(qa.getScore() + (vote.isUp() ? 1 : -1));
            this.questionAnswerRepository.save(qa);
        }
        else {
            // TODO: exception handling
        }
    }

    @DeleteMapping("/vote/{qaId}")
    public void deleteVote(@PathVariable long qaId, @AuthenticationPrincipal UserDetails userDetails) {
        final QuestionAnswer qa = this.questionAnswerRepository.findOne(qaId);
        final Vote existingVote = this.voteRepository.findByQuestionAnswerIdAndUserId(qaId, userDetails.getUser().getId());

        if (existingVote != null) {
            this.voteRepository.delete(existingVote.getId());

            if (qa != null) {
                qa.setScore(qa.getScore() + (existingVote.isUp() ? -1 : 1));
                this.questionAnswerRepository.save(qa);
            }
            else {
                // TODO: exception handling
            }
        }
        else {
            // TODO: exception handling
        }
    }
}
