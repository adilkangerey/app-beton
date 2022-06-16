#java8

для работы с нужна java8

#jaspersoft studio 6.19.1

1) для работы с отчетами нужно установить jaspersoft studio 6.19.1
2) после открытия студии выбрать File -> Open project from the File System и указать путь \[этот проект]/report/Myreports и там создавать /редактировать отчеты  
3) для работы с font Roboto (нужен для PDF)
 - войти в студию и в меню нажать Window -> Preferences 
  - в окне выбрать JasperStudio -> Fonts 
  - там же выбрать действие Add From Path и указать путь \[этот проект]\src\main\resources\fonts\Roboto 
  - далее нажать Edit по отношению к font Roboto
  - в новом окне Font Family в самом низу нажать галочку на "Embed this font in PDF document"
  - примечание: теперь после создания отчета или редактировании нужно править все поля на font Roboto чтоб не было проблем с отображением   

###HELP generate 
####exist table classes in db and repository 
for use run `mvn jpa-entity-generator:generateAll`

https://github.com/smartnews/jpa-entity-generator

####Внимание!
эта часть вызывается только когда необходимо т.к. для ее работы билд должен выполняться, а в случае когда у вас есть ссылка на эти сгенерированные файлы то билд не выполнится (единственный вариант это убрал некомпилируемые файлы)
 use `mvn spring-data-generator:repositories`

https://github.com/cmeza20/spring-data-generator

####Swagger

В проекте настроен swagger согласно статьи https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api

для перехода на swagger нужно вписать http://localhost:[port]/swagger-ui.html

####telegram

https://github.com/pengrad/java-telegram-bot-api