package iit.fyp.textSummarizer;

import java.util.ArrayList;

import iit.fyp.textSummarizer.core.SentanceSimilarityCalc;
import iit.fyp.textSummarizer.core.SummaryGraph;
import iit.fyp.textSummarizer.core.TFISFCalculator;
import iit.fyp.textSummarizer.core.WeightMap;
import iit.fyp.textSummarizer.preProcesses.PreProcess;

public class textSummarizer {

	private String origText;
	private String filteredText;
	
	private PreProcess preProcess;
	
	private double[][] similarityCalculationValue;
	
	private String[] filteredSentenceArray;
	private String[] origSentenceArray;
	
	private int noOfSentences;
	
    private WeightMap[] wms;
	

    private TFISFCalculator tfisfCalculator;
    private SummaryGraph summaryGraph;
    private SentanceSimilarityCalc sentanceSimilarityCalc;
	
	public textSummarizer(){
		
		summaryGraph = new SummaryGraph();
		
		
	}
	
	/**
	 * Read the document and do the seperation of stop words from sentences 
	 * and stores original sentences sepataely. 
	 * @throws Exception 
	 */
	
	public void preProcessOfDocument(String file) throws Exception{
		
		preProcess = new PreProcess(file);
		origText = preProcess.getOrigTextInString();
		filteredText = preProcess.getFilteredTextInString();
		
		noOfSentences = preProcess.getNoOfSentences();
		
		filteredSentenceArray = preProcess.filteredSentencesInArray();
		origSentenceArray = preProcess.originalSentencesInArray();
		
		
		//System.out.println("No of Sentences in Original Text : "+origSentenceArray.length);
		
		
		
		
	}
	
	
		public String originalText(){
			 
		        return origText;
		}

	    public String filteredText(){
	        return filteredText;
	    }
	    
	    public void TFISFCalculator(){
	        tfisfCalculator = new TFISFCalculator(filteredSentenceArray, noOfSentences);
	        tfisfCalculator.termFrequencyCalculation();
	    }
	    
	    
	    public void sentenceSimilarityCalculation() {
	    	
	    	
			try {
				
				similarityCalculationValue = new double[noOfSentences-1][noOfSentences];
				
				for (int x = 0; x < noOfSentences-1; x++) {
					for (int y = 0; y < noOfSentences; y++) {
						similarityCalculationValue[x][y]= tfisfCalculator.sentenceSimilarityCalc(x, y, filteredSentenceArray[x], filteredSentenceArray[y]);
					}
					
				}
				
			} catch (Exception e) {
				System.out.println("Error in Sentance similarity Calculation : "+e);
			}
			
			
	    	
		}
	    
	    
	public void createGraph(){
		
		summaryGraph.createDocumentGraph(origSentenceArray);
		
	}
	

	
	public void weightedGraph() {

		 
		 
		 for (int x = 0; x < origSentenceArray.length-1; x++) {
			 
			for (int y = x+1; y < origSentenceArray.length; y++) {
				String weightedSentenceArray[] = {origSentenceArray[x], origSentenceArray[y]};
				boolean bool = summaryGraph.setWeightedEdge(weightedSentenceArray, similarityCalculationValue[x][y]);
				/*if(bool)
					System.out.println("Successfully added to the graph");
				else
					System.out.println("Not added");
				*/	
			}
		}
		 
		 
		 
		
	}
	
	 public double[][] getGraphWeights(){
	        return summaryGraph.getWeightedEdge(origSentenceArray);
	 }
	
	 public ArrayList getSummary(int summaryPercent){

	        int summLength = (int)(summaryPercent * noOfSentences)/100;
	        System.out.println("Process Array LIst");
	        ArrayList summaryList = new ArrayList();
	        //System.out.println(summLength);
	        int[] senNum = new int[summLength];

	        double similarityWeights[][] = this.getGraphWeights();
	        String[] oriSent = origSentenceArray;

	        boolean bl=true;
	        boolean init=false;
	        int i=0;
	        int y = 0;
	        int count=0;
	        int x=0;
	        int z=0;
	        do {

	            i=count;
	            while(bl){
	            int val=0;
	            bl=false;
	            String s = "";
	            double max = 0;

	            if(i==count){
	                if(!summaryList.contains(oriSent[i].toString())){
	                    summaryList.add(oriSent[i].toString());
	                    senNum[x] = i;
	                    x++;
	                }

	            }

	            if(i!=similarityWeights.length){
	                boolean initialJ=true;
	                for (int j = i+1; j < similarityWeights[i].length; j++) {

	                    if (initialJ) {
	                        max = similarityWeights[i][j];
	                        s = oriSent[j].toString();
	                        z=j;
	                        initialJ = false;
	                        val=j;
	                        bl=true;
	                    }else {
	                        if (max<similarityWeights[i][j]) {
	                            max=similarityWeights[i][j];
	                            s = oriSent[j].toString();
	                            z=j;
	                            val=j;
	                            bl=true;
	                        }
	                    }

	                }

	            }

	            i=val;
	            if(!summaryList.contains(s) && summaryList.size()<summLength){
	                summaryList.add(s);
	                senNum[x]=z; x++;
	            }

	            y++;

	        }


	            if(summaryList.size()<summLength){
	                init = true;
	                bl = true;
	                count++;
	            }else{
	                init = false;
	                bl=false;
	            }


	        } while (init);
	        //System.out.println("Hello");
	        for (int j = 0; j < senNum.length; j++) {
	           // System.out.println(senNum[j]);

	        }

	        
	        summaryList = this.sortSentences(summaryList, senNum);

	        return summaryList;

	    }

	 private int[] getMaximQueue(){

	        double[] simWeights = this.getGraphWeights()[0];
	        int[] maxQueue = new int[simWeights.length];

	        for (int i = 0; i < maxQueue.length; i++) {
	            maxQueue[i] = i;
	        }

	        for (int i = 0; i < simWeights.length; i++) {
	            double maxVal = simWeights[i];
	            int index = i;
	            for (int j = i+1; j < simWeights.length; j++) {
	                if(maxVal<simWeights[j]){
	                    index=j;
	                }
	            }

	            if(index!=i){
	                int temp = maxQueue[i];
	                maxQueue[i] = maxQueue[index];
	                maxQueue[index] = temp;
	            }
	        }

	        return maxQueue;
	    }
	 
	 
	 
	    public ArrayList getTitleBasedSummary(int summaryPercent){

	        int summLength = (int)(summaryPercent * noOfSentences)/100;
	        System.out.println("Process Array LIst");
	        ArrayList summaryList = new ArrayList();
	        //System.out.println(summLength);
	        int[] senNum = new int[summLength];

	        double similarityWeights[][] = this.getGraphWeights();
	        
	        /*for (int i = 0; i < similarityWeights.length; i++) {
	        	double[] ddd= similarityWeights[i];
				
	        	for (int j = 0; j < ddd.length; j++) {
	        		System.out.println(ddd[j]);
				}
	        	
	        	
	        	
			}*/
	        String[] oriSent = origSentenceArray;

	        boolean bl=true;
	        boolean init=false;
	        int i=0;
	        int y = 0;
	        int count=0;
	        int senCount = 0;
	        int arrVal=0;
	        int sentNo=0;
	        int[] maxQueue = getMaximQueue();
	  
	        do {

	            i=senCount;
	            while(bl){
	            int val=0;
	            bl=false;
	            String s = "";
	            double max = 0;

	            if(i==senCount){
	                if(!summaryList.contains(oriSent[i].toString())){
	                    summaryList.add(oriSent[i].toString());
	                    senNum[arrVal] = i;
	                    arrVal++;
	                }

	            }

	            if(i!=similarityWeights.length){
	                boolean initialJ=true;
	                for (int j = i+1; j < similarityWeights[i].length; j++) {

	                    if (initialJ) {
	                        max = similarityWeights[i][j];
	                        s = oriSent[j].toString();
	                        sentNo=j;
	                        initialJ = false;
	                        val=j;
	                        bl=true;
	                    }else {
	                        if (max<similarityWeights[i][j]) {
	                            max=similarityWeights[i][j];
	                            s = oriSent[j].toString();
	                            sentNo=j;
	                            val=j;
	                            bl=true;
	                        }
	                    }

	                }

	            }

	            i=val;
	            if(!summaryList.contains(s) && summaryList.size()<summLength){
	                summaryList.add(s);
	                senNum[arrVal]=sentNo; arrVal++;
	            }

	            y++;

	        }


	            if(summaryList.size()<summLength){
	                init = true;
	                bl = true;
	                count++;
	                senCount = maxQueue[count];
	            }else{
	                init = false;
	                bl=false;
	            }


	        } while (init);
	        //System.out.println("Hello");
	        for (int j = 0; j < senNum.length; j++) {
	           // System.out.println(senNum[j]);

	        }


	        summaryList = this.sortSentences(summaryList, senNum);

	        return summaryList;

	    }
	 
	 private ArrayList sortSentences(ArrayList sList, int[] sentIndices){

	        int index = 0;
	        int minVal = 0;
	        for (int i = 0; i < sentIndices.length; i++) {

	            minVal = sentIndices[i];
	            index = i;
	            for (int k = i+1; k < sentIndices.length; k++) {

	                if(minVal>sentIndices[k]){
	                    minVal = sentIndices[k];
	                    index=k;
	                }

	            }

	            if(index!=i){
	                int tempSNo = sentIndices[i];
	                String tempString = sList.get(i).toString();

	                sentIndices[i] = sentIndices[index];
	                sList.set(i, sList.get(index));

	                sentIndices[index] = tempSNo;
	                sList.set(index, tempString);

	            }

	        }
	        return sList;

	    }

	
	 public double[][] getWeightedGraph(){
	        return summaryGraph.getWeightedEdge(origSentenceArray);
	 }
	
}
