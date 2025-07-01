<template>
  <div class="app-container">
    <!-- 搜索栏 -->
    <el-form :inline="true" :model="searchForm" class="mb8" label-width="68px" v-show="showSearch">
      <el-form-item label="品牌名">
        <el-input v-model="queryParams.brandName" placeholder="请输入品牌名" clearable style="width: 240px"
          @keyup.enter="handleSearch" />
      </el-form-item>
      <el-form-item label="首字母">
        <el-input v-model="queryParams.firstLetter" placeholder="请输入首字母" maxlength="1" clearable style="width: 240px"
          @keyup.enter="handleSearch" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleSearch">搜索</el-button>
        <el-button icon="Refresh" @click="resetSearch">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="Plus" @click="openDialog('add')">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="Delete" :disabled="!multipleSelection.length"
          @click="handleBatchDelete">删除</el-button>
      </el-col>
    </el-row>

    <!-- 品牌表格 -->
    <el-table :data="tableData" v-loading="loading" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column prop="name" label="品牌名" min-width="150" align="left" />
      <el-table-column prop="logo" label="品牌Logo" width="120" align="center">
        <template #default="scope">
          <el-image v-if="scope.row.logo" :src="scope.row.logo" :alt="scope.row.name"
            style="width: 40px; height: 40px; object-fit: contain;" />
          <span v-else class="text-muted">无</span>
        </template>
      </el-table-column>
      <el-table-column prop="descript" label="介绍" min-width="200" align="left">
        <template #default="scope">
          {{ scope.row.descript || "暂无介绍" }}
        </template>
      </el-table-column>
      <el-table-column prop="showStatus" label="显示状态" width="100" align="center">
        <template #default="scope">
          <el-tag :type="scope.row.showStatus === 1 ? 'success' : 'danger'">
            {{ scope.row.showStatus === 1 ? '显示' : '不显示' }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="firstLetter" label="首字母" width="80" align="center" />
      <el-table-column prop="sort" label="排序" width="80" align="center" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="160">
        <template #default="scope">
          <el-button link icon="Edit" @click="openDialog('edit', scope.row)">修改</el-button>
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

    <!-- 新增/编辑弹窗 -->
    <el-dialog :title="dialogMode === 'add' ? '新增品牌' : '编辑品牌'" v-model="dialogVisible" width="600px" append-to-body>
      <el-form :model="form" :rules="rules" ref="formRef" label-width="100px">
        <el-form-item label="品牌名" prop="name">
          <el-input v-model="form.name" />
        </el-form-item>
        <el-form-item label="Logo" prop="logo">
          <ImageUpload v-model="form.logo" :limit="1" :file-size="2" :file-type="['png', 'jpg', 'jpeg']" />
        </el-form-item>
        <el-form-item label="介绍" prop="descript">
          <el-input v-model="form.descript" type="textarea" />
        </el-form-item>
        <el-form-item label="显示状态" prop="showStatus">
          <el-radio-group v-model="form.showStatus">
            <el-radio :value="1">显示</el-radio>
            <el-radio :value="0">不显示</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="首字母" prop="firstLetter">
          <el-input v-model="form.firstLetter" maxlength="1" />
        </el-form-item>
        <el-form-item label="排序" prop="sort">
          <el-input-number v-model="form.sort" :min="0" style="width: 100%" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="handleSubmit">确 定</el-button>
          <el-button @click="dialogVisible = false">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, reactive, nextTick, onMounted } from 'vue'
import { ElMessageBox, ElMessage } from 'element-plus'
import ImageUpload from '@/components/ImageUpload/index.vue'
import { listBrand, delBrand, addBrand, updateBrand } from '@/api/product/brand'

const showSearch = ref(true)
const loading = ref(false)
const total = ref(0)

// 页面信息
const queryParams = reactive({
  page: 1,
  limit: 10,
  brandName: '',
  firstLetter: ''
})
// 搜索表单
const searchForm = reactive({
  brandName: '',
  firstLetter: ''
})

// 品牌数据
const tableData = ref()

function handleSearch() {
  queryParams.page = 1
  getList()
}

function resetSearch() {
  queryParams.brandName = ''
  queryParams.firstLetter = ''
  queryParams.page = 1
  getList()
}

// 多选
const multipleSelection = ref([])
function handleSelectionChange(val) {
  multipleSelection.value = val
}

// 弹窗表单
const dialogVisible = ref(false)
const dialogMode = ref('add') // add/edit
const formRef = ref()
const form = reactive({
  brandId: null,
  name: '',
  logo: '',
  descript: '',
  showStatus: 1,
  firstLetter: '',
  sort: 0
})

const rules = {
  name: [{ required: true, message: '请输入品牌名', trigger: 'blur' }],
  logo: [{ required: true, message: '请上传品牌Logo', trigger: 'change' }],
  firstLetter: [{ required: true, message: '请输入首字母', trigger: 'blur' }],
  sort: [{ required: true, message: '请输入排序', trigger: 'blur' }]
}

function openDialog(mode, row) {
  dialogMode.value = mode
  dialogVisible.value = true
  nextTick(() => {
    if (formRef.value) formRef.value.clearValidate()
  })
  if (mode === 'edit' && row) {
    Object.assign(form, row)
  } else {
    Object.assign(form, {
      brandId: null,
      name: '',
      logo: '',
      descript: '',
      showStatus: 1,
      firstLetter: '',
      sort: 0
    })
  }
}

function handleSubmit() {
  formRef.value.validate(valid => {
    if (!valid) return
    if (form.logo) {
      form.logo = import.meta.env.VITE_APP_BASE_API + form.logo;
    }
    if (dialogMode.value === 'add') {
      addBrand(form).then((res) => {
        if (res.code == 0) {
          ElMessage.success('新增成功')
          getList();
        } else {
          ElMessage.error("新增失败: " + res.msg);
        }
      })
    } else {
      updateBrand(form).then((res) => {
        if (res.code == 0) {
          ElMessage.success('修改成功')
          getList();
        } else {
          ElMessage.error("修改失败: " + res.msg);
        }
      })
    }
    dialogVisible.value = false
  })
}

// 删除
function handleDelete(row) {
  ElMessageBox.confirm('确定要删除该品牌吗？', '提示', { type: 'warning' })
    .then(() => {
      const ids = [row.brandId];
      delBrand(ids).then((res) => {
        if (res.code == 0) {
          ElMessage.success('删除成功')
          getList();
        } else {
          ElMessage.error("删除失败")
        }
      })
      handleSearch();
    })
    .catch(() => { })
}

function handleBatchDelete() {
  if (!multipleSelection.value.length) return
  console.log("multipleSelection", multipleSelection)
  ElMessageBox.confirm('确定要删除选中的品牌吗？', '提示', { type: 'warning' })
    .then(() => {
      const ids = multipleSelection.value.map(i => i.brandId);
      delBrand(ids).then((res) => {
        if (res.code == 0) {
          ElMessage.success('批量删除成功')
          getList();
        } else {
          ElMessage.error("批量删除失败")
        }
      })
      multipleSelection.value = []
      handleSearch();
    })
    .catch(() => { })
}

function handleSizeChange(val) {
  queryParams.limit = val
  queryParams.page = 1
  getList()
}
function handleCurrentChange(val) {
  queryParams.page = val
  getList()
}

function getList() {
  loading.value = true
  listBrand(queryParams).then(res => {
    if (res.data) {
      tableData.value = res.data.list;
      total.value = res.data.total;
    }
  }).catch(err => {
    ElMessage.error('获取品牌列表失败:', err)
    loading.value = false
  }).finally(() => {
    loading.value = false
  })
}

onMounted(() => {
  getList();
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

.text-muted {
  color: #909399;
}

.pagination-container {
  margin: 20px 0 0 0;
  text-align: right;
}
</style>