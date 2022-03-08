package com.maple.minio.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.maple.common.exception.Assert;
import com.maple.common.result.ResponseEnum;
import com.maple.minio.core.pojo.entity.AppInfo;
import com.maple.minio.core.mapper.AppInfoMapper;
import com.maple.minio.core.pojo.entity.FileInfo;
import com.maple.minio.core.pojo.entity.dto.AppDTO;
import com.maple.minio.core.pojo.entity.dto.FileDTO;
import com.maple.minio.core.service.AppInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maple.minio.core.util.MinioUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ggq
 * @since 2022-03-08
 */
@Service
public class AppInfoServiceImpl extends ServiceImpl<AppInfoMapper, AppInfo> implements AppInfoService {

    @Override
    public boolean saveAppInfo(AppDTO appDTO) {
        AppInfo appInfo = new AppInfo();
        BeanUtil.copyProperties(appDTO,appInfo);
        int count = baseMapper.insert(appInfo);
        return count > 0;
    }
}
