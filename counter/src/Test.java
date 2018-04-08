package profile;

import java.io.IOException;

public class Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
        Counter count=new Counter("input.txt","result.txt");
        FileUnit.readFile(count.getFilepath(),count.getBuffer());
        count.analyse();
        try 
        {
			FileUnit.fileWriter(count.getOutputpath(),count.getMap());
		} catch (IOException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
