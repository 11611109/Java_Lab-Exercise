package Lab2;

import ClassExercise.Picture;

class CFG {
	public final static int DEFAULT_CANVAS_WIDTH = 800;//宽度的像素
	public final static int DEFAULT_CANVAS_HEIGHT = 800;
	public final static int DEFAULT_SCALE_MIN = -1000;//屏蔽物理设备的像素点，建立自己的坐标系，画布放大缩小的话内容也会放大缩小
	public final static int DEFAULT_SCALE_MAX = 1000;
}
public class CatRunSample {

	public static void main(String[] args) {
		StdDraw.setCanvasSize(CFG.DEFAULT_CANVAS_WIDTH, CFG.DEFAULT_CANVAS_HEIGHT);
		StdDraw.setScale(CFG.DEFAULT_SCALE_MIN, CFG.DEFAULT_SCALE_MAX);

		String imageFileName = "icon/cat.png";
		Picture picture = new Picture(imageFileName);
		// int scaledHeight = picture.height();
		// int scaledWidth = picture.width();

		int scaledHeight = CFG.DEFAULT_SCALE_MAX;//占画布的一半
		int scaledWidth = picture.width() * CFG.DEFAULT_SCALE_MAX / picture.height();

		int speed = 80;
		StdDraw.enableDoubleBuffering();//两个缓冲区1.on screen buffer 2.off buffer准备下一幅图片 
		double y = 0;
		double x = CFG.DEFAULT_SCALE_MIN + 0.5 * scaledHeight;
		for (; x < CFG.DEFAULT_SCALE_MAX - 0.5 * scaledHeight; ) {//循环制作展示图片形成动画
			x += speed;
			StdDraw.clear();
			StdDraw.picture(x, y, imageFileName, scaledWidth, scaledHeight);
			StdDraw.show();
			StdDraw.pause(100);//100ms

		}
	}

}
