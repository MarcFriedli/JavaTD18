package ch.dlm.td18;


/**
 * @author Marc Friedli
 * 
 * classe qui compte le nombre de dossiers du répertoire donné
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingWorker;

public class MySwingWorker implements Observable
{  
    private File file;
    public File getFile()
    {
        return file;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    ArrayList<Observer> observersList = new ArrayList<>();
    int fileCount;
    
    public MySwingWorker()
    {
        // TODO Auto-generated constructor stub
    }
    
    void work()
    {
        SwingWorker<String, Integer> swingWorker = new SwingWorker<String, Integer>()
        {

            @Override
            protected void done()
            {
                // TODO Auto-generated method stub
                System.out.println("Done");
            }
            @Override
            protected void process(List<Integer> chunks)
            {
                for(Integer jInteger : chunks){
                    updateObserver((int)jInteger);
                }
            }

            @Override
            protected String doInBackground() throws Exception
            {
                File[] fileTab = file.listFiles();
                fileCount = 0;
                for (int i = 0 ; i < fileTab.length ; i++) {
                    if (fileTab[i].isDirectory()) {
                        fileCount+=count(fileTab[i]);
                    }
                    else{
                        fileCount++;
                    }
                    publish(fileCount);
                }
                updateObserver();
                return null;
            }
            
        };
        
        swingWorker.execute();
    }
    
    void count(){
        
    }
    
    int count(File fileList){
        File[] fileTab = fileList.listFiles();
        int tempCount = 0;
        for (int i = 0 ; i < fileTab.length ; i++) {
            if (fileTab[i].isDirectory()) {
                tempCount+=count(fileTab[i]);
            }
            else{
                tempCount++;
            }
        }
        return tempCount;
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
            obs.showAnswer(fileCount);
        }
        
    }

    @Override
    public void updateObserver(int i)
    {
        // TODO Auto-generated method stub
        for(Observer obs : observersList)
        {
            obs.showAnswer(i);
        } 
    }

}
