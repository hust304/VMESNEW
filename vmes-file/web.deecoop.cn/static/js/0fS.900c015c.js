(window.webpackJsonp=window.webpackJsonp||[]).push([["/0fS"],{"/0fS":function(e,t,a){"use strict";a.r(t);var i=a("2+ib"),o=(a("z0WU"),{components:{multilevelTable:i.a},name:"dialog-add",props:["initData","visible"],data:function(){var e=this;return{rules:{typeName:[{required:!0,trigger:"change",validator:function(t,a,i){e.typeData.defaultSelected.length<=0?i(new Error("请选择出库类型")):i()}}],warehouseName:[{required:!0,trigger:"change",message:"请选择仓库"}],deptName:[{required:!0,message:"请选择接收单位",trigger:"change"}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{type:"",typeName:"",warehouseId:"",warehouseName:"",deptId:"",deptName:"",makeId:"",makeName:"",dtlJsonStr:""},tempLable:{},tableData:[],selectList:[],configs:{topBarBtnList:[]},tableConfigList:[{customColumn:[],apiObj:{apiName:"listPageWarehouseOutDetails",params:{fieldCode:"warehouseName,productCode,productName,productSpec,productGenreName,productUnitName,count,executeCount,stateName,remark",typeName:"报废处理",parentId:this.initData.temp.id}},tempData:{},showIndex:!0,showHeader:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"all",rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[],apiObj:{apiName:"listPageWarehouseOutExecutes",params:{fieldCode:"warehouseName,actualCount,executorName,endDate",isNeedPage:"false"}},dynamicValue:{detailId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable",leftFixed:1,rightFixed:1}]}},created:function(){var e=this.$storage.get("userInfo");this.temp.makeId=e.userId,this.temp.makeName=e.userName},mounted:function(){this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},databridge:function(e){this.selectList=e},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){this.showDialog=!1;null!=e.selectList&&e.selectList}},watch:{}}),l=a("KHd+"),s=Object(l.a)(o,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1300px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog,"table-selected":e.tableSelected}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"90px"}},[a("el-row",{staticClass:"tableContent",staticStyle:{width:"96%","margin-left":"2%"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_warehouseBySimple_scrapBySimple_createScrapBySimple_dialogView0",tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="dialogView.vue";t.default=s.exports}}]);