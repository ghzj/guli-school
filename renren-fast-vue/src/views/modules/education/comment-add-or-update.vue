<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="课程id" prop="courseId">
      <el-input v-model="dataForm.courseId" placeholder="课程id"></el-input>
    </el-form-item>
    <el-form-item label="讲师id" prop="teacherId">
      <el-input v-model="dataForm.teacherId" placeholder="讲师id"></el-input>
    </el-form-item>
    <el-form-item label="会员id" prop="memberId">
      <el-input v-model="dataForm.memberId" placeholder="会员id"></el-input>
    </el-form-item>
    <el-form-item label="会员昵称" prop="nickname">
      <el-input v-model="dataForm.nickname" placeholder="会员昵称"></el-input>
    </el-form-item>
    <el-form-item label="会员头像" prop="avatar">
      <el-input v-model="dataForm.avatar" placeholder="会员头像"></el-input>
    </el-form-item>
    <el-form-item label="评论内容" prop="content">
      <el-input v-model="dataForm.content" placeholder="评论内容"></el-input>
    </el-form-item>
    <el-form-item label="逻辑删除 1（true）已删除， 0（false）未删除" prop="isDeleted">
      <el-input v-model="dataForm.isDeleted" placeholder="逻辑删除 1（true）已删除， 0（false）未删除"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="gmtCreate">
      <el-input v-model="dataForm.gmtCreate" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="gmtModified">
      <el-input v-model="dataForm.gmtModified" placeholder="更新时间"></el-input>
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
          courseId: '',
          teacherId: '',
          memberId: '',
          nickname: '',
          avatar: '',
          content: '',
          isDeleted: '',
          gmtCreate: '',
          gmtModified: ''
        },
        dataRule: {
          courseId: [
            { required: true, message: '课程id不能为空', trigger: 'blur' }
          ],
          teacherId: [
            { required: true, message: '讲师id不能为空', trigger: 'blur' }
          ],
          memberId: [
            { required: true, message: '会员id不能为空', trigger: 'blur' }
          ],
          nickname: [
            { required: true, message: '会员昵称不能为空', trigger: 'blur' }
          ],
          avatar: [
            { required: true, message: '会员头像不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '评论内容不能为空', trigger: 'blur' }
          ],
          isDeleted: [
            { required: true, message: '逻辑删除 1（true）已删除， 0（false）未删除不能为空', trigger: 'blur' }
          ],
          gmtCreate: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          gmtModified: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/education/comment/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.courseId = data.comment.courseId
                this.dataForm.teacherId = data.comment.teacherId
                this.dataForm.memberId = data.comment.memberId
                this.dataForm.nickname = data.comment.nickname
                this.dataForm.avatar = data.comment.avatar
                this.dataForm.content = data.comment.content
                this.dataForm.isDeleted = data.comment.isDeleted
                this.dataForm.gmtCreate = data.comment.gmtCreate
                this.dataForm.gmtModified = data.comment.gmtModified
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
              url: this.$http.adornUrl(`/education/comment/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'courseId': this.dataForm.courseId,
                'teacherId': this.dataForm.teacherId,
                'memberId': this.dataForm.memberId,
                'nickname': this.dataForm.nickname,
                'avatar': this.dataForm.avatar,
                'content': this.dataForm.content,
                'isDeleted': this.dataForm.isDeleted,
                'gmtCreate': this.dataForm.gmtCreate,
                'gmtModified': this.dataForm.gmtModified
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