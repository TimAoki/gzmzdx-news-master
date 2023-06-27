import request from '@/utils/request'

export function getNews(pageNum) {
  return request({
    url: '/news',
    method: 'get',
    params: { pageNum }
  })
}
