(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-edd4","chunk-534f"],{"4bO+":function(t,e,i){"use strict";var o=i("hhyJ");i.n(o).a},"E4/n":function(t,e,i){},JdTs:function(t,e,i){"use strict";var o=i("E4/n");i.n(o).a},TslA:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var o=i("V/0Z");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var a={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{deptName:!0},tempShow:{deptName:!0},rules:{name:[{required:!0,message:"请填写BOM名称",trigger:"change"}]}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(o.updateBom)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){console.log(e),t.dialogLoading=!1}))})}}},s=(i("JdTs"),i("KHd+")),l=Object(s.a)(a,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"500px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px","padding-top":"10px"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:t.tempLable.name+":",prop:"name"}},[i("el-input",{model:{value:t.temp.name,callback:function(e){t.$set(t.temp,"name",e)},expression:"temp.name"}})],1),t._v(" "),i("el-form-item",{attrs:{label:t.tempLable.remark+":",prop:"remark"}},[i("el-input",{model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,"5da8449c",null);l.options.__file="dialogEdit.vue";e.default=l.exports},bI86:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rGqo");var o=i("mSNy"),n=i("TslA"),a=i("/nWt"),s=i("V/0Z"),l=i("z0WU");function c(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},o=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(o=o.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),o.forEach(function(e){r(t,e,i[e])})}return t}function r(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var d={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},p={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdefault" :disabled="scope.row.isdefault==\'1\'" @change="colConfig.changeIsDefault(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.editBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editBtns(scope.row,scope.$index)">更换名称</el-button>\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.deleteBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.deleteBtns(scope.row,scope.$index)">删除</el-button>\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.viewBomBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.viewBomBtns(scope.row,scope.$index)">查看/编辑</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},g={name:"dialog-option",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"",userInfo:null,topBarBtnList:[{name:"查询",icon:"search",method:this.queryTable},{name:"重置",icon:"refresh",plain:!0,method:this.resetQueryTemp}],initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",btnName:"编辑",isPropName:!0,component:u,editBtns:this.editBtns,editBtns_isShow:!0,viewBomBtns:this.viewBomBtns,viewBomBtns_isShow:!0,deleteBtns:this.deleteBtns,deleteBtns_isShow:!0}},configs:{topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.addNew},{name:"导出",nameEn:"export",isShow:!0,icon:"export",method:this.exportExcel}],tableConfigs:[],showCheckBox:!1,showIndex:!1,isSingle:!1},tableData:[],selectList:[],queryParms:[{name:"code"},{name:"name"}],tempQuery:{},tempLable:{},pageData:null,pageNo:1,openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{dialogEdit:n.default,dialogView:a.default},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.configs.isSingle=this.initData.isSingle,this.userInfo=this.$storage.get("userInfo"),this.initTable(!0)},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(){this.$emit("close-dialog",{resState:"ok"})},queryTable:function(){this.pageNo=1,this.initTable()},initTable:function(t){var e=this;e.dialogTopLoading=!0,Object(s.listPageBoms)(c({},e.tempQuery,{modelCode:"BomList",queryStr:" bom.id is not null ",prodId:this.initData.temp.prodId,pageNo:e.pageNo,orderStr:"bom.isdefault desc"})).then(function(i){e.getListPage(i),t&&(e.dialogTopLoading=!1)}).catch(function(t){e.dialogTopLoading=!1})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(l.l)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!1,this.configs.showIndex=!0,this.tableData=t.result.varList}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var n=t[i];n.indexOf("_")>0&&("en"==o.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==o.a.locale&&(n=n.substring(0,n.indexOf("_")))),e.tempLable[i]=n}})},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==o.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==o.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"是否启用"===t.label&&(t.component=d,t.changeState=e.changeState),"是否默认"===t.label&&(t.component=p,t.changeIsDefault=e.changeIsDefault)}),t.push(e.initConfigs.tableOperates),t},viewBomBtns:function(t,e){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="查看/编辑",this.openDialogName="dialogView",this.showDialog=!0,this.visibleState=!0},editBtns:function(t,e){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="编辑",this.openDialogName="dialogEdit",this.showDialog=!0,this.visibleState=!0},deleteBtns:function(t,e){var i=this;i.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var e=t.id;Object(s.deleteBoms)(e).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),i.refreshTable())}).catch(function(t){console.log(t)})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},changeIsDefault:function(t,e){var i=this;Object(s.updateIsDefaultBom)(t.id,t.isdefault,this.initData.temp.prodId).then(function(t){i.refreshTable()}).catch(function(t){console.log(t)})},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.refreshTable()},refreshTable:function(){var t=this;t.$axios.all([Object(s.listPageBoms)(c({},t.tempQuery,{prodId:this.initData.temp.prodId,modelCode:"BomList",pageNo:t.pageNo}))]).then(t.$axios.spread(function(e){t.getListPage(e)})).catch(function(t){console.log(t)})},dataBridge:function(t){this.selectList=t},resetQueryTemp:function(){for(var t in this.tempQuery)this.tempQuery[t]=""}},computed:{dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable()}}},f=(i("4bO+"),i("KHd+")),m=Object(f.a)(g,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.title,visible:t.isVisible,"append-to-body":"",width:"900px"},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}]},[i("div",{staticStyle:{padding:"7px"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,isSingle:t.configs.isSingle,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)},[],!1,null,null,null);m.options.__file="dialogList.vue";e.default=m.exports},hhyJ:function(t,e,i){}}]);