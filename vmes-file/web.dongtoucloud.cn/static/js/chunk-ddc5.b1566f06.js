(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-ddc5","chunk-336d"],{"2+ib":function(e,t,i){"use strict";i("dRSK"),i("INYr"),i("91GP"),i("Vd3H"),i("rGqo"),i("f3/d"),i("xfY5");var a=i("4Q6Z"),n=i("z0WU"),o=i("DKCI"),s=i("50Ol"),l=i("F9dT"),r=(i("Yfch"),i("YP4+")),c=i("WwWg"),d=(i("evdt"),i("mwzG")),u={name:"multilevel-table",mixins:[a.a],provide:function(){return{rootVm:this}},props:{expand:[Boolean],expandMode:[String],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,showColList:"",headerWidthList:[],listLength:-1,restaurants:[],debounce:300,fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:o.a,customSummaryOption:s.a},computed:{setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer,defaultSpacingClass:!this.layer&&this.maxLayer>1,noSpacingClass:this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return!!this.layer&&(!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2))}},created:function(){var e=this;if(!this.layer)if(this.guid=Object(n.a)(),this.userInfo=this.$storage.get("userInfo"),Object(c.c)(this),this.initData.result){var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var t=JSON.parse(JSON.stringify(d.a));e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:t,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1},1e3):this.httpRequests());this.layer&&(this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.tableData[this.dataName].forEach(function(e){e.rowState="1"}),this.setDragTable&&this.setSort(),this.initLoading=!1,this.tableDoLayout()):(this.$emit("narrow-row",this.parentData[0]),this.initLoading=!1,this.tableDoLayout()))},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){var e=this;
//!this.layer && unCreateStore(this.$store, this.guid)
this.tempCheckedList.forEach(function(t){e.$store.commit(e.setGuid+"/DELETE_CHECKED",[t])})},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay()},initData:function(){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1},resetContentWidthList:function(){var e=this,t=this.resetContentWidthList.map(function(e){return null});this.resetContentWidthList.forEach(function(i,a){e.useMiddleValue=!1,t[a]=e.contentWidthAlgorithm(i.map(function(e){return Math.max.apply(null,e)})),e.useMiddleValueList[a]=e.useMiddleValue}),t.forEach(function(t,i){e.contentWidthList[i]=t?t+26:null})}},methods:{contentWidthAlgorithm:function(e){if(e&&e.length){if(e.length>1){var t=Math.max.apply(null,e);if(t-Math.min.apply(null,e)>this.setWidthDiffValue){var i,a=[].concat(e);return a.sort(n.d),i=a.length%2==0?(a[a.length/2-1]+a[a.length/2])/2:a[(a.length+1)/2-1],this.useMiddleValue=!0,t-i>this.setWidthDiffValue&&(i=2*this.setWidthDiffValue),i}return t}return e[0]}return null},databridge:function(e,t){this.$emit("databridge",e,t)},expandChange:function(e,t){var i=this;"one"===this.setExpandMode&&t.forEach(function(i,a){e._internalId!==i._internalId&&t.splice(a,1)}),this.$refs.baseTable.$nextTick(function(e){i.$refs.baseTable&&i.$refs.baseTable.doLayout&&i.$refs.baseTable.doLayout(),i.$emit("table-dolayout")})},setRowExpansion:function(e,t){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(e,t)},httpRequests:function(e){var t=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:e||1},this.searchObj)).then(function(i){t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:i,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.initLoading=!1,e&&(t.pageNo=e,t.scrollTable())}).catch(function(e){console.log(e),t.initLoading=!1})},httpChildrenRequests:function(e,t){var i=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:t||1},this.setParams(e,this.setApiObj),this.setDynaValue(e))).then(function(a){i.$store.commit(i.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:a,row:e,vm:i}),i.setDragTable&&i.setSort(),i.pageNo=i.tableData[i.dataName].pageData&&i.tableData[i.dataName].pageData.current||1,i.initLoading=!1,i.tableDoLayout(),t&&i.scrollTable()}).catch(function(e){console.log(e),i.initLoading=!1})},selectItem:function(e,t){e.findIndex(function(e){return e._internalId===t._internalId})>-1?(this.tempCheckedList.push(t),this.$store.commit(this.setGuid+"/ADD_CHECKED",[t])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[t]),this.tempCheckedList=this.tempCheckedList.filter(function(e){return e._internalId!==t._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:e.length?"0":"1"}),e.length?(this.tableData[this.dataName].forEach(function(e){e.rowState="0"}),e[0].rowState="1"):this.tableData[this.dataName].forEach(function(e){e.rowState="1"}))},selectAllItem:function(e){if(this.setIsSingle){if(e.length)for(var t=e.length-1;t>=0;t--)e.splice(t,1)}else e.length?(this.tempCheckedList=e.map(function(e){return e}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(e){e!==this.pageNo&&this.httpRequests(e)},setDynaValue:function(e){if(this.setDynamicValue){var t={};for(var i in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(i)&&(t[i]=Object(l.c)([this.setDynamicValue[i]],e,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return t}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setCellStyle:function(e){return this.setExpand&&2===this.maxLayer&&"1"===this.setExpandColumnWidth?{"border-bottom":"none","background-color":"inherit"}:{"background-color":"inherit"}},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(e,t){var i=this;return t&&e?(this.resultTableData=(e.tableData||e.children).find(function(e){if(e._internalId===t)return!0;if(e.children&&e.children.length){var a={titleList:e.titleList,children:e.children,pageData:e.pageData||{}};i.resultTableData=i.searchTableData(a,t)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(e){this.$emit("callmethod",e)},tableDoLayout:function(){var e=this;this.$nextTick(function(t){e.$refs.baseTable&&e.$refs.baseTable.doLayout&&e.$refs.baseTable.doLayout(),e.$emit("table-dolayout")})}}},h=(i("q7oa"),i("KHd+")),p=Object(h.a)(u,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.setTableLoading,expression:"setTableLoading"}],staticClass:"myCoustomTable resetCoustomTableStyle",class:e.setTableClass},[e.setShowTableSet?i("table-filter",{attrs:{headerList:e.setColConfigs,storeId:e.pageId,componentId:e.setComponentId,showAll:e.setShowAll},on:{"checked-list":e.checkedList,"checked-height":e.checkedHeight}}):e._e(),e._v(" "),i("div",{style:{height:e.setTableHeight}},[i("el-form",{ref:"ruleForm",style:{height:e.layer?"auto":"100%"},attrs:{model:e.ruleForm,"status-icon":""},nativeOn:{submit:function(e){e.preventDefault()}}},[i("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:e.tableData[e.dataName],stripe:!e.setExpand||"50"===e.setExpandColumnWidth,"highlight-current-row":"",border:e.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:e.layer?null:"100%",fit:"","show-header":e.setShowHeader,"row-key":"_internalId","show-summary":e.setSysSummary,"default-expand-all":!e.setShowExpandBtn&&e.setExpand&&"all"===e.setExpandMode,"header-row-style":e.setHeaderRowStyle,"row-style":e.setRowStyle,"row-class-name":e.setRowClass,"cell-style":e.setCellStyle,"header-row-class-name":e.setHeaderRowClass,"default-sort":e.setSortableConfig["default-sort"]},on:{select:e.selectItem,"select-all":e.selectAllItem,"selection-change":e.selectionChange,"expand-change":e.expandChange,"sort-change":e.sortChange,"row-click":e.rowClick,"row-dblclick":e.rowDblclick}},[e.setExpand?[i("el-table-column",{attrs:{type:"expand",width:e.setExpandColumnWidth,align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("multilevel-table",{attrs:{tableConfigList:e.tableConfigList,layer:e.layer+1,internalGuid:e.setGuid,parentData:[t.row],rowChain:e.setRowChain},on:{databridge:e.databridge,callmethod:e.callParentMethod,"table-dolayout":e.tableDoLayout,"narrow-row":e.narrowRow}})]}}])})]:e._e(),e._v(" "),e.setShowCheckBox?[i("el-table-column",{attrs:{type:"selection",fixed:e.setFixedState,selectable:e.selectable,width:"55",align:"center"}})]:e._e(),e._v(" "),e.setShowIndex?[i("el-table-column",{attrs:{type:"index",index:e.indexMethod,fixed:e.setFixedState,label:"序号",width:"50",align:"center"}})]:e._e(),e._v(" "),e._l(e.setTitleList,function(t,a){return[t.slot&&t._isShow?e._t(t.slot,null,{fixed:e.setFixedList[a]}):Array.isArray(t.component)&&t._isShow?[i("el-table-column",e._b({key:a,attrs:{"show-overflow-tooltip":"",fixed:e.setFixedList[a],width:e.setColumnWidth[t.prop]||null,align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[i("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:a,isComponent:!0,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[e._v("\n                  "+e._s(t.label)+"\n                ")])]}},{key:"default",fn:function(a){return["button"===t.componentName?i("div",{directives:[{name:"button-width",rawName:"v-button-width",value:t,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":e.setColumnWidth[t.prop]?"space-between":"center"}},e._l(t.component,function(t,n){return void 0!==t.editBtns_isShow&&!t.editBtns_isShow||!t.rowState||e.setButtonState(a.$index,a.row,t)?i("el-button",{key:n,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(e){t.method(a.row,a.$index,a)}}},[e._v(e._s(t.name)+"\n                  ")]):e._e()}),1):e._e()]}}])},"el-table-column",t,!1))]:"object"==typeof t.component&&t._isShow?i(t.component,{key:a,tag:"component",attrs:{"col-config":t,fixed:e.setFixedList[a]}}):[t._isShow?i("el-table-column",{key:a,attrs:{"show-overflow-tooltip":"",label:t.label,prop:t.prop||t.columnIndex,width:t.width||e.constantWidth[t.componentName]||"auto","min-width":t["min-width"]||e.contentWidthList[a]||"none",sortable:!!e.setSortableConfig[t.prop||t.columnIndex],"sort-method":e.setSortableConfig[t.prop||t.columnIndex]&&e.setSortableConfig[t.prop||t.columnIndex]["sort-method"]?e.setSortableConfig[t.prop||t.columnIndex]["sort-method"]:null,"sort-by":e.setSortableConfig[t.prop||t.columnIndex]&&e.setSortableConfig[t.prop||t.columnIndex]["sort-by"]?e.setSortableConfig[t.prop||t.columnIndex]["sort-by"]:null,fixed:e.setFixedList[a],align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[i("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:a,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"}],style:{display:t._isShow?"inline-flex":"none"},domProps:{textContent:e._s(t.label)}})]}},{key:"default",fn:function(n){return[t.mergeTitles&&t.mergeTitles.length?[e._l(t.mergeTitles,function(o,s){return[o.componentName?["input"===o.componentName?[o._cellConfig.asyn?[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[i("table-autocomplete",{attrs:{_scope:n,"child-colconfig":o,debounce:e.debounce}})],1)])]:[i("el-form-item",{key:s,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[i("table-input",{attrs:{_scope:n,"child-colconfig":o}})],1)])]]:"date"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[i("table-date-picker",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"time"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[i("table-time-picker",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"select"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[i("table-select",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"cascader"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[i("table-cascader",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"switch"===o.componentName?[i("div",{on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[e._v("\n                            "+e._s(o.label+":")+" \n                          ")]),e._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-switch",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"dateTime"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[i("table-date-time",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"inputNumber"===o.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[i("table-input-number",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"steps"===o.componentName?[i("div",{key:s,staticClass:"resetElStepStyle",on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[o._cellConfig.hideTitle?e._e():i("div",{style:o._cellConfig.titleStyle||{}},[e._v("\n                            "+e._s(o.label+":")+" \n                          ")]),e._v(" "),i("div",[i("custom-steps",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"progress"===o.componentName?[i("div",{key:s,staticStyle:{"text-align":"left"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:[{"line-height":o._cellConfig.componentConfig["stroke-width"]>23?2:""},o._cellConfig.titleStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.titleStyle:{})||{}]},[e._v("\n                            "+e._s(o.label+":"+(o._cellConfig.componentConfig.showInitValue?n.row[o.prop]:""))+" \n                          ")]),e._v(" "),i("div",{staticClass:"resetProgressStyle",staticStyle:{display:"inline-block",overflow:"hidden","vertical-align":"middle"},style:{width:(o._cellConfig.componentConfig.width||e.constantWidth[o.componentName])+"px"}},[i("table-progress",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"upload"===o.componentName?[i("div",{staticStyle:{display:"inline-block"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[i("table-upload",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"tag"===o.componentName?[i("div",{staticStyle:{display:"inline-block"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[i("table-tag",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"button"===o.componentName?[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[e._v("\n                          "+e._s(o.label+":")+" \n                        ")]),e._v(" "),i("div",{staticStyle:{display:"inline-block"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[i("table-button",{attrs:{_scope:n,"child-colconfig":o}})],1)]:[i("span",{key:s,staticStyle:{"margin-left":"10px"},domProps:{textContent:e._s(n.row[o.prop])}})]]:[i("div",{key:s,style:{"text-align":o._cellConfig&&o._cellConfig.hideTitle?"center":"left"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[o._cellConfig?[o._cellConfig.hideTitle?e._e():[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:[o._cellConfig.titleStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.titleStyle:{}),e.setMiddleValue[a]?e.setMiddleValue[a].title:{}],domProps:{textContent:e._s(o.label+":")}},[e._v(" ")])]]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:e.setMiddleValue[a]?e.setMiddleValue[a].title:{},domProps:{textContent:e._s(o.label+":")}},[e._v(" ")])],e._v(" "),o._cellConfig&&o._cellConfig.events?[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"}],style:[o._cellConfig.bodyStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.bodyStyle:{}),e.setMiddleValue[a]?e.setMiddleValue[a].body:{}]},[i("a",{domProps:{textContent:e._s(n.row[o.prop])},on:{click:function(t){e.mergeColumnEvents(o,n)}}})])]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:s,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"},{name:"content-set",rawName:"v-content-set",value:{config:o,row:n.row},expression:"{config: childColconfig,row: scope.row}"}],class:{resetContent:e.setMiddleValue[a],ellipsis:!!e.setMiddleValue[a]&&e.isEllipsis(n.row[o.prop||o.columnIndex],parseInt(e.setMiddleValue[a].body.width))},style:[o._cellConfig?o._cellConfig.bodyStyle:{},e.setColumnGlobalStyle?e.setColumnGlobalStyle.bodyStyle:{},e.setMiddleValue[a]?e.setMiddleValue[a].body:{}],domProps:{textContent:e._s(n.row[o.prop||o.columnIndex])}})]],2)]]})]:[i("div",{style:{display:t._isShow?"inline-block":"none"},domProps:{textContent:e._s(n.row[t.prop])}})]]}}])}):e._e()]]}),e._v(" "),e.setDragTable?[i("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[i("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)])]}}])})]:e._e()],2)],1),e._v(" "),e.setUseSummary&&e.setCustomSummary.component?[i("custom-summary-option",{attrs:{customSummary:e.setCustomSummary,tempData:e.setTempData,tableData:e.tableData[e.dataName]},on:{"send-height":e.customSummaryHeight,"custom-summary-value":e.customSummaryValue}})]:e._e()],2),e._v(" "),e.setHidePages?e._e():i("div",{staticStyle:{"text-align":"center"},style:{"padding-top":(e.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[i("el-pagination",{attrs:{background:"","current-page":e.tableData.pageData.current,"page-size":e.tableData.pageData.size,layout:"prev, pager, next, jumper",total:e.tableData.pageData.total-0},on:{"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.tableData.pageData,"current",t)}}})],1)],1)},[],!1,null,null,null);p.options.__file="index.vue";t.a=p.exports},D2yE:function(e,t,i){},Yw29:function(e,t,i){"use strict";i.r(t);i("f3/d"),i("rGqo");var a=i("uTIz"),n=i("2+ib"),o=i("K3g7"),s=i("R1DK"),l=i("Vobf"),r=(i("z0WU"),{components:{searchBar:a.a,multilevelTable:n.a},data:function(){return{guid:"",searchList:[{label:"货品编码",type:"input",mapKey:"code",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入货品名称"},{label:"货品属性",type:"select",ruleType:"string",mapKey:"genreName",configs:{clearable:!0,name:"",options:[{value:"成品",label:"成品"},{value:"半成品",label:"半成品"},{value:"原材料",label:"原材料"},{value:"辅料",label:"辅料"},{value:"备件",label:"备件"}]},placeholder:"请选择"},{label:"货品类型",type:"input",ruleType:"string",mapKey:"typeName",configs:{},placeholder:"请输入货品类型"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"spec",configs:{},placeholder:"请输入规格型号"},{label:"库存数量",type:"select",ruleType:"number",mapKey:"orderByStock",configs:{clearable:!0,name:"",options:[{value:0,label:"由多到少"},{value:1,label:"由少到多"}]},placeholder:"请选择"},{label:"安全库存",type:"select",ruleType:"number",mapKey:"isSafeStock",configs:{clearable:!0,name:"",options:[{value:1,label:"小于安全库存"},{value:2,label:"大于等于安全库存"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null,nodeId:null},configs:{topBarBtnList:[{name:"批量同步",nameEn:"synStockCountAll",isShow:!0,icon:"synStockCountAll",method:this.synStockCountAll}]},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableConfigList:[{customColumn:[{columnIndex:"stockCount",_cellConfig:{hideTitle:!0,contentSet:{state:{computed:"self@stockCount(-)self@safetyCount"},style:{color:'computed < 0 ? "#ff0000" : "inherit"'}}}}],apiObj:{apiName:"listPageWarehouseProductView",params:{isNeedVirtual:"true",isNotNeedSpare:"true"}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"手工调整库存",nameEn:"resetStock",editBtns_isShow:!0,icon:"resetStock",method:this.resetStock}]}],apiObj:{apiName:"listPageSimpleWarehouseDetailView",params:{fieldCode:"pathName,warehouseName,stockCount"}},dynamicValue:{productId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],searchObj:{isNeedVirtual:"true",isNotNeedSpare:"true"},selectList:[],temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},beforeCreate:function(){},created:function(){this.initButtons(),this.initTree()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{synStockCountAll:function(){var e=this;Object(s.updateSynStockCount)().then(function(t){0===t.code&&(e.$notify({title:"成功",message:"同步成功",type:"success",duration:2e3}),e.updateData(e.searchObj))}).catch(function(e){})},synStockCountByProduct:function(e,t){var i=this;Object(s.updateSynStockCount)(e).then(function(e){0===e.code&&(i.$notify({title:"成功",message:"同步成功",type:"success",duration:2e3}),i.updateData(i.searchObj))}).catch(function(e){})},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.searchObj.isNeedVirtual="true",this.searchObj.isNotNeedSpare="true",this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},searchMap:function(e){this.searchObj=e,this.tableConfigList[0].apiObj.params={warehouseId:this.selectTree.id},this.tableConfigList[1].apiObj.params={fieldCode:"pathName,warehouseName,stockCount",warehouseId:this.selectTree.id},this.updateData(this.searchObj)},sendGuid:function(e){this.guid=e},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&(this.tableConfigList[0].apiObj.params={warehouseId:this.selectTree.id},this.tableConfigList[1].apiObj.params={fieldCode:"pathName,warehouseName,stockCount",warehouseId:this.selectTree.id},this.updateData(this.searchObj))},initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,i=e.$storage.get("menuId");t&&(e.$loading({spinner:"none",text:"云上企业"}),Object(l.initMenuButtons)({menuId:i,roleId:t}).then(function(t){e.$loading().close();var i=t.buttonList;i&&i.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)})),e.tableConfigList&&e.tableConfigList.forEach(function(e){e.customColumn&&e.customColumn.forEach(function(e){"last"==e.columnIndex&&e.component&&e.component.forEach(function(e){e.nameEn==t.nameEn&&(e.rowState="1==2")})})})})}).catch(function(t){e.$loading().close()}))},initTree:function(){var e=this;Object(o.treeWarehouse)({isNeedVirtual:"true",isNotNeedSpare:"true"}).then(function(t){var i=[],a=t.result.treeList;e.selectTree={pid:a.pid,id:a.id,layer:a.layer,name:a.name,virtualGenre:a.virtualGenre},i.push(a),e.treeData=i,e.$nextTick(function(){e.$refs.tree.$children[0].setCurrentKey(e.selectTree.id)}),e.$loading().close()}).catch(function(t){e.$loading().close()})},treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,layer:e.nodeData.layer,name:e.nodeData.name,pathId:e.nodeData.pathId},this.pageNo=1,this.tableConfigList[0].apiObj.params={warehouseId:this.selectTree.id},this.tableConfigList[1].apiObj.params={warehouseId:this.selectTree.id},this.updateData(this.searchObj)},databridge:function(e){this.selectList=e}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),c=(i("e0SM"),i("KHd+")),d=Object(c.a)(r,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"warehouseBaseManage"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1),e._v(" "),i("el-col",{staticStyle:{height:"100%",position:"relative"},attrs:{span:20}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1)])],1),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);d.options.__file="index.vue";t.default=d.exports},e0SM:function(e,t,i){"use strict";var a=i("wR/4");i.n(a).a},q7oa:function(e,t,i){"use strict";var a=i("D2yE");i.n(a).a},"wR/4":function(e,t,i){}}]);