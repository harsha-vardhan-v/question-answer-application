package com.example.qa.service;

import com.example.qa.exception.ResourceNotFoundException;
import com.example.qa.model.Answer;
import com.example.qa.repository.AnswerRepository;
import com.example.qa.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public List<Answer> getAnswerByQuestionId (Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    public Answer addAnswer(Long questionId, Answer answer) {
        return questionRepository.findById(questionId)
                .map(question -> {
                    answer.setQuestion(question);
                    return answerRepository.save(answer);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
    }

    public Answer updateAnswer(Long questionId, Long answerId, Answer answerRequest) {
        if (!questionRepository.existsById(questionId)) {
            throw new ResourceNotFoundException("Question not found with id " + questionId);
        }

        return answerRepository.findById(answerId)
                .map(answer -> {
                    answer.setText(answerRequest.getText());
                    return answerRepository.save(answer);
                }).orElseThrow(() -> new ResourceNotFoundException("Answer not found with id " + answerId));
    }

    public ResponseEntity<?> deleteAnswer(Long questionId, Long answerId) {
        if (!questionRepository.existsById(questionId)) {
            throw new ResourceNotFoundException("Question not found with id" + questionId);
        }

        return answerRepository.findById(answerId)
                .map(answer -> {
                    answerRepository.delete(answer);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Answer not found with id" + answerId));
    }
}
