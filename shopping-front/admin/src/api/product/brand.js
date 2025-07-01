import request from '@/utils/request'

export function listBrand(query) {
  return request({
    url: '/mall-product/product/brand/page',
    method: 'get',
    params: query
  })
}

// 新增品牌
export function addBrand(data) {
  return request({
    url: '/mall-product/product/brand/add',
    method: 'post',
    data: data
  })
}

// 修改品牌
export function updateBrand(data) {
  return request({
    url: '/mall-product/product/brand/update',
    method: 'put',
    data: data
  })
}

// 删除品牌分类
export function delBrand(brandIds) {
  return request({
    url: '/mall-product/product/brand/delete',
    method: 'delete',
    data: brandIds
  })
}