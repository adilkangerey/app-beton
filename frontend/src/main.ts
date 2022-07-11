import { createApp } from 'vue'
import './registerServiceWorker'
import router from './router'
// @ts-ignore
import App from './App'
// @ts-ignore
// https://github.com/kingscode/vuetify-file-manager
import VuetifyFileManager from '@kingscode/vuetify-file-manager'

createApp(App).use(router, VuetifyFileManager).mount('#app')
export default {
  name: "App"
}
