package agame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class StaticValue {
	public static List<BufferedImage> allcharactorImage=new ArrayList<BufferedImage>();
    public static BufferedImage startImage=null;
    public static BufferedImage endImage=null;
    public static BufferedImage deadImage=null;
    public static BufferedImage helpImage=null;
    public static BufferedImage heart =null;
    public static File startmusic=null;
    public static BufferedImage item=null;
    
    public static BufferedImage spike=null;
    public static BufferedImage spike2=null;
    public static BufferedImage button=null;
    public static BufferedImage buttonpress=null;
	
	public static List<BufferedImage> allbgImage=new ArrayList<BufferedImage>();;
	
	public static List<BufferedImage> allObstructionImage=new ArrayList<BufferedImage>();
	
	public static List<BufferedImage> allenemyImage=new ArrayList<BufferedImage>();
	
	public static String ImagePath=System.getProperty("user.dir")+"/bin/";
	//将全部图片初始化
	public static void init(){
		//将所有图片保存到静态属性中
		for(int i=1;i<=8;i++){
			try {
					allcharactorImage.add(ImageIO.read(new File(ImagePath+i+".png")));
			} catch (IOException e) {
			// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
		//导入全部背景
		for(int i=1;i<=4;i++){
				try {
					
					allbgImage.add(ImageIO.read(new File(ImagePath+"地图"+i+".png")));
					
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		}
		//导入障碍物的图片
				for(int i=1;i<=9;i++){
					try {
						allObstructionImage.add(ImageIO.read(new File(ImagePath+"tileBrown_0"+i+".png")));
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			for(int i=1;i<=3;i++){
				try {
					allenemyImage.add(ImageIO.read(new File(ImagePath+"enemyWalking_"+i+".png")));
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			try {
				endImage=ImageIO.read(new File(ImagePath+"QQ图片20170604000416.png"));
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			try {
				deadImage=ImageIO.read(new File(ImagePath+"QQ图片20170604000443.png"));
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			try {
				helpImage=ImageIO.read(new File(ImagePath+"有道具帮助界面.png"));
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			try {
				spike=ImageIO.read(new File(ImagePath+"spikesLow.png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			try {
				spike2=ImageIO.read(new File(ImagePath+"spikesLow2.png"));
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			try {
				startImage=ImageIO.read(new File(ImagePath+"主界面最终版.png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			try {
				heart=ImageIO.read(new File(ImagePath+"redGem.png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			try {
				item=ImageIO.read(new File(ImagePath+"redCrystal.png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			try {
				button=ImageIO.read(new File(ImagePath+"buttonRed.png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			try {
				buttonpress=ImageIO.read(new File(ImagePath+"buttonRed_pressed.png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		
	}
}
