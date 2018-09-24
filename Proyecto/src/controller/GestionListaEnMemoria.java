/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Armak;

/**
 *
 * @author aitor
 */
public class GestionListaEnMemoria {
    
 //  
    
    public static ObservableList<Armak> cargarDatos(){
        
        return FXCollections.observableArrayList(
            new Armak("Katana", "Japon", "Se refiere a un tipo particular de sable de filo único, curvado, tradicionalmente utilizado por los samuráis.", 1392),
            new Armak("Tambo", "Mundu osoa", "Palo grueso de aproximadamente 45cm", 0)
        );
    }     
    
//    public static void añadirDato(ObservableList<Person> lista, Person persona){
//        
//        lista.add(persona);
//    }      
//    
    
}
