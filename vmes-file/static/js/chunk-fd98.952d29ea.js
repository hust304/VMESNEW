(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-fd98","chunk-f804","chunk-365e"],{"/PT8":function(e,t,i){"use strict";var a=i("uqOe");i.n(a).a},"03rG":function(e,t,i){"use strict";i.r(t);i("rGqo");var a=i("2+ib"),n=i("uTIz"),o=i("vrrb"),s=i("zF5t"),l=i("Vobf"),r=(i("nX/d"),i("PuDp"),{components:{multilevelTable:a.a,searchBar:n.a,dialogDispatch:o.default},data:function(){return{configs:{topBarBtnList:[{name:"派单",nameEn:"dispatchWarehouseOut",isShow:!0,icon:"add",method:this.dispatchWarehouseOut}]},searchList:[{label:"出库单编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入出库单编码"},{label:"出库类型",type:"input",ruleType:"string",mapKey:"typeName",configs:{},placeholder:"请输入出库类型"},{label:"仓库名称",type:"input",ruleType:"string",mapKey:"warehouseName",configs:{},placeholder:"请输入仓库名称"},{label:"接收单位",type:"input",ruleType:"string",mapKey:"deptName",configs:{},placeholder:"请输入接收单位"},{label:"出库单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"未完成"},{value:"1",label:"已完成"}]},placeholder:"请选择"},{label:"明细状态",type:"select",ruleType:"string",mapKey:"detailState",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"待派单"},{value:"1",label:"执行中"},{value:"2",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"请输入货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"请输入规格型号"},{label:"货品属性",type:"input",ruleType:"string",mapKey:"productGenreName",configs:{},placeholder:"请输入货品属性"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"productUnitName",configs:{},placeholder:"请输入计量单位"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"1",text:"已完成"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"未完成"}}}],apiObj:{apiName:"listPageWarehouseOuts",params:{detailState:"0"}},tempData:{},showHeader:!1,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"2",text:"已完成"},warning:{state:"1",text:"执行中"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"待派单"}}}],apiObj:{apiName:"listPageWarehouseOutDetails",params:{detailState:"0"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!0,isSingle:!1,componentId:"twoLevelTable"}],searchObj:{},temp:{},tempLable:{},selectList:[],openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:{},tempLable:{}}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,i=e.$storage.get("menuId");t&&(e.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(l.initMenuButtons)({menuId:i,roleId:t}).then(function(t){e.$loading().close();var i=t.buttonList;i&&i.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){console.log(t),e.$loading().close()}))},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.updateData(this.searchObj)},addChild:function(e,t){},databridge:function(e){this.selectList=e},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},dispatchWarehouseOut:function(){var e=this,t=this.selectList;if(console.log(t),null!=t&&0!=t.length){var i={userType:this.$storage.get("userInfo").userType,roleName:"仓库管理员"};Object(s.addRoleByName)(i).then(function(i){var a=i.result,n=a.roleId,o=a.roleName;null!=n&&0!=n.trim().length?(e.dialogData.temp=t,e.dialogData.temp.roleId=n,e.dialogData.temp.roleName=o,e.dialogData.title="派单",e.openDialogName="dialogDispatch",e.showDialog=!0,e.visible=!0):e.$message({type:"warning",duration:5e3,showClose:!0,message:"仓库管理员角色ID不存在(角色ID为空或空字符串)！"})}).catch(function(e){})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条明细！"})},resetTemp:function(){for(var e in this.temp)this.temp[e]=""}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),c=(i("A78t"),i("KHd+")),d=Object(c.a)(r,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"warehouseOutManage"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);d.options.__file="index.vue";t.default=d.exports},"6tci":function(e,t,i){},A78t:function(e,t,i){"use strict";var a=i("6tci");i.n(a).a},"Wc/n":function(e,t,i){},YfbJ:function(e,t,i){"use strict";var a=i("zcV0");i.n(a).a},oC0i:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d");var a=i("ukxx"),n=i.n(a),o=i("Do8I"),s=i("zF5t"),l=i("z0WU");function r(e){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var c={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{roleId:"",rules:{},temp:{},tempLable:{},tempNotEditable:{},dialogLoading:!1,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},assignTree:[],assignTreeConfigs:{showSearch:!0},assignCheckedList:[],assignFilterText:"",dialogAssignChecked:!1,clickArrow:!1,defaultProps:{children:"children",label:"url"},treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},transferData:[],transferSelectedData:[],renderFunc:function(e,t){return e("span",{style:"display: inline-block;width: 100%;"},[e("span",{style:"display: inline-block;width: 20%;text-align: center;"},[t.index]),e("span",{style:"display: inline-block;width: 39%;text-align: center;"},[t.userCode]),e("span",{style:"display: inline-block;width: 39%;text-align: center;"},[t.userName])])},transferProps:{key:"id",label:"userName",code:"userCode",disabled:"isdisable",index:"index"},resState:null}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.roleId=this.temp.roleId,this.treeDepartments();var e=this.$storage.get("userInfo").companyId;this.assignTreeDataBridge({id:e})},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=r(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){this.$nextTick(function(){if(!document.getElementsByClassName("customTitle").length)for(var e=document.getElementsByClassName("el-transfer-panel__filter"),t=0;t<e.length;t++){var i=(new(n.a.extend({template:'<div class="customTitle" style="box-sizing: border-box;padding: 5px 0 5px 41px;height: 25px;box-shadow:0 3px 5px -3px rgba(0,0,0,0.3);">\n                        <span style="display: inline-block;width: 100%;">\n                        <span style="display: inline-block;width: 20%;text-align: center;">序号</span>\n                        <span style="display: inline-block;width: 37%;text-align: center;">账号</span>\n                        <span style="display: inline-block;width: 38%;text-align: center;">姓名</span>\n                        </span>\n                      </div>'}))).$mount(),a=e[t],o=a.parentNode,s=a.nextSibling;s?o.insertBefore(i.$el,s):o.appendChild(i.$el)}})},dialogClose:function(e){this.$emit("close-dialog",e||{})},assignFilterNode:function(e,t){return!e||-1!==t.name.indexOf(e)},treeDepartments:function(){var e=this;this.dialogLoading=!0,Object(o.treeDepartments)({isdisable:"1"}).then(function(t){e.assignTree=[t.result.treeList],e.$nextTick(function(t){e.$refs.assignTree.setCurrentKey(e.assignTree[0].id)})}).catch(function(t){e.dialogLoading=!1})},assignFilterKey:function(e){var t=[];return e.forEach(function(e){t.push(e.id)}),t},assignTreeDataBridge:function(e){var t=this;this.transferData=[],this.transferSelectedData=[];var i={deptId:e.id,roleId:this.roleId},a={roleId:this.roleId};this.$axios.all([Object(s.listUsersByRole)(a),Object(s.listAllUsersByDeptId)(i)]).then(this.$axios.spread(function(e,i){var a=Object(l.n)(e.result.varList.concat(i.result.varList));a.forEach(function(e,t){e.index=t+1}),t.transferData=a,t.transferSelectedData=t.assignFilterKey(e.result.varList),t.$loading().close(),t.dialogLoading=!1})).catch(function(e){t.$loading().close(),t.dialogLoading=!1})},handleChange:function(e,t,i){},saveUsersByRole:function(){var e=this;Object(s.saveRoleUsers)({roleId:this.roleId,userIds:Object(l.j)(this.transferSelectedData)}).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"保存成功",type:"success",duration:1e3}),e.isVisible=!1,e.dialogClose({resState:"ok"})),e.$loading().close()}).catch(function(t){e.$loading().close()})},closeDialog:function(e){this.showDialog=!1}}},d=(i("uoYy"),i("KHd+")),u=Object(d.a)(c,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"850px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{position:"relative",height:"100%",overflow:"hidden"},attrs:{span:6}},[i("div",{staticStyle:{position:"absolute",top:"-10px",bottom:"-10px",left:"0",right:"5px","background-color":"#EBF0F6","box-shadow":"5px 0 10px -5px rgba(0,0,0,0.3)","box-sizing":"border-box",padding:"10px 0"}},[i("div",{staticClass:"leftTree",staticStyle:{height:"100%","padding-top":"10px"}},[i("el-input",{attrs:{placeholder:"",clearable:""},model:{value:e.assignFilterText,callback:function(t){e.assignFilterText=t},expression:"assignFilterText"}},[i("i",{staticClass:"el-input__icon el-icon-search",attrs:{slot:"suffix"},slot:"suffix"})]),e._v(" "),i("div",{staticClass:"checkBox"},[i("el-checkbox",{model:{value:e.dialogAssignChecked,callback:function(t){e.dialogAssignChecked=t},expression:"dialogAssignChecked"}},[e._v("显示封存部门")])],1),e._v(" "),i("div",{staticClass:"treeView",staticStyle:{height:"calc(100% - 85px)",overflow:"auto"}},[i("el-tree",{ref:"assignTree",attrs:{"highlight-current":"","default-expand-all":"","node-key":"id","expand-on-click-node":e.clickArrow,data:e.assignTree,props:e.defaultProps,"filter-node-method":e.assignFilterNode},on:{"node-click":e.assignTreeDataBridge},scopedSlots:e._u([{key:"default",fn:function(t){var a=t.node,n=t.data;return i("span",{staticClass:"custom-tree-node"},[e.treeConfigs.showIcons?i("svg-icon",{staticStyle:{"margin-right":"5px"},attrs:{"icon-class":n.url}}):e._e(),e._v(" "),a.label?i("span",[e._v(e._s(a.label))]):i("span",[e._v(e._s(n.name))])],1)}}])})],1)],1)])]),e._v(" "),i("el-col",{staticStyle:{height:"100%"},attrs:{span:18}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px 0"}},[i("div",{staticStyle:{"text-align":"center"}},[i("el-transfer",{staticStyle:{"text-align":"left",display:"inline-block"},attrs:{filterable:"",props:e.transferProps,"left-default-checked":[],"right-default-checked":[],"render-content":e.renderFunc,titles:["未分配用户","已分配用户"],format:{noChecked:"${total}",hasChecked:"${checked}/${total}"},data:e.transferData},on:{change:e.handleChange},model:{value:e.transferSelectedData,callback:function(t){e.transferSelectedData=t},expression:"transferSelectedData"}})],1)]),e._v(" "),i("div",{staticStyle:{position:"relative",height:"60px","text-align":"center","box-sizing":"border-box",padding:"10px 0 0 0"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveUsersByRole}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);u.options.__file="dialogRoleUser.vue";t.default=u.exports},uoYy:function(e,t,i){"use strict";var a=i("Wc/n");i.n(a).a},uqOe:function(e,t,i){},vleD:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rGqo");var a=i("mSNy"),n=i("t3Un"),o=i("z0WU");function s(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var l={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},r={name:"dialog-option",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"",userInfo:null,topBarBtnList:[{name:"查询",icon:"search",method:this.queryTable},{name:"重置",icon:"refresh",plain:!0,method:this.resetQueryTemp}],configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1,isSingle:!1},tableData:[],selectList:[],queryParms:[{name:"code"},{name:"name"}],tempQuery:{},tempLable:{},pageData:null,pageNo:1}},components:{},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.configs.isSingle=this.initData.isSingle,this.userInfo=this.$storage.get("userInfo"),this.initTable()},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(){this.$emit("close-dialog",this.selectList,this.initData.temp)},queryTable:function(){this.pageNo=1,this.initTable()},initTable:function(){var e=this;e.dialogTopLoading=!0,Object(n.a)({url:e.initData.tableUrl,method:"post",data:function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){s(e,t,i[t])})}return e}({},e.initData.tableParm,e.tempQuery,{pageNo:e.pageNo})}).then(function(t){e.dialogTopLoading=!1,e.getListPage(t)}).catch(function(t){console.log(t),e.dialogTopLoading=!1})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(o.k)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var n=e[i];n.indexOf("_")>0&&("en"==a.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==a.a.locale&&(n=n.substring(0,n.indexOf("_")))),t.tempLable[i]=n}})},addTableTitle:function(e){var t=this;return e.forEach(function(e){var i=e.label;i.indexOf("_")>0&&("en"==a.a.locale?e.label=i.substring(i.indexOf("_")+1):"zh"==a.a.locale&&(e.label=i.substring(0,i.indexOf("_")))),"是否启用"===e.label&&(e.component=l,e.changeState=t.changeState)}),e},dataBridge:function(e){this.selectList=e},resetQueryTemp:function(){for(var e in this.tempQuery)this.tempQuery[e]=""}},computed:{},watch:{pageNo:function(){this.initTable()}}},c=(i("/PT8"),i("KHd+")),d=Object(c.a)(r,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.title,visible:e.isVisible,"append-to-body":"",width:"900px"},on:{"update:visible":function(t){e.isVisible=t},close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{height:"100%"},attrs:{span:24}},[i("div",{staticStyle:{height:"50px","box-sizing":"border-box",padding:"7px 20px 7px 7px"}},[i("el-form",{staticClass:"form-inline",staticStyle:{width:"900px",margin:"10px auto"},attrs:{inline:!0,model:e.tempQuery,"label-width":"80px"}},[i("el-col",{staticStyle:{"max-width":"260px"},attrs:{span:6}}),e._v(" "),i("el-col",{staticStyle:{"max-width":"260px"},attrs:{span:6}},[i("el-form-item",{attrs:{label:e.tempLable.code}},[i("el-input",{attrs:{placeholder:e.tempLable.code},model:{value:e.tempQuery.code,callback:function(t){e.$set(e.tempQuery,"code",t)},expression:"tempQuery.code"}})],1)],1),e._v(" "),i("el-col",{staticStyle:{"max-width":"260px"},attrs:{span:6}},[i("el-form-item",{attrs:{label:e.tempLable.name}},[i("el-input",{attrs:{placeholder:e.tempLable.name},model:{value:e.tempQuery.name,callback:function(t){e.$set(e.tempQuery,"name",t)},expression:"tempQuery.name"}})],1)],1),e._v(" "),i("el-col",{staticStyle:{"max-width":"90px"},attrs:{span:3}},[i("el-form-item",[i("base-button",{attrs:{name:e.topBarBtnList[0].name,icon:e.topBarBtnList[0].icon,plain:e.topBarBtnList[0].plain,state:e.topBarBtnList[0].state},on:{myclick:e.topBarBtnList[0].method}})],1)],1),e._v(" "),i("el-col",{staticStyle:{"max-width":"95px"},attrs:{span:3}},[i("el-form-item",[i("base-button",{attrs:{name:e.topBarBtnList[1].name,icon:e.topBarBtnList[1].icon,plain:e.topBarBtnList[1].plain,state:e.topBarBtnList[1].state},on:{myclick:e.topBarBtnList[1].method}})],1)],1)],1)],1),e._v(" "),i("div",{staticStyle:{height:"calc(100% - 110px)","box-sizing":"border-box",padding:"7px"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,isSingle:e.configs.isSingle,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1),e._v(" "),i("div",{staticStyle:{position:"relative",height:"60px","text-align":"center","box-sizing":"border-box",padding:"10px 0 0 0"}},[i("el-button",{attrs:{type:"primary",disabled:!e.selectList.length},on:{click:function(t){e.isVisible=!1}}},[e._v("确认")]),e._v(" "),i("el-button",{staticStyle:{"margin-left":"30px"},on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)])],1)])},[],!1,null,null,null);d.options.__file="dialogOption.vue";t.default=d.exports},vrrb:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("rGqo");var a=i("7cmB"),n=i("vleD"),o=i("oC0i"),s=i("zF5t"),l=i("PuDp");i("z0WU");function r(e){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var c={props:["colConfig"],template:'<el-table-column :label="colConfig.label" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t\t\t<el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.change(scope.row,scope.$index)">选择库位</el-button>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},d={components:{treeFormTable:a.a,dialogOption:n.default,dialogRoleUser:o.default},name:"dialog-add",props:["initData","visible"],data:function(){return{rootData:{},tableSets:{1:{showCheckBox:!1,showIndex:!0,expandOne:!1},2:{showCheckBox:!1,showIndex:!1,isExpands:!1,isSortable:!1,isSingle:!1}},currentpage:1,customColumn:{0:[{columnIndex:"last",prop:"operate",label:"操作",component:c,change:this.change}]},editable:{suggestCount:{type:"input"}},apiObj:{apiName:"listPageWarehouseOutDetailsDispatch",params:{}},addedData:{},userData:[],executorIds:[],openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"选择员工",data:null,temp:{},tempLable:null,isSingle:!0,tableParm:{}},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},roleId:"",roleName:""}},created:function(){this.roleId=this.initData.temp.roleId,this.roleName=this.initData.temp.roleName,this.initUserData();var e="",t=this.initData.temp;null!=t&&t.length>0&&t.forEach(function(t){null!=t.id&&t.id.trim().length>0&&(e=0==e.length?"'"+t.id.trim()+"'":e+",'"+t.id.trim()+"'")});var i="";null!=e&&e.trim().length>0&&(i="detail.id in ("+e+")"),this.apiObj.params={queryStr:i,pageNo:1}},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=r(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(e){console.log(e)},addChild:function(e,t){this.dialogCallBackData=e,this.showDialog=!0,this.dialogVisible=!0},addChildRow:function(){this.dialogVisible=!1,this.showDialog=!1,this.addedData={rowData:this.testData,parentData:this.dialogCallBackData}},sendChildrenRow:function(e){},change:function(e,t){this.dialogData.temp=e,this.dialogData.tempLable=this.tempLable,this.dialogData.title="选择库位",this.dialogData.isSingle=!1,this.dialogData.tableUrl="/warehouse/warehouseProduct/listPageWarehouseProductsDispatchOption";var i="";null!=e.parentWarehouseId&&e.parentWarehouseId.trim().length>0&&(i="'%"+e.parentWarehouseId+"%'"),this.dialogData.tableParm={productId:e.productId,isNeedWarehouse:"true",parentWarehouseId:i},this.openDialogName="dialogOption",this.showDialog=!0,this.inLinVisible=!0},initUserData:function(){var e=this;Object(s.findListUserByRole)({userIsdisable:"1",queryStr:"role.id = '"+this.roleId+"'"}).then(function(t){e.userData=[];var i=t.result.options;null!=i&&i.length>0&&i.forEach(function(t){var i=t.id,a=t.userName;null!=i&&i.trim().length>0&&null!=a&&a.trim().length>0&&e.userData.push({key:i,label:a,disabled:!1})})}).catch(function(e){})},dataBridge:function(e){},dialogOpen:function(){},dialogClose:function(e){console.log(e),this.$emit("close-dialog",e||{})},leftCheckChange:function(e){var t=this.userData;if(null!=t&&0!=t.length)if(0==e.length)t.forEach(function(e){e.disabled=!1});else if(e.length>0){var i="";e.forEach(function(e){i=i+e+","}),t.forEach(function(e){var t=e.key;-1==i.indexOf(t)&&(e.disabled=!0)})}},addAdmin:function(){var e=this.roleId,t=this.roleName;this.dialogData.temp.roleId=e,this.dialogData.title=t+"-分配用户",this.openDialogName="dialogRoleUser",this.showDialog=!0,this.inLinVisible=!0},save:function(){this.$refs.treeFormTable.getData()},formData:function(e){console.log(e),this.realSave(e)},realSave:function(e){var t=this,i=this.roleId,a=this.roleName;if(null!=i&&0!=i){if(null==this.userData||0==this.userData.length)return this.dialogData.temp.roleId=i,this.dialogData.title=a+"-分配用户",this.openDialogName="dialogRoleUser",this.showDialog=!0,void(this.inLinVisible=!0);if(null!=this.executorIds&&0!=this.executorIds.length)if(null!=e.tableData&&0!=e.tableData.length){var n="";this.executorIds.forEach(function(e){n=n?n+","+e:e});var o="";e.tableData&&e.tableData.length>0&&(o=JSON.stringify(e.tableData)),Object(l.dispatchWarehouseOutDetail)({jsonDataStr:o,executorIdsStr:n}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择出库明细信息！"});else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择执行人！"})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"仓库管理员角色ID为空或空字符串！"})},closeDialog:function(e,t){console.log(e),this.addedData={rowData:e[0],parentData:t},this.initUserData(),this.showDialog=!1}},watch:{pageNo:function(){this.initTable()}}},u=(i("YfbJ"),i("KHd+")),p=Object(u.a)(d,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{staticStyle:{height:"300px","margin-top":"15px",width:"96%","margin-left":"2%"}},[i("tree-form-table",{ref:"treeFormTable",attrs:{"expand-all":!0,initData:e.rootData,configs:e.tableSets,currentpage:e.currentpage,customColumn:e.customColumn,editable:e.editable,apiObj:e.apiObj,addedData:e.addedData},on:{"update:currentpage":function(t){e.currentpage=t},"get-data":e.formData,"send-children-row":e.sendChildrenRow,databridge:e.databridge}})],1),e._v(" "),i("el-row",{staticStyle:{width:"60%",margin:"3% 25%",height:"300px"}},[i("el-transfer",{staticStyle:{height:"300px","margin-bottom":"5px"},attrs:{data:e.userData,titles:["仓库管理员","执行人"]},on:{"left-check-change":e.leftCheckChange},model:{value:e.executorIds,callback:function(t){e.executorIds=t},expression:"executorIds"}}),e._v(" "),i("span",{staticStyle:{"font-size":"12px",color:"#1482f0",cursor:"pointer"},on:{click:e.addAdmin}},[e._v("+添加仓库管理员")])],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);p.options.__file="dialogDispatch.vue";t.default=p.exports},zcV0:function(e,t,i){}}]);