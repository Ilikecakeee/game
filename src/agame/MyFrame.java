package agame;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;


public class MyFrame extends JFrame implements KeyListener,Runnable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<BackGround>allBG=new ArrayList<BackGround>();
	
	private charactor charactor=null;//初始化角色
	
	private BackGround nowBG=null;
	private Thread t=new Thread(this);
	
	private int status=0;
	public static void main(String[] args){
		new MyFrame();
		
		
	}
	public MyFrame(){
		this.setTitle("骑皮皮虾小分队3.0");
		this.setSize(960,738);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width-960)/2,(height-738)/2);
		this.setResizable(false);//无法改变窗体大小
		
		//初始化全部的图片
		StaticValue.init();
		//创建全部场景
		for(int i=1;i<=4;i++){
			this.allBG.add(new BackGround(i));
		}
		//将第一个场景设置为当前场景
		this.nowBG=this.allBG.get(0);
		//初始化角色对象
		this.charactor=new charactor(10,480,0);
		
		//将场景放入CHAR对象中
		this.charactor.setBg(nowBG);
		this.repaint();
		this.addKeyListener(this);
		
		t.start();
		
		//this.music();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void music(){
		 try {  
	            URL cb;  
	            File f = new File(System.getProperty("user.dir")+"/bin/"+"Alone.wav"); // 引号里面的是音乐文件所在的路径  
	            cb = f.toURL();  
	            AudioClip aau;  
	            aau = Applet.newAudioClip(cb);  
	          
	            aau.play();   
	            aau.loop();//循环播放  
	          
	            // 循环播放 aau.play()  
	            //单曲 aau.stop()停止播放  
	  
	        } catch (MalformedURLException e) {  
	              
	            e.printStackTrace();  
	        }  
	}
	public void paint(Graphics g){
		//建立临时的缓冲图片
		BufferedImage image=new BufferedImage(960,738,BufferedImage.TYPE_3BYTE_BGR);
		Graphics g2=image.getGraphics();
		if(this.status==1){
			
		
		//绘制背景
		g2.drawImage(this.nowBG.getBgImage(), 0, 0, this);
		
		//绘制敌人
		Iterator<enemy> iterenemy=this.nowBG.getAllenemy().iterator();
		while(iterenemy.hasNext()){
			enemy e=iterenemy.next();
			g2.drawImage(e.getShowImage(),e.getX(),e.getY(),this);
		}
		//绘制障碍物
		Iterator<Obstruction>iter=this.nowBG.getAllObstruction().iterator();
		while(iter.hasNext()){
			Obstruction ob=iter.next();
			g2.drawImage(ob.getShowImage(), ob.getX(), ob.getY(), this);
			
		}
		//绘制道具
		Iterator<item>iteritem=this.nowBG.getAllitem().iterator();
		while(iteritem.hasNext()){
			item it=iteritem.next();
			g2.drawImage(it.getShowImage(),it.getX(),it.getY(),this);
		}
		//绘制按钮
		Iterator<saveplace>itersa=this.nowBG.getAllbutton().iterator();
		while(itersa.hasNext()){
			saveplace sa=itersa.next();
			g2.drawImage(sa.getShowImage(),sa.getX(),sa.getY(),this);
		}
		g2.drawImage(this.charactor.getShowImage(),this.charactor.getX(),this.charactor.getY(),this);
		}else if(this.status==0){
			g2.drawImage(StaticValue.startImage,0,0,this);
		}else if(this.status==3){
			g2.drawImage(StaticValue.helpImage,0,0,this);
		}else if(this.status==4){
			g2.drawImage(StaticValue.endImage,0,0,this);
		}else if(this.status==5){
			g2.drawImage(StaticValue.deadImage,0,0,this);
		}
		if(this.charactor.getLife()==1){
		g2.drawImage(StaticValue.heart,600 , 100,this);
		}else if(this.charactor.getLife()==2){
			g2.drawImage(StaticValue.heart,600,100,this);
			g2.drawImage(StaticValue.heart,630,100,this);
		}else if(this.charactor.getLife()==3){
			g2.drawImage(StaticValue.heart,600,100,this);
			g2.drawImage(StaticValue.heart,630,100,this);
			g2.drawImage(StaticValue.heart,660,100,this);
		}else if(this.charactor.getLife()==4){
			g2.drawImage(StaticValue.heart,600,100,this);
			g2.drawImage(StaticValue.heart,630,100,this);
			g2.drawImage(StaticValue.heart,660,100,this);
			g2.drawImage(StaticValue.heart,690,100,this);
		}
		else if(this.charactor.getLife()==5){
			g2.drawImage(StaticValue.heart,600,100,this);
			g2.drawImage(StaticValue.heart,630,100,this);
			g2.drawImage(StaticValue.heart,660,100,this);
			g2.drawImage(StaticValue.heart,690,100,this);
			g2.drawImage(StaticValue.heart,710,100,this);
		}
		else if(this.charactor.getLife()==6){
			g2.drawImage(StaticValue.heart,600,100,this);
			g2.drawImage(StaticValue.heart,630,100,this);
			g2.drawImage(StaticValue.heart,660,100,this);
			g2.drawImage(StaticValue.heart,690,100,this);
			g2.drawImage(StaticValue.heart,710,100,this);
			g2.drawImage(StaticValue.heart,740,100,this);
		}
		//把缓冲图片绘制到窗体中
		g.drawImage(image, 0, 0, this);
		
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO 自动生成的方法存根
		//当抬起时停止向左或向右移动
		if(this.status==1){
		if(ke.getKeyCode()==39){
			this.charactor.rightStop();
		}
		if(ke.getKeyCode()==37){
			this.charactor.leftStop();
		}
		}
	}
	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO 自动生成的方法存根
		/*System.out.print(ke.getKeyCode());*/
		//左37右39上38空格32H72S83G71
		//主菜单
		if(this.status==0){
			//按Q退出
			this.charactor.setLife(0);	
		if(ke.getKeyCode()==81){
			System.exit(0);
		}
		if(ke.getKeyCode()==83){
				this.status=1;
				this.nowBG.enemyStartMove();
				this.charactor.setFlag(0);
				this.charactor.setLife(2);
		}
		//按H打开帮助页面
				if(ke.getKeyCode()==72){
					this.status=3;
				}
		
		}
		
			
		//游戏界面
		if(this.status==1){
			//按下x键88返回主菜单
			
			if(ke.getKeyCode()==88){
			this.status=0;
		}
			if(ke.getKeyCode()==81){
				System.exit(0);
			}
			//按H打开帮助页面
		if(ke.getKeyCode()==72){
			this.status=3;
		}
		if(ke.getKeyCode()==39){
			this.charactor.rightMove();
		}
		if(ke.getKeyCode()==37){
			this.charactor.leftMove();
		}
		//按↑跳跃
		if(ke.getKeyCode()==38&&(this.charactor.getUptime()>=0&&this.charactor.getUptime()<2)){
			this.charactor.jump();
		
		}
		if(ke.getKeyCode()==71){
			this.nowBG=allBG.get(3);
			this.charactor.setX(800);
			this.charactor.setY(480);
		}
		}
		//帮助界面
		if(this.status==3){
			//按下x键88返回主菜单
			this.charactor.setLife(0);
			if(ke.getKeyCode()==88){
			this.status=0;
		    }
			if(ke.getKeyCode()==83){
				this.status=1;
				
		}
			
		}//胜利界面
			if(this.status==4){
				//按下x键88返回主菜单
				this.charactor.setLife(0);
				if(ke.getKeyCode()==88){
				this.status=0;
			}
				//按Q退出
				if(ke.getKeyCode()==81){
					System.exit(0);
				}
			}
			//失败界面
			if(this.status==5){
				//按下x键88返回主菜单
				if(ke.getKeyCode()==88){
				this.status=0;
			}if(ke.getKeyCode()==81){
					System.exit(0);
				}
				
			}
		
		
		
		
		
		
		
		

	}

	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO 自动生成的方法存根

	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true){
			this.repaint();
		    
			try {
				Thread.sleep(80);
				if(this.charactor.getX()>=960){
					//切换场景
					this.nowBG=this.allBG.get(this.nowBG.getSort());
					
					this.charactor.setBg(this.nowBG);
					this.nowBG.enemyStartMove();
					this.charactor.setX(0);
				}
				if(this.charactor.getX()<0){
					this.nowBG=this.allBG.get(this.nowBG.getSort()-2);
					this.charactor.setBg(this.nowBG);
					this.nowBG.enemyStartMove();
					this.charactor.setX(950);
				}
				if(this.charactor.isIsdead()){
					
					 
					this.status=5;
					this.charactor.setIsdead(false);
					this.nowBG=this.allBG.get(0);
					this.charactor.setBg(this.nowBG);
					this.charactor.setStatus("right--standing");
					this.nowBG.enemyStartMove();
					this.charactor.setX(10);
					this.charactor.setY(540);
					this.allBG.get(0).reset();
					//this.allBG.get(1).reset();
					//this.allBG.get(2).reset();
					//this.allBG.get(3).reset();
					//this.nowBG.reset();
					/*for(int i=0;i<4;i++){
						this.nowBG=this.allBG.get(i);
						this.nowBG.reset();
					}*/
					//this.nowBG=this.allBG.get(0);
					
				}
				if(this.charactor.isIsdown()){
					this.charactor.setIsdown(false);
					
					this.charactor.setStatus("right--standing");
					if(this.charactor.getFlag()==0){
						this.nowBG=this.allBG.get(0);
					this.charactor.setBg(this.nowBG);
					this.charactor.setX(10);
					this.charactor.setY(540);
					}if(this.charactor.getFlag()==1){
						this.nowBG=this.allBG.get(0);
						this.charactor.setBg(this.nowBG);
						this.charactor.setX(720);
						this.charactor.setY(180);
						
					}if(this.charactor.getFlag()==2){
						this.nowBG=this.allBG.get(1);
						this.charactor.setBg(this.nowBG);
						this.charactor.setX(900);
						this.charactor.setY(480);
					}if(this.charactor.getFlag()==3){
						this.nowBG=this.allBG.get(2);
						this.charactor.setBg(this.nowBG);
						this.charactor.setX(490);
						this.charactor.setY(180);
					}if(this.charactor.getFlag()==4){
						this.nowBG=this.allBG.get(3);
						this.charactor.setBg(this.nowBG);
						this.charactor.setX(430);
						this.charactor.setY(540);
					}
					
					
					
				}
				if(this.nowBG.getSort()==4&&this.charactor.getX()>=920&&this.charactor.getY()>=400){
					
					this.status=4;
					this.nowBG=this.allBG.get(0);
					this.charactor.setBg(this.nowBG);
					this.charactor.setStatus("right--standing");
					this.nowBG.enemyStartMove();
					this.charactor.setX(10);
					this.charactor.setY(540);
					
					//this.nowBG.reset();
					for(int i=0;i<4;i++){
						this.nowBG=this.allBG.get(i);
						this.nowBG.reset();
					}
					this.nowBG=this.allBG.get(0);
					
					
				}
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

} 