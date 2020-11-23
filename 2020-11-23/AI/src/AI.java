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
	
	Image heroImg[][] = new Image[4][3];	//0����left��1����right��2����up��3����down
	Image currentImg;

	int x = 120;	//X����
	int y = 100;	//Y����
	boolean isAction = true;

	public MainCanvas(){
	
		try{
			for(int i= 0;i< heroImg.length; i++){
				for(int j= 0;j< heroImg[i].length;j++){
					heroImg[i][j] = Image.createImage("/sayo" + i + j + ".png");		//�ǵÿ�ͷ��  " /"
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
		
		g.drawImage(currentImg,x,y,0); //130��X���ꡢ90��Y����
	}
	public void keyPressed(int keyCode){

		int action = getGameAction(keyCode);
		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/

		isKeyAction(action);
		
	}
	/*
		�жϰ�������Ӧ����
	*/
	public void isKeyAction(int action){
		if(action == LEFT){
			if(x >= 0){		//�����ƶ�������
				x--;
			}
			changeImgAndDirect(heroImg[0][1],heroImg[0][2]);	//�ƶ��ı�ͼƬ
			
		}

		if(action == RIGHT){
			if(x <= getWidth()-25){		//�����ƶ�������
				x++;
			}
			changeImgAndDirect(heroImg[1][1],heroImg[1][2]);
		
		}

		if(action == UP){
			if(y >= 1){		//�����ƶ�������
				y--;
			}
			changeImgAndDirect(heroImg[2][1],heroImg[2][2]);
		}

		if(action == DOWN){
			if(y <= getHeight() - 25){		//�����ƶ�������
				y++;
			}
			changeImgAndDirect(heroImg[3][1],heroImg[3][2]);
		}
		repaint();
	}
	/*
		�ƶ��ı�ͼƬ
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