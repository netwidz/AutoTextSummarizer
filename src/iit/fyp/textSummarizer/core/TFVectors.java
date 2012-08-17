package iit.fyp.textSummarizer.core;

import java.util.ArrayList;

public class TFVectors {


	    int sentenceid;
	    ArrayList<String> term;
	    ArrayList<Integer> frequency;

	    public TFVectors(){
	        term=new ArrayList<String>();
	        frequency=new ArrayList<Integer>();
	    }
	    
	    public int getSentenceId(){
	        return sentenceid;
	    }
	    
	    public ArrayList<String> getTerm(){
	        return term;
	    }
	    
	    public ArrayList<Integer> getFrequency(){
	        return frequency;
	    }

	
}
