(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4da4","chunk-aafd"],{"67kp":function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf");var a=i("fFUy"),o=i("uTIz"),n=i("HltP");function s(e){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var l={props:["colConfig","scope"],template:'<div class="btnBox">\n              <el-button v-show="colConfig.infoByParent_isShow" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.infoByParent(scope.row,scope.$index)">详情</el-button>\n    \t\t\t\t </div>'},r={components:{searchBar:o.a,customRowTable:a.a,dialogAdd:n.default},name:"dialog-add",props:["initData","visible"],data:function(){return{rowTableList:[],orderData:{id:"",customerId:"",receiptType:"",receiptTypeName:"",custInvoiceCompanyName:"",custInvoiceNumber:"",custInvoiceAddress:"",custInvoiceBankName:"",custInvoiceBankCode:"",custInvoiceMobile:"",custInvoicePhone:""},guid:"",searchList:[{label:"订单编号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单编号"}],openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",temp:null,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,resState:"",temp:{},tempLable:{},currentpage:1,searchObj:{},customColumn:{0:[{columnIndex:"last",prop:"operate",label:"操作",component:l,infoByParent_isShow:!0}],1:[{}]},tableSets:{0:{showCheckBox:!0,showIndex:!0,expandOne:!1,isSortable:!1,showPageData:!0,isSingle:!0},1:{showCheckBox:!1,showIndex:!1,isSortable:!1,isSingle:!0}},precision:2,apiObj:{apiName:"listPageOrderByInvoice",params:{pageNo:1}},mergeColumn:{0:[{index:3,columns:["orderDate","expectDate"]},{index:6,columns:["orderSum","receiveSum"]},{index:7,columns:["deliverSum","invoiceSum"]}]}}},created:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=s(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.orderTableByInvoice.getData()},formData:function(e){},databridge:function(e){Array.isArray(e)&&(this.rowTableList=[],this.rowTableList=e)},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",{resState:this.resState})},rowTableList2OrderData:function(e){if(this.orderData={id:"",customerId:"",receiptType:"",receiptTypeName:"",custInvoiceCompanyName:"",custInvoiceNumber:"",custInvoiceAddress:"",custInvoiceBankName:"",custInvoiceBankCode:"",custInvoiceMobile:"",custInvoicePhone:""},null!=e&&0!=e.length){var t=e[0];this.orderData.id=t.id,this.orderData.customerId=t.customerId,this.orderData.receiptType=t.receiptType,this.orderData.receiptTypeName=t.receiptTypeName,this.orderData.custInvoiceCompanyName=t.custInvoiceCompanyName,this.orderData.custInvoiceNumber=t.custInvoiceNumber,this.orderData.custInvoiceAddress=t.custInvoiceAddress,this.orderData.custInvoiceBankName=t.custInvoiceBankName,this.orderData.custInvoiceBankCode=t.custInvoiceBankCode,this.orderData.custInvoiceMobile=t.custInvoiceMobile,this.orderData.custInvoicePhone=t.custInvoicePhone}},addInvoice:function(){this.$refs.orderTableByInvoice.getData(),null!=this.rowTableList&&0!=this.rowTableList.length?(this.rowTableList2OrderData(this.rowTableList),this.dialogData.temp=this.orderData,this.dialogData.title="选择订单",this.openDialogName="dialogAdd",this.showDialog=!0,this.inLinVisible=!0):this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条数据！"})},closeDialog:function(e){"ok"==e.resState&&(this.resState="ok",this.isVisible=!1)}}},c=i("KHd+"),d=Object(c.a)(r,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[i("custom-row-table",{ref:"orderTableByInvoice",attrs:{"expand-all":!0,keyValue:!0,configs:e.tableSets,currentpage:e.currentpage,customColumn:e.customColumn,editable:{},precision:e.precision,apiObj:e.apiObj,mergeColumn:e.mergeColumn},on:{"update:currentpage":function(t){e.currentpage=t},"get-data":e.formData,databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.addInvoice}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);d.options.__file="dialogOrderByInvoice.vue";t.default=d.exports},"8ptq":function(e,t,i){"use strict";i.r(t);i("Oyvg");var a=i("WIyV"),o=i("CK78"),n={components:{customBaseTable:a.a},props:["initData","visible"],data:function(){return{receiptType:"1",productUnit:{},rowData:{},rules:{},openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],rowTableList:[],configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},apiObj:{apiName:"listPageSaleInvoiceDetail",params:{pageNo:1,fieldCode:"",parentId:""}},customColumn:[{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"sum",_cellConfig:{hideTitle:!0,compute:"self@count(*)self@productPrice"}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.temp=this.initData.temp,null!=this.initData.temp.receiptType&&this.initData.temp.receiptType.trim().length>0&&(this.receiptType=this.initData.temp.receiptType.trim()),null!=this.initData.temp.id&&this.initData.temp.id.trim().length>0&&(this.apiObj.params.parentId=this.initData.temp.id.trim())},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){Array.isArray(e)&&(this.rowTableList=[],this.rowTableList=e,this.saveSaleOrder(this.rowTableList))},save:function(){this.$refs.orderAddByInvoiceDialog.getData()},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i].count;null!=a&&0!=a.trim().length||(t=t+"第 "+(i+1)+" 行: 开票数量为空或空字符串！"),null!=a&&a.trim().length>0&&!this.isNumberByValue(a.trim())&&(t=t+"第 "+(index+1)+" 行: 开票数量("+a+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return t},saveSaleOrder:function(e){var t=this,i=this.checkColumn(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{for(var a=[],n=0;n<e.length;n++){var s=e[n];a.push(s)}this.temp.dtlJsonStr="",null!=a&&a.length>0&&(this.temp.dtlJsonStr=JSON.stringify(a)),this.dialogLoading=!0,Object(o.updateSaleInvoice)(this.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},s=i("KHd+"),l=Object(s.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",{staticStyle:{margin:"10px 50px"}},[i("el-radio-group",{model:{value:e.receiptType,callback:function(t){e.receiptType=t},expression:"receiptType"}},[i("el-radio",{attrs:{label:"1"}},[e._v("不开票")]),e._v(" "),i("el-radio",{attrs:{label:"2"}},[e._v("增值税普通发票")]),e._v(" "),i("el-radio",{attrs:{label:"3"}},[e._v("增值税专用发票")])],1)],1),e._v(" "),i("div",{staticStyle:{"padding-left":"50px"}},[i("p",[i("a",[e._v("公司名称:")]),e._v(e._s(e.temp.custInvoiceCompanyName))]),e._v(" "),i("p",[i("a",[e._v("发票税号:")]),e._v(e._s(e.temp.custInvoiceNumber))]),e._v(" "),i("p",[i("a",[e._v("地址:")]),e._v(e._s(e.temp.custInvoiceAddress))]),e._v(" "),i("p",[i("a",[e._v("电话:")]),e._v(e._s(e.temp.custInvoiceMobile))]),e._v(" "),i("p",[i("a",[e._v("开户银行:")]),e._v(e._s(e.temp.custInvoiceBankName))]),e._v(" "),i("p",[i("a",[e._v("银行账号:")]),e._v(e._s(e.temp.custInvoiceBankCode))])]),e._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[i("custom-base-table",{ref:"orderAddByInvoiceDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"orderAddByInvoiceDialog",useDefaultBtn:!0,showAll:!1},on:{databridge:e.databridge}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);l.options.__file="dialogEdit.vue";t.default=l.exports},HltP:function(e,t,i){"use strict";i.r(t);i("Oyvg");var a=i("WIyV"),o=i("CK78"),n={components:{customBaseTable:a.a},props:["initData","visible"],data:function(){return{fieldCode:"productCode,productName,productSpec,productGenreName,priceUnitName,count,productPrice,productSum,invoiceCount,nowInvoiceCount,nowInvoiceSum",receiptType:"1",productUnit:{},rowData:{},rules:{},openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],rowTableList:[],configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},apiObj:{apiName:"listPageOrderDetailByInvoice",params:{pageNo:1,fieldCode:"",parentId:""}},customColumn:[{columnIndex:"nowInvoiceCount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"nowInvoiceSum",_cellConfig:{hideTitle:!0,compute:"self@nowInvoiceCount(*)self@productPrice"}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.temp=this.initData.temp,null!=this.initData.temp.receiptType&&this.initData.temp.receiptType.trim().length>0&&(this.receiptType=this.initData.temp.receiptType.trim()),null!=this.initData.temp.id&&this.initData.temp.id.trim().length>0&&(this.apiObj.params.parentId=this.initData.temp.id.trim()),this.apiObj.params.fieldCode=this.fieldCode},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){Array.isArray(e)&&(this.rowTableList=[],this.rowTableList=e,this.saveSaleOrder(this.rowTableList))},save:function(){this.$refs.orderAddByInvoiceDialog.getData()},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i].nowInvoiceCount;null!=a&&0!=a.trim().length||(t=t+"第 "+(i+1)+" 行: 开票数量为空或空字符串！"),null!=a&&a.trim().length>0&&!this.isNumberByValue(a.trim())&&(t=t+"第 "+(index+1)+" 行: 开票数量("+count+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return t},saveSaleOrder:function(e){var t=this,i=this.checkColumn(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{for(var a=[],n=0;n<e.length;n++){var s=e[n];s.count=s.nowInvoiceCount,a.push(s)}this.temp.dtlJsonStr="",null!=a&&a.length>0&&(this.temp.dtlJsonStr=JSON.stringify(a)),this.dialogLoading=!0,Object(o.addSaleInvoice)(this.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},s=i("KHd+"),l=Object(s.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",{staticStyle:{margin:"10px 50px"}},[i("el-radio-group",{model:{value:e.receiptType,callback:function(t){e.receiptType=t},expression:"receiptType"}},[i("el-radio",{attrs:{label:"1"}},[e._v("不开票")]),e._v(" "),i("el-radio",{attrs:{label:"2"}},[e._v("增值税普通发票")]),e._v(" "),i("el-radio",{attrs:{label:"3"}},[e._v("增值税专用发票")])],1)],1),e._v(" "),i("div",{staticStyle:{"padding-left":"50px"}},[i("p",[i("a",[e._v("公司名称:")]),e._v(e._s(e.temp.custInvoiceCompanyName))]),e._v(" "),i("p",[i("a",[e._v("发票税号:")]),e._v(e._s(e.temp.custInvoiceNumber))]),e._v(" "),i("p",[i("a",[e._v("地址:")]),e._v(e._s(e.temp.custInvoiceAddress))]),e._v(" "),i("p",[i("a",[e._v("电话:")]),e._v(e._s(e.temp.custInvoiceMobile))]),e._v(" "),i("p",[i("a",[e._v("开户银行:")]),e._v(e._s(e.temp.custInvoiceBankName))]),e._v(" "),i("p",[i("a",[e._v("银行账号:")]),e._v(e._s(e.temp.custInvoiceBankCode))])]),e._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[i("custom-base-table",{ref:"orderAddByInvoiceDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"orderAddByInvoiceDialog",useDefaultBtn:!0,showAll:!1},on:{databridge:e.databridge}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);l.options.__file="dialogAdd.vue";t.default=l.exports},Kabk:function(e,t,i){"use strict";var a={name:"tabs-table",components:{customRowTable:i("fFUy").a},props:{tableConfig:{type:Object,default:function(){return{}}},tabs:{type:Array,default:function(){return[]}}},data:function(){return{activeName:""}},computed:{},watch:{},methods:{databridge:function(e){this.$emit("databridge",e)},handleClick:function(e,t){this.$emit("tabsKey",this.activeName)}},created:function(){this.activeName=this.tabs[0].key},mounted:function(){}},o=(i("Yn/c"),i("KHd+")),n=Object(o.a)(a,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-tabs",{on:{"tab-click":e.handleClick},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[e._l(e.tabs,function(t,a){return[i("el-tab-pane",{key:a,attrs:{label:t.label,name:t.key}},[t.btnName?i("el-button",{staticStyle:{"margin-bottom":"5px"},attrs:{type:"primary",size:"mini",disabled:t.disabled},domProps:{textContent:e._s(t.btnName)},on:{click:function(e){t.method(t)}}}):e._e(),e._v(" "),e.activeName===t.key?i(t.componentName,{tag:"component",attrs:{baseHeight:e.tableConfig.baseHeight?e.tableConfig.baseHeight:"calc(100% - 40px)",baseBorder:e.tableConfig.baseBorder?e.tableConfig.baseBorder:"1px solid #E4E4E4","expand-all":void 0===e.tableConfig["expand-all"]||e.tableConfig["expand-all"],keyValue:void 0===e.tableConfig.keyValue||e.tableConfig.keyValue,configs:e.tableConfig.configs,customColumn:e.tableConfig.customColumn,columnGlobalStyle:e.tableConfig.columnGlobalStyle,editable:e.tableConfig.editable?e.tableConfig.editable:{},apiObj:t.apiObj||{},mergeColumn:e.tableConfig.mergeColumn},on:{databridge:e.databridge}}):e._e()],1)]})],2)},[],!1,null,"9b7e86c6",null);n.options.__file="index.vue";t.a=n.exports},Kbtb:function(e,t,i){"use strict";i.r(t);i("91GP"),i("INYr");var a=i("uTIz"),o=i("Kabk"),n=i("67kp"),s=i("8ptq"),l=i("CK78"),r={components:{searchBar:a.a,tabsTable:o.a,dialogOrderByInvoice:n.default,dialogEdit:s.default},data:function(){return{openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null},searchList:[{label:"订单编号",type:"input",ruleType:"string",mapKey:"orderSysCode",configs:{},placeholder:"订单编号"}],guid:"",currentpage:1,searchObj:{},activeName:"first",isFinance:!1,tableConfig:{configs:{0:{showCheckBox:!1,showIndex:!1,expandOne:!1,isSortable:!1,showPageData:!0},1:{showCheckBox:!1,showIndex:!0,isSortable:!1,isSingle:!0}},customColumn:{0:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"详情",editBtns_isShow:!0,icon:"add",method:this.infoByParent},{name:"修改",editBtns_isShow:!0,icon:"add",method:this.editByParent},{name:"删除",editBtns_isShow:!0,icon:"add",method:this.deleteByParent}]}]},mergeColumn:{0:[{index:1,columns:["orderSysCode","customerName","receiptTypeName","custInvoiceBankName","totalSum"]},{index:2,columns:["custInvoiceCompanyName","custInvoiceMobile","custInvoiceNumber","custInvoiceAddress","custInvoiceBankCode"]},{index:3,columns:["cuserDeptName","cuserName","cdate","stateName"]}]},columnGlobalStyle:{0:{titleStyle:{"font-size":"14px","font-weight":600,color:"#000000"},bodyStyle:{color:"#199ED4"}}},apiObj:{apiName:"listPageSaleInvoice",params:{state:"0"}}},tabs:[{label:"待开票",key:"first",btnName:"申请开票",method:this.addInvoice,disabled:!1,componentName:"customRowTable",apiObj:{apiName:"listPageSaleInvoice",params:{state:"0"}}},{label:"已开票",key:"second",btnName:"申请开票",disabled:!0,componentName:"customRowTable",apiObj:{apiName:"listPageSaleInvoice",params:{state:"1"}}}],tabsKey:"first"}},created:function(){},mounted:function(){},methods:{sendTabsKey:function(e){this.tabsKey=e},closeDialog:function(e){var t=this;if("ok"==e.resState){var i=this.tabs.findIndex(function(e){return e.key===t.tabsKey});i>-1&&(this.tabs[i].apiObj.params=Object.assign({},this.tabs[i].apiObj.params,this.searchObj))}},addInvoice:function(e){this.dialogData.title="选择订单",this.openDialogName="dialogOrderByInvoice",this.showDialog=!0,this.visible=!0},databridge:function(e){},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.tableConfig.apiObj.params=Object.assign({},this.tableConfig.apiObj.params,this.searchObj)},infoByParent:function(e,t){},editByParent:function(e,t,i){this.$storage.get("userInfo").userId==e.cuser?"1"!=e.state?(this.dialogData.temp=e,this.dialogData.title="编辑订单",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0):this.$message({type:"warning",duration:5e3,showClose:!0,message:"开票单状态(已开票)不可修改！"}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是创建人不可修改！"})},deleteByParent:function(e,t){var i=this;this.$storage.get("userInfo").userId==e.cuser?"1"!=e.state?this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(l.deleteSaleInvoice)({id:e.id}).then(function(e){if(0===e.code){i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3});var t=i.tabs.findIndex(function(e){return e.key===i.tabsKey});t>-1&&(i.tabs[t].apiObj.params=Object.assign({},i.tabs[t].apiObj.params,i.searchObj))}}).catch(function(e){})}).catch(function(){i.$message({type:"info",message:"已取消删除"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"开票单状态(已开票)不可删除！"}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是创建人不可删除！"})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{currentpage:function(){}}},c=(i("fm/h"),i("KHd+")),d=Object(c.a)(r,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"invoice"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticStyle:{"border-bottom":"none",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("tabs-table",{attrs:{tabs:e.tabs,tableConfig:e.tableConfig},on:{tabsKey:e.sendTabsKey,databridge:e.databridge}})],1),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);d.options.__file="index.vue";t.default=d.exports},NNGy:function(e,t,i){},"Yn/c":function(e,t,i){"use strict";var a=i("tlAi");i.n(a).a},"fm/h":function(e,t,i){"use strict";var a=i("NNGy");i.n(a).a},tlAi:function(e,t,i){}}]);