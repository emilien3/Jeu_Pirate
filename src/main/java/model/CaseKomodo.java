/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laura
 */
public class CaseKomodo extends Cases {
    public static int CHANGEMENT = -3;
    public static int PERTEPOINTDEVIE = 3;
    public static int GAGNER = 8;
    public CaseKomodo(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Case komodo";
    }
}
