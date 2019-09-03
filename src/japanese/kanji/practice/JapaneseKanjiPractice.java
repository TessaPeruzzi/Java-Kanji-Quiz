/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package japanese.kanji.practice;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Tessa
 */
public class JapaneseKanjiPractice {
static int questionNum=-1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
     Question[] thequestions=new Question[200]; //Large array to allow me to always add in new kanji
     Scanner scan=new Scanner(new File("question list.txt"));
     String question;
     String pronunciation;
     String definition;
     
     while(scan.hasNext()){
         questionNum++;
         question=scan.nextLine();
         pronunciation=scan.nextLine();
         definition=scan.nextLine();
         Question q=new Question(question, pronunciation, definition);
         thequestions[questionNum]=q;
     }
     doTest(thequestions);
    }
    
    
    static void doTest(Question[] questionlist){
        double score=0;
        Scanner input=new Scanner(System.in);
        NumberFormat percent=NumberFormat.getPercentInstance();
        int questioncounter=0;
        
        for (int i=0; i<=19;i++){
            Random random=new Random();
            int randnum=random.nextInt(questionNum);
            
            questioncounter++;
              
            System.out.println("\n"+questioncounter+".)"+"\t"+questionlist[randnum].getQuestion());
            
            System.out.println("What is the pronunciation of this kanji?");
            String answerP=input.nextLine();
            
            System.out.println("What is the definition of this kanji?");
            String answerD=input.nextLine();
              
              if (answerP.equals(questionlist[randnum].getPronunciation())){
                  score=score+.5;
                  System.out.println("Your pronunciation is correct!");
              } else {
                  System.out.println("WRONG! The correction pronunciation is: "+questionlist[randnum].getPronunciation());
              }
              if (answerD.equals(questionlist[randnum].getDefinition())){
                  score=score+.5;
                  System.out.println("Your definition is correct!");
              }else{
                  System.out.println("WRONG! The correct definition is: "+questionlist[randnum].getDefinition());
              }
              
          }  
        System.out.println("\nYou received a "+percent.format((score/20)));

    }

}
