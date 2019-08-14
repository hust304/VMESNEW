(window.webpackJsonp=window.webpackJsonp||[]).push([["KAlK"],{KAlK:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("Oyvg");var o=i("xT69");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var a={components:{},name:"dialog-edit",props:["initData","visible"],data:function(){return{formData:{},rules:{stockCount:[{required:!0,message:"请填写库存数量",trigger:"change"}]},dialogLoading:!0,isVisible:!1,inDialog:!0}},created:function(){this.formData=this.initData.rowData},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t.trim())},checkNumber:function(t,e){var i="";return null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&(i=e+"("+t+") 输入错误，请输入大于零的正整数或(1,2)位小数！"),i},changeStockCount:function(t){var e="";null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&(e=this.checkNumber(t,"库存数量")),null!=e&&e.trim().length>0&&this.$message({type:"warning",duration:5e3,showClose:!0,message:e})},changeProductSafetyCount:function(t){var e="";null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&(e=this.checkNumber(t,"安全库存数量")),null!=e&&e.trim().length>0&&this.$message({type:"warning",duration:5e3,showClose:!0,message:e})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){if(e){var i="",n=t.formData.stockCount,a=t.checkNumber(n,"库存数量");null!=a&&a.trim().length>0&&(i+=a);var r=t.formData.productSafetyCount;if(null!=(a=t.checkNumber(r,"安全库存数量"))&&a.trim().length>0&&(i+=a),null!=i&&i.trim().length>0)return void t.$message({type:"warning",duration:5e3,showClose:!0,message:i});Object(o.updateWarehouseProductBySpare)({id:t.formData.id,stockCount:n,productSafetyCount:r}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})}})}}},r=i("KHd+"),l=Object(r.a)(a,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"350px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto",width:"100%"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-form-item",{attrs:{label:"库存数量:",prop:"stockCount"}},[i("el-input",{staticStyle:{width:"200px"},on:{change:t.changeStockCount},model:{value:t.formData.stockCount,callback:function(e){t.$set(t.formData,"stockCount",e)},expression:"formData.stockCount"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"安全库存数量:",prop:""}},[i("el-input",{staticStyle:{width:"200px"},on:{change:t.changeProductSafetyCount},model:{value:t.formData.productSafetyCount,callback:function(e){t.$set(t.formData,"productSafetyCount",e)},expression:"formData.productSafetyCount"}})],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);l.options.__file="dialogEdit.vue";e.default=l.exports}}]);