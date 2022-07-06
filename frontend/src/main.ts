import { createApp } from 'vue'
import './registerServiceWorker'
import router from './router'
// @ts-ignore
import App from './views/template/BuhRep.vue'

createApp(App).use(router).mount('#app')
