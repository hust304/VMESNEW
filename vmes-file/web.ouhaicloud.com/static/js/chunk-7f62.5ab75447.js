(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7f62","chunk-2c81","chunk-0571","D2zt"],{"2+ib":function(t,e,a){"use strict";a("dRSK"),a("INYr"),a("91GP"),a("Vd3H"),a("rGqo"),a("f3/d"),a("xfY5");var i=a("8WZi"),s=a("z0WU"),n=a("DKCI"),o=a("50Ol"),l=a("F9dT"),r=(a("Yfch"),a("YP4+")),d=a("WwWg"),u=(a("evdt"),a("mwzG")),c={name:"multilevel-table",mixins:[i.a],provide:function(){return{rootVm:this}},props:{expand:[Boolean],expandMode:[String],rootWidth:[String,Number],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,headerWidthList:[],listLength:-1,restaurants:[],fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:n.a,customSummaryOption:o.a},computed:{setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer,defaultSpacingClass:!this.layer&&this.maxLayer>1,noSpacingClass:this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return this.layer?!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2):!!this.setShowTableSet},setRootWidth:function(){return this.layer?"100%":this.layerConfig.rootWidth||this.rootWidth?"".concat((this.layerConfig.rootWidth||this.rootWidth)+"","px"):"100%"}},created:function(){var t=this;if(!this.layer)if(this.guid=Object(s.a)(),Object(d.c)(this),this.initData.result){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:"root",vm:this}),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var e=JSON.parse(JSON.stringify(u.a));t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:e,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.$store.commit(t.guid+"/SET_TABLERULELIST",{cb:t.tableRuleForm,ruleId:"root",vm:t}),t.initLoading=!1},1e3):this.httpRequests());this.layer&&(this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.tableData[this.dataName].forEach(function(t){t.rowState="1"}),this.setDragTable&&this.setSort(),this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:this.internalRuleId,vm:this}),this.initLoading=!1,this.tableDoLayout()):(this.$emit("narrow-row",this.parentData[0]),this.initLoading=!1,this.tableDoLayout()))},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){var t=this;this.$store.state[this.setGuid]&&this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:null,ruleId:this.layer?this.internalRuleId:"root"}),this.tempCheckedList.forEach(function(e){t.$store.commit(t.setGuid+"/DELETE_CHECKED",[e])}),!this.layer&&Object(d.g)(this.$store,this.guid)},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay(),this.tableDoLayout()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay(),this.tableDoLayout()},initData:function(){this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:null,ruleId:this.layer?this.internalRuleId:"root"});var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:this.layer?this.internalRuleId:"root",vm:this}),this.initLoading=!1,this.tableDoLayout()},resetContentWidthList:function(){var t=this,e=this.resetContentWidthList.map(function(t){return null});this.resetContentWidthList.forEach(function(a,i){t.useMiddleValue=!1,e[i]=t.contentWidthAlgorithm(a.map(function(t){return Math.max.apply(null,t)})),t.useMiddleValueList[i]=t.useMiddleValue}),e.forEach(function(e,a){t.contentWidthList[a]=e?e+26:null})}},methods:{contentWidthAlgorithm:function(t){if(this.setWidthDiffValue&&t&&t.length){if(t.length>1){var e=Math.max.apply(null,t);if(e-Math.min.apply(null,t)>this.setWidthDiffValue){var a,i=[].concat(t);return i.sort(s.d),a=i.length%2==0?(i[i.length/2-1]+i[i.length/2])/2:i[(i.length+1)/2-1],this.useMiddleValue=!0,e-a>this.setWidthDiffValue&&(a=2*this.setWidthDiffValue),a}return e}return t[0]}return null},databridge:function(t,e){this.$emit("databridge",t,e)},expandChange:function(t,e){var a=this;"one"===this.setExpandMode&&e.forEach(function(a,i){t._internalId!==a._internalId&&e.splice(i,1)}),this.$refs.baseTable.$nextTick(function(t){a.$refs.baseTable&&a.$refs.baseTable.doLayout&&a.$refs.baseTable.doLayout(),a.$emit("table-dolayout")})},setRowExpansion:function(t,e){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(t,e)},httpRequests:function(t){var e=this;this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:null,ruleId:"root"}),this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:t||1},this.searchObj)).then(function(a){e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:a,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1,t&&(e.pageNo=t,e.scrollTable()),e.tableDoLayout(),e.$store.commit(e.guid+"/SET_TABLERULELIST",{cb:e.tableRuleForm,ruleId:"root",vm:e})}).catch(function(t){console.log(t),e.initLoading=!1})},httpChildrenRequests:function(t,e){var a=this;this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:null,ruleId:this.internalRuleId}),this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:e||1},this.setParams(t,this.setApiObj),this.setDynaValue(t))).then(function(i){a.$store.commit(a.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:i,row:t,vm:a}),a.setDragTable&&a.setSort(),a.pageNo=a.tableData[a.dataName].pageData&&a.tableData[a.dataName].pageData.current||1,a.initLoading=!1,a.tableDoLayout(),e&&a.scrollTable(),a.$store.commit(a.setGuid+"/SET_TABLERULELIST",{cb:a.tableRuleForm,ruleId:a.internalRuleId,vm:a})}).catch(function(t){console.log(t),a.initLoading=!1})},selectItem:function(t,e){t.findIndex(function(t){return t._internalId===e._internalId})>-1?(this.tempCheckedList.push(e),this.$store.commit(this.setGuid+"/ADD_CHECKED",[e])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[e]),this.tempCheckedList=this.tempCheckedList.filter(function(t){return t._internalId!==e._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:t.length?"0":"1"}),t.length?(this.tableData[this.dataName].forEach(function(t){t.rowState="0"}),t[0].rowState="1"):this.tableData[this.dataName].forEach(function(t){t.rowState="1"}))},selectAllItem:function(t){if(this.setIsSingle){if(t.length)for(var e=t.length-1;e>=0;e--)t.splice(e,1)}else t.length?(this.tempCheckedList=t.map(function(t){return t}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(t){t!==this.pageNo&&this.httpRequests(t)},setDynaValue:function(t){if(this.setDynamicValue){var e={};for(var a in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(a)&&(e[a]=Object(l.c)([this.setDynamicValue[a]],t,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return e}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(t,e){var a=this;return e&&t?(this.resultTableData=(t.tableData||t.children).find(function(t){if(t._internalId===e)return!0;if(t.children&&t.children.length){var i={titleList:t.titleList,children:t.children,pageData:t.pageData||{}};a.resultTableData=a.searchTableData(i,e)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(t){this.$emit("callmethod",t)},tableDoLayout:function(){var t=this;this.$nextTick(function(e){t.$refs.baseTable&&t.$refs.baseTable.doLayout&&t.$refs.baseTable.doLayout(),t.layer&&t.$emit("table-dolayout")})}}},h=(a("q7oa"),a("jB/s"),a("KHd+")),m=Object(h.a)(c,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.setTableLoading,expression:"setTableLoading"}],staticClass:"myCoustomTable resetCoustomTableStyle",class:t.setTableClass},[t.setShowTableSet&&"outside"===t.setTableSetMode&&!t.layer?a("table-filter",{attrs:{headerList:t.setColConfigs,tableSwitchState:t.setTableSwitch,storeId:t.pageId,componentId:t.setComponentId},on:{"checked-list":t.checkedList,"checked-height":t.checkedHeight}}):t._e(),t._v(" "),a("div",{style:{height:t.setTableHeight}},[a("el-form",{ref:"ruleForm",style:{height:t.layer?"auto":"100%"},attrs:{model:t.ruleForm,"status-icon":""},nativeOn:{submit:function(t){t.preventDefault()}}},[a("el-table",{ref:"baseTable",style:{width:t.setRootWidth},attrs:{data:t.tableData[t.dataName],stripe:!t.setExpand||"50"===t.setExpandColumnWidth,"highlight-current-row":"",border:t.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:t.layer?null:"100%",fit:"","show-header":t.setShowHeader,"row-key":"_internalId","show-summary":t.setSysSummary,"default-expand-all":!t.setShowExpandBtn&&t.setExpand&&"all"===t.setExpandMode,"header-row-style":t.setHeaderRowStyle,"row-style":t.setRowStyle,"row-class-name":t.setRowClass,"cell-style":t.setCellStyle,"header-cell-style":t.setHeaderCellStyle,"header-row-class-name":t.setHeaderRowClass,"default-sort":t.setSortableConfig["default-sort"]},on:{select:t.selectItem,"select-all":t.selectAllItem,"selection-change":t.selectionChange,"expand-change":t.expandChange,"sort-change":t.sortChange,"row-click":t.rowClick,"row-dblclick":t.rowDblclick}},[t.setExpand?[a("el-table-column",{attrs:{type:"expand",width:t.setExpandColumnWidth,align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("multilevel-table",{ref:"multilevelTable",attrs:{"data-custom-table-id":"components_customTable_multilevelTable_index0",tableConfigList:t.tableConfigList,layer:t.layer+1,internalRuleId:e.row._internalId,internalGuid:t.setGuid,parentData:[e.row],rowChain:t.setRowChain,tableSwitchBaseKey:t.columnSwitchBaseKey},on:{databridge:t.databridge,callmethod:t.callParentMethod,"table-dolayout":t.tableDoLayout,"narrow-row":t.narrowRow}})]}}])})]:t._e(),t._v(" "),t.setShowCheckBox?[a("el-table-column",{attrs:{type:"selection",fixed:t.setFixedState,selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.setShowIndex?[a("el-table-column",{attrs:{type:"index",index:t.indexMethod,fixed:t.setFixedState,label:"序号",width:"50",align:"center"}})]:t._e(),t._v(" "),t._l(t.setTitleList,function(e,i){return[e.slot?t._t(e.slot,null,{fixed:t.setFixedList[i]}):Array.isArray(e.component)?[a("el-table-column",t._b({key:i,attrs:{"show-overflow-tooltip":"",fixed:t.setFixedList[i],"min-width":e.width||t.setColumnWidth[e.prop]||null,align:"center"},scopedSlots:t._u([{key:"header",fn:function(s){return[a("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:i,isComponent:!0,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[t._v("\n                  "+t._s(e.label)+"\n                ")])]}},{key:"default",fn:function(i){return["button"===e.componentName?a("div",{directives:[{name:"button-width",rawName:"v-button-width",value:e,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":t.setColumnWidth[e.prop]?"space-between":"center"}},t._l(e.component,function(e,s){return void 0!==e.editBtns_isShow&&!e.editBtns_isShow||!e.rowState||t.setButtonState(i.$index,i.row,e)?a("el-button",{key:s,style:t.setButtonStyle||{height:"24px",width:"46px",padding:0,margin:0,"font-size":"12px","max-width":"46px"},attrs:{type:"text"},on:{click:function(t){e.method(i.row,i.$index,i)}}},[t._v(t._s(e.name)+"\n                  ")]):t._e()}),1):t._e()]}}])},"el-table-column",e,!1))]:"object"!=typeof e.component||Array.isArray(e.component)?[e._isShow||"outside"!==t.setTableSetMode?a("el-table-column",{key:i,attrs:{"show-overflow-tooltip":"",label:e.label,prop:e.prop||e.columnIndex,width:e._isShow?e.width||t.constantWidth[e.componentName]||"auto":t.setTableColumnState?"20":"","min-width":e._isShow?e.width||e["min-width"]||t.constantWidth[e.componentName]||t.contentWidthList[i]||"none":"",sortable:!(!t.setSortableConfig[e.prop||e.columnIndex]||!e._isShow),"sort-method":t.setSortableConfig[e.prop||e.columnIndex]&&t.setSortableConfig[e.prop||e.columnIndex]["sort-method"]?t.setSortableConfig[e.prop||e.columnIndex]["sort-method"]:null,"sort-by":t.setSortableConfig[e.prop||e.columnIndex]&&t.setSortableConfig[e.prop||e.columnIndex]["sort-by"]?t.setSortableConfig[e.prop||e.columnIndex]["sort-by"]:null,fixed:t.setFixedList[i],align:"center"},scopedSlots:t._u([{key:"header",fn:function(s){return[a("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:i,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"},{name:"custom-table-switch",rawName:"v-custom-table-switch",value:{config:e,index:i,showSwitch:t.setTableColumnState},expression:"{config:colConfig,index:infoIndex,showSwitch:setTableColumnState}"}],style:{display:e._isShow?"inline-flex":"none","white-space":"nowrap"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(s){return[a("core-index",{directives:[{name:"show",rawName:"v-show",value:!!e._isShow||"outside"===t.setTableSetMode,expression:"colConfig._isShow?true:setTableSetMode === 'outside'"}],attrs:{scope:s,"info-index":i,"col-config":e,runTime:"multilevel"}})]}}])}):t._e()]:a(e.component,{key:i,tag:"component",attrs:{"col-config":e,fixed:t.setFixedList[i]}})]}),t._v(" "),t.setDragTable?[a("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[a("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[a("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)])]}}])})]:t._e()],2)],1),t._v(" "),t.setUseSummary&&t.setCustomSummary.component?[a("custom-summary-option",{attrs:{customSummary:t.setCustomSummary,tempData:t.setTempData,tableData:t.tableData[t.dataName]},on:{"send-height":t.customSummaryHeight,"custom-summary-value":t.customSummaryValue}})]:t._e()],2),t._v(" "),t.setHidePages?t._e():a("div",{staticStyle:{"text-align":"center"},style:{"padding-top":(t.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[a("el-pagination",{attrs:{background:"","current-page":t.tableData.pageData.current,"page-size":t.tableData.pageData.size,layout:"prev, pager, next, jumper",total:t.tableData.pageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.tableData.pageData,"current",e)}}})],1)],1)},[],!1,null,null,null);m.options.__file="index.vue";e.a=m.exports},"9keN":function(t,e,a){},D2zt:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf");var i=a("spKr");function s(t){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={name:"dialog-edit",props:["initData","visible"],data:function(){return{retreatId:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{remark:[{required:!0,message:"请填写退回原因！",trigger:"change"}]}}},created:function(){this.retreatId=this.initData.retreatId},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=s(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){if(e){t.dialogLoading=!0;var a=t.$storage.get("userInfo").userName;Object(i.auditDisagreePurchaseRetreat)({retreatId:t.retreatId,remark:t.temp.remark,userName:a}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"退回成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1})}})}}},o=a("KHd+"),l=Object(o.a)(n,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[a("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"30px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[a("el-form-item",{attrs:{label:"退回原因:",prop:"remark"}},[a("el-input",{staticStyle:{width:"240px"},attrs:{type:"textarea",rows:2},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);l.options.__file="dialogAuditDisagree.vue";e.default=l.exports},RxSU:function(t,e,a){"use strict";var i=a("ehCV");a.n(i).a},cE6r:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf"),a("Oyvg"),a("rGqo");var i=a("uTIz"),s=a("2+ib"),n=a("spKr");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{searchBar:i.a,multilevelTable:s.a},name:"dialog-add",props:["initData","visible"],data:function(){return{retreatId:"",supplierId:"",supplierName:"",totalSum:"",dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",table_style:"",orderId:"",orderDtlIds:"",supplierId:"",supplierName:""},rowTableList:[],tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"1",text:"待审核"},info2:{state:"2",text:"待退货"},info3:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageRetreat",params:{id:"",fieldCode:"sysCode,supplierName,orderCode,cdate,retreatDate,remark,state"}},tempData:{},showHeader:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"1",text:"待审核"},info2:{state:"2",text:"待退货"},info3:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageRetreatDetail",params:{isNeedPage:"false",fieldCode:"productCode,productName,productSpec,productGenreName,unitName,count,price,amount"}},dynamicValue:{parentId:"self@id"},tempData:{},isSingle:!1,componentId:"twoLevelTable",useSummary:!0,customSummary:{component:{props:["data","setStyle"],template:'<ul class="clearfix" :style="setStyle">\n                    <li style="float: left;width: 50%" class="inputStyle">\n                      <span>退货总额：</span>\n                      <span>\n                        <el-form inline inline-message :model="data" ref="numberValidateForm" label-width="0">\n                          <el-form-item prop="realityTotal">\n                            <el-input v-model="data.realityTotal" size="mini" :readonly="true"></el-input>\n                          </el-form-item>\n                        </el-form>\n                      </span>\n                    </li>\n                    </ul>'},data:{realityTotal:""},boxStyle:{width:"500px",float:"left",padding:"10px"},computes:{realityTotal:"table@amount"}}}]}},created:function(){this.retreatId=this.initData.retreatId,this.supplierId=this.initData.supplierId,this.supplierName=this.initData.supplierName,null!=this.initData.totalSum&&(this.totalSum=this.initData.totalSum+""),this.tableConfigList[0].apiObj.params.id=this.retreatId},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(t){this.rowTableList=[],Array.isArray(t)&&(this.rowTableList=t)},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},updateData:function(t){this.$refs.customBaseTable.updateData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},closeDialog:function(t){},findChildrenList:function(t){var e=[];return null!=t&&null!=t[0].children&&t[0].children.length>0&&t[0].children.forEach(function(t){e.push(t)}),e},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+\\.{0,1}[0-9]{0,2}$").test(t.trim())},checkNumber:function(t,e){var a="";return null==t||0==t.trim().length?a=e+"输入为空或空字符串！":null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&(a=e+"("+t+") 输入错误，请输入大于零的正整数或(1,2)位小数！"),a},save:function(){if(this.$refs.AuditPassDialog.getData(),null!=this.rowTableList&&this.rowTableList.length>0){var t=this.findChildrenList(this.rowTableList);this.auditPass(t)}},auditPass:function(t){var e=this,a=this.tableConfigList[1].customSummary.data.realityTotal;a+="";var i=this.checkNumber(a,"退货总额");if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{if(null!=this.totalSum&&this.totalSum.trim().length>0&&this.totalSum.trim(),a-this.totalSum>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:"退货总额("+a+") 不可大于退货明细总金额"});else if(null!=t&&0!=t.length){var s=[];t.forEach(function(t){var e={id:t.id,orderDetailId:t.orderDetailId,count:t.count,price:t.price,productId:t.productId,productGenre:t.productGenre,planDtlId:t.planDtlId,planId:t.planParentId,unitName:t.unitName,p2nFormula:t.p2nFormula};s.push(e)});var o="";null!=s&&s.length>0&&(o=JSON.stringify(s)),Object(n.auditPassPurchaseRetreat)({retreatId:this.retreatId,supplierId:this.supplierId,supplierName:this.supplierName,roleId:this.$storage.get("userInfo").roleIds,realityTotal:a,dtlJsonStr:o}).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"无退货单明细数据！"})}}}},r=a("KHd+"),d=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{staticStyle:{"padding-top":"10px"}},[a("el-row",{staticStyle:{width:"96%","margin-left":"2%"}},[a("multilevel-table",{ref:"AuditPassDialog",attrs:{"data-custom-table-id":"views_purchase_purchaseRetreat_auditRetreatByPurchase_dialogAuditPass0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("通过")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);d.options.__file="dialogAuditPass.vue";e.default=d.exports},ehCV:function(t,e,a){},"jB/s":function(t,e,a){"use strict";var i=a("rXsy");a.n(i).a},lcuM:function(t,e,a){},q7oa:function(t,e,a){"use strict";var i=a("9keN");a.n(i).a},qRCZ:function(t,e,a){"use strict";var i=a("lcuM");a.n(i).a},rXsy:function(t,e,a){},us7y:function(t,e,a){"use strict";a.r(e);a("rGqo");var i=a("2+ib"),s=a("uTIz"),n=a("cE6r"),o=a("D2zt"),l=(a("spKr"),a("Vobf")),r=(a("z0WU"),{components:{multilevelTable:i.a,searchBar:s.a,dialogAuditPass:n.default,dialogAuditDisagree:o.default},data:function(){return{searchList:[{label:"退货单号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单编号"},{label:"供应商名称",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"供应商名称"},{label:"退货单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"1",label:"待审核"},{value:"3",label:"已完成"},{value:"-1",label:"已取消"}]},placeholder:"请选择"},{label:"制单日期起",type:"date",ruleType:"date",mapKey:"cdateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"制单日期止",type:"date",ruleType:"date",mapKey:"cdateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"1",text:"待审核"},info2:{state:"2",text:"待退货"},info3:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"通过",nameEn:"auditPassByParent",editBtns_isShow:!0,rowState:"#self@state#===1",method:this.auditPassByParent},{name:"退回",nameEn:"auditDisagreeByParent",editBtns_isShow:!0,rowState:"#self@state#===1",method:this.auditDisagreeByParent}]}],apiObj:{apiName:"listPageRetreat",params:{state:"1",orderStr:"retreat.cdate desc",dataType:this.$storage.get("dataType"),fieldCode:"sysCode,supplierName,orderCode,typeName,cdate,retreatDate,remark,state"}},tempData:{},showHeader:!0,showIndex:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"1",text:"待审核"},info2:{state:"2",text:"待退货"},info3:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageRetreatDetail",params:{isNeedPage:"false",fieldCode:"productCode,productName,productSpec,productGenreName,unitName,count,price,amount,remark,state"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],searchObj:{},selectList:[],configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1},temp:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",retreatId:"",supplierId:"",supplierName:"",totalSum:"",title:"",data:{},tempLable:null}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,a=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"云上企业"}),Object(l.initMenuButtons)({menuId:a,roleId:e}).then(function(e){t.$loading().close();var a=e.buttonList;a&&a.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)})),t.tableConfigList&&t.tableConfigList.forEach(function(t){t.customColumn&&t.customColumn.forEach(function(t){"last"==t.columnIndex&&t.component&&t.component.forEach(function(t){t.nameEn==e.nameEn&&(t.rowState="1==2")})})})})}).catch(function(e){t.$loading().close()}))},databridge:function(t){this.temp.dataList=t,this.selectList=t,this.configs.topBarBtnList.forEach(function(t){"orderSubmit"==t.nameEn&&(t.state=!1)});var e=!1;if(null!=t&&t.length>0)for(var a=0;a<t.length;a++){if("0"!=t[a].state){e=!0;break}}e&&this.configs.topBarBtnList.forEach(function(t){"orderSubmit"==t.nameEn&&(t.state=!0)})},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.selectList=[],this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},auditPassByParent:function(t,e){var a=.7*document.body.clientWidth;this.dialogData.dialog_width=a+"px";var i=.75*(.618*a)+"px";this.dialogData.table_style="height:"+i+";width: 96%;margin-left: 2%;",this.dialogData.retreatId=t.id,this.dialogData.supplierId=t.supplierId,this.dialogData.supplierName=t.supplierName,this.dialogData.totalSum=t.totalSum,this.dialogData.title="退货单审核",this.openDialogName="dialogAuditPass",this.showDialog=!0,this.visible=!0},auditDisagreeByParent:function(t,e){this.dialogData.retreatId=t.id,this.dialogData.title="审核退回",this.openDialogName="dialogAuditDisagree",this.showDialog=!0,this.visible=!0}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),d=(a("RxSU"),a("qRCZ"),a("KHd+")),u=Object(d.a)(r,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"auditRetreatByPurchase"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_purchase_purchaseRetreat_auditRetreatByPurchase_index0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);u.options.__file="index.vue";e.default=u.exports}}]);