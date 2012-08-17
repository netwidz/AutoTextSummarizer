package iit.fyp.textSummarizer.preProcesses;

public class PreProcess {
	
	private String[] originalDoc = null;
	//private ReadWordDoc readWordDoc;
	private StopWordEliminator stopWordEliminator;
	private FileToTextParser fileToTextParser;
	private String filePath = null;
	
	private String[] weightedSentences;
	
	public PreProcess(String filePath) throws Exception{
		
		//readWordDoc = new ReadWordDoc(filePath);
		fileToTextParser = new FileToTextParser();
		this.filePath = filePath;
		stopWordEliminator = new StopWordEliminator("stopWords.txt");
		this.preProcessDoc();
		
		
		
	}
	
	/**
	 * Function to make sentences to an array
	 * @throws Exception 
	 */

	private void preProcessDoc() throws Exception{
		originalDoc = fileToTextParser.getTextFromFile(this.filePath);
		
	}
	
	/**
	 * Get the number of sentences contains in the sentences Array
	 * @return Int Number of Sentences contains in the Sentences Array
	 * @throws Exception 
	 */
	
	public int getNoOfSentences() throws Exception{
		this.preProcessDoc();
		return originalDoc.length;
	}
	
	/**
	 * 
	 * @return String returns Original Text 
	 */
	
	public String getOrigTextInString(){
		String origText = null;
		

		for (int i = 0; i < originalDoc.length; i++) {
			if(i==0)
				origText = originalDoc[i];
			else
				origText = origText + "\n"+originalDoc[i];
			
			
		}
		
		
		return origText;
		
	}
	
	/**
	 * 
	 * @return string[] original Sentences return with Array
	 */
	
	 public String[] originalSentencesInArray(){
	        return originalDoc;
	 }
	 
	 

	 /**
	  * 
	  * @return String returns filtered sentences with string
	  */
	 
	 public String getFilteredTextInString(){
		 String filteredSentences = null;
		 
		 weightedSentences = new String[originalDoc.length];
		 
		 for(int i=0; i< originalDoc.length; i++){
			 String str = stopWordEliminator.filterSentence(originalDoc[i]);
			 weightedSentences[i]=str;
			 
			 if(i==0)
				 filteredSentences=str;
			 else
				 filteredSentences=filteredSentences+" "+str;
			 
		 }
		 
		 return filteredSentences;
		 
		 
	 }
	 
    /**
	 * 
	 * @return string[] Filtered Sentences return with Array
	 */
		public String[] filteredSentencesInArray(){
		    return weightedSentences;
		}
	 
	 
}
