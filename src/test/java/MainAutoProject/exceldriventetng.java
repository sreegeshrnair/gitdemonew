package MainAutoProject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class exceldriventetng {
	
	@Test (dataProvider = "UserData")
	public void userlogin(String name1, String name2, int SLNo)
	{
		System.out.println(name1+ " " +name2+ " " +SLNo);
	}
	
	@DataProvider(name ="UserData")
	public Object[][] getData()
	{
		Object [][] data = {{"hello", "goodmorning", 1}, {"sree", "good evening", 2}};
		return data;
	}
	
	
	

}
