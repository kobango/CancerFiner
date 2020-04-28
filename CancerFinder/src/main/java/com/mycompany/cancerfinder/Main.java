/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cancerfinder;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import nu.pattern.OpenCV;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

        
/**
 *
 * @author kamil
 */
public class Main {
        public static void main(String[] args) {
            System.out.println("Hello World!");
            
            OpenCV.loadLocally();
            
           
            String path = "D:/IMD018.bmp";
            Mat img2 = loadImage(path);
            
            Mat img = Imgcodecs.imread(path); 
            
            MatOfByte mat = new MatOfByte();       
            Imgcodecs.imencode(".jpg", img, mat); 
            byte[] byteArray = mat.toArray(); 
            InputStream in = new ByteArrayInputStream(byteArray); 
            BufferedImage buf = null;
            try 
            {
                buf = ImageIO.read(in); 
            }
            
            catch (IOException e) 
            {
			System.out.println(e.getMessage());      
            }
            JFrame fr = new JFrame(); 
            fr.getContentPane().add(new JLabel(new ImageIcon(buf))); 
            fr.pack(); 
            fr.setVisible(true);
            
    }
public static Mat loadImage(String imagePath) {
    Imgcodecs imageCodecs = new Imgcodecs();
    return imageCodecs.imread(imagePath);
}
    
}
