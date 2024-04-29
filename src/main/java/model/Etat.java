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
            return "le pirate va bien";
        }
    },
    PASSETOUR{
        @Override
        public String toString(){
            return "le pirate doit passer sont tour";
        }
    },
    ESTPRISON{
        @Override
        public String toString(){
            return "le pirate est en prison";
        }
    },
    ESTPOURSUIVI{
        @Override
        public String toString(){
            return "le pirate est poursuivi";
        }
    };
}
