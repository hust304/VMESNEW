(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-687f","chunk-036e","chunk-2a99","chunk-39a3","rmg0"],{"01ds":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("rmg0");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{dialogAddCustomerInvoice:i("SwnK").default,dialogAdd:a.default},name:"dialog-add",props:["initData","visible"],data:function(){return{customerId:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{companyName:"",invoiceNumber:"",address:"",bankName:"",bankCode:"",mobile:"",remark:"",customerId:"",customerInvoiceId:""},tempLable:{},tempNotEditable:{},rules:{},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{temp:{},title:""},CustomerInvoiceDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择开票信息",tableUrl:"/base/customerInvoice/listPageCustomerInvoices",tableParm:{fieldCode:"companyName,invoiceNumber,address,bankName,mobile,remark,isdefaultStr",customerId:this.initData.customerId},temp:{}},dialogName:"dialogOption"}}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.temp.customerInvoiceId=this.temp.id)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){(t={}).resState=this.resState,this.$emit("close-dialog",t||{})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&(t.dialogData.temp=JSON.parse(JSON.stringify(t.temp)),t.dialogData.title="选择订单",t.openDialogName="dialogAdd",t.showDialog=!0,t.inLinVisible=!0)})},customerInvoiceSelect:function(t){t[0]&&(this.temp.customerInvoiceId=t[0].id,this.temp.customerId=this.initData.customerId,this.temp.companyName=t[0].companyName,this.temp.invoiceNumber=t[0].invoiceNumber,this.temp.address=t[0].address,this.temp.bankName=t[0].bankName,this.temp.bankCode=t[0].bankCode,this.temp.mobile=t[0].mobile,this.temp.remark=t[0].remark)},addCustomerInvoice:function(){this.temp={},this.temp.customerId=this.initData.customerId,this.dialogData.customerId=this.initData.customerId,this.dialogData.temp=JSON.parse(JSON.stringify(this.temp)),this.dialogData.title="新增开票信息",this.openDialogName="dialogAddCustomerInvoice",this.showDialog=!0,this.inLinVisible=!0},closeDialog:function(t){t.resState&&(this.resState=t.resState),this.isVisible=!1}}},s=i("KHd+"),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"450px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"75%","padding-top":"10px"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"75px"}},[i("el-form-item",{attrs:{label:"名称:",prop:"companyName"}},[i("base-input-option",{staticStyle:{display:"inline-block"},attrs:{disabled:!0,dialog:t.CustomerInvoiceDialog.dialog},on:{callback:t.customerInvoiceSelect},model:{value:t.temp.companyName,callback:function(e){t.$set(t.temp,"companyName",e)},expression:"temp.companyName"}}),t._v(" "),i("el-button",{staticStyle:{display:"inline-block"},attrs:{size:"medium",type:"text",icon:"el-icon-plus"},on:{click:t.addCustomerInvoice}})],1),t._v(" "),i("el-form-item",{attrs:{label:"税号:",prop:"invoiceNumber"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.invoiceNumber,callback:function(e){t.$set(t.temp,"invoiceNumber",e)},expression:"temp.invoiceNumber"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"地址:",prop:"address"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.address,callback:function(e){t.$set(t.temp,"address",e)},expression:"temp.address"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"电话:",prop:"mobile"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.mobile,callback:function(e){t.$set(t.temp,"mobile",e)},expression:"temp.mobile"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"开户银行:",prop:"bankName"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.bankName,callback:function(e){t.$set(t.temp,"bankName",e)},expression:"temp.bankName"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"账号:",prop:"bankCode"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.bankCode,callback:function(e){t.$set(t.temp,"bankCode",e)},expression:"temp.bankCode"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{attrs:{type:"textarea",rows:"2",disabled:!0},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("下一步")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogEditCustomerInvoice.vue";e.default=l.exports},"3CKI":function(t,e,i){},AZ8z:function(t,e,i){"use strict";i.d(e,"a",function(){return s});i("rE2o"),i("ioFf"),i("dRSK"),i("Oyvg"),i("a1Th");function a(t){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}function o(t){return Object.prototype.toString.call(t).slice(8,-1)}function n(t){var e="";t.global&&(e+="g"),t.ignoreCase&&(e+="i"),t.multiline&&(e+="m");var i=new RegExp(t,e);return i.lastIndex=t.lastIndex,i}function s(t){if(null==t||"object"!==a(t))return t;var e;switch(o(t)){case"RegExp":return n(t);case"Date":return new Date(t.getTime());case"Function":return t;case"Array":e=[];break;default:e=Object.create(Object.getPrototypeOf(t))}for(var i=[],s=[{parent:e,key:void 0,data:t}],l=function(){var t=s.pop(),e=t.parent,l=t.key,r=t.data,c=e;if(void 0!==l)switch(o(r)){case"RegExp":return e[l]=n(r),"continue";case"Date":return e[l]=new Date(r.getTime()),"continue";case"Function":return e[l]=r,"continue";case"Array":c=e[l]=[];break;default:var u=Object.getPrototypeOf(r);c=e[l]=Object.create(u)}var d=i.find(function(t){return t.source===r});if(d)return e[l]=d.target,"continue";for(var m in i.push({source:r,target:c}),r)r.hasOwnProperty(m)&&(null==r[m]||"object"!==a(r[m])?c[m]=r[m]:s.push({parent:c,key:m,data:r[m]}))};s.length;)l();return e}},BsFA:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("91GP");var a=i("WIyV"),o=i("uTIz"),n=i("rmg0"),s=i("SwnK"),l=i("01ds"),r=i("QmdA");function c(t){return(c="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}function u(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var d={components:{searchBar:o.a,customBaseTable:a.a,dialogAdd:n.default,dialogEditCustomerInvoice:l.default,dialogAddCustomerInvoice:s.default},name:"dialog-add",props:["initData","visible"],data:function(){var t;return u(t={rowTableList:[],guid:"",searchList:[{label:"客户名称",type:"input",ruleType:"string",mapKey:"customerName",configs:{},placeholder:"客户名称"}],openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",orderDetail_style:"",deliverDetail_style:"",orderId:"",orderObject:{},title:"",temp:null,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,resState:"",temp:{},tempLable:{},currentpage:1,searchObj:{},tableData:[]},"rowTableList",[]),u(t,"configs",{tableConfigs:[],showCheckBox:!1,showIndex:!1}),u(t,"apiObj",{apiName:"getInvoiceAmount",params:{fieldCode:"customerName,uninvoiceAmount"}}),u(t,"customColumn",[]),u(t,"mergeTitle",[]),u(t,"mergeColumn",[]),u(t,"mergeRow",[]),t},created:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=c(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName},setApiObj:function(){return this.apiObj.params=Object.assign({},this.apiObj.params,this.searchObj),this.apiObj}},watch:{},methods:{getData:function(){this.$refs.dialogFinanceInvoice.getData()},formData:function(t){},databridge:function(t){Array.isArray(t)&&(this.rowTableList=[],this.rowTableList=t)},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.setApiObj()},dialogOpen:function(){},dialogClose:function(t){(t={}).resState=this.resState,this.$emit("close-dialog",t||{})},addInvoice:function(){var t=this;if(null!=this.rowTableList&&0!=this.rowTableList.length){var e=this.rowTableList[0].customerId;Object(r.c)({customerId:e}).then(function(i){"false"==i.isExistCustomerInvoice?(t.dialogData.customerId=e,t.dialogData.title="客户开票信息",t.openDialogName="dialogAddCustomerInvoice",t.showDialog=!0,t.inLinVisible=!0):(t.dialogData.temp=i.customerInvoice,t.dialogData.customerId=e,t.dialogData.title="客户开票信息",t.openDialogName="dialogEditCustomerInvoice",t.showDialog=!0,t.inLinVisible=!0)})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条数据！"})},closeDialog:function(t){t.resState&&(this.resState=t.resState),this.isVisible=!1}}},m=i("KHd+"),p=Object(m.a)(d,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{width:"98%",margin:"0 1%",border:"1px solid #ebeef5"}},[i("custom-base-table",{ref:"dialogFinanceInvoice",attrs:{"data-custom-table-id":"views_finance_financeInvoice_dialogFinanceInvoice0",isSortable:!1,varList:t.tableData,keyValue:!1,isSingle:!0,showCheckBox:!0,showIndex:!0,showTableSet:!1,customColumn:t.customColumn,apiObj:t.setApiObj,mergeTitle:t.mergeTitle,mergeColumn:t.mergeColumn,mergeRow:t.mergeRow,componentId:"orderAddByInvoiceDialog",useDefaultBtn:!1,showAll:!1},on:{databridge:t.databridge}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.addInvoice}},[t._v("下一步")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);p.options.__file="dialogFinanceInvoice.vue";e.default=p.exports},QmdA:function(t,e,i){"use strict";i.d(e,"d",function(){return o}),i.d(e,"c",function(){return n}),i.d(e,"a",function(){return s}),i.d(e,"e",function(){return l}),i.d(e,"f",function(){return r}),i.d(e,"b",function(){return c});var a=i("t3Un");function o(t){return Object(a.a)({url:"/base/customerInvoice/listPageCustomerInvoices",method:"post",data:t})}function n(t){return Object(a.a)({url:"/base/customerInvoice/findIsExistCustomerInvoice",method:"post",data:t})}function s(t){return Object(a.a)({url:"/base/customerInvoice/addCustomerInvoice",method:"post",data:t})}function l(t){return Object(a.a)({url:"/base/customerInvoice/updateCustomerInvoice",method:"post",data:t})}function r(t){return Object(a.a)({url:"/base/customerInvoice/updateDefaultCustomerInvoice",method:"post",data:t})}function c(t){return Object(a.a)({url:"/base/customerInvoice/deleteCustomerInvoice",method:"post",data:{ids:t}})}},SwnK:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("rmg0");i("QmdA");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{dialogAdd:a.default},name:"dialog-add",props:["initData","visible"],data:function(){return{customerId:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{companyName:"",invoiceNumber:"",address:"",bankName:"",bankCode:"",mobile:"",remark:"",customerId:""},tempLable:{},tempNotEditable:{},rules:{companyName:[{required:!0,message:"请填写公司名称",trigger:"change"}]},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{temp:{},title:""}}},created:function(){this.customerId=this.initData.customerId,this.temp.customerId=this.initData.customerId},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){(t={}).resState=this.resState,this.$emit("close-dialog",t||{})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&(t.dialogData.temp=JSON.parse(JSON.stringify(t.temp)),t.dialogData.title="选择订单",t.openDialogName="dialogAdd",t.showDialog=!0,t.inLinVisible=!0)})},closeDialog:function(t){t.resState&&(this.resState=t.resState),this.isVisible=!1}}},s=i("KHd+"),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"450px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"75%","padding-top":"10px"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"75px"}},[i("el-form-item",{attrs:{label:"名称:",prop:"companyName"}},[i("el-input",{model:{value:t.temp.companyName,callback:function(e){t.$set(t.temp,"companyName",e)},expression:"temp.companyName"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"税号:",prop:"invoiceNumber"}},[i("el-input",{model:{value:t.temp.invoiceNumber,callback:function(e){t.$set(t.temp,"invoiceNumber",e)},expression:"temp.invoiceNumber"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"地址:",prop:"address"}},[i("el-input",{model:{value:t.temp.address,callback:function(e){t.$set(t.temp,"address",e)},expression:"temp.address"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"电话:",prop:"mobile"}},[i("el-input",{model:{value:t.temp.mobile,callback:function(e){t.$set(t.temp,"mobile",e)},expression:"temp.mobile"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"开户银行:",prop:"bankName"}},[i("el-input",{model:{value:t.temp.bankName,callback:function(e){t.$set(t.temp,"bankName",e)},expression:"temp.bankName"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"账号:",prop:"bankCode"}},[i("el-input",{model:{value:t.temp.bankCode,callback:function(e){t.$set(t.temp,"bankCode",e)},expression:"temp.bankCode"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{attrs:{type:"textarea",rows:"2"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("下一步")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogAddCustomerInvoice.vue";e.default=l.exports},WIyV:function(t,e,i){"use strict";i("91GP"),i("dRSK"),i("rGqo"),i("INYr"),i("xfY5");var a=i("8WZi"),o=i("z0WU"),n=i("DKCI"),s=i("50Ol"),l=(i("F9dT"),i("Yfch"),i("YP4+")),r=i("WwWg"),c=i("AZ8z"),u=i("mwzG"),d={name:"single-table",mixins:[a.a],provide:function(){return{rootVm:this}},props:{varList:{type:Array,default:function(){return[]}},isFixed:{type:Number,default:1},isSortable:{type:Boolean,default:!1},isRemoval:{type:Boolean,default:!1},useDefaultBtn:{type:Boolean,default:!1},rowKey:{type:String,default:"id"}},data:function(){return{componentName:"singleTable",data:null,fixedList:[],scrollTimer:"",checkedViewHeight:0,pageId:"",initLoading:!0,headerWidthList:[],headerWidthTimerList:[],listLength:-1,selectOptionList:[],selectLoading:!1,tempVarList:[],guid:"",pageNo:1,defaultOperation:{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",method:this.defaultDeleteRow}]},constantWidth:l.a.tableComponentWidth,autoWidthTimer:{},autoWidthList:[],setScrollWidthTimer:-2,autoWidthSwitch:!1,autoWidths:[],columnWidth:{},isLoading:!0,fileList:[],removalVarListTimer:null}},components:{tableFilter:n.a,customSummaryOption:s.a},directives:{"auto-width":{inserted:function(t,e,i){var a=i.context,o=e.value.component?e.value.component.length:0;o>1&&t.clientHeight>60&&a.$set(a.columnWidth,e.value.prop,60*Math.ceil(o/2)+25+"px")}},"merga-width":{bind:function(t,e,i){!i.context.autoWidthTimer[e.value.id]&&(i.context.autoWidthTimer[e.value.id]=-1)},inserted:function(t,e,i){!i.context.autoWidthList.length&&(i.context.autoWidthList=i.context.setTitleList.map(function(t){return[]})),i.context.$nextTick(function(a){-1===i.context.autoWidthTimer[e.value.id]&&(i.context.autoWidthTimer[e.value.id]=setTimeout(function(a){var o=t.offsetWidth,n=e.value,s=i.context.autoWidthList;if(s[n.parentLayer].length)if(s[n.parentLayer][n.selfLayer]>-1){var l=s[n.parentLayer][n.selfLayer];s[n.parentLayer].splice(n.selfLayer,1,o+l)}else s[n.parentLayer][n.selfLayer]=o;else{var r=[];r[n.selfLayer]=o,s.splice(n.parentLayer,1,r)}},20))})}}},computed:{setColumnGlobalStyle:function(){return this.columnGlobalStyle},setVarList:function(){return this.varList.concat([])},removalVarList:function(){return this.removalVarLists(this.setVarList)},setInitLoading:function(){return this.mergeTitle.length?this.initLoading||this.isLoading:this.initLoading},setTableLoading:function(){return this.showTableSet?this.showTableSet&&this.setInitLoading:this.setInitLoading},tableData:function(){return this.$store.getters[this.guid+"/tableData"]||{}},resetPageDataHeight:function(){var t=0;return"boolean"==typeof this.hidePages?!this.hidePages&&this.hasPageData&&(t=this.setSmallPageHeight):void 0===this.hidePages&&(t=this.setSmallPageHeight),t},resetHeight:function(){return this.checkedViewHeight+this.customSummaryOptionHeight+this.resetPageDataHeight},tempCustomColumn:function(){return this.customColumn.concat([])},setCustomColumn:function(){if(this.useDefaultBtn){var t=this.tempCustomColumn.findIndex(function(t){return"last"===t.columnIndex});return t>-1?this.tempCustomColumn.splice(t,1,this.defaultOperation):this.tempCustomColumn.push(this.defaultOperation),this.tempCustomColumn}return this.tempCustomColumn}},created:function(){var t=this;console.log(this.setApiObj),this.guid=Object(o.a)(),Object(r.c)(this),this.setApiObj.apiName&&("0"===this.userInfo.userId?setTimeout(function(){t.data=u.a,t.data.result.varList&&t.data.result.varList.length>0&&t.data.result.varList.forEach(function(t){t.rowState="1"}),t.$store.commit(t.guid+"/SET_TABLEDATA",{res:t.data,vm:t}),t.pageId=t.$storage.get("menuId"),t.setDragTable&&t.setSort(),t.$store.commit(t.guid+"/SET_TABLERULELIST",{cb:t.tableRuleForm,ruleId:"root",vm:t}),t.initLoading=!1},1e3):this.httpRequests())},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},beforeDestroy:function(){!this.layer&&Object(r.g)(this.$store,this.guid)},updated:function(){},watch:{"tableData.tableData":function(){this.setFixed(),this.setTableCheckBoxDisplay()},"setApiObj.params":function(){this.httpRequests()},autoWidthList:{deep:!0,handler:function(t,e){var i=this;clearTimeout(this.setScrollWidthTimer),this.setScrollWidthTimer=setTimeout(function(e){i.autoWidths=t.map(function(t){var e=Math.max.apply(null,t);return e>-9999&&e<9999?e+20:0});var a=0;i.autoWidths.forEach(function(t){a+=t}),i.setShowCheckBox&&(a+=55),i.setShowIndex&&(a+=50),i.setDragTable&&(a+=50);var o=i.$el.clientWidth>a?(i.$el.clientWidth-a)/i.autoWidthList.length:0;i.autoWidths=i.autoWidths.map(function(t){return t?t+o:null}),i.setFixed(),i.autoWidthSwitch=!0,i.isLoading=!1},100)}},removalVarList:function(){var t=this;clearInterval(this.removalVarListTimer),this.removalVarListTimer=setInterval(function(e){t.tableData.titleList&&t.tableData.titleList.length&&(clearInterval(t.removalVarListTimer),t.pushData(t.removalVarList))},200)},initData:function(){var t=this;this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:null,ruleId:"root"});var e=JSON.parse(JSON.stringify(this.initData));this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setDragTable&&this.setSort(),this.pageNo=this.tableData.pageData&&this.tableData.pageData.current||1,this.initLoading=!1,this.$nextTick(function(e){t.scrollTable()}),this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:"root",vm:this})}},methods:{defaultDeleteRow:function(t,e,i){this.deleteData(t)},removalVarLists:function(t){var e=this;if("transferTable"===this.useScenarios)return Object(c.a)(t);var i=[];return t.forEach(function(t,a){!t._internalId&&(t._internalId=Object(o.p)());var n=JSON.parse(JSON.stringify(t));!e.tempVarList.find(function(t){return t._internalId===n._internalId})&&i.push(n)}),i.length&&(this.tempVarList=this.tempVarList.concat(i)),i},httpRequests:function(t){var e=this;this.initLoading=!0,this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:null,ruleId:"root"}),this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:t||1})).then(function(i){e.data=i,e.pageNo=i.result.pageData&&i.result.pageData.current||1,e.data.result.varList&&e.data.result.varList.length&&e.data.result.varList.forEach(function(t){t.rowState="1",t._internalId=Object(o.p)()}),e.$store.commit(e.guid+"/SET_TABLEDATA",{res:e.data,vm:e}),e.pageId=e.$storage.get("menuId"),e.setDragTable&&e.setSort(),e.initLoading=!1,t&&e.$nextTick(function(t){e.scrollTable()}),e.$store.commit(e.guid+"/SET_TABLERULELIST",{cb:e.tableRuleForm,ruleId:"root",vm:e})}).catch(function(t){console.log(t),e.initLoading=!1})},setStyle:function(t){},selectItem:function(t,e){this.$emit("databridge",t,e),this.isSingle&&(t.length?(this.tableData[this.dataName].forEach(function(t){t.rowState="0"}),t[0].rowState="1"):this.tableData[this.dataName].forEach(function(t){t.rowState="1"}))},selectAllItem:function(t){if(this.isSingle){if(t.length)for(var e=t.length-1;e>=0;e--)t.splice(e,1)}else this.$emit("databridge",t)},handleCurrentChange:function(t){t!==this.pageNo&&(this.setApiObj.apiName?this.httpRequests(t)&&(this.tempVarList=[]):this.$emit("current-change",t))},updateTable:function(){this.setApiObj&&this.setApiObj.apiName&&this.httpRequests()},updateData:function(){this.setApiObj&&this.setApiObj.apiName&&this.httpRequests()}}},m=(i("sV09"),i("KHd+")),p=Object(m.a)(d,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:!t.disableLoading&&t.setTableLoading,expression:"!disableLoading && setTableLoading"}],ref:"tableWrapper",staticClass:"columnBaseTable myCoustomTable resetCoustomTableStyle",staticStyle:{height:"100%",position:"relative"}},[t.showTableSet&&"outside"===t.tableSetMode?i("table-filter",{attrs:{headerList:t.setColConfigs,tableSwitchState:t.setTableSwitch,storeId:t.pageId,componentId:t.componentId},on:{"checked-list":t.checkedList,"checked-height":t.checkedHeight}}):t._e(),t._v(" "),i("div",{style:{height:t.setTableHeight}},[i("el-form",{ref:"ruleForm",style:{height:"100%"},attrs:{model:t.ruleForm,"status-icon":""},nativeOn:{submit:function(t){t.preventDefault()}}},[i("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:t.tableData.tableData,stripe:"",border:"","current-row-key":t.rowKey,"tooltip-effect":"dark",height:"100%",fit:"","header-cell-class-name":t.setStyle,"row-key":"_internalId","default-sort":t.setSortableConfig["default-sort"],"show-summary":t.setSysSummary},on:{select:t.selectItem,"select-all":t.selectAllItem,"selection-change":t.selectionChange,"sort-change":t.sortChange,"row-click":t.rowClick,"row-dblclick":t.rowDblclick}},[t.setShowCheckBox?[i("el-table-column",{attrs:{type:"selection",fixed:t.fixedState,selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.setShowIndex?[i("el-table-column",{attrs:{type:"index",index:t.indexMethod,fixed:t.fixedState,label:"序号",width:"50",align:"center"}})]:t._e(),t._v(" "),t._l(t.setTitleList,function(e,a){return[e.slot?i("tempalte",[t._t(e.slot,null,{fixed:t.setFixedList[a]})],2):Array.isArray(e.component)?[i("el-table-column",t._b({key:a,attrs:{"show-overflow-tooltip":"",fixed:t.setFixedList[a],"min-width":e.width||t.setColumnWidth[e.prop],align:"center"},scopedSlots:t._u([{key:"header",fn:function(o){return[i("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:a,isComponent:!0,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}],staticStyle:{display:"inline-flex","white-space":"nowrap"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(a){return[i("div",{directives:[{name:"auto-width",rawName:"v-auto-width",value:e,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":t.setColumnWidth[e.prop]?"space-between":"center"}},t._l(e.component,function(e,o){return void 0!==e.editBtns_isShow&&!e.editBtns_isShow||!e.rowState||t.setButtonState(a.$index,a.row,e)?i("el-button",{key:o,staticStyle:{height:"24px",width:"46px",padding:"0",margin:"0","font-size":"12px","max-width":"46px"},attrs:{type:"text"},on:{click:function(t){e.method(a.row,a.$index,a)}}},[t._v(t._s(e.name))]):t._e()}),1)]}}])},"el-table-column",e,!1))]:"object"!=typeof e.component||Array.isArray(e.component)?[e._isShow||"outside"!==t.tableSetMode?i("el-table-column",{key:a,attrs:{"show-overflow-tooltip":"",prop:e.prop,width:e._isShow?"":t.setTableColumnState?"20":"","min-width":e._isShow?e.width||t.constantWidth[e.componentName]||t.autoWidths[a]||null:"",sortable:void 0===e.sortable?t.isSortable:e.sortable,fixed:t.setFixedList[a],align:"center"},scopedSlots:t._u([{key:"header",fn:function(o){return[i("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:a,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"},{name:"custom-table-switch",rawName:"v-custom-table-switch",value:{config:e,index:a,showSwitch:t.setTableColumnState},expression:"{config:colConfig,index:infoIndex,showSwitch:setTableColumnState}"}],style:{display:e._isShow?"inline-flex":"none","white-space":"nowrap"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(o){return[i("core-index",{directives:[{name:"show",rawName:"v-show",value:!!e._isShow||"outside"===t.tableSetMode,expression:"colConfig._isShow?true:tableSetMode === 'outside'"}],attrs:{scope:o,"info-index":a,"col-config":e,runTime:"base"}})]}}])}):t._e()]:[i(e.component,{key:a,tag:"component",attrs:{"col-config":e,fixed:t.setFixedList[a]}})]]}),t._v(" "),t.setDragTable?[i("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:t._u([{key:"default",fn:function(t){return[i("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[i("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)]}}])})]:t._e()],2)],1),t._v(" "),t.setUseSummary&&t.setCustomSummary.component?[i("custom-summary-option",{attrs:{customSummary:t.setCustomSummary,tempData:t.setTempData,tableData:t.tableData.tableData},on:{"send-height":t.customSummaryHeight,"custom-summary-value":t.customSummaryValue}})]:t._e()],2),t._v(" "),!t.hidePages&&t.hasPageData?i("div",{staticStyle:{"text-align":"center"},style:{"margin-top":(t.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[i("el-pagination",{attrs:{background:!t.smallPage,small:t.smallPage,"current-page":t.tableData.pageData.current,"page-size":t.tableData.pageData.size,layout:"prev, pager, next, jumper",total:t.tableData.pageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.tableData.pageData,"current",e)}}})],1):t._e()],1)},[],!1,null,"37bf1899",null);p.options.__file="index.vue";e.a=p.exports},rmg0:function(t,e,i){"use strict";i.r(e);i("xfY5");var a=i("WIyV"),o=i("c5eW"),n={components:{customBaseTable:a.a},props:["initData","visible"],data:function(){return{receiptType:2,productUnit:{},rules:{},openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],rowTableList:[],configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},apiObj:{apiName:"getInvoiceAmount",params:{customerId:this.initData.temp.customerId,isNeedPage:"false",fieldCode:"customerCode,customerName,uninvoiceAmount,amount"}},customColumn:[{columnIndex:"amount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+\\.{0,1}[0-9]{0,2}$"},{lessThan:["self@uninvoiceAmount",!0]}],message:["请输入大于零的正整数或(1,2)位小数！","必须小于等于未开发票数量！"]}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.temp=this.initData.temp,null!=this.initData.temp.receiptType&&this.initData.temp.receiptType.trim().length>0&&(this.receiptType=Number(this.initData.temp.receiptType)),null!=this.initData.temp.id&&this.initData.temp.id.trim().length>0&&(this.apiObj.params.parentId=this.initData.temp.id.trim())},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(t){if(Array.isArray(t)){if(this.rowTableList=t,!(this.rowTableList.length>0))return void this.$message({type:"warning",duration:5e3,showClose:!0,message:"至少要选择一条记录！"});this.saveFinanceInvoice(this.rowTableList)}},save:function(){this.$refs.orderAddByInvoiceDialog.getData()},saveFinanceInvoice:function(t){for(var e=this,i=0;i<t.length;i++){var a=t[i];this.temp.amount=a.amount}this.temp.type=this.receiptType,this.dialogLoading=!0,Object(o.saveFinanceInvoice)(this.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1})},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},closeDialog:function(t){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},s=i("KHd+"),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1000px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",{staticStyle:{margin:"10px 50px"}},[i("el-radio-group",{model:{value:t.receiptType,callback:function(e){t.receiptType=e},expression:"receiptType"}},[i("el-radio",{attrs:{label:2}},[t._v("增值税普通发票")]),t._v(" "),i("el-radio",{attrs:{label:3}},[t._v("增值税专用发票")])],1)],1),t._v(" "),i("div",{staticStyle:{"padding-left":"50px"}},[i("p",[i("a",[t._v("名称:")]),t._v(t._s(t.temp.companyName))]),t._v(" "),i("p",[i("a",[t._v("税号:")]),t._v(t._s(t.temp.invoiceNumber))]),t._v(" "),i("p",[i("a",[t._v("地址:")]),t._v(t._s(t.temp.address))]),t._v(" "),i("p",[i("a",[t._v("电话:")]),t._v(t._s(t.temp.mobile))]),t._v(" "),i("p",[i("a",[t._v("开户银行:")]),t._v(t._s(t.temp.bankName))]),t._v(" "),i("p",[i("a",[t._v("账号:")]),t._v(t._s(t.temp.bankCode))])]),t._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{width:"96%","margin-left":"2%"}},[i("custom-base-table",{ref:"orderAddByInvoiceDialog",attrs:{"data-custom-table-id":"views_finance_financeInvoice_dialogAdd0",isSortable:!1,varList:t.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:t.customColumn,apiObj:t.apiObj,mergeTitle:t.mergeTitle,mergeColumn:t.mergeColumn,mergeRow:t.mergeRow,componentId:"orderAddByInvoiceDialog",useDefaultBtn:!1,showAll:!1},on:{databridge:t.databridge}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);l.options.__file="dialogAdd.vue";e.default=l.exports},sV09:function(t,e,i){"use strict";var a=i("3CKI");i.n(a).a}}]);