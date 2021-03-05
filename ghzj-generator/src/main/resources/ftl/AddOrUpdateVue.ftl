<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
<#list columns as column>
<#if column.columnName != pk.columnName>
    <el-form-item label="${column.columnComment}" prop="${column.humpAttrName}">
      <el-input v-model="dataForm.${column.humpAttrName}" placeholder="${column.columnComment}"></el-input>
    </el-form-item>
</#if>
</#list>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
            <#list columns as column>
            <#if column.columnName == pk.columnName>
          ${column.humpAttrName}: 0,
            <#else >
          ${column.humpAttrName}: ''<#if column_index != columns?size - 1 >,</#if>
            </#if>
            </#list>
        },
        dataRule: {
          <#list columns as column>
          <#if column.columnName != pk.columnName>
          ${column.humpAttrName}: [
            { required: true, message: '${column.columnComment}不能为空', trigger: 'blur' }
          ]<#if column_index != columns?size - 1 >,</#if>
          </#if>
          </#list>
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.${pk.humpAttrName} = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.${pk.humpAttrName}) {
            this.$http({
              url: this.$http.adornUrl(`/${moduleName}/${pathName}/info/${r"${"}this.dataForm.${pk.humpAttrName}}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                <#list columns as column>
                  <#if column.columnName != pk.columnName>
                this.dataForm.${column.humpAttrName} = data.${humpClassName}.${column.humpAttrName}
                  </#if>
                </#list>
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/${moduleName}/${pathName}/${r"${"}!this.dataForm.${pk.humpAttrName} ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                  <#list columns as column>
                  <#if column.columnName == pk.columnName>
                ${r"'"}${column.humpAttrName}': this.dataForm.${column.humpAttrName} || undefined,
                  <#else >
                ${r"'"}${column.humpAttrName}': this.dataForm.${column.humpAttrName}<#if column_index != columns?size - 1 >,</#if>
                  </#if>
                  </#list>
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>