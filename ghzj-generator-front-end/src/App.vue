<template>
  <div id="app">
    <el-scrollbar ref="scrollbar" style="height:100%">
      <el-tabs :class="isFixedTop && 'tabs-fixed-top'">
        <el-tab-pane></el-tab-pane>
        <el-container id = "my-container">
          <el-header id="my-header">Header</el-header>
          <el-container >
            <el-aside width="200px" id="my-aside" >
              <el-row class="tac">
                <el-col >
                  <el-menu
                    default-active="2"
                    class="el-menu-vertical-demo"
                    @open="handleOpen"
                    @close="handleClose"
                    background-color="#545c64"
                    text-color="#fff"
                    active-text-color="#ffd04b">
                    <el-submenu index="1">
                      <template slot="title">
                        <i class="el-icon-location"></i>
                        <span>导航一</span>
                      </template>
                      <el-menu-item-group>
                        <template slot="title">分组一</template>
                        <el-menu-item index="1-1">选项1</el-menu-item>
                        <el-menu-item index="1-2">选项2</el-menu-item>
                      </el-menu-item-group>
                      <el-menu-item-group title="分组2">
                        <el-menu-item index="1-3">选项3</el-menu-item>
                      </el-menu-item-group>
                      <el-submenu index="1-4">
                        <template slot="title">选项4</template>
                        <el-menu-item index="1-4-1">选项1</el-menu-item>
                      </el-submenu>
                    </el-submenu>
                    <el-menu-item index="2">
                      <i class="el-icon-menu"></i>
                      <span slot="title">导航二</span>
                    </el-menu-item>
                    <el-menu-item index="3">
                      <i class="el-icon-setting"></i>
                      <span slot="title">导航三</span>
                    </el-menu-item>
                  </el-menu>
                </el-col>
              </el-row>
            </el-aside>
            <el-main id="my-main" >
              <router-view></router-view>
            </el-main>
          </el-container>
        </el-container>
        <el-tab-pane></el-tab-pane>
      </el-tabs>
    </el-scrollbar>
  </div>
</template>

<script>

export default {
  name: 'app',
  components: {
  }
}
</script>

<style scoped>
.el-scrollbar__wrap{
  overflow-x: hidden;
}

#my-header {
  background-color: red;
}

#my-aside {
  background-color: yellow;
}

#my-main{
  background-color: green;
}
</style>
