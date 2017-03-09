package ch.dlm.td18;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MyJFrame extends JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MyJFrame()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Tue le thread lorsqu'on clique sur la croix rouge
        setTitle("File counter");
        setSize(600,300); //Donne juste les dimensions de la fenêtre, pas sa position
        setLocationRelativeTo(null); //positionne la fenêtre au centre
        
        MyMenu myMenu = new MyMenu();
        //MyPanel myPanel = new MyPanel();
        //myAnimatedPanel = new MyAnimatedPanel();
        
        this.setJMenuBar(myMenu);
        this.setLayout(new BorderLayout());
        //this.add(myMenu,BorderLayout.NORTH);
        //this.add(myButton,BorderLayout.SOUTH);
        //this.add(myAnimatedPanel, BorderLayout.CENTER);
        //this.add(myPanel, BorderLayout.NORTH);
        
        
        //setContentPane(myMenu);
        
        setVisible(true);
    }

}
