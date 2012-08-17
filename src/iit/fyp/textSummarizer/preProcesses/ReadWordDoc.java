package iit.fyp.textSummarizer.preProcesses;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
public class ReadWordDoc {

	private File docFile = null;
	private WordExtractor wordExtractor = null;
	private String[] docContentArray = null;
	private int lineLength = 0;
	private String title;
	
	public ReadWordDoc(String filePath){
		
		docFile = new File(filePath);
		this.fileReader();
		
	}
	
	private void fileReader(){
		
		try {
			FileInputStream fileInputStream = new FileInputStream(docFile);
			HWPFDocument hwpfDocument = new HWPFDocument(fileInputStream);
			wordExtractor = new WordExtractor(hwpfDocument);
			
			
			System.out.println(hwpfDocument.getStyleSheet().getStyleDescription(1));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		docContentArray=wordExtractor.getParagraphText();
		
		lineLength=docContentArray.length;
		
	}
	
	public String[] getSentences(){
		
		return this.docContentArray;
				
				
	}
	
	public int getNoOfSentences(){
		
		return this.lineLength;
	}
	
	public static void main(String args[]){
		
		ReadWordDoc rwd = new ReadWordDoc("D:/IIT/fahiz/4th year/FYP/Fahiz TOR.doc");
		System.out.println(rwd.getNoOfSentences());
		
		/*for (int i = 0; i < rwd.getSentences().length; i++) {
			System.out.println(rwd.getSentences()[i].toString());
		}*/
		System.out.println(rwd.getSentences()[99].toString());
		System.out.println(rwd.getSentences()[100].toString());
		System.out.println(rwd.getSentences()[101].toString());
		System.out.println(rwd.getSentences()[102].toString());
		System.out.println(rwd.getSentences()[103].toString());
	}
}
