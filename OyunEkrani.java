package javaoyunum;

import java.awt.HeadlessException;
import javax.swing.JFrame;

public class OyunEkrani extends javax.swing.JFrame {

    public OyunEkrani(String title) throws HeadlessException {
        super(title);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
     
         OyunEkrani ekran =new OyunEkrani("Uzay Oyunu");
    
         //SIRA MÜHİMMM!!
    ekran.setResizable(false);//oyun ekranımın değişmesini istemiyorum
    ekran.setFocusable(false);//tüm işlemlerimizin jFrame e odaklanmıcak.direk jPanele odaklanacak
    ekran.setSize(800,600);
    ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//?
    //
    Oyun oyun=new Oyun();
    oyun.requestFocus(); //direk klavyeden işlemlerimizi anlamaız için bana odağı ver
    oyun.addKeyListener(oyun);//klavye işlemlerimizi anlamamızı sağlayacak
    oyun.setFocusable(true);//odak artık J Panel de
    oyun.setFocusTraversalKeysEnabled(false);//direk klavye işlemleri gerçekleşebilsin
    
    ekran.add(oyun);
    ekran.setVisible(true);//JFrame imimiz Jpanele eklenince direk oluşsun
    
        
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
