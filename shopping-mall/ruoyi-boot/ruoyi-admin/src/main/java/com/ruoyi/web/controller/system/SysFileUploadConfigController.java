package com.ruoyi.web.controller.system;

import com.leimu.mallcommon.constant.ConstantRedis;
import com.leimu.mallcommon.enums.FileStorageTypeEnum;
import com.leimu.mallcommon.file.storage.config.FileStorageConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/system/fileUpload/config")
public class SysFileUploadConfigController extends BaseController {

    private final RedisCache redisCache;

    public SysFileUploadConfigController(RedisCache redisCache) {
        this.redisCache = redisCache;
    }

    @GetMapping("get")
    public AjaxResult get() {
        FileStorageConfig cacheObject = redisCache.getCacheObject(ConstantRedis.SYSTEM_OSS_CONFIG);
        if (Objects.isNull(cacheObject)) {
            cacheObject = new FileStorageConfig(FileStorageTypeEnum.LOCAL.getName());
        }
        return AjaxResult.success(cacheObject);
    }

    @PostMapping("update")
    public AjaxResult updateFileUploadConfig(@RequestBody FileStorageConfig fileStorageConfig) {
        if (StringUtils.isBlank(fileStorageConfig.getType())) {
            return AjaxResult.error("上传类型不可为空");
        }
        String verify = fileStorageConfig.verify();
        if (StringUtils.isBlank(verify)) {
            redisCache.setCacheObject(ConstantRedis.SYSTEM_OSS_CONFIG, fileStorageConfig);
            return AjaxResult.success();
        }
        return AjaxResult.error(verify);
    }

}
