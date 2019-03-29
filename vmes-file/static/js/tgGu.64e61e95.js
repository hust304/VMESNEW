(window.webpackJsonp=window.webpackJsonp||[]).push([["tgGu"],{tgGu:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("/a8v");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{initialPeriodDate:null,paymentPeriodDate:null,rules:{initialPeriodDate:[{required:!0,message:"请填写初始付款期间",trigger:"change"}]},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,formTemp:[]}},created:function(){this.initData.rowData&&(this.formData=this.initData.rowData,this.initialPeriodDate=new Date(this.initData.rowData.initialPeriodDate),null!=this.initData.rowData.paymentPeriodDate&&(this.paymentPeriodDate=new Date(this.initData.rowData.paymentPeriodDate)))},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},changeInitialPeriodDate:function(t){null!=t&&(this.initialPeriodDate=new Date(t),this.formData.initialPeriodDate=t)},changePaymentPeriodDate:function(t){this.paymentPeriodDate=new Date(t),this.formData.paymentPeriodDate=t},isErrorByPeriodDate:function(){var t=this.initialPeriodDate.getTime();if(null!=this.paymentPeriodDate&&this.paymentPeriodDate.getTime()-t<0)return this.$message({message:"当前付款期间不可小于初始付款期间！",type:"warning",duration:5e3}),!0;return!1},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&!t.isErrorByPeriodDate()&&Object(a.updateCompanyPeriod)(t.formData).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"付款成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})},closeDialog:function(t){}}},r=i("KHd+"),l=Object(r.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-form-item",{attrs:{label:"企业编码:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.companyCode,callback:function(e){t.$set(t.formData,"companyCode",e)},expression:"formData.companyCode"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"企业名称:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.companyName,callback:function(e){t.$set(t.formData,"companyName",e)},expression:"formData.companyName"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"初始付款期间:",prop:"initialPeriodDate"}},[i("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"month","value-format":"yyyy-MM-dd",placeholder:"选择月"},on:{change:t.changeInitialPeriodDate},model:{value:t.formData.initialPeriodDate,callback:function(e){t.$set(t.formData,"initialPeriodDate",e)},expression:"formData.initialPeriodDate"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"当前付款期间:",prop:"paymentPeriodDate"}},[i("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"month","value-format":"yyyy-MM-dd",placeholder:"选择月"},on:{change:t.changePaymentPeriodDate},model:{value:t.formData.paymentPeriodDate,callback:function(e){t.$set(t.formData,"paymentPeriodDate",e)},expression:"formData.paymentPeriodDate"}})],1)],1)],1),t._v(" "),i("div",{staticStyle:{"padding-left":"6%"}},[t._v("\n    备注："),i("br"),t._v("\n    1) 初始付款期间：当前企业首次采购付款结转初始期间"),i("br"),t._v("\n    2) 当前付款期间：供应商在当前付款期间内发生的所有"),i("br"),t._v("\n            \n            \n            \n    (采购金额，付款金额)"),i("br"),t._v("\n    3) 当前付款期间：为空不填保存后默认等于初始付款期间"),i("br"),t._v("\n    例如：201903 表示2019年03月份"),i("br"),i("br")]),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogEdit.vue";e.default=l.exports}}]);