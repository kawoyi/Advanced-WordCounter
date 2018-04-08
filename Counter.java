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
	private String filepath; // Դ������
	private String outputpath;//����ļ���
	private StringBuffer buffer = new StringBuffer(); // ������
	private char ch; // �ַ�������������¶�����Դ�����ַ�
	private static int i = 0;
	private String strToken;
	public ArrayList<String>words=new ArrayList<String>();
	public Map<String,Integer> map=new TreeMap<String,Integer>();//��ŵ���������Ӧ�Ĵ�Ƶ
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
	{ //���д������ļ���
		 File file=new File(outputpath);
		 FileWriter fw = new FileWriter(file,false);
		 BufferedWriter bw = new BufferedWriter(fw);
		 List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());//ʵ�ְ�Value����
	        //Ȼ��ͨ���Ƚ�����ʵ������
	        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>()
	        {
	            //��������
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
		    {  //��result.txtд���
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

	public void readFile()   //��ȡ�ļ�
	{
		try {
			FileReader fis = new FileReader(this.filepath);
			BufferedReader br = new BufferedReader(fis);
			int temp=-1;
			while ((temp = br.read()) != -1) {
				buffer.append((char)(temp));
			}
                        
		} catch (FileNotFoundException e) {
			System.out.println("Դ�ļ�δ�ҵ�!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("��д�ļ������쳣!");
			e.printStackTrace();
		}
		
	}*/
	public void getChar() {
		ch = buffer.charAt(i);
		i++;
	}

	/**
	 * ���ch�е��ַ��Ƿ�Ϊ�հף����������getChar() ֱ��ch�н���һ���ǿհ��ַ�
	 */
	public void getBc() {
		while (Character.isSpaceChar(ch))
			getChar();
	}

	/**
	 * ��ch���ӵ�strToken֮��
	 */
	public void concat() {
		strToken += ch;
	}

	/**
	 * �ж��ַ��Ƿ�Ϊ��ĸ
	 */
	boolean isLetter() {
		return Character.isLetter(ch);
	}

	/**
	 * �ж��ַ��Ƿ�Ϊ����
	 */
	boolean isDigit() {
		return Character.isDigit(ch);
	}
	boolean isConnector(){//�ж����ӷ�
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


	boolean isValid(){//������Ч�Լ���
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
	
	public void analyse()//��Ҫ����ʵ��
	{
	    strToken = ""; // ��strTokenΪ�մ�
		while (i < buffer.length())
		{
			getChar();
			getBc();
			if (isLetter()) 
			{ // ���chΪ��ĸ
				while (isLetter() ||isConnector()) 
				{
					concat();
					getChar();
				}
				validLize();
				retract(); // �ص�
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
