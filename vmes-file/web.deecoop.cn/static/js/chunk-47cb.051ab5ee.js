(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-47cb"],{"5nyD":function(t,e,a){"use strict";a.r(e);var i=a("uTIz"),s=a("2+ib"),n=a("2bT2"),o=a("V9Vj"),l={components:{searchBar:i.a,multilevelTable:s.a,dialogAssistProductDetail:n.default},data:function(){return{searchList:[{label:"签收单号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"签收单号"},{label:"供应商",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"供应商"},{label:"状态",type:"select",ruleType:"string",mapKey:"signState",configs:{clearable:!0,name:"",options:[{value:"1",label:"检验中"},{value:"2",label:"已完成"},{value:"-1",label:"已取消"},{value:"",label:"全部"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},searchObj:{},guid:"",tableData:[],tableConfigList:[{customColumn:[{columnIndex:"state",width:"80",componentName:"tag",_cellConfig:{success:{state:"2",text:"已完成"},info1:{state:"1",text:"检验中"},info2:{state:"2",text:"已完成"},info:{state:"-1",text:"已取消"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"160",component:[{name:"取消",nameEn:"cancelByParent",editBtns_isShow:!0,method:this.cancelByParent},{name:"详情",nameEn:"infoByParent",editBtns_isShow:!0}]}],apiObj:{apiName:"listPageAssistSign",params:{fieldCode:"sysCode,orderCode,supplierName,signUserName,signDate,state",orderStr:"sign.cdate desc"}},tempData:{},showHeader:!0,showIndex:!1,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"160",component:[{name:"原材料",nameEn:"findAssistProductDetail",editBtns_isShow:!0,method:this.findAssistProductDetail}]}],apiObj:{apiName:"listPageAssistSignDetail",params:{fieldCode:"assistProductName,craftName,orderUnitName,qualityName,arriveCount",isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!1,showCheckBox:!1,isSingle:!1,leftFixed:3,rightFixed:0,componentId:"twoLevelTable"}],openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",data:null},dialogLoading:!0}},beforeCreate:function(){},created:function(){},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},methods:{updateData:function(t){this.$refs.customBaseTable.updateData(t)},getData:function(){this.$refs.customBaseTable.getData()},searchMap:function(t){this.searchObj=t,this.updateData(this.searchObj)},sendGuid:function(t){this.guid=t},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},databridge:function(t){this.tableData=t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},cancelByParent:function(t){var e=this;this.$confirm("此操作将该签收单变更为已取消, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(o.cancelAssistSign)({signId:t.id}).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),e.updateData(e.searchObj))}).catch(function(t){})}).catch(function(){e.$message({type:"info",message:"已取消操作"})})},findAssistProductDetail:function(t){this.dialogData.title="原材料",this.dialogData.parentId=t.assistProductId,this.openDialogName="dialogAssistProductDetail",this.showDialog=!0,this.visible=!0}},watch:{}},c=(a("pcXG"),a("WzlT"),a("KHd+")),r=Object(c.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"listAssistSign"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle",attrs:{span:24}},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_assist_assistSign_listAssistSign_index0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);r.options.__file="index.vue";e.default=r.exports},WzlT:function(t,e,a){"use strict";var i=a("xlWY");a.n(i).a},jeBC:function(t,e,a){},pcXG:function(t,e,a){"use strict";var i=a("jeBC");a.n(i).a},xlWY:function(t,e,a){}}]);