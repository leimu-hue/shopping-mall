import request from '@/utils/request'

export function listBrand(query) {
  return request({
    url: '/mall-product/product/brand/page',
    method: 'get',
    params: query
  })
}