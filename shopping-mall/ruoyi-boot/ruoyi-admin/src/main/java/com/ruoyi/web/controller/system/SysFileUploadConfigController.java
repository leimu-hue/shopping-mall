package com.ruoyi.web.controller.system;

import com.leimu.mallcommon.file.storage.config.FileStorageConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.service.FileUploadService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/system/fileUpload/config")
public class SysFileUploadConfigController extends BaseController {

    private final FileUploadService fileUploadService;

    public SysFileUploadConfigController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @GetMapping("get")
    public AjaxResult get() {
        FileStorageConfig cacheObject = fileUploadService.getFileStorageConfig();
        return AjaxResult.success(cacheObject);
    }

    @PostMapping("update")
    public AjaxResult updateFileUploadConfig(@RequestBody FileStorageConfig fileStorageConfig) {
        if (StringUtils.isBlank(fileStorageConfig.getType())) {
            return AjaxResult.error("上传类型不可为空");
        }
        String verify = fileStorageConfig.verify();
        if (StringUtils.isBlank(verify)) {
            fileUploadService.setFileStorageConfig(fileStorageConfig);
            return AjaxResult.success();
        }
        return AjaxResult.error(verify);
    }

}
