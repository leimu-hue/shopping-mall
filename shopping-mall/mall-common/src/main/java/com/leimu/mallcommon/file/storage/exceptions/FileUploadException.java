package com.leimu.mallcommon.file.storage.exceptions;

public class FileUploadException extends RuntimeException {
    /**
     * 构造上传异常
     *
     * @param message 异常消息
     */
    public FileUploadException(String message) {
        super(message);
    }

    /**
     * 构造上传异常
     *
     * @param message 异常消息
     * @param cause   原始异常
     */
    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }
}
