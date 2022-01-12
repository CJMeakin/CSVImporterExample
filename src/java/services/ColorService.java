package services;

import java.awt.Color;
/**
 *
 * @author Connor
 */
public class ColorService {
    public int[] labToRGB(double[] lab){
        double Xr = 95.047f;
        double Yr = 100.0f;
        double Zr = 108.883f;
        
        double var_Y = ( lab[0] + 16 ) / 116;
        double var_X = lab[1] / 500 + var_Y;
        double var_Z = var_Y - lab[2] / 200;

        if ( Math.pow(var_Y,3)  > 0.008856 ) 
            var_Y = Math.pow(var_Y,3);
        else                      
            var_Y = ( var_Y - 16 / 116 ) / 7.787;
        if ( Math.pow(var_X,3)  > 0.008856 ) 
            var_X = Math.pow(var_X,3);
        else                      
            var_X = ( var_X - 16 / 116 ) / 7.787;
        if ( Math.pow(var_Z,3)  > 0.008856 ) 
            var_Z = Math.pow(var_Z,3);
        else                      
            var_Z = ( var_Z - 16 / 116 ) / 7.787;

        var_X *= Xr;
        var_Y *= Yr;
        var_Z *= Zr;
        
        
        
        var_X /= 100d;
        var_Y /= 100d;
        var_Z /= 100d;

        double var_R = var_X * 3.2406 + var_Y * -1.5372 + var_Z * -0.4986;        
        double var_G = var_X * -0.9689 + var_Y *  1.8758 + var_Z *  0.0415;
        double var_B = var_X *  0.0557 + var_Y * -0.2040 + var_Z *  1.0570;
        
        
        if ( var_R > 0.0031308 )
            var_R = 1.055 * ( Math.pow(var_R , ( 1d / 2.4d )) ) - 0.055;
        else                    
            var_R = 12.92 * var_R;
  
        
        if ( var_G > 0.0031308 ) 
            var_G = 1.055 * ( Math.pow(var_G,( 1 / 2.4 )) ) - 0.055;
        else                     
            var_G = 12.92 * var_G;
        
        if ( var_B > 0.0031308 )
            var_B = 1.055 * ( Math.pow(var_B, ( 1d / 2.4d )) ) - 0.055;
        else                    
            var_B = 12.92 * var_B;

        int[] RGB = new int[3];        
        RGB[0] = ((int)(var_R * 255)) > 0 ? ((int)(var_R * 255) > 255) ? 255: (int)(var_R * 255) : 1;
        RGB[1] = ((int)(var_G * 255)) > 0 ? ((int)(var_G * 255) > 255) ? 255: (int)(var_G * 255) : 1;
        RGB[2] = ((int)(var_B * 255)) > 0 ? ((int)(var_B * 255) > 255) ? 255: (int)(var_B * 255) : 1;
        
        
        return RGB;
    }
    public double[] rgbToLab(Color RGB) {
            double r, g, b, X, Y, Z, xr, yr, zr;

            // D65/2
            double Xr = 95.047d;
            double Yr = 100.0d;
            double Zr = 108.883d;

            // --------- RGB to XYZ ---------//

            r = RGB.getRed() / 255d;
            g = RGB.getGreen() / 255d;
            b = RGB.getBlue() / 255d;

            if (r > 0.04045) {
                    r =  Math.pow((r + 0.055d) / 1.055d, 2.4d);
            } else {
                    r = r / 12.92;
            }
            if (g > 0.04045) {
                    g = Math.pow((g + 0.055d) / 1.055d, 2.4d);
            } else {
                    g = g / 12.92d;
            }
            if (b > 0.04045) {
                    b =  Math.pow((b + 0.055d) / 1.055d, 2.4d);
            } else {
                    b = b / 12.92d;
            }
            r *= 100d;
            g *= 100d;
            b *= 100d;

            X = (0.4124d * r + 0.3576d * g + 0.1805d * b);
            Y = (0.2126d * r + 0.7152d * g + 0.0722d * b);
            Z = (0.0193d * r + 0.1192d * g + 0.9505d * b);

            // --------- XYZ to Lab --------- //

            xr = X / Xr;
            yr = Y / Yr;
            zr = Z / Zr;

            if (xr > 0.008856d) {
                    xr = Math.pow(xr, 1d / 3d);
            } else {
                    xr = ((7.787d * xr) + 16d / 116.0);
            }

            if (yr > 0.008856) {
                    yr =  Math.pow(yr, 1d / 3d);
            } else {
                    yr = ((7.787d * yr) + 16d / 116.0d);
            }

            if (zr > 0.008856d) {
                    zr =  Math.pow(zr, 1d / 3d);
            } else {
                    zr = ((7.787d * zr) + 16d / 116.0d);
            }

            double[] lab = new double[3];

            lab[0] = (116d * yr) - 16d;
            lab[1] = 500d * (xr - yr);
            lab[2] = 200d * (yr - zr);

            return lab;
    }
    public double deltaENew(double col1[], double col2[]){  
        
        double kL = 1.00;
        double kC = 1.045;
        double kH = 1.015;
        kC = 1.00;
        kH = 1.00;
        
        double xC1 = Math.sqrt((col1[1] * col1[1]) + (col1[2] * col1[2]));
        double xC2 = Math.sqrt((col2[1] * col2[1]) + (col2[2] * col2[2]));
        
        double xCX = ( xC1 + xC2 ) / 2d;
        double xGX = 0.5d * ( 1d - Math.sqrt( ( Math.pow(xCX, 7) ) / ( Math.pow(xCX, 7) + Math.pow( 25, 7 ) ) ) );
        double xNN = ( 1d + xGX ) * col1[1];
        
        xC1 = Math.sqrt( xNN * xNN + col1[2] * col1[2] );
        
        double xH1 = CieLab2Hue( xNN, col1[2] );
        
        xNN = ( 1 + xGX ) * col2[1];
        xC2 = Math.sqrt( xNN * xNN + col2[2] * col2[2] );
        
        double xH2 = CieLab2Hue( xNN, col2[2] );
       
                
        
        double xDL = col2[0] - col1[0];
        double xDC = xC2 - xC1;
        double xDH;
        
        if ( ( xC1 * xC2 ) == 0 ) {
           xDH = 0;
        }else {
           xNN = ((xH2 - xH1)); 
           if ( Math.abs( xNN ) <= 180 ) {
              xDH = xH2 - xH1;
           } else {
              if ( xNN > 180 ) xDH = xH2 - xH1 - 360d;
              else             xDH = xH2 - xH1 + 360d;
           }
        }
        
        xDH = 2d * Math.sqrt( xC1 * xC2 ) * Math.sin( Math.toRadians( xDH / 2d ) );
       
        
        double xLX = ( col1[0] + col2[0] ) / 2d;
        double xCY = ( xC1 + xC2 ) / 2d;
        double xHX;
        
        if ( ( xC1 *  xC2 ) == 0 ) {
           xHX = xH1 + xH2;
        } else {
           xNN = Math.abs((xH1 - xH2)); 
           if ( xNN >  180 ) {
              if ( ( xH2 + xH1 ) <  360 ) xHX = xH1 + xH2 + 360d;
              else                        xHX = xH1 + xH2 - 360d;
           }
           else {
              xHX = xH1 + xH2;
           }
           xHX /= 2d;
        }
        
        double xTX = 1d - 0.17 * Math.cos( Math.toRadians( xHX - 30d ) ) + 0.24
                       * Math.cos( Math.toRadians( 2d * xHX ) ) + 0.32
                       * Math.cos( Math.toRadians( 3d * xHX + 6d ) ) - 0.20
                       * Math.cos( Math.toRadians( 4d * xHX - 63d ) );
        
        double xPH = 30d * Math.exp( - ( ( xHX  - 275d ) / 25d ) * ( ( xHX  - 275d ) / 25d ) );
        double xRC = 2d * Math.sqrt( Math.pow( xCY , 7 ) / ( Math.pow(xCY, 7 ) + Math.pow( 25 , 7 ) ) );
        double xSL = 1d + ( ( 0.015 * ( ( xLX - 50d ) * ( xLX - 50d ) ) )
                 / Math.sqrt( 20d + ( ( xLX - 50d ) * ( xLX - 50d ) ) ) );

        double xSC = 1d + 0.045 * xCY;
        double xSH = 1d + 0.015 * xCY * xTX;
        double xRT = -(Math.sin( Math.toRadians( 2d * xPH ) )) * xRC;
        
        xDL = xDL / ( kL * xSL );
        xDC = xDC / ( kC * xSC );
        xDH = xDH / ( kH * xSH );

        return Math.sqrt( Math.pow(xDL, 2) + Math.pow(xDC , 2) + Math.pow(xDH , 2) + (xRT * xDC * xDH) );
        
    }    
    public double CieLab2Hue(double var_a, double var_b){
        double var_bias = 0;
        if ( var_a >= 0 && var_b == 0 ) return 0;
        if ( var_a <  0 && var_b == 0 ) return 180;
        if ( var_a == 0 && var_b >  0 ) return 90;
        if ( var_a == 0 && var_b <  0 ) return 270;
        if ( var_a >  0 && var_b >  0 ) var_bias = 0;
        if ( var_a <  0               ) var_bias = 180;
        if ( var_a >  0 && var_b <  0 ) var_bias = 360;
        return ( Math.toRadians( Math.atan( var_b / var_a ) ) + var_bias );
    }
    public double deltaE(double col1[], double col2[]){       
        
        //L, C, h
        /*
         * L = 0
         * a = 1
         * b = 2
         */

        //calculate C, as CBase and CNew

        double 
        CBase, CNew, CMean, G, 
        aPrimeBase, aPrimeNew, 
        CPrimeBase, CPrimeNew, 
        hPrimeBase, hPrimeNew, 
        dPrimeL, dPrimeC, dPrimeH,
        LMeanPrime, CMeanPrime, hMeanPrime,
        T, dT, Rc, Sl, Sc, Sh, Rt,
        E, kL, kC, kH;

        kL = 1.00;
        kC = 0.045;
        kH = 0.015;


        CBase = Math.sqrt(Math.pow(col2[1], 2) + Math.pow(col2[2], 2)); 
        CNew = Math.sqrt(Math.pow(col1[1], 2) + Math.pow(col1[2], 2)); 
        CMean = (CBase + CNew)/2.00;

        G = (1.00-(Math.sqrt(Math.pow(CMean, 7)/((Math.pow(CMean, 7)+Math.pow(25.00, 7))))))/2;

        aPrimeBase =  (1.00 + G)*col2[1];
        aPrimeNew =  (1.00 + G)*col1[1];

        CPrimeBase = Math.sqrt(Math.pow(aPrimeBase, 2) + Math.pow(col2[2],2));
        CPrimeNew = Math.sqrt(Math.pow(aPrimeNew, 2) + Math.pow(col1[2], 2));

        hPrimeBase = (col2[2] == 0 && aPrimeBase == 0) ? 0.00 : (360.00+((Math.atan2(col2[2], aPrimeBase))*180.00)/Math.PI);
        hPrimeNew = (col2[2] == 0 && aPrimeNew == 0) ? 0.00 : (180.00+((Math.atan2(col1[2], aPrimeNew))*180.00)/Math.PI);					  

        dPrimeL = col1[0] - col2[0];
        dPrimeC = CPrimeNew - CPrimeBase;

        dPrimeH = 0.00;
        if(CPrimeNew*CPrimeBase == 0) {
                dPrimeH = 0.00;
        }else if(Math.abs(hPrimeNew - hPrimeBase) <= 180){						  
                dPrimeH = hPrimeNew - hPrimeBase;
        }else if(hPrimeNew - hPrimeBase > 180){
                dPrimeH = hPrimeNew - hPrimeBase - 360.00;
        }else if(hPrimeNew - hPrimeBase < -180){
                dPrimeH = hPrimeNew - hPrimeBase + 360.00;
        }

        dPrimeH = 2.00*Math.sqrt(CPrimeBase*CPrimeNew*Math.sin(dPrimeH/2.00));

        LMeanPrime = (col2[0] + col1[0])/2.00;
        CMeanPrime = (CPrimeBase + CPrimeNew)/2.00;



        if(Math.abs(hPrimeBase-hPrimeNew) <= 180 && CPrimeBase*CPrimeNew != 0) {
                hMeanPrime = (hPrimeBase + hPrimeNew)/2.00;
        }else if(Math.abs(hPrimeBase-hPrimeNew) > 180 && hPrimeBase+hPrimeNew < 360 && CPrimeBase*CPrimeNew != 0) {
                hMeanPrime = (hPrimeBase + hPrimeNew + 360.00)/2.00;
        }else if(Math.abs(hPrimeBase-hPrimeNew) > 180 && hPrimeBase+hPrimeNew >= 360 && CPrimeBase*CPrimeNew != 0) {
                hMeanPrime = (hPrimeBase + hPrimeNew - 360.00)/2.00;
        }else{
                hMeanPrime = (hPrimeBase + hPrimeNew);
        }

        T = 1.00 
                        - 0.17 * Math.cos(hMeanPrime - (30.00*(Math.PI/180.00)))
                        + 0.24 * Math.cos(2.00 * hMeanPrime) 
                        + 0.32 * Math.cos(3.00 * hMeanPrime + (6.00*(Math.PI/180.00))) 
                        - 0.20 * Math.cos(4.00 * hMeanPrime - (63.00*(Math.PI/180.00)));

        dT = Math.pow(30.00, -(Math.pow(((hMeanPrime-275.00)/25.00),2)));
        Rc = 2.00 * Math.sqrt(Math.pow(CMeanPrime, 7)/(Math.pow(CMeanPrime, 7)+Math.pow(25.00, 7)));
        Sl = 1.00 + (0.015 *Math.pow(LMeanPrime - 50.00, 2))/Math.sqrt(20.00 + Math.pow(LMeanPrime-50.00, 2));
        Sc = 1.00 + (kC * CMeanPrime);
        Sh = 1.00 + (kH * CMeanPrime * T);
        Rt = (-Math.sin(2.00 * dT)) * Rc;

        E = Math.sqrt(Math.pow((dPrimeL/kL*Sl), 2) + Math.pow(dPrimeC/kC*Sc, 2) + Math.pow(dPrimeH/kH*Sh, 2) +(Rt * (dPrimeC/kC*Sc)*(dPrimeH/kH *Sh)));


        System.out.println("aPrimeBase " + aPrimeBase);
        System.out.println("aPrimeNew " + aPrimeNew);

        System.out.println("CPrimeBase " + CPrimeBase);
        System.out.println("CPrimeNew " + CPrimeNew);

        System.out.println("hPrimeBase " + hPrimeBase);
        System.out.println("hPrimeNew " + hPrimeNew);

        System.out.println("hMeanPrime " + hMeanPrime);
        System.out.println("G " +  G );
        System.out.println("T " + T);
        System.out.println("Sl " + Sl);
        System.out.println("Sc " + Sc);
        System.out.println("Sh " + Sh);
        System.out.println("Rt " + Rt);

        
        return E;
    }
}


