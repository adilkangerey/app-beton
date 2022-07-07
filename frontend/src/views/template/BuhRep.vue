
    <template>
  <div id="summary-report" >
    <h2>Сводный отчет</h2>
    <div id="v-model-period">
      <div id="v-model-select" class="demo">
        <select v-model="selectedd">
          <option disabled value="">Выберите один из вариантов</option>
          <option>А</option>
          <option>Б</option>
          <option>В</option>
        </select>
        <span>Выбрано: {{ selectedd }}</span>
      </div>
      <label >Дата начала</label> <br>
      <input class="data-" type="date" placeholder="Введите дату" min="2000.01.01" max="2099.12.12" v-model="period">
      <input class="data-" type="time" placeholder="Введите время" v-model="period_goal"><br>
      <label id="labels">Дата окончания</label><br>
      <input class="data_period" type="date" placeholder="Введите дату" min="2000.01.01" max="2099.12.12" v-model="period">
      <input class="data_period" type="time" placeholder="Введите время" v-model="period_goal"><br>
      <span>Список клиентов и пунктов доставки за период: {{ period_ }}</span>
    </div>
    <button href="#zatemnenie"><a href="#zatemnenie">aaaa</a></button>
  </div>
  <div>
    <h2>Продолжение: Детальный отчёт</h2>
    <button>Выбрать клиентов и их пункты доставки</button>
    <p>Клиенты:</p>
    <p>Пункты доставки:</p>
    <button>Запросить детальный отчёт</button>
  </div>
  <div id="zatemnenie">
    <div id="okno">

      <button><a>Получить клиентов</a></button>
      <button><a>Получить пункты доставки</a></button><br>
      <span>Клиенты:</span>
      <span>Пункты доставки</span>
      <a href="#" class="close">zhaby</a>
    </div>
  </div>
</template>
<script>
import {createApp, h} from 'vue'

createApp({
  data(){
    return{
      selectedd: ''
    }
  }
}).mount('#selectedd')
export default BuhRep
</script>
<style>
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
  display: inline-block;
  border: 1px solid #090000;
  color: #1a1a1a;
  padding: 0 12px;
  margin: 10px;
  text-decoration: none;
  background: #f2f2f2;
  font-size: 14pt;
  cursor:pointer;
}
.close:hover {background: #e6e6ff;}

div{
  margin-left: 10px;
}
.data- {
  min-width: 200px;
  width: 43%;
}
</style>


