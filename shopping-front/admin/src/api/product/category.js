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

// 查询商品分类详细
export function getCategory(categoryId) {
  return request({
    url: '/mall-product/product/category/' + categoryId,
    method: 'get'
  })
}

// 新增商品分类
export function addCategory(data) {
  return request({
    url: '/mall-product/product/category',
    method: 'post',
    data: data
  })
}

// 修改商品分类
export function updateCategory(data) {
  return request({
    url: '/mall-product/product/category',
    method: 'put',
    data: data
  })
}

// 删除商品分类
export function delCategory(categoryId) {
  return request({
    url: '/mall-product/product/category/' + categoryId,
    method: 'delete'
  })
}

// 获取分类树形选择数据
export function getCategoryTreeSelect() {
  return request({
    url: '/mall-product/product/category/tree-select',
    method: 'get'
  })
}

// 检查分类名称是否唯一
export function checkCategoryNameUnique(data) {
  return request({
    url: '/mall-product/product/category/check-name',
    method: 'post',
    data: data
  })
}

// 获取分类列表（包含父分类名称）
export function listCategoryWithParent(query) {
  return request({
    url: '/mall-product/product/category/list-with-parent',
    method: 'get',
    params: query
  })
} 