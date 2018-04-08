package profile;

import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Counter count=new Counter(args[0],"result.txt");
        count.readFile();
        count.analyse();
        try {
			count.filwWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
