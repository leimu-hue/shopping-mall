<template>
    <div>
        <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
    </div>
</template>

<script>
// import {getMenuList} from "@/api/product/category/index"

export default {
    data() {
        return {
        data: [],
            defaultProps: {
                children: 'children',
                label: 'label'
            }
        };
    },
    created() {
        // this.getMenu();
    },
    methods: {
        handleNodeClick(data) {
            console.log(data);
        },
        // getMenu() {
        //     getMenuList({}).then((response) => {
        //         console.log(response);
        //     })
        // }
    }
};
</script>

<style>
</style>
