import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '首页', icon: 'dashboard' }
    }]
  },

  {
    path: '/release-news',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'Form',
        component: () => import('@/views/release-news/index'),
        meta: { title: '新闻发布', icon: 'form' }
      }
    ]
  },
  {
    path: '/comment',
    component: Layout,
    children: [
      {
        path: '/comment',
        name: 'comment',
        component: () => import('@/views/comment/index'),
        meta: { title: '评论管理', icon: 'form' }
      }
    ]
  },
  {
    path: '/news-list',
    component: Layout,
    children: [
      {
        path: '/news-list',
        name: 'news-list',
        component: () => import('@/views/news-list/index'),
        meta: { title: '新闻列表', icon: 'form' }
      }
    ]
  },
  {
    path: '/search',
    component: Layout,
    children: [
      {
        path: '/search',
        name: 'search',
        component: () => import('@/views/search/index'),
        meta: { title: '新闻查找', icon: 'form' }
      }
    ]
  },
  {
    path: '/review-news',
    component: Layout,
    redirect: '/review-news/review-news',
    name: 'Nested',
    meta: {
      title: '新闻审核',
      icon: 'nested'
    },
    children: [
      {
        path: 'review-news',
        component: () => import('@/views/review-news/review-news/index'), // Parent router-view
        name: 'Menu1',
        meta: { title: '新闻审核' }
      },
      {
        path: 'edit-news',
        component: () => import('@/views/review-news/edit-news/index'),
        name: 'Menu2',
        meta: { title: '新闻修改' }
      },
      {
        path: 'audit-permissions',
        component: () => import('@/views/review-news/audit-permissions/index'),
        name: 'Menu2',
        meta: { title: '审核权限' }
      }
    ]
  },
  {
    path: '/',
    component: Layout,
    name: 'Nested',
    meta: {
      title: '信息管理',
      icon: 'nested'
    },
    children: [
      {
        path: '/users',
        component: () => import('@/views/information-management/user-management/index'), // Parent router-view
        name: 'Menu1',
        meta: { title: '用户管理' }
      },
      {
        path: 'admin-management',
        component: () => import('@/views/information-management/admin-management/index'),
        name: 'Menu2',
        meta: { title: '管理员管理' }
      }
    ]
  },

  {
    path: '/news-classification',
    component: Layout,
    redirect: '/news-classification/NMC',
    name: 'news-classification',
    meta: {
      title: '新闻分类管理',
      icon: 'nested'
    },
    children: [
      {
        path: 'NMC',
        component: () => import('@/views/news-classification/NMC/index'), // Parent router-view
        name: 'Menu1',
        meta: { title: '类别管理' }
      },
      {
        path: 'NCM',
        component: () => import('@/views/news-classification/NCM/index'),
        name: 'Menu2',
        meta: { title: '分类管理' }
      }
    ]
  },

  {
    path: 'external-link',
    component: Layout,
    children: [
      {
        path: 'https://github.com/TimAoki',
        meta: { title: '外链', icon: 'link' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
