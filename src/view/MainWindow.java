/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.dosse.upnp.UPnP;
import java.io.*;
import java.net.*;
import java.util.LinkedList;


/**
 *
 * @author Runelord
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    ServerSocket ss;
    LinkedList <Socket> s=new LinkedList<Socket>();
    LinkedList <DataInputStream> din=new LinkedList <DataInputStream>();
    LinkedList <DataOutputStream> dout=new LinkedList <DataOutputStream>();
    
    int clients;
    
    ClientWait cw=new ClientWait();
    
    LinkedList <Listen> l=new LinkedList <Listen>();
    
    String str1="";
    String str2="";
    
    boolean server=false;
    boolean exit=false;
    
    int messagesSent;
        
    InetAddress ia; 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        ip = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        message = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        makeServerButton = new javax.swing.JToggleButton();
        connectButton = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        serverIp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jLabel2.setText("Server IP:");

        ip.setText("localHost");
        ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipActionPerformed(evt);
            }
        });

        jLabel3.setText("User Name:");

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.setAutoscrolls(false);
        jScrollPane1.setViewportView(textArea);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        makeServerButton.setText("Make Server (Port: 1234)");
        makeServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeServerButtonActionPerformed(evt);
            }
        });

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("LAN IP:");

        serverIp.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(makeServerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(user))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(message)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton))
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serverIp)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(serverIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(makeServerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        if (clients!=0) for(int i=0; i<clients; i++)
            l.get(i).interrupt();
        cw.interrupt();
        exit=true;
        
        try{
            wait(10);
        } catch(Exception e) {}
        
        if(server) {
                        for (int i=0; i<clients; i++) {
                            try
                            {
                                dout.get(i).writeUTF("0");
                                dout.get(i).flush();
                                dout.get(i).close();
                                s.get(i).close();
                            } catch (Exception e) {}
        
                        }
                        try
                        {
                            ss.close();
                        }catch (Exception e) {}
                    }
        else try 
        {
        dout.get(0).writeUTF("0");
        dout.get(0).flush();
        dout.get(0).close();  
        s.get(0).close();
        } catch (Exception e) {}
        
        
        
        
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        str1=user.getText()+": "+message.getText();
        if (messagesSent>=9) messagesSent=0;
        messagesSent++;
        
        if (!server) try{
            dout.get(0).writeUTF(""+messagesSent+str1);  
            dout.get(0).flush();
        } catch (Exception e){}
        else {
                for(int i=0; i<clients; i++) try{
                dout.get(i).writeUTF(""+messagesSent+str1);  
                dout.get(i).flush();
             } catch (Exception e){}
             if (textArea.getText().equals("")) textArea.setText(str1);
             else textArea.setText(textArea.getText()+"\n"+str1);
        }
        
    }//GEN-LAST:event_sendButtonActionPerformed

    private void makeServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeServerButtonActionPerformed
        // TODO add your handling code here:
        makeServerButton.setEnabled(false);
        connectButton.setEnabled(false);
        
        if(UPnP.isUPnPAvailable()) textArea.setText("Port forwarding possible.");
        else textArea.setText("Port forwarding not possible.");
        UPnP.openPortTCP(1234);
        
        System.out.println("SERVER!!!");
        server=true;
        try{
            ss=new ServerSocket(1234);
        } catch(Exception e){}
        
        cw.start();
    }//GEN-LAST:event_makeServerButtonActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // TODO add your handling code here:
        makeServerButton.setEnabled(false);
        connectButton.setEnabled(false);
        
        try{
            Socket socket=new Socket(ip.getText(), 1234);
            s.add(socket);
            
            DataInputStream dataInputStream=new DataInputStream(s.get(0).getInputStream());
            din.add(dataInputStream);
            
            DataOutputStream dataOutputStream=new DataOutputStream(s.get(0).getOutputStream());
            dout.add(dataOutputStream);
            
            Listen listen=new Listen(0);
            l.add(listen);
            l.get(0).start();
            clients++;
        } catch (Exception e) {
            System.out.println(e);
            makeServerButton.setEnabled(true);
            connectButton.setEnabled(true);
            connectButton.setSelected(false);
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton connectButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField ip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton makeServerButton;
    private javax.swing.JTextField message;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField serverIp;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

public void activate(){
    setVisible(true);
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    
    try {
        ia=InetAddress.getByName("localHost");
        serverIp.setText(ia.getHostAddress());
    } catch(Exception e) {System.out.println(e);}
    
    messagesSent=0;
    
    clients=0;
}
public class Listen extends Thread{
    public int x;
    
    int messagesReceived=0;
    
    boolean disconnected=false;
    
    Listen(int sock){
        x=sock;
    };
    
    @Override
    public void run(){
        do{
            if(server){
                    this.setName("Listen"+x);
                    
                    str1="";
                    str2="";
                    
                    try{
                        str1=din.get(x).readUTF();
                    }catch (Exception e) {}
                    
                    if(!(str1.equals("")) & str1!=null)
                        if((""+str1.charAt(0)).equals("0")) try{
                            din.get(x).close();
                            dout.get(x).close();
                            s.get(x).close();
                            disconnected=true;
                            System.out.println(x+" disconnected");
                        } catch(Exception e) {}
                        
                        else if(!((""+str1.charAt(0)).equals(""+messagesReceived))){
                        
                        if(messagesReceived>=9) messagesReceived=0;
                        messagesReceived++;
                        
                        for(int j=1; j<str1.length(); j++)
                        str2=str2+str1.charAt(j);
                        
                        if(textArea.getText().equals("")) textArea.setText(str2);
                        else textArea.setText(textArea.getText()+"\n"+str2);
                        
                        if (messagesSent>=9) messagesSent=0;
                        messagesSent++;
                        
                        str2=messagesSent+str2;
                        for(int j=0; j<clients; j++){
                            System.out.println(str2);
                            try{
                                dout.get(j).writeUTF(str2);
                                dout.get(j).flush();
                            }catch (Exception e) {System.out.println(e);}
                        }        
                        
                        
                    }
            try{
            wait(1);
            }catch(Exception e) {}    
                                
                            
                                
                                    
            }
            else {
                str2="";
                str1="";
                try{
                    str1=(String) din.get(0).readUTF();
                    System.out.println(str1);
                } catch (Exception e) {}
                
                if(!(str1.equals("")) & str1!=null)
                        if((""+str1.charAt(0)).equals("0")) try{
                            din.get(x).close();
                            dout.get(x).close();
                            s.get(x).close();
                            disconnected=true;
                            System.out.println(x+" disconnected");
                        } catch(Exception e) {}
                
                        else 
                            if (!(str1.equals("")) & (!(""+messagesReceived).equals(""+str1.charAt(0)))) 
                        {
                            if(messagesReceived>=9) messagesReceived=0;
                            messagesReceived++;
                    
                            for(int j=1; j<str1.length(); j++)
                            str2=str2+str1.charAt(j);
                    
                            if(textArea.getText().equals("")) textArea.setText(str2);
                            else textArea.setText(textArea.getText()+"\n"+str2);
                        } 
            
            }
            try{
            wait(1);
            }catch(Exception e) {}
        } while(!exit & !disconnected);
    }
}
public class ClientWait extends Thread{
    
    @Override
    public void run(){
        Socket socket=new Socket();
        do{
        try
        {
            
            ss.setSoTimeout(1);
            socket=ss.accept();//establishes connection
            if (socket!=null){ 
                s.add(socket);
                
                
                
                DataInputStream dataInputStream=new DataInputStream(s.get(clients).getInputStream());
                din.add(dataInputStream);
                
                DataOutputStream dataOutputStream=new DataOutputStream(s.get(clients).getOutputStream());
                dout.add(dataOutputStream);
                
                Listen listen=new Listen(clients);
                l.add(listen);
                l.get(clients).start();
                
                System.out.println("Clients: "+clients);
                clients++;
            }
                
                
                
            
        } catch (Exception e) {}
        
        try{
            wait(1);
        }catch(Exception e) {}
        } while(!exit);
        try
        {
        
        } catch (Exception e) {}
    }
    
    }
}