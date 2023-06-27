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
        prop="title"
        label="标题"
        width="180"
      />
      <el-table-column
        prop="category_id"
        label="所属分类"
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
      <el-table-column
        prop="updateTime"
        label="更新时间"
      />
      <el-table-column
        prop="browseCount"
        label="浏览数"
      />
      <el-table-column
        prop="author"
        label="作者"
      />
      <el-table-column
        prop="status"
        label="状态"
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
import { getNews } from '@/api/news-list'
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
    getNews().then((response) => {
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
      getNews(pageNum).then((response) => {
        this.tableData = response.data.records
      })
    }
  }

}
</script>
