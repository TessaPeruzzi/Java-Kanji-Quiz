/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package japanese.kanji.practice;

/**
 *
 * @author Tessa
 */
public class Question {
private String question;
private String pronunciation;
private String definition;

public Question(String q,String p, String d){
    question=q;
    pronunciation=p;
    definition=d;
}
public String getQuestion(){
    return question;
}
public String getPronunciation(){
    return pronunciation;
}
public String getDefinition(){
    return definition;
}
@Override
public String toString(){
    String s;
    s="For Kanji "+ question+":"+"\n"+"The Pronunciation is: "+pronunciation+"\nThe Definition is: "+definition+"\n";
    return s;
    }
}
