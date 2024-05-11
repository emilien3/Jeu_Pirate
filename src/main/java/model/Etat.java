/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author PJR4505A
 */
public enum Etat {
    ESTVIVANT{
        @Override
        public String toString(){
            return "va bien";
        }
    },
    PASSETOUR{
        @Override
        public String toString(){
            return "passer son prochain tour";
        }
    },
    ESTPRISON{
        @Override
        public String toString(){
            return "est en prison";
        }
    },
    ESTPOURSUIVI{
        @Override
        public String toString(){
            return "est poursuivi";
        }
    };
}