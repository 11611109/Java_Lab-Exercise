package Final_Ex1;
public class GlassFilter {
   public static void main(String[] args) {
      Picture source = new Picture(args[0]);

      final int width = source.width();
      final int height = source.height();

      Picture target = new Picture(width, height);

      for (int i = 0; i < width; i++) {
         for (int j = 0; j < height; j++) {
            int si = (int)(i - 5 + Math.random() * 10);
            if (si < 0) si = 0;
            if (si >= width) si = width - 1;
            
            int sj = (int)(j - 5 + Math.random() * 10);
            if (sj < 0) sj = 0;
            if (sj >= height) sj = height - 1;

            target.set( i, j, source.get(si, sj));
         }
      }

      target.show();
   }
}
