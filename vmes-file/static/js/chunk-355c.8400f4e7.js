(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-355c","chunk-3a27","chunk-3b33","chunk-3af6"],{"/RvK":function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("Oyvg"),i("rGqo");var a=i("ddId"),o=i("rwyD"),n=(i("a0Xs"),i("z0WU")),l=i("mSNy");function r(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}function s(e){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var d={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.productPrice" @change="colConfig.productPriceChange(scope.row,scope.$index)" />\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},c={components:{},name:"dialog-add",props:["initData","visible"],data:function(){var e=this;return{fieldCode:"productCode,productName,productSpec,productGenreName,orderUnitName,orderCount,productPrice,productSum,deliverDate,remark",rules:{customerName:[{required:!0,message:"请选择客户名称",trigger:"change"}],receiptTypeName:[{required:!0,trigger:"change",validator:function(t,i,a){e.temp.receiptType.length<=0?a(new Error("请选择发票类型")):a()}}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}],orderDate:[{required:!0,message:"请填写下单日期",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,isNeedRepeat:!1,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{id:"",discountSum:"",advanceSum:"",dtlJsonStr:""},tempLable:{},tempQuery:{},tableData:[],selectList:null,initConfigs:{tableOperates:{}},configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1}},created:function(){this.temp=this.initData.temp,this.initTable(null,this.initData.temp.id)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=s(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(n.m)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==l.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==l.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}})},addTableTitle:function(e){var t=this;return e.forEach(function(e){var i=e.label;i.indexOf("_")>0&&("en"==l.a.locale?e.label=i.substring(i.indexOf("_")+1):"zh"==l.a.locale&&(e.label=i.substring(0,i.indexOf("_")))),"productPrice"===e.prop&&(e.component=d,e.productPriceChange=t.productPriceChange)}),this.internationalConfig(),e},internationalConfig:function(){"en"==l.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==l.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTable:function(e,t){var i=this;this.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(o.listPageSaleOrderDetail)(function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){r(e,t,i[t])})}return e}({},this.tempQuery,{fieldCode:this.fieldCode,parentId:t,pageNo:this.pageNo})).then(function(e){i.getListPage(e),i.$loading().close()}).catch(function(e){i.$loading().close()})},dataBridge:function(e){},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},deleteBtns:function(e,t){this.tableData.splice(t,1)},checkNumber:function(e,t){null!=e&&e.trim().length>0&&!this.isNumberByValue(e.trim())&&this.$message({type:"warning",duration:5e3,showClose:!0,message:t+"("+e+") 输入错误，请输入大于零的正整数或(1,2)位小数！"})},checkDiscountSum:function(e){this.checkNumber(e,"折扣金额")},checkAdvanceSum:function(e){null!=e&&e.trim().length>0&&!this.isNumberByValue(e.trim())&&this.checkNumber(e,"预付款")},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i].productPrice;null!=a&&0!=a.trim().length||(t=t+"第 "+(i+1)+" 行: 单价为空或空字符串！"),null!=a&&a.trim().length>0&&!this.isNumberByValue(a.trim())&&(t=t+"第 "+(index+1)+" 行: 单价("+a+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return t},saveSaleOrder:function(){var e,t=this,i=this.temp.discountSum;null!=i&&i.trim().length>0&&this.checkNumber(i,"折扣金额");var o=this.temp.advanceSum;null!=o&&o.trim().length>0&&this.checkNumber(o,"预付款");var n=this.checkColumn(this.tableData);if(null!=n&&n.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:n});else{for(var l=[],r=0;r<this.tableData.length;r++){var s=this.tableData[r],d={id:"",productPrice:"",productSum:""};d.id=s.id,d.productPrice=s.productPrice,d.productSum=s.productSum,l.push(d)}e=JSON.stringify(l),this.temp.dtlJsonStr=e,this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(a.d)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){}))})}},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},productPriceChange:function(e,t){var i=e.productPrice;if(null!=i&&i.trim().length>0&&!this.isNumberByValue(i))this.$message({showClose:!0,message:"第 "+(t+1)+" 行: 单价("+i+") 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3});else{var a=e.count;if(null!=a&&a.trim().length>0){if(!this.isNumberByValue(a))return void this.$message({showClose:!0,message:"第 "+(t+1)+" 行: 订购数量("+a+") 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3});e.productSum=(a.trim()*i.trim()).toFixed(2)}}},closeDialog:function(e){}},watch:{pageNo:function(){this.initTable("add","")}}},u=i("KHd+"),m=Object(u.a)(c,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"客户名称:",prop:"customerName"}},[i("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:e.temp.customerName,callback:function(t){e.$set(e.temp,"customerName",t)},expression:"temp.customerName"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"发票类型:",prop:"receiptTypeName"}},[i("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:e.temp.receiptTypeName,callback:function(t){e.$set(e.temp,"receiptTypeName",t)},expression:"temp.receiptTypeName"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[i("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:e.temp.makeName,callback:function(t){e.$set(e.temp,"makeName",t)},expression:"temp.makeName"}})],1)],1)],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"下单日期:",prop:"orderDate"}},[i("el-date-picker",{staticStyle:{width:"230px"},attrs:{type:"date",placeholder:"下单日期","value-format":"yyyy-MM-dd",disabled:!0},model:{value:e.temp.orderDate,callback:function(t){e.$set(e.temp,"orderDate",t)},expression:"temp.orderDate"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"约定交期:",prop:"deliverDate"}},[i("el-date-picker",{staticStyle:{width:"230px"},attrs:{type:"date",placeholder:"约定交期","value-format":"yyyy-MM-dd",disabled:!0},model:{value:e.temp.deliverDate,callback:function(t){e.$set(e.temp,"deliverDate",t)},expression:"temp.deliverDate"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1)],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"折扣金额:",prop:"discountSum"}},[i("el-input",{staticStyle:{width:"230px"},on:{change:e.checkDiscountSum},model:{value:e.temp.discountSum,callback:function(t){e.$set(e.temp,"discountSum",t)},expression:"temp.discountSum"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"预付款:",prop:"advanceSum"}},[i("el-input",{staticStyle:{width:"230px"},on:{change:e.checkAdvanceSum},model:{value:e.temp.advanceSum,callback:function(t){e.$set(e.temp,"advanceSum",t)},expression:"temp.advanceSum"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}})],1),e._v(" "),i("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[e._l(e.configs.topBarBtnList,function(e,t){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2),e._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveSaleOrder}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);m.options.__file="dialogEdit.vue";t.default=m.exports},"5Fd+":function(e,t,i){"use strict";i.r(t);var a=i("WIyV"),o=i("2+ib"),n=i("8Vv6"),l={components:{customBaseTable:a.a,multilevelTable:o.a},name:"dialog-edit",props:["initData","visible"],data:function(){return{orderId:"",orderObject:{},orderCollect:{},isShowText:!1,rowData:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",tempLable:null,data:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tableConfigList:[{customColumn:[],apiObj:{apiName:"listPageOrderDetailCollectByInfo",params:{pageNo:1,parentId:this.initData.orderId,fieldCode:"productCode,productName,productSpec,productGenreName,orderUnitName,orderCount,productPrice,productSum,deliverCount,deliverSum,invoiceCount,invoiceSum,deliverDate"}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"5",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待生产"},info3:{state:"3",text:"待出库"},info4:{state:"4",text:"待发货"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageSaleDeliverDetail",params:{pageNo:1,state:"1",orderStr:"detail.product_id,detail.cdate asc",fieldCode:"deliverCode,orderCount,productPrice,sum,cdate,deliverDate"}},dynamicValue:{orderDetaiId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],tableData_deliverDetail:[],apiObj_deliverDetail:{apiName:"listPageSaleReceiveDetails",params:{pageNo:1,state:"1",orderId:this.initData.orderId,orderStr:" receive.code desc",fieldCode:"code,productName,orderSum,discountAmount,receiveAmount,state,remark"}},customColumn_deliverDetail:[],mergeTitle_deliverDetail:[],mergeColumn_deliverDetail:[],mergeRow_deliverDetail:[],keyMapping_deliverDetail:{},tempData_deliverDetail:{}}},beforeCreate:function(){},created:function(){this.orderObject=this.initData.orderObject,this.orderId=this.initData.orderId,this.apiObj_deliverDetail.params.orderId=this.orderId,this.findOrderCollectByOrderId(this.orderId)},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},databridge:function(e){},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},findOrderCollectByOrderId:function(e){var t=this;this.dialogLoading=!0,Object(n.getSaleOrderCollectByOrderId)({id:e}).then(function(e){t.dialogLoading=!1,0===e.code&&null!=e.result&&null!=e.result.varList&&e.result.varList.length>0&&(t.orderCollect=e.result.varList[0])}).catch(function(e){console.log(e),t.dialogLoading=!1})}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}}},r=(i("ghff"),i("KHd+")),s=Object(r.a)(l,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{margin:"2em 2.3em"}},[i("el-row",{staticStyle:{"margin-bottom":"10px"}},[i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("订单编号  :  ")]),e._v(e._s(e.orderCollect.sysCode))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("订单状态  :  ")]),e._v(e._s(e.orderCollect.stateName))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("制单人  :  ")]),e._v(e._s(e.orderCollect.makeName))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("下单日期  :  ")]),e._v(e._s(e.orderCollect.orderDate))])])],1),e._v(" "),i("el-row",{staticStyle:{"margin-bottom":"10px"}},[i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("客户名称  :  ")]),e._v(e._s(e.orderCollect.customerName))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("约定交期  :  ")]),e._v(e._s(e.orderCollect.expectDate))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("发票类型  :  ")]),e._v(e._s(e.orderCollect.receiptTypeName))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("审核人:")]),e._v(e._s(e.orderCollect.auditName))])])],1),e._v(" "),i("el-row",{staticStyle:{"margin-bottom":"10px"}},[i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("发货完成日期  :  ")]),e._v(e._s(e.orderCollect.deliverDate))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("付款完成日期  :  ")]),e._v(e._s(e.orderCollect.payDate))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("账期截止日  :  ")]),e._v(e._s(e.orderCollect.deadlineDate))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.daysRemaining<0,expression:"orderCollect.daysRemaining<0"}],staticStyle:{color:"red"}},[i("b",[e._v("逾期(天)  :  ")]),e._v(e._s(e.orderCollect.daysRemaining))]),e._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.daysRemaining>=0,expression:"orderCollect.daysRemaining>=0"}]},[i("b",[e._v("账期剩余(天)  :  ")]),e._v(e._s(e.orderCollect.daysRemaining))])])],1),e._v(" "),i("el-row",{staticStyle:{"margin-bottom":"10px"}},[i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("发货金额  :  ")]),e._v(e._s(e.orderCollect.deliverAmount))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("实收金额  :  ")]),e._v(e._s(e.orderCollect.receivedAmount))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("折扣金额  :  ")]),e._v(e._s(e.orderCollect.discountedAmount))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",{directives:[{name:"show",rawName:"v-show",value:0==e.orderCollect.nowReceiveAmount&&0==e.orderCollect.preReceiveAmount,expression:"orderCollect.nowReceiveAmount==0&&orderCollect.preReceiveAmount==0"}]},[i("b",[e._v("应收金额  :  ")]),e._v(e._s(e.orderCollect.nowReceiveAmount))]),e._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.nowReceiveAmount>0&&0==e.orderCollect.preReceiveAmount,expression:"orderCollect.nowReceiveAmount>0&&orderCollect.preReceiveAmount==0"}]},[i("b",[e._v("应收金额  :  ")]),e._v(e._s(e.orderCollect.nowReceiveAmount))]),e._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.preReceiveAmount>0&&0==e.orderCollect.nowReceiveAmount,expression:"orderCollect.preReceiveAmount>0&&orderCollect.nowReceiveAmount==0"}]},[i("b",[e._v("预收金额  :  ")]),e._v(e._s(e.orderCollect.preReceiveAmount))])])],1),e._v(" "),i("el-row",{staticStyle:{"margin-bottom":"10px"}},[i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("订单金额  :  ")]),e._v(e._s(e.orderCollect.orderAmount))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("预付款  :  ")]),e._v(e._s(e.orderCollect.advanceAmount))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("开票金额  :  ")]),e._v(e._s(e.orderCollect.invoiceAmount))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.daysRemaining<0,expression:"orderCollect.daysRemaining<0"}],staticStyle:{color:"red"}},[i("b",[e._v("逾期金额  :  ")]),e._v(e._s(e.orderCollect.nowReceiveAmount))])])],1),e._v(" "),i("el-row",{staticStyle:{"margin-bottom":"10px"}},[i("el-col",{attrs:{span:24}},[i("div",[i("b",[e._v("备注  :  ")]),e._v(e._s(e.orderCollect.remark))])])],1)],1),e._v(" "),i("el-row",{style:e.initData.orderDetail_style},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1),e._v(" "),i("br"),e._v(" "),i("el-row",{style:e.initData.deliverDetail_style},[i("custom-base-table",{ref:"deliverDetailDialog",attrs:{isSortable:!1,varList:e.tableData_deliverDetail,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn_deliverDetail,apiObj:e.apiObj_deliverDetail,mergeTitle:e.mergeTitle_deliverDetail,mergeColumn:e.mergeColumn_deliverDetail,mergeRow:e.mergeRow_deliverDetail,tempData:e.tempData_deliverDetail,componentId:"deliverDetailDialog",useDefaultBtn:!1,showAll:!1,keyMapping:e.keyMapping_deliverDetail,hidePages:!0},on:{databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);s.options.__file="orderCollect.vue";t.default=s.exports},"9WTv":function(e,t,i){"use strict";i.d(t,"d",function(){return o}),i.d(t,"a",function(){return n}),i.d(t,"f",function(){return l}),i.d(t,"e",function(){return r}),i.d(t,"b",function(){return s}),i.d(t,"c",function(){return d});var a=i("t3Un");function o(e){return Object(a.a)({url:"/base/equipment/listPageEquipments",method:"post",data:e})}function n(e){return Object(a.a)({url:"/base/equipment/addEquipment",method:"post",data:e})}function l(e){return Object(a.a)({url:"/base/equipment/updateEquipment",method:"post",data:e})}function r(e,t){return Object(a.a)({url:"/base/equipment/update",method:"post",data:{id:e,isdisable:t}})}function s(e){return Object(a.a)({url:"/base/equipment/deleteByIds",method:"post",data:{ids:e}})}function d(e){return Object(a.a)({url:"/base/equipment/exportExcelEquipments",method:"post",responseType:"blob",data:{ids:e}})}},"9m9g":function(e,t,i){"use strict";i.r(t);i("rGqo");var a=i("zDZ1"),o=i("2+ib"),n=i("uTIz"),l=i("/RvK"),r=i("rIO6"),s=i("5Fd+"),d=i("ddId"),c=i("Vobf"),u=(i("z0WU"),{orderAudit:{orderId:"",isCustomerPrice:""},components:{dialogQrcode:a.a,multilevelTable:o.a,searchBar:n.a,dialogEdit:l.default,dialogRebackBill:r.default,orderCollect:s.default},data:function(){return{isLockStock:"",searchList:[{label:"订单编号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单编号"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"customerName",configs:{},placeholder:"客户名称"},{label:"发票类型",type:"select",ruleType:"string",mapKey:"receiptType",configs:{clearable:!0,name:"",options:[{value:"1",label:"不开票"},{value:"2",label:"增值税普通发票"},{value:"3",label:"增值税专用发票"}]},placeholder:"请选择"},{label:"下单日期起",type:"date",ruleType:"date",mapKey:"orderDateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"下单日期止",type:"date",ruleType:"date",mapKey:"orderDateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"约定交期",type:"date",ruleType:"date",mapKey:"deliverDate",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"订单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"待发货"},{value:"3",label:"已发货"},{value:"4",label:"已完成"},{value:"-1",label:"已取消"}]},placeholder:"请选择"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"sysCode",width:"200"},{columnIndex:"customerName"},{columnIndex:"orderDate"},{columnIndex:"expectDate"},{columnIndex:"orderSum"},{columnIndex:"makeName"},{columnIndex:"remark"},{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"4",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待发货"},info3:{state:"3",text:"已发货"},info:{state:"-1",text:"已取消"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"通过",nameEn:"auditPassByParent",editBtns_isShow:!0,icon:"auditPassByParent",method:this.auditPassByParent},{name:"退回",nameEn:"auditDisagreeByParent",editBtns_isShow:!0,icon:"auditDisagreeByParent",method:this.auditDisagreeByParent},{name:"详情",nameEn:"infoByParent",editBtns_isShow:!0,icon:"infoByParent",method:this.infoByParent}]}],apiObj:{apiName:"listPageSaleOrder",params:{state:"1"}},tempData:{},showHeader:!1,showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"5",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待生产"},info3:{state:"3",text:"待出库"},info4:{state:"4",text:"待发货"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageSaleOrderDetail",params:{isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],searchObj:{},selectList:[],configs:{topBarBtnList:[],tableConfigs:[]},temp:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null,detailIds:""}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,i=e.$storage.get("menuId");t&&(e.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(c.initMenuButtons)({menuId:i,roleId:t}).then(function(t){e.$loading().close();var i=t.buttonList;i&&i.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){e.$loading().close()}))},databridge:function(e){this.temp.dataList=e,this.selectList=e},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.updateData(this.searchObj)},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},closeDialog:function(e){this.showDialog=!1,this.updateData(this.searchObj)},auditDisagreeByParent:function(e,t){this.dialogData.temp=e,this.dialogData.title="审核退回",this.openDialogName="dialogRebackBill",this.showDialog=!0,this.visible=!0},infoByParent:function(e,t){var i=document.body.clientWidth,a=document.body.clientHeight,o=.8*i;this.dialogData.dialog_width=o+"px";var n=.9*a,l=.25*n+"px";this.dialogData.orderDetail_style="height:"+l+";width: 96%;margin-left: 2%;";var r=.25*n+"px";this.dialogData.deliverDetail_style="height:"+r+";width: 96%;margin-left: 2%;",this.dialogData.temp=e,this.dialogData.orderObject=e,this.dialogData.orderId=e.id,this.dialogData.title="订单详情",this.openDialogName="orderCollect",this.showDialog=!0,this.visible=!0},auditPassByParent:function(e,t){var i=this;this.$confirm("该订单是否审核通过?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",distinguishCancelAndClose:!0,type:"warning"}).then(function(){i.orderAudit={orderId:e.id},i.auditPassSaleOrder(i.orderAudit)}).catch(function(e){"cancel"===e&&i.$message({type:"info",message:"已取消"})})},auditPassSaleOrder:function(e){var t=this;Object(d.b)(e).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"审核成功",type:"success",duration:2e3}),t.updateData(t.searchObj))}).catch(function(e){})},executorByDetail:function(e,t){this.resetTemp(),this.dialogData.temp=e,this.dialogData.tempLable=this.tempLable,this.dialogData.title="查看执行人",this.openDialogName="dialogViewExecutor",this.showDialog=!0,this.visible=!0},exportExcel:function(){}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),m=(i("PRRt"),i("KHd+")),p=Object(m.a)(u,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"orderAudit"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);p.options.__file="index.vue";t.default=p.exports},PRRt:function(e,t,i){"use strict";var a=i("tSA/");i.n(a).a},QzUw:function(e,t,i){},S8Ej:function(e,t,i){},bNCw:function(e,t,i){"use strict";var a=i("QzUw");i.n(a).a},ddId:function(e,t,i){"use strict";i.d(t,"c",function(){return o}),i.d(t,"e",function(){return n}),i.d(t,"d",function(){return l}),i.d(t,"b",function(){return r}),i.d(t,"a",function(){return s});var a=i("t3Un");function o(e){return Object(a.a)({url:"/sale/saleOrderAudit/listPageSaleOrderDetailByLockStock",method:"post",data:e})}function n(e){return Object(a.a)({url:"/sale/saleOrderAudit/updateSaleOrderDetailByLockStock",method:"post",data:e})}function l(e){return Object(a.a)({url:"/sale/saleOrderAudit/updateSaleOrderByAudit",method:"post",data:e})}function r(e){return Object(a.a)({url:"/sale/saleOrderAudit/auditPassSaleOrder",method:"post",data:e})}function s(e){return Object(a.a)({url:"/sale/saleOrderAudit/auditDisagreeSaleOrder",method:"post",data:e})}},ghff:function(e,t,i){"use strict";var a=i("S8Ej");i.n(a).a},lZYi:function(e,t,i){"use strict";var a=i("wnxv");i.n(a).a},rIO6:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf");var a=i("ddId");function o(e){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var n={name:"dialog-edit",props:["initData","visible"],data:function(){return{orderId:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{remark:[{required:!0,message:"请填写退回原因！",trigger:"change"}]}}},created:function(){this.orderId=this.initData.temp.id},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=o(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},save:function(){var e=this;this.$refs.submitForm.validate(function(t){if(t){e.dialogLoading=!0;var i=e.$storage.get("userInfo").userName;Object(a.a)({orderId:e.orderId,remark:e.temp.remark,userName:i}).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"退回成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1})}})}}},l=i("KHd+"),r=Object(l.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"编辑",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"400px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"30px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"退回原因:",prop:"remark"}},[i("el-input",{staticStyle:{width:"240px"},attrs:{type:"textarea",rows:2},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);r.options.__file="dialogRebackBill.vue";t.default=r.exports},"tSA/":function(e,t,i){},wnxv:function(e,t,i){},zDZ1:function(e,t,i){"use strict";i("rE2o"),i("ioFf"),i("f3/d"),i("9WTv");function a(e){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var o={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},tempShow:{},rules:{},imageUrl:""}},created:function(){console.log(this.initData),this.initData.temp&&(this.temp=this.initData.temp,this.initData.temp.qrcode&&(this.imageUrl="http://vmes.deecoop.cn/"+this.initData.temp.qrcode)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=a(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},download:function(){var e=this.imageUrl,t=document.createElement("a");t.style.display="none",t.href=e,t.setAttribute("download",this.temp.name),document.body.appendChild(t),t.click()},print:function(){var e='<!DOCTYPE html> <html> <head> <meta charset="utf-8"> <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> ';e+="<style></style>",e+="</head><body >",e+=document.getElementById("printContent").innerHTML,e+="</body></html>";var t=window.open("","打印","");t.document.write(e),t.document.close(),t.focus(),t.print(),t.close()}}},n=(i("lZYi"),i("bNCw"),i("KHd+")),l=Object(n.a)(o,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"二维码",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"400px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("div",{attrs:{id:"printContent"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"text-align":"center","padding-bottom":"20px"},attrs:{span:24}},[e.imageUrl?i("img",{staticClass:"avatar",staticStyle:{margin:"0 auto"},attrs:{src:e.imageUrl}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("b",{staticStyle:{"padding-left":"35%"}},[e._v(e._s(e.tempLable.code)+":")]),e._v(e._s(e.temp.code)),i("br"),e._v(" "),i("b",{staticStyle:{"padding-left":"35%"}},[e._v(e._s(e.tempLable.name)+":")]),e._v(e._s(e.temp.name)+"\n\n          ")])],1)],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center",padding:"15px 0 15px 0"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.download}},[e._v("下载")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:e.print}},[e._v("打印")])],1)])])},[],!1,null,"48eacded",null);l.options.__file="dialogQrcode.vue";t.a=l.exports}}]);