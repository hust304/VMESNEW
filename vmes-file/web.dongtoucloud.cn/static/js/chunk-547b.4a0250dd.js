(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-547b","chunk-d47f"],{"0Koe":function(e,t,a){},AZ8z:function(e,t,a){"use strict";a.d(t,"a",function(){return s});a("rE2o"),a("ioFf"),a("dRSK"),a("Oyvg"),a("a1Th");function i(e){return(i="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}function n(e){return Object.prototype.toString.call(e).slice(8,-1)}function o(e){var t="";e.global&&(t+="g"),e.ignoreCase&&(t+="i"),e.multiline&&(t+="m");var a=new RegExp(e,t);return a.lastIndex=e.lastIndex,a}function s(e){if(null==e||"object"!==i(e))return e;var t;switch(n(e)){case"RegExp":return o(e);case"Date":return new Date(e.getTime());case"Function":return e;case"Array":t=[];break;default:t=Object.create(Object.getPrototypeOf(e))}for(var a=[],s=[{parent:t,key:void 0,data:e}],l=function(){var e=s.pop(),t=e.parent,l=e.key,r=e.data,c=t;if(void 0!==l)switch(n(r)){case"RegExp":return t[l]=o(r),"continue";case"Date":return t[l]=new Date(r.getTime()),"continue";case"Function":return t[l]=r,"continue";case"Array":c=t[l]=[];break;default:var u=Object.getPrototypeOf(r);c=t[l]=Object.create(u)}var h=a.find(function(e){return e.source===r});if(h)return t[l]=h.target,"continue";for(var d in a.push({source:r,target:c}),r)r.hasOwnProperty(d)&&(null==r[d]||"object"!==i(r[d])?c[d]=r[d]:s.push({parent:c,key:d,data:r[d]}))};s.length;)l();return t}},ArEB:function(e,t,a){},FXWM:function(e,t,a){"use strict";var i=a("ArEB");a.n(i).a},MCfF:function(e,t,a){"use strict";var i=a("0Koe");a.n(i).a},WIyV:function(e,t,a){"use strict";a("91GP"),a("dRSK"),a("rGqo"),a("INYr"),a("xfY5");var i=a("8WZi"),n=a("z0WU"),o=a("DKCI"),s=a("50Ol"),l=(a("F9dT"),a("Yfch"),a("YP4+")),r=a("WwWg"),c=a("AZ8z"),u=a("mwzG"),h={name:"single-table",mixins:[i.a],provide:function(){return{rootVm:this}},props:{varList:{type:Array,default:function(){return[]}},isFixed:{type:Number,default:1},isSortable:{type:Boolean,default:!1},isRemoval:{type:Boolean,default:!1},useDefaultBtn:{type:Boolean,default:!1},rowKey:{type:String,default:"id"}},data:function(){return{componentName:"singleTable",data:null,fixedList:[],scrollTimer:"",checkedViewHeight:0,pageId:"",initLoading:!0,headerWidthList:[],headerWidthTimerList:[],listLength:-1,selectOptionList:[],selectLoading:!1,tempVarList:[],guid:"",pageNo:1,defaultOperation:{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",method:this.defaultDeleteRow}]},constantWidth:l.a.tableComponentWidth,autoWidthTimer:{},autoWidthList:[],setScrollWidthTimer:-2,autoWidthSwitch:!1,autoWidths:[],columnWidth:{},isLoading:!0,fileList:[],removalVarListTimer:null}},components:{tableFilter:o.a,customSummaryOption:s.a},directives:{"auto-width":{inserted:function(e,t,a){var i=a.context,n=t.value.component?t.value.component.length:0;n>1&&e.clientHeight>60&&i.$set(i.columnWidth,t.value.prop,60*Math.ceil(n/2)+25+"px")}},"merga-width":{bind:function(e,t,a){!a.context.autoWidthTimer[t.value.id]&&(a.context.autoWidthTimer[t.value.id]=-1)},inserted:function(e,t,a){!a.context.autoWidthList.length&&(a.context.autoWidthList=a.context.setTitleList.map(function(e){return[]})),a.context.$nextTick(function(i){-1===a.context.autoWidthTimer[t.value.id]&&(a.context.autoWidthTimer[t.value.id]=setTimeout(function(i){var n=e.offsetWidth,o=t.value,s=a.context.autoWidthList;if(s[o.parentLayer].length)if(s[o.parentLayer][o.selfLayer]>-1){var l=s[o.parentLayer][o.selfLayer];s[o.parentLayer].splice(o.selfLayer,1,n+l)}else s[o.parentLayer][o.selfLayer]=n;else{var r=[];r[o.selfLayer]=n,s.splice(o.parentLayer,1,r)}},20))})}}},computed:{setColumnGlobalStyle:function(){return this.columnGlobalStyle},setVarList:function(){return this.varList.concat([])},removalVarList:function(){return this.removalVarLists(this.setVarList)},setInitLoading:function(){return this.mergeTitle.length?this.initLoading||this.isLoading:this.initLoading},setTableLoading:function(){return this.showTableSet?this.showTableSet&&this.setInitLoading:this.setInitLoading},tableData:function(){return this.$store.getters[this.guid+"/tableData"]||{}},resetPageDataHeight:function(){var e=0;return"boolean"==typeof this.hidePages?!this.hidePages&&this.hasPageData&&(e=this.setSmallPageHeight):void 0===this.hidePages&&(e=this.setSmallPageHeight),e},resetHeight:function(){return this.checkedViewHeight+this.customSummaryOptionHeight+this.resetPageDataHeight},tempCustomColumn:function(){return this.customColumn.concat([])},setCustomColumn:function(){if(this.useDefaultBtn){var e=this.tempCustomColumn.findIndex(function(e){return"last"===e.columnIndex});return e>-1?this.tempCustomColumn.splice(e,1,this.defaultOperation):this.tempCustomColumn.push(this.defaultOperation),this.tempCustomColumn}return this.tempCustomColumn}},created:function(){var e=this;this.guid=Object(n.a)(),Object(r.c)(this),this.apiObj.apiName&&("0"===this.userInfo.userId?setTimeout(function(){e.data=u.a,e.data.result.varList&&e.data.result.varList.length>0&&e.data.result.varList.forEach(function(e){e.rowState="1"}),e.$store.commit(e.guid+"/SET_TABLEDATA",{res:e.data,vm:e}),e.pageId=e.$storage.get("menuId"),e.setDragTable&&e.setSort(),e.$store.commit(e.guid+"/SET_TABLERULELIST",{cb:e.tableRuleForm,ruleId:"root",vm:e}),e.initLoading=!1},1e3):this.httpRequests())},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},beforeDestroy:function(){!this.layer&&Object(r.g)(this.$store,this.guid)},updated:function(){},watch:{"tableData.tableData":function(){this.setFixed(),this.setTableCheckBoxDisplay()},"apiObj.params":function(){this.httpRequests()},autoWidthList:{deep:!0,handler:function(e,t){var a=this;clearTimeout(this.setScrollWidthTimer),this.setScrollWidthTimer=setTimeout(function(t){a.autoWidths=e.map(function(e){var t=Math.max.apply(null,e);return t>-9999&&t<9999?t+20:0});var i=0;a.autoWidths.forEach(function(e){i+=e}),a.setShowCheckBox&&(i+=55),a.setShowIndex&&(i+=50),a.setDragTable&&(i+=50);var n=a.$el.clientWidth>i?(a.$el.clientWidth-i)/a.autoWidthList.length:0;a.autoWidths=a.autoWidths.map(function(e){return e?e+n:null}),a.setFixed(),a.autoWidthSwitch=!0,a.isLoading=!1},100)}},removalVarList:function(){var e=this;clearInterval(this.removalVarListTimer),this.removalVarListTimer=setInterval(function(t){e.tableData.titleList&&e.tableData.titleList.length&&(clearInterval(e.removalVarListTimer),e.pushData(e.removalVarList))},200)},initData:function(){var e=this;this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:null,ruleId:"root"});var t=JSON.parse(JSON.stringify(this.initData));this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setDragTable&&this.setSort(),this.pageNo=this.tableData.pageData&&this.tableData.pageData.current||1,this.initLoading=!1,this.$nextTick(function(t){e.scrollTable()}),this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:"root",vm:this})}},methods:{defaultDeleteRow:function(e,t,a){this.deleteData(e)},removalVarLists:function(e){var t=this;if("transferTable"===this.useScenarios)return Object(c.a)(e);var a=[];return e.forEach(function(e,i){!e._internalId&&(e._internalId=Object(n.n)());var o=JSON.parse(JSON.stringify(e));!t.tempVarList.find(function(e){return e._internalId===o._internalId})&&a.push(o)}),a.length&&(this.tempVarList=this.tempVarList.concat(a)),a},httpRequests:function(e){var t=this;this.initLoading=!0,this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:null,ruleId:"root"}),this.$api[this.apiObj.apiName](Object.assign({},this.apiObj.params,{pageNo:e||1})).then(function(a){t.data=a,t.pageNo=a.result.pageData&&a.result.pageData.current||1,t.data.result.varList&&t.data.result.varList.length&&t.data.result.varList.forEach(function(e){e.rowState="1",e._internalId=Object(n.n)()}),t.$store.commit(t.guid+"/SET_TABLEDATA",{res:t.data,vm:t}),t.pageId=t.$storage.get("menuId"),t.setDragTable&&t.setSort(),t.initLoading=!1,e&&t.$nextTick(function(e){t.scrollTable()}),t.$store.commit(t.guid+"/SET_TABLERULELIST",{cb:t.tableRuleForm,ruleId:"root",vm:t})}).catch(function(e){console.log(e),t.initLoading=!1})},setStyle:function(e){},selectItem:function(e,t){this.$emit("databridge",e,t),this.isSingle&&(e.length?(this.tableData[this.dataName].forEach(function(e){e.rowState="0"}),e[0].rowState="1"):this.tableData[this.dataName].forEach(function(e){e.rowState="1"}))},selectAllItem:function(e){if(this.isSingle){if(e.length)for(var t=e.length-1;t>=0;t--)e.splice(t,1)}else this.$emit("databridge",e)},handleCurrentChange:function(e){e!==this.pageNo&&(this.apiObj.apiName?this.httpRequests(e)&&(this.tempVarList=[]):this.$emit("current-change",e))},updateTable:function(){this.apiObj&&this.apiObj.apiName&&this.httpRequests()},updateData:function(){this.apiObj&&this.apiObj.apiName&&this.httpRequests()}}},d=(a("FXWM"),a("KHd+")),b=Object(d.a)(h,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:!e.disableLoading&&e.setTableLoading,expression:"!disableLoading && setTableLoading"}],ref:"tableWrapper",staticClass:"columnBaseTable myCoustomTable resetCoustomTableStyle",staticStyle:{height:"100%",position:"relative"}},[e.showTableSet&&"outside"===e.tableSetMode?a("table-filter",{attrs:{headerList:e.setColConfigs,tableSwitchState:e.setTableSwitch,storeId:e.pageId,componentId:e.componentId},on:{"checked-list":e.checkedList,"checked-height":e.checkedHeight}}):e._e(),e._v(" "),a("div",{style:{height:e.setTableHeight}},[a("el-form",{ref:"ruleForm",style:{height:"100%"},attrs:{model:e.ruleForm,"status-icon":""},nativeOn:{submit:function(e){e.preventDefault()}}},[a("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:e.tableData.tableData,stripe:"",border:"","current-row-key":e.rowKey,"tooltip-effect":"dark",height:"100%",fit:"","header-cell-class-name":e.setStyle,"row-key":"_internalId","default-sort":e.setSortableConfig["default-sort"],"show-summary":e.setSysSummary},on:{select:e.selectItem,"select-all":e.selectAllItem,"selection-change":e.selectionChange,"sort-change":e.sortChange,"row-click":e.rowClick,"row-dblclick":e.rowDblclick}},[e.setShowCheckBox?[a("el-table-column",{attrs:{type:"selection",fixed:e.fixedState,selectable:e.selectable,width:"55",align:"center"}})]:e._e(),e._v(" "),e.setShowIndex?[a("el-table-column",{attrs:{type:"index",index:e.indexMethod,fixed:e.fixedState,label:"序号",width:"50",align:"center"}})]:e._e(),e._v(" "),e._l(e.setTitleList,function(t,i){return[t.slot?a("tempalte",[e._t(t.slot,null,{fixed:e.setFixedList[i]})],2):Array.isArray(t.component)?[a("el-table-column",e._b({key:i,attrs:{"show-overflow-tooltip":"",fixed:e.setFixedList[i],"min-width":e.setColumnWidth[t.prop],align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[a("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:i,isComponent:!0,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}],staticStyle:{display:"inline-flex","white-space":"nowrap"},domProps:{textContent:e._s(t.label)}})]}},{key:"default",fn:function(i){return[a("div",{directives:[{name:"auto-width",rawName:"v-auto-width",value:t,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":e.setColumnWidth[t.prop]?"space-between":"center"}},e._l(t.component,function(t,n){return void 0!==t.editBtns_isShow&&!t.editBtns_isShow||!t.rowState||e.setButtonState(i.$index,i.row,t)?a("el-button",{key:n,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(e){t.method(i.row,i.$index,i)}}},[e._v(e._s(t.name))]):e._e()}),1)]}}])},"el-table-column",t,!1))]:"object"!=typeof t.component||Array.isArray(t.component)?[t._isShow||"outside"!==e.tableSetMode?a("el-table-column",{key:i,attrs:{"show-overflow-tooltip":"",prop:t.prop,width:t._isShow?"":e.setTableColumnState?"20":"","min-width":t._isShow?t.width||e.constantWidth[t.componentName]||e.autoWidths[i]||null:"",sortable:void 0===t.sortable?e.isSortable:t.sortable,fixed:e.setFixedList[i],align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[a("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:i,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"},{name:"custom-table-switch",rawName:"v-custom-table-switch",value:{config:t,index:i,showSwitch:e.setTableColumnState},expression:"{config:colConfig,index:infoIndex,showSwitch:setTableColumnState}"}],style:{display:t._isShow?"inline-flex":"none","white-space":"nowrap"},domProps:{textContent:e._s(t.label)}})]}},{key:"default",fn:function(n){return[a("core-index",{directives:[{name:"show",rawName:"v-show",value:!!t._isShow||"outside"===e.tableSetMode,expression:"colConfig._isShow?true:tableSetMode === 'outside'"}],attrs:{scope:n,"info-index":i,"col-config":t,runTime:"base"}})]}}])}):e._e()]:[a(t.component,{key:i,tag:"component",attrs:{"col-config":t,fixed:e.setFixedList[i]}})]]}),e._v(" "),e.setDragTable?[a("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:e._u([{key:"default",fn:function(e){return[a("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[a("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)]}}])})]:e._e()],2)],1),e._v(" "),e.setUseSummary&&e.setCustomSummary.component?[a("custom-summary-option",{attrs:{customSummary:e.setCustomSummary,tempData:e.setTempData,tableData:e.tableData.tableData},on:{"send-height":e.customSummaryHeight,"custom-summary-value":e.customSummaryValue}})]:e._e()],2),e._v(" "),!e.hidePages&&e.hasPageData?a("div",{staticStyle:{"text-align":"center"},style:{"margin-top":(e.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[a("el-pagination",{attrs:{background:!e.smallPage,small:e.smallPage,"current-page":e.tableData.pageData.current,"page-size":e.tableData.pageData.size,layout:"prev, pager, next, jumper",total:e.tableData.pageData.total-0},on:{"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.tableData.pageData,"current",t)}}})],1):e._e()],1)},[],!1,null,"3b7b21d4",null);b.options.__file="index.vue";t.a=b.exports},varj:function(e,t,a){"use strict";a("dRSK"),a("INYr"),a("91GP"),a("rGqo"),a("z0WU"),a("Yfch");var i=a("AZ8z"),n={props:["colConfig","fixed"],template:'<el-table-column :label="colConfig.label" :fixed="fixed" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t  <template v-for="(item, index) in colConfig.rowMethods">\n    \t\t\t\t\t    <el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="item.method(scope.row,scope.$index)" v-text="item.name"></el-button>\n                </template>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},o={components:{customBaseTable:a("WIyV").a},name:"custom-transfer-table",props:{btnList:{type:Array,default:function(){return[]}},stateBtn:{type:Object,default:function(){return{}}},aboveTableConfig:{type:Object,default:function(){return{}}},belowTableConfig:{type:Object,default:function(){return{}}},addColumns:{type:Array,default:function(){return[]}},hideColumns:{type:Array,default:function(){return[]}},deDuplication:{type:Boolean,default:!1},useDefaultBtn:{type:Boolean,default:!0},rowKey:{type:String,default:"id"}},data:function(){return{selectTableGuid:"",resultTableGuid:"",aboveTableLoading:!0,belowTableLoading:!0,btnsBoxHeight:0,currentpage:1,tableLoading:!1,resultTableData:[],titleList:[],pageData:{},tableBtns:{columnIndex:"last",prop:"operate",label:"操作",component:n,rowMethods:[{name:"删除",method:this.deleteRow}]},tempSelectList:[],stateBtnChecked:!1,aboveTableInitData:{},belowTableInitData:null,belowTableDataTimer:""}},computed:{apiData:function(){return this.aboveTableConfig.apiObj||null},belowApiData:function(){return this.belowTableConfig.apiObj||null},setBelowTableLoading:function(){return!!this.belowApiData&&this.belowTableLoading},setCustomTransferTableLoading:function(){return this.aboveTableLoading||this.setBelowTableLoading},setTablesHeight:function(){return this.stateBtn.title?{height:"calc(50% - 15px)"}:{height:"calc(50% - 6px)"}},setResultBtnState:function(){var e=this;return function(t){return!e.resultTableData.length&&t.state}},mixCustomColumn:function(){return[].concat([],this.addColumns,this.belowTableConfig.customColumn||[],this.useDefaultBtn?[this.tableBtns]:[])},setResultTableData:function(){return[].concat(this.resultTableData)},selectTableData:function(){return this.selectTableGuid?this.$store.getters[this.selectTableGuid+"/tableData"]:{}},tableData:function(){return this.selectTableData.tableData||[]},belowTableData:function(){return this.resultTableGuid&&this.$store.getters[this.resultTableGuid+"/tableData"].tableData||[]}},watch:{setResultTableData:function(){var e=this,t=Object(i.a)(this.setResultTableData);(t||[]).forEach(function(t){e.addColumns.forEach(function(a){t.hasOwnProperty([a.prop])||(t[a.prop]=e.initRowDataValue(a.componentName))})}),this.$refs.resultTable.updataTableRow&&this.$refs.resultTable.updataTableRow(t)},stateBtnChecked:function(){var e={};e[this.stateBtn.keyName?this.stateBtn.keyName:"isShow"]=this.stateBtnChecked,this.httpAboveTableData(this.apiData.apiName,this.apiData.params,e)},"apiData.params":function(){var e={};e[this.stateBtn.keyName?this.stateBtn.keyName:"isShow"]=this.stateBtnChecked,this.httpAboveTableData(this.apiData.apiName,this.apiData.params,e)}},created:function(){this.apiData&&this.httpAboveTableData(this.apiData.apiName,this.apiData.params),this.belowApiData&&this.httpBelowTableData(this.belowApiData.apiName,this.belowApiData.params)},mounted:function(){this.$nextTick(function(){this.selectTableGuid=this.$refs.selectTable.guid,this.resultTableGuid=this.$refs.resultTable.guid,this.btnsBoxHeight=this.$refs.btnsBox.clientHeight+5})},methods:{initRowDataValue:function(e){return e?"cascader"===e?[]:"inputNumber"===e||"progress"===e?0:"":""},clearTableSelected:function(){var e=this;this.resultTableData=[],this.tempSelectList=[],this.tableData.forEach(function(t){e.$refs.selectTable.$refs.baseTable.clearSelection()})},httpAboveTableData:function(e,t,a){var i=this;this.aboveTableLoading=!0,this.$api[e](Object.assign({},t,a)).then(function(e){i.aboveTableInitData=e,i.belowApiData||i.belowTableInitData||(i.belowTableInitData=i.initBelowTableData(e)),i.tempSelectList=[],i.$nextTick(function(e){i.toggleRowSelected()}),i.aboveTableLoading=!1}).catch(function(e){i.aboveTableLoading=!1})},httpBelowTableData:function(e,t,a){var i=this;this.belowTableLoading=!0,this.$api[e](Object.assign({},t,a)).then(function(e){i.belowTableInitData=i.initBelowTableData(e),i.belowTableLoading=!1}).catch(function(e){i.belowTableLoading=!1})},initBelowTableData:function(e){if(e){var t=this.belowApiData?e:Object(i.a)(e),a=this.belowApiData?Object(i.a)("string"==typeof t.result.varList?JSON.parse(t.result.varList):t.result.varList):[];return t.result.titles="string"==typeof t.result.titles?JSON.parse(t.result.titles):t.result.titles,t.result.hideTitles="string"==typeof t.result.hideTitles?JSON.parse(t.result.hideTitles):t.result.hideTitles,this.hideColumns.forEach(function(e){!(t.result.hideTitles.findIndex(function(t){return e===t})>-1)&&t.result.hideTitles.push(e)}),t.result.varList=[],this.belowApiData&&this.addBelowTableData(a),t}},addBelowTableData:function(e){var t=this;clearInterval(this.belowTableDataTimer),this.belowTableDataTimer=setInterval(function(a){t.selectTableData.titleList&&t.selectTableData.tableData&&(clearInterval(t.belowTableDataTimer),t.dataBridge(e),t.toggleRowSelected())},50)},toggleRowSelected:function(){var e=this;this.tableData.forEach(function(t){e.resultTableData.some(function(a){return t[e.rowKey]===a[e.rowKey]})?(e.$refs.selectTable.$refs.baseTable.toggleRowSelection(t,!0),!e.tempSelectList.some(function(a){return a[e.rowKey]===t[e.rowKey]})&&e.tempSelectList.push(t)):e.$refs.selectTable&&e.$refs.selectTable.$refs.baseTable.toggleRowSelection(t,!1)})},currentChange:function(e){var t={};t[this.stateBtn.keyName?this.stateBtn.keyName:"isShow"]=this.stateBtnChecked,this.httpAboveTableData(this.apiData.apiName,this.apiData.params,Object.assign({},{pageNo:e},t))},dataBridge:function(e,t){this.getChecked(t,e)?this.addRowData(t):this.removeRowData(t)},resultDataBridge:function(e,t){},deleteRow:function(e,t){var a=this;this.resultTableData.find(function(t,i){if(e[a.rowKey]===t[a.rowKey])return a.resultTableData.splice(i,1),t}),this.toggleRowSelected()},getChecked:function(e,t){var a=this;return e?t.some(function(t){return e[a.rowKey]===t[a.rowKey]}):(t.length&&(this.tempSelectList=t),!!t.length)},addRowData:function(e){var t=this;e?!this.resultTableData.some(function(a){return e[t.rowKey]===a[t.rowKey]})&&this.resultTableData.push(e):this.addAllRowData()},addAllRowData:function(){var e=this;this.resultTableData.length?this.tempSelectList.forEach(function(t){e.addRowData(t)}):this.resultTableData=this.tempSelectList},removeRowData:function(e){var t=this;e?this.resultTableData.some(function(a,i){if(e[t.rowKey]===a[t.rowKey])return t.resultTableData.splice(i,1),!0}):this.tableData.forEach(function(e){t.removeRowData(e)})},getTableSelected:function(){this.$emit("table-selected",this.belowTableData)}}},s=a("KHd+"),l=Object(s.a)(o,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.setCustomTransferTableLoading,expression:"setCustomTransferTableLoading"}],staticClass:"myCoustomTable resetTransferTableStyle",staticStyle:{height:"100%",padding:"10px"}},[e.stateBtn&&e.stateBtn.title?a("div",{staticStyle:{"text-align":"right"}},[a("el-checkbox",{model:{value:e.stateBtnChecked,callback:function(t){e.stateBtnChecked=t},expression:"stateBtnChecked"}},[e._v(e._s(e.stateBtn.title))])],1):e._e(),e._v(" "),a("div",{style:e.setTablesHeight},[a("custom-base-table",{ref:"selectTable",attrs:{"data-custom-table-id":"components_customTransferTable_index0",useScenarios:"transferTable",isRemoval:e.aboveTableConfig.isRemoval||!1,showIndex:e.aboveTableConfig.showIndex||!1,showCheckBox:e.aboveTableConfig.showCheckBox||!1,showTableSet:e.aboveTableConfig.showTableSet||!1,customColumn:e.aboveTableConfig.customColumn,initData:e.aboveTableInitData,mergeTitle:e.aboveTableConfig.mergeTitle,componentId:"transferAboveTable",tempData:e.aboveTableConfig.tempData,dragTable:e.aboveTableConfig.dragTable,entireRowDrag:e.aboveTableConfig.entireRowDrag},on:{"current-change":e.currentChange,databridge:e.dataBridge}})],1),e._v(" "),a("div",{staticStyle:{height:"11px"}}),e._v(" "),a("div",{ref:"resultBox",staticStyle:{position:"relative"},style:e.setTablesHeight},[a("div",{staticStyle:{height:"100%"},style:{paddingBottom:e.btnsBoxHeight+"px"}},[a("custom-base-table",{ref:"resultTable",attrs:{"data-custom-table-id":"components_customTransferTable_index1",useScenarios:"transferTable",isRemoval:e.belowTableConfig.isRemoval||!1,showIndex:e.belowTableConfig.showIndex||!1,showCheckBox:e.belowTableConfig.showCheckBox||!1,showTableSet:e.belowTableConfig.showTableSet||!1,hidePages:e.belowTableConfig.hidePages||!0,customColumn:e.mixCustomColumn,initData:e.belowTableInitData,mergeTitle:e.belowTableConfig.mergeTitle,componentId:"transferBelowTable",tempData:e.belowTableConfig.tempData,dragTable:e.belowTableConfig.dragTable,entireRowDrag:e.belowTableConfig.entireRowDrag},on:{databridge:e.resultDataBridge}})],1),e._v(" "),a("div",{ref:"btnsBox",staticStyle:{position:"absolute",bottom:"0",right:"0"}},[e.btnList.length?[e._l(e.btnList,function(t,i){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],key:i,attrs:{name:t.name,icon:t.icon,plain:t.plain,state:e.setResultBtnState(t)},on:{myclick:t.method}})]})]:e._e()],2)])])},[],!1,null,null,null);l.options.__file="index.vue";t.a=l.exports},vpHr:function(e,t,a){"use strict";a.r(t);a("91GP");var i=a("varj"),n=a("uTIz"),o={name:"encapsulation",components:{customTransferTable:i.a,searchBar:n.a},data:function(){return{userInfo:null,guid:"",btnList:[{name:"生成盘点任务",isShow:!0,state:!0,method:this.addMenu},{name:"清空",icon:"refresh",state:!0,plain:!0,method:this.resetQuery,isShow:!0}],stateBtnData:{title:"上次盘点至今变动过的货品"},aboveTableConfig:{apiObj:{apiName:"listPageLogInfo",params:{}},customColumn:[{columnIndex:"userCode",width:200,componentName:"input",_cellConfig:{rules:[{required:!0}],message:["必填"],icon:"search"}},{columnIndex:"cdate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy年MM月dd日",valueFormat:"yyyy-MM-dd"}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"新增",nameEn:"add",editBtns_isShow:!0,method:this.reviseData},{name:"删除1",nameEn:"delete1",editBtns_isShow:!0,rowState:"#self@count#===10",method:this.deleteAllRow},{name:"删除2",nameEn:"delete2",editBtns_isShow:!0,rowState:"#self@count#===9",method:this.deleteAllRow},{name:"删除3",nameEn:"delete3",editBtns_isShow:!0,method:this.deleteAllRow}]}],tempData:{count:100,defaultDate:"2019-01-21"},showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,leftFixed:2,rightFixed:1,sortableConfig:{"default-sort":{prop:"count",order:"descending"},progress:{},count:{}},dragTable:!1,entireRowDrag:!1},belowTableConfig:{customColumn:[{columnIndex:"operateUrl",width:200,componentName:"input",_cellConfig:{rules:[{required:!0}],message:["必填"],icon:"search"}},{columnIndex:"cdate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy年MM月dd日",valueFormat:"yyyy-MM-dd"}},{columnIndex:"userName",componentName:"select",_cellConfig:{asyn:{apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},rules:[{required:!0}]}}],tempData:{count:100,defaultDate:"2019-01-21"},showIndex:!0,showCheckBox:!1,leftFixed:2,rightFixed:1,dragTable:!0,entireRowDrag:!1},addColumns:[{columnIndex:5,prop:"userCode1",label:"操作人账号1",componentName:"cascader",_cellConfig:{asyn:{apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},rules:[{required:!0}]}}],hideColumns:["operate"],tableSelectList:[],searchList:[{label:"货品编码",type:"input",ruleType:"code",ruleOps:{min:6,max:7},mapKey:"goodsCode",configs:{},placeholder:"请输入编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"goodsName",configs:{},placeholder:"请输入货物名"},{label:"盘点时间",type:"select",ruleType:"number",mapKey:"inventoryTime",configs:{clearable:!0,name:"",options:[{value:1,label:"由近到远"},{value:2,label:"由远到近"}]},placeholder:"请选择"},{label:"库存变动时间",type:"select",mapKey:"inventoryChangeTime",configs:{clearable:!0,name:"",options:[{value:1,label:"近3天内"},{value:2,label:"近一周内"},{value:3,label:"近一个月"},{value:4,label:"近三个月"},{value:5,label:"近一年"}]},placeholder:"请选择"},{label:"库存数量",type:"cascader",mapKey:"cascaded",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},placeholder:"请选择"},{label:"货品总金额",type:"select",mapKey:"totalAmount",configs:{clearable:!0,name:"",options:[{value:1,label:"从低到高"},{value:2,label:"从高到低"}]},placeholder:"请选择"},{label:"盘点日期",type:"date",ruleType:"date",mapKey:"date",configs:{clearable:!0,name:"",type:"date",pickerOptions:{disabledDate:["2018-09-15","2018-10-20"]}},placeholder:"请选择"},{label:"盘点时间",type:"time",mapKey:"time",configs:{clearable:!0,name:"",pickerOptions:{}},placeholder:"选择时间"},{label:"货品单价",type:"magnifier",mapKey:"magnifier",configs:{dialogType:"table",apiName:"listPageRoles",params:{}},placeholder:"请选择"}]}},created:function(){this.userInfo=this.$storage.get("userInfo")},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},methods:{changeRoleState:function(e,t){console.log(e),console.log(t)},testBtn:function(e,t){console.log(e),console.log(t)},editRole:function(e,t){console.log(e),console.log(t)},searchMap:function(e){this.aboveTableConfig.apiObj.params=Object.assign({},this.aboveTableConfig.apiObj.params,e),this.belowTableConfig.apiObj&&this.belowTableConfig.apiObj.params&&(this.belowTableConfig.apiObj.params=Object.assign({},this.belowTableConfig.apiObj.params,e)),console.log(this.aboveTableConfig.apiObj.params)},sendGuid:function(e){this.guid=e},tableSelected:function(e){console.log(e,"tableSelected"),this.tableSelectList=e},addMenu:function(){this.$refs.trabsferTables.getTableSelected()},resetQuery:function(){this.$refs.trabsferTables.clearTableSelected()}}},s=(a("MCfF"),a("KHd+")),l=Object(s.a)(o,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"customTransferTableDemo"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px","margin-top":e.searchList.length?"10px":"0"}},[a("div",{staticStyle:{height:"100%"}},[a("custom-transfer-table",{ref:"trabsferTables",attrs:{aboveTableConfig:e.aboveTableConfig,belowTableConfig:e.belowTableConfig,deDuplication:!1,addColumns:e.addColumns,hideColumns:e.hideColumns,btnList:e.btnList,stateBtn:e.stateBtnData},on:{"table-selected":e.tableSelected}})],1)])],1)},[],!1,null,null,null);l.options.__file="index.vue";t.default=l.exports}}]);