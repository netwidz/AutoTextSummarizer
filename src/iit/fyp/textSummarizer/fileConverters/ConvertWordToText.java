/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.fyp.textSummarizer.fileConverters;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.TextPiece;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
/**
 *
 * @author Fahiz
 */
public class ConvertWordToText {
    
    private String fileName;
    private String parsedText = null;
    
    
    public ConvertWordToText(){
    
       
    }
    
    public void wordToText(String wordFileName){
        
         fileName = wordFileName;
        System.out.println("Parsing text from word file " + fileName + "....");
    
        FileInputStream fileInputStream = null;
        
        
        try {

            File file = new File(fileName);
             if (!file.isFile()) {
                 System.out.println("File " + fileName + " does not exist.");
                // return null;
             }else{
            
            
                fileInputStream = new FileInputStream(file);       

                HWPFDocument hwpfDoc = new HWPFDocument(fileInputStream);
                
                    Object[] textStack=hwpfDoc.getTextTable().getTextPieces().toArray();
System.out.println(textStack.toString());

                for (int i = 0; i < textStack.length; i++) {
                    if(parsedText==null){
                        parsedText=((TextPiece)textStack[i]).getStringBuffer().toString();

                    }else{
                        parsedText=parsedText + " " + ((TextPiece)textStack[i]).getStringBuffer().toString();
                    }


                }

                System.out.println(parsedText);
                FileWriter fileWriter=new FileWriter(fileName + ".txt");
                fileWriter.write(parsedText);
                fileWriter.close();
                
             }
                    
            
            
    
            
            
        } catch (Exception e) {
            Logger.getLogger(ConvertWordToText.class.getName()).log(Level.SEVERE, null, e);
        }
        

        
        
        
    }
    
    
    
    
    
}
