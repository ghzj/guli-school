<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="课程讲师ID" prop="teacherId">
      <el-input v-model="dataForm.teacherId" placeholder="课程讲师ID"></el-input>
    </el-form-item>
    <el-form-item label="课程专业ID" prop="subjectId">
      <el-input v-model="dataForm.subjectId" placeholder="课程专业ID"></el-input>
    </el-form-item>
    <el-form-item label="课程专业父级ID" prop="subjectParentId">
      <el-input v-model="dataForm.subjectParentId" placeholder="课程专业父级ID"></el-input>
    </el-form-item>
    <el-form-item label="课程标题" prop="title">
      <el-input v-model="dataForm.title" placeholder="课程标题"></el-input>
    </el-form-item>
    <el-form-item label="课程销售价格，设置为0则可免费观看" prop="price">
      <el-input v-model="dataForm.price" placeholder="课程销售价格，设置为0则可免费观看"></el-input>
    </el-form-item>
    <el-form-item label="总课时" prop="lessonNum">
      <el-input v-model="dataForm.lessonNum" placeholder="总课时"></el-input>
    </el-form-item>
    <el-form-item label="课程封面图片路径" prop="cover">
      <el-input v-model="dataForm.cover" placeholder="课程封面图片路径"></el-input>
    </el-form-item>
    <el-form-item label="销售数量" prop="buyCount">
      <el-input v-model="dataForm.buyCount" placeholder="销售数量"></el-input>
    </el-form-item>
    <el-form-item label="浏览数量" prop="viewCount">
      <el-input v-model="dataForm.viewCount" placeholder="浏览数量"></el-input>
    </el-form-item>
    <el-form-item label="乐观锁" prop="version">
      <el-input v-model="dataForm.version" placeholder="乐观锁"></el-input>
    </el-form-item>
    <el-form-item label="课程状态 Draft未发布  Normal已发布" prop="status">
      <el-input v-model="dataForm.status" placeholder="课程状态 Draft未发布  Normal已发布"></el-input>
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
          teacherId: '',
          subjectId: '',
          subjectParentId: '',
          title: '',
          price: '',
          lessonNum: '',
          cover: '',
          buyCount: '',
          viewCount: '',
          version: '',
          status: '',
          isDeleted: '',
          gmtCreate: '',
          gmtModified: ''
        },
        dataRule: {
          teacherId: [
            { required: true, message: '课程讲师ID不能为空', trigger: 'blur' }
          ],
          subjectId: [
            { required: true, message: '课程专业ID不能为空', trigger: 'blur' }
          ],
          subjectParentId: [
            { required: true, message: '课程专业父级ID不能为空', trigger: 'blur' }
          ],
          title: [
            { required: true, message: '课程标题不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '课程销售价格，设置为0则可免费观看不能为空', trigger: 'blur' }
          ],
          lessonNum: [
            { required: true, message: '总课时不能为空', trigger: 'blur' }
          ],
          cover: [
            { required: true, message: '课程封面图片路径不能为空', trigger: 'blur' }
          ],
          buyCount: [
            { required: true, message: '销售数量不能为空', trigger: 'blur' }
          ],
          viewCount: [
            { required: true, message: '浏览数量不能为空', trigger: 'blur' }
          ],
          version: [
            { required: true, message: '乐观锁不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '课程状态 Draft未发布  Normal已发布不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/education/course/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.teacherId = data.course.teacherId
                this.dataForm.subjectId = data.course.subjectId
                this.dataForm.subjectParentId = data.course.subjectParentId
                this.dataForm.title = data.course.title
                this.dataForm.price = data.course.price
                this.dataForm.lessonNum = data.course.lessonNum
                this.dataForm.cover = data.course.cover
                this.dataForm.buyCount = data.course.buyCount
                this.dataForm.viewCount = data.course.viewCount
                this.dataForm.version = data.course.version
                this.dataForm.status = data.course.status
                this.dataForm.isDeleted = data.course.isDeleted
                this.dataForm.gmtCreate = data.course.gmtCreate
                this.dataForm.gmtModified = data.course.gmtModified
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
              url: this.$http.adornUrl(`/education/course/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'teacherId': this.dataForm.teacherId,
                'subjectId': this.dataForm.subjectId,
                'subjectParentId': this.dataForm.subjectParentId,
                'title': this.dataForm.title,
                'price': this.dataForm.price,
                'lessonNum': this.dataForm.lessonNum,
                'cover': this.dataForm.cover,
                'buyCount': this.dataForm.buyCount,
                'viewCount': this.dataForm.viewCount,
                'version': this.dataForm.version,
                'status': this.dataForm.status,
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