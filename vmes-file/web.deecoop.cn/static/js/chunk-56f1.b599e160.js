(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-56f1"],{MrFm:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rGqo");var n=i("mSNy"),a=i("uTIz"),o=i("7lLV"),s=i("Vobf"),l=i("z0WU");function c(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var r={data:function(){return{guid:"",searchList:[{label:"操作人账号",type:"input",ruleType:"string",mapKey:"userCode",configs:{},placeholder:"操作人账号"},{label:"操作人姓名",type:"input",ruleType:"string",mapKey:"userName",configs:{},placeholder:"操作人姓名"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!1,hideTime:500,dynaHeight:40,clientHeight:0,dynaHeightTimer:null,dynaHeightState:null,initConfigs:{tableOperates:{}},configs:{queryBarBtnList:[{name:"查询",nameEn:"query",isShow:!0,icon:"search",method:this.initTable},{name:"重置",nameEn:"reset",isShow:!0,icon:"refresh",plain:!0,method:this.resetQueryTemp}],topBarBtnList:[],tableConfigs:[],showCheckBox:!1,showIndex:!1},tableData:[],selectList:null,dialogFormVisible:!1,dialogStatus:"",textMap:{update:"编辑菜单",create:"新增菜单"},temp:{},tempQuery:{},tempLable:{},tempNotEditable:{},rules:{},pageData:null,pageNo:1}},components:{searchBar:a.a},beforeCreate:function(){},created:function(){this.initButtons(),this.initTable(!0),this.dynaHeightState=this.$storage.get("dynaHeightState")||"1",this.dynaHeightState-0||(this.dynaHeight=0)},beforeMount:function(){},mounted:function(){this.clientHeight=this.$el.clientHeight},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(t){this.tempQuery=t,this.pageNo=1,this.initTable()},sendGuid:function(t){this.guid=t},initButtons:function(){var t=this;t.$loading({spinner:"preloader",text:""});var e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&Object(s.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){if(t.initConfigs&&t.initConfigs.tableOperates)for(var i in t.initConfigs.tableOperates)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t.initConfigs.tableOperates[i]=!1);if(t.customColumn)for(var n in t.customColumn)if(n){var a=t.customColumn[n];a.length>0&&a.forEach(function(t){if(t)for(var i in t)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t[i]=!1)})}t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(console.log(t),t.isShow=!1)}))})}).catch(function(e){console.log(e),t.$loading().close()})},initTable:function(t){var e=this;Object(o.listPageLogInfo)(function(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},n=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),n.forEach(function(e){c(t,e,i[e])})}return t}({},e.tempQuery,{pageNo:e.pageNo})).then(function(i){e.getListPage(i),t&&e.$loading().close()}).catch(function(t){console.log(t),e.$loading().close()})},getListPage:function(t){if(t){console.log(t.result.titles),this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(l.n)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var a=t[i];a.indexOf("_")>0&&("en"==n.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==n.a.locale&&(a=a.substring(0,a.indexOf("_")))),e.tempLable[i]=a,e.tempNotEditable[i]=!1}})},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==n.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==n.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"是否启用"===t.label&&(t.component=stateBtns,t.changeState=e.changeState)}),e.internationalConfig(),t},internationalConfig:function(){"en"==n.a.locale?(this.initConfigs.tableOperates.label="OPERATE",this.textMap.create="ADDNEW",this.textMap.update="EDIT"):"zh"==n.a.locale&&(this.initConfigs.tableOperates.label="操作",this.textMap.create="新增",this.textMap.update="编辑")},changeState:function(t,e){var i=this;Object(o.updateDisableLogInfo)(t.id,t.isdisable).then(function(t){console.log(t),i.$loading().close()}).catch(function(t){console.log(t),i.$loading().close()})},dataBridge:function(t){this.selectList=t,t.length?this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!1)}):this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})},editBtns:function(t,e){var i=this;this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.tempNotEditable.code=!0,this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){i.$refs.submitForm.clearValidate()})},updateData:function(){var t=this;t.$refs.submitForm.validate(function(e){e&&Object(o.updateLogInfo)(t.temp).then(function(e){console.log(e),0===e.code&&(t.dialogFormVisible=!1,t.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),t.refreshTable())}).catch(function(e){console.log(e),t.$loading().close()})})},addNew:function(){var t=this;this.resetTemp(),this.tempNotEditable.code=!1,this.dialogStatus="create",this.dialogFormVisible=!0,this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},resetQueryTemp:function(){for(var t in this.tempQuery)this.tempQuery[t]=""},createData:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&Object(o.addLogInfo)(t.temp).then(function(e){console.log(e),0===e.code&&(t.dialogFormVisible=!1,t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.refreshTable())}).catch(function(e){console.log(e),t.$loading().close()})})},deleteBatch:function(){var t=this;t.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var e="";t.selectList.forEach(function(t){e+=t.id+","}),Object(o.deleteLogInfos)(e).then(function(e){console.log(e),0===e.code&&(t.dialogFormVisible=!1,t.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),t.refreshTable())}).catch(function(e){console.log(e),t.$loading().close()})}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},refreshTable:function(){var t=this;t.$axios.all([Object(o.listPageLogInfo)()]).then(t.$axios.spread(function(e){console.log(e),t.getListPage(e),t.$loading().close()})).catch(function(t){console.log(t)})},exportExcel:function(){var t="";null!=this.selectList&&this.selectList.length>0&&this.selectList.forEach(function(e){t=t+e.id+","}),Object(o.exportExcelLogInfos)(t).then(function(t){t&&Object(l.i)(t,"组织管理导出.xls")}).catch(function(t){console.log(t)})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},watch:{pageNo:function(){this.initTable()}}},u=(i("P2XB"),i("KHd+")),h=Object(u.a)(r,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"logInfoManage"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)],1)])],1),t._v(" "),i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.textMap[t.dialogStatus],visible:t.dialogFormVisible,width:"700px",top:"40px"},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:t.tempLable.code+":",prop:"code"}},[i("el-input",{attrs:{disabled:t.tempNotEditable.code},model:{value:t.temp.code,callback:function(e){t.$set(t.temp,"code",e)},expression:"temp.code"}})],1),t._v(" "),i("el-form-item",{attrs:{label:t.tempLable.name+":",prop:"name"}},[i("el-input",{model:{value:t.temp.name,callback:function(e){t.$set(t.temp,"name",e)},expression:"temp.name"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"30px"},attrs:{slot:"footer"},slot:"footer"},["create"==t.dialogStatus?i("el-button",{attrs:{type:"primary"},on:{click:t.createData}},[t._v("保存")]):i("el-button",{attrs:{type:"primary"},on:{click:t.updateData}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("关闭")])],1)],1)])],1)},[],!1,null,null,null);h.options.__file="index.vue";e.default=h.exports},P2XB:function(t,e,i){"use strict";var n=i("roLT");i.n(n).a},roLT:function(t,e,i){}}]);