<template>
  <div>
    <el-table
      :data="tableData"
      style="width: 100%"
      :row-class-name="tableRowClassName"
    >
      <el-table-column
        prop="id"
        label="编号"
        width="180"
      />
      <el-table-column
        prop="newsId"
        label="新闻ID"
        width="180"
      />
      <el-table-column
        prop="parentId"
        label="父评论ID"
        width="180"
      />
      <el-table-column
        prop="userId"
        label="用户ID"
        width="180"
      />
      <el-table-column
        prop="content"
        label="内容"
        width="480"
      />
      <el-table-column
        prop="createTime"
        label="创建时间"
      />
    </el-table>
    <el-pagination
      v-if="isShow"
      background
      layout="prev, pager, next"
      :total="total"
      :page-size="pageSize"
      @current-change="changePage"
    />
  </div>
</template>

<style>
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>

<script>
import { getComment } from '@/api/comment'
export default {
  data() {
    return {
      total: 1,
      pageSize: 1,
      isShow: false,
      tableData: []
    }
  },
  created: function() {
    getComment().then((response) => {
      this.tableData = response.data.records
      this.total = response.data.total
      this.pageSize = response.data.size
      this.isShow = true
      // eslint-disable-next-line no-unused-vars
      var JsonData = JSON.stringify(response.data.records)
    })
  },
  mounted() {
  },
  methods: {
    tableRowClassName({ row, rowIndex }) {
      if (rowIndex === 1) {
        return 'warning-row'
      } else if (rowIndex === 3) {
        return 'success-row'
      }
      return ''
    },
    changePage(pageNum) {
      getComment(pageNum).then((response) => {
        this.tableData = response.data.records
      })
    }
  }

}
</script>
