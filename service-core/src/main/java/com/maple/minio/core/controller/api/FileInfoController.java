package com.maple.minio.core.controller.api;


import com.maple.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ggq
 * @since 2022-03-07
 */
@Api(tags = "api 文件管理")
@RestController
@RequestMapping("/api/fileInfo")
@CrossOrigin
@Slf4j
public class FileInfoController {

    @ApiOperation(value = "获取hello world")
    @GetMapping("/hello")
    public R hello() {
        return R.ok().data("content", "hello world");
    }
}

