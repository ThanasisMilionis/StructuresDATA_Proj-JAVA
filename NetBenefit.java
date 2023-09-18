import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NetBenefit {

	public static void main(String[] args) {
		
		
		try{
			  String nextLine;
			  

			  BufferedReader inFile = new BufferedReader(new FileReader(args[0]));

			  String[] info;
			  int sumMetoxes = 0;
			  int numOfMetoxes;
			  int kerdos = 0;
			  int price;
			  int tempMetoxes;
			  int tempPrice;
			  IntQueue<Integer> queue = new IntQueueImpl<Integer>();
			  
			  while((nextLine = inFile.readLine()) != null)
			  {
			      info  = nextLine.split(" "); // SPACE would be the delimiter
				  numOfMetoxes = Integer.parseInt(info[1]);
		    	  price = Integer.parseInt(info[3]);
			      if(info[0].charAt(0) == 'b') { 
			    	  sumMetoxes = sumMetoxes + numOfMetoxes;
			    	  queue.put(numOfMetoxes);
			    	  queue.put(price);
			    	  
			      }else if((info[0].charAt(0) == 's') && (sumMetoxes > numOfMetoxes)) {

			    	  while(numOfMetoxes >= 0 ) {
			    		  if(queue.peek() <= numOfMetoxes) {
			    			  numOfMetoxes -= queue.peek();
			    			  kerdos += queue.get()*(price - queue.get());
			    		  }else {
			    			  tempMetoxes = queue.get() - numOfMetoxes;
			    			  tempPrice = queue.get();
			    			  kerdos += numOfMetoxes*(price - tempPrice);
			    			  numOfMetoxes = -tempMetoxes;
			    			  queue.put(tempMetoxes);
			    			  queue.put(tempPrice);
			    		  }
			    			  
			    	  }
			    	  
			      }else
			    	  System.out.println("ERROR you tried to sell more stocks than you have");
			  }

			  inFile.close();
			  
			  if(kerdos >= 0 )
				  System.out.println("Your benefit is : "+ kerdos);
			  else 
				  System.out.println("Your loss is : "+ kerdos);
			  
		} catch(IOException e) {
			System.out.println("Reading txt file Failed, try again . ");
		}
		
		
	}

}
