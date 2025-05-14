package practice_datadriven_testing;

public class Generate_alphanumric_randomDataTest {

	public static void main(String[] args) {
		int n =20;
		
		// choose a character random from this string 
		
		String alphanumric_string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		// create StringBuffer size of alphanumric_string

		StringBuffer sb = new StringBuffer(n);
		
		for(int i=0;i<n;i++)
		{
			// generate the random number between 0 to alphanumric_string variable
			
			int index =(int)(alphanumric_string.length()* Math.random());
			
			// add character one by one in end of sb 
			
			sb.append(alphanumric_string.charAt(index));
			
		}
	
	     System.out.println(sb);
	
	}
	
	

}
