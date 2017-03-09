package ch.dlm.td18;

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
    
    public SelectZone()
    {
        // TODO Auto-generated constructor stub
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        
        JButton chooseFolder = new JButton("Choose Folder");
        JTextField samere = new JTextField();
        JLabel sonpere = new JLabel("Select Folder");
        
        chooseFolder.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                updateObserver();
                
            }
        });
        
        this.add(sonpere);
        this.add(samere);
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
    
}
