import { createRouter, createWebHistory } from 'vue-router'
import CrearVehiculoView from "@/views/CrearVehiculoView"
import ConsultarVehiculoView from "@/views/ConsultarVehiculoView"


const routes = [

  {
    path: '/',
    name: 'crear',
    component: CrearVehiculoView
  },
  {
    path: '/consultar',
    name: 'consultar',
    component: ConsultarVehiculoView
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
