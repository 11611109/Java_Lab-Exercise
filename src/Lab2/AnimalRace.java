package Lab2;

import java.util.ArrayList;

import ClassExercise.Picture;

import java.awt.Font;

//class CFG {
//	public final static int DEFAULT_CANVAS_WIDTH = 800;//宽度的像素
//	public final static int DEFAULT_CANVAS_HEIGHT = 800;
//	public final static int DEFAULT_SCALE_MIN = -1000;//屏蔽物理设备的像素点，建立自己的坐标系，画布放大缩小的话内容也会放大缩小
//	public final static int DEFAULT_SCALE_MAX = 1000;
//}

public class AnimalRace{
	public static void main(String[] args) {
		StdDraw.setCanvasSize(CFG.DEFAULT_CANVAS_WIDTH, CFG.DEFAULT_CANVAS_HEIGHT);
		StdDraw.setScale(CFG.DEFAULT_SCALE_MIN, CFG.DEFAULT_SCALE_MAX);
		
		String imageFileName = "icon/rabbit.png";
		String imageFileName2 = "icon/turtle.png";
		String imageFileName3 = "icon/pig.png";
		Picture picture = new Picture(imageFileName);
		Picture picture2 = new Picture(imageFileName2);
		Picture picture3 = new Picture(imageFileName3);
		// int scaledHeight = picture.height();
		// int scaledWidth = picture.width();

		int scaledHeight = CFG.DEFAULT_SCALE_MAX/3*2;//占画布的一半
		int scaledWidth = picture.width() * CFG.DEFAULT_SCALE_MAX / picture.height()/3*2;
		
		Rabbit rabbit=new Rabbit(80, imageFileName);
		Turtle turtle=new Turtle(5, imageFileName2);
		Pig pig=new Pig(30, imageFileName3);
		ArrayList<Animal> animals=new ArrayList<Animal>();
		animals.add(rabbit);
		animals.add(turtle);
		animals.add(pig);
		
		StdDraw.enableDoubleBuffering();
		int t;
		int height=CFG.DEFAULT_SCALE_MAX*2/3;
		int raceNo=0;
		int start=CFG.DEFAULT_SCALE_MIN+scaledHeight/2;
		for(t=0 ; t<80 ;t++){
			raceNo=1;
			StdDraw.clear();
			for (Animal a:animals){	
				a.raceDraw(start, t, raceNo, height,scaledWidth,scaledHeight);
				raceNo++;
			}
			StdDraw.show();
			StdDraw.pause(100);//100ms
		}		
		Font f = new Font("Comic Sans MS",Font.BOLD,60);
		StdDraw.setFont(f);
		StdDraw.setPenColor(StdDraw.ORANGE);
		StdDraw.text(0, 0, "The rabbit wins!!!");
	    StdDraw.show();
	}
}
abstract class Animal {
	protected int speed;
	protected String imageFileName;
	public Animal(int speed, String imageFileName) {
         super();
         this.speed = speed;
         this.imageFileName = imageFileName;
    }
	abstract public void raceDraw(int s, int time, int raceNo, int raceHeight, int scaledWidth, int 
			scaledHeight);
}

class Rabbit extends Animal{
	public Rabbit(int speed, String imageFileName){
		super(speed, imageFileName);
	}
	@Override
	public void raceDraw(int s, int time, int raceNo, int raceHeight,int scaledWidth, int 
			scaledHeight) {
//		if (time%4==2){
//			
//		}
		double x = s + (time/4)*speed;
		double y= (CFG.DEFAULT_SCALE_MAX*2/3*(raceNo-1)+raceHeight)/2-CFG.DEFAULT_SCALE_MAX;
		StdDraw.picture(x, y, imageFileName, scaledWidth, scaledHeight);
		
	}
}

class Turtle extends Animal{
	public Turtle(int speed, String imageFileName){
		super(speed, imageFileName);
	}
	@Override
	public void raceDraw(int s, int time, int raceNo, int raceHeight,int scaledWidth, int 
			scaledHeight) {
		double y= 0;
		double x = s + time*speed;
		StdDraw.picture(x, y, imageFileName, scaledWidth, scaledHeight);
	}
}

class Pig extends Animal{
	public Pig(int speed, String imageFileName){
		super(speed, imageFileName);
	}
	@Override
	public void raceDraw(int s, int time, int raceNo, int raceHeight,int scaledWidth, int 
			scaledHeight) {
//		if (time%3==1) {
//			
//		}
		double y= (CFG.DEFAULT_SCALE_MAX*2/3*(raceNo-1)+raceHeight)/2-CFG.DEFAULT_SCALE_MAX/3;
		double x = s + (time/3)*speed;
		StdDraw.picture(x, y, imageFileName, scaledWidth, scaledHeight);
		
	}
}