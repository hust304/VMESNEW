(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-3e2b"],{QmdA:function(e,t,i){"use strict";i.d(t,"c",function(){return a}),i.d(t,"a",function(){return n}),i.d(t,"d",function(){return r}),i.d(t,"e",function(){return s}),i.d(t,"b",function(){return l});var o=i("t3Un");function a(e){return Object(o.a)({url:"/base/customerInvoice/listPageCustomerInvoices",method:"post",data:e})}function n(e){return Object(o.a)({url:"/base/customerInvoice/addCustomerInvoice",method:"post",data:e})}function r(e){return Object(o.a)({url:"/base/customerInvoice/updateCustomerInvoice",method:"post",data:e})}function s(e){return Object(o.a)({url:"/base/customerInvoice/updateDefaultCustomerInvoice",method:"post",data:e})}function l(e){return Object(o.a)({url:"/base/customerInvoice/deleteCustomerInvoice",method:"post",data:{ids:e}})}},t2Xm:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf");var o=i("QmdA");function a(e){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var n={name:"dialog-edit",props:["initData","visible"],data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{companyName:[{required:!0,message:"请填写公司名称",trigger:"change"}],invoiceNumber:[{required:!0,message:"请填写发票税号",trigger:"change"}],address:[{required:!0,message:"请填写地址",trigger:"change"}],bankName:[{required:!0,message:"请填写开户行名称",trigger:"change"}],bankCode:[{required:!0,message:"请填写银行账号",trigger:"change"}],mobile:[{required:!0,message:"请填写手机号",trigger:"change"}]}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=a(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},save:function(){var e=this;e.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(o.d)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1}))})}}},r=i("KHd+"),s=Object(r.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"编辑",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.dialogWidth},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"公司名称:",prop:"companyName"}},[i("el-input",{model:{value:e.temp.companyName,callback:function(t){e.$set(e.temp,"companyName",t)},expression:"temp.companyName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"发票税号:",prop:"invoiceNumber"}},[i("el-input",{model:{value:e.temp.invoiceNumber,callback:function(t){e.$set(e.temp,"invoiceNumber",t)},expression:"temp.invoiceNumber"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"地址:",prop:"address"}},[i("el-input",{model:{value:e.temp.address,callback:function(t){e.$set(e.temp,"address",t)},expression:"temp.address"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"开户行名称:",prop:"bankName"}},[i("el-input",{model:{value:e.temp.bankName,callback:function(t){e.$set(e.temp,"bankName",t)},expression:"temp.bankName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"银行账号:",prop:"bankCode"}},[i("el-input",{model:{value:e.temp.bankCode,callback:function(t){e.$set(e.temp,"bankCode",t)},expression:"temp.bankCode"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"手机号:",prop:"mobile"}},[i("el-input",{model:{value:e.temp.mobile,callback:function(t){e.$set(e.temp,"mobile",t)},expression:"temp.mobile"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{attrs:{type:"textarea",rows:"2"},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);s.options.__file="invoiceEdit.vue";t.default=s.exports}}]);