package chap5;


public class VolTest {

	public static void main(String[] args) {
		
		Volume v[ ] = new Volume[3];
		v[0] = new Speaker();
		v[1] = new TV();
		v[2] = new Radio();
		for(int i = 0; i < v.length; i++){
		  v[i].VolumeUp(200);
		  v[i].VolumeDown(300);
		}


	}

}

interface Volume{

	void VolumeUp(int level);
	void VolumeDown(int level);
	
}
	

class Speaker implements Volume{     /////Speaker 클래스
	
	int VolLevel=0;
	public void VolumeUp(int level){
		
		VolLevel +=level;

		if(VolLevel>100){
			VolLevel = 100;
		}
		System.out.println("증가한 speaker level 값 : " +VolLevel);	

	}
	
	public void VolumeDown(int level){
		
		this.VolLevel -=level;

		if(this.VolLevel<-100){
			this.VolLevel = -100;
		}
		System.out.println("감소한 speaker level 값 : " +VolLevel);
	}
	
}

class Radio implements Volume{       ////Radio 클래스
	
	
	int VolLevel=0;

	public Radio(){
		
	}
	
	public void VolumeUp(int level){
		
		this.VolLevel +=level;

		System.out.println("증가한 Radio level 값 : " +VolLevel);

	}
	
	public void VolumeDown(int level){
		
		this.VolLevel -=level;

		System.out.println("감소한 Radio level 값 : "+VolLevel);
	}
	
}

class TV implements Volume {   ////TV 클래스
	
	
	int VolLevel=0;

	public TV(){
		
	}
	
	public void VolumeUp(int level){
		
		this.VolLevel +=level;

		System.out.println("증가한 TV level 값 : " +VolLevel);
	}
	
	public void VolumeDown(int level){
		
		this.VolLevel -=level;

		if(this.VolLevel<0){
			this.VolLevel = 0;
		}
		System.out.println("감소한 TV level 값 : " +VolLevel);
	}
	
}





