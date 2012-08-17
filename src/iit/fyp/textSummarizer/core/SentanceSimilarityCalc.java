package iit.fyp.textSummarizer.core;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class SentanceSimilarityCalc {
	
	WeightMap[] weightMaps;
	
	public SentanceSimilarityCalc(WeightMap[] wm){
		this.weightMaps = wm;
		
	}
	
	private ArrayList getTokenizedSentence(String sentance){
		
		
	     ArrayList arrayList = new ArrayList();
	     
	     StringTokenizer stringTokenizer = new StringTokenizer(sentance);
	     String token="";
	     String tokenToCheck = "";


	        while(stringTokenizer.hasMoreTokens()){
	            token=stringTokenizer.nextToken();
	            tokenToCheck=token.toLowerCase();

	            if (!arrayList.contains(tokenToCheck)) {
	                arrayList.add(tokenToCheck);
	            }
	        }

	        return arrayList;
		
		
	}

	public double  sentenceSimilarityCalculation(int sentenceID1, int sentenceID2, String sentence1, String sentence2){

        double sentenceSimilarity=0.0;
        
        ArrayList wordlist1 = new ArrayList();
        ArrayList wordlist2 = new ArrayList();
        ArrayList wordListAll = new ArrayList();


        double[] sweight1;
        double[] sweight2;

        double sumOfProducts;
        double sumOfsquareroot;



        wordlist1 = getTokenizedSentence(sentence1);
        wordlist2 = getTokenizedSentence(sentence2);

        for (int i = 0; i < wordlist1.size(); i++) {
            wordListAll.add(wordlist1.get(i));
        }


        for (int i = 0; i < wordlist2.size(); i++) {
            if(!wordListAll.contains(wordlist2.get(i))){
                wordListAll.add(wordlist2.get(i));
            }
        }


        sweight1 = new double[wordListAll.size()];
        sweight2 = new double[wordListAll.size()];
        

        for (int i = 0; i < wordListAll.size(); i++) {
            if(weightMaps[sentenceID1].map.containsKey(wordListAll.get(i).toString()))
                sweight1[i] = weightMaps[sentenceID1].map.get(wordListAll.get(i).toString());
            else
                sweight1[i] = 0.0;

            if(weightMaps[sentenceID2].map.containsKey(wordListAll.get(i).toString()))
                sweight2[i] = weightMaps[sentenceID2].map.get(wordListAll.get(i).toString());
            else
                sweight2[i] = 0.0;

        }


        sumOfProducts = sumDotProducts(sweight1, sweight2);
        sumOfsquareroot = sumRoot(sweight1) * sumRoot(sweight2);

        sentenceSimilarity = sumOfProducts/sumOfsquareroot;

        System.out.println("The Similarity Between the Sentence "
                + sentenceID1 + " and " + sentenceID2 + " " + sentenceSimilarity);

        return sentenceSimilarity;

    }
	
	   private double sumDotProducts(double sweight1[], double sweight2[]){
	        double sumdotproduct=0.0;

	        double[] sw1 = sweight1;
	        double[] sw2 = sweight2;

	        for (int i = 0; i < sw2.length; i++) {

	            sumdotproduct += sw1[i]*sw2[i];

	        }


	        return sumdotproduct;
	        
	    }
	   
	    private double sumRoot(double val[]){
	        double sumroot=0.0;
	        double[] values=val;

	        for (int i = 0; i < values.length; i++) {

	            sumroot += values[i]*values[i];

	        }

	        return Math.sqrt(sumroot);
	    }
	
	
}
