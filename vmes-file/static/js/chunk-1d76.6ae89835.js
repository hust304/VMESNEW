(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-1d76","chunk-336d","3+RD"],{"/Owj":function(t,e,i){},"2+ib":function(t,e,i){"use strict";i("dRSK"),i("INYr"),i("91GP"),i("Vd3H"),i("rGqo"),i("f3/d"),i("xfY5");var a=i("4Q6Z"),n=i("z0WU"),o=i("DKCI"),s=i("50Ol"),l=i("F9dT"),r=(i("Yfch"),i("YP4+")),d=i("WwWg"),c=(i("evdt"),i("mwzG")),u={name:"multilevel-table",mixins:[a.a],provide:function(){return{rootVm:this}},props:{expand:[Boolean],expandMode:[String],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,showColList:"",headerWidthList:[],listLength:-1,restaurants:[],debounce:300,fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:o.a,customSummaryOption:s.a},computed:{setGlobalSingle:function(){return this.layerConfig.globalSingle||this.globalSingle||!1},setLayerSingle:function(){return this.layerConfig.layerSingle||this.layerSingle||!1},setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer,defaultSpacingClass:!this.layer&&this.maxLayer>1,noSpacingClass:this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return!!this.layer&&(!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2))}},created:function(){var t=this;if(!this.layer)if(this.guid=Object(n.a)(),this.userInfo=this.$storage.get("userInfo"),Object(d.c)(this),this.initData.result){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var e=JSON.parse(JSON.stringify(c.a));t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:e,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.initLoading=!1},1e3):this.httpRequests());this.layer&&(this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.setDragTable&&this.setSort(),this.initLoading=!1,this.tableDoLayout()):(this.initLoading=!1,this.tableDoLayout()))},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){//!this.layer && unCreateStore(this.$store, this.guid)
},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay()},initData:function(){var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1},resetContentWidthList:function(){var t=this,e=this.resetContentWidthList.map(function(t){return null});this.resetContentWidthList.forEach(function(i,a){t.useMiddleValue=!1,e[a]=t.contentWidthAlgorithm(i.map(function(t){return Math.max.apply(null,t)})),t.useMiddleValueList[a]=t.useMiddleValue}),e.forEach(function(e,i){t.contentWidthList[i]=e?e+26:null}),console.log(e,this.contentWidthList,this.useMiddleValueList,this.contentTitleWidthList)}},methods:{contentWidthAlgorithm:function(t){if(t&&t.length){if(t.length>1){var e=Math.max.apply(null,t);if(e-Math.min.apply(null,t)>this.setWidthDiffValue){var i,a=[].concat(t);return a.sort(n.d),i=a.length%2==0?(a[a.length/2-1]+a[a.length/2])/2:a[(a.length+1)/2-1],this.useMiddleValue=!0,e-i>this.setWidthDiffValue&&(i=2*this.setWidthDiffValue),i}return e}return t[0]}return null},databridge:function(t,e){this.$emit("databridge",t,e)},expandChange:function(t,e){var i=this;"one"===this.setExpandMode&&e.forEach(function(i,a){t._internalId!==i._internalId&&e.splice(a,1)}),this.$refs.baseTable.$nextTick(function(t){console.log("doLayout1"),i.$refs.baseTable.doLayout(),i.$emit("table-dolayout")})},setRowExpansion:function(t,e){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(t,e)},httpRequests:function(t){var e=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:t||1},this.searchObj)).then(function(i){e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:i,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1,t&&(e.pageNo=t,e.scrollTable())}).catch(function(t){console.log(t),e.initLoading=!1})},httpChildrenRequests:function(t,e){var i=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:e||1},this.setParams(t,this.setApiObj),this.setDynaValue(t))).then(function(a){i.$store.commit(i.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:a,row:t,vm:i}),i.setDragTable&&i.setSort(),i.pageNo=i.tableData[i.dataName].pageData&&i.tableData[i.dataName].pageData.current||1,i.initLoading=!1,i.tableDoLayout(),console.log("initLoading---\x3e",i.initLoading),e&&i.scrollTable()}).catch(function(t){console.log(t),i.initLoading=!1})},selectItem:function(t,e){console.log(t,e),t.findIndex(function(t){return t._internalId===e._internalId})>-1?(this.tempCheckedList.push(e),this.$store.commit(this.setGuid+"/ADD_CHECKED",[e])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[e]),this.tempCheckedList=this.tempCheckedList.filter(function(t){return t._internalId!==e._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:t.length?"0":"1"}),t.length?(this.tableData[this.dataName].forEach(function(t){t.rowState="0"}),t[0].rowState="1"):this.tableData[this.dataName].forEach(function(t){t.rowState="1"}))},selectAllItem:function(t){if(console.log(t),this.setIsSingle){if(t.length)for(var e=t.length-1;e>=0;e--)t.splice(e,1)}else t.length?(this.tempCheckedList=t.map(function(t){return t}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(t){t!==this.pageNo&&this.httpRequests(t)},setDynaValue:function(t){if(this.setDynamicValue){var e={};for(var i in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(i)&&(e[i]=Object(l.c)([this.setDynamicValue[i]],t,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return console.log(e),e}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setCellStyle:function(t){return this.setExpand&&2===this.maxLayer&&"1"===this.setExpandColumnWidth?{"border-bottom":"none","background-color":"inherit"}:{"background-color":"inherit"}},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(t,e){var i=this;return e&&t?(this.resultTableData=(t.tableData||t.children).find(function(t){if(t._internalId===e)return!0;if(t.children&&t.children.length){var a={titleList:t.titleList,children:t.children,pageData:t.pageData||{}};i.resultTableData=i.searchTableData(a,e)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(t){this.$emit("callmethod",t)},tableDoLayout:function(){var t=this;this.$nextTick(function(e){console.log("doLayout2"),t.$refs.baseTable.doLayout(),t.$emit("table-dolayout")})}}},h=(i("q7oa"),i("KHd+")),p=Object(h.a)(u,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.setTableLoading,expression:"setTableLoading"}],staticClass:"myCoustomTable resetCoustomTableStyle",class:t.setTableClass},[t.setShowTableSet?i("table-filter",{attrs:{headerList:t.setColConfigs,storeId:t.pageId,componentId:t.setComponentId,showAll:t.setShowAll},on:{"checked-list":t.checkedList,"checked-height":t.checkedHeight}}):t._e(),t._v(" "),i("div",{style:{height:t.setTableHeight}},[i("el-form",{ref:"ruleForm",style:{height:t.layer?"auto":"100%"},attrs:{model:t.ruleForm,"status-icon":""},nativeOn:{submit:function(t){t.preventDefault()}}},[i("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:t.tableData[t.dataName],stripe:!t.setExpand||"50"===t.setExpandColumnWidth,"highlight-current-row":"",border:t.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:t.layer?null:"100%",fit:"","show-header":t.setShowHeader,"row-key":"_internalId","show-summary":t.setSysSummary,"default-expand-all":!t.setShowExpandBtn&&t.setExpand&&"all"===t.setExpandMode,"header-row-style":t.setHeaderRowStyle,"row-style":t.setRowStyle,"row-class-name":t.setRowClass,"cell-style":t.setCellStyle,"header-row-class-name":t.setHeaderRowClass,"default-sort":t.setSortableConfig["default-sort"]},on:{select:t.selectItem,"select-all":t.selectAllItem,"selection-change":t.selectionChange,"expand-change":t.expandChange,"sort-change":t.sortChange,"row-click":t.rowClick,"row-dblclick":t.rowDblclick}},[t.setExpand?[i("el-table-column",{attrs:{type:"expand",width:t.setExpandColumnWidth,align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("multilevel-table",{attrs:{tableConfigList:t.tableConfigList,layer:t.layer+1,internalGuid:t.setGuid,parentData:[e.row],rowChain:t.setRowChain},on:{databridge:t.databridge,callmethod:t.callParentMethod,"table-dolayout":t.tableDoLayout}})]}}])})]:t._e(),t._v(" "),t.setShowCheckBox?[i("el-table-column",{attrs:{type:"selection",fixed:t.setFixedState,selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.setShowIndex?[i("el-table-column",{attrs:{type:"index",index:t.indexMethod,fixed:t.setFixedState,label:"序号",width:"50",align:"center"}})]:t._e(),t._v(" "),t._l(t.setTitleList,function(e,a){return[e.slot&&e._isShow?t._t(e.slot,null,{fixed:t.setFixedList[a]}):Array.isArray(e.component)&&e._isShow?[i("el-table-column",t._b({key:a,attrs:{"show-overflow-tooltip":"",fixed:t.setFixedList[a],width:t.setColumnWidth[e.prop]||null,align:"center"},scopedSlots:t._u([{key:"header",fn:function(n){return[i("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:a,isComponent:!0,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[t._v("\n                  "+t._s(e.label)+"\n                ")])]}},{key:"default",fn:function(a){return["button"===e.componentName?i("div",{directives:[{name:"button-width",rawName:"v-button-width",value:e,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":t.setColumnWidth[e.prop]?"space-between":"center"}},t._l(e.component,function(e,n){return void 0!==e.editBtns_isShow&&!e.editBtns_isShow||!e.rowState||t.setButtonState(a.$index,a.row,e)?i("el-button",{key:n,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(t){e.method(a.row,a.$index,a)}}},[t._v(t._s(e.name)+"\n                  ")]):t._e()}),1):t._e()]}}])},"el-table-column",e,!1))]:"object"==typeof e.component&&e._isShow?i(e.component,{key:a,tag:"component",attrs:{"col-config":e,fixed:t.setFixedList[a]}}):[e._isShow?i("el-table-column",{key:a,attrs:{"show-overflow-tooltip":"",label:e.label,prop:e.columnIndex||e.prop,width:e.width||t.constantWidth[e.componentName]||"auto","min-width":e["min-width"]||t.contentWidthList[a]||"none",sortable:!!t.setSortableConfig[e.columnIndex||e.prop],"sort-method":t.setSortableConfig[e.columnIndex||e.prop]&&t.setSortableConfig[e.columnIndex||e.prop]["sort-method"]?t.setSortableConfig[e.columnIndex||e.prop]["sort-method"]:null,"sort-by":t.setSortableConfig[e.columnIndex||e.prop]&&t.setSortableConfig[e.columnIndex||e.prop]["sort-by"]?t.setSortableConfig[e.columnIndex||e.prop]["sort-by"]:null,fixed:t.setFixedList[a],align:"center"},scopedSlots:t._u([{key:"header",fn:function(n){return[i("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:a,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"}],style:{display:e._isShow?"inline-flex":"none"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(n){return[e.mergeTitles&&e.mergeTitles.length?[t._l(e.mergeTitles,function(o,s){return[o.componentName?["input"===o.componentName?[o._cellConfig.asyn?[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-autocomplete",{attrs:{_scope:n,"child-colconfig":o,debounce:t.debounce}})],1)]:[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-input",{attrs:{_scope:n,"child-colconfig":o}})],1)]]:"date"===o.componentName?[i("table-date-picker",{attrs:{_scope:n,"child-colconfig":o}})]:"time"===o.componentName?[i("table-time-picker",{attrs:{_scope:n,"child-colconfig":o}})]:"select"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-select",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"cascader"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-cascader",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"switch"===o.componentName?[i("div",[o._cellConfig.hideTitle?t._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[t._v("\n                            "+t._s(o.label+":")+" \n                          ")]),t._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-switch",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"dateTime"===o.componentName?[i("table-date-time",{attrs:{_scope:n,"child-colconfig":o}})]:"inputNumber"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-input-number",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"steps"===o.componentName?[i("div",{key:s,staticClass:"resetElStepStyle"},[o._cellConfig.hideTitle?t._e():i("div",{style:o._cellConfig.titleStyle||{}},[t._v("\n                            "+t._s(o.label+":")+" \n                          ")]),t._v(" "),i("div",[i("table-steps",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"progress"===o.componentName?[i("div",{key:s,staticStyle:{"text-align":"left"}},[o._cellConfig.hideTitle?t._e():i("div",{staticStyle:{display:"inline-block"},style:[{"line-height":o._cellConfig.componentConfig["stroke-width"]>23?2:""},o._cellConfig.titleStyle||(t.setColumnGlobalStyle?t.setColumnGlobalStyle.titleStyle:{})||{}]},[t._v("\n                            "+t._s(o.label+":"+(o._cellConfig.componentConfig.showInitValue?n.row[o.prop]:""))+" \n                          ")]),t._v(" "),i("div",{staticClass:"resetProgressStyle",staticStyle:{display:"inline-block",overflow:"hidden","vertical-align":"middle"},style:{width:(o._cellConfig.componentConfig.width||t.constantWidth[o.componentName])+"px"}},[i("table-progress",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"upload"===o.componentName?[i("table-upload",{attrs:{_scope:n,"child-colconfig":o}})]:"tag"===o.componentName?[i("table-tag",{attrs:{_scope:n,"child-colconfig":o}})]:"button"===o.componentName?[o._cellConfig.hideTitle?t._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[t._v("\n                          "+t._s(o.label+":")+" \n                        ")]),t._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-button",{attrs:{_scope:n,"child-colconfig":o}})],1)]:[i("span",{key:s,staticStyle:{"margin-left":"10px"},domProps:{textContent:t._s(n.row[o.prop])}})]]:[i("div",{key:s,style:{"text-align":o._cellConfig&&o._cellConfig.hideTitle?"center":"left"}},[o._cellConfig?[o._cellConfig.hideTitle?t._e():[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:e,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:[o._cellConfig.titleStyle||(t.setColumnGlobalStyle?t.setColumnGlobalStyle.titleStyle:{}),t.setMiddleValue[a]?t.setMiddleValue[a].title:{}],domProps:{textContent:t._s(o.label+":")}},[t._v(" ")])]]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:e,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:t.setMiddleValue[a]?t.setMiddleValue[a].title:{},domProps:{textContent:t._s(o.label+":")}},[t._v(" ")])],t._v(" "),o._cellConfig&&o._cellConfig.events?[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:e,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"}],style:[o._cellConfig.bodyStyle||(t.setColumnGlobalStyle?t.setColumnGlobalStyle.bodyStyle:{}),t.setMiddleValue[a]?t.setMiddleValue[a].body:{}]},[i("a",{domProps:{textContent:t._s(n.row[o.prop])},on:{click:function(e){t.mergeColumnEvents(o,n)}}})])]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:e,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"},{name:"content-set",rawName:"v-content-set",value:{config:o,row:n.row},expression:"{config: childColconfig,row: scope.row}"}],class:{resetContent:t.setMiddleValue[a],ellipsis:!!t.setMiddleValue[a]&&t.isEllipsis(n.row[o.columnIndex||o.prop],parseInt(t.setMiddleValue[a].body.width))},style:[o._cellConfig?o._cellConfig.bodyStyle:{},t.setColumnGlobalStyle?t.setColumnGlobalStyle.bodyStyle:{},t.setMiddleValue[a]?t.setMiddleValue[a].body:{}],domProps:{textContent:t._s(n.row[o.columnIndex||o.prop])}})]],2)]]})]:[i("div",{style:{display:e._isShow?"inline-block":"none"},domProps:{textContent:t._s(n.row[e.prop])}})]]}}])}):t._e()]]}),t._v(" "),t.setDragTable?[i("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:t._u([{key:"default",fn:function(t){return[i("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[i("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)]}}])})]:t._e()],2)],1),t._v(" "),t.setUseSummary&&t.setCustomSummary.component?[i("custom-summary-option",{attrs:{customSummary:t.setCustomSummary,tempData:t.setTempData,tableData:t.tableData[t.dataName]},on:{"send-height":t.customSummaryHeight,"custom-summary-value":t.customSummaryValue}})]:t._e()],2),t._v(" "),t.setHidePages?t._e():i("div",{staticStyle:{"text-align":"center"},style:{"padding-top":(t.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[i("el-pagination",{attrs:{background:"","current-page":t.tableData.pageData.current,"page-size":t.tableData.pageData.size,layout:"prev, pager, next, jumper",total:t.tableData.pageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.tableData.pageData,"current",e)}}})],1)],1)},[],!1,null,null,null);p.options.__file="index.vue";e.a=p.exports},"3+RD":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("2SRW");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{auditJsonStr:"",dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{remark:[{required:!0,message:"请填写审核原因",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},formTemp:[]}},created:function(){this.auditJsonStr=this.initData.temp.auditJsonStr},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;this.temp.auditExecuteJsonStr=this.auditJsonStr,this.$refs.submitForm.validate(function(e){e&&Object(a.auditDisagreeWarehouseCheckExecute)(t.temp).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"审核成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})},closeDialog:function(t){this.showDialog=!1}}},s=i("KHd+"),l=Object(s.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"不通过原因:",prop:"remark"}},[i("el-input",{staticStyle:{width:"240px"},attrs:{type:"textarea",rows:2},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogAuditDisagree.vue";e.default=l.exports},Cuvw:function(t,e,i){"use strict";var a=i("zo9M");i.n(a).a},D2yE:function(t,e,i){},VfKu:function(t,e,i){"use strict";var a=i("/Owj");i.n(a).a},lZYi:function(t,e,i){"use strict";var a=i("wnxv");i.n(a).a},mtOT:function(t,e,i){"use strict";i.r(e);i("rGqo");var a=i("zDZ1"),n=i("2+ib"),o=i("uTIz"),s=i("3+RD"),l=i("uXxI"),r=i("2SRW"),d=i("Vobf"),c=(i("z0WU"),{components:{dialogQrcode:a.a,multilevelTable:n.a,searchBar:o.a,dialogAuditDisagree:s.default},data:function(){return{searchList:[{label:"盘点单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"盘点单号"},{label:"盘点类型",type:"select",ruleType:"number",mapKey:"type",configs:{clearable:!0,name:"",options:[{value:"1",label:"按库位"},{value:"2",label:"按货品"}]},placeholder:"请选择"},{label:"盘点单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"未完成"},{value:"1",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"规格型号"},{label:"货品属性",type:"input",ruleType:"string",mapKey:"productGenreName",configs:{},placeholder:"货品属性"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"productUnitName",configs:{},placeholder:"请输入计量单位"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"1",text:"已完成"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"未完成"}}}],apiObj:{apiName:"listPagewarehouseChecks",params:{orderStr:" parent.code desc ",isNeedExecutor:"true",queryStr:" detail.state in ('2','3') "}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},warning:{state:"1",text:"执行中"},danger:{state:"2",text:"审核中"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"待派单"}}}],apiObj:{apiName:"findListByWarehouseCheckExecute",params:{isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!0,componentId:"twoLevelTable"}],searchObj:{},selectList:[],configs:{topBarBtnList:[{name:"通过",nameEn:"auditPass",isShow:!0,state:!1,icon:"add",method:this.auditPass},{name:"不通过",nameEn:"auditDisagree",isShow:!0,state:!1,icon:"add",method:this.dialogAuditDisagree}],tableConfigs:[]},temp:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:{auditJsonStr:""},tempLable:null}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"云上企业"}),Object(d.initMenuButtons)({menuId:i,roleId:e}).then(function(e){t.$loading().close();var i=e.buttonList;i&&i.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)})),t.tableConfigList&&t.tableConfigList.forEach(function(t){t.customColumn&&t.customColumn.forEach(function(t){"last"==t.columnIndex&&t.component&&t.component.forEach(function(t){t.nameEn==e.nameEn&&(t.rowState="1==2")})})})})}).catch(function(e){t.$loading().close()}))},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.selectList=[],this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},databridge:function(t){this.temp.detail=t,this.selectList=t,this.configs.topBarBtnList.forEach(function(t){-1!="auditPass,auditDisagree".indexOf(t.nameEn)&&(t.state=!1)});var e=!1;if(null!=t&&t.length>0)for(var i=0;i<t.length;i++){if("2"!=t[i].detailState){e=!0;break}}e&&this.configs.topBarBtnList.forEach(function(t){-1!="auditPass,auditDisagree".indexOf(t.nameEn)&&(t.state=!0)})},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},checkUserRoleByWarehouseAudit:function(){var t=this,e=this.$storage.get("userInfo").roleIds;Object(l.checkUserRoleByWarehouseAudit)(e).then(function(e){t.updateData(t.searchObj)}).catch(function(t){})},auditPass:function(){var t=this,e=this.selectList;if(null!=e&&0!=e.length){var i=this.checkAudit(e);if(null!=i&&i.trim().length>0)return i+=" 请重新选择审核结果是(待审核)的记录！",void this.$message({type:"warning",duration:5e3,showClose:!0,message:i});this.$confirm("您勾选的(审核中)盘点明细将审核通过, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var i=[];null!=e&&e.length>0&&e.forEach(function(t){if(null!=t.detailState&&t.detailState.trim().length>0&&"2"==t.detailState.trim()){var e={id:"",parentId:"",detailId:"",stockCount:"",count:"",code:"",productId:"",warehouseId:""};e.id=t.id,e.parentId=t.parentId,e.detailId=t.detailId,e.stockCount=t.stockCount,e.count=t.count,e.code=t.code,e.productId=t.productId,e.warehouseId=t.warehouseId,i.push(e)}});var a=JSON.stringify(i);t.saveAuditPass(a)}).catch(function(){t.$message({type:"info",message:"已取消删除"})})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条明细！"})},checkAudit:function(t){var e=0,i="";return t.forEach(function(t){var a="";if(null!=t.detailState&&t.detailState.trim().length>0&&(a=t.detailState.trim()),"3"==a)i=i+"第 "+(e+1)+" 行: 明细状态(已完成)，无需审核！";else if("2"==a){var n="";null!=t.state&&t.state.trim().length>0&&(n=t.state.trim(),-1!="2,3".indexOf(n)&&(i=i+"第 "+(e+1)+" 行: 明细已经审核，无需再次审核！"))}e+=1}),i},saveAuditPass:function(t){var e=this;Object(r.auditPassWarehouseCheckExecute)({auditExecuteJsonStr:t}).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"审核成功",type:"success",duration:2e3}),e.updateData(e.searchObj))}).catch(function(t){})},dialogAuditDisagree:function(){var t=this.selectList;if(null!=t&&0!=t.length){var e=this.checkAudit(t);if(null!=e&&e.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:e});else{var i=[];null!=t&&t.length>0&&t.forEach(function(t){if(null!=t.detailState&&t.detailState.trim().length>0&&"2"==t.detailState.trim()){var e={id:"",parentId:"",detailId:""};e.id=t.id,e.parentId=t.parentId,e.detailId=t.detailId,i.push(e)}});var a=JSON.stringify(i);this.dialogData.temp.auditJsonStr=a,this.dialogData.title="盘点审核",this.openDialogName="dialogAuditDisagree",this.showDialog=!0,this.visible=!0}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条明细！"})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),u=(i("Cuvw"),i("KHd+")),h=Object(u.a)(c,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"warehouseCheckManage"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);h.options.__file="index.vue";e.default=h.exports},q7oa:function(t,e,i){"use strict";var a=i("D2yE");i.n(a).a},wnxv:function(t,e,i){},zDZ1:function(t,e,i){"use strict";i("rE2o"),i("ioFf"),i("f3/d"),i("9WTv");function a(t){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},tempShow:{},rules:{},imageUrl:""}},created:function(){console.log(this.initData),this.initData.temp&&(this.temp=this.initData.temp,this.initData.temp.qrcode&&(this.imageUrl="https://web.ouhaicloud.com/"+this.initData.temp.qrcode)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=a(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},download:function(){var t=this.imageUrl,e=document.createElement("a");e.style.display="none",e.href=t,e.setAttribute("download",this.temp.name),document.body.appendChild(e),e.click()},print:function(){var t='<!DOCTYPE html> <html> <head> <meta charset="utf-8"> <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> ';t+="<style></style>",t+="</head><body >",t+=document.getElementById("printContent").innerHTML,t+="</body></html>";var e=window.open("","打印","");e.document.write(t),e.document.close(),e.focus(),e.print(),e.close()},dialogImgLoad:function(){this.$refs.myDialog&&this.$refs.myDialog.reDialogStyle&&this.$refs.myDialog.reDialogStyle(this.$store.getters.systemInfo,!0)}}},o=(i("lZYi"),i("VfKu"),i("KHd+")),s=Object(o.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],ref:"myDialog",attrs:{title:t.initData.title?t.initData.title:"二维码",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("div",{attrs:{id:"printContent"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"text-align":"center","padding-bottom":"20px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},attrs:{span:24}},[t.imageUrl?i("img",{staticClass:"avatar",staticStyle:{margin:"0 auto"},attrs:{src:t.imageUrl},on:{load:t.dialogImgLoad}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.code)+":")]),t._v(t._s(t.temp.code)),i("br"),t._v(" "),i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.name)+":")]),t._v(t._s(t.temp.name)+"\n\n          ")])],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center",padding:"15px 0 15px 0"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.download}},[t._v("下载")]),t._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:t.print}},[t._v("打印")])],1)])])},[],!1,null,"20580914",null);s.options.__file="dialogQrcode.vue";e.a=s.exports},zo9M:function(t,e,i){}}]);