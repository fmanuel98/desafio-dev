<script setup lang="ts">
import uploadService from './UploadService';

async function upload($event: Event) {
  const target = $event.target as HTMLInputElement;
  if (target && target.files) {
    const selectedFile = target.files[0] as File;
    await uploadService(selectedFile)
  }
}

</script>

<template>
  <form enctype="multipart/form-data">
    <div class="input">
      <input type="file" class="form-control" placeholder="Escolha o ficheiro cnab" @change="upload($event)" />
    </div>
    <div class="button">
      <button type="submit">Enviar</button>
    </div>
  </form>
</template>

<style scoped>
form {
  display: flex;
  flex-direction: column;
}

.input input {
  padding: 7px;
  border-radius: 4px;
  margin-bottom: 12px;
  width: 550px;
  border: 1px solid rgb(29, 146, 45);
}

.button button {
  background-color: white;
  border: 1px solid rgb(29, 146, 45);
  width: 100px;
  height: 30px;
  border-radius: 4px;
  font-size: medium;
}
</style>
