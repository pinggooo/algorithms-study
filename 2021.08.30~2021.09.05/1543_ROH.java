import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class 1543_ROH {
	
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String document = br.readLine();
        String text = br.readLine();
        int index = 0;
        int count = 0;
        int size = document.length();
        int len = text.length();
        
        while(index < size - len + 1) {
        	String temp = document.substring(index, index+len);
        	//System.out.println(temp);
        	if(temp.equals(text)) {
        		index += len;
        		count++;
        	}
        	else {
        		index++;
        	}
        }
        System.out.println(count);

	}

}
