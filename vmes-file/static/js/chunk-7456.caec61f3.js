(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7456","chunk-336d","chunk-4eb7"],{"2+ib":function(e,t,i){"use strict";i("dRSK"),i("INYr"),i("91GP"),i("Vd3H"),i("rGqo"),i("f3/d"),i("xfY5");var a=i("4Q6Z"),n=i("z0WU"),o=i("DKCI"),s=i("50Ol"),l=i("F9dT"),r=(i("Yfch"),i("YP4+")),d=i("WwWg"),c=(i("evdt"),i("mwzG")),u={name:"multilevel-table",mixins:[a.a],provide:function(){return{rootVm:this}},props:{expand:[Boolean],expandMode:[String],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,showColList:"",headerWidthList:[],listLength:-1,restaurants:[],debounce:300,fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:o.a,customSummaryOption:s.a},computed:{setGlobalSingle:function(){return this.layerConfig.globalSingle||this.globalSingle||!1},setLayerSingle:function(){return this.layerConfig.layerSingle||this.layerSingle||!1},setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer,defaultSpacingClass:!this.layer,noSpacingClass:this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return!!this.layer&&(!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2))}},created:function(){var e=this;if(!this.layer)if(this.guid=Object(n.a)(),this.userInfo=this.$storage.get("userInfo"),Object(d.c)(this),this.initData.result){var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var t=JSON.parse(JSON.stringify(c.a));e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:t,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1},1e3):this.httpRequests());this.layer&&(this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.setDragTable&&this.setSort(),this.initLoading=!1,this.tableDoLayout()):(this.initLoading=!1,this.tableDoLayout()))},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){//!this.layer && unCreateStore(this.$store, this.guid)
},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay()},initData:function(){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1},resetContentWidthList:function(){var e=this,t=this.resetContentWidthList.map(function(e){return null});this.resetContentWidthList.forEach(function(i,a){e.useMiddleValue=!1,t[a]=e.contentWidthAlgorithm(i.map(function(e){return Math.max.apply(null,e)})),e.useMiddleValueList[a]=e.useMiddleValue}),t.forEach(function(t,i){e.contentWidthList[i]=t?t+26:null}),console.log(t,this.contentWidthList,this.useMiddleValueList,this.contentTitleWidthList)}},methods:{contentWidthAlgorithm:function(e){if(e&&e.length){if(e.length>1){var t=Math.max.apply(null,e);if(t-Math.min.apply(null,e)>this.setWidthDiffValue){var i,a=[].concat(e);return a.sort(n.d),i=a.length%2==0?(a[a.length/2-1]+a[a.length/2])/2:a[(a.length+1)/2-1],this.useMiddleValue=!0,t-i>this.setWidthDiffValue&&(i=2*this.setWidthDiffValue),i}return t}return e[0]}return null},databridge:function(e,t){this.$emit("databridge",e,t)},expandChange:function(e,t){var i=this;"one"===this.setExpandMode&&t.forEach(function(i,a){e._internalId!==i._internalId&&t.splice(a,1)}),this.$refs.baseTable.$nextTick(function(e){console.log("doLayout1"),i.$refs.baseTable.doLayout(),i.$emit("table-dolayout")})},setRowExpansion:function(e,t){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(e,t)},httpRequests:function(e){var t=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:e||1},this.searchObj)).then(function(i){t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:i,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.initLoading=!1,e&&(t.pageNo=e,t.scrollTable())}).catch(function(e){console.log(e),t.initLoading=!1})},httpChildrenRequests:function(e,t){var i=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:t||1},this.setParams(e,this.setApiObj),this.setDynaValue(e))).then(function(a){i.$store.commit(i.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:a,row:e,vm:i}),i.setDragTable&&i.setSort(),i.pageNo=i.tableData[i.dataName].pageData&&i.tableData[i.dataName].pageData.current||1,i.initLoading=!1,i.tableDoLayout(),console.log("initLoading---\x3e",i.initLoading),t&&i.scrollTable()}).catch(function(e){console.log(e),i.initLoading=!1})},selectItem:function(e,t){e.findIndex(function(e){return e._internalId===t._internalId})>-1?(this.tempCheckedList.push(t),this.$store.commit(this.setGuid+"/ADD_CHECKED",[t])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[t]),this.tempCheckedList=this.tempCheckedList.filter(function(e){return e._internalId!==t._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:e.length?"0":"1"}),e.length?(this.tableData[this.dataName].forEach(function(e){e.rowState="0"}),e[0].rowState="1"):this.tableData[this.dataName].forEach(function(e){e.rowState="1"}))},selectAllItem:function(e){if(this.setIsSingle){if(e.length)for(var t=e.length-1;t>=0;t--)e.splice(t,1)}else e.length?(this.tempCheckedList=e.map(function(e){return e}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(e){e!==this.pageNo&&this.httpRequests(e)},setDynaValue:function(e){if(this.setDynamicValue){var t={};for(var i in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(i)&&(t[i]=Object(l.c)([this.setDynamicValue[i]],e,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return console.log(t),t}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setCellStyle:function(e){return this.setExpand&&2===this.maxLayer&&"1"===this.setExpandColumnWidth?{"border-bottom":"none","background-color":"inherit"}:{"background-color":"inherit"}},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(e,t){var i=this;return t&&e?(this.resultTableData=(e.tableData||e.children).find(function(e){if(e._internalId===t)return!0;if(e.children&&e.children.length){var a={titleList:e.titleList,children:e.children,pageData:e.pageData||{}};i.resultTableData=i.searchTableData(a,t)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(e){this.$emit("callmethod",e)},tableDoLayout:function(){var e=this;this.$nextTick(function(t){console.log("doLayout2"),e.$refs.baseTable.doLayout(),e.$emit("table-dolayout")})}}},h=(i("q7oa"),i("KHd+")),p=Object(h.a)(u,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.setTableLoading,expression:"setTableLoading"}],staticClass:"myCoustomTable resetCoustomTableStyle",class:e.setTableClass},[e.setShowTableSet?i("table-filter",{attrs:{headerList:e.setColConfigs,storeId:e.pageId,componentId:e.setComponentId,showAll:e.setShowAll},on:{"checked-list":e.checkedList,"checked-height":e.checkedHeight}}):e._e(),e._v(" "),i("div",{style:{height:e.setTableHeight}},[i("el-form",{ref:"ruleForm",style:{height:e.layer?"auto":"100%"},attrs:{model:e.ruleForm,"status-icon":""},nativeOn:{submit:function(e){e.preventDefault()}}},[i("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:e.tableData[e.dataName],stripe:!e.setExpand||"50"===e.setExpandColumnWidth,"highlight-current-row":"",border:e.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:e.layer?null:"100%",fit:"","show-header":e.setShowHeader,"row-key":"_internalId","show-summary":e.setSysSummary,"default-expand-all":!e.setShowExpandBtn&&e.setExpand&&"all"===e.setExpandMode,"header-row-style":e.setHeaderRowStyle,"row-style":e.setRowStyle,"row-class-name":e.setRowClass,"cell-style":e.setCellStyle,"header-row-class-name":e.setHeaderRowClass,"default-sort":e.setSortableConfig["default-sort"]},on:{select:e.selectItem,"select-all":e.selectAllItem,"expand-change":e.expandChange,"sort-change":e.sortChange}},[e.setExpand?[i("el-table-column",{attrs:{type:"expand",width:e.setExpandColumnWidth,align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("multilevel-table",{attrs:{tableConfigList:e.tableConfigList,layer:e.layer+1,internalGuid:e.setGuid,parentData:[t.row],rowChain:e.setRowChain},on:{databridge:e.databridge,callmethod:e.callParentMethod,"table-dolayout":e.tableDoLayout}})]}}])})]:e._e(),e._v(" "),e.setShowCheckBox?[i("el-table-column",{attrs:{type:"selection",fixed:e.setFixedState,selectable:e.selectable,width:"55",align:"center"}})]:e._e(),e._v(" "),e.setShowIndex?[i("el-table-column",{attrs:{type:"index",index:e.indexMethod,fixed:e.setFixedState,label:"序号",width:"50",align:"center"}})]:e._e(),e._v(" "),e._l(e.setTitleList,function(t,a){return[t.slot&&t._isShow?e._t(t.slot,null,{fixed:e.setFixedList[a]}):Array.isArray(t.component)&&t._isShow?[i("el-table-column",e._b({key:a,attrs:{"show-overflow-tooltip":"",fixed:e.setFixedList[a],width:e.setColumnWidth[t.prop]||null,align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[i("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:a,isComponent:!0,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[e._v("\n                  "+e._s(t.label)+"\n                ")])]}},{key:"default",fn:function(a){return["button"===t.componentName?i("div",{directives:[{name:"button-width",rawName:"v-button-width",value:t,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":e.setColumnWidth[t.prop]?"space-between":"center"}},e._l(t.component,function(t,n){return void 0!==t.editBtns_isShow&&!t.editBtns_isShow||!t.rowState||e.setButtonState(a.$index,a.row,t)?i("el-button",{key:n,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(e){t.method(a.row,a.$index,a)}}},[e._v(e._s(t.name)+"\n                  ")]):e._e()}),1):e._e()]}}])},"el-table-column",t,!1))]:"object"==typeof t.component&&t._isShow?i(t.component,{key:a,tag:"component",attrs:{"col-config":t,fixed:e.setFixedList[a]}}):[t._isShow?i("el-table-column",{key:a,attrs:{"show-overflow-tooltip":"",label:t.label,prop:t.columnIndex||t.prop,width:t.width||e.constantWidth[t.componentName]||"auto","min-width":t["min-width"]||e.contentWidthList[a]||"none",sortable:!!e.setSortableConfig[t.columnIndex||t.prop],"sort-method":e.setSortableConfig[t.columnIndex||t.prop]&&e.setSortableConfig[t.columnIndex||t.prop]["sort-method"]?e.setSortableConfig[t.columnIndex||t.prop]["sort-method"]:null,"sort-by":e.setSortableConfig[t.columnIndex||t.prop]&&e.setSortableConfig[t.columnIndex||t.prop]["sort-by"]?e.setSortableConfig[t.columnIndex||t.prop]["sort-by"]:null,fixed:e.setFixedList[a],align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[i("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:a,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"}],style:{display:t._isShow?"inline-flex":"none"},domProps:{textContent:e._s(t.label)}})]}},{key:"default",fn:function(n){return[t.mergeTitles&&t.mergeTitles.length?[e._l(t.mergeTitles,function(o,s){return[o.componentName?["input"===o.componentName?[o._cellConfig.asyn?[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-autocomplete",{attrs:{_scope:n,"child-colconfig":o,debounce:e.debounce}})],1)]:[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-input",{attrs:{_scope:n,"child-colconfig":o}})],1)]]:"date"===o.componentName?[i("table-date-picker",{attrs:{_scope:n,"child-colconfig":o}})]:"time"===o.componentName?[i("table-time-picker",{attrs:{_scope:n,"child-colconfig":o}})]:"select"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-select",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"cascader"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-cascader",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"switch"===o.componentName?[i("div",[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[e._v("\n                            "+e._s(o.label+":")+" \n                          ")]),e._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-switch",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"dateTime"===o.componentName?[i("table-date-time",{attrs:{_scope:n,"child-colconfig":o}})]:"inputNumber"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-input-number",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"steps"===o.componentName?[i("div",{key:s,staticClass:"resetElStepStyle"},[o._cellConfig.hideTitle?e._e():i("div",{style:o._cellConfig.titleStyle||{}},[e._v("\n                            "+e._s(o.label+":")+" \n                          ")]),e._v(" "),i("div",[i("table-steps",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"progress"===o.componentName?[i("div",{key:s,staticStyle:{"text-align":"left"}},[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:[{"line-height":o._cellConfig.componentConfig["stroke-width"]>23?2:""},o._cellConfig.titleStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.titleStyle:{})||{}]},[e._v("\n                            "+e._s(o.label+":"+(o._cellConfig.componentConfig.showInitValue?n.row[o.prop]:""))+" \n                          ")]),e._v(" "),i("div",{staticClass:"resetProgressStyle",staticStyle:{display:"inline-block",overflow:"hidden","vertical-align":"middle"},style:{width:(o._cellConfig.componentConfig.width||e.constantWidth[o.componentName])+"px"}},[i("table-progress",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"upload"===o.componentName?[i("table-upload",{attrs:{_scope:n,"child-colconfig":o}})]:"tag"===o.componentName?[i("table-tag",{attrs:{_scope:n,"child-colconfig":o}})]:"button"===o.componentName?[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[e._v("\n                          "+e._s(o.label+":")+" \n                        ")]),e._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-button",{attrs:{_scope:n,"child-colconfig":o}})],1)]:[i("span",{key:s,staticStyle:{"margin-left":"10px"},domProps:{textContent:e._s(n.row[o.prop])}})]]:[i("div",{key:s,style:{"text-align":o._cellConfig&&o._cellConfig.hideTitle?"center":"left"}},[o._cellConfig?[o._cellConfig.hideTitle?e._e():[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:[o._cellConfig.titleStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.titleStyle:{}),e.setMiddleValue[a]?e.setMiddleValue[a].title:{}],domProps:{textContent:e._s(o.label+":")}},[e._v(" ")])]]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:e.setMiddleValue[a]?e.setMiddleValue[a].title:{},domProps:{textContent:e._s(o.label+":")}},[e._v(" ")])],e._v(" "),o._cellConfig&&o._cellConfig.events?[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"}],style:[o._cellConfig.bodyStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.bodyStyle:{}),e.setMiddleValue[a]?e.setMiddleValue[a].body:{}]},[i("a",{domProps:{textContent:e._s(n.row[o.prop])},on:{click:function(t){e.mergeColumnEvents(o,n)}}})])]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"},{name:"content-set",rawName:"v-content-set",value:{config:o,row:n.row},expression:"{config: childColconfig,row: scope.row}"}],class:{resetContent:e.setMiddleValue[a],ellipsis:!!e.setMiddleValue[a]&&e.isEllipsis(n.row[o.columnIndex||o.prop],parseInt(e.setMiddleValue[a].body.width))},style:[o._cellConfig?o._cellConfig.bodyStyle:{},e.setColumnGlobalStyle?e.setColumnGlobalStyle.bodyStyle:{},e.setMiddleValue[a]?e.setMiddleValue[a].body:{}],domProps:{textContent:e._s(n.row[o.columnIndex||o.prop])}})]],2)]]})]:[i("div",{style:{display:t._isShow?"inline-block":"none"},domProps:{textContent:e._s(n.row[t.prop])}})]]}}])}):e._e()]]}),e._v(" "),e.setDragTable?[i("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:e._u([{key:"default",fn:function(e){return[i("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[i("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)]}}])})]:e._e()],2)],1),e._v(" "),e.setUseSummary&&e.setCustomSummary.component?[i("custom-summary-option",{attrs:{customSummary:e.setCustomSummary,tempData:e.setTempData,tableData:e.tableData[e.dataName]},on:{"send-height":e.customSummaryHeight,"custom-summary-value":e.customSummaryValue}})]:e._e()],2),e._v(" "),e.setHidePages?e._e():i("div",{staticStyle:{"text-align":"center"},style:{"padding-top":(e.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[i("el-pagination",{attrs:{background:"","current-page":e.tableData.pageData.current,"page-size":e.tableData.pageData.size,layout:"prev, pager, next, jumper",total:e.tableData.pageData.total-0},on:{"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.tableData.pageData,"current",t)}}})],1)],1)},[],!1,null,null,null);p.options.__file="index.vue";t.a=p.exports},"9URt":function(e,t,i){"use strict";i.r(t);i("f3/d"),i("rGqo");var a=i("2+ib"),n=i("uTIz"),o=i("BESt"),s=i("z0WU"),l={components:{dialogReport:o.default,multilevelTable:a.a,searchBar:n.a},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{expectCount:[{required:!0,message:"请输入期望生产数量"},{type:"number",message:"请输入数字"}]},tableConfigList:[{apiObj:{apiName:"getBomTreeProduct",params:{bomId:this.initData.temp.id,productId:this.initData.temp.prodId}},showIndex:!0,showCheckBox:!1,expand:!0,expandMode:"one",rowStyle:{"background-color":"#E4F3FA"}},{showIndex:!0,showCheckBox:!1,expand:!0,expandMode:"none",headerStyle:{"background-color":"#E4F3FA"}},{showIndex:!0,showCheckBox:!1,expand:!0,expandMode:"none",headerStyle:{"background-color":"#E4F3FA"}},{showIndex:!0,showCheckBox:!1,expand:!0,expandMode:"none",headerStyle:{"background-color":"#E4F3FA"}},{showIndex:!0,showCheckBox:!1,expand:!0,expandMode:"none",headerStyle:{"background-color":"#E4F3FA"}}],openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{},tempLable:{},selectList:[],varList:[]}},created:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},databridge:function(e){this.selectList=e},refreshTable:function(){this.updateData({expectCount:this.temp.expectCount})},createReport:function(){var e=this;this.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,setTimeout(function(){e.dialogLoading=!1,e.getData(),e.varList=[],e.createVarList(e.varList,e.selectList),e.selectList[0]&&e.selectList[0].expectCount<=0&&e.temp.expectCount>0?e.$message({type:"warning",duration:5e3,showClose:!0,message:"查询错误，请重新尝试！"}):e.varList.length<=0?e.$message({type:"warning",duration:5e3,showClose:!0,message:"物料充足，无需采购！"}):(e.dialogData.data=JSON.stringify(e.unique(e.varList,"id")),e.dialogData.title="选择货品",e.openDialogName="dialogReport",e.showDialog=!0,e.inLinVisible=!0)},2e3))})},unique:function(e,t){for(var i={},a=[],n=0;n<e.length;n++)i[e[n][t]]?(Object(s.q)(a,i[e[n][t]]),e[n].expectCount=e[n].expectCount+i[e[n][t]].expectCount,e[n].lackCount=e[n].expectCount-e[n].stockCount,a.push(e[n])):(i[e[n][t]]=e[n],a.push(e[n]));return a},createVarList:function(e,t){var i=this;t.forEach(function(t){var a=t.id,n=t.code,o=t.name,s=t.spec,l=t.unit,r=t.stockCount,d=t.children,c=t.expectCount,u=t.lackCount,h=t.layer,p={id:a,code:n,name:o,spec:s,unit:l,stockCount:r,expectCount:c,lackCount:u};u>0&&h>0&&0==d.length&&e.push(p),d.length>0&&i.createVarList(e,d)})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e,t){this.addedData={rowData:e[0],parentData:t},this.showDialog=!1}},watch:{}},r=(i("xgHm"),i("KHd+")),d=Object(r.a)(l,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1500px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("el-row",{staticStyle:{width:"96%","margin-left":"2%"}},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);d.options.__file="dialogAnalysis.vue";t.default=d.exports},BESt:function(e,t,i){"use strict";i.r(t);var a=i("2+ib"),n=i("cTe8"),o=(i("z0WU"),{components:{multilevelTable:a.a},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{remark:"齐套分析预采",makeId:""},tempLable:{},tempQuery:{},rowData:{},selectList:[],configs:{topBarBtnList:[]},tempData:{defaultDate:new Date},tableConfigList:[{customColumn:[{columnIndex:"lackCount",width:120,componentName:"input",_cellConfig:{rules:[]}},{columnIndex:"edate",width:180,componentName:"date",_cellConfig:{valueType:"date",format:"yyyy-MM-dd",valueFormat:"yyyy-MM-dd",greaterThan:["self@cdate",!0]}},{columnIndex:"remark",width:120,componentName:"input",_cellConfig:{rules:[]}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",nameEn:"deleteData",editBtns_isShow:!0,icon:"deleteData",method:this.deleteData}]}],apiObj:{apiName:"getLackProduct",params:{fieldCode:"code,name,spec,unit,lackCount,edate,remark",dtlJsonStr:this.initData.temp}},showIndex:!0,showCheckBox:!1,expand:!1,expandMode:"none",rowStyle:{"background-color":"#E4F3FA"}}]}},created:function(){var e=this.$storage.get("userInfo");this.temp.makeId=e.userId},mounted:function(){this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},databridge:function(e){Array.isArray(e)?(this.selectList=[],this.selectList=e):(this.rowData=null,null!=e.row&&(this.rowData=e.row))},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},saveOrder:function(){var e=this,t="",i="";if(this.getData(),null!=this.selectList&&0!=this.selectList.length){for(var a=[],o=0;o<this.selectList.length;o++){var s=this.selectList[o],l={productId:"",count:"",reason:"",edate:"",remark:"",id:""};l.productId=s.id,l.count=s.lackCount,l.remark=s.remark,l.edate=s.edate,l.reason="350135d34d1b43aeb4e2977061632045",l.id=s.id,i=i?i+",'"+s.id+"'":"'"+s.id+"'",a.push(l)}t=JSON.stringify(a),this.temp.prodIds=i,this.temp.dtlJsonStr=t,this.$refs.submitForm.validate(function(t){t&&Object(n.checkPurchasePlan)(e.temp).then(function(t){0===t.code&&(t.msg?e.$confirm(t.msg,"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){e.addPurchasePlan(e.temp)}):e.addPurchasePlan(e.temp))}).catch(function(e){console.log(e)})})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})},addPurchasePlan:function(e){var t=this;this.dialogLoading=!0,Object(n.addPurchasePlan)(e).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1,console.log(e)})},closeDialog:function(e){this.showDialog=!1;null!=e.isConfirm&&e.isConfirm;null!=e.selectList&&e.selectList}},watch:{}}),s=(i("WqLC"),i("KHd+")),l=Object(s.a)(o,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1024px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("el-row",{staticStyle:{width:"96%","margin-left":"2%"}},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveOrder}},[e._v("生成采购计划")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogReport.vue";t.default=l.exports},D2yE:function(e,t,i){},WqLC:function(e,t,i){"use strict";var a=i("mBQz");i.n(a).a},jGQn:function(e,t,i){},mBQz:function(e,t,i){},q7oa:function(e,t,i){"use strict";var a=i("D2yE");i.n(a).a},xgHm:function(e,t,i){"use strict";var a=i("jGQn");i.n(a).a}}]);