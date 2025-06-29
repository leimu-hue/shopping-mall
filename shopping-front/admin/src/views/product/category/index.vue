<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
            <el-form-item label="分类名称" prop="categoryName">
                <el-input v-model="queryParams.categoryName" placeholder="请输入分类名称" clearable style="width: 240px"
                    @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="状态" prop="status">
                <el-select v-model="queryParams.status" placeholder="分类状态" clearable style="width: 240px">
                    <el-option v-for="dict in statusOptions" :key="dict.value" :label="dict.label"
                        :value="dict.value" />
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
                <el-button icon="Refresh" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="Plus" @click="handleAdd">新增</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate">修改</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete">删除</el-button>
            </el-col>
        </el-row>

        <el-table v-loading="loading" :data="categoryList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column label="分类名称" align="left" prop="name" min-width="150">
            </el-table-column>
            <el-table-column label="父分类" align="center" prop="parentName" width="120">
                <template #default="scope">
                    <span v-if="scope.row.parentCid === 0" class="text-muted">顶级分类</span>
                    <span v-else>{{ scope.row.parentName || '未知' }}</span>
                </template>
            </el-table-column>
            <el-table-column label="排序" align="center" prop="sort" width="80" />
            <el-table-column label="商品数量" align="center" prop="productCount" width="80" />
            <el-table-column label="状态" align="center" prop="showStatus" width="100">
                <template #default="scope">
                    <el-tag :type="scope.row.showStatus === '0' ? 'danger' : 'success'">
                        {{ scope.row.showStatus === '0' ? '不显示' : '显示' }}
                    </el-tag>
                </template>
            </el-table-column>
            <el-table-column label="创建时间" align="center" prop="createTime" width="180">
                <template #default="scope">
                    <span>{{ formatDate(scope.row.createTime) }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="200">
                <template #default="scope">
                    <el-button link icon="Edit" @click="handleUpdate(scope.row)">修改</el-button>
                    <el-button link icon="Delete" @click="handleDelete(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <div class="pagination-container">
            <el-pagination v-show="total > 0" :total="total" v-model:current-page="queryParams.page"
                v-model:page-size="queryParams.limit" :page-sizes="[10, 20, 30, 50]"
                layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange"
                @current-change="handleCurrentChange" />
        </div>
        <!-- 添加或修改商品分类对话框 -->
        <el-dialog :title="title" v-model="open" width="600px" append-to-body>
            <el-form ref="categoryRef" :model="form" :rules="rules" label-width="100px">
                <el-form-item label="上级分类" prop="parentId">
                    <el-tree-select v-model="form.parentId" :data="categoryTreeData"
                        :props="{ value: 'catId', label: 'name', children: 'children' }" placeholder="请选择上级分类" clearable
                        check-strictly :render-after-expand="false" style="width: 100%" />
                </el-form-item>
                <el-form-item label="分类名称" prop="categoryName">
                    <el-input v-model="form.categoryName" placeholder="请输入分类名称" />
                </el-form-item>
                <el-form-item label="排序" prop="sortOrder">
                    <el-input-number v-model="form.sortOrder" controls-position="right" :min="0" style="width: 100%" />
                </el-form-item>
                <el-form-item label="状态" prop="status">
                    <el-radio-group v-model="form.status">
                        <el-radio value="0">不显示</el-radio>
                        <el-radio value="1">显示</el-radio>
                    </el-radio-group>
                </el-form-item>
            </el-form>
            <template #footer>
                <div class="dialog-footer">
                    <el-button type="primary" @click="submitForm">确 定</el-button>
                    <el-button @click="cancel">取 消</el-button>
                </div>
            </template>
        </el-dialog>
    </div>
</template>

<script setup name="category">
import { ref, reactive, onMounted, computed, watch } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { listCategory, listCategoryTree, delCategory, addCategory, updateCategory } from '@/api/product/category'

const categoryList = ref([])
const open = ref(false)
const loading = ref(false)
const showSearch = ref(true)
const ids = ref([])
const single = ref(true)
const multiple = ref(true)
const total = ref(0)
const title = ref("")
const statusOptions = ref([
    { value: '0', label: '不显示' },
    { value: '1', label: '显示' }
])

const queryParams = reactive({
    page: 1,
    limit: 10,
    categoryName: '',
    status: ''
})

const form = reactive({
    categoryId: undefined,
    categoryName: '',
    description: '',
    sortOrder: 0,
    status: '1',
    parentId: 0
})

const rules = {
    categoryName: [
        { required: true, message: "分类名称不能为空", trigger: "blur" }
    ],
    sortOrder: [
        { required: true, message: "排序不能为空", trigger: "blur" }
    ]
}

// 获取树形选择
const categoryTreeData = ref([]);

const getCategoryTreeData = () => {
    listCategoryTree().then(res => {
        categoryTreeData.value = res.data;
    }).catch(err => {
        ElMessage.error('获取分类树形数据失败, 请稍后重试')
    })
}

// 格式化日期
const formatDate = (dateStr) => {
    if (!dateStr) return ''
    const date = new Date(dateStr)
    return date.toLocaleDateString()
}

/** 查询商品分类列表 */
function getList() {
    loading.value = true
    listCategory(queryParams).then(res => {
        if (res.data) {
            categoryList.value = res.data.list;
            total.value = res.data.total;
        }
    }).catch(err => {
        ElMessage.error('获取分类列表失败:', err)
        loading.value = false
    }).finally(() => {
        loading.value = false
    })
}

// 取消按钮
function cancel() {
    open.value = false
    reset()
}

// 表单重置
function reset() {
    form.categoryId = undefined
    form.categoryName = ''
    form.description = ''
    form.sortOrder = 0
    form.status = '1'
    form.parentId = 0
}

/** 搜索按钮操作 */
function handleQuery() {
    queryParams.page = 1
    getList()
}

/** 重置按钮操作 */
function resetQuery() {
    queryParams.categoryName = ''
    queryParams.status = ''
    handleQuery()
}

// 多选框选中数据
function handleSelectionChange(selection) {
    ids.value = selection.map(item => item.categoryId)
    single.value = selection.length != 1
    multiple.value = !selection.length
}

/** 新增按钮操作 */
function handleAdd(row) {
    reset()
    if (row) {
        // 添加子分类
        form.parentId = row.categoryId
    }
    open.value = true
    title.value = row ? `添加子分类 - ${row.categoryName}` : "添加商品分类"
}

/** 修改按钮操作 */
function handleUpdate(row) {
    if (!row) {
        return;
    }
    reset()
    const categoryId = row.catId || ids.value[0]
    const category = categoryList.value.find(item => item.catId === categoryId)
    if (category) {
        Object.assign(form, {
            categoryId: category.catId,
            categoryName: category.name,
            sortOrder: category.sort,
            status: String(category.showStatus),
            parentId: category.parentCid
        })
        open.value = true
        title.value = "修改商品分类"
    }
}

/** 提交按钮 */
function submitForm() {
    if (!form.categoryName) {
        ElMessage.error('请输入分类名称')
        return
    }

    // 检查是否选择自己作为父分类
    if (form.categoryId && form.parentId === form.categoryId) {
        ElMessage.error('不能选择自己作为父分类')
        return
    }

    if (form.categoryId) {
        // 修改
        const categoryData = {
            categoryId: form.categoryId,
            categoryName: form.categoryName,
            description: form.description,
            sortOrder: form.sortOrder,
            status: form.status,
            parentId: form.parentId
        }

        updateCategory(categoryData).then(res => {
            ElMessage.success('修改成功')
            open.value = false
            getList()
        }).catch(err => {
            ElMessage.error('修改失败')
        })
    } else {
        // 新增
        const categoryData = {
            categoryName: form.categoryName,
            description: form.description,
            sortOrder: form.sortOrder,
            status: form.status,
            parentId: form.parentId
        }

        addCategory(categoryData).then(res => {
            ElMessage.success('新增成功')
            open.value = false
            getList()
        }).catch(err => {
            ElMessage.error('新增失败')
        })
    }
}

/** 删除按钮操作 */
function handleDelete(row) {
    const categoryIds = row?.catId || ids.value
    const categoryName = row?.name || '选中的分类'

    ElMessageBox.confirm(`是否确认删除商品分类"${categoryName}"？`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
    }).then(() => {
        const deleteIds = Array.isArray(categoryIds) ? categoryIds : [categoryIds]

        // 批量删除
        Promise.all(deleteIds.map(id => delCategory(id))).then(() => {
            ElMessage.success('删除成功')
            getList()
        }).catch(err => {
            ElMessage.error('删除失败')
        })
    }).catch(() => { })
}

// 分页处理
function handleSizeChange(val) {
    queryParams.limit = val
    getList()
}

function handleCurrentChange(val) {
    queryParams.page = val
    getList()
}

watch(open, (newValue) => {
    if (newValue) {
        getCategoryTreeData()
    }
})

onMounted(() => {
    getList()
})
</script>

<style scoped lang="scss">
.app-container {
    padding: 20px;
}

.mb8 {
    margin-bottom: 8px;
}

.dialog-footer {
    text-align: right;
}

.mr-2 {
    margin-right: 8px;
}

.text-muted {
    color: #909399;
}
</style>