(window.webpackJsonp=window.webpackJsonp||[]).push([["vbKv"],{vbKv:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("WI6C");function a(e){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var o={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{warehouseId:[{required:!0,trigger:"change",message:"请选择仓库"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:""},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{warehouseId:""},warehouseData:{data:{selectUrl:"/warehouse/warehouseBase/treeSelectWarehouse",selectParm:{isNeedEntityVirtual:"true",isNotNeedSpare:"true",isNeedwarehouseGenre:"true",orderStr:"a.serial_number asc"}},defaultSelected:[]}}},created:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=a(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dataBridge:function(e){},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},deleteBtns:function(e,t){this.tableData.splice(t,1)},closeDialog:function(e){},warehouseSelect:function(e){null!=e&&e.length>0&&(this.formData.warehouseId=e[e.length-1])},save:function(){this.$refs.submitForm.validate(function(e){})}},watch:{}},n=i("KHd+"),l=Object(n.a)(o,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"350px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{margin:"10px auto",width:"100%"}},[i("el-form",{ref:"submitForm",attrs:{rules:e.rules,model:e.formData,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-form-item",{attrs:{label:"仓库:",prop:"warehouseId"}},[i("base-input-select",{staticStyle:{width:"200px"},attrs:{data:e.warehouseData.data},on:{callback:e.warehouseSelect},model:{value:e.warehouseData.defaultSelected,callback:function(t){e.$set(e.warehouseData,"defaultSelected",t)},expression:"warehouseData.defaultSelected"}})],1)],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("确定")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="selectWarehouse.vue";t.default=l.exports}}]);