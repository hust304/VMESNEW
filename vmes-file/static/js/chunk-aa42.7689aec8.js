(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-aa42","chunk-07f9","chunk-48f7","chunk-594c"],{"5BnR":function(e,t,i){"use strict";i.r(t);i("91GP"),i("rGqo");var a=i("lX1r"),n=i("uTIz"),o=i("LCER"),s=(i("z0WU"),{name:"dialog-option",props:["initData","visible"],data:function(){return{nextButtonShow:!0,dialogTopLoading:!1,isVisible:!1,title:"",searchConfig:{hideSearchSwitch:!1},searchList:[{label:"订单号",type:"input",ruleType:"string",mapKey:"orderCode",configs:{},placeholder:"订单号"},{label:"下单日期起",type:"date",ruleType:"date",mapKey:"orderDateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"下单日期止",type:"date",ruleType:"date",mapKey:"orderDateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"}],guid:"",currentpage:1,maxLayer:2,expandTableApiList:["listPageOrderReceiveDetail","listPageSaleDeliverDetail"],expandTableApiParams:[{},{}],tableData:{},initParams:{},updateViewData:{},searchObj:{},childrenData:{},customColumn:{1:[],2:[]},tableSets:{1:{showCheckBox:!0,showIndex:!0,expandOne:!1},2:{showCheckBox:!1,showIndex:!1,isExpands:!1,isSortable:!1,isSingle:!1}},temp:{},tempQuery:{},tempLable:{},selectList:[],pageData:null,pageNo:1,openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{expandTable:a.a,searchBar:n.a,dialogReceiptAdd:o.default},beforeCreate:function(){},created:function(){this.title=this.initData.title,"订单收款明细"==this.title?(this.nextButtonShow=!1,this.tableSets[1].showCheckBox=!1,this.expandTableApiParams=[{},{}]):(this.nextButtonShow=!0,this.expandTableApiParams=[{havingStr:" sOrder.state > 1 "},{}]),this.temp=this.initData.temp,this.initExpandTable()},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{nextPage:function(){if(this.selectList.length<=0)this.$message({showClose:!0,message:"请勾选收款费用分摊明细！",duration:5e3});else{var e="";this.selectList.forEach(function(t){e=e?e+",'"+t.id+"'":"'"+t.id+"'"}),this.dialogData.temp=this.temp,this.dialogData.ids=e,this.dialogData.tempLable=this.tempLable,this.dialogData.title="订单结算",this.openDialogName="dialogReceiptAdd",this.showDialog=!0,this.visibleState=!0}},dialogClose:function(){this.$emit("close-dialog",{resState:"ok"})},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState?this.dialogClose():(this.initExpandTable(),this.selectList=[])},initExpandTable:function(){var e=this;this.$api[this.expandTableApiList[0]](this.setParams(1,this.initParams,this.currentpage)).then(function(t){e.tableData={row:null,layer:1,res:t,customColumn:e.customColumn},e.$loading().close()}).catch(function(t){console.log(t),e.$loading().close()})},findChildByRow:function(e,t,i,a,n){var o=this;this.$api[this.expandTableApiList[t-1]](this.setParams(t,e,n)).then(function(i){o.childrenData={row:e,layer:t,res:i,customColumn:o.customColumn}}).catch(function(e){console.log(e)})},setParams:function(e,t,i){if(e>1){var a=this.expandTableApiParams[e-1];for(var n in a)a.hasOwnProperty(n)&&(a[n]=t[n]||"");return Object.assign({},a,this.searchObj,{pageNo:i},{orderId:t.id},{fieldCode:"deliverCode,productCode,productName,productSpec,productGenreName,orderUnitName,orderDetailCount,orderCount,,productPrice,sum,deliverDate,stateName"})}return Object.assign({},t,this.searchObj,{pageNo:i},{customerId:this.temp.id},this.expandTableApiParams[0])},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.initExpandTable()},databridge:function(e){this.selectList=e}},computed:{dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){}}}),l=i("KHd+"),r=Object(l.a)(s,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"编辑",visible:e.isVisible,"append-to-body":"",width:"1300px"},on:{"update:visible":function(t){e.isVisible=t},close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visibleState},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{height:"100%"},attrs:{span:24}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px"}},[i("expand-table",{attrs:{initData:e.tableData,childrenData:e.childrenData,configs:e.tableSets,currentpage:e.currentpage,apiObj:{apiName:e.expandTableApiList,apiParams:e.expandTableApiParams},updateViewData:e.updateViewData},on:{"update:currentpage":function(t){e.currentpage=t},databridge:e.databridge,"send-children-row":e.findChildByRow}})],1),e._v(" "),i("div",{staticStyle:{"text-align":"center","padding-bottom":"10px"}},[i("el-button",{directives:[{name:"show",rawName:"v-show",value:e.nextButtonShow,expression:"nextButtonShow"}],on:{click:e.nextPage}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);r.options.__file="dialogSelectDeliverList.vue";t.default=r.exports},G9cW:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("xfY5"),i("9rC1");function a(e){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var n={name:"dialog-edit",props:["initData","visible"],data:function(){return{currentBalance_before:"",currentBalance:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.temp.totalBalance=Number(this.temp.addBalance)+Number(this.temp.balance)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable),this.currentBalance_before=this.temp.currentBalance,this.currentBalance=this.temp.currentBalance},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=a(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},save:function(){var e=this,t=this;if(this.currentBalance>this.temp.totalBalance)this.$message({showClose:!0,message:"当前分摊金额不能大于预收款！",duration:5e3});else{var i=this.currentBalance-this.currentBalance_before;t.$refs.submitForm.validate(function(a){a&&(t.isVisible=!1,t.dialogClose({resState:"ok",currentBalance:e.currentBalance,currentBalance_edit:i}))})}}}},o=(i("Yf9r"),i("KHd+")),s=Object(o.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"编辑",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.dialogWidth},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"预收款:",prop:"totalBalance"}},[i("el-input",{staticStyle:{width:"140px"},attrs:{disabled:!0},model:{value:e.temp.totalBalance,callback:function(t){e.$set(e.temp,"totalBalance",t)},expression:"temp.totalBalance"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"本次分摊金额:",prop:"currentBalance"}},[i("el-input",{staticStyle:{width:"140px"},model:{value:e.currentBalance,callback:function(t){e.currentBalance=e._n(t)},expression:"currentBalance"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,"48899cd4",null);s.options.__file="dialogReceiptBalanceEdit.vue";t.default=s.exports},HYdd:function(e,t,i){"use strict";var a=i("lbuq");i.n(a).a},"J/5B":function(e,t,i){},LCER:function(e,t,i){"use strict";i.r(t);i("91GP"),i("xfY5");var a=i("uTIz"),n=i("G9cW"),o=i("kAts"),s=i("WIyV"),l=(i("z0WU"),{name:"dialog-option",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"",selectList:[],temp:{},tempLable:{},pageData:null,pageNo:1,unapportionedValue:0,openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null},customColumn:[{columnIndex:"receiveAmount",componentName:"input",_cellConfig:{rules:[{type:"number"},{required:!0},{lessThan:["tempData@currentBalance",!0]},{lessThan:["self@orderAmount(-)self@discountAmount(-)self@haveReceivedAmount",!0]}],message:["输入类型必须是数字！","该单元格是必填项","必须小于等于可分摊总额","本次收款金额与折扣金额之和加上已收金额必须小于等于订单金额！"]}},{columnIndex:"discountAmount",componentName:"input",_cellConfig:{defaultValue:"0.00",rules:[{type:"number"},{lessThan:["self@orderAmount(-)self@receiveAmount(-)self@haveReceivedAmount",!0]}],message:["输入类型必须是数字！","本次收款金额与折扣金额之和加上已收金额必须小于等于订单金额！"]}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",nameEn:"delete",editBtns_isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteAllRow}]}],apiObj:{apiName:"listPageOrderReceiveDetail",params:{pageNo:this.pageNo,queryStr:" sOrder.id in ("+this.initData.ids+") ",fieldCode:"sysCode,orderAmount,haveReceivedAmount,nowReceiveAmount,receiveAmount,discountAmount "}},customSummary:{component:{props:["data","setStyle","tempData"],created:function(){},computed:{unapportionedValue:function(){var e=this.data.orderAmount.toFixed(2);return/\d/.test(e)?(this.$emit("custom-summary-value",e),e):(this.$emit("custom-summary-value",""),"输入错误")}},template:'<ul class="clearfix" :style="setStyle">\n                        <li style="float: left;width: 100%"><span>本次分摊总金额：</span><span>{{unapportionedValue}}元</span></li>\n                    </ul>'},data:{orderAmount:""},boxStyle:{width:"220px",float:"right",padding:"10px"},computes:{orderAmount:"table@receiveAmount"}}}},components:{searchBar:a.a,dialogReceiptBalanceEdit:n.default,customBaseTable:s.a},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.temp=this.initData.temp,!this.temp.addBalance&&this.$set(this.temp,"addBalance",""),!this.temp.lastBalance&&this.$set(this.temp,"lastBalance",""),!this.temp.currentBalance&&this.$set(this.temp,"currentBalance",""),this.temp.addBalance?this.temp.currentBalance=Number(this.temp.balance)+Number(this.temp.addBalance):(this.temp.currentBalance=this.temp.balance,this.temp.addBalance=0),this.temp.lastBalance=0},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){this.showDialog=!1,e.resState},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},getData:function(){this.$refs.customBaseTable.getData()},dataBridge:function(e){var t=this;if(this.selectList=e,this.unapportionedValue>0&&this.unapportionedValue-this.temp.currentBalance<=0)if(this.selectList.length>0){var i=JSON.stringify(this.selectList);this.temp.dtlJsonStr=i,this.dialogLoading=!0,Object(o.saveSaleReceiveAndDetail)(this.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前界面没有分摊明细，请重新选择分摊明细！"});else this.$message({type:"warning",duration:5e3,showClose:!0,message:"分摊明细总金额必须小于等于分摊总额！"})},customSummaryValue:function(e){this.unapportionedValue=e},deleteAllRow:function(e,t,i){console.log(e,t,i),this.deleteData(e)},edit:function(){this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="本次分摊金额",this.openDialogName="dialogReceiptBalanceEdit",this.showDialog=!0,this.visibleState=!0},save:function(){this.$refs.customBaseTable.getData()}},computed:{dialogName:function(){return this.openDialogName},setApiObj:function(){return this.apiObj.params=Object.assign({},this.apiObj.params,this.searchObj),this.apiObj}},watch:{}}),r=i("KHd+"),c=Object(r.a)(l,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.title,visible:e.isVisible,"append-to-body":"",width:"1000px"},on:{"update:visible":function(t){e.isVisible=t},close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visibleState},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{staticStyle:{height:"50px"}},[i("el-row",{staticStyle:{"text-align":"center","padding-top":"20px","line-height":"2"}},[i("el-col",{staticStyle:{height:"100%","vertical-align":"middle"},attrs:{span:5}},[e._v("客户名称："+e._s(e.temp.name))]),e._v(" "),i("el-col",{staticStyle:{height:"100%","vertical-align":"middle"},attrs:{span:5}},[e._v("客户类型："+e._s(e.temp.typeName))]),e._v(" "),i("el-col",{staticStyle:{height:"100%","vertical-align":"middle"},attrs:{span:5}},[e._v("地域："+e._s(e.temp.provinceName))]),e._v(" "),i("el-col",{staticStyle:{height:"100%","vertical-align":"middle"},attrs:{span:5}},[e._v("可分摊总额："+e._s(e.temp.currentBalance))])],1)],1),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{height:"100%"},attrs:{span:24}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px"}},[i("custom-base-table",{ref:"customBaseTable",attrs:{keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.setApiObj,tempData:e.temp,componentId:"customBaseTable",showAll:!1,useSummary:!0,customSummary:e.customSummary},on:{databridge:e.dataBridge,"custom-summary-value":e.customSummaryValue}})],1),e._v(" "),i("div",{staticStyle:{"text-align":"center","padding-bottom":"10px"}},[i("el-button",{on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);c.options.__file="dialogReceiptAdd.vue";t.default=c.exports},Yf9r:function(e,t,i){"use strict";var a=i("J/5B");i.n(a).a},lbuq:function(e,t,i){},qWH3:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rGqo");var a=i("uTIz"),n=i("5BnR"),o=i("mSNy"),s=i("9rC1"),l=(i("5W5M"),i("Vobf")),r=i("z0WU");function c(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){d(e,t,i[t])})}return e}function d(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.viewOrderReceipt_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.viewOrderReceipt(scope.row,scope.$index)">订单收款明细</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},p={data:function(){return{preReceiveAmount:0,nowReceiveAmount:0,guid:"",searchList:[{label:"客户编码",type:"input",mapKey:"code",configs:{},placeholder:"请输入客户编码"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入客户名称"},{label:"客户类型",type:"input",ruleType:"string",mapKey:"typeName",configs:{},placeholder:"请输入客户类型"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{width:400,title:"",temp:null,tempLable:null},initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",btnName:"编辑",isPropName:!0,component:u,viewOrderReceipt:this.viewOrderReceipt,viewOrderReceipt_isShow:!0}},configs:{topBarBtnList:[{name:"录入收款",nameEn:"addNew",isShow:!0,icon:"add",method:this.addNew}],tableConfigs:[],showCheckBox:!1,showIndex:!1},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},components:{searchBar:a.a,dialogSelectDeliverList:n.default},beforeCreate:function(){},created:function(){this.initButtons(),this.initTable(!0)},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(e){this.tempQuery=e,this.initTable(null)},sendGuid:function(e){this.guid=e},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.refreshTable()},initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,i=e.$storage.get("menuId");t&&(e.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(l.initMenuButtons)({menuId:i,roleId:t}).then(function(t){var i=t.buttonList;i&&i.forEach(function(t){if(e.initConfigs&&e.initConfigs.tableOperates)for(var i in e.initConfigs.tableOperates)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e.initConfigs.tableOperates[i]=!1);if(e.customColumn)for(var a in e.customColumn)if(a){var n=e.customColumn[a];n.length>0&&n.forEach(function(e){if(e)for(var i in e)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e[i]=!1)})}e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(console.log(e),e.isShow=!1)}))})}).catch(function(t){console.log(t),e.$loading().close()}))},initTable:function(e){var t=this;Object(s.listPageCustomerReceive)(c({},t.tempQuery,{genre:"df7cb67fca4148bc9632c908e4a7fdea",pageNo:t.pageNo})).then(function(i){t.getListPage(i),e&&t.$loading().close()}).catch(function(e){t.$loading().close()})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.preReceiveAmount=e.result.preReceiveAmount,this.nowReceiveAmount=e.result.nowReceiveAmount,this.initTempData(e.result.titles);var t=Object(r.m)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==o.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==o.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}}),console.log(t.tempLable)},addTableTitle:function(e){var t=this;return e.forEach(function(e){var i=e.label;i.indexOf("_")>0&&("en"==o.a.locale?e.label=i.substring(i.indexOf("_")+1):"zh"==o.a.locale&&(e.label=i.substring(0,i.indexOf("_")))),"是否启用"===e.label&&(e.component=stateBtns,e.changeState=t.changeState)}),t.internationalConfig(),e.push(t.initConfigs.tableOperates),e},internationalConfig:function(){"en"==o.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==o.a.locale&&(this.initConfigs.tableOperates.label="操作")},dataBridge:function(e){this.selectList=e,e.length?this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!1)}):this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})},viewOrderReceipt:function(e,t){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(e)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="订单收款明细",this.openDialogName="dialogSelectDeliverList",this.showDialog=!0,this.visible=!0},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},refreshTable:function(){var e=this;e.$axios.all([Object(s.listPageCustomerReceive)(c({},e.tempQuery,{genre:"df7cb67fca4148bc9632c908e4a7fdea",pageNo:e.pageNo}))]).then(e.$axios.spread(function(t){e.getListPage(t)})).catch(function(e){console.log(e)})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable(null,this.selectTree.id)}}},h=(i("HYdd"),i("KHd+")),m=Object(h.a)(p,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"customerManage"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle",attrs:{span:24}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",{attrs:{span:16}},[e._v("  ")]),e._v(" "),i("el-col",{attrs:{span:4}},[i("div",{staticStyle:{width:"100%",height:"40px","background-color":"#1482f0","text-align":"center","line-height":"40px",color:"#ffffff"}},[i("span",[e._v("预收款合计：￥"+e._s(e.preReceiveAmount))])])]),e._v(" "),i("el-col",{attrs:{span:4}},[i("div",{staticStyle:{width:"100%",height:"40px","background-color":"#2ED18C","text-align":"center","line-height":"40px",color:"#ffffff"}},[i("span",[e._v("应收款合计："+e._s(e.nowReceiveAmount))])])])],1),e._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)],1)])],1),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);m.options.__file="index.vue";t.default=m.exports}}]);