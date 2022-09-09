
import { ElNotification } from 'element-plus'
export {
    openRandomFistWarnings,
    open,
}
const startRandomFistWarningsIteration = ()=>{
    // 随机弹出真爱粉警告弹窗
    for (let i = 1000; i <= 20000; i=i+1000) {
        // 随机弹窗
        let typeRandom : number
        // 随机位置
        let positionRandom : number
        // 随机真爱粉警告警告信息
        let msgRandom : number
        // 弹窗类型只有四种 因此最大数是4。因为1是成功标志，忽略它，所以最小值是2。
        typeRandom = Math.ceil((()=> {
            let tmp = Math.random();
            return tmp<=0.1?0:tmp;
        })() * (4-2)) + 2;
        // 位置类型只有四种 因此最大数是4,最小值是1
        positionRandom = Math.floor(Math.random() * 4) + 1;
        // 警告信息只有五种 因此最大数是5,最小值是1
        msgRandom = Math.floor(Math.random() * 5) + 1;
        ElNotification({
            title: '真爱粉警告',
            message: realIkunErrorMsg[msgRandom],
            position: positions[positionRandom],
            type: types[typeRandom],
            showClose:false,
            duration:i
        })

    }
}

/**
 * 随机弹出真爱粉警告信息，连续弹出20此
 * @param clickCount 模拟连击次数，默认1
 * @param durSecond 间隔多少秒再次触发随机弹出事件，默认1s
 */

const openRandomFistWarnings = (clickCount = 1, durSecond=1) => {
    for (let i = 0; i < clickCount; i++) {
        setTimeout(()=>{
            startRandomFistWarningsIteration()
        }, durSecond*1000);
    }
}
const open = (message : string, t:number, pos:number, title="提示") => {
    ElNotification({
        title: title,
        message: message,
        position: positions[pos],
        type: types[t],
    })
}

let positions : any
let types : any
let realIkunErrorMsg : any
positions={
    1:'top-left',
    2:'top-right',
    3:'bottom-left',
    4:'bottom-right'
}
types={
    1:'success',
    2:'warning',
    3:'info',
    4:'error'
}

realIkunErrorMsg={
    1:'你不是真的爱坤！！',
    2:'她这么优秀，你们为什么要这么对她？',
    3:'有完没完啦？',
    4:'答错了，这都不知道，你是黑粉吧！！',
    5:'你干嘛~~'
}