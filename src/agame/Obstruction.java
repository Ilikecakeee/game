package agame;

import java.awt.image.BufferedImage;

public class Obstruction {
	private int x;
	
	private int y;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	//类型
	private int type2;
	private int type;
	public void setType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}
	//显示图片
	private BufferedImage showImage=null;

	private BackGround bg;
	
	public BufferedImage getShowImage() {
		return showImage;
	}
	//构造方法
	public Obstruction(int x,int y,int type/*,BackGround bg*/){
		this.x=x;
		this.y=y;
		this.type=type;
		//this.bg=bg;
		setImage();
	}
	public Obstruction(int x,int y,int type,int type2,BackGround bg){
		this.x=x;
		this.y=y;
		this.type=type;
		this.type2=type2;
		this.bg=bg;
		setImage();
	}
	public int getType2() {
		return type2;
	}
	/*//重置的方法
	public void reset(){
		//修改类型为原始的类型
		this.type=startType;
		//改变显示图片
		this.setImage();
	}*/
	//根据类型改变显示图片
	public void setImage(){
		showImage=StaticValue.allObstructionImage.get(type);
	}
	

}
