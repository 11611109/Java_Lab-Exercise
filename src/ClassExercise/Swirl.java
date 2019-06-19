package ClassExercise;

public class Swirl {
	public static void main(String[] args) {
		//The source file is sample.png,takes one command line arguments:sample.png
		Picture source=new Picture(args[0]);
		
//		double degree=Math.PI/6;
		int width = source.width();
		int height = source.height();

		int Ci = height/2;
		int Cj = width/2;
		Picture target=new Picture(width,height);
		
		int trow=0;
		int tcol=0;
		for (int col=0; col<source.width(); col++){
			for (int row=0; row<source.height(); row++){
				double degree=Math.sqrt((row-Ci)*(row-Ci)+(col-Cj)*(col-Cj))*Math.PI/256;
				trow=(int)((row-Ci)*Math.cos(degree)-(col-Cj)*Math.sin(degree)+Ci);
				tcol=(int)((row-Ci)*Math.sin(degree)+(col-Cj)*Math.cos(degree)+Cj);
				if(height>trow && trow>=0 && width>tcol && tcol>=0){
					target.set(tcol, trow, source.get(col, row));
				}
			}
		}
		target.show();
	}

}
