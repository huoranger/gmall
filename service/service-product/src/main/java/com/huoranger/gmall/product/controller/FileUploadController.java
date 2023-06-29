package com.huoranger.gmall.product.controller;

import com.huoranger.gmall.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/admin/product")
@Slf4j
public class FileUploadController {

    @Value("${fileServer.url}")
    private String fileServerUrl;

    @PostMapping("/file_upload")
    public Result fileUpload(MultipartFile file) throws Exception {
        // TODO 连不上FastDFS服务,暂时不清楚原因
        // String path = getUploadFilePath(file);
        return Result.ok(/*fileServerUrl + path*/ "https://pic1.zhimg.com/70/v2-7d338b7d2fd7da3ab92b3e27e73edec7_1440w.avis?source=172ae18b&biz_tag=Post");
    }

    // 获取上传文件的路径
    private String getUploadFilePath(MultipartFile file) throws Exception {
        String configFile = this.getClass().getResource("/tracker.conf").getFile();
        String path = "";
        if (configFile != null) {
            ClientGlobal.init(configFile);
            // 创建trackerClient
            TrackerClient trackerClient = new TrackerClient();
            // 创建trackerServer
            TrackerServer trackerServer = trackerClient.getConnection();
            // 创建storageClient
            StorageClient1 storageClient1 = new StorageClient1(trackerServer, null);
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            path = storageClient1.upload_appender_file1(file.getBytes(), extension, null);
            log.info("文件路径{}", path);
        }
        return path;
    }

}
