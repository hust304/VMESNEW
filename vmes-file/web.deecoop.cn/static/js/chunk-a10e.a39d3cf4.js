(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-a10e"],{"0jwy":function(e,t,a){"use strict";a.r(t);a("rGqo");var n=a("2+ib"),i=a("uTIz"),o=a("otD4"),s=a("G3sP"),c=a("Qbmm"),l=a("Vobf"),r=(a("z0WU"),{components:{multilevelTable:n.a,searchBar:i.a,selectProductByWarehouse:o.default,checkExecute:s.default},data:function(){return{searchList:[{label:"盘点单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"盘点单号"},{label:"盘点单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"未完成"},{value:"1",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"规格型号"},{label:"货品属性",type:"cascader",mapKey:"genreSelect",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"productGenre",isglobal:"1"}},placeholder:"请选择"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"productUnitName",configs:{},placeholder:"计量单位"},{label:"日期起",type:"date",ruleType:"date",mapKey:"createDateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{hidePicker:!0}},placeholder:"请选择"},{label:"日期止",type:"date",ruleType:"date",mapKey:"createDateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{hidePicker:!0}},placeholder:"请选择"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"1",text:"已完成"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"未完成"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",nameEn:"deleteByParent",editBtns_isShow:!0,rowState:"#self@state#===-1",method:this.deleteByParent},{name:"取消",nameEn:"cancelByParent",editBtns_isShow:!0,rowState:"#self@state#===0",method:this.cancelByParent},{name:"恢复",nameEn:"recoveryByParent",editBtns_isShow:!0,rowState:"#self@state#===-1",method:this.recoveryByParent},{name:"执行",nameEn:"executeByParent",editBtns_isShow:!0,rowState:"#self@state#===0",method:this.executeByParent}]}],apiObj:{apiName:"listPagewarehouseChecks",params:{fieldCode:"code,makeName,cdate,state",dataType:this.$storage.get("dataType"),orderStr:"parent.cdate desc"}},tempData:{},showHeader:!0,showIndex:!1,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},warning:{state:"1",text:"执行中"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageWarehouseCheckDetails",params:{fieldCode:"warehouseName,productCode,productName,productSpec,productGenreName,productUnitName,checkStockCount,stockCount,businessCode,remark",isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,componentId:"twoLevelTable",dragTable:!1}],searchObj:{},selectList:[],configs:{topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.dialogAdd}],tableConfigs:[]},temp:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",title:""}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,a=e.$storage.get("menuId");t&&(e.$loading({spinner:"preloader",text:""}),Object(l.initMenuButtons)({menuId:a,roleId:t}).then(function(t){e.$loading().close();var a=t.buttonList;a&&a.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)})),e.tableConfigList&&e.tableConfigList.forEach(function(e){e.customColumn&&e.customColumn.forEach(function(e){"last"==e.columnIndex&&e.component&&e.component.forEach(function(e){e.nameEn==t.nameEn&&(e.rowState="1==2")})})})})}).catch(function(t){e.$loading().close()}))},databridge:function(e){this.selectList=e},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.updateData(this.searchObj)},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},dialogAdd:function(){this.dialogData.title="仓库列表",this.openDialogName="selectProductByWarehouse",this.showDialog=!0,this.visible=!0},cancelByParent:function(e,t){var a=this;"-1"!=e.state?this.$confirm("此操作将该记录从未完成状态变更为已取消状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(c.cancelWarehouseCheckBySimple)(e.id).then(function(e){0===e.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(e){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前盘点单状态(已取消)，无需重复取消！"})},deleteByParent:function(e,t){var a=this;"1"!=e.state?this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(c.deleteWarehouseCheckBySimple)(e.id).then(function(e){0===e.code&&(a.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(e){})}).catch(function(){a.$message({type:"info",message:"已取消删除"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前盘点单状态(已完成)，不可删除！"})},recoveryByParent:function(e,t){var a=this;this.$confirm("此操作将该记录从取消状态恢复到未完成状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(c.recoveryWarehouseCheckBySimple)(e.id).then(function(e){0===e.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(e){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})})},executeByParent:function(e,t){var a=.6*document.body.clientWidth;this.dialogData.dialog_width=a+"px";var n=.75*(.618*a)+"px";this.dialogData.table_style="height:"+n+";width: 96%;margin-left: 2%;",this.dialogData.parentId=e.id,this.dialogData.title="执行盘点单",this.openDialogName="checkExecute",this.showDialog=!0,this.visible=!0}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),u=(a("90qB"),a("GZMM"),a("KHd+")),d=Object(u.a)(r,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"warehouseCheckManage"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_warehouseBySimple_checkBySimple_index0",tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);d.options.__file="index.vue";t.default=d.exports},"90qB":function(e,t,a){"use strict";var n=a("RWu5");a.n(n).a},GZMM:function(e,t,a){"use strict";var n=a("e1Fy");a.n(n).a},RWu5:function(e,t,a){},e1Fy:function(e,t,a){}}]);