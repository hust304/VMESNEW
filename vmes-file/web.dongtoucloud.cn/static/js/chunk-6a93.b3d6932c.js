(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-6a93","chunk-2c81","chunk-2f42","chunk-f7e3"],{"2+ib":function(t,e,a){"use strict";a("dRSK"),a("INYr"),a("91GP"),a("Vd3H"),a("rGqo"),a("f3/d"),a("xfY5");var i=a("8WZi"),s=a("z0WU"),o=a("DKCI"),n=a("50Ol"),l=a("F9dT"),r=(a("Yfch"),a("YP4+")),d=a("WwWg"),u=(a("evdt"),a("mwzG")),c={name:"multilevel-table",mixins:[i.a],provide:function(){return{rootVm:this}},props:{expand:[Boolean],expandMode:[String],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,headerWidthList:[],listLength:-1,restaurants:[],fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:o.a,customSummaryOption:n.a},computed:{setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer,defaultSpacingClass:!this.layer&&this.maxLayer>1,noSpacingClass:this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return this.layer?!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2):!!this.setShowTableSet}},created:function(){var t=this;if(!this.layer)if(this.guid=Object(s.a)(),Object(d.c)(this),this.initData.result){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:"root",vm:this}),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var e=JSON.parse(JSON.stringify(u.a));t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:e,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.$store.commit(t.guid+"/SET_TABLERULELIST",{cb:t.tableRuleForm,ruleId:"root",vm:t}),t.initLoading=!1},1e3):this.httpRequests());this.layer&&(this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.tableData[this.dataName].forEach(function(t){t.rowState="1"}),this.setDragTable&&this.setSort(),this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:this.internalRuleId,vm:this}),this.initLoading=!1,this.tableDoLayout()):(this.$emit("narrow-row",this.parentData[0]),this.initLoading=!1,this.tableDoLayout()))},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){var t=this;this.$store.state[this.setGuid]&&this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:null,ruleId:this.layer?this.internalRuleId:"root"}),this.tempCheckedList.forEach(function(e){t.$store.commit(t.setGuid+"/DELETE_CHECKED",[e])}),!this.layer&&Object(d.g)(this.$store,this.guid)},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay(),this.tableDoLayout()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay(),this.tableDoLayout()},initData:function(){this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:null,ruleId:this.layer?this.internalRuleId:"root"});var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:this.layer?this.internalRuleId:"root",vm:this}),this.initLoading=!1,this.tableDoLayout()},resetContentWidthList:function(){var t=this,e=this.resetContentWidthList.map(function(t){return null});this.resetContentWidthList.forEach(function(a,i){t.useMiddleValue=!1,e[i]=t.contentWidthAlgorithm(a.map(function(t){return Math.max.apply(null,t)})),t.useMiddleValueList[i]=t.useMiddleValue}),e.forEach(function(e,a){t.contentWidthList[a]=e?e+26:null})}},methods:{contentWidthAlgorithm:function(t){if(t&&t.length){if(t.length>1){var e=Math.max.apply(null,t);if(e-Math.min.apply(null,t)>this.setWidthDiffValue){var a,i=[].concat(t);return i.sort(s.d),a=i.length%2==0?(i[i.length/2-1]+i[i.length/2])/2:i[(i.length+1)/2-1],this.useMiddleValue=!0,e-a>this.setWidthDiffValue&&(a=2*this.setWidthDiffValue),a}return e}return t[0]}return null},databridge:function(t,e){this.$emit("databridge",t,e)},expandChange:function(t,e){var a=this;"one"===this.setExpandMode&&e.forEach(function(a,i){t._internalId!==a._internalId&&e.splice(i,1)}),this.$refs.baseTable.$nextTick(function(t){a.$refs.baseTable&&a.$refs.baseTable.doLayout&&a.$refs.baseTable.doLayout(),a.$emit("table-dolayout")})},setRowExpansion:function(t,e){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(t,e)},httpRequests:function(t){var e=this;this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:null,ruleId:"root"}),this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:t||1},this.searchObj)).then(function(a){e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:a,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1,t&&(e.pageNo=t,e.scrollTable()),e.tableDoLayout(),e.$store.commit(e.guid+"/SET_TABLERULELIST",{cb:e.tableRuleForm,ruleId:"root",vm:e})}).catch(function(t){console.log(t),e.initLoading=!1})},httpChildrenRequests:function(t,e){var a=this;this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:null,ruleId:this.internalRuleId}),this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:e||1},this.setParams(t,this.setApiObj),this.setDynaValue(t))).then(function(i){a.$store.commit(a.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:i,row:t,vm:a}),a.setDragTable&&a.setSort(),a.pageNo=a.tableData[a.dataName].pageData&&a.tableData[a.dataName].pageData.current||1,a.initLoading=!1,a.tableDoLayout(),e&&a.scrollTable(),a.$store.commit(a.setGuid+"/SET_TABLERULELIST",{cb:a.tableRuleForm,ruleId:a.internalRuleId,vm:a})}).catch(function(t){console.log(t),a.initLoading=!1})},selectItem:function(t,e){t.findIndex(function(t){return t._internalId===e._internalId})>-1?(this.tempCheckedList.push(e),this.$store.commit(this.setGuid+"/ADD_CHECKED",[e])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[e]),this.tempCheckedList=this.tempCheckedList.filter(function(t){return t._internalId!==e._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:t.length?"0":"1"}),t.length?(this.tableData[this.dataName].forEach(function(t){t.rowState="0"}),t[0].rowState="1"):this.tableData[this.dataName].forEach(function(t){t.rowState="1"}))},selectAllItem:function(t){if(this.setIsSingle){if(t.length)for(var e=t.length-1;e>=0;e--)t.splice(e,1)}else t.length?(this.tempCheckedList=t.map(function(t){return t}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(t){t!==this.pageNo&&this.httpRequests(t)},setDynaValue:function(t){if(this.setDynamicValue){var e={};for(var a in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(a)&&(e[a]=Object(l.c)([this.setDynamicValue[a]],t,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return e}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setCellStyle:function(t){return this.setExpand&&2===this.maxLayer&&"1"===this.setExpandColumnWidth?{"border-bottom":"none","background-color":"inherit"}:{"background-color":"inherit"}},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(t,e){var a=this;return e&&t?(this.resultTableData=(t.tableData||t.children).find(function(t){if(t._internalId===e)return!0;if(t.children&&t.children.length){var i={titleList:t.titleList,children:t.children,pageData:t.pageData||{}};a.resultTableData=a.searchTableData(i,e)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(t){this.$emit("callmethod",t)},tableDoLayout:function(){var t=this;this.$nextTick(function(e){t.$refs.baseTable&&t.$refs.baseTable.doLayout&&t.$refs.baseTable.doLayout(),t.layer&&t.$emit("table-dolayout")})}}},h=(a("q7oa"),a("jB/s"),a("KHd+")),p=Object(h.a)(c,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.setTableLoading,expression:"setTableLoading"}],staticClass:"myCoustomTable resetCoustomTableStyle",class:t.setTableClass},[t.setShowTableSet&&"outside"===t.setTableSetMode&&!t.layer?a("table-filter",{attrs:{headerList:t.setColConfigs,tableSwitchState:t.setTableSwitch,storeId:t.pageId,componentId:t.setComponentId},on:{"checked-list":t.checkedList,"checked-height":t.checkedHeight}}):t._e(),t._v(" "),a("div",{style:{height:t.setTableHeight}},[a("el-form",{ref:"ruleForm",style:{height:t.layer?"auto":"100%"},attrs:{model:t.ruleForm,"status-icon":""},nativeOn:{submit:function(t){t.preventDefault()}}},[a("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:t.tableData[t.dataName],stripe:!t.setExpand||"50"===t.setExpandColumnWidth,"highlight-current-row":"",border:t.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:t.layer?null:"100%",fit:"","show-header":t.setShowHeader,"row-key":"_internalId","show-summary":t.setSysSummary,"default-expand-all":!t.setShowExpandBtn&&t.setExpand&&"all"===t.setExpandMode,"header-row-style":t.setHeaderRowStyle,"row-style":t.setRowStyle,"row-class-name":t.setRowClass,"cell-style":t.setCellStyle,"header-row-class-name":t.setHeaderRowClass,"default-sort":t.setSortableConfig["default-sort"]},on:{select:t.selectItem,"select-all":t.selectAllItem,"selection-change":t.selectionChange,"expand-change":t.expandChange,"sort-change":t.sortChange,"row-click":t.rowClick,"row-dblclick":t.rowDblclick}},[t.setExpand?[a("el-table-column",{attrs:{type:"expand",width:t.setExpandColumnWidth,align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("multilevel-table",{ref:"multilevelTable",attrs:{"data-custom-table-id":"components_customTable_multilevelTable_index0",tableConfigList:t.tableConfigList,layer:t.layer+1,internalRuleId:e.row._internalId,internalGuid:t.setGuid,parentData:[e.row],rowChain:t.setRowChain,tableSwitchBaseKey:t.columnSwitchBaseKey},on:{databridge:t.databridge,callmethod:t.callParentMethod,"table-dolayout":t.tableDoLayout,"narrow-row":t.narrowRow}})]}}])})]:t._e(),t._v(" "),t.setShowCheckBox?[a("el-table-column",{attrs:{type:"selection",fixed:t.setFixedState,selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.setShowIndex?[a("el-table-column",{attrs:{type:"index",index:t.indexMethod,fixed:t.setFixedState,label:"序号",width:"50",align:"center"}})]:t._e(),t._v(" "),t._l(t.setTitleList,function(e,i){return[e.slot?t._t(e.slot,null,{fixed:t.setFixedList[i]}):Array.isArray(e.component)?[a("el-table-column",t._b({key:i,attrs:{"show-overflow-tooltip":"",fixed:t.setFixedList[i],"min-width":t.setColumnWidth[e.prop]||null,align:"center"},scopedSlots:t._u([{key:"header",fn:function(s){return[a("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:i,isComponent:!0,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[t._v("\n                  "+t._s(e.label)+"\n                ")])]}},{key:"default",fn:function(i){return["button"===e.componentName?a("div",{directives:[{name:"button-width",rawName:"v-button-width",value:e,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":t.setColumnWidth[e.prop]?"space-between":"center"}},t._l(e.component,function(e,s){return void 0!==e.editBtns_isShow&&!e.editBtns_isShow||!e.rowState||t.setButtonState(i.$index,i.row,e)?a("el-button",{key:s,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(t){e.method(i.row,i.$index,i)}}},[t._v(t._s(e.name)+"\n                  ")]):t._e()}),1):t._e()]}}])},"el-table-column",e,!1))]:"object"!=typeof e.component||Array.isArray(e.component)?[e._isShow||"outside"!==t.setTableSetMode?a("el-table-column",{key:i,attrs:{"show-overflow-tooltip":"",label:e.label,prop:e.prop||e.columnIndex,width:e._isShow?e.width||t.constantWidth[e.componentName]||"auto":t.setTableColumnState?"20":"","min-width":e._isShow?e.width||e["min-width"]||t.constantWidth[e.componentName]||t.contentWidthList[i]||"none":"",sortable:!(!t.setSortableConfig[e.prop||e.columnIndex]||!e._isShow),"sort-method":t.setSortableConfig[e.prop||e.columnIndex]&&t.setSortableConfig[e.prop||e.columnIndex]["sort-method"]?t.setSortableConfig[e.prop||e.columnIndex]["sort-method"]:null,"sort-by":t.setSortableConfig[e.prop||e.columnIndex]&&t.setSortableConfig[e.prop||e.columnIndex]["sort-by"]?t.setSortableConfig[e.prop||e.columnIndex]["sort-by"]:null,fixed:t.setFixedList[i],align:"center"},scopedSlots:t._u([{key:"header",fn:function(s){return[a("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:i,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"},{name:"custom-table-switch",rawName:"v-custom-table-switch",value:{config:e,index:i,showSwitch:t.setTableColumnState},expression:"{config:colConfig,index:infoIndex,showSwitch:setTableColumnState}"}],style:{display:e._isShow?"inline-flex":"none","white-space":"nowrap"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(s){return[a("core-index",{directives:[{name:"show",rawName:"v-show",value:!!e._isShow||"outside"===t.setTableSetMode,expression:"colConfig._isShow?true:setTableSetMode === 'outside'"}],attrs:{scope:s,"info-index":i,"col-config":e,runTime:"multilevel"}})]}}])}):t._e()]:a(e.component,{key:i,tag:"component",attrs:{"col-config":e,fixed:t.setFixedList[i]}})]}),t._v(" "),t.setDragTable?[a("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[a("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[a("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)])]}}])})]:t._e()],2)],1),t._v(" "),t.setUseSummary&&t.setCustomSummary.component?[a("custom-summary-option",{attrs:{customSummary:t.setCustomSummary,tempData:t.setTempData,tableData:t.tableData[t.dataName]},on:{"send-height":t.customSummaryHeight,"custom-summary-value":t.customSummaryValue}})]:t._e()],2),t._v(" "),t.setHidePages?t._e():a("div",{staticStyle:{"text-align":"center"},style:{"padding-top":(t.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[a("el-pagination",{attrs:{background:"","current-page":t.tableData.pageData.current,"page-size":t.tableData.pageData.size,layout:"prev, pager, next, jumper",total:t.tableData.pageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.tableData.pageData,"current",e)}}})],1)],1)},[],!1,null,null,null);p.options.__file="index.vue";e.a=p.exports},"9keN":function(t,e,a){},J99a:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf"),a("pIFo"),a("rGqo");var i=a("uTIz"),s=a("2+ib"),o=a("b3I8");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{searchBar:i.a,multilevelTable:s.a,dialogAdd:o.default},name:"dialog-add",props:["initData","visible"],data:function(){return{orderId:"",supplierId:"",supplierName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",table_style:"",orderId:"",orderDtlIds:"",supplierId:"",supplierName:""},rowTableList:[],tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},default:{state:"0",text:"待提交"}}}],apiObj:{apiName:"listPagePurchaseOrders",params:{id:"",fieldCode:"code,supplierName,cdate,applyName,remark,state",queryStr:"",orderStr:"purchaseOrder.code desc"}},tempData:{},showHeader:!0,showIndex:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"4",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},info1:{state:"3",text:"部分签收"},default:{state:"0",text:"待提交"}}}],apiObj:{apiName:"listPagePurchaseOrderDetails",params:{isNeedPage:"false",fieldCode:"productCode,productName,spec,genre,unit,count,arriveCount,price,amount,signDate,state,remark",queryStr:""}},dynamicValue:{parentId:"self@id"},tempData:{},showCheckBox:!0,isSingle:!1,componentId:"twoLevelTable"}]}},created:function(){this.orderId=this.initData.orderId,this.supplierId=this.initData.supplierId,this.supplierName=this.initData.supplierName;var t="detail.id in (select a.id from vmes_purchase_order_detail a left join vmes_purchase_order b on a.parent_id = b.id left join view_purchase_order_detail_by_count c on a.id = c.orderDtlId where b.company_id = '"+this.$storage.get("userInfo").companyId+"' and a.isdisable = '1' and c.arrive_count > 0 )";this.tableConfigList[0].apiObj.params.id=this.orderId,this.tableConfigList[0].apiObj.params.queryStr=t,this.tableConfigList[1].apiObj.params.queryStr=t},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(t){this.rowTableList=[],Array.isArray(t)&&(this.rowTableList=t)},dialogOpen:function(){},dialogClose:function(t){(t={}).resState=this.resState,this.$emit("close-dialog",t||{})},updateData:function(t){this.$refs.customBaseTable.updateData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},closeDialog:function(t){t.resState&&(this.resState=t.resState),this.isVisible=!1},save:function(){var t="";if(null!=this.rowTableList&&0!=this.rowTableList.length||(t="请至少选择一行数据！"),t.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:t});else{var e="";this.rowTableList.forEach(function(t){var a=t.id;null!=a&&a.trim().length>0&&(e=e+a.trim()+",")}),null!=e&&e.trim().length>0&&(e="'"+(e=e.substring(0,e.lastIndexOf(","))).replace(",","','")+"'"),this.dialogData.orderId=this.orderId,this.dialogData.orderDtlIds=e,this.dialogData.supplierId=this.supplierId,this.dialogData.supplierName=this.supplierName;var a=.7*document.body.clientWidth;this.dialogData.dialog_width=a+"px";var i=.666*(.618*a)+"px";this.dialogData.table_style="height:"+i+";width: 96%;margin-left: 2%;",this.dialogData.title="生成退货单",this.openDialogName="dialogAdd",this.showDialog=!0,this.inLinVisible=!0}}}},r=a("KHd+"),d=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{staticStyle:{"padding-top":"10px"}},[a("el-row",{staticStyle:{width:"96%","margin-left":"2%"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_purchase_purchaseRetreat_createRetreatByPurchase_dialogPurchaseOrderDtl0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("下一步")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);d.options.__file="dialogPurchaseOrderDtl.vue";e.default=d.exports},YAWn:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf");var i=a("uTIz"),s=a("2+ib"),o=a("J99a");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{searchBar:i.a,multilevelTable:s.a,dialogPurchaseOrderDtl:o.default},name:"dialog-add",props:["initData","visible"],data:function(){return{searchList:[{label:"采购单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入采购单号"},{label:"供应商",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"请输入供应商"},{label:"状态",type:"select",ruleType:"number",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"采购中"},{value:"3",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"请输入货品名称"}],guid:"",searchObj:{},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",table_style:"",orderId:"",supplierId:"",supplierName:"",title:""},rowTableList:[],tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},default:{state:"0",text:"待提交"}}}],apiObj:{apiName:"listPagePurchaseOrders",params:{queryStr:"",fieldCode:"code,supplierName,cdate,applyName,remark,state",orderStr:"purchaseOrder.code desc"}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,isSingle:!0,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"4",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},info1:{state:"3",text:"部分签收"},default:{state:"0",text:"待提交"}}}],apiObj:{apiName:"listPagePurchaseOrderDetails",params:{isNeedPage:"false",fieldCode:"productCode,productName,spec,genre,unit,count,arriveCount,price,amount,signDate,state,remark",queryStr:""}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}]}},created:function(){var t="detail.id in (select a.id from vmes_purchase_order_detail a left join vmes_purchase_order b on a.parent_id = b.id left join view_purchase_order_detail_by_count c on a.id = c.orderDtlId where b.company_id = '"+this.$storage.get("userInfo").companyId+"' and a.isdisable = '1' and c.arrive_count > 0 )";this.tableConfigList[0].apiObj.params.queryStr=t,this.tableConfigList[1].apiObj.params.queryStr=t},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(t)},databridge:function(t){this.rowTableList=[],Array.isArray(t)&&(this.rowTableList=t)},dialogOpen:function(){},dialogClose:function(t){(t={}).resState=this.resState,this.$emit("close-dialog",t||{})},updateData:function(t){this.$refs.customBaseTable.updateData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},closeDialog:function(t){t.resState&&(this.resState=t.resState),this.isVisible=!1},save:function(){var t="";if(null==this.rowTableList||0==this.rowTableList.length?t="请选择一行数据！":this.rowTableList.length>1&&(t="请选择一行数据，只允许单选！"),t.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:t});else{var e=this.rowTableList[0].id;this.dialogData.orderId=e,this.dialogData.supplierId=this.rowTableList[0].supplierId,this.dialogData.supplierName=this.rowTableList[0].supplierName;var a=.7*document.body.clientWidth;this.dialogData.dialog_width=a+"px";var i=.75*(.618*a)+"px";this.dialogData.table_style="height:"+i+";width: 96%;margin-left: 2%;",this.dialogData.title="采购订单明细",this.openDialogName="dialogPurchaseOrderDtl",this.showDialog=!0,this.inLinVisible=!0}}}},r=a("KHd+"),d=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticStyle:{width:"96%","margin-left":"2%"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_purchase_purchaseRetreat_createRetreatByPurchase_dialogPurchaseOrder0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("下一步")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);d.options.__file="dialogPurchaseOrder.vue";e.default=d.exports},b3I8:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf"),a("rGqo");var i=a("uTIz"),s=a("2+ib"),o=a("spKr");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}function l(t,e,a){return e in t?Object.defineProperty(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}var r={components:{searchBar:i.a,multilevelTable:s.a},name:"dialog-add",props:["initData","visible"],data:function(){var t,e=this;return l(t={orderId:"",supplierId:"",supplierName:"",formData:{cuserName:"",supplierName:"",type:"",typeName:"",remark:""},rules:{typeName:[{required:!0,trigger:"change",validator:function(t,a,i){e.typeData.defaultSelected.length<=0?i(new Error("请选择退货类型")):i()}}]},dialogLoading:!0,isVisible:!1,inDialog:!0},"formData",{}),l(t,"openDialogName",""),l(t,"showDialog",!1),l(t,"inLinVisible",!1),l(t,"dialogData",{dialog_width:"",table_style:"",orderId:"",orderDtlIds:""}),l(t,"rowTableList",[]),l(t,"tableConfigList",[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},default:{state:"0",text:"待提交"}}}],apiObj:{apiName:"listPagePurchaseOrders",params:{id:"",fieldCode:"code,supplierName,cdate,applyName,remark,state",orderStr:"purchaseOrder.code desc"}},tempData:{},showHeader:!0,showIndex:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"retreatCount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+\\.{0,1}[0-9]{0,2}$"},{lessThan:["self@maxRetreatCount",!0]},{greaterThan:["0",!1]}],message:["请输入大于零的正整数或(1,2)位小数！","必须小于等于可退货数！","必须大于零！"]}},{columnIndex:"retreatRemark",componentName:"input",_cellConfig:{}}],apiObj:{apiName:"listPageOrderDetailByRetreat",params:{isNeedPage:"false",fieldCode:"productCode,productName,productSpec,productGenreName,unitName,count,maxRetreatCount,retreatCount,retreatRemark",detailIds:""}},dynamicValue:{parentId:"self@id"},tempData:{},isSingle:!1,componentId:"twoLevelTable"}]),l(t,"typeData",{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"retreatType",isglobal:"1"}},defaultSelected:[]}),t},created:function(){this.orderId=this.initData.orderId,this.supplierId=this.initData.supplierId,this.supplierName=this.initData.supplierName;var t=this.$storage.get("userInfo");this.formData.cuserName=t.userName,this.formData.supplierName=this.supplierName;var e="";null!=this.initData.orderDtlIds&&this.initData.orderDtlIds.trim().length>0&&(e=this.initData.orderDtlIds.trim()),this.tableConfigList[0].apiObj.params.id=this.orderId,this.tableConfigList[1].apiObj.params.detailIds=e},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(t){this.rowTableList=[],Array.isArray(t)&&(this.rowTableList=t)},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},updateData:function(t){this.$refs.customBaseTable.updateData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},closeDialog:function(t){},typeSelect:function(t){t[0]?(this.formData.type=t[0],this.typeData.defaultSelected=[t[0]]):(this.formData.type=[],this.typeData.defaultSelected=[])},save:function(){var t=this;this.$refs.submitForm.validate(function(e){if(e&&(t.$refs.retreatAddDialog.getData(),null!=t.rowTableList&&t.rowTableList.length>0)){var a=t.findChildrenList(t.rowTableList);t.savePurchaseRetreat(a)}})},findChildrenList:function(t){var e=[];return null!=t&&null!=t[0].children&&t[0].children.length>0&&t[0].children.forEach(function(t){e.push(t)}),e},checkColumn:function(t){for(var e="",a=0;a<t.length;a++){var i=t[a],s=i.retreatCount;s-i.maxRetreatCount>0&&(e=e+"第 "+(a+1)+" 行: 本次退货数量("+s+") 输入错误，本次退货数量不可大于可退货数量！")}return e},savePurchaseRetreat:function(t){var e=this;if(null!=t&&0!=t.length){var a=this.checkColumn(t);if(null!=a&&a.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:a});else{var i=[];t.forEach(function(t){var e={orderDetailId:t.id,productId:t.productId,unit:t.unit,count:t.retreatCount,remark:t.retreatRemark,price:t.price};i.push(e)});var s="";null!=i&&i.length>0&&(s=JSON.stringify(i)),null!=s&&0!=s?Object(o.addPurchaseRetreat)({orderId:this.orderId,supplierId:this.supplierId,type:this.formData.type,remark:this.formData.remark,dtlJsonStr:s}).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"暂无采购订单明细！"})}}}}},d=a("KHd+"),u=Object(d.a)(r,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",[a("el-form",{ref:"submitForm",staticStyle:{"padding-top":"10px","padding-right":"15px","padding-left":"15px"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"90px"}},[a("el-row",[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"退货类型:",prop:"typeName"}},[a("base-input-select",{attrs:{data:t.typeData.data},on:{callback:t.typeSelect},model:{value:t.typeData.defaultSelected,callback:function(e){t.$set(t.typeData,"defaultSelected",e)},expression:"typeData.defaultSelected"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"供应商名称:",prop:"deptName"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.formData.supplierName,callback:function(e){t.$set(t.formData,"supplierName",e)},expression:"formData.supplierName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.formData.cuserName,callback:function(e){t.$set(t.formData,"cuserName",e)},expression:"formData.cuserName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[a("el-input",{model:{value:t.formData.remark,callback:function(e){t.$set(t.formData,"remark",e)},expression:"formData.remark"}})],1)],1)],1)],1),t._v(" "),a("el-row",{staticStyle:{width:"96%","margin-left":"2%"}},[a("multilevel-table",{ref:"retreatAddDialog",attrs:{"data-custom-table-id":"views_purchase_purchaseRetreat_createRetreatByPurchase_dialogAdd0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);u.options.__file="dialogAdd.vue";e.default=u.exports},"jB/s":function(t,e,a){"use strict";var i=a("rXsy");a.n(i).a},q7oa:function(t,e,a){"use strict";var i=a("9keN");a.n(i).a},rXsy:function(t,e,a){}}]);