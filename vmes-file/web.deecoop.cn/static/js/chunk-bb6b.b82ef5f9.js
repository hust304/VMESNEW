(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-bb6b"],{LsiE:function(t,e,a){"use strict";var i=a("rAcx");a.n(i).a},MaXN:function(t,e,a){"use strict";a.r(e);var i=a("uTIz"),s=a("2+ib"),o=a("U9kq"),n=a("mbVW"),l={components:{searchBar:i.a,multilevelTable:s.a,dialogAuditDisagree:o.default},data:function(){return{searchList:[{label:"报废单号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"报废单号"},{label:"供应商",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"供应商"},{label:"状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"待报废"},{value:"3",label:"已完成"},{value:"-1",label:"已取消"},{value:"",label:"全部"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},searchObj:{},guid:"",tableData:[],tableConfigList:[{customColumn:[{columnIndex:"state",width:"80",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待报废"},info3:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"160",component:[{name:"通过",nameEn:"auditPassByParent",rowState:"#self@state#===1",editBtns_isShow:!0,method:this.auditPassByParent},{name:"退回",nameEn:"auditDisagreeByParent",rowState:"#self@state#===1",editBtns_isShow:!0,method:this.auditDisagreeByParent}]}],apiObj:{apiName:"listPageAssistDiscard",params:{fieldCode:"sysCode,supplierName,creatUserName,creatDateStr,remark,state",state:"1",type:"2",orderStr:"assistDiscard.cdate desc"}},tempData:{},showHeader:!0,showIndex:!1,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[],apiObj:{apiName:"listPageAssistDiscardDetail",params:{fieldCode:"prodInfo,orderUnitName,orderCount",addColumn:{columnKey:"prodInfo",columnName:"货品"},prodColumnKey:"productCode,productName,productSpec,productProperty",isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!1,showCheckBox:!1,isSingle:!1,leftFixed:3,rightFixed:0,componentId:"twoLevelTable"}],openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",data:null},dialogLoading:!0}},beforeCreate:function(){},created:function(){},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},methods:{updateData:function(t){this.$refs.customBaseTable.updateData(t)},getData:function(){this.$refs.customBaseTable.getData()},searchMap:function(t){this.searchObj=t,this.updateData(this.searchObj)},sendGuid:function(t){this.guid=t},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},databridge:function(t){this.tableData=t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},auditPassByParent:function(t){var e=this;this.$confirm("是否审核通过?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(n.auditPassAssistDiscard)({id:t.id,type:t.type}).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),e.updateData(e.searchObj))}).catch(function(t){})})},auditDisagreeByParent:function(t){this.dialogData.rowData=JSON.parse(JSON.stringify(t)),this.dialogData.title="审核退回",this.openDialogName="dialogAuditDisagree",this.showDialog=!0,this.visible=!0}},watch:{}},r=(a("LsiE"),a("QWtV"),a("KHd+")),c=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"auditAssistDiscard"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle",attrs:{span:24}},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_assist_assistDiscard_auditAssistDiscard_index0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);c.options.__file="index.vue";e.default=c.exports},Op6v:function(t,e,a){},QWtV:function(t,e,a){"use strict";var i=a("Op6v");a.n(i).a},rAcx:function(t,e,a){}}]);