import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TagMatching {

	public static void main(String[] args) {
		
		String content = "";
	    try {
	        BufferedReader in = new BufferedReader(new FileReader(args[0]));
	        String str;
	        while ((str = in.readLine()) != null) {
	            content +=str;
	        }
	        
			in.close();
	    } catch (IOException e) {
			System.out.println("FAILED");
	    }
	    
	    StringStack<String> stack = new StringStackImpl<String>();
	    
	    boolean errorFlag = true;
	    int i=0;

	    while(i <= content.length()-1) {
	    	int k=0;
	    	String temp = "";
	    	if(content.charAt(i) == '<' ) {
	    			k = i+1;
	    		
	    		while(content.charAt(k) != '>') {
	    			temp += content.charAt(k);
					k++;
	    		}

	    		if(stack.isEmpty()) {
	    			stack.push(temp);
	    		}else {
					String tagWithShlash = '/' + stack.peek();
	    			if(temp != stack.peek() && temp.charAt(0) != '/'){ 
	    				stack.push(temp);
	    			}else if (temp.charAt(1) == tagWithShlash.charAt(1) && temp.charAt(2) == tagWithShlash.charAt(2) ){
	    				stack.pop();
	    			}else{
						errorFlag = false;
					}
	    		}
	    	}
	    	
	    	if(content.charAt(k) == '>')
	    		i = k+1;
	    	else
	    		i++;
	   }
	    
	    if(errorFlag && stack.isEmpty()){
	    	System.out.println("The format on this HTML file is CORRECT and VALID");
		} else{
	    	System.out.println("The format on this HTML file is INCORRECT and INVALID");
		}

	}

}
