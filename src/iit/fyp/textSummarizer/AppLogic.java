package iit.fyp.textSummarizer;

import java.util.ArrayList;

public class AppLogic {
	
	public static boolean init = false;
	private static String filePath;
	private static textSummarizer txtSummarizer;
	
	public AppLogic() {
		// TODO Auto-generated constructor stub
	
		
	}
	
	private static void initializer(){
		
		txtSummarizer = new textSummarizer();
		try {
			txtSummarizer.preProcessOfDocument(filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init = true;
		
	}
	
	public static void setFilePath(String file){
		initializer();
//		System.out.println(file);
		filePath = file;
		
	}
	
	public static String  getFilePath(){
		return filePath;
	}
	
	public static String getOriginalText(){
		
		return txtSummarizer.originalText();
	}
	
	public static String getFilteredText(){
		
		return txtSummarizer.filteredText();
	}
	
	private static void createBaseSummary(){
		
		txtSummarizer.TFISFCalculator();
		txtSummarizer.sentenceSimilarityCalculation();
		txtSummarizer.createGraph();
		txtSummarizer.weightedGraph();
	}
	
	public static String getSummary(int summaryPercent) {
		String summary ="";
		

		if(!init)
			  return "Please initialize the file to summarize";
			
		
		createBaseSummary();
		ArrayList<String> summaryList = new ArrayList<String>();
		summaryList = txtSummarizer.getSummary(summaryPercent);
		for (String string : summaryList) {
			summary += string.toString() + " ";
		}
		
		return summary;
			
	}
	
	public static String getTitleBasedSummary(int summaryPercent) {
		String summary ="";
		
		if(!init)
			  return "Please initialize the file to summarize";
		
		createBaseSummary();
		ArrayList<String> summaryList = new ArrayList<String>();
		summaryList = txtSummarizer.getTitleBasedSummary(summaryPercent);
		for (String string : summaryList) {
			summary += string.toString() + " ";
		}
		
		return summary;
			
	}
}
