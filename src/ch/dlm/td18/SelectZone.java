package ch.dlm.td18;

/**
 * @author Marc Friedli
 * 
 * JPanel qui contient un label qui affiche le dossier en cours + un boutton pour sélectionner le dossier
 * Observale qui communique avec JPanel pour lui signaler qu'il faut sélectionner un dossier
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectZone extends JPanel implements Observable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    ArrayList<Observer> observersList = new ArrayList<>(); 
    JLabel jLabel;
    JTextField jTextField;
    JButton chooseFolder;
    
    public SelectZone()
    {
        // TODO Auto-generated constructor stub
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        
        chooseFolder = new JButton("Choose Folder");
        jTextField = new JTextField();
        jLabel = new JLabel("Select Folder");
        
        chooseFolder.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                updateObserver();
                
            }
        });
        
        this.add(jLabel);
        this.add(jTextField);
        this.add(chooseFolder);
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
