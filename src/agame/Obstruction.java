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
	//����
	private int type2;
	private int type;
	public void setType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}
	//��ʾͼƬ
	private BufferedImage showImage=null;

	private BackGround bg;
	
	public BufferedImage getShowImage() {
		return showImage;
	}
	//���췽��
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
	/*//���õķ���
	public void reset(){
		//�޸�����Ϊԭʼ������
		this.type=startType;
		//�ı���ʾͼƬ
		this.setImage();
	}*/
	//�������͸ı���ʾͼƬ
	public void setImage(){
		showImage=StaticValue.allObstructionImage.get(type);
	}
	

}
