import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
import java.util.Scanner; 

public class ASCII_Image_Processing {
    public static void main(String [] args) throws IOException {
        int height = 60;
        int width = 45;
        char[][] newColorMap = new char[60][45];
        char[] scaleMap = new char[69];
        File imageFile = new File("/home/robert/Pictures/don.png");
        Scanner scan = new Scanner(new File("/home/robert/Projects/colorScale.txt"));
        int iterator = 0;
        while(scan.hasNextLine()) {
            scaleMap[iterator] = scan.nextLine().charAt(0);
            iterator ++;
        }
        System.out.println(scaleMap[14]);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        image = ImageIO.read(imageFile);
        System.out.println("Yeet");
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                  int  clr   = image.getRGB(x, y); 
                  int  red   = (clr & 0x00ff0000) >> 16;
                  int  green = (clr & 0x0000ff00) >> 8;
                  int  blue  =  clr & 0x000000ff;
                  int adjustedBrightness = (red + green + blue) / 3;
                  newColorMap[x][y] = scaleMap[adjustedBrightness / 4];

            }
        }
        for(int r = 0; r < newColorMap.length; r ++) {
            for(int c = 0; c < newColorMap[0].length; c ++) {
                System.out.print(newColorMap[r][c]);
                System.out.print(newColorMap[r][c]);
                System.out.print(newColorMap[r][c]);
            }
            System.out.println();
        }

    }


}