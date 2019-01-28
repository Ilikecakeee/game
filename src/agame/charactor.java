package agame;

import java.awt.image.BufferedImage;
/*import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;*/

public class charactor implements Runnable{
	
	//坐标
	private int x;
	

	public void setX(int x) {
		this.x = x;
	}
	private int y;
	//加入线程
	
	public void setY(int y) {
		this.y = y;
	}
	//加入线程
	private Thread t=null;
	//定义一个场景对象，保存当前所在场景
	private BackGround bg;

	public void setBg(BackGround bg) {
		this.bg = bg;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	//定义一个速度属性
	private int xmove=0;
	//定义垂直方向的速度
	private int ymove=0;
	//状态
	private String status;
	public void setStatus(String status) {
		this.status = status;
	}
	//显示的图片
	private BufferedImage showImage;
	

	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	private int life;
	
	//当前移动中显示的图片索引
	private int moving=0;
	
	//上升的时间
	private int uptime=0;	
	public int getUptime() {
		return uptime;
	}
	//存档用
	private int flag=0;
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getFlag() {
		return flag;
	}
	private boolean isdead=false;
	public void setIsdead(boolean isdead) {
		this.isdead = isdead;
	}
	public boolean isIsdead() {
		return isdead;
	}
	private boolean isdown=false;

	public void setIsdown(boolean isdown) {
		this.isdown = isdown;
	}
	public boolean isIsdown() {
		return isdown;
	}
	public charactor(int x,int y,int flag){
		this.x=x;
		this.y=y;
		this.flag=flag;
		//初始化
		this.showImage=StaticValue.allcharactorImage.get(0);
		this.uptime=0;
		this.life=0;
		
		t=new Thread(this);
		//开始线程
		t.start();
		
		this.status="right--standing";
	}
	public BufferedImage getShowImage() {
		return showImage;
	}
	
	public void leftMove(){
		xmove=-10;
		//改变状态
		//跳跃时不移动
		if(this.status.indexOf("jumping")!=-1){
			this.status="left--jumping";
		}else{
		this.status="left--moving";
		}
	}
	
	public void rightMove(){
		xmove=10;
		if(this.status.indexOf("jumping")!=-1){
			this.status="right--jumping";
		}else{
		this.status="right--moving";
		}
	}
	
	public void leftStop(){
		this.xmove=0;
		if(this.status.indexOf("jumping")!=-1){
			this.status="left--jumping";
		}else{
		this.status="left--standing";
		}
	}
	
	public void rightStop(){
		this.xmove=0;
		if(this.status.indexOf("jumping")!=-1){
			this.status="right--jumping";
		}else{
		this.status="right--standing";
		}
	}
	
	public void jump(){
		
		
			if(this.status.indexOf("left")!=-1){
				this.status="left--jumping";
			}else{
				this.status="right--jumping";
			}
			uptime+=6;
			ymove=-15;
			
		}
	
	//加入下落的方法
	public void down(){
		if(this.status.indexOf("left")!=-1){
			this.status="left--jumping";
		}else{
			this.status="right--jumping";
		}
		ymove=15;
			
		
	}
	
	//死亡方法
	public void dead(){
		--life;
		if(this.life==0){
			//this.flag=0;
			this.isdead=true;
			
		}else{
			this.isdown=true;
			
			
			/*this.bg.reset();
			
			this.x=20;
			this.y=430;*/
		}
	}
	public void lifeup(){
		life+=1;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true){
			
			boolean canLeft=true;
			boolean canRight=true;
			boolean onLand=false;
			if(this.y>700){
				this.dead();
			}
			//判断是否与障碍物碰撞
			for(int i=0;i<this.bg.getAllObstruction().size();i++){
				Obstruction ob=this.bg.getAllObstruction().get(i);
				//不允许继续向右移动
				//定义标记
				
				if(ob.getX()==this.x+40&&(ob.getY()+60>this.y &&ob.getY()-50<this.y)){
					canRight=false;
				}
				//不允许继续向左移动
				if(ob.getX()==this.x-60&&(ob.getY()+60>this.y &&ob.getY()-50<this.y)){
					canLeft=false;
				}
				//如果符合条件，则表示当前处在障碍物的上面
				if(ob.getY()==this.y+60&&(ob.getX()+60>this.x&&ob.getX()-40<this.x)){
					onLand =true;
				}
				//判断当前是否在跳跃中顶到了一个障碍物
				if(ob.getY()==this.y-60&&(ob.getX()+60>this.x&&ob.getX()-40<this.x)){
					uptime=0;//立刻改为下降状态
				}
				if(ob.getType2()==1){
					if(ob.getX()-25<this.x&&ob.getX()+30>this.x&&(this.y+60==ob.getY())){
						this.bg.getAllObstruction().remove(ob);
						this.bg.getRemovedObstruction().add(ob);
					}
				}
			}
			
			//加入对敌人的判断
			for(int i=0;i<this.bg.getAllenemy().size();i++){
				enemy e=this.bg.getAllenemy().get(i);
				//碰到刺
				if(e.getType()==2){
					if((e.getY()-60<this.y&&e.getY()+32>this.y)&&(e.getX()+20>this.x&&e.getX()-30<this.x)){
						this.dead();
						
					}
				}
				if(e.getType()==3){
					if((e.getY()-60<this.y&&e.getY()+32>this.y)&&(e.getX()+20>this.x&&e.getX()-30<this.x)){
						this.dead();
				}
				}
				if(e.getType()==4){
					if((e.getY()+30>this.y&&e.getY()+20<this.y)&&(e.getX()+20>this.x&&e.getX()-30<this.x)){
						this.dead();
				}
				}
				//
				if(e.getType()==1){
					if(e.getX()+32>this.x&&e.getX()-40<this.x){
						if(e.getY()-60<this.y&&e.getY()-50>this.y){
							//this.uptime+=2;
							//this.ymove=-5;
							e.dead();
						}else{
						if(e.getY()+42>this.y&&e.getY()-55<this.y)
							this.dead();
						}
					}
				}
			
			
			}
			//对道具的判断
			for(int i=0;i<this.bg.getAllitem().size();i++){
				item ite=this.bg.getAllitem().get(i);
				if((ite.getX()-40<this.x&&ite.getX()+30>this.x)&&(ite.getY()-60<this.y&&ite.getY()+30>this.y)){
					this.bg.getAllitem().remove(ite);
					this.bg.getRemoveditem().add(ite);
					lifeup();
					
				}
				
				
			}
			
			//对按钮的判断
			for(int i=0;i<this.bg.getAllbutton().size();i++){
				saveplace sa=this.bg.getAllbutton().get(i);
				
				if(sa.getType()==1&&sa.getX()-30<this.x&&sa.getX()+25>this.x&&sa.getY()-60<this.y&&sa.getY()-50>this.y){
					sa.setType(2);
					sa.setImage();
					if(sa.getPlace()==1){
					
					this.flag=1;
					}if(sa.getPlace()==2){
					
					this.flag=2;
					}
					if(sa.getPlace()==3){
						
						this.flag=3;
						}
                    if(sa.getPlace()==4){
						
						this.flag=4;
						}
				}
				
			}
			if(onLand&&uptime==0){
				if(this.status.indexOf("left")!=-1){
					if(xmove!=0){
						this.status="left--moving";
					}else{
						this.status="left--standing";
					}
				}else{
					if(xmove!=0){
						this.status="right--moving";
					}else{
						this.status="right--standing";
					}
			    }
			}else{
				//表示当前为上升的状态
				if(uptime==0){
					this.down();
				}else{
					uptime--;
				}
				y+=ymove;
			}
			if(canLeft&&xmove<0||canRight&&xmove>0){
			x+=xmove;
			/*if(x<0){
				x=0;
			}*/
			}
			//定义一个初始索引数
			int temp=0;
			//当前面向左
			if(this.status.indexOf("left")==-1){
				temp+=4;
				
			}
			
			//判断当前是否为移动
			if(this.status.indexOf("moving")!=-1){
				temp+=this.moving;
				moving++;
				if(moving==3){
					moving=0;
				}
			}
			
			//如果当前是跳跃状态
			if(this.status.indexOf("jumping")!=-1){
				temp+=3;
			}
			//改变显示图片
			this.showImage=StaticValue.allcharactorImage.get(temp);
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	
}
