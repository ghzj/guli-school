<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="讲师姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="讲师姓名"></el-input>
    </el-form-item>
    <el-form-item label="讲师简介" prop="intro">
      <el-input v-model="dataForm.intro" placeholder="讲师简介"></el-input>
    </el-form-item>
    <el-form-item label="讲师资历,一句话说明讲师" prop="career">
      <el-input v-model="dataForm.career" placeholder="讲师资历,一句话说明讲师"></el-input>
    </el-form-item>
    <el-form-item label="头衔 1高级讲师 2首席讲师" prop="level">
      <el-input v-model="dataForm.level" placeholder="头衔 1高级讲师 2首席讲师"></el-input>
    </el-form-item>
    <el-form-item label="讲师头像" prop="avatar">
      <el-input v-model="dataForm.avatar" placeholder="讲师头像"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="sort">
      <el-input v-model="dataForm.sort" placeholder="排序"></el-input>
    </el-form-item>
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
          id: 0,
          name: '',
          intro: '',
          career: '',
          level: '',
          avatar: '',
          sort: '',
          isDeleted: '',
          gmtCreate: '',
          gmtModified: ''
        },
        dataRule: {
          name: [
            { required: true, message: '讲师姓名不能为空', trigger: 'blur' }
          ],
          intro: [
            { required: true, message: '讲师简介不能为空', trigger: 'blur' }
          ],
          career: [
            { required: true, message: '讲师资历,一句话说明讲师不能为空', trigger: 'blur' }
          ],
          level: [
            { required: true, message: '头衔 1高级讲师 2首席讲师不能为空', trigger: 'blur' }
          ],
          avatar: [
            { required: true, message: '讲师头像不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.myUrl(`/education/teacher/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.data.name
                this.dataForm.intro = data.data.intro
                this.dataForm.career = data.data.career
                this.dataForm.level = data.data.level
                this.dataForm.avatar = data.data.avatar
                this.dataForm.sort = data.data.sort
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
              url: this.$http.myUrl(`/education/teacher/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'intro': this.dataForm.intro,
                'career': this.dataForm.career,
                'level': this.dataForm.level,
                'avatar': this.dataForm.avatar,
                'sort': this.dataForm.sort
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
