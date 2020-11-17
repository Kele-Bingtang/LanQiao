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
	����������
	�﷨���������� �������ƣ���ʶ����;
	*/
	Image leftImg,rightImg,upImg,downImg,currentImg;
	public MainCanvas(){
		try
		{
			/*
			��������ֵ
			�﷨����������=value;
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
		g.drawImage(currentImg,120,100,0); //120��X���ꡢ100��Y����
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/
		if(action == LEFT){
			currentImg = leftImg;
			System.out.println("����ת");
		}
		if(action == RIGHT){
			currentImg = rightImg;
			System.out.println("����ת");
		}
		if(action == UP){
			currentImg = upImg;
			System.out.println("����ת");
		}
		if(action == DOWN){
			currentImg = downImg;
			System.out.println("����ת");
		}
		repaint();
	}
}