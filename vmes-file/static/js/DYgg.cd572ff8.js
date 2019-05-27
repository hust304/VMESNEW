(window.webpackJsonp=window.webpackJsonp||[]).push([["DYgg"],{DYgg:function(t,e,o){"use strict";o.r(e);o("rE2o"),o("ioFf");var a=o("1FtD");function i(t){return(i="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{},name:"dialog-edit",props:["initData","visible"],data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{stockCount:[{required:!0,message:"请填写库存数量",trigger:"change"},{type:"number",message:"库存数量必须为数字"}]}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=i(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&Object(a.updateWarehouseProduct)({id:t.temp.id,stockCount:t.temp.stockCount}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})}}},n=o("KHd+"),s=Object(n.a)(l,function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"620px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[o("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[o("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[o("el-row",[o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:t.tempLable.warehouseCode+":",prop:"warehouseCode"}},[o("el-input",{attrs:{disabled:!0},model:{value:t.temp.warehouseCode,callback:function(e){t.$set(t.temp,"warehouseCode",e)},expression:"temp.warehouseCode"}})],1)],1),t._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:t.tempLable.pathName+":",prop:"pathName"}},[o("el-input",{attrs:{disabled:!0},model:{value:t.temp.pathName,callback:function(e){t.$set(t.temp,"pathName",e)},expression:"temp.pathName"}})],1)],1)],1),t._v(" "),o("el-row",[o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:t.tempLable.productCode+":",prop:"productCode"}},[o("el-input",{attrs:{disabled:!0},model:{value:t.temp.productCode,callback:function(e){t.$set(t.temp,"productCode",e)},expression:"temp.productCode"}})],1)],1),t._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:t.tempLable.productName+":",prop:"productName"}},[o("el-input",{attrs:{disabled:!0},model:{value:t.temp.productName,callback:function(e){t.$set(t.temp,"productName",e)},expression:"temp.productName"}})],1)],1)],1),t._v(" "),o("el-row",[o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:t.tempLable.productSpec+":",prop:"productSpec"}},[o("el-input",{attrs:{disabled:!0},model:{value:t.temp.productSpec,callback:function(e){t.$set(t.temp,"productSpec",e)},expression:"temp.productSpec"}})],1)],1),t._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:t.tempLable.productGenreName+":",prop:"productGenreName"}},[o("el-input",{attrs:{disabled:!0},model:{value:t.temp.productGenreName,callback:function(e){t.$set(t.temp,"productGenreName",e)},expression:"temp.productGenreName"}})],1)],1)],1),t._v(" "),o("el-row",[o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:t.tempLable.productUnitName+":",prop:"productUnitName"}},[o("el-input",{attrs:{disabled:!0},model:{value:t.temp.productUnitName,callback:function(e){t.$set(t.temp,"productUnitName",e)},expression:"temp.productUnitName"}})],1)],1),t._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:t.tempLable.code+":",prop:"code"}},[o("el-input",{attrs:{disabled:!0},model:{value:t.temp.code,callback:function(e){t.$set(t.temp,"code",e)},expression:"temp.code"}})],1)],1)],1),t._v(" "),o("el-row",[o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:t.tempLable.stockCount+":",prop:"stockCount"}},[o("el-input",{model:{value:t.temp.stockCount,callback:function(e){t.$set(t.temp,"stockCount",t._n(e))},expression:"temp.stockCount"}})],1)],1),t._v(" "),o("el-col",{attrs:{span:12}})],1)],1),t._v(" "),o("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[o("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),o("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);s.options.__file="dialogEdit.vue";e.default=s.exports}}]);