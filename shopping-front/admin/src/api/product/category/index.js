import request from '@/utils/request'

// 查询参数列表
function getMenuList(query) {
  return request({
    url: '/mall-product/product/category/list/tree',
    method: 'get',
    params: query
  })
}

export {
    getMenuList
}