(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-6c04"],{"9ehx":function(t,e,a){},BvIC:function(t,e,a){"use strict";a.r(e);var i=a("uTIz"),n=a("2+ib"),o=a("gbju"),s=a("yNXC"),l=a("Hhy1"),c=a("AV4t"),d=a("+NOJ"),r={components:{searchBar:i.a,multilevelTable:n.a,dialogExecute:o.default,addFinanceBillByPurchase:s.default,dialogListFinanceBill:l.default},data:function(){return{searchList:[{label:"订单编号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单编号"},{label:"供应商",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"供应商"},{label:"状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"待发货"},{value:"3",label:"外协中"},{value:"4",label:"已完成"},{value:"-1",label:"已取消"},{value:"",label:"全部"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},searchObj:{},guid:"",tableData:[],tableConfigList:[{customColumn:[{columnIndex:"state",width:"80",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待退货"},info3:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"160",component:[{name:"扣款",nameEn:"addFinanceBillByParent",editBtns_isShow:!0,method:this.addFinanceBillByParent},{name:"扣款记录",nameEn:"findFinanceBillByParent",editBtns_isShow:!0,method:this.findFinanceBillByParent}]}],apiObj:{apiName:"listPageAssistRetreat",params:{fieldCode:"sysCode,supplierName,creatUserName,creatDateStr,remark,state",type:"2",state:"2"}},tempData:{},showHeader:!0,showIndex:!1,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"prodInfo",width:"500",_cellConfig:{hideTitle:!0}},{columnIndex:"state",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待退货"},info3:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"160",component:[{name:"免检",nameEn:"updateQualityByDetail",editBtns_isShow:!0,rowState:"#self@state#===2",method:this.updateQualityByDetail},{name:"执行",nameEn:"executeByDetail",editBtns_isShow:!0,owState:"#self@state#===2",method:this.executeByDetail},{name:"详情",nameEn:"signQualityInfoByDetail",editBtns_isShow:!0,method:this.signQualityInfoByDetail}]}],apiObj:{apiName:"listPageAssistRetreatDetail",params:{fieldCode:"prodInfo,orderUnitName,orderCount,state",addColumn:{columnKey:"prodInfo",columnName:"货品"},prodColumnKey:"productCode,productName,productSpec,productProperty",isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!1,showCheckBox:!1,isSingle:!1,leftFixed:3,rightFixed:0,componentId:"twoLevelTable"}],openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",data:null},dialogLoading:!0}},beforeCreate:function(){},created:function(){},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},methods:{updateData:function(t){this.$refs.customBaseTable.updateData(t)},getData:function(){this.$refs.customBaseTable.getData()},searchMap:function(t){this.searchObj=t,this.updateData(this.searchObj)},sendGuid:function(t){this.guid=t},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},databridge:function(t){this.tableData=t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},addFinanceBillByParent:function(t){this.dialogData.rowData=JSON.parse(JSON.stringify(t)),this.dialogData.title="扣款",this.openDialogName="addFinanceBillByPurchase",this.showDialog=!0,this.visible=!0},findFinanceBillByParent:function(t){this.dialogData.rowData=JSON.parse(JSON.stringify(t)),this.dialogData.title="扣款记录",this.openDialogName="dialogListFinanceBill",this.showDialog=!0,this.visible=!0},updateQualityByDetail:function(t){var e=this;this.$confirm("此操作将该记录执行免检 , 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(d.updateAssistRetreatDetailByProductQuality)({retreatDtlId:t.id,orderId:t.orderId,roleId:e.$storage.get("userInfo").roleIds}).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),e.updateData(e.searchObj))}).catch(function(t){})}).catch(function(){e.$message({type:"info",message:"已取消操作"})})},executeByDetail:function(t){var e=this;Object(c.checkExistQualityByProduct)({productId:t.productId}).then(function(a){null!=a.isExist&&"false"==a.isExist?e.$confirm("该货品无质检项，请在(质量-质检项设置)添加该货品质检项， 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){e.dialogData.rowData=t,e.dialogData.title="检验执行",e.openDialogName="dialogExecute",e.showDialog=!0,e.visible=!0}).catch(function(){e.$message({type:"info",message:"已取消执行"})}):(e.dialogData.rowData=t,e.dialogData.title="检验执行",e.openDialogName="dialogExecute",e.showDialog=!0,e.visible=!0)})},signQualityInfoByDetail:function(t){}},watch:{}},u=(a("aSZg"),a("acJX"),a("KHd+")),h=Object(u.a)(r,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"listAssistRetreat"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle",attrs:{span:24}},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_quality_assistQuality_assistRetreatProductByQuality_index0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);h.options.__file="index.vue";e.default=h.exports},aSZg:function(t,e,a){"use strict";var i=a("qQNm");a.n(i).a},acJX:function(t,e,a){"use strict";var i=a("9ehx");a.n(i).a},qQNm:function(t,e,a){}}]);