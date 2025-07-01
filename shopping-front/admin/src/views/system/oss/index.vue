<template>
    <el-card>
        <el-form :model="form" :rules="rules" ref="formRef" label-width="120px"
            style="max-width: 500px; margin: 0 auto;">
            <el-form-item label="上传方式" prop="type">
                <el-radio-group v-model="form.type">
                    <el-radio value="local">本地存储</el-radio>
                    <el-radio value="aliYun">阿里云OSS</el-radio>
                    <el-radio value="tencentYun">腾讯云OSS</el-radio>
                </el-radio-group>
            </el-form-item>
            <template v-if="form.type === 'local'">
                <el-form-item label="本地路径" prop="localPath">
                    <el-input v-model="form.localPath" placeholder="如 D:/uploads" />
                </el-form-item>
            </template>
            <template v-if="form.type === 'aliYun'">
                <el-form-item label="Endpoint" prop="endpoint">
                    <el-input v-model="form.endpoint" placeholder="如 https://oss-cn-hangzhou.aliyuncs.com" />
                </el-form-item>
                <el-form-item label="AccessKeyId" prop="accessKeyId">
                    <el-input v-model="form.accessKeyId" />
                </el-form-item>
                <el-form-item label="AccessKeySecret" prop="accessKeySecret">
                    <el-input v-model="form.accessKeySecret" type="password" />
                </el-form-item>
                <el-form-item label="Bucket" prop="bucketName">
                    <el-input v-model="form.bucketName" />
                </el-form-item>
            </template>
            <template v-if="form.type === 'tencentYun'">
                <el-form-item label="Endpoint" prop="endpoint">
                    <el-input v-model="form.endpoint" placeholder="如 https://cos.ap-beijing.myqcloud.com" />
                </el-form-item>
                <el-form-item label="SecretId" prop="accessKeyId">
                    <el-input v-model="form.accessKeyId" />
                </el-form-item>
                <el-form-item label="SecretKey" prop="accessKeySecret">
                    <el-input v-model="form.accessKeySecret" type="password" />
                </el-form-item>
                <el-form-item label="Bucket" prop="bucketName">
                    <el-input v-model="form.bucketName" />
                </el-form-item>
            </template>
            <el-form-item>
                <el-button type="primary" :loading="saving" @click="onSave">保存</el-button>
                <el-button @click="onReset">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script setup>
import { ref, reactive, watch, onBeforeMount } from 'vue'
import { ElMessage } from 'element-plus'
import { getOssConfig, setOssConfig } from '@/api/system/oss/index'

const formRef = ref()
const form = reactive({
    type: 'local',
    localPath: '',
    endpoint: '',
    accessKeyId: '',
    accessKeySecret: '',
    bucketName: ''
})
const rules = {
    type: [{ required: true, message: '请选择上传方式', trigger: 'change' }],
    localPath: [
        {
            required: true, message: '请输入本地路径', trigger: 'blur',
            validator: (rule, value, callback) => {
                if (form.type === 'local' && !value) callback(new Error('请输入本地路径'));
                else callback();
            }
        }
    ],
    endpoint: [
        {
            required: true, message: '请输入Endpoint', trigger: 'blur',
            validator: (rule, value, callback) => {
                if ((form.type === 'aliyun' || form.type === 'tencent') && !value) callback(new Error('请输入Endpoint'));
                else callback();
            }
        }
    ],
    accessKeyId: [
        {
            required: true, message: '请输入AccessKeyId/SecretId', trigger: 'blur',
            validator: (rule, value, callback) => {
                if ((form.type === 'aliyun' || form.type === 'tencent') && !value) callback(new Error('请输入AccessKeyId/SecretId'));
                else callback();
            }
        }
    ],
    accessKeySecret: [
        {
            required: true, message: '请输入AccessKeySecret/SecretKey', trigger: 'blur',
            validator: (rule, value, callback) => {
                if ((form.type === 'aliyun' || form.type === 'tencent') && !value) callback(new Error('请输入AccessKeySecret/SecretKey'));
                else callback();
            }
        }
    ],
    bucketName: [
        {
            required: true, message: '请输入Bucket', trigger: 'blur',
            validator: (rule, value, callback) => {
                if ((form.type === 'aliyun' || form.type === 'tencent') && !value) callback(new Error('请输入Bucket'));
                else callback();
            }
        }
    ]
}
const saving = ref(false)

// 获取当前全局配置
const fetchConfig = () => {
    getOssConfig().then(res => {
        if (res.data) {
            Object.assign(form, res.data)
        }
    });
}

// 保存配置
const onSave = () => {
    formRef.value.validate((valid) => {
        if (!valid) return
        saving.value = true

        setOssConfig(form).then(res => {
            if (res.code === 200) {
                ElMessage.success('保存成功')
            } else {
                ElMessage.error('保存失败, ' + res.msg)
            }
        })
        saving.value = false
    })
}

const onReset = () => {
    fetchConfig()
}

onBeforeMount(() => {
    fetchConfig()
})
</script>

<style scoped lang="scss">
.el-card {
    margin: 40px auto;
    max-width: 600px;
}
</style>