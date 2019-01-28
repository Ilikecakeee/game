package agame;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BackGround {
	
	private BufferedImage bgImage=null;
	public BufferedImage getBgImage() {
		return bgImage;
	}
	private int sort;//场景顺序
	public void setSort(int sort) {
		this.sort = sort;
	}



	public int getSort() {
		return sort;
	}
	
	
	//全部的障碍物
	private List<Obstruction> allObstruction=new ArrayList<Obstruction>();
	public List<Obstruction> getAllObstruction() {
		return allObstruction;
	}
	private List<Obstruction> removedObstruction=new ArrayList<Obstruction>();
	
	public List<Obstruction> getRemovedObstruction() {
		return removedObstruction;
	}
	private List<enemy> allenemy=new ArrayList<enemy>();
	
	public List<enemy> getAllenemy() {
		return allenemy;
	}
	
	//被消灭的敌人
	
     private List<enemy> removedenemy=new ArrayList<enemy>();
     public List<enemy> getRemovedenemy() {
		return removedenemy;
	}
     
     //所有的道具
     private List<item> allitem=new ArrayList<item>();



	public List<item> getAllitem() {
		return allitem;
	}
	//被移除的道具
	private List<item> removeditem=new ArrayList<item>();
	private List<saveplace> allbutton=new ArrayList<saveplace>();
	



	public List<saveplace> getAllbutton() {
		return allbutton;
	}



	public List<item> getRemoveditem() {
		return removeditem;
	}



	//构造方法
	public BackGround(int sort){
		this.sort=sort;
		
		
		if(sort==1){//第一个场景
			bgImage=StaticValue.allbgImage.get(sort-1);
			for(int i=0;i<16;i++){
				this.allObstruction.add(new Obstruction(i*64,600,8));
			}
			 //this.allenemy.add(new enemy(240,300,4,this));
			
			 for(int i=0;i<12;i++){
					this.allObstruction.add(new Obstruction(-50,i*64,8));
				}
			 for(int i=0;i<7;i++){
					this.allObstruction.add(new Obstruction(940,i*64,8));
				}
			this.allObstruction.add(new Obstruction(300,420,4));
			for(int i=0;i<3;i++){
				this.allObstruction.add(new Obstruction(364+i*64,420,5));
			}
			for(int i=0;i<10;i++){
				this.allObstruction.add(new Obstruction(i*64,240,5));
			}
			this.allObstruction.add(new Obstruction(700,240,7));//
			this.allitem.add(new item(450,560,this));
			this.allenemy.add(new enemy(350,570,3,this));
			this.allenemy.add(new enemy(450,390,3,this));
			this.allenemy.add(new enemy(550,570,3,this));
			this.allObstruction.add(new Obstruction(556,420,6));
			this.allObstruction.add(new Obstruction(120,540,3));
			this.allenemy.add(new enemy(400,311,true,1,this));
			this.allenemy.add(new enemy(200,150,true,1,this));
			this.allenemy.add(new enemy(660,458,true,1,this));
			this.allbutton.add(new saveplace(720,223,1,1,this));//x,y,true,type,this

			
			
		}
		if(sort==2){
			bgImage=StaticValue.allbgImage.get(sort-1);
			for(int i=0;i<12;i++){
		    	this.allObstruction.add(new Obstruction(i*64,600,8));
		    }
			this.allObstruction.add(new Obstruction(768,600,8,1,this));
			this.allObstruction.add(new Obstruction(832,600,8));
			this.allObstruction.add(new Obstruction(896,600,8));
		 for(int i=0;i<12;i++){
				this.allObstruction.add(new Obstruction(i*64,420,8));
			}
		 for(int i=0;i<9;i++){
				this.allObstruction.add(new Obstruction(950,240+i*64,8));
			}
		 for(int i=0;i<7;i++){
				this.allObstruction.add(new Obstruction(-50,i*64,8));
			}
		 this.allObstruction.add(new Obstruction(900,540,8));
		 for(int i=0;i<13;i++){
				this.allObstruction.add(new Obstruction(180+i*64,240,8));
			}
		 for(int i=0;i<33;i++){
			 this.allenemy.add(new enemy(i*30,20,4,this));
		 }
		this.allenemy.add(new enemy(120,570,3,this));
		 this.allenemy.add(new enemy(370,570,3,this));
		 this.allenemy.add(new enemy(520,570,3,this));
		 this.allenemy.add(new enemy(680,570,3,this));
		 this.allenemy.add(new enemy(120,210,3,this));
		 this.allenemy.add(new enemy(240,480,4,this));
		 this.allenemy.add(new enemy(480,480,4,this));
		 //this.allenemy.add(new enemy(450,290,4,this));
		 this.allbutton.add(new saveplace(920,523,1,2,this));
		 this.allenemy.add(new enemy(120,422,true,false,2,392,422,this));
		 this.allenemy.add(new enemy(160,422,true,false,2,392,422,this));
		 this.allenemy.add(new enemy(190,422,true,false,2,392,422,this));
		 this.allenemy.add(new enemy(300,422,true,false,2,392,422,this));
		 this.allenemy.add(new enemy(330,422,true,false,2,392,422,this));
		 this.allenemy.add(new enemy(360,422,true,false,2,392,422,this));
		 this.allenemy.add(new enemy(390,422,true,false,2,392,422,this));
		 this.allenemy.add(new enemy(480,422,true,false,2,392,422,this));
		 this.allenemy.add(new enemy(530,422,true,false,2,392,422,this));
		 //this.allObstruction.add(new Obstruction(400,180,8));
		 //this.allenemy.add(new enemy(420,160,3,this));
		 this.allitem.add(new item(300,500,this));
		}
		if(sort==3){
			bgImage=StaticValue.allbgImage.get(sort-1);
			for(int i=0;i<10;i++){
				this.allObstruction.add(new Obstruction(i*64,240,8));
			}
			for(int i=0;i<16;i++){
				this.allObstruction.add(new Obstruction(i*64,600,8));
			}
			for(int i=0;i<10;i++){
				this.allObstruction.add(new Obstruction(i*64,240,8));
			}
			for(int i=0;i<16;i++){
				this.allObstruction.add(new Obstruction(i*64,600,8));
			}
			 for(int i=0;i<33;i++){
				 this.allenemy.add(new enemy(i*30,20,4,this));
			 }
			 this.allenemy.add(new enemy(120,210,3,this));
			 this.allenemy.add(new enemy(150,210,3,this));
			 this.allenemy.add(new enemy(250,210,3,this));
			 this.allenemy.add(new enemy(280,210,3,this));
			 this.allenemy.add(new enemy(380,210,3,this));
			 this.allenemy.add(new enemy(410,210,3,this));
			 this.allbutton.add(new saveplace(490,223,1,3,this));
			 this.allitem.add(new item(340,210,this));
			 for(int i=0;i<10;i++){
				 this.allObstruction.add(new Obstruction(640,210+i*64,8));
			 }
			 for(int i=0;i<8;i++){
				 this.allObstruction.add(new Obstruction(900,i*64,8));
			 }
			this.allenemy.add(new enemy(710,280,true,1,this));
			 this.allenemy.add(new enemy(800,410,true,1,this));
			 this.allenemy.add(new enemy(850,550,false,1,this));
			 this.allenemy.add(new enemy(720,570,3,this));
		}
		if(sort==4){
			bgImage=StaticValue.allbgImage.get(sort-1);
			

			for(int i=0;i<11;i++){
				this.allObstruction.add(new Obstruction(i*64,600,8));//x,y,类型
			}
			this.allObstruction.add(new Obstruction(704,600,8,1,this));
			this.allObstruction.add(new Obstruction(768,600,8,1,this));
			this.allObstruction.add(new Obstruction(832,600,8));
			this.allObstruction.add(new Obstruction(896,600,8));
			for(int i=0;i<8;i++){
				this.allObstruction.add(new Obstruction(950,i*64,8));
			}
			for(int i=0;i<16;i++){
				this.allObstruction.add(new Obstruction(i*64,260,8));
			}
			for(int i=0;i<33;i++){
				 this.allenemy.add(new enemy(i*30,320,4,this));
			 }
			for(int i=0;i<7;i++){
				 this.allenemy.add(new enemy(120+i*30,570,3,this));
			 }
			for(int i=0;i<9;i++){
				 this.allenemy.add(new enemy(500+i*30,570,3,this));
			 }
			this.allbutton.add(new saveplace(430,583,1,4,this));
			 this.allitem.add(new item(390,570,this));
			
		}
		
			
		
		
		
	}
	
	

		//重置方法，将所有的障碍物和敌人返回到原有坐标，并将其状态也修改
		public void reset(){
			
			//将已经移除的敌人道具放回
			this.allenemy.addAll(this.removedenemy);
		    this.allitem.addAll(this.removeditem);
		    this.allObstruction.addAll(this.removedObstruction);
			//调用重置方法
			for(int i=0;i<this.allenemy.size();i++){
				this.allenemy.get(i).reset();
			}
			for(int i=0;i<this.allbutton.size();i++){
				this.allbutton.get(i).reset();
			}
			
		}
		//使敌人开始移动
		public void enemyStartMove(){
			for(int i=0;i<this.allenemy.size();i++){
				this.allenemy.get(i).startMove();;
			}
		}
	

}
