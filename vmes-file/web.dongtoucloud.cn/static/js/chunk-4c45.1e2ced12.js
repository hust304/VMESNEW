(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4c45","chunk-336d","6nQq"],{"2+ib":function(t,e,i){"use strict";i("dRSK"),i("INYr"),i("91GP"),i("Vd3H"),i("rGqo"),i("f3/d"),i("xfY5");var n=i("4Q6Z"),a=i("z0WU"),o=i("DKCI"),s=i("50Ol"),l=i("F9dT"),r=(i("Yfch"),i("YP4+")),c=i("WwWg"),d=(i("evdt"),i("mwzG")),u={name:"multilevel-table",mixins:[n.a],provide:function(){return{rootVm:this}},props:{expand:[Boolean],expandMode:[String],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,showColList:"",headerWidthList:[],listLength:-1,restaurants:[],debounce:300,fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:o.a,customSummaryOption:s.a},computed:{setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer,defaultSpacingClass:!this.layer&&this.maxLayer>1,noSpacingClass:this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return!!this.layer&&(!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2))}},created:function(){var t=this;if(console.log(this.layer,"created"),!this.layer)if(this.guid=Object(a.a)(),this.userInfo=this.$storage.get("userInfo"),Object(c.c)(this),this.initData.result){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var e=JSON.parse(JSON.stringify(d.a));t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:e,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.initLoading=!1},1e3):this.httpRequests());this.layer&&(console.log("test"),this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.tableData[this.dataName].forEach(function(t){t.rowState="1"}),this.setDragTable&&this.setSort(),this.initLoading=!1,this.tableDoLayout()):(console.log("test"),this.$emit("narrow-row",this.parentData[0]),this.initLoading=!1,this.tableDoLayout()))},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){var t=this;
//!this.layer && unCreateStore(this.$store, this.guid)
this.tempCheckedList.forEach(function(e){t.$store.commit(t.setGuid+"/DELETE_CHECKED",[e])})},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay()},initData:function(){var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1},resetContentWidthList:function(){var t=this,e=this.resetContentWidthList.map(function(t){return null});this.resetContentWidthList.forEach(function(i,n){t.useMiddleValue=!1,e[n]=t.contentWidthAlgorithm(i.map(function(t){return Math.max.apply(null,t)})),t.useMiddleValueList[n]=t.useMiddleValue}),e.forEach(function(e,i){t.contentWidthList[i]=e?e+26:null}),console.log(e,this.contentWidthList,this.useMiddleValueList,this.contentTitleWidthList)}},methods:{contentWidthAlgorithm:function(t){if(t&&t.length){if(t.length>1){var e=Math.max.apply(null,t);if(e-Math.min.apply(null,t)>this.setWidthDiffValue){var i,n=[].concat(t);return n.sort(a.d),i=n.length%2==0?(n[n.length/2-1]+n[n.length/2])/2:n[(n.length+1)/2-1],this.useMiddleValue=!0,e-i>this.setWidthDiffValue&&(i=2*this.setWidthDiffValue),i}return e}return t[0]}return null},databridge:function(t,e){this.$emit("databridge",t,e)},expandChange:function(t,e){var i=this;"one"===this.setExpandMode&&e.forEach(function(i,n){t._internalId!==i._internalId&&e.splice(n,1)}),this.$refs.baseTable.$nextTick(function(t){i.$refs.baseTable&&i.$refs.baseTable.doLayout&&i.$refs.baseTable.doLayout(),i.$emit("table-dolayout")})},setRowExpansion:function(t,e){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(t,e)},httpRequests:function(t){var e=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:t||1},this.searchObj)).then(function(i){e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:i,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1,t&&(e.pageNo=t,e.scrollTable())}).catch(function(t){console.log(t),e.initLoading=!1})},httpChildrenRequests:function(t,e){var i=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:e||1},this.setParams(t,this.setApiObj),this.setDynaValue(t))).then(function(n){i.$store.commit(i.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:n,row:t,vm:i}),i.setDragTable&&i.setSort(),i.pageNo=i.tableData[i.dataName].pageData&&i.tableData[i.dataName].pageData.current||1,i.initLoading=!1,i.tableDoLayout(),console.log("initLoading---\x3e",i.initLoading),e&&i.scrollTable()}).catch(function(t){console.log(t),i.initLoading=!1})},selectItem:function(t,e){console.log(t,e),t.findIndex(function(t){return t._internalId===e._internalId})>-1?(this.tempCheckedList.push(e),this.$store.commit(this.setGuid+"/ADD_CHECKED",[e])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[e]),this.tempCheckedList=this.tempCheckedList.filter(function(t){return t._internalId!==e._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:t.length?"0":"1"}),t.length?(this.tableData[this.dataName].forEach(function(t){t.rowState="0"}),t[0].rowState="1"):this.tableData[this.dataName].forEach(function(t){t.rowState="1"}))},selectAllItem:function(t){if(console.log(t),this.setIsSingle){if(t.length)for(var e=t.length-1;e>=0;e--)t.splice(e,1)}else t.length?(this.tempCheckedList=t.map(function(t){return t}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(t){t!==this.pageNo&&this.httpRequests(t)},setDynaValue:function(t){if(this.setDynamicValue){var e={};for(var i in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(i)&&(e[i]=Object(l.c)([this.setDynamicValue[i]],t,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return console.log(e),e}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setCellStyle:function(t){return this.setExpand&&2===this.maxLayer&&"1"===this.setExpandColumnWidth?{"border-bottom":"none","background-color":"inherit"}:{"background-color":"inherit"}},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(t,e){var i=this;return e&&t?(this.resultTableData=(t.tableData||t.children).find(function(t){if(t._internalId===e)return!0;if(t.children&&t.children.length){var n={titleList:t.titleList,children:t.children,pageData:t.pageData||{}};i.resultTableData=i.searchTableData(n,e)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(t){this.$emit("callmethod",t)},tableDoLayout:function(){var t=this;this.$nextTick(function(e){t.$refs.baseTable&&t.$refs.baseTable.doLayout&&t.$refs.baseTable.doLayout(),t.$emit("table-dolayout")})}}},p=(i("q7oa"),i("KHd+")),h=Object(p.a)(u,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.setTableLoading,expression:"setTableLoading"}],staticClass:"myCoustomTable resetCoustomTableStyle",class:t.setTableClass},[t.setShowTableSet?i("table-filter",{attrs:{headerList:t.setColConfigs,storeId:t.pageId,componentId:t.setComponentId,showAll:t.setShowAll},on:{"checked-list":t.checkedList,"checked-height":t.checkedHeight}}):t._e(),t._v(" "),i("div",{style:{height:t.setTableHeight}},[i("el-form",{ref:"ruleForm",style:{height:t.layer?"auto":"100%"},attrs:{model:t.ruleForm,"status-icon":""},nativeOn:{submit:function(t){t.preventDefault()}}},[i("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:t.tableData[t.dataName],stripe:!t.setExpand||"50"===t.setExpandColumnWidth,"highlight-current-row":"",border:t.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:t.layer?null:"100%",fit:"","show-header":t.setShowHeader,"row-key":"_internalId","show-summary":t.setSysSummary,"default-expand-all":!t.setShowExpandBtn&&t.setExpand&&"all"===t.setExpandMode,"header-row-style":t.setHeaderRowStyle,"row-style":t.setRowStyle,"row-class-name":t.setRowClass,"cell-style":t.setCellStyle,"header-row-class-name":t.setHeaderRowClass,"default-sort":t.setSortableConfig["default-sort"]},on:{select:t.selectItem,"select-all":t.selectAllItem,"selection-change":t.selectionChange,"expand-change":t.expandChange,"sort-change":t.sortChange,"row-click":t.rowClick,"row-dblclick":t.rowDblclick}},[t.setExpand?[i("el-table-column",{attrs:{type:"expand",width:t.setExpandColumnWidth,align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("multilevel-table",{attrs:{tableConfigList:t.tableConfigList,layer:t.layer+1,internalGuid:t.setGuid,parentData:[e.row],rowChain:t.setRowChain},on:{databridge:t.databridge,callmethod:t.callParentMethod,"table-dolayout":t.tableDoLayout,"narrow-row":t.narrowRow}})]}}])})]:t._e(),t._v(" "),t.setShowCheckBox?[i("el-table-column",{attrs:{type:"selection",fixed:t.setFixedState,selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.setShowIndex?[i("el-table-column",{attrs:{type:"index",index:t.indexMethod,fixed:t.setFixedState,label:"序号",width:"50",align:"center"}})]:t._e(),t._v(" "),t._l(t.setTitleList,function(e,n){return[e.slot&&e._isShow?t._t(e.slot,null,{fixed:t.setFixedList[n]}):Array.isArray(e.component)&&e._isShow?[i("el-table-column",t._b({key:n,attrs:{"show-overflow-tooltip":"",fixed:t.setFixedList[n],width:t.setColumnWidth[e.prop]||null,align:"center"},scopedSlots:t._u([{key:"header",fn:function(a){return[i("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:n,isComponent:!0,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[t._v("\n                  "+t._s(e.label)+"\n                ")])]}},{key:"default",fn:function(n){return["button"===e.componentName?i("div",{directives:[{name:"button-width",rawName:"v-button-width",value:e,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":t.setColumnWidth[e.prop]?"space-between":"center"}},t._l(e.component,function(e,a){return void 0!==e.editBtns_isShow&&!e.editBtns_isShow||!e.rowState||t.setButtonState(n.$index,n.row,e)?i("el-button",{key:a,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(t){e.method(n.row,n.$index,n)}}},[t._v(t._s(e.name)+"\n                  ")]):t._e()}),1):t._e()]}}])},"el-table-column",e,!1))]:"object"==typeof e.component&&e._isShow?i(e.component,{key:n,tag:"component",attrs:{"col-config":e,fixed:t.setFixedList[n]}}):[e._isShow?i("el-table-column",{key:n,attrs:{"show-overflow-tooltip":"",label:e.label,prop:e.prop||e.columnIndex,width:e.width||t.constantWidth[e.componentName]||"auto","min-width":e["min-width"]||t.contentWidthList[n]||"none",sortable:!!t.setSortableConfig[e.prop||e.columnIndex],"sort-method":t.setSortableConfig[e.prop||e.columnIndex]&&t.setSortableConfig[e.prop||e.columnIndex]["sort-method"]?t.setSortableConfig[e.prop||e.columnIndex]["sort-method"]:null,"sort-by":t.setSortableConfig[e.prop||e.columnIndex]&&t.setSortableConfig[e.prop||e.columnIndex]["sort-by"]?t.setSortableConfig[e.prop||e.columnIndex]["sort-by"]:null,fixed:t.setFixedList[n],align:"center"},scopedSlots:t._u([{key:"header",fn:function(a){return[i("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:n,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"}],style:{display:e._isShow?"inline-flex":"none"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(a){return[e.mergeTitles&&e.mergeTitles.length?[t._l(e.mergeTitles,function(o,s){return[o.componentName?["input"===o.componentName?[o._cellConfig.asyn?[i("el-form-item",{key:s,attrs:{prop:"tableData."+a.$index+"."+o.prop,rules:t.baseRules(a.$index,a.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-autocomplete",{attrs:{_scope:a,"child-colconfig":o,debounce:t.debounce}})],1)])]:[i("el-form-item",{key:s,attrs:{prop:"tableData."+a.$index+"."+o.prop,rules:t.baseRules(a.$index,a.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-input",{attrs:{_scope:a,"child-colconfig":o}})],1)])]]:"date"===o.componentName?[i("el-form-item",{key:a.row._internalId,attrs:{prop:"tableData."+a.$index+"."+o.prop,rules:t.baseRules(a.$index,a.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-date-picker",{attrs:{_scope:a,"child-colconfig":o}})],1)])]:"time"===o.componentName?[i("el-form-item",{key:a.row._internalId,attrs:{prop:"tableData."+a.$index+"."+o.prop,rules:t.baseRules(a.$index,a.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-time-picker",{attrs:{_scope:a,"child-colconfig":o}})],1)])]:"select"===o.componentName?[i("el-form-item",{key:a.row._internalId,attrs:{prop:"tableData."+a.$index+"."+o.prop,rules:t.baseRules(a.$index,a.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-select",{attrs:{_scope:a,"child-colconfig":o}})],1)])]:"cascader"===o.componentName?[i("el-form-item",{key:a.row._internalId,attrs:{prop:"tableData."+a.$index+"."+o.prop,rules:t.baseRules(a.$index,a.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-cascader",{attrs:{_scope:a,"child-colconfig":o}})],1)])]:"switch"===o.componentName?[i("div",{on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[o._cellConfig.hideTitle?t._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[t._v("\n                            "+t._s(o.label+":")+" \n                          ")]),t._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-switch",{attrs:{_scope:a,"child-colconfig":o}})],1)])]:"dateTime"===o.componentName?[i("el-form-item",{key:a.row._internalId,attrs:{prop:"tableData."+a.$index+"."+o.prop,rules:t.baseRules(a.$index,a.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-date-time",{attrs:{_scope:a,"child-colconfig":o}})],1)])]:"inputNumber"===o.componentName?[i("el-form-item",{key:a.row._internalId,attrs:{prop:"tableData."+a.$index+"."+o.prop,rules:t.baseRules(a.$index,a.row,o),"inline-message":!0}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-input-number",{attrs:{_scope:a,"child-colconfig":o}})],1)])]:"steps"===o.componentName?[i("div",{key:s,staticClass:"resetElStepStyle",on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[o._cellConfig.hideTitle?t._e():i("div",{style:o._cellConfig.titleStyle||{}},[t._v("\n                            "+t._s(o.label+":")+" \n                          ")]),t._v(" "),i("div",[i("custom-steps",{attrs:{_scope:a,"child-colconfig":o}})],1)])]:"progress"===o.componentName?[i("div",{key:s,staticStyle:{"text-align":"left"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[o._cellConfig.hideTitle?t._e():i("div",{staticStyle:{display:"inline-block"},style:[{"line-height":o._cellConfig.componentConfig["stroke-width"]>23?2:""},o._cellConfig.titleStyle||(t.setColumnGlobalStyle?t.setColumnGlobalStyle.titleStyle:{})||{}]},[t._v("\n                            "+t._s(o.label+":"+(o._cellConfig.componentConfig.showInitValue?a.row[o.prop]:""))+" \n                          ")]),t._v(" "),i("div",{staticClass:"resetProgressStyle",staticStyle:{display:"inline-block",overflow:"hidden","vertical-align":"middle"},style:{width:(o._cellConfig.componentConfig.width||t.constantWidth[o.componentName])+"px"}},[i("table-progress",{attrs:{_scope:a,"child-colconfig":o}})],1)])]:"upload"===o.componentName?[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-upload",{attrs:{_scope:a,"child-colconfig":o}})],1)]:"tag"===o.componentName?[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-tag",{attrs:{_scope:a,"child-colconfig":o}})],1)]:"button"===o.componentName?[o._cellConfig.hideTitle?t._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[t._v("\n                          "+t._s(o.label+":")+" \n                        ")]),t._v(" "),i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("table-button",{attrs:{_scope:a,"child-colconfig":o}})],1)]:[i("span",{key:s,staticStyle:{"margin-left":"10px"},domProps:{textContent:t._s(a.row[o.prop])}})]]:[i("div",{key:s,style:{"text-align":o._cellConfig&&o._cellConfig.hideTitle?"center":"left"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[o._cellConfig?[o._cellConfig.hideTitle?t._e():[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:n,cIndex:s,colConfig:e,childColconfig:o,rowIndex:a.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:[o._cellConfig.titleStyle||(t.setColumnGlobalStyle?t.setColumnGlobalStyle.titleStyle:{}),t.setMiddleValue[n]?t.setMiddleValue[n].title:{}],domProps:{textContent:t._s(o.label+":")}},[t._v(" ")])]]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:n,cIndex:s,colConfig:e,childColconfig:o,rowIndex:a.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:t.setMiddleValue[n]?t.setMiddleValue[n].title:{},domProps:{textContent:t._s(o.label+":")}},[t._v(" ")])],t._v(" "),o._cellConfig&&o._cellConfig.events?[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:n,cIndex:s,colConfig:e,childColconfig:o,rowIndex:a.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"}],style:[o._cellConfig.bodyStyle||(t.setColumnGlobalStyle?t.setColumnGlobalStyle.bodyStyle:{}),t.setMiddleValue[n]?t.setMiddleValue[n].body:{}]},[i("a",{domProps:{textContent:t._s(a.row[o.prop])},on:{click:function(e){t.mergeColumnEvents(o,a)}}})])]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:n,cIndex:s,colConfig:e,childColconfig:o,rowIndex:a.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"},{name:"content-set",rawName:"v-content-set",value:{config:o,row:a.row},expression:"{config: childColconfig,row: scope.row}"}],class:{resetContent:t.setMiddleValue[n],ellipsis:!!t.setMiddleValue[n]&&t.isEllipsis(a.row[o.prop||o.columnIndex],parseInt(t.setMiddleValue[n].body.width))},style:[o._cellConfig?o._cellConfig.bodyStyle:{},t.setColumnGlobalStyle?t.setColumnGlobalStyle.bodyStyle:{},t.setMiddleValue[n]?t.setMiddleValue[n].body:{}],domProps:{textContent:t._s(a.row[o.prop||o.columnIndex])}})]],2)]]})]:[i("div",{style:{display:e._isShow?"inline-block":"none"},domProps:{textContent:t._s(a.row[e.prop])}})]]}}])}):t._e()]]}),t._v(" "),t.setDragTable?[i("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[i("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[i("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)])]}}])})]:t._e()],2)],1),t._v(" "),t.setUseSummary&&t.setCustomSummary.component?[i("custom-summary-option",{attrs:{customSummary:t.setCustomSummary,tempData:t.setTempData,tableData:t.tableData[t.dataName]},on:{"send-height":t.customSummaryHeight,"custom-summary-value":t.customSummaryValue}})]:t._e()],2),t._v(" "),t.setHidePages?t._e():i("div",{staticStyle:{"text-align":"center"},style:{"padding-top":(t.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[i("el-pagination",{attrs:{background:"","current-page":t.tableData.pageData.current,"page-size":t.tableData.pageData.size,layout:"prev, pager, next, jumper",total:t.tableData.pageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.tableData.pageData,"current",e)}}})],1)],1)},[],!1,null,null,null);h.options.__file="index.vue";e.a=h.exports},"6nQq":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var n=i("cTe8");function a(t){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={name:"dialog-edit",props:["initData","visible"],data:function(){return{orderId:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{remark:[{required:!0,message:"请填写退回原因！",trigger:"change"}]}}},created:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=a(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(n.rebackPurchasePlan)({id:t.initData.temp.id,remark:t.temp.remark}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"退回成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1}))})}}},s=i("KHd+"),l=Object(s.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"100%",padding:"10px"},attrs:{rules:t.rules,model:t.temp,"label-position":"left","label-width":"100px"}},[i("el-form-item",{attrs:{label:"退回原因:",prop:"remark"}},[i("el-input",{attrs:{type:"textarea",rows:2},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);l.options.__file="dialogRebackBill.vue";e.default=l.exports},"9Jys":function(t,e,i){"use strict";i.r(e);i("rGqo");var n=i("2+ib"),a=i("uTIz"),o=i("6nQq"),s=i("Vobf"),l=i("cTe8"),r={components:{dialogRebackBill:o.default,multilevelTable:n.a,searchBar:a.a},data:function(){return{configs:{topBarBtnList:[{name:"审核通过",nameEn:"auditPlan",isShow:!0,state:!1,icon:"save",method:this.auditPlan}]},searchList:[{label:"计划号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入计划号"},{label:"经办人",type:"input",ruleType:"string",mapKey:"makeName",configs:{},placeholder:"请输入经办人"},{label:"状态",type:"select",ruleType:"number",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"待执行"},{value:"3",label:"执行中"},{value:"4",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"请输入货品名称"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"4",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"待执行"},info1:{state:"3",text:"执行中"},default:{state:"0",text:"待提交"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"退回",nameEn:"reback",editBtns_isShow:!0,icon:"reback",method:this.reback}]}],apiObj:{apiName:"listPagePurchasePlans",params:{state:"1",orderStr:"  plan.code desc "}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"4",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"待执行"},info1:{state:"3",text:"执行中"},default:{state:"0",text:"待提交"}}}],apiObj:{apiName:"listPagePurchasePlanDetails",params:{}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],selectList:[],searchObj:{},temp:{},tempLable:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.selectList=[],this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"云上企业"}),Object(s.initMenuButtons)({menuId:i,roleId:e}).then(function(e){t.$loading().close();var i=e.buttonList;i&&i.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)})),t.tableConfigList&&t.tableConfigList.forEach(function(t){t.customColumn&&t.customColumn.forEach(function(t){"last"==t.columnIndex&&t.component&&t.component.forEach(function(t){t.nameEn==e.nameEn&&(t.rowState="1==2")})})})})}).catch(function(e){console.log(e),t.$loading().close()}))},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(this.searchObj)},databridge:function(t){this.selectList=t;var e=0;if(t.length)for(var i=0;i<t.length;i++){"1"!=t[i].state&&(e+=1)}else this.configs.topBarBtnList.forEach(function(t){"auditPlan"==t.nameEn&&(t.state=!1)});e>0?this.configs.topBarBtnList.forEach(function(t){"auditPlan"==t.nameEn&&(t.state=!0)}):this.configs.topBarBtnList.forEach(function(t){"auditPlan"==t.nameEn&&(t.state=!1)})},reback:function(t,e){this.dialogData.temp=JSON.parse(JSON.stringify(t)),this.dialogData.title="审核退回",this.openDialogName="dialogRebackBill",this.showDialog=!0,this.visible=!0},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},auditPlan:function(){var t=this,e=this,i="";e.selectList.forEach(function(t){"1"==t.state&&(i+=""==i?t.id:"','"+t.id)}),""!=i?e.$confirm("是否审核通过?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(l.auditPurchasePlan)(i).then(function(i){0===i.code&&(e.$notify({title:"成功",message:"审核成功",type:"success",duration:2e3}),t.updateData(t.searchObj))}).catch(function(t){console.log(t)})}):e.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条待审核状态的记录！"})},resetTemp:function(){for(var t in this.temp)this.temp[t]=""}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},c=(i("iS3U"),i("KHd+")),d=Object(c.a)(r,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"purchasePlan"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);d.options.__file="index.vue";e.default=d.exports},D2yE:function(t,e,i){},OvUn:function(t,e,i){},iS3U:function(t,e,i){"use strict";var n=i("OvUn");i.n(n).a},q7oa:function(t,e,i){"use strict";var n=i("D2yE");i.n(n).a}}]);