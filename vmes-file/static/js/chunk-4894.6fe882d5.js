(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4894"],{"4/ya":function(e,t,i){"use strict";var o=i("l/0v");i.n(o).a},"6nHU":function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("rGqo");var o=i("zF5t"),a=i("928u");function n(e){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var l={components:{customBaseTable:i("WIyV").a},name:"dialog-add",props:["initData","visible"],data:function(){return{userData:[],executorIds:[],isSingle:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,temp:{}},dialogLoading:!1,isVisible:!1,inDialog:!0,tableData:[],rowTableList:[],apiObj:{apiName:"listUserByRole",params:{pageNo:1,userIsdisable:"1",queryStr:"role.name like '%仓库管理员%'",fieldCode:"userCode,userName,roleName"}},customColumn:[],mergeTitle:[],mergeColumn:[],mergeRow:[],temp:{},tempLable:{}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.initUserData()},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=n(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{initUserData:function(){var e=this;Object(o.findListUserByRole)({userIsdisable:"1",queryStr:"role.name like '%仓库管理员%'"}).then(function(t){var i=t.result.options;null!=i&&i.length>0&&i.forEach(function(t){var i=t.id,o=t.userName;null!=i&&i.trim().length>0&&null!=o&&o.trim().length>0&&e.userData.push({key:i,label:o,disabled:!1})})}).catch(function(e){})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},leftCheckChange:function(e){this.isSingle&&this.singleUserData(e)},singleUserData:function(e){var t=this.userData;if(null!=t&&0!=t.length)if(0==e.length)t.forEach(function(e){e.disabled=!1});else if(e.length>0){var i="";e.forEach(function(e){i=i+e+","}),t.forEach(function(e){var t=e.key;-1==i.indexOf(t)&&(e.disabled=!0)})}},databridge:function(e){e.length&&(this.executorIds=[e[0].id])},save:function(){var e=this;if(null!=this.executorIds&&0!=this.executorIds.length){var t="";this.executorIds.forEach(function(e){t=t+e+","}),this.dialogLoading=!0,Object(a.updateExecutor)({detailId:this.temp.detailId,executorIds:t}).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(e){})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择执行人！"})},closeDialog:function(e){this.showDialog=!1}},watch:{}},s=(i("4/ya"),i("KHd+")),r=Object(s.a)(l,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"700px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{staticStyle:{padding:"10px"}},[i("custom-base-table",{ref:"editExecutorDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,showCheckBox:!0,isSingle:!0,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"editExecutorDialog",useDefaultBtn:!1,showAll:!1},on:{databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="dialogEditExecutor.vue";t.default=r.exports},"l/0v":function(e,t,i){}}]);