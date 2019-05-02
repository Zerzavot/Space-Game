/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaoyunum;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Rectangle;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;
import javax.swing.Timer;
import javafx.geometry.Rectangle2D;
import javax.swing.JOptionPane;


class Ates{
    private int x;
    private int y;
   // public int harcanan_ates;


    public Ates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
public class Oyun extends JPanel implements KeyListener,ActionListener{
    Timer timer=new Timer(5,this);

    private int gecen_sure=0;
    private int harcanan_ates=0;
    
    
    private BufferedImage image; //image i yerleştiricez.BufferedImage adlı class tan
    private ArrayList<Ates> atesler=new ArrayList<Ates>();
    
    //her timer calsıtıgında atesler bir ileri gitmwli
    //atesin hareketi icin
    private int atesdirY=1;
    private int topX=0;//saga sola sürekli 1 artır hareket etsin
    private int topdirX=2;
    private int uzayGemisiX=0;
    private int dirUzayX=20;
    
    public boolean kontrolEt(){
        for(Ates ates:atesler)
        {
            //iki dikdörtgen carpısıyorsa true don
            //iki dikdortgen gibi al
           
            if( new Rectangle2D(ates.getX(),ates.getY(),10,20).intersects(new Rectangle2D(topX,0,20,20)) )
            {return true;
            } 
        }
        return false;
    }

    public Oyun() {
       
        
        try {
            image =ImageIO.read(new FileImageInputStream(new File("uzaygemisi.png")));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBackground(Color.BLACK);
        
        timer.start();
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        gecen_sure+=5;
        g.setColor(Color.red);
        g.fillOval(topX, 0, 20, 20);
        
        g.drawImage(image,uzayGemisiX,490,image.getWidth()/10,image.getHeight()/10,this);//this:Jpanel de olacak
        
        for(Ates ates:atesler)
          {
         if(ates.getY()<0)//ates jframe den cıktıysa
         {
             atesler.remove(ates);
         }
          }
         g.setColor(Color.BLUE);
        for(Ates ates:atesler)
         {
             g.fillRect(ates.getX(), ates.getY(), 10, 20);
             
         }
    
        if(kontrolEt())//carpısma
        {
            timer.stop();
            String message="Kazandınız..\n"+
                    "Harcanan Ateş: "+harcanan_ates+
                    "\nGeçen Süre: "+gecen_sure/1000.0+" saniye";
            JOptionPane.showMessageDialog(this,message);
            System.exit(0);
        }
        
    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int c=e.getKeyCode();
        if(c==KeyEvent.VK_LEFT){
            if(uzayGemisiX<=0){
                uzayGemisiX=0;
                
            }
            else
            {
                uzayGemisiX-=dirUzayX;
            }
        }
        else if(c==KeyEvent.VK_RIGHT){
            if(uzayGemisiX>=720){
                uzayGemisiX=720;
            }
            else
            {
                uzayGemisiX+=dirUzayX;
            }
        }
        else if(c==KeyEvent.VK_SPACE){
            atesler.add(new Ates(uzayGemisiX+17,470));
            
           harcanan_ates++;//?
            
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(Ates ates:atesler){
            ates.setY(ates.getY()-atesdirY);
            
        }
        
        topX+=topdirX;
        if(topX>=750){
            topdirX=-topdirX;
            
        }
        if(topX<=0){
            topdirX=-topdirX;
        }
        repaint();
        
    
    }
    
    
    
}
