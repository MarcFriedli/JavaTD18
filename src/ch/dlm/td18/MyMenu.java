package ch.dlm.td18;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
        
        file.add(open);
        file.add(quit);
        about.add(help);
        
        this.add(file);
        this.add(about);
    }
}
