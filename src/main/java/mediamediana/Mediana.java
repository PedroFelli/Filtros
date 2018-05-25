package mediamediana;

public class Mediana {
	
    public static void medianFilter(MyImage img, int maskSize){
        
        /** 
         * This array will store the output of the median filter operation which will
         * be later written back to the original image pixels.
         */
        int outputPixels[] = new int[img.getImageTotalPixels()];
        
        //image dimension
        int width = img.getImageWidth();
        int height = img.getImageHeight();
        
        /**
         * Buff is a 2D square of odd size like 3x3, 5x5, 7x7, ...
         * For simplicity storing it into 1D array.
         */
        int buff[];
        
        /** Median Filter operation */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                buff = new int[maskSize * maskSize];
                int count = 0;
                for(int r = y - (maskSize / 2); r <= y + (maskSize / 2); r++){
                    for(int c = x - (maskSize / 2); c <= x + (maskSize / 2); c++){
                        if(r < 0 || r >= height || c < 0 || c >= width){
                            /** Some portion of the mask is outside the image. */
                            continue;
                        }else{
                            buff[count] = img.getPixel(c, r);
                            count++;
                        }
                    }
                }
                
                /** sort buff array */
                java.util.Arrays.sort(buff);
                
                /** save median value in outputPixels array */
                outputPixels[x+y*width] = buff[count/2];
            }
        }
        /** Write the output pixels to the image pixels */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                img.setPixelToValue(x, y, outputPixels[x+y*width]);
            }
        }
    }

}
