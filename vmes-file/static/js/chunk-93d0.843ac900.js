(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-93d0","chunk-336d"],{"2+ib":function(e,t,i){"use strict";i("dRSK"),i("INYr"),i("91GP"),i("Vd3H"),i("rGqo"),i("f3/d"),i("xfY5");var a=i("4Q6Z"),n=i("z0WU"),s=i("DKCI"),l=i("50Ol"),o=i("F9dT"),r=(i("Yfch"),i("YP4+")),d=i("WwWg"),c=(i("evdt"),i("mwzG")),h={name:"multilevel-table",mixins:[a.a],provide:function(){return{rootVm:this}},props:{initData:{type:Object,default:function(){return{}}},expand:[Boolean],expandMode:[String],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,showColList:"",headerWidthList:[],listLength:-1,restaurants:[],debounce:300,fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:s.a,customSummaryOption:l.a},computed:{setGlobalSingle:function(){return this.layerConfig.globalSingle||this.globalSingle||!1},setLayerSingle:function(){return this.layerConfig.layerSingle||this.layerSingle||!1},setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2)}},created:function(){var e=this;if(!this.layer)if(this.guid=Object(n.a)(),this.userInfo=this.$storage.get("userInfo"),Object(d.c)(this),this.initData.result){var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var t=JSON.parse(JSON.stringify(c.a));e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:t,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1},1e3):this.httpRequests());this.layer&&(this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.setDragTable&&this.setSort(),this.initLoading=!1):this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.initLoading=!1)},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){//!this.layer && unCreateStore(this.$store, this.guid)
},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay()},initData:function(){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1},resetContentWidthList:function(){var e=this,t=this.resetContentWidthList.map(function(e){return null});this.resetContentWidthList.forEach(function(i,a){e.useMiddleValue=!1,t[a]=e.contentWidthAlgorithm(i.map(function(e){return Math.max.apply(null,e)})),e.useMiddleValueList[a]=e.useMiddleValue}),t.forEach(function(t,i){e.contentWidthList[i]=t?t+26:null})}},methods:{contentWidthAlgorithm:function(e){if(e&&e.length){if(e.length>1){var t=Math.max.apply(null,e);if(t-Math.min.apply(null,e)>this.setWidthDiffValue){var i,a=[].concat(e);return a.sort(n.c),i=a.length%2==0?(a[a.length/2-1]+a[a.length/2])/2:a[(a.length+1)/2-1],this.useMiddleValue=!0,t-i>this.setWidthDiffValue&&(i=2*this.setWidthDiffValue),i}return t}return e[0]}return null},databridge:function(e,t){this.$emit("databridge",e,t)},expandChange:function(e,t){var i=this;"one"===this.setExpandMode&&t.forEach(function(i,a){e._internalId!==i._internalId&&t.splice(a,1)}),this.$refs.baseTable.$nextTick(function(e){i.$refs.baseTable.doLayout(),i.$emit("table-dolayout")})},setRowExpansion:function(e,t){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(e,t)},httpRequests:function(e){var t=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:e||1},this.searchObj)).then(function(i){t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:i,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.initLoading=!1,e&&(t.pageNo=e,t.scrollTable())}).catch(function(e){console.log(e),t.initLoading=!1})},httpChildrenRequests:function(e,t){var i=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:t||1},this.setParams(e,this.setApiObj),this.setDynaValue(e))).then(function(a){i.$store.commit(i.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:a,row:e,vm:i}),i.setDragTable&&i.setSort(),i.pageNo=i.tableData[i.dataName].pageData&&i.tableData[i.dataName].pageData.current||1,i.initLoading=!1,console.log("initLoading---\x3e",i.initLoading),t&&i.scrollTable()}).catch(function(e){console.log(e),i.initLoading=!1})},selectItem:function(e,t){e.findIndex(function(e){return e._internalId===t._internalId})>-1?(this.tempCheckedList.push(t),this.$store.commit(this.setGuid+"/ADD_CHECKED",[t])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[t]),this.tempCheckedList=this.tempCheckedList.filter(function(e){return e._internalId!==t._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:e.length?"0":"1"}),e.length?(this.tableData[this.dataName].forEach(function(e){e.rowState="0"}),e[0].rowState="1"):this.tableData[this.dataName].forEach(function(e){e.rowState="1"}))},selectAllItem:function(e){if(this.setIsSingle){if(e.length)for(var t=e.length-1;t>=0;t--)e.splice(t,1)}else e.length?(this.tempCheckedList=e.map(function(e){return e}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(e){e!==this.pageNo&&this.httpRequests(e)},setDynaValue:function(e){if(this.setDynamicValue){var t={};for(var i in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(i)&&(t[i]=Object(o.c)([this.setDynamicValue[i]],e,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return console.log(t),t}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setCellStyle:function(e){return this.setExpand&&2===this.maxLayer&&"1"===this.setExpandColumnWidth?{"border-bottom":"none","background-color":"inherit"}:{"background-color":"inherit"}},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(e,t){var i=this;return t&&e?(this.resultTableData=(e.tableData||e.children).find(function(e){if(e._internalId===t)return!0;if(e.children&&e.children.length){var a={titleList:e.titleList,children:e.children,pageData:e.pageData||{}};i.resultTableData=i.searchTableData(a,t)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(e){this.$emit("callmethod",e)},tableDoLayout:function(){var e=this;this.$nextTick(function(t){e.$refs.baseTable.doLayout(),e.$emit("table-dolayout")})}}},u=(i("q7oa"),i("KHd+")),p=Object(u.a)(h,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.setTableLoading,expression:"setTableLoading"}],class:e.setTableClass},[e.setShowTableSet?i("table-filter",{attrs:{headerList:e.setColConfigs,storeId:e.pageId,componentId:e.setComponentId,showAll:e.setShowAll},on:{"checked-list":e.checkedList,"checked-height":e.checkedHeight}}):e._e(),e._v(" "),i("div",{style:{height:e.setTableHeight}},[i("el-form",{ref:"ruleForm",style:{height:e.layer?"auto":"100%"},attrs:{model:e.ruleForm,"status-icon":""},nativeOn:{submit:function(e){e.preventDefault()}}},[i("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:e.tableData[e.dataName],stripe:!e.setExpand||"50"===e.setExpandColumnWidth,"highlight-current-row":"",border:e.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:e.layer?null:"100%",fit:"","show-header":e.setShowHeader,"row-key":"_internalId","show-summary":e.setSysSummary,"default-expand-all":!e.setShowExpandBtn&&e.setExpand&&"all"===e.setExpandMode,"header-row-style":e.setHeaderRowStyle,"row-style":e.setRowStyle,"row-class-name":e.setRowClass,"cell-style":e.setCellStyle,"header-row-class-name":e.setHeaderRowClass,"default-sort":e.setSortableConfig["default-sort"]},on:{select:e.selectItem,"select-all":e.selectAllItem,"expand-change":e.expandChange,"sort-change":e.sortChange}},[e.setExpand?[i("el-table-column",{attrs:{type:"expand",width:e.setExpandColumnWidth,align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("multilevel-table",{attrs:{tableConfigList:e.tableConfigList,layer:e.layer+1,internalGuid:e.setGuid,parentData:[t.row],rowChain:e.setRowChain},on:{databridge:e.databridge,callmethod:e.callParentMethod,"table-dolayout":e.tableDoLayout}})]}}])})]:e._e(),e._v(" "),e.setShowCheckBox?[i("el-table-column",{attrs:{type:"selection",fixed:e.setFixedState,selectable:e.selectable,width:"55",align:"center"}})]:e._e(),e._v(" "),e.setShowIndex?[i("el-table-column",{attrs:{type:"index",index:e.indexMethod,fixed:e.setFixedState,label:"序号",width:"50",align:"center"}})]:e._e(),e._v(" "),e._l(e.setTitleList,function(t,a){return[t.slot&&t._isShow?e._t(t.slot,null,{fixed:e.setFixedList[a]}):Array.isArray(t.component)&&t._isShow?[i("el-table-column",e._b({key:a,attrs:{"show-overflow-tooltip":"",fixed:e.setFixedList[a],width:e.setColumnWidth[t.prop]||null,align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[i("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:a,isComponent:!0,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[e._v("\n                  "+e._s(t.label)+"\n                ")])]}},{key:"default",fn:function(a){return["button"===t.componentName?i("div",{directives:[{name:"button-width",rawName:"v-button-width",value:t,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":e.setColumnWidth[t.prop]?"space-between":"center"}},e._l(t.component,function(t,n){return void 0!==t.editBtns_isShow&&!t.editBtns_isShow||!t.rowState||e.setButtonState(a.$index,a.row,t)?i("el-button",{key:n,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(e){t.method(a.row,a.$index,a)}}},[e._v(e._s(t.name)+"\n                  ")]):e._e()}),1):e._e()]}}])},"el-table-column",t,!1))]:"object"==typeof t.component&&t._isShow?i(t.component,{key:a,tag:"component",attrs:{"col-config":t,fixed:e.setFixedList[a]}}):[t._isShow?i("el-table-column",{key:a,attrs:{"show-overflow-tooltip":"",label:t.label,prop:t.columnIndex||t.prop,width:t.width||e.constantWidth[t.componentName]||"auto","min-width":t["min-width"]||e.contentWidthList[a]||"none",sortable:!!e.setSortableConfig[t.columnIndex||t.prop],"sort-method":e.setSortableConfig[t.columnIndex||t.prop]&&e.setSortableConfig[t.columnIndex||t.prop]["sort-method"]?e.setSortableConfig[t.columnIndex||t.prop]["sort-method"]:null,"sort-by":e.setSortableConfig[t.columnIndex||t.prop]&&e.setSortableConfig[t.columnIndex||t.prop]["sort-by"]?e.setSortableConfig[t.columnIndex||t.prop]["sort-by"]:null,fixed:e.setFixedList[a],align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[i("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:a,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"}],style:{display:t._isShow?"inline-flex":"none"},domProps:{textContent:e._s(t.label)}})]}},{key:"default",fn:function(n){return[t.mergeTitles&&t.mergeTitles.length?[e._l(t.mergeTitles,function(s,l){return[s.componentName?["input"===s.componentName?[s._cellConfig.asyn?[i("el-form-item",{key:l,attrs:{prop:"tableData."+n.$index+"."+s.prop,rules:e.baseRules(n.$index,n.row,s),"inline-message":!0}},[i("table-autocomplete",{attrs:{_scope:n,"child-colconfig":s,debounce:e.debounce}})],1)]:[i("el-form-item",{key:l,attrs:{prop:"tableData."+n.$index+"."+s.prop,rules:e.baseRules(n.$index,n.row,s),"inline-message":!0}},[i("table-input",{attrs:{_scope:n,"child-colconfig":s}})],1)]]:"date"===s.componentName?[i("table-date-picker",{attrs:{_scope:n,"child-colconfig":s}})]:"time"===s.componentName?[i("table-time-picker",{attrs:{_scope:n,"child-colconfig":s}})]:"select"===s.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+s.prop,rules:e.baseRules(n.$index,n.row,s),"inline-message":!0}},[i("table-select",{attrs:{_scope:n,"child-colconfig":s}})],1)]:"cascader"===s.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+s.prop,rules:e.baseRules(n.$index,n.row,s),"inline-message":!0}},[i("table-cascader",{attrs:{_scope:n,"child-colconfig":s}})],1)]:"switch"===s.componentName?[i("div",[s._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:s._cellConfig.titleStyle||{}},[e._v("\n                            "+e._s(s.label+":")+" \n                          ")]),e._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-switch",{attrs:{_scope:n,"child-colconfig":s}})],1)])]:"dateTime"===s.componentName?[i("table-date-time",{attrs:{_scope:n,"child-colconfig":s}})]:"inputNumber"===s.componentName?[i("el-form-item",{key:n.row._internalId,attrs:{prop:"tableData."+n.$index+"."+s.prop,rules:e.baseRules(n.$index,n.row,s),"inline-message":!0}},[i("table-input-number",{attrs:{_scope:n,"child-colconfig":s}})],1)]:"steps"===s.componentName?[i("div",{key:l,staticClass:"resetElStepStyle"},[s._cellConfig.hideTitle?e._e():i("div",{style:s._cellConfig.titleStyle||{}},[e._v("\n                            "+e._s(s.label+":")+" \n                          ")]),e._v(" "),i("div",[i("table-steps",{attrs:{_scope:n,"child-colconfig":s}})],1)])]:"progress"===s.componentName?[i("div",{key:l,staticStyle:{"text-align":"left"}},[s._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:[{"line-height":s._cellConfig.componentConfig["stroke-width"]>23?2:""},s._cellConfig.titleStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.titleStyle:{})||{}]},[e._v("\n                            "+e._s(s.label+":"+(s._cellConfig.componentConfig.showInitValue?n.row[s.prop]:""))+" \n                          ")]),e._v(" "),i("div",{staticClass:"resetProgressStyle",staticStyle:{display:"inline-block",overflow:"hidden","vertical-align":"middle"},style:{width:(s._cellConfig.componentConfig.width||e.constantWidth[s.componentName])+"px"}},[i("table-progress",{attrs:{_scope:n,"child-colconfig":s}})],1)])]:"upload"===s.componentName?[i("table-upload",{attrs:{_scope:n,"child-colconfig":s}})]:"tag"===s.componentName?[i("table-tag",{attrs:{_scope:n,"child-colconfig":s}})]:"button"===s.componentName?[s._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:s._cellConfig.titleStyle||{}},[e._v("\n                          "+e._s(s.label+":")+" \n                        ")]),e._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-button",{attrs:{_scope:n,"child-colconfig":s}})],1)]:[i("span",{key:l,staticStyle:{"margin-left":"10px"},domProps:{textContent:e._s(n.row[s.prop])}})]]:[i("div",{key:l,style:{"text-align":s._cellConfig&&s._cellConfig.hideTitle?"center":"left"}},[s._cellConfig?[s._cellConfig.hideTitle?e._e():[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:l,colConfig:t,childColconfig:s,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:[s._cellConfig.titleStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.titleStyle:{}),e.setMiddleValue[a]?e.setMiddleValue[a].title:{}],domProps:{textContent:e._s(s.label+":")}},[e._v(" ")])]]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:l,colConfig:t,childColconfig:s,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"}],style:e.setMiddleValue[a]?e.setMiddleValue[a].title:{},domProps:{textContent:e._s(s.label+":")}},[e._v(" ")])],e._v(" "),s._cellConfig&&s._cellConfig.events?[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:l,colConfig:t,childColconfig:s,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"}],style:[s._cellConfig.bodyStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.bodyStyle:{}),e.setMiddleValue[a]?e.setMiddleValue[a].body:{}]},[i("a",{domProps:{textContent:e._s(n.row[s.prop])},on:{click:function(t){e.mergeColumnEvents(s,n)}}})])]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:l,colConfig:t,childColconfig:s,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"},{name:"content-set",rawName:"v-content-set",value:{config:s,row:n.row},expression:"{config: childColconfig,row: scope.row}"}],class:{resetContent:e.setMiddleValue[a],ellipsis:!!e.setMiddleValue[a]&&e.isEllipsis(n.row[s.columnIndex||s.prop],parseInt(e.setMiddleValue[a].body.width))},style:[s._cellConfig?s._cellConfig.bodyStyle:{},e.setColumnGlobalStyle?e.setColumnGlobalStyle.bodyStyle:{},e.setMiddleValue[a]?e.setMiddleValue[a].body:{}],domProps:{textContent:e._s(n.row[s.columnIndex||s.prop])}})]],2)]]})]:[i("div",{style:{display:t._isShow?"inline-block":"none"},domProps:{textContent:e._s(n.row[t.prop])}})]]}}])}):e._e()]]}),e._v(" "),e.setDragTable?[i("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:e._u([{key:"default",fn:function(e){return[i("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[i("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)]}}])})]:e._e()],2)],1),e._v(" "),e.setUseSummary&&e.setCustomSummary.component?[i("custom-summary-option",{attrs:{customSummary:e.setCustomSummary,tempData:e.setTempData,tableData:e.tableData[e.dataName]},on:{"send-height":e.customSummaryHeight,"custom-summary-value":e.customSummaryValue}})]:e._e()],2),e._v(" "),e.setHidePages?e._e():i("div",{staticStyle:{height:"40px","text-align":"center"},style:{"padding-top":(e.customSummaryOptionHeight||5)+"px"}},[i("el-pagination",{attrs:{background:"","current-page":e.tableData.pageData.current,"page-size":e.tableData.pageData.size,layout:"prev, pager, next, jumper",total:e.tableData.pageData.total-0},on:{"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.tableData.pageData,"current",t)}}})],1)],1)},[],!1,null,null,null);p.options.__file="index.vue";t.a=p.exports},D2yE:function(e,t,i){},cE6r:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("Oyvg"),i("rGqo");var a=i("uTIz"),n=i("2+ib"),s=i("spKr");function l(e){return(l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var o={components:{searchBar:a.a,multilevelTable:n.a},name:"dialog-add",props:["initData","visible"],data:function(){return{retreatId:"",supplierId:"",supplierName:"",totalSum:"",dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",table_style:"",orderId:"",orderDtlIds:"",supplierId:"",supplierName:""},rowTableList:[],tableConfigList:[{customColumn:[{columnIndex:"sysCode",width:"200"},{columnIndex:"supplierName"},{columnIndex:"orderCode",width:"200"},{columnIndex:"cdate"},{columnIndex:"retreatDate"},{columnIndex:"remark"},{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"1",text:"待提交"},info2:{state:"2",text:"待退货"},info3:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageRetreat",params:{id:"",fieldCode:"sysCode,supplierName,orderCode,cdate,retreatDate,remark,state"}},tempData:{},showHeader:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"1",text:"待审核"},info2:{state:"2",text:"待退货"},info3:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageRetreatDetail",params:{isNeedPage:"false",fieldCode:"productCode,productName,productSpec,productGenreName,unitName,count,price,amount"}},dynamicValue:{parentId:"self@id"},tempData:{},isSingle:!1,componentId:"twoLevelTable",useSummary:!0,customSummary:{component:{props:["data","setStyle"],template:'<ul class="clearfix" :style="setStyle">\n                    <li style="float: left;width: 50%" class="inputStyle">\n                      <span>退货总额：</span>\n                      <span>\n                        <el-form inline inline-message :model="data" ref="numberValidateForm" label-width="0">\n                          <el-form-item prop="realityTotal">\n                            <el-input v-model="data.realityTotal" size="mini" placeholder="请输入"></el-input>\n                          </el-form-item>\n                        </el-form>\n                      </span>\n                    </li>\n                    </ul>'},data:{realityTotal:""},boxStyle:{width:"500px",float:"left",padding:"10px"},computes:{realityTotal:"table@amount"}}}]}},created:function(){this.retreatId=this.initData.retreatId,this.supplierId=this.initData.supplierId,this.supplierName=this.initData.supplierName,null!=this.initData.totalSum&&(this.totalSum=this.initData.totalSum+""),this.tableConfigList[0].apiObj.params.id=this.retreatId},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=l(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(e){this.rowTableList=[],Array.isArray(e)&&(this.rowTableList=e)},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},updateData:function(e){this.$refs.customBaseTable.updateData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},closeDialog:function(e){},findChildrenList:function(e){var t=[];return null!=e&&null!=e[0].children&&e[0].children.length>0&&e[0].children.forEach(function(e){t.push(e)}),t},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkNumber:function(e,t){var i="";return null==e||0==e.trim().length?i=t+"输入为空或空字符串！":null!=e&&e.trim().length>0&&!this.isNumberByValue(e.trim())&&(i=t+"("+e+") 输入错误，请输入大于零的正整数或(1,2)位小数！"),i},save:function(){if(this.$refs.AuditPassDialog.getData(),null!=this.rowTableList&&this.rowTableList.length>0){var e=this.findChildrenList(this.rowTableList);this.auditPass(e)}},auditPass:function(e){var t=this,i=this.tableConfigList[1].customSummary.data.realityTotal;i+="";var a=this.checkNumber(i,"退货总额");if(null!=a&&a.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:a});else{if(null!=this.totalSum&&this.totalSum.trim().length>0&&this.totalSum.trim(),i-this.totalSum>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:"退货总额("+i+") 不可大于退货明细总金额"});else if(null!=e&&0!=e.length){var n=[];e.forEach(function(e){var t={id:e.id,count:e.count,price:e.price,productId:e.productId,unitName:e.unitName,p2nFormula:e.p2nFormula};n.push(t)});var l="";null!=n&&n.length>0&&(l=JSON.stringify(n)),Object(s.auditPassPurchaseRetreat)({retreatId:this.retreatId,supplierId:this.supplierId,supplierName:this.supplierName,realityTotal:i,dtlJsonStr:l}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"无退货单明细数据！"})}}}},r=i("KHd+"),d=Object(r.a)(o,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("el-row",{style:e.initData.table_style},[i("multilevel-table",{ref:"AuditPassDialog",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("通过")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)},[],!1,null,null,null);d.options.__file="dialogAuditPass.vue";t.default=d.exports},q7oa:function(e,t,i){"use strict";var a=i("D2yE");i.n(a).a}}]);