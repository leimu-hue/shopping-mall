package com.leimu.mallcommon.file.storage.show;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UploadResult {

    private boolean success;

    private String fileUrl;

    private String fileName;

    private String errorMessage;

    public UploadResult(boolean success, String fileUrl, String fileName) {
        this.success = success;
        this.fileUrl = fileUrl;
        this.fileName = fileName;
    }

    public UploadResult(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

}
