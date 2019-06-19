package Final_Ex1;
import java.awt.*;
import static java.awt.Color.BLACK;
import static java.lang.Math.*;

public class RotationFilter {
   public static void main(String[] args) {
      Picture source = new Picture(args[0]);

      final double THETA = toRadians( Double.parseDouble(args[1]));
      final int width = source.width();
      final int height = source.height();
      final int ci = width / 2;
      final int cj = height / 2;
      final double COS = cos(THETA);
      final double SIN = sin(THETA);

      Picture target = new Picture(width, height);

      for (int i = 0; i < width; i++) {
         for (int j = 0; j < height; j++) {
            int ti = (int)round((i - ci) * COS - (j - cj) * SIN + ci);
            int tj = (int)round((i - ci) * SIN + (j - cj) * COS + cj);
            if (ti < 0 || width <= ti || tj < 0 || height <= tj) 
               continue;
            target.set( ti, tj, source.get(i, j));
         }
      }

      // Any missing pixel with BLACK by rotation 
      // is filled with the color of its left neighbour pixel.
      for (int i = 0; i < width-2; i++) {
         for (int j = 0; j < height; j++) {
            Color c0 = target.get(i, j);
            Color c1 = target.get(i+1, j);
            Color c2 = target.get(i+2, j);
            if (!c0.equals(BLACK) && c1.equals(BLACK) && !c2.equals(BLACK)) {
               target.set(i+1, j, c0);
            }
         }
      }
      target.show();
   }
}
