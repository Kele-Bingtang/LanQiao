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
	
	Image heroLeftImg[] = new Image[3];
	Image heroRightImg[] = new Image[3];
	Image heroUpImg[] = new Image[3];
	Image heroDownImg[] = new Image[3];
	Image currentImg;
	
	int x = 120;
	int y = 100;
	boolean isAction = true;
	public MainCanvas(){
		try
		{
			/*
			��������ֵ
			�﷨����������=value;
			*/
		for(int i =0;i <heroLeftImg.length;i++){
			heroLeftImg[i] = Image.createImage("/sayo" + i + "2.png");	//��׺Ϊ2������
		}
		for(int i =0;i <heroRightImg.length;i++){
			heroRightImg[i] = Image.createImage("/sayo" + i + "6.png");	//��׺Ϊ6������
		}
		for(int i =0;i <heroUpImg.length;i++){
			heroUpImg[i] = Image.createImage("/sayo" + i + "4.png");	//��׺Ϊ4������
		}
		for(int i =0;i <heroDownImg.length;i++){
			heroDownImg[i] = Image.createImage("/sayo" + i + "0.png");	//��׺Ϊ0������
		}
		
		currentImg = heroDownImg[1];
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		
		g.drawImage(currentImg,x,y,0); //130��X���ꡢ90��Y����
	}
	public void keyPressed(int keyCode){

		int action = getGameAction(keyCode);
		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/

		isKeyAction(action);
		
	}
	public void isKeyAction(int action){

		if(action == LEFT){
			currentImg = heroLeftImg[1];
			
			if(x >= 0){
				x--;
			}
			getImage(action,heroLeftImg[0],heroLeftImg[2]);
		}
		if(action == RIGHT){
			currentImg = heroRightImg[1];
			if(x <= getWidth()-25){
				x++;
			}
			getImage(action,heroRightImg[0],heroRightImg[2]);
		}
		if(action == UP){
			currentImg = heroUpImg[1];
			if(y >= 1){
				y--;
			}
			getImage(action,heroUpImg[0],heroUpImg[2]);
		}
		if(action == DOWN){
			currentImg = heroDownImg[1];

			if(y <= getHeight() - 25){
				y++;
			}

			getImage(action,heroDownImg[0],heroDownImg[2]);
			
		}
		repaint();
	}
	
	public void getImage(int action,Image heroMoveImg_1,Image hereMoveImg_2){
		
		if(isAction){
			currentImg = heroMoveImg_1;
			isAction = !isAction;
		}else if(!isAction){
			currentImg = hereMoveImg_2;
			isAction = !isAction;
		}
	}
	
}