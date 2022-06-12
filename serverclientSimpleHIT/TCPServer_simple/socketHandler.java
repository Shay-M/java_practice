import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.*;

public class socketHandler extends Thread {
	Socket incoming;
	
	socketHandler(Socket _in)
	{
		incoming=_in;
		
	}
	
	public void run()
	{
		String clientSentence; 
	    String capitalizedSentence = null; 
	   int num ; 
	   int num2;
		try
		{
	    
           BufferedReader inFromClient = 
              new BufferedReader(new
              InputStreamReader(incoming.getInputStream())); 
          
               
           DataOutputStream  outToClient = 
        		   new DataOutputStream (incoming.getOutputStream() );
          
		while(true) {
	           clientSentence = inFromClient.readLine();

	           // all the work from the client
	           
	           capitalizedSentence = capitalizedSentence+"\n"; //MUST BE \N !!!!!!!!!!!!
	      
	        	  
	           outToClient.writeBytes(capitalizedSentence);
	           
	        	
	        }
		}
		catch(IOException e)
		{
			
		}

	}
}
