(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7095","chunk-336d","chunk-7167"],{"2+ib":function(t,e,i){"use strict";i("dRSK"),i("INYr"),i("91GP"),i("Vd3H"),i("rGqo"),i("f3/d"),i("xfY5");var a=i("4Q6Z"),n=i("z0WU"),o=i("DKCI"),s=i("50Ol"),l=i("F9dT"),r=(i("Yfch"),i("YP4+")),c=i("WwWg"),d=(i("evdt"),i("mwzG")),u={name:"multilevel-table",mixins:[a.a],provide:function(){return{rootVm:this}},props:{expand:[Boolean],expandMode:[String],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,showColList:"",headerWidthList:[],listLength:-1,restaurants:[],debounce:300,fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:o.a,customSummaryOption:s.a},computed:{setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer,defaultSpacingClass:!this.layer&&this.maxLayer>1,noSpacingClass:this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return!!this.layer&&(!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2))}},created:function(){var t=this;if(console.log(this.layer,"created"),!this.layer)if(this.guid=Object(n.a)(),this.userInfo=this.$storage.get("userInfo"),Object(c.c)(this),this.initData.result){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var e=JSON.parse(JSON.stringify(d.a));t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:e,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.initLoading=!1},1e3):this.httpRequests());this.layer&&(console.log("test"),this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.tableData[this.dataName].forEach(function(t){t.rowState="1"}),this.setDragTable&&this.setSort(),this.initLoading=!1,this.tableDoLayout()):(console.log("test"),this.$emit("narrow-row",this.parentData[0]),this.initLoading=!1,this.tableDoLayout()))},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){var t=this;
//!this.layer && unCreateStore(this.$store, this.guid)
this.tempCheckedList.forEach(function(e){t.$store.commit(t.setGuid+"/DELETE_CHECKED",[e])})},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay()},initData:function(){var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1},resetContentWidthList:function(){var t=this,e=this.resetContentWidthList.map(function(t){return null});this.resetContentWidthList.forEach(function(i,a){t.useMiddleValue=!1,e[a]=t.contentWidthAlgorithm(i.map(function(t){return Math.max.apply(null,t)})),t.useMiddleValueList[a]=t.useMiddleValue}),e.forEach(function(e,i){t.contentWidthList[i]=e?e+26:null}),console.log(e,this.contentWidthList,this.useMiddleValueList,this.contentTitleWidthList)}},methods:{contentWidthAlgorithm:function(t){if(t&&t.length){if(t.length>1){var e=Math.max.apply(null,t);if(e-Math.min.apply(null,t)>this.setWidthDiffValue){var i,a=[].concat(t);return a.sort(n.d),i=a.length%2==0?(a[a.length/2-1]+a[a.length/2])/2:a[(a.length+1)/2-1],this.useMiddleValue=!0,e-i>this.setWidthDiffValue&&(i=2*this.setWidthDiffValue),i}return e}return t[0]}return null},databridge:function(t,e){this.$emit("databridge",t,e)},expandChange:function(t,e){var i=this;"one"===this.setExpandMode&&e.forEach(function(i,a){t._internalId!==i._internalId&&e.splice(a,1)}),this.$refs.baseTable.$nextTick(function(t){i.$refs.baseTable&&i.$refs.baseTable.doLayout&&i.$refs.baseTable.doLayout(),i.$emit("table-dolayout")})},setRowExpansion:function(t,e){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(t,e)},httpRequests:function(t){var e=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:t||1},this.searchObj)).then(function(i){e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:i,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1,t&&(e.pageNo=t,e.scrollTable())}).catch(function(t){console.log(t),e.initLoading=!1})},httpChildrenRequests:function(t,e){var i=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:e||1},this.setParams(t,this.setApiObj),this.setDynaValue(t))).then(function(a){i.$store.commit(i.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:a,row:t,vm:i}),i.setDragTable&&i.setSort(),i.pageNo=i.tableData[i.dataName].pageData&&i.tableData[i.dataName].pageData.current||1,i.initLoading=!1,i.tableDoLayout(),console.log("initLoading---\x3e",i.initLoading),e&&i.scrollTable()}).catch(function(t){console.log(t),i.initLoading=!1})},selectItem:function(t,e){console.log(t,e),t.findIndex(function(t){return t._internalId===e._internalId})>-1?(this.tempCheckedList.push(e),this.$store.commit(this.setGuid+"/ADD_CHECKED",[e])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[e]),this.tempCheckedList=this.tempCheckedList.filter(function(t){return t._internalId!==e._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:t.length?"0":"1"}),t.length?(this.tableData[this.dataName].forEach(function(t){t.rowState="0"}),t[0].rowState="1"):this.tableData[this.dataName].forEach(function(t){t.rowState="1"}))},selectAllItem:function(t){if(console.log(t),this.setIsSingle){if(t.length)for(var e=t.length-1;e>=0;e--)t.splice(e,1)}else t.length?(this.tempCheckedList=t.map(function(t){return t}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(t){t!==this.pageNo&&this.httpRequests(t)},setDynaValue:function(t){if(this.setDynamicValue){var e={};for(var i in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(i)&&(e[i]=Object(l.c)([this.setDynamicValue[i]],t,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return console.log(e),e}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setCellStyle:function(t){return this.setExpand&&2===this.maxLayer&&"1"===this.setExpandColumnWidth?{"border-bottom":"none","background-color":"inherit"}:{"background-color":"inherit"}},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(t,e){var i=this;return e&&t?(this.resultTableData=(t.tableData||t.children).find(function(t){if(t._internalId===e)return!0;if(t.children&&t.children.length){var a={titleList:t.titleList,children:t.children,pageData:t.pageData||{}};i.resultTableData=i.searchTableData(a,e)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(t){this.$emit("callmethod",t)},tableDoLayout:function(){var t=this;this.$nextTick(function(e){t.$refs.baseTable&&t.$refs.baseTable.doLayout&&t.$refs.baseTable.doLayout(),t.$emit("table-dolayout")})}}},h=(i("q7oa"),i("KHd+")),p=Object(h.a)(u,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.setTableLoading,expression:"setTableLoading"}],staticClass:"myCoustomTable resetCoustomTableStyle",class:t.setTableClass},[t.setShowTableSet?i("table-filter",{attrs:{headerList:t.setColConfigs,storeId:t.pageId,componentId:t.setComponentId,showAll:t.setShowAll},on:{"checked-list":t.checkedList,"checked-height":t.checkedHeight}}):t._e(),t._v(" "),i("div",{style:{height:t.setTableHeight}},[i("el-form",{ref:"ruleForm",style:{height:t.layer?"auto":"100%"},attrs:{model:t.ruleForm,"status-icon":""},nativeOn:{submit:function(t){t.preventDefault()}}},[i("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:t.tableData[t.dataName],stripe:!t.setExpand||"50"===t.setExpandColumnWidth,"highlight-current-row":"",border:t.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:t.layer?null:"100%",fit:"","show-header":t.setShowHeader,"row-key":"_internalId","show-summary":t.setSysSummary,"default-expand-all":!t.setShowExpandBtn&&t.setExpand&&"all"===t.setExpandMode,"header-row-style":t.setHeaderRowStyle,"row-style":t.setRowStyle,"row-class-name":t.setRowClass,"cell-style":t.setCellStyle,"header-row-class-name":t.setHeaderRowClass,"default-sort":t.setSortableConfig["default-sort"]},on:{select:t.selectItem,"select-all":t.selectAllItem,"selection-change":t.selectionChange,"expand-change":t.expandChange,"sort-change":t.sortChange,"row-click":t.rowClick,"row-dblclick":t.rowDblclick}},[t.setExpand?[i("el-table-column",{attrs:{type:"expand",width:t.setExpandColumnWidth,align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("multilevel-table",{attrs:{tableConfigList:t.tableConfigList,layer:t.layer+1,internalGuid:t.setGuid,parentData:[e.row],rowChain:t.setRowChain},on:{databridge:t.databridge,callmethod:t.callParentMethod,"table-dolayout":t.tableDoLayout,"narrow-row":t.narrowRow}})]}}])})]:t._e(),t._v(" "),t.setShowCheckBox?[i("el-table-column",{attrs:{type:"selection",fixed:t.setFixedState,selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.setShowIndex?[i("el-table-column",{attrs:{type:"index",index:t.indexMethod,fixed:t.setFixedState,label:"序号",width:"50",align:"center"}})]:t._e(),t._v(" "),t._l(t.setTitleList,function(e,a){return[e.slot&&e._isShow?t._t(e.slot,null,{fixed:t.setFixedList[a]}):Array.isArray(e.component)&&e._isShow?[i("el-table-column",t._b({key:a,attrs:{"show-overflow-tooltip":"",fixed:t.setFixedList[a],width:t.setColumnWidth[e.prop]||null,align:"center"},scopedSlots:t._u([{key:"header",fn:function(n){return[i("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:a,isComponent:!0,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[t._v("\n                  "+t._s(e.label)+"\n                ")])]}},{key:"default",fn:function(a){return["button"===e.componentName?i("div",{directives:[{name:"button-width",rawName:"v-button-width",value:e,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":t.setColumnWidth[e.prop]?"space-between":"center"}},t._l(e.component,function(e,n){return void 0!==e.editBtns_isShow&&!e.editBtns_isShow||!e.rowState||t.setButtonState(a.$index,a.row,e)?i("el-button",{key:n,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(t){e.method(a.row,a.$index,a)}}},[t._v(t._s(e.name)+"\n                  ")]):t._e()}),1):t._e()]}}])},"el-table-column",e,!1))]:"object"==typeof e.component&&e._isShow?i(e.component,{key:a,tag:"component",attrs:{"col-config":e,fixed:t.setFixedList[a]}}):[e._isShow?i("el-table-column",{key:a,attrs:{"show-overflow-tooltip":"",label:e.label,prop:e.prop||e.columnIndex,width:e.width||t.constantWidth[e.componentName]||"auto","min-width":e["min-width"]||t.contentWidthList[a]||"none",sortable:!!t.setSortableConfig[e.prop||e.columnIndex],"sort-method":t.setSortableConfig[e.prop||e.columnIndex]&&t.setSortableConfig[e.prop||e.columnIndex]["sort-method"]?t.setSortableConfig[e.prop||e.columnIndex]["sort-method"]:null,"sort-by":t.setSortableConfig[e.prop||e.columnIndex]&&t.setSortableConfig[e.prop||e.columnIndex]["sort-by"]?t.setSortableConfig[e.prop||e.columnIndex]["sort-by"]:null,fixed:t.setFixedList[a],align:"center"},scopedSlots:t._u([{key:"header",fn:function(n){return[i("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:a,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"}],style:{display:e._isShow?"inline-flex":"none"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(n){return[e.mergeTitles&&e.mergeTitles.length?[t._l(e.mergeTitles,function(o,s){return[o.componentName?["input"===o.componentName?[o._cellConfig.asyn?[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-autocomplete",{attrs:{_scope:n,"child-colconfig":o,debounce:t.debounce}})],1)])]:[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-input",{attrs:{_scope:n,"child-colconfig":o}})],1)])]]:"date"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-date-picker",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"time"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-time-picker",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"select"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-select",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"cascader"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-cascader",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"switch"===o.componentName?[i("div",{on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[o._cellConfig.hideTitle?t._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[t._v("\n                            "+t._s(o.label+":")+" \n                          ")]),t._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-switch",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"dateTime"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-date-time",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"inputNumber"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-input-number",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"steps"===o.componentName?[i("div",{key:s,staticClass:"resetElStepStyle",on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[o._cellConfig.hideTitle?t._e():i("div",{style:o._cellConfig.titleStyle||{}},[t._v("\n                            "+t._s(o.label+":")+" \n                          ")]),t._v(" "),i("div",[i("table-steps",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"progress"===o.componentName?[i("div",{key:s,staticStyle:{"text-align":"left"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[o._cellConfig.hideTitle?t._e():i("div",{staticStyle:{display:"inline-block"},style:[{"line-height":o._cellConfig.componentConfig["stroke-width"]>23?2:""},o._cellConfig.titleStyle||(t.setColumnGlobalStyle?t.setColumnGlobalStyle.titleStyle:{})||{}]},[t._v("\n                            "+t._s(o.label+":"+(o._cellConfig.componentConfig.showInitValue?n.row[o.prop]:""))+" \n                          ")]),t._v(" "),i("div",{staticClass:"resetProgressStyle",staticStyle:{display:"inline-block",overflow:"hidden","vertical-align":"middle"},style:{width:(o._cellConfig.componentConfig.width||t.constantWidth[o.componentName])+"px"}},[i("table-progress",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"upload"===o.componentName?[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-upload",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"tag"===o.componentName?[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-tag",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"button"===o.componentName?[o._cellConfig.hideTitle?t._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[t._v("\n                          "+t._s(o.label+":")+" \n                        ")]),t._v(" "),i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-button",{attrs:{_scope:n,"child-colconfig":o}})],1)]:[i("span",{key:s,staticStyle:{"margin-left":"10px"},domProps:{textContent:t._s(n.row[o.prop])}})]]:[i("div",{key:s,style:{"text-align":o._cellConfig&&o._cellConfig.hideTitle?"center":"left"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[o._cellConfig?[o._cellConfig.hideTitle?t._e():[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:e,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:[o._cellConfig.titleStyle||(t.setColumnGlobalStyle?t.setColumnGlobalStyle.titleStyle:{}),t.setMiddleValue[a]?t.setMiddleValue[a].title:{}],domProps:{textContent:t._s(o.label+":")}},[t._v(" ")])]]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:e,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:t.setMiddleValue[a]?t.setMiddleValue[a].title:{},domProps:{textContent:t._s(o.label+":")}},[t._v(" ")])],t._v(" "),o._cellConfig&&o._cellConfig.events?[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:e,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"}],style:[o._cellConfig.bodyStyle||(t.setColumnGlobalStyle?t.setColumnGlobalStyle.bodyStyle:{}),t.setMiddleValue[a]?t.setMiddleValue[a].body:{}]},[i("a",{domProps:{textContent:t._s(n.row[o.prop])},on:{click:function(e){t.mergeColumnEvents(o,n)}}})])]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:e,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"},{name:"content-set",rawName:"v-content-set",value:{config:o,row:n.row},expression:"{config: childColconfig,row: scope.row}"}],class:{resetContent:t.setMiddleValue[a],ellipsis:!!t.setMiddleValue[a]&&t.isEllipsis(n.row[o.prop||o.columnIndex],parseInt(t.setMiddleValue[a].body.width))},style:[o._cellConfig?o._cellConfig.bodyStyle:{},t.setColumnGlobalStyle?t.setColumnGlobalStyle.bodyStyle:{},t.setMiddleValue[a]?t.setMiddleValue[a].body:{}],domProps:{textContent:t._s(n.row[o.prop||o.columnIndex])}})]],2)]]})]:[i("div",{style:{display:e._isShow?"inline-block":"none"},domProps:{textContent:t._s(n.row[e.prop])}})]]}}])}):t._e()]]}),t._v(" "),t.setDragTable?[i("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)])]}}])})]:t._e()],2)],1),t._v(" "),t.setUseSummary&&t.setCustomSummary.component?[i("custom-summary-option",{attrs:{customSummary:t.setCustomSummary,tempData:t.setTempData,tableData:t.tableData[t.dataName]},on:{"send-height":t.customSummaryHeight,"custom-summary-value":t.customSummaryValue}})]:t._e()],2),t._v(" "),t.setHidePages?t._e():i("div",{staticStyle:{"text-align":"center"},style:{"padding-top":(t.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[i("el-pagination",{attrs:{background:"","current-page":t.tableData.pageData.current,"page-size":t.tableData.pageData.size,layout:"prev, pager, next, jumper",total:t.tableData.pageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.tableData.pageData,"current",e)}}})],1)],1)},[],!1,null,null,null);p.options.__file="index.vue";e.a=p.exports},D2yE:function(t,e,i){},"F4/0":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d"),i("Oyvg"),i("pIFo");var a=i("uTIz"),n=i("2+ib"),o=i("YcSE"),s=i("b5Ov");function l(t){return(l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var r={components:{searchBar:a.a,multilevelTable:n.a,dialogWarehouseBySimple:o.default},name:"dialog-add",props:["initData","visible"],data:function(){return{sourceWarehouseId:"",warehouse:{name:null,id:null},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{warehouseIds:"",title:"",dialog_width:"",table_style:"",temp:{}},rowTableList:[],tableConfigList:[{customColumn:[{columnIndex:"moveCount",componentName:"input",_cellConfig:{}}],apiObj:{apiName:"listPageWarehouseInitial",params:{warehouseIds:"",productIds:"",fieldCode:"pathName,productCode,productName,productSpec,productGenreName,productUnitName,stockCount,moveCount"}},tempData:{},showHeader:!0,showIndex:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable"}]}},created:function(){if(this.sourceWarehouseId=this.initData.sourceWarehouseId,null!=this.sourceWarehouseId&&this.sourceWarehouseId.trim().length>0){var t="'"+this.sourceWarehouseId.replace(",","','")+"'";this.tableConfigList[0].apiObj.params.warehouseIds=t}var e="";null!=this.initData.productIds&&this.initData.productIds.trim().length>0&&(e=this.initData.productIds.trim()),this.tableConfigList[0].apiObj.params.productIds=e},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=l(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(t){this.rowTableList=[],Array.isArray(t)&&(this.rowTableList=t)},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},updateData:function(t){this.$refs.customBaseTable.updateData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},closeDialog:function(t){"{}"!=JSON.stringify(t)&&(this.warehouse.id=t.id,this.warehouse.name=t.pathName),this.inLinVisible=!1,this.showDialog=!1},selectWarehouse:function(){var t=this.sourceWarehouseId;this.dialogData.warehouseIds=t,this.dialogData.title="选择库位",this.openDialogName="dialogWarehouseBySimple",this.showDialog=!0,this.inLinVisible=!0},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t.trim())},checkValueNumber:function(t,e){var i="";return null==t||0==t.trim().length?i=e+"为空或空字符串！":null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&(i=e+"("+t+")输入错误，请输入大于零的正整数或(1,2)位小数！"),i},checkColumn:function(t){for(var e="",i=0;i<t.length;i++){var a=t[i],n="";null!=a.moveCount&&a.moveCount.trim().length>0&&(n=a.moveCount.trim()+"");var o="0";null!=a.stockCount&&a.stockCount.trim().length>0&&(o=a.stockCount.trim()+"");var s=this.checkValueNumber(n,"移库数量");null!=s&&s.trim().length>0?e=e+"第 "+(i+1)+" 行: "+s:n-o>0&&(e=e+"第 "+(i+1)+" 行: 移库数量不可大于库存数量！")}return e},save:function(){var t=this;if(null!=this.warehouse.name&&0!=this.warehouse.name.trim().length)if(this.$refs.customBaseTable.getData(),null!=this.rowTableList&&0!=this.rowTableList.length){var e=this.checkColumn(this.rowTableList);if(null!=e&&e.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:e});else{var i=[];this.rowTableList.forEach(function(t){var e={warehouseProductId:t.id,count:t.moveCount};i.push(e)});var a="";i.length>0&&(a=JSON.stringify(i)),Object(s.addWarehouseMoveBySimple)({targetWarehouseId:this.warehouse.id,dtlJsonStr:a}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"无盘点货品信息！"});else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择目标仓库，目标仓库为必填项不可为空！"})}}},c=i("KHd+"),d=Object(c.a)(r,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:t.initData.dialog_width},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("el-row",{staticStyle:{width:"300px","margin-top":"15px","margin-left":"2%"}},[i("b",[t._v("目标仓库:")]),t._v(" "),i("el-input",{attrs:{value:t.warehouse.name,placeholder:"请选择",disabled:!0,clearable:!0}},[i("el-button",{attrs:{slot:"append",icon:"el-icon-search"},on:{click:t.selectWarehouse},slot:"append"})],1)],1),t._v(" "),i("el-row",{style:t.initData.table_style},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)},[],!1,null,null,null);d.options.__file="dialogAdd.vue";e.default=d.exports},IfZh:function(t,e,i){"use strict";i.d(e,"b",function(){return n}),i.d(e,"a",function(){return o}),i.d(e,"c",function(){return s});var a=i("t3Un");function n(t){return Object(a.a)({url:"/warehouse/warehouseInDispatch/listPageWarehouseInDetail",method:"post",data:t})}function o(t){return Object(a.a)({url:"/warehouse/warehouseInDispatch/findWarehouseListByWarehouseIn",method:"post",data:t})}function s(t){return Object(a.a)({url:"/warehouse/warehouseInDispatch/updateWarehouseInDispatch",method:"post",data:t})}},"T/cP":function(t,e,i){"use strict";var a=i("xQNa");i.n(a).a},YcSE:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d");var a=i("K3g7"),n=i("IfZh"),o=i("z0WU"),s=i("mSNy");function l(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}function r(t){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var c={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{queryType:null,productId:"",productType:"",warehouseIds:"",dialogLoading:!1,isVisible:!1,inDialog:!0,tempLable:{},tempQuery:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},BaseTableLoading:!1,tableData:[],selectList:[],configs:{tableConfigs:[],isSingle:!0,showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1,resState:null}},created:function(){var t=this.initData.temp;this.productId=t.productId,this.productType=t.productType,this.warehouseIds=this.initData.warehouseIds,this.initTree()},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=r(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{treeDataBridge:function(t){this.selectTree={pid:t.nodeData.pid,id:t.nodeData.id,name:t.nodeData.name},this.pageNo=1,this.radioChange()},initTree:function(){var t=this;this.dialogLoading=!0;var e=this;Object(a.treeWarehouse)({notInWarehouseIds:this.warehouseIds}).then(function(t){var i=[],a=t.result.treeList;e.selectTree={pid:a.pid,id:a.id,name:a.name},i.push(a),e.treeData=i,e.initTable(null,null,null,null,null),e.$nextTick(function(){e.$refs.tree.$children[0].setCurrentKey(e.selectTree.id)})}).catch(function(e){t.dialogLoading=!1})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(o.l)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var a=t[i];a.indexOf("_")>0&&("en"==s.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==s.a.locale&&(a=a.substring(0,a.indexOf("_")))),e.tempLable[i]=a}})},addTableTitle:function(t){return t.forEach(function(t){var e=t.label;e.indexOf("_")>0&&("en"==s.a.locale?t.label=e.substring(e.indexOf("_")+1):"zh"==s.a.locale&&(t.label=e.substring(0,e.indexOf("_"))))}),t},initTable:function(t,e,i,a,o){var s=this;null!=e&&0!=e.trim().length||(e=""),null!=i&&0!=i.trim().length||(i=""),null!=a&&0!=a.trim().length||(a=""),null!=o&&0!=o.trim().length||(o=""),t&&(this.BaseTableLoading=!0),Object(n.a)(function(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){l(t,e,i[e])})}return t}({},this.tempQuery,{notInWarehouseIds:this.warehouseIds,nodeId:e,productId:i,productType:a,isExistProd:o,pageNo:this.pageNo})).then(function(e){s.getListPage(e),s.dialogLoading=!1,t&&(s.BaseTableLoading=!1)}).catch(function(t){s.dialogLoading=!1,s.BaseTableLoading=!1})},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},radioChange:function(){var t="",e="",i="";"productId"==this.queryType?(t=this.productId,i="true"):"productType"==this.queryType?(e=this.productType,i="true"):"warehouseId"==this.queryType&&(i="false");var a="";null!=this.selectTree&&null!=this.selectTree.id&&this.selectTree.id.trim().length>0&&(a=this.selectTree.id.trim()),this.initTable(!0,a,t,e,i)},dataBridge:function(t){if(null!=t&&t.length>0){var e=t[0];e.pageName="dialogChangeWarehouseByIn",this.selectList.push(e)}},save:function(){var t={id:this.selectList[0].id,pathName:this.selectList[0].pathName};this.dialogClose(t),this.isVisible=!1}},watch:{pageNo:function(){this.initTable()}}},d=(i("T/cP"),i("KHd+")),u=Object(d.a)(c,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("el-row",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:t.treeData,treeConfigs:t.treeConfigs},on:{treedatabridge:t.treeDataBridge}})],1),t._v(" "),i("el-col",{attrs:{span:20}},[i("div",{staticClass:"tableContent",staticStyle:{"margin-left":"10px"}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.BaseTableLoading,expression:"BaseTableLoading"}],staticStyle:{height:"400px"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,isSingle:t.configs.isSingle,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)]),t._v(" "),i("el-row",{staticStyle:{height:"100px","text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)],1)},[],!1,null,null,null);u.options.__file="dialogWarehouseBySimple.vue";e.default=u.exports},q7oa:function(t,e,i){"use strict";var a=i("D2yE");i.n(a).a},xQNa:function(t,e,i){}}]);