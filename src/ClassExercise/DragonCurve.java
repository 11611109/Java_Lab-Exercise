package ClassExercise;

public class DragonCurve {
	public static void main(String[] args) {
		//Takes one command line argument: the level n of dragon curve
		int n=Integer.parseInt(args[0]);
		String d0="F",r="F";
		recursive(n, d0, r);
	}
	
	public static void recursive(int level, String d,String r){
		if(level>0){
			String d1=d+"L"+r;
			String r1=d+"R"+r;
			recursive(level-1, d1, r1);
		}else {
			draw(d);
		}	
	}
	
	public static void draw(String d){
		String check="FLR";
		char [] ch=check.toCharArray();
		
		Turtle turtle=new Turtle(0.5, 0.5, 0);

		for (int j=0; j<d.length();j++){
			
			char c=d.charAt(j);
			if (c==ch[0]){
				turtle.goForward(0.002);
			} else if (c==ch[1]){
				turtle.turnLeft(90);
			}else{
				turtle.turnLeft(270);
			}
	    }
	}

}
