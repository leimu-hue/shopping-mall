<p align="center">
	<img alt="logo" src="https://oscimg.oschina.net/oscnet/up-d3d0a9303e11d522a06cd263f3079027715.png">
</p>
<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">RuoYi v3.9.0</h1>
<h4 align="center">基于SpringBoot+Vue3前后端分离的Java快速开发框架</h4>
<p align="center">
	<a href="https://gitee.com/y_project/RuoYi-Vue/stargazers"><img src="https://gitee.com/y_project/RuoYi-Vue/badge/star.svg?theme=dark"></a>
	<a href="https://gitee.com/y_project/RuoYi-Vue"><img src="https://img.shields.io/badge/RuoYi-v3.9.0-brightgreen.svg"></a>
	<a href="https://gitee.com/y_project/RuoYi-Vue/blob/master/LICENSE"><img src="https://img.shields.io/github/license/mashape/apistatus.svg"></a>
</p>

## 平台简介

* 本仓库为前端技术栈 [Vue3](https://v3.cn.vuejs.org) + [Element Plus](https://element-plus.org/zh-CN) + [Vite](https://cn.vitejs.dev) 版本。
* 配套后端代码仓库地址[RuoYi-Vue](https://gitee.com/y_project/RuoYi-Vue) 或 [RuoYi-Vue-fast](https://gitcode.com/yangzongzhuan/RuoYi-Vue-fast) 版本。
* 前端技术栈（[Vue2](https://cn.vuejs.org) + [Element](https://github.com/ElemeFE/element) + [Vue CLI](https://cli.vuejs.org/zh)），请移步[RuoYi-Vue](https://gitee.com/y_project/RuoYi-Vue/tree/master/ruoyi-ui)。
* 阿里云折扣场：[点我进入](http://aly.ruoyi.vip)，腾讯云秒杀场：[点我进入](http://txy.ruoyi.vip)&nbsp;&nbsp;

## 前端运行

```bash
# 克隆项目
git clone https://github.com/yangzongzhuan/RuoYi-Vue3.git

# 进入项目目录
cd RuoYi-Vue3

# 安装依赖
yarn --registry=https://registry.npmmirror.com

# 启动服务
yarn dev

# 构建测试环境 yarn build:stage
# 构建生产环境 yarn build:prod
# 前端访问地址 http://localhost:80
```

## 内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
16. 缓存监控：对系统的缓存信息查询，命令统计等。
17. 在线构建器：拖动表单元素生成相应的HTML代码。
18. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

## 在线体验

- admin/admin123  
- 陆陆续续收到一些打赏，为了更好的体验已用于演示服务器升级。谢谢各位小伙伴。

演示地址：http://vue.ruoyi.vip  
文档地址：http://doc.ruoyi.vip

## 演示图

<table>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/cd1f90be5f2684f4560c9519c0f2a232ee8.jpg"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/1cbcf0e6f257c7d3a063c0e3f2ff989e4b3.jpg"/></td>
    </tr>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-8074972883b5ba0622e13246738ebba237a.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-9f88719cdfca9af2e58b352a20e23d43b12.png"/></td>
    </tr>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-39bf2584ec3a529b0d5a3b70d15c9b37646.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-936ec82d1f4872e1bc980927654b6007307.png"/></td>
    </tr>
	<tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-b2d62ceb95d2dd9b3fbe157bb70d26001e9.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-d67451d308b7a79ad6819723396f7c3d77a.png"/></td>
    </tr>	 
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/5e8c387724954459291aafd5eb52b456f53.jpg"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/644e78da53c2e92a95dfda4f76e6d117c4b.jpg"/></td>
    </tr>
	<tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-8370a0d02977eebf6dbf854c8450293c937.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-49003ed83f60f633e7153609a53a2b644f7.png"/></td>
    </tr>
	<tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-d4fe726319ece268d4746602c39cffc0621.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-c195234bbcd30be6927f037a6755e6ab69c.png"/></td>
    </tr>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/b6115bc8c31de52951982e509930b20684a.jpg"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-5e4daac0bb59612c5038448acbcef235e3a.png"/></td>
    </tr>
</table>


## 若依前后端分离交流群

QQ群： [![加入QQ群](https://img.shields.io/badge/已满-937441-blue.svg)](https://jq.qq.com/?_wv=1027&k=5bVB1og) [![加入QQ群](https://img.shields.io/badge/已满-887144332-blue.svg)](https://jq.qq.com/?_wv=1027&k=5eiA4DH) [![加入QQ群](https://img.shields.io/badge/已满-180251782-blue.svg)](https://jq.qq.com/?_wv=1027&k=5AxMKlC) [![加入QQ群](https://img.shields.io/badge/已满-104180207-blue.svg)](https://jq.qq.com/?_wv=1027&k=51G72yr) [![加入QQ群](https://img.shields.io/badge/已满-186866453-blue.svg)](https://jq.qq.com/?_wv=1027&k=VvjN2nvu) [![加入QQ群](https://img.shields.io/badge/已满-201396349-blue.svg)](https://jq.qq.com/?_wv=1027&k=5vYAqA05) [![加入QQ群](https://img.shields.io/badge/已满-101456076-blue.svg)](https://jq.qq.com/?_wv=1027&k=kOIINEb5) [![加入QQ群](https://img.shields.io/badge/已满-101539465-blue.svg)](https://jq.qq.com/?_wv=1027&k=UKtX5jhs) [![加入QQ群](https://img.shields.io/badge/已满-264312783-blue.svg)](https://jq.qq.com/?_wv=1027&k=EI9an8lJ) [![加入QQ群](https://img.shields.io/badge/已满-167385320-blue.svg)](https://jq.qq.com/?_wv=1027&k=SWCtLnMz) [![加入QQ群](https://img.shields.io/badge/已满-104748341-blue.svg)](https://jq.qq.com/?_wv=1027&k=96Dkdq0k) [![加入QQ群](https://img.shields.io/badge/已满-160110482-blue.svg)](https://jq.qq.com/?_wv=1027&k=0fsNiYZt) [![加入QQ群](https://img.shields.io/badge/已满-170801498-blue.svg)](https://jq.qq.com/?_wv=1027&k=7xw4xUG1) [![加入QQ群](https://img.shields.io/badge/已满-108482800-blue.svg)](https://jq.qq.com/?_wv=1027&k=eCx8eyoJ) [![加入QQ群](https://img.shields.io/badge/已满-101046199-blue.svg)](https://jq.qq.com/?_wv=1027&k=SpyH2875) [![加入QQ群](https://img.shields.io/badge/已满-136919097-blue.svg)](https://jq.qq.com/?_wv=1027&k=tKEt51dz) [![加入QQ群](https://img.shields.io/badge/已满-143961921-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=0vBbSb0ztbBgVtn3kJS-Q4HUNYwip89G&authKey=8irq5PhutrZmWIvsUsklBxhj57l%2F1nOZqjzigkXZVoZE451GG4JHPOqW7AW6cf0T&noverify=0&group_code=143961921) [![加入QQ群](https://img.shields.io/badge/已满-174951577-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=ZFAPAbp09S2ltvwrJzp7wGlbopsc0rwi&authKey=HB2cxpxP2yspk%2Bo3WKTBfktRCccVkU26cgi5B16u0KcAYrVu7sBaE7XSEqmMdFQp&noverify=0&group_code=174951577) [![加入QQ群](https://img.shields.io/badge/已满-161281055-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=Fn2aF5IHpwsy8j6VlalNJK6qbwFLFHat&authKey=uyIT%2B97x2AXj3odyXpsSpVaPMC%2Bidw0LxG5MAtEqlrcBcWJUA%2FeS43rsF1Tg7IRJ&noverify=0&group_code=161281055) [![加入QQ群](https://img.shields.io/badge/已满-138988063-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=XIzkm_mV2xTsUtFxo63bmicYoDBA6Ifm&authKey=dDW%2F4qsmw3x9govoZY9w%2FoWAoC4wbHqGal%2BbqLzoS6VBarU8EBptIgPKN%2FviyC8j&noverify=0&group_code=138988063) [![加入QQ群](https://img.shields.io/badge/已满-151450850-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=DkugnCg68PevlycJSKSwjhFqfIgrWWwR&authKey=pR1Pa5lPIeGF%2FFtIk6d%2FGB5qFi0EdvyErtpQXULzo03zbhopBHLWcuqdpwY241R%2F&noverify=0&group_code=151450850) [![加入QQ群](https://img.shields.io/badge/已满-224622315-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=F58bgRa-Dp-rsQJThiJqIYv8t4-lWfXh&authKey=UmUs4CVG5OPA1whvsa4uSespOvyd8%2FAr9olEGaWAfdLmfKQk%2FVBp2YU3u2xXXt76&noverify=0&group_code=224622315) [![加入QQ群](https://img.shields.io/badge/已满-287842588-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=Nxb2EQ5qozWa218Wbs7zgBnjLSNk_tVT&authKey=obBKXj6SBKgrFTJZx0AqQnIYbNOvBB2kmgwWvGhzxR67RoRr84%2Bus5OadzMcdJl5&noverify=0&group_code=287842588) [![加入QQ群](https://img.shields.io/badge/已满-187944233-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=numtK1M_I4eVd2Gvg8qtbuL8JgX42qNh&authKey=giV9XWMaFZTY%2FqPlmWbkB9g3fi0Ev5CwEtT9Tgei0oUlFFCQLDp4ozWRiVIzubIm&noverify=0&group_code=187944233) [![加入QQ群](https://img.shields.io/badge/已满-228578329-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=G6r5KGCaa3pqdbUSXNIgYloyb8e0_L0D&authKey=4w8tF1eGW7%2FedWn%2FHAypQksdrML%2BDHolQSx7094Agm7Luakj9EbfPnSTxSi2T1LQ&noverify=0&group_code=228578329) [![加入QQ群](https://img.shields.io/badge/191164766-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=GsOo-OLz53J8y_9TPoO6XXSGNRTgbFxA&authKey=R7Uy%2Feq%2BZsoKNqHvRKhiXpypW7DAogoWapOawUGHokJSBIBIre2%2FoiAZeZBSLuBc&noverify=0&group_code=191164766) 点击按钮入群。

# 商品管理系统 - 前端管理界面

基于 Vue 3 + TypeScript + Element Plus 构建的商品管理系统前端界面。

## 功能特性

### 商品分类管理（扁平化设计）
- ✅ 扁平化分类列表展示
- ✅ 父分类列显示层级关系
- ✅ 分类层级缩进可视化
- ✅ 分类搜索功能
- ✅ 新增顶级分类
- ✅ 新增子分类
- ✅ 编辑商品分类
- ✅ 删除商品分类（支持单个和批量删除）
- ✅ 状态管理（显示/不显示）
- ✅ 分类排序
- ✅ 分页显示

## 技术栈

- **Vue 3** - 渐进式 JavaScript 框架
- **TypeScript** - 类型安全的 JavaScript 超集
- **Element Plus** - Vue 3 的组件库
- **Vite** - 下一代前端构建工具
- **Pinia** - Vue 的状态管理库

## 项目结构

```
src/
├── api/                    # API 接口
│   └── product/
│       └── category.js     # 商品分类 API
├── views/                  # 页面组件
│   └── product/
│       └── category/
│           └── index.vue   # 商品分类管理页面
├── utils/                  # 工具函数
└── components/             # 公共组件
```

## 快速开始

### 安装依赖
```bash
npm install
# 或
pnpm install
```

### 启动开发服务器
```bash
npm run dev
# 或
pnpm dev
```

### 构建生产版本
```bash
npm run build:prod
# 或
pnpm build:prod
```

## 商品分类管理使用说明

### 功能概述
商品分类管理模块采用扁平化设计，提供完整的分类 CRUD 操作，通过父分类列清晰展示层级关系：

1. **扁平化分类列表** - 以表格形式展示所有商品分类
2. **父分类列** - 清晰显示每个分类的上级分类
3. **层级缩进** - 通过缩进和图标显示分类层级
4. **搜索功能** - 按分类名称和状态搜索
5. **新增分类** - 支持新增顶级分类和子分类
6. **编辑分类** - 修改现有分类信息，包括父分类
7. **删除分类** - 删除不需要的分类

### 分类字段说明
- **分类ID** - 系统自动生成的唯一标识
- **分类名称** - 分类的显示名称（必填），带层级缩进和图标
- **父分类** - 显示上级分类名称，顶级分类显示"顶级分类"
- **分类描述** - 分类的详细描述
- **排序** - 分类的显示顺序（数字越小越靠前）
- **状态** - 分类状态（显示/不显示）
- **创建时间** - 分类创建的时间

### 操作说明

#### 新增顶级分类
1. 点击"新增"按钮
2. 选择"顶级分类"作为上级分类
3. 填写分类信息（分类名称为必填项）
4. 点击"确定"保存

#### 新增子分类
1. 在分类列表中点击对应分类的"添加子分类"按钮
2. 系统会自动设置父分类
3. 填写分类信息
4. 点击"确定"保存

#### 编辑分类
1. 选择要编辑的分类
2. 点击"修改"按钮
3. 修改分类信息（可以更改父分类）
4. 点击"确定"保存

#### 删除分类
1. 选择要删除的分类
2. 点击"删除"按钮
3. 确认删除操作

#### 搜索分类
1. 在搜索框中输入分类名称
2. 选择状态筛选条件
3. 点击"搜索"按钮
4. 点击"重置"清除搜索条件

### 扁平化展示效果

| 分类ID | 分类名称 | 父分类 | 描述 | 排序 | 状态 |
|--------|----------|--------|------|------|------|
| 1 | 📁 电子产品 | 顶级分类 | 各类电子产品 | 1 | 显示 |
| 11 | 📁 手机数码 | 电子产品 | 手机、平板等 | 1 | 显示 |
| 111 | 📄 智能手机 | 手机数码 | 各类智能手机 | 1 | 显示 |
| 112 | 📄 平板电脑 | 手机数码 | 各类平板电脑 | 2 | 显示 |
| 12 | 📁 电脑办公 | 电子产品 | 台式机、笔记本等 | 2 | 显示 |
| 121 | 📄 笔记本电脑 | 电脑办公 | 各类笔记本电脑 | 1 | 显示 |
| 2 | 📁 服装鞋帽 | 顶级分类 | 各类服装鞋帽 | 2 | 显示 |
| 21 | 📄 男装 | 服装鞋帽 | 男士服装 | 1 | 显示 |
| 22 | 📄 女装 | 服装鞋帽 | 女士服装 | 2 | 显示 |

## API 接口说明

### 分类管理接口
- `GET /mall-product/product/category/page` - 获取分页分类列表
- `GET /mall-product/product/category/list-with-parent` - 获取分类列表（包含父分类名称）
- `GET /mall-product/product/category/{id}` - 获取分类详情
- `POST /mall-product/product/category` - 新增分类
- `PUT /mall-product/product/category` - 修改分类
- `DELETE /mall-product/product/category/{id}` - 删除分类
- `GET /mall-product/product/category/tree-select` - 获取分类树形选择数据
- `POST /mall-product/product/category/check-name` - 检查分类名称唯一性

### 数据结构
```typescript
interface Category {
  categoryId: number;        // 分类ID
  categoryName: string;      // 分类名称
  description?: string;      // 分类描述
  parentId: number;          // 父分类ID（0表示顶级分类）
  parentName?: string;       // 父分类名称
  level: number;             // 层级深度
  sortOrder: number;         // 排序
  status: string;            // 状态（0-不显示，1-显示）
  createTime: string;        // 创建时间
}
```

## 设计优势

### 扁平化设计的优点
1. **直观清晰** - 所有分类在一张表中展示，一目了然
2. **易于操作** - 不需要展开/折叠操作，直接查看所有分类
3. **搜索友好** - 支持全局搜索，快速定位分类
4. **分页支持** - 大数据量时支持分页显示
5. **层级关系明确** - 通过父分类列和缩进清晰显示层级

### 用户体验优化
1. **图标区分** - 使用文件夹和文档图标区分有子分类和无子分类
2. **缩进显示** - 通过缩进直观显示分类层级
3. **状态标签** - 使用不同颜色的标签显示状态
4. **操作便捷** - 每行都有快捷操作按钮

## 开发说明

### 当前实现
- 使用模拟数据进行演示
- 完整的响应式数据管理
- 表单验证
- 用户友好的交互提示
- 扁平化数据结构处理

### 核心功能
1. **扁平化表格** - 使用 Element Plus 的表格组件
2. **层级显示** - 通过缩进和图标显示分类层级
3. **父分类选择** - 使用树形选择器选择父分类
4. **数据验证** - 防止选择自己作为父分类
5. **API 集成** - 完整的后端接口调用

### 集成真实 API
要集成真实的后端 API，需要：

1. 确保后端返回的数据包含 `parentName` 字段
2. 在 `src/views/product/category/index.vue` 中处理真实的 API 响应
3. 确保后端支持分页查询
4. 处理错误情况和加载状态

### 样式定制
可以通过修改 `src/views/product/category/index.vue` 中的 `<style>` 部分来自定义样式。

## 许可证

MIT License