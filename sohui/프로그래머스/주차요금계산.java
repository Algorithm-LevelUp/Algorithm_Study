import java.util.Arrays;
import java.util.HashMap;

public class 주차요금계산 {
	public int[] solution(int[] fees, String[] records) {
	       HashMap<String,String>time=new HashMap<>();
	        HashMap<String,Integer>result=new HashMap<>();
	        
	        for(int i=0; i<records.length; i++){
	            String[] arr=records[i].split(" ");
	            if(arr[2].equals("IN")){
	                time.put(arr[1], arr[0]);
	            }else{
	                String start=time.get(arr[1]);
	                time.put(arr[1],"0");
	                String[] temp_1=start.split(":");
	                String[] temp_2=arr[0].split(":");
	                int start_time=Integer.parseInt(temp_1[0])*60+Integer.parseInt(temp_1[1]);
	                int end_time=Integer.parseInt(temp_2[0])*60+Integer.parseInt(temp_2[1]);
	                if(result.containsKey(arr[1])){
	                    result.put(arr[1], result.get(arr[1])+end_time-start_time);
	                }else{
	                    result.put(arr[1], end_time-start_time);
	                }
	            }
	        }
	        for(String x:time.keySet()) {
	        	if(!time.get(x).equals("0")) {
	        		String start=time.get(x);
	        		String[] temp=start.split(":");
	        		 int start_time=Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
	        		 int end_time=23*60+59;
	        		 if(result.containsKey(x)){
	                     result.put(x, result.get(x)+end_time-start_time);
	                 }else{
	                     result.put(x, end_time-start_time);
	                 }
	        	}
	        }
	        
	        Object[] key_sort=result.keySet().toArray();
	        Arrays.sort(key_sort);
	        
	        int[] answer=new int[key_sort.length];
	        int i=0;
	        
	        for(Object x: key_sort){
	        	if(result.get(x)<fees[0]) { //기본 요금보다 작으면
	        		answer[i++]=fees[1];
	        	}else {
	        		int temp=0;
	        		if((result.get(x)-fees[0])%fees[2]==0) {
	        			temp=(result.get(x)-fees[0])/fees[2];
	        		}else {
	        			temp=(result.get(x)-fees[0])/fees[2]+1;
	        		}
	        		answer[i++]=fees[1]+temp*fees[3];
	        	}
	        }
	      
	        return answer;
	    }
}
