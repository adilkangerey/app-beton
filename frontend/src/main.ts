import { createApp } from 'vue'
import './registerServiceWorker'
import router from './router'
// @ts-ignore
import {BApp} from './views/template/BuhRep.vue'

createApp(BApp).use(router).mount('#app')
