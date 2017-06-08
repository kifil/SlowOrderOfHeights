public class Solution {
	public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
	    Integer inputCount = heights.size();
	    
	    HashMap<Integer, Integer> heightMap = new HashMap<>();
	    ArrayList<Integer> result = new ArrayList<>(inputCount);
	    
	    for(int i = 0; i< heights.size(); i++){
	        heightMap.put(heights.get(i), infronts.get(i));
	        result.add(null);
	    }
	    
	    //sort people so we insert shortest first
	    Collections.sort(heights);
	    
	    //O(n^2)
	    for(Integer height : heights){
	        Integer numberInFront = heightMap.get(height);
	        Integer openTallerPersonSpace= -1;
	        
	        //find where to place this height
	        for(int j = 0; j < inputCount; j++){
	            
	            //check if space is open
	            if(result.get(j) ==null){
	                openTallerPersonSpace++;
	            }
	            
	            //insert from shrotest to largest
	            //any open space is a person larger than you
	            //find first position that == number of larger people in front of you
	            if(openTallerPersonSpace == numberInFront){
	                result.set(j, height);
	                //stop looking for where to palce this height
	                break;
	            }
	        }
	        
	        
	    }
	    
	    
	    return result;
	}
}
