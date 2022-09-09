<template>
  <el-dialog
      v-model="centerDialogVisible"
      title="鸡你太美"
      width="100%" >
    <JntmShow/>
  </el-dialog>
</template>
<script lang="ts" >
import {defineComponent, ref} from 'vue'
import JntmShow from "./JntmShow.vue";
export default defineComponent({
  name:"CoverVideo",
  components: {
    JntmShow
  },
  data(){
    const centerDialogVisible = ref(false)
    return{
      centerDialogVisible:centerDialogVisible
    }
  },
  methods:{
    showCover(){
      this.centerDialogVisible = true
    }
  },
  mounted() {
    this.showCover()
  }
})

</script>
