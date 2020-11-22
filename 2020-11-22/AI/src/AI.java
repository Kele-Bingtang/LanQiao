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
			currentImg = heroImg[0][0];

			if(x >= 0){		//不能移动出界面
				x--;
			}
			getImage(action,heroImg[0][1],heroImg[0][2]);	//移动改变图片
			
		}

		if(action == RIGHT){
			currentImg = heroImg[1][0];

			if(x <= getWidth()-25){		//不能移动出界面
				x++;
			}
			getImage(action,heroImg[1][1],heroImg[1][2]);
		
		}

		if(action == UP){
			currentImg = heroImg[2][0];

			if(y >= 1){		//不能移动出界面
				y--;
			}
			getImage(action,heroImg[2][1],heroImg[2][2]);
		}

		if(action == DOWN){
			currentImg = heroImg[3][0];

			if(y <= getHeight() - 25){		//不能移动出界面
				y++;
			}
			getImage(action,heroImg[3][1],heroImg[3][2]);
		}
		repaint();
	}
	/*
		移动改变图片
	*/
	public void getImage(int action, Image heroImg_1, Image heroImg_2){
		if(isAction){
			currentImg = heroImg_1;
			isAction = !isAction;
		}else if(!isAction){
			currentImg = heroImg_2;
			isAction = !isAction;
		}	
	}
	
}


/*
自我介绍:
kuang zhong jie 
lian chen
wei cai yu
luo pei ning
wu shang na
ma yong qiang
zhou jian jian 
lu shao yu
chen li peng
liang shuang xiang
liu jun
li liang chen
huang zhi guo
lei bin
li gao qiao
lu pan yu
long yu biao
chen xiang yong
sun guang qiao
xia jin hai
huang jia jian
wang shi tao
zhong liang xuan
zhang wang qin
wei liu qing
wu jia li
lu yu xin
liu dan min
chen geng qiao
liang fu xiang
zhao fang yu
lu gui xin
yang chun
zhu han
yang yang
liu shi peng
li ying feng
liu si yuan
pang jin yuan
wu ya kun
tang fei xue
tang xi
wei ning qing
shi yan hong
shi wei yi
li fa gui
ou jia ming
li zhuo wen
wei xiao ting
wei ting
mo chen long
*/
