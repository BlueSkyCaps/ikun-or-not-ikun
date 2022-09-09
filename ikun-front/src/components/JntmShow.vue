<template>
  <div style="text-align: center">
    <video-player
        class="video-player vjs-big-play-centered"
        src="../src/assets/jntm.mp4"
        crossorigin="anonymous"
        playsinline
        controls
        loop="true"
        :volume="1"
        :width="deviceWidth"
        :height="432"
        :playback-rates="[0.5, 1.0, 1.5, 2.0]"
        @mounted="handleMounted"
        @play="handleEvent($event)"
        @pause="handleEvent($event)"
        @playing="handleEvent($event)"
        @canplay="handleEvent($event)"
    />
  </div>

</template>

<script lang="ts">
import {defineComponent, ref, shallowRef} from 'vue'
import { VideoJsPlayer } from 'video.js'
import { VideoPlayer } from '@videojs-player/vue'
import 'video.js/dist/video-js.css'

export default defineComponent({
  name: 'JntmSHow',
  url: import.meta.url,
  components: {
    VideoPlayer
  },
  setup() {
    // 响应当前设备宽度，40是外侧遮罩层组件内部padding，避免视频右侧溢出40px
    let deviceWidth = ref<number>(window.innerWidth-40)
    const player = shallowRef<VideoJsPlayer>()
    const handleMounted = (payload: any) => {
      player.value = payload.player
      player.value?.play()
    }

    const handleEvent = (log: any) => {
    }

    return { player, handleMounted, handleEvent,deviceWidth }
  }
})
</script>

