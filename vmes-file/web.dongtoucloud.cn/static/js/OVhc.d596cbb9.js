(window.webpackJsonp=window.webpackJsonp||[]).push([["OVhc"],{OVhc:function(e,a,t){"use strict";t.r(a);var i={components:{multilevelTable:t("2+ib").a},props:["initData","visible"],data:function(){return{parentId:"",tableData:[],tableConfigList:[{customColumn:[{columnIndex:"sysCode",width:"200"},{columnIndex:"customerName"},{columnIndex:"orderDate"},{columnIndex:"makeName"},{columnIndex:"changeStateName"}],apiObj:{apiName:"listPageSaleOrderChange",params:{fieldCode:"sysCode,customerName,orderDate,beforeReceiptTypeName,afterReceiptTypeName,makeName,changeStateName,remark",orderId:"",orderStr:"ordeChange.cdate asc"}},mergeTitle:[{index:4,alias:"合并后的列",columns:["beforeReceiptTypeName","afterReceiptTypeName"]}],tempData:{},showHeader:!1,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"all",rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[],apiObj:{apiName:"listPageSaleOrderDetailChange",params:{fieldCode:"productCode,productName,productSpec,orderUnitName,orderCountBefore,orderCountAfter,productPriceBefore,productPriceAfter,priceSumBefore,priceSumAfter,deliverDateBefore,deliverDateAfter",isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:""},dialogLoading:!1,isVisible:!1,inDialog:!0}},beforeCreate:function(){},created:function(){this.tableConfigList[0].apiObj.params.orderId=this.initData.orderId},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},getData:function(){this.$refs.customBaseTable.getData()},databridge:function(e){this.tableData=e},pushData:function(e,a){this.$refs.customBaseTable.pushData(e,a)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},closeDialog:function(){},save:function(){}},watch:{}},o=t("KHd+"),n=Object(o.a)(i,function(){var e=this,a=e.$createElement,t=e._self._c||a;return t("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(a){e.isVisible=a},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?t(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),t("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[t("el-row",{staticStyle:{width:"96%","margin-left":"2%"}},[t("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_sale_orderChangeAudit_orderChangeView0",tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1),e._v(" "),t("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[t("el-button",{on:{click:function(a){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);n.options.__file="orderChangeView.vue";a.default=n.exports}}]);