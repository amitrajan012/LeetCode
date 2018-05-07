import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleTwo {
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        //When row is 0
        result.add(1);
        
        for(int i=1;i<=rowIndex;i++){
        	//Make a copy of current row and clear the list
        	List <Integer> previous = new ArrayList<Integer>(result);
        	System.out.println(previous.toString());
        	result.clear();
        	for(int j=0;j<=i;j++){
        		//Add first and last element
            	if(j==i || j==0){
            		result.add(1);
            	}else{
            		result.add(previous.get(j)+previous.get(j-1));
            	}
        	}
        	
        }
        
        return result;
    }
}
