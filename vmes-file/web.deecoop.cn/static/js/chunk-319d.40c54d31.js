(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-319d"],{"+B5T":function(e,t,a){},Bize:function(e,t,a){},N9NB:function(e,t,a){"use strict";var i=a("+B5T");a.n(i).a},O1JL:function(e,t,a){"use strict";var i=a("Bize");a.n(i).a},Wd1I:function(e,t,a){"use strict";a.r(t);a("rGqo");var i=a("2+ib"),n=a("uTIz"),s=a("EDKZ"),o=a("Vobf"),l=(a("z0WU"),a("Hycs"),a("gZnM")),c=a("bR9l"),r=a("yP9E"),u=a("D0r1"),d={components:{multilevelTable:i.a,searchBar:n.a,dialogSaleRetreatDetailByIn:l.default,dialogPurchaseSignDetailByIn:c.default,dialogRepairTaskDetailByIn:r.default,dialogMaintainTaskDetailByIn:u.default},data:function(){return{searchList:[{label:"入库单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"入库单号"},{label:"入库类型",type:"select",ruleType:"string",mapKey:"typeName",configs:{clearable:!0,name:"",options:[{value:"虚拟库入库",label:"虚拟库入库"}]},placeholder:"请选择"},{label:"仓库名称",type:"input",ruleType:"string",mapKey:"warehouseName",configs:{},placeholder:"仓库名称"},{label:"来源单位",type:"input",ruleType:"string",mapKey:"deptName",configs:{},placeholder:"来源单位"},{label:"入库单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"未完成"},{value:"1",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"规格型号"},{label:"货品属性",type:"input",ruleType:"string",mapKey:"productGenreName",configs:{},placeholder:"货品属性"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"productUnitName",configs:{},placeholder:"请输入计量单位"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"1",text:"已完成"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"未完成"}}}],apiObj:{apiName:"listPageWarehouseIn",params:{dataType:this.$storage.get("dataType"),isNeedWarehouseVirtual:"true",orderStr:" a.code desc "}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"2",text:"已完成"},warning:{state:"1",text:"执行中"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"待派单"}}}],apiObj:{apiName:"listPageWarehouseInDetail",params:{fieldCode:"productCode,productName,productSpec,productGenreName,productUnitName,count,remark",isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,componentId:"twoLevelTable",dragTable:!0}],searchObj:{},selectList:[],configs:{topBarBtnList:[],tableConfigs:[]},temp:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",warehouseType:"",businessId:"",title:"",temp:[],tempLable:[]}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,a=e.$storage.get("menuId");t&&(e.$loading({spinner:"preloader",text:""}),Object(o.initMenuButtons)({menuId:a,roleId:t}).then(function(t){e.$loading().close();var a=t.buttonList;a&&a.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)})),e.tableConfigList&&e.tableConfigList.forEach(function(e){e.customColumn&&e.customColumn.forEach(function(e){"last"==e.columnIndex&&e.component&&e.component.forEach(function(e){e.nameEn==t.nameEn&&(e.rowState="1==2")})})})})}).catch(function(t){e.$loading().close()}))},databridge:function(e){this.selectList=e},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.updateData(this.searchObj)},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},dialogAdd:function(){this.resetTemp(),this.dialogData.temp=this.temp,this.dialogData.title="新增入库单",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0},editByParent:function(e,t){"1"!=e.state?(this.resetTemp(),this.dialogData.temp=JSON.parse(JSON.stringify(e)),this.dialogData.title="编辑入库单",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0):this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前入库单状态(已完成)，不可修改！"})},cancelByParent:function(e,t){var a=this;"-1"!=e.state?this.$confirm("此操作将该记录从未完成状态变更为已取消状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(s.cancelWarehouseInBySimple)(e.id).then(function(e){0===e.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(e){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前入库单状态(已取消)，无需重复取消！"})},deleteByParent:function(e,t){var a=this;"1"!=e.state?this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(s.deleteWarehouseInBySimple)(e.id).then(function(e){0===e.code&&(a.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(e){})}).catch(function(){a.$message({type:"info",message:"已取消删除"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前入库单状态(已完成)，不可删除！"})},recoveryByParent:function(e,t){var a=this;this.$confirm("此操作将该记录从取消状态恢复到未完成状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(s.recoveryWarehouseInBySimple)(e.id).then(function(e){0===e.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(e){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})})},executeByParent:function(e,t){var a=this;this.$confirm("当前单据状态将变更为已完成，确定执行吗？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(s.executeWarehouseInBySimple)(e.id).then(function(e){0===e.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(e){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})})},orderByParent:function(e,t){var a=.8*document.body.clientWidth;this.dialogData.dialog_width=a+"px";var i=.75*(.618*a)+"px";this.dialogData.table_style="height:"+i+";width: 96%;margin-left: 2%;",this.dialogData.businessId=e.id;var n=e.type;"81907167d5c8498692e6c4f3694c5cfa"==n?(this.openDialogName="dialogSaleRetreatDetailByIn",this.dialogData.title="销售退货单信息"):"d78ceba5beef41f5be16f0ceee775399"==n?(this.openDialogName="dialogPurchaseSignDetailByIn",this.dialogData.title="采购签收单信息"):"c396683796d54b8693b522a2c0ad2793"==n?(this.openDialogName="dialogRepairTaskDetailByIn",this.dialogData.title="维修单领料退回信息"):"d9c9eb85db0d4c8faa09ddc2b8173859"==n&&(this.openDialogName="dialogMaintainTaskDetailByIn",this.dialogData.title="保养单领料退回信息"),this.showDialog=!0,this.visible=!0}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},h=(a("O1JL"),a("N9NB"),a("KHd+")),p=Object(h.a)(d,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"warehouseInManage"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_virtual_virtualIn_index0",tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);p.options.__file="index.vue";t.default=p.exports}}]);