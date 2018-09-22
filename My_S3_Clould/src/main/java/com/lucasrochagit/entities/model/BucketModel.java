/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasrochagit.entities.model;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class BucketModel {

    private String name;
    private int size;
    private ArrayList<FileModel> files;

    public BucketModel(String name, int size, ArrayList<FileModel> files) {
        this.name = name;
        this.size = size;
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<FileModel> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<FileModel> files) {
        this.files = files;
    }

}
