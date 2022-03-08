package com.maple.minio.core.controller.api;


import com.maple.common.result.R;
import com.maple.minio.core.pojo.entity.dto.AppDTO;
import com.maple.minio.core.pojo.entity.dto.FileDTO;
import com.maple.minio.core.service.AppInfoService;
import com.maple.minio.core.service.FileInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ggq
 * @since 2022-03-08
 */
@Api(tags = "APP管理")
@RestController
@RequestMapping("/api/appInfo")
@CrossOrigin
@Slf4j
public class AppInfoController {

    @Resource
    private AppInfoService appInfoService;

    @Resource
    private FileInfoService fileService;


    /**
     * 文件APP
     * @param file
     * @return
     */
    @ApiOperation("文件APP")
    @PostMapping("/uploadApp")
    @ResponseBody
    public R uploadApp(
            @ApiParam(value= "APP文件", required = true)
            @RequestParam("file") MultipartFile file,
            @ApiParam(value = "桶名", required = true)
            @RequestParam("bucketName") String bucketName,

            @ApiParam(value = "APP类型（0：Android 1：IOS）", required = true)
            @RequestParam("type") Integer type,
            @ApiParam(value = "是否更新（0：不更新  1：更新）", required = true)
            @RequestParam("hasUpdate") Boolean hasUpdate,
            @ApiParam(value = "是否可忽略该版本（是否强制更新）（0： 可忽略，1：不可取消）", required = true)
            @RequestParam("isIgnorable") Boolean isIgnorable,
            @ApiParam(value = "版本号", required = true)
            @RequestParam("versionCode") Integer versionCode,
            @ApiParam(value = "版本名", required = true)
            @RequestParam("versionName") String versionName,
            @ApiParam(value = "更新内容", required = true)
            @RequestParam("updateContent") String updateContent,
            @ApiParam(value = "应用包名", required = true)
            @RequestParam("packageName") String packageName) {

        AppDTO appDTO = fileService.uploadApp(file,bucketName,"app");
        if(appDTO != null){
            appDTO.setType(type);
            appDTO.setHasUpdate(hasUpdate);
            appDTO.setIsIgnorable(isIgnorable);
            appDTO.setVersionCode(versionCode);
            appDTO.setVersionName(versionName);
            appDTO.setUpdateContent(updateContent);
            appDTO.setPackageName(packageName);
            boolean result = appInfoService.saveAppInfo(appDTO);
            if(result){
                return R.ok().message("APP上传成功");
            }
        }
        return R.error().message("APP上传失败");
    }


}

