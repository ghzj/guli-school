<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="课程ID" prop="courseId">
      <el-input v-model="dataForm.courseId" placeholder="课程ID"></el-input>
    </el-form-item>
    <el-form-item label="章节ID" prop="chapterId">
      <el-input v-model="dataForm.chapterId" placeholder="章节ID"></el-input>
    </el-form-item>
    <el-form-item label="节点名称" prop="title">
      <el-input v-model="dataForm.title" placeholder="节点名称"></el-input>
    </el-form-item>
    <el-form-item label="云端视频资源" prop="videoSourceId">
      <el-input v-model="dataForm.videoSourceId" placeholder="云端视频资源"></el-input>
    </el-form-item>
    <el-form-item label="原始文件名称" prop="videoOriginalName">
      <el-input v-model="dataForm.videoOriginalName" placeholder="原始文件名称"></el-input>
    </el-form-item>
    <el-form-item label="排序字段" prop="sort">
      <el-input v-model="dataForm.sort" placeholder="排序字段"></el-input>
    </el-form-item>
    <el-form-item label="播放次数" prop="playCount">
      <el-input v-model="dataForm.playCount" placeholder="播放次数"></el-input>
    </el-form-item>
    <el-form-item label="是否可以试听：0收费 1免费" prop="isFree">
      <el-input v-model="dataForm.isFree" placeholder="是否可以试听：0收费 1免费"></el-input>
    </el-form-item>
    <el-form-item label="视频时长（秒）" prop="duration">
      <el-input v-model="dataForm.duration" placeholder="视频时长（秒）"></el-input>
    </el-form-item>
    <el-form-item label="Empty未上传 Transcoding转码中  Normal正常" prop="status">
      <el-input v-model="dataForm.status" placeholder="Empty未上传 Transcoding转码中  Normal正常"></el-input>
    </el-form-item>
    <el-form-item label="视频源文件大小（字节）" prop="size">
      <el-input v-model="dataForm.size" placeholder="视频源文件大小（字节）"></el-input>
    </el-form-item>
    <el-form-item label="乐观锁" prop="version">
      <el-input v-model="dataForm.version" placeholder="乐观锁"></el-input>
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
          chapterId: '',
          title: '',
          videoSourceId: '',
          videoOriginalName: '',
          sort: '',
          playCount: '',
          isFree: '',
          duration: '',
          status: '',
          size: '',
          version: '',
          gmtCreate: '',
          gmtModified: ''
        },
        dataRule: {
          courseId: [
            { required: true, message: '课程ID不能为空', trigger: 'blur' }
          ],
          chapterId: [
            { required: true, message: '章节ID不能为空', trigger: 'blur' }
          ],
          title: [
            { required: true, message: '节点名称不能为空', trigger: 'blur' }
          ],
          videoSourceId: [
            { required: true, message: '云端视频资源不能为空', trigger: 'blur' }
          ],
          videoOriginalName: [
            { required: true, message: '原始文件名称不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '排序字段不能为空', trigger: 'blur' }
          ],
          playCount: [
            { required: true, message: '播放次数不能为空', trigger: 'blur' }
          ],
          isFree: [
            { required: true, message: '是否可以试听：0收费 1免费不能为空', trigger: 'blur' }
          ],
          duration: [
            { required: true, message: '视频时长（秒）不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: 'Empty未上传 Transcoding转码中  Normal正常不能为空', trigger: 'blur' }
          ],
          size: [
            { required: true, message: '视频源文件大小（字节）不能为空', trigger: 'blur' }
          ],
          version: [
            { required: true, message: '乐观锁不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/education/video/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.courseId = data.video.courseId
                this.dataForm.chapterId = data.video.chapterId
                this.dataForm.title = data.video.title
                this.dataForm.videoSourceId = data.video.videoSourceId
                this.dataForm.videoOriginalName = data.video.videoOriginalName
                this.dataForm.sort = data.video.sort
                this.dataForm.playCount = data.video.playCount
                this.dataForm.isFree = data.video.isFree
                this.dataForm.duration = data.video.duration
                this.dataForm.status = data.video.status
                this.dataForm.size = data.video.size
                this.dataForm.version = data.video.version
                this.dataForm.gmtCreate = data.video.gmtCreate
                this.dataForm.gmtModified = data.video.gmtModified
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
              url: this.$http.adornUrl(`/education/video/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'courseId': this.dataForm.courseId,
                'chapterId': this.dataForm.chapterId,
                'title': this.dataForm.title,
                'videoSourceId': this.dataForm.videoSourceId,
                'videoOriginalName': this.dataForm.videoOriginalName,
                'sort': this.dataForm.sort,
                'playCount': this.dataForm.playCount,
                'isFree': this.dataForm.isFree,
                'duration': this.dataForm.duration,
                'status': this.dataForm.status,
                'size': this.dataForm.size,
                'version': this.dataForm.version,
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