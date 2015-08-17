package com.ilimi.taxonomy.util;

import java.io.File;
import java.net.URL;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 * arguments 
 * - operation: createStorage, uploadFiles 
 * - storageName: name of the storage 
 * - file/folder path: applicable only for uploadFiles operation
 * - region name: optional, name of the AWS region
 * 
 * @author rayulu
 * 
 */
public class AWSUploader {
    
    public static String[] uploadFile(String bucketName, String folderName, File file) throws Exception {
        AmazonS3Client s3 = new AmazonS3Client();
        Region region = Region.getRegion(Regions.AP_SOUTHEAST_1);
        s3.setRegion(region);
        String key = file.getName();
        s3.putObject(new PutObjectRequest(bucketName+"/"+folderName, key, file));
        s3.setObjectAcl(bucketName+"/"+folderName, key, CannedAccessControlList.PublicRead);
        URL url = s3.getUrl(bucketName, folderName+"/"+key);
        return new String[] {folderName+"/"+key, url.toURI().toString()};
    }
    
    public static void deleteFile(String bucketName, String key) throws Exception {
        AmazonS3 s3 = new AmazonS3Client();
        s3.deleteObject(new DeleteObjectRequest(bucketName, key));
    }
}
