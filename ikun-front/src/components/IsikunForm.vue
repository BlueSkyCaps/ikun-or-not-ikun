<template>
  <el-form
      ref="ruleFormRef"
      :model="ruleForm"
      status-icon
      :rules="rules"
      class="demo-ruleForm">
    <el-form-item label="坤的鞋码" prop="shoeSize">
      <el-input-number v-model.number="ruleForm.shoeSize" :precision="2" :step="0.1" :max="60" />
    </el-form-item>
    <el-form-item label="坤喜欢的颜色" prop="assistanceColor">
      <el-input v-model="ruleForm.assistanceColor" />
    </el-form-item>
    <el-form-item label="坤喜欢的地方" prop="dreamsLand">
      <el-input v-model="ruleForm.dreamsLand" />
    </el-form-item>
    <el-form-item label="坤喜欢的技能(四个字母缩写)" prop="sports">
      <el-input v-model="ruleForm.sports" />
    </el-form-item>
    <div>
      <el-alert :title="getMsg" v-show="getMsg!==''" type="error" center show-icon />
      <el-button type="primary" @click="submitForm(ruleFormRef)">🏀</el-button>
      <el-button @click="resetForm(ruleFormRef)">置空</el-button>
    </div>
  </el-form>
  <component :is="coverVideoLazyName"/>
</template>

<script lang="ts" setup>
import {reactive, ref} from 'vue'
import type { FormInstance } from 'element-plus'
import {openRandomFistWarnings, open} from "../common/openNotification";
import axios from "axios";
import {apiUris} from "../common/apis";
import {playAudio} from "../common/ikunCommon";


const ruleFormRef = ref<FormInstance>()
const unityValidateTextInput = (rule: any, value: any, callback: any) => {
  const fieldTarget = rule.field
  let errTips: any;
  errTips={
    "assistanceColor":"坤坤：快告诉我颜色哦！",
    "dreamsLand":"坤坤：我喜欢的地方空空如也哦！",
    "sports":"坤坤：全名制作人都知道我的技能哦！",
  }
  if (value===null||value===undefined||value.trim()=='') {
    return callback(new Error(errTips[fieldTarget]))
  }
  return callback()
}

const validateShoeSize = (rule: any, value: any, callback: any) => {
  if (isNaN(parseFloat(value))) {
    callback(new Error('坤坤：鞋码格式不对哦！'))
  } else {
    callback()
  }
}

const ruleForm = reactive({
  shoeSize: 0.0,
  assistanceColor: '',
  dreamsLand: '',
  sports: '',
})

let getMsg = ref('')
let coverVideoLazyName = ref('')

const rules = reactive({
  shoeSize: [{ validator: validateShoeSize, trigger: 'blur' }],
  assistanceColor: [{ validator: unityValidateTextInput, trigger: 'blur' }],
  dreamsLand: [{ validator: unityValidateTextInput, trigger: 'blur' }],
  sports: [{ validator: unityValidateTextInput, trigger: 'blur' }],
})

// 调用接口验证是否是真的ikun：答案正确与否
function callDistinguishIkunApi(ikunInfo :any) {
  let apiDict :any=apiUris()
  let distinguishUri :string = apiDict['proxy']+apiDict['uris']['distinguish']
  axios.post(distinguishUri, ikunInfo).then((res)=>{
    if (res.data['status']==1){
      // 验证成功~更新底部信息
      open(res.data['message'], 1, 1)
      // 验证成功~显示ikun视频
      setTimeout(()=>{
        coverVideoLazyName.value = "CoverVideo"
      },3000)
      return
    }
    // 假ikun 真爱粉弹窗拳击警告！
    getMsg.value = res.data['message']
    playAudio('../src/assets/ngm.mp3')
    openRandomFistWarnings(3, 1)
  }).catch((err)=>{
    open('网络：'+err.toString(), 4, 1)
  })
}

const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      // 调接口验证答案是否填写正确
      callDistinguishIkunApi(ruleForm)
    } else {
      return false
    }
  })
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}
</script>

<script lang="ts">
// is动态加载遮罩层视频组件(遮罩组件内部有视频组件,加载遮罩组建完毕时视频组件自动播放)，export所需遮罩组件
import CoverVideo from "./CoverVideo.vue";
export default {
  components: {
    CoverVideo,
  }
}
</script>