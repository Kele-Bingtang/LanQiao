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
	
	Image heroImg[][] = new Image[4][3];	//0代表left，1代表right，2代表up，3代表down
	Image currentImg;

	int x = 120;	//X坐标
	int y = 100;	//Y坐标
	boolean isAction = true;

	public MainCanvas(){
	
		try{
			for(int i= 0;i< heroImg.length; i++){
				for(int j= 0;j< heroImg[i].length;j++){
					heroImg[i][j] = Image.createImage("/sayo" + i + j + ".png");		//记得开头加  " /"
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}

		currentImg = heroImg[3][0];
	}
	public void paint(Graphics g){
		
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		
		g.drawImage(currentImg,x,y,0); //130：X坐标、90：Y坐标
	}
	public void keyPressed(int keyCode){

		int action = getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/

		isKeyAction(action);
		
	}
	/*
		判断按键，响应按键
	*/
	public void isKeyAction(int action){
		if(action == LEFT){
			if(x >= 0){		//不能移动出界面
				x--;
			}
			changeImgAndDirect(heroImg[0][1],heroImg[0][2]);	//移动改变图片
			
		}

		if(action == RIGHT){
			if(x <= getWidth()-25){		//不能移动出界面
				x++;
			}
			changeImgAndDirect(heroImg[1][1],heroImg[1][2]);
		
		}

		if(action == UP){
			if(y >= 1){		//不能移动出界面
				y--;
			}
			changeImgAndDirect(heroImg[2][1],heroImg[2][2]);
		}

		if(action == DOWN){
			if(y <= getHeight() - 25){		//不能移动出界面
				y++;
			}
			changeImgAndDirect(heroImg[3][1],heroImg[3][2]);
		}
		repaint();
	}
	/*
		移动改变图片
	*/
	public void changeImgAndDirect( Image heroImg_1, Image heroImg_2){
		if(isAction){
			currentImg = heroImg_1;
			isAction = !isAction;
		}else if(!isAction){
			currentImg = heroImg_2;
			isAction = !isAction;
		}	
	}
	
}