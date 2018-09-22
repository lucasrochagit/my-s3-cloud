/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasrochagit.entities.business;

import com.lucasrochagit.entities.model.BucketModel;
import com.lucasrochagit.entities.model.FileModel;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class FileBusiness {

    private static FileBusiness instance;

    private FileBusiness() {

    }

    public static synchronized FileBusiness getInstance() {
        if (instance == null) {
            instance = new FileBusiness();
        }
        return instance;
    }

    public ArrayList<BucketModel>
            addFileToBucket(
                    ArrayList<BucketModel> buckets,
                    String bucketName,
                    File file) {
        for (BucketModel b : buckets) {
            if (b.getName().equals(bucketName)) {
                ArrayList<FileModel> newFiles = b.getFiles();
                FileModel newFile
                        = new FileModel(file.getName(), (int) file.length());
                newFiles.add(newFile);
                b.setFiles(newFiles);
                b.setSize((int) (b.getSize() + file.length()));
            }
        }
        return buckets;
    }

    public ArrayList<BucketModel>
            deleteFile(
                    ArrayList<BucketModel> buckets,
                    String bucketName,
                    String fileName) {
        ArrayList<FileModel> newList = null;
        FileModel file = null;
        for (BucketModel b : buckets) {
            if (b.getName().equals(bucketName)) {
                for (FileModel f : b.getFiles()) {
                    if (f.getName().equals(fileName)) {
                        newList = b.getFiles();
                        file = f;
                    }
                }      
                newList.remove(file);
                b.setFiles(newList);
            }
        }
        return buckets;
    }
}
