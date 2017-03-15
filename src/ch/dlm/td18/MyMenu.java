package ch.dlm.td18;

/** 
 * @author Marc Friedli
 * 
 * JMenuBar. Possède 2 menus : file et about et 3 actions : open, quit et about
 * Observable pour communiquer avec MyJFrame lorsqu'on lance l'action open
 */

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MyMenu extends JMenuBar implements Observable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    ArrayList<Observer> observersList = new ArrayList<>(); 

    MyMenu(){        
        //JMenu
        JMenu file = new JMenu();
        file.setText("File");
        JMenu about = new JMenu();
        about.setText("About");
        
        //JMenuItems
        JMenuItem open = new JMenuItem("Open");
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem help = new JMenuItem("About");
        
        //Action
        quit.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });
        //Raccourci clavier
        quit.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));  
        
        open.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateObserver();
            }
        });
        open.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
        
        help.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                System.out.println("TD 18 by Marc Friedli");
            }
        });
        help.setAccelerator(KeyStroke.getKeyStroke('H', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
        
        //Ajout des actions aux menus
        file.add(open);
        file.add(quit);
        about.add(help);
        
        //Ajouts des menus au JmenuBar
        this.add(file);
        this.add(about);
    }

    @Override
    public void addObserver(Observer observer)
    {
        // TODO Auto-generated method stub
        observersList.add(observer);
        
    }

    @Override
    public void updateObserver()
    {
        // TODO Auto-generated method stub
        for(Observer obs : observersList)
        {
            obs.selectFolder();
        }
        
    }

    @Override
    public void updateObserver(int i)
    {
        // TODO Auto-generated method stub
        
    }
}
