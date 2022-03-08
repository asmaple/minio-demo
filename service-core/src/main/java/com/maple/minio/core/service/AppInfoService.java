package com.maple.minio.core.service;

import com.maple.minio.core.pojo.entity.AppInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.maple.minio.core.pojo.entity.dto.AppDTO;
import com.maple.minio.core.pojo.entity.dto.FileDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ggq
 * @since 2022-03-08
 */
public interface AppInfoService extends IService<AppInfo> {

    boolean saveAppInfo(AppDTO appDTO);
}
