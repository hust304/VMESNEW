(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-5cf0"],{"/FO0":function(t,e,a){},"8VNB":function(t,e,a){},"9O1b":function(t,e,a){"use strict";var i=a("/FO0");a.n(i).a},K8no:function(t,e,a){"use strict";var i=a("8VNB");a.n(i).a},KxAj:function(t,e,a){"use strict";var i=a("WxTd");a.n(i).a},NaOS:function(t,e,a){"use strict";a("rGqo");function i(t,e,a){return e in t?Object.defineProperty(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}var s={components:{},name:"dyna-form",props:{config:{type:Object,default:function(){return{}}},formTemp:{type:Array,default:function(){return[]}},props:{type:Object,default:function(){return{key:"key",value:"value"}}}},data:function(){var t=this;return{btnsBoxHeight:0,addFormData:[],isVisible:!1,saveBtnState:!0,tempFormList:[{key:"",value:""}],itemRule:[{validator:function(e,a,i){""===a?(t.saveBtnState=!0,i(new Error("请定义属性名称"))):t.deDuplication(a)?(t.saveBtnState=!0,i(new Error("有重复的属性名称"))):i()},trigger:"blur"}],formData:[]}},created:function(){this.formData=this.renameAttr(this.formTemp,!0)},mounted:function(){this.$nextTick(function(){this.btnsBoxHeight=this.hideBtn?this.$refs.btnsBox.clientHeight:0})},computed:{hideBtn:function(){return!this.config.hideBtn},formList:function(){return this.formData.concat(this.addFormData)},onModal:function(){return!1},onEscape:function(){return!1}},methods:{renameAttr:function(t,e){if("key"===this.props.key&&"value"===this.props.value)return t;var a=this.props,s=a.key,n=a.value,o=[];return e?(t.forEach(function(t,e){o.push({key:t[s||"key"],value:t[n||"value"]})}),o):(this.formList.forEach(function(t,e){var a;o.push((i(a={},s||"key",t.key),i(a,n||"value",t.value),a))}),o)},addAttr:function(){this.tempFormList=[{key:"",value:""}],this.isVisible=!0},removeDomain:function(t,e){var a=this,i=!0;this.formData.forEach(function(e,s){e.key===t.key&&(i=!1,a.formData.splice(s,1))}),i&&this.addFormData.forEach(function(e,i){e.key===t.key&&a.addFormData.splice(i,1)})},dialogOpen:function(){var t=this;this.saveBtnState=!0,this.$nextTick(function(){t.tempFormList.forEach(function(e,a){t.$refs["tempForm"+a][0].clearValidate()})})},getFormList:function(){this.$emit("sent-list",this.renameAttr(this.formList))},save:function(){this.addFormData=this.addFormData.concat(this.tempFormList),this.isVisible=!1},addContent:function(){this.tempFormList.push({key:"",value:""}),this.saveBtnState=!0},deleteContent:function(t,e){this.tempFormList.splice(e,1),this.switchSaveBtnState()},deDuplication:function(t){var e=0;return this.tempFormList.forEach(function(a){a.key===t&&e++}),this.formList.forEach(function(a){a.key===t&&e++}),1!==e},checkInput:function(){this.switchSaveBtnState()},switchSaveBtnState:function(){var t=this;this.$nextTick(function(){var e=0,a=!0;t.tempFormList.forEach(function(i,s){a?t.$refs["tempForm"+s][0].validate(function(t){t||(e++,a=!1)}):t.$refs["tempForm"+s][0].validate(function(t){})}),t.saveBtnState=!t.tempFormList.length||!!e})}}},n=(a("9O1b"),a("KHd+")),o=Object(n.a)(s,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"dynaForm",staticStyle:{height:"100%",position:"relative","box-sizing":"border-box"},style:{paddingTop:t.btnsBoxHeight+"px"}},[t.hideBtn?a("div",{ref:"btnsBox",staticClass:"dynaFormBtn",staticStyle:{position:"absolute",top:"0",right:"0"}},[a("el-button",{attrs:{type:"text",size:"mini",icon:"el-icon-plus"},on:{click:t.addAttr}},[t._v("自定义属性")])],1):t._e(),t._v(" "),a("div",{staticClass:"formBox",staticStyle:{height:"100%","overflow-y":"auto"}},[a("el-form",{ref:"resultForm",staticStyle:{padding:"5px"},attrs:{"label-position":"left","label-width":"75px"}},t._l(t.formList,function(e,i){return a("el-form-item",{key:e.key,attrs:{label:e.key}},[a("el-input",{staticStyle:{width:"calc(100% - 27px)"},attrs:{placeholder:"请输入",clearable:""},model:{value:e.value,callback:function(a){t.$set(e,"value",a)},expression:"item.value"}}),a("el-button",{staticStyle:{padding:"5px"},attrs:{type:"text",icon:"el-icon-remove",title:"删除该项"},on:{click:function(a){a.preventDefault(),t.removeDomain(e,i)}}})],1)}),1)],1),t._v(" "),a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:"自定义属性",visible:t.isVisible,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,width:"400px","append-to-body":""},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen}},[a("div",{staticClass:"addContent",staticStyle:{"box-sizing":"border-box",padding:"5px 10px"}},[a("div",[t._l(t.tempFormList,function(e,i){return[a("el-row",{staticStyle:{position:"relative",border:"1px solid #E4E4E4","border-radius":"4px","margin-bottom":"10px"}},[a("el-form",{ref:"tempForm"+i,refInFor:!0,staticStyle:{width:"90%",padding:"5px"},attrs:{model:e,"label-position":"left","label-width":"75px"}},[a("el-form-item",{staticStyle:{"margin-bottom":"20px"},attrs:{label:"属性名称:",prop:"key",rules:t.itemRule}},[a("el-input",{attrs:{placeholder:"请输入属性名",clearable:""},on:{blur:function(a){t.checkInput(e,i)}},model:{value:e.key,callback:function(a){t.$set(e,"key",a)},expression:"item.key"}})],1),t._v(" "),a("el-form-item",{staticStyle:{"margin-bottom":"0"},attrs:{label:"属性值:"}},[a("el-input",{attrs:{placeholder:"请输入属性值",clearable:""},model:{value:e.value,callback:function(a){t.$set(e,"value",a)},expression:"item.value"}})],1)],1),t._v(" "),a("div",{staticStyle:{position:"absolute",right:"8px",top:"50%",transform:"translate(0,-50%)"}},[a("el-button",{staticStyle:{padding:"5px"},attrs:{type:"text",icon:"el-icon-remove",title:"删除该项"},on:{click:function(a){t.deleteContent(e,i)}}})],1)],1)]})],2),t._v(" "),a("div",{ref:"dialogBtn",staticStyle:{"text-align":"center"}},[a("el-button",{staticStyle:{padding:"5px",width:"100%",border:"1px dashed #E4E4E4"},attrs:{type:"text",size:"medium",icon:"el-icon-plus"},on:{click:t.addContent}},[t._v("新增属性")])],1)]),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary",disabled:t.saveBtnState},on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)},[],!1,null,null,null);o.options.__file="index.vue";e.a=o.exports},WxTd:function(t,e,a){},YPSH:function(t,e,a){"use strict";a.r(e);var i=a("f/WR"),s=a("uTIz"),n=a("NaOS"),o={name:"encapsulation",components:{transferTable:i.a,DynaForm:n.a,searchBar:s.a},data:function(){return{userInfo:null,isVisible:!1,showDialog:!1,guid:"",btnList:[{name:"生成盘点任务",isShow:!0,state:!0,method:this.addMenu},{name:"清空",icon:"refresh",state:!0,plain:!0,method:this.resetQuery,isShow:!0}],apiData:{apiName:"listPageLogInfo",params:{}},tableSelectList:[],stateBtnData:{title:"上次盘点至今变动过的货品"},tableConfigs:{showIndex:!0,isSingle:!1,isSortable:!1},formTemp:[{key:"haha",value:"sde"}],searchList:[{label:"货品编码",type:"input",ruleType:"code",ruleOps:{min:6,max:7},mapKey:"goodsCode",configs:{},placeholder:"请输入编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"goodsName",configs:{},placeholder:"请输入货物名"},{label:"盘点时间",type:"select",ruleType:"number",mapKey:"inventoryTime",configs:{clearable:!0,name:"",options:[{value:1,label:"由近到远"},{value:2,label:"由远到近"}]},placeholder:"请选择"},{label:"库存变动时间",type:"select",mapKey:"inventoryChangeTime",configs:{clearable:!0,name:"",options:[{value:1,label:"近3天内"},{value:2,label:"近一周内"},{value:3,label:"近一个月"},{value:4,label:"近三个月"},{value:5,label:"近一年"}]},placeholder:"请选择"},{label:"库存数量",type:"cascader",mapKey:"cascaded",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},placeholder:"请选择"},{label:"货品总金额",type:"select",mapKey:"totalAmount",configs:{clearable:!0,name:"",options:[{value:1,label:"从低到高"},{value:2,label:"从高到低"}]},placeholder:"请选择"},{label:"盘点日期",type:"date",ruleType:"date",mapKey:"date",configs:{clearable:!0,name:"",type:"date",pickerOptions:{disabledDate:["2018-09-15","2018-10-20"]}},placeholder:"请选择"},{label:"盘点时间",type:"time",mapKey:"time",configs:{clearable:!0,name:"",pickerOptions:{}},placeholder:"选择时间"},{label:"货品单价",type:"magnifier",mapKey:"magnifier",configs:{dialogType:"table",apiName:"listPageRoles",params:{}},placeholder:"请选择"}],searchMethod:{},searchConfig:{}}},created:function(){this.userInfo=this.$storage.get("userInfo")},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},methods:{changeRoleState:function(t,e){console.log(t),console.log(e)},testBtn:function(t,e){console.log(t),console.log(e)},editRole:function(t,e){console.log(t),console.log(e)},getList:function(){this.$refs.dynaForm.getFormList()},formListResult:function(t){console.log(t)},searchMap:function(t){console.log(t)},searchRes:function(t){console.log(t)},sendGuid:function(t){this.guid=t},dialogBtns:function(){this.showDialog=!0,this.isVisible=!0},addMenu:function(){console.log(this.tableSelectList)},resetQuery:function(){this.$refs.trabsferTables.clearTableSelected()},tableSelected:function(t){this.tableSelectList=t}}},l=(a("KxAj"),a("KHd+")),r=Object(l.a)(o,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"testPage"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList,searchMethod:t.searchMethod,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"search-res":t.searchRes,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px","margin-top":t.searchList.length?"10px":"0"}},[a("div",{staticStyle:{float:"left",width:"210px",height:"100%"}}),t._v(" "),a("div",{staticStyle:{float:"left",width:"calc(100% - 210px)",height:"100%"}},[a("transfer-table",{ref:"trabsferTables",attrs:{tableConfigs:t.tableConfigs,btnList:t.btnList,stateBtn:t.stateBtnData,apiData:t.apiData},on:{"table-selected":t.tableSelected}})],1)])],1)},[],!1,null,null,null);r.options.__file="index.vue";e.default=r.exports},"f/WR":function(t,e,a){"use strict";a("XfO3"),a("HEwt"),a("a1Th"),a("rE2o"),a("ioFf"),a("dRSK"),a("rGqo"),a("91GP");var i=a("z0WU"),s=a("Yfch");function n(t){return function(t){if(Array.isArray(t))return t}(t)||function(t){if(Symbol.iterator in Object(t)||"[object Arguments]"===Object.prototype.toString.call(t))return Array.from(t)}(t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}()}var o={props:["colConfig","fixed"],template:'<el-table-column :label="colConfig.label" :fixed="fixed" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t  <template v-for="(item, index) in colConfig.rowMethods">\n    \t\t\t\t\t    <el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="item.method(scope.row,scope.$index)" v-text="item.name"></el-button>\n                </template>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},l={components:{},name:"transfer-table",props:{tableConfigs:{type:Object,default:function(){return{}}},btnList:{type:Array,default:function(){return[]}},upTableBtnTemplate:{type:Array,default:function(){return[]}},downTableBtnTemplate:{type:Array,default:function(){return[]}},apiData:{type:Object,default:function(){return{}}},stateBtn:{type:Object,default:function(){return{}}}},data:function(){return{btnsBoxHeight:0,currentpage:1,tableLoading:!1,tableData:[],resultTableData:[],titleList:[],pageData:{},tableBtns:{columnIndex:"last",prop:"operate",label:"操作",component:o,rowMethods:[{name:"删除",method:this.deleteRow}]},rowKey:"",tempSelectList:[],stateBtnChecked:!1}},computed:{setTablesHeight:function(){return this.stateBtn.title?{height:"calc(50% - 15px)"}:{height:"calc(50% - 6px)"}},setResultBtnState:function(){var t=this;return function(e){return!t.resultTableData.length&&e.state}},setTableConfigs:function(){var t=n(this.titleList).slice(0);return{titleList:this.addTableTitle(t,this.upTableBtnTemplate),showIndex:void 0!==this.tableConfigs.showIndex&&this.tableConfigs.showIndex,isSingle:void 0!==this.tableConfigs.isSingle&&this.tableConfigs.isSingle,isSortable:void 0!==this.tableConfigs.isSortable&&this.tableConfigs.isSortable}},setResultTableConfigs:function(){var t=n(this.titleList).slice(0);return this.downTableBtnTemplate.length?this.addTableTitle(t,this.downTableBtnTemplate):this.addTableTitle(t,[this.tableBtns])},setResultTableData:function(){return[].concat(this.resultTableData)}},watch:{currentpage:function(){var t=Object.assign({},this.apiData.params);t.pageNo=this.currentpage,this.httpTableMethod(this.apiData.apiName,t)},setResultTableData:function(){this.$emit("table-selected",this.setResultTableData)},stateBtnChecked:function(){var t={};t[this.stateBtn.keyName?this.stateBtn.keyName:"isShow"]=this.stateBtnChecked,this.httpTableMethod(this.apiData.apiName,this.apiData.params,t)},"apiData.params":function(){console.log(this.apiData.params),this.httpTableMethod(this.apiData.apiName,this.apiData.params)}},created:function(){this.apiData.apiName?(this.httpTableMethod(this.apiData.apiName,this.apiData.params),this.rowKey=this.tableConfigs.rowKey||"id"):this.$message({message:"没有设置接口名",type:"error",duration:1e4})},mounted:function(){this.$nextTick(function(){this.btnsBoxHeight=this.$refs.btnsBox.clientHeight+5})},methods:{clearTableSelected:function(){var t=this;this.resultTableData=[],this.tempSelectList=[],this.tableData.forEach(function(e){t.$refs.selectTable.$refs.baseTable.clearSelection()})},httpTableMethod:function(t,e,a){var i=this;this.tableLoading=!0,this.$api[t](Object.assign({},e,a)).then(function(t){console.log(t),i.getListPage(t),i.tableLoading=!1}).catch(function(t){i.tableLoading=!1})},getListPage:function(t){var e=this;t&&(t.result.titles="string"==typeof t.result.titles?JSON.parse(t.result.titles):t.result.titles,t.result.varList="string"==typeof t.result.varList?JSON.parse(t.result.varList):t.result.varList,t.result.pageData="string"==typeof t.result.pageData?JSON.parse(t.result.pageData):t.result.pageData,this.titleList=Object(i.m)(t.result),this.pageData=t.result.pageData,this.tableData=t.result.varList||[],this.tempSelectList=[],this.$nextTick(function(t){e.toggleRowSelected()}))},toggleRowSelected:function(){var t=this;this.tableData.forEach(function(e){t.resultTableData.some(function(a){return e[t.rowKey]===a[t.rowKey]})?(t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!0),!t.tempSelectList.some(function(a){return a[t.rowKey]===e[t.rowKey]})&&t.tempSelectList.push(e)):t.$refs.selectTable&&t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!1)})},addTableTitle:function(t,e){return e&&e.length&&e.forEach(function(e){Object(s.b)(e.columnIndex)?t.splice(e.columnIndex,0,e):"first"===e.columnIndex?t.unshift(e):"last"===e.columnIndex?t.push(e):t.some(function(t){if(t.prop===e.columnIndex)return Object.assign(t,e),!0})}),t},dataBridge:function(t,e){this.getChecked(e,t)?this.addRowData(e):this.removeRowData(e)},resultDataBridge:function(t,e){console.log(t),console.log(e)},deleteRow:function(t,e){var a=this;console.log(t),console.log(e),this.resultTableData.find(function(e,i){if(t[a.rowKey]===e[a.rowKey])return a.resultTableData.splice(i,1),e}),this.toggleRowSelected()},updateView:function(t,e){this.resultTableData.splice(e-1,1,t)},getChecked:function(t,e){var a=this;return t?e.some(function(e){return t[a.rowKey]===e[a.rowKey]}):(e.length&&(this.tempSelectList=e),!!e.length)},addRowData:function(t){var e=this;t?!this.resultTableData.some(function(a){return t[e.rowKey]===a[e.rowKey]})&&this.resultTableData.push(t):this.addAllRowData()},addAllRowData:function(){var t=this;this.resultTableData.length?this.tempSelectList.forEach(function(e){t.addRowData(e)}):this.resultTableData=this.tempSelectList},removeRowData:function(t){var e=this;t?this.resultTableData.some(function(a,i){if(t[e.rowKey]===a[e.rowKey])return e.resultTableData.splice(i,1),!0}):this.tableData.forEach(function(t){e.removeRowData(t)})}}},r=(a("K8no"),a("KHd+")),c=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"myCoustomTable",staticStyle:{height:"100%",padding:"10px"}},[t.stateBtn.title?a("div",{staticStyle:{"text-align":"right"}},[a("el-checkbox",{model:{value:t.stateBtnChecked,callback:function(e){t.stateBtnChecked=e},expression:"stateBtnChecked"}},[t._v(t._s(t.stateBtn.title))])],1):t._e(),t._v(" "),a("div",{style:t.setTablesHeight},[a("base-table",{directives:[{name:"loading",rawName:"v-loading",value:t.tableLoading,expression:"tableLoading"}],ref:"selectTable",attrs:{data:t.tableData,colConfigs:t.setTableConfigs.titleList,showCheckBox:!0,showIndex:t.setTableConfigs.showIndex,pageData:t.pageData,currentpage:t.currentpage,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.dataBridge}})],1),t._v(" "),a("div",{staticStyle:{height:"11px"}}),t._v(" "),a("div",{ref:"resultBox",staticStyle:{position:"relative"},style:t.setTablesHeight},[a("div",{staticStyle:{height:"100%"},style:{paddingBottom:t.btnsBoxHeight+"px"}},[a("base-table",{ref:"resultTable",attrs:{data:t.setResultTableData,colConfigs:t.setResultTableConfigs,showCheckBox:!1,showIndex:t.setTableConfigs.showIndex,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{databridge:t.resultDataBridge}})],1),t._v(" "),a("div",{ref:"btnsBox",staticStyle:{position:"absolute",bottom:"0",right:"0"}},[t.btnList.length?[t._l(t.btnList,function(e,i){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],key:i,attrs:{name:e.name,icon:e.icon,plain:e.plain,state:t.setResultBtnState(e)},on:{myclick:e.method}})]})]:t._e()],2)])])},[],!1,null,"438f4cfc",null);c.options.__file="index.vue";e.a=c.exports}}]);