package iit.fyp.textSummarizer.core;

import java.util.HashMap;
import java.util.Map;

public class WeightMap {
	
	  Map<String,Double> map;

	    public WeightMap() {

	        map=new HashMap<String, Double>();

	    }

	    public void add(String wd, double tfisf){

	        map.put(wd, tfisf);

	    }

	    @Override
	    public String toString(){
	        return map.toString();
	    }

}
