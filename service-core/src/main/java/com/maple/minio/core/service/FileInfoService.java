package com.maple.minio.core.service;

import com.maple.minio.core.pojo.entity.FileInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.maple.minio.core.pojo.entity.dto.AppDTO;
import com.maple.minio.core.pojo.entity.dto.FileDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ggq
 * @since 2022-03-07
 */
public interface FileInfoService extends IService<FileInfo> {

    FileDTO uploadFile(MultipartFile file, String bucketName, String moduleName);
    AppDTO uploadApp(MultipartFile file, String bucketName, String moduleName);

    boolean removeFile(String bucketName, String fileName);

    boolean removeFiles(String bucketName, String keys);

    boolean removeBucket(String bucketName);

    String queryBucketPolicy(String bucketName);

    boolean downloadFile(HttpServletResponse httpServletResponse, String bucketName, String fileName);
}
