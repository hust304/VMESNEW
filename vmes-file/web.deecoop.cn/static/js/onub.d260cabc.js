(window.webpackJsonp=window.webpackJsonp||[]).push([["onub"],{onub:function(e,t,a){"use strict";a.r(t);var i={components:{customBaseTable:a("WIyV").a},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,tableData:[],tableList:[],apiObj:{apiName:"listPageOrderDetaiByPurchasePlan",params:{fieldCode:"sysCode,prodInfo,orderUnitName,allowStockCount,safetyCount,orderCount,purchasePlanCount",prodColumnKey:"productCode,productName,productSpec,productProperty",orderDtlIds:""}},customColumn:[{columnIndex:"prodInfo",width:"200",_cellConfig:{hideTitle:!0}},{columnIndex:"purchasePlanCount",width:"120",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{minDate:new Date}}},created:function(){this.apiObj.params.orderDtlIds=this.initData.orderDtlIds},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.planAddDialog.getData()},databridge:function(e){null!=e&&e.length>0&&(this.tableList=e)},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},save:function(){this.getData(),null!=this.tableList&&this.tableList.length>0&&(this.isVisible=!1,this.dialogClose({selectList:this.tableList,pageName:"editOrderByPurchasePlan"}))}},watch:{}},o=a("KHd+"),l=Object(o.a)(i,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1250px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-row",{staticStyle:{width:"96%","margin-left":"2%"}},[a("custom-base-table",{ref:"planAddDialog",attrs:{"data-custom-table-id":"views_purchase_planManager_editOrderByPurchasePlan0",isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,tempData:e.tempData,componentId:"planAddDialog",useDefaultBtn:!0,showAll:!1,keyMapping:e.keyMapping},on:{databridge:e.databridge}})],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("确定")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="editOrderByPurchasePlan.vue";t.default=l.exports}}]);