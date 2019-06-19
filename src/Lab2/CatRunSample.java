package Lab2;

import ClassExercise.Picture;

class CFG {
	public final static int DEFAULT_CANVAS_WIDTH = 800;//��ȵ�����
	public final static int DEFAULT_CANVAS_HEIGHT = 800;
	public final static int DEFAULT_SCALE_MIN = -1000;//���������豸�����ص㣬�����Լ�������ϵ�������Ŵ���С�Ļ�����Ҳ��Ŵ���С
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

		int scaledHeight = CFG.DEFAULT_SCALE_MAX;//ռ������һ��
		int scaledWidth = picture.width() * CFG.DEFAULT_SCALE_MAX / picture.height();

		int speed = 80;
		StdDraw.enableDoubleBuffering();//����������1.on screen buffer 2.off buffer׼����һ��ͼƬ 
		double y = 0;
		double x = CFG.DEFAULT_SCALE_MIN + 0.5 * scaledHeight;
		for (; x < CFG.DEFAULT_SCALE_MAX - 0.5 * scaledHeight; ) {//ѭ������չʾͼƬ�γɶ���
			x += speed;
			StdDraw.clear();
			StdDraw.picture(x, y, imageFileName, scaledWidth, scaledHeight);
			StdDraw.show();
			StdDraw.pause(100);//100ms

		}
	}

}
