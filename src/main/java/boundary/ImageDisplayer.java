/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

/**
 *
 * @author ogled
 */
public abstract class ImageDisplayer extends javax.swing.JPanel {
    
    protected boolean x2Res = false;
    protected boolean alternative = false;
    protected int baseResolution; // A initialiser dans la classe implémentant
    
    /**
     * Getter pour l'attribut x2Res.
     * @return la valeut de x2Res
     */
    public boolean isX2Res() {
        return x2Res;
    }
    
    /**
     * Getter pour l'attribut alternative
     * @return la valeut de alternative
     */
    public boolean isAlternative() {
        return alternative;
    }
    
    /**
     * Setter pour l'attribut x2Res.
     * ATTENTION : Cette fonction appelle repaint() pour mettre à jour
     * l'affichage
     * @param x2Res nouvelle valeur pour x2Res.
     */
    public void setX2Res(boolean x2Res) {
        if(x2Res == this.x2Res)
            return;
        
        this.x2Res = x2Res;
        
        // Pour l'édition dans le GUI
        firePropertyChange("x2Res", null, x2Res);
        
        // On mets à jour les images
        updateImagesFiles();
        
        // On actualise l'affichage
        repaint();
    }
    
    /**
     * Setter pour l'attribut alternative.
     * ATTENTION : Cette fonction appelle repaint() pour mettre à jour
     * l'affichage
     * @param alternative nouvelle valeur pour alternative
     */
    public void setAlternative(boolean alternative) {
        if(alternative == this.alternative)
            return;
        
        this.alternative = alternative;
        
        // Pour l'édition dans le GUI
        firePropertyChange("alternative", null, alternative);
        
        // On mets à jour les images
        updateImagesFiles();
        
        // On actualise l'affichage
        repaint(); 
    }
    
    /**
     * Renvoi une extension pour les images à utiliser en fonction des variables
     * x2res et alternative
     * @return extension du nom de fichier 
     */
    protected String getImageExtension() {
        String temp = "";
        
        if(x2Res)
            temp += String.valueOf(baseResolution * 2);
        else
            temp += String.valueOf(baseResolution);
        
        if(alternative)
            temp += "_alt";
        
        return temp + ".png";
    }
    
    /**
     * Mets à jour les fichiers images. Spécifique aux classes implémentant
     */
    protected abstract void updateImagesFiles();
}
