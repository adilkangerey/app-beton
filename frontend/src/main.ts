import { createApp } from 'vue'
import './registerServiceWorker'
import router from './router'
// @ts-ignore
import {App} from './views/BuhRep.js'

createApp(App).use(router).mount('#app')
