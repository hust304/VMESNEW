(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-6896","6tA9"],{"6tA9":function(e,t,i){"use strict";i.r(t);i("xfY5");var a=i("WIyV"),o=i("c5eW"),n={components:{customBaseTable:a.a},props:["initData","visible"],data:function(){return{receiptType:2,productUnit:{},rules:{},openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],rowTableList:[],configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},apiObj:{apiName:"getInvoiceAmount",params:{customerId:this.initData.temp.customerId,isNeedPage:"false",fieldCode:"customerCode,customerName,amount"}},customColumn:[{columnIndex:"amount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+\\.{0,1}[0-9]{0,2}$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.temp=this.initData.temp,null!=this.initData.temp.receiptType&&this.initData.temp.receiptType.trim().length>0&&(this.receiptType=Number(this.initData.temp.receiptType)),null!=this.initData.temp.id&&this.initData.temp.id.trim().length>0&&(this.apiObj.params.parentId=this.initData.temp.id.trim())},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){if(Array.isArray(e)){if(this.rowTableList=e,!(this.rowTableList.length>0))return void this.$message({type:"warning",duration:5e3,showClose:!0,message:"至少要选择一条记录！"});this.saveFinanceInvoice(this.rowTableList)}},save:function(){this.$refs.orderAddByInvoiceDialog.getData()},saveFinanceInvoice:function(e){for(var t=this,i=0;i<e.length;i++){var a=e[i];this.temp.amount=a.amount}this.temp.type=this.receiptType,this.dialogLoading=!0,Object(o.saveFinanceInvoice)(this.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1})},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},l=i("KHd+"),s=Object(l.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1000px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",{staticStyle:{margin:"10px 50px"}},[i("el-radio-group",{model:{value:e.receiptType,callback:function(t){e.receiptType=t},expression:"receiptType"}},[i("el-radio",{attrs:{label:2}},[e._v("增值税普通发票")]),e._v(" "),i("el-radio",{attrs:{label:3}},[e._v("增值税专用发票")])],1)],1),e._v(" "),i("div",{staticStyle:{"padding-left":"50px"}},[i("p",[i("a",[e._v("名称:")]),e._v(e._s(e.temp.companyName))]),e._v(" "),i("p",[i("a",[e._v("税号:")]),e._v(e._s(e.temp.invoiceNumber))]),e._v(" "),i("p",[i("a",[e._v("地址:")]),e._v(e._s(e.temp.address))]),e._v(" "),i("p",[i("a",[e._v("电话:")]),e._v(e._s(e.temp.mobile))]),e._v(" "),i("p",[i("a",[e._v("开户银行:")]),e._v(e._s(e.temp.bankName))]),e._v(" "),i("p",[i("a",[e._v("账号:")]),e._v(e._s(e.temp.bankCode))])]),e._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{width:"96%","margin-left":"2%"}},[i("custom-base-table",{ref:"orderAddByInvoiceDialog",attrs:{"data-custom-table-id":"views_sale_saleInvoice_dialogAdd0",isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"orderAddByInvoiceDialog",useDefaultBtn:!1,showAll:!1},on:{databridge:e.databridge}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);s.options.__file="dialogAdd.vue";t.default=s.exports},"hI+3":function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf");var a=i("6tA9");i("QmdA");function o(e){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var n={components:{dialogAdd:a.default},name:"dialog-add",props:["initData","visible"],data:function(){return{customerId:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{companyName:"",invoiceNumber:"",address:"",bankName:"",bankCode:"",mobile:"",remark:"",customerId:""},tempLable:{},tempNotEditable:{},rules:{companyName:[{required:!0,message:"请填写公司名称",trigger:"change"}]},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{temp:{},title:""}}},created:function(){this.customerId=this.initData.customerId,this.temp.customerId=this.initData.customerId,this.temp.companyName=this.initData.customerName},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=o(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){(e={}).resState=this.resState,this.$emit("close-dialog",e||{})},save:function(){var e=this;this.$refs.submitForm.validate(function(t){t&&(e.dialogData.temp=JSON.parse(JSON.stringify(e.temp)),e.dialogData.title="选择订单",e.openDialogName="dialogAdd",e.showDialog=!0,e.inLinVisible=!0)})},closeDialog:function(e){e.resState&&(this.resState=e.resState),this.isVisible=!1}}},l=i("KHd+"),s=Object(l.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"450px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"75%","padding-top":"10px"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"75px"}},[i("el-form-item",{attrs:{label:"名称:",prop:"companyName"}},[i("el-input",{model:{value:e.temp.companyName,callback:function(t){e.$set(e.temp,"companyName",t)},expression:"temp.companyName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"税号:",prop:"invoiceNumber"}},[i("el-input",{model:{value:e.temp.invoiceNumber,callback:function(t){e.$set(e.temp,"invoiceNumber",t)},expression:"temp.invoiceNumber"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"地址:",prop:"address"}},[i("el-input",{model:{value:e.temp.address,callback:function(t){e.$set(e.temp,"address",t)},expression:"temp.address"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"电话:",prop:"mobile"}},[i("el-input",{model:{value:e.temp.mobile,callback:function(t){e.$set(e.temp,"mobile",t)},expression:"temp.mobile"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"开户银行:",prop:"bankName"}},[i("el-input",{model:{value:e.temp.bankName,callback:function(t){e.$set(e.temp,"bankName",t)},expression:"temp.bankName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"账号:",prop:"bankCode"}},[i("el-input",{model:{value:e.temp.bankCode,callback:function(t){e.$set(e.temp,"bankCode",t)},expression:"temp.bankCode"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{attrs:{type:"textarea",rows:"2"},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="dialogAddCustomerInvoice.vue";t.default=s.exports}}]);