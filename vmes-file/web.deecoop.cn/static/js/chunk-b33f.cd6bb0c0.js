(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-b33f"],{"4uhQ":function(e,t,i){},FWEX:function(e,t,i){"use strict";var a=i("4uhQ");i.n(a).a},dv0t:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("f3/d"),i("rGqo");var a=i("mSNy"),n=i("uTIz"),s=i("5W5M"),o=i("Vobf"),r=i("z0WU");function l(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){c(e,t,i[t])})}return e}function c(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var h={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.editBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editBtns(scope.row,scope.$index)">编辑</el-button>\n      \t\t\t\t\t</div>\n    \t\t\t\t</el-table-column>'},d={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},p={data:function(){return{guid:"",searchList:[{label:"字典名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"字典名称"},{label:"是否启用",type:"select",ruleType:"string",mapKey:"isdisable",configs:{clearable:!0,name:"",options:[{value:"1",label:"是"},{value:"0",label:"否"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!1,userInfo:null,filterTextDept:"",enterTime:0,showDisableDept:!1,treeNodes:[],hideTime:700,dynaHeight:40,clientHeight:0,dynaHeightTimer:null,dynaHeightState:null,initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:h,editBtns:this.editBtns,editBtns_isShow:!0}},configs:{queryBarBtnList:[{name:"查询",nameEn:"query",isShow:!0,icon:"search",method:this.queryTable},{name:"重置",nameEn:"reset",isShow:!0,icon:"refresh",plain:!0,method:this.resetQueryTemp}],topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.addNew},{name:"删除",nameEn:"delete",isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteBatch},{name:"导出",nameEn:"export",isShow:!0,icon:"export",method:this.exportExcel}],tableConfigs:[],showCheckBox:!1,showIndex:!1},tableData:[],selectList:null,treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1,showSearch:!0,showDisable:!1},selectTree:{pid:"",id:"",layer:"",name:""},dialogFormVisible:!1,dialogStatus:"",textMap:{update:"编辑菜单",create:"新增菜单"},temp:{},tempQuery:{},tempLable:{},tempNotEditable:{},rules:{name:[{required:!0,message:"请填写字典名称",trigger:"change"}]},pageData:null,pageNo:1,deptTypeData:[],isReadDeptTypeFirst:!0,selectedDeptTypeOptions:[],props:{value:"value",label:"label",children:"childrens"}}},components:{searchBar:n.a},beforeCreate:function(){},created:function(){this.userInfo=this.$storage.get("userInfo"),this.initButtons(),this.initTree(),this.dynaHeightState=this.$storage.get("dynaHeightState")||"1",this.dynaHeightState-0||(this.dynaHeight=0)},beforeMount:function(){},mounted:function(){this.clientHeight=this.$el.clientHeight},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(e){this.tempQuery=e,this.pageNo=1,this.initTable(this.selectTree.id,this.selectTree.layer,null)},sendGuid:function(e){this.guid=e},initButtons:function(){var e=this;e.$loading({spinner:"preloader",text:""});var t=e.$storage.get("userInfo").roleIds,i=e.$storage.get("menuId");t&&Object(o.initMenuButtons)({menuId:i,roleId:t}).then(function(t){var i=t.buttonList;i&&i.forEach(function(t){if(e.initConfigs&&e.initConfigs.tableOperates)for(var i in e.initConfigs.tableOperates)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e.initConfigs.tableOperates[i]=!1);if(e.customColumn)for(var a in e.customColumn)if(a){var n=e.customColumn[a];n.length>0&&n.forEach(function(e){if(e)for(var i in e)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e[i]=!1)})}e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){e.$loading().close()})},initTree:function(){var e=this;Object(s.listTreeDictionary)({}).then(function(t){var i=[],a=t.result.treeList;e.selectTree={pid:a.pid,id:a.id,layer:a.layer,name:a.name},i.push(a),e.treeData=i,e.treeNodes=[],Object(r.c)(e.treeData,e.showDisableDept,e.filterTextDept,e.treeNodes),e.$nextTick(function(){if(e.treeNodes.length>0){var t=e.treeNodes[0];e.selectTree={pid:t.pid,id:t.id,layer:t.layer,name:t.name}}e.initTable(e.selectTree.id,e.selectTree.layer,!0)})}).catch(function(t){e.$loading().close()})},treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,layer:e.nodeData.layer,name:e.nodeData.name},this.pageNo=1,this.initTable(this.selectTree.id,this.selectTree.layer)},queryTable:function(){this.pageNo=1,this.initTable(this.selectTree.id,this.selectTree.layer)},initTable:function(e,t,i){var a=this;Object(s.listPageDictionary)(l({},a.tempQuery,{pid:e,layer:t,pageNo:a.pageNo})).then(function(e){a.getListPage(e),i&&a.$loading().close()}).catch(function(e){a.$loading().close()})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(r.o)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var n=e[i];n.indexOf("_")>0&&("en"==a.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==a.a.locale&&(n=n.substring(0,n.indexOf("_")))),t.tempLable[i]=n,t.tempNotEditable[i]=!1}})},addTableTitle:function(e){var t=this;return e.forEach(function(e){var i=e.label;i.indexOf("_")>0&&("en"==a.a.locale?e.label=i.substring(i.indexOf("_")+1):"zh"==a.a.locale&&(e.label=i.substring(0,i.indexOf("_")))),"是否启用"===e.label&&(e.component=d,e.changeState=t.changeState)}),t.internationalConfig(),e.push(t.initConfigs.tableOperates),e},internationalConfig:function(){"en"==a.a.locale?(this.initConfigs.tableOperates.label="OPERATE",this.textMap.create="ADDNEW",this.textMap.update="EDIT"):"zh"==a.a.locale&&(this.initConfigs.tableOperates.label="操作",this.textMap.create="新增",this.textMap.update="编辑")},changeState:function(e,t){Object(s.updateDisableDictionary)(e.id,e.isdisable).then(function(e){}).catch(function(t){"0"==e.isdisable&&(e.isdisable="1")})},dataBridge:function(e){this.selectList=e,e.length?this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!1)}):this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})},editBtns:function(e,t){var i=this;this.resetTemp(),this.temp=JSON.parse(JSON.stringify(e)),this.tempNotEditable.parentName=!0,this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){i.$refs.submitForm.clearValidate()})},updateData:function(){var e=this;e.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(s.updateDictionary)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.dialogFormVisible=!1,e.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(t){e.dialogLoading=!1}))})},addNew:function(){var e=this;this.resetTemp(),"6839818aecfc41be8f367e62502dfde4"==this.userInfo.userType||"root"!=this.selectTree.pid?"2"!=this.selectTree.layer||(this.selectTree.pid,0)?(this.temp.pid=this.selectTree.id,this.temp.parentName=this.selectTree.name,this.tempNotEditable.parentName=!0,this.dialogStatus="create",this.dialogFormVisible=!0,this.$nextTick(function(){e.$refs.submitForm.clearValidate()})):this.$message({type:"info",message:"该数据字典类型不支持新增三级节点!"}):this.$message({type:"info",message:"只有超级管理员才能新增数据字典一级节点!"})},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},resetQueryTemp:function(){for(var e in this.tempQuery)this.tempQuery[e]=""},createData:function(){var e=this;this.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(s.addDictionary)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.dialogFormVisible=!1,e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(t){e.dialogLoading=!1}))})},deleteBatch:function(){var e=this;e.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var t="";e.selectList.forEach(function(e){t+=e.id+","}),Object(s.deleteDictionarys)(t).then(function(t){0===t.code&&(e.dialogFormVisible=!1,e.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(e){})}).catch(function(){e.$message({type:"info",message:"已取消删除"})})},refreshTable:function(){var e=this;e.$axios.all([Object(s.listPageDictionary)(l({},e.tempQuery,{pid:e.selectTree.id,layer:e.selectTree.layer,pageNo:e.pageNo})),Object(s.listTreeDictionary)({})]).then(e.$axios.spread(function(t,i){e.getListPage(t);var a=i.result.treeList,n=[];n.push(a),e.treeData=n,e.$nextTick(function(){})})).catch(function(e){})},exportExcel:function(){var e="";null!=this.selectList&&this.selectList.length>0&&this.selectList.forEach(function(t){e=e+t.id+","}),Object(s.exportExcelDictionarys)(e).then(function(e){e&&Object(r.j)(e,"数据字典导出.xls")}).catch(function(e){})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},watch:{pageNo:function(){this.initTable(this.selectTree.id,this.selectTree.layer)},showDisableDept:function(){this.initTree()}}},u=(i("FWEX"),i("KHd+")),f=Object(u.a)(p,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"dictionaryManage"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("div",{staticStyle:{"padding-left":"20px",height:"100%"}},[i("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1)]),e._v(" "),i("el-col",{staticClass:"tableStyle",attrs:{span:20}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)],1)])],1),e._v(" "),i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.textMap[e.dialogStatus],visible:e.dialogFormVisible,width:"700px",top:"40px"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:e.tempLable.parentName+":",prop:"parentName"}},[i("el-input",{attrs:{disabled:e.tempNotEditable.parentName},model:{value:e.temp.parentName,callback:function(t){e.$set(e.temp,"parentName",t)},expression:"temp.parentName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:e.tempLable.name+":",prop:"name"}},[i("el-input",{model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name",t)},expression:"temp.name"}})],1),e._v(" "),i("el-form-item",{attrs:{label:e.tempLable.remark+":",prop:"remark"}},[i("el-input",{model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"30px"},attrs:{slot:"footer"},slot:"footer"},["create"==e.dialogStatus?i("el-button",{attrs:{type:"primary"},on:{click:e.createData}},[e._v("保存")]):i("el-button",{attrs:{type:"primary"},on:{click:e.updateData}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("关闭")])],1)],1)])],1)},[],!1,null,null,null);f.options.__file="index.vue";t.default=f.exports}}]);