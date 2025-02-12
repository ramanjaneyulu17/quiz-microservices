package com.example.quiz_service.sevice;

import com.example.quiz_service.model.QuestionWrapper;
import com.example.quiz_service.model.Quiz;
import com.example.quiz_service.model.Response;
import com.example.quiz_service.repository.QuizDAO;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDAO quizDAO;

    @Autowired
    QuizInterface quizInterface;

//    @Autowired
//    private QuestionDAO questionDAO;

   public ResponseEntity<String> createQuiz(String category, int numQ, String title, int quizId ) {
        List<Integer> questions= quizInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setId(quizId);
        quiz.setQuestionIds(questions);
        quizDAO.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsByQuizId(int id) {
            Quiz quiz=quizDAO.findById(id).get();
            List<Integer> questionIds=quiz.getQuestionIds();
            ResponseEntity<List<QuestionWrapper>> questions=quizInterface.getQuestionsFromIds(questionIds);
            return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}
