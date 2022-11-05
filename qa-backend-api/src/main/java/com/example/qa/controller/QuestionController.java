package com.example.qa.controller;

import com.example.qa.model.Question;
import com.example.qa.repository.QuestionRepository;
import com.example.qa.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public Page<Question> getQuestions(Pageable pageable) {
        return questionService.getQuestions(pageable);
    }

    @PostMapping
    public Question createQuestion(@Valid @RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    @PutMapping("/{questionId}")
    public Question updateQuestion(@PathVariable Long questionId,
                                   @Valid @RequestBody Question question) {
        return questionService.updateQuestion(questionId, question);
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
        return questionService.deleteQuestion(questionId);
    }
}