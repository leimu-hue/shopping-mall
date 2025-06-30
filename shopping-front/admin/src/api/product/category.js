import request from '@/utils/request'

// 查询商品分类列表（扁平结构）
export function listCategory(query) {
  return request({
    url: '/mall-product/product/category/page',
    method: 'get',
    params: query
  })
}

// 获取分类数据，按照树形结构显示
export function listCategoryTree(query) {
  return request({
    url: '/mall-product/product/category/list/tree',
    method: 'get',
    params: query
  })
}

// 新增商品分类
export function addCategory(data) {
  return request({
    url: '/mall-product/product/category/add',
    method: 'post',
    data: data
  })
}

// 修改商品分类
export function updateCategory(data) {
  return request({
    url: '/mall-product/product/category/update',
    method: 'put',
    data: data
  })
}

// 删除商品分类
export function delCategory(categoryIds) {
  return request({
    url: '/mall-product/product/category/delete',
    method: 'delete',
    data: categoryIds
  })
}