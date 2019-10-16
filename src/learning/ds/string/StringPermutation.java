package learning.ds.string;

public class StringPermutation {
	
	private String value ="";
    public String getPermutation(int n, int k) {
        char [] cs = new char[n];
        
        for(int i=1;i<=n;i++){
            cs[i-1] = (char) (i + 48); 
        }
       
		permuteAndFindSequence(cs,0,0,k);
		return value;
    }
    
    
    private  int permuteAndFindSequence(char[] cs, int start, int count, int k) {
		if (value.equals("")) {
			if (start == cs.length) {
				count++;
				if (count == k) {
					value = String.valueOf(cs);
				}
				return count;
			}

			for (int i = start; i < cs.length; i++) {
				swap(cs, i, start);
				count = permuteAndFindSequence(cs, start + 1, count, k);
				swap(cs, i, start);
			}

		}
		return count;

	}

	private  void swap(char[] cs, int i, int start) {
		char temp = cs[i];
		cs[i] = cs[start];
		cs[start] = temp;
		
	}
	
	public static void main(String []args) {
		StringPermutation sp = new StringPermutation();
		System.out.println(sp.getPermutation(4, 9));
	}
}
