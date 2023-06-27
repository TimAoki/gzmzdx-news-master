import request from '@/utils/request'

export function getAllUser(page) {
  return request({
    url: '/user/selectAll',
    method: 'get',
    params: { page }
  })
}
