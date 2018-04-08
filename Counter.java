package profile;
import java.util.*;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Counter {
	private String filepath; // 源程序名
	private String outputpath;//输出文件名
	private StringBuffer buffer = new StringBuffer(); // 缓冲区
	private char ch; // 字符变量，存放最新读进的源程序字符
	private static int i = 0;
	private String strToken;
	public ArrayList<String>words=new ArrayList<String>();
	public Map<String,Integer> map=new TreeMap<String,Integer>();//存放单词数及对应的词频
	Counter(String filepath,String outputpath)
	{
		this.filepath=filepath;
		this.outputpath=outputpath;
	}
	Counter(){
		
	}
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getOutputpath() {
		return outputpath;
	}

	public void setOutputpath(String outputpath) {
		this.outputpath = outputpath;
	}
	
	public StringBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(StringBuffer buffer) {
		this.buffer = buffer;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	/*public void fileWriter()throws IOException
	{ //结果写到输出文件中
		 File file=new File(outputpath);
		 FileWriter fw = new FileWriter(file,false);
		 BufferedWriter bw = new BufferedWriter(fw);
		 List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());//实现按Value排序
	        //然后通过比较器来实现排序
	        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>()
	        {
	            //降序排序
	            public int compare(Entry<String, Integer> o1,
	                    Entry<String, Integer> o2) 
	            {
	            	int p1=o1.getValue();
	            	int p2=o2.getValue();
	            	int p=p1-p2;
	            	if(p>0)
	            	{
	            		return -1;
	            		
	            	}
	            		else if(p==0)
	            		{
	            		return 0;
	            		}
	            		else
	            		return 1;
	            }
	          });
		 for (Map.Entry<String, Integer> mapping:list) 
		    {  //向result.txt写结果
			 int temp=0;
			 if(temp<100)
			 {
			  bw.write(  mapping.getKey() + " " + mapping.getValue()); 
			  bw.newLine();
			 }
			 temp++;
			}
		  
		  bw.close();
	}

	public void readFile()   //读取文件
	{
		try {
			FileReader fis = new FileReader(this.filepath);
			BufferedReader br = new BufferedReader(fis);
			int temp=-1;
			while ((temp = br.read()) != -1) {
				buffer.append((char)(temp));
			}
                        
		} catch (FileNotFoundException e) {
			System.out.println("源文件未找到!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("读写文件出现异常!");
			e.printStackTrace();
		}
		
	}*/
	public void getChar() {
		ch = buffer.charAt(i);
		i++;
	}

	/**
	 * 检查ch中的字符是否为空白，若是则调用getChar() 直至ch中进入一个非空白字符
	 */
	public void getBc() {
		while (Character.isSpaceChar(ch))
			getChar();
	}

	/**
	 * 将ch连接到strToken之后
	 */
	public void concat() {
		strToken += ch;
	}

	/**
	 * 判断字符是否为字母
	 */
	boolean isLetter() {
		return Character.isLetter(ch);
	}

	/**
	 * 判断字符是否为数字
	 */
	boolean isDigit() {
		return Character.isDigit(ch);
	}
	boolean isConnector(){//判断连接符
		boolean flag=false;
		
			if(ch=='-'){
				flag=true;
			}
		
		return flag;
	}
	boolean isSeperator(){
		boolean flag=false;
		for(int i=0;i<Define.seperator.length;i++){
			if(ch==Define.seperator[i]){
				flag=true;
			}
		}
		return flag;
	}
	boolean isCharacter(char c){
		boolean flag=false;
		for(int i=0;i<Define.validCharacter.length;i++){
			if(ch==Define.validCharacter[i]){
				flag=true;
			}
		}
		return flag;
		
	}


	boolean isValid(){//单词有效性检验
		boolean flag=true;
		     for(int j=0;j<strToken.length();j++){
			if(!isCharacter(strToken.charAt(j))&&!Character.isLetter(strToken.charAt(j)))
			{
			  	flag=false;
			}
		}
		     return flag;
	}
	void validLize(){
		if(!Character.isLetter(strToken.charAt(strToken.length()-1))){
			strToken=strToken.substring(0,strToken.length()-1);
		}
		
	}
	public void retract() {
		i--;
		ch = ' ';
	}
	
	public void analyse()//主要功能实现
	{
	    strToken = ""; // 置strToken为空串
		while (i < buffer.length())
		{
			getChar();
			getBc();
			if (isLetter()) 
			{ // 如果ch为字母
				while (isLetter() ||isConnector()) 
				{
					concat();
					getChar();
				}
				validLize();
				retract(); // 回调
				if(!map.containsKey(strToken))
				{
				   map.put(strToken, 1)	;
				}else{
					int temp=map.get(strToken)+1;
					map.put(strToken, temp);
				}
				System.out.println(strToken);
				strToken = "";
			}
		}
	}
}
