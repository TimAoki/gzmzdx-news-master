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
        prop="username"
        label="用户名"
        width="180"
      />
      <el-table-column
        prop="age"
        label="年龄"
        width="180"
      />
      <el-table-column
        prop="address"
        label="地址"
        width="480"
      />
      <el-table-column
        prop="email"
        label="电子邮箱"
      />
      <el-table-column
        prop="moblephone"
        label="手机号码"
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
import { getAllUser } from '@/api/information-management'
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
    getAllUser().then((response) => {
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
    changePage(page) {
      getAllUser(page).then((response) => {
        this.tableData = response.data.records
      })
    }
  }

}
</script>
