import java.util.*;

/**
 * This class implements a number of filters, i.e. methods that can be used to
 * manipulate Image objects, e.g. make the image darker or mirrored.
 * The filter methods operates on the image in the field (feltvariabel) image.
 * The filter methods change the original image and return the new image.
 *
 * @author Kurt Jensen
 * @version 2017-08-04
 */
public class Filters
{

    private Image image;     // Image on which the filter methods operate

    /**
     * The constructor takes as input an instance of Image.
     * 
     * @param image   Image to apply filters to.
     */
    public Filters(Image image) {
        this.image = image;
    }

    /**
     * The constructor  creates an Image object from the file picture.jpg (in the project folder).
     * 
     * @param image   Image to apply filters to.
     */
    public Filters() {
        image = new Image("picture.png");
    }

    /**
     * This method brightens an image by adding some amount to the
     * value of all pixels in the image.
     * The title of the new image is prefixed 'brightenX-',
     * where X is the parametervalue.
     *
     * @param amount   Increase in value for each pixel.
     * @return   Brightened image.
     */
    public Image brighten(int amount) {
        //Gå gennem hver pixel og øg dens værdi med amount
        for(Pixel pixel : image.getPixels()) {
            pixel.setValue(pixel.getValue()+amount);
        }
        image.setTitle("brighten" + amount + "-" + image.getTitle());
        image.updateCanvas();
        return image;
    }

    /**
     * This method darkens an image by subtracting some amount from the
     * value of all pixels in the image.
     * The title of the new image is prefixed 'darkenX-',
     * where X is the parametervalue.
     *
     * @param amount   Decrease in value for each pixel.
     * @return   Darkened image.
     */
    public Image darken(int amount) {
        for(Pixel pixel : image.getPixels()) {
            pixel.setValue(pixel.getValue()-amount);
        }
        image.setTitle("darken" + amount + "-" + image.getTitle());
        image.updateCanvas();
        return image;
    }

    /**
     * This method inverts an image by mapping each pixel value 'v' to '255-v'
     * such that white turns black and vice-versa.
     * The title of the new image is prefixed 'invert-'.
     *
     * @return   Inverted image.
     */
    public Image invert() {
        for(Pixel pixel : image.getPixels()) {
            pixel.setValue(255 - pixel.getValue());
        }
        image.setTitle("invert-" + image.getTitle());
        image.updateCanvas();
        return image;
    }

    /**
     * This method mirrors an image across the vertical axis.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * (width-i-1, j) in the old image, where width is the width of the image.
     * The title of the new image is prefixed 'mirror-'.
     *
     * @return   Mirrored image.
     */
    public Image mirror() {
        for(int y = 0; y < image.getHeight(); y++) {
            for(int left = 0, right = image.getWidth()-1; left < image.getWidth()/2; left++, right--) {
                int temp = image.getPixel(right, y).getValue();
                image.getPixel(right, y).setValue(image.getPixel(left, y).getValue());
                image.getPixel(left, y).setValue(temp);
            }
        }
        image.setTitle("mirror-" + image.getTitle());
        image.updateCanvas();
        return image;        
    }

    /**
     * This method flips an image across the horizontal axis.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * (i,height-j-1) in the old image, where height is the height of the image.
     * The title of the new image is prefixed 'flip-'.
     *
     * @return   Flipped image.
     */
    public Image flip() {
        for(int x = 0; x < image.getWidth(); x++) {
            for(int top = 0, bottom = image.getHeight()-1; top < image.getHeight()/2; top++, bottom--) {
                int temp = image.getPixel(x, bottom).getValue();
                image.getPixel(x, bottom).setValue(image.getPixel(x, top).getValue());
                image.getPixel(x, top).setValue(temp);
            }
        }
        image.setTitle("flip-" + image.getTitle());
        image.updateCanvas();
        return image; 
    }

    /**
     * This method rotates an image 90 degrees clockwise.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * (j,width-i-1) in the old image, where width is the width of the new image.
     * The title of the new image is prefixed 'rotate-'.
     *
     * @return   Rotated image.
     */
    public Image rotate() {
        Image newImage = new Image(image.getHeight(), image.getWidth(), "");
        for(int row = 0, newrow = newImage.getWidth()-1; row < image.getHeight(); row++, newrow--) {
            for(int column = 0; column < image.getWidth(); column++) {
                newImage.getPixel(newrow, column).setValue(image.getPixel(column, row).getValue());
            }
        }
        newImage.setTitle("rotate-" + image.getTitle());
        newImage.updateCanvas();
        return newImage; 
    }

    /**
     * Auxillary method for blur.
     * This method computes the average value of the (up to nine) neighbouring pixels
     * of position (i,j) -- including pixel (i,j).
     *
     * @param i   Horizontal index.
     * @param j   Vertical index.
     * @return    Average pixel value.
     */
    private int average(int i, int j) {
        int avgVal = 0;
        for(Pixel pixel : image.getNeighbours(i, j)) {
            avgVal += pixel.getValue();
        }
        avgVal /= image.getNeighbours(i, j).size();
        return (int)Math.round(avgVal);
    }

    /**
     * This method blurs an image.
     * Each pixel (x,y) is mapped to the average value of the neighbouring pixels. 
     * The title of the new image is prefixed 'blur-'.
     *
     * @return   Blurred image.
     */
    public Image blur() {
        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                image.getPixel(x, y).setValue(average(x, y));
            }
        }
        image.setTitle("blur-" + image.getTitle());
        image.updateCanvas();
        return image;
    }

    /**
     * This method adds noise to an image.
     * The value of pixel (i,j) is set to a random value in the interval
     * [v-amount, v+amount], where v is the old value and amount the parameter.
     * The title of the new image is prefixed 'noiseX-'.
     *
     * @param amount   Maximal amount of noise to add.
     * @return  Noisy image. 
     */
    public Image noise(int amount) {
        Random r = new Random();
        for(Pixel pixel : image.getPixels()) {
            pixel.setValue(pixel.getValue() + (r.nextInt(1+amount*2)-amount));
        }
        image.setTitle("noise" + amount + "-" + image.getTitle());
        image.updateCanvas();
        return image;
    }

    /**
     * This method resizes an image by some factor.
     * The size of the new image becomes with*factor x hiehgt*factor, where
     * width and heigt are the width and height of the old image.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * (i/factor,j/factor) in the old image, where factor is the parameter.
     * This produces a new image of size (width*factor, height*factor).
     * The title of the new image is prefixed 'factorX-'.
     *
     * @param factor   Resize factor.
     * @return   Resized image.
     */
    public Image resize(double factor) {
        Image newImage = new Image((int)(image.getWidth()*factor), (int)(image.getHeight()*factor), "");
        for(int y = 0; y < newImage.getHeight(); y++) {
            for(int x = 0; x < newImage.getWidth(); x++) {
                newImage.getPixel(x, y).setValue(image.getPixel((int)(x/factor), (int)(y/factor)).getValue());
            }
        }
        newImage.setTitle("resize" + factor +  "-" + image.getTitle());
        newImage.updateCanvas();
        return newImage;
    }

    /**
     * This method rotates an image 90 degrees anti-clockwise.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * (j,i) in the old image, where width is the width of the new image.
     * The title of the new image is prefixed 'rotateAC-'.
     *
     * @return   Rotated image.
     */
    public Image rotateAC() {
        Image newImage = new Image(image.getHeight(), image.getWidth(), "");
        for(int row = 0; row < image.getHeight(); row++) {
            for(int column = 0, newcolumn = newImage.getHeight()-1; column < image.getWidth(); column++, newcolumn--) {
                newImage.getPixel(row, newcolumn).setValue(image.getPixel(column, row).getValue());
            }
        }
        newImage.setTitle("rotateAC-" + image.getTitle());
        newImage.updateCanvas();
        return newImage; 
    }

    /**
     * This image increases the contrast of an image by some amount.
     * 
     * @param amount    The amount by which to increase contrast
     */
    public Image increaseContrast(double amount) {
        for(Pixel pixel : image.getPixels()) {
            double x  = ((2*pixel.getValue())/255.0)-1;
            double y  = Math.abs(x);
            double p  = Math.pow(Math.E, -amount);
            double yp = Math.pow(y, p);
            double xp = Math.signum(x)*yp;
            double output = ((xp+1)/2)*255;
            pixel.setValue((int)output);
        }
        image.setTitle("contrast" + amount + "-" + image.getTitle());
        image.updateCanvas();
        return image; 
    }

}
