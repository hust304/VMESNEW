(window.webpackJsonp=window.webpackJsonp||[]).push([["r/Cm"],{"r/Cm":function(t,i,e){"use strict";e.r(i);e("rE2o"),e("ioFf");var o=e("sNnr");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var a={name:"dialog-edit",props:["initData","visible"],data:function(){var t=this;return{orderId:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{receiptAmount:[{required:!0,message:"请填写收票金额！",trigger:"blur"},{type:"number",trigger:["blur","change"],validator:function(i,e,o){e>t.temp.amount?o(new Error("输入的收票金额不能大于采购金额！")):e<=0?o(new Error("输入的收票金额必须大于零！")):o()}}]}}},created:function(){this.temp=this.initData.temp,this.orderId=this.initData.temp.id},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var i=parseInt(this.initData.width);return i?i>100?"100%":i+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;this.$refs.submitForm.validate(function(i){i&&(t.dialogLoading=!0,Object(o.addReceipt)({id:t.initData.temp.id,receiptAmount:t.temp.receiptAmount}).then(function(i){t.dialogLoading=!1,0===i.code&&(t.$notify({title:"成功",message:"退回成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(i){t.dialogLoading=!1}))})}}},l=e("KHd+"),r=Object(l.a)(a,function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(i){t.isVisible=i},open:t.dialogOpen,close:t.dialogClose}},[e("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[e("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"30px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[e("el-form-item",{attrs:{label:"采购金额:",prop:"amount"}},[e("el-input",{staticStyle:{width:"240px"},attrs:{disabled:!0},model:{value:t.temp.amount,callback:function(i){t.$set(t.temp,"amount",i)},expression:"temp.amount"}})],1),t._v(" "),e("el-form-item",{attrs:{label:"收票金额:",prop:"receiptAmount"}},[e("el-input",{staticStyle:{width:"240px"},model:{value:t.temp.receiptAmount,callback:function(i){t.$set(t.temp,"receiptAmount",t._n(i))},expression:"temp.receiptAmount"}})],1)],1),t._v(" "),e("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[e("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),e("el-button",{on:{click:function(i){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);r.options.__file="dialogAddReceipt.vue";i.default=r.exports}}]);