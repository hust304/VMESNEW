(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-c48f"],{Aqwb:function(t,i,e){"use strict";e.r(i);e("rE2o"),e("ioFf"),e("rGqo"),e("91GP"),e("xfY5");var a=e("z0WU"),s=e("Yfch");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}function o(t,i,e){return i in t?Object.defineProperty(t,i,{value:e,enumerable:!0,configurable:!0,writable:!0}):t[i]=e,t}var r={name:"searchBar-tree-and-table",components:{searchBar:e("uTIz").a},props:{initData:{type:Object,default:function(){return null}},visible:{type:Boolean,default:!1},showCheckBox:{type:Boolean,default:!1},showIndex:{type:Boolean,default:!1},searchList:{type:Array,default:function(){return[]}},isSingle:{type:Boolean,default:!1},isFixed:{type:Number,default:1},isSortable:{type:Boolean,default:!1},tableBtns:{type:Array,default:function(){return[]}},layout:{type:String,default:"left"},scrollTree:{type:Boolean,default:!1},width:{type:[String,Number],default:900},treeWidth:{type:[String,Number],default:200},title:{type:String,default:"树表弹窗"}},data:function(){var t;return o(t={isVisible:!1,dialogLoading:!1,checkedList:[],userSelectData:{},selectData:{},currentpage:1,tableData:[],pageData:{},tableConfigs:{titleList:[],showCheckBox:!0,showIndex:!0,isSingle:!0,isSortable:!0,isFixed:1},componentKeys:[],treeLoading:!1,dialogTree:[]},"checkedList",[]),o(t,"isRoll",!0),o(t,"tableParamsObj",{}),t},beforeCreate:function(){},created:function(){this.isVisible=this.visible,this.initData.apiName&&"object"===n(this.initData.apiName)?(this.treeLoading=!0,this.dialogLoading=!0,this.initData.apiName.tree.api?this.httpTreeMethod(this.initData.apiName.tree.api,this.initData.apiName.tree.params):this.$message({message:"apiName参数错误",type:"error",duration:2e3})):this.$message({message:"参数错误",type:"error",duration:2e3})},beforeMount:function(){},mounted:function(){},watch:{currentpage:function(){var t=this.getParams(this.userSelectData.nodeData);t.pageNo=this.currentpage,this.dialogLoading=!0,this.httpTableMethod(this.initData.apiName.table.api,t,this.tableParamsObj)}},computed:{configs:function(){return{showDisable:!!this.initData.showDisable,keyboard:!!this.initData.keyboard,showSearch:!!this.initData.showSearch}},isScrollTree:function(){return this.scrollTree?this.scrollTree:void 0!==this.initData.scrollTree&&this.initData.scrollTree},setTreeWidth:function(){if(this.initData.treeWidth){var t=n(this.initData.treeWidth);return"string"===t?this.initData.treeWidth:"number"===t?this.initData.treeWidth+"px":"200px"}var i=n(this.treeWidth);return"string"===i?this.treeWidth:"number"===i?this.treeWidth+"px":"200px"},setLayout:function(){return this.initData.layoutType?this.isRoll?"right"===this.initData.layoutType?{right:0}:{left:0}:"right"===this.initData.layoutType?{right:"calc(-".concat(this.setTreeWidth," + 15px)")}:{left:"calc(-".concat(this.setTreeWidth," + 15px)")}:this.isRoll?"right"===this.layout?{right:0}:{left:0}:"right"===this.layout?{right:"calc(-".concat(this.setTreeWidth," + 15px)")}:{left:"calc(-".concat(this.setTreeWidth," + 15px)")}},setPadding:function(){return this.initData.layoutType?"right"===this.initData.layoutType?{paddingLeft:"10px"}:{paddingRight:"10px"}:"right"===this.layout?{paddingLeft:"10px"}:{paddingRight:"10px"}},setFixed:function(){return this.initData.layoutType?"right"===this.initData.layoutType?{left:"10px",right:0,boxShadow:"-5px 0 10px -5px rgba(0,0,0,0.3)"}:{left:0,right:"10px",boxShadow:"5px 0 10px -5px rgba(0,0,0,0.3)"}:"right"===this.layout?{left:"10px",right:0,boxShadow:"-5px 0 10px -5px rgba(0,0,0,0.3)"}:{left:0,right:"10px",boxShadow:"5px 0 10px -5px rgba(0,0,0,0.3)"}},setArrowPosition:function(){return this.initData.layoutType?"right"===this.initData.layoutType?{left:"-2px"}:{right:"-10px"}:"right"===this.layout?{left:"-2px"}:{right:"-10px"}},setTopArrow:function(){return this.initData.layoutType?"right"===this.initData.layoutType?"el-icon-d-arrow-right":"el-icon-d-arrow-left":"right"===this.layout?"el-icon-d-arrow-right":"el-icon-d-arrow-left"},setBottomArrow:function(){return"el-icon-d-arrow-right"===this.setTopArrow?"el-icon-d-arrow-left":"el-icon-d-arrow-right"},setTableWidth:function(){var t={};return t["padding-"+(this.initData.layoutType?this.initData.layoutType:this.layout)]=this.isRoll?this.setTreeWidth:"15px",t},dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);return"string"===t?this.initData.width:"number"===t?this.initData.width+"px":"900px"}var i=n(this.width);return"string"===i?this.width:"number"===i?this.width+"px":"900px"},setCheckBoxState:function(){return!!this.showCheckBox||(this.initData.tableOption?void 0===this.initData.tableOption.showCheckBox?this.tableConfigs.showCheckBox:this.initData.tableOption.showCheckBox:this.tableConfigs.showCheckBox)},setIndexState:function(){return!!this.showIndex||(this.initData.tableOption?void 0===this.initData.tableOption.showIndex?this.tableConfigs.showIndex:this.initData.tableOption.showIndex:this.tableConfigs.showIndex)},setSingle:function(){return!!this.isSingle||(this.initData.tableOption?void 0===this.initData.tableOption.isSingle?this.tableConfigs.isSingle:this.initData.tableOption.isSingle:this.tableConfigs.isSingle)},setSortable:function(){return!!this.isSortable||(this.initData.tableOption?void 0===this.initData.tableOption.isSortable?this.tableConfigs.isSortable:this.initData.tableOption.isSortable:this.tableConfigs.isSortable)},setSearchList:function(){return this.searchList.length?this.searchList:this.initData.tableOption?void 0===this.initData.tableOption.searchList?[]:this.initData.tableOption.searchList:[]}},methods:{getParams:function(t){var i={};for(var e in t||(t={}),this.initData.apiName.table.params)this.initData.apiName.table.params.hasOwnProperty(e)&&(i[e]=t[e]?t[e]:"");return i},checkTableParams:function(t){for(var i in t)t.hasOwnProperty(i)&&t[i]&&(this.tableParamsObj[i]=t[i])},httpTreeMethod:function(t,i,e){var a=this;this.$api[t](Object.assign(i||{},e||{})).then(function(t){console.log(t),a.treeLoading=!1,a.dialogTree.push(t.result.treeList),a.checkTableParams(a.initData.apiName.table.params),a.httpTableMethod(a.initData.apiName.table.api,a.getParams(a.dialogTree[0]),a.tableParamsObj),a.initData.apiName.table.isInit&&(a.tableParamsObj={})}).catch(function(t){a.dialogLoading=!1})},httpTableMethod:function(t,i,e){var a=this;this.$api[t](Object.assign(i||{},e||{})).then(function(t){console.log(t),a.dialogLoading=!1,a.getListPage(t)}).catch(function(t){a.dialogLoading=!1})},searchMap:function(t){console.log(t),this.dialogLoading=!0,this.httpTableMethod(this.initData.apiName.table.api,this.getParams(this.userSelectData.nodeData),Object.assign({},t,this.tableParamsObj))},getListPage:function(t){if(t){t.result.titles="string"==typeof t.result.titles?JSON.parse(t.result.titles):t.result.titles,t.result.varList="string"==typeof t.result.varList?JSON.parse(t.result.varList):t.result.varList,t.result.pageData="string"==typeof t.result.pageData?JSON.parse(t.result.pageData):t.result.pageData;var i=Object(a.m)(t.result),e=this.addTableTitle(i);console.log(e),this.tableConfigs.titleList=e,this.pageData=t.result.pageData,this.tableData=t.result.varList}},addTableTitle:function(t){return(this.initData.tableBtns&&this.initData.tableBtns.length||this.tableBtns.length)&&(this.initData.tableBtns.length?this.initData.tableBtns:this.tableBtns).forEach(function(i){Object(s.a)(i.columnIndex)?t.splice(i.columnIndex,0,i):"first"===i.columnIndex?t.unshift(i):"last"===i.columnIndex?t.push(i):t.some(function(t){if(t.prop===i.columnIndex)return Object.assign(t,i),!0})}),t},dialogClose:function(t){this.$emit("close-dialog",this.selectData,this.initData)},dataBridge:function(t,i){this.selectData=t},dialogDataBridge:function(t,i){this.userSelectData=t,console.log(this.userSelectData),this.dialogLoading=!0,this.httpTableMethod(this.initData.apiName.table.api,this.getParams(this.userSelectData.nodeData),this.tableParamsObj),i&&(this.isVisible=!1)},save:function(){this.isVisible=!1},clear:function(){this.$emit("close-dialog",null,this.initData)},disableState:function(t){var i=this;console.log(t),this.$api[this.initData.apiName.tree.api](Object.assign({},this.initData.apiName.tree.params,{disableState:t})).then(function(t){i.dialogLoading=!1,i.dialogTree=i.screenData(t)}).catch(function(t){i.dialogLoading=!1})}}},l=(e("nrmB"),e("KHd+")),h=Object(l.a)(r,function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:t.title,visible:t.isVisible,"append-to-body":"",width:t.dialogWidth},on:{"update:visible":function(i){t.isVisible=i},close:t.dialogClose}},[e("div",{staticStyle:{position:"relative",overflow:"hidden"}},[e("div",{staticClass:"treeBox",staticStyle:{position:"absolute",top:"-10px",bottom:"0",overflow:"hidden",transition:"right 0.3s,left 0.3s","-webkit-transition":"right 0.3s,left 0.3s","-moz-transition":"right 0.3s,left 0.3s"},style:[t.setLayout,{width:t.setTreeWidth}]},[e("div",{staticStyle:{position:"relative","box-sizing":"border-box",height:"100%"},style:t.setPadding},[e("div",{staticStyle:{position:"absolute",top:"-10px",bottom:"-10px",padding:"30px 10px 20px 10px","box-sizing":"border-box","background-color":"#EBF0F6"},style:t.setFixed},[e("base-tree",{directives:[{name:"loading",rawName:"v-loading",value:t.treeLoading,expression:"treeLoading"}],ref:"dialogTree",attrs:{data:t.dialogTree,treeConfigs:t.configs,checkedList:t.checkedList,keyClose:!1},on:{treedatabridge:t.dialogDataBridge,"disable-state":t.disableState}})],1),t._v(" "),t.isScrollTree?e("div",{staticStyle:{position:"absolute",top:"50%",transform:"translate(0,-50%)",width:"20px",height:"20px"},style:t.setArrowPosition},[e("div",{staticStyle:{position:"relative",height:"100%"}},[e("span",{directives:[{name:"show",rawName:"v-show",value:t.isRoll,expression:"isRoll"}],staticStyle:{position:"absolute",top:"0",left:"0",right:"0",bottom:"0"},attrs:{title:"收起侧边栏"},on:{click:function(i){t.isRoll=!t.isRoll}}},[e("i",{class:t.setTopArrow,staticStyle:{display:"block","font-size":"13px","line-height":"1.5"}})]),t._v(" "),e("span",{directives:[{name:"show",rawName:"v-show",value:!t.isRoll,expression:"!isRoll"}],staticStyle:{position:"absolute",top:"0",left:"0",right:"0",bottom:"0"},attrs:{title:"展开侧边栏"},on:{click:function(i){t.isRoll=!t.isRoll}}},[e("i",{class:t.setBottomArrow,staticStyle:{display:"block","font-size":"13px","line-height":"1.5"}})])])]):t._e()])]),t._v(" "),e("div",{staticStyle:{height:"100%","box-sizing":"border-box",transition:"padding-right 0.3s,padding-left 0.3s","-webkit-transition":"padding-right 0.3s,padding-left 0.3s","-moz-transition":"padding-right 0.3s,padding-left 0.3s"},style:t.setTableWidth},[e("div",{staticClass:"el- tableBox"},[t.setSearchList.length?e("div",{staticStyle:{margin:"10px 10px 0 10px"}},[e("search-bar",{attrs:{searchList:t.setSearchList},on:{"search-map":t.searchMap}})],1):t._e(),t._v(" "),e("div",{staticStyle:{"box-sizing":"border-box",padding:"10px",overflow:"auto"},style:t.tableData.length?"height: 400px":""},[e("base-table",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],ref:"searchTables",attrs:{data:t.tableData,colConfigs:t.tableConfigs.titleList,showCheckBox:t.setCheckBoxState,showIndex:t.setIndexState,pageData:t.pageData,currentpage:t.currentpage,isSingle:t.setSingle,isSortable:t.setSortable},on:{"update:currentpage":function(i){t.currentpage=i},databridge:t.dataBridge}})],1),t._v(" "),e("div",{staticStyle:{"text-align":"center",padding:"10px 20px","box-sizing":"border-box"}},[e("div",{staticClass:"dialog-footer"},[e("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("确 定")]),t._v(" "),e("el-button",{attrs:{plain:"",type:"primary"},on:{click:t.clear}},[t._v("清 空")])],1)])])])])])},[],!1,null,null,null);h.options.__file="treeAndTable.vue";i.default=h.exports},FX97:function(t,i,e){},nrmB:function(t,i,e){"use strict";var a=e("FX97");e.n(a).a}}]);