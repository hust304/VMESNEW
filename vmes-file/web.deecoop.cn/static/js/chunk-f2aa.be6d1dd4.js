(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-f2aa"],{"4/Gt":function(e,t,a){},D6Iz:function(e,t,a){"use strict";var n=a("qVjb");a.n(n).a},NLGg:function(e,t,a){"use strict";a.r(t);a("rGqo"),a("yt8O"),a("XfO3"),a("9AAn");var n=a("2+ib"),i=a("uTIz"),o=a("C9Ry"),s=a("txn6"),r=a("Vobf"),c={components:{multilevelTable:n.a,searchBar:i.a,dialogAuditDisagree:o.default},data:function(){return{outStateNameMap:new Map([["0","未完成"],["1","已完成"],["2","待提交"],["3","待审核"],["-1","已取消"]]),searchList:[{label:"报废单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"报废单号"},{label:"报废单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"1",label:"已完成"},{value:"3",label:"待审核"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"规格型号"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"productUnitName",configs:{},placeholder:"计量单位"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"1",text:"已完成"},info2:{state:"2",text:"待提交"},info3:{state:"3",text:"待审核"},info:{state:"-1",text:"已取消"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"通过",nameEn:"auditByParent",editBtns_isShow:!0,rowState:"#self@state#===3",method:this.auditByParent},{name:"退回",nameEn:"auditDisagreeByParent",editBtns_isShow:!0,rowState:"#self@state#===3",method:this.auditDisagreeByParent}]}],apiObj:{apiName:"listPageWarehouseOuts",params:{typeName:"报废处理",dataType:this.$storage.get("dataType"),fieldCode:"code,typeName,makeName,cdate,state",isNeedWarehouseWarehouse:"true",state:"3",orderStr:"warehouseout.cdate desc"}},tempData:{},showHeader:!0,showIndex:!1,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[],apiObj:{apiName:"listPageWarehouseOutDetails",params:{fieldCode:"warehouseName,productCode,productName,productSpec,productGenreName,warehouseProductStockCount,count,executeCount,remark",typeName:"报废处理",isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,componentId:"twoLevelTable",dragTable:!1}],searchObj:{},selectList:[],configs:{topBarBtnList:[],tableConfigs:[]},temp:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",warehouseType:"",businessId:"",title:"",temp:[],tempLable:[]}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,a=e.$storage.get("menuId");t&&(e.$loading({spinner:"preloader",text:""}),Object(r.initMenuButtons)({menuId:a,roleId:t}).then(function(t){e.$loading().close();var a=t.buttonList;a&&a.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)})),e.tableConfigList&&e.tableConfigList.forEach(function(e){e.customColumn&&e.customColumn.forEach(function(e){"last"==e.columnIndex&&e.component&&e.component.forEach(function(e){e.nameEn==t.nameEn&&(e.rowState="1==2")})})})})}).catch(function(t){e.$loading().close()}))},databridge:function(e){this.selectList=e},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.updateData(this.searchObj)},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},auditByParent:function(e,t){var a=this;this.$confirm("当前报废记录是否审核通过?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(s.auditPassWarehouseOutScrapByWC)(e).then(function(e){0===e.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(e){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})})},auditDisagreeByParent:function(e,t){this.dialogData.temp=JSON.parse(JSON.stringify(e)),this.dialogData.title="审核退回",this.openDialogName="dialogAuditDisagree",this.showDialog=!0,this.visible=!0}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},l=(a("QizQ"),a("D6Iz"),a("KHd+")),u=Object(l.a)(c,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"warehouseOutManage"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_warehouseByWC_scrapByWC_auditScrapByWC_index0",tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);u.options.__file="index.vue";t.default=u.exports},QizQ:function(e,t,a){"use strict";var n=a("4/Gt");a.n(n).a},qVjb:function(e,t,a){}}]);