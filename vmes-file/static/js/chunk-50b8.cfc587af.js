(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-50b8","chunk-96c3","chunk-913f"],{"7+Lp":function(t,e,a){"use strict";var i=a("MQ7q");a.n(i).a},"9+6w":function(t,e,a){},"9WTv":function(t,e,a){"use strict";a.d(e,"d",function(){return n}),a.d(e,"a",function(){return s}),a.d(e,"f",function(){return o}),a.d(e,"e",function(){return l}),a.d(e,"b",function(){return r}),a.d(e,"c",function(){return c});var i=a("t3Un");function n(t){return Object(i.a)({url:"/base/equipment/listPageEquipments",method:"post",data:t})}function s(t){return Object(i.a)({url:"/base/equipment/addEquipment",method:"post",data:t})}function o(t){return Object(i.a)({url:"/base/equipment/updateEquipment",method:"post",data:t})}function l(t,e){return Object(i.a)({url:"/base/equipment/update",method:"post",data:{id:t,isdisable:e}})}function r(t){return Object(i.a)({url:"/base/equipment/deleteByIds",method:"post",data:{ids:t}})}function c(t){return Object(i.a)({url:"/base/equipment/exportExcelEquipments",method:"post",responseType:"blob",data:{ids:t}})}},FK0u:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf"),a("rGqo"),a("91GP"),a("f3/d");var i=a("f/WR"),n=a("uTIz"),s=a("5W5M"),o=(a("xMja"),a("uXxI"));function l(t){return(l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var r={components:{transferTable:i.a,searchBar:n.a},name:"dialogAddByProduct",props:["initData","visible"],data:function(){return{temp:{productIds:""},tempLable:{},rules:{},guid:"",tempQuery:{},searchList:[{label:"货品编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"货品名称"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!1,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},pageData:null,pageNo:1,treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},btnList:[{name:"生成盘点任务",isShow:!0,state:!0,method:this.addWarehouseCheck},{name:"清空",icon:"refresh",state:!0,plain:!0,method:this.resetQuery,isShow:!0}],apiData:{apiName:"listPageProducts",params:{fieldCode:"code,name,spec,unitName,genreName,cdate",genreId:"",isNeedWarehouseProduct:"true",isdisable:"1",orderStr:"prod.cdate desc"}},tableSelectList:[],stateBtnData:{},tableConfigs:{showIndex:!0},tempList:[],searchObj:{}}},created:function(){this.initTree()},mounted:function(){this.isVisible=this.visible},computed:{tableHeight:function(){},dialogWidth:function(){if(this.initData.width){var t=l(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{treeDataBridge:function(t){this.selectTree={pid:t.nodeData.pid,id:t.nodeData.id,name:t.nodeData.name},this.pageNo=1,this.apiData.params=Object.assign({},this.searchObj,this.apiData.params,{genreId:this.selectTree.id})},initTree:function(){var t=this;this.dialogLoading=!0,Object(s.listTreeDictionary)({dictionaryKey:"productGenre"}).then(function(e){var a=[],i=e.result.treeList;t.selectTree={pid:i.pid,id:i.id,layer:i.layer,name:i.name},a.push(i),t.treeData=a,t.apiData.params=Object.assign({},t.searchObj,t.apiData.params,{genreId:t.selectTree.id}),t.$nextTick(function(){this.$refs.tree.$children[0].setCurrentKey(this.selectTree.id)}),t.dialogLoading=!1}).catch(function(e){t.dialogLoading=!1})},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.apiData.params=Object.assign({},this.searchObj,this.apiData.params)},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{selectList:this.tempList})},addWarehouseCheck:function(){var t=this,e=this.tempList,a=[];null!=e&&e.length>0&&e.forEach(function(t){var e=t.id;if(null!=e&&e.trim().length>0){var i={businessId:""};i.businessId=e,a.push(i)}}),0!=a.length?Object(o.addWarehouseCheck)({type:"2",dtlJsonStr:JSON.stringify(a)}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条货品数据！"})},resetQuery:function(){this.$refs.trabsferTables.clearTableSelected()},tableSelected:function(t){this.tempList=t},closeDialog:function(t){this.showDialog=!1}}},c=(a("7+Lp"),a("KHd+")),d=Object(c.a)(r,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"500px"}},[a("el-col",{staticClass:"treeStyle",attrs:{span:6}},[a("base-tree",{ref:"tree",attrs:{data:t.treeData,treeConfigs:t.treeConfigs},on:{treedatabridge:t.treeDataBridge}})],1),t._v(" "),a("el-col",{attrs:{span:18}},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticClass:"tableContent"},[a("div",{staticStyle:{height:"400px"}},[a("transfer-table",{ref:"trabsferTables",attrs:{tableConfigs:t.tableConfigs,btnList:t.btnList,stateBtn:t.stateBtnData,apiData:t.apiData},on:{"table-selected":t.tableSelected}})],1)])],1)],1)],1)},[],!1,null,null,null);d.options.__file="dialogAddByProduct.vue";e.default=d.exports},FO0E:function(t,e,a){"use strict";var i=a("SZ8E");a.n(i).a},MKQz:function(t,e,a){"use strict";var i=a("9+6w");a.n(i).a},MQ7q:function(t,e,a){},SZ8E:function(t,e,a){},VcxO:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf"),a("rGqo"),a("91GP"),a("f3/d");var i=a("f/WR"),n=a("uTIz"),s=a("K3g7"),o=a("uXxI");function l(t){return(l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var r={components:{transferTable:i.a,searchBar:n.a},name:"dialogAddByProduct",props:["initData","visible"],data:function(){return{temp:{productIds:""},tempLable:{},rules:{},guid:"",tempQuery:{},searchList:[{label:"货品编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"货品名称"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!1,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},pageData:null,pageNo:1,treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},btnList:[{name:"生成盘点任务",isShow:!0,state:!0,method:this.addWarehouseCheck},{name:"清空",icon:"refresh",state:!0,plain:!0,method:this.resetQuery,isShow:!0}],apiData:{apiName:"listPageWarehouse",params:{fieldCode:"",isLeaf:"1",nodeId:"",orderStr:"",queryStr:""}},tableSelectList:[],stateBtnData:{},tableConfigs:{showIndex:!0},tempList:[],searchObj:{}}},created:function(){this.initTree()},mounted:function(){this.isVisible=this.visible},computed:{tableHeight:function(){},dialogWidth:function(){if(this.initData.width){var t=l(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{treeDataBridge:function(t){this.selectTree={pid:t.nodeData.pid,id:t.nodeData.id,name:t.nodeData.name,layer:t.layer,virtualGenre:t.virtualGenre},this.pageNo=1,this.apiData.params=Object.assign({},this.searchObj,this.apiData.params,{nodeId:this.selectTree.id})},initTree:function(){var t=this;this.dialogLoading=!0,Object(s.treeWarehouse)({}).then(function(e){var a=[],i=e.result.treeList;t.selectTree={pid:i.pid,id:i.id,layer:i.layer,name:i.name,virtualGenre:i.virtualGenre},a.push(i),t.treeData=a,t.apiData.params=Object.assign({},t.searchObj,t.apiData.params,{nodeId:t.selectTree.id}),t.$nextTick(function(){this.$refs.tree.$children[0].setCurrentKey(this.selectTree.id)}),t.dialogLoading=!1}).catch(function(e){t.dialogLoading=!1})},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.apiData.params=Object.assign({},this.searchObj,this.apiData.params)},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{selectList:this.tempList})},addWarehouseCheck:function(){var t=this,e=this.tempList,a=[];null!=e&&e.length>0&&e.forEach(function(t){var e=t.id;if(null!=e&&e.trim().length>0){var i={businessId:""};i.businessId=e,a.push(i)}}),0!=a.length?Object(o.addWarehouseCheck)({type:"1",dtlJsonStr:JSON.stringify(a)}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条库位数据！！"})},resetQuery:function(){this.$refs.trabsferTables.clearTableSelected()},tableSelected:function(t){this.tempList=t},closeDialog:function(t){this.showDialog=!1}}},c=(a("abxq"),a("KHd+")),d=Object(c.a)(r,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"500px"}},[a("el-col",{staticClass:"treeStyle",attrs:{span:6}},[a("base-tree",{ref:"tree",attrs:{data:t.treeData,treeConfigs:t.treeConfigs},on:{treedatabridge:t.treeDataBridge}})],1),t._v(" "),a("el-col",{attrs:{span:18}},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticClass:"tableContent"},[a("div",{staticStyle:{height:"400px"}},[a("transfer-table",{ref:"trabsferTables",attrs:{tableConfigs:t.tableConfigs,btnList:t.btnList,stateBtn:t.stateBtnData,apiData:t.apiData},on:{"table-selected":t.tableSelected}})],1)])],1)],1)],1)},[],!1,null,null,null);d.options.__file="dialogAddByWarehouse.vue";e.default=d.exports},abxq:function(t,e,a){"use strict";var i=a("llIp");a.n(i).a},"f/WR":function(t,e,a){"use strict";a("XfO3"),a("HEwt"),a("a1Th"),a("rE2o"),a("ioFf"),a("dRSK"),a("rGqo"),a("91GP");var i=a("z0WU"),n=a("Yfch");function s(t){return function(t){if(Array.isArray(t))return t}(t)||function(t){if(Symbol.iterator in Object(t)||"[object Arguments]"===Object.prototype.toString.call(t))return Array.from(t)}(t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}()}var o={props:["colConfig","fixed"],template:'<el-table-column :label="colConfig.label" :fixed="fixed" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t  <template v-for="(item, index) in colConfig.rowMethods">\n    \t\t\t\t\t    <el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="item.method(scope.row,scope.$index)" v-text="item.name"></el-button>\n                </template>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},l={components:{},name:"transfer-table",props:{tableConfigs:{type:Object,default:function(){return{}}},btnList:{type:Array,default:function(){return[]}},upTableBtnTemplate:{type:Array,default:function(){return[]}},downTableBtnTemplate:{type:Array,default:function(){return[]}},apiData:{type:Object,default:function(){return{}}},stateBtn:{type:Object,default:function(){return{}}}},data:function(){return{btnsBoxHeight:0,currentpage:1,tableLoading:!1,tableData:[],resultTableData:[],titleList:[],pageData:{},tableBtns:{columnIndex:"last",prop:"operate",label:"操作",component:o,rowMethods:[{name:"删除",method:this.deleteRow}]},rowKey:"",tempSelectList:[],stateBtnChecked:!1}},computed:{setTablesHeight:function(){return this.stateBtn.title?{height:"calc(50% - 15px)"}:{height:"calc(50% - 6px)"}},setResultBtnState:function(){var t=this;return function(e){return!t.resultTableData.length&&e.state}},setTableConfigs:function(){var t=s(this.titleList).slice(0);return{titleList:this.addTableTitle(t,this.upTableBtnTemplate),showIndex:void 0!==this.tableConfigs.showIndex&&this.tableConfigs.showIndex,isSingle:void 0!==this.tableConfigs.isSingle&&this.tableConfigs.isSingle,isSortable:void 0!==this.tableConfigs.isSortable&&this.tableConfigs.isSortable}},setResultTableConfigs:function(){var t=s(this.titleList).slice(0);return this.downTableBtnTemplate.length?this.addTableTitle(t,this.downTableBtnTemplate):this.addTableTitle(t,[this.tableBtns])},setResultTableData:function(){return[].concat(this.resultTableData)}},watch:{currentpage:function(){var t=Object.assign({},this.apiData.params);t.pageNo=this.currentpage,this.httpTableMethod(this.apiData.apiName,t)},setResultTableData:function(){this.$emit("table-selected",this.setResultTableData)},stateBtnChecked:function(){var t={};t[this.stateBtn.keyName?this.stateBtn.keyName:"isShow"]=this.stateBtnChecked,this.httpTableMethod(this.apiData.apiName,this.apiData.params,t)},"apiData.params":function(){this.httpTableMethod(this.apiData.apiName,this.apiData.params)}},created:function(){this.apiData.apiName?(this.httpTableMethod(this.apiData.apiName,this.apiData.params),this.rowKey=this.tableConfigs.rowKey||"id"):this.$message({message:"没有设置接口名",type:"error",duration:1e4})},mounted:function(){this.$nextTick(function(){this.btnsBoxHeight=this.$refs.btnsBox.clientHeight+5})},methods:{clearTableSelected:function(){var t=this;this.resultTableData=[],this.tempSelectList=[],this.tableData.forEach(function(e){t.$refs.selectTable.$refs.baseTable.clearSelection()})},httpTableMethod:function(t,e,a){var i=this;this.tableLoading=!0,this.$api[t](Object.assign({},e,a)).then(function(t){i.getListPage(t),i.tableLoading=!1}).catch(function(t){i.tableLoading=!1})},getListPage:function(t){var e=this;t&&(t.result.titles="string"==typeof t.result.titles?JSON.parse(t.result.titles):t.result.titles,t.result.varList="string"==typeof t.result.varList?JSON.parse(t.result.varList):t.result.varList,t.result.pageData="string"==typeof t.result.pageData?JSON.parse(t.result.pageData):t.result.pageData,this.titleList=Object(i.j)(t.result),this.pageData=t.result.pageData,this.tableData=t.result.varList||[],this.tempSelectList=[],this.$nextTick(function(t){e.toggleRowSelected()}))},toggleRowSelected:function(){var t=this;this.tableData.forEach(function(e){t.resultTableData.some(function(a){return e[t.rowKey]===a[t.rowKey]})?(t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!0),!t.tempSelectList.some(function(a){return a[t.rowKey]===e[t.rowKey]})&&t.tempSelectList.push(e)):t.$refs.selectTable&&t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!1)})},addTableTitle:function(t,e){return e&&e.length&&e.forEach(function(e){Object(n.b)(e.columnIndex)?t.splice(e.columnIndex,0,e):"first"===e.columnIndex?t.unshift(e):"last"===e.columnIndex?t.push(e):t.some(function(t){if(t.prop===e.columnIndex)return Object.assign(t,e),!0})}),t},dataBridge:function(t,e){this.getChecked(e,t)?this.addRowData(e):this.removeRowData(e)},resultDataBridge:function(t,e){},deleteRow:function(t,e){var a=this;this.resultTableData.find(function(e,i){if(t[a.rowKey]===e[a.rowKey])return a.resultTableData.splice(i,1),e}),this.toggleRowSelected()},updateView:function(t,e){this.resultTableData.splice(e-1,1,t)},getChecked:function(t,e){var a=this;return t?e.some(function(e){return t[a.rowKey]===e[a.rowKey]}):(e.length&&(this.tempSelectList=e),!!e.length)},addRowData:function(t){var e=this;t?!this.resultTableData.some(function(a){return t[e.rowKey]===a[e.rowKey]})&&this.resultTableData.push(t):this.addAllRowData()},addAllRowData:function(){var t=this;this.resultTableData.length?this.tempSelectList.forEach(function(e){t.addRowData(e)}):this.resultTableData=this.tempSelectList},removeRowData:function(t){var e=this;t?this.resultTableData.some(function(a,i){if(t[e.rowKey]===a[e.rowKey])return e.resultTableData.splice(i,1),!0}):this.tableData.forEach(function(t){e.removeRowData(t)})}}},r=(a("MKQz"),a("KHd+")),c=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{height:"100%",padding:"10px"}},[t.stateBtn.title?a("div",{staticStyle:{"text-align":"right"}},[a("el-checkbox",{model:{value:t.stateBtnChecked,callback:function(e){t.stateBtnChecked=e},expression:"stateBtnChecked"}},[t._v(t._s(t.stateBtn.title))])],1):t._e(),t._v(" "),a("div",{style:t.setTablesHeight},[a("base-table",{directives:[{name:"loading",rawName:"v-loading",value:t.tableLoading,expression:"tableLoading"}],ref:"selectTable",attrs:{data:t.tableData,colConfigs:t.setTableConfigs.titleList,showCheckBox:!0,showIndex:t.setTableConfigs.showIndex,pageData:t.pageData,currentpage:t.currentpage,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.dataBridge}})],1),t._v(" "),a("div",{staticStyle:{height:"11px"}}),t._v(" "),a("div",{ref:"resultBox",staticStyle:{position:"relative"},style:t.setTablesHeight},[a("div",{staticStyle:{height:"100%"},style:{paddingBottom:t.btnsBoxHeight+"px"}},[a("base-table",{ref:"resultTable",attrs:{data:t.setResultTableData,colConfigs:t.setResultTableConfigs,showCheckBox:!1,showIndex:t.setTableConfigs.showIndex,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{databridge:t.resultDataBridge}})],1),t._v(" "),a("div",{ref:"btnsBox",staticStyle:{position:"absolute",bottom:"0",right:"0"}},[t.btnList.length?[t._l(t.btnList,function(e,i){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],key:i,attrs:{name:e.name,icon:e.icon,plain:e.plain,state:t.setResultBtnState(e)},on:{myclick:e.method}})]})]:t._e()],2)])])},[],!1,null,"aebf6780",null);c.options.__file="index.vue";e.a=c.exports},lZYi:function(t,e,a){"use strict";var i=a("wnxv");a.n(i).a},llIp:function(t,e,a){},qG3H:function(t,e,a){"use strict";var i=a("qltN");a.n(i).a},qltN:function(t,e,a){},vlkX:function(t,e,a){"use strict";a.r(e);a("91GP"),a("rGqo");var i=a("zDZ1"),n=a("lX1r"),s=a("uTIz"),o=a("VcxO"),l=a("FK0u"),r=a("q0T2"),c=a("zF5t"),d=a("uXxI"),u=a("DuN6"),h=a("Vobf");a("z0WU");function p(t,e,a){return e in t?Object.defineProperty(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}var g={props:["colConfig"],template:'<el-table-column :label="colConfig.label" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t    <el-button v-show="colConfig.deleteByParent_isShow && (scope.row.state == \'0\' || scope.row.state == \'-1\')" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.deleteByParent(scope.row,scope.$index)">删除</el-button>\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.cancelByParent_isShow && scope.row.state == \'0\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.cancelByParent(scope.row,scope.$index,scope)">取消</el-button>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},f={props:["colConfig"],template:'<el-table-column :label="colConfig.label" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.deleteByDetail_isShow && (scope.row.state == \'0\' || scope.row.state == \'-1\')" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.deleteByDetail(scope.row,scope.$index)">删除</el-button>\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.cancelByDetail_isShow && scope.row.state == \'0\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.cancelByDetail(scope.row,scope.$index)">取消</el-button>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},m={components:{dialogQrcode:i.a,expandTable:n.a,searchBar:s.a,dialogAddByWarehouse:o.default,dialogAddByProduct:l.default,dialogDispatch:r.default},data:function(){var t;return p(t={colConfigs:[],initData:{},childrenDialogTitleList:[],fromTemp:{},showDialog:!1,dialogVisible:!1,dialogCallBackData:null,baseLayer:0,searchList:[{label:"盘点单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"盘点单号"},{label:"盘点类型",type:"select",ruleType:"number",mapKey:"type",configs:{clearable:!0,name:"",options:[{value:"1",label:"按库位"},{value:"2",label:"按货品"}]},placeholder:"请选择"},{label:"盘点单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"未完成"},{value:"1",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"规格型号"},{label:"货品属性",type:"input",ruleType:"string",mapKey:"productGenreName",configs:{},placeholder:"货品属性"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"productUnitName",configs:{},placeholder:"请输入计量单位"}],guid:"",currentpage:1,maxLayer:2,expandTableApiList:["listPagewarehouseChecks","listPageWarehouseCheckDetails"],expandTableApiParams:[{},{parentId:""}],initParams:{},updateViewData:{},searchObj:{},titleList:[],pageData:{},childrenData:{},customColumn:{1:[{columnIndex:"last",prop:"operate",label:"操作",component:g,cancelByParent:this.cancelByParent,cancelByParent_isShow:!0,deleteByParent:this.deleteByParent,deleteByParent_isShow:!0}],2:[{columnIndex:"last",prop:"operate",label:"操作",component:f,cancelByDetail:this.cancelByDetail,cancelByDetail_isShow:!0,deleteByDetail:this.deleteByDetail,deleteByDetail_isShow:!0}]},tableSets:{1:{showCheckBox:!1,showIndex:!0,expandOne:!1},2:{showCheckBox:!0,showIndex:!1,isExpands:!1,isSortable:!1,isSingle:!1}},configs:{topBarBtnList:[{name:"新增(按库位)",nameEn:"addByWarehouse",isShow:!0,icon:"add",method:this.dialogAddByWarehouse},{name:"新增(按货品)",nameEn:"addByProduct",isShow:!0,icon:"add",method:this.dialogAddByProduct},{name:"派单",nameEn:"dispatch",isShow:!0,icon:"add",method:this.dialogAddByDispatch},{name:"导出",nameEn:"export",isShow:!0,icon:"export",method:this.exportExcel}],tableConfigs:[]},temp:{},openDialogName:""},"showDialog",!1),p(t,"visible",!1),p(t,"dialogData",{title:"",temp:{},tempLable:null}),t},beforeCreate:function(){},created:function(){this.initExpandTable()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this;t.$loading({spinner:"none",text:"智 造 云 管 家"});var e=t.$storage.get("userInfo").roleIds,a=t.$storage.get("menuId");e&&Object(h.initMenuButtons)({menuId:a,roleId:e}).then(function(e){var a=e.buttonList;a&&a.forEach(function(e){if(t.initConfigs&&t.initConfigs.tableOperates)for(var a in t.initConfigs.tableOperates)a.indexOf(e.nameEn)>=0&&a.indexOf("isShow")>0&&(t.initConfigs.tableOperates[a]=!1);if(t.customColumn)for(var i in t.customColumn)if(i){var n=t.customColumn[i];n.length>0&&n.forEach(function(t){if(t)for(var a in t)a.indexOf(e.nameEn)>=0&&a.indexOf("isShow")>0&&(t[a]=!1)})}t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){t.$loading().close()})},initExpandTable:function(){var t=this;this.$api[this.expandTableApiList[0]](this.setParams(1,this.expandTableApiParams[0],this.currentpage)).then(function(e){t.initData={row:null,layer:1,res:e,customColumn:t.customColumn},t.$loading().close()}).catch(function(e){t.$loading().close()})},findChildByRow:function(t,e,a,i,n){var s=this;this.$api[this.expandTableApiList[e-1]](this.setParams(e,t,n)).then(function(a){s.childrenData={row:t,layer:e,res:a,customColumn:s.customColumn}}).catch(function(t){})},setParams:function(t,e,a){if(t>1){var i=this.expandTableApiParams[t-1];for(var n in i)i.hasOwnProperty(n)&&(i[n]=e[n]||"");return Object.assign({},i,this.searchObj,{pageNo:a})}return Object.assign({},e,this.searchObj,{pageNo:a})},databridge:function(t){this.temp.detail=t},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.initExpandTable()},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.initExpandTable()},dialogAddByWarehouse:function(){this.resetTemp(),this.dialogData.temp=this.temp,this.dialogData.title="选择货位",this.openDialogName="dialogAddByWarehouse",this.showDialog=!0,this.visible=!0},dialogAddByProduct:function(){this.resetTemp(),this.dialogData.temp=this.temp,this.dialogData.title="选择货品",this.openDialogName="dialogAddByProduct",this.showDialog=!0,this.visible=!0},dialogAddByDispatch:function(){var t=this.temp.detail;null!=t&&0!=t.length?this.isExistWarehouseRole(t):this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条明细！"})},isExistWarehouseRole:function(t){var e=this,a={userType:this.$storage.get("userInfo").userType,roleName:"仓库管理员"};Object(c.addRoleByName)(a).then(function(a){var i=a.result,n=i.type,s=i.roleId,o=i.roleName;null!=s&&0!=s.trim().length?(e.dialogData.temp=t,e.dialogData.temp.roleId=s,e.dialogData.temp.roleName=o,e.dialogData.temp.type=n,e.dialogData.title="派发盘点单",e.openDialogName="dialogDispatch",e.showDialog=!0,e.visible=!0):e.$message({type:"warning",duration:5e3,showClose:!0,message:"仓库管理员角色ID不存在(角色ID为空或空字符串)！"})}).catch(function(t){})},cancelByParent:function(t,e){var a=this;this.$storage.get("userInfo").userId==t.makeId?"1"!=t.state?this.$confirm("此操作将该盘点单状态变更为已取消, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(d.cancelWarehouseCheck)(t.id).then(function(t){0===t.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.initExpandTable())}).catch(function(t){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前盘点单状态(已完成)，不可取消！"}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是制单人不可取消！"})},deleteByParent:function(t,e){var a=this;this.$storage.get("userInfo").userId==t.makeId?"1"!=t.state?this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(d.deleteWarehouseCheck)(t.id).then(function(t){0===t.code&&(a.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),a.initExpandTable())}).catch(function(t){})}).catch(function(){a.$message({type:"info",message:"已取消删除"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前盘点单状态(已完成)，不可删除！"}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是制单人不可删除！"})},cancelByDetail:function(t,e){var a=this;this.$storage.get("userInfo").userId==t.cuser?-1=="1,2,3".indexOf(t.state)?this.$confirm("此操作将该盘点明细状态变更为已取消, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(u.cancelWarehouseCheckDetail)(t.id).then(function(t){0===t.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.initExpandTable())}).catch(function(t){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前明细状态(执行中,审核中,已完成)，不可取消！"}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是制单人不可取消！"})},deleteByDetail:function(t,e){var a=this;this.$storage.get("userInfo").userId==t.cuser?-1=="1,2,3".indexOf(t.state)?this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(u.deleteWarehouseCheckDetail)(t.id).then(function(t){0===t.code&&(a.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),a.initExpandTable())}).catch(function(t){})}).catch(function(){a.$message({type:"info",message:"已取消删除"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前明细状态(执行中,审核中,已完成)，不可删除！"}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是制单人不可删除！"})},exportExcel:function(){}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{currentpage:function(){this.initExpandTable()}}},b=(a("FO0E"),a("KHd+")),y=Object(b.a)(m,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"warehouseCheckManage"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("expand-table",{attrs:{initData:t.initData,childrenData:t.childrenData,configs:t.tableSets,currentpage:t.currentpage,maxLayer:t.maxLayer,apiObj:{apiName:t.expandTableApiList,apiParams:t.expandTableApiParams},updateViewData:t.updateViewData},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.databridge,"send-children-row":t.findChildByRow}})],1)],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);y.options.__file="index.vue";e.default=y.exports},wnxv:function(t,e,a){},zDZ1:function(t,e,a){"use strict";a("rE2o"),a("ioFf"),a("f3/d"),a("9WTv");function i(t){return(i="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},tempShow:{},rules:{},imageUrl:""}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.initData.temp.qrcode&&(this.imageUrl="http://116.196.105.79:8080/"+this.initData.temp.qrcode)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=i(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},download:function(){var t=this.imageUrl,e=document.createElement("a");e.style.display="none",e.href=t,e.setAttribute("download",this.temp.name),document.body.appendChild(e),e.click()},print:function(){var t=document.getElementById("printContent").innerHTML,e=document.body.innerHTML;return document.body.innerHTML=t,window.print(),window.location.reload(),document.body.innerHTML=e,!1}}},s=(a("lZYi"),a("qG3H"),a("KHd+")),o=Object(s.a)(n,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"二维码",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("div",{attrs:{id:"printContent"}},[a("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-col",{staticStyle:{"text-align":"center","padding-bottom":"20px"},attrs:{span:24}},[t.imageUrl?a("img",{staticClass:"avatar",staticStyle:{margin:"0 auto"},attrs:{src:t.imageUrl}}):a("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:24}},[a("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.code)+":")]),t._v(t._s(t.temp.code)),a("br"),t._v(" "),a("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.name)+":")]),t._v(t._s(t.temp.name)+"\n\n          ")])],1)],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center",padding:"15px 0 15px 0"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.download}},[t._v("下载")]),t._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:t.print}},[t._v("打印")])],1)])])},[],!1,null,"56ed280a",null);o.options.__file="dialogQrcode.vue";e.a=o.exports}}]);