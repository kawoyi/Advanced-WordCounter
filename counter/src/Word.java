package profile;

public class Word 
{
	private String content;
	   private int times;
	   private  boolean isValid;
	Word(String content,int times)
	{
		setContent(content);
		setTimes(times);
		isValid(content);
	}
   public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	boolean isCharacter(char c){
		boolean flag=false;
		for(int i=0;i<Define.validCharacter.length;i++){
			if(c==Define.validCharacter[i]){
				flag=true;
			}
		}
		return flag;
		
	}

	public void isValid(String content){//单词有效性检验
		
		    for(int j=0;j<content.length();j++){
			if(!isCharacter(content.charAt(j))&&!Character.isLetter(content.charAt(j)))
			{
			  	isValid=false;
			}
		}
		    
	}

    
}
