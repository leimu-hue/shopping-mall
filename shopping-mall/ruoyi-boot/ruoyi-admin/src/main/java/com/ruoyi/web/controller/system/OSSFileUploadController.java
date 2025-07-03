package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.service.FileUploadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 此处实现整体文件上传逻辑
 */
@RestController
@RequestMapping("/file/upload")
public class OSSFileUploadController {

    private final FileUploadService fileUploadService;

    public OSSFileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @GetMapping("get_presigned_url_for_oss_upload")
    public AjaxResult generatePresignedUrl(@RequestParam("fileName") String fileName,
                                           @RequestParam(value = "fileType", defaultValue = "image/png") String fileType) {
        return fileUploadService.generatePresignedUrl(fileName, fileType);
    }

}
