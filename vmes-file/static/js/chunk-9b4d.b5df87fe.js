(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-9b4d"],{L1vm:function(e,t,a){"use strict";var i=a("Yjem");a.n(i).a},Yjem:function(e,t,a){},ou9N:function(e,t,a){"use strict";a.r(t);a("yt8O"),a("RW0V"),a("f3/d"),a("rGqo");var i=a("mSNy"),n=a("uTIz"),s=a("Do8I"),o=a("Vobf"),l=(a("5W5M"),a("z0WU"));function r(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{},i=Object.keys(a);"function"==typeof Object.getOwnPropertySymbols&&(i=i.concat(Object.getOwnPropertySymbols(a).filter(function(e){return Object.getOwnPropertyDescriptor(a,e).enumerable}))),i.forEach(function(t){c(e,t,a[t])})}return e}function c(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}var d={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.editBtns_isShow && scope.row.parentName!=\'云上企业\'" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editBtns(scope.row,scope.$index)">编辑</el-button>\n      \t\t\t\t\t</div>\n    \t\t\t\t</el-table-column>'},p={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},h={data:function(){var e=this;return{guid:"",searchList:[{label:"组织编码",type:"input",mapKey:"code",configs:{},placeholder:"组织编码"},{label:"组织名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"组织名称"},{label:"组织类型",type:"input",ruleType:"string",mapKey:"deptTypeName",configs:{},placeholder:"组织类型"},{label:"是否启用",type:"select",ruleType:"string",mapKey:"isdisableByQuery",configs:{clearable:!0,name:"",options:[{value:"1",label:"是"},{value:"0",label:"否"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!1,filterTextDept:"",enterTime:0,showDisableDept:!1,treeNodes:[],userInfo:null,hideTime:700,dynaHeight:40,clientHeight:0,dynaHeightTimer:null,dynaHeightState:null,initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:d,editBtns:this.editBtns,editBtns_isShow:!0}},configs:{queryBarBtnList:[{name:"查询",nameEn:"query",isShow:!0,icon:"search",method:this.queryTable},{name:"重置",nameEn:"reset",isShow:!0,icon:"refresh",plain:!0,method:this.resetQueryTemp}],topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.addNew},{name:"删除",nameEn:"delete",isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteBatch},{name:"导出",nameEn:"export",isShow:!0,icon:"export",method:this.exportExcel},{name:"导入",nameEn:"import",isShow:!0,icon:"import",method:this.importExcelCallBack,dialog:{enable:!0,data:{exportUrl:"/fileUpload/excelTemplet/组织管理.xlsx",importUrl:"/system/department/importExcelDepartments"},dialogName:"dialogImportExcel"}}],tableConfigs:[],showCheckBox:!1,showIndex:!1},tableData:[],selectList:null,treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1,showSearch:!0,showDisable:!1},selectTree:{pid:"",id:"",type:"",layer:"",name:""},dialogFormVisible:!1,dialogStatus:"",textMap:{update:"编辑菜单",create:"新增菜单"},temp:{},tempQuery:{},tempLable:{},tempNotEditable:{},rules:{name:[{required:!0,message:"请填写部门名称",trigger:"change"}],deptTypeName:[{required:!0,trigger:"change",validator:function(t,a,i){e.selectData.defaultSelected.length<=0?i(new Error("请选择组织类型")):i()}}]},pageData:null,pageNo:1,selectData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"deptType",isglobal:"1"}},defaultSelected:[]}}},components:{searchBar:n.a},beforeCreate:function(){},created:function(){this.userInfo=this.$storage.get("userInfo"),this.initButtons(),this.initTree(),this.dynaHeightState=this.$storage.get("dynaHeightState")||"1",this.dynaHeightState-0||(this.dynaHeight=0)},beforeMount:function(){},mounted:function(){this.clientHeight=this.$el.clientHeight},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(e){this.tempQuery=e,this.initTable(this.selectTree.id,this.selectTree.layer,null)},sendGuid:function(e){this.guid=e},importExcelCallBack:function(e){this.refreshTable()},initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,a=e.$storage.get("menuId");t&&(e.$loading({spinner:"none",text:"云上企业"}),Object(o.initMenuButtons)({menuId:a,roleId:t}).then(function(t){var a=t.buttonList;a&&a.forEach(function(t){if(e.initConfigs&&e.initConfigs.tableOperates)for(var a in e.initConfigs.tableOperates)a.indexOf(t.nameEn)>=0&&a.indexOf("isShow")>0&&(e.initConfigs.tableOperates[a]=!1);if(e.customColumn)for(var i in e.customColumn)if(i){var n=e.customColumn[i];n.length>0&&n.forEach(function(e){if(e)for(var a in e)a.indexOf(t.nameEn)>=0&&a.indexOf("isShow")>0&&(e[a]=!1)})}e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(console.log(e),e.isShow=!1)}))})}).catch(function(t){console.log(t),e.$loading().close()}))},initTree:function(e){var t=this,a=" isdisable = 1 ";e&&(a=""),Object(s.listTreeDepartment)({queryStr:a}).then(function(e){var a=[],i=e.result.treeList;t.selectTree={pid:i.pid,id:i.id,type:i.type,layer:i.layer,name:i.name},a.push(i),t.treeData=a,t.treeNodes=[],t.$nextTick(function(){if(t.treeNodes.length>0){var e=t.treeNodes[0];t.selectTree={pid:e.pid,id:e.id,type:e.type,layer:e.layer,name:e.name}}t.initTable(t.selectTree.id,t.selectTree.layer,!0)})}).catch(function(e){console.log(e),t.$loading().close()})},treeDataBridge:function(e){console.log(e);this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,type:e.nodeData.type,layer:e.nodeData.layer,name:e.nodeData.name},this.pageNo=1,this.initTable(this.selectTree.id,this.selectTree.layer)},queryTable:function(){this.pageNo=1,this.initTable(this.selectTree.id,this.selectTree.layer)},initTable:function(e,t,a){var i=this;Object(s.listPageDepartment)(r({},i.tempQuery,{pid:e,layer:t,pageNo:i.pageNo})).then(function(e){i.getListPage(e),a&&i.$loading().close()}).catch(function(e){i.$loading().close()})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(l.l)(e.result),a=this.addTableTitle(t);this.configs.tableConfigs=a,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var a in e){var n=e[a];n.indexOf("_")>0&&("en"==i.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==i.a.locale&&(n=n.substring(0,n.indexOf("_")))),t.tempLable[a]=n,t.tempNotEditable[a]=!1}})},addTableTitle:function(e){var t=this;return e.forEach(function(e){var a=e.label;a.indexOf("_")>0&&("en"==i.a.locale?e.label=a.substring(a.indexOf("_")+1):"zh"==i.a.locale&&(e.label=a.substring(0,a.indexOf("_")))),"是否启用"===e.label&&(e.component=p,e.changeState=t.changeState)}),t.internationalConfig(),e.push(t.initConfigs.tableOperates),e},internationalConfig:function(){"en"==i.a.locale?(this.initConfigs.tableOperates.label="OPERATE",this.textMap.create="ADDNEW",this.textMap.update="EDIT",this.textMap.importExcel="ImportExcel"):"zh"==i.a.locale&&(this.initConfigs.tableOperates.label="操作",this.textMap.create="新增",this.textMap.update="编辑",this.textMap.importExcel="Excel导入")},changeState:function(e,t){var a=this;Object(s.updateDisableDepartment)(e.id,e.isdisable).then(function(e){0===e.code&&(a.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),a.refreshTable())}).catch(function(t){"0"==e.isdisable&&(e.isdisable="1")})},dataBridge:function(e){this.selectList=e,e.length?this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!1)}):this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})},editBtns:function(e,t){var a=this;this.resetTemp(),this.temp=JSON.parse(JSON.stringify(e)),this.selectData.defaultSelected=[],this.selectData.defaultSelected.push(e.deptType),this.tempNotEditable.code=!0,this.tempNotEditable.parentName=!0,this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){a.$refs.submitForm.clearValidate()})},updateData:function(){var e=this;e.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(s.updateDepartment)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.dialogFormVisible=!1,e.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(t){console.log(t),e.dialogLoading=!1}))})},addNew:function(){var e=this;this.resetTemp(),this.temp.pid=this.selectTree.id,this.temp.parentName=this.selectTree.name,this.selectTree.type?(this.selectData.defaultSelected=[],this.selectData.defaultSelected.push(this.selectTree.type),this.temp.deptType=this.selectTree.type,this.tempNotEditable.deptTypeName=!0):this.temp.deptType=this.selectData.defaultSelected[0],this.tempNotEditable.code=!0,this.tempNotEditable.parentName=!0,this.dialogStatus="create",this.dialogFormVisible=!0,this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},resetQueryTemp:function(){for(var e in this.tempQuery)this.tempQuery[e]=""},createData:function(){var e=this;this.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(s.addDepartment)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.dialogFormVisible=!1,e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(t){console.log(t),e.dialogLoading=!1}))})},deleteBatch:function(){var e=this;e.$confirm("此操作将删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var t="";e.selectList.forEach(function(e){t+=e.id+","}),Object(s.deleteDepartments)(t).then(function(t){0===t.code&&(e.dialogFormVisible=!1,e.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(e){console.log(e)})}).catch(function(){e.$message({type:"info",message:"已取消删除"})})},exportExcel:function(){var e="",t=this;null!=t.selectList&&t.selectList.length>0&&t.selectList.forEach(function(t){e=e+t.id+","}),Object(s.exportExcelDepartments)(e).then(function(e){e&&(Object(l.g)(e,"组织管理导出.xls"),t.$message({title:"成功",message:"导出成功",type:"success",duration:2e3}))}).catch(function(e){console.log(e)})},refreshTable:function(){var e=this;e.$axios.all([Object(s.listPageDepartment)(r({},e.tempQuery,{pid:e.selectTree.id,layer:e.selectTree.layer,pageNo:e.pageNo})),Object(s.listTreeDepartment)({queryStr:" isdisable = 1 "})]).then(e.$axios.spread(function(t,a){e.getListPage(t);var i=a.result.treeList,n=[];n.push(i),e.treeData=n,e.$nextTick(function(){})})).catch(function(e){console.log(e)})},inputSelect:function(e){console.log(e);e[0]?(this.temp.deptType=e[0],this.selectData.defaultSelected=[e[0]]):(this.temp.deptType=[],this.selectData.defaultSelected=[])},searchDeptByName:function(){var e=this;e.treeNodes=[],Object(l.c)(e.treeData,e.showDisableDept,e.filterTextDept,e.treeNodes),e.enterTime=e.enterTime+1,e.$nextTick(function(){if(e.treeNodes.length>0){var t=e.treeNodes[e.enterTime%e.treeNodes.length];e.selectTree={pid:t.pid,id:t.id,type:t.type,layer:t.layer,name:t.name}}e.initTable(e.selectTree.id,e.selectTree.layer)})},disableState:function(e){this.initTree(e)}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},watch:{pageNo:function(){this.initTable(this.selectTree.id,this.selectTree.layer)},showDisableDept:function(){this.initTree()}}},u=(a("L1vm"),a("KHd+")),m=Object(u.a)(h,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"departmentManage"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"treeStyle",attrs:{span:4}},[a("div",{staticStyle:{"padding-left":"20px",height:"100%"}},[a("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge,"disable-state":e.disableState}})],1)]),e._v(" "),a("el-col",{staticClass:"tableStyle",attrs:{span:20}},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state,dialog:e.dialog},on:{myclick:e.method}})]})],2)])],1),e._v(" "),a("el-row",{staticClass:"tableContent"},[a("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)],1)])],1),e._v(" "),a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.textMap[e.dialogStatus],visible:e.dialogFormVisible,width:"700px",top:"40px"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[a("el-form-item",{attrs:{label:e.tempLable.parentName+":",prop:"parentName"}},[a("el-input",{attrs:{disabled:e.tempNotEditable.parentName},model:{value:e.temp.parentName,callback:function(t){e.$set(e.temp,"parentName",t)},expression:"temp.parentName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.name+":",prop:"name"}},[a("el-input",{model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name",t)},expression:"temp.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.deptTypeName+":",prop:"deptTypeName"}},[a("base-input-select",{staticStyle:{width:"280px"},attrs:{disabled:e.tempNotEditable.deptTypeName,data:e.selectData.data},on:{callback:e.inputSelect},model:{value:e.selectData.defaultSelected,callback:function(t){e.$set(e.selectData,"defaultSelected",t)},expression:"selectData.defaultSelected"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.remark+":",prop:"remark"}},[a("el-input",{model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"30px"},attrs:{slot:"footer"},slot:"footer"},["create"==e.dialogStatus?a("el-button",{attrs:{type:"primary"},on:{click:e.createData}},[e._v("保存")]):a("el-button",{attrs:{type:"primary"},on:{click:e.updateData}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取消")])],1)],1)])],1)},[],!1,null,null,null);m.options.__file="index.vue";t.default=m.exports}}]);