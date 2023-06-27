import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/gzmzdx-news-web/table/list',
    method: 'get',
    params
  })
}
