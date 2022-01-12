package utilites;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Connor
 */
public class DBUtil {
    
    public String[][] getData(String path) throws FileNotFoundException{
        
        Scanner sc = new Scanner(new File(path));  
        sc.useDelimiter("[,\n]");        
        int lineSize = 16; // number of columns in CSV
        int rowSize = 70; //number of rowns in CSV
        
        String[][] dataset = new String[lineSize][rowSize];
        
        int x = 0, y = 0;       
        while (sc.hasNext()){
            dataset[x][y] = sc.next();            
            if(dataset[x][y].length() == 0){
                dataset[x][y] = "0.0";
              
            }            
            x++;
            if(x == lineSize){               
                x = 0;
                y++;
                
            }
        }
        
        return dataset;
    }
    
    
}
