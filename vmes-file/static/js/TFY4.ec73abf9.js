(window.webpackJsonp=window.webpackJsonp||[]).push([["TFY4"],{TFY4:function(t,e,a){"use strict";a.r(e);a("f3/d");var i=a("WIyV"),n=a("63W0");function o(t,e,a){return e in t?Object.defineProperty(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}var l={components:{customBaseTable:i.a},props:["initData","visible"],data:function(){return{modeId:"",eqptTableData:[],openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},dialogLoading:!0,isVisible:!1,inDialog:!0,tableData:[],dataList:[],apiObj:{apiName:"listPageEquipmentMaintainPlan",params:{type:"add",fieldCode:"code,name,spec,maintainContent,maintainDateStr"}},customColumn:[],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{maxExpectDate:""},isValidate:!1}},beforeCreate:function(){},created:function(){this.modeId=this.initData.modeId},beforeMount:function(){},mounted:function(){var t=this;this.dialogLoading=!1,this.isVisible=this.visible,this.$nextTick(function(e){t.eqptTableData=t.initData.eqptTableData,t.addTableDataByEquipment(t.eqptTableData)})},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(t){Array.isArray(t)&&(this.dataList=[],this.dataList=t)},save:function(){this.$refs.orderAddDialog.getData(),this.saveMaintainPlan(this.dataList)},saveMaintainPlan:function(t){var e=this;if(null!=t&&0!=t.length){for(var a=[],i=0;i<t.length;i++){var l,s=t[i],d=(o(l={equipmentId:s.equipmentId,maintainContentId:s.maintainContentId},"maintainContentId","e9e972fa916c4b9d8b81c2761a2cfb4d"),o(l,"isStop","1"),o(l,"maintainDateStr",s.maintainDateStr),l);a.push(d)}var r="";null!=a&&a.length>0&&(r=JSON.stringify(a)),this.dialogLoading=!0,Object(n.addMaintainPlanByCustom)({modeId:this.modeId,eqptJsonStr:r}).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样设备！"})},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},closeDialog:function(t){},addTableDataByEquipment:function(t){for(var e=0;e<t.length;e++){var a=t[e],i={equipmentId:a.id,code:a.code,name:a.name,spec:a.spec};this.tableData.push(i),console.log(this.tableData,"this.tableData")}}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName},size:function(){return this.$store.getters.size},formItemWidth:function(){var t={};switch(this.size){case"mini":t.width="180px";break;case"small":t.width="200px";break;default:t.width="220px"}return t}},watch:{}},s=a("KHd+"),d=Object(s.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[a("el-row",{staticClass:"tableContent",staticStyle:{width:"96%","margin-left":"2%"}},[a("custom-base-table",{ref:"orderAddDialog",attrs:{isSortable:!1,varList:t.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:t.customColumn,apiObj:t.apiObj,mergeTitle:t.mergeTitle,mergeColumn:t.mergeColumn,mergeRow:t.mergeRow,tempData:t.tempData,componentId:"orderAddDialog",useDefaultBtn:!0,showAll:!1,keyMapping:t.keyMapping},on:{databridge:t.databridge}})],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);d.options.__file="addCustom.vue";e.default=d.exports}}]);