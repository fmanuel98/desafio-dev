<script setup lang="ts">
// This starter template is using Vue 3 <script setup> SFCs
// Check out https://vuejs.org/api/sfc-script-setup.html#script-setup
import Upload from './components/Upload.vue'
</script>

<template>
  <h3>Faça aqui a submissão do arquivo cnab</h3>
  <Upload msg="Hello Vue 3 + TypeScript + Vite" />
</template>

<style>
body {
  background-color: rgb(231, 224, 224);

}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h3 {
  text-transform: uppercase;
}
</style>
