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