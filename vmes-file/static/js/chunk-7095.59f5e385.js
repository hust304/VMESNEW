(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7095","chunk-336d","chunk-7167"],{"2+ib":function(e,t,i){"use strict";i("dRSK"),i("INYr"),i("91GP"),i("Vd3H"),i("rGqo"),i("f3/d"),i("xfY5");var a=i("4Q6Z"),n=i("z0WU"),o=i("DKCI"),s=i("50Ol"),l=i("F9dT"),r=(i("Yfch"),i("YP4+")),d=i("WwWg"),c=(i("evdt"),i("mwzG")),h={name:"multilevel-table",mixins:[a.a],provide:function(){return{rootVm:this}},props:{initData:{type:Object,default:function(){return{}}},expand:[Boolean],expandMode:[String],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,showColList:"",headerWidthList:[],listLength:-1,restaurants:[],debounce:300,fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:o.a,customSummaryOption:s.a},computed:{setGlobalSingle:function(){return this.layerConfig.globalSingle||this.globalSingle||!1},setLayerSingle:function(){return this.layerConfig.layerSingle||this.layerSingle||!1},setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2)}},created:function(){var e=this;if(!this.layer)if(this.guid=Object(n.a)(),this.userInfo=this.$storage.get("userInfo"),Object(d.c)(this),this.initData.result){var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var t=JSON.parse(JSON.stringify(c.a));e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:t,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1},1e3):this.httpRequests());this.layer&&(this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.setDragTable&&this.setSort(),this.initLoading=!1):this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.initLoading=!1)},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){//!this.layer && unCreateStore(this.$store, this.guid)
},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay()},initData:function(){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1},resetContentWidthList:function(){var e=this,t=this.resetContentWidthList.map(function(e){return null});this.resetContentWidthList.forEach(function(i,a){e.useMiddleValue=!1,t[a]=e.contentWidthAlgorithm(i.map(function(e){return Math.max.apply(null,e)})),e.useMiddleValueList[a]=e.useMiddleValue}),t.forEach(function(t,i){e.contentWidthList[i]=t?t+26:null})}},methods:{contentWidthAlgorithm:function(e){if(e&&e.length){if(e.length>1){var t=Math.max.apply(null,e);if(t-Math.min.apply(null,e)>this.setWidthDiffValue){var i,a=[].concat(e);return a.sort(n.c),i=a.length%2==0?(a[a.length/2-1]+a[a.length/2])/2:a[(a.length+1)/2-1],this.useMiddleValue=!0,t-i>this.setWidthDiffValue&&(i=2*this.setWidthDiffValue),i}return t}return e[0]}return null},databridge:function(e,t){this.$emit("databridge",e,t)},expandChange:function(e,t){var i=this;"one"===this.setExpandMode&&t.forEach(function(i,a){e._internalId!==i._internalId&&t.splice(a,1)}),this.$refs.baseTable.$nextTick(function(e){i.$refs.baseTable.doLayout(),i.$emit("table-dolayout")})},setRowExpansion:function(e,t){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(e,t)},httpRequests:function(e){var t=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:e||1},this.searchObj)).then(function(i){t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:i,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.initLoading=!1,e&&(t.pageNo=e,t.scrollTable())}).catch(function(e){console.log(e),t.initLoading=!1})},httpChildrenRequests:function(e,t){var i=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:t||1},this.setParams(e,this.setApiObj),this.setDynaValue(e))).then(function(a){i.$store.commit(i.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:a,row:e,vm:i}),i.setDragTable&&i.setSort(),i.pageNo=i.tableData[i.dataName].pageData&&i.tableData[i.dataName].pageData.current||1,i.initLoading=!1,console.log("initLoading---\x3e",i.initLoading),t&&i.scrollTable()}).catch(function(e){console.log(e),i.initLoading=!1})},selectItem:function(e,t){e.findIndex(function(e){return e._internalId===t._internalId})>-1?(this.tempCheckedList.push(t),this.$store.commit(this.setGuid+"/ADD_CHECKED",[t])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[t]),this.tempCheckedList=this.tempCheckedList.filter(function(e){return e._internalId!==t._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:e.length?"0":"1"}),e.length?(this.tableData[this.dataName].forEach(function(e){e.rowState="0"}),e[0].rowState="1"):this.tableData[this.dataName].forEach(function(e){e.rowState="1"}))},selectAllItem:function(e){if(this.setIsSingle){if(e.length)for(var t=e.length-1;t>=0;t--)e.splice(t,1)}else e.length?(this.tempCheckedList=e.map(function(e){return e}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(e){e!==this.pageNo&&this.httpRequests(e)},setDynaValue:function(e){if(this.setDynamicValue){var t={};for(var i in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(i)&&(t[i]=Object(l.c)([this.setDynamicValue[i]],e,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return console.log(t),t}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setCellStyle:function(e){return this.setExpand&&2===this.maxLayer&&"1"===this.setExpandColumnWidth?{"border-bottom":"none","background-color":"inherit"}:{"background-color":"inherit"}},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(e,t){var i=this;return t&&e?(this.resultTableData=(e.tableData||e.children).find(function(e){if(e._internalId===t)return!0;if(e.children&&e.children.length){var a={titleList:e.titleList,children:e.children,pageData:e.pageData||{}};i.resultTableData=i.searchTableData(a,t)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(e){this.$emit("callmethod",e)},tableDoLayout:function(){var e=this;this.$nextTick(function(t){e.$refs.baseTable.doLayout(),e.$emit("table-dolayout")})}}},u=(i("q7oa"),i("KHd+")),p=Object(u.a)(h,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.setTableLoading,expression:"setTableLoading"}],class:e.setTableClass},[e.setShowTableSet?i("table-filter",{attrs:{headerList:e.setColConfigs,storeId:e.pageId,componentId:e.setComponentId,showAll:e.setShowAll},on:{"checked-list":e.checkedList,"checked-height":e.checkedHeight}}):e._e(),e._v(" "),i("div",{style:{height:e.setTableHeight}},[i("el-form",{ref:"ruleForm",style:{height:e.layer?"auto":"100%"},attrs:{model:e.ruleForm,"status-icon":""},nativeOn:{submit:function(e){e.preventDefault()}}},[i("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:e.tableData[e.dataName],stripe:!e.setExpand||"50"===e.setExpandColumnWidth,"highlight-current-row":"",border:e.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:e.layer?null:"100%",fit:"","show-header":e.setShowHeader,"row-key":"_internalId","show-summary":e.setSysSummary,"default-expand-all":!e.setShowExpandBtn&&e.setExpand&&"all"===e.setExpandMode,"header-row-style":e.setHeaderRowStyle,"row-style":e.setRowStyle,"row-class-name":e.setRowClass,"cell-style":e.setCellStyle,"header-row-class-name":e.setHeaderRowClass,"default-sort":{prop:"count",order:"descending"}},on:{select:e.selectItem,"select-all":e.selectAllItem,"expand-change":e.expandChange,"sort-change":e.sortChange}},[e.setExpand?[i("el-table-column",{attrs:{type:"expand",width:e.setExpandColumnWidth,align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("multilevel-table",{attrs:{tableConfigList:e.tableConfigList,layer:e.layer+1,internalGuid:e.setGuid,parentData:[t.row],rowChain:e.setRowChain},on:{databridge:e.databridge,callmethod:e.callParentMethod,"table-dolayout":e.tableDoLayout}})]}}])})]:e._e(),e._v(" "),e.setShowCheckBox?[i("el-table-column",{attrs:{type:"selection",fixed:e.setFixedState,selectable:e.selectable,width:"55",align:"center"}})]:e._e(),e._v(" "),e.setShowIndex?[i("el-table-column",{attrs:{type:"index",index:e.indexMethod,fixed:e.setFixedState,label:"序号",width:"50",align:"center"}})]:e._e(),e._v(" "),e._l(e.setTitleList,function(t,a){return[t.slot&&t._isShow?e._t(t.slot,null,{fixed:e.setFixedList[a]}):Array.isArray(t.component)&&t._isShow?[i("el-table-column",e._b({key:a,attrs:{"show-overflow-tooltip":"",fixed:e.setFixedList[a],width:e.setColumnWidth[t.prop]||null,align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[i("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:a,isComponent:!0,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[e._v("\n                  "+e._s(t.label)+"\n                ")])]}},{key:"default",fn:function(a){return["button"===t.componentName?i("div",{directives:[{name:"button-width",rawName:"v-button-width",value:t,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":e.setColumnWidth[t.prop]?"space-between":"center"}},e._l(t.component,function(t,n){return void 0!==t.editBtns_isShow&&!t.editBtns_isShow||!t.rowState||e.setButtonState(a.$index,a.row,t)?i("el-button",{key:n,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(e){t.method(a.row,a.$index,a)}}},[e._v(e._s(t.name)+"\n                  ")]):e._e()}),1):e._e()]}}])},"el-table-column",t,!1))]:"object"==typeof t.component&&t._isShow?i(t.component,{key:a,tag:"component",attrs:{"col-config":t,fixed:e.setFixedList[a]}}):[t._isShow?i("el-table-column",{key:a,attrs:{"show-overflow-tooltip":"",label:t.label,prop:t.columnIndex||t.prop,width:t.width||e.constantWidth[t.componentName]||"auto","min-width":t["min-width"]||e.contentWidthList[a]||"none",sortable:!!e.setSortableConfig[t.columnIndex||t.prop],"sort-method":e.setSortableConfig[t.columnIndex||t.prop]&&e.setSortableConfig[t.columnIndex||t.prop]["sort-method"]?e.setSortableConfig[t.columnIndex||t.prop]["sort-method"]:null,"sort-by":e.setSortableConfig[t.columnIndex||t.prop]&&e.setSortableConfig[t.columnIndex||t.prop]["sort-by"]?e.setSortableConfig[t.columnIndex||t.prop]["sort-by"]:null,fixed:e.setFixedList[a],align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[i("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:a,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"}],style:{display:t._isShow?"inline-flex":"none"},domProps:{textContent:e._s(t.label)}})]}},{key:"default",fn:function(n){return[t.mergeTitles&&t.mergeTitles.length?[e._l(t.mergeTitles,function(o,s){return[o.componentName?["input"===o.componentName?[o._cellConfig.asyn?[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-autocomplete",{attrs:{_scope:n,"child-colconfig":o,debounce:e.debounce}})],1)]:[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-input",{attrs:{_scope:n,"child-colconfig":o}})],1)]]:"date"===o.componentName?[i("table-date-picker",{attrs:{_scope:n,"child-colconfig":o}})]:"time"===o.componentName?[i("table-time-picker",{attrs:{_scope:n,"child-colconfig":o}})]:"select"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-select",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"cascader"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-cascader",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"switch"===o.componentName?[i("div",[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[e._v("\n                            "+e._s(o.label+":")+" \n                          ")]),e._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-switch",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"dateTime"===o.componentName?[i("table-date-time",{attrs:{_scope:n,"child-colconfig":o}})]:"inputNumber"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-input-number",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"steps"===o.componentName?[i("div",{key:s,staticClass:"resetElStepStyle"},[o._cellConfig.hideTitle?e._e():i("div",{style:o._cellConfig.titleStyle||{}},[e._v("\n                            "+e._s(o.label+":")+" \n                          ")]),e._v(" "),i("div",[i("table-steps",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"progress"===o.componentName?[i("div",{key:s,staticStyle:{"text-align":"left"}},[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:[{"line-height":o._cellConfig.componentConfig["stroke-width"]>23?2:""},o._cellConfig.titleStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.titleStyle:{})||{}]},[e._v("\n                            "+e._s(o.label+":"+(o._cellConfig.componentConfig.showInitValue?n.row[o.prop]:""))+" \n                          ")]),e._v(" "),i("div",{staticClass:"resetProgressStyle",staticStyle:{display:"inline-block",overflow:"hidden","vertical-align":"middle"},style:{width:(o._cellConfig.componentConfig.width||e.constantWidth[o.componentName])+"px"}},[i("table-progress",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"upload"===o.componentName?[i("table-upload",{attrs:{_scope:n,"child-colconfig":o}})]:"tag"===o.componentName?[i("table-tag",{attrs:{_scope:n,"child-colconfig":o}})]:"button"===o.componentName?[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[e._v("\n                          "+e._s(o.label+":")+" \n                        ")]),e._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-button",{attrs:{_scope:n,"child-colconfig":o}})],1)]:[i("span",{key:s,staticStyle:{"margin-left":"10px"},domProps:{textContent:e._s(n.row[o.prop])}})]]:[i("div",{key:s,style:{"text-align":o._cellConfig&&o._cellConfig.hideTitle?"center":"left"}},[o._cellConfig?[o._cellConfig.hideTitle?e._e():[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:[o._cellConfig.titleStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.titleStyle:{}),e.setMiddleValue[a]?e.setMiddleValue[a].title:{}],domProps:{textContent:e._s(o.label+":")}},[e._v(" ")])]]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:e.setMiddleValue[a]?e.setMiddleValue[a].title:{},domProps:{textContent:e._s(o.label+":")}},[e._v(" ")])],e._v(" "),o._cellConfig&&o._cellConfig.events?[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"}],style:[o._cellConfig.bodyStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.bodyStyle:{}),e.setMiddleValue[a]?e.setMiddleValue[a].body:{}]},[i("a",{domProps:{textContent:e._s(n.row[o.prop])},on:{click:function(t){e.mergeColumnEvents(o,n)}}})])]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"},{name:"content-set",rawName:"v-content-set",value:{config:o,row:n.row},expression:"{config: childColconfig,row: scope.row}"}],class:{resetContent:e.setMiddleValue[a],ellipsis:!!e.setMiddleValue[a]&&e.isEllipsis(n.row[o.columnIndex||o.prop],parseInt(e.setMiddleValue[a].body.width))},style:[o._cellConfig?o._cellConfig.bodyStyle:{},e.setColumnGlobalStyle?e.setColumnGlobalStyle.bodyStyle:{},e.setMiddleValue[a]?e.setMiddleValue[a].body:{}],domProps:{textContent:e._s(n.row[o.columnIndex||o.prop])}})]],2)]]})]:[i("div",{directives:[{name:"reset-text-width",rawName:"v-reset-text-width"}],style:{display:t._isShow?"inline-block":"none"},domProps:{textContent:e._s(n.row[t.prop])}})]]}}])}):e._e()]]}),e._v(" "),e.setDragTable?[i("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:e._u([{key:"default",fn:function(e){return[i("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[i("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)]}}])})]:e._e()],2)],1),e._v(" "),e.setUseSummary&&e.setCustomSummary.component?[i("custom-summary-option",{attrs:{customSummary:e.setCustomSummary,tempData:e.setTempData,tableData:e.tableData[e.dataName]},on:{"send-height":e.customSummaryHeight,"custom-summary-value":e.customSummaryValue}})]:e._e()],2),e._v(" "),e.setHidePages?e._e():i("div",{staticStyle:{height:"40px","text-align":"center"},style:{"margin-top":(e.customSummaryOptionHeight||5)+"px"}},[i("el-pagination",{attrs:{background:"","current-page":e.tableData.pageData.current,"page-size":e.tableData.pageData.size,layout:"prev, pager, next, jumper",total:e.tableData.pageData.total-0},on:{"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.tableData.pageData,"current",t)}}})],1)],1)},[],!1,null,null,null);p.options.__file="index.vue";t.a=p.exports},D2yE:function(e,t,i){},"F4/0":function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d"),i("Oyvg");var a=i("uTIz"),n=i("2+ib"),o=i("YcSE"),s=i("b5Ov");function l(e){return(l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var r={components:{searchBar:a.a,multilevelTable:n.a,dialogWarehouseBySimple:o.default},name:"dialog-add",props:["initData","visible"],data:function(){return{sourceWarehouseId:"",warehouse:{name:null,id:null},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{warehouseIds:"",title:"",dialog_width:"",table_style:"",temp:{}},rowTableList:[],tableConfigList:[{customColumn:[{columnIndex:"moveCount",componentName:"input",_cellConfig:{}}],apiObj:{apiName:"listPageWarehouseInitial",params:{productIds:"",fieldCode:"pathName,productCode,productName,productSpec,productGenreName,productUnitName,stockCount,moveCount"}},tempData:{},showHeader:!0,showIndex:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}]}},created:function(){this.sourceWarehouseId=this.initData.sourceWarehouseId;var e="";null!=this.initData.productIds&&this.initData.productIds.trim().length>0&&(e=this.initData.productIds.trim()),this.tableConfigList[0].apiObj.params.productIds=e},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=l(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(e){this.rowTableList=[],Array.isArray(e)&&(this.rowTableList=e)},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},updateData:function(e){this.$refs.customBaseTable.updateData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},closeDialog:function(e){"{}"!=JSON.stringify(e)&&(this.warehouse.id=e.id,this.warehouse.name=e.pathName),this.inLinVisible=!1,this.showDialog=!1},selectWarehouse:function(){var e=this.sourceWarehouseId;this.dialogData.warehouseIds=e,this.dialogData.title="选择库位",this.openDialogName="dialogWarehouseBySimple",this.showDialog=!0,this.inLinVisible=!0},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkValueNumber:function(e,t){var i="";return null==e||0==e.trim().length?i=t+"为空或空字符串！":null!=e&&e.trim().length>0&&!this.isNumberByValue(e.trim())&&(i=t+"("+e+")输入错误，请输入大于零的正整数或(1,2)位小数！"),i},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i],n="";null!=a.moveCount&&a.moveCount.trim().length>0&&(n=a.moveCount.trim()+"");var o="0";null!=a.stockCount&&a.stockCount.trim().length>0&&(o=a.stockCount.trim()+"");var s=this.checkValueNumber(n,"移库数量");null!=s&&s.trim().length>0?t=t+"第 "+(i+1)+" 行: "+s:n-o>0&&(t=t+"第 "+(i+1)+" 行: 移库数量不可大于库存数量！")}return t},save:function(){var e=this;if(null!=this.warehouse.name&&0!=this.warehouse.name.trim().length)if(this.$refs.customBaseTable.getData(),null!=this.rowTableList&&0!=this.rowTableList.length){var t=this.checkColumn(this.rowTableList);if(null!=t&&t.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:t});else{var i=[];this.rowTableList.forEach(function(e){var t={warehouseProductId:e.id,count:e.moveCount};i.push(t)});var a="";i.length>0&&(a=JSON.stringify(i)),Object(s.addWarehouseMoveBySimple)({targetWarehouseId:this.warehouse.id,dtlJsonStr:a}).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(e){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"无盘点货品信息！"});else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择目标仓库，目标仓库为必填项不可为空！"})}}},d=i("KHd+"),c=Object(d.a)(r,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("el-row",{staticStyle:{width:"300px","margin-top":"15px","margin-left":"2%"}},[i("b",[e._v("目标仓库:")]),e._v(" "),i("el-input",{attrs:{value:e.warehouse.name,placeholder:"请选择",disabled:!0,clearable:!0}},[i("el-button",{attrs:{slot:"append",icon:"el-icon-search"},on:{click:e.selectWarehouse},slot:"append"})],1)],1),e._v(" "),i("el-row",{style:e.initData.table_style},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)},[],!1,null,null,null);c.options.__file="dialogAdd.vue";t.default=c.exports},IfZh:function(e,t,i){"use strict";i.d(t,"b",function(){return n}),i.d(t,"a",function(){return o}),i.d(t,"c",function(){return s});var a=i("t3Un");function n(e){return Object(a.a)({url:"/warehouse/warehouseInDispatch/listPageWarehouseInDetail",method:"post",data:e})}function o(e){return Object(a.a)({url:"/warehouse/warehouseInDispatch/findWarehouseListByWarehouseIn",method:"post",data:e})}function s(e){return Object(a.a)({url:"/warehouse/warehouseInDispatch/updateWarehouseInDispatch",method:"post",data:e})}},"T/cP":function(e,t,i){"use strict";var a=i("xQNa");i.n(a).a},YcSE:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d");var a=i("K3g7"),n=i("IfZh"),o=i("z0WU"),s=i("mSNy");function l(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}function r(e){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var d={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{queryType:null,productId:"",productType:"",warehouseIds:"",dialogLoading:!1,isVisible:!1,inDialog:!0,tempLable:{},tempQuery:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},BaseTableLoading:!1,tableData:[],selectList:[],configs:{tableConfigs:[],isSingle:!0,showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1,resState:null}},created:function(){var e=this.initData.temp;this.productId=e.productId,this.productType=e.productType,this.warehouseIds=this.initData.warehouseIds,this.initTree()},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=r(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,name:e.nodeData.name},this.pageNo=1,this.radioChange()},initTree:function(){var e=this;this.dialogLoading=!0;var t=this;Object(a.treeWarehouse)({isSimple:"Y",notInWarehouseIds:this.warehouseIds}).then(function(e){var i=[],a=e.result.treeList;t.selectTree={pid:a.pid,id:a.id,name:a.name},i.push(a),t.treeData=i,t.initTable(null,null,null,null,null),t.$nextTick(function(){t.$refs.tree.$children[0].setCurrentKey(t.selectTree.id)})}).catch(function(t){e.dialogLoading=!1})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(o.m)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==s.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==s.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}})},addTableTitle:function(e){return e.forEach(function(e){var t=e.label;t.indexOf("_")>0&&("en"==s.a.locale?e.label=t.substring(t.indexOf("_")+1):"zh"==s.a.locale&&(e.label=t.substring(0,t.indexOf("_"))))}),e},initTable:function(e,t,i,a,o){var s=this;null!=t&&0!=t.trim().length||(t=""),null!=i&&0!=i.trim().length||(i=""),null!=a&&0!=a.trim().length||(a=""),null!=o&&0!=o.trim().length||(o=""),e&&(this.BaseTableLoading=!0),Object(n.a)(function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){l(e,t,i[t])})}return e}({},this.tempQuery,{isSimple:"Y",notInWarehouseIds:this.warehouseIds,nodeId:t,productId:i,productType:a,isExistProd:o,pageNo:this.pageNo})).then(function(t){s.getListPage(t),s.dialogLoading=!1,e&&(s.BaseTableLoading=!1)}).catch(function(e){s.dialogLoading=!1,s.BaseTableLoading=!1})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},radioChange:function(){var e="",t="",i="";"productId"==this.queryType?(e=this.productId,i="true"):"productType"==this.queryType?(t=this.productType,i="true"):"warehouseId"==this.queryType&&(i="false");var a="";null!=this.selectTree&&null!=this.selectTree.id&&this.selectTree.id.trim().length>0&&(a=this.selectTree.id.trim()),this.initTable(!0,a,e,t,i)},dataBridge:function(e){if(null!=e&&e.length>0){var t=e[0];t.pageName="dialogChangeWarehouseByIn",this.selectList.push(t)}},save:function(){var e={id:this.selectList[0].id,pathName:this.selectList[0].pathName};this.dialogClose(e),this.isVisible=!1}},watch:{pageNo:function(){this.initTable()}}},c=(i("T/cP"),i("KHd+")),h=Object(c.a)(d,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1),e._v(" "),i("el-col",{attrs:{span:20}},[i("div",{staticClass:"tableContent",staticStyle:{"margin-left":"10px"}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.BaseTableLoading,expression:"BaseTableLoading"}],staticStyle:{height:"400px"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,isSingle:e.configs.isSingle,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)]),e._v(" "),i("el-row",{staticStyle:{height:"100px","text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)],1)},[],!1,null,null,null);h.options.__file="dialogWarehouseBySimple.vue";t.default=h.exports},q7oa:function(e,t,i){"use strict";var a=i("D2yE");i.n(a).a},xQNa:function(e,t,i){}}]);