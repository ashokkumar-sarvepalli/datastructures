package learning.ds.slidingwindow;

import java.util.Arrays;

public class MaximumSlidingWindow {

	public static void main(String[] args) {
		

		int[] nums = new int[] { -95,92,-85,59,-59,-14,88,-39,2,92,94,79,78,-58,37,48,63,-91,91,74,-28,39,90,-9,-72,-88,-72,93,38,14,-83,-2,21,4,-75,-65,3,63,100,59,-48,43,35,-49,48,-36,-64,-13,-7,-29,87,34,56,-39,-5,-27,-28,10,-57,100,-43,-98,19,-59,78,-28,-91,67,41,-64,76,5,-58,-89,83,26,-7,-82,-32,-76,86,52,-6,84,20,51,-86,26,46,35,-23,30,-51,54,19,30,27,80,45,22 };
		MaximumSlidingWindow msw = new MaximumSlidingWindow();
		int [] result = msw.maxSlidingWindow(nums, 10);
		System.out.println(Arrays.toString(result));
	}
	
	
public int[] maxSlidingWindow(int[] nums, int k) {
        
        
        int n = nums.length;
        if(n==0) return new int[]{};

        int count =0; 
        int [] result = new int[nums.length-k+1];
        
        int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			
			if(nums[i]>max) {
				secondMax = max;
				max = nums[i];
			}
			
			else if (nums[i] > secondMax && nums[i]!=max) {
				secondMax = nums[i];
			}

		}
        
        result[count++] = max;
        
        // end of first window
        
        
        
        for(int i=k; i<nums.length;i++){
            
            
            if(nums[i]>result[i-k]){
                result[count++] = nums[i];
                
                if(nums[i-k]==secondMax)
                {
                secondMax = findSecondMax(nums,(i-k+1),i,nums[i]);
                    
                }
            }
            else{
                // the window before had the maximum element
                if(nums[i-k]==result[i-k]){
                    if(nums[i]>secondMax){
                        result[count++] = nums[i];
                    }
                    else{
                        result[count++] = secondMax;
                        secondMax = findSecondMax(nums,(i-k+1),i,secondMax);
                    }
                    
                }
                
                // same element retaining (with in the window again)
                else{
                	int current = count-1;
                	if(nums[i]>secondMax) {
                		secondMax = nums[i];
                	}
                	
                	else if(nums[i-k]==secondMax)
                     {
                     secondMax = findSecondMax(nums,(i-k+1),i,result[current]);
                         
                     }
                    
                    result[count++] = result[current];
                    
                }
                
               
                
            }
        }
        
        return result;
        
        
            
    }
    
    
    public int findSecondMax(int []nums, int start, int end , int exclusion){
        
        int max = Integer.MIN_VALUE;
        
        for(int i=start;i<=end;i++){
            if(nums[i]>max && nums[i]!=exclusion){
                max = nums[i];
            }
        }
        
        return max;
    }

}
