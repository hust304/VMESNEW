(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-5d6a","chunk-336d"],{"2+ib":function(e,t,a){"use strict";a("dRSK"),a("INYr"),a("91GP"),a("Vd3H"),a("rGqo"),a("f3/d"),a("xfY5");var i=a("8WZi"),o=a("z0WU"),n=a("DKCI"),s=a("50Ol"),l=a("F9dT"),r=(a("Yfch"),a("YP4+")),d=a("WwWg"),c=(a("evdt"),a("mwzG")),h={name:"multilevel-table",mixins:[i.a],provide:function(){return{rootVm:this}},props:{expand:[Boolean],expandMode:[String],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,showColList:"",headerWidthList:[],listLength:-1,restaurants:[],fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:n.a,customSummaryOption:s.a},computed:{setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer,defaultSpacingClass:!this.layer&&this.maxLayer>1,noSpacingClass:this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return!!this.layer&&(!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2))}},created:function(){var e=this;if(!this.layer)if(this.guid=Object(o.a)(),this.userInfo=this.$storage.get("userInfo"),Object(d.c)(this),this.initData.result){var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var t=JSON.parse(JSON.stringify(c.a));e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:t,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1},1e3):this.httpRequests());this.layer&&(this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.tableData[this.dataName].forEach(function(e){e.rowState="1"}),this.setDragTable&&this.setSort(),this.initLoading=!1,this.tableDoLayout()):(this.$emit("narrow-row",this.parentData[0]),this.initLoading=!1,this.tableDoLayout()))},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){var e=this;this.tempCheckedList.forEach(function(t){e.$store.commit(e.setGuid+"/DELETE_CHECKED",[t])}),!this.layer&&Object(d.g)(this.$store,this.guid)},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay()},initData:function(){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.initLoading=!1},resetContentWidthList:function(){var e=this,t=this.resetContentWidthList.map(function(e){return null});this.resetContentWidthList.forEach(function(a,i){e.useMiddleValue=!1,t[i]=e.contentWidthAlgorithm(a.map(function(e){return Math.max.apply(null,e)})),e.useMiddleValueList[i]=e.useMiddleValue}),t.forEach(function(t,a){e.contentWidthList[a]=t?t+26:null})}},methods:{contentWidthAlgorithm:function(e){if(e&&e.length){if(e.length>1){var t=Math.max.apply(null,e);if(t-Math.min.apply(null,e)>this.setWidthDiffValue){var a,i=[].concat(e);return i.sort(o.d),a=i.length%2==0?(i[i.length/2-1]+i[i.length/2])/2:i[(i.length+1)/2-1],this.useMiddleValue=!0,t-a>this.setWidthDiffValue&&(a=2*this.setWidthDiffValue),a}return t}return e[0]}return null},databridge:function(e,t){this.$emit("databridge",e,t)},expandChange:function(e,t){var a=this;"one"===this.setExpandMode&&t.forEach(function(a,i){e._internalId!==a._internalId&&t.splice(i,1)}),this.$refs.baseTable.$nextTick(function(e){a.$refs.baseTable&&a.$refs.baseTable.doLayout&&a.$refs.baseTable.doLayout(),a.$emit("table-dolayout")})},setRowExpansion:function(e,t){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(e,t)},httpRequests:function(e){var t=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:e||1},this.searchObj)).then(function(a){t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:a,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.initLoading=!1,e&&(t.pageNo=e,t.scrollTable())}).catch(function(e){console.log(e),t.initLoading=!1})},httpChildrenRequests:function(e,t){var a=this;this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:t||1},this.setParams(e,this.setApiObj),this.setDynaValue(e))).then(function(i){a.$store.commit(a.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:i,row:e,vm:a}),a.setDragTable&&a.setSort(),a.pageNo=a.tableData[a.dataName].pageData&&a.tableData[a.dataName].pageData.current||1,a.initLoading=!1,a.tableDoLayout(),t&&a.scrollTable()}).catch(function(e){console.log(e),a.initLoading=!1})},selectItem:function(e,t){e.findIndex(function(e){return e._internalId===t._internalId})>-1?(this.tempCheckedList.push(t),this.$store.commit(this.setGuid+"/ADD_CHECKED",[t])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[t]),this.tempCheckedList=this.tempCheckedList.filter(function(e){return e._internalId!==t._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:e.length?"0":"1"}),e.length?(this.tableData[this.dataName].forEach(function(e){e.rowState="0"}),e[0].rowState="1"):this.tableData[this.dataName].forEach(function(e){e.rowState="1"}))},selectAllItem:function(e){if(this.setIsSingle){if(e.length)for(var t=e.length-1;t>=0;t--)e.splice(t,1)}else e.length?(this.tempCheckedList=e.map(function(e){return e}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(e){e!==this.pageNo&&this.httpRequests(e)},setDynaValue:function(e){if(this.setDynamicValue){var t={};for(var a in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(a)&&(t[a]=Object(l.c)([this.setDynamicValue[a]],e,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return t}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setCellStyle:function(e){return this.setExpand&&2===this.maxLayer&&"1"===this.setExpandColumnWidth?{"border-bottom":"none","background-color":"inherit"}:{"background-color":"inherit"}},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(e,t){var a=this;return t&&e?(this.resultTableData=(e.tableData||e.children).find(function(e){if(e._internalId===t)return!0;if(e.children&&e.children.length){var i={titleList:e.titleList,children:e.children,pageData:e.pageData||{}};a.resultTableData=a.searchTableData(i,t)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(e){this.$emit("callmethod",e)},tableDoLayout:function(){var e=this;this.$nextTick(function(t){e.$refs.baseTable&&e.$refs.baseTable.doLayout&&e.$refs.baseTable.doLayout(),e.$emit("table-dolayout")})}}},u=(a("q7oa"),a("KHd+")),m=Object(u.a)(h,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.setTableLoading,expression:"setTableLoading"}],staticClass:"myCoustomTable resetCoustomTableStyle",class:e.setTableClass},[e.setShowTableSet?a("table-filter",{attrs:{headerList:e.setColConfigs,storeId:e.pageId,componentId:e.setComponentId,showAll:e.setShowAll},on:{"checked-list":e.checkedList,"checked-height":e.checkedHeight}}):e._e(),e._v(" "),a("div",{style:{height:e.setTableHeight}},[a("el-form",{ref:"ruleForm",style:{height:e.layer?"auto":"100%"},attrs:{model:e.ruleForm,"status-icon":""},nativeOn:{submit:function(e){e.preventDefault()}}},[a("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:e.tableData[e.dataName],stripe:!e.setExpand||"50"===e.setExpandColumnWidth,"highlight-current-row":"",border:e.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:e.layer?null:"100%",fit:"","show-header":e.setShowHeader,"row-key":"_internalId","show-summary":e.setSysSummary,"default-expand-all":!e.setShowExpandBtn&&e.setExpand&&"all"===e.setExpandMode,"header-row-style":e.setHeaderRowStyle,"row-style":e.setRowStyle,"row-class-name":e.setRowClass,"cell-style":e.setCellStyle,"header-row-class-name":e.setHeaderRowClass,"default-sort":e.setSortableConfig["default-sort"]},on:{select:e.selectItem,"select-all":e.selectAllItem,"selection-change":e.selectionChange,"expand-change":e.expandChange,"sort-change":e.sortChange,"row-click":e.rowClick,"row-dblclick":e.rowDblclick}},[e.setExpand?[a("el-table-column",{attrs:{type:"expand",width:e.setExpandColumnWidth,align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("multilevel-table",{attrs:{tableConfigList:e.tableConfigList,layer:e.layer+1,internalGuid:e.setGuid,parentData:[t.row],rowChain:e.setRowChain},on:{databridge:e.databridge,callmethod:e.callParentMethod,"table-dolayout":e.tableDoLayout,"narrow-row":e.narrowRow}})]}}])})]:e._e(),e._v(" "),e.setShowCheckBox?[a("el-table-column",{attrs:{type:"selection",fixed:e.setFixedState,selectable:e.selectable,width:"55",align:"center"}})]:e._e(),e._v(" "),e.setShowIndex?[a("el-table-column",{attrs:{type:"index",index:e.indexMethod,fixed:e.setFixedState,label:"序号",width:"50",align:"center"}})]:e._e(),e._v(" "),e._l(e.setTitleList,function(t,i){return[t.slot&&t._isShow?e._t(t.slot,null,{fixed:e.setFixedList[i]}):Array.isArray(t.component)&&t._isShow?[a("el-table-column",e._b({key:i,attrs:{"show-overflow-tooltip":"",fixed:e.setFixedList[i],"min-width":e.setColumnWidth[t.prop]||null,align:"center"},scopedSlots:e._u([{key:"header",fn:function(o){return[a("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:i,isComponent:!0,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[e._v("\n                  "+e._s(t.label)+"\n                ")])]}},{key:"default",fn:function(i){return["button"===t.componentName?a("div",{directives:[{name:"button-width",rawName:"v-button-width",value:t,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":e.setColumnWidth[t.prop]?"space-between":"center"}},e._l(t.component,function(t,o){return void 0!==t.editBtns_isShow&&!t.editBtns_isShow||!t.rowState||e.setButtonState(i.$index,i.row,t)?a("el-button",{key:o,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(e){t.method(i.row,i.$index,i)}}},[e._v(e._s(t.name)+"\n                  ")]):e._e()}),1):e._e()]}}])},"el-table-column",t,!1))]:"object"==typeof t.component&&t._isShow?a(t.component,{key:i,tag:"component",attrs:{"col-config":t,fixed:e.setFixedList[i]}}):[t._isShow?a("el-table-column",{key:i,attrs:{"show-overflow-tooltip":"",label:t.label,prop:t.prop||t.columnIndex,width:t.width||e.constantWidth[t.componentName]||"auto","min-width":t["min-width"]||e.contentWidthList[i]||"none",sortable:!!e.setSortableConfig[t.prop||t.columnIndex],"sort-method":e.setSortableConfig[t.prop||t.columnIndex]&&e.setSortableConfig[t.prop||t.columnIndex]["sort-method"]?e.setSortableConfig[t.prop||t.columnIndex]["sort-method"]:null,"sort-by":e.setSortableConfig[t.prop||t.columnIndex]&&e.setSortableConfig[t.prop||t.columnIndex]["sort-by"]?e.setSortableConfig[t.prop||t.columnIndex]["sort-by"]:null,fixed:e.setFixedList[i],align:"center"},scopedSlots:e._u([{key:"header",fn:function(o){return[a("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:i,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"}],style:{display:t._isShow?"inline-flex":"none"},domProps:{textContent:e._s(t.label)}})]}},{key:"default",fn:function(e){return[a("core-index",{attrs:{scope:e,"info-index":i,"col-config":t,runTime:"multilevel"}})]}}])}):e._e()]]}),e._v(" "),e.setDragTable?[a("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[a("div",{staticStyle:{display:"inline-block"},on:{click:function(t){return t.stopPropagation(),e.clickStop(t)},dblclick:function(t){return t.stopPropagation(),e.clickStop(t)}}},[a("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)])]}}])})]:e._e()],2)],1),e._v(" "),e.setUseSummary&&e.setCustomSummary.component?[a("custom-summary-option",{attrs:{customSummary:e.setCustomSummary,tempData:e.setTempData,tableData:e.tableData[e.dataName]},on:{"send-height":e.customSummaryHeight,"custom-summary-value":e.customSummaryValue}})]:e._e()],2),e._v(" "),e.setHidePages?e._e():a("div",{staticStyle:{"text-align":"center"},style:{"padding-top":(e.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[a("el-pagination",{attrs:{background:"","current-page":e.tableData.pageData.current,"page-size":e.tableData.pageData.size,layout:"prev, pager, next, jumper",total:e.tableData.pageData.total-0},on:{"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.tableData.pageData,"current",t)}}})],1)],1)},[],!1,null,null,null);m.options.__file="index.vue";t.a=m.exports},"5Fd+":function(e,t,a){"use strict";a.r(t);var i=a("WIyV"),o=a("2+ib"),n=a("8Vv6"),s={components:{customBaseTable:i.a,multilevelTable:o.a},name:"dialog-edit",props:["initData","visible"],data:function(){return{orderId:"",orderObject:{},orderCollect:{},isShowText:!1,rowData:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",tempLable:null,data:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tableConfigList:[{customColumn:[],apiObj:{apiName:"listPageOrderDetailCollectByInfo",params:{pageNo:1,parentId:this.initData.orderId,fieldCode:"productCode,productName,productSpec,productGenreName,orderUnitName,orderCount,productPrice,productSum,deliverCount,deliverSum,retreatCount,retreatSum,invoiceCount,invoiceSum,deliverDate"}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"5",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待生产"},info3:{state:"3",text:"待出库"},info4:{state:"4",text:"待发货"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageSaleDeliverDetail",params:{pageNo:1,state:"1",orderStr:"detail.product_id,detail.cdate asc",fieldCode:"deliverCode,orderCount,productPrice,sum,cdate,deliverDate"}},dynamicValue:{orderDetaiId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],tableData_deliverDetail:[],apiObj_deliverDetail:{apiName:"listPageSaleReceiveDetails",params:{pageNo:1,state:"1",orderId:this.initData.orderId,orderStr:" receive.code desc",fieldCode:"code,productName,orderSum,discountAmount,receiveAmount,state"}},customColumn_deliverDetail:[],mergeTitle_deliverDetail:[],mergeColumn_deliverDetail:[],mergeRow_deliverDetail:[],keyMapping_deliverDetail:{},tempData_deliverDetail:{}}},beforeCreate:function(){},created:function(){this.orderObject=this.initData.orderObject,this.orderId=this.initData.orderId,this.apiObj_deliverDetail.params.orderId=this.orderId,this.findOrderCollectByOrderId(this.orderId)},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},databridge:function(e){},dialogOpen:function(){this.$nextTick(function(){})},dialogClose:function(e){this.$emit("close-dialog",e||{})},findOrderCollectByOrderId:function(e){var t=this;this.dialogLoading=!0,Object(n.getSaleOrderCollectByOrderId)({id:e}).then(function(e){t.dialogLoading=!1,0===e.code&&null!=e.result&&null!=e.result.varList&&e.result.varList.length>0&&(t.orderCollect=e.result.varList[0])}).catch(function(e){console.log(e),t.dialogLoading=!1})}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}}},l=(a("ghff"),a("KHd+")),r=Object(l.a)(s,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width,layoutType:2},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[a("div",[a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{margin:"1em 2em"}},[a("el-row",{staticStyle:{"margin-bottom":"10px"}},[a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("订单编号  :  ")]),e._v(e._s(e.orderCollect.sysCode))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("订单状态  :  ")]),e._v(e._s(e.orderCollect.stateName))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("制单人  :  ")]),e._v(e._s(e.orderCollect.makeName))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("下单日期  :  ")]),e._v(e._s(e.orderCollect.orderDate))])])],1),e._v(" "),a("el-row",{staticStyle:{"margin-bottom":"10px"}},[a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("客户名称  :  ")]),e._v(e._s(e.orderCollect.customerName))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("约定交期  :  ")]),e._v(e._s(e.orderCollect.expectDate))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("发票类型  :  ")]),e._v(e._s(e.orderCollect.receiptTypeName))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("审核人:")]),e._v(e._s(e.orderCollect.auditName))])])],1),e._v(" "),a("el-row",{staticStyle:{"margin-bottom":"10px"}},[a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("发货完成日期  :  ")]),e._v(e._s(e.orderCollect.deliverDate))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("付款完成日期  :  ")]),e._v(e._s(e.orderCollect.payDate))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("账期截止日  :  ")]),e._v(e._s(e.orderCollect.deadlineDate))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.daysRemaining<0&&e.orderCollect.nowReceiveAmount>0,expression:"orderCollect.daysRemaining<0&&orderCollect.nowReceiveAmount>0"}],staticStyle:{color:"red"}},[a("b",[e._v("逾期(天)  :  ")]),e._v(e._s(-e.orderCollect.daysRemaining))]),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.daysRemaining<0&&e.orderCollect.nowReceiveAmount<=0,expression:"orderCollect.daysRemaining<0&&orderCollect.nowReceiveAmount<=0"}]},[a("b",[e._v("账期剩余(天)  :  ")]),e._v("0")]),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.daysRemaining>=0,expression:"orderCollect.daysRemaining>=0"}]},[a("b",[e._v("账期剩余(天)  :  ")]),e._v(e._s(e.orderCollect.daysRemaining))])])],1),e._v(" "),a("el-row",{staticStyle:{"margin-bottom":"10px"}},[a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("发货金额  :  ")]),e._v(e._s(e.orderCollect.deliverAmount))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("退货金额  :  ")]),e._v(e._s(e.orderCollect.retreatAmount))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("实收金额  :  ")]),e._v(e._s(e.orderCollect.receivedAmount))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("折扣金额  :  ")]),e._v(e._s(e.orderCollect.discountedAmount))])])],1),e._v(" "),a("el-row",{staticStyle:{"margin-bottom":"10px"}},[a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("订单金额  :  ")]),e._v(e._s(e.orderCollect.orderAmount))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("预付款  :  ")]),e._v(e._s(e.orderCollect.advanceAmount))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",{directives:[{name:"show",rawName:"v-show",value:0==e.orderCollect.nowReceiveAmount&&0==e.orderCollect.preReceiveAmount,expression:"orderCollect.nowReceiveAmount==0&&orderCollect.preReceiveAmount==0"}]},[a("b",[e._v("应收金额  :  ")]),e._v(e._s(e.orderCollect.nowReceiveAmount))]),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.nowReceiveAmount>0&&0==e.orderCollect.preReceiveAmount,expression:"orderCollect.nowReceiveAmount>0&&orderCollect.preReceiveAmount==0"}]},[a("b",[e._v("应收金额  :  ")]),e._v(e._s(e.orderCollect.nowReceiveAmount))]),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.preReceiveAmount>0&&0==e.orderCollect.nowReceiveAmount,expression:"orderCollect.preReceiveAmount>0&&orderCollect.nowReceiveAmount==0"}]},[a("b",[e._v("预收金额  :  ")]),e._v(e._s(e.orderCollect.preReceiveAmount))])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",[a("b",[e._v("开票金额  :  ")]),e._v(e._s(e.orderCollect.invoiceAmount))])])],1),e._v(" "),a("el-row",{staticStyle:{"margin-bottom":"10px"}},[a("el-col",{attrs:{span:6}},[a("div",{directives:[{name:"show",rawName:"v-show",value:e.orderCollect.daysRemaining<0&&e.orderCollect.nowReceiveAmount>0,expression:"orderCollect.daysRemaining<0&&orderCollect.nowReceiveAmount>0"}],staticStyle:{color:"red"}},[a("b",[e._v("逾期金额  :  ")]),e._v(e._s(e.orderCollect.nowReceiveAmount))])]),e._v(" "),a("el-col",{attrs:{span:18}},[a("div",[a("b",[e._v("备注  :  ")]),e._v(e._s(e.orderCollect.remark))])])],1)],1),e._v(" "),a("el-row",{style:e.initData.orderDetail_style},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1),e._v(" "),a("br"),e._v(" "),a("el-row",{style:e.initData.deliverDetail_style},[a("custom-base-table",{ref:"deliverDetailDialog",attrs:{isSortable:!1,varList:e.tableData_deliverDetail,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn_deliverDetail,apiObj:e.apiObj_deliverDetail,mergeTitle:e.mergeTitle_deliverDetail,mergeColumn:e.mergeColumn_deliverDetail,mergeRow:e.mergeRow_deliverDetail,tempData:e.tempData_deliverDetail,componentId:"deliverDetailDialog",useDefaultBtn:!1,showAll:!1,keyMapping:e.keyMapping_deliverDetail,hidePages:!0},on:{databridge:e.databridge}})],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);r.options.__file="orderCollect.vue";t.default=r.exports},D2yE:function(e,t,a){},S8Ej:function(e,t,a){},ghff:function(e,t,a){"use strict";var i=a("S8Ej");a.n(i).a},q7oa:function(e,t,a){"use strict";var i=a("D2yE");a.n(i).a}}]);