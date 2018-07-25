package com.example.yukakosunabe.quizapp.QuizLibrary;

public class HtmlCssQuizLiblary {
    private String mQuestion[] = {
            "What is the difference between a start tag and an end tag?",
            "Which is not a valid location for CSS declarations?",
            "What type of content can be placed into a <td> table cell element?",
            "What CSS technique could we use to force a <div> element to center itself horizontally in the browser window, no matter what the screen dimensions are?"
    };

    private String mChoices[][] = {
            {"An end tag starts with a forward slash",
             "They are identical",
             "An end tag is capitalized.",
             "An end tag is mandatory but a start tag is optional."},

            {"Inline", "CSS div after the opening <body> tag",
             "External Style Sheet", "Internal Style Sheet"},

            {"Text only", "Text and links only", "Text, links, and lists only",
             "Text, links, lists, and images"},

            {"Set the text-align property of the <div> to center.",
             "Set the right and left margins of the <div> to auto.",
             "Set the screen property of the <div> to horizontal-center.",
             "Set the width property of the <div> to be 50%"},

    };

    private String mCorrectAnswers[] = {"An end tag starts with a forward slash", "CSS div after the opening <body> tag",
                                        "Text, links, lists, and images", "Set the right and left margins of the <div> to auto."};


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
