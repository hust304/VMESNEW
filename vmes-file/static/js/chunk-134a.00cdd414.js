(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-134a"],{G9cW:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("xfY5"),i("8Vv6");function a(t){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={name:"dialog-edit",props:["initData","visible"],data:function(){return{currentBalance_before:"",currentBalance:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.temp.totalBalance=Number(this.temp.addBalance)+Number(this.temp.balance)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable),this.currentBalance_before=this.temp.currentBalance,this.currentBalance=this.temp.currentBalance},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=a(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this,e=this;if(this.currentBalance>this.temp.totalBalance)this.$message({showClose:!0,message:"当前分摊金额不能大于预收款！",duration:5e3});else{var i=this.currentBalance-this.currentBalance_before;e.$refs.submitForm.validate(function(a){a&&(e.isVisible=!1,e.dialogClose({resState:"ok",currentBalance:t.currentBalance,currentBalance_edit:i}))})}}}},l=(i("bVxC"),i("KHd+")),o=Object(l.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:t.dialogWidth},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"预收款:",prop:"totalBalance"}},[i("el-input",{staticStyle:{width:"140px"},attrs:{disabled:!0},model:{value:t.temp.totalBalance,callback:function(e){t.$set(t.temp,"totalBalance",e)},expression:"temp.totalBalance"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"本次分摊金额:",prop:"currentBalance"}},[i("el-input",{staticStyle:{width:"140px"},model:{value:t.currentBalance,callback:function(e){t.currentBalance=t._n(e)},expression:"currentBalance"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,"3bd394eb",null);o.options.__file="dialogReceiptBalanceEdit.vue";e.default=o.exports},bVxC:function(t,e,i){"use strict";var a=i("f9Bb");i.n(a).a},f9Bb:function(t,e,i){}}]);