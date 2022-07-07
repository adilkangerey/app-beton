import { createApp } from 'vue'
import './registerServiceWorker'
import router from './router'
// @ts-ignore
import App from './App'

createApp(App).use(router).mount('#app')
