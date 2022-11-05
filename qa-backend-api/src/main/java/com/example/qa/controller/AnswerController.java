package com.example.qa.controller;

import com.example.qa.model.Answer;
import com.example.qa.repository.AnswerRepository;
import com.example.qa.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/questions/{questionId}/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping
    public List<Answer> getAnswersByQuestionId(@PathVariable Long questionId) {
        return answerService.getAnswerByQuestionId(questionId);
    }

    @PostMapping
    public Answer addAnswer(@PathVariable Long questionId,
                            @Valid @RequestBody Answer answer) {
        return answerService.addAnswer(questionId, answer);
    }

    @PutMapping("/{answerId}")
    public Answer updateAnswer(@PathVariable Long questionId,
                               @PathVariable Long answerId,
                               @Valid @RequestBody Answer answerRequest) {
        return answerService.updateAnswer(questionId, answerId, answerRequest);
    }

    @DeleteMapping("/{answerId}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long questionId,
                                          @PathVariable Long answerId) {
        return answerService.deleteAnswer(questionId, answerId);
    }
}
