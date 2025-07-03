import request from '@/utils/request'

export function getOssConfig() {
    return request({
        url: '/mall-admin/system/fileUpload/config/get',
        method: 'get'
    })
}

export function setOssConfig(data) {
    return request({
        url: '/mall-admin/system/fileUpload/config/update',
        method: 'post',
        data: data
    })
}

export function getGenerateSignatureUrl(fileName, fileType) {
    return request({
        url: '/mall-admin/file/upload/get_presigned_url_for_oss_upload',
        method: 'get',
        params: {
            fileName,
            fileType
        }
    })
}