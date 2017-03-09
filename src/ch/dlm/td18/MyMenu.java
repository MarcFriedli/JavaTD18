package ch.dlm.td18;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MyMenu extends JMenuBar
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

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
        
        quit.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });
        quit.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));  
        
        open.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Pas encore implémenté");
                openThisFkingDialog();
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
        
        file.add(open);
        file.add(quit);
        about.add(help);
        
        this.add(file);
        this.add(about);
    }
    
    private void openThisFkingDialog(){
    JFileChooser jFileChooser = new JFileChooser();
    jFileChooser.setCurrentDirectory(new java.io.File("."));
    jFileChooser.setDialogTitle("Yolooooo");
    jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    
    if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
        System.out.println("getCurrentDirectory(): " 
           +  jFileChooser.getCurrentDirectory());
        System.out.println("getSelectedFile() : " 
           +  jFileChooser.getSelectedFile());
        }
      else {
        System.out.println("No Selection ");
        }
    }
}
