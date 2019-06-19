package ClassExercise;

public class Rotation {
	public static void main(String[] args) {
		//The source file is sample.png,takes two command line arguments:sample.png + degree
		Picture source=new Picture(args[0]);
		double degree=Double.parseDouble(args[1]);
		
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
				trow=(int)((row-Ci)*Math.cos(Math.toRadians(degree))-(col-Cj)*Math.sin(Math.toRadians(degree))+Ci);
				tcol=(int)((row-Ci)*Math.sin(Math.toRadians(degree))+(col-Cj)*Math.cos(Math.toRadians(degree))+Cj);

				if(height>trow && trow>=0 && width>tcol && tcol>=0){
					target.set(tcol, trow, source.get(col, row));
				}
			}
		}
		target.show();
	}

}
