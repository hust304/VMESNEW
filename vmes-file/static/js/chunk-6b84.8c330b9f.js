(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-6b84"],{Fo9U:function(e,t,i){},cOtO:function(e,t,i){"use strict";i.r(t);i("f3/d"),i("rGqo");var n=i("ukxx"),s=i.n(n),a=i("uTIz"),o=i("zF5t"),l=i("Do8I"),r=i("Vobf"),c=i("z0WU");function d(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var h={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.editRole(scope.row,scope.$index)">编辑</el-button>\n      \t\t\t\t\t\t\t<el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.menuRole(scope.row,scope.$index)">菜单权限</el-button>\n      \t\t\t\t\t\t\t<el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.btnRole(scope.row,scope.$index)">按钮权限</el-button>\n      \t\t\t\t\t\t\t<el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.assign(scope.row,scope.$index)">分配用户</el-button>\n      \t\t\t\t\t</div>\n    \t\t\t\t</el-table-column>'},u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" :disabled="colConfig.isSingle && scope.row.isdisable===\'0\'" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},g={data:function(){var e;return d(e={guid:"",searchList:[{label:"角色编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"角色编码"},{label:"角色名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"角色名称"},{label:"是否启用",type:"select",ruleType:"string",mapKey:"isdisable",configs:{clearable:!0,name:"",options:[{value:"1",label:"是"},{value:"0",label:"否"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},propName:"role",userInfo:null,pageData:{},currentpage:1,selectList:[],hideTime:500,dynaHeight:40,clientHeight:0,dynaHeightTimer:null,dynaHeightState:null,formData:{code:"",name:"",isdisable:""},topBarBtnList:[{name:"查询",icon:"search",method:this.queryRole},{name:"重置",icon:"refresh",plain:!0,method:this.resetQuery}],contentBarBtnList:[{name:"新增",icon:"add",method:this.addRole},{name:"导入",icon:"import",method:this.importRole},{name:"导出",nameEn:"export",isShow:!0,icon:"export",method:this.exportExcel},{name:"删除",icon:"delete",plain:!0,state:!0,method:this.deleteRole}],tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:h,editRole:this.editRole,menuRole:this.menuRole,btnRole:this.btnRole,assign:this.assign},tableConfigs:{titleList:[],showCheckBox:!0,showIndex:!1,isSingle:!1},tableData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},addDictionaryData:{pid:"",id:"",name:""},dialogFormVisible:!1,dialogStatus:"",textMap:{update:"编辑",create:"新增"},temp:{userId:"",userType:"",name:"",companyId:"",remark:""},rules:{name:[{required:!0,message:"请填写名称",trigger:"change"}]},treeData:[],menuRoleLoading:!0,dialogMenuVisible:!1,menuRoleBtnList:[{name:"清空",icon:"refresh",plain:!0,state:!0,method:this.emptyMenuRole}],menuRoleData:"",menuRoleTreeConfigs:{propName:"route",showCheckBox:!0,defaultProps:{children:"children",label:"url"}},menuRoleTree:[],checkedList:[],menuRoleCheckedList:[],roleID:"",btnPropName:"",dialogBtnVisible:!1,isIndeterminate:!1,btnCheckAll:!1,checkedDialogBtns:[],dialogBtns:[],btnRoleTreeConfigs:{propName:"route"},btnRoleTree:[],btnCheckedList:[],btnRoleLoading:!1,dialogCheckboxLoading:!1,menuNodeData:null,dialogAssignVisible:!1,transferData:[],transferSelectedData:[],renderFunc:function(e,t){return e("span",{style:"display: inline-block;width: 100%;"},[e("span",{style:"display: inline-block;width: 20%;text-align: center;"},[t.index]),e("span",{style:"display: inline-block;width: 39%;text-align: center;"},[t.userCode]),e("span",{style:"display: inline-block;width: 39%;text-align: center;"},[t.userName])])},assignLoading:!1,assignTree:[],assignTreeConfigs:{showSearch:!0},assignCheckedList:[],assignData:null,assignFilterText:"",dialogAssignChecked:!1,clickArrow:!1,defaultProps:{children:"children",label:"url"},transferProps:{key:"id",label:"userName",code:"userCode",disabled:"isdisable",index:"index"},initConfigs:{}},"tableData",[]),d(e,"configs",{topBarBtnList:[{name:"add",icon:"add",method:this.addNew},{name:"delete",icon:"delete",plain:!0,state:!0,method:this.deleteBatch}],tableConfigs:[],showCheckBox:!1,showIndex:!1}),d(e,"tempQuery",{}),d(e,"tempLable",{name:""}),d(e,"rules",{name:[{required:!0,message:"请填写名称",trigger:"change"}]}),e},components:{searchBar:a.a},beforeCreate:function(){},created:function(){this.userInfo=this.$storage.get("userInfo"),this.initButtons(),this.httpListPageRoles(),this.dynaHeightState=this.$storage.get("dynaHeightState")||"1",this.dynaHeightState-0||(this.dynaHeight=0)},beforeMount:function(){},mounted:function(){this.clientHeight=this.$el.clientHeight},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(e){this.tempQuery=e,this.httpListPageRoles()},sendGuid:function(e){this.guid=e},initButtons:function(){var e=this;e.$loading({spinner:"none",text:"智 造 云 管 家"});var t=e.$storage.get("userInfo").roleIds,i=e.$storage.get("menuId");t&&Object(r.initMenuButtons)({menuId:i,roleId:t}).then(function(t){var i=t.buttonList;i&&i.forEach(function(t){if(e.initConfigs&&e.initConfigs.tableOperates)for(var i in e.initConfigs.tableOperates)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e.initConfigs.tableOperates[i]=!1);if(e.customColumn)for(var n in e.customColumn)if(n){var s=e.customColumn[n];s.length>0&&s.forEach(function(e){if(e)for(var i in e)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e[i]=!1)})}e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){e.$loading().close()})},httpListPageRoles:function(){var e=this;Object(o.listPageRoles)(e.tempQuery).then(function(t){e.getListPage(t),e.$loading().close()}).catch(function(e){})},queryRole:function(){var e=this;Object(o.listPageRoles)(e.tempQuery).then(function(t){e.getListPage(t),e.$loading().close()}).catch(function(e){})},addRole:function(){var e=this;this.resetTemp(),this.dialogStatus="create",this.dialogFormVisible=!0,this.$nextTick(function(){e.$refs[e.propName+"Dialog"].clearValidate()})},createData:function(){var e=this;e.$refs[this.propName+"Dialog"].validate(function(t){t&&(e.temp.userId=e.userInfo.userId,e.temp.userType=e.userInfo.userType,e.temp.companyId=e.userInfo.companyId,e.dialogFormVisible=!0,e.httpAddRole(e.temp))})},httpAddRole:function(e){var t=this;Object(o.addRole)(e).then(function(e){0===e.code&&(t.dialogFormVisible=!1,t.$notify({title:"成功",message:"创建成功",type:"success",duration:1e3,onClose:function(){t.httpListPageRoles()}}))}).catch(function(e){})},importRole:function(){},deleteRole:function(){var e="";this.selectList.forEach(function(t){e+=t.id+","}),e=e.slice(0,e.length-1),this.httpDeleteRoles({ids:e})},httpDeleteRoles:function(e,t){var i=this;Object(o.deleteRoles)(e).then(function(e){i.selectList=[],0===e.code&&i.$notify({title:"成功",message:"删除成功",type:"success",duration:1e3,onClose:function(){t||i.httpListPageRoles()}}),i.$loading().close()}).catch(function(e){})},editRole:function(e,t){var i=this;this.resetTemp(),this.temp=JSON.parse(JSON.stringify(e)),this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){i.$refs[i.propName+"Dialog"].clearValidate()})},updateData:function(){var e=this;e.$refs[this.propName+"Dialog"].validate(function(t){if(t){var i={companyId:e.temp.companyId,id:e.temp.id,name:e.temp.name,remark:e.temp.remark};e.httpUpdateRole(i,!0)}})},httpUpdateRole:function(e,t){var i=this;Object(o.updateRole)(e).then(function(e){0===e.code&&(i.dialogFormVisible=!1,i.$loading().close(),i.$notify({title:"成功",message:"修改成功",type:"success",duration:1e3,onClose:function(){i.httpListPageRoles()}}))}).catch(function(e){})},changeRoleState:function(e,t){this.httpUpdateRoleDisable(e)},httpUpdateRoleDisable:function(e){var t=this;Object(o.updateRoleDisable)({id:e.id,isdisable:e.isdisable}).then(function(e){t.$loading().close(),t.$notify({title:"成功",message:"修改成功",type:"success",duration:1e3})}).catch(function(t){"0"===e.isdisable?e.isdisable="1":e.isdisable="0"})},menuRole:function(e,t){var i=this.$storage.get("userInfo").roleIds,n=this.$storage.get("userInfo").userType;this.menuRoleData=e,this.roleID=e.id,this.menuRoleTree=[],this.checkedList=[],this.menuRoleLoading=!0,this.dialogMenuVisible=!0,this.httpTreeRoleMeunsAll({userRoleId:i,userType:n,roleIds:e.id})},httpTreeRoleMeunsAll:function(e){var t=this;Object(o.treeRoleMeunsAll)(e).then(function(e){t.menuRoleLoading=!1,0===e.code&&(t.menuRoleTree=JSON.parse(e.result),t.filterBindRole(t.menuRoleTree))}).catch(function(e){})},saveMenuRole:function(){var e=this.$refs.menuRoleTree.$children[0].getHalfCheckedKeys();if(this.menuRoleCheckedList=this.menuRoleCheckedList.concat(e),this.menuRoleCheckedList.length){var t="";this.menuRoleCheckedList.forEach(function(e){t+=e+","}),t=t.slice(0,t.length-1),this.httpSaveRoleMeuns({roleID:this.roleID,meunIds:t})}else this.$message({message:"请选择菜单",type:"error",duration:1e3})},httpSaveRoleMeuns:function(e){var t=this,i=this;Object(o.saveRoleMeuns)(e).then(function(e){0===e.code&&(i.$loading().close(),i.$notify({title:"成功",message:"设置成功",type:"success",duration:1e3}),t.dialogMenuVisible=!1)}).catch(function(e){})},emptyMenuRole:function(){this.$refs.menuRoleTree.$children[0].setCheckedKeys([],!0),this.menuRoleCheckedList=[],this.checkedList=[]},menuRoleTreeDataBridge:function(e){e.checkedKeys&&(this.menuRoleCheckedList=e.checkedKeys)},filterBindRole:function(e){var t=this;e.forEach(function(e,i){e.isBindRole&&(e.children&&e.children.length?(t.checkChildBindRole(e.children)&&t.checkedList.push(e.id),t.filterBindRole(e.children)):t.checkedList.push(e.id))}),t.menuRoleCheckedList=t.checkedList},checkChildBindRole:function(e){var t=0,i=!1;return e.forEach(function(n){n.isBindRole&&t++,t===e.length&&(i=!0)}),i},btnRole:function(e,t){this.menuNodeData=null,this.btnPropName="",this.dialogBtns=[],this.btnRoleTree=[],this.btnCheckedList=[],this.menuRoleData=e,this.dialogBtnVisible=!0,this.btnRoleLoading=!0,this.httpTreeRoleMeunsSelected({roleIds:e.id})},httpTreeRoleMeunsSelected:function(e){var t=this;Object(o.treeRoleMeunsSelected)(e).then(function(e){0===e.code&&(e.result=JSON.parse(e.result),t.btnRoleTree=e.result,t.btnRoleLoading=!1)}).catch(function(e){})},contains:function(e,t){for(var i=e.length;i--;)if(e[i]===t)return!0;return!1},saveBtnRole:function(){var e=this,t="";this.dialogBtns.forEach(function(i){e.contains(e.checkedDialogBtns,i.id)||(t=0==t.length?i.id:t+","+i.id)}),this.httpSaveRoleMeunsButtons({menuId:this.menuNodeData.id,roleID:this.menuRoleData.id,buttonIds:t})},httpSaveRoleMeunsButtons:function(e){var t=this,i=this;Object(o.saveRoleMeunsButtons)(e).then(function(e){i.$loading().close(),i.dialogCheckboxLoading=!0,Object(o.listRoleMeunsButtonsAll)({roleIds:i.menuRoleData.id,menuId:i.menuNodeData.id}).then(function(e){i.resetBtnDialogData(),e.result=JSON.parse(e.result),i.dialogBtns=e.result,i.checkedDialogBtns=i.getCheckedDialogBtns(e.result),i.dialogCheckboxLoading=!1,i.$notify({title:"成功",message:"设置成功",type:"success",duration:1e3}),t.dialogBtnVisible=!1}).catch(function(e){})}).catch(function(e){})},getCheckedDialogBtns:function(e){var t=[];return e.forEach(function(e){"1"===e.isBindRole&&t.push(e.id)}),t},resetBtnDialogData:function(){this.btnCheckAll=!1,this.dialogBtns=[],this.dialogCheckboxLoading=!0,this.isIndeterminate=!1,this.checkedDialogBtns=[]},btnRoleTreeDataBridge:function(e){e.nodeData.url!==this.btnPropName&&(this.btnPropName=e.nodeData.url,this.resetBtnDialogData(),this.menuNodeData=e.nodeData,this.httpListRoleMeunsButtonsAll({roleIds:this.menuRoleData.id,menuId:e.nodeData.id}))},httpListRoleMeunsButtonsAll:function(e){var t=this;Object(o.listRoleMeunsButtonsAll)(e).then(function(e){0===e.code&&(e.result=JSON.parse(e.result),t.dialogBtns=e.result,t.checkedDialogBtns=t.getCheckedDialogBtns(e.result),t.dialogCheckboxLoading=!1)}).catch(function(e){t.dialogCheckboxLoading=!1})},handleCheckAllChange:function(e){this.checkedDialogBtns=e?this.filterBtnNameEn(this.dialogBtns):[],this.isIndeterminate=!1},filterBtnNameEn:function(e){var t=[];return e.length&&e.forEach(function(e){t.push(e.id)}),t},handleCheckedDialogBtnsChange:function(e){var t=e.length;this.btnCheckAll=t===this.dialogBtns.length,this.isIndeterminate=t>0&&t<this.dialogBtns.length},resetAssignData:function(){this.assignData=null,this.assignFilterText="",this.dialogAssignChecked=!1,this.assignLoading=!1,this.assignTree=[],this.transferData=[],this.transferSelectedData=[]},assign:function(e,t){this.resetAssignData(),this.dialogAssignVisible=!0,this.assignLoading=!0,this.assignData=e,this.$nextTick(function(){if(!document.getElementsByClassName("customTitle").length)for(var e=document.getElementsByClassName("el-transfer-panel__filter"),t=0;t<e.length;t++){var i=(new(s.a.extend({template:'<div class="customTitle" style="box-sizing: border-box;padding: 5px 0 5px 41px;height: 25px;box-shadow:0 3px 5px -3px rgba(0,0,0,0.3);">\n                          <span style="display: inline-block;width: 100%;">\n                          <span style="display: inline-block;width: 20%;text-align: center;">序号</span>\n                          <span style="display: inline-block;width: 37%;text-align: center;">账号</span>\n                          <span style="display: inline-block;width: 38%;text-align: center;">姓名</span>\n                          </span>\n                        </div>'}))).$mount(),n=e[t],a=n.parentNode,o=n.nextSibling;o?a.insertBefore(i.$el,o):a.appendChild(i.$el)}}),this.httpTreeDepartments({isdisable:"1"});var i=this.$storage.get("userInfo").companyId;this.assignTreeDataBridge({id:i})},httpTreeDepartments:function(e){var t=this;Object(l.treeDepartments)(e).then(function(e){t.assignTree=[e.result.treeList],t.$nextTick(function(e){t.$refs.assignTree.setCurrentKey(t.assignTree[0].id)})}).catch(function(e){t.assignLoading=!1})},handleChange:function(e,t,i){},assignTreeDataBridge:function(e){var t=this;t.transferData=[],t.transferSelectedData=[];var i={deptId:e.id,roleId:t.assignData.id},n={roleId:t.assignData.id};t.$axios.all([Object(o.listUsersByRole)(n),Object(o.listAllUsersByDeptId)(i)]).then(t.$axios.spread(function(e,i){var n=Object(c.n)(e.result.varList.concat(i.result.varList));n.forEach(function(e,t){e.index=t+1}),t.transferData=n,t.transferSelectedData=t.assignFilterKey(e.result.varList),t.$loading().close(),t.assignLoading=!1})).catch(function(e){t.$loading().close(),t.assignLoading=!1})},assignFilterKey:function(e){var t=[];return e.forEach(function(e){t.push(e.id)}),t},assignFilterNode:function(e,t){return!e||-1!==t.name.indexOf(e)},saveUsersByRole:function(){this.httpSaveRoleUsers()},httpSaveRoleUsers:function(){var e=this;Object(o.saveRoleUsers)({roleId:e.assignData.id,userIds:Object(c.j)(e.transferSelectedData)}).then(function(t){e.$loading().close(),e.dialogAssignVisible=!1,e.$notify({title:"成功",message:"保存成功",type:"success",duration:1e3})}).catch(function(e){})},getListPage:function(e){if(e){e.result.titles=JSON.parse(e.result.titles),e.result.varList=JSON.parse(e.result.varList),e.result.pageData=JSON.parse(e.result.pageData);var t=Object(c.k)(e.result),i=this.addTableTitle(t);this.tableConfigs.titleList=i,this.pageData=e.result.pageData,this.tableConfigs.showCheckBox=!0,this.tableConfigs.showIndex=!0,this.tableData=e.result.varList}},addTableTitle:function(e){var t=this;return e.forEach(function(e){"isdisable"===e.enLabel&&(e.component=u,e.changeState=t.changeRoleState,e.isPropName=!!t.propName)}),e.push(t.tableOperates),e},dataBridge:function(e){this.selectList=e,e.length?(this.contentBarBtnList[2].state=!1,this.contentBarBtnList[3].state=!1):(this.contentBarBtnList[2].state=!0,this.contentBarBtnList[3].state=!0)},addNew:function(){var e=this;this.resetTemp(),this.dialogStatus="create",this.dialogFormVisible=!0,this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},resetTemp:function(){this.temp={userId:"",userType:"",name:"",companyId:"",remark:""}},exportExcel:function(){var e="",t=this;null!=t.selectList&&t.selectList.length>0&&t.selectList.forEach(function(t){e=e+t.id+","}),Object(o.exportExcelRoles)(e).then(function(e){e&&(Object(c.d)(e,"组织管理导出.xls"),t.$message({title:"成功",message:"导出成功",type:"success",duration:2e3}))}).catch(function(e){})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},watch:{currentpage:function(){},selectList:function(){this.contentBarBtnList[2].state=this.selectList.length<1,this.contentBarBtnList[3].state=this.selectList.length<1},menuRoleCheckedList:function(){this.menuRoleBtnList[0].state=this.menuRoleCheckedList.length<1},dialogAssignChecked:function(){},assignFilterText:function(e){this.$refs.assignTree.filter(e)}}},p=(i("r94G"),i("KHd+")),f=Object(p.a)(g,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"roleManage"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[e._l(e.contentBarBtnList,function(e){return[i("base-button",{attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.tableConfigs.titleList,showCheckBox:e.tableConfigs.showCheckBox,showIndex:e.tableConfigs.showIndex,propName:e.propName,pageData:e.pageData,currentpage:e.currentpage,isSingle:e.tableConfigs.isSingle},on:{"update:currentpage":function(t){e.currentpage=t},databridge:e.dataBridge}})],1)],1)])],1),e._v(" "),i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.textMap[e.dialogStatus],visible:e.dialogFormVisible,width:"440px",center:"true"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[i("el-form",{ref:e.propName+"Dialog",staticStyle:{width:"400px",margin:"20px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"left","label-width":"80px"}},[i("el-form-item",{attrs:{label:"角色名称",prop:"name"}},[i("el-input",{model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name",t)},expression:"temp.name"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"备注",prop:"remark"}},[i("el-input",{attrs:{type:"textarea",rows:2},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},["create"==e.dialogStatus?i("el-button",{attrs:{type:"primary"},on:{click:e.createData}},[e._v("保 存")]):i("el-button",{attrs:{type:"primary"},on:{click:e.updateData}},[e._v("保 存")]),e._v(" "),i("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("关 闭")])],1)],1),e._v(" "),i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:"菜单权限",visible:e.dialogMenuVisible,width:"340px",center:"true"},on:{"update:visible":function(t){e.dialogMenuVisible=t}}},[i("div",{staticStyle:{"box-sizing":"border-box",padding:"10px"}},[i("base-button",{attrs:{name:e.menuRoleBtnList[0].name,icon:e.menuRoleBtnList[0].icon,plain:e.menuRoleBtnList[0].plain,state:e.menuRoleBtnList[0].state},on:{myclick:e.menuRoleBtnList[0].method}}),e._v(" "),i("span",[e._v(" 当前角色 :"),i("span",{staticStyle:{color:"#409EFF","font-weight":"bold"}},[e._v(" "+e._s(e.menuRoleData.name))])])],1),e._v(" "),i("div",{staticStyle:{"box-sizing":"border-box",padding:"10px",overflow:"auto"},style:e.menuRoleTree.length?"height: 400px":""},[i("base-tree",{directives:[{name:"loading",rawName:"v-loading",value:e.menuRoleLoading,expression:"menuRoleLoading"}],ref:"menuRoleTree",attrs:{data:e.menuRoleTree,treeConfigs:e.menuRoleTreeConfigs,propName:e.menuRoleTreeConfigs.propName,checkedList:e.checkedList},on:{treedatabridge:e.menuRoleTreeDataBridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveMenuRole}},[e._v("保 存")]),e._v(" "),i("el-button",{on:{click:function(t){e.dialogMenuVisible=!1}}},[e._v("关 闭")])],1)]),e._v(" "),i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:"按钮权限",visible:e.dialogBtnVisible,width:"850px"},on:{"update:visible":function(t){e.dialogBtnVisible=t}}},[i("div",{staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{position:"relative",height:"100%",overflow:"hidden"},attrs:{span:6}},[i("div",{staticStyle:{position:"absolute",top:"-10px",bottom:"-10px",left:"0",right:"5px","background-color":"#EBF0F6","box-shadow":"5px 0 10px -5px rgba(0,0,0,0.3)","box-sizing":"border-box",padding:"20px 0"}},[i("base-tree",{directives:[{name:"loading",rawName:"v-loading",value:e.btnRoleLoading,expression:"btnRoleLoading"}],ref:"btnRoleTree",attrs:{data:e.btnRoleTree,treeConfigs:e.btnRoleTreeConfigs,propName:e.btnRoleTreeConfigs.propName,checkedList:e.btnCheckedList},on:{treedatabridge:e.btnRoleTreeDataBridge}})],1)]),e._v(" "),i("el-col",{staticStyle:{height:"100%"},attrs:{span:18}},[i("div",{staticStyle:{height:"50px","box-sizing":"border-box",padding:"7px 20px 7px 0"}},[i("el-checkbox",{attrs:{border:"",indeterminate:e.isIndeterminate,disabled:!e.dialogBtns.length},on:{change:e.handleCheckAllChange},model:{value:e.btnCheckAll,callback:function(t){e.btnCheckAll=t},expression:"btnCheckAll"}},[e._v("全选\n          ")]),e._v(" "),i("span",[e._v(" 当前角色 :"),i("span",{staticStyle:{color:"#409EFF","font-weight":"bold"}},[e._v(" "+e._s(e.menuRoleData.name))])])],1),e._v(" "),i("div",{staticStyle:{height:"calc(100% - 110px)","box-sizing":"border-box",padding:"7px 20px 7px 0"}},[i("el-checkbox-group",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogCheckboxLoading,expression:"dialogCheckboxLoading"}],on:{change:e.handleCheckedDialogBtnsChange},model:{value:e.checkedDialogBtns,callback:function(t){e.checkedDialogBtns=t},expression:"checkedDialogBtns"}},e._l(e.dialogBtns,function(t){return i("el-checkbox",{key:t.id,attrs:{label:t.id,disabled:"0"===t.isdisable,border:""},model:{value:"1"===t.isBindRole,callback:function(i){e.$set(t,"isBindRole === '1'",i)},expression:"item.isBindRole === '1'"}},[e._v(e._s(t.name)+"\n            ")])}),1),e._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:!e.dialogBtns.length,expression:"!dialogBtns.length"}],staticStyle:{"text-align":"center"}},[e._v("请选择左侧菜单")])],1),e._v(" "),i("div",{staticClass:"showLine",staticStyle:{position:"relative",height:"60px","text-align":"center","box-sizing":"border-box",padding:"10px 0 0 0"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveBtnRole}},[e._v("保 存")]),e._v(" "),i("el-button",{staticStyle:{"margin-left":"30px"},on:{click:function(t){e.dialogBtnVisible=!1}}},[e._v("关 闭")])],1)])],1)]),e._v(" "),i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:"分配用户",visible:e.dialogAssignVisible,width:"850px",center:"true"},on:{"update:visible":function(t){e.dialogAssignVisible=t}}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.assignLoading,expression:"assignLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{position:"relative",height:"100%",overflow:"hidden"},attrs:{span:6}},[i("div",{staticStyle:{position:"absolute",top:"-10px",bottom:"-10px",left:"0",right:"5px","background-color":"#EBF0F6","box-shadow":"5px 0 10px -5px rgba(0,0,0,0.3)","box-sizing":"border-box",padding:"10px 0"}},[i("div",{staticClass:"leftTree",staticStyle:{height:"100%","padding-top":"10px"}},[i("el-input",{attrs:{placeholder:"",clearable:""},model:{value:e.assignFilterText,callback:function(t){e.assignFilterText=t},expression:"assignFilterText"}},[i("i",{staticClass:"el-input__icon el-icon-search",attrs:{slot:"suffix"},slot:"suffix"})]),e._v(" "),i("div",{staticClass:"checkBox"},[i("el-checkbox",{model:{value:e.dialogAssignChecked,callback:function(t){e.dialogAssignChecked=t},expression:"dialogAssignChecked"}},[e._v("显示封存部门")])],1),e._v(" "),i("div",{staticClass:"treeView",staticStyle:{height:"calc(100% - 85px)",overflow:"auto"}},[i("el-tree",{ref:"assignTree",attrs:{"highlight-current":"","default-expand-all":"","node-key":"id","expand-on-click-node":e.clickArrow,data:e.assignTree,props:e.defaultProps,"filter-node-method":e.assignFilterNode},on:{"node-click":e.assignTreeDataBridge},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.node,s=t.data;return i("span",{staticClass:"custom-tree-node"},[e.treeConfigs.showIcons?i("svg-icon",{staticStyle:{"margin-right":"5px"},attrs:{"icon-class":s.url}}):e._e(),e._v(" "),n.label?i("span",[e._v(e._s(n.label))]):i("span",[e._v(e._s(s.name))])],1)}}])})],1)],1)])]),e._v(" "),i("el-col",{staticStyle:{height:"100%"},attrs:{span:18}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px 0"}},[i("div",{staticStyle:{"text-align":"center"}},[i("el-transfer",{staticStyle:{"text-align":"left",display:"inline-block"},attrs:{filterable:"",props:e.transferProps,"left-default-checked":[],"right-default-checked":[],"render-content":e.renderFunc,titles:["未分配用户","已分配用户"],format:{noChecked:"${total}",hasChecked:"${checked}/${total}"},data:e.transferData},on:{change:e.handleChange},model:{value:e.transferSelectedData,callback:function(t){e.transferSelectedData=t},expression:"transferSelectedData"}})],1)]),e._v(" "),i("div",{staticStyle:{position:"relative",height:"60px","text-align":"center","box-sizing":"border-box",padding:"10px 0 0 0"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveUsersByRole}},[e._v("保 存")]),e._v(" "),i("el-button",{staticStyle:{"margin-left":"30px"},on:{click:function(t){e.dialogAssignVisible=!1}}},[e._v("关 闭")])],1)])],1)])],1)},[],!1,null,null,null);f.options.__file="index.vue";t.default=f.exports},r94G:function(e,t,i){"use strict";var n=i("Fo9U");i.n(n).a}}]);