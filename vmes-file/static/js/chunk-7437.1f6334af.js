(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7437","chunk-336d","chunk-0e8b"],{"2+ib":function(e,t,i){"use strict";i("dRSK"),i("INYr"),i("91GP"),i("Vd3H"),i("rGqo"),i("f3/d"),i("xfY5");var a=i("4Q6Z"),n=i("z0WU"),o=i("DKCI"),s=i("50Ol"),l=i("F9dT"),r=(i("Yfch"),i("YP4+")),d=i("WwWg"),c=(i("evdt"),i("mwzG")),u={name:"multilevel-table",mixins:[a.a],provide:function(){return{rootVm:this}},props:{initData:{type:Object,default:function(){return{}}},expand:[Boolean],expandMode:[String],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,showColList:"",headerWidthList:[],listLength:-1,restaurants:[],debounce:300,fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:o.a,customSummaryOption:s.a},computed:{setGlobalSingle:function(){return this.layerConfig.globalSingle||this.globalSingle||!1},setLayerSingle:function(){return this.layerConfig.layerSingle||this.layerSingle||!1},setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2)}},created:function(){var e=this;if(!this.layer)if(this.guid=Object(n.a)(),this.userInfo=this.$storage.get("userInfo"),Object(d.c)(this),this.initData.result){var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var t=JSON.parse(JSON.stringify(c.a));e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:t,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1},1e3):this.httpRequests());this.layer&&(this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.setDragTable&&this.setSort(),this.initLoading=!1):this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.initLoading=!1)},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){//!this.layer && unCreateStore(this.$store, this.guid)
},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay()},initData:function(){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1},resetContentWidthList:function(){var e=this,t=this.resetContentWidthList.map(function(e){return null});this.resetContentWidthList.forEach(function(i,a){e.useMiddleValue=!1,t[a]=e.contentWidthAlgorithm(i.map(function(e){return Math.max.apply(null,e)})),e.useMiddleValueList[a]=e.useMiddleValue}),t.forEach(function(t,i){e.contentWidthList[i]=t?t+26:null})}},methods:{contentWidthAlgorithm:function(e){if(e&&e.length){if(e.length>1){var t=Math.max.apply(null,e);if(t-Math.min.apply(null,e)>this.setWidthDiffValue){var i,a=[].concat(e);return a.sort(n.c),i=a.length%2==0?(a[a.length/2-1]+a[a.length/2])/2:a[(a.length+1)/2-1],this.useMiddleValue=!0,t-i>this.setWidthDiffValue&&(i=2*this.setWidthDiffValue),i}return t}return e[0]}return null},databridge:function(e,t){this.$emit("databridge",e,t)},expandChange:function(e,t){var i=this;"one"===this.setExpandMode&&t.forEach(function(i,a){e._internalId!==i._internalId&&t.splice(a,1)}),this.$refs.baseTable.$nextTick(function(e){i.$refs.baseTable.doLayout(),i.$emit("table-dolayout")})},setRowExpansion:function(e,t){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(e,t)},httpRequests:function(e){var t=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:e||1},this.searchObj)).then(function(i){t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:i,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.initLoading=!1,e&&(t.pageNo=e,t.scrollTable())}).catch(function(e){console.log(e),t.initLoading=!1})},httpChildrenRequests:function(e,t){var i=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:t||1},this.setParams(e,this.setApiObj),this.setDynaValue(e))).then(function(a){i.$store.commit(i.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:a,row:e,vm:i}),i.setDragTable&&i.setSort(),i.pageNo=i.tableData[i.dataName].pageData&&i.tableData[i.dataName].pageData.current||1,i.initLoading=!1,console.log("initLoading---\x3e",i.initLoading),t&&i.scrollTable()}).catch(function(e){console.log(e),i.initLoading=!1})},selectItem:function(e,t){e.findIndex(function(e){return e._internalId===t._internalId})>-1?(this.tempCheckedList.push(t),this.$store.commit(this.setGuid+"/ADD_CHECKED",[t])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[t]),this.tempCheckedList=this.tempCheckedList.filter(function(e){return e._internalId!==t._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:e.length?"0":"1"}),e.length?(this.tableData[this.dataName].forEach(function(e){e.rowState="0"}),e[0].rowState="1"):this.tableData[this.dataName].forEach(function(e){e.rowState="1"}))},selectAllItem:function(e){if(this.setIsSingle){if(e.length)for(var t=e.length-1;t>=0;t--)e.splice(t,1)}else e.length?(this.tempCheckedList=e.map(function(e){return e}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(e){e!==this.pageNo&&this.httpRequests(e)},setDynaValue:function(e){if(this.setDynamicValue){var t={};for(var i in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(i)&&(t[i]=Object(l.c)([this.setDynamicValue[i]],e,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return console.log(t),t}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setCellStyle:function(e){return this.setExpand&&2===this.maxLayer&&"1"===this.setExpandColumnWidth?{"border-bottom":"none","background-color":"inherit"}:{"background-color":"inherit"}},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(e,t){var i=this;return t&&e?(this.resultTableData=(e.tableData||e.children).find(function(e){if(e._internalId===t)return!0;if(e.children&&e.children.length){var a={titleList:e.titleList,children:e.children,pageData:e.pageData||{}};i.resultTableData=i.searchTableData(a,t)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(e){this.$emit("callmethod",e)},tableDoLayout:function(){var e=this;this.$nextTick(function(t){e.$refs.baseTable.doLayout(),e.$emit("table-dolayout")})}}},h=(i("q7oa"),i("KHd+")),p=Object(h.a)(u,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.setTableLoading,expression:"setTableLoading"}],class:e.setTableClass},[e.setShowTableSet?i("table-filter",{attrs:{headerList:e.setColConfigs,storeId:e.pageId,componentId:e.setComponentId,showAll:e.setShowAll},on:{"checked-list":e.checkedList,"checked-height":e.checkedHeight}}):e._e(),e._v(" "),i("div",{style:{height:e.setTableHeight}},[i("el-form",{ref:"ruleForm",style:{height:e.layer?"auto":"100%"},attrs:{model:e.ruleForm,"status-icon":""},nativeOn:{submit:function(e){e.preventDefault()}}},[i("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:e.tableData[e.dataName],stripe:!e.setExpand||"50"===e.setExpandColumnWidth,"highlight-current-row":"",border:e.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:e.layer?null:"100%",fit:"","show-header":e.setShowHeader,"row-key":"_internalId","show-summary":e.setSysSummary,"default-expand-all":!e.setShowExpandBtn&&e.setExpand&&"all"===e.setExpandMode,"header-row-style":e.setHeaderRowStyle,"row-style":e.setRowStyle,"row-class-name":e.setRowClass,"cell-style":e.setCellStyle,"header-row-class-name":e.setHeaderRowClass,"default-sort":{prop:"count",order:"descending"}},on:{select:e.selectItem,"select-all":e.selectAllItem,"expand-change":e.expandChange,"sort-change":e.sortChange}},[e.setExpand?[i("el-table-column",{attrs:{type:"expand",width:e.setExpandColumnWidth,align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("multilevel-table",{attrs:{tableConfigList:e.tableConfigList,layer:e.layer+1,internalGuid:e.setGuid,parentData:[t.row],rowChain:e.setRowChain},on:{databridge:e.databridge,callmethod:e.callParentMethod,"table-dolayout":e.tableDoLayout}})]}}])})]:e._e(),e._v(" "),e.setShowCheckBox?[i("el-table-column",{attrs:{type:"selection",fixed:e.setFixedState,selectable:e.selectable,width:"55",align:"center"}})]:e._e(),e._v(" "),e.setShowIndex?[i("el-table-column",{attrs:{type:"index",index:e.indexMethod,fixed:e.setFixedState,label:"序号",width:"50",align:"center"}})]:e._e(),e._v(" "),e._l(e.setTitleList,function(t,a){return[t.slot&&t._isShow?e._t(t.slot,null,{fixed:e.setFixedList[a]}):Array.isArray(t.component)&&t._isShow?[i("el-table-column",e._b({key:a,attrs:{"show-overflow-tooltip":"",fixed:e.setFixedList[a],width:e.setColumnWidth[t.prop]||null,align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[i("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:a,isComponent:!0,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[e._v("\n                  "+e._s(t.label)+"\n                ")])]}},{key:"default",fn:function(a){return["button"===t.componentName?i("div",{directives:[{name:"button-width",rawName:"v-button-width",value:t,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":e.setColumnWidth[t.prop]?"space-between":"center"}},e._l(t.component,function(t,n){return void 0!==t.editBtns_isShow&&!t.editBtns_isShow||!t.rowState||e.setButtonState(a.$index,a.row,t)?i("el-button",{key:n,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(e){t.method(a.row,a.$index,a)}}},[e._v(e._s(t.name)+"\n                  ")]):e._e()}),1):e._e()]}}])},"el-table-column",t,!1))]:"object"==typeof t.component&&t._isShow?i(t.component,{key:a,tag:"component",attrs:{"col-config":t,fixed:e.setFixedList[a]}}):[t._isShow?i("el-table-column",{key:a,attrs:{"show-overflow-tooltip":"",label:t.label,prop:t.columnIndex||t.prop,width:t.width||e.constantWidth[t.componentName]||"auto","min-width":t["min-width"]||e.contentWidthList[a]||"none",sortable:!!e.setSortableConfig[t.columnIndex||t.prop],"sort-method":e.setSortableConfig[t.columnIndex||t.prop]&&e.setSortableConfig[t.columnIndex||t.prop]["sort-method"]?e.setSortableConfig[t.columnIndex||t.prop]["sort-method"]:null,"sort-by":e.setSortableConfig[t.columnIndex||t.prop]&&e.setSortableConfig[t.columnIndex||t.prop]["sort-by"]?e.setSortableConfig[t.columnIndex||t.prop]["sort-by"]:null,fixed:e.setFixedList[a],align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[i("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:a,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"}],style:{display:t._isShow?"inline-flex":"none"},domProps:{textContent:e._s(t.label)}})]}},{key:"default",fn:function(n){return[t.mergeTitles&&t.mergeTitles.length?[e._l(t.mergeTitles,function(o,s){return[o.componentName?["input"===o.componentName?[o._cellConfig.asyn?[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-autocomplete",{attrs:{_scope:n,"child-colconfig":o,debounce:e.debounce}})],1)]:[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-input",{attrs:{_scope:n,"child-colconfig":o}})],1)]]:"date"===o.componentName?[i("table-date-picker",{attrs:{_scope:n,"child-colconfig":o}})]:"time"===o.componentName?[i("table-time-picker",{attrs:{_scope:n,"child-colconfig":o}})]:"select"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-select",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"cascader"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-cascader",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"switch"===o.componentName?[i("div",[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[e._v("\n                            "+e._s(o.label+":")+" \n                          ")]),e._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-switch",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"dateTime"===o.componentName?[i("table-date-time",{attrs:{_scope:n,"child-colconfig":o}})]:"inputNumber"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-input-number",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"steps"===o.componentName?[i("div",{key:s,staticClass:"resetElStepStyle"},[o._cellConfig.hideTitle?e._e():i("div",{style:o._cellConfig.titleStyle||{}},[e._v("\n                            "+e._s(o.label+":")+" \n                          ")]),e._v(" "),i("div",[i("table-steps",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"progress"===o.componentName?[i("div",{key:s,staticStyle:{"text-align":"left"}},[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:[{"line-height":o._cellConfig.componentConfig["stroke-width"]>23?2:""},o._cellConfig.titleStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.titleStyle:{})||{}]},[e._v("\n                            "+e._s(o.label+":"+(o._cellConfig.componentConfig.showInitValue?n.row[o.prop]:""))+" \n                          ")]),e._v(" "),i("div",{staticClass:"resetProgressStyle",staticStyle:{display:"inline-block",overflow:"hidden","vertical-align":"middle"},style:{width:(o._cellConfig.componentConfig.width||e.constantWidth[o.componentName])+"px"}},[i("table-progress",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"upload"===o.componentName?[i("table-upload",{attrs:{_scope:n,"child-colconfig":o}})]:"tag"===o.componentName?[i("table-tag",{attrs:{_scope:n,"child-colconfig":o}})]:"button"===o.componentName?[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[e._v("\n                          "+e._s(o.label+":")+" \n                        ")]),e._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-button",{attrs:{_scope:n,"child-colconfig":o}})],1)]:[i("span",{key:s,staticStyle:{"margin-left":"10px"},domProps:{textContent:e._s(n.row[o.prop])}})]]:[i("div",{key:s,style:{"text-align":o._cellConfig&&o._cellConfig.hideTitle?"center":"left"}},[o._cellConfig?[o._cellConfig.hideTitle?e._e():[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:[o._cellConfig.titleStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.titleStyle:{}),e.setMiddleValue[a]?e.setMiddleValue[a].title:{}],domProps:{textContent:e._s(o.label+":")}},[e._v(" ")])]]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:e.setMiddleValue[a]?e.setMiddleValue[a].title:{},domProps:{textContent:e._s(o.label+":")}},[e._v(" ")])],e._v(" "),o._cellConfig&&o._cellConfig.events?[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"}],style:[o._cellConfig.bodyStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.bodyStyle:{}),e.setMiddleValue[a]?e.setMiddleValue[a].body:{}]},[i("a",{domProps:{textContent:e._s(n.row[o.prop])},on:{click:function(t){e.mergeColumnEvents(o,n)}}})])]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"},{name:"content-set",rawName:"v-content-set",value:{config:o,row:n.row},expression:"{config: childColconfig,row: scope.row}"}],class:{resetContent:e.setMiddleValue[a],ellipsis:!!e.setMiddleValue[a]&&e.isEllipsis(n.row[o.columnIndex||o.prop],parseInt(e.setMiddleValue[a].body.width))},style:[o._cellConfig?o._cellConfig.bodyStyle:{},e.setColumnGlobalStyle?e.setColumnGlobalStyle.bodyStyle:{},e.setMiddleValue[a]?e.setMiddleValue[a].body:{}],domProps:{textContent:e._s(n.row[o.columnIndex||o.prop])}})]],2)]]})]:[i("div",{directives:[{name:"reset-text-width",rawName:"v-reset-text-width"}],style:{display:t._isShow?"inline-block":"none"},domProps:{textContent:e._s(n.row[t.prop])}})]]}}])}):e._e()]]}),e._v(" "),e.setDragTable?[i("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:e._u([{key:"default",fn:function(e){return[i("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[i("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)]}}])})]:e._e()],2)],1),e._v(" "),e.setUseSummary&&e.setCustomSummary.component?[i("custom-summary-option",{attrs:{customSummary:e.setCustomSummary,tempData:e.setTempData,tableData:e.tableData[e.dataName]},on:{"send-height":e.customSummaryHeight,"custom-summary-value":e.customSummaryValue}})]:e._e()],2),e._v(" "),e.setHidePages?e._e():i("div",{staticStyle:{height:"40px","text-align":"center"},style:{"margin-top":(e.customSummaryOptionHeight||5)+"px"}},[i("el-pagination",{attrs:{background:"","current-page":e.tableData.pageData.current,"page-size":e.tableData.pageData.size,layout:"prev, pager, next, jumper",total:e.tableData.pageData.total-0},on:{"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.tableData.pageData,"current",t)}}})],1)],1)},[],!1,null,null,null);p.options.__file="index.vue";t.a=p.exports},D2yE:function(e,t,i){},J99a:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("pIFo"),i("rGqo");var a=i("uTIz"),n=i("2+ib"),o=i("b3I8");function s(e){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var l={components:{searchBar:a.a,multilevelTable:n.a,dialogAdd:o.default},name:"dialog-add",props:["initData","visible"],data:function(){return{orderId:"",supplierId:"",supplierName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",table_style:"",orderId:"",orderDtlIds:"",supplierId:"",supplierName:""},rowTableList:[],tableConfigList:[{customColumn:[{columnIndex:"code"},{columnIndex:"supplierName"},{columnIndex:"cdate"},{columnIndex:"applyName"},{columnIndex:"remark"},{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},default:{state:"0",text:"待提交"}}}],apiObj:{apiName:"listPagePurchaseOrders",params:{id:"",fieldCode:"code,supplierName,cdate,applyName,remark,state",queryStr:"",orderStr:"purchaseOrder.code desc"}},tempData:{},showHeader:!1,showIndex:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"4",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},info1:{state:"3",text:"部分签收"},default:{state:"0",text:"待提交"}}}],apiObj:{apiName:"listPagePurchaseOrderDetails",params:{isNeedPage:"false",fieldCode:"productCode,productName,spec,genre,unit,count,arriveCount,price,amount,signDate,state,remark",queryStr:""}},dynamicValue:{parentId:"self@id"},tempData:{},showCheckBox:!0,isSingle:!1,componentId:"twoLevelTable"}]}},created:function(){this.orderId=this.initData.orderId,this.supplierId=this.initData.supplierId,this.supplierName=this.initData.supplierName;var e="detail.id in (select a.id from vmes_purchase_order_detail a left join vmes_purchase_order b on a.parent_id = b.id left join view_purchase_order_detail_by_count c on a.id = c.orderDtlId where b.company_id = '"+this.$storage.get("userInfo").companyId+"' and a.isdisable = '1' and c.arrive_count > 0 )";this.tableConfigList[0].apiObj.params.id=this.orderId,this.tableConfigList[0].apiObj.params.queryStr=e,this.tableConfigList[1].apiObj.params.queryStr=e},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=s(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(e){this.rowTableList=[],Array.isArray(e)&&(this.rowTableList=e)},dialogOpen:function(){},dialogClose:function(e){(e={}).resState=this.resState,this.$emit("close-dialog",e||{})},updateData:function(e){this.$refs.customBaseTable.updateData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},closeDialog:function(e){e.resState&&(this.resState=e.resState),this.isVisible=!1},save:function(){var e="";if(null!=this.rowTableList&&0!=this.rowTableList.length||(e="请至少选择一行数据！"),e.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:e});else{var t="";this.rowTableList.forEach(function(e){var i=e.id;null!=i&&i.trim().length>0&&(t=t+i.trim()+",")}),null!=t&&t.trim().length>0&&(t="'"+(t=t.substring(0,t.lastIndexOf(","))).replace(",","','")+"'"),this.dialogData.orderId=this.orderId,this.dialogData.orderDtlIds=t,this.dialogData.supplierId=this.supplierId,this.dialogData.supplierName=this.supplierName;var i=.7*document.body.clientWidth;this.dialogData.dialog_width=i+"px";var a=.666*(.618*i)+"px";this.dialogData.table_style="height:"+a+";width: 96%;margin-left: 2%;",this.dialogData.title="生成退货单",this.openDialogName="dialogAdd",this.showDialog=!0,this.inLinVisible=!0}}}},r=i("KHd+"),d=Object(r.a)(l,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("el-row",{style:e.initData.table_style},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)},[],!1,null,null,null);d.options.__file="dialogPurchaseOrderDtl.vue";t.default=d.exports},b3I8:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("rGqo");var a=i("uTIz"),n=i("2+ib"),o=i("spKr");function s(e){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}function l(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var r={components:{searchBar:a.a,multilevelTable:n.a},name:"dialog-add",props:["initData","visible"],data:function(){var e,t=this;return l(e={orderId:"",supplierId:"",supplierName:"",formData:{cuserName:"",supplierName:"",type:"",typeName:""},rules:{typeName:[{required:!0,trigger:"change",validator:function(e,i,a){t.typeData.defaultSelected.length<=0?a(new Error("请选择退货类型")):a()}}]},dialogLoading:!0,isVisible:!1,inDialog:!0},"formData",{}),l(e,"openDialogName",""),l(e,"showDialog",!1),l(e,"inLinVisible",!1),l(e,"dialogData",{dialog_width:"",table_style:"",orderId:"",orderDtlIds:""}),l(e,"rowTableList",[]),l(e,"tableConfigList",[{customColumn:[{columnIndex:"code"},{columnIndex:"supplierName"},{columnIndex:"cdate"},{columnIndex:"applyName"},{columnIndex:"remark"},{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},default:{state:"0",text:"待提交"}}}],apiObj:{apiName:"listPagePurchaseOrders",params:{id:"",fieldCode:"code,supplierName,cdate,applyName,remark,state",orderStr:"purchaseOrder.code desc"}},tempData:{},showHeader:!1,showIndex:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"retreatCount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"retreatRemark",componentName:"input",_cellConfig:{}}],apiObj:{apiName:"listPageOrderDetailByRetreat",params:{isNeedPage:"false",fieldCode:"productCode,productName,productSpec,productGenreName,unitName,count,maxRetreatCount,retreatCount,retreatRemark",detailIds:""}},dynamicValue:{parentId:"self@id"},tempData:{},isSingle:!1,componentId:"twoLevelTable"}]),l(e,"typeData",{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"retreatType",isglobal:"1"}},defaultSelected:[]}),e},created:function(){this.orderId=this.initData.orderId,this.supplierId=this.initData.supplierId,this.supplierName=this.initData.supplierName;var e=this.$storage.get("userInfo");this.formData.cuserName=e.userName,this.formData.supplierName=this.supplierName;var t="";null!=this.initData.orderDtlIds&&this.initData.orderDtlIds.trim().length>0&&(t=this.initData.orderDtlIds.trim()),this.tableConfigList[0].apiObj.params.id=this.orderId,this.tableConfigList[1].apiObj.params.detailIds=t},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=s(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(e){this.rowTableList=[],Array.isArray(e)&&(this.rowTableList=e)},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},updateData:function(e){this.$refs.customBaseTable.updateData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},closeDialog:function(e){},typeSelect:function(e){e[0]?(this.formData.type=e[0],this.typeData.defaultSelected=[e[0]]):(this.formData.type=[],this.typeData.defaultSelected=[])},save:function(){var e=this;this.$refs.submitForm.validate(function(t){if(t&&(e.$refs.retreatAddDialog.getData(),null!=e.rowTableList&&e.rowTableList.length>0)){var i=e.findChildrenList(e.rowTableList);e.savePurchaseRetreat(i)}})},findChildrenList:function(e){var t=[];return null!=e&&null!=e[0].children&&e[0].children.length>0&&e[0].children.forEach(function(e){t.push(e)}),t},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i],n=a.retreatCount;n-a.maxRetreatCount>0&&(t=t+"第 "+(i+1)+" 行: 本次退货数量("+n+") 输入错误，本次退货数量不可大于可退货数量！")}return t},savePurchaseRetreat:function(e){var t=this;if(null!=e&&0!=e.length){var i=this.checkColumn(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{var a=[];e.forEach(function(e){var t={orderDetailId:e.id,productId:e.productId,unit:e.unit,count:e.retreatCount,remark:e.retreatRemark,price:e.price};a.push(t)});var n="";null!=a&&a.length>0&&(n=JSON.stringify(a)),null!=n&&0!=n?Object(o.addPurchaseRetreat)({orderId:this.orderId,supplierId:this.supplierId,type:this.formData.type,dtlJsonStr:n}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"暂无采购订单明细！"})}}}}},d=i("KHd+"),c=Object(d.a)(r,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("el-form",{ref:"submitForm",attrs:{rules:e.rules,model:e.formData,"label-position":"right","label-width":"90px"}},[i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"退货类型:",prop:"typeName"}},[i("base-input-select",{attrs:{data:e.typeData.data},on:{callback:e.typeSelect},model:{value:e.typeData.defaultSelected,callback:function(t){e.$set(e.typeData,"defaultSelected",t)},expression:"typeData.defaultSelected"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"供应商名称:",prop:"deptName"}},[i("el-input",{attrs:{disabled:!0},model:{value:e.formData.supplierName,callback:function(t){e.$set(e.formData,"supplierName",t)},expression:"formData.supplierName"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[i("el-input",{attrs:{disabled:!0},model:{value:e.formData.cuserName,callback:function(t){e.$set(e.formData,"cuserName",t)},expression:"formData.cuserName"}})],1)],1)],1),e._v(" "),i("el-row",{style:e.initData.table_style},[i("multilevel-table",{ref:"retreatAddDialog",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)},[],!1,null,null,null);c.options.__file="dialogAdd.vue";t.default=c.exports},q7oa:function(e,t,i){"use strict";var a=i("D2yE");i.n(a).a}}]);