package iit.fyp.textSummarizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String args[]){
		
		try {
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please Provide File to be Summarized : ");
			
			//String fileName = bufferedReader.readLine();
			
			textSummarizer textSummarizer = new textSummarizer();
			
			//String fileName = "D:/IIT/fahiz/4th year/FYP/Litriture Review .docx";
			//String fileName = "D:/IIT/fahiz/4th year/FYP/Litriture Review.docx";
			//String fileName = "C:/Users/Fahiz/Desktop/Litriture Review - Copy.pdf";
			//String fileName = "C:/Users/Fahiz/Desktop/LR.docx";
			//String fileName = "C:/Users/Fahiz/Downloads/Documents/Ganapathiraju_11-742Report.pdf";
			//String fileName = "D:/IIT/fahiz/4th yearS/Embeded/MC68307 User's Manual.pdf";
			//String fileName = "D:/IIT/fahiz/4th yearS/Embeded/MC68307 User's Manual.pdf";
			//String fileName = "C:/Users/Fahiz/Desktop/affordable personal computers.docx";			
			//String fileName = "D:/Dropbox/Security CW1/cw 1.docx";
			//String fileName = "D:/IIT/fahiz/4th yearS/FYP/research/summarizing technique.docx";
			//String fileName = "D:/IIT/fahiz/4th yearS/FYP/Test Doc/how siri works.docx";
			//String fileName = "D:/IIT/fahiz/4th yearS/Software Quality/notes/Software Quality/11. BigO.pdf";
			String fileName = "C:/Users/Fahiz/Downloads/Documents/litrev.pdf";
			
			//String fileName = "D:/IIT/fahiz/4th year/FYP/Fahiz TOR.doc";
			//textSummarizer.preProcessOfDocument("D:/IIT/fahiz/4th year/FYP/Fahiz TOR.doc");
			textSummarizer.preProcessOfDocument(fileName);
			
			System.out.println("!!====================Original Text Goes Here===============================!!\n");
			System.out.println(textSummarizer.originalText());
			System.out.println("\n!!====================Original Text Ends Here===============================!!\n");
			
			System.out.println("!!====================Filtered Text Goes Here===============================!!\n");
			System.out.println(textSummarizer.filteredText());
			System.out.println("\n!!====================Filtered Text Ends Here===============================!!\n");

			System.out.println("!!====================TF ISF=================================!!\n");
			textSummarizer.TFISFCalculator();
			System.out.println("\n!!====================TF ISF Ends Here===============================!!\n");
			
			System.out.println("!!====================Sentence Similarity Calculation=================================!!\n");
			textSummarizer.sentenceSimilarityCalculation();
			System.out.println("\n!!====================Sentence Similarity Calculation===============================!!\n");
			
			System.out.println("!!====================Create Graph for sentences=================================!!\n");
			textSummarizer.createGraph();
			System.out.println("\n!!====================Create Graph for sentences Ends===============================!!\n");
			
			System.out.println("!!====================Weightning of Graph=================================!!\n");
			textSummarizer.weightedGraph();
			System.out.println("\n!!====================Weightning of Graph Ends===============================!!\n");
			
			
			System.out.println("\n!!====================Weightning of Graph Values===============================!!\n");
		
			double weightedGraph[][]=textSummarizer.getWeightedGraph();
            for (int x = 0; x < weightedGraph.length; x++) {

                for (int y = 0; y < weightedGraph[x].length; y++) {

                    System.out.println("Sentence " + x + " Sentence " + y);
                    System.out.println(weightedGraph[x][y]);

                }

            }
            System.out.println("\n!!====================Weightning of Graph Values Ends===============================!!\n");
			
            
            
            
            System.out.println("\n!!====================Summary===============================!!\n");
            
           ArrayList arrayList=new ArrayList();
           /*    arrayList = textSummarizer.getSummary(25);
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(arrayList.get(i));

            }
*/
            arrayList = textSummarizer.getTitleBasedSummary(25);

            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(arrayList.get(i));

            }

            String summary = "";
            for (int i = 0; i < arrayList.size(); i++) {
            
            	
                summary += arrayList.get(i);

            }

            

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName+"_summary.rtf"));
            bufferedWriter.write(summary);
            bufferedWriter.close();
            
            
            System.out.println("\n!!====================Summary Ends===============================!!\n");
			
			
		} catch (Exception e) {
            System.out.println("!!=======================================!!");
            System.out.println("Error : " + e.getMessage());
            System.out.println("!!=======================================!!");
		}
		
	}
	
}
