(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-3410","chunk-f804"],{"Wc/n":function(e,t,i){},oC0i:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d");var a=i("ukxx"),n=i.n(a),s=i("Do8I"),o=i("zF5t"),l=i("z0WU");function r(e){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var c={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{roleId:"",rules:{},temp:{},tempLable:{},tempNotEditable:{},dialogLoading:!1,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},assignTree:[],assignTreeConfigs:{showSearch:!0},assignCheckedList:[],assignFilterText:"",dialogAssignChecked:!1,clickArrow:!1,defaultProps:{children:"children",label:"url"},treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},transferData:[],transferSelectedData:[],renderFunc:function(e,t){return e("span",{style:"display: inline-block;width: 100%;"},[e("span",{style:"display: inline-block;width: 20%;text-align: center;"},[t.index]),e("span",{style:"display: inline-block;width: 39%;text-align: center;"},[t.userCode]),e("span",{style:"display: inline-block;width: 39%;text-align: center;"},[t.userName])])},transferProps:{key:"id",label:"userName",code:"userCode",disabled:"isdisable",index:"index"},resState:null}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.roleId=this.temp.roleId,this.treeDepartments();var e=this.$storage.get("userInfo").companyId;this.assignTreeDataBridge({id:e})},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=r(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){this.$nextTick(function(){if(!document.getElementsByClassName("customTitle").length)for(var e=document.getElementsByClassName("el-transfer-panel__filter"),t=0;t<e.length;t++){var i=(new(n.a.extend({template:'<div class="customTitle" style="box-sizing: border-box;padding: 5px 0 5px 41px;height: 25px;box-shadow:0 3px 5px -3px rgba(0,0,0,0.3);">\n                        <span style="display: inline-block;width: 100%;">\n                        <span style="display: inline-block;width: 20%;text-align: center;">序号</span>\n                        <span style="display: inline-block;width: 37%;text-align: center;">账号</span>\n                        <span style="display: inline-block;width: 38%;text-align: center;">姓名</span>\n                        </span>\n                      </div>'}))).$mount(),a=e[t],s=a.parentNode,o=a.nextSibling;o?s.insertBefore(i.$el,o):s.appendChild(i.$el)}})},dialogClose:function(e){this.$emit("close-dialog",e||{})},assignFilterNode:function(e,t){return!e||-1!==t.name.indexOf(e)},treeDepartments:function(){var e=this;this.dialogLoading=!0,Object(s.treeDepartments)({isdisable:"1"}).then(function(t){e.assignTree=[t.result.treeList],e.$nextTick(function(t){e.$refs.assignTree.setCurrentKey(e.assignTree[0].id)})}).catch(function(t){e.dialogLoading=!1})},assignFilterKey:function(e){var t=[];return e.forEach(function(e){t.push(e.id)}),t},assignTreeDataBridge:function(e){var t=this;this.transferData=[],this.transferSelectedData=[];var i={deptId:e.id,roleId:this.roleId},a={roleId:this.roleId};this.$axios.all([Object(o.listUsersByRole)(a),Object(o.listAllUsersByDeptId)(i)]).then(this.$axios.spread(function(e,i){var a=Object(l.r)(e.result.varList.concat(i.result.varList));a.forEach(function(e,t){e.index=t+1}),t.transferData=a,t.transferSelectedData=t.assignFilterKey(e.result.varList),t.$loading().close(),t.dialogLoading=!1})).catch(function(e){t.$loading().close(),t.dialogLoading=!1})},handleChange:function(e,t,i){},saveUsersByRole:function(){var e=this;Object(o.saveRoleUsers)({roleId:this.roleId,userIds:Object(l.l)(this.transferSelectedData)}).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"保存成功",type:"success",duration:1e3}),e.isVisible=!1,e.dialogClose({resState:"ok"})),e.$loading().close()}).catch(function(t){e.$loading().close()})},closeDialog:function(e){this.showDialog=!1}}},d=(i("uoYy"),i("KHd+")),u=Object(d.a)(c,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"850px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{position:"relative",height:"100%",overflow:"hidden"},attrs:{span:6}},[i("div",{staticStyle:{position:"absolute",top:"-10px",bottom:"-10px",left:"0",right:"5px","background-color":"#EBF0F6","box-shadow":"5px 0 10px -5px rgba(0,0,0,0.3)","box-sizing":"border-box",padding:"10px 0"}},[i("div",{staticClass:"leftTree",staticStyle:{height:"100%","padding-top":"10px"}},[i("el-input",{attrs:{placeholder:"",clearable:""},model:{value:e.assignFilterText,callback:function(t){e.assignFilterText=t},expression:"assignFilterText"}},[i("i",{staticClass:"el-input__icon el-icon-search",attrs:{slot:"suffix"},slot:"suffix"})]),e._v(" "),i("div",{staticClass:"checkBox"},[i("el-checkbox",{model:{value:e.dialogAssignChecked,callback:function(t){e.dialogAssignChecked=t},expression:"dialogAssignChecked"}},[e._v("显示封存部门")])],1),e._v(" "),i("div",{staticClass:"treeView",staticStyle:{height:"calc(100% - 85px)",overflow:"auto"}},[i("el-tree",{ref:"assignTree",attrs:{"highlight-current":"","default-expand-all":"","node-key":"id","expand-on-click-node":e.clickArrow,data:e.assignTree,props:e.defaultProps,"filter-node-method":e.assignFilterNode},on:{"node-click":e.assignTreeDataBridge},scopedSlots:e._u([{key:"default",fn:function(t){var a=t.node,n=t.data;return i("span",{staticClass:"custom-tree-node"},[e.treeConfigs.showIcons?i("svg-icon",{staticStyle:{"margin-right":"5px"},attrs:{"icon-class":n.url}}):e._e(),e._v(" "),a.label?i("span",[e._v(e._s(a.label))]):i("span",[e._v(e._s(n.name))])],1)}}])})],1)],1)])]),e._v(" "),i("el-col",{staticStyle:{height:"100%"},attrs:{span:18}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px 0"}},[i("div",{staticStyle:{"text-align":"center"}},[i("el-transfer",{staticStyle:{"text-align":"left",display:"inline-block"},attrs:{filterable:"",props:e.transferProps,"left-default-checked":[],"right-default-checked":[],"render-content":e.renderFunc,titles:["未分配用户","已分配用户"],format:{noChecked:"${total}",hasChecked:"${checked}/${total}"},data:e.transferData},on:{change:e.handleChange},model:{value:e.transferSelectedData,callback:function(t){e.transferSelectedData=t},expression:"transferSelectedData"}})],1)]),e._v(" "),i("div",{staticStyle:{position:"relative",height:"60px","text-align":"center","box-sizing":"border-box",padding:"10px 0 0 0"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveUsersByRole}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);u.options.__file="dialogRoleUser.vue";t.default=u.exports},q0T2:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("rGqo");var a=i("DuN6"),n=i("we3T"),s=i("zF5t"),o=i("oC0i"),l=i("z0WU"),r=i("mSNy");function c(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}function d(e){return(d="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.deleteRow_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.deleteRow(scope.row,scope.$index)">删除</el-button>\n    \t\t\t\t\t</div>\n\n  \t\t\t\t</el-table-column>'},h={components:{dialogRoleUser:o.default},name:"dialog-add",props:["initData","visible"],data:function(){return{roleId:"",roleName:"",type:"",userData:[],userId:[],isSingle:!0,rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",temp:{},tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],selectList:null,tableIndex:null,initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:u,deleteRow:this.deleteRow,deleteRow_isShow:!0}},configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1}},created:function(){this.tableIndex=null,this.roleId=this.initData.temp.roleId,this.roleName=this.initData.temp.roleName,this.type=this.initData.temp.type,this.initUserData(),this.initTable()},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=d(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(l.m)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.tableData=e.result.varList}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==r.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==r.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}})},addTableTitle:function(e){return e.forEach(function(e){var t=e.label;t.indexOf("_")>0&&("en"==r.a.locale?e.label=t.substring(t.indexOf("_")+1):"zh"==r.a.locale&&(e.label=t.substring(0,t.indexOf("_"))))}),this.internationalConfig(),e.push(this.initConfigs.tableOperates),e},internationalConfig:function(){"en"==r.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==r.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTable:function(){var e=this,t="",i=this.initData.temp;null!=i&&i.length>0&&i.forEach(function(e){null!=e.id&&e.id.trim().length>0&&(t=0==t.length?"'"+e.id.trim()+"'":t+",'"+e.id.trim()+"'")});var n="";null!=t&&t.trim().length>0&&(n="detail.id in ("+t+")"),this.dialogLoading=!0,Object(a.listPageWarehouseCheckDetails)(function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){c(e,t,i[t])})}return e}({},this.tempQuery,{state:"0",queryStr:n,fieldCode:"pathName,productCode,productName,productSpec,productGenreName,productUnitName,code,stockCount",pageNo:this.pageNo})).then(function(t){e.getListPage(t),e.dialogLoading=!1}).catch(function(t){e.dialogLoading=!1})},initUserData:function(){var e=this;this.userData=[],Object(s.findListUserByRole)({userIsdisable:"1",queryStr:"role.id = '"+this.roleId+"'"}).then(function(t){var i=t.result.options;null!=i&&i.length>0&&i.forEach(function(t){var i=t.id,a=t.userName;null!=i&&i.trim().length>0&&null!=a&&a.trim().length>0&&e.userData.push({key:i,label:a,disabled:!1})})}).catch(function(e){})},dataBridge:function(e){},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},leftCheckChange:function(e){this.isSingle&&this.singleUserData(e)},singleUserData:function(e){var t=this.userData;if(null!=t&&0!=t.length)if(0==e.length)t.forEach(function(e){e.disabled=!1});else if(e.length>0){var i="";e.forEach(function(e){i=i+e+","}),t.forEach(function(e){var t=e.key;-1==i.indexOf(t)&&(e.disabled=!0)})}},addAdmin:function(){var e=this.roleId,t=this.roleName;this.dialogData.temp.roleId=e,this.dialogData.title=t+"-分配用户",this.openDialogName="dialogRoleUser",this.showDialog=!0,this.inLinVisible=!0},saveDispatch:function(){var e=this,t=this.roleId,i=this.roleName;this.type;if(null!=t&&0!=t){if(null==this.userData||0==this.userData.length)return this.dialogData.temp.roleId=t,this.dialogData.title=i+"-分配用户",this.openDialogName="dialogRoleUser",this.showDialog=!0,void(this.inLinVisible=!0);if(null!=this.userId&&0!=this.userId.length){var a=this.tableData,s="";if(null!=a&&0!=a.length){for(var o=[],l=0;l<a.length;l++){var r=a[l],c={id:"",parentId:"",taskName:""};c.id=r.id,c.parentId=r.parentId,c.taskName=r.parentCode+"_"+r.productName,o.push(c)}if(s=JSON.stringify(o),this.temp.dtlJsonStr=s,this.isSingle&&this.userId.length>1)this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择一位执行人，执行人只允许单选！"});else{this.temp.executeId="";for(var d=0;d<this.userId.length;d++){var u=this.userId[d];null!=u&&u.trim().length>0&&(this.temp.executeId=this.temp.executeId+u+",")}Object(n.addWarehouseCheckExecutor)(this.temp).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(e){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一行数据！"})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择执行人！"})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"仓库管理员角色ID为空或空字符串！"})},deleteRow:function(e,t){},closeDialog:function(e){}},watch:{pageNo:function(){this.initTable()}}},g=i("KHd+"),p=Object(g.a)(h,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{staticStyle:{height:"300px","margin-top":"15px",width:"96%","margin-left":"2%"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1),e._v(" "),i("el-row",{staticStyle:{width:"60%",margin:"3% 30%"}},[i("el-transfer",{staticStyle:{height:"300px","margin-bottom":"5px"},attrs:{data:e.userData,titles:["仓库管理员","执行人"]},on:{"left-check-change":e.leftCheckChange},model:{value:e.userId,callback:function(t){e.userId=t},expression:"userId"}}),e._v(" "),i("span",{staticStyle:{"font-size":"12px",color:"#1482f0",cursor:"pointer"},on:{click:e.addAdmin}},[e._v("+添加仓库管理员")])],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveDispatch}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);p.options.__file="dialogDispatch.vue";t.default=p.exports},uoYy:function(e,t,i){"use strict";var a=i("Wc/n");i.n(a).a}}]);