(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-0b33","8veI"],{"8veI":function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("Oyvg"),i("rGqo");var a=i("rwyD"),n=i("AUoE"),o=i("z0WU"),l=i("mSNy");function s(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}function r(e){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var c={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.orderDtlDeliverCount" @change="colConfig.orderDtlDeliverCountChange(scope.row,scope.$index)"/>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.deliverDtlRemark" />\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},d={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{priceType:"1",dialogLoading:!1,isVisible:!1,inDialog:!0,tempLable:{},tempQuery:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},BaseTableLoading:!1,tableData:[],selectList:[],configs:{tableConfigs:[],isSingle:!0},pageData:null,pageNo:1,resState:null}},created:function(){var e=this.initData.orderDtlIds;this.initTable(!0,e)},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=r(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(o.k)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==l.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==l.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}})},addTableTitle:function(e){var t=this;return e.forEach(function(e){var i=e.label;i.indexOf("_")>0&&("en"==l.a.locale?e.label=i.substring(i.indexOf("_")+1):"zh"==l.a.locale&&(e.label=i.substring(0,i.indexOf("_")))),"orderDtlDeliverCount"===e.prop?(e.component=c,e.orderDtlDeliverCountChange=t.orderDtlDeliverCountChange):"deliverDtlRemark"===e.prop&&(e.component=u)}),e},initTable:function(e,t){var i=this;e&&(this.BaseTableLoading=!0),Object(a.listPageOrderDetailQueryByDeliver)(function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){s(e,t,i[t])})}return e}({},this.tempQuery,{ids:t,pageNo:this.pageNo})).then(function(t){i.getListPage(t),i.dialogLoading=!1,e&&(i.BaseTableLoading=!1)}).catch(function(e){i.dialogLoading=!1,i.BaseTableLoading=!1})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},dataBridge:function(e){},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},orderDtlDeliverCountChange:function(e,t){e.notDeliverCount;var i=e.orderDtlDeliverCount;if(null!=i&&i.trim().length>0&&!this.isNumberByValue(i.trim()))this.$message({showClose:!0,message:"第 "+(t+1)+" 行: 本次发货数量("+i+") 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3});else{var a=e.productPrice;if(null!=a&&a.trim().length>0){if(!this.isNumberByValue(a))return void this.$message({showClose:!0,message:"第 "+(t+1)+" 行: 单价("+a+") 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3});e.productSum=(i.trim()*a.trim()).toFixed(2)}}},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i],n=a.needDeliverCount,o=a.orderDtlDeliverCount;null!=o&&o.trim().length>0&&!this.isNumberByValue(o.trim())?t=t+"第 "+(i+1)+" 行: 本次发货数量("+o+") 输入错误，请输入大于零的正整数或(1,2)位小数！":(o=(o+"").trim())-n>0&&(t=t+"第 "+(i+1)+" 行: 本次发货数量("+o+") 输入错误，本次发货数量不可大于可发货数量！")}return t},saveSaleDeliver:function(){var e=this,t=this.tableData;if(null!=t&&0!=t.length){var i=this.checkColumn(t);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{var a=[];t.forEach(function(e){a.push(e)});var o=JSON.stringify(a);Object(n.addSaleDeliver)({priceType:this.priceType,dtlJsonStr:o}).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"保存成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(e){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条订单明细！"})}}},p=i("KHd+"),m=Object(p.a)(d,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"500px"}},[i("el-row",{staticStyle:{"margin-left":"10px"}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.BaseTableLoading,expression:"BaseTableLoading"}],staticStyle:{height:"400px"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,isSingle:e.configs.isSingle,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)]),e._v(" "),i("el-row",{staticStyle:{height:"100px","text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveSaleDeliver}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);m.options.__file="dialogAddDeliverDetail.vue";t.default=m.exports},"9WTv":function(e,t,i){"use strict";i.d(t,"d",function(){return n}),i.d(t,"a",function(){return o}),i.d(t,"f",function(){return l}),i.d(t,"e",function(){return s}),i.d(t,"b",function(){return r}),i.d(t,"c",function(){return c});var a=i("t3Un");function n(e){return Object(a.a)({url:"/base/equipment/listPageEquipments",method:"post",data:e})}function o(e){return Object(a.a)({url:"/base/equipment/addEquipment",method:"post",data:e})}function l(e){return Object(a.a)({url:"/base/equipment/updateEquipment",method:"post",data:e})}function s(e,t){return Object(a.a)({url:"/base/equipment/update",method:"post",data:{id:e,isdisable:t}})}function r(e){return Object(a.a)({url:"/base/equipment/deleteByIds",method:"post",data:{ids:e}})}function c(e){return Object(a.a)({url:"/base/equipment/exportExcelEquipments",method:"post",responseType:"blob",data:{ids:e}})}},HWi0:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("XfO3"),i("9AAn"),i("rGqo");var a=i("zDZ1"),n=i("2+ib"),o=i("uTIz"),l=i("8veI"),s=i("SINu"),r=i("Vobf"),c=(i("z0WU"),{components:{dialogQrcode:a.a,multilevelTable:n.a,searchBar:o.a,dialogAddDeliverDetail:l.default,dialogAddDeliverDetailByPrice:s.default},data:function(){return{searchList:[{label:"订单编号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单编号"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"customerName",configs:{},placeholder:"客户名称"},{label:"订单状态",type:"select",ruleType:"string",mapKey:"detailState",configs:{clearable:!0,name:"",options:[{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"待发货"},{value:"3",label:"已发货"},{value:"4",label:"已完成"},{value:"-1",label:"已取消"}]},placeholder:"请选择"},{label:"下单日期起",type:"date",ruleType:"date",mapKey:"orderDateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"下单日期止",type:"date",ruleType:"date",mapKey:"orderDateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"sysCode"},{columnIndex:"customerName"},{columnIndex:"orderDate"},{columnIndex:"expectDate"},{columnIndex:"orderSum"},{columnIndex:"makeName"},{columnIndex:"remark"},{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"4",text:"已完成"},info1:{state:"1",text:"待审核"},warning:{state:"2",text:"待发货"},danger:{state:"3",text:"已发货"},default:{state:"0",text:"待提交"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageSaleOrder",params:{isNeedDeliver:"true",isBydeliver:"true"}},tempData:{},showHeader:!1,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"5",text:"已完成"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待生产"},info3:{state:"3",text:"待出库"},info4:{state:"4",text:"待发货"},default:{state:"0",text:"待提交"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageSaleOrderDetail",params:{fieldCode:"productCode,productName,productSpec,productGenreName,orderUnitName,orderCount,productPrice,productSum,lockCountN2P,deliverDate,remark,state"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!0,isSingle:!1,componentId:"twoLevelTable"}],searchObj:{},selectList:[],configs:{topBarBtnList:[{name:"生成发货单",nameEn:"add",isShow:!0,icon:"add",method:this.dialogAdd}],tableConfigs:[],showCheckBox:!1},temp:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",orderDtlIds:"",tempLable:null}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,i=e.$storage.get("menuId");t&&(e.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(r.initMenuButtons)({menuId:i,roleId:t}).then(function(t){e.$loading().close();var i=t.buttonList;i&&i.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){e.$loading().close()}))},databridge:function(e){this.temp.dataList=e,this.selectList=e},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.updateData(this.searchObj)},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},checkColumn:function(e){for(var t="",i=new Map,a=new Map,n=0;n<e.length;n++){var o=e[n],l=o.customerId;i.size>0&&null==i.get(l)?t=t+"第 "+(n+1)+" 行: 订单客户不同！":0==i.size&&i.set(l,l);var s=o.priceType;a.size>0&&null==a.get(s)?t=t+"第 "+(n+1)+" 行: 订单计价类型不同！":0==a.size&&a.set(s,s)}return t},dialogAdd:function(){var e=this.temp.dataList;if(null!=e&&0!=e.length){var t=this.checkColumn(e);if(null!=t&&t.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:t+"提示:勾选的订单明细(订单客户)必须相同，请通过(客户名称)进行过滤。"});else{var i="";e.forEach(function(e){i=i+e.id.trim()+","});var a="1";null!=e&&e.length>0&&null!=e[0].priceType&&e[0].priceType.trim().length>0&&(a=e[0].priceType.trim()),this.openDialogName="dialogAddDeliverDetail",this.dialogData.title="生成发货单(先)","2"==a&&(this.openDialogName="dialogAddDeliverDetailByPrice",this.dialogData.title="生成发货单(后)"),this.dialogData.orderDtlIds=i,this.showDialog=!0,this.visible=!0}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条订单明细！"})},executorByDetail:function(e,t){this.resetTemp(),this.dialogData.temp=e,this.dialogData.tempLable=this.tempLable,this.dialogData.title="查看执行人",this.openDialogName="dialogViewExecutor",this.showDialog=!0,this.visible=!0},exportExcel:function(){}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),u=(i("PFL1"),i("KHd+")),d=Object(u.a)(c,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"createDeliver"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);d.options.__file="index.vue";t.default=d.exports},N0OG:function(e,t,i){},PFL1:function(e,t,i){"use strict";var a=i("N0OG");i.n(a).a},QzUw:function(e,t,i){},SINu:function(e,t,i){"use strict";i.r(t);i("rGqo"),i("Oyvg");var a=i("WIyV"),n=i("AUoE"),o=(i("a0Xs"),{components:{customBaseTable:a.a},props:["initData","visible"],data:function(){return{priceType:"2",productUnit:{},rowData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},isVisible:!1,inDialog:!0,tableData:[],orderDtlList:[],apiObj:{apiName:"listPageOrderDetailQueryByDeliver",params:{pageNo:1,ids:"",fieldCode:"productCode,productName,productSpec,productGenreName,orderUnitName,orderCount,needDeliverCount,notDeliverCount,orderDtlDeliverCount,deliverDtlRemark"}},customColumn:[{columnIndex:"orderDtlDeliverCount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"deliverDtlRemark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{maxExpectDate:""}}},beforeCreate:function(){},created:function(){var e=this.initData.orderDtlIds;this.apiObj.params.ids=e},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){Array.isArray(e)?(this.orderDtlList=[],this.orderDtlList=e):(this.productUnit=null,null!=e.item&&(this.productUnit=e.item),this.rowData=null,null!=e.item&&(this.rowData=e.row))},save:function(){this.$refs.addDeliverByPriceDialog.getData(),this.saveSaleDeliver(this.orderDtlList)},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkNumber:function(e,t){null!=e&&e.trim().length>0&&!this.isNumberByValue(e.trim())&&this.$message({type:"warning",duration:5e3,showClose:!0,message:t+"("+e+") 输入错误，请输入大于零的正整数或(1,2)位小数！"})},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i],n=a.needDeliverCount,o=a.orderDtlDeliverCount;null==o||0==(o+"").trim().length?t=t+"第 "+(i+1)+" 行: 本次发货数量为空或空字符串！":(o+="",this.isNumberByValue(o.trim())?(o=(o+"").trim())-n>0&&(t=t+"第 "+(i+1)+" 行: 本次发货数量("+o+") 输入错误，本次发货数量不可大于可发货数量！"):t=t+"第 "+(i+1)+" 行: 本次发货数量("+o.trim()+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return t},saveSaleDeliver:function(e){var t=this;if(null!=e&&0!=e.length){var i=this.checkColumn(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{var a=[];e.forEach(function(e){a.push(e)});var o=JSON.stringify(a);Object(n.addSaleDeliver)({priceType:this.priceType,dtlJsonStr:o}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条订单明细！"})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}}),l=i("KHd+"),s=Object(l.a)(o,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{staticStyle:{height:"500px"}},[i("el-row",{staticStyle:{"margin-left":"10px"}},[i("div",{staticStyle:{height:"400px"}},[i("custom-base-table",{ref:"addDeliverByPriceDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,tempData:e.tempData,componentId:"addDeliverByPriceDialog",useDefaultBtn:!0,showAll:!1,keyMapping:e.keyMapping},on:{databridge:e.databridge}})],1)]),e._v(" "),i("el-row",{staticStyle:{height:"100px","text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="dialogAddDeliverDetailByPrice.vue";t.default=s.exports},bNCw:function(e,t,i){"use strict";var a=i("QzUw");i.n(a).a},lZYi:function(e,t,i){"use strict";var a=i("wnxv");i.n(a).a},wnxv:function(e,t,i){},zDZ1:function(e,t,i){"use strict";i("rE2o"),i("ioFf"),i("f3/d"),i("9WTv");function a(e){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var n={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},tempShow:{},rules:{},imageUrl:""}},created:function(){console.log(this.initData),this.initData.temp&&(this.temp=this.initData.temp,this.initData.temp.qrcode&&(this.imageUrl="https://vmes.deecoop.cn/"+this.initData.temp.qrcode)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=a(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},download:function(){var e=this.imageUrl,t=document.createElement("a");t.style.display="none",t.href=e,t.setAttribute("download",this.temp.name),document.body.appendChild(t),t.click()},print:function(){var e='<!DOCTYPE html> <html> <head> <meta charset="utf-8"> <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> ';e+="<style></style>",e+="</head><body >",e+=document.getElementById("printContent").innerHTML,e+="</body></html>";var t=window.open("","打印","");t.document.write(e),t.document.close(),t.focus(),t.print(),t.close()}}},o=(i("lZYi"),i("bNCw"),i("KHd+")),l=Object(o.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"二维码",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"400px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("div",{attrs:{id:"printContent"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"text-align":"center","padding-bottom":"20px"},attrs:{span:24}},[e.imageUrl?i("img",{staticClass:"avatar",staticStyle:{margin:"0 auto"},attrs:{src:e.imageUrl}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("b",{staticStyle:{"padding-left":"35%"}},[e._v(e._s(e.tempLable.code)+":")]),e._v(e._s(e.temp.code)),i("br"),e._v(" "),i("b",{staticStyle:{"padding-left":"35%"}},[e._v(e._s(e.tempLable.name)+":")]),e._v(e._s(e.temp.name)+"\n\n          ")])],1)],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center",padding:"15px 0 15px 0"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.download}},[e._v("下载")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:e.print}},[e._v("打印")])],1)])])},[],!1,null,"48eacded",null);l.options.__file="dialogQrcode.vue";t.a=l.exports}}]);