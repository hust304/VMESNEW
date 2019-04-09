(window.webpackJsonp=window.webpackJsonp||[]).push([["s2cx"],{s2cx:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf"),a("Oyvg");var i=a("YQ/6");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{initialPeriodDate:null,paymentPeriodDate:null,rules:{paymentPeriodDate:[{required:!0,message:"请填写付款期间",trigger:"change"}],paymentType:[{required:!0,message:"请选择付款类型",trigger:"change"}],paymentSum:[{required:!0,message:"请填写期初金额",trigger:"change"}]},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,formTemp:[]}},created:function(){this.initData.rowData&&(this.formData=this.initData.rowData,this.initialPeriodDate=new Date(this.initData.rowData.initialPeriodDate),null!=this.initData.rowData.paymentPeriodDate&&(this.paymentPeriodDate=new Date(this.initData.rowData.paymentPeriodDate)))},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t.trim())},checkNumberByValue:function(t,e){var a="";return null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())?a=a+e+":"+t+" 输入错误，请输入大于零的正整数或(1,2)位小数！":t-0<=0&&(a=a+e+":"+t+" 输入错误，请输入大于零的正整数或(1,2)位小数！"),a},checkPaymentSum:function(t){var e=this.checkNumberByValue(t+"","期初金额");return null!=e&&e.trim().length>0&&(this.$message({message:e,type:"warning",duration:5e3}),!0)},save:function(){var t=this;this.$refs.submitForm.validate(function(e){var a=t.formData.paymentSum;e&&!t.checkPaymentSum(a)&&Object(i.editPaymentBuild)(t.formData).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"设定成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})},closeDialog:function(t){}}},l=a("KHd+"),r=Object(l.a)(n,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-form-item",{attrs:{label:"供应商编码:"}},[a("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.supplierCode,callback:function(e){t.$set(t.formData,"supplierCode",e)},expression:"formData.supplierCode"}})],1)],1),t._v(" "),a("el-row",[a("el-form-item",{attrs:{label:"供应商名称:"}},[a("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.supplierName,callback:function(e){t.$set(t.formData,"supplierName",e)},expression:"formData.supplierName"}})],1)],1),t._v(" "),a("el-row",[a("el-form-item",{attrs:{label:"付款期间:",prop:"paymentPeriodDate"}},[a("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"month","value-format":"yyyy-MM-dd",placeholder:"选择月"},model:{value:t.formData.paymentPeriodDate,callback:function(e){t.$set(t.formData,"paymentPeriodDate",e)},expression:"formData.paymentPeriodDate"}})],1)],1),t._v(" "),a("el-form-item",{attrs:{label:"付款类型:",prop:"paymentType"}},[a("el-select",{model:{value:t.formData.paymentType,callback:function(e){t.$set(t.formData,"paymentType",e)},expression:"formData.paymentType"}},[a("el-option",{attrs:{label:"应付款",value:"plus"}}),t._v(" "),a("el-option",{attrs:{label:"预付款",value:"minus"}})],1)],1),t._v(" "),a("el-row",[a("el-form-item",{attrs:{label:"期初金额:",prop:"paymentSum"}},[a("el-input",{staticStyle:{width:"200px"},on:{change:t.checkPaymentSum},model:{value:t.formData.paymentSum,callback:function(e){t.$set(t.formData,"paymentSum",e)},expression:"formData.paymentSum"}})],1)],1)],1),t._v(" "),a("div",{staticStyle:{"padding-left":"6%"}},[t._v("\n      备注："),a("br"),t._v("\n      供应商在付款期间中设定期初金额"),a("br"),t._v("\n      期初金额：含有(期初应付款，期初预付款)中的一项"),a("br"),t._v("\n      例如：付款期间(201903) 表示2019年03月份"),a("br"),a("br")]),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="dialogEdit.vue";e.default=r.exports}}]);