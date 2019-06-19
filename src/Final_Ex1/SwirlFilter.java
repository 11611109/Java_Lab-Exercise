package Final_Ex1;
import java.awt.*;
import static java.awt.Color.BLACK;
import static java.lang.Math.*;

public class SwirlFilter {
   public static void main(String[] args) {
      Picture source = new Picture(args[0]);

      final int width = source.width();
      final int height = source.height();
      final int ci = width / 2;
      final int cj = height / 2;

      Picture target = new Picture(width, height);

      for (int i = 0; i < width; i++) {
         for (int j = 0; j < height; j++) {
            double theta = PI / 256 * sqrt( pow(i-ci, 2) + pow(j-cj, 2));
            double COS = cos(theta);
            double SIN = sin(theta);
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

      // Any missing pixel with BLACK by rotation 
      // is filled with the color of its up neighbour pixel.
      for (int i = 0; i < width; i++) {
         for (int j = 0; j < height-2; j++) {
            Color c0 = target.get(i, j);
            Color c1 = target.get(i, j+1);
            Color c2 = target.get(i, j+2);
            if (!c0.equals(BLACK) && c1.equals(BLACK) && !c2.equals(BLACK)) {
               target.set(i, j+1, c0);
            }
         }
      }

      target.show();
   }
}
