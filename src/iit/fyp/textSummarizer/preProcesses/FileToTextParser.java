package iit.fyp.textSummarizer.preProcesses;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import com.aliasi.sentences.MedlineSentenceModel;
import com.aliasi.sentences.SentenceModel;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.Tokenizer;
import com.aliasi.tokenizer.TokenizerFactory;

public class FileToTextParser {
	
	public FileToTextParser() {
		// TODO Auto-generated constructor stub
	}

	
	
    private static final TokenizerFactory TOKENIZER_FACTORY = IndoEuropeanTokenizerFactory.INSTANCE;
    private static final SentenceModel SENTENCE_MODEL = new MedlineSentenceModel();

    
private String[] extractPDFText(InputStream inputStream) {
	
	
	ArrayList<String> sentences = new ArrayList<String>(); 
	
    try {
    	

    	org.apache.pdfbox.pdmodel.PDDocument pddoc = new org.apache.pdfbox.pdmodel.PDDocument();
    	pddoc = PDDocument.load(inputStream);
    	
    	
    	PDFTextStripper stripper = new PDFTextStripper();
    	if(!pddoc.isEncrypted()){
        		String PDFText = stripper.getText(pddoc);
    			
        		
        	
        	 	List<String> tokenList = new ArrayList<String>();
        	    List<String> whiteList = new ArrayList<String>();
        	    Tokenizer tokenizer  = TOKENIZER_FACTORY.tokenizer(PDFText.toCharArray(),0,PDFText.length());
        	    tokenizer.tokenize(tokenList,whiteList);
        	    
        	    String[] tokens = new String[tokenList.size()];
        	    String[] whites = new String[whiteList.size()];
        	    tokenList.toArray(tokens);
        	    whiteList.toArray(whites);
        	    int[] sentenceBoundaries = SENTENCE_MODEL.boundaryIndices(tokens,whites);
        	    
        	    
        	    int sentStartTok = 0;
        	    int sentEndTok = 0;

        	    for (int i = 0; i < sentenceBoundaries.length; ++i) {
        	        sentEndTok = sentenceBoundaries[i];
        	        String sentence = "";
        	        for (int j=sentStartTok; j <= sentEndTok; j++) {
        	        	String word = tokens[j]+whites[j+1];
        	        	
        	            
        	            
        	            if(word != null)
	        	            sentence += word; 

        	            if(sentEndTok == j)
        	            	sentences.add(sentence.trim());
        	            	
        	            
        	        }
        	        
        	        sentStartTok = sentEndTok+1;
        	    }
        
        	
        	   
        	pddoc.close();
    	
    	}else{
    		
    		System.out.println("Unable open the PDF encrypted.");
    		
    	}
    } catch (Exception e) {
        System.out.println("Unable to open PDF Parser."+e);
        return null;
    }
    
    
    String[] sentencesArray = new String[sentences.size()];
    int count = 0;
    
    for (Iterator<String> iterator = sentences.iterator(); iterator
			.hasNext();) {
		sentencesArray[count] = (String) iterator.next();
		
		count++;
		
	}

    return sentencesArray;
	
	
}    

private String[] extractDocxText(InputStream inputStream) throws Exception {
	

		XWPFDocument xwpfDocument = new XWPFDocument(inputStream);
		List<XWPFParagraph> xwpfParagraphs = xwpfDocument.getParagraphs();
		String[] paragraphs = new String[xwpfParagraphs.size()];

		String text = "";
		
	for (int i = 0; i < xwpfParagraphs.size(); i++) {
		
		
		text += " "+xwpfParagraphs.get(i).getParagraphText()+"\n"; 
		
	}
		
	return this.sentenceBreaker(text);
	     
	
}

private String[] extractDocText(InputStream inputStream)throws Exception{
	

	
	POIFSFileSystem fs = new POIFSFileSystem(inputStream);
	HWPFDocument hwpfDocument = new HWPFDocument(fs);
	WordExtractor wordExtractor = new WordExtractor(hwpfDocument);
	
	String[] pText = wordExtractor.getParagraphText();
	String text = "";
	for (int i = 0; i < pText.length; i++) {
		text += pText[i]+"\n";
	}
	
	return this.sentenceBreaker(text);
	
	//return wordExtractor.getParagraphText();
	 
}


private InputStream getFileInputStream(String input){
	System.out.println(input);
	InputStream inputStream = null;
	
	File file = new File(input);
	try {
		
		inputStream = new FileInputStream(file);
		
	} catch (FileNotFoundException e) {
		// TODO: handle exception
		
		System.err.println("File Not Found in "+input );
	}
	
	
	
	
	return inputStream;
}


private String getFileExtention(String fileName){
	String extention = null;
	
	int dotPosition = fileName.lastIndexOf(".");
	extention = fileName.substring(dotPosition);
	
	
	return extention;
}


public static void main(String args[]) throws Exception{
	String[] paragraphTexts =null;
	//String fileName = "D:/IIT/fahiz/4th year/FYP/Litriture Review .docx";
	//String fileName = "D:/IIT/fahiz/4th year/FYP/Litriture Review.docx";
//	String fileName = "C:/Users/Fahiz/Desktop/Litriture Review - Copy.pdf";
	String fileName = "C:/Users/Fahiz/Desktop/LR.docx";
	//String fileName = "C:/Users/Fahiz/Desktop/LR.doc";
	
	//String fileName = "D:/IIT/fahiz/4th year/FYP/Fahiz TOR.doc";
	FileToTextParser docx = new FileToTextParser();

	paragraphTexts = docx.getTextFromFile(fileName);
	String print = "";
	
		for (int i = 0; i < paragraphTexts.length; i++) {
			print += paragraphTexts[i];
			System.out.println(paragraphTexts[i]);
		}
		
		docx.writeToTextFile(print, "D:/IIT/fahiz/4th year/docText.txt");
		
	
	
}


public void writeToTextFile(String text, String fileName) {
 
    	
    	System.out.println("\nWriting PDF text to output text file " + fileName + "....");
    	try {
    		PrintWriter pw = new PrintWriter(fileName);
    		pw.print(text);
    		pw.close();    	
    	} catch (Exception e) {
    		System.out.println("An exception occured in writing the pdf text to file.");
    		e.printStackTrace();
    	}
    	System.out.println("Done.");
   
}

public String[] getTextFromFile(String fileName) throws Exception{
	
	
	
	String[] paragraphTexts =null;
	

	InputStream inputStream = this.getFileInputStream(fileName);
	
	if(this.getFileExtention(fileName).equalsIgnoreCase(".docx")){
		
		paragraphTexts =this.extractDocxText(inputStream);
		
	}else if (this.getFileExtention(fileName).equalsIgnoreCase(".doc")) {
		paragraphTexts = this.extractDocText(inputStream);
	}else if (this.getFileExtention(fileName).equalsIgnoreCase(".pdf")) {
		
		paragraphTexts = this.extractPDFText(inputStream);
		
	}else{
		
		System.err.println("Invalid File Format"); 
		return null;
	}
	

	return paragraphTexts;

		
}

private String[] sentenceBreaker(String text){
	
	ArrayList<String> sentences = new ArrayList<String>(); 
	List<String> tokenList = new ArrayList<String>();
    List<String> whiteList = new ArrayList<String>();
    Tokenizer tokenizer  = TOKENIZER_FACTORY.tokenizer(text.toCharArray(),0,text.length());
    tokenizer.tokenize(tokenList,whiteList);
    
    String[] tokens = new String[tokenList.size()];
    String[] whites = new String[whiteList.size()];
    tokenList.toArray(tokens);
    whiteList.toArray(whites);
    int[] sentenceBoundaries = SENTENCE_MODEL.boundaryIndices(tokens,whites);
    
    
    int sentStartTok = 0;
    int sentEndTok = 0;

    for (int i = 0; i < sentenceBoundaries.length; ++i) {
        sentEndTok = sentenceBoundaries[i];
        String sentence = "";
        for (int j=sentStartTok; j <= sentEndTok; j++) {
        	String word = tokens[j]+whites[j+1];
        	
            
            
            if(word != null)
	            sentence += word; 

            if(sentEndTok == j)
            	sentences.add(sentence.trim());
            	
            
        }
        
        sentStartTok = sentEndTok+1;
    }

    String[] toReturn =new String[sentences.size()];
    int x = 0;
    
    for (Iterator iterator = sentences.iterator(); iterator.hasNext();) {
		String string = (String) iterator.next();
		
		toReturn[x] = string;
		
		x++;
	}
    
    return toReturn;
    
}

}
