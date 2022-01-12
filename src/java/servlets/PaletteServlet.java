package servlets;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.SampleData;
import services.ColorService;
import utilites.DBUtil;

/**
 *
 * @author Connor
 */
public class PaletteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {
        HttpSession session = request.getSession();    
        DBUtil dbUtil = new DBUtil();         
        String dataset[][] = dbUtil.getData(getServletContext().getRealPath("/resources/ciede2000data.csv")); // retrieve
        ArrayList<SampleData> sampleData = new ArrayList();
        ArrayList<Color> colorList = new ArrayList();
        ColorService CS = new ColorService();
        
        double lab[]= {0,0,0},lab2[] = {0,0,0};
        int RGB[];
        int x = 0;
        int lineSize = 68;
       
        for(int y = 0; y < lineSize; y++) {
            SampleData data = new SampleData();
            
            //this is jank, works but looks like shit --TODO streams?
            data.setPair(Integer.valueOf(dataset[x][y]));
            data.setI(Integer.valueOf(dataset[++x][y]));
            data.setLightness(Double.valueOf(dataset[++x][y]));
            data.setAlpha(Double.valueOf(dataset[++x][y]));
            data.setBeta(Double.valueOf(dataset[++x][y]));
            data.setChroma(Double.valueOf(dataset[++x][y]));
            data.setAlphaP(Double.valueOf(dataset[++x][y]));
            data.setHue(Double.valueOf(dataset[++x][y]));
            data.setHueMean(Double.valueOf(dataset[++x][y]));
            data.setG(Double.valueOf(dataset[++x][y]));
            data.setT(Double.valueOf(dataset[++x][y]));
            data.setsL(Double.valueOf(dataset[++x][y]));
            data.setsC(Double.valueOf(dataset[++x][y]));
            data.setsH(Double.valueOf(dataset[++x][y]));
            data.setrT(Double.valueOf(dataset[++x][y]));
            data.setDeltaE(Double.valueOf(dataset[++x][y]));
            x = 0;
           
            if(y%2 == 1){
                
                lab[0] = sampleData.get(sampleData.size()-1).getLightness();
                lab[1] = sampleData.get(sampleData.size()-1).getAlpha();
                lab[2] = sampleData.get(sampleData.size()-1).getBeta();
                
                lab2[0] = data.getLightness();
                lab2[1] = data.getAlpha();
                lab2[2] = data.getBeta();
                
              
                
                data.setDeltaE(CS.deltaENew(lab, lab2));
                
            }
            
            lab[0] = data.getLightness();
            lab[1] = data.getAlpha();
            lab[2] = data.getBeta();
            
            RGB = CS.labToRGB(lab);
            
            Color col = new Color(RGB[0],RGB[1],RGB[2]);            
            data.setColor(col);
            data.setHexColor(String.format("#%02x%02x%02x", RGB[0], RGB[1], RGB[2]));            
            sampleData.add(data);  
            
           
            
            
        } 
        
        request.setAttribute("sampleData", sampleData);
        
        getServletContext().getRequestDispatcher("/WEB-INF/palette.jsp").forward(request, response); 
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/palette.jsp").forward(request, response); 
    }

  

}
