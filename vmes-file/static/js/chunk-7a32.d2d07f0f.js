(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7a32"],{F0s3:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rGqo");var a=i("mSNy"),o=i("a0Xs"),n=i("c+Jk"),l=i("iA4u"),s=i("z0WU");function c(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){r(t,e,i[e])})}return t}function r(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var p={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" :disabled="scope.row.type===\'计量单位\'" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},d={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdefault" @change="colConfig.changeIsdefault(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.editBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editBtns(scope.row,scope.$index)">编辑</el-button>\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.deleteBtns_isShow&&scope.row.isdisable==\'0\'" type="text" class="btns" style="font-size: 12px;" @click="colConfig.deleteBtns(scope.row,scope.$index)">删除</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},g={name:"dialog-option",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"",userInfo:null,topBarBtnList:[{name:"查询",icon:"search",method:this.queryTable},{name:"重置",icon:"refresh",plain:!0,method:this.resetQueryTemp}],initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",btnName:"编辑",isPropName:!0,component:u,editBtns:this.editBtns,editBtns_isShow:!0,deleteBtns:this.deleteBtns,deleteBtns_isShow:!0}},configs:{topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.addNew}],tableConfigs:[],showCheckBox:!1,showIndex:!1,isSingle:!1},tableData:[],selectList:[],queryParms:[{name:"code"},{name:"name"}],temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1,openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{dialogUnitAdd:n.default,dialogUnitEdit:l.default},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.configs.isSingle=this.initData.isSingle,this.userInfo=this.$storage.get("userInfo"),this.initTable(!0)},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{editBtns:function(t,e){this.dialogData.temp=t,this.dialogData.tempLable=this.tempLable,this.dialogData.title="编辑",this.openDialogName="dialogUnitEdit",this.showDialog=!0,this.visibleState=!0},changeState:function(t,e){Object(o.g)(t.id,t.isdisable).then(function(t){}).catch(function(t){console.log(t)})},deleteBtns:function(t,e){var i=this;i.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(o.a)(t.id).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),i.initTable(!0))}).catch(function(t){console.log(t)})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},dialogClose:function(){this.$emit("close-dialog",{resState:"ok"})},queryTable:function(){this.pageNo=1,this.initTable(!0)},initTable:function(t){var e=this;e.dialogTopLoading=!0,Object(o.e)(c({},e.tempQuery,{productId:this.initData.temp.id,pageNo:e.pageNo})).then(function(i){e.getListPage(i),t&&(e.dialogTopLoading=!1)}).catch(function(t){e.dialogTopLoading=!1})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(s.j)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=t.result.varList}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var o=t[i];o.indexOf("_")>0&&("en"==a.a.locale?o=o.substring(o.indexOf("_")+1):"zh"==a.a.locale&&(o=o.substring(0,o.indexOf("_")))),e.tempLable[i]=o}})},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==a.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==a.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"是否启用"===t.label&&(t.component=p,t.changeState=e.changeState),"是否默认"===t.label&&(t.component=d,t.changeIsdefault=e.changeIsdefault)}),t.push(e.initConfigs.tableOperates),t},addNew:function(){this.dialogData.temp=this.initData.temp,this.dialogData.tempLable=this.initData.tempLable,this.dialogData.title="新增计价单位",this.openDialogName="dialogUnitAdd",this.showDialog=!0,this.visibleState=!0},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},changeIsdefault:function(t,e){var i=this;Object(o.h)(t.id,t.isdefault,t.productId).then(function(t){i.refreshTable()}).catch(function(t){console.log(t)})},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.refreshTable()},refreshTable:function(){var t=this;t.$axios.all([Object(o.e)(c({},t.tempQuery,{productId:this.initData.temp.id,pageNo:t.pageNo}))]).then(t.$axios.spread(function(e){t.getListPage(e)})).catch(function(t){console.log(t)})},dataBridge:function(t){this.selectList=t},resetQueryTemp:function(){for(var t in this.tempQuery)this.tempQuery[t]=""}},computed:{dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable()}}},f=i("KHd+"),m=Object(f.a)(g,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.title,visible:t.isVisible,"append-to-body":"",width:"1300px"},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{height:"100%"},attrs:{span:24}},[i("div",{staticStyle:{height:"50px","box-sizing":"border-box",padding:"7px 20px 7px 7px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2),t._v(" "),i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,isSingle:t.configs.isSingle,isSortable:!1,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)]),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e()],1)])},[],!1,null,null,null);m.options.__file="dialogUnit.vue";e.default=m.exports},iA4u:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("a0Xs");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{formulaDialog:i("Ck00").a},name:"dialog-edit",props:["initData","visible"],data:function(){var t=this;return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{punitName:[{required:!0,trigger:"change",validator:function(e,i,a){t.unitData.defaultSelected.length<=0?a(new Error("请选择计价单位")):a()}}]},unitData:{data:{selectUrl:"/dictionary/getDictionarys",selectParm:{dictionaryKey:"productUnit",isglobal:"0"}},defaultSelected:[""]},formTemp:[],showDialog:!1,visibleState:!1,dialogName:"",formulaState:""}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{openFormulaEdit:function(t){this.dialogName="formulaDialog",this.showDialog=!0,this.formulaState=t,this.visibleState=!0},dialogOpen:function(){this.unitData.defaultSelected=[this.initData.temp.punit],this.temp.unit=this.initData.temp.punit},unitSelect:function(t){t[0]?(this.temp.unit=t[0],this.unitData.defaultSelected=[t[0]]):(this.temp.unit=[],this.unitData.defaultSelected=[])},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;t.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(a.i)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1}))})}}},l=i("KHd+"),s=Object(l.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"620px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"单位类型:",prop:"type"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.type,callback:function(e){t.$set(t.temp,"type",e)},expression:"temp.type"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"单位:",prop:"punitName"}},[i("base-input-select",{attrs:{data:t.unitData.data},on:{callback:t.unitSelect},model:{value:t.unitData.defaultSelected,callback:function(e){t.$set(t.unitData,"defaultSelected",e)},expression:"unitData.defaultSelected"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:"计价单位"==t.temp.type,expression:"temp.type=='计价单位'"}],attrs:{label:"计量单位转换计价单位(公式):",prop:"npFormula"}},[i("el-input",{staticStyle:{width:"450px"},attrs:{type:"textarea",rows:"3",disabled:!0},model:{value:t.temp.npFormula,callback:function(e){t.$set(t.temp,"npFormula",e)},expression:"temp.npFormula"}}),t._v(" "),i("el-button",{attrs:{type:"text",icon:"el-icon-plus"},on:{click:function(e){t.openFormulaEdit("n")}}},[t._v("公式编辑器")])],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:"计价单位"==t.temp.type,expression:"temp.type=='计价单位'"}],attrs:{label:"计价单位转换计量单位(公式):",prop:"pnFormula"}},[i("el-input",{staticStyle:{width:"450px"},attrs:{type:"textarea",rows:"3",disabled:!0},model:{value:t.temp.pnFormula,callback:function(e){t.$set(t.temp,"pnFormula",e)},expression:"temp.pnFormula"}}),t._v(" "),i("el-button",{attrs:{type:"text",icon:"el-icon-plus"},on:{click:function(e){t.openFormulaEdit("p")}}},[t._v("公式编辑器")])],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{staticStyle:{width:"450px"},attrs:{type:"textarea",rows:"2"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{state:t.formulaState,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);s.options.__file="dialogUnitEdit.vue";e.default=s.exports}}]);