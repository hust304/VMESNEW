(window.webpackJsonp=window.webpackJsonp||[]).push([["YVgj"],{YVgj:function(t,i,e){"use strict";e.r(i);e("rE2o"),e("ioFf"),e("Oyvg");var a=e("We3Z");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{},name:"dialog-add",props:["initData","visible"],data:function(){var t=this;return{initialPeriodDate:null,paymentPeriodDate:null,rules:{amount:[{required:!0,trigger:"change",validator:function(i,e,a){t.isNumberByValue(e)?(0==e&&a(new Error("请输入大于零的正整数或(1,2)位小数！")),a()):a(new Error("请输入大于零的正整数或(1,2)位小数！"))}}]},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,formTemp:[]}},created:function(){this.initData.rowData&&(this.formData=this.initData.rowData,this.initialPeriodDate=new Date(this.initData.rowData.initialPeriodDate),null!=this.initData.rowData.paymentPeriodDate&&(this.paymentPeriodDate=new Date(this.initData.rowData.paymentPeriodDate)))},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var i=parseInt(this.initData.width);return i?i>100?"100%":i+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},isNumberByValue:function(t){return null!=t&&0!=t.length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t)},save:function(){var t=this;this.$refs.submitForm.validate(function(i){t.dialogLoading=!0,Object(a.eidtFinanceBill)(t.formData).then(function(i){t.dialogLoading=!1,0===i.code&&(t.$notify({title:"成功",message:"设定成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(i){console.error(i),t.dialogLoading=!1})})},closeDialog:function(t){}}},l=e("KHd+"),r=Object(l.a)(n,function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(i){t.isVisible=i},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?e(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),e("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[e("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[e("el-row",[e("el-form-item",{attrs:{label:"客户编码:"}},[e("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.customerCode,callback:function(i){t.$set(t.formData,"customerCode",i)},expression:"formData.customerCode"}})],1)],1),t._v(" "),e("el-row",[e("el-form-item",{attrs:{label:"客户名称:"}},[e("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.customerName,callback:function(i){t.$set(t.formData,"customerName",i)},expression:"formData.customerName"}})],1)],1),t._v(" "),e("el-row",[e("el-form-item",{attrs:{label:"金额:",prop:"amount"}},[e("el-input",{staticStyle:{width:"200px"},model:{value:t.formData.amount,callback:function(i){t.$set(t.formData,"amount",i)},expression:"formData.amount"}})],1)],1),t._v(" "),e("el-row",[e("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[e("el-input",{staticStyle:{width:"200px"},attrs:{type:"textarea",rows:"2"},model:{value:t.formData.remark,callback:function(i){t.$set(t.formData,"remark",i)},expression:"formData.remark"}})],1)],1)],1),t._v(" "),e("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[e("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),e("el-button",{on:{click:function(i){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="dialogEdit.vue";i.default=r.exports}}]);