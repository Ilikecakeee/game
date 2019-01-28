package agame;

import java.awt.image.BufferedImage;

public class item {
	private int x;
	private BackGround bg;
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

	public item(int x,int y,BackGround bg){
		this.x=x;
		this.y=y;
		this.bg=bg;
		setImage();
	}

	public void setImage() {
		showImage=StaticValue.item;
		
	}
	
	
	
	
	

}
