package com.example.demo6;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TriviaGameController {

    @FXML
    private Label questionLabel;
    private Label scoreLabel;

    @FXML
    private Button option1Button;

    @FXML
    private Button option2Button;

    @FXML
    private Button option3Button;

    @FXML
    private Button option4Button;

    @FXML
    private Label feedbackLabel;

    private int currentQuestionIndex = 0;
    private int score = 0;

    private final String[] questions = {
            "What is the highest peak in Lesotho?",
            "Which traditional Basotho hat is commonly worn by locals?",
            "When did Lesotho gain independence from Britain?",
            "Which famous  landmark is located in Thaba Bosiu?",
            "What is the capital city of Lesotho?"
    };

    private final String[][] options = {
            {"Thabana Ntlenyana", "Mount Qiloane", "Thaba Bosiu", "Sani Pass"},
            {"Mokorotlo", "Ts'hepe", "Seana Marena", "Mohobo"},
            {"1966", "1970", "1980", "1990"},
            {"Royal Palace", "Thaba Bosiu", "Katse Dam", "Afriski Mountain Resort"},
            {"Maseru", "Mafeteng", "Hlotse", "Mohale's Hoek"}
    };

    private final int[] answers = {0, 0, 0, 1, 0};

    @FXML
    public void initialize() {
        showQuestion();
    }

    private void showQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionLabel.setText(questions[currentQuestionIndex]);
            option1Button.setText(options[currentQuestionIndex][0]);
            option2Button.setText(options[currentQuestionIndex][1]);
            option3Button.setText(options[currentQuestionIndex][2]);
            option4Button.setText(options[currentQuestionIndex][3]);
            feedbackLabel.setText("");
        } else {
            displayFinalScore();
        }
    }

    @FXML
    public void checkAnswer(ActionEvent event) {
        Button clickedButton =(Button)event.getSource();
       currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            showQuestion();
        } else {
            displayFinalScore();
        }
        int selectedOptionIndex = 0;
        if(selectedOptionIndex ==answers[currentQuestionIndex]){
    score++;
    feedbackLabel.setText("correct answer!");
}else{
            feedbackLabel.setText("incorrect! the correct answer is:" +options[currentQuestionIndex][answers[currentQuestionIndex]]);
        }
        updateScoreLabel();
    }

    private void updateScoreLabel() {
        scoreLabel.setText("score:"+score);

    }

    private void showNextQuestion(){
       if(currentQuestionIndex< questions.length){
           showQuestion();
       }else{
          displayFinalScore();
       }
    }

    private void displayFinalScore() {
        questionLabel.setText("Game Over! Your final score is: " + score + " out of " + questions.length);
        option1Button.setVisible(false);
        option2Button.setVisible(false);
        option3Button.setVisible(false);
        option4Button.setVisible(false);
    }
    

}



