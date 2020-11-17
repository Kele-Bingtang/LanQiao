import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	Image leftImg,rightImg,upImg,downImg,currentImg;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			leftImg = Image.createImage("/sayo10.png");
			rightImg = Image.createImage("/sayo12.png");
			upImg = Image.createImage("/sayo16.png");
			downImg = Image.createImage("/sayo20.png");
			currentImg=leftImg;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,120,100,0); //120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action == LEFT){
			currentImg = leftImg;
			System.out.println("向左转");
		}
		if(action == RIGHT){
			currentImg = rightImg;
			System.out.println("向右转");
		}
		if(action == UP){
			currentImg = upImg;
			System.out.println("向上转");
		}
		if(action == DOWN){
			currentImg = downImg;
			System.out.println("向下转");
		}
		repaint();
	}
}