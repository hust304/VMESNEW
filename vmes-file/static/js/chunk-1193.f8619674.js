(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-1193"],{"3m6U":function(t,i,e){},jCec:function(t,i,e){"use strict";e.r(i);e("rE2o"),e("ioFf"),e("rGqo");var n=e("zF5t"),a=e("we3T");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{userData:[],executorIds:[],isSingle:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,temp:{}},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{},tempLable:{}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.initUserData()},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var i=parseInt(this.initData.width);return i?i>100?"100%":i+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{initUserData:function(){var t=this;Object(n.findListUserByRole)({userIsdisable:"1",queryStr:"role.name like '%仓库管理员%'"}).then(function(i){var e=i.result.options;null!=e&&e.length>0&&e.forEach(function(i){var e=i.id,n=i.userName;null!=e&&e.trim().length>0&&null!=n&&n.trim().length>0&&t.userData.push({key:e,label:n,disabled:!1})})}).catch(function(t){})},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},leftCheckChange:function(t){this.isSingle&&this.singleUserData(t)},singleUserData:function(t){var i=this.userData;if(null!=i&&0!=i.length)if(0==t.length)i.forEach(function(t){t.disabled=!1});else if(t.length>0){var e="";t.forEach(function(t){e=e+t+","}),i.forEach(function(t){var i=t.key;-1==e.indexOf(i)&&(t.disabled=!0)})}},save:function(){var t=this;if(null!=this.executorIds&&0!=this.executorIds.length){var i="";this.executorIds.forEach(function(t){i=i+t+","}),this.dialogLoading=!0,Object(a.updateExecutor)({detailId:this.temp.detailId,executorIds:i}).then(function(i){t.dialogLoading=!1,0===i.code&&(t.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择执行人！"})},closeDialog:function(t){this.showDialog=!1}},watch:{}},s=(e("kNQ0"),e("KHd+")),r=Object(s.a)(l,function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"700px"},on:{"update:visible":function(i){t.isVisible=i},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?e(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),e("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[e("div",{staticStyle:{"text-align":"center"}},[e("el-row",{staticStyle:{display:"inline-block","text-align":"left"}},[e("el-transfer",{attrs:{data:t.userData,titles:["仓库管理员","执行人"]},on:{"left-check-change":t.leftCheckChange},model:{value:t.executorIds,callback:function(i){t.executorIds=i},expression:"executorIds"}})],1)],1),t._v(" "),e("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[e("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),e("el-button",{on:{click:function(i){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)},[],!1,null,null,null);r.options.__file="dialogEditExecutor.vue";i.default=r.exports},kNQ0:function(t,i,e){"use strict";var n=e("3m6U");e.n(n).a}}]);