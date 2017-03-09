package ch.dlm.td18;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MyJFrame extends JFrame implements Observer
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
        SelectZone selectZone = new SelectZone();
        
        this.setJMenuBar(myMenu);
        
        this.setLayout(new BorderLayout());
        this.add(selectZone,BorderLayout.NORTH);
        
        setVisible(true);
        myMenu.addObserver(this); 
        selectZone.addObserver(this); 
    }

    @Override
    public void selectFolder()
    {
        // TODO Auto-generated method stub
        System.out.println("Je suis ici !");
    }
}
