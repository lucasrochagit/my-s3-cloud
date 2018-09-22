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
import java.util.List;

/**
 *
 * @author lucas
 */
public class BucketBusiness {

    private static BucketBusiness instance;

    private BucketBusiness() {

    }

    public static synchronized BucketBusiness getInstance() {
        if (instance == null) {
            instance = new BucketBusiness();
        }
        return instance;
    }

    public BucketModel getBucket(ArrayList<BucketModel> buckets, String name) {
        BucketModel result = null;
        for (BucketModel b : buckets) {
            if (b.getName().equals(name)) {
                result = b;
            }
        }
        return result;
    }

    public String[] getBucketNames(ArrayList<BucketModel> buckets) {
        List<String> result = new ArrayList<>();
        for (BucketModel b : buckets) {
            result.add(b.getName());
        }
        return result.toArray(new String[result.size()]);
    }

    public ArrayList<BucketModel> addFileToBucket
                (ArrayList<BucketModel> buckets, String bucketName, File file) {
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

    public ArrayList<BucketModel> emptyBucket
                (ArrayList<BucketModel> buckets, String bucketName) {
        for (BucketModel b : buckets) {
            if (b.getName()
                    .equals(bucketName)) {
                b.setFiles(new ArrayList<FileModel>());
                b.setSize(0);
            }
        }

        return buckets;
    }

    public ArrayList<BucketModel> deleteBucket
                (ArrayList<BucketModel> buckets, String bucketName) {
        BucketModel bucketToDelete = null;
        for (BucketModel b : buckets) {
            if (b.getName().equals(bucketName)) {
                bucketToDelete = b;
            }
        }
        buckets.remove(bucketToDelete);
        return buckets;
    }

}
