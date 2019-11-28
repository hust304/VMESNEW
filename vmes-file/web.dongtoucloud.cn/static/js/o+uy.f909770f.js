(window.webpackJsonp=window.webpackJsonp||[]).push([["o+uy"],{"o+uy":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("Oyvg");var a=i("EXX/");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{paymentSum:[{required:!0,message:"请填写付款金额",trigger:"change"}]},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,formTemp:[]}},created:function(){this.initData.rowData&&(this.formData=this.initData.rowData)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+\\.{0,1}[0-9]{0,2}$").test(t.trim())},isErrorByCheckPaymentSum:function(t){return null!=this.formData.endPlus&&this.formData.endPlus.trim().length>0&&this.formData.endPlus.trim(),!this.isNumberByValue(t.trim())&&(this.$message({message:"付款金额:"+t+" 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3}),!0)},save:function(){var t=this;this.$refs.submitForm.validate(function(e){var i=t.formData.paymentSum;t.isErrorByCheckPaymentSum(i)||Object(a.addPaymentRecord)(t.formData).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"付款成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})},closeDialog:function(t){}}},l=i("KHd+"),r=Object(l.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-form-item",{attrs:{label:"供应商编号:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.supplierCode,callback:function(e){t.$set(t.formData,"supplierCode",e)},expression:"formData.supplierCode"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"供应商名称:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.supplierName,callback:function(e){t.$set(t.formData,"supplierName",e)},expression:"formData.supplierName"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"应付款(期末):"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.endPlus,callback:function(e){t.$set(t.formData,"endPlus",e)},expression:"formData.endPlus"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"付款金额:",prop:"paymentSum"}},[i("el-input",{staticStyle:{width:"200px"},on:{change:t.isErrorByCheckPaymentSum},model:{value:t.formData.paymentSum,callback:function(e){t.$set(t.formData,"paymentSum",e)},expression:"formData.paymentSum"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{type:"textarea",rows:"2"},model:{value:t.formData.remark,callback:function(e){t.$set(t.formData,"remark",e)},expression:"formData.remark"}})],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="addPaymentRecord.vue";e.default=r.exports}}]);