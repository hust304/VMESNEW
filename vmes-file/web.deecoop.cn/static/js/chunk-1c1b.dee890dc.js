(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-1c1b"],{Ogww:function(e,t,i){},SNA9:function(e,t,i){"use strict";var n=i("Ogww");i.n(n).a},VHoc:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("KKXr"),i("f3/d"),i("rGqo");var n=i("uTIz"),o=i("zDZ1"),a=i("zXQq"),s=i("ihj5"),l=i("K3g7"),r=i("1FtD"),c=i("6Q2N"),u=i("Vobf"),h=i("z0WU"),d=i("mSNy");function p(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},n=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),n.forEach(function(t){f(e,t,i[t])})}return e}function f(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var g={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t\t\t\x3c!--<el-button  v-show="colConfig.qrcodeBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.qrcodeBtns(scope.row,scope.$index)">二维码</el-button>--\x3e\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.editByRow_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editByRow(scope.row,scope.$index)">编辑</el-button>\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.deleteByRow_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.deleteByRow(scope.row,scope.$index)">删除</el-button>\n    \t\t\t\t\t</div>\n\n  \t\t\t\t</el-table-column>'},m={components:{searchBar:n.a,dialogQrcode:o.a,dialogEdit:a.default,dialogImportExcel:s.default},data:function(){return{fieldCode:"warehouseName,productCode,productName,productSpec,productGenreName,productUnitName,code,stockCount",guid:"",searchList:[{label:"货位编码",type:"input",ruleType:"string",mapKey:"warehouseCode",configs:{},placeholder:"货位编码"},{label:"货位名称",type:"input",ruleType:"string",mapKey:"pathName",configs:{},placeholder:"货位名称"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"规格型号"},{label:"货品属性",type:"cascader",mapKey:"genreSelect",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"productGenre",isglobal:"1"}},placeholder:"请选择"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"productUnitName",configs:{},placeholder:"计量单位"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null,nodeId:null},initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:g,editByRow:this.editByRow,editByRow_isShow:!0,deleteByRow:this.deleteByRow,deleteByRow_isShow:!0}},configs:{topBarBtnList:[{name:"初始化",nameEn:"add",isShow:!0,state:!1,icon:"add",method:this.initialWarehouse},{name:"导出",nameEn:"exportExcel",isShow:!0,icon:"export",method:this.exportExcel},{name:"导入",nameEn:"importExcel",isShow:!0,icon:"import",method:this.importExcelCallBack,dialog:{enable:!0,data:{exportUrl:"/fileUpload/excelTemplet/WarehouseProductBySimpleExcelImport.xlsx",importUrl:"/warehouse/warehouseInitialBySimple/importExcelWarehouseInitialBySimple"},dialogName:"dialogImportExcel"}},{name:"禁用初始化",nameEn:"disableInitial",isShow:!0,state:!1,icon:"add",method:this.disableInitial}],tableConfigs:[],showCheckBox:!1,showIndex:!1},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},isShowEdit:"true",isShowDelete:"true",pageData:null,pageNo:1}},beforeCreate:function(){},created:function(){this.initButtons(),this.initTree()},beforeMount:function(){},mounted:function(){this.functionTableButton()},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(e){this.tempQuery=e,this.pageNo=1,this.initTable(null,this.selectTree.id)},sendGuid:function(e){this.guid=e},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&(this.initTree(),this.functionTableButton())},initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,i=e.$storage.get("menuId");t&&(e.$loading({spinner:"preloader",text:""}),Object(u.initMenuButtons)({menuId:i,roleId:t}).then(function(t){var i=t.buttonList;i&&i.forEach(function(t){if(e.initConfigs&&e.initConfigs.tableOperates)for(var i in e.initConfigs.tableOperates)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e.initConfigs.tableOperates[i]=!1);if(e.customColumn)for(var n in e.customColumn)if(n){var o=e.customColumn[n];o.length>0&&o.forEach(function(e){if(e)for(var i in e)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e[i]=!1)})}e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){e.$loading().close()}))},initTable:function(e,t){var i=this;Object(r.listPageWarehouseInitial)(p({},i.tempQuery,{nodeId:t,dataType:this.$storage.get("dataType"),fieldCode:this.fieldCode,isNeedEntity:"true",isNeedNotInWarehouseSpare:"true",pageNo:i.pageNo})).then(function(t){i.getListPage(t),e&&i.$loading().close()}).catch(function(e){i.$loading().close()})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(h.o)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var n=e[i];n.indexOf("_")>0&&("en"==d.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==d.a.locale&&(n=n.substring(0,n.indexOf("_")))),t.tempLable[i]=n}})},addTableTitle:function(e){return e.forEach(function(e){var t=e.label;t.indexOf("_")>0&&("en"==d.a.locale?e.label=t.substring(t.indexOf("_")+1):"zh"==d.a.locale&&(e.label=t.substring(0,t.indexOf("_"))))}),this.internationalConfig(),e.push(this.initConfigs.tableOperates),e},internationalConfig:function(){"en"==d.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==d.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTree:function(){var e=this;Object(l.treeWarehouse)({id:"2d75e49bcb9911e884ad00163e105f05",isNotNeedSpare:"true",isNeedEntity:"true"}).then(function(t){var i=[],n=t.result.treeList;e.selectTree={pid:n.pid,id:n.id,layer:n.layer,name:n.name,virtualGenre:n.virtualGenre},i.push(n),e.treeData=i,e.initTable(!0,e.selectTree.id),e.$nextTick(function(){e.$refs.tree.$children[0].setCurrentKey(e.selectTree.id)})}).catch(function(t){e.$loading().close()})},treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,layer:e.nodeData.layer,name:e.nodeData.name,pathId:e.nodeData.pathId},this.pageNo=1,this.initTable(null,this.selectTree.id)},dataBridge:function(e){this.selectList=e,e.length?this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!1)}):this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})},editByRow:function(e,t){this.temp=JSON.parse(JSON.stringify(e)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="编辑",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0},deleteByRow:function(e,t){var i=this;JSON.parse(JSON.stringify(e));this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(c.deleteWarehouseProductBySimple)({warehouseId:e.warehouseId,productId:e.productId,stockCount:e.stockCount}).then(function(e){0===e.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),i.initTree())}).catch(function(e){})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},refreshTable:function(){var e=this;this.$axios.all([Object(c.findWarehouseInitialBySimple)(p({},this.tempQuery,{fieldCode:this.fieldCode,nodeId:this.selectTree.id,dataType:this.$storage.get("dataType"),isNeedEntity:"true",isNeedNotInWarehouseSpare:"true",pageNo:this.pageNo}))]).then(this.$axios.spread(function(t){e.getListPage(t)})).catch(function(e){})},functionTableButton:function(){var e=this,t="111";Object(r.findIsDisableButton)({warehouseGenre:"warehouse"}).then(function(i){null!=i.isDisableButton&&i.isDisableButton.trim().length>0&&(t=i.isDisableButton.trim()),e.setTableButton(t,e.configs.topBarBtnList)})},setTableButton:function(e,t){null!=e&&0!=e.trim().length||(e="111");for(var i=e.split(""),n=i[0],o=i[1],a=i[2],s=0;s<t.length;s++){var l=t[s],r=l.nameEn;"add"==r?this.setTableButtonShow(n,l):"importExcel"==r?this.setTableButtonShow(o,l):"disableInitial"==r&&(this.setTableButtonShow(a,l),"0"==a?this.initConfigs.tableOperates={}:"1"==a&&(this.initConfigs.tableOperates={prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:g,editByRow:this.editByRow,editByRow_isShow:!0,deleteByRow:this.deleteByRow,deleteByRow_isShow:!0}))}},setTableButtonShow:function(e,t){null!=e&&0!=e.trim().length||(e="0"),"0"==e?t.state=!0:"1"==e&&(t.state=!1)},initialWarehouse:function(){var e=this;this.$confirm('<div style="color:#FF0000">初始化后，仓库中的货品以及全部业务数据将被清空，请谨慎操作！</div>',"提示",{dangerouslyUseHTMLString:!0,confirmButtonText:"继续",cancelButtonText:"取消",type:"warning"}).then(function(){e.$confirm('<div style="color:#FF0000">确定执行初始化吗？</div>',"提示",{dangerouslyUseHTMLString:!0,confirmButtonText:"是",cancelButtonText:"否",type:"warning"}).then(function(){Object(r.initialWarehouse)({warehouseGenre:"warehouse"}).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"初始化成功",type:"success",duration:2e3}),e.refreshTable(),e.functionTableButton())}).catch(function(e){})}).catch(function(){e.$message({type:"info",message:"已取消仓库初始化"})})}).catch(function(){e.$message({type:"info",message:"已取消仓库初始化"})})},exportExcel:function(){var e="";null!=this.selectList&&this.selectList.length>0&&this.selectList.forEach(function(t){e=e+t.id+","}),Object(r.exportExcelWarehouseInitial)({fieldCode:"pathName,warehouseTypeName,code,sourceCode,productName,productSpec,productPictureCode,productGenreName,typeName,productUnitName,stockCount",ids:e,isNeedEntity:"true",isNeedNotInWarehouseSpare:"true"}).then(function(e){e&&Object(h.j)(e,"仓库初始化导出.xls")}).catch(function(e){})},importExcel:function(){this.dialogData.importUrl="/warehouse/warehouseInitialBySimple/importExcelWarehouseInitialBySimple",this.dialogData.title="文件导入",this.openDialogName="dialogImportExcel",this.showDialog=!0,this.visible=!0},importExcelCallBack:function(){this.refreshTable(),this.functionTableButton()},disableInitial:function(){var e=this;Object(r.disableWarehouseInitial)({warehouseGenre:"warehouse"}).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.functionTableButton())}).catch(function(e){})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable(null,this.selectTree.id)}}},b=(i("SNA9"),i("KHd+")),y=Object(b.a)(m,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"warehouseInitialManage"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1),e._v(" "),i("el-col",{staticClass:"tableStyle",attrs:{span:20}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state,dialog:e.dialog},on:{myclick:e.method}})]})],2)])],1),e._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)],1)])],1),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);y.options.__file="index.vue";t.default=y.exports}}]);