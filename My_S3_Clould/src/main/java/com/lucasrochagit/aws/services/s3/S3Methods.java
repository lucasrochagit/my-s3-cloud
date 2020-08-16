/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasrochagit.aws.services.s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.lucasrochagit.aws.credentials.Credentials;
import com.lucasrochagit.entities.model.BucketModel;
import com.lucasrochagit.entities.model.FileModel;
import com.lucasrochagit.utils.Directory;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class S3Methods {

    private static S3Methods instance;
    private AmazonS3 s3 = null;

    private S3Methods() {
        buildS3();
    }

    public static synchronized S3Methods getInstance() {
        if (instance == null) {
            instance = new S3Methods();
        }
        return instance;
    }

    private void buildS3() {
        s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(Credentials.getInstance().getCredentials())
                .withRegion("us-west-2")
                .build();
    }

    public boolean createBucket(String bucketName) {
        boolean result = false;
        try {
            if (s3.doesBucketExistV2(bucketName)) {
                return result;
            }
            s3.createBucket(bucketName);
            result = true;
        } catch (AmazonServiceException ex) {
            System.out.println("Caught an AmazonServiceException, "
                    + "which means your request made it "
                    + "to Amazon S3, but was rejected with an error"
                    + " response for some reason.");
            System.out.println("Error Message:    " + ex.getMessage());
            System.out.println("HTTP Status Code: " + ex.getStatusCode());
            System.out.println("AWS Error Code:   " + ex.getErrorCode());
            System.out.println("Error Type:       " + ex.getErrorType());
            System.out.println("Request ID:       " + ex.getRequestId());
        }
        return result;
    }

    public ArrayList<BucketModel> listBuckets() {
        ArrayList<BucketModel> buckets = new ArrayList<>();
        int cont = 0;
        for (Bucket bucket : s3.listBuckets()) {
            ArrayList<FileModel> list = listFiles(bucket.getName());
            for (FileModel f : list) {
                cont += f.getSize();
            }
            buckets.add(new BucketModel(bucket.getName(), cont, list));
            cont = 0;
        }
        return buckets;
    }

    public boolean emptyBucket(String bucketName) {
        boolean var = false;
        ObjectListing object_listing = s3.listObjects(bucketName);
        try {
            do {
                for (Iterator<?> iterator
                        = object_listing.getObjectSummaries().iterator();
                        iterator.hasNext();) {
                    S3ObjectSummary summary = (S3ObjectSummary) iterator.next();
                    s3.deleteObject(bucketName, summary.getKey());
                }
                object_listing = s3.listNextBatchOfObjects(object_listing);
            } while (object_listing.isTruncated());
            var = true;
        } catch (AmazonServiceException ex) {
            System.out.println("Caught an AmazonServiceException, "
                    + "which means your request made it "
                    + "to Amazon S3, but was rejected with an error"
                    + " response for some reason.");
            System.out.println("Error Message:    " + ex.getMessage());
            System.out.println("HTTP Status Code: " + ex.getStatusCode());
            System.out.println("AWS Error Code:   " + ex.getErrorCode());
            System.out.println("Error Type:       " + ex.getErrorType());
            System.out.println("Request ID:       " + ex.getRequestId());
        }

        return var;
    }

    public boolean deleteEmptyBucket(String bucketName) {
        boolean var = false;
        try {
            s3.deleteBucket(bucketName);
            var = true;
        } catch (AmazonServiceException ex) {
            System.out.println("Caught an AmazonServiceException,"
                    + " which means your request made it "
                    + "to Amazon S3, but was rejected with an error "
                    + "response for some reason.");
            System.out.println("Error Message:    " + ex.getMessage());
            System.out.println("HTTP Status Code: " + ex.getStatusCode());
            System.out.println("AWS Error Code:   " + ex.getErrorCode());
            System.out.println("Error Type:       " + ex.getErrorType());
            System.out.println("Request ID:       " + ex.getRequestId());
        }
        return var;
    }

    public boolean uploadFile(File archive, String bucketName, String fileName) {
        boolean var = false;
        try {
            s3.putObject(new PutObjectRequest(bucketName, fileName, archive));
            var = true;
        } catch (AmazonServiceException ex) {
            System.out.println("Caught an AmazonServiceException,"
                    + " which means your request made it "
                    + "to Amazon S3, but was rejected with an "
                    + "error response for some reason.");
            System.out.println("Error Message:    " + ex.getMessage());
            System.out.println("HTTP Status Code: " + ex.getStatusCode());
            System.out.println("AWS Error Code:   " + ex.getErrorCode());
            System.out.println("Error Type:       " + ex.getErrorType());
            System.out.println("Request ID:       " + ex.getRequestId());
        }
        return var;
    }

    public boolean downloadFile(String bucketName, String fileName) {
        boolean var = false;
        try {
            S3Object object = s3
                    .getObject(new GetObjectRequest(bucketName, fileName));
            final BufferedInputStream i
                    = new BufferedInputStream(object.getObjectContent());
            InputStream objectData = object.getObjectContent();
            Directory
                    .getInstance()
                    .createDirectories("C:\\Users\\"
                            + System.getProperty("user.name")
                            + "\\Desktop\\" + bucketName);
            Files
                    .copy(objectData,
                            new File("C:\\Users\\"
                                    + System.getProperty("user.name")
                                    + "\\Desktop\\" + bucketName
                                    + "\\" + fileName).toPath());
            objectData.close();
            var = true;
        } catch (AmazonServiceException ex) {
            System.out.println("Caught an AmazonServiceException, "
                    + "which means your request made it "
                    + "to Amazon S3, but was rejected with an error "
                    + "response for some reason.");
            System.out.println("Error Message:    " + ex.getMessage());
            System.out.println("HTTP Status Code: " + ex.getStatusCode());
            System.out.println("AWS Error Code:   " + ex.getErrorCode());
            System.out.println("Error Type:       " + ex.getErrorType());
            System.out.println("Request ID:       " + ex.getRequestId());
        } catch (IOException ex) {
            Logger
                    .getLogger(S3Methods.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return var;
    }

    public ArrayList<FileModel> listFiles(String bucketName) {
        ArrayList<FileModel> files = new ArrayList();
        ObjectListing objectListing = s3.listObjects(new ListObjectsRequest()
                .withBucketName(bucketName)
                .withPrefix(""));
        for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            files
                    .add(new FileModel(objectSummary.getKey(), (int) objectSummary.getSize()));
        }
        return files;
    }

    public boolean deleteFile(String bucketName, String fileName) {
        boolean var = false;
        try {
            s3.deleteObject(bucketName, fileName);
            var = true;
        } catch (AmazonServiceException ex) {
            System.out.println("Caught an AmazonServiceException, "
                    + "which means your request made it "
                    + "to Amazon S3, but was rejected with an error"
                    + "response for some reason.");
            System.out.println("Error Message:    " + ex.getMessage());
            System.out.println("HTTP Status Code: " + ex.getStatusCode());
            System.out.println("AWS Error Code:   " + ex.getErrorCode());
            System.out.println("Error Type:       " + ex.getErrorType());
            System.out.println("Request ID:       " + ex.getRequestId());
        }
        return var;
    }

}
