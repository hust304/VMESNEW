(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7839"],{TF2P:function(t,e,a){"use strict";var i=a("ogea");a.n(i).a},W8O8:function(t,e,a){},iKm1:function(t,e,a){"use strict";a.r(e);a("91GP"),a("rGqo");var i=a("uTIz"),n=a("WIyV"),s=a("Qqum"),o=a("YVgj"),c=a("z0WU"),l=a("Vobf"),d=a("We3Z"),h={components:{cancelFinanceBill:d.cancelFinanceBill,customBaseTable:n.a,searchBar:i.a,dialogEdit:o.default,dialogAdd:s.default},data:function(){return{searchList:[{label:"客户编码",type:"input",ruleType:"string",mapKey:"customerCode",configs:{},placeholder:"客户编码"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"customerName",configs:{},placeholder:"客户名称"}],guid:"",searchObj:{},configs:{topBarBtnList:[{name:"录入收款",nameEn:"addReceive",isShow:!0,state:!1,icon:"add",method:this.addReceive},{name:"录入减免",nameEn:"addReduce",isShow:!0,state:!1,icon:"add",method:this.addReduce},{name:"录入退款",nameEn:"addRefund",isShow:!0,state:!1,icon:"add",method:this.addRefund},{name:"增加应收",nameEn:"addRaise",isShow:!0,state:!1,icon:"add",method:this.addRaise},{name:"导出",nameEn:"exportExcel",isShow:!0,state:!1,icon:"export",method:this.exportExcel}],tableConfigs:[],showCheckBox:!1},tableConfigList:[{customColumn:[{columnIndex:"customerName",width:"160",_cellConfig:{hideTitle:!0}},{columnIndex:"state",componentName:"tag",_cellConfig:{success:{state:"2",text:"已审核"},warning:{state:"1",text:"待审核"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"待提交"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"160",component:[{name:"编辑",nameEn:"editFinanceBill",editBtns_isShow:!0,rowState:"#self@state# === 0",method:this.editFinanceBill},{name:"提交",nameEn:"submitFinanceBill",editBtns_isShow:!0,rowState:"#self@state# === 0",method:this.submitFinanceBill},{name:"撤回",nameEn:"rebackFinanceBill",editBtns_isShow:!0,rowState:"#self@state# === 1",method:this.rebackFinanceBill},{name:"取消",nameEn:"cancelFinanceBill",editBtns_isShow:!0,rowState:"#self@state# === 0",method:this.cancelFinanceBill},{name:"恢复",nameEn:"recoverFinanceBill",editBtns_isShow:!0,rowState:"#self@state# === -1",method:this.recoverFinanceBill},{name:"删除",nameEn:"deleteFinanceBill",editBtns_isShow:!0,rowState:"#self@state# === -1",method:this.deleteFinanceBill}]}],apiObj:{apiName:"listPageFinanceBills",params:{fieldCode:"code,customerName,typeName,amount,state,cuserName,cdate,suserName,remark",inTypes:"0,2,3,4,5,8",orderStr:"bill.cdate desc",dataType:this.$storage.get("dataType")}},tempData:{},showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",rowStyle:{"background-color":"#dfe6ec"}}],selectList:[],temp:{},tempLable:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",rowData:{},title:""}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,a=t.$storage.get("menuId");e&&(t.$loading({spinner:"preloader",text:""}),Object(l.initMenuButtons)({menuId:a,roleId:e}).then(function(e){t.$loading().close();var a=e.buttonList;a&&a.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)})),t.tableConfigList&&t.tableConfigList.forEach(function(t){t.customColumn&&t.customColumn.forEach(function(t){"last"==t.columnIndex&&t.component&&t.component.forEach(function(t){t.nameEn==e.nameEn&&(t.rowState="1==2")})})})})}).catch(function(e){t.$loading().close()}))},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(t)},databridge:function(t){this.selectList=t},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.$refs.customBaseTable.updateData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},addReceive:function(){this.dialogData.title="收款单",this.dialogData.type="0",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0},addReduce:function(){this.dialogData.title="减免单",this.dialogData.type="2",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0},addRefund:function(){this.dialogData.title="退款单",this.dialogData.type="3",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0},addRaise:function(){this.dialogData.title="增加应收",this.dialogData.type="8",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0},exportExcel:function(){Object(d.exportExcelFinanceBills)({dataType:this.$storage.get("dataType"),fieldCode:"code,customerName,typeName,amount,state,cuserName,cdate,suserName,remark"}).then(function(t){t&&Object(c.j)(t,"收款单导出.xls")}).catch(function(t){})},deleteFinanceBill:function(t,e){var a=this;this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(d.deleteFinanceBill)(t).then(function(t){0===t.code&&(a.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(t){})}).catch(function(){a.$message({type:"info",message:"已取消删除"})})},cancelFinanceBill:function(t,e){var a=this;this.$confirm("此操作将取消该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(d.cancelFinanceBill)(t).then(function(t){0===t.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(t){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})})},recoverFinanceBill:function(t,e){var a=this;this.$confirm("此操作将恢复该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(d.recoverFinanceBill)(t).then(function(t){0===t.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(t){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})})},submitFinanceBill:function(t,e){var a=this;this.$confirm("此操作将此记录提交, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(d.submitFinanceBill)(t).then(function(t){0===t.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(t){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})})},rebackFinanceBill:function(t,e){var a=this;this.$confirm("此操作将此记录撤回, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(d.rebackFinanceBill)(t).then(function(t){0===t.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(t){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})})},editFinanceBill:function(t,e){this.dialogData.rowData=JSON.parse(JSON.stringify(t)),this.dialogData.title="编辑",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},setApiObj:function(){return this.tableConfigList[0].apiObj.params=Object.assign({},this.tableConfigList[0].apiObj.params,this.searchObj),this.tableConfigList[0].apiObj},dialogName:function(){return this.openDialogName}},watch:{}},r=(a("TF2P"),a("vX0r"),a("KHd+")),u=Object(r.a)(h,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"financeBill"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("custom-base-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_sale_receivables_financeSaleBill_index0",showIndex:!0,showCheckBox:!1,showTableSet:!1,customColumn:t.tableConfigList[0].customColumn,apiObj:t.setApiObj},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);u.options.__file="index.vue";e.default=u.exports},ogea:function(t,e,a){},vX0r:function(t,e,a){"use strict";var i=a("W8O8");a.n(i).a}}]);