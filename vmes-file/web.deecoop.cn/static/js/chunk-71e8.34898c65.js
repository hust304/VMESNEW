(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-71e8"],{Toi7:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("KKXr"),i("f3/d"),i("rGqo");var n=i("uTIz"),a=i("zDZ1"),o=i("DYgg"),s=i("YIaj"),l=i("K3g7"),r=i("1FtD"),c=i("Vobf"),h=i("z0WU"),u=i("mSNy");function d(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},n=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),n.forEach(function(e){f(t,e,i[e])})}return t}function f(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var p={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t\t\t\x3c!--<el-button  v-show="colConfig.qrcodeBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.qrcodeBtns(scope.row,scope.$index)">二维码</el-button>--\x3e\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.editByRow_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editByRow(scope.row,scope.$index)">编辑</el-button>\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.deleteByRow_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.deleteByRow(scope.row,scope.$index)">删除</el-button>\n    \t\t\t\t\t</div>\n\n  \t\t\t\t</el-table-column>'},g={components:{searchBar:n.a,dialogQrcode:a.a,dialogEdit:o.default,dialogImportExcel:s.default},data:function(){return{guid:"",searchList:[{label:"货位编码",type:"input",ruleType:"string",mapKey:"warehouseCode",configs:{},placeholder:"货位编码"},{label:"货位名称",type:"input",ruleType:"string",mapKey:"pathName",configs:{},placeholder:"货位名称"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"规格型号"},{label:"货品属性",type:"cascader",mapKey:"genreSelect",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"productGenre",isglobal:"1"}},placeholder:"请选择"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"productUnitName",configs:{},placeholder:"计量单位"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null,nodeId:null},initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:p,editByRow:this.editByRow,editByRow_isShow:!0,deleteByRow:this.deleteByRow,deleteByRow_isShow:!0}},configs:{topBarBtnList:[{name:"初始化",nameEn:"add",isShow:!0,state:!1,icon:"add",method:this.initialWarehouse},{name:"导出",nameEn:"exportExcel",isShow:!0,icon:"export",method:this.exportExcel},{name:"导入",nameEn:"importExcel",isShow:!0,state:!1,icon:"import",method:this.importExcel},{name:"禁用初始化",nameEn:"disableInitial",isShow:!0,state:!1,icon:"add",method:this.disableInitial}],tableConfigs:[],showCheckBox:!1,showIndex:!1},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},beforeCreate:function(){},created:function(){this.initButtons(),this.initTree()},beforeMount:function(){},mounted:function(){this.functionTableButton()},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(t){this.tempQuery=t,this.pageNo=1,this.initTable(null,this.selectTree.id)},sendGuid:function(t){this.guid=t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&(this.initTree(),this.functionTableButton())},initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&(t.$loading({spinner:"preloader",text:""}),Object(c.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){if(t.initConfigs&&t.initConfigs.tableOperates)for(var i in t.initConfigs.tableOperates)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t.initConfigs.tableOperates[i]=!1);if(t.customColumn)for(var n in t.customColumn)if(n){var a=t.customColumn[n];a.length>0&&a.forEach(function(t){if(t)for(var i in t)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t[i]=!1)})}t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){t.$loading().close()}))},initTable:function(t,e){var i=this;Object(r.listPageWarehouseInitial)(d({},i.tempQuery,{nodeId:e,dataType:this.$storage.get("dataType"),isNeedEntity:"true",isNeedNotInWarehouseSpare:"true",pageNo:i.pageNo})).then(function(e){i.getListPage(e),t&&i.$loading().close()}).catch(function(t){i.$loading().close()})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(h.o)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var n=t[i];n.indexOf("_")>0&&("en"==u.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==u.a.locale&&(n=n.substring(0,n.indexOf("_")))),e.tempLable[i]=n}})},addTableTitle:function(t){return t.forEach(function(t){var e=t.label;e.indexOf("_")>0&&("en"==u.a.locale?t.label=e.substring(e.indexOf("_")+1):"zh"==u.a.locale&&(t.label=e.substring(0,e.indexOf("_"))))}),this.internationalConfig(),t.push(this.initConfigs.tableOperates),t},internationalConfig:function(){"en"==u.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==u.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTree:function(){var t=this;Object(l.treeWarehouse)({isNeedEntity:"true",isNotNeedSpare:"true"}).then(function(e){var i=[],n=e.result.treeList;t.selectTree={pid:n.pid,id:n.id,layer:n.layer,name:n.name,virtualGenre:n.virtualGenre},i.push(n),t.treeData=i,t.initTable(!0,t.selectTree.id),t.$nextTick(function(){t.$refs.tree.$children[0].setCurrentKey(t.selectTree.id)})}).catch(function(e){t.$loading().close()})},treeDataBridge:function(t){this.selectTree={pid:t.nodeData.pid,id:t.nodeData.id,layer:t.nodeData.layer,name:t.nodeData.name,pathId:t.nodeData.pathId},this.pageNo=1,this.initTable(null,this.selectTree.id)},dataBridge:function(t){this.selectList=t,t.length?this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!1)}):this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})},refreshTable:function(){var t=this;this.$axios.all([Object(r.listPageWarehouseInitial)(d({},this.tempQuery,{dataType:this.$storage.get("dataType"),nodeId:this.selectTree.id,pageNo:this.pageNo}))]).then(this.$axios.spread(function(e){t.getListPage(e)})).catch(function(t){})},functionTableButton:function(){var t=this,e="011";Object(r.findIsDisableButton)({warehouseGenre:"warehouse"}).then(function(i){null!=i.isDisableButton&&i.isDisableButton.trim().length>0&&(e=i.isDisableButton.trim()),t.setTableButton(e,t.configs.topBarBtnList)})},setTableButton:function(t,e){null!=t&&0!=t.trim().length||(t="011");for(var i=t.split(""),n=i[0],a=i[1],o=i[2],s=0;s<e.length;s++){var l=e[s],r=l.nameEn;"add"==r?this.setTableButtonShow(n,l):"importExcel"==r?this.setTableButtonShow(a,l):"disableInitial"==r&&(this.setTableButtonShow(o,l),"0"==o?this.initConfigs.tableOperates={}:"1"==o&&(this.initConfigs.tableOperates={prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:p,editByRow:this.editByRow,editByRow_isShow:!0,deleteByRow:this.deleteByRow,deleteByRow_isShow:!0}))}},setTableButtonShow:function(t,e){null!=t&&0!=t.trim().length||(t="0"),"0"==t?e.state=!0:"1"==t&&(e.state=!1)},initialWarehouse:function(){var t=this;this.$confirm('<div style="color:#FF0000">初始化后，仓库中的货品以及全部业务数据将被清空，请谨慎操作！</div>',"提示",{dangerouslyUseHTMLString:!0,confirmButtonText:"继续",cancelButtonText:"取消",type:"warning"}).then(function(){t.$confirm('<div style="color:#FF0000">确定执行初始化吗？</div>',"提示",{dangerouslyUseHTMLString:!0,confirmButtonText:"是",cancelButtonText:"否",type:"warning"}).then(function(){Object(r.initialWarehouse)({warehouseGenre:"warehouse"}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"初始化成功",type:"success",duration:2e3}),t.refreshTable(),t.functionTableButton())}).catch(function(t){})}).catch(function(){t.$message({type:"info",message:"已取消仓库初始化"})})}).catch(function(){t.$message({type:"info",message:"已取消仓库初始化"})})},exportExcel:function(){var t="";null!=this.selectList&&this.selectList.length>0&&this.selectList.forEach(function(e){t=t+e.id+","}),Object(r.exportExcelWarehouseInitial)({ids:t}).then(function(t){t&&Object(h.j)(t,"仓库初始化导出.xls")}).catch(function(t){})},importExcel:function(){this.dialogData.importUrl="/warehouse/warehouseInitial/importExcelWarehouseInitial",this.dialogData.title="文件导入",this.openDialogName="dialogImportExcel",this.showDialog=!0,this.visible=!0},importExcelCallBack:function(){this.refreshTable(),this.functionTableButton()},disableInitial:function(){var t=this;Object(r.disableWarehouseInitial)({warehouseGenre:"warehouse"}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.functionTableButton())}).catch(function(t){})},editByRow:function(t,e){this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="编辑",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0},deleteByRow:function(t,e){var i=this,n=JSON.parse(JSON.stringify(t));this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(r.deleteWarehouseProduct)(n.id).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),i.initTree())}).catch(function(t){})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable(null,this.selectTree.id)}}},b=(i("jIRe"),i("KHd+")),m=Object(b.a)(g,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"warehouseInitialManage"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:t.treeData,treeConfigs:t.treeConfigs},on:{treedatabridge:t.treeDataBridge}})],1),t._v(" "),i("el-col",{staticClass:"tableStyle",attrs:{span:20}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state,dialog:t.dialog},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);m.options.__file="index.vue";e.default=m.exports},jIRe:function(t,e,i){"use strict";var n=i("sJ2i");i.n(n).a},sJ2i:function(t,e,i){}}]);