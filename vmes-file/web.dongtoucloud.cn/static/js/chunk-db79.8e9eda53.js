(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-db79","zXQq","ihj5"],{Ogww:function(t,e,i){},SNA9:function(t,e,i){"use strict";var o=i("Ogww");i.n(o).a},VHoc:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("KKXr"),i("f3/d"),i("rGqo");var o=i("uTIz"),a=i("zDZ1"),n=i("zXQq"),s=i("ihj5"),l=i("K3g7"),r=i("1FtD"),c=i("6Q2N"),u=i("Vobf"),d=i("z0WU"),p=i("mSNy");function h(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},o=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(o=o.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),o.forEach(function(e){m(t,e,i[e])})}return t}function m(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var f={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t\t\t\x3c!--<el-button  v-show="colConfig.qrcodeBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.qrcodeBtns(scope.row,scope.$index)">二维码</el-button>--\x3e\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.editByRow_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editByRow(scope.row,scope.$index)">编辑</el-button>\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.deleteByRow_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.deleteByRow(scope.row,scope.$index)">删除</el-button>\n    \t\t\t\t\t</div>\n\n  \t\t\t\t</el-table-column>'},g={components:{searchBar:o.a,dialogQrcode:a.a,dialogEdit:n.default,dialogImportExcel:s.default},data:function(){return{fieldCode:"warehouseName,productCode,productName,productSpec,productGenreName,productUnitName,stockCount",guid:"",searchList:[{label:"货位编码",type:"input",ruleType:"string",mapKey:"warehouseCode",configs:{},placeholder:"货位编码"},{label:"货位名称",type:"input",ruleType:"string",mapKey:"pathName",configs:{},placeholder:"货位名称"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"规格型号"},{label:"货品属性",type:"cascader",mapKey:"genreSelect",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"productGenre",isglobal:"1"}},placeholder:"请选择"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"productUnitName",configs:{},placeholder:"计量单位"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null,nodeId:null},initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:f,editByRow:this.editByRow,editByRow_isShow:!0,deleteByRow:this.deleteByRow,deleteByRow_isShow:!0}},configs:{topBarBtnList:[{name:"初始化",nameEn:"add",isShow:!0,state:!1,icon:"add",method:this.initialWarehouse},{name:"导出",nameEn:"exportExcel",isShow:!0,icon:"export",method:this.exportExcel},{name:"导入",nameEn:"importExcel",isShow:!0,icon:"import",method:this.importExcelCallBack,dialog:{enable:!0,data:{exportUrl:"/fileUpload/excelTemplet/WarehouseProductBySimpleExcelImport.xlsx",importUrl:"/warehouse/warehouseInitialBySimple/importExcelWarehouseInitialBySimple"},dialogName:"dialogImportExcel"}},{name:"禁用初始化",nameEn:"disableInitial",isShow:!0,state:!1,icon:"add",method:this.disableInitial}],tableConfigs:[],showCheckBox:!1,showIndex:!1},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},isShowEdit:"true",isShowDelete:"true",pageData:null,pageNo:1}},beforeCreate:function(){},created:function(){this.initButtons(),this.initTree()},beforeMount:function(){},mounted:function(){this.functionTableButton()},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(t){this.tempQuery=t,this.pageNo=1,this.initTable(null,this.selectTree.id)},sendGuid:function(t){this.guid=t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&(this.initTree(),this.functionTableButton())},initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"云上企业"}),Object(u.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){if(t.initConfigs&&t.initConfigs.tableOperates)for(var i in t.initConfigs.tableOperates)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t.initConfigs.tableOperates[i]=!1);if(t.customColumn)for(var o in t.customColumn)if(o){var a=t.customColumn[o];a.length>0&&a.forEach(function(t){if(t)for(var i in t)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t[i]=!1)})}t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){t.$loading().close()}))},initTable:function(t,e){var i=this;Object(r.listPageWarehouseInitial)(h({},i.tempQuery,{nodeId:e,dataType:this.$storage.get("dataType"),fieldCode:"productCode,productName,productSpec,productGenreName,warehouseName,productUnitName,code,stockCount",isNeedEntity:"true",isNeedNotInWarehouseSpare:"true",pageNo:i.pageNo})).then(function(e){i.getListPage(e),t&&i.$loading().close()}).catch(function(t){i.$loading().close()})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(d.l)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var o=t[i];o.indexOf("_")>0&&("en"==p.a.locale?o=o.substring(o.indexOf("_")+1):"zh"==p.a.locale&&(o=o.substring(0,o.indexOf("_")))),e.tempLable[i]=o}})},addTableTitle:function(t){return t.forEach(function(t){var e=t.label;e.indexOf("_")>0&&("en"==p.a.locale?t.label=e.substring(e.indexOf("_")+1):"zh"==p.a.locale&&(t.label=e.substring(0,e.indexOf("_"))))}),this.internationalConfig(),t.push(this.initConfigs.tableOperates),t},internationalConfig:function(){"en"==p.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==p.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTree:function(){var t=this;Object(l.treeWarehouse)({id:"2d75e49bcb9911e884ad00163e105f05",isNotNeedSpare:"true",isNeedEntity:"true"}).then(function(e){var i=[],o=e.result.treeList;t.selectTree={pid:o.pid,id:o.id,layer:o.layer,name:o.name,virtualGenre:o.virtualGenre},i.push(o),t.treeData=i,t.initTable(!0,t.selectTree.id),t.$nextTick(function(){t.$refs.tree.$children[0].setCurrentKey(t.selectTree.id)})}).catch(function(e){t.$loading().close()})},treeDataBridge:function(t){this.selectTree={pid:t.nodeData.pid,id:t.nodeData.id,layer:t.nodeData.layer,name:t.nodeData.name,pathId:t.nodeData.pathId},this.pageNo=1,this.initTable(null,this.selectTree.id)},dataBridge:function(t){this.selectList=t,t.length?this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!1)}):this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})},editByRow:function(t,e){this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="编辑",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0},deleteByRow:function(t,e){var i=this;JSON.parse(JSON.stringify(t));this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(c.deleteWarehouseProductBySimple)({warehouseId:t.warehouseId,productId:t.productId,stockCount:t.stockCount}).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),i.initTree())}).catch(function(t){})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},refreshTable:function(){var t=this;this.$axios.all([Object(c.findWarehouseInitialBySimple)(h({},this.tempQuery,{fieldCode:this.fieldCode,nodeId:this.selectTree.id,dataType:this.$storage.get("dataType"),isNeedEntity:"true",isNeedNotInWarehouseSpare:"true",pageNo:this.pageNo}))]).then(this.$axios.spread(function(e){t.getListPage(e)})).catch(function(t){})},functionTableButton:function(){var t=this,e="111";Object(r.findIsDisableButton)({warehouseGenre:"warehouse"}).then(function(i){null!=i.isDisableButton&&i.isDisableButton.trim().length>0&&(e=i.isDisableButton.trim()),t.setTableButton(e,t.configs.topBarBtnList)})},setTableButton:function(t,e){null!=t&&0!=t.trim().length||(t="111");for(var i=t.split(""),o=i[0],a=i[1],n=i[2],s=0;s<e.length;s++){var l=e[s],r=l.nameEn;"add"==r?this.setTableButtonShow(o,l):"importExcel"==r?this.setTableButtonShow(a,l):"disableInitial"==r&&(this.setTableButtonShow(n,l),"0"==n?this.initConfigs.tableOperates={}:"1"==n&&(this.initConfigs.tableOperates={prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:f,editByRow:this.editByRow,editByRow_isShow:!0,deleteByRow:this.deleteByRow,deleteByRow_isShow:!0}))}},setTableButtonShow:function(t,e){null!=t&&0!=t.trim().length||(t="0"),"0"==t?e.state=!0:"1"==t&&(e.state=!1)},initialWarehouse:function(){var t=this;this.$confirm('<div style="color:#FF0000">初始化后，仓库中的货品以及全部业务数据将被清空，请谨慎操作！</div>',"提示",{dangerouslyUseHTMLString:!0,confirmButtonText:"继续",cancelButtonText:"取消",type:"warning"}).then(function(){t.$confirm('<div style="color:#FF0000">确定执行初始化吗？</div>',"提示",{dangerouslyUseHTMLString:!0,confirmButtonText:"是",cancelButtonText:"否",type:"warning"}).then(function(){Object(r.initialWarehouse)({warehouseGenre:"warehouse"}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"初始化成功",type:"success",duration:2e3}),t.refreshTable(),t.functionTableButton())}).catch(function(t){})}).catch(function(){t.$message({type:"info",message:"已取消仓库初始化"})})}).catch(function(){t.$message({type:"info",message:"已取消仓库初始化"})})},exportExcel:function(){var t="";null!=this.selectList&&this.selectList.length>0&&this.selectList.forEach(function(e){t=t+e.id+","}),Object(r.exportExcelWarehouseInitial)({fieldCode:"warehouseName,productCode,productName,productSpec,productGenreName,productUnitName,stockCount",ids:t,isNeedEntity:"true",isNeedNotInWarehouseSpare:"true"}).then(function(t){t&&Object(d.g)(t,"仓库初始化导出.xls")}).catch(function(t){})},importExcel:function(){this.dialogData.importUrl="/warehouse/warehouseInitialBySimple/importExcelWarehouseInitialBySimple",this.dialogData.title="文件导入",this.openDialogName="dialogImportExcel",this.showDialog=!0,this.visible=!0},importExcelCallBack:function(){this.refreshTable(),this.functionTableButton()},disableInitial:function(){var t=this;Object(r.disableWarehouseInitial)({warehouseGenre:"warehouse"}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.functionTableButton())}).catch(function(t){})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable(null,this.selectTree.id)}}},b=(i("SNA9"),i("KHd+")),y=Object(b.a)(g,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"warehouseInitialManage"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:t.treeData,treeConfigs:t.treeConfigs},on:{treedatabridge:t.treeDataBridge}})],1),t._v(" "),i("el-col",{staticClass:"tableStyle",attrs:{span:20}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state,dialog:t.dialog},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);y.options.__file="index.vue";e.default=y.exports},VfKu:function(t,e,i){"use strict";var o=i("cf0X");i.n(o).a},cf0X:function(t,e,i){},ihj5:function(t,e,i){"use strict";i.r(e);i("f3/d");var o=i("1FtD"),a=i("z0WU"),n={name:"dialog-import-excel",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"文件导入",importUrl:"",exportUrl:"",userInfo:null,excelFileList:[],excelData:{},fieldCode:"pathName,warehouseTypeName,productName,productSpec,productPictureCode,productGenreName,productUnitName,stockCount"}},components:{},beforeCreate:function(){},created:function(){this.initData.title&&(this.title=this.initData.title),this.importUrl="https://web.ouhaicloud.com/"+this.initData.importUrl,this.initData.excelData&&(this.excelData=this.initData.excelData),this.$storage.get("userInfo")&&(this.excelData.companyId=this.$storage.get("userInfo").companyId,this.excelData.userId=this.$storage.get("userInfo").userId,this.excelData.warehouseGenre="warehouse")},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(t){this.$emit("close-dialog",t||{})},importExcelChangeFile:function(t,e){this.excelFileList=[e[e.length-1]]},importExcelBeforeUpload:function(t){null!=this.excelFileList&&this.excelFileList.length>1&&this.$message({showClose:!0,message:"只能选择一个导入文件，请删除多余的导入列表！",type:"warning",duration:5e3});var e=t.name,i="";if(-1!=e.indexOf(".")&&(i=e.substr(e.indexOf(".")+1,e.length)),-1!="xls,xlsx".indexOf(i)){t.size>10485760&&this.$message({showClose:!0,message:"Excel导入文件大小不能超过 5MB!",type:"error",duration:5e3})}else this.$message({showClose:!0,message:"Excel导入文件只能支持(xls,xlsx)格式!",type:"error",duration:5e3})},importExcelSuccess:function(t){this.dialogTopLoading=!1;var e="";null!=t.msg&&t.msg.trim().length>0&&(e=t.msg.trim()),0==t.code?(this.isVisible=!1,this.$message({showClose:!0,message:e,type:"success",duration:5e3}),this.dialogClose({resState:"ok"})):0!=t.code&&this.$message({showClose:!0,message:e,type:"error",duration:0}),this.$refs.upload.clearFiles()},importExcelSubmit:function(){null==this.excelFileList||0!=this.excelFileList.length?(this.dialogTopLoading=!0,this.$refs.upload.submit()):this.$message({showClose:!0,message:"请选择导入文件！",type:"warning",duration:5e3})},exportExcelFunction:function(){var t=this;Object(o.exportExcelTemplateWarehouseInitial)({fieldCode:this.fieldCode}).then(function(e){Object(a.g)(e,"仓库货品导入.xls"),t.$message({title:"成功",message:"Excel仓库货品导入模板下载成功",type:"success",duration:2e3})}).catch(function(t){})}},computed:{},watch:{}},s=i("KHd+"),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.title,visible:t.isVisible,width:"500px",top:"40px","append-to-body":""},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{"text-align":"left","padding-left":"50px","padding-top":"20px","line-height":"20px"}},[i("span",{staticStyle:{"font-size":"16px","padding-bottom":"5px"}},[t._v("操作步骤：")]),i("br"),t._v("\n    1."),i("a",{staticStyle:{color:"#169BD5"},on:{click:t.exportExcelFunction}},[t._v("点击此处下载模板")]),i("br"),t._v("\n    2.按示例填写需要导入的数据信息"),i("br"),t._v("\n    3.请将Excel模板中示例信息删除"),i("br"),t._v("\n    4.上传过程中不要多次提交或刷新页面"),i("br"),t._v("\n    5.Excel导入文件只能支持(xls,xlsx)格式，且文件大小不能超过10M"),i("br"),i("br"),t._v(" "),i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{name:"excelFile",action:t.importUrl,"on-change":t.importExcelChangeFile,"before-upload":t.importExcelBeforeUpload,"on-success":t.importExcelSuccess,data:t.excelData,"file-list":t.excelFileList,"auto-upload":!1}},[i("el-button",{attrs:{slot:"trigger",size:"small",type:"primary"},slot:"trigger"},[t._v("选取文件")]),t._v(" "),i("el-button",{attrs:{size:"small",type:"success"},on:{click:t.importExcelSubmit}},[t._v("导入")])],1),t._v(" "),i("br"),i("br")],1)])},[],!1,null,null,null);l.options.__file="dialogImportExcel.vue";e.default=l.exports},lZYi:function(t,e,i){"use strict";var o=i("qBBH");i.n(o).a},qBBH:function(t,e,i){},zDZ1:function(t,e,i){"use strict";i("rE2o"),i("ioFf"),i("f3/d"),i("9WTv");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var a={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},tempShow:{},rules:{},imageUrl:""}},created:function(){console.log(this.initData),this.initData.temp&&(this.temp=this.initData.temp,this.initData.temp.qrcode&&(this.imageUrl="https://web.ouhaicloud.com/"+this.initData.temp.qrcode)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},download:function(){var t=this.imageUrl,e=document.createElement("a");e.style.display="none",e.href=t,e.setAttribute("download",this.temp.name),document.body.appendChild(e),e.click()},print:function(){var t='<!DOCTYPE html> <html> <head> <meta charset="utf-8"> <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> ';t+="<style></style>",t+="</head><body >",t+=document.getElementById("printContent").innerHTML,t+="</body></html>";var e=window.open("","打印","");e.document.write(t),e.document.close(),e.focus(),e.print(),e.close()},dialogImgLoad:function(){this.$refs.myDialog&&this.$refs.myDialog.reDialogStyle&&this.$refs.myDialog.reDialogStyle(this.$store.getters.systemInfo,!0)}}},n=(i("lZYi"),i("VfKu"),i("KHd+")),s=Object(n.a)(a,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],ref:"myDialog",attrs:{title:t.initData.title?t.initData.title:"二维码",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("div",{attrs:{id:"printContent"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"text-align":"center","padding-bottom":"20px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},attrs:{span:24}},[t.imageUrl?i("img",{staticClass:"avatar",staticStyle:{margin:"0 auto"},attrs:{src:t.imageUrl},on:{load:t.dialogImgLoad}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.code)+":")]),t._v(t._s(t.temp.code)),i("br"),t._v(" "),i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.name)+":")]),t._v(t._s(t.temp.name)+"\n\n          ")])],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center",padding:"15px 0 15px 0"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.download}},[t._v("下载")]),t._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:t.print}},[t._v("打印")])],1)])])},[],!1,null,"20580914",null);s.options.__file="dialogQrcode.vue";e.a=s.exports},zXQq:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("Oyvg");var o=i("1FtD");function a(t){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{},name:"dialog-edit",props:["initData","visible"],data:function(){var t=this;return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{newStockCount:[{required:!0,trigger:"change",validator:function(e,i,o){null==i||0==i.trim().length?o(new Error("请填写变更单价！")):t.isNumberByValue(i+"")?0==i?o(new Error("请输入大于零的整数或小数！")):o():o(new Error("请输入大于零的整数或小数！"))}}]}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.initData.tempLable&&(this.tempLable=this.initData.tempLable),null!=this.initData.temp.stockCount&&(this.temp.oldStockCount=this.initData.temp.stockCount)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=a(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t.trim())},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&Object(o.updateWarehouseProduct)({id:t.temp.id,stockCount:t.temp.newStockCount}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})}}},s=i("KHd+"),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"620px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.warehouseCode+":",prop:"warehouseCode"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.warehouseCode,callback:function(e){t.$set(t.temp,"warehouseCode",e)},expression:"temp.warehouseCode"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.pathName+":",prop:"pathName"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.pathName,callback:function(e){t.$set(t.temp,"pathName",e)},expression:"temp.pathName"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.productCode+":",prop:"productCode"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.productCode,callback:function(e){t.$set(t.temp,"productCode",e)},expression:"temp.productCode"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.productName+":",prop:"productName"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.productName,callback:function(e){t.$set(t.temp,"productName",e)},expression:"temp.productName"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.productSpec+":",prop:"productSpec"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.productSpec,callback:function(e){t.$set(t.temp,"productSpec",e)},expression:"temp.productSpec"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.productGenreName+":",prop:"productGenreName"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.productGenreName,callback:function(e){t.$set(t.temp,"productGenreName",e)},expression:"temp.productGenreName"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.productUnitName+":",prop:"productUnitName"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.productUnitName,callback:function(e){t.$set(t.temp,"productUnitName",e)},expression:"temp.productUnitName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"原库存数量:",prop:"oldStockCount"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.oldStockCount,callback:function(e){t.$set(t.temp,"oldStockCount",t._n(e))},expression:"temp.oldStockCount"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.stockCount+":",prop:"newStockCount"}},[i("el-input",{model:{value:t.temp.newStockCount,callback:function(e){t.$set(t.temp,"newStockCount",e)},expression:"temp.newStockCount"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);l.options.__file="dialogEdit.vue";e.default=l.exports}}]);