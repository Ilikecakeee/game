package agame;

import java.awt.image.BufferedImage;

public class enemy implements Runnable {
	
	private int x;
	private int y;
	//��ʼ����
	private int startX;
	private int startY;
	//����
	private int type;
	public int getType() {
		return type;
	}

	//��ʾͼƬ
	private BufferedImage showImage;
	//�ƶ�����
	private boolean islestorup=true;
	private boolean ismove=true;
	//�ƶ��ļ��޷�Χ
	private int upMax=0;
	private int downMax=0;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public BufferedImage getShowImage() {
		return showImage;
	}

	//�����߳�
	Thread t=new Thread(this);
	//����ͼƬ״̬
	private int imageType=0;
	//����һ����������
	private BackGround bg;
	
	//С����
	@SuppressWarnings("deprecation")
	public enemy(int x,int y,boolean isLeft,int type,BackGround bg){
		this.x=x;
		this.y=y;
		this.startX=x;
		this.startY=y;
		this.islestorup=isLeft;
		this.type=type;
		this.bg=bg;
		if(type==1){
			this.showImage=StaticValue.allenemyImage.get(0);
		}
		t.start();
		t.suspend();
	}
	//���
	public enemy(int x,int y,boolean isUp,boolean ismove,int type,int upMax,int downMax,BackGround bg){
		this.x=x;
		this.y=y;
		this.islestorup=isUp;
		this.ismove=ismove;
		this.type=type;
		this.bg=bg;
		
		this.upMax=upMax;
		this.downMax=downMax;
		
		if(type==2){
		     this.showImage=StaticValue.spike;
		}
		t.start();
		
	}
	//�����
	public enemy(int x,int y,int type,BackGround bg){
		this.x=x;
		this.y=y;
		this.bg=bg;
		this.type=type;
		if(type==3){
			this.showImage=StaticValue.spike;
		}
		if(type==4){
			this.showImage=StaticValue.spike2;
		}
	}
	
	
	public void dead(){
		this.showImage=StaticValue.allenemyImage.get(2);
		this.bg.getAllenemy().remove(this);
		this.bg.getRemovedenemy().add(this);
		
	}
	@SuppressWarnings("deprecation")
	public void startMove(){
		t.resume();
	}
	
	public void reset(){
		//�����긴λ
		
		//����ʾͼƬ����
		if(this.type==1){
			this.x=this.startX;
		    this.y=this.startY;
		     this.showImage=StaticValue.allenemyImage.get(0);
		}
		
		
	}
	

	
	

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(true){
			if(type==1){
				if(this.islestorup){
					this.x-=2;
				}else{
					this.x+=2;
				}
				
				if(imageType==0){
					imageType=1;
					
				}else{
					imageType=0;
				}
				
				boolean canLeft =true;
				boolean canRight=true;
			
				
				for(int i=0;i<this.bg.getAllObstruction().size();i++){
					Obstruction ob=this.bg.getAllObstruction().get(i);
					//��������������ƶ�
					if(ob.getX()==this.x+32&&(ob.getY()+64>this.y &&ob.getY()-42<this.y)){
						canRight=false;
					}
					//��������������ƶ�
					if(ob.getX()==this.x-64&&(ob.getY()+64>this.y &&ob.getY()-42<this.y)){
						canLeft=false;
					}
				}
				if(this.islestorup&&!canLeft||this.x==0){
					this.islestorup=false;
				}else if(this.islestorup&&!canRight||this.x==900){
					this.islestorup=true;
				}
				
				this.showImage=StaticValue.allenemyImage.get(imageType);
			}
			if(type==2){
				
					this.ismove=true;
				
				if(this.ismove){
				if(this.islestorup){
					this.y-=1;
					
				}else{
					this.y+=1;
				}
				if(this.islestorup&&this.y==this.upMax){
					this.islestorup=false;
				}
				if(!this.islestorup&&this.y==this.downMax){
					this.islestorup=true;
				}}
				showImage=StaticValue.spike;
			}
			if(type==3){
				this.showImage=StaticValue.allenemyImage.get(0);
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}

	}

}
