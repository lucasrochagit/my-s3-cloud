/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasrochagit.aws.credentials;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

/**
 *
 * @author lucas
 */
public class Credentials {

    private AWSStaticCredentialsProvider credentials = null;
    private String accessKeyId;
    private String secretKeyId;

    private static Credentials instance;

    private Credentials() {
    }

    public static synchronized Credentials getInstance() {
        if (instance == null) {
            instance = new Credentials();
        }
        return instance;
    }

    private void validateCredentials() {
        try {
            BasicAWSCredentials credentials
                    = new BasicAWSCredentials(accessKeyId, secretKeyId);
            this.credentials = new AWSStaticCredentialsProvider(credentials);
        } catch (Exception e) {
            throw new AmazonClientException("Error during validate credentials", e);
        }
    }

    public AWSStaticCredentialsProvider getCredentials() {
        return this.credentials;
    }

    public void setCredentials(String access, String secret) {
        if (access != null && secret != null) {
            this.accessKeyId = access;
            this.secretKeyId = secret;
            validateCredentials();
        }
    }
}
