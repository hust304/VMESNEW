(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-07d8"],{NwC3:function(e,t,i){"use strict";var a=i("esil");i.n(a).a},esil:function(e,t,i){},mJk1:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("f3/d"),i("rGqo");var a=i("uTIz"),n=i("Y/E/"),s=i("ZItt"),o=i("zDZ1"),l=i("mSNy"),r=i("9WTv"),c=i("Do8I"),h=i("Vobf"),d=i("z0WU");function p(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){g(e,t,i[t])})}return e}function g(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var f={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.editBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editBtns(scope.row,scope.$index)">编辑</el-button>\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.qrcodeBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.qrcodeBtns(scope.row,scope.$index)">二维码</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},m={data:function(){return{guid:"",searchList:[{label:"设备编码",type:"input",mapKey:"code",configs:{},placeholder:"设备编码"},{label:"设备名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"设备名称"},{label:"是否启用",type:"select",ruleType:"string",mapKey:"isdisable",configs:{clearable:!0,name:"",options:[{value:"1",label:"是"},{value:"0",label:"否"}]},placeholder:"请选择"},{label:"设备类型",type:"input",ruleType:"string",mapKey:"typeName",configs:{},placeholder:"设备类型"},{label:"所属部门",type:"input",ruleType:"string",mapKey:"deptName",configs:{},placeholder:"所属部门"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null},initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",btnName:"编辑",isPropName:!0,component:f,editBtns:this.editBtns,editBtns_isShow:!0,qrcodeBtns:this.qrcodeBtns,qrcodeBtns_isShow:!0}},configs:{topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.addNew},{name:"删除",nameEn:"delete",isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteBatch},{name:"导出",nameEn:"export",isShow:!0,icon:"export",method:this.exportExcel},{name:"导入",nameEn:"import",isShow:!0,icon:"import",method:this.importExcelCallBack,dialog:{enable:!0,data:{exportUrl:"/fileUpload/excelTemplet/EquipmentExcelImport.xlsx",importUrl:"/base/equipment/importExcelEquipments"},dialogName:"dialogImportExcel"}}],tableConfigs:[],showCheckBox:!1,showIndex:!1},filterTextDept:"",enterTime:0,showDisableDept:!1,treeNodes:[],treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},components:{searchBar:a.a,dialogAdd:n.default,dialogEdit:s.default,dialogQrcode:o.a},beforeCreate:function(){},created:function(){this.initButtons(),this.initTree()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(e){this.tempQuery=e,this.pageNo=1,this.initTable(this.selectTree.id,this.selectTree.layer)},sendGuid:function(e){this.guid=e},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.refreshTable()},initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,i=e.$storage.get("menuId");t&&(e.$loading({spinner:"preloader",text:""}),Object(h.initMenuButtons)({menuId:i,roleId:t}).then(function(t){var i=t.buttonList;i&&i.forEach(function(t){if(e.initConfigs&&e.initConfigs.tableOperates)for(var i in e.initConfigs.tableOperates)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e.initConfigs.tableOperates[i]=!1);if(e.customColumn)for(var a in e.customColumn)if(a){var n=e.customColumn[a];n.length>0&&n.forEach(function(e){if(e)for(var i in e)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e[i]=!1)})}e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){e.$loading().close()}))},initTree:function(){var e=this;Object(c.listTreeDepartment)({}).then(function(t){var i=[],a=t.result.treeList;e.selectTree={pid:a.pid,id:a.id,layer:a.layer,name:a.name},i.push(a),e.treeData=i,e.treeNodes=[],Object(d.c)(e.treeData,e.showDisableDept,e.filterTextDept,e.treeNodes),e.$nextTick(function(){if(e.treeNodes.length>0){var t=e.treeNodes[0];e.selectTree={pid:t.pid,id:t.id,layer:t.layer,name:t.name}}e.initTable(e.selectTree.id,e.selectTree.layer,!0)})}).catch(function(t){e.$loading().close()})},treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,layer:e.nodeData.layer,name:e.nodeData.name},this.pageNo=1,this.initTable(this.selectTree.id,this.selectTree.layer)},disableState:function(e){},initTable:function(e,t,i){var a=this;Object(r.listPageEquipments)(p({},a.tempQuery,{pid:e,layer:t,dataType:this.$storage.get("dataType"),pageNo:a.pageNo})).then(function(e){a.getListPage(e),i&&a.$loading().close()}).catch(function(e){a.$loading().close()})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(d.o)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==l.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==l.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}})},addTableTitle:function(e){var t=this;return e.forEach(function(e){var i=e.label;i.indexOf("_")>0&&("en"==l.a.locale?e.label=i.substring(i.indexOf("_")+1):"zh"==l.a.locale&&(e.label=i.substring(0,i.indexOf("_")))),"是否启用"===e.label&&(e.component=u,e.changeState=t.changeState)}),t.internationalConfig(),e.push(t.initConfigs.tableOperates),e},internationalConfig:function(){"en"==l.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==l.a.locale&&(this.initConfigs.tableOperates.label="操作")},changeState:function(e,t){Object(r.updateDisableEquipment)(e.id,e.isdisable).then(function(e){}).catch(function(e){})},dataBridge:function(e){this.selectList=e,e.length?this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!1)}):this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})},editBtns:function(e,t){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(e)),this.dialogData.temp=this.temp,this.dialogData.temp.deptId=this.selectTree.id,this.dialogData.temp.deptName=this.selectTree.name,this.dialogData.tempLable=this.tempLable,this.dialogData.title="编辑",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0},qrcodeBtns:function(e,t){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(e)),this.dialogData.temp=this.temp,this.dialogData.temp.deptId=this.selectTree.id,this.dialogData.temp.deptName=this.selectTree.name,this.dialogData.tempLable=this.tempLable,this.dialogData.title="二维码",this.openDialogName="dialogQrcode",this.showDialog=!0,this.visible=!0},addNew:function(){this.resetTemp(),this.dialogData.temp=this.temp,this.dialogData.temp.deptId=this.selectTree.id,this.dialogData.temp.deptName=this.selectTree.name,this.dialogData.tempLable=this.tempLable,this.dialogData.title="新增",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},deleteBatch:function(){var e=this;e.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var t="";e.selectList.forEach(function(e){t+=e.id+","}),Object(r.deleteEquipments)(t).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(e){})}).catch(function(){e.$message({type:"info",message:"已取消删除"})})},refreshTable:function(){var e=this;e.$axios.all([Object(r.listPageEquipments)(p({},e.tempQuery,{pid:e.selectTree.id,dataType:this.$storage.get("dataType"),layer:e.selectTree.layer,pageNo:e.pageNo}))]).then(e.$axios.spread(function(t){e.getListPage(t)})).catch(function(e){})},exportExcel:function(){var e="";null!=this.selectList&&this.selectList.length>0&&this.selectList.forEach(function(t){e=e+t.id+","}),Object(r.exportExcelEquipments)(e).then(function(e){e&&Object(d.j)(e,"设备信息导出.xls")}).catch(function(e){})},importExcelCallBack:function(){this.refreshTable()},searchDeptByName:function(){var e=this;e.treeNodes=[],Object(d.c)(e.treeData,e.showDisableDept,e.filterTextDept,e.treeNodes),e.enterTime=e.enterTime+1,e.$nextTick(function(){if(e.treeNodes.length>0){var t=e.treeNodes[e.enterTime%e.treeNodes.length];e.selectTree={pid:t.pid,id:t.id,layer:t.layer,name:t.name}}e.initTable(e.selectTree.id,e.selectTree.layer)})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable(this.selectTree.id,this.selectTree.layer)}}},b=(i("NwC3"),i("KHd+")),T=Object(b.a)(m,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"equipmentManage"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("div",{staticStyle:{"padding-left":"20px",height:"100%"}},[i("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge,"disable-state":e.disableState}})],1)]),e._v(" "),i("el-col",{staticClass:"tableStyle",attrs:{span:20}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state,dialog:e.dialog},on:{myclick:e.method}})]})],2)])],1),e._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)],1)])],1),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);T.options.__file="index.vue";t.default=T.exports}}]);