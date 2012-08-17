package iit.fyp.textSummarizer;

import java.util.ArrayList;

public class SummarizerThread extends Thread{

	 	private int summrypercent;
	    private boolean  isCompresed = false;
	    private boolean isCompleted = false;
	    private String summText = "";
	    private AppUI appUI;
	    private String filePath = "";
	    

	    

	    public SummarizerThread(int sumPerc, AppUI iMain) {
	        summrypercent = sumPerc;
	        isCompresed = true;
	        appUI = iMain;
	        
	    }

	    public SummarizerThread(AppUI iMain) {
	        isCompresed = false;
	        appUI = iMain;
	    }



	    
	    @Override
	    public void run(){

	  		
	    	summText = AppLogic.getTitleBasedSummary(summrypercent);
	    	
	         //   summText = txtSummarizer.getTitleBasedSummary(summrypercent);
	    //  appUI.jTextArea1.setText(summText);

	        appUI.jTextArea1.setText(summText);
	        appUI.chooseBtn.setEnabled(true);

	    }
	    
	    
	
}
