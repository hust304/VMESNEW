(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-1589","QYBy","Ikhz"],{HhWc:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("f3/d"),i("rGqo");var a=i("uTIz"),n=i("QYBy"),o=i("Ikhz"),s=i("9WTv"),l=i("WI6C"),r=i("Vobf"),c=i("z0WU"),d=i("mSNy");function u(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var f={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t\t\t\x3c!--<el-button  v-show="colConfig.qrcodeBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.qrcodeBtns(scope.row,scope.$index)">二维码</el-button>--\x3e\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.editByRow_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editByRow(scope.row,scope.$index)">编辑</el-button>\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.deleteByRow_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.deleteByRow(scope.row,scope.$index)">删除</el-button>\n    \t\t\t\t\t</div>\n\n  \t\t\t\t</el-table-column>'},p={components:{searchBar:a.a,dialogAdd:n.default,dialogEdit:o.default},data:function(){return{fieldCode:"code,name,spec,deptName,content,remark",guid:"",searchList:[{label:"设备编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"设备编码"},{label:"设备名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"设备名称"},{label:"设备型号",type:"input",ruleType:"string",mapKey:"spec",configs:{},placeholder:"设备型号"},{label:"保养内容",type:"input",ruleType:"string",mapKey:"content",configs:{},placeholder:"保养内容"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null,nodeId:null},initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:f,editByRow:this.editByRow,editByRow_isShow:!0,deleteByRow:this.deleteByRow,deleteByRow_isShow:!0}},configs:{topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.dialogAdd}],tableConfigs:[],showCheckBox:!1,showIndex:!0},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},beforeCreate:function(){},created:function(){this.initButtons(),this.initTree()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(t){this.tempQuery=t,this.pageNo=1,this.initTable(this.selectTree.id,this.selectTree.type,this.selectTree.layer,null)},sendGuid:function(t){this.guid=t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.initTree()},initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&(t.$loading({spinner:"preloader",text:""}),Object(r.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){if(t.initConfigs&&t.initConfigs.tableOperates)for(var i in t.initConfigs.tableOperates)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t.initConfigs.tableOperates[i]=!1);if(t.customColumn)for(var a in t.customColumn)if(a){var n=t.customColumn[a];n.length>0&&n.forEach(function(t){if(t)for(var i in t)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t[i]=!1)})}t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){t.$loading().close()}))},initTable:function(t,e,i,a){var n=this;Object(l.listPageMaintainContent)(function(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){u(t,e,i[e])})}return t}({},this.tempQuery,{fieldCode:this.fieldCode,id:t,type:e,layer:i,dataType:this.$storage.get("dataType"),maintainContentIsdisable:"1",equipmentIsdisable:"1",pageNo:this.pageNo})).then(function(t){a&&n.$loading().close(),n.getListPage(t)}).catch(function(t){n.$loading().close()})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(c.o)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var a=t[i];a.indexOf("_")>0&&("en"==d.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==d.a.locale&&(a=a.substring(0,a.indexOf("_")))),e.tempLable[i]=a}})},addTableTitle:function(t){return t.forEach(function(t){var e=t.label;e.indexOf("_")>0&&("en"==d.a.locale?t.label=e.substring(e.indexOf("_")+1):"zh"==d.a.locale&&(t.label=e.substring(0,e.indexOf("_"))))}),this.internationalConfig(),t.push(this.initConfigs.tableOperates),t},internationalConfig:function(){"en"==d.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==d.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTree:function(){var t=this;Object(s.treeDepartmentEquipment)({deptDisable:"1",eqptDisable:"1",deptID:this.$storage.get("userInfo").companyId}).then(function(e){var i=[],a=e.result.treeList;t.selectTree={pid:a.pid,id:a.id,type:a.type,layer:a.layer,deptName:a.deptName,eqptName:a.eqptName},i.push(a),t.treeData=i,t.initTable(t.selectTree.id,t.selectTree.type,t.selectTree.layer,!0),t.$nextTick(function(){t.$refs.tree.$children[0].setCurrentKey(t.selectTree.id)})}).catch(function(e){t.$loading().close()})},treeDataBridge:function(t){this.selectTree={pid:t.nodeData.pid,id:t.nodeData.id,name:t.nodeData.name,type:t.nodeData.type,layer:t.nodeData.layer,deptName:t.nodeData.deptName,eqptName:t.nodeData.eqptName},this.pageNo=1,this.initTable(this.selectTree.id,this.selectTree.type,this.selectTree.layer)},dataBridge:function(t){this.selectList=t,t.length?this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!1)}):this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})},deleteByRow:function(t,e){var i=this;this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(l.updateDisableMaintainContent)({id:t.id}).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),i.initTree())}).catch(function(t){})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},dialogAdd:function(){var t=this.selectTree.type,e=this.selectTree.id;"dept"!=t?"eqpt"==t&&(this.dialogData.equipmentId=e,this.dialogData.title="新增设备保养内容",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0):this.$message({showClose:!0,message:"当前节点为部门，请选择设备节点！(设备在部门下面，如果部门下无设备请于管理员联系)",duration:5e3})},editByRow:function(t,e){var i=JSON.parse(JSON.stringify(t));this.dialogData.rowData=i,this.dialogData.tempLable=this.tempLable,this.dialogData.title="编辑设备保养内容",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable(this.selectTree.id,this.selectTree.type,this.selectTree.layer)}}},g=(i("kCyh"),i("KHd+")),h=Object(g.a)(p,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"maintainContent"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:t.treeData,treeConfigs:t.treeConfigs},on:{treedatabridge:t.treeDataBridge}})],1),t._v(" "),i("el-col",{staticClass:"tableStyle",attrs:{span:20}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state,dialog:t.dialog},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);h.options.__file="index.vue";e.default=h.exports},Ikhz:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("WI6C");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{content:[{required:!0,trigger:"change",message:"请填写保养内容"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:""},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{id:"",content:"",remark:""}}},created:function(){var t=this.initData.rowData;this.formData.id=t.id,this.formData.content=t.content,this.formData.remark=t.remark},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dataBridge:function(t){},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},deleteBtns:function(t,e){this.tableData.splice(e,1)},closeDialog:function(t){},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&Object(a.updateMaintainContent)(t.formData).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})}},watch:{}},s=i("KHd+"),l=Object(s.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"350px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{margin:"10px auto",width:"100%"}},[i("el-form",{ref:"submitForm",attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-form-item",{attrs:{label:"保养内容:",prop:"content"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:t.formData.content,callback:function(e){t.$set(t.formData,"content",e)},expression:"formData.content"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"备注:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{type:"textarea",rows:"2"},model:{value:t.formData.remark,callback:function(e){t.$set(t.formData,"remark",e)},expression:"formData.remark"}})],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogEdit.vue";e.default=l.exports},JTqL:function(t,e,i){},QYBy:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("WI6C");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{content:[{required:!0,trigger:"change",message:"请填写保养内容"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:""},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{equipmentId:"",content:"",remark:""}}},created:function(){this.formData.equipmentId=this.initData.equipmentId},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dataBridge:function(t){},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},deleteBtns:function(t,e){this.tableData.splice(e,1)},closeDialog:function(t){},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&Object(a.addMaintainContent)(t.formData).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})}},watch:{}},s=i("KHd+"),l=Object(s.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"350px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{margin:"10px auto",width:"100%"}},[i("el-form",{ref:"submitForm",attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-form-item",{attrs:{label:"保养内容:",prop:"content"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:t.formData.content,callback:function(e){t.$set(t.formData,"content",e)},expression:"formData.content"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"备注:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{type:"textarea",rows:"2"},model:{value:t.formData.remark,callback:function(e){t.$set(t.formData,"remark",e)},expression:"formData.remark"}})],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogAdd.vue";e.default=l.exports},kCyh:function(t,e,i){"use strict";var a=i("JTqL");i.n(a).a}}]);