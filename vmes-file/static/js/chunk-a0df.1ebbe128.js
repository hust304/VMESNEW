(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-a0df"],{"0UjI":function(t,e,a){"use strict";a("rE2o"),a("ioFf"),a("91GP");var i=a("f/WR"),n=a("uTIz");a("xMja");function s(t){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{transferTable:i.a,searchBar:n.a},name:"productTableDialog",props:["initData","visible"],data:function(){return{isConfirm:!1,temp:{productIds:""},tempLable:{},rules:{},guid:"",tempQuery:{},searchList:[{label:"编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入编码"},{label:"名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入名称"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!0,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},pageData:null,pageNo:1,btnList:[{name:"确定",isShow:!0,state:!0,method:this.toAddWarehouseIn},{name:"清空",icon:"refresh",state:!0,plain:!0,method:this.resetQuery,isShow:!0}],apiData:{apiName:"listPageProducts",params:{}},tableSelectList:[],stateBtnData:{},tableConfigs:{showIndex:!0},tempList:[]}},created:function(){var t="";null!=this.initData.queryStr&&(t=this.initData.queryStr);var e="";e=null!=this.initData.fieldCode?this.initData.fieldCode:"code,name,spec,unitName,genreName,stockCount,safetyCount,lockCount,productStockCount,cdate";var a="";a=null!=this.initData.orderStr?this.initData.orderStr:"prod.stock_count desc";var i="";i=null!=this.initData.apiName?this.initData.apiName:"listPageProducts",null!=this.initData.searchList&&this.initData.searchList.length>0&&(this.searchList=this.initData.searchList),this.apiData.apiName=i,this.apiData.params={fieldCode:e,queryStr:t,orderStr:a}},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{tableHeight:function(){},dialogWidth:function(){if(this.initData.width){var t=s(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{sendGuid:function(t){this.guid=t},searchMap:function(t){console.log(t),this.apiData.params=Object.assign({},this.apiData.params,t)},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{isConfirm:this.isConfirm,selectList:this.tempList})},toAddWarehouseIn:function(){this.isConfirm=!0,this.isVisible=!1},resetQuery:function(){this.$refs.trabsferTables.clearTableSelected()},tableSelected:function(t){this.tempList=t},closeDialog:function(t){this.showDialog=!1}}},o=a("KHd+"),r=Object(o.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"margin-top":"15px","margin-left":"10px"}},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticStyle:{height:"650px"},style:{"margin-top":t.searchList.length?"10px":"0"}},[a("transfer-table",{ref:"trabsferTables",attrs:{tableConfigs:t.tableConfigs,btnList:t.btnList,stateBtn:t.stateBtnData,apiData:t.apiData},on:{"table-selected":t.tableSelected}})],1)],1)],1)},[],!1,null,null,null);r.options.__file="definedTableDialog.vue";e.a=r.exports},"3d3b":function(t,e,a){"use strict";a("rE2o"),a("ioFf"),a("91GP"),a("pIFo");var i=a("f/WR"),n=a("uTIz");a("xMja");function s(t){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{transferTable:i.a,searchBar:n.a},name:"productTableDialog",props:["initData","visible"],data:function(){return{fieldCode_default:"code,name,spec,unitName,genreName,stockCount,safetyCount,lockCount,productStockCount",fieldCode:"",isConfirm:!1,temp:{productIds:""},tempLable:{},rules:{},guid:"",tempQuery:{},searchList:[{label:"货品编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"spec",configs:{},placeholder:"请输入规格型号"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"unitName",configs:{},placeholder:"请输入计量单位"},{label:"货品属性",type:"select",ruleType:"string",mapKey:"genreName",configs:{clearable:!0,name:"",options:[{value:"成品",label:"成品"},{value:"原材料",label:"原材料"},{value:"辅料",label:"辅料"},{value:"半成品",label:"半成品"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!0,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},pageData:null,pageNo:1,btnList:[{name:"确定",isShow:!0,state:!0,method:this.toAddWarehouseIn},{name:"取消",state:!1,method:this.closeWin,isShow:!0}],apiData:{apiName:"listPageProducts",params:{}},tableSelectList:[],stateBtnData:{},tableConfigs:{showIndex:!0},tempList:[]}},created:function(){var t="";if(null!=this.initData.data&&this.initData.data.length>0)for(var e=0;e<this.initData.data.length;e++){var a=this.initData.data[e];null!=a.productId&&a.productId.trim().length>0&&(t=t+a.productId+",")}this.temp.productIds=t;var i="";null!=this.initData.queryStr&&(i=this.initData.queryStr);var n="";null==(n=null!=this.initData.fieldCode?this.initData.queryStr:this.fieldCode_default)||0==n.trim().length?this.fieldCode=this.fieldCode_default:null!=n&&n.trim().length>0&&(this.fieldCode=n.trim());var s="";s=null!=this.initData.orderStr?this.initData.queryStr:"prod.stock_count desc";var l=!0;null!=this.initData.isNeedRepeat&&(l=this.initData.isNeedRepeat),l||null!=t&&t.trim().length>0&&(i="prod.id not in ("+(t="'"+(t=t.substring(0,t.lastIndexOf(","))).replace(",","','")+"'")+")");var o="false";null!=this.initData.isNeedCustomerPrice&&this.initData.isNeedCustomerPrice&&(o="true");var r="";null!=this.initData.customerId&&this.initData.customerId.trim().length>0&&(r=this.initData.customerId.trim()),this.apiData.params={fieldCode:n,queryStr:i,orderStr:s,isNeedCustomerPrice:o,customerId:r,isdisable:"1"}},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{tableHeight:function(){},dialogWidth:function(){if(this.initData.width){var t=s(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{sendGuid:function(t){this.guid=t},searchMap:function(t){this.apiData.params=Object.assign({},t),this.apiData.params.fieldCode=this.fieldCode},dialogOpen:function(){},closeWin:function(){this.isVisible=!1},dialogClose:function(t){this.$emit("close-dialog",t||{isConfirm:this.isConfirm,selectList:this.tempList})},toAddWarehouseIn:function(){this.isConfirm=!0,this.isVisible=!1},resetQuery:function(){this.$refs.trabsferTables.clearTableSelected()},tableSelected:function(t){this.tempList=t},closeDialog:function(t){this.showDialog=!1}}},o=a("KHd+"),r=Object(o.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"margin-top":"15px","margin-left":"10px"}},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticStyle:{height:"500px"},style:{"margin-top":t.searchList.length?"10px":"0"}},[a("transfer-table",{ref:"trabsferTables",attrs:{tableConfigs:t.tableConfigs,btnList:t.btnList,stateBtn:t.stateBtnData,apiData:t.apiData},on:{"table-selected":t.tableSelected}})],1)],1)],1)},[],!1,null,null,null);r.options.__file="productTableDialog.vue";e.a=r.exports},"8VNB":function(t,e,a){},K8no:function(t,e,a){"use strict";var i=a("8VNB");a.n(i).a},LUXg:function(t,e,a){},"VI+Y":function(t,e,a){"use strict";var i=a("LUXg");a.n(i).a},"f/WR":function(t,e,a){"use strict";a("XfO3"),a("HEwt"),a("a1Th"),a("rE2o"),a("ioFf"),a("dRSK"),a("rGqo"),a("91GP");var i=a("z0WU"),n=a("Yfch");function s(t){return function(t){if(Array.isArray(t))return t}(t)||function(t){if(Symbol.iterator in Object(t)||"[object Arguments]"===Object.prototype.toString.call(t))return Array.from(t)}(t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}()}var l={props:["colConfig","fixed"],template:'<el-table-column :label="colConfig.label" :fixed="fixed" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t  <template v-for="(item, index) in colConfig.rowMethods">\n    \t\t\t\t\t    <el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="item.method(scope.row,scope.$index)" v-text="item.name"></el-button>\n                </template>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},o={components:{},name:"transfer-table",props:{tableConfigs:{type:Object,default:function(){return{}}},btnList:{type:Array,default:function(){return[]}},upTableBtnTemplate:{type:Array,default:function(){return[]}},downTableBtnTemplate:{type:Array,default:function(){return[]}},apiData:{type:Object,default:function(){return{}}},stateBtn:{type:Object,default:function(){return{}}}},data:function(){return{btnsBoxHeight:0,currentpage:1,tableLoading:!1,tableData:[],resultTableData:[],titleList:[],pageData:{},tableBtns:{columnIndex:"last",prop:"operate",label:"操作",component:l,rowMethods:[{name:"删除",method:this.deleteRow}]},rowKey:"",tempSelectList:[],stateBtnChecked:!1}},computed:{setTablesHeight:function(){return this.stateBtn.title?{height:"calc(50% - 15px)"}:{height:"calc(50% - 6px)"}},setResultBtnState:function(){var t=this;return function(e){return!t.resultTableData.length&&e.state}},setTableConfigs:function(){var t=s(this.titleList).slice(0);return{titleList:this.addTableTitle(t,this.upTableBtnTemplate),showIndex:void 0!==this.tableConfigs.showIndex&&this.tableConfigs.showIndex,isSingle:void 0!==this.tableConfigs.isSingle&&this.tableConfigs.isSingle,isSortable:void 0!==this.tableConfigs.isSortable&&this.tableConfigs.isSortable}},setResultTableConfigs:function(){var t=s(this.titleList).slice(0);return this.downTableBtnTemplate.length?this.addTableTitle(t,this.downTableBtnTemplate):this.addTableTitle(t,[this.tableBtns])},setResultTableData:function(){return[].concat(this.resultTableData)}},watch:{currentpage:function(){var t=Object.assign({},this.apiData.params);t.pageNo=this.currentpage,this.httpTableMethod(this.apiData.apiName,t)},setResultTableData:function(){this.$emit("table-selected",this.setResultTableData)},stateBtnChecked:function(){var t={};t[this.stateBtn.keyName?this.stateBtn.keyName:"isShow"]=this.stateBtnChecked,this.httpTableMethod(this.apiData.apiName,this.apiData.params,t)},"apiData.params":function(){console.log(this.apiData.params),this.httpTableMethod(this.apiData.apiName,this.apiData.params)}},created:function(){this.apiData.apiName?(this.httpTableMethod(this.apiData.apiName,this.apiData.params),this.rowKey=this.tableConfigs.rowKey||"id"):this.$message({message:"没有设置接口名",type:"error",duration:1e4})},mounted:function(){this.$nextTick(function(){this.btnsBoxHeight=this.$refs.btnsBox.clientHeight+5})},methods:{clearTableSelected:function(){var t=this;this.resultTableData=[],this.tempSelectList=[],this.tableData.forEach(function(e){t.$refs.selectTable.$refs.baseTable.clearSelection()})},httpTableMethod:function(t,e,a){var i=this;this.tableLoading=!0,this.$api[t](Object.assign({},e,a)).then(function(t){console.log(t),i.getListPage(t),i.tableLoading=!1}).catch(function(t){i.tableLoading=!1})},getListPage:function(t){var e=this;t&&(t.result.titles="string"==typeof t.result.titles?JSON.parse(t.result.titles):t.result.titles,t.result.varList="string"==typeof t.result.varList?JSON.parse(t.result.varList):t.result.varList,t.result.pageData="string"==typeof t.result.pageData?JSON.parse(t.result.pageData):t.result.pageData,this.titleList=Object(i.m)(t.result),this.pageData=t.result.pageData,this.tableData=t.result.varList||[],this.tempSelectList=[],this.$nextTick(function(t){e.toggleRowSelected()}))},toggleRowSelected:function(){var t=this;this.tableData.forEach(function(e){t.resultTableData.some(function(a){return e[t.rowKey]===a[t.rowKey]})?(t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!0),!t.tempSelectList.some(function(a){return a[t.rowKey]===e[t.rowKey]})&&t.tempSelectList.push(e)):t.$refs.selectTable&&t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!1)})},addTableTitle:function(t,e){return e&&e.length&&e.forEach(function(e){Object(n.b)(e.columnIndex)?t.splice(e.columnIndex,0,e):"first"===e.columnIndex?t.unshift(e):"last"===e.columnIndex?t.push(e):t.some(function(t){if(t.prop===e.columnIndex)return Object.assign(t,e),!0})}),t},dataBridge:function(t,e){this.getChecked(e,t)?this.addRowData(e):this.removeRowData(e)},resultDataBridge:function(t,e){console.log(t),console.log(e)},deleteRow:function(t,e){var a=this;console.log(t),console.log(e),this.resultTableData.find(function(e,i){if(t[a.rowKey]===e[a.rowKey])return a.resultTableData.splice(i,1),e}),this.toggleRowSelected()},updateView:function(t,e){this.resultTableData.splice(e-1,1,t)},getChecked:function(t,e){var a=this;return t?e.some(function(e){return t[a.rowKey]===e[a.rowKey]}):(e.length&&(this.tempSelectList=e),!!e.length)},addRowData:function(t){var e=this;t?!this.resultTableData.some(function(a){return t[e.rowKey]===a[e.rowKey]})&&this.resultTableData.push(t):this.addAllRowData()},addAllRowData:function(){var t=this;this.resultTableData.length?this.tempSelectList.forEach(function(e){t.addRowData(e)}):this.resultTableData=this.tempSelectList},removeRowData:function(t){var e=this;t?this.resultTableData.some(function(a,i){if(t[e.rowKey]===a[e.rowKey])return e.resultTableData.splice(i,1),!0}):this.tableData.forEach(function(t){e.removeRowData(t)})}}},r=(a("K8no"),a("KHd+")),d=Object(r.a)(o,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"myCoustomTable",staticStyle:{height:"100%",padding:"10px"}},[t.stateBtn.title?a("div",{staticStyle:{"text-align":"right"}},[a("el-checkbox",{model:{value:t.stateBtnChecked,callback:function(e){t.stateBtnChecked=e},expression:"stateBtnChecked"}},[t._v(t._s(t.stateBtn.title))])],1):t._e(),t._v(" "),a("div",{style:t.setTablesHeight},[a("base-table",{directives:[{name:"loading",rawName:"v-loading",value:t.tableLoading,expression:"tableLoading"}],ref:"selectTable",attrs:{data:t.tableData,colConfigs:t.setTableConfigs.titleList,showCheckBox:!0,showIndex:t.setTableConfigs.showIndex,pageData:t.pageData,currentpage:t.currentpage,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.dataBridge}})],1),t._v(" "),a("div",{staticStyle:{height:"11px"}}),t._v(" "),a("div",{ref:"resultBox",staticStyle:{position:"relative"},style:t.setTablesHeight},[a("div",{staticStyle:{height:"100%"},style:{paddingBottom:t.btnsBoxHeight+"px"}},[a("base-table",{ref:"resultTable",attrs:{data:t.setResultTableData,colConfigs:t.setResultTableConfigs,showCheckBox:!1,showIndex:t.setTableConfigs.showIndex,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{databridge:t.resultDataBridge}})],1),t._v(" "),a("div",{ref:"btnsBox",staticStyle:{position:"absolute",bottom:"0",right:"0"}},[t.btnList.length?[t._l(t.btnList,function(e,i){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],key:i,attrs:{name:e.name,icon:e.icon,plain:e.plain,state:t.setResultBtnState(e)},on:{myclick:e.method}})]})]:t._e()],2)])])},[],!1,null,"438f4cfc",null);d.options.__file="index.vue";e.a=d.exports},"z+ln":function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf"),a("f3/d");var i=a("3d3b"),n=a("WIyV"),s=a("0UjI"),l=a("sNnr");a("qnVx"),a("z0WU");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var r={components:{productTableDialog:i.a,definedTableDialog:s.a,customBaseTable:n.a},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{remark:"",applyName:"",supplierName:"",deptName:"",applyId:"",supplierId:"",deptId:""},tempLable:{},tempQuery:{},tableData:[],tableList:[],rowData:{},selectList:null,configs:{topBarBtnList:[{name:"选择货品",nameEn:"add",isShow:!0,icon:"add",method:this.addProduct},{name:"从计划导入",nameEn:"addPlan",isShow:!0,icon:"add",method:this.addPlan}]},apiObj:{apiName:"listPagePurchaseOrderDetails",params:{pageNo:1,parentId:"null",fieldCode:"productCode,productName,spec,genre,unit,count,price,amount,edate,reason,remark"}},customColumn:[{columnIndex:"unit",componentName:"select",_cellConfig:{asyn:{apiName:"findListProductUnitByProduct",params:{productId:""}},rules:[{required:!0}],outputData:!0}},{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"amount",componentName:"input",_cellConfig:{compute:"self@price(*)self@count",editable:!1}},{columnIndex:"price",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"reason",componentName:"select",_cellConfig:{asyn:{apiName:"getDictionarys",params:{dictionaryKey:"purchaseReason",isglobal:"1"}},rules:[{required:!0}],outputData:!0}},{columnIndex:"edate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy-MM-dd",valueFormat:"yyyy-MM-dd",greaterThan:["tempData@minDate",!0]}},{columnIndex:"remark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{minDate:new Date},customSummary:{component:{props:["data","setStyle"],template:'<ul class="clearfix" :style="setStyle">\n                    <li style="float: left;width: 100%"><span>合计金额：</span><span>￥{{data.total.toFixed(2)}}</span></li>\n                    <li style="float: left;width: 100%" class="inputStyle">\n                      <span>折扣金额：</span>\n                      <span>￥\n                        <el-form inline inline-message :model="data" ref="numberValidateForm" label-width="0">\n                          <el-form-item prop="discount" :rules="[{ type: \'number\', message: \'必须为数字值\'}]">\n                            <el-input v-model.number="data.discount" size="mini" placeholder="请输入"></el-input>\n                          </el-form-item>\n                        </el-form>\n                      </span>\n                    </li>\n                    <li style="float: left;width: 100%"><span>订单金额：</span><span>￥{{(data.total-data.discount).toFixed(2)}}</span></li>\n                    </ul>'},data:{discount:"0",total:"0"},boxStyle:{width:"250px",float:"left",padding:"10px"},apiObj:{apiName:"",params:{}},computes:{total:"table@amount"}},ApplyDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择制单人",tableUrl:"/system/user/listPageUsers",tableParm:{isdisable:"1",fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}},DeptDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择部门",treeUrl:"/system/department/treeDepartments",treeParm:{},tableUrl:"/system/department/listPageDepartments",tableParm:{isdisable:"1",fieldCode:"code,name,deptTypeName,layer,parentName,remark"},temp:{}},dialogName:"dialogTreeOption"}},SupplierDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择供应商",tableUrl:"/base/customer/listPageCustomers",tableParm:{isdisable:"1",genre:"49c0a7ebcb4c4175bd5195837a6a9a13",fieldCode:"code,name,typeName,remark,udate"},temp:{}},dialogName:"dialogOption"}}}},created:function(){this.$storage.get("userInfo");this.temp=this.initData.temp,this.apiObj.params.parentId=this.initData.temp.id,this.customSummary.data.discount=this.temp.discount,this.customSummary.data.total=this.temp.total},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(t){Array.isArray(t)?(this.tableList=[],this.tableList=t):(this.rowData=null,null!=t.row&&(this.rowData=t.row))},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},addProduct:function(){this.dialogData.data=this.tableList,this.dialogData.title="选择货品",this.openDialogName="productTableDialog",this.showDialog=!0,this.inLinVisible=!0},addPlan:function(){this.dialogData={title:"",data:null,tempLable:null},this.dialogData.apiName="listPagePurchasePlanDetails",this.dialogData.fieldCode="code,productCode,productName,spec,genre,unit,count,edate,reason",this.dialogData.queryStr=" detail.id not in (select plan_id from vmes_purchase_order_detail where plan_id is not null and state != '-1' ) and detail.state = '2' ",this.dialogData.orderStr="product.code desc";this.dialogData.searchList=[{label:"编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"请输入编码"},{label:"名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"请输入名称"}],this.dialogData.data=this.tableList,this.dialogData.title="选择货品",this.openDialogName="definedTableDialog",this.showDialog=!0,this.inLinVisible=!0},editOrder:function(){var t=this,e="";if(this.$refs.orderAddDialog.getData(),null!=this.tableList&&0!=this.tableList.length){for(var a=[],i=0;i<this.tableList.length;i++){var n=this.tableList[i],s={productId:"",amount:"",unit:"",price:"",count:"",reason:"",edate:"",remark:"",planId:"",id:""};s.productId=n.productId,s.amount=n.amount,n.unit.item?s.unit=n.unit.item.id:s.unit=n.unitId,s.price=n.price,s.count=n.count,s.remark=n.remark,s.edate=n.edate,n.reason.item?s.reason=n.reason.item.id:s.reason=n.reasonId,s.planId=n.planId,s.id=n.id,a.push(s)}e=JSON.stringify(a),this.temp.discount=this.customSummary.data.discount,this.temp.total=this.customSummary.data.total,this.temp.amount=this.temp.total-this.temp.discount,this.temp.dtlJsonStr=e,this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(l.editPurchaseOrder)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){}))})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})},deptSelect:function(t){t[0]&&(this.temp.deptId=t[0].id,this.temp.deptName=t[0].name)},applySelect:function(t){t[0]&&(this.temp.applyId=t[0].id,this.temp.applyName=t[0].name)},supplierSelect:function(t){t[0]&&(this.temp.supplierId=t[0].id,this.temp.supplierName=t[0].name)},closeDialog:function(t){this.showDialog=!1;var e=!1;null!=t.isConfirm&&(e=t.isConfirm);var a=[];null!=t.selectList&&(a=t.selectList),this.tableSelected(e,a)},tableSelected:function(t,e){if(t&&null!=e&&e.length>0)for(var a=0;a<e.length;a++){var i=e[a],n={productId:"",productCode:"",productName:"",spec:"",genre:"",unit:"",amount:"",price:"",count:"",reason:"",edate:"",remark:"",planId:"",id:""};null!=i.productId&&i.productId.trim().length>0?(n.productId=i.productId.trim(),n.planId=i.id.trim(),n.remark=i.code,n.edate=i.edate,n.reason=i.reason,n.reasonId=i.reasonId,null!=i.productCode&&i.productCode.trim().length>0&&(n.productCode=i.productCode.trim()),null!=i.productName&&i.productName.trim().length>0&&(n.productName=i.productName.trim()),null!=i.spec&&i.spec.trim().length>0&&(n.spec=i.spec.trim()),null!=i.genre&&i.genre.trim().length>0&&(n.genre=i.genre.trim()),null!=i.unit&&i.unit.trim().length>0&&(n.unit=i.unit.trim(),n.unitId=i.unitId.trim())):(n.productId=i.id.trim(),null!=i.code&&i.code.trim().length>0&&(n.productCode=i.code.trim()),null!=i.name&&i.name.trim().length>0&&(n.productName=i.name.trim()),null!=i.spec&&i.spec.trim().length>0&&(n.spec=i.spec.trim()),null!=i.genreName&&i.genreName.trim().length>0&&(n.genre=i.genreName.trim()),null!=i.unitName&&i.unitName.trim().length>0&&(n.unit=i.unitName.trim(),n.unitId=i.unit.trim())),n.id=i.id.trim()||a,this.tableData.push(n)}}},watch:{}},d=(a("VI+Y"),a("KHd+")),c=Object(d.a)(r,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1250px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"申请人:",prop:"applyName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:t.ApplyDialog.dialog},on:{callback:t.applySelect},model:{value:t.temp.applyName,callback:function(e){t.$set(t.temp,"applyName",e)},expression:"temp.applyName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"申请部门:",prop:"deptName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:t.DeptDialog.dialog},on:{callback:t.deptSelect},model:{value:t.temp.deptName,callback:function(e){t.$set(t.temp,"deptName",e)},expression:"temp.deptName"}})],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"供应商:",prop:"supplierName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:t.SupplierDialog.dialog},on:{callback:t.supplierSelect},model:{value:t.temp.supplierName,callback:function(e){t.$set(t.temp,"supplierName",e)},expression:"temp.supplierName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[a("el-input",{staticStyle:{width:"200px"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2),t._v(" "),a("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[a("custom-base-table",{ref:"orderAddDialog",attrs:{isSortable:!1,varList:t.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:t.customColumn,apiObj:t.apiObj,mergeTitle:t.mergeTitle,mergeColumn:t.mergeColumn,mergeRow:t.mergeRow,tempData:t.tempData,componentId:"orderAddDialog",useDefaultBtn:!0,rowKey:"_insideId",showAll:!1,keyMapping:t.keyMapping,useSummary:!0,customSummary:t.customSummary},on:{databridge:t.databridge}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.editOrder}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);c.options.__file="dialogEdit.vue";e.default=c.exports}}]);