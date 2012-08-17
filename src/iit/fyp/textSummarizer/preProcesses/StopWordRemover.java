package iit.fyp.textSummarizer.preProcesses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class StopWordRemover {
	
	private File file;
	private BufferedReader bufferedReader, temp;
	private String fileText;
	private Pattern pattern;

	public StopWordRemover(String fileName){
		file = new File(fileName);
		fileText=null;
	    temp=new BufferedReader(new InputStreamReader(System.in));
	    pattern = Pattern.compile("[\\.\\!\\?]\\s+|\n", Pattern.MULTILINE);
	    
	}
	
    private void readFile(){
        try {
            
            StringBuffer stringBuffer=new StringBuffer();
            String filedata=null;
            
            bufferedReader=new BufferedReader(new FileReader(file));

            while((filedata=bufferedReader.readLine())!=null){
                stringBuffer.append(filedata).append(System.getProperty("line.separator"));
        }

            fileText=stringBuffer.toString();

        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
            

        }
        
        
    }
    
    public void readWordDoc(){
        File filedoc=null;
        WordExtractor wordExtractor=null;
        WordExtractor exprExtractor=null;

        try {
            filedoc=new File("D:/IIT/fahiz/4th year/FYP/Fahiz TOR.doc");
            FileInputStream fileInputStream=new FileInputStream
                    (filedoc.getAbsolutePath());

            HWPFDocument hWPFDocument=new HWPFDocument(fileInputStream);
            wordExtractor=new WordExtractor(hWPFDocument);


        } catch (Exception e) {
        }

        String[] docArray=wordExtractor.getParagraphText();

        StopWordEliminator stopWordEliminator=new StopWordEliminator
                ("Stopwords/stopwords3.txt");



        for (int i = 0; i < docArray.length; i++) {
            if(docArray[i]!=null){
                System.out.println("Line" + i + " : " + docArray[i]);
                System.out.println("Summary" + i + " : " + stopWordEliminator.filterSentence(docArray[i]));
            }

        }
    }

    /**
     * Function to remove stop words from sentences
     */

    public void removeStopWords(){
        String filteredSentence="";
        String sentence="";
        BufferedReader bufferedReader=null;

        StopWordEliminator stopWordEliminator=new StopWordEliminator
                ("Stopwords/stopwords3.txt");

        System.out.println("");
        this.getSplittedSentences();
        System.out.println(fileText);

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("-------------Stop Word Free----------------");

        System.out.println(getNumberofSentences());


        for (int i = 0; i < getNumberofSentences(); i++) {
            System.out.println("Sentence" + i + " : " + this.getSplittedSentences()[i]);
            sentence=stopWordEliminator.filterSentence(this.getSplittedSentences()[i]);
            System.out.println("Summary" + i + " : " + sentence);
            if(1==0)
                filteredSentence=sentence;
            else
                filteredSentence=filteredSentence+sentence;

        }
        
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("The Summarized Collection");
       System.out.println(filteredSentence);
        System.out.println("--------------------- THATS THE END---------------------");


    }
    
    private String[] splitParagraph(){
        
        this.readFile();
        return pattern.split(fileText);
    }
    
    
    public int getNumberofSentences(){
        return this.splitParagraph().length;
    }
    
    public String[] getSplittedSentences(){
       return this.splitParagraph();
    }
    
public static void main(String args[]){
		
		StopWordRemover SWE = new StopWordRemover("D:/IIT/fahiz/4th year/FYP/Fahiz TOR.doc");
		
		SWE.readFile();
		SWE.readWordDoc();
		SWE.removeStopWords();
		System.out.println(SWE.splitParagraph());
		System.out.println(SWE.getNumberofSentences());
		
	}
	
	
	
}
