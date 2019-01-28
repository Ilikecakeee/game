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
	
	private charactor charactor=null;//��ʼ����ɫ
	
	private BackGround nowBG=null;
	private Thread t=new Thread(this);
	
	private int status=0;
	public static void main(String[] args){
		new MyFrame();
		
		
	}
	public MyFrame(){
		this.setTitle("��ƤƤϺС�ֶ�3.0");
		this.setSize(960,738);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width-960)/2,(height-738)/2);
		this.setResizable(false);//�޷��ı䴰���С
		
		//��ʼ��ȫ����ͼƬ
		StaticValue.init();
		//����ȫ������
		for(int i=1;i<=4;i++){
			this.allBG.add(new BackGround(i));
		}
		//����һ����������Ϊ��ǰ����
		this.nowBG=this.allBG.get(0);
		//��ʼ����ɫ����
		this.charactor=new charactor(10,480,0);
		
		//����������CHAR������
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
	            File f = new File(System.getProperty("user.dir")+"/bin/"+"Alone.wav"); // ����������������ļ����ڵ�·��  
	            cb = f.toURL();  
	            AudioClip aau;  
	            aau = Applet.newAudioClip(cb);  
	          
	            aau.play();   
	            aau.loop();//ѭ������  
	          
	            // ѭ������ aau.play()  
	            //���� aau.stop()ֹͣ����  
	  
	        } catch (MalformedURLException e) {  
	              
	            e.printStackTrace();  
	        }  
	}
	public void paint(Graphics g){
		//������ʱ�Ļ���ͼƬ
		BufferedImage image=new BufferedImage(960,738,BufferedImage.TYPE_3BYTE_BGR);
		Graphics g2=image.getGraphics();
		if(this.status==1){
			
		
		//���Ʊ���
		g2.drawImage(this.nowBG.getBgImage(), 0, 0, this);
		
		//���Ƶ���
		Iterator<enemy> iterenemy=this.nowBG.getAllenemy().iterator();
		while(iterenemy.hasNext()){
			enemy e=iterenemy.next();
			g2.drawImage(e.getShowImage(),e.getX(),e.getY(),this);
		}
		//�����ϰ���
		Iterator<Obstruction>iter=this.nowBG.getAllObstruction().iterator();
		while(iter.hasNext()){
			Obstruction ob=iter.next();
			g2.drawImage(ob.getShowImage(), ob.getX(), ob.getY(), this);
			
		}
		//���Ƶ���
		Iterator<item>iteritem=this.nowBG.getAllitem().iterator();
		while(iteritem.hasNext()){
			item it=iteritem.next();
			g2.drawImage(it.getShowImage(),it.getX(),it.getY(),this);
		}
		//���ư�ť
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
		//�ѻ���ͼƬ���Ƶ�������
		g.drawImage(image, 0, 0, this);
		
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO �Զ����ɵķ������
		//��̧��ʱֹͣ����������ƶ�
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
		// TODO �Զ����ɵķ������
		/*System.out.print(ke.getKeyCode());*/
		//��37��39��38�ո�32H72S83G71
		//���˵�
		if(this.status==0){
			//��Q�˳�
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
		//��H�򿪰���ҳ��
				if(ke.getKeyCode()==72){
					this.status=3;
				}
		
		}
		
			
		//��Ϸ����
		if(this.status==1){
			//����x��88�������˵�
			
			if(ke.getKeyCode()==88){
			this.status=0;
		}
			if(ke.getKeyCode()==81){
				System.exit(0);
			}
			//��H�򿪰���ҳ��
		if(ke.getKeyCode()==72){
			this.status=3;
		}
		if(ke.getKeyCode()==39){
			this.charactor.rightMove();
		}
		if(ke.getKeyCode()==37){
			this.charactor.leftMove();
		}
		//������Ծ
		if(ke.getKeyCode()==38&&(this.charactor.getUptime()>=0&&this.charactor.getUptime()<2)){
			this.charactor.jump();
		
		}
		if(ke.getKeyCode()==71){
			this.nowBG=allBG.get(3);
			this.charactor.setX(800);
			this.charactor.setY(480);
		}
		}
		//��������
		if(this.status==3){
			//����x��88�������˵�
			this.charactor.setLife(0);
			if(ke.getKeyCode()==88){
			this.status=0;
		    }
			if(ke.getKeyCode()==83){
				this.status=1;
				
		}
			
		}//ʤ������
			if(this.status==4){
				//����x��88�������˵�
				this.charactor.setLife(0);
				if(ke.getKeyCode()==88){
				this.status=0;
			}
				//��Q�˳�
				if(ke.getKeyCode()==81){
					System.exit(0);
				}
			}
			//ʧ�ܽ���
			if(this.status==5){
				//����x��88�������˵�
				if(ke.getKeyCode()==88){
				this.status=0;
			}if(ke.getKeyCode()==81){
					System.exit(0);
				}
				
			}
		
		
		
		
		
		
		
		

	}

	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO �Զ����ɵķ������

	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(true){
			this.repaint();
		    
			try {
				Thread.sleep(80);
				if(this.charactor.getX()>=960){
					//�л�����
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}

} 