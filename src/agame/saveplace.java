package agame;

import java.awt.image.BufferedImage;

public class saveplace {
	private int x;
	private int type;//按钮形态
	private BackGround bg;
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
    private int place=0;//区分不同按钮
	public void setPlace(int place) {
		this.place = place;
	}

	public int getPlace() {
		return place;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private int y;
	
	private BufferedImage showImage=null;
	
	public BufferedImage getShowImage() {
		return showImage;
	}

	public saveplace(int x,int y,int type,int place,BackGround bg){
		this.x=x;
		this.y=y;
		this.type=type;
		this.place=place;
		this.bg=bg;
		setImage();
	}

	public void setImage() {
		
		if(this.getType()==1){
		showImage=StaticValue.button;
		}
		else if(this.getType()==2){
			showImage=StaticValue.buttonpress;
		}
		
	}
	
	public void used(){
		this.setType(2);
	}
	
	public void reset(){
		if(this.type==2){
		this.type=1;
		this.setImage();
		}
		
		
		
	}

}
