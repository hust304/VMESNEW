(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-2521","chunk-336d","4Nw2","dnMx"],{"2+ib":function(t,e,i){"use strict";i("dRSK"),i("INYr"),i("91GP"),i("Vd3H"),i("rGqo"),i("f3/d"),i("xfY5");var a=i("4Q6Z"),n=i("z0WU"),o=i("DKCI"),s=i("50Ol"),l=i("F9dT"),r=(i("Yfch"),i("YP4+")),d=i("WwWg"),c=(i("evdt"),i("mwzG")),h={name:"multilevel-table",mixins:[a.a],provide:function(){return{rootVm:this}},props:{expand:[Boolean],expandMode:[String],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,showColList:"",headerWidthList:[],listLength:-1,restaurants:[],debounce:300,fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:o.a,customSummaryOption:s.a},computed:{setGlobalSingle:function(){return this.layerConfig.globalSingle||this.globalSingle||!1},setLayerSingle:function(){return this.layerConfig.layerSingle||this.layerSingle||!1},setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer,defaultSpacingClass:!this.layer,noSpacingClass:this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return!!this.layer&&(!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2))}},created:function(){var t=this;if(!this.layer)if(this.guid=Object(n.a)(),this.userInfo=this.$storage.get("userInfo"),Object(d.c)(this),this.initData.result){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var e=JSON.parse(JSON.stringify(c.a));t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:e,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.initLoading=!1},1e3):this.httpRequests());this.layer&&(this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.setDragTable&&this.setSort(),this.initLoading=!1,this.tableDoLayout()):(this.initLoading=!1,this.tableDoLayout()))},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){//!this.layer && unCreateStore(this.$store, this.guid)
},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay()},initData:function(){var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1},resetContentWidthList:function(){var t=this,e=this.resetContentWidthList.map(function(t){return null});this.resetContentWidthList.forEach(function(i,a){t.useMiddleValue=!1,e[a]=t.contentWidthAlgorithm(i.map(function(t){return Math.max.apply(null,t)})),t.useMiddleValueList[a]=t.useMiddleValue}),e.forEach(function(e,i){t.contentWidthList[i]=e?e+26:null}),console.log(e,this.contentWidthList,this.useMiddleValueList,this.contentTitleWidthList)}},methods:{contentWidthAlgorithm:function(t){if(t&&t.length){if(t.length>1){var e=Math.max.apply(null,t);if(e-Math.min.apply(null,t)>this.setWidthDiffValue){var i,a=[].concat(t);return a.sort(n.d),i=a.length%2==0?(a[a.length/2-1]+a[a.length/2])/2:a[(a.length+1)/2-1],this.useMiddleValue=!0,e-i>this.setWidthDiffValue&&(i=2*this.setWidthDiffValue),i}return e}return t[0]}return null},databridge:function(t,e){this.$emit("databridge",t,e)},expandChange:function(t,e){var i=this;"one"===this.setExpandMode&&e.forEach(function(i,a){t._internalId!==i._internalId&&e.splice(a,1)}),this.$refs.baseTable.$nextTick(function(t){console.log("doLayout1"),i.$refs.baseTable.doLayout(),i.$emit("table-dolayout")})},setRowExpansion:function(t,e){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(t,e)},httpRequests:function(t){var e=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:t||1},this.searchObj)).then(function(i){e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:i,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1,t&&(e.pageNo=t,e.scrollTable())}).catch(function(t){console.log(t),e.initLoading=!1})},httpChildrenRequests:function(t,e){var i=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:e||1},this.setParams(t,this.setApiObj),this.setDynaValue(t))).then(function(a){i.$store.commit(i.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:a,row:t,vm:i}),i.setDragTable&&i.setSort(),i.pageNo=i.tableData[i.dataName].pageData&&i.tableData[i.dataName].pageData.current||1,i.initLoading=!1,i.tableDoLayout(),console.log("initLoading---\x3e",i.initLoading),e&&i.scrollTable()}).catch(function(t){console.log(t),i.initLoading=!1})},selectItem:function(t,e){t.findIndex(function(t){return t._internalId===e._internalId})>-1?(this.tempCheckedList.push(e),this.$store.commit(this.setGuid+"/ADD_CHECKED",[e])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[e]),this.tempCheckedList=this.tempCheckedList.filter(function(t){return t._internalId!==e._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:t.length?"0":"1"}),t.length?(this.tableData[this.dataName].forEach(function(t){t.rowState="0"}),t[0].rowState="1"):this.tableData[this.dataName].forEach(function(t){t.rowState="1"}))},selectAllItem:function(t){if(this.setIsSingle){if(t.length)for(var e=t.length-1;e>=0;e--)t.splice(e,1)}else t.length?(this.tempCheckedList=t.map(function(t){return t}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(t){t!==this.pageNo&&this.httpRequests(t)},setDynaValue:function(t){if(this.setDynamicValue){var e={};for(var i in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(i)&&(e[i]=Object(l.c)([this.setDynamicValue[i]],t,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return console.log(e),e}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setCellStyle:function(t){return this.setExpand&&2===this.maxLayer&&"1"===this.setExpandColumnWidth?{"border-bottom":"none","background-color":"inherit"}:{"background-color":"inherit"}},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(t,e){var i=this;return e&&t?(this.resultTableData=(t.tableData||t.children).find(function(t){if(t._internalId===e)return!0;if(t.children&&t.children.length){var a={titleList:t.titleList,children:t.children,pageData:t.pageData||{}};i.resultTableData=i.searchTableData(a,e)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(t){this.$emit("callmethod",t)},tableDoLayout:function(){var t=this;this.$nextTick(function(e){console.log("doLayout2"),t.$refs.baseTable.doLayout(),t.$emit("table-dolayout")})}}},u=(i("q7oa"),i("KHd+")),m=Object(u.a)(h,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.setTableLoading,expression:"setTableLoading"}],staticClass:"myCoustomTable resetCoustomTableStyle",class:t.setTableClass},[t.setShowTableSet?i("table-filter",{attrs:{headerList:t.setColConfigs,storeId:t.pageId,componentId:t.setComponentId,showAll:t.setShowAll},on:{"checked-list":t.checkedList,"checked-height":t.checkedHeight}}):t._e(),t._v(" "),i("div",{style:{height:t.setTableHeight}},[i("el-form",{ref:"ruleForm",style:{height:t.layer?"auto":"100%"},attrs:{model:t.ruleForm,"status-icon":""},nativeOn:{submit:function(t){t.preventDefault()}}},[i("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:t.tableData[t.dataName],stripe:!t.setExpand||"50"===t.setExpandColumnWidth,"highlight-current-row":"",border:t.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:t.layer?null:"100%",fit:"","show-header":t.setShowHeader,"row-key":"_internalId","show-summary":t.setSysSummary,"default-expand-all":!t.setShowExpandBtn&&t.setExpand&&"all"===t.setExpandMode,"header-row-style":t.setHeaderRowStyle,"row-style":t.setRowStyle,"row-class-name":t.setRowClass,"cell-style":t.setCellStyle,"header-row-class-name":t.setHeaderRowClass,"default-sort":t.setSortableConfig["default-sort"]},on:{select:t.selectItem,"select-all":t.selectAllItem,"expand-change":t.expandChange,"sort-change":t.sortChange}},[t.setExpand?[i("el-table-column",{attrs:{type:"expand",width:t.setExpandColumnWidth,align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("multilevel-table",{attrs:{tableConfigList:t.tableConfigList,layer:t.layer+1,internalGuid:t.setGuid,parentData:[e.row],rowChain:t.setRowChain},on:{databridge:t.databridge,callmethod:t.callParentMethod,"table-dolayout":t.tableDoLayout}})]}}])})]:t._e(),t._v(" "),t.setShowCheckBox?[i("el-table-column",{attrs:{type:"selection",fixed:t.setFixedState,selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.setShowIndex?[i("el-table-column",{attrs:{type:"index",index:t.indexMethod,fixed:t.setFixedState,label:"序号",width:"50",align:"center"}})]:t._e(),t._v(" "),t._l(t.setTitleList,function(e,a){return[e.slot&&e._isShow?t._t(e.slot,null,{fixed:t.setFixedList[a]}):Array.isArray(e.component)&&e._isShow?[i("el-table-column",t._b({key:a,attrs:{"show-overflow-tooltip":"",fixed:t.setFixedList[a],width:t.setColumnWidth[e.prop]||null,align:"center"},scopedSlots:t._u([{key:"header",fn:function(n){return[i("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:a,isComponent:!0,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[t._v("\n                  "+t._s(e.label)+"\n                ")])]}},{key:"default",fn:function(a){return["button"===e.componentName?i("div",{directives:[{name:"button-width",rawName:"v-button-width",value:e,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":t.setColumnWidth[e.prop]?"space-between":"center"}},t._l(e.component,function(e,n){return void 0!==e.editBtns_isShow&&!e.editBtns_isShow||!e.rowState||t.setButtonState(a.$index,a.row,e)?i("el-button",{key:n,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(t){e.method(a.row,a.$index,a)}}},[t._v(t._s(e.name)+"\n                  ")]):t._e()}),1):t._e()]}}])},"el-table-column",e,!1))]:"object"==typeof e.component&&e._isShow?i(e.component,{key:a,tag:"component",attrs:{"col-config":e,fixed:t.setFixedList[a]}}):[e._isShow?i("el-table-column",{key:a,attrs:{"show-overflow-tooltip":"",label:e.label,prop:e.columnIndex||e.prop,width:e.width||t.constantWidth[e.componentName]||"auto","min-width":e["min-width"]||t.contentWidthList[a]||"none",sortable:!!t.setSortableConfig[e.columnIndex||e.prop],"sort-method":t.setSortableConfig[e.columnIndex||e.prop]&&t.setSortableConfig[e.columnIndex||e.prop]["sort-method"]?t.setSortableConfig[e.columnIndex||e.prop]["sort-method"]:null,"sort-by":t.setSortableConfig[e.columnIndex||e.prop]&&t.setSortableConfig[e.columnIndex||e.prop]["sort-by"]?t.setSortableConfig[e.columnIndex||e.prop]["sort-by"]:null,fixed:t.setFixedList[a],align:"center"},scopedSlots:t._u([{key:"header",fn:function(n){return[i("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:a,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"}],style:{display:e._isShow?"inline-flex":"none"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(n){return[e.mergeTitles&&e.mergeTitles.length?[t._l(e.mergeTitles,function(o,s){return[o.componentName?["input"===o.componentName?[o._cellConfig.asyn?[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-autocomplete",{attrs:{_scope:n,"child-colconfig":o,debounce:t.debounce}})],1)]:[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-input",{attrs:{_scope:n,"child-colconfig":o}})],1)]]:"date"===o.componentName?[i("table-date-picker",{attrs:{_scope:n,"child-colconfig":o}})]:"time"===o.componentName?[i("table-time-picker",{attrs:{_scope:n,"child-colconfig":o}})]:"select"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-select",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"cascader"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-cascader",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"switch"===o.componentName?[i("div",[o._cellConfig.hideTitle?t._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[t._v("\n                            "+t._s(o.label+":")+" \n                          ")]),t._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-switch",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"dateTime"===o.componentName?[i("table-date-time",{attrs:{_scope:n,"child-colconfig":o}})]:"inputNumber"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:t.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-input-number",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"steps"===o.componentName?[i("div",{key:s,staticClass:"resetElStepStyle"},[o._cellConfig.hideTitle?t._e():i("div",{style:o._cellConfig.titleStyle||{}},[t._v("\n                            "+t._s(o.label+":")+" \n                          ")]),t._v(" "),i("div",[i("table-steps",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"progress"===o.componentName?[i("div",{key:s,staticStyle:{"text-align":"left"}},[o._cellConfig.hideTitle?t._e():i("div",{staticStyle:{display:"inline-block"},style:[{"line-height":o._cellConfig.componentConfig["stroke-width"]>23?2:""},o._cellConfig.titleStyle||(t.setColumnGlobalStyle?t.setColumnGlobalStyle.titleStyle:{})||{}]},[t._v("\n                            "+t._s(o.label+":"+(o._cellConfig.componentConfig.showInitValue?n.row[o.prop]:""))+" \n                          ")]),t._v(" "),i("div",{staticClass:"resetProgressStyle",staticStyle:{display:"inline-block",overflow:"hidden","vertical-align":"middle"},style:{width:(o._cellConfig.componentConfig.width||t.constantWidth[o.componentName])+"px"}},[i("table-progress",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"upload"===o.componentName?[i("table-upload",{attrs:{_scope:n,"child-colconfig":o}})]:"tag"===o.componentName?[i("table-tag",{attrs:{_scope:n,"child-colconfig":o}})]:"button"===o.componentName?[o._cellConfig.hideTitle?t._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[t._v("\n                          "+t._s(o.label+":")+" \n                        ")]),t._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-button",{attrs:{_scope:n,"child-colconfig":o}})],1)]:[i("span",{key:s,staticStyle:{"margin-left":"10px"},domProps:{textContent:t._s(n.row[o.prop])}})]]:[i("div",{key:s,style:{"text-align":o._cellConfig&&o._cellConfig.hideTitle?"center":"left"}},[o._cellConfig?[o._cellConfig.hideTitle?t._e():[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:e,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:[o._cellConfig.titleStyle||(t.setColumnGlobalStyle?t.setColumnGlobalStyle.titleStyle:{}),t.setMiddleValue[a]?t.setMiddleValue[a].title:{}],domProps:{textContent:t._s(o.label+":")}},[t._v(" ")])]]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:e,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:t.setMiddleValue[a]?t.setMiddleValue[a].title:{},domProps:{textContent:t._s(o.label+":")}},[t._v(" ")])],t._v(" "),o._cellConfig&&o._cellConfig.events?[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:e,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"}],style:[o._cellConfig.bodyStyle||(t.setColumnGlobalStyle?t.setColumnGlobalStyle.bodyStyle:{}),t.setMiddleValue[a]?t.setMiddleValue[a].body:{}]},[i("a",{domProps:{textContent:t._s(n.row[o.prop])},on:{click:function(e){t.mergeColumnEvents(o,n)}}})])]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:e,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"},{name:"content-set",rawName:"v-content-set",value:{config:o,row:n.row},expression:"{config: childColconfig,row: scope.row}"}],class:{resetContent:t.setMiddleValue[a],ellipsis:!!t.setMiddleValue[a]&&t.isEllipsis(n.row[o.columnIndex||o.prop],parseInt(t.setMiddleValue[a].body.width))},style:[o._cellConfig?o._cellConfig.bodyStyle:{},t.setColumnGlobalStyle?t.setColumnGlobalStyle.bodyStyle:{},t.setMiddleValue[a]?t.setMiddleValue[a].body:{}],domProps:{textContent:t._s(n.row[o.columnIndex||o.prop])}})]],2)]]})]:[i("div",{style:{display:e._isShow?"inline-block":"none"},domProps:{textContent:t._s(n.row[e.prop])}})]]}}])}):t._e()]]}),t._v(" "),t.setDragTable?[i("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:t._u([{key:"default",fn:function(t){return[i("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[i("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)]}}])})]:t._e()],2)],1),t._v(" "),t.setUseSummary&&t.setCustomSummary.component?[i("custom-summary-option",{attrs:{customSummary:t.setCustomSummary,tempData:t.setTempData,tableData:t.tableData[t.dataName]},on:{"send-height":t.customSummaryHeight,"custom-summary-value":t.customSummaryValue}})]:t._e()],2),t._v(" "),t.setHidePages?t._e():i("div",{staticStyle:{"text-align":"center"},style:{"padding-top":(t.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[i("el-pagination",{attrs:{background:"","current-page":t.tableData.pageData.current,"page-size":t.tableData.pageData.size,layout:"prev, pager, next, jumper",total:t.tableData.pageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.tableData.pageData,"current",e)}}})],1)],1)},[],!1,null,null,null);m.options.__file="index.vue";e.a=m.exports},"4Nw2":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("/a8v");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{initialPeriodDate:null,paymentPeriodDate:null,rules:{initialPeriodDate:[{required:!0,message:"请填写初始付款期间",trigger:"change"}]},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,formTemp:[]}},created:function(){this.initData.rowData&&(this.formData=this.initData.rowData)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},changeInitialPeriodDate:function(t){null!=t&&(this.initialPeriodDate=new Date(t),this.formData.initialPeriodDate=t)},changePaymentPeriodDate:function(t){this.paymentPeriodDate=new Date(t),this.formData.paymentPeriodDate=t},isErrorByPeriodDate:function(){var t=this.initialPeriodDate.getTime();if(null!=this.paymentPeriodDate&&this.paymentPeriodDate.getTime()-t<0)return this.$message({message:"当前付款期间不可小于初始付款期间！",type:"warning",duration:5e3}),!0;return!1},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&!t.isErrorByPeriodDate()&&Object(a.addCompanyPeriod)(t.formData).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"保存成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})},closeDialog:function(t){}}},s=i("KHd+"),l=Object(s.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-form-item",{attrs:{label:"企业编码:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.companyCode,callback:function(e){t.$set(t.formData,"companyCode",e)},expression:"formData.companyCode"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"企业名称:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.companyName,callback:function(e){t.$set(t.formData,"companyName",e)},expression:"formData.companyName"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"初始付款期间:",prop:"initialPeriodDate"}},[i("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"month","value-format":"yyyy-MM-dd",placeholder:"选择月"},on:{change:t.changeInitialPeriodDate},model:{value:t.formData.initialPeriodDate,callback:function(e){t.$set(t.formData,"initialPeriodDate",e)},expression:"formData.initialPeriodDate"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"当前付款期间:",prop:"paymentPeriodDate"}},[i("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"month","value-format":"yyyy-MM-dd",placeholder:"选择月"},on:{change:t.changePaymentPeriodDate},model:{value:t.formData.paymentPeriodDate,callback:function(e){t.$set(t.formData,"paymentPeriodDate",e)},expression:"formData.paymentPeriodDate"}})],1)],1)],1),t._v(" "),i("div",{staticStyle:{"padding-left":"6%"}},[t._v("\n      备注："),i("br"),t._v("\n      1) 初始付款期间：当前企业首次采购付款结转初始期间"),i("br"),t._v("\n      2) 当前付款期间：供应商在当前付款期间内发生的所有"),i("br"),t._v("\n              \n              \n              \n      (采购金额，付款金额)"),i("br"),t._v("\n      3) 当前付款期间：为空不填保存后默认等于初始付款期间"),i("br"),t._v("\n      例如：201903 表示2019年03月份"),i("br"),i("br")]),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogAdd.vue";e.default=l.exports},"AP/f":function(t,e,i){},D2yE:function(t,e,i){},DNa0:function(t,e,i){"use strict";var a=i("AP/f");i.n(a).a},dnMx:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("/a8v");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{initialPeriodDate:null,paymentPeriodDate:null,rules:{initialPeriodDate:[{required:!0,message:"请填写初始付款期间",trigger:"change"}]},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,formTemp:[]}},created:function(){this.initData.rowData&&(this.formData=this.initData.rowData,this.initialPeriodDate=new Date(this.initData.rowData.initialPeriodDate),null!=this.initData.rowData.paymentPeriodDate&&(this.paymentPeriodDate=new Date(this.initData.rowData.paymentPeriodDate)))},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},changeInitialPeriodDate:function(t){null!=t&&(this.initialPeriodDate=new Date(t),this.formData.initialPeriodDate=t)},changePaymentPeriodDate:function(t){this.paymentPeriodDate=new Date(t),this.formData.paymentPeriodDate=t},isErrorByPeriodDate:function(){var t=this.initialPeriodDate.getTime();if(null!=this.paymentPeriodDate&&this.paymentPeriodDate.getTime()-t<0)return this.$message({message:"当前付款期间不可小于初始付款期间！",type:"warning",duration:5e3}),!0;return!1},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&!t.isErrorByPeriodDate()&&Object(a.updateCompanyPeriod)(t.formData).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"保存成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})},closeDialog:function(t){}}},s=i("KHd+"),l=Object(s.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-form-item",{attrs:{label:"企业编码:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.companyCode,callback:function(e){t.$set(t.formData,"companyCode",e)},expression:"formData.companyCode"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"企业名称:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.companyName,callback:function(e){t.$set(t.formData,"companyName",e)},expression:"formData.companyName"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"初始付款期间:",prop:"initialPeriodDate"}},[i("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"month","value-format":"yyyy-MM-dd",placeholder:"选择月"},on:{change:t.changeInitialPeriodDate},model:{value:t.formData.initialPeriodDate,callback:function(e){t.$set(t.formData,"initialPeriodDate",e)},expression:"formData.initialPeriodDate"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"当前付款期间:",prop:"paymentPeriodDate"}},[i("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"month","value-format":"yyyy-MM-dd",placeholder:"选择月",readonly:!0},on:{change:t.changePaymentPeriodDate},model:{value:t.formData.paymentPeriodDate,callback:function(e){t.$set(t.formData,"paymentPeriodDate",e)},expression:"formData.paymentPeriodDate"}})],1)],1)],1),t._v(" "),i("div",{staticStyle:{"padding-left":"6%"}},[t._v("\n    备注："),i("br"),t._v("\n    1) 初始付款期间：当前企业首次采购付款结转初始期间"),i("br"),t._v("\n    2) 当前付款期间：供应商在当前付款期间内发生的所有"),i("br"),t._v("\n            \n            \n            \n    (采购金额，付款金额)"),i("br"),t._v("\n    3) 当前付款期间：为空不填保存后默认等于初始付款期间"),i("br"),t._v("\n    例如：201903 表示2019年03月份"),i("br"),i("br")]),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogEdit.vue";e.default=l.exports},fY7h:function(t,e,i){"use strict";i.r(e);i("rGqo");var a=i("uTIz"),n=i("2+ib"),o=i("4Nw2"),s=i("dnMx"),l=i("Vobf"),r=(i("hZMg"),i("/a8v"),{components:{multilevelTable:n.a,searchBar:a.a,dialogAdd:o.default,dialogEdit:s.default},data:function(){return{searchList:[],guid:"",searchObj:{},tableConfigList:[{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"设定",nameEn:"addCompanyPeriod",editBtns_isShow:!0,icon:"addCompanyPeriod",method:this.addCompanyPeriod},{name:"修改",nameEn:"updateCompanyPeriod",editBtns_isShow:!0,icon:"updateCompanyPeriod",method:this.updateCompanyPeriod}]}],apiObj:{apiName:"listPagePurchaseCompanyPeriod",params:{fieldCode:"companyCode,companyName,initialPeriod,paymentPeriod,isBuildName,cdateStr"}},tempData:{},showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],selectList:[],temp:{},tempLable:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",rowData:{},title:""}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"云上企业"}),Object(l.initMenuButtons)({menuId:i,roleId:e}).then(function(e){t.$loading().close();var i=e.buttonList;i&&i.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)})),t.tableConfigList&&t.tableConfigList.forEach(function(t){t.customColumn&&t.customColumn.forEach(function(t){"last"==t.columnIndex&&t.component&&t.component.forEach(function(t){t.nameEn==e.nameEn&&(t.rowState="1==2")})})})})}).catch(function(e){console.log(e),t.$loading().close()}))},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(t)},databridge:function(t){this.selectList=t},updateData:function(t){this.$refs.customBaseTable.updateData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},addCompanyPeriod:function(t,e){var i=t.id;null!=i&&i.trim().length>0?this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前企业已经设定，请点击(修改)！"}):(this.dialogData.rowData={companyId:t.companyId,companyCode:t.companyCode,companyName:t.companyName,initialPeriodDate:"",paymentPeriodDate:""},this.dialogData.title="创建企业首次付款期间",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0)},updateCompanyPeriod:function(t,e){var i=t.id;null!=i&&0!=i.trim().length?(this.dialogData.rowData={id:t.id,companyId:t.companyId,companyCode:t.companyCode,companyName:t.companyName,initialPeriodDate:t.initialPeriodDate,paymentPeriodDate:t.paymentPeriodDate},this.dialogData.title="修改企业首次付款期间",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0):this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前企业还没有设定不可修改！"})},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0)+"px":"100%"},dialogName:function(){return this.openDialogName}},watch:{}}),d=(i("DNa0"),i("KHd+")),c=Object(d.a)(r,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"companyPeriod"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{"border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight,"margin-top":t.searchList.length?"10px":"0"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);c.options.__file="index.vue";e.default=c.exports},q7oa:function(t,e,i){"use strict";var a=i("D2yE");i.n(a).a}}]);