(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-819c"],{"1pkS":function(t,e,a){},"2cdE":function(t,e,a){"use strict";a.r(e);a("rGqo");var i=a("2+ib"),n=a("uTIz"),s=a("PHiC"),o=a("kAts"),c=a("Vobf"),l=(a("z0WU"),{components:{multilevelTable:i.a,searchBar:n.a,dialogAuditDisagree:s.default},data:function(){return{searchList:[{label:"收款单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"入库单号"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"仓库名称"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"150",component:[{name:"通过",nameEn:"auditPassByParent",editBtns_isShow:!0,rowState:"#self@isAudit# == 0",method:this.auditPassByParent},{name:"不通过",nameEn:"auditDisagreeByParent",editBtns_isShow:!0,rowState:"#self@isAudit# == 0",method:this.auditDisagreeByParent}]}],apiObj:{apiName:"listPageSaleReceives",params:{fieldCode:"code,name,typeName,receiveSum,cdate,auditResultName,remark",isNeedDetail:"true",dataType:this.$storage.get("dataType"),detailState:"0",orderStr:"receive.cdate desc"}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{}],apiObj:{apiName:"findListSaleReceiveDetailByByAudit",params:{fieldCode:"sysCode,orderSum,discountAmount,receiveAmount,cdateStr",state:"0",isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,componentId:"twoLevelTable",dragTable:!0}],searchObj:{},selectList:[],configs:{},temp:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",warehouseType:"",parentId:"",title:"",temp:[],tempLable:[]}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,a=t.$storage.get("menuId");e&&(t.$loading({spinner:"preloader",text:""}),Object(c.initMenuButtons)({menuId:a,roleId:e}).then(function(e){t.$loading().close();var a=e.buttonList;a&&a.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)})),t.tableConfigList&&t.tableConfigList.forEach(function(t){t.customColumn&&t.customColumn.forEach(function(t){"last"==t.columnIndex&&t.component&&t.component.forEach(function(t){t.nameEn==e.nameEn&&(t.rowState="1==2")})})})})}).catch(function(e){t.$loading().close()}))},databridge:function(t){this.selectList=t},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},auditPassByParent:function(t,e){var a=this,i=t.auditResult;null!=i&&i.trim().length>0?this.$message({type:"warning",duration:5e3,showClose:!0,message:"该收款单已经审核！"}):this.$confirm("此操作执行成功后该付款单的明细状态变更为已完成，是否执行审核通过?","提示",{confirmButtonText:"通过",cancelButtonText:"取消",type:"warning"}).then(function(){Object(o.auditPassSaleReceive)({parentId:t.id}).then(function(t){a.dialogLoading=!1,0===t.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.isVisible=!1,a.updateData(a.searchObj))}).catch(function(t){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})})},auditDisagreeByParent:function(t,e){this.dialogData.parentId=t.id,this.dialogData.title="审核不通过",this.openDialogName="dialogAuditDisagree",this.showDialog=!0,this.visible=!0}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),r=(a("9wBy"),a("y4NS"),a("KHd+")),d=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"receiveAudit"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_sale_receivables_receiveAudit_index0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);d.options.__file="index.vue";e.default=d.exports},"9wBy":function(t,e,a){"use strict";var i=a("TFrn");a.n(i).a},TFrn:function(t,e,a){},y4NS:function(t,e,a){"use strict";var i=a("1pkS");a.n(i).a}}]);