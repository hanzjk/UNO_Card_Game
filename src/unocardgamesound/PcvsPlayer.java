/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unocardgamesound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static unocardgamesound.GameStage.uno;


public class PcvsPlayer extends javax.swing.JFrame {
  public static Boolean uno=false;
   
     ArrayList<String> temp = new ArrayList<>();
    String pids[];
    GameSingle gamesingle;
    //ScoreDisplay scoredisplay;
    ArrayList<JButton> cardButtons1 =new ArrayList<JButton>();
    ArrayList<String> cardIds1;
    
    ArrayList<JButton> cardButtons2=new ArrayList<JButton>();
    ArrayList<String> cardIds2;

   int p[]={0,0};
   
   public PcvsPlayer() {
        initComponents();
    }
    public PcvsPlayer(ArrayList<String>playerIds,int points[]) {
        initComponents();
         temp =playerIds;
        String Computer="PC";
        temp.add(Computer);
	pids=temp.toArray(new String[temp.size()]);
        
	gamesingle= new GameSingle(pids,points,this);
        p=points;
        //scoredisplay = new ScoreDisplay(pids,points,this);
	populateArrayList1();
        populateArrayList2();
        int c=0;
	c = gamesingle.startplayer2(gamesingle); //c=currentplayer  
	topCardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/cardSprites/"+gamesingle.getTopCardImage())));
        
        setButtonIcons();
        
        if (c==1)
        {
            pcturn();
        }
        
       }
    
    
    
    
    
    public  void pcturn()  //0 1
    {  
        //JLabel  message =new JLabel("PC trn!");
       // JOptionPane.showMessageDialog(null, message); 
        Boolean draw=true;
       ArrayList<UnoCard> playerHand;  
        playerHand=gamesingle.getPlayerhand(pids[1]);
      
       for (int i=0;i<cardIds2.size();i++)
      {
      
         if(playerHand.get(i).getColor()==gamesingle.validColor || playerHand.get(i).getValue()==gamesingle.validValue  || playerHand.get(i).getColor()==UnoCard.Color.WILD)
          {
            draw=false;
         
            String cardId2=cardIds2.get(i);
            pressPC(cardId2,gamesingle,i,cardButtons2,this,topCardButton);
        
            break;
         }
       
      
        
         
      } 
       
       if( draw==true)
       
       {
        int k=0;
        JLabel  message333 =new JLabel(" PC drew a card!");
        JOptionPane.showMessageDialog(null, message333);
      
            try {
                k =gamesingle.submitDraw(pids[1]);
            
            } catch (InvalidColorSubmissionException ex) {
                Logger.getLogger(PcvsPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidValueSubmissionException ex) {
                Logger.getLogger(PcvsPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidPlayerTurnException ex) {
                Logger.getLogger(PcvsPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            draw=false;
        
       
        

        
        this.setButtonIcons();
         if(k==1)
         {
            JLabel  message11 =new JLabel("PC turn");
             JOptionPane.showMessageDialog(null, message11);
             pcturn();
         }
       }
       
       
    } 
        
    
    public void setButtonIcons() {
	String listString1 =gamesingle.getPlayerhand(pids[0]).stream().map(Object::toString).collect(Collectors.joining(","));
	String cardNames1[]=listString1.split(",");
	cardIds1=new ArrayList<>(Arrays.asList(cardNames1));
	for(int i=0;i<cardIds1.size();i++) {
	       cardButtons1.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/cardSprites/"+cardIds1.get(i)+".png")));
        }
	for(int j=cardIds1.size();j<cardButtons1.size();j++)
	{
            cardButtons1.get(j).setIcon(null);
	}
        
        String listString2 =gamesingle.getPlayerhand(pids[1]).stream().map(Object::toString).collect(Collectors.joining(","));
	String cardNames2[]=listString2.split(",");
	cardIds2=new ArrayList<>(Arrays.asList(cardNames2));
	for(int i=0;i<cardIds2.size();i++) {
	     cardButtons2.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/cardSprites/card_back_alt.png")));  
            //cardButtons2.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/cardSprites/"+cardIds2.get(i)+".png")));
        }
	for(int j=cardIds2.size();j<cardButtons2.size();j++)
	{
            cardButtons2.get(j).setIcon(null);
	}
	
		
		
	}
    public void press(String cardName,GameSingle gamesingle,int index, ArrayList<JButton> cardButtons,PcvsPlayer pcvsPlayer,JButton topCardButton)
    {   int b=1;
        
        ArrayList<UnoCard>playerHand;
   
        UnoCard.Color declaredColor; 
       
        //cardImage=cardName;
	this.gamesingle=gamesingle;
	playerHand=gamesingle.getPlayerhand(pids[0]);
	
	this.topCardButton=topCardButton;
        
        PickColorFrame2 pickColor=new PickColorFrame2(gamesingle,this,topCardButton,pids[0]);
       declaredColor =pickColor.choseColor(playerHand.get(index));
	if(declaredColor!=null)
	{
          try {
            
                b=gamesingle.submitPlayerCard(pids[0], playerHand.get(index), declaredColor ,topCardButton);
      
          } catch (InvalidColorSubmissionException | InvalidValueSubmissionException | InvalidPlayerTurnException ex) {
              Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
          }
           revalidate();
           if(declaredColor!=UnoCard.Color.WILD) {
              
                   setButtonIcons();
               
               
               topCardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/cardSprites/"+gamesingle.getTopCardImage())));
               if (b==1)
          {
              pcturn();
          }
        }
           else if (b==1){
               setButtonIcons();
               pcturn();
           
        }
            
         
          
       
					
            
           
	}
        
        
        
    
     
    }
 
  
          
    public void pressPC(String cardName,GameSingle gamesingle,int index, ArrayList<JButton> cardButtons,PcvsPlayer pcvsPlayer,JButton topCardButton)
    {  int a = 0;
     
      ArrayList<UnoCard> playerHand;
   
       UnoCard.Color declaredColor; 
       
        
	this.gamesingle=gamesingle; 
	
        playerHand=gamesingle.getPlayerhand(pids[1]);
	
	this.topCardButton=topCardButton;
        
     
        declaredColor = playerHand.get(index).getColor();
       
        
	if(declaredColor!=null)
	{
          try {
            
              a=gamesingle.submitPlayerCard(pids[1], playerHand.get(index), declaredColor,topCardButton);
         
          } catch ( InvalidColorSubmissionException | InvalidValueSubmissionException |InvalidPlayerTurnException ex) {
              Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          
            
					
            
            revalidate();
           if(declaredColor!=UnoCard.Color.WILD) {
              
                setButtonIcons();
             
               
               
               
                
              
               topCardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/cardSprites/"+gamesingle.getTopCardImage())));
           
               if ( a==1)
            {
                pcturn();
            }
          }
           
           else if (a==1)
           {
               setButtonIcons();pcturn();
           }
            else if (a==0)
           {
               setButtonIcons();
           }
           
         
           
        
           
           
           
           
	}
        
        
       
        
        
        
    }
    
  
    
    
    public void populateArrayList1(){
        cardButtons1.add(jButton1);
	cardButtons1.add(jButton2);
	cardButtons1.add(jButton3);
	cardButtons1.add(jButton4);
	cardButtons1.add(jButton5);
	cardButtons1.add(jButton6);
	cardButtons1.add(jButton7);
        cardButtons1.add(jButton8);
        cardButtons1.add(jButton9);
        cardButtons1.add(jButton10);
        cardButtons1.add(jButton11);
	cardButtons1.add(jButton12);
	cardButtons1.add(jButton13);
	cardButtons1.add(jButton14);
        cardButtons1.add(jButton15);
      
      
      
        
    }
    
     public void populateArrayList2(){
      
       cardButtons2.add(jButton16);
       cardButtons2.add(jButton17);
       cardButtons2.add(jButton18);
       cardButtons2.add(jButton19);
       cardButtons2.add(jButton20);
       cardButtons2.add(jButton21);
       cardButtons2.add(jButton22);
       cardButtons2.add(jButton23);
        cardButtons2.add(jButton24);
        cardButtons2.add(jButton25);
        cardButtons2.add(jButton26);
       cardButtons2.add(jButton27);
        cardButtons2.add(jButton28);
        cardButtons2.add(jButton29);
        cardButtons2.add(jButton30);
       
       
     
      }
    
    
     
     
  
        
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        topCardButton = new javax.swing.JButton();
        downCard = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        callUNOButton = new javax.swing.JButton();
        ScoreButton = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UNO");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 140, 190));

        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 140, 190));

        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 140, 190));

        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 560, 140, 190));

        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 140, 190));

        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 560, 140, 190));

        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 140, 190));

        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 560, 140, 190));

        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 560, 140, 190));

        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 560, 140, 190));

        jButton11.setContentAreaFilled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 560, 140, 190));

        jButton12.setContentAreaFilled(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 140, 190));

        jButton13.setContentAreaFilled(false);
        jButton13.setPreferredSize(new java.awt.Dimension(163, 191));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 140, 190));

        jButton14.setContentAreaFilled(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 140, 190));

        topCardButton.setBorderPainted(false);
        topCardButton.setContentAreaFilled(false);
        getContentPane().add(topCardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 140, 190));

        downCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/card_back_alt.png"))); // NOI18N
        downCard.setBorderPainted(false);
        downCard.setContentAreaFilled(false);
        downCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                downCardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                downCardMouseExited(evt);
            }
        });
        downCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downCardActionPerformed(evt);
            }
        });
        getContentPane().add(downCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 140, 200));

        jButton15.setContentAreaFilled(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 140, 190));

        jButton16.setContentAreaFilled(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 190));

        jButton17.setContentAreaFilled(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 140, 190));

        jButton18.setContentAreaFilled(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 140, 190));

        jButton19.setContentAreaFilled(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 140, 190));

        jButton20.setContentAreaFilled(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 140, 190));

        jButton21.setContentAreaFilled(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 140, 190));

        jButton22.setContentAreaFilled(false);
        getContentPane().add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 140, 190));

        jButton23.setContentAreaFilled(false);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 140, 190));

        jButton24.setContentAreaFilled(false);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 190));

        jButton25.setContentAreaFilled(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 140, 190));

        jButton26.setContentAreaFilled(false);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 0, 140, 190));

        jButton27.setContentAreaFilled(false);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 190, 140, 190));

        jButton28.setContentAreaFilled(false);
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 190, 140, 190));

        jButton29.setContentAreaFilled(false);
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 190, 140, 190));

        jButton30.setContentAreaFilled(false);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 190, 140, 190));

        callUNOButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/button_uno.png"))); // NOI18N
        callUNOButton.setBorderPainted(false);
        callUNOButton.setContentAreaFilled(false);
        callUNOButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                callUNOButtonMouseEntered(evt);
            }
        });
        callUNOButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callUNOButtonActionPerformed(evt);
            }
        });
        getContentPane().add(callUNOButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 130, 80));

        ScoreButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/score_1.png"))); // NOI18N
        ScoreButton.setContentAreaFilled(false);
        ScoreButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ScoreButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ScoreButtonMouseExited(evt);
            }
        });
        ScoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScoreButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ScoreButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/restart_1.png"))); // NOI18N
        Home.setContentAreaFilled(false);
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeMouseExited(evt);
            }
        });
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        getContentPane().add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 390, 130, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/greenBackground.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     if(cardIds1.get(0)!=null) {
          Music m = new Music();
        m.buttonClick();
	int index=0;
	String cardId=cardIds1.get(0);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
        
        
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(cardIds1.get(1)!=null) {
        Music m = new Music();
        m.buttonClick();
	int index=1;
	String cardId=cardIds1.get(1);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
       
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      if(cardIds1.get(2)!=null) {
          Music m = new Music();
        m.buttonClick();
	int index=2;
	String cardId=cardIds1.get(2);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
     
        }
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      if(cardIds1.get(3)!=null) {
          Music m = new Music();
        m.buttonClick();
	int index=3;
	String cardId=cardIds1.get(3);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
   
        }
     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(cardIds1.get(4)!=null) {
         Music m = new Music();
        m.buttonClick();
	int index=4;
	String cardId=cardIds1.get(4);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
              
        }
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        if(cardIds1.get(5)!=null) {
          Music m = new Music();
        m.buttonClick();
	int index=5;
	String cardId=cardIds1.get(5);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
      
        }
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      if(cardIds1.get(6)!=null) {
          Music m = new Music();
        m.buttonClick();
	int index=6;
	String cardId=cardIds1.get(6);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
        
        }
   
    }//GEN-LAST:event_jButton7ActionPerformed

    private void downCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downCardActionPerformed
       int c=1;
          Music m = new Music();
        m.buttonClick();
        JLabel  message =new JLabel(pids[0]+" drew a card!");
        JOptionPane.showMessageDialog(null, message);
        try {
            c=gamesingle.submitDraw(pids[0]);
        }
        catch(Exception ex) {
            java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        }

       
          this.setButtonIcons();
       
        if(c==1)
        {
            //pcturn();
        JLabel  message22 =new JLabel("PC");
        JOptionPane.showMessageDialog(null, message22);
        pcturn();
        }
        
        else if(c==0)
        {
        JLabel  message33 =new JLabel("PLAYER");
        JOptionPane.showMessageDialog(null, message33);
        }
    }//GEN-LAST:event_downCardActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        if(cardIds1.get(10)!=null) {
          Music m = new Music();
        m.buttonClick();
	int index=10;
	String cardId=cardIds1.get(10);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
        
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        if(cardIds1.get(13)!=null) {
        Music m = new Music();
        m.buttonClick();
	int index=13;
	String cardId=cardIds1.get(13);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
        
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        if(cardIds1.get(11)!=null) {
     Music m = new Music();
        m.buttonClick();
	int index=11;
	String cardId=cardIds1.get(11);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
        
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if(cardIds1.get(12)!=null) {
        Music m = new Music();
        m.buttonClick();
	int index=12;
	String cardId=cardIds1.get(12);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
        
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
      if(cardIds1.get(14)!=null) {
  Music m = new Music();
        m.buttonClick();
        int index=14;
	String cardId=cardIds1.get(14);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
        
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(cardIds1.get(7)!=null) {
       Music m = new Music();
        m.buttonClick();
	int index=7;
	String cardId=cardIds1.get(7);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
        
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if(cardIds1.get(8)!=null) {
          Music m = new Music();
        m.buttonClick();
	int index=8;
	String cardId=cardIds1.get(8);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
        
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if(cardIds1.get(9)!=null) {
         Music m = new Music();
        m.buttonClick();
	int index=9;
	String cardId=cardIds1.get(9);
        press(cardId,gamesingle,index,cardButtons1,this,topCardButton);
        
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void callUNOButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callUNOButtonActionPerformed
        uno=false;
        if (gamesingle.getPlayerHandSize(gamesingle.getCurrentPlayer())==2)
        {
             Music m = new Music();
        m.uno();
            uno=true;
        }       

    }//GEN-LAST:event_callUNOButtonActionPerformed

    private void ScoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScoreButtonActionPerformed
         Music m = new Music();
        m.buttonClick();
        new ScoreDisplay(p).setVisible(true);
    }//GEN-LAST:event_ScoreButtonActionPerformed

    private void ScoreButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScoreButtonMouseEntered
       ScoreButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/score_2.png")));
    }//GEN-LAST:event_ScoreButtonMouseEntered

    private void ScoreButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScoreButtonMouseExited
        ScoreButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/score_1.png")));
    }//GEN-LAST:event_ScoreButtonMouseExited

    private void callUNOButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_callUNOButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_callUNOButtonMouseEntered

    private void downCardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downCardMouseEntered
        downCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/card_back_alt_hover.png")));
    }//GEN-LAST:event_downCardMouseEntered

    private void downCardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downCardMouseExited
        downCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/card_back_alt.png")));
    }//GEN-LAST:event_downCardMouseExited

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
       Music m = new Music();
       m.buttonClick();
       new Menu().setVisible(true);
       dispose();
    }//GEN-LAST:event_HomeActionPerformed

    private void HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseEntered
        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/restart_2.png")));
    }//GEN-LAST:event_HomeMouseEntered

    private void HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseExited
        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/restart_1.png")));
    }//GEN-LAST:event_HomeMouseExited

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
            java.util.logging.Logger.getLogger(PcvsPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PcvsPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PcvsPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PcvsPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PcvsPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home;
    private javax.swing.JButton ScoreButton;
    private javax.swing.JButton callUNOButton;
    private javax.swing.JButton downCard;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JButton topCardButton;
    // End of variables declaration//GEN-END:variables
}
