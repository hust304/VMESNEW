(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-6bf3","chunk-2c81","4Nw2","dnMx"],{"2+ib":function(t,e,a){"use strict";a("dRSK"),a("INYr"),a("91GP"),a("Vd3H"),a("rGqo"),a("f3/d"),a("xfY5");var i=a("8WZi"),o=a("z0WU"),n=a("DKCI"),s=a("50Ol"),l=a("F9dT"),r=(a("Yfch"),a("YP4+")),d=a("WwWg"),c=(a("evdt"),a("mwzG")),h={name:"multilevel-table",mixins:[i.a],provide:function(){return{rootVm:this}},props:{expand:[Boolean],expandMode:[String],rootWidth:[String,Number],showExpandBtn:[Boolean],parentData:{type:Array,default:function(){return[]}},rowChain:{type:Array,default:function(){return[]}},layerSingle:{type:Boolean,default:!1},globalSingle:{type:Boolean,default:!1},widthDiffValue:{type:Number,default:r.a.widthDiffValue}},data:function(){return{_vnode:null,componentName:"multilevelTable",checkedViewHeight:0,pageId:"",initLoading:!0,headerWidthList:[],listLength:-1,restaurants:[],fileList:[],resultTableData:"",computedIds:[],tempCheckedList:[]}},components:{tableFilter:n.a,customSummaryOption:s.a},computed:{setMergeTitle:function(){return this.layerConfig.mergeTitle||this.mergeTitle},setInitLoading:function(){return this.initLoading},setTableLoading:function(){return 1===this.maxLayer?this.setShowTableSet?this.setShowTableSet&&this.setInitLoading:this.setInitLoading:!!this.setApiObj.apiName&&this.initLoading},tableData:function(){return this.layer?this.parentData[0]||{}:this.$store.getters[this.guid+"/tableData"]||{}},setExpand:function(){return this.layerConfig.expand||this.expand||!1},setExpandMode:function(){return this.layerConfig.expandMode||this.expandMode||"all"},setShowExpandBtn:function(){return this.layerConfig.showExpandBtn||this.showExpandBtn||!1},setExpandColumnWidth:function(){return this.setShowExpandBtn?"50":this.maxLayer>2?"50":this.setExpand&&"all"!==this.setExpandMode?"50":"1"},setTableClass:function(){return{twoLevelTable:"1"===this.setExpandColumnWidth&&2===this.maxLayer&&!this.layer,inTwoLevelTable:2===this.maxLayer&&this.layer,multilevelTable:"50"===this.setExpandColumnWidth||this.maxLayer>2,singleStageTable:1===this.maxLayer&&!this.layer,columnBaseTable:!this.layer,defaultSpacingClass:!this.layer&&this.maxLayer>1,noSpacingClass:this.layer}},setExpandRowKeys:function(){return"one"===this.setExpandMode&&this.tableData[this.dataName]?[this.tableData[this.dataName][0]]:[]},setShowHeader:function(){return"boolean"!=typeof this.layerConfig.showHeader||this.layerConfig.showHeader},setTableBorder:function(){return this.layer?!this.setExpand||("50"===this.setExpandColumnWidth||this.maxLayer>2):!!this.setShowTableSet},setRootWidth:function(){return this.layer?"100%":this.layerConfig.rootWidth||this.rootWidth?"".concat((this.layerConfig.rootWidth||this.rootWidth)+"","px"):"100%"}},created:function(){var t=this;if(!this.layer)if(this.guid=Object(o.a)(),Object(d.c)(this),this.initData.result){var e=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.guid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:"root",vm:this}),this.initLoading=!1}else this.setApiObj.apiName&&("单级表格"===this.$route.name||"两级表格"===this.$route.name||"多级表格"===this.$route.name?setTimeout(function(){var e=JSON.parse(JSON.stringify(c.a));t.computedIds=[],t.tempCheckedList=[],t.$store.commit(t.guid+"/SET_TABLEDATA",{res:e,vm:t}),t.pageId=t.$storage.get("menuId"),t.setRowExpansion(t.tableData[t.dataName][0],!0),t.setDragTable&&t.setSort(),t.$store.commit(t.guid+"/SET_TABLERULELIST",{cb:t.tableRuleForm,ruleId:"root",vm:t}),t.initLoading=!1},1e3):this.httpRequests());this.layer&&(this.setApiObj&&this.setApiObj.apiName?this.httpChildrenRequests(this.tableData):this.tableData[this.dataName]&&this.tableData[this.dataName].length?(this.tableData[this.dataName].forEach(function(t){t.rowState="1"}),this.setDragTable&&this.setSort(),this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:this.internalRuleId,vm:this}),this.initLoading=!1,this.tableDoLayout()):(this.$emit("narrow-row",this.parentData[0]),this.initLoading=!1,this.tableDoLayout()))},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},beforeDestroy:function(){var t=this;this.$store.state[this.setGuid]&&this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:null,ruleId:this.layer?this.internalRuleId:"root"}),this.tempCheckedList.forEach(function(e){t.$store.commit(t.setGuid+"/DELETE_CHECKED",[e])}),!this.layer&&Object(d.g)(this.$store,this.guid)},watch:{"tableData.tableData":function(){1===this.maxLayer&&this.setFixed(),this.setTableCheckBoxDisplay(),this.tableDoLayout()},"tableData.children":function(){this.maxLayer===this.layer+1&&this.setFixed(),this.setTableCheckBoxDisplay(),this.tableDoLayout()},initData:function(){this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:null,ruleId:this.layer?this.internalRuleId:"root"});var t=JSON.parse(JSON.stringify(this.initData));this.computedIds=[],this.tempCheckedList=[],this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:t,vm:this}),this.pageId=this.$storage.get("menuId"),this.setRowExpansion(this.tableData[this.dataName][0],!0),this.setDragTable&&this.setSort(),this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:this.layer?this.internalRuleId:"root",vm:this}),this.initLoading=!1,this.tableDoLayout()},resetContentWidthList:function(){var t=this,e=this.resetContentWidthList.map(function(t){return null});this.resetContentWidthList.forEach(function(a,i){t.useMiddleValue=!1,e[i]=t.contentWidthAlgorithm(a.map(function(t){return Math.max.apply(null,t)})),t.useMiddleValueList[i]=t.useMiddleValue}),e.forEach(function(e,a){t.contentWidthList[a]=e?e+26:null})}},methods:{contentWidthAlgorithm:function(t){if(this.setWidthDiffValue&&t&&t.length){if(t.length>1){var e=Math.max.apply(null,t);if(e-Math.min.apply(null,t)>this.setWidthDiffValue){var a,i=[].concat(t);return i.sort(o.d),a=i.length%2==0?(i[i.length/2-1]+i[i.length/2])/2:i[(i.length+1)/2-1],this.useMiddleValue=!0,e-a>this.setWidthDiffValue&&(a=2*this.setWidthDiffValue),a}return e}return t[0]}return null},databridge:function(t,e){this.$emit("databridge",t,e)},expandChange:function(t,e){var a=this;"one"===this.setExpandMode&&e.forEach(function(a,i){t._internalId!==a._internalId&&e.splice(i,1)}),this.$refs.baseTable.$nextTick(function(t){a.$refs.baseTable&&a.$refs.baseTable.doLayout&&a.$refs.baseTable.doLayout(),a.$emit("table-dolayout")})},setRowExpansion:function(t,e){!this.layer&&this.maxLayer>1&&"one"===this.setExpandMode&&this.$refs.baseTable.toggleRowExpansion(t,e)},httpRequests:function(t){var e=this;this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:null,ruleId:"root"}),this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:t||1},this.searchObj)).then(function(a){e.computedIds=[],e.tempCheckedList=[],e.$store.commit(e.guid+"/SET_TABLEDATA",{res:a,vm:e}),e.pageId=e.$storage.get("menuId"),e.setRowExpansion(e.tableData[e.dataName][0],!0),e.setDragTable&&e.setSort(),e.initLoading=!1,t&&(e.pageNo=t,e.scrollTable()),e.tableDoLayout(),e.$store.commit(e.guid+"/SET_TABLERULELIST",{cb:e.tableRuleForm,ruleId:"root",vm:e})}).catch(function(t){console.log(t),e.initLoading=!1})},httpChildrenRequests:function(t,e){var a=this;this.$store.commit(this.setGuid+"/SET_TABLERULELIST",{cb:null,ruleId:this.internalRuleId}),this.initLoading=!0,this.$api[this.setApiObj.apiName](Object.assign({},{pageNo:e||1},this.setParams(t,this.setApiObj),this.setDynaValue(t))).then(function(i){a.$store.commit(a.setGuid+"/UPDATE_CHILDRENTABLEDATA",{res:i,row:t,vm:a}),a.setDragTable&&a.setSort(),a.pageNo=a.tableData[a.dataName].pageData&&a.tableData[a.dataName].pageData.current||1,a.initLoading=!1,a.tableDoLayout(),e&&a.scrollTable(),a.$store.commit(a.setGuid+"/SET_TABLERULELIST",{cb:a.tableRuleForm,ruleId:a.internalRuleId,vm:a})}).catch(function(t){console.log(t),a.initLoading=!1})},selectItem:function(t,e){t.findIndex(function(t){return t._internalId===e._internalId})>-1?(this.tempCheckedList.push(e),this.$store.commit(this.setGuid+"/ADD_CHECKED",[e])):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",[e]),this.tempCheckedList=this.tempCheckedList.filter(function(t){return t._internalId!==e._internalId})),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"]),(this.setIsSingle||this.setGlobalSingle||this.setLayerSingle)&&((this.setGlobalSingle||this.setLayerSingle)&&this.$store.commit(this.setGuid+"/SET_ROWSTATE",{model:this.setGlobalSingle?"global":"layer",layer:this.layer,state:t.length?"0":"1"}),t.length?(this.tableData[this.dataName].forEach(function(t){t.rowState="0"}),t[0].rowState="1"):this.tableData[this.dataName].forEach(function(t){t.rowState="1"}))},selectAllItem:function(t){if(this.setIsSingle){if(t.length)for(var e=t.length-1;e>=0;e--)t.splice(e,1)}else t.length?(this.tempCheckedList=t.map(function(t){return t}),this.$store.commit(this.setGuid+"/ADD_CHECKED",this.tempCheckedList)):(this.$store.commit(this.setGuid+"/DELETE_CHECKED",this.tempCheckedList),this.tempCheckedList=[]),this.$emit("databridge",this.$store.getters[this.setGuid+"/checkedList"])},handleCurrentChange:function(t){t!==this.pageNo&&this.httpRequests(t)},setDynaValue:function(t){if(this.setDynamicValue){var e={};for(var a in this.setDynamicValue)this.setDynamicValue.hasOwnProperty(a)&&(e[a]=Object(l.c)([this.setDynamicValue[a]],t,this.setRowChain,this.tableData[this.dataName],!1,this.setTempData)[0]);return e}return{}},setRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-expand-column":2===this.maxLayer?"row-expand-cover":"multilevel-expand-cover":""},setHeaderRowClass:function(){return this.setExpand?"1"===this.setExpandColumnWidth?"hide-header-expand-column":2===this.maxLayer&&"1"===this.setExpandColumnWidth?"header-expand-cover":"multilevel-header-expand-cover":""},searchTableData:function(t,e){var a=this;return e&&t?(this.resultTableData=(t.tableData||t.children).find(function(t){if(t._internalId===e)return!0;if(t.children&&t.children.length){var i={titleList:t.titleList,children:t.children,pageData:t.pageData||{}};a.resultTableData=a.searchTableData(i,e)}}),this.resultTableData?this.resultTableData:void 0):{}},callParentMethod:function(t){this.$emit("callmethod",t)},tableDoLayout:function(){var t=this;this.$nextTick(function(e){t.$refs.baseTable&&t.$refs.baseTable.doLayout&&t.$refs.baseTable.doLayout(),t.layer&&t.$emit("table-dolayout")})}}},u=(a("q7oa"),a("jB/s"),a("KHd+")),m=Object(u.a)(h,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.setTableLoading,expression:"setTableLoading"}],staticClass:"myCoustomTable resetCoustomTableStyle",class:t.setTableClass},[t.setShowTableSet&&"outside"===t.setTableSetMode&&!t.layer?a("table-filter",{attrs:{headerList:t.setColConfigs,tableSwitchState:t.setTableSwitch,storeId:t.pageId,componentId:t.setComponentId},on:{"checked-list":t.checkedList,"checked-height":t.checkedHeight}}):t._e(),t._v(" "),a("div",{style:{height:t.setTableHeight}},[a("el-form",{ref:"ruleForm",style:{height:t.layer?"auto":"100%"},attrs:{model:t.ruleForm,"status-icon":""},nativeOn:{submit:function(t){t.preventDefault()}}},[a("el-table",{ref:"baseTable",style:{width:t.setRootWidth},attrs:{data:t.tableData[t.dataName],stripe:!t.setExpand||"50"===t.setExpandColumnWidth,"highlight-current-row":"",border:t.setTableBorder,"current-row-key":"_internalId","tooltip-effect":"dark",height:t.layer?null:"100%",fit:"","show-header":t.setShowHeader,"row-key":"_internalId","show-summary":t.setSysSummary,"default-expand-all":!t.setShowExpandBtn&&t.setExpand&&"all"===t.setExpandMode,"header-row-style":t.setHeaderRowStyle,"row-style":t.setRowStyle,"row-class-name":t.setRowClass,"cell-style":t.setCellStyle,"header-cell-style":t.setHeaderCellStyle,"header-row-class-name":t.setHeaderRowClass,"default-sort":t.setSortableConfig["default-sort"]},on:{select:t.selectItem,"select-all":t.selectAllItem,"selection-change":t.selectionChange,"expand-change":t.expandChange,"sort-change":t.sortChange,"row-click":t.rowClick,"row-dblclick":t.rowDblclick}},[t.setExpand?[a("el-table-column",{attrs:{type:"expand",width:t.setExpandColumnWidth,align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("multilevel-table",{ref:"multilevelTable",attrs:{"data-custom-table-id":"components_customTable_multilevelTable_index0",tableConfigList:t.tableConfigList,layer:t.layer+1,internalRuleId:e.row._internalId,internalGuid:t.setGuid,parentData:[e.row],rowChain:t.setRowChain,tableSwitchBaseKey:t.columnSwitchBaseKey},on:{databridge:t.databridge,callmethod:t.callParentMethod,"table-dolayout":t.tableDoLayout,"narrow-row":t.narrowRow}})]}}])})]:t._e(),t._v(" "),t.setShowCheckBox?[a("el-table-column",{attrs:{type:"selection",fixed:t.setFixedState,selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.setShowIndex?[a("el-table-column",{attrs:{type:"index",index:t.indexMethod,fixed:t.setFixedState,label:"序号",width:"50",align:"center"}})]:t._e(),t._v(" "),t._l(t.setTitleList,function(e,i){return[e.slot?t._t(e.slot,null,{fixed:t.setFixedList[i]}):Array.isArray(e.component)?[a("el-table-column",t._b({key:i,attrs:{"show-overflow-tooltip":"",fixed:t.setFixedList[i],"min-width":e.width||t.setColumnWidth[e.prop]||null,align:"center"},scopedSlots:t._u([{key:"header",fn:function(o){return[a("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:i,isComponent:!0,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}]},[t._v("\n                  "+t._s(e.label)+"\n                ")])]}},{key:"default",fn:function(i){return["button"===e.componentName?a("div",{directives:[{name:"button-width",rawName:"v-button-width",value:e,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":t.setColumnWidth[e.prop]?"space-between":"center"}},t._l(e.component,function(e,o){return void 0!==e.editBtns_isShow&&!e.editBtns_isShow||!e.rowState||t.setButtonState(i.$index,i.row,e)?a("el-button",{key:o,style:t.setButtonStyle||{height:"24px",width:"46px",padding:0,margin:0,"font-size":"12px","max-width":"46px"},attrs:{type:"text"},on:{click:function(t){e.method(i.row,i.$index,i)}}},[t._v(t._s(e.name)+"\n                  ")]):t._e()}),1):t._e()]}}])},"el-table-column",e,!1))]:"object"!=typeof e.component||Array.isArray(e.component)?[e._isShow||"outside"!==t.setTableSetMode?a("el-table-column",{key:i,attrs:{"show-overflow-tooltip":"",label:e.label,prop:e.prop||e.columnIndex,width:e._isShow?e.width||t.constantWidth[e.componentName]||"auto":t.setTableColumnState?"20":"","min-width":e._isShow?e.width||e["min-width"]||t.constantWidth[e.componentName]||t.contentWidthList[i]||"none":"",sortable:!(!t.setSortableConfig[e.prop||e.columnIndex]||!e._isShow),"sort-method":t.setSortableConfig[e.prop||e.columnIndex]&&t.setSortableConfig[e.prop||e.columnIndex]["sort-method"]?t.setSortableConfig[e.prop||e.columnIndex]["sort-method"]:null,"sort-by":t.setSortableConfig[e.prop||e.columnIndex]&&t.setSortableConfig[e.prop||e.columnIndex]["sort-by"]?t.setSortableConfig[e.prop||e.columnIndex]["sort-by"]:null,fixed:t.setFixedList[i],align:"center"},scopedSlots:t._u([{key:"header",fn:function(o){return[a("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:i,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"},{name:"custom-table-switch",rawName:"v-custom-table-switch",value:{config:e,index:i,showSwitch:t.setTableColumnState},expression:"{config:colConfig,index:infoIndex,showSwitch:setTableColumnState}"}],style:{display:e._isShow?"inline-flex":"none","white-space":"nowrap"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(o){return[a("core-index",{directives:[{name:"show",rawName:"v-show",value:!!e._isShow||"outside"===t.setTableSetMode,expression:"colConfig._isShow?true:setTableSetMode === 'outside'"}],attrs:{scope:o,"info-index":i,"col-config":e,runTime:"multilevel"}})]}}])}):t._e()]:a(e.component,{key:i,tag:"component",attrs:{"col-config":e,fixed:t.setFixedList[i]}})]}),t._v(" "),t.setDragTable?[a("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[a("div",{staticStyle:{display:"inline-block"},on:{click:function(e){return e.stopPropagation(),t.clickStop(e)},dblclick:function(e){return e.stopPropagation(),t.clickStop(e)}}},[a("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)])]}}])})]:t._e()],2)],1),t._v(" "),t.setUseSummary&&t.setCustomSummary.component?[a("custom-summary-option",{attrs:{customSummary:t.setCustomSummary,tempData:t.setTempData,tableData:t.tableData[t.dataName]},on:{"send-height":t.customSummaryHeight,"custom-summary-value":t.customSummaryValue}})]:t._e()],2),t._v(" "),t.setHidePages?t._e():a("div",{staticStyle:{"text-align":"center"},style:{"padding-top":(t.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[a("el-pagination",{attrs:{background:"","current-page":t.tableData.pageData.current,"page-size":t.tableData.pageData.size,layout:"prev, pager, next, jumper",total:t.tableData.pageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.tableData.pageData,"current",e)}}})],1)],1)},[],!1,null,null,null);m.options.__file="index.vue";e.a=m.exports},"4Nw2":function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf");var i=a("/a8v");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{initialPeriodDate:null,paymentPeriodDate:null,rules:{initialPeriodDate:[{required:!0,message:"请填写初始付款期间",trigger:"change"}]},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,formTemp:[]}},created:function(){this.initData.rowData&&(this.formData=this.initData.rowData)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},changeInitialPeriodDate:function(t){null!=t&&(this.initialPeriodDate=new Date(t),this.formData.initialPeriodDate=t)},changePaymentPeriodDate:function(t){this.paymentPeriodDate=new Date(t),this.formData.paymentPeriodDate=t},isErrorByPeriodDate:function(){var t=this.initialPeriodDate.getTime();if(null!=this.paymentPeriodDate&&this.paymentPeriodDate.getTime()-t<0)return this.$message({message:"当前付款期间不可小于初始付款期间！",type:"warning",duration:5e3}),!0;return!1},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&!t.isErrorByPeriodDate()&&Object(i.addCompanyPeriod)(t.formData).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"保存成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})},closeDialog:function(t){}}},s=a("KHd+"),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[a("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-form-item",{attrs:{label:"企业编码:"}},[a("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.companyCode,callback:function(e){t.$set(t.formData,"companyCode",e)},expression:"formData.companyCode"}})],1)],1),t._v(" "),a("el-row",[a("el-form-item",{attrs:{label:"企业名称:"}},[a("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.companyName,callback:function(e){t.$set(t.formData,"companyName",e)},expression:"formData.companyName"}})],1)],1),t._v(" "),a("el-row",[a("el-form-item",{attrs:{label:"初始付款期间:",prop:"initialPeriodDate"}},[a("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"month","value-format":"yyyy-MM-dd",placeholder:"选择月"},on:{change:t.changeInitialPeriodDate},model:{value:t.formData.initialPeriodDate,callback:function(e){t.$set(t.formData,"initialPeriodDate",e)},expression:"formData.initialPeriodDate"}})],1)],1),t._v(" "),a("el-row",[a("el-form-item",{attrs:{label:"当前付款期间:",prop:"paymentPeriodDate"}},[a("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"month","value-format":"yyyy-MM-dd",placeholder:"选择月"},on:{change:t.changePaymentPeriodDate},model:{value:t.formData.paymentPeriodDate,callback:function(e){t.$set(t.formData,"paymentPeriodDate",e)},expression:"formData.paymentPeriodDate"}})],1)],1)],1),t._v(" "),a("div",{staticStyle:{"padding-left":"6%"}},[t._v("\n      备注："),a("br"),t._v("\n      1) 初始付款期间：当前企业首次采购付款结转初始期间"),a("br"),t._v("\n      2) 当前付款期间：供应商在当前付款期间内发生的所有"),a("br"),t._v("\n              \n              \n              \n      (采购金额，付款金额)"),a("br"),t._v("\n      3) 当前付款期间：为空不填保存后默认等于初始付款期间"),a("br"),t._v("\n      例如：201903 表示2019年03月份"),a("br"),a("br")]),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogAdd.vue";e.default=l.exports},"9keN":function(t,e,a){},AOGg:function(t,e,a){},DNa0:function(t,e,a){"use strict";var i=a("AOGg");a.n(i).a},dnMx:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf");var i=a("/a8v");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{initialPeriodDate:null,paymentPeriodDate:null,rules:{initialPeriodDate:[{required:!0,message:"请填写初始付款期间",trigger:"change"}]},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,formTemp:[]}},created:function(){this.initData.rowData&&(this.formData=this.initData.rowData,this.initialPeriodDate=new Date(this.initData.rowData.initialPeriodDate),null!=this.initData.rowData.paymentPeriodDate&&(this.paymentPeriodDate=new Date(this.initData.rowData.paymentPeriodDate)))},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},changeInitialPeriodDate:function(t){null!=t&&(this.initialPeriodDate=new Date(t),this.formData.initialPeriodDate=t)},changePaymentPeriodDate:function(t){this.paymentPeriodDate=new Date(t),this.formData.paymentPeriodDate=t},isErrorByPeriodDate:function(){var t=this.initialPeriodDate.getTime();if(null!=this.paymentPeriodDate&&this.paymentPeriodDate.getTime()-t<0)return this.$message({message:"当前付款期间不可小于初始付款期间！",type:"warning",duration:5e3}),!0;return!1},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&!t.isErrorByPeriodDate()&&Object(i.updateCompanyPeriod)(t.formData).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"保存成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})},closeDialog:function(t){}}},s=a("KHd+"),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[a("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-form-item",{attrs:{label:"企业编码:"}},[a("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.companyCode,callback:function(e){t.$set(t.formData,"companyCode",e)},expression:"formData.companyCode"}})],1)],1),t._v(" "),a("el-row",[a("el-form-item",{attrs:{label:"企业名称:"}},[a("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.companyName,callback:function(e){t.$set(t.formData,"companyName",e)},expression:"formData.companyName"}})],1)],1),t._v(" "),a("el-row",[a("el-form-item",{attrs:{label:"初始付款期间:",prop:"initialPeriodDate"}},[a("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"month","value-format":"yyyy-MM-dd",placeholder:"选择月"},on:{change:t.changeInitialPeriodDate},model:{value:t.formData.initialPeriodDate,callback:function(e){t.$set(t.formData,"initialPeriodDate",e)},expression:"formData.initialPeriodDate"}})],1)],1),t._v(" "),a("el-row",[a("el-form-item",{attrs:{label:"当前付款期间:",prop:"paymentPeriodDate"}},[a("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"month","value-format":"yyyy-MM-dd",placeholder:"选择月",readonly:!0},on:{change:t.changePaymentPeriodDate},model:{value:t.formData.paymentPeriodDate,callback:function(e){t.$set(t.formData,"paymentPeriodDate",e)},expression:"formData.paymentPeriodDate"}})],1)],1)],1),t._v(" "),a("div",{staticStyle:{"padding-left":"6%"}},[t._v("\n    备注："),a("br"),t._v("\n    1) 初始付款期间：当前企业首次采购付款结转初始期间"),a("br"),t._v("\n    2) 当前付款期间：供应商在当前付款期间内发生的所有"),a("br"),t._v("\n            \n            \n            \n    (采购金额，付款金额)"),a("br"),t._v("\n    3) 当前付款期间：为空不填保存后默认等于初始付款期间"),a("br"),t._v("\n    例如：201903 表示2019年03月份"),a("br"),a("br")]),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogEdit.vue";e.default=l.exports},fY7h:function(t,e,a){"use strict";a.r(e);a("rGqo");var i=a("uTIz"),o=a("2+ib"),n=a("4Nw2"),s=a("dnMx"),l=a("Vobf"),r=(a("hZMg"),a("/a8v"),{components:{multilevelTable:o.a,searchBar:i.a,dialogAdd:n.default,dialogEdit:s.default},data:function(){return{searchList:[],guid:"",searchObj:{},tableConfigList:[{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"设定",nameEn:"addCompanyPeriod",editBtns_isShow:!0,icon:"addCompanyPeriod",method:this.addCompanyPeriod},{name:"修改",nameEn:"updateCompanyPeriod",editBtns_isShow:!0,icon:"updateCompanyPeriod",method:this.updateCompanyPeriod}]}],apiObj:{apiName:"listPagePurchaseCompanyPeriod",params:{dataType:this.$storage.get("dataType"),fieldCode:"companyCode,companyName,initialPeriod,paymentPeriod,isBuildName,cdateStr"}},tempData:{},showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],selectList:[],temp:{},tempLable:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",rowData:{},title:""}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,a=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"云上企业"}),Object(l.initMenuButtons)({menuId:a,roleId:e}).then(function(e){t.$loading().close();var a=e.buttonList;a&&a.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)})),t.tableConfigList&&t.tableConfigList.forEach(function(t){t.customColumn&&t.customColumn.forEach(function(t){"last"==t.columnIndex&&t.component&&t.component.forEach(function(t){t.nameEn==e.nameEn&&(t.rowState="1==2")})})})})}).catch(function(e){console.log(e),t.$loading().close()}))},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(t)},databridge:function(t){this.selectList=t},updateData:function(t){this.$refs.customBaseTable.updateData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},addCompanyPeriod:function(t,e){var a=t.id;null!=a&&a.trim().length>0?this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前企业已经设定，请点击(修改)！"}):(this.dialogData.rowData={companyId:t.companyId,companyCode:t.companyCode,companyName:t.companyName,initialPeriodDate:"",paymentPeriodDate:""},this.dialogData.title="创建企业首次付款期间",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0)},updateCompanyPeriod:function(t,e){var a=t.id;null!=a&&0!=a.trim().length?(this.dialogData.rowData={id:t.id,companyId:t.companyId,companyCode:t.companyCode,companyName:t.companyName,initialPeriodDate:t.initialPeriodDate,paymentPeriodDate:t.paymentPeriodDate},this.dialogData.title="修改企业首次付款期间",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0):this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前企业还没有设定不可修改！"})},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0)+"px":"100%"},dialogName:function(){return this.openDialogName}},watch:{}}),d=(a("DNa0"),a("kgYZ"),a("KHd+")),c=Object(d.a)(r,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"companyPeriod"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticStyle:{"border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight,"margin-top":t.searchList.length?"10px":"0"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_purchase_purchaseBase_companyPeriod_index1",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);c.options.__file="index.vue";e.default=c.exports},"jB/s":function(t,e,a){"use strict";var i=a("rXsy");a.n(i).a},kgYZ:function(t,e,a){"use strict";var i=a("pm28");a.n(i).a},pm28:function(t,e,a){},q7oa:function(t,e,a){"use strict";var i=a("9keN");a.n(i).a},rXsy:function(t,e,a){}}]);