package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Random;

public class LetterGame {

    @FXML
    private TextArea textArea;

    @FXML
    private TextField textField;

    @FXML
    private TextField countOfMoves;


    Random random = new Random();

    private int high = 123;
    private int lower = 97;
    private char symbol;
    private int randomInt;
    private Integer moves;
    private boolean isWinn;

    private Main main;


    public void setMain(Main main) {
        this.main = main;
        setRandom();
    }

    @FXML
    private void sendText(){
        String text = textField.getText().toLowerCase();
        if (!text.equals("")) {
            char entered = text.charAt(0);
            if (symbol == entered) {
                textArea.setText("you winn, count of moves - " + moves);
                isWinn = true;
            }
            if (!isWinn) {
                if (symbol > entered) {
                    textArea.setText("you have entered a small value");
                    moves++;
                } else {
                    textArea.setText("you have entered too much value");
                    moves++;
                }
            }
            countOfMoves.setText(moves.toString());
            textField.clear();
        }
    }

    @FXML
    private void setRandom() {
        randomInt = (random.nextInt(high - lower) + lower);
        moves = 0;
        countOfMoves.setText(moves.toString());
        isWinn = false;
        symbol = (char) randomInt;
    }
}
