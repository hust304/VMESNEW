(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-42fd"],{EnqU:function(e,t,i){},"WmY+":function(e,t,i){"use strict";var a=i("EnqU");i.n(a).a},osum:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("f3/d"),i("rGqo");var a=i("mSNy"),n=i("uTIz"),s=i("yvbL"),o=i("Vobf"),l=i("Do8I"),r=i("5W5M"),c=i("z0WU");function d(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){p(e,t,i[t])})}return e}function p(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var h={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.editBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editBtns(scope.row,scope.$index)">编辑</el-button>\n      \t\t\t\t\t</div>\n    \t\t\t\t</el-table-column>'},u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},f={data:function(){return{guid:"",searchList:[{label:"岗位编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"角色编码"},{label:"岗位名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"角色名称"},{label:"所属部门",type:"input",ruleType:"string",mapKey:"deptName",configs:{},placeholder:"所属部门"},{label:"是否启用",type:"select",ruleType:"string",mapKey:"isdisable",configs:{clearable:!0,name:"",options:[{value:"1",label:"是"},{value:"0",label:"否"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!1,userInfo:null,filterTextDept:"",enterTime:0,showDisableDept:!1,treeNodes:[],hideTime:700,dynaHeight:40,clientHeight:0,dynaHeightTimer:null,dynaHeightState:null,initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:h,editBtns:this.editBtns,editBtns_isShow:!0}},configs:{queryBarBtnList:[{name:"查询",nameEn:"query",isShow:!0,icon:"search",method:this.queryTable},{name:"重置",nameEn:"reset",isShow:!0,icon:"refresh",plain:!0,method:this.resetQueryTemp}],topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.addNew},{name:"删除",nameEn:"delete",isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteBatch},{name:"导出",nameEn:"export",isShow:!0,icon:"export",method:this.exportExcel}],tableConfigs:[],showCheckBox:!1,showIndex:!1},tableData:[],selectList:null,treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1,showSearch:!0,showDisable:!1},selectTree:{pid:"",id:"",layer:"",name:""},dialogFormVisible:!1,dialogStatus:"",textMap:{update:"编辑菜单",create:"新增菜单"},temp:{},tempQuery:{},tempLable:{},tempNotEditable:{},rules:{name:[{required:!0,message:"请填写部门名称",trigger:"change"}]},pageData:null,pageNo:1,deptTypeData:[],isReadDeptTypeFirst:!0,selectedDeptTypeOptions:[],props:{value:"value",label:"label",children:"childrens"}}},components:{searchBar:n.a},beforeCreate:function(){},created:function(){this.userInfo=this.$storage.get("userInfo"),this.initButtons(),this.initTree(),this.dynaHeightState=this.$storage.get("dynaHeightState")||"1",this.dynaHeightState-0||(this.dynaHeight=0)},beforeMount:function(){},mounted:function(){this.clientHeight=this.$el.clientHeight},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(e){this.tempQuery=e,this.pageNo=1,this.initTable(this.selectTree.id,null)},sendGuid:function(e){this.guid=e},initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,i=e.$storage.get("menuId");t&&(e.$loading({spinner:"preloader",text:""}),Object(o.initMenuButtons)({menuId:i,roleId:t}).then(function(t){var i=t.buttonList;i&&i.forEach(function(t){if(e.initConfigs&&e.initConfigs.tableOperates)for(var i in e.initConfigs.tableOperates)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e.initConfigs.tableOperates[i]=!1);if(e.customColumn)for(var a in e.customColumn)if(a){var n=e.customColumn[a];n.length>0&&n.forEach(function(e){if(e)for(var i in e)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e[i]=!1)})}e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){e.$loading().close()}))},disableState:function(e){this.initTree(e,!0)},initTree:function(e,t){var i=this,a=" isdisable = 1 ";e&&(a=""),Object(l.listTreeDepartment)({queryStr:a,deptID:i.userInfo.companyId}).then(function(e){var a=[],n=e.result.treeList;i.selectTree={pid:n.pid,id:n.id,layer:n.layer,name:n.name},a.push(n),i.treeData=a,i.treeNodes=[],i.$nextTick(function(){if(i.treeNodes.length>0){var e=i.treeNodes[0];i.selectTree={pid:e.pid,id:e.id,layer:e.layer,name:e.name}}t||i.initTable(i.selectTree.id,!0)})}).catch(function(e){i.$loading().close()})},treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,layer:e.nodeData.layer,name:e.nodeData.name},this.pageNo=1,this.initTable(this.selectTree.id)},queryTable:function(){this.pageNo=1,this.initTable(this.selectTree.id)},initTable:function(e,t){var i=this;Object(s.listPagePosts)(d({},i.tempQuery,{userDeptId:e,dataType:this.$storage.get("dataType"),pageNo:i.pageNo})).then(function(e){i.getListPage(e),t&&i.$loading().close()}).catch(function(e){i.$loading().close()})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(c.o)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var n=e[i];n.indexOf("_")>0&&("en"==a.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==a.a.locale&&(n=n.substring(0,n.indexOf("_")))),t.tempLable[i]=n,t.tempNotEditable[i]=!1}})},addTableTitle:function(e){var t=this;return e.forEach(function(e){var i=e.label;i.indexOf("_")>0&&("en"==a.a.locale?e.label=i.substring(i.indexOf("_")+1):"zh"==a.a.locale&&(e.label=i.substring(0,i.indexOf("_")))),"是否启用"===e.label&&(e.component=u,e.changeState=t.changeState)}),t.internationalConfig(),e.push(t.initConfigs.tableOperates),e},internationalConfig:function(){"en"==a.a.locale?(this.initConfigs.tableOperates.label="OPERATE",this.textMap.create="ADDNEW",this.textMap.update="EDIT"):"zh"==a.a.locale&&(this.initConfigs.tableOperates.label="操作",this.textMap.create="新增",this.textMap.update="编辑")},changeState:function(e,t){Object(s.updateDisablePost)(e.id,e.isdisable).then(function(e){}).catch(function(t){"0"==e.isdisable&&(e.isdisable="1")})},dataBridge:function(e){this.selectList=e,e.length?this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!1)}):this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})},editBtns:function(e,t){var i=this;this.resetTemp(),this.temp=JSON.parse(JSON.stringify(e)),this.selectedDeptTypeOptions=[],this.selectedDeptTypeOptions.push(e.deptType),this.tempNotEditable.code=!0,this.tempNotEditable.parentName=!0,this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){i.$refs.submitForm.clearValidate()})},updateData:function(){var e=this;e.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(s.updatePost)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.dialogFormVisible=!1,e.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(t){e.dialogLoading=!1}))})},addNew:function(){var e=this;this.resetTemp(),this.temp.deptId=this.selectTree.id,this.temp.deptName=this.selectTree.name,this.tempNotEditable.code=!0,this.tempNotEditable.parentName=!0,this.dialogStatus="create",this.dialogFormVisible=!0,this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},resetQueryTemp:function(){for(var e in this.tempQuery)this.tempQuery[e]=""},createData:function(){var e=this;this.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(s.addPost)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.dialogFormVisible=!1,e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(t){e.dialogLoading=!1}))})},deleteBatch:function(){var e=this;e.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var t="";e.selectList.forEach(function(e){t+=e.id+","}),Object(s.deletePosts)(t).then(function(t){0===t.code&&(e.dialogFormVisible=!1,e.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(e){})}).catch(function(){e.$message({type:"info",message:"已取消删除"})})},refreshTable:function(){var e=this;e.$axios.all([Object(s.listPagePosts)(d({},e.tempQuery,{userDeptId:e.selectTree.id,dataType:this.$storage.get("dataType"),pageNo:e.pageNo}))]).then(e.$axios.spread(function(t,i){e.getListPage(t);var a=i.result.treeList,n=[];n.push(a),e.treeData=n,e.$nextTick(function(){})})).catch(function(e){})},handleDeptTypeFocus:function(){var e=this;e.isReadDeptTypeFirst&&(e.deptTypeData=[],Object(r.dataListDictionarys)("deptType").then(function(t){t.result.forEach(function(t){1;var i={value:t.id,label:t.name};e.deptTypeData.push(i),1&&(e.selectedDeptTypeOptions=[],e.selectedDeptTypeOptions.push(t.id))}),e.isReadDeptTypeFirst=!1}).catch(function(e){}))},handleDeptTypeChange:function(e){this.temp.deptType=e[0]},handleDeptTypeView:function(e){},searchDeptByName:function(){var e=this;e.treeNodes=[],Object(c.c)(e.treeData,e.showDisableDept,e.filterTextDept,e.treeNodes),e.enterTime=e.enterTime+1,e.$nextTick(function(){if(e.treeNodes.length>0){var t=e.treeNodes[e.enterTime%e.treeNodes.length];e.selectTree={pid:t.pid,id:t.id,layer:t.layer,name:t.name}}e.initTable(e.selectTree.id)})},exportExcel:function(){var e="";null!=this.selectList&&this.selectList.length>0&&this.selectList.forEach(function(t){e=e+t.id+","}),Object(s.exportExcelPosts)(e).then(function(e){e&&Object(c.j)(e,"岗位管理导出.xls")}).catch(function(e){})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},watch:{pageNo:function(){this.initTable(this.selectTree.id)},showDisableDept:function(){this.initTree()}}},g=(i("WmY+"),i("KHd+")),m=Object(g.a)(f,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"postManage"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("div",{staticStyle:{"padding-left":"20px",height:"100%"}},[i("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge,"disable-state":e.disableState}})],1)]),e._v(" "),i("el-col",{staticClass:"tableStyle",attrs:{span:20}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)],1)])],1),e._v(" "),i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.textMap[e.dialogStatus],visible:e.dialogFormVisible,width:"700px",top:"40px"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:e.tempLable.deptName+":",prop:"deptName"}},[i("el-input",{attrs:{disabled:e.tempNotEditable.deptName},model:{value:e.temp.deptName,callback:function(t){e.$set(e.temp,"deptName",t)},expression:"temp.deptName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:e.tempLable.name+":",prop:"name"}},[i("el-input",{model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name",t)},expression:"temp.name"}})],1),e._v(" "),i("el-form-item",{attrs:{label:e.tempLable.remark+":",prop:"remark"}},[i("el-input",{model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"30px"},attrs:{slot:"footer"},slot:"footer"},["create"==e.dialogStatus?i("el-button",{attrs:{type:"primary"},on:{click:e.createData}},[e._v("保存")]):i("el-button",{attrs:{type:"primary"},on:{click:e.updateData}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("关闭")])],1)],1)])],1)},[],!1,null,null,null);m.options.__file="index.vue";t.default=m.exports}}]);