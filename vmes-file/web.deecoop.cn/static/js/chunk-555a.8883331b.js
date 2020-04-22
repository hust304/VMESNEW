(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-555a","chunk-7144","chunk-6896","6tA9"],{"6tA9":function(e,t,i){"use strict";i.r(t);i("xfY5");var a=i("WIyV"),o=i("c5eW"),n={components:{customBaseTable:a.a},props:["initData","visible"],data:function(){return{receiptType:2,productUnit:{},rules:{},openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],rowTableList:[],configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},apiObj:{apiName:"getInvoiceAmount",params:{customerId:this.initData.temp.customerId,isNeedPage:"false",fieldCode:"customerCode,customerName,amount"}},customColumn:[{columnIndex:"amount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+\\.{0,1}[0-9]{0,2}$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.temp=this.initData.temp,null!=this.initData.temp.receiptType&&this.initData.temp.receiptType.trim().length>0&&(this.receiptType=Number(this.initData.temp.receiptType)),null!=this.initData.temp.id&&this.initData.temp.id.trim().length>0&&(this.apiObj.params.parentId=this.initData.temp.id.trim())},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){if(Array.isArray(e)){if(this.rowTableList=e,!(this.rowTableList.length>0))return void this.$message({type:"warning",duration:5e3,showClose:!0,message:"至少要选择一条记录！"});this.saveFinanceInvoice(this.rowTableList)}},save:function(){this.$refs.orderAddByInvoiceDialog.getData()},saveFinanceInvoice:function(e){for(var t=this,i=0;i<e.length;i++){var a=e[i];this.temp.amount=a.amount}this.temp.type=this.receiptType,this.dialogLoading=!0,Object(o.saveFinanceInvoice)(this.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1})},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},l=i("KHd+"),s=Object(l.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1000px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",{staticStyle:{margin:"10px 50px"}},[i("el-radio-group",{model:{value:e.receiptType,callback:function(t){e.receiptType=t},expression:"receiptType"}},[i("el-radio",{attrs:{label:2}},[e._v("增值税普通发票")]),e._v(" "),i("el-radio",{attrs:{label:3}},[e._v("增值税专用发票")])],1)],1),e._v(" "),i("div",{staticStyle:{"padding-left":"50px"}},[i("p",[i("a",[e._v("名称:")]),e._v(e._s(e.temp.companyName))]),e._v(" "),i("p",[i("a",[e._v("税号:")]),e._v(e._s(e.temp.invoiceNumber))]),e._v(" "),i("p",[i("a",[e._v("地址:")]),e._v(e._s(e.temp.address))]),e._v(" "),i("p",[i("a",[e._v("电话:")]),e._v(e._s(e.temp.mobile))]),e._v(" "),i("p",[i("a",[e._v("开户银行:")]),e._v(e._s(e.temp.bankName))]),e._v(" "),i("p",[i("a",[e._v("账号:")]),e._v(e._s(e.temp.bankCode))])]),e._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{width:"96%","margin-left":"2%"}},[i("custom-base-table",{ref:"orderAddByInvoiceDialog",attrs:{"data-custom-table-id":"views_sale_saleInvoice_dialogAdd0",isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"orderAddByInvoiceDialog",useDefaultBtn:!1,showAll:!1},on:{databridge:e.databridge}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);s.options.__file="dialogAdd.vue";t.default=s.exports},"hI+3":function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf");var a=i("6tA9");i("QmdA");function o(e){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var n={components:{dialogAdd:a.default},name:"dialog-add",props:["initData","visible"],data:function(){return{customerId:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{companyName:"",invoiceNumber:"",address:"",bankName:"",bankCode:"",mobile:"",remark:"",customerId:""},tempLable:{},tempNotEditable:{},rules:{companyName:[{required:!0,message:"请填写公司名称",trigger:"change"}]},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{temp:{},title:""}}},created:function(){this.customerId=this.initData.customerId,this.temp.customerId=this.initData.customerId,this.temp.companyName=this.initData.customerName},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=o(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){(e={}).resState=this.resState,this.$emit("close-dialog",e||{})},save:function(){var e=this;this.$refs.submitForm.validate(function(t){t&&(e.dialogData.temp=JSON.parse(JSON.stringify(e.temp)),e.dialogData.title="选择订单",e.openDialogName="dialogAdd",e.showDialog=!0,e.inLinVisible=!0)})},closeDialog:function(e){e.resState&&(this.resState=e.resState),this.isVisible=!1}}},l=i("KHd+"),s=Object(l.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"450px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"75%","padding-top":"10px"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"75px"}},[i("el-form-item",{attrs:{label:"名称:",prop:"companyName"}},[i("el-input",{model:{value:e.temp.companyName,callback:function(t){e.$set(e.temp,"companyName",t)},expression:"temp.companyName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"税号:",prop:"invoiceNumber"}},[i("el-input",{model:{value:e.temp.invoiceNumber,callback:function(t){e.$set(e.temp,"invoiceNumber",t)},expression:"temp.invoiceNumber"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"地址:",prop:"address"}},[i("el-input",{model:{value:e.temp.address,callback:function(t){e.$set(e.temp,"address",t)},expression:"temp.address"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"电话:",prop:"mobile"}},[i("el-input",{model:{value:e.temp.mobile,callback:function(t){e.$set(e.temp,"mobile",t)},expression:"temp.mobile"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"开户银行:",prop:"bankName"}},[i("el-input",{model:{value:e.temp.bankName,callback:function(t){e.$set(e.temp,"bankName",t)},expression:"temp.bankName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"账号:",prop:"bankCode"}},[i("el-input",{model:{value:e.temp.bankCode,callback:function(t){e.$set(e.temp,"bankCode",t)},expression:"temp.bankCode"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{attrs:{type:"textarea",rows:"2"},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="dialogAddCustomerInvoice.vue";t.default=s.exports},rPmT:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf");var a=i("6tA9");function o(e){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var n={components:{dialogAddCustomerInvoice:i("hI+3").default,dialogAdd:a.default},name:"dialog-add",props:["initData","visible"],data:function(){return{customerId:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{companyName:"",invoiceNumber:"",address:"",bankName:"",bankCode:"",mobile:"",remark:"",customerId:"",customerInvoiceId:""},tempLable:{},tempNotEditable:{},rules:{},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{temp:{},title:""},CustomerInvoiceDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择开票信息",tableUrl:"/base/customerInvoice/listPageCustomerInvoices",tableParm:{fieldCode:"companyName,invoiceNumber,address,bankName,mobile,remark,isdefaultStr",customerId:this.initData.customerId},temp:{}},dialogName:"dialogOption"}}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.temp.customerInvoiceId=this.temp.id)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=o(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){(e={}).resState=this.resState,this.$emit("close-dialog",e||{})},save:function(){var e=this;this.$refs.submitForm.validate(function(t){t&&(e.dialogData.temp=JSON.parse(JSON.stringify(e.temp)),e.dialogData.title="选择订单",e.openDialogName="dialogAdd",e.showDialog=!0,e.inLinVisible=!0)})},customerInvoiceSelect:function(e){e[0]&&(this.temp.customerInvoiceId=e[0].id,this.temp.customerId=this.initData.customerId,this.temp.companyName=e[0].companyName,this.temp.invoiceNumber=e[0].invoiceNumber,this.temp.address=e[0].address,this.temp.bankName=e[0].bankName,this.temp.bankCode=e[0].bankCode,this.temp.mobile=e[0].mobile,this.temp.remark=e[0].remark)},addCustomerInvoice:function(){this.temp={},this.temp.customerId=this.initData.customerId,this.dialogData.customerId=this.initData.customerId,this.dialogData.temp=JSON.parse(JSON.stringify(this.temp)),this.dialogData.title="新增开票信息",this.openDialogName="dialogAddCustomerInvoice",this.showDialog=!0,this.inLinVisible=!0},closeDialog:function(e){e.resState&&(this.resState=e.resState),this.isVisible=!1}}},l=i("KHd+"),s=Object(l.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"450px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"75%","padding-top":"10px"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"75px"}},[i("el-form-item",{attrs:{label:"名称:",prop:"companyName"}},[i("base-input-option",{staticStyle:{display:"inline-block",width:"240px"},attrs:{disabled:!0,dialog:e.CustomerInvoiceDialog.dialog},on:{callback:e.customerInvoiceSelect},model:{value:e.temp.companyName,callback:function(t){e.$set(e.temp,"companyName",t)},expression:"temp.companyName"}}),e._v(" "),i("el-button",{staticStyle:{display:"inline-block",padding:"0px"},attrs:{size:"medium",type:"text",icon:"el-icon-plus"},on:{click:e.addCustomerInvoice}})],1),e._v(" "),i("el-form-item",{attrs:{label:"税号:",prop:"invoiceNumber"}},[i("el-input",{staticStyle:{width:"260px"},attrs:{disabled:!0},model:{value:e.temp.invoiceNumber,callback:function(t){e.$set(e.temp,"invoiceNumber",t)},expression:"temp.invoiceNumber"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"地址:",prop:"address"}},[i("el-input",{staticStyle:{width:"260px"},attrs:{disabled:!0},model:{value:e.temp.address,callback:function(t){e.$set(e.temp,"address",t)},expression:"temp.address"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"电话:",prop:"mobile"}},[i("el-input",{staticStyle:{width:"260px"},attrs:{disabled:!0},model:{value:e.temp.mobile,callback:function(t){e.$set(e.temp,"mobile",t)},expression:"temp.mobile"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"开户银行:",prop:"bankName"}},[i("el-input",{staticStyle:{width:"260px"},attrs:{disabled:!0},model:{value:e.temp.bankName,callback:function(t){e.$set(e.temp,"bankName",t)},expression:"temp.bankName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"账号:",prop:"bankCode"}},[i("el-input",{staticStyle:{width:"260px"},attrs:{disabled:!0},model:{value:e.temp.bankCode,callback:function(t){e.$set(e.temp,"bankCode",t)},expression:"temp.bankCode"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{staticStyle:{width:"260px"},attrs:{type:"textarea",rows:"2",disabled:!0},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="dialogEditCustomerInvoice.vue";t.default=s.exports},rdjU:function(e,t,i){"use strict";i.r(t);i("91GP");var a=i("WIyV"),o=i("6tA9"),n=i("hI+3"),l=i("rPmT"),s=i("QmdA");function r(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var m={components:{customBaseTable:a.a,dialogAdd:o.default,dialogEditCustomerInvoice:l.default,dialogAddCustomerInvoice:n.default},name:"dialog-add",props:["initData","visible"],data:function(){var e;return r(e={queryForm:{name:""},rowTableList:[],guid:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",orderDetail_style:"",deliverDetail_style:"",orderId:"",orderObject:{},title:"",temp:null,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,resState:"",temp:{},tempLable:{},currentpage:1,searchObj:{},tableData:[]},"rowTableList",[]),r(e,"configs",{tableConfigs:[],showCheckBox:!1,showIndex:!1}),r(e,"apiObj",{apiName:"getInvoiceAmount",params:{fieldCode:"customerName"}}),r(e,"customColumn",[]),r(e,"mergeTitle",[]),r(e,"mergeColumn",[]),r(e,"mergeRow",[]),e},created:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName},setApiObj:function(){return this.apiObj.params=Object.assign({},this.apiObj.params,this.searchObj),this.apiObj}},watch:{},methods:{getData:function(){this.$refs.dialogFinanceInvoice.getData()},formData:function(e){},databridge:function(e){Array.isArray(e)&&(this.rowTableList=[],this.rowTableList=e)},dialogOpen:function(){},dialogClose:function(e){(e={}).resState=this.resState,this.$emit("close-dialog",e||{})},addInvoice:function(){var e=this;if(null!=this.rowTableList&&0!=this.rowTableList.length){var t=this.rowTableList[0].customerId,i=this.rowTableList[0].customerName;Object(s.findIsExistCustomerInvoice)({customerId:t}).then(function(a){"false"==a.isExistCustomerInvoice?(e.dialogData.customerId=t,e.dialogData.customerName=i,e.dialogData.title="客户开票信息",e.openDialogName="dialogAddCustomerInvoice",e.showDialog=!0,e.inLinVisible=!0):(e.dialogData.temp=a.customerInvoice,e.dialogData.customerId=t,e.dialogData.title="客户开票信息",e.openDialogName="dialogEditCustomerInvoice",e.showDialog=!0,e.inLinVisible=!0)})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条数据！"})},closeDialog:function(e){e.resState&&(this.resState=e.resState),this.isVisible=!1},queryTable:function(){this.setApiObj()},resetQueryTemp:function(){for(var e in this.queryForm)this.queryForm[e]="";this.setApiObj()}}},d=i("KHd+"),c=Object(d.a)(m,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"600px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{staticStyle:{height:"50px"}},[i("el-form",{staticClass:"form-inline",staticStyle:{width:"90%",margin:"10px auto","padding-top":"10px"},attrs:{inline:!0,model:e.queryForm}},[i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"名称："}},[i("el-input",{staticStyle:{width:"230px"},attrs:{placeholder:"名称"},model:{value:e.queryForm.name,callback:function(t){e.$set(e.queryForm,"name",t)},expression:"queryForm.name"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:10}},[i("div",{attrs:{align:"right"}},[i("el-form-item",[i("base-button",{attrs:{name:"查询",icon:"search"},on:{myclick:e.queryTable}})],1),e._v(" "),i("el-form-item",[i("base-button",{attrs:{name:"重置",icon:"refresh",plain:!0},on:{myclick:e.resetQueryTemp}})],1)],1)])],1)],1),e._v(" "),i("el-row",{staticStyle:{width:"98%",margin:"0 1%",border:"1px solid #ebeef5"}},[i("custom-base-table",{ref:"dialogFinanceInvoice",attrs:{"data-custom-table-id":"views_sale_saleInvoice_dialogFinanceInvoice0",isSortable:!1,varList:e.tableData,keyValue:!1,isSingle:!0,showCheckBox:!0,showIndex:!1,showTableSet:!1,customColumn:e.customColumn,apiObj:e.setApiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"orderAddByInvoiceDialog",useDefaultBtn:!1,showAll:!1},on:{databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.addInvoice}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);c.options.__file="dialogFinanceInvoice.vue";t.default=c.exports}}]);