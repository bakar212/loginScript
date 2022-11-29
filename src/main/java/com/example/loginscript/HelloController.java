package com.example.loginscript;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.HashMap;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Text message;
    @FXML
    private TextField user1;
    @FXML
    private PasswordField pass1;

    HashMap<String, String> database = new HashMap<>();
    private int attempts = 4;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void clicked(){
        if(user1.getLength() > 0 && pass1.getLength() > 0 && attempts > 0){//ensures text fields and password fields are not empty
            //user still is allowed to input password
            executeB(user1.getText().toLowerCase(), pass1.getText());

        }else{
            user1.setDisable(true);
            pass1.setDisable(true);
            message.setText("THIS ACCOUNT IS NOW LOCKED!");
        }


    }

    @FXML
    protected void regClicked(){//register button clicked, to add user details to database

        if(user1.getLength() > 0 && pass1.getLength() > 0 && attempts > 0){//ensures text fields and password fields are not empty
            //user still is allowed to input password
            database.put(user1.getText(), pass1.getText());//adds details to hashmap dataset
            message.setText("SUCCESSFULLY REGISTERED USER DETAILS!");
        }



    }

    public int executeB(String login, String password) {

        database.put("chipmunks69", "Teamaqua12");//adding 4 entries for username and password
        database.put("bax212", "fatboySlim919");//to the hashmap

        if(database.containsKey(login) && database.get(login).equals(password)) {//first condition checks whether the login
            message.setText("Access Granted!");//input exists in our database, and then whether the password input matches
            //with the value in our database

            return 1;//code value to let system know the outcome, 1 = success
            //0 = failure
        }
        else if(database.containsKey(login) && !database.get(login).equals(password)) {//second condition checks whether the login
            //input exists in our database, however the password input  does not match
            //with the value in our database
            attempts--;
            message.setText("Error! The Password is incorrect\n"+"ATTEMPTS REMAINING: "+attempts);


            return 0;
        }
        else {//for all other conditions
            message.setText("Error the username does not exist!");
            return 0;
        }
    }

}