package easy;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        //Base case
        if(numRows == 0){
        	//Return empty list
        	return result;
        }
        //Add [1] to the list
        result.add(new LinkedList<Integer>(Arrays.asList(1)));
        //Iterate over numRows
        for(int i=1;i<numRows;i++){
        	List<Integer> temp = new LinkedList<Integer>();
        	List<Integer> previous = result.get(i-1);
        	for(int j=0;j<=i;j++){
        		if(j==0){
        			//Insert first element of previous list to new list
        			temp.add(previous.get(0));
        		}else if(j==i){
        			//Insert last element of previous list to new list
        			temp.add(previous.get(previous.size()-1));
        		}else{
        			temp.add(previous.get(j-1)+previous.get(j));
        		}
        		
        	}
        	result.add(temp);
        }
        return result;
    }
}
