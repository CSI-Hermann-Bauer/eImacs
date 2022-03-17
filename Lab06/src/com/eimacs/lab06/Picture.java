package com.eimacs.lab06;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 * @version 2.0 (April 25, 2014) IMACS Curriculum Development Group
 */
public class Picture extends SimplePicture
{
      ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     *
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int width, int height)
    {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a copy of that picture
     *
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

      ////////////////////// methods ///////////////////////////////////////
    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName()
                + " height " + getHeight()
                + " width " + getWidth();
        return output;
    }

    /**
     * Method to set the blue component to 0
     */
    public void zeroBlue()
    {
        Pixel[][] pixels = getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    /**
     * Method that mirrors the left half of a picture onto the
     * right half as though reflecting in a mirror placed on 
     * the vertical center line of the picture
     */
    public void mirrorLeftOntoRight()
    {
        Pixel[][] pixels = getPixels2D();
        Pixel leftPixel, rightPixel;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][(width - 1) - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    
    public void negate() 
    { 
        Pixel[][] pixels = getPixels2D();
        for (Pixel[] rowArray : pixels) 
        { 
            for (Pixel pixelObj : rowArray) 
            { 
                pixelObj.setRed(255-pixelObj.getRed());
                pixelObj.setGreen(255-pixelObj.getGreen());
                pixelObj.setBlue(255-pixelObj.getBlue());
                
                //pixelObj.setAlpha(255 ­ pixelObj.getAlpha()); 
            } 
        } 
    } 
    public void grayscale() 
    { 
        Pixel[][] pixels = getPixels2D();
        for (Pixel[] rowArray : pixels) 
        { 
            for (Pixel pixelObj : rowArray) 
 
            { 
                int avg = (int)pixelObj.getAverage();
                pixelObj.setRed(avg);
                pixelObj.setGreen(avg);
                pixelObj.setBlue(avg);
                //pixelObj.setAlpha(255 ­ pixelObj.getAlpha()); 
            } 
        } 
    } 
 
public void fixUnderwater() 
    { 
        Pixel[][] pixels = getPixels2D();
        for (Pixel[] rowArray : pixels) 
        { 
            for (Pixel pixelObj : rowArray) 
            { 
                int avg = (int)pixelObj.getAverage();
                pixelObj.setRed(avg);
                pixelObj.setGreen(avg);
                pixelObj.setBlue(avg);
                pixelObj.setAlpha(255);
                pixelObj.getAlpha();
            } 
        } 
    } 
    public void mirrorTopOntoBottom() 
    { 
        Pixel[][] pixels = getPixels2D();
        Pixel top, bot;
        int height = pixels.length;
        int width = pixels[0].length;
        for(int y = 0; y < height / 2; y ++) 
        { 
            for(int x = 0; x < width; x++) 
            { 
                top = pixels[y][x]; 
                bot = pixels[height - y - 1][x]; 
                bot.setColor(top.getColor()); 
            } 
        } 
 
    } 
 
public void flipLeftAndRight() 
    { 
        Pixel[][] pixels = getPixels2D();
        Pixel leftPixel, rightPixel;
        Color temp;
        int width = pixels[0].length; 
        for (int row = 0; row < pixels.length; row++) 
        { 
            for (int col = 0; col < width / 2; col++) 
            { 
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][(width - 1) - col]; 
                temp = rightPixel.getColor();
                rightPixel.setColor(leftPixel.getColor());
                leftPixel.setColor(temp);
            } 
        } 
    } 
////SEGUNDO
public void repairTemple() 
    { 
        Pixel[][] pixels = getPixels2D();
        Pixel leftPixel, rightPixel;
        for (int row = 28; row < 97; row++) 
        { 
            for (int col = 17; col < 279; col++) 
            { 
                leftPixel = pixels[row][col]; 
                int x = 278 -17-(col- 17); 
                rightPixel = pixels[row][279 + x]; 
                rightPixel.setColor(leftPixel.getColor());
            } 
        } 
    } 
 

public void cloneSeagull() 
    { 
        Pixel[][] pixels = getPixels2D();
 
        Color[][] copiedRegion = new Color[341 -228][450231];
        for (int row = 228; row < 341; row++) 
        { 
            for (int col = 231; col < 450; col++) 
            { 
                copiedRegion[row -228][col - 231] = pixels[row][col].getColor();
            }
        } 
        for(int row = 248;row < 361; row++) 
        { 
            for(int col = 382; col < 601; col++) 
            { 
                pixels[row][col].setColor(copiedRegion[row- 248][col-382]);
            } 
        } 
    } 
 //// tercero
 public void edgeDetect(int minColorDistance) 
    { 
        Pixel[][] pixels = getPixels2D();
        Pixel left, right, bot;
        int height = pixels.length;
        int width = pixels[0].length; 
        for(int y = 0; y < height-1; y ++)
        { 
            for(int x = 0; x < width- 1; x++) 
            { 
                left = pixels[y][x];
                right = pixels[y][x+1];
                bot = pixels[y+1][x];
                double dif = left.colorDistance(right.getColor());
                double bDif = left.colorDistance(bot.getColor());
                if(bDif > dif) dif = bDif;
                if(dif >= minColorDistance) 
                { 
                    left.setColor(Color.BLACK);
                } 
                else 
                    left.setColor(Color.WHITE);
            } 
        } 
    } 
 
 
public void hideMessage(String[] messages) 
{ 
    Pixel[][] pixels = getPixels2D();
    int height = pixels.length;
    int width = pixels[0].length;
    Picture pix = new Picture( width, height);
    for ( int i = 0; i < messages.length; i++ ) 
      pix.addMessage( messages[ i ], 50, 50 + 30 * i );
    Pixel[][] wording = pix.getPixels2D();


    for(int y = 0; y < height; y ++) 
    { 
        for(int x = 0; x < width; x++) 
        { 
            Color preColor = pixels[y][x].getColor();
            boolean isBlack = wording[y][x].getColor().equals(Color.BLACK);
            boolean isOddRed = preColor.getRed() % 2 == 1;
            if(isOddRed) 
            { 
                pixels[y][x].setRed(preColor.getRed() - 1);
            } 
            preColor = pixels[y][x].getColor();
            if(isBlack) 
            { 
                pixels[y][x].setRed(preColor.getRed() + 1);
            } 
        } 
    } 
} 
 
    public void revealMessage() 
    { 
        Pixel[][] pixels = getPixels2D();
        int height = pixels.length;
        int width = pixels[0].length;
        for(int y = 0; y < height; y ++) 
        { 
            for(int x = 0; x < width; x++) 
            { 
                if(pixels[y][x].getRed() % 2 == 0) 
                    pixels[y][x].setColor(Color.WHITE);
 
                else 
                    pixels[y][x].setColor(Color.BLACK);
            }
        } 
    } 
} // this } is the end of class Picture, put all new methods before this


