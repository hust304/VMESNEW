(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-2b47","chunk-0470","chunk-259c","chunk-f804"],{"2WVR":function(e,t,i){"use strict";var a=i("AGgG");i.n(a).a},AGgG:function(e,t,i){},"BC+U":function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d");var a=i("K3g7"),n=i("uTIz"),o=i("y9YZ"),s=i("R1DK"),l=i("zF5t"),r=i("z0WU"),c=i("mSNy");function d(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}function u(e){return(u="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var h={components:{searchBar:n.a,dialogDispatch:o.default},name:"dialog-add",props:["initData","visible"],data:function(){return{searchList:[{label:"货品编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"spec",configs:{},placeholder:"请输入规格型号"},{label:"货品属性",type:"input",ruleType:"string",mapKey:"genreName",configs:{},placeholder:"请输入货品属性"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"unitName",configs:{},placeholder:"请输入计量单位"},{label:"货品类型",type:"input",ruleType:"string",mapKey:"typeName",configs:{},placeholder:"请输入货品类型"}],guid:"",queryType:null,productId:"",productType:"",dialogLoading:!1,isVisible:!1,inDialog:!0,tempLable:{},tempQuery:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null,temp:null},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},BaseTableLoading:!1,tableData:[],selectList:[],configs:{tableConfigs:[],isSingle:!1,showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1}},created:function(){var e=this.initData.temp;this.productId=e.productId,this.productType=e.productType,this.initTree()},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=u(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{sendGuid:function(e){this.guid=e},searchMap:function(e){console.log(e),this.tempQuery=e,this.initTable(null,this.selectTree.id)},treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,name:e.nodeData.name},this.pageNo=1,this.initTable(null,this.selectTree.id)},initTree:function(){var e=this;this.dialogLoading=!0;var t=this;Object(a.treeWarehouse)({}).then(function(e){var i=[],a=e.result.treeList;t.selectTree={pid:a.pid,id:a.id,name:a.name},i.push(a),t.treeData=i,t.initTable(null,null),t.$nextTick(function(){t.$refs.tree.$children[0].setCurrentKey(t.selectTree.id)})}).catch(function(t){e.dialogLoading=!1})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(r.m)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==c.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==c.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}})},addTableTitle:function(e){return e.forEach(function(e){var t=e.label;t.indexOf("_")>0&&("en"==c.a.locale?e.label=t.substring(t.indexOf("_")+1):"zh"==c.a.locale&&(e.label=t.substring(0,t.indexOf("_"))))}),e},initTable:function(e,t){var i=this;null!=t&&0!=t.trim().length||(t=""),e&&(this.BaseTableLoading=!0),Object(s.listPageWarehouseProductMove)(function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){d(e,t,i[t])})}return e}({},this.tempQuery,{fieldCode:"pathName,wpCode,code,name,spec,genreName,unitName,typeName,stockCount",queryStr:" (wp.stock_count > 0 ) ",warehouseId:t,pageNo:this.pageNo})).then(function(t){i.getListPage(t),i.dialogLoading=!1,e&&(i.BaseTableLoading=!1)}).catch(function(e){i.dialogLoading=!1,i.BaseTableLoading=!1})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",{resState:this.resState})},dataBridge:function(e){this.selectList=e},save:function(){var e=this;console.log(this.selectList);var t=this.selectList;if(console.log(t),null!=t&&0!=t.length){var i={userType:this.$storage.get("userInfo").userType,roleName:"仓库管理员"};Object(l.addRoleByName)(i).then(function(i){var a=i.result,n=a.roleId,o=a.roleName;null!=n&&0!=n.trim().length?(e.dialogData.temp=t,e.dialogData.temp.roleId=n,e.dialogData.temp.roleName=o,e.dialogData.title="派单",e.openDialogName="dialogDispatch",e.showDialog=!0,e.inLinVisible=!0):e.$message({type:"warning",duration:5e3,showClose:!0,message:"仓库管理员角色ID不存在(角色ID为空或空字符串)！"})}).catch(function(e){})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条明细！"})},closeDialog:function(e){"ok"==e.resState&&(this.resState="ok",this.isVisible=!1),this.inLinVisible=!1,this.showDialog=!1}},watch:{pageNo:function(){this.initTable(null,this.selectTree.id)}}},g=(i("SAfV"),i("KHd+")),p=Object(g.a)(h,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"600px"}},[i("el-col",{attrs:{span:24}},[i("div",{staticStyle:{"margin-left":"4%","margin-top":"1%"}},[i("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}})],1)]),e._v(" "),i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1),e._v(" "),i("el-col",{attrs:{span:20}},[i("el-row",{staticClass:"tableContent",staticStyle:{"margin-left":"10px"}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.BaseTableLoading,expression:"BaseTableLoading"}],staticStyle:{height:"400px"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,isSingle:e.configs.isSingle,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)]),e._v(" "),i("el-row",{staticStyle:{height:"100px","text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)],1)},[],!1,null,null,null);p.options.__file="dialogSelectWarehouseProduct.vue";t.default=p.exports},IfZh:function(e,t,i){"use strict";i.d(t,"b",function(){return n}),i.d(t,"a",function(){return o}),i.d(t,"c",function(){return s});var a=i("t3Un");function n(e){return Object(a.a)({url:"/warehouse/warehouseInDispatch/listPageWarehouseInDetail",method:"post",data:e})}function o(e){return Object(a.a)({url:"/warehouse/warehouseInDispatch/findWarehouseListByWarehouseIn",method:"post",data:e})}function s(e){return Object(a.a)({url:"/warehouse/warehouseInDispatch/updateWarehouseInDispatch",method:"post",data:e})}},SAfV:function(e,t,i){"use strict";var a=i("lhJN");i.n(a).a},"Wc/n":function(e,t,i){},WnSj:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d");var a=i("K3g7"),n=i("IfZh"),o=i("z0WU"),s=i("mSNy");function l(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}function r(e){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var c={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{queryType:null,productId:"",productType:"",dialogLoading:!1,isVisible:!1,inDialog:!0,tempLable:{},tempQuery:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},BaseTableLoading:!1,tableData:[],selectList:[],configs:{tableConfigs:[],isSingle:!0,showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1,resState:null}},created:function(){var e=this.initData.temp;this.productId=e.productId,this.productType=e.productType,this.initTree()},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=r(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,name:e.nodeData.name},this.pageNo=1,this.radioChange()},initTree:function(){var e=this;this.dialogLoading=!0;var t=this;Object(a.treeWarehouse)({}).then(function(e){var i=[],a=e.result.treeList;t.selectTree={pid:a.pid,id:a.id,name:a.name},i.push(a),t.treeData=i,t.initTable(null,null,null,null,null),t.$nextTick(function(){t.$refs.tree.$children[0].setCurrentKey(t.selectTree.id)})}).catch(function(t){e.dialogLoading=!1})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(o.m)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==s.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==s.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}})},addTableTitle:function(e){return e.forEach(function(e){var t=e.label;t.indexOf("_")>0&&("en"==s.a.locale?e.label=t.substring(t.indexOf("_")+1):"zh"==s.a.locale&&(e.label=t.substring(0,t.indexOf("_"))))}),e},initTable:function(e,t,i,a,o){var s=this;null!=t&&0!=t.trim().length||(t=""),null!=i&&0!=i.trim().length||(i=""),null!=a&&0!=a.trim().length||(a=""),null!=o&&0!=o.trim().length||(o=""),e&&(this.BaseTableLoading=!0),Object(n.a)(function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){l(e,t,i[t])})}return e}({},this.tempQuery,{nodeId:t,productId:i,productType:a,isExistProd:o,pageNo:this.pageNo})).then(function(t){s.getListPage(t),s.dialogLoading=!1,e&&(s.BaseTableLoading=!1)}).catch(function(e){s.dialogLoading=!1,s.BaseTableLoading=!1})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},radioChange:function(){var e="",t="",i="";"productId"==this.queryType?(e=this.productId,i="true"):"productType"==this.queryType?(t=this.productType,i="true"):"warehouseId"==this.queryType&&(i="false");var a="";null!=this.selectTree&&null!=this.selectTree.id&&this.selectTree.id.trim().length>0&&(a=this.selectTree.id.trim()),this.initTable(!0,a,e,t,i)},dataBridge:function(e){if(null!=e&&e.length>0){var t=e[0];t.pageName="dialogChangeWarehouseByIn",this.selectList.push(t)}},save:function(){this.isVisible=!1,this.dialogClose(this.selectList[0])}},watch:{pageNo:function(){this.initTable()}}},d=(i("2WVR"),i("KHd+")),u=Object(d.a)(c,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1),e._v(" "),i("el-col",{attrs:{span:20}},[i("el-row",[i("el-radio-group",{staticStyle:{padding:"10px 10px"},on:{change:e.radioChange},model:{value:e.queryType,callback:function(t){e.queryType=t},expression:"queryType"}},[i("el-radio",{attrs:{label:"productId"}},[e._v("相同货品")]),e._v(" "),i("el-radio",{attrs:{label:"productType"}},[e._v("相同货品分类")]),e._v(" "),i("el-radio",{attrs:{label:"warehouseId"}},[e._v("空货位")])],1)],1),e._v(" "),i("div",{staticClass:"tableContent",staticStyle:{"margin-left":"10px"}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.BaseTableLoading,expression:"BaseTableLoading"}],staticStyle:{height:"400px"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,isSingle:e.configs.isSingle,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)]),e._v(" "),i("el-row",{staticStyle:{height:"100px","text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)],1)},[],!1,null,null,null);u.options.__file="dialogChangeWarehouseByIn.vue";t.default=u.exports},lhJN:function(e,t,i){},oC0i:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d");var a=i("ukxx"),n=i.n(a),o=i("Do8I"),s=i("zF5t"),l=i("z0WU");function r(e){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var c={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{roleId:"",rules:{},temp:{},tempLable:{},tempNotEditable:{},dialogLoading:!1,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},assignTree:[],assignTreeConfigs:{showSearch:!0},assignCheckedList:[],assignFilterText:"",dialogAssignChecked:!1,clickArrow:!1,defaultProps:{children:"children",label:"url"},treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},transferData:[],transferSelectedData:[],renderFunc:function(e,t){return e("span",{style:"display: inline-block;width: 100%;"},[e("span",{style:"display: inline-block;width: 20%;text-align: center;"},[t.index]),e("span",{style:"display: inline-block;width: 39%;text-align: center;"},[t.userCode]),e("span",{style:"display: inline-block;width: 39%;text-align: center;"},[t.userName])])},transferProps:{key:"id",label:"userName",code:"userCode",disabled:"isdisable",index:"index"},resState:null}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.roleId=this.temp.roleId,this.treeDepartments();var e=this.$storage.get("userInfo").companyId;this.assignTreeDataBridge({id:e})},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=r(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){this.$nextTick(function(){if(!document.getElementsByClassName("customTitle").length)for(var e=document.getElementsByClassName("el-transfer-panel__filter"),t=0;t<e.length;t++){var i=(new(n.a.extend({template:'<div class="customTitle" style="box-sizing: border-box;padding: 5px 0 5px 41px;height: 25px;box-shadow:0 3px 5px -3px rgba(0,0,0,0.3);">\n                        <span style="display: inline-block;width: 100%;">\n                        <span style="display: inline-block;width: 20%;text-align: center;">序号</span>\n                        <span style="display: inline-block;width: 37%;text-align: center;">账号</span>\n                        <span style="display: inline-block;width: 38%;text-align: center;">姓名</span>\n                        </span>\n                      </div>'}))).$mount(),a=e[t],o=a.parentNode,s=a.nextSibling;s?o.insertBefore(i.$el,s):o.appendChild(i.$el)}})},dialogClose:function(e){this.$emit("close-dialog",e||{})},assignFilterNode:function(e,t){return!e||-1!==t.name.indexOf(e)},treeDepartments:function(){var e=this;this.dialogLoading=!0,Object(o.treeDepartments)({isdisable:"1"}).then(function(t){e.assignTree=[t.result.treeList],e.$nextTick(function(t){e.$refs.assignTree.setCurrentKey(e.assignTree[0].id)})}).catch(function(t){e.dialogLoading=!1})},assignFilterKey:function(e){var t=[];return e.forEach(function(e){t.push(e.id)}),t},assignTreeDataBridge:function(e){var t=this;this.transferData=[],this.transferSelectedData=[];var i={deptId:e.id,roleId:this.roleId},a={roleId:this.roleId};this.$axios.all([Object(s.listUsersByRole)(a),Object(s.listAllUsersByDeptId)(i)]).then(this.$axios.spread(function(e,i){var a=Object(l.s)(e.result.varList.concat(i.result.varList));a.forEach(function(e,t){e.index=t+1}),t.transferData=a,t.transferSelectedData=t.assignFilterKey(e.result.varList),t.$loading().close(),t.dialogLoading=!1})).catch(function(e){t.$loading().close(),t.dialogLoading=!1})},handleChange:function(e,t,i){},saveUsersByRole:function(){var e=this;Object(s.saveRoleUsers)({roleId:this.roleId,userIds:Object(l.l)(this.transferSelectedData)}).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"保存成功",type:"success",duration:1e3}),e.isVisible=!1,e.dialogClose({resState:"ok"})),e.$loading().close()}).catch(function(t){e.$loading().close()})},closeDialog:function(e){this.showDialog=!1}}},d=(i("uoYy"),i("KHd+")),u=Object(d.a)(c,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"850px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{position:"relative",height:"100%",overflow:"hidden"},attrs:{span:6}},[i("div",{staticStyle:{position:"absolute",top:"-10px",bottom:"-10px",left:"0",right:"5px","background-color":"#EBF0F6","box-shadow":"5px 0 10px -5px rgba(0,0,0,0.3)","box-sizing":"border-box",padding:"10px 0"}},[i("div",{staticClass:"leftTree",staticStyle:{height:"100%","padding-top":"10px"}},[i("el-input",{attrs:{placeholder:"",clearable:""},model:{value:e.assignFilterText,callback:function(t){e.assignFilterText=t},expression:"assignFilterText"}},[i("i",{staticClass:"el-input__icon el-icon-search",attrs:{slot:"suffix"},slot:"suffix"})]),e._v(" "),i("div",{staticClass:"treeView",staticStyle:{height:"calc(100% - 85px)",overflow:"auto"}},[i("el-tree",{ref:"assignTree",attrs:{"highlight-current":"","default-expand-all":"","node-key":"id","expand-on-click-node":e.clickArrow,data:e.assignTree,props:e.defaultProps,"filter-node-method":e.assignFilterNode},on:{"node-click":e.assignTreeDataBridge},scopedSlots:e._u([{key:"default",fn:function(t){var a=t.node,n=t.data;return i("span",{staticClass:"custom-tree-node"},[e.treeConfigs.showIcons?i("svg-icon",{staticStyle:{"margin-right":"5px"},attrs:{"icon-class":n.url}}):e._e(),e._v(" "),a.label?i("span",[e._v(e._s(a.label))]):i("span",[e._v(e._s(n.name))])],1)}}])})],1)],1)])]),e._v(" "),i("el-col",{staticStyle:{height:"100%"},attrs:{span:18}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px 0"}},[i("div",{staticStyle:{"text-align":"center"}},[i("el-transfer",{staticStyle:{"text-align":"left",display:"inline-block"},attrs:{filterable:"",props:e.transferProps,"left-default-checked":[],"right-default-checked":[],"render-content":e.renderFunc,titles:["未分配用户","已分配用户"],format:{noChecked:"${total}",hasChecked:"${checked}/${total}"},data:e.transferData},on:{change:e.handleChange},model:{value:e.transferSelectedData,callback:function(t){e.transferSelectedData=t},expression:"transferSelectedData"}})],1)]),e._v(" "),i("div",{staticStyle:{position:"relative",height:"60px","text-align":"center","box-sizing":"border-box",padding:"10px 0 0 0"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveUsersByRole}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);u.options.__file="dialogRoleUser.vue";t.default=u.exports},uoYy:function(e,t,i){"use strict";var a=i("Wc/n");i.n(a).a},y9YZ:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("rGqo");var a=i("zF5t"),n=i("oC0i"),o=i("WnSj"),s=i("R1DK"),l=i("XBTa"),r=i("z0WU"),c=i("mSNy");function d(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}function u(e){return(u="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var h={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.deleteWarehouse_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.deleteWarehouse(scope.row,scope.$index)">删除</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},g={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model.number="scope.row.moveCount" @change="colConfig.checkCount(scope.row,scope.$index)"></el-input>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},p={components:{dialogRoleUser:n.default,dialogChangeWarehouseByIn:o.default},name:"dialog-add",props:["initData","visible"],data:function(){return{roleId:"",roleName:"",type:"",userData:[],userId:[],isSingle:!0,rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",temp:{},tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],selectList:null,tableIndex:null,initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:h,deleteWarehouse:this.deleteWarehouse,deleteWarehouse_isShow:!0}},configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},newWarehouse:{name:null,id:null},pageData:null,pageNo:1}},created:function(){this.tableIndex=null,this.roleId=this.initData.temp.roleId,this.roleName=this.initData.temp.roleName,this.type=this.initData.temp.type,this.initUserData(),this.initTable()},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=u(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{checkCount:function(e,t){if(console.log(e),!e.moveCount)return this.$message({type:"warning",duration:5e3,showClose:!0,message:"输入的移库数量不能为空！"}),!1;if(!/^[0-9]+(.[0-9]{1,3})?$/.test(e.moveCount))return this.$message({type:"warning",duration:5e3,showClose:!0,message:"请输入正确移库数量！"}),e.moveCount=null,!1;var i=parseFloat(e.stockCount);return e.moveCount>i?(this.$message({type:"warning",duration:5e3,showClose:!0,message:"输入的移库数量不能大于库存数量！"}),e.moveCount=null,!1):void 0},selectWarehouse:function(){this.dialogData.title="选择库位",this.openDialogName="dialogChangeWarehouseByIn",this.showDialog=!0,this.inLinVisible=!0},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(r.m)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.tableData=e.result.varList}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==c.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==c.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}})},addTableTitle:function(e){var t=this;return e.forEach(function(e){var i=e.label;i.indexOf("_")>0&&("en"==c.a.locale?e.label=i.substring(i.indexOf("_")+1):"zh"==c.a.locale&&(e.label=i.substring(0,i.indexOf("_")))),"moveCount"===e.prop&&(e.component=g,e.checkCount=t.checkCount)}),this.internationalConfig(),e.push(this.initConfigs.tableOperates),e},internationalConfig:function(){"en"==c.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==c.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTable:function(){var e=this,t="",i=this.initData.temp;null!=i&&i.length>0&&i.forEach(function(e){null!=e.id&&e.id.trim().length>0&&(t=0==t.length?"'"+e.id.trim()+"'":t+",'"+e.id.trim()+"'")});var a="";null!=t&&t.trim().length>0&&(a="wp.id in ("+t+")"),this.dialogLoading=!0,Object(s.listPageWarehouseProductMove)(function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){d(e,t,i[t])})}return e}({},this.tempQuery,{queryStr:a,pageNo:this.pageNo})).then(function(t){e.getListPage(t),e.dialogLoading=!1}).catch(function(t){e.dialogLoading=!1})},initUserData:function(){var e=this;this.userData=[],Object(a.findListUserByRole)({userIsdisable:"1",queryStr:"role.id = '"+this.roleId+"'"}).then(function(t){var i=t.result.options;null!=i&&i.length>0&&i.forEach(function(t){var i=t.id,a=t.userName;null!=i&&i.trim().length>0&&null!=a&&a.trim().length>0&&e.userData.push({key:i,label:a,disabled:!1})})}).catch(function(e){})},dataBridge:function(e){},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},leftCheckChange:function(e){this.isSingle&&this.singleUserData(e)},singleUserData:function(e){var t=this.userData;if(null!=t&&0!=t.length)if(0==e.length)t.forEach(function(e){e.disabled=!1});else if(e.length>0){var i="";e.forEach(function(e){i=i+e+","}),t.forEach(function(e){var t=e.key;-1==i.indexOf(t)&&(e.disabled=!0)})}},addAdmin:function(){var e=this.roleId,t=this.roleName;this.dialogData.temp.roleId=e,this.dialogData.title=t+"-分配用户",this.openDialogName="dialogRoleUser",this.showDialog=!0,this.inLinVisible=!0},saveDispatch:function(){var e=this,t=this.roleId,i=this.roleName;this.type;if(null!=t&&0!=t){if(null==this.userData||0==this.userData.length)return this.dialogData.temp.roleId=t,this.dialogData.title=i+"-分配用户",this.openDialogName="dialogRoleUser",this.showDialog=!0,void(this.inLinVisible=!0);if(null!=this.userId&&0!=this.userId.length)if(this.newWarehouse.id){this.temp.warehouseId=this.newWarehouse.id;var a=this.tableData,n="";if(null!=a&&0!=a.length){for(var o=[],s=0;s<a.length;s++){var r=a[s],c={warehouseProductId:"",count:"",productName:""};if(!r.moveCount)return void this.$message({type:"warning",duration:5e3,showClose:!0,message:"第"+(s+1)+"行的移库数量不能为空！"});c.warehouseProductId=r.id,c.count=r.moveCount,c.productName=r.productName,o.push(c)}n=JSON.stringify(o),this.temp.dtlJsonStr=n;for(var d="",u=0;u<this.userId.length;u++){var h=this.userId[u];null!=h&&h.trim().length>0&&(d=d?d+","+h:h)}this.temp.executorIdsStr=d,Object(l.saveWarehouseMove)(this.temp).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(e){})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择新的库位！"});else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择执行人！"})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"仓库管理员角色ID为空或空字符串！"})},deleteWarehouse:function(e,t){this.tableData.splice(t,1)},closeDialog:function(e){"{}"!=JSON.stringify(e)&&(this.newWarehouse.id=e.id,this.newWarehouse.name=e.pathName,"ok"==e.resState&&this.initUserData()),this.inLinVisible=!1,this.showDialog=!1}},watch:{pageNo:function(){this.initTable()}}},f=i("KHd+"),b=Object(f.a)(p,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px",top:"50px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{staticStyle:{width:"300px","margin-top":"15px","margin-left":"2%"}},[i("b",[e._v("选择新库位:")]),e._v(" "),i("el-input",{attrs:{value:e.newWarehouse.name,placeholder:"请选择",disabled:!0,clearable:!0}},[i("el-button",{attrs:{slot:"append",icon:"el-icon-search"},on:{click:e.selectWarehouse},slot:"append"})],1)],1),e._v(" "),i("el-row",{staticStyle:{height:"250px","margin-top":"15px",width:"96%","margin-left":"2%"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1),e._v(" "),i("el-row",{staticStyle:{width:"60%",margin:"3% 30%"}},[i("el-transfer",{staticStyle:{height:"300px","margin-bottom":"5px"},attrs:{data:e.userData,titles:["仓库管理员","执行人"]},on:{"left-check-change":e.leftCheckChange},model:{value:e.userId,callback:function(t){e.userId=t},expression:"userId"}}),e._v(" "),i("span",{staticStyle:{"font-size":"12px",color:"#1482f0",cursor:"pointer"},on:{click:e.addAdmin}},[e._v("+添加仓库管理员")])],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveDispatch}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);b.options.__file="dialogDispatch.vue";t.default=b.exports}}]);