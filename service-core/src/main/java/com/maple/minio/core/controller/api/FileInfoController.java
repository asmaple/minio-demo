package com.maple.minio.core.controller.api;


import com.maple.common.result.R;
import com.maple.common.util.RsaUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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


    @ApiOperation(value = "测试rsa加密")
    @PostMapping("/rsaTest")
    public R rsaTest(@ApiParam(value = "参数", required = true)
                         @RequestParam("password") String password) {
        try {
            String decryptData = RsaUtils.decrypt(password, RsaUtils.getPrivateKey(RsaUtils.privateKey));
            return R.ok().data("decryptData", decryptData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error();
    }
}

