package profile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class FileUnit 
{
	public static void fileWriter(String outputpath,Map<String,Integer> map)throws IOException
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

	public static void readFile(String filepath,StringBuffer buffer)   //��ȡ�ļ�
	{
		try {
			FileReader fis = new FileReader(filepath);
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
		
	}
}
