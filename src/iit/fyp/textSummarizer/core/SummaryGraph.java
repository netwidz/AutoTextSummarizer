package iit.fyp.textSummarizer.core;

import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class SummaryGraph {
	
	WeightedGraph<Object,Object> wg;
	boolean init;
	
	public SummaryGraph(){
		init= false;
		wg = new SimpleWeightedGraph<Object, Object>(DefaultWeightedEdge.class);
	}
	
	public void createDocumentGraph(String sentence[]) {
		
		init = true;
		
		for (int x = 0; x < sentence.length; x++) {
			wg.addVertex(sentence[x]);
		}
		
		
		for (int x = 0; x < sentence.length-1; x++) {
			for (int y = x+1; y < sentence.length; y++) {
				try {
					wg.addEdge(sentence[x], sentence[y]);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			
			
		}
		
	
		
		System.out.println(wg.edgeSet());
	}

	
	
	
	 public boolean setWeightedEdge(String sentences[], double weight){
	        
	        if(wg.containsEdge(wg.getEdge(sentences[0], sentences[1]))){
	            wg.setEdgeWeight(wg.getEdge(sentences[0], sentences[1]), weight);
	            return true;
	        }else{
	            return false;
	        }
	        
	        
	    }

	    public double[][] getWeightedEdge(String sentences[]){

	        double edges[][]=new double[sentences.length-1][sentences.length];
	        for (int x = 0; x <(sentences.length-1); x++) {
	            for (int y = x+1; y < sentences.length; y++) {
	            	edges[x][y]=Double.parseDouble(String.valueOf(wg.getEdgeWeight(wg.getEdge(sentences[x], sentences[y]))));

	            }
	            

	        }

	        return edges;

	    }
	
	
}
