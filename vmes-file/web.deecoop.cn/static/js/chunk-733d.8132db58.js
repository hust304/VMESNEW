(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-733d"],{KLid:function(e,t,a){"use strict";var i=a("wW4B");a.n(i).a},SQ3A:function(e,t,a){},cVzj:function(e,t,a){"use strict";var i=a("SQ3A");a.n(i).a},qBmv:function(e,t,a){"use strict";a.r(t);a("yt8O"),a("RW0V"),a("pIFo"),a("Oyvg"),a("f3/d"),a("rGqo");var i=a("mSNy"),l=a("uTIz"),s=a("73Xj"),o=a("Vobf"),n=a("yvbL"),r=(a("5W5M"),a("zF5t"),a("z0WU"));function c(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{},i=Object.keys(a);"function"==typeof Object.getOwnPropertySymbols&&(i=i.concat(Object.getOwnPropertySymbols(a).filter(function(e){return Object.getOwnPropertyDescriptor(a,e).enumerable}))),i.forEach(function(t){p(e,t,a[t])})}return e}function p(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}var d={props:["colConfig","fixed"],template:'<el-table-column :label="colConfig.label" :fixed="fixed" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.editBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editBtns(scope.row,scope.$index)">编辑</el-button>\n      \t\t\t\t\t</div>\n    \t\t\t\t</el-table-column>'},m={props:["colConfig","fixed"],template:'<el-table-column :label="colConfig.label" :fixed="fixed" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},h={data:function(){var e=this;return{guid:"",searchList:[{label:"员工编号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"员工编号"},{label:"员工姓名",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"员工姓名"},{label:"是否主岗",type:"select",ruleType:"string",mapKey:"isplurality",configs:{clearable:!0,name:"",options:[{value:"0",label:"是"},{value:"1",label:"否"}]},placeholder:"请选择"},{label:"是否在职",type:"select",ruleType:"string",mapKey:"isdisableByQuery",configs:{clearable:!0,name:"",options:[{value:"1",label:"是"},{value:"0",label:"否"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!1,userInfo:null,filterTextDept:"",enterTime:0,showDisableDept:!1,treeNodes:[],imageUrl:"",hideTime:700,dynaHeight:40,clientHeight:0,dynaHeightTimer:null,dynaHeightState:null,initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:d,editBtns:this.editBtns,editBtns_isShow:!0}},configs:{queryBarBtnList:[{name:"查询",nameEn:"query",isShow:!0,icon:"search",method:this.queryTable},{name:"重置",nameEn:"reset",isShow:!0,icon:"refresh",plain:!0,method:this.resetQueryTemp}],topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.addNew},{name:"删除",nameEn:"delete",isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteBatch},{name:"开通账号",nameEn:"openCode",isShow:!0,icon:"add",plain:!0,state:!0,method:this.showOpenCode},{name:"岗位变更",nameEn:"changePost",isShow:!0,icon:"edit",plain:!0,state:!0,method:this.dialogCallBack,dialog:{enable:!0,data:{isSingle:!0,key:"deptId",employeeList:null,timeStamp:""},dialogName:"dialogPost"}},{name:"新增兼岗",nameEn:"pluralityPost",isShow:!0,icon:"edit",plain:!0,state:!0,method:this.dialogCallBack,dialog:{enable:!0,data:{isSingle:!1,key:"deptId",employeeList:null,timeStamp:""},dialogName:"dialogPost"}},{name:"导出",nameEn:"export",isShow:!0,icon:"export",method:this.exportExcel},{name:"导入",nameEn:"import",isShow:!0,icon:"import",method:this.importExcelCallBack,dialog:{enable:!0,data:{exportUrl:"/fileUpload/excelTemplet/EmployeeBySimpleExcelImport.xlsx",importUrl:"/system/employee/importExcelEmployeeBySimple"},dialogName:"dialogImportExcel"}}],tableConfigs:[],showCheckBox:!1,showIndex:!1},timeStamp:"",tableData:[],selectList:null,treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1,showSearch:!0,showDisable:!1},selectTree:{pid:"",id:"",name:""},dialogFormOpenCode:!1,isShowOpenUserCheckbox:!1,openUserChecked:!1,isShowRole:!1,dialogFormVisible:!1,dialogStatus:"",textMap:{update:"编辑菜单",create:"新增菜单"},fileData:{photoDir:"employee/"},temp:{},tempQuery:{},tempLable:{},tempNotEditable:{},rules:{name:[{required:!0,message:"请填写员工姓名",trigger:"change"}],sex:[{required:!0,message:"请填写性别",trigger:"change"}],roleName:[{required:!0,trigger:"change",validator:function(t,a,i){e.roleData.defaultSelected.length<=0?i(new Error("请选择角色")):i()}}],email:[{type:"email",message:"请输入正确的邮箱地址",trigger:["blur","change"]}],mobile:[{required:!0,message:"请填写手机号",trigger:"blur"},{type:"number",trigger:["blur","change"],validator:function(e,t,a){!t||/^[1][34578]\d{9}$/.test(t)&&/^[1-9]\d*$/.test(t)&&11===t.length?a():a(new Error("手机号码不符合规范"))}}]},OpenCodeRules:{},pageData:null,pageNo:1,props:{value:"value",label:"label",children:"childrens"},politicalData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"political",isglobal:"0"}},defaultSelected:["ebb2eae0e5c3479aa1b19a9251917077"]},roleData:{data:{selectUrl:"/system/role/getRoles",selectParm:{queryStr:""}},defaultSelected:[]}}},components:{searchBar:l.a},beforeCreate:function(){},created:function(){this.userInfo=this.$storage.get("userInfo"),this.initButtons(),this.initTree(),this.dynaHeightState=this.$storage.get("dynaHeightState")||"1",this.dynaHeightState-0||(this.dynaHeight=0)},beforeMount:function(){},mounted:function(){this.clientHeight=this.$el.clientHeight},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(e){this.tempQuery=e,this.pageNo=1,this.initTable(this.selectTree.id,this.selectTree.type,this.selectTree.layer,null)},sendGuid:function(e){this.guid=e},initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,a=e.$storage.get("menuId");t&&(e.$loading({spinner:"preloader",text:""}),Object(o.initMenuButtons)({menuId:a,roleId:t}).then(function(t){var a=t.buttonList;a&&a.forEach(function(t){if(e.initConfigs&&e.initConfigs.tableOperates)for(var a in e.initConfigs.tableOperates)a.indexOf(t.nameEn)>=0&&a.indexOf("isShow")>0&&(e.initConfigs.tableOperates[a]=!1);if(e.customColumn)for(var i in e.customColumn)if(i){var l=e.customColumn[i];l.length>0&&l.forEach(function(e){if(e)for(var a in e)a.indexOf(t.nameEn)>=0&&a.indexOf("isShow")>0&&(e[a]=!1)})}e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){e.$loading().close()}))},disableState:function(e){this.initTree(e,!0)},initTree:function(e,t){var a=this,i="1",l="1";e&&(i="",l=""),Object(n.treeDeptPosts)({postDisable:i,deptDisable:l,deptID:a.userInfo.companyId}).then(function(e){var i=[],l=e.result.treeList;a.selectTree={pid:l.pid,id:l.id,name:l.name,type:l.type,layer:l.layer,deptName:l.deptName,postName:l.postName},i.push(l),a.treeData=i,a.treeNodes=[],a.$nextTick(function(){if(a.treeNodes.length>0){var e=a.treeNodes[0];a.selectTree={pid:e.pid,id:e.id,name:e.name,type:e.type,layer:e.layer,deptName:e.deptName,postName:e.postName}}t||a.initTable(a.selectTree.id,a.selectTree.type,a.selectTree.layer,!0)})}).catch(function(e){a.$loading().close()})},treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,name:e.nodeData.name,type:e.nodeData.type,layer:e.nodeData.layer,deptName:e.nodeData.deptName,postName:e.nodeData.postName},this.pageNo=1,this.initTable(this.selectTree.id,this.selectTree.type,this.selectTree.layer)},queryTable:function(){this.pageNo=1,this.initTable(this.selectTree.id,this.selectTree.type,this.selectTree.layer)},initTable:function(e,t,a,i){var l=this;Object(s.listPageEmployees)(c({},l.tempQuery,{id:e,type:t,layer:a,dataType:this.$storage.get("dataType"),pageNo:l.pageNo})).then(function(e){i&&l.$loading().close(),l.getListPage(e)}).catch(function(e){l.$loading().close()})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(r.o)(e.result),a=this.addTableTitle(t);this.configs.tableConfigs=a,this.configs.showCheckBox=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var a in e){var l=e[a];l.indexOf("_")>0&&("en"==i.a.locale?l=l.substring(l.indexOf("_")+1):"zh"==i.a.locale&&(l=l.substring(0,l.indexOf("_")))),t.tempLable[a]=l,t.tempNotEditable[a]=!1}})},addTableTitle:function(e){var t=this;return e.forEach(function(e){var a=e.label;a.indexOf("_")>0&&("en"==i.a.locale?e.label=a.substring(a.indexOf("_")+1):"zh"==i.a.locale&&(e.label=a.substring(0,a.indexOf("_")))),"是否在职"===e.label&&(e.component=m,e.changeState=t.changeState)}),t.internationalConfig(),e.push(t.initConfigs.tableOperates),e},internationalConfig:function(){"en"==i.a.locale?(this.initConfigs.tableOperates.label="OPERATE",this.textMap.create="Add",this.textMap.update="Edit",this.textMap.OpenCode="OpenUserCode"):"zh"==i.a.locale&&(this.initConfigs.tableOperates.label="操作",this.textMap.create="新增",this.textMap.update="编辑",this.textMap.OpenCode="开通账号")},changeState:function(e,t){Object(s.updateDisableEmployee)(e.id,e.employeeId,e.userId,e.isdisable).then(function(e){}).catch(function(t){"0"==e.isdisable&&(e.isdisable="1")})},dataBridge:function(e){var t=this;t.selectList=e,t.configs.topBarBtnList.forEach(function(t){"changePost"!=t.nameEn&&"pluralityPost"!=t.nameEn||(t.dialog.data.employeeList=e,t.dialog.data.timeStamp=(new Date).getTime())}),e.length?t.configs.topBarBtnList.forEach(function(e){"delete"!=e.nameEn&&"changePost"!=e.nameEn&&"pluralityPost"!=e.nameEn||(e.state=!1),"openCode"==e.nameEn&&t.selectList.forEach(function(t){var a=t.userId;null!=a&&a.trim().length>0?e.state=!0:"1"!=t.isOpenUser&&(e.state=!1)})}):t.configs.topBarBtnList.forEach(function(e){"delete"!=e.nameEn&&"changePost"!=e.nameEn&&"pluralityPost"!=e.nameEn&&"openCode"!=e.nameEn||(e.state=!0)})},showOpenCode:function(){var e=this,t=this.selectTree.type;"dept"==t?(this.temp.deptId=this.selectTree.id,this.temp.deptName=this.selectTree.deptName):"post"==t&&(this.temp.deptId=this.selectTree.pid,this.temp.deptName=this.selectTree.deptName,this.temp.postId=this.selectTree.id,this.temp.postName=this.selectTree.postName),this.temp.deptId&&(this.roleData.data={selectUrl:"/system/role/getRoles",selectParm:{queryStr:"(company_id = (select case when id_1 is null or id_1 = '' then id_0 else id_1 end from vmes_department where  id = '"+this.temp.deptId+"')    )"}}),this.roleData.defaultSelected=[],this.dialogStatus="OpenCode",this.dialogFormOpenCode=!0,this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},isMobileNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^1[\\d]{10}").test(e.trim())},checkMobileValue:function(e,t){var a="";return null!=e&&e.trim().length>0&&11!=e.trim().length?a=t+"("+e+")输入错误，请输入11位正确的手机号！":null==e||11!=e.trim().length||this.isMobileNumberByValue(e.trim())||(a=t+"("+e+")输入错误，请输入11位正确的手机号！"),a},checkMobile:function(e){var t=this.checkMobileValue(e,"手机号");null!=t&&t.trim().length>0&&this.$message({type:"warning",duration:5e3,showClose:!0,message:t})},addNew:function(){var e=this;this.resetTemp(),this.temp.uploadUrl="/api//fileIO/file/uploadPhoto",this.isShowOpenUserCheckbox=!0,this.openUserChecked=!0,this.isShowRole=!0,this.tempNotEditable.deptName=!0,this.tempNotEditable.postName=!0,this.temp.deptId="",this.temp.deptName="",this.temp.postId="",this.temp.postName="",this.imageUrl="",this.rules.roleName=[{required:!0,trigger:"change",validator:function(t,a,i){e.roleData.defaultSelected.length<=0?i(new Error("请选择角色")):i()}}];var t=this.selectTree.type;"dept"==t?(this.temp.deptId=this.selectTree.id,this.temp.deptName=this.selectTree.deptName):"post"==t&&(this.temp.deptId=this.selectTree.pid,this.temp.deptName=this.selectTree.deptName,this.temp.postId=this.selectTree.id,this.temp.postName=this.selectTree.postName),"dept"!=t?(this.temp.political=this.politicalData.defaultSelected[0],this.temp.deptId&&(this.roleData.data={selectUrl:"/system/role/getRoles",selectParm:{queryStr:"(company_id = (select case when id_1 is null or id_1 = '' then id_0 else id_1 end from vmes_department where  id = '"+this.temp.deptId+"')    )"}}),this.roleData.defaultSelected=[],this.dialogStatus="create",this.dialogFormVisible=!0,this.$nextTick(function(){e.$refs.submitForm.clearValidate()})):this.$message({showClose:!0,message:"当前节点为部门，请选择正确的岗位！",duration:5e3})},editBtns:function(e,t){var a=this;if(this.resetTemp(),this.temp=JSON.parse(JSON.stringify(e)),this.temp.photo?this.imageUrl="/api/"+this.temp.photo:this.imageUrl="",this.temp.uploadUrl="/api//fileIO/file/uploadPhoto",this.rules.roleName=[{required:!0,trigger:"change",validator:function(e,t,i){a.roleData.defaultSelected.length<=0?i(new Error("请选择角色")):i()}}],this.politicalData.defaultSelected=[],this.politicalData.defaultSelected.push(e.political),this.temp.deptId){var i="";this.temp.roleId&&(i=" or id = '"+this.temp.roleId+"' "),this.roleData.data={selectUrl:"/system/role/getRoles",selectParm:{queryStr:"(company_id = (select case when id_1 is null or id_1 = '' then id_0 else id_1 end from vmes_department where id = '"+this.temp.deptId+"')"+i+")"}}}this.roleData.defaultSelected=[this.temp.roleId],this.isShowOpenUserCheckbox=!1,this.openUserChecked=!1,this.isShowRole=!1,"1"==this.temp.isOpenUser&&(this.isShowRole=!0),this.tempNotEditable.deptName=!0,this.tempNotEditable.postName=!0,this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){a.$refs.submitForm.clearValidate()})},updateData:function(){var e=this,t=this;t.temp.isOpenUser="0",t.openUserChecked&&(t.temp.isOpenUser="1"),t.$refs.submitForm.validate(function(a){if(a){var i=e.temp.mobile,l=e.checkMobileValue(i,"手机号");if(null!=l&&l.trim().length>0)return void e.$message({type:"warning",duration:5e3,showClose:!0,message:l});t.dialogLoading=!0,Object(s.updateEmployeeAndUser)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.dialogFormVisible=!1,t.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),t.refreshTable())}).catch(function(e){t.dialogLoading=!1})}})},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},resetQueryTemp:function(){for(var e in this.tempQuery)this.tempQuery[e]=""},createData:function(){var e=this,t=this;t.temp.isOpenUser="0",t.openUserChecked&&(t.temp.isOpenUser="1"),this.$refs.submitForm.validate(function(a){if(a){var i=e.temp.mobile,l=e.checkMobileValue(i,"手机号");if(null!=l&&l.trim().length>0)return void e.$message({type:"warning",duration:5e3,showClose:!0,message:l});t.dialogLoading=!0,Object(s.addEmployee)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.dialogFormVisible=!1,t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.refreshTable())}).catch(function(e){t.dialogLoading=!1})}})},addOpenCode:function(){var e=this,t=e.temp.roleId;if(null!=t&&0!=t.trim().lang){var a=[];this.$refs.submitForm.validate(function(t){if(t){e.dialogLoading=!0,e.selectList.forEach(function(t){var i={employeeId:"",roleId:""};i.employeeId=t.employeeId,i.roleId=e.temp.roleId,a.push(i)});var i=JSON.stringify(a);Object(s.addEmployToUser)(i).then(function(t){e.dialogLoading=!1,0===t.code&&(e.dialogFormOpenCode=!1,e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(t){e.dialogLoading=!1})}})}else this.$message({message:"角色名称为空，角色名称为必填项不可为空！",type:"error",duration:5e3})},checkColumnByDelete:function(e){for(var t="",a=0;a<e.length;a++){var i=e[a].isplurality;"是"==i&&(t=t+"勾选的 第 "+(a+1)+" 行: 员工是主岗不可删除！")}return t},deleteBatch:function(){var e=this;null!=this.selectList&&0!=this.selectList.length?this.$confirm("即将删除勾选的员工信息请谨慎操作, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var t="";e.selectList.forEach(function(e){t+=e.employeeId+","}),Object(s.deleteEmployees)(t).then(function(t){0===t.code&&(e.dialogFormVisible=!1,e.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(e){})}).catch(function(){e.$message({type:"info",message:"已取消删除"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一行数据！"})},refreshTable:function(){var e=this;e.$axios.all([Object(s.listPageEmployees)(c({},e.tempQuery,{id:e.selectTree.id,type:e.selectTree.type,layer:e.selectTree.layer,dataType:this.$storage.get("dataType"),pageNo:e.pageNo}))]).then(e.$axios.spread(function(t,a){e.getListPage(t),e.configs.topBarBtnList.forEach(function(e){"delete"!=e.nameEn&&"changePost"!=e.nameEn&&"pluralityPost"!=e.nameEn&&"openCode"!=e.nameEn||(e.state=!0)});var i=a.result.treeList,l=[];l.push(i),e.treeData=l,e.$nextTick(function(){})})).catch(function(e){})},politicalSelect:function(e,t,a){e&&e.length>0?(this.temp.political=t.id,this.politicalData.defaultSelected=e):(this.temp.political=[],this.politicalData.defaultSelected=[])},roleSelect:function(e){e[0]?(this.roleData.defaultSelected=[e[0]],this.temp.roleId=e[0]):(this.roleData.defaultSelected=[],this.temp.roleId=[])},isOpenUserCode:function(e){this.isShowRole=e,this.openUserChecked=e,this.rules.roleName=null},handleAvatarSuccess:function(e){if(0==e.code){var t=e.photo;null!=t&&t.trim().length>0&&(this.temp.photo=t,this.imageUrl="/api/"+t),this.$message({message:"图片上传成功！",type:"success",duration:5e3})}else 0!=e.code&&null!=e.msg&&e.msg.trim().length>0&&this.$message.error(e.msg.trim())},beforeAvatarUpload:function(e){var t=e.type;if(t=t.replace("image/",""),-1!="jpg,jpeg,png".indexOf(t)){e.size>5242880&&this.$message({message:"上传员工照片大小不能超过 5MB!",type:"error",duration:5e3})}else this.$message({message:"上传员工照片只能是(jpg,jpeg,png)格式文件!",type:"error",duration:5e3})},dialogCallBack:function(e){this.timeStamp=e},searchDeptByName:function(){var e=this;e.treeNodes=[],Object(r.c)(e.treeData,e.showDisableDept,e.filterTextDept,e.treeNodes),e.enterTime=e.enterTime+1,e.$nextTick(function(){if(e.treeNodes.length>0){var t=e.treeNodes[e.enterTime%e.treeNodes.length];e.selectTree={pid:t.pid,id:t.id,name:t.name,type:t.type,layer:t.layer,deptName:t.deptName,postName:t.postName}}e.initTable(e.selectTree.id,e.selectTree.type,e.selectTree.layer)})},exportExcel:function(){var e="";null!=this.selectList&&this.selectList.length>0&&this.selectList.forEach(function(t){e=e+t.id+","}),Object(s.exportExcelEmployees)(e).then(function(e){e&&Object(r.j)(e,"员工管理导出.xls")}).catch(function(e){})},importExcelCallBack:function(){this.refreshTable()}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},watch:{pageNo:function(){this.initTable(this.selectTree.id,this.selectTree.type,this.selectTree.layer)},timeStamp:function(){var e=this,t=this;t.configs.topBarBtnList.forEach(function(a){"changePost"!=a.nameEn&&"pluralityPost"!=a.nameEn||e.timeStamp!==a.dialog.data.timeStamp&&t.refreshTable()})},showDisableDept:function(){this.initTree()}}},u=(a("KLid"),a("cVzj"),a("KHd+")),g=Object(u.a)(h,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"employeeManage"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"treeStyle",attrs:{span:4}},[a("div",{staticStyle:{"padding-left":"20px",height:"100%"}},[a("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge,"disable-state":e.disableState}})],1)]),e._v(" "),a("el-col",{staticClass:"tableStyle",attrs:{span:20}},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state,dialog:e.dialog},on:{myclick:e.method}})]})],2)])],1),e._v(" "),a("el-row",{staticClass:"tableContent"},[a("div",{staticStyle:{position:"absolute",top:"0",left:"10px",right:"10px",bottom:"5px"}},[a("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo,isSortable:!1},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)])],1)])],1),e._v(" "),a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],staticStyle:{height:"90vh"},attrs:{title:e.textMap[e.dialogStatus],visible:e.dialogFormVisible,width:"600px",top:"10vh","custom-class":"listDeliverClass"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"100%",overflow:"auto"}},[a("el-form",{ref:"submitForm",staticStyle:{width:"570px","padding-top":"10px"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-col",{attrs:{span:12}},[a("div",{staticStyle:{"padding-left":"120px"}},[a("el-upload",{staticClass:"avatar-uploader",attrs:{name:"fileName",action:e.temp.uploadUrl,data:e.fileData,"show-file-list":!1,"on-success":e.handleAvatarSuccess,"before-upload":e.beforeAvatarUpload}},[e.imageUrl?a("img",{staticClass:"avatar",attrs:{src:e.imageUrl}}):a("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1)]),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.code+":",prop:"code"}},[a("el-input",{model:{value:e.temp.code,callback:function(t){e.$set(e.temp,"code",t)},expression:"temp.code"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.name+":",prop:"name"}},[a("el-input",{model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name",t)},expression:"temp.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.sexName+":",prop:"sexName"}},[a("el-select",{attrs:{placeholder:e.tempLable.sex},model:{value:e.temp.sex,callback:function(t){e.$set(e.temp,"sex",t)},expression:"temp.sex"}},[a("el-option",{attrs:{label:"男",value:"1"}}),e._v(" "),a("el-option",{attrs:{label:"女",value:"0"}})],1)],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.deptName+":",prop:"deptName"}},[a("el-input",{attrs:{disabled:e.tempNotEditable.deptName},model:{value:e.temp.deptName,callback:function(t){e.$set(e.temp,"deptName",t)},expression:"temp.deptName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.mobile+":",prop:"mobile"}},[a("el-input",{on:{change:e.checkMobile},model:{value:e.temp.mobile,callback:function(t){e.$set(e.temp,"mobile",t)},expression:"temp.mobile"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.position+":",prop:"position"}},[a("el-input",{model:{value:e.temp.position,callback:function(t){e.$set(e.temp,"position",t)},expression:"temp.position"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.dormitory+":",prop:"dormitory"}},[a("el-input",{model:{value:e.temp.dormitory,callback:function(t){e.$set(e.temp,"dormitory",t)},expression:"temp.dormitory"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.entryDate+":",prop:"entryDate"}},[a("el-date-picker",{staticStyle:{width:"165px"},attrs:{type:"date",placeholder:"选择日期","value-format":"yyyy-MM-dd"},model:{value:e.temp.entryDate,callback:function(t){e.$set(e.temp,"entryDate",t)},expression:"temp.entryDate"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.contractDate+":",prop:"contractDate"}},[a("el-date-picker",{staticStyle:{width:"165px"},attrs:{type:"date",placeholder:"选择日期","value-format":"yyyy-MM-dd"},model:{value:e.temp.contractDate,callback:function(t){e.$set(e.temp,"contractDate",t)},expression:"temp.contractDate"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.nativePlace+":",prop:"nativePlace"}},[a("el-input",{model:{value:e.temp.nativePlace,callback:function(t){e.$set(e.temp,"nativePlace",t)},expression:"temp.nativePlace"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.politicalName+":",prop:"politicalName"}},[a("base-input-select",{staticStyle:{width:"165px"},attrs:{placeholder:e.tempLable.politicalName,data:e.politicalData.data},on:{callback:e.politicalSelect},model:{value:e.politicalData.defaultSelected,callback:function(t){e.$set(e.politicalData,"defaultSelected",t)},expression:"politicalData.defaultSelected"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.identityNumber+":",prop:"identityNumber"}},[a("el-input",{model:{value:e.temp.identityNumber,callback:function(t){e.$set(e.temp,"identityNumber",t)},expression:"temp.identityNumber"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.maritalName+":",prop:"maritalName"}},[a("el-select",{attrs:{placeholder:e.tempLable.marital},model:{value:e.temp.marital,callback:function(t){e.$set(e.temp,"marital",t)},expression:"temp.marital"}},[a("el-option",{attrs:{label:"未婚",value:"0"}}),e._v(" "),a("el-option",{attrs:{label:"已婚",value:"1"}})],1)],1)],1)],1),e._v(" "),a("el-row",{attrs:{gutter:20,type:"flex",justify:"end"}},[a("el-col",{attrs:{span:12}},[a("el-checkbox",{directives:[{name:"show",rawName:"v-show",value:e.isShowOpenUserCheckbox,expression:"isShowOpenUserCheckbox"}],staticStyle:{"padding-left":"120px"},attrs:{label:"开通用户账号"},on:{change:e.isOpenUserCode},model:{value:e.openUserChecked,callback:function(t){e.openUserChecked=t},expression:"openUserChecked"}})],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{directives:[{name:"show",rawName:"v-show",value:e.isShowRole,expression:"isShowRole"}],attrs:{label:e.tempLable.roleName+"：",prop:"roleName"}},[a("base-input-select",{staticStyle:{width:"165px","margin-left":"-10px"},attrs:{data:e.roleData.data},on:{callback:e.roleSelect},model:{value:e.roleData.defaultSelected,callback:function(t){e.$set(e.roleData,"defaultSelected",t)},expression:"roleData.defaultSelected"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:e.tempLable.remark+":",prop:"remark"}},[a("el-input",{attrs:{type:"textarea",rows:2},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"30px"},attrs:{slot:"footer"},slot:"footer"},["create"==e.dialogStatus?a("el-button",{attrs:{type:"primary"},on:{click:e.createData}},[e._v("保存")]):a("el-button",{attrs:{type:"primary"},on:{click:e.updateData}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("关闭")])],1)],1)]),e._v(" "),a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.textMap[e.dialogStatus],visible:e.dialogFormOpenCode,width:"700px",top:"40px"},on:{"update:visible":function(t){e.dialogFormOpenCode=t}}},[a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:e.OpenCodeRules,model:e.temp,"label-position":"right","label-width":"120px"}},[a("el-form-item",{attrs:{label:e.tempLable.roleName+":",prop:"roleName"}},[a("base-input-select",{staticStyle:{width:"280px"},attrs:{data:e.roleData.data},on:{callback:e.roleSelect},model:{value:e.roleData.defaultSelected,callback:function(t){e.$set(e.roleData,"defaultSelected",t)},expression:"roleData.defaultSelected"}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"30px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.addOpenCode}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.dialogFormOpenCode=!1}}},[e._v("关闭")])],1)],1)])],1)},[],!1,null,null,null);g.options.__file="index.vue";t.default=g.exports},wW4B:function(e,t,a){}}]);