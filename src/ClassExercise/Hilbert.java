package ClassExercise;

public class Hilbert {

    private static double dist0=1, dist=dist0;

    public static void main(String[] args)  {
    	//The level of Hilbert Curve is depended on your command line argument 
        int level=Integer.parseInt(args[0]);
        dist=dist0;
        for (int i=level;i>0;i--) dist /= 2;
        Turtle turtle=new Turtle(dist/2, dist/2, 0);
        HilbertA(level,turtle); // 开始递归调用
        
    }

    private static void HilbertA (int level, Turtle turtle) {
        if (level > 0) {
            HilbertB(level-1,turtle);    
            turtle.goUp(dist);
            HilbertA(level-1,turtle);    
            turtle.goLeft(-dist);
            HilbertA(level-1,turtle);    
            turtle.goUp(-dist);
            HilbertC(level-1,turtle);
        }
    }

    private static void HilbertB (int level, Turtle turtle) {
        if (level > 0) {
        	HilbertA(level-1,turtle);      
        	turtle.goLeft(-dist);
        	HilbertB(level-1,turtle);     
        	turtle.goUp(dist);
        	HilbertB(level-1,turtle);    
        	turtle.goLeft(dist);
            HilbertD(level-1,turtle);
        }
    }

    private static void HilbertC (int level, Turtle turtle) {
        if (level > 0) {
        	HilbertD(level-1,turtle);    
        	turtle.goLeft(dist);
            HilbertC(level-1,turtle);    
            turtle.goUp(-dist);
            HilbertC(level-1,turtle);    
            turtle.goLeft(-dist);
            HilbertA(level-1,turtle);    
        }
    }

    private static void HilbertD (int level, Turtle turtle) {
        if (level > 0) {
        	HilbertC(level-1,turtle);    
        	turtle.goUp(-dist);
        	HilbertD(level-1,turtle);    
        	turtle.goLeft(dist);
        	HilbertD(level-1,turtle);  
        	turtle.goUp(dist);
            HilbertB(level-1,turtle); 
        }
    }
}
	