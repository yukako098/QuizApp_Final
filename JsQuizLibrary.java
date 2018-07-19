package com.example.yukakosunabe.quizapp;

public class JsQuizLibrary {
    private String mQuestion[] = {
            "Integer Variable + Character Variable + Undefined Variable = ______________ Value",
            "Which of the following is not a comparison operator ?",
            "What will be the output of the following script ?\n\n<!DOCTYPE html>\n<html>\n\n\t<body>\n\t\t<script>\n\t\t\tvar x = 5;\n\t\t\tdocument.write(x === \"5\");\n\t\t</script>\n\t</body>\n\n</html>",
            "What will be the output of the following script ?\n\n<!DOCTYPE html>\n<html>\n\n\t<body>\n\t\t<script>\n\t\t\tvar x = 5;\n\t\t\tdocument.write(x == \"5\");\n\t\t</script>\n\t</body>\n\n</html>"
    };

    private String mChoices[][] = {
            {"Undefined Value",
                    "Integer",
                    "Character",
                    "Text / String Value"},

            {"++", "<=","===", "=="},

            {"5", "true", "1","false"},

            {"5", "true", "undefined","false"},

    };

    private String mCorrectAnswers[] = {"Undefined Value", "++", "false", "true"};


    // getter
    public String[] getmQuestion() {
        return mQuestion;
    }



    public String getQuestion(int a){
        String question = mQuestion[a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoice4(int a){
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }




}
