<template>
  <div id="">
      <h2>Сводный отчет</h2>
        <button v-on:click="getReportFileName">НАЖМИ и ПОЛУЧИ отчет</button>
        <label >Дата начала</label> <br>
        <input class="data-" type="date" placeholder="Введите дату" min="2000.01.01" max="2099.12.12" v-model="period_d">
        <input class="data-" type="time" placeholder="Введите время" v-model="period_t"><br>

        <label id="labels">Дата окончания</label><br>
        <input class="data-" type="date" placeholder="Введите дату" min="2000.01.01" max="2099.12.12" v-model="period_dd">
        <input class="data-" type="time" placeholder="Введите время" v-model="period_tt"><br>
        <vuetify-file-manager root-name="website"
                          :get-folders="getFolders"
                          @filesDropped="uploadFiles"
                          :getFolderContent="getFolderContent"
                          @download="downloadFile"
                          @select="selectFile"
                          :createFolder="createFolder"
        > </vuetify-file-manager>
  </div>
  <div>
    <h2>Продолжение: Детальный отчёт</h2>
    <button href="#zatemnenie"><a id="open-button" href="#zatemnenie">Выбрать клиентов и пункты доставки</a></button>
    <p>Клиенты:</p>
    <p>Пункты доставки:</p>
    <button>Запросить детальный отчёт</button>
  </div>
  <div id="zatemnenie">
    <div id="okno">
      <span>Список клиентов и пунктов доставки за период: {{ period_d }} {{ period_t }} - {{ period_dd }} {{ period_tt }}</span><br>
      <button class="o_button"><a>Получить клиентов</a></button>
      <button class="o_button"><a>Получить пункты доставки</a></button><br>
      <label class="o-p" >Клиенты:</label>
      <label class="o-p">Пункты доставки</label><br>
      <a href="#" class="close">Готово</a>
    </div>
  </div>
</template>
<style>
#open-button{
  text-underline-color: #42b983;
}
.o-p{
  text-align: left;
  width: 204px;

  margin-left: 80px;
}
.o_button{
  margin-top: 30px;
  margin-right: 70px;
  width: 220px;
}
template{
  font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
}
p{
  margin-bottom: 5px;
  margin-top: 5px;
}
h2{
  font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
  margin-bottom: 15px;
  margin-top: 30px;
}
#zatemnenie {
  background: rgba(102, 102, 102, 0.5);
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
  display: none;
}
#okno {
  width: 700px;
  height: 500px;
  text-align: center;
  padding: 15px;
  border: 3px solid #0a0000;
  border-radius: 10px;
  color: #1a1a1a;
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  margin: auto;
  background: #fff;
}
#zatemnenie:target {display: block;}
.close {
  margin-left: 400px;
  margin-top: 150px;
  display: inline-block;
  border: 1px solid #090000;
  color: #1a1a1a;
  padding: 0 12px;
  text-decoration: none;
  background: #f2f2f2;
  font-size: 14pt;
  cursor:pointer;
}
.close:hover {background: #e6e6ff;}

div{
  margin-left: 10px;
  text-align: left;
}
.data- {
  min-width: 200px;
  width: 43%;
  margin-right: 40px;
}
</style>
<script>
import * as api from '@/api/api'
import axios from 'axios'
export default {
  name: 'BuhRep',
  data () {
    return {
      period_d: '',
      period_t: '',
      period_dd: '',
      period_tt: '',
      selectedDirectoryId: null,
      reportFileName: null
    }
  },
  props: {
    canSelectFile: {
      type: Boolean,
      default: true,
      required: false
    }
  },
  methods: {
    getReportFileName: async function () {
      // params to send
      // var data = $data.selectedReport.data
      // var parameters = [];
      // if(data.start){
      // parameters.push({
      //     name: "start",
      //     value: data.start.value,
      //     javaType: "java.sql.Timestamp"
      // })
      // }
      // if(data.end){
      // parameters.push({
      //     name: "end",
      //     value: data.end.value,
      //     javaType: 'java.sql.Timestamp'
      // })
      // }
      //
      // //and customer."Name" in ('') and wareh."Name" in ('')
      // var customfilter = [];
      // if(data.clients && data.clients.length > 0){
      //   var client = "'" + data.clients.join("','") + "'";
      //   customfilter.push('customer."Name" in (' + client + ')')
      // }
      // if(data.warehouses && data.warehouses.length > 0){
      //   var client = "'" + data.warehouses.join("','") + "'";
      //   customfilter.push('wareh."Name" in (' + client + ')')
      // }
      // parameters.push({
      //     name: "customfilter",
      //     value: customfilter.length != 0? ' and ' + customfilter.join(' and '): '',
      //     javaType: "java.lang.String"
      // })
      // parameters variable send
      return api.post('/barakat/report/barakatmain-fb', null, [
        {
          name: 'start',
          value: '2022-07-12T13:20:00', // todo подменить
          javaType: 'java.sql.Timestamp'
        },
        {
          name: 'end',
          value: '2022-07-12T13:20:00', // todo подменить
          javaType: 'java.sql.Timestamp'
        },
        {
          name: 'customfilter',
          value: '', // todo рализовать логику динамического sql
          javaType: 'java.lang.String'
        }
      ]).then(data => {
        console.log('Пришло название файла ' + data) // todo теперь нужно название файла дернуть
        this.reportFileName = data
      })
    },
    getFolders () {
      return new Promise(resolve => {
        this.$http.get('url_to_get_the_folders').then((response) => {
          resolve(response.data.data)
        })
      })
    },
    getFolderContent (directoryId) {
      return new Promise(resolve => {
        this.selectedDirectoryId = null
        this.$http.get('url_to_get_a_folders_content_with_files').then((response) => {
          resolve(response.data.data.map((file) => {
            return {
              id: file.id,
              name: file.name,
              mime_type: file.media.mime_type,
              download_path: file.download_path,
              preview_path: file.preview_path
            }
          }))
        })
      })
    },
    uploadFiles (files) {
      for (let i = 0; i < files.length; i++) {
        const formData = new FormData()
        formData.append('file', files[i])
        formData.append('name', files[i].name)
        this.$http.post('url_to_upload_a_file', formData)
      }
    },
    selectFile (file) {
      if (this.canSelectFile) {
        this.$emit('selected', file)
      } else {
        window.open(
          file.download_path,
          '_blank'
        )
      }
    },
    downloadFile (file) {
      window.open(
        file.download_path,
        '_blank'
      )
    },
    createFolder (name, parent) {
      return new Promise(resolve => {
        this.$http.post('url_to_create_a_folder', { name: name, directory_id: parent }).then(() => {
          resolve()
        })
      })
    }
  },
  compilerOptions: {
    isCustomElement: tag => console.log(tag)
  }
}
// If this is a native custom element, make sure to exclude it from component resolution via compilerOptions.isCustomElement. at <BuhRep onVnodeUnmounted=fn<onVnodeUnmounted> ref=Ref< undefined > > at <RouterView> at <App>
</script>
