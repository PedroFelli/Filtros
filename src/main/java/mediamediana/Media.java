package mediamediana;


public class Media {

	
	 public static void meanFilter(MyImage img, int maskSize){
	        
	        /** 
	         * This array will store the output of the mean filter operation which will
	         * be later written back to the original image pixels.
	         */
	        int outputPixels[] = new int[img.getImageTotalPixels()];
	        
	        //image dimension
	        int width = img.getImageWidth();
	        int height = img.getImageHeight();
	        
	        //ARGB variable
	        int alpha, red, green, blue;
	        
	        /** Mean Filter operation */
	        for(int y = 0; y < height; y++){
	            for(int x = 0; x < width; x++){
	                alpha = 0;
	                red = 0;
	                green = 0;
	                blue = 0;
	                int count = 0;
	                for(int r = y - (maskSize / 2); r <= y + (maskSize / 2); r++){
	                    for(int c = x - (maskSize / 2); c <= x + (maskSize / 2); c++){
	                        if(r < 0 || r >= height || c < 0 || c >= width){
	                            /** Some portion of the mask is outside the image. */
	                            continue;
	                        }else{
	                            alpha += img.getAlpha(c, r);
	                            red += img.getRed(c, r);
	                            green += img.getGreen(c, r);
	                            blue += img.getBlue(c, r);
	                            count++;
	                        }
	                    }
	                }
	                
	                /** save mean value in outputPixels array */
	                int p = ImageFX.getPixelValueFromARGBValue(alpha/count, red/count, green/count, blue/count);
	                outputPixels[x+y*width] = p;
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
