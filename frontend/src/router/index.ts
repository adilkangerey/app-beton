import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'
// @ts-ignore
import BuhRep from '../views/template/BuhRep.vue'
import AboutView from '../views/AboutView.vue'

// @ts-ignore

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'buhrep',
    component: BuhRep
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
  // ,
  // {
  //   path: '/login',
  //   name: 'login',
  //   component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
  // }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
