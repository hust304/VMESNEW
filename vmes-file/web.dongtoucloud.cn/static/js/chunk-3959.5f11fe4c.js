(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-3959","chunk-2c81","chunk-57a1","chunk-3ee3"],{"2+ib":function(t,e,a){"use strict";a("dRSK"),a("INYr"),a("91GP"),a("Vd3H"),a("rGqo"),a("f3/d"),a("xfY5");var i=a("8WZi"),s=a("z0WU"),n=a("DKCI"),o=a("50Ol"),l=a("F9dT"),r=(a("Yfch"),a("YP4+")),c=a("WwWg"),d=(a("evdt"),a("mwzG")),u={name:"multilevel-table",mixins:[i.a],provide:function(){return{rootVm:this}},props:{expand:[Boolean],expandMode:[String],rootWidth:[String,Number],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,headerWidthList:[],listLength:-1,restaurants:[],fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:n.a,customSummaryOption:o.a},computed:{setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer,defaultSpacingClass:!this.layer&&this.maxLayer>1,noSpacingClass:this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return this.layer?!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2):!!this.setShowTableSet},setRootWidth:function(){return this.layer?"100%":this.layerConfig.rootWidth||this.rootWidth?"".concat((this.layerConfig.rootWidth||this.rootWidth)+"","px"):"100%"}},created:function(){var t=this;if(!this.layer)if(this.guid=Object(s.a)(),Object(c.c)(this),this.initData.result){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:"root",vm:this}),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var e=JSON.parse(JSON.stringify(d.a));t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:e,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.$store.commit(t.guid+"/SET_TABLERULELIST",{cb:t.tableRuleForm,ruleId:"root",vm:t}),t.initLoading=!1},1e3):this.httpRequests());this.layer&&(this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.tableData[this.dataName].forEach(function(t){t.rowState="1"}),this.setDragTable&&this.setSort(),this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:this.internalRuleId,vm:this}),this.initLoading=!1,this.tableDoLayout()):(this.$emit("narrow-row",this.parentData[0]),this.initLoading=!1,this.tableDoLayout()))},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){var t=this;this.$store.state[this.setGuid]&&this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:null,ruleId:this.layer?this.internalRuleId:"root"}),this.tempCheckedList.forEach(function(e){t.$store.commit(t.setGuid+"/DELETE_CHECKED",[e])}),!this.layer&&Object(c.g)(this.$store,this.guid)},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay(),this.tableDoLayout()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay(),this.tableDoLayout()},initData:function(){this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:null,ruleId:this.layer?this.internalRuleId:"root"});var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:this.layer?this.internalRuleId:"root",vm:this}),this.initLoading=!1,this.tableDoLayout()},resetContentWidthList:function(){var t=this,e=this.resetContentWidthList.map(function(t){return null});this.resetContentWidthList.forEach(function(a,i){t.useMiddleValue=!1,e[i]=t.contentWidthAlgorithm(a.map(function(t){return Math.max.apply(null,t)})),t.useMiddleValueList[i]=t.useMiddleValue}),e.forEach(function(e,a){t.contentWidthList[a]=e?e+26:null})}},methods:{contentWidthAlgorithm:function(t){if(this.setWidthDiffValue&&t&&t.length){if(t.length>1){var e=Math.max.apply(null,t);if(e-Math.min.apply(null,t)>this.setWidthDiffValue){var a,i=[].concat(t);return i.sort(s.d),a=i.length%2==0?(i[i.length/2-1]+i[i.length/2])/2:i[(i.length+1)/2-1],this.useMiddleValue=!0,e-a>this.setWidthDiffValue&&(a=2*this.setWidthDiffValue),a}return e}return t[0]}return null},databridge:function(t,e){this.$emit("databridge",t,e)},expandChange:function(t,e){var a=this;"one"===this.setExpandMode&&e.forEach(function(a,i){t._internalId!==a._internalId&&e.splice(i,1)}),this.$refs.baseTable.$nextTick(function(t){a.$refs.baseTable&&a.$refs.baseTable.doLayout&&a.$refs.baseTable.doLayout(),a.$emit("table-dolayout")})},setRowExpansion:function(t,e){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(t,e)},httpRequests:function(t){var e=this;this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:null,ruleId:"root"}),this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:t||1},this.searchObj)).then(function(a){e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:a,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1,t&&(e.pageNo=t,e.scrollTable()),e.tableDoLayout(),e.$store.commit(e.guid+"/SET_TABLERULELIST",{cb:e.tableRuleForm,ruleId:"root",vm:e})}).catch(function(t){console.log(t),e.initLoading=!1})},httpChildrenRequests:function(t,e){var a=this;this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:null,ruleId:this.internalRuleId}),this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:e||1},this.setParams(t,this.setApiObj),this.setDynaValue(t))).then(function(i){a.$store.commit(a.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:i,row:t,vm:a}),a.setDragTable&&a.setSort(),a.pageNo=a.tableData[a.dataName].pageData&&a.tableData[a.dataName].pageData.current||1,a.initLoading=!1,a.tableDoLayout(),e&&a.scrollTable(),a.$store.commit(a.setGuid+"/SET_TABLERULELIST",{cb:a.tableRuleForm,ruleId:a.internalRuleId,vm:a})}).catch(function(t){console.log(t),a.initLoading=!1})},selectItem:function(t,e){t.findIndex(function(t){return t._internalId===e._internalId})>-1?(this.tempCheckedList.push(e),this.$store.commit(this.setGuid+"/ADD_CHECKED",[e])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[e]),this.tempCheckedList=this.tempCheckedList.filter(function(t){return t._internalId!==e._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:t.length?"0":"1"}),t.length?(this.tableData[this.dataName].forEach(function(t){t.rowState="0"}),t[0].rowState="1"):this.tableData[this.dataName].forEach(function(t){t.rowState="1"}))},selectAllItem:function(t){if(this.setIsSingle){if(t.length)for(var e=t.length-1;e>=0;e--)t.splice(e,1)}else t.length?(this.tempCheckedList=t.map(function(t){return t}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(t){t!==this.pageNo&&this.httpRequests(t)},setDynaValue:function(t){if(this.setDynamicValue){var e={};for(var a in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(a)&&(e[a]=Object(l.c)([this.setDynamicValue[a]],t,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return e}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(t,e){var a=this;return e&&t?(this.resultTableData=(t.tableData||t.children).find(function(t){if(t._internalId===e)return!0;if(t.children&&t.children.length){var i={titleList:t.titleList,children:t.children,pageData:t.pageData||{}};a.resultTableData=a.searchTableData(i,e)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(t){this.$emit("callmethod",t)},tableDoLayout:function(){var t=this;this.$nextTick(function(e){t.$refs.baseTable&&t.$refs.baseTable.doLayout&&t.$refs.baseTable.doLayout(),t.layer&&t.$emit("table-dolayout")})}}},h=(a("q7oa"),a("jB/s"),a("KHd+")),m=Object(h.a)(u,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.setTableLoading,expression:"setTableLoading"}],staticClass:"myCoustomTable resetCoustomTableStyle",class:t.setTableClass},[t.setShowTableSet&&"outside"===t.setTableSetMode&&!t.layer?a("table-filter",{attrs:{headerList:t.setColConfigs,tableSwitchState:t.setTableSwitch,storeId:t.pageId,componentId:t.setComponentId},on:{"checked-list":t.checkedList,"checked-height":t.checkedHeight}}):t._e(),t._v(" "),a("div",{style:{height:t.setTableHeight}},[a("el-form",{ref:"ruleForm",style:{height:t.layer?"auto":"100%"},attrs:{model:t.ruleForm,"status-icon":""},nativeOn:{submit:function(t){t.preventDefault()}}},[a("el-table",{ref:"baseTable",style:{width:t.setRootWidth},attrs:{data:t.tableData[t.dataName],stripe:!t.setExpand||"50"===t.setExpandColumnWidth,"highlight-current-row":"",border:t.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:t.layer?null:"100%",fit:"","show-header":t.setShowHeader,"row-key":"_internalId","show-summary":t.setSysSummary,"default-expand-all":!t.setShowExpandBtn&&t.setExpand&&"all"===t.setExpandMode,"header-row-style":t.setHeaderRowStyle,"row-style":t.setRowStyle,"row-class-name":t.setRowClass,"cell-style":t.setCellStyle,"header-cell-style":t.setHeaderCellStyle,"header-row-class-name":t.setHeaderRowClass,"default-sort":t.setSortableConfig["default-sort"]},on:{select:t.selectItem,"select-all":t.selectAllItem,"selection-change":t.selectionChange,"expand-change":t.expandChange,"sort-change":t.sortChange,"row-click":t.rowClick,"row-dblclick":t.rowDblclick}},[t.setExpand?[a("el-table-column",{attrs:{type:"expand",width:t.setExpandColumnWidth,align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("multilevel-table",{ref:"multilevelTable",attrs:{"data-custom-table-id":"components_customTable_multilevelTable_index0",tableConfigList:t.tableConfigList,layer:t.layer+1,internalRuleId:e.row._internalId,internalGuid:t.setGuid,parentData:[e.row],rowChain:t.setRowChain,tableSwitchBaseKey:t.columnSwitchBaseKey},on:{databridge:t.databridge,callmethod:t.callParentMethod,"table-dolayout":t.tableDoLayout,"narrow-row":t.narrowRow}})]}}])})]:t._e(),t._v(" "),t.setShowCheckBox?[a("el-table-column",{attrs:{type:"selection",fixed:t.setFixedState,selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.setShowIndex?[a("el-table-column",{attrs:{type:"index",index:t.indexMethod,fixed:t.setFixedState,label:"序号",width:"50",align:"center"}})]:t._e(),t._v(" "),t._l(t.setTitleList,function(e,i){return[e.slot?t._t(e.slot,null,{fixed:t.setFixedList[i]}):Array.isArray(e.component)?[a("el-table-column",t._b({key:i,attrs:{"show-overflow-tooltip":"",fixed:t.setFixedList[i],"min-width":e.width||t.setColumnWidth[e.prop]||null,align:"center"},scopedSlots:t._u([{key:"header",fn:function(s){return[a("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:i,isComponent:!0,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[t._v("\n                  "+t._s(e.label)+"\n                ")])]}},{key:"default",fn:function(i){return["button"===e.componentName?a("div",{directives:[{name:"button-width",rawName:"v-button-width",value:e,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":t.setColumnWidth[e.prop]?"space-between":"center"}},t._l(e.component,function(e,s){return void 0!==e.editBtns_isShow&&!e.editBtns_isShow||!e.rowState||t.setButtonState(i.$index,i.row,e)?a("el-button",{key:s,style:t.setButtonStyle||{height:"24px",width:"46px",padding:0,margin:0,"font-size":"12px","max-width":"46px"},attrs:{type:"text"},on:{click:function(t){e.method(i.row,i.$index,i)}}},[t._v(t._s(e.name)+"\n                  ")]):t._e()}),1):t._e()]}}])},"el-table-column",e,!1))]:"object"!=typeof e.component||Array.isArray(e.component)?[e._isShow||"outside"!==t.setTableSetMode?a("el-table-column",{key:i,attrs:{"show-overflow-tooltip":"",label:e.label,prop:e.prop||e.columnIndex,width:e._isShow?e.width||t.constantWidth[e.componentName]||"auto":t.setTableColumnState?"20":"","min-width":e._isShow?e.width||e["min-width"]||t.constantWidth[e.componentName]||t.contentWidthList[i]||"none":"",sortable:!(!t.setSortableConfig[e.prop||e.columnIndex]||!e._isShow),"sort-method":t.setSortableConfig[e.prop||e.columnIndex]&&t.setSortableConfig[e.prop||e.columnIndex]["sort-method"]?t.setSortableConfig[e.prop||e.columnIndex]["sort-method"]:null,"sort-by":t.setSortableConfig[e.prop||e.columnIndex]&&t.setSortableConfig[e.prop||e.columnIndex]["sort-by"]?t.setSortableConfig[e.prop||e.columnIndex]["sort-by"]:null,fixed:t.setFixedList[i],align:"center"},scopedSlots:t._u([{key:"header",fn:function(s){return[a("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:i,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"},{name:"custom-table-switch",rawName:"v-custom-table-switch",value:{config:e,index:i,showSwitch:t.setTableColumnState},expression:"{config:colConfig,index:infoIndex,showSwitch:setTableColumnState}"}],style:{display:e._isShow?"inline-flex":"none","white-space":"nowrap"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(s){return[a("core-index",{directives:[{name:"show",rawName:"v-show",value:!!e._isShow||"outside"===t.setTableSetMode,expression:"colConfig._isShow?true:setTableSetMode === 'outside'"}],attrs:{scope:s,"info-index":i,"col-config":e,runTime:"multilevel"}})]}}])}):t._e()]:a(e.component,{key:i,tag:"component",attrs:{"col-config":e,fixed:t.setFixedList[i]}})]}),t._v(" "),t.setDragTable?[a("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[a("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[a("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)])]}}])})]:t._e()],2)],1),t._v(" "),t.setUseSummary&&t.setCustomSummary.component?[a("custom-summary-option",{attrs:{customSummary:t.setCustomSummary,tempData:t.setTempData,tableData:t.tableData[t.dataName]},on:{"send-height":t.customSummaryHeight,"custom-summary-value":t.customSummaryValue}})]:t._e()],2),t._v(" "),t.setHidePages?t._e():a("div",{staticStyle:{"text-align":"center"},style:{"padding-top":(t.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[a("el-pagination",{attrs:{background:"","current-page":t.tableData.pageData.current,"page-size":t.tableData.pageData.size,layout:"prev, pager, next, jumper",total:t.tableData.pageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.tableData.pageData,"current",e)}}})],1)],1)},[],!1,null,null,null);m.options.__file="index.vue";e.a=m.exports},"7MTH":function(t,e,a){"use strict";a.r(e);a("f3/d");var i=a("sNnr"),s=a("2+ib"),n=a("K77I"),o=(a("z0WU"),{components:{multilevelTable:s.a},name:"dialog-add",mixins:[n.a],props:["initData","visible"],data:function(){return{rules:{deptName:[{required:!0,message:"请选择接收单位",trigger:"change"}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{type:"",typeName:"",warehouseId:"",warehouseName:"",deptId:"",deptName:"",makeId:"",makeName:"",dtlJsonStr:""},tempLable:{},tableData:[],selectList:[],configs:{topBarBtnList:[]},tableConfigList:[{customColumn:[{columnIndex:"arrivingCount",width:150,componentName:"input",_cellConfig:{rules:[{lessThan:["self@count(-)self@arriveCount",!0]},{greaterThan:["0",!1]}],message:["须小于采购数量-到货数量","输入数量必须大于零"]}}],apiObj:{apiName:"listPagePurchaseOrderDetails",params:{parentId:this.initData.temp.id,queryStr:"detail.state in ('2','3')",fieldCode:"productCode,productName,spec,genre,unit,count,arriveCount,arrivingCount"}},tempData:{},showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!1,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],DeptDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择接收单位",tableUrl:"/base/departmentCustomer/listPageDepartmentCustomer",tableParm:{type:"4"},temp:{}},dialogName:"dialogOption"}},MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择制单人",tableUrl:"/system/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}}}},created:function(){var t=this.$storage.get("userInfo");this.temp.makeId=t.userId,this.temp.makeName=t.userName,this.temp.typeName="采购入库",this.temp.deptName=this.initData.temp.supplierName,this.temp.deptId=this.initData.temp.supplierId},mounted:function(){this.isVisible=this.visible,this.scaleNum=this.$refs.myDialog.scaleNum},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},save:function(){var t=this;this.selectList=[],this.$refs.customBaseTable.getData(),setTimeout(function(){t.signPurchaseOrder()},1e3)},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},databridge:function(t){this.selectList=t},dialogClose:function(t){this.$emit("close-dialog",t||{})},deptSelect:function(t){t[0]&&(this.temp.deptId=t[0].id,this.temp.deptName=t[0].name)},makeSelect:function(t){t[0]&&(this.temp.makeId=t[0].id,this.temp.makeName=t[0].name)},closeDialog:function(t){this.showDialog=!1;null!=t.selectList&&t.selectList},signPurchaseOrder:function(){var t=this,e="";this.$refs.submitForm.validate(function(a){if(a){if(null==t.selectList||0==t.selectList.length)return;for(var s=[],n=0;n<t.selectList.length;n++){var o=t.selectList[n],l={productId:o.productId,productGenre:o.genreId,count:o.arrivingCount,price:o.price,remark:o.remark,orderDetailId:o.id,planDtlId:o.planId,planId:o.planParentId,unit:o.unit,p2nFormula:o.p2nFormula,p2nIsScale:o.p2nIsScale,p2nDecimalCount:o.p2nDecimalCount};s.push(l)}e=JSON.stringify(s),t.dialogLoading=!0,Object(i.signPurchaseOrder)({purchaseOrderId:t.initData.temp.id,supplierId:t.initData.temp.supplierId,supplierName:t.initData.temp.supplierName,warehouseId:t.temp.warehouseId,roleId:t.$storage.get("userInfo").roleIds,dtlJsonStr:e}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1})}})}},watch:{}}),l=a("KHd+"),r=Object(l.a)(o,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],ref:"myDialog",attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,layoutType:4,"custom-class":t.computeDialogClass},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog,"table-selected":t.tableSelected}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"100%",display:"flex","flex-direction":"column",position:"relative"}},[a("el-form",{ref:"submitForm",staticStyle:{"padding-top":"10px","flex-shrink":"0"},attrs:{inline:"",rules:t.rules,model:t.temp,"label-position":"right","label-width":"90px",size:t.size}},[a("el-form-item",{attrs:{label:"入库类型:",prop:"typeName"}},[a("el-input",{style:t.formItemWidth,attrs:{disabled:!0},model:{value:t.temp.typeName,callback:function(e){t.$set(t.temp,"typeName",e)},expression:"temp.typeName"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"来源单位:",prop:"deptName"}},[a("el-input",{style:t.formItemWidth,attrs:{disabled:!0},model:{value:t.temp.deptName,callback:function(e){t.$set(t.temp,"deptName",e)},expression:"temp.deptName"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("base-input-option",{style:t.formItemWidth,attrs:{dialog:t.MakeDialog.dialog},on:{callback:t.makeSelect},model:{value:t.temp.makeName,callback:function(e){t.$set(t.temp,"makeName",e)},expression:"temp.makeName"}})],1)],1),t._v(" "),a("el-row",{staticClass:"tableContent",staticStyle:{width:"96%","margin-left":"2%","flex-grow":"1",position:"relative"}},[a("div",{staticStyle:{position:"absolute",top:"0",left:"0",right:"0",bottom:"0"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_purchase_orderSign_dialogSign0",tableConfigList:t.tableConfigList},on:{databridge:t.databridge}})],1)]),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="dialogSign.vue";e.default=r.exports},"9keN":function(t,e,a){},GjEI:function(t,e,a){"use strict";a.r(e);a("sNnr");var i=a("2+ib"),s=(a("z0WU"),{components:{multilevelTable:i.a},name:"dialog-add",props:["initData","visible"],data:function(){var t=this;return{rules:{typeName:[{required:!0,trigger:"change",validator:function(e,a,i){t.typeData.defaultSelected.length<=0?i(new Error("请选择出库类型")):i()}}],warehouseName:[{required:!0,trigger:"change",message:"请选择仓库"}],deptName:[{required:!0,message:"请选择接收单位",trigger:"change"}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{type:"",typeName:"",warehouseId:"",warehouseName:"",deptId:"",deptName:"",makeId:"",makeName:"",dtlJsonStr:""},tempLable:{},tableData:[],selectList:[],configs:{topBarBtnList:[]},tableConfigList:[{customColumn:[],apiObj:{apiName:"listPagePurchaseSigns",params:{orderId:this.initData.temp.id,orderStr:" sign.cdate desc "}},tempData:{},showIndex:!0,showHeader:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"all",rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[],apiObj:{apiName:"listPagePurchaseSignDetails",params:{}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable",leftFixed:1,rightFixed:1}]}},created:function(){var t=this.$storage.get("userInfo");this.temp.makeId=t.userId,this.temp.makeName=t.userName},mounted:function(){this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},databridge:function(t){this.selectList=t},dialogClose:function(t){this.$emit("close-dialog",t||{})},closeDialog:function(t){this.showDialog=!1;null!=t.selectList&&t.selectList}},watch:{}}),n=(a("uPfp"),a("e/Jj"),a("KHd+")),o=Object(n.a)(s,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1300px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog,"table-selected":t.tableSelected}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"90px"}},[a("el-row",{staticClass:"tableContent",staticStyle:{width:"96%","margin-left":"2%"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_purchase_orderSign_dialogSignList0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);o.options.__file="dialogSignList.vue";e.default=o.exports},IZt8:function(t,e,a){},IwDB:function(t,e,a){},K77I:function(t,e,a){"use strict";var i=a("z0WU");e.a={directives:{switchshadow:{inserted:function(t,e,a){var i=a.context;t.scrollHeight>t.offsetHeight?i.showBoxShadow=!0:i.showBoxShadow=!1},componentUpdated:function(t,e,a){var i=a.context;t.scrollHeight>t.offsetHeight?i.showBoxShadow=!0:i.showBoxShadow=!1}}},props:{},data:function(){return{showBoxShadow:!1,scaleNum:0,suid:""}},created:function(){this.suid=Object(i.b)()},mounted:function(){var t=this;setTimeout(function(e){console.log(t.scaleNum,t.suid)})},beforeDestroy:function(){this.suid&&this.removeDialogClass()},computed:{size:function(){return this.$store.getters.size},formItemWidth:function(){var t={};switch(this.size){case"mini":t.width="180px";break;case"small":t.width="200px";break;default:t.width="220px"}return t},createDialogStyle:function(){return".".concat(this.suid,"{\n        width: ").concat(this.scaleNum,"%;\n        height: ").concat(this.scaleNum,"%;\n        margin-top: ").concat((100-this.scaleNum)/2*this.$store.getters.systemInfo.offsetHeight/100,"px !important;\n      }")},computeDialogClass:function(){return this.setStyle(this.suid),this.suid}},methods:{setStyle:function(t){if(t){var e=document.getElementById(t);e&&e.remove(),(e=document.createElement("style")).setAttribute("id",t),document.head.appendChild(e),e.innerText=this.createDialogStyle}},removeDialogClass:function(){var t=document.getElementById(this.suid);t&&t.remove()}},watch:{}}},"e/Jj":function(t,e,a){"use strict";var i=a("IZt8");a.n(i).a},eJBo:function(t,e,a){},fKAa:function(t,e,a){"use strict";a.r(e);a("rGqo");var i=a("uTIz"),s=a("2+ib"),n=a("7MTH"),o=a("GjEI"),l=a("Vobf"),r=a("sNnr"),c=a("qnVx"),d={components:{multilevelTable:s.a,dialogSign:n.default,dialogSignList:o.default,searchBar:i.a},data:function(){return{searchList:[{label:"采购单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入采购单号"},{label:"供应商",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"请输入供应商"},{label:"状态",type:"select",ruleType:"number",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"采购中"},{value:"3",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"请输入货品名称"}],guid:"",searchObj:{},configs:{topBarBtnList:[]},tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},default:{state:"0",text:"待提交"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"签收",nameEn:"sign",editBtns_isShow:!0,rowState:"#self@state#===2",icon:"sign",method:this.sign},{name:"取消",nameEn:"cancel",editBtns_isShow:!0,rowState:"#self@state#===0||#self@state#===2",icon:"cancel",method:this.cancel},{name:"收货详情",nameEn:"signList",editBtns_isShow:!0,icon:"signList",method:this.signList}]}],apiObj:{apiName:"listPagePurchaseOrders",params:{fieldCode:"code,supplierName,applyName,deptName,amount,cdate,state",queryStr:"  purchaseOrder.state in ('2','3') ",dataType:this.$storage.get("dataType"),orderStr:" purchaseOrder.code desc"}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"4",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},info1:{state:"3",text:"部分签收"},default:{state:"0",text:"待提交"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"取消",nameEn:"cancelRow",editBtns_isShow:!0,rowState:"#self@state#===0||#self@state#===2",icon:"cancelRow",method:this.cancelRow}]}],apiObj:{apiName:"listPagePurchaseOrderDetails",params:{isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],selectList:[],temp:{},tempLable:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,a=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"云上企业"}),Object(l.initMenuButtons)({menuId:a,roleId:e}).then(function(e){var a=e.buttonList;a&&a.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(console.log(t),t.isShow=!1)})),t.tableConfigList&&t.tableConfigList.forEach(function(t){t.customColumn&&t.customColumn.forEach(function(t){"last"==t.columnIndex&&t.component&&t.component.forEach(function(t){t.nameEn==e.nameEn&&(t.rowState="1==2")})})})}),t.$loading().close()}).catch(function(e){console.log(e),t.$loading().close()}))},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(t)},databridge:function(t){this.selectList=t},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.selectList=[],this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},cancel:function(t,e){var a=this,i=this;i.$confirm("此操作将该记录变更为已取消状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(r.cancelPurchaseOrder)(t.id).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),i.updateData(a.searchObj))}).catch(function(t){console.log(t)})}).catch(function(){i.$message({type:"info",message:"已取消操作"})})},cancelRow:function(t,e,a){var i=this,s=this;s.$confirm("此操作将该记录变更为已取消状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(c.cancelPurchaseOrderDetail)(t.id).then(function(t){0===t.code&&(s.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),s.updateData(i.searchObj))}).catch(function(t){console.log(t)})}).catch(function(){s.$message({type:"info",message:"已取消操作"})})},signList:function(t,e){this.dialogData.temp=JSON.parse(JSON.stringify(t)),this.dialogData.title="签收详情",this.openDialogName="dialogSignList",this.showDialog=!0,this.visible=!0},sign:function(t,e){this.dialogData.temp=JSON.parse(JSON.stringify(t)),this.dialogData.title="签收",this.openDialogName="dialogSign",this.showDialog=!0,this.visible=!0},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},u=(a("jWqT"),a("tSoJ"),a("KHd+")),h=Object(u.a)(d,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"purchasePlan"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_purchase_orderSign_index0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);h.options.__file="index.vue";e.default=h.exports},"jB/s":function(t,e,a){"use strict";var i=a("rXsy");a.n(i).a},jWqT:function(t,e,a){"use strict";var i=a("IwDB");a.n(i).a},q7oa:function(t,e,a){"use strict";var i=a("9keN");a.n(i).a},rXsy:function(t,e,a){},tSoJ:function(t,e,a){"use strict";var i=a("zNuo");a.n(i).a},uPfp:function(t,e,a){"use strict";var i=a("eJBo");a.n(i).a},zNuo:function(t,e,a){}}]);