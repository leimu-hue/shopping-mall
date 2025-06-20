import request from '@/utils/request'

// 获取路由
export const getRouters = () => {
  return request({
    url: '/mall-admin/getRouters',
    method: 'get'
  })
}