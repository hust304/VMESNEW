(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-3a27"],{"5Fd+":function(e,t,o){"use strict";o.r(t);var l=o("WIyV"),i=o("2+ib"),a=o("8Vv6"),r={components:{customBaseTable:l.a,multilevelTable:i.a},name:"dialog-edit",props:["initData","visible"],data:function(){return{orderId:"",orderObject:{},orderCollect:{},isShowText:!1,rowData:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",tempLable:null,data:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tableConfigList:[{customColumn:[],apiObj:{apiName:"listPageOrderDetailCollectByInfo",params:{pageNo:1,parentId:this.initData.orderId,fieldCode:"productCode,productName,productSpec,productGenreName,orderUnitName,orderCount,productPrice,productSum,deliverCount,deliverSum,invoiceCount,invoiceSum,deliverDate"}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"5",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待生产"},info3:{state:"3",text:"待出库"},info4:{state:"4",text:"待发货"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageSaleDeliverDetail",params:{pageNo:1,state:"1",orderStr:"detail.product_id,detail.cdate asc",fieldCode:"deliverCode,orderCount,productPrice,sum,cdate,deliverDate"}},dynamicValue:{orderDetaiId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],tableData_deliverDetail:[],apiObj_deliverDetail:{apiName:"listPageSaleReceiveDetails",params:{pageNo:1,state:"1",orderId:this.initData.orderId,orderStr:" receive.code desc",fieldCode:"code,productName,orderSum,discountAmount,receiveAmount,state,remark"}},customColumn_deliverDetail:[],mergeTitle_deliverDetail:[],mergeColumn_deliverDetail:[],mergeRow_deliverDetail:[],keyMapping_deliverDetail:{},tempData_deliverDetail:{}}},beforeCreate:function(){},created:function(){this.orderObject=this.initData.orderObject,this.orderId=this.initData.orderId,this.apiObj_deliverDetail.params.orderId=this.orderId,this.findOrderCollectByOrderId(this.orderId)},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},databridge:function(e){},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},findOrderCollectByOrderId:function(e){var t=this;this.dialogLoading=!0,Object(a.getSaleOrderCollectByOrderId)({id:e}).then(function(e){t.dialogLoading=!1,0===e.code&&null!=e.result&&null!=e.result.varList&&e.result.varList.length>0&&(t.orderCollect=e.result.varList[0])}).catch(function(e){console.log(e),t.dialogLoading=!1})}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}}},d=(o("ghff"),o("KHd+")),n=Object(d.a)(r,function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[o("div",[o("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{margin:"2em 2.3em"}},[o("el-row",{staticStyle:{"margin-bottom":"10px"}},[o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("订单编号  :  ")]),e._v(e._s(e.orderCollect.sysCode))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("订单状态  :  ")]),e._v(e._s(e.orderCollect.stateName))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("制单人  :  ")]),e._v(e._s(e.orderCollect.makeName))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("下单日期  :  ")]),e._v(e._s(e.orderCollect.orderDate))])])],1),e._v(" "),o("el-row",{staticStyle:{"margin-bottom":"10px"}},[o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("客户名称  :  ")]),e._v(e._s(e.orderCollect.customerName))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("约定交期  :  ")]),e._v(e._s(e.orderCollect.expectDate))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("发票类型  :  ")]),e._v(e._s(e.orderCollect.receiptTypeName))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("审核人:")]),e._v(e._s(e.orderCollect.auditName))])])],1),e._v(" "),o("el-row",{staticStyle:{"margin-bottom":"10px"}},[o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("发货完成日期  :  ")]),e._v(e._s(e.orderCollect.deliverDate))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("付款完成日期  :  ")]),e._v(e._s(e.orderCollect.payDate))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("账期截止日  :  ")]),e._v(e._s(e.orderCollect.deadlineDate))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.daysRemaining<0,expression:"orderCollect.daysRemaining<0"}],staticStyle:{color:"red"}},[o("b",[e._v("逾期(天)  :  ")]),e._v(e._s(e.orderCollect.daysRemaining))]),e._v(" "),o("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.daysRemaining>=0,expression:"orderCollect.daysRemaining>=0"}]},[o("b",[e._v("账期剩余(天)  :  ")]),e._v(e._s(e.orderCollect.daysRemaining))])])],1),e._v(" "),o("el-row",{staticStyle:{"margin-bottom":"10px"}},[o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("发货金额  :  ")]),e._v(e._s(e.orderCollect.deliverAmount))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("实收金额  :  ")]),e._v(e._s(e.orderCollect.receivedAmount))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("折扣金额  :  ")]),e._v(e._s(e.orderCollect.discountedAmount))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",{directives:[{name:"show",rawName:"v-show",value:0==e.orderCollect.nowReceiveAmount&&0==e.orderCollect.preReceiveAmount,expression:"orderCollect.nowReceiveAmount==0&&orderCollect.preReceiveAmount==0"}]},[o("b",[e._v("应收金额  :  ")]),e._v(e._s(e.orderCollect.nowReceiveAmount))]),e._v(" "),o("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.nowReceiveAmount>0&&0==e.orderCollect.preReceiveAmount,expression:"orderCollect.nowReceiveAmount>0&&orderCollect.preReceiveAmount==0"}]},[o("b",[e._v("应收金额  :  ")]),e._v(e._s(e.orderCollect.nowReceiveAmount))]),e._v(" "),o("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.preReceiveAmount>0&&0==e.orderCollect.nowReceiveAmount,expression:"orderCollect.preReceiveAmount>0&&orderCollect.nowReceiveAmount==0"}]},[o("b",[e._v("预收金额  :  ")]),e._v(e._s(e.orderCollect.preReceiveAmount))])])],1),e._v(" "),o("el-row",{staticStyle:{"margin-bottom":"10px"}},[o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("订单金额  :  ")]),e._v(e._s(e.orderCollect.orderAmount))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("预付款  :  ")]),e._v(e._s(e.orderCollect.advanceAmount))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",[o("b",[e._v("开票金额  :  ")]),e._v(e._s(e.orderCollect.invoiceAmount))])]),e._v(" "),o("el-col",{attrs:{span:6}},[o("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.daysRemaining<0,expression:"orderCollect.daysRemaining<0"}],staticStyle:{color:"red"}},[o("b",[e._v("逾期金额  :  ")]),e._v(e._s(e.orderCollect.nowReceiveAmount))])])],1),e._v(" "),o("el-row",{staticStyle:{"margin-bottom":"10px"}},[o("el-col",{attrs:{span:24}},[o("div",[o("b",[e._v("备注  :  ")]),e._v(e._s(e.orderCollect.remark))])])],1)],1),e._v(" "),o("el-row",{style:e.initData.orderDetail_style},[o("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1),e._v(" "),o("br"),e._v(" "),o("el-row",{style:e.initData.deliverDetail_style},[o("custom-base-table",{ref:"deliverDetailDialog",attrs:{isSortable:!1,varList:e.tableData_deliverDetail,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn_deliverDetail,apiObj:e.apiObj_deliverDetail,mergeTitle:e.mergeTitle_deliverDetail,mergeColumn:e.mergeColumn_deliverDetail,mergeRow:e.mergeRow_deliverDetail,tempData:e.tempData_deliverDetail,componentId:"deliverDetailDialog",useDefaultBtn:!1,showAll:!1,keyMapping:e.keyMapping_deliverDetail,hidePages:!0},on:{databridge:e.databridge}})],1),e._v(" "),o("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[o("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);n.options.__file="orderCollect.vue";t.default=n.exports},S8Ej:function(e,t,o){},ghff:function(e,t,o){"use strict";var l=o("S8Ej");o.n(l).a}}]);