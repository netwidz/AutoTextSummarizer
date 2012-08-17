package iit.fyp.textSummarizer.core;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TFISFCalculator {
	
	private String[] sentencs;
    private int noOfsent;
    private TFVectors[] tfVectors;
    private WeightMap[] wms;
    private SentanceSimilarityCalc similaityCalculator;
    private Stemmer stemmer1 = new Stemmer();
    private Stemmer stemmer2 = new Stemmer();

    public TFISFCalculator(String sentence[],int noOfsentences) {
        sentencs=sentence;
        noOfsent=noOfsentences;
        wms=new WeightMap[noOfsentences];
        similaityCalculator = new SentanceSimilarityCalc(wms);
    }
    
    /**
     * Function to calculate frequency of words in the document according to the algorythms according to 
     *  Qazvinian et al 2008 theory
     *   termFrequency = frequency/termSize;
     *   inverseTermFrequency = log(noOfsentences/sentenceFrequency);
     *   termFrequency-InverseSenternceFrequency=termFrequencyf*inverseSentanceFrequency;
     * 
     */
    
    public void termFrequencyCalculation(){

        String[] termsentences=sentencs;
        StringTokenizer stringTokenizer;
        ArrayList arrayList=new ArrayList();
        String token=null;
        String tokenToCheck=null;
        for (int i = 0; i < termsentences.length; i++) {
            String string = termsentences[i];
            stringTokenizer=new StringTokenizer(string);

            while(stringTokenizer.hasMoreTokens()){
                token=stringTokenizer.nextElement().toString();
                tokenToCheck=token.toLowerCase();

                int strLength = tokenToCheck.length()-1;
                if(tokenToCheck.substring(strLength).equals(".") ||
                		tokenToCheck.substring(strLength).equals(",")||
                		tokenToCheck.substring(strLength).equals(";")||
                		tokenToCheck.substring(strLength).equals(":")||
                		tokenToCheck.substring(strLength).equals("?")){
                	tokenToCheck=tokenToCheck.substring(0, strLength);
                }

                if(!arrayList.contains(tokenToCheck)){
                    arrayList.add(tokenToCheck);
                }

            }

            
        }

        for (int i = 0; i < arrayList.size(); i++) {
           /* System.out.println("The Term \"" + arrayList.get(i) + "\" is available in "
                    + getFrequencyOfSentences(arrayList.get(i).toString()) + " sentences");*/

        }
        addTermFrequency();

        for (int i = 0; i < noOfsent; i++) {
            ArrayList freq=new ArrayList();
            ArrayList term=new ArrayList();


            wms[i]=new WeightMap();

            freq=tfVectors[i].getFrequency();
            term=tfVectors[i].getTerm();
           System.out.println("Processing The Sentence " + tfVectors[i].getSentenceId() + " : ");
            for (int j = 0; j < freq.size(); j++) {

                String tm=term.get(j).toString();
                int frq=Integer.parseInt(freq.get(j).toString());

                int sentFrq=getFrequencyOfSentences(tm);

                double tf=(double)frq/(double)term.size();
                double isf=Math.log((double)noOfsent/(double)sentFrq);
                double tfisf=tf*isf;

              System.out.println("The TF-ISF score in the Sentence" +" No. " + i + " for the Term " + tm + " = " + tfisf);
              
              
                wms[i].add(tm, basicEnglishWordWeight(tm, tfisf));
                System.out.println("\n-- Mapping Testing -- ");
           
                System.out.println(wms[i].map.get(tm));
                System.out.println("-- End Map -- \n");
                
              //  basicEnglishWordWeight(tm, tfisf);

            }

            

        }

        

    }
    
    /**
     * Get the term frequence
     * @param term String the term word 
     * @return Int frequency of the word term used in the document
     */
    
    private int getFrequencyOfSentences(String term){
        int count=0;
        String[] senColl = sentencs;

        for (int i = 0; i < senColl.length; i++) {
            int x=0;
            String string = senColl[i];
            StringTokenizer stringTokenizer= new StringTokenizer(string);
            String token="";

            while((stringTokenizer.hasMoreTokens()) && (x==0)){
                token=stringTokenizer.nextToken();
                if(term.equalsIgnoreCase(token)){
                    count++;
                    x++;
                }
            }
        }

        return count;


    }
    
    /**
     * Function to add the frequency of word to vector
     */
    
    private void addTermFrequency(){

        int count=0;
        String[] sentencesarray=sentencs;
        tfVectors=new TFVectors[sentencesarray.length];

        for (int i = 0; i < sentencesarray.length; i++) {

            String sent=sentencesarray[i];
            ArrayList arrayList=new ArrayList();
            ArrayList comparearrayList=new ArrayList();
            StringTokenizer stringTokenizer=new StringTokenizer(sent);
            String token="";


            tfVectors[i]=new TFVectors();

            tfVectors[i].sentenceid=i;

            while (stringTokenizer.hasMoreTokens()) {
                token=stringTokenizer.nextToken();
                arrayList.add(token);
            }

            comparearrayList=arrayList;

            for (int j = 0; j < arrayList.size(); j++) {
                int termfreq=0;
                for (int k = 0; k < comparearrayList.size(); k++) {
                	
                	String term1Orig = "";
                	if(arrayList.get(j).toString().contains(","))
                		term1Orig = arrayList.get(j).toString().replaceAll(",", "");
                	else if(arrayList.get(j).toString().contains("."))
                		term1Orig = arrayList.get(j).toString().replaceAll(".", "");
                	else
                		term1Orig = arrayList.get(j).toString();
                		
               
                	
                	
                	String term2Orig = "";
                	if(comparearrayList.get(k).toString().contains(","))
                		term2Orig = comparearrayList.get(k).toString().replaceAll(",", "");
                	else if(comparearrayList.get(k).toString().contains("."))
                		term2Orig = comparearrayList.get(k).toString().replaceAll(".", "");
                	else
                		term2Orig = comparearrayList.get(k).toString();
                	
                	String term1 = stemmer1.getStemmingWord(term1Orig);
                	String term2 = stemmer2.getStemmingWord(term2Orig);
             // System.out.println(term1Orig+" : "+term1+" : "+term2+" : "+term2Orig);
                	
                    if(term1.equalsIgnoreCase(term2)){
                        termfreq++;
                    }
                }
         
                
                tfVectors[i].term.add(arrayList.get(j).toString());
               System.out.println("The Term "+i+" is : "+tfVectors[i].getTerm()+"\n");
               
                tfVectors[i].frequency.add(termfreq);
                System.out.println("The Term frequency "+i+" is : "+tfVectors[i].getFrequency()+"\n");
            

                
                
            }

        }
       
        
    }
    
    public double sentenceSimilarityCalc(int sentenceNo1, int sentenceNo2, String sentence1, String sentence2){
    	return similaityCalculator.sentenceSimilarityCalculation(sentenceNo1, sentenceNo2, sentence1, sentence2);
    	
    }
    
    private double basicEnglishWordWeight(String word, double weight) {
    	String[] basicWordsEnglish = new String[850];
    	int x = 0;
    
    	try {
			FileInputStream fileStream = new FileInputStream("basicEnglishWords.txt");
			DataInputStream dataStream = new DataInputStream(fileStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(dataStream));
			String lineStr = "";
			while ((lineStr = br.readLine()) != null && lineStr != "") {
				basicWordsEnglish[x++] = lineStr;
				
			}		
			
			
    		
		} catch (Exception e) {
			// TODO: handle exception
			return weight;
		}
    	
    	double weightage = weight;
    	
    	//String[] basicWordsEnglish = {
    	if(Arrays.asList(basicWordsEnglish).contains(word.toLowerCase()))
    		return weight;
    	
    	
    	return weight;
	}

}
