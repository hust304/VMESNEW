(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-5ae1","chunk-48941"],{"4/ya":function(t,e,i){"use strict";var a=i("l/0v");i.n(a).a},"6nHU":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("rGqo");var a=i("zF5t"),n=i("928u");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{userData:[],executorIds:[],isSingle:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,temp:{}},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{},tempLable:{}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.initUserData()},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{initUserData:function(){var t=this;Object(a.findListUserByRole)({userIsdisable:"1",queryStr:"role.name like '%仓库管理员%'"}).then(function(e){var i=e.result.options;null!=i&&i.length>0&&i.forEach(function(e){var i=e.id,a=e.userName;null!=i&&i.trim().length>0&&null!=a&&a.trim().length>0&&t.userData.push({key:i,label:a,disabled:!1})})}).catch(function(t){})},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},leftCheckChange:function(t){this.isSingle&&this.singleUserData(t)},singleUserData:function(t){var e=this.userData;if(null!=e&&0!=e.length)if(0==t.length)e.forEach(function(t){t.disabled=!1});else if(t.length>0){var i="";t.forEach(function(t){i=i+t+","}),e.forEach(function(t){var e=t.key;-1==i.indexOf(e)&&(t.disabled=!0)})}},save:function(){var t=this;if(null!=this.executorIds&&0!=this.executorIds.length){var e="";this.executorIds.forEach(function(t){e=e+t+","}),this.dialogLoading=!0,Object(n.updateExecutor)({detailId:this.temp.detailId,executorIds:e}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择执行人！"})},closeDialog:function(t){this.showDialog=!1}},watch:{}},s=(i("4/ya"),i("KHd+")),r=Object(s.a)(l,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"700px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{staticStyle:{width:"100%",margin:"3% 10%"}},[i("el-transfer",{attrs:{data:t.userData,titles:["仓库管理员","执行人"]},on:{"left-check-change":t.leftCheckChange},model:{value:t.executorIds,callback:function(e){t.executorIds=e},expression:"executorIds"}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="dialogEditExecutor.vue";e.default=r.exports},"l/0v":function(t,e,i){},wbrj:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("rGqo");var a=i("6nHU"),n=i("928u"),o=i("z0WU"),l=i("mSNy");function s(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}function r(t){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var c={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.editBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editBtns(scope.row,scope.$index)">修改执行人</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},d={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" :disabled=true />\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},u={components:{dialogEditExecutor:a.default},name:"dialog-add",props:["initData","visible"],data:function(){return{detail:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],selectList:null,initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:c,editBtns:this.editBtns,editBtns_isShow:!1}},configs:{tableConfigs:[],showCheckBox:!1,showIndex:!0},pageData:null,pageNo:1}},created:function(){this.detail=this.initData.temp,"1"==this.initData.temp.state&&(this.initConfigs.tableOperates.editBtns_isShow=!0),this.initTable(this.initData.temp.id)},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=r(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{initTable:function(t){var e=this;this.dialogLoading=!0,Object(n.listPageWarehouseInExecutor)(function(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){s(t,e,i[e])})}return t}({},this.tempQuery,{detailId:t,pageNo:1,pageSize:1e4})).then(function(t){e.getListPage(t),e.dialogLoading=!1}).catch(function(t){e.dialogLoading=!1})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(o.l)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.tableData=t.result.varList}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var a=t[i];a.indexOf("_")>0&&("en"==l.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==l.a.locale&&(a=a.substring(0,a.indexOf("_")))),e.tempLable[i]=a}})},addTableTitle:function(t){return t.forEach(function(t){var e=t.label;e.indexOf("_")>0&&("en"==l.a.locale?t.label=e.substring(e.indexOf("_")+1):"zh"==l.a.locale&&(t.label=e.substring(0,e.indexOf("_")))),"isdisable"===t.prop&&(t.component=d)}),this.internationalConfig(),t.push(this.initConfigs.tableOperates),t},internationalConfig:function(){"en"==l.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==l.a.locale&&(this.initConfigs.tableOperates.label="操作")},dataBridge:function(t){},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},editBtns:function(t,e){var i="";null!=this.detail&&null!=this.detail.state&&this.detail.state.trim().length>0&&(i=this.detail.state.trim()),"1"==i?(this.dialogData.temp=t,this.dialogData.title="修改执行人",this.openDialogName="dialogEditExecutor",this.showDialog=!0,this.inLinVisible=!0):this.$message({type:"warning",duration:5e3,showClose:!0,message:"明细状态必须是(执行中)允许修改执行人！"})},closeDialog:function(t){"ok"==t.resState&&this.initTable(this.initData.temp.id),this.showDialog=!1,t.resState=this.resState}},watch:{}},g=i("KHd+"),f=Object(g.a)(u,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"700px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog,"table-selected":t.tableSelected}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{staticClass:"tableContent",staticStyle:{height:"500px",width:"96%","margin-left":"2%"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo,isSortable:!0},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1),t._v(" "),i("div",{staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);f.options.__file="dialogViewExecutor.vue";e.default=f.exports}}]);