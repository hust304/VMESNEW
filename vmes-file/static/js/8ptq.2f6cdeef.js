(window.webpackJsonp=window.webpackJsonp||[]).push([["8ptq"],{"8ptq":function(e,t,i){"use strict";i.r(t);i("Oyvg");var o=i("WIyV"),a=i("CK78"),n={components:{customBaseTable:o.a},props:["initData","visible"],data:function(){return{receiptType:"1",productUnit:{},rowData:{},rules:{},openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],rowTableList:[],configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},apiObj:{apiName:"listPageSaleInvoiceDetail",params:{pageNo:1,fieldCode:"productCode,productName,productSpec,productGenreName,priceUnitName,orderCount,productPrice,productSum,notInvoiceCount,count,nowInvoiceSum",parentId:""}},customColumn:[{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"},{lessThan:["self@notInvoiceCount",!0]}],message:["请输入大于零的正整数或(1,2)位小数！","必须小于等于未开发票数量！"]}},{columnIndex:"sum",componentName:"input",_cellConfig:{hideTitle:!0,editable:!1,compute:"self@count(*)self@productPrice"}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.temp=this.initData.temp,null!=this.initData.temp.receiptType&&this.initData.temp.receiptType.trim().length>0&&(this.receiptType=this.initData.temp.receiptType.trim()),null!=this.initData.temp.id&&this.initData.temp.id.trim().length>0&&(this.apiObj.params.parentId=this.initData.temp.id.trim())},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){Array.isArray(e)&&(this.rowTableList=[],this.rowTableList=e,this.saveSaleOrder(this.rowTableList))},save:function(){this.$refs.orderAddByInvoiceDialog.getData()},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var o=e[i].count;null!=o&&0!=o.trim().length||(t=t+"第 "+(i+1)+" 行: 开票数量为空或空字符串！"),null!=o&&o.trim().length>0&&!this.isNumberByValue(o.trim())&&(t=t+"第 "+(index+1)+" 行: 开票数量("+o+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return t},saveSaleOrder:function(e){var t=this,i=this.checkColumn(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{for(var o=[],n=0;n<e.length;n++){var l=e[n];o.push(l)}this.temp.dtlJsonStr="",null!=o&&o.length>0&&(this.temp.dtlJsonStr=JSON.stringify(o)),this.dialogLoading=!0,Object(a.updateSaleInvoice)(this.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},l=i("KHd+"),s=Object(l.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",{staticStyle:{margin:"10px 50px"}},[i("el-radio-group",{model:{value:e.receiptType,callback:function(t){e.receiptType=t},expression:"receiptType"}},[i("el-radio",{attrs:{label:2}},[e._v("增值税普通发票")]),e._v(" "),i("el-radio",{attrs:{label:3}},[e._v("增值税专用发票")])],1)],1),e._v(" "),i("div",{staticStyle:{"padding-left":"50px"}},[i("p",[i("a",[e._v("公司名称:")]),e._v(e._s(e.temp.custInvoiceCompanyName))]),e._v(" "),i("p",[i("a",[e._v("发票税号:")]),e._v(e._s(e.temp.custInvoiceNumber))]),e._v(" "),i("p",[i("a",[e._v("地址:")]),e._v(e._s(e.temp.custInvoiceAddress))]),e._v(" "),i("p",[i("a",[e._v("电话:")]),e._v(e._s(e.temp.custInvoiceMobile))]),e._v(" "),i("p",[i("a",[e._v("开户银行:")]),e._v(e._s(e.temp.custInvoiceBankName))]),e._v(" "),i("p",[i("a",[e._v("银行账号:")]),e._v(e._s(e.temp.custInvoiceBankCode))])]),e._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{width:"96%","margin-left":"2%"}},[i("custom-base-table",{ref:"orderAddByInvoiceDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"orderAddByInvoiceDialog",useDefaultBtn:!0,showAll:!1},on:{databridge:e.databridge}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);s.options.__file="dialogEdit.vue";t.default=s.exports}}]);