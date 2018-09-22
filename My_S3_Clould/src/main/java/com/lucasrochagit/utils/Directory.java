/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasrochagit.utils;

import java.io.File;

/**
 *
 * @author lucas
 */
public class Directory {
    
    private static Directory instance;
   
    private Directory(){
        
    }
    
    public static synchronized Directory getInstance(){
        if(instance == null){
            instance = new Directory();
        }
        
        return instance;
    }
    
    public  boolean createDirectory(String address){
        File directory = new File(address);
        if(!directory.exists()){
            if (directory.mkdir()) {
                return true;
            }           
        }
        return false;
    }
    
    public boolean createDirectories(String address){
        boolean var = false;
        
        File directories = new File(address);
        if(!directories.exists()){
            if (directories.mkdirs()) {
                return true;
            }           
        }
        return false;
    }
}
