<script setup lang="ts">
import IsikunForm from "./IsikunForm.vue";
</script>
<template>
  <div class="common-layout">
    <el-container direction="vertical">
      <el-main>
        <div>
          <h5>测试你是不是真ikun，请仔细回答哦！</h5>
          <img src="src/assets/mainimg.png" class="main" alt="main show" />
        </div>
        <IsikunForm/>
      </el-main>
    </el-container>
  </div>
</template>

<style scoped>
.main {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
}
.main:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.main:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
