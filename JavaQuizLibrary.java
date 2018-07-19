package com.example.yukakosunabe.quizapp;

public class JavaQuizLibrary {

    private String mQuestion[] = {
            "What is the result? \n\n class CICCC { \n \t public static void main(String args[]){\n \t\t int x = 10;\n \t\t int y = new CICCC().change(x);\n \t\t System.out.print(x+y); \n}\npublic static int change (int x){\n \t\tx = 12;\n \t\treturn x;\n }\n}",
            "What is the result? \n\npublic class Calculator {\n\tint num = 100;\n\n\tpublic void calc(int num) {\n\t\t\tthis.num = num * 10;\n\t}\n\tpublic void printNum(){\n\t\tSystem.out.println(num);\n\t}\n\n\tpublic static void main(String[] args) {\n\t\t\tCalculator obj = new Calculator ();\n\t\t\tobj.calc(2);\n\t\t\tobj.printNum();\n\t}\n}",
            "Suppose that Horse is a subclass of Animal, and neither class is abstract. Which of the following is an invalid declaration and initialization?\n\n",
            "Consider this program segment. You may assume that wordList has been declared as ArrayList<String>.\n\nfor (String s : wordList) {\n\tif (s.length() < 4)\n\t\tSystem.out.println(\"SHORT WORD\");\n}\n\nWhat is the maximum number of times that SHORT WORD can be printed?"
    };

    private String mChoices[][] = {
            {"20", "22", "24", "Compilation fails."},
            {"20", "100", "1000", "200"},
            {"Horse h = new Horse();", "Horse h = new Animal();", "Animal a = new Animal();", "Animal a = new Horse();"},
            {"3", "4", "wordList.size()", "wordList.size() -1"}
    };

    private String mAnswers[] = {
            "22", "20", "Horse h = new Animal();","wordList.size() -1"
    };


    public String[] getmQuestion() {
        return mQuestion;
    }

    public String getQuestion(int a){
        String question = mQuestion[a];
        return question;
    }

    public String choices1(int a){
        String choices1 = mChoices[a][0];
        return choices1;
    }

    public String choices2(int a){
        String choices2 = mChoices[a][1];
        return choices2;
    }

    public String choices3(int a){
        String choices3 = mChoices[a][2];
        return choices3;
    }

    public String choices4(int a){
        String choices4 = mChoices[a][3];
        return choices4;
    }

    public String getAnswers(int a){
        String answers = mAnswers[a];
        return answers;
    }
}
