import { showConfirmDialog, showLoadingToast } from 'vant'

export function showCustomConfirmDialog({ title, message, onConfirm }) {
  showConfirmDialog({
    title,
    message,
    beforeClose: action => {
      if(action !== 'confirm') return true
      try {
        onConfirm()
      } catch(e) {
        console.log(e)
      }
      //返回true表示应该关闭弹窗，而不是beforeClose的预定义行为执行成功
      return true
    }
  }).then(() => {
    //仅当action为confirm时，才执行then中的内容
  }).catch(() => {
    //当action不为confirm时，执行catch中的内容。若不调用catch指定回调，则控制台将会输出Promise Error信息
  })
}

export function showCustomLoadingToast(options) {
  //noinspection JSUnusedGlobalSymbols
  let mergedOptions = Object.assign({
    duration: 0,
    forbidClick: true,
    className: 'custom-vant-loading-toast'
  }, options)
  let toast = showLoadingToast(mergedOptions)
  return {
    close: () => {
      let toastDom = document.querySelector('.custom-vant-loading-toast')
      if(toastDom == null) return
      toast.close()
    }
  }
}