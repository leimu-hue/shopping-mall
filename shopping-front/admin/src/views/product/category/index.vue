<template>
  <div>
    <el-tree :data="data" node-key="catId" :props="defaultProps" @node-click="handleNodeClick" :expand-on-click-node="false">
        <span class="custom-tree-node" slot-scope="{ node, data }">
            <span>{{ node.label }}</span>
            <span>
            <el-button v-if="node.level <= 2"
                type="text"
                size="mini"
                @click="() => append(data)">
                Append
            </el-button>
            <el-button v-if="node.childNodes.length == 0"
                type="text"
                size="mini"
                @click="() => remove(node, data)">
                Delete
            </el-button>
            </span>
        </span>
    </el-tree>
  </div>
</template>

<script>
import { getMenuList } from "@/api/product/category/index";

export default {
  data() {
    return {
      data: [],
      defaultProps: {
        children: "children",
        label: "name",
      },
      isGetData: false,
      errorMsg: "",
    };
  },
  created() {
    this.getMenu();
  },
  methods: {
    handleNodeClick(data) {
      console.log(data);
    },
    getMenu() {
      getMenuList({}).then((response) => {
        if (response.code == 0) {
          this.isGetData = true;
          this.data = response.data;
        } else {
          this.isGetData = false;
          this.errorMsg = response.success;
        }
      });
    },
    append(data) {
        console.log(data);
        const newChild = { name: 'testtest', children: [] };
        if (!data.children) {
          this.$set(data, 'children', []);
        }
        data.children.push(newChild);
    },
    remove(node, data) {
        console.log(data)
        const parent = node.parent;
        const children = parent.data.children || parent.data;
        const index = children.findIndex(d => d.catId === data.catId);
        children.splice(index, 1);
    }
  },
};
</script>

<style></style>
