(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-5975"],{PRMX:function(e,t,a){"use strict";var i=a("vVxi");a.n(i).a},W5q3:function(e,t,a){"use strict";var i=a("wThB");a.n(i).a},hoYk:function(e,t,a){"use strict";a.r(t);a("rGqo");var i=a("2+ib"),n=a("uTIz"),s=a("CcWj"),o=a("wD3y"),l=a("8CNV"),c=a("iW6I"),r=a("EDKZ"),d=a("z9VH"),u=a("Vobf"),h={components:{multilevelTable:i.a,searchBar:n.a,dialogAdd:s.default,dialogEdit:o.default,dialogExecute:l.default,dialogView:c.default},data:function(){return{searchList:[{label:"入库单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"入库单号"},{label:"入库类型",type:"select",ruleType:"string",mapKey:"typeName",configs:{clearable:!0,name:"",options:[{value:"生产入库",label:"生产入库"},{value:"生产退料",label:"生产退料"},{value:"销售退货入库",label:"销售退货入库"},{value:"销售变更退货入库",label:"销售变更退货入库"},{value:"采购入库",label:"采购入库"},{value:"维修领料退回入库",label:"维修领料退回入库"},{value:"保养领料退回入库",label:"保养领料退回入库"},{value:"盘盈",label:"盘盈"},{value:"盘点入库",label:"盘点入库"},{value:"外协入库",label:"外协入库"},{value:"组装入库",label:"组装入库"},{value:"虚拟库入库",label:"虚拟库入库"}]},placeholder:"请选择"},{label:"业务单号",type:"input",ruleType:"string",mapKey:"businessCode",configs:{},placeholder:"业务单号"},{label:"来源单位",type:"input",ruleType:"string",mapKey:"deptName",configs:{},placeholder:"来源单位"},{label:"入库单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"未完成"},{value:"1",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"规格型号"},{label:"货品属性",type:"cascader",mapKey:"genreSelect",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"productGenre",isglobal:"1"}},placeholder:"请选择"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"productUnitName",configs:{},placeholder:"计量单位"},{label:"日期起",type:"date",ruleType:"date",mapKey:"createDateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{hidePicker:!0}},placeholder:"请选择"},{label:"日期止",type:"date",ruleType:"date",mapKey:"createDateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{hidePicker:!0}},placeholder:"请选择"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"code",_cellConfig:{hideTitle:!0},width:"100"},{columnIndex:"businessCode",_cellConfig:{hideTitle:!0},width:"120"},{columnIndex:"makeName",_cellConfig:{hideTitle:!0},width:"80"},{columnIndex:"cdate",_cellConfig:{hideTitle:!0},width:"100"},{columnIndex:"remark",_cellConfig:{hideTitle:!0},width:"120"},{columnIndex:"state",width:"80",componentName:"tag",_cellConfig:{success:{state:"1",text:"已完成"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"未完成"}}},{columnIndex:"last",prop:"operate",label:"操作",width:"150",componentName:"button",component:[{name:"编辑",nameEn:"editByParent",editBtns_isShow:!0,rowState:"#self@state#===0 && #self@isNeedShowEdit#===1",method:this.editByParent},{name:"删除",nameEn:"deleteByParent",editBtns_isShow:!0,rowState:"#self@state#===-1 && #self@isNeedShowEdit#===1",method:this.deleteByParent},{name:"取消",nameEn:"cancelByParent",editBtns_isShow:!0,rowState:"#self@state#===0 && #self@isNeedShowEdit#===1",method:this.cancelByParent},{name:"恢复",nameEn:"recoveryByParent",editBtns_isShow:!0,rowState:"#self@state#===-1",method:this.recoveryByParent},{name:"执行",nameEn:"executeByParent",editBtns_isShow:!0,rowState:"#self@state#===0",method:this.executeByParent},{name:"详情",nameEn:"infoByParent",editBtns_isShow:!0,rowState:"#self@state#===1",method:this.infoByParent}]}],apiObj:{apiName:"listPageWarehouseInBySimple",params:{fieldCode:"code,businessCode,typeName,deptName,makeName,cdate,remark,state",isNeedWarehouseWarehouse:"true",isNeedPage:"false",orderStr:"a.code desc",dataType:this.$storage.get("dataType")}},tempData:{},showHeader:!0,showIndex:!1,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"2",text:"已完成"},warning:{state:"1",text:"执行中"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"待派单"}}}],apiObj:{apiName:"listPageWarehouseInDetail",params:{fieldCode:"productCode,productName,productSpec,productGenreName,productUnitName,count,executeCount,remark",isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,componentId:"twoLevelTable",dragTable:!1}],searchObj:{},selectList:[],configs:{topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.dialogAdd}],tableConfigs:[]},temp:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",warehouseType:"",businessId:"",title:"",temp:[],tempLable:[]}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,a=e.$storage.get("menuId");t&&(e.$loading({spinner:"preloader",text:""}),Object(u.initMenuButtons)({menuId:a,roleId:t}).then(function(t){e.$loading().close();var a=t.buttonList;a&&a.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)})),e.tableConfigList&&e.tableConfigList.forEach(function(e){e.customColumn&&e.customColumn.forEach(function(e){"last"==e.columnIndex&&e.component&&e.component.forEach(function(e){e.nameEn==t.nameEn&&(e.rowState="1==2")})})})})}).catch(function(t){e.$loading().close()}))},databridge:function(e){this.selectList=e},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.updateData(this.searchObj)},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},dialogAdd:function(){this.resetTemp(),this.dialogData.temp=this.temp,this.dialogData.title="新增",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0},editByParent:function(e,t){var a=this;Object(d.isExistBusinessByWarehouseIn)({parentId:e.id,type:e.type}).then(function(t){"true"!=t.isExist?(a.resetTemp(),a.dialogData.temp=JSON.parse(JSON.stringify(e)),a.dialogData.title="编辑",a.openDialogName="dialogEdit",a.showDialog=!0,a.visible=!0):a.$message({type:"warning",duration:5e3,showClose:!0,message:"该入库单类型("+e.typeName+")编辑功能禁用！"})})},cancelByParent:function(e,t){var a=this;Object(d.isExistBusinessByWarehouseIn)({parentId:e.id,type:e.type}).then(function(t){"true"!=t.isExist?a.$confirm("此操作将该记录从未完成状态变更为已取消状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(r.cancelWarehouseInBySimple)(e.id).then(function(e){0===e.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(e){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})}):a.$message({type:"warning",duration:5e3,showClose:!0,message:"该入库单类型("+e.typeName+")取消功能禁用！"})})},deleteByParent:function(e,t){var a=this;Object(d.isExistBusinessByWarehouseIn)({parentId:e.id,type:e.type}).then(function(t){"true"!=t.isExist?a.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(r.deleteWarehouseInBySimple)(e.id).then(function(e){0===e.code&&(a.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(e){})}).catch(function(){a.$message({type:"info",message:"已取消删除"})}):a.$message({type:"warning",duration:5e3,showClose:!0,message:"该入库单类型("+e.typeName+")删除功能禁用！"})})},recoveryByParent:function(e,t){var a=this;Object(d.isExistBusinessByWarehouseIn)({parentId:e.id,type:e.type}).then(function(t){"true"!=t.isExist?a.$confirm("此操作将该记录从取消状态恢复到未完成状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(r.recoveryWarehouseInBySimple)(e.id).then(function(e){0===e.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(e){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})}):a.$message({type:"warning",duration:5e3,showClose:!0,message:"该入库单类型("+e.typeName+")恢复功能禁用！"})})},executeByParent:function(e,t){this.dialogData.temp=e,this.dialogData.title="执行",this.openDialogName="dialogExecute",this.showDialog=!0,this.visible=!0},infoByParent:function(e,t){this.dialogData.temp=e,this.dialogData.title="详情",this.openDialogName="dialogView",this.showDialog=!0,this.visible=!0}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},p=(a("W5q3"),a("PRMX"),a("KHd+")),m=Object(p.a)(h,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"warehouseInManage"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_warehouseBySimple_inBySimple_index0",tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);m.options.__file="index.vue";t.default=m.exports},vVxi:function(e,t,a){},wThB:function(e,t,a){}}]);