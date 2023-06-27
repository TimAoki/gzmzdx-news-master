import request from '@/utils/request'

export function getComment(pageNum) {
  return request({
    url: '/comment',
    method: 'get',
    params: { pageNum }
  })
}
