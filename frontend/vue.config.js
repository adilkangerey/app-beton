const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  outputDir: '../backend/target/classes/templates/public',
  assetsDir: 'static'
})
