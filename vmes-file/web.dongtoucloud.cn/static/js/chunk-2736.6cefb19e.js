(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-2736","HltP"],{Ey5t:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("Oyvg");var o=i("HltP"),a=i("QmdA");function n(e){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var l={components:{dialogAdd:o.default},name:"dialog-add",props:["initData","visible"],data:function(){return{customerId:"",orderData:{},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{companyName:"",invoiceNumber:"",address:"",bankName:"",bankCode:"",mobile:"",remark:"",customerId:""},tempLable:{},tempNotEditable:{},rules:{},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{temp:{},title:""}}},created:function(){this.customerId=this.initData.customerId,this.temp.customerId=this.initData.customerId,this.orderData=this.initData.orderData},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=n(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){(e={}).resState=this.resState,this.$emit("close-dialog",e||{})},isBankCodeNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[1-9][0-9]*$").test(e.trim())},checkBankCodeValue:function(e,t){var i="";return null!=e&&e.trim().length>0&&!this.isBankCodeNumberByValue(e.trim())&&(i=t+"("+e+")输入错误，请输入正确的账号！"),i},checkBankCode:function(e){var t=this.checkBankCodeValue(e,"账号");null!=t&&t.trim().length>0&&this.$message({type:"warning",duration:5e3,showClose:!0,message:t})},save:function(){var e=this,t=this;this.$refs.submitForm.validate(function(i){if(i){var o="",n=e.temp.bankCode,l=e.checkBankCodeValue(n,"账号");if(null!=l&&l.trim().length>0&&(o=o+" "+l),null!=o&&o.trim().length>0)return void e.$message({type:"warning",duration:5e3,showClose:!0,message:o});t.dialogLoading=!0,Object(a.a)(t.temp).then(function(i){t.dialogLoading=!1,0===i.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.orderData.custInvoiceCompanyName=t.temp.companyName,e.orderData.custInvoiceNumber=t.temp.invoiceNumber,e.orderData.custInvoiceAddress=t.temp.address,e.orderData.custInvoiceMobile=t.temp.mobile,e.orderData.custInvoiceBankName=t.temp.bankName,e.orderData.custInvoiceBankCode=t.temp.bankCode,e.dialogData.temp=e.orderData,e.dialogData.title="选择订单",e.openDialogName="dialogAdd",e.showDialog=!0,e.inLinVisible=!0)}).catch(function(e){t.dialogLoading=!1})}})},closeDialog:function(e){e.resState&&(this.resState=e.resState),this.isVisible=!1}}},s=i("KHd+"),r=Object(s.a)(l,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"350px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"90%","padding-top":"10px"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"名称:",prop:"companyName"}},[i("el-input",{model:{value:e.temp.companyName,callback:function(t){e.$set(e.temp,"companyName",t)},expression:"temp.companyName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"税号:",prop:"invoiceNumber"}},[i("el-input",{model:{value:e.temp.invoiceNumber,callback:function(t){e.$set(e.temp,"invoiceNumber",t)},expression:"temp.invoiceNumber"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"地址:",prop:"address"}},[i("el-input",{model:{value:e.temp.address,callback:function(t){e.$set(e.temp,"address",t)},expression:"temp.address"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"电话:",prop:"mobile"}},[i("el-input",{model:{value:e.temp.mobile,callback:function(t){e.$set(e.temp,"mobile",t)},expression:"temp.mobile"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"开户银行:",prop:"bankName"}},[i("el-input",{model:{value:e.temp.bankName,callback:function(t){e.$set(e.temp,"bankName",t)},expression:"temp.bankName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"账号:",prop:"bankCode"}},[i("el-input",{on:{change:e.checkBankCode},model:{value:e.temp.bankCode,callback:function(t){e.$set(e.temp,"bankCode",t)},expression:"temp.bankCode"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{attrs:{type:"textarea",rows:"2"},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="addCustomerInvoice.vue";t.default=r.exports},HltP:function(e,t,i){"use strict";i.r(t);i("Oyvg");var o=i("WIyV"),a=i("CK78"),n={components:{customBaseTable:o.a},props:["initData","visible"],data:function(){return{fieldCode:"productCode,productName,productSpec,productGenreName,priceUnitName,orderCount,productPrice,productSum,notInvoiceCount,count,nowInvoiceSum",receiptType:2,productUnit:{},rowData:{},rules:{},openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],rowTableList:[],configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},apiObj:{apiName:"listPageOrderDetailByInvoice",params:{pageNo:1,fieldCode:"productCode,productName,productSpec,productGenreName,priceUnitName,orderCount,productPrice,productSum,notInvoiceCount,count,nowInvoiceSum",parentId:""}},customColumn:[{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+\\.{0,1}[0-9]{0,2}$"},{lessThan:["self@notInvoiceCount",!0]}],message:["请输入大于零的正整数或(1,2)位小数！","必须小于等于未开发票数量！"]}},{columnIndex:"nowInvoiceSum",componentName:"input",_cellConfig:{hideTitle:!0,editable:!1,compute:"self@count(*)self@productPrice"}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.temp=this.initData.temp,null!=this.initData.temp.id&&this.initData.temp.id.trim().length>0&&(this.apiObj.params.parentId=this.initData.temp.id.trim()),this.apiObj.params.fieldCode=this.fieldCode},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){if(Array.isArray(e)){if(this.rowTableList=[],this.rowTableList=e,null==this.rowTableList||0==this.rowTableList.length)return void this.$message({type:"warning",duration:5e3,showClose:!0,message:"无开票明细！"});this.saveSaleOrder(this.rowTableList)}},save:function(){this.$refs.orderAddByInvoiceDialog.getData()},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+\\.{0,1}[0-9]{0,2}$").test(e.trim())},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var o=e[i],a=o.notInvoiceCount,n=o.count;null==n||0==n.trim().length?t=t+"第 "+(i+1)+" 行: 开票数量为空或空字符串！":null!=n&&n.trim().length>0&&!this.isNumberByValue(n.trim())&&(t=t+"第 "+(i+1)+" 行: 开票数量("+n+") 输入错误，请输入大于零的正整数或(1,2)位小数！"),n-a>0&&(t=t+"第 "+(i+1)+" 行: 开票数量("+n+") 输入错误，开票数量不可大于未开票数量！")}return t},saveSaleOrder:function(e){var t=this,i=this.checkColumn(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{for(var o=[],n=0;n<e.length;n++){var l=e[n];l.orderCount=l.count,o.push(l)}this.temp.dtlJsonStr="",null!=o&&o.length>0&&(this.temp.dtlJsonStr=JSON.stringify(o)),this.temp.receiptType=this.receiptType,this.dialogLoading=!0,Object(a.addSaleInvoice)(this.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},l=i("KHd+"),s=Object(l.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",{staticStyle:{margin:"10px 50px"}},[i("el-radio-group",{model:{value:e.receiptType,callback:function(t){e.receiptType=t},expression:"receiptType"}},[i("el-radio",{attrs:{label:2}},[e._v("增值税普通发票")]),e._v(" "),i("el-radio",{attrs:{label:3}},[e._v("增值税专用发票")])],1)],1),e._v(" "),i("div",{staticStyle:{"padding-left":"50px"}},[i("p",[i("a",[e._v("名称:")]),e._v(e._s(e.temp.custInvoiceCompanyName))]),e._v(" "),i("p",[i("a",[e._v("税号:")]),e._v(e._s(e.temp.custInvoiceNumber))]),e._v(" "),i("p",[i("a",[e._v("地址:")]),e._v(e._s(e.temp.custInvoiceAddress))]),e._v(" "),i("p",[i("a",[e._v("电话:")]),e._v(e._s(e.temp.custInvoiceMobile))]),e._v(" "),i("p",[i("a",[e._v("开户银行:")]),e._v(e._s(e.temp.custInvoiceBankName))]),e._v(" "),i("p",[i("a",[e._v("账号:")]),e._v(e._s(e.temp.custInvoiceBankCode))])]),e._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{width:"96%","margin-left":"2%"}},[i("custom-base-table",{ref:"orderAddByInvoiceDialog",attrs:{"data-custom-table-id":"views_sale_invoice_dialogAdd0",isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"orderAddByInvoiceDialog",useDefaultBtn:!0,showAll:!1},on:{databridge:e.databridge}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);s.options.__file="dialogAdd.vue";t.default=s.exports},QmdA:function(e,t,i){"use strict";i.d(t,"d",function(){return a}),i.d(t,"c",function(){return n}),i.d(t,"a",function(){return l}),i.d(t,"e",function(){return s}),i.d(t,"f",function(){return r}),i.d(t,"b",function(){return c});var o=i("t3Un");function a(e){return Object(o.a)({url:"/base/customerInvoice/listPageCustomerInvoices",method:"post",data:e})}function n(e){return Object(o.a)({url:"/base/customerInvoice/findIsExistCustomerInvoice",method:"post",data:e})}function l(e){return Object(o.a)({url:"/base/customerInvoice/addCustomerInvoice",method:"post",data:e})}function s(e){return Object(o.a)({url:"/base/customerInvoice/updateCustomerInvoice",method:"post",data:e})}function r(e){return Object(o.a)({url:"/base/customerInvoice/updateDefaultCustomerInvoice",method:"post",data:e})}function c(e){return Object(o.a)({url:"/base/customerInvoice/deleteCustomerInvoice",method:"post",data:{ids:e}})}}}]);