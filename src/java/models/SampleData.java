package models;

import java.awt.Color;

/**
 *
 * @author Connor
 */
public class SampleData {
    
    private int pair;
    private int i;
    private double lightness;
    private double alpha;
    private double beta;
    private double alphaP;   
    private double chroma;
    private double hue;
    private double hueMean;
    private double G;
    private double T;
    private double sL;
    private double sC;
    private double sH;
    private double rT;
    private double deltaE;
    private Color color;
    private String hexColor;

    public String getHexColor() {
        return hexColor;
    }

    public void setHexColor(String hexColor) {
        this.hexColor = hexColor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPair() {
        return pair;
    }

    public void setPair(int pair) {
        this.pair = pair;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public double getLightness() {
        return lightness;
    }

    public void setLightness(double lightness) {
        this.lightness = lightness;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getBeta() {
        return beta;
    }
    
     public double getAlphaP() {
        return alphaP;
    }

    public void setAlphaP(double alphaP) {
        this.alphaP = alphaP;
    }
    
    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getChroma() {
        return chroma;
    }

    public void setChroma(double chroma) {
        this.chroma = chroma;
    }

    public double getHue() {
        return hue;
    }

    public void setHue(double hue) {
        this.hue = hue;
    }

    public double getHueMean() {
        return hueMean;
    }

    public void setHueMean(double hueMean) {
        this.hueMean = hueMean;
    }

    public double getG() {
        return G;
    }

    public void setG(double G) {
        this.G = G;
    }

    public double getT() {
        return T;
    }

    public void setT(double T) {
        this.T = T;
    }

    public double getsL() {
        return sL;
    }

    public void setsL(double sL) {
        this.sL = sL;
    }

    public double getsC() {
        return sC;
    }

    public void setsC(double sC) {
        this.sC = sC;
    }

    public double getsH() {
        return sH;
    }

    public void setsH(double sH) {
        this.sH = sH;
    }

    public double getrT() {
        return rT;
    }

    public void setrT(double rT) {
        this.rT = rT;
    }

    public double getDeltaE() {
        return deltaE;
    }

    public void setDeltaE(double deltaE) {
        this.deltaE = deltaE;
    }
    
    
    
    
}
