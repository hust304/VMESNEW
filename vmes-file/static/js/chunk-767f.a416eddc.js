(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-767f","chunk-0520","KC3E"],{"6gk9":function(e,t,a){},KC3E:function(e,t,a){"use strict";a.r(t);a("rGqo"),a("Oyvg");var i=a("WIyV"),n=a("91ra"),s={components:{customBaseTable:i.a,dialogAdd:l},props:["initData","visible"],data:function(){return{customerId:"",deliverDtlIds:"",openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",orderDetail_style:"",title:"",temp:null,tempLable:null},tableData:[],rowTableList:[],apiObj:{apiName:"listPageDeliverDetailByRetreat",params:{pageNo:1,deliverDtlIds:"",state:"1",fieldCode:"sysOrderCode,deliverCode,productCode,productName,productSpec,orderUnitName,orderCount,notRetreatCount,retreatOrderCount,productPrice,retreatOrderSum,retreatRemark"}},customColumn:[{columnIndex:"retreatOrderCount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"retreatOrderSum",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"],compute:"self@retreatOrderCount(*)self@productPrice",editable:!1}},{columnIndex:"retreatRemark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.customerId=this.initData.customerId,this.deliverDtlIds=this.initData.deliverDtlIds,this.apiObj.params.deliverDtlIds=this.deliverDtlIds},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){this.rowTableList=[],Array.isArray(e)&&(this.rowTableList=e)},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkColumn:function(e){for(var t="",a=0;a<e.length;a++){var i=e[a],n=i.retreatOrderCount;n-i.notRetreatCount>0&&(t=t+"第 "+(a+1)+" 行: 本次退货数量("+n+") 输入错误，本次退货数量不可大于可退货数量！")}return t},save:function(){this.$refs.retreatAddDialog.getData(),null!=this.rowTableList&&this.rowTableList.length>0&&this.saveSaleRetreat(this.rowTableList)},saveSaleRetreat:function(e){var t=this;if(null!=e&&0!=e.length){var a=this.checkColumn(e);if(null!=a&&a.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:a});else{var i=[];e.forEach(function(e){var t={deliverDetailId:e.id,orderDetailId:e.orderDetaiId,productId:e.productId,orderSum:e.retreatOrderSum,orderUnit:e.orderUnit,orderCount:e.retreatOrderCount,productUnit:e.productUnit,remark:e.retreatRemark,sysOrderCode:e.sysOrderCode,orderId:e.orderId,receiveAmount:e.receiveAmount,notRetreatSum:e.notRetreatSum,n2pFormula:e.n2pFormula,p2nFormula:e.p2nFormula};i.push(t)});var s="";null!=i&&i.length>0&&(s=JSON.stringify(i)),null!=s&&0!=s?Object(n.addSaleRetreat)({customerId:this.customerId,dtlJsonStr:s}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"暂无发货单明细！"})}}},dialogOpen:function(){},dialogClose:function(e){this.rowTableList=[],this.customerId="",this.deliverDtlIds="",this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},r=a("KHd+"),o=Object(r.a)(s,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-row",{style:e.initData.orderDetail_style},[a("custom-base-table",{ref:"retreatAddDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"retreatAddDialog",useDefaultBtn:!0,showAll:!1},on:{databridge:e.databridge}})],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);o.options.__file="dialogAdd.vue";var l=t.default=o.exports},QSvI:function(e,t,a){},lX1r:function(e,t,a){"use strict";a("INYr"),a("91GP"),a("rGqo"),a("xfY5");var i,n=a("z0WU"),s=a("Yfch");function r(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}var o={name:"children-table",components:{childrenTable:c},props:{data:{type:Array,default:function(){return[]}},colConfigs:{type:Array,default:function(){return[]}},layer:{type:Number,default:2},maxLayer:{type:Number,default:2},sets:{type:Object,default:function(){return{}}},parentData:{type:Array,default:function(){return[]}},childrenData:{type:Object,default:function(){return{}}},pageData:{type:Object,default:function(){return{}}},guid:{type:String,default:""},rowChain:{type:Array,default:function(){return[]}},isLoading:{type:Boolean,default:!0},defaultExpandAll:[Boolean]},data:function(){return{fixedState:!1,fixedList:[],expandRowKeys:[],childrenConfigs:{},getRowKey:function(e){return e.id},selectable:function(e,t){return"1"===e.rowState},setRowChain:[],currentpage:1,elTimer:""}},computed:(i={setConfigs:function(){return this.sets},configs:function(){return this.setConfigs[this.layer]||{}},childrenLayer:function(){return this.layer+1},setTableRef:function(){return"childTable"+this.layer},formatedData:function(){return this.$emit("do-layout"),this.data},setLoadings:function(){var e=[];return this.formatedData.forEach(function(t){e.push(!1)}),e},setLoading:function(){return this.isLoading},setMaxLayer:function(){return this.maxLayer}},r(i,"setLoadings",function(){var e=[];return this.data.forEach(function(t){e.push(!1)}),e}),r(i,"setPageData",function(){return this.pageData}),r(i,"showPageData",function(){return parseInt(this.setPageData.total)/parseInt(this.setPageData.size)>1}),r(i,"setGuid",function(){return this.guid}),r(i,"childrenKey",function(){return this.$store.getters[this.setGuid+"/keyList"][this.layer-1].childrenKey||"children"}),r(i,"configKey",function(){return this.$store.getters[this.setGuid+"/keyList"][this.layer-1].configKey||"colConfig"}),r(i,"layerKey",function(){return this.$store.getters[this.setGuid+"/keyList"][this.layer-1].layerKey||"layer"}),r(i,"selectionLayer",function(){return this.$store.getters[this.guid+"/selectionLayer"]}),r(i,"selectionList",function(){return this.$store.getters[this.guid+"/selectionList"]}),i),created:function(){var e=this;this.setRowChain=this.rowChain.concat(this.parentData),this.selectionList.length&&(this.selectionLayer!=this.layer?this.formatedData.forEach(function(e){e.rowState="0"}):this.configs.isSingle?this.selectionList.forEach(function(t){e.formatedData.forEach(function(e){t.id!=e.id&&(e.rowState="0")})}):this.formatedData.forEach(function(e){e.rowState="1"}))},mounted:function(){},watch:{configs:function(){console.log(this.configs)},childrenData:function(){},formatedData:function(){var e=this;this.configs.isSingle&&(clearTimeout(this.elTimer),this.elTimer=setTimeout(function(t){e.$refs[e.setTableRef].$el.querySelector(".el-table__header-wrapper .el-checkbox").style.display="none"},10))},selectionLayer:function(){var e=this;this.selectionLayer!=this.layer?this.selectionList.length?this.formatedData.forEach(function(e){e.rowState="0"}):this.formatedData.forEach(function(e){e.rowState="1"}):this.configs.isSingle&&this.selectionList.length?this.selectionList.forEach(function(t){e.formatedData.forEach(function(e){t.id!=e.id&&(e.rowState="0")})}):this.formatedData.forEach(function(e){e.rowState="1"})}},methods:{indexMethod:function(e){return e+1},expandChange:function(e,t){var a=this;t.some(function(t){return t.id===e.id})&&(this.configs.expandOne&&this.toggleRowExpands(t,e),e[this.childrenKey].length||this.sendChildrenRow(e,this.childrenLayer,this.setRowChain,this.layerKey,1),this.setLoadings[this.getRowIndex(e)]=!0),this.$refs[this.setTableRef].setCurrentRow(e),this.$refs[this.setTableRef].$nextTick(function(e){a.$refs[a.setTableRef].doLayout()})},getRowIndex:function(e){return this.formatedData.findIndex(function(t){return e.id===t.id})},toggleRowExpands:function(e,t){var a=this;e.forEach(function(e){a.$refs[a.setTableRef].toggleRowExpansion(e,e.id===t.id)})},getListPage:function(e,t,a){if(e){e.result.titles="string"==typeof e.result.titles?JSON.parse(e.result.titles):e.result.titles,e.result.varList="string"==typeof e.result.varList?JSON.parse(e.result.varList):e.result.varList,e.result.pageData="string"==typeof e.result.pageData?JSON.parse(e.result.pageData):e.result.pageData;var i=Object(n.m)(e.result);return{titleList:this.addTableTitle(i,t,a),pageData:e.result.pageData,tableData:e.result.varList}}return{}},addTableTitle:function(e,t,a){return t[a]&&Array.isArray(t[a])&&t[a].forEach(function(t){Object(s.b)(t.columnIndex)?e.splice(t.columnIndex,0,t):"first"===t.columnIndex?e.unshift(t):"last"===t.columnIndex?e.push(t):e.some(function(e){if(e.prop===t.columnIndex)return Object.assign(e,t),!0})}),e},selectItem:function(e,t){var a=this;this.$emit("databridge",{selection:e,layer:this.layer,baseList:this.formatedData}),setTimeout(function(){a.configs.isSingle&&(e.length?(a.data.forEach(function(e){e.rowState="0"}),e[0].rowState="1"):a.data.forEach(function(e){e.rowState="1"}))},20)},selectAllItem:function(e){if(this.configs.isSingle){if(e.length){for(var t=e.length-1;t>=0;t--)e.splice(t,1);console.log(e)}}else this.$emit("databridge",{selection:e,layer:this.layer,baseList:this.formatedData})},sendChildrenRow:function(e,t,a,i,n){this.$emit("send-children-row",e,t,a,i,n)},handleCurrentChange:function(e){console.log(this.setRowChain),console.log(e),this.currentpage=e,this.changePage({currentpage:this.currentpage,rowChain:this.setRowChain})},doLayout:function(){this.$emit("do-layout")},databridge:function(e){this.$emit("databridge",e)},changePage:function(e){this.$emit("change-page",e)}}},l=(a("v0Ex"),a("KHd+")),d=Object(l.a)(o,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"childrens"},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.setLoading,expression:"setLoading"}],ref:e.setTableRef,attrs:{data:e.formatedData,stripe:"",border:"",fit:"","highlight-current-row":"","tooltip-effect":"dark","row-key":e.getRowKey,"expand-row-keys":e.expandRowKeys},on:{"expand-change":e.expandChange,select:e.selectItem,"select-all":e.selectAllItem}},[e.layer<e.setMaxLayer?[e.formatedData.length?a("el-table-column",{attrs:{type:"expand",width:"55",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("children-table",{attrs:{data:t.row[e.childrenKey],layer:e.childrenLayer,isLoading:t.row._loading&&!e.defaultExpandAll,colConfigs:t.row[e.configKey],pageData:t.row.pageData,sets:e.setConfigs,guid:e.setGuid,parentData:[t.row],rowChain:e.setRowChain,maxLayer:e.setMaxLayer,"default-expand-all":e.defaultExpandAll},on:{"send-children-row":e.sendChildrenRow,"do-layout":e.doLayout,databridge:e.databridge,"change-page":e.changePage}})]}}])}):e._e()]:e._e(),e._v(" "),e.configs.showCheckBox&&e.formatedData.length?[a("el-table-column",{attrs:{type:"selection",fixed:e.fixedState,selectable:e.selectable,width:"55",align:"center"}})]:e._e(),e._v(" "),e.configs.showIndex&&e.formatedData.length?[a("el-table-column",{attrs:{type:"index",index:e.indexMethod,fixed:e.fixedState,label:"序号",width:"60",align:"center"}})]:e._e(),e._v(" "),e._l(e.colConfigs,function(t,i){return[t.component?a(t.component,{key:i,tag:"component",attrs:{"col-config":t}}):a("el-table-column",e._b({key:i,attrs:{"show-overflow-tooltip":"",sortable:e.configs.isSortable,label:t.label,align:"center"}},"el-table-column",t,!1))]})],2),e._v(" "),e.showPageData?a("div",{staticClass:"resetPagination",staticStyle:{height:"30px","text-align":"center","margin-top":"5px"}},[a("el-pagination",{staticStyle:{height:"30px"},attrs:{small:"","current-page":e.setPageData.current,"page-size":e.setPageData.size,layout:"prev, pager, next, jumper",total:e.setPageData.total-0},on:{"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.setPageData,"current",t)}}})],1):e._e()],1)},[],!1,null,null,null);d.options.__file="childrenTable.vue";var c=d.exports,u={name:"expand-table",props:{initData:{type:Object,default:function(){return{}}},childrenData:{type:Object,default:function(){return{}}},configs:{type:Object,default:function(){return{}}},maxLayer:{type:Number,default:2},apiObj:{type:Object,default:function(){return{}}},updateViewData:{type:Object,default:function(){return{}}},defaultExpandAll:[Boolean]},data:function(){return{wrapperWidth:0,tableWidth:0,fixedList:[],expandRowKeys:[],getRowKey:function(e){return e.id},guid:"",layer:1,tableData:[]}},components:{childrenTable:c},computed:{setTableHeight:function(){return this.showPageData?"calc(100% - 40px)":"100%"},setShowCheckBox:function(){return!!(this.configs[1]&&this.configs[1].showCheckBox&&this.formatedData.length)},setShowIndex:function(){return!!(this.configs[1]&&this.configs[1].showIndex&&this.formatedData.length)},expandOne:function(){return!(!this.configs[1]||!this.configs[1].expandOne)},setLoadings:function(){var e=[];return this.tableData.forEach(function(t){e.push(!1)}),e},formatedData:function(){return this.$store.getters[this.guid+"/dataTree"]||[]},setMaxLayer:function(){return this.maxLayer},childrenKey:function(){return this.$store.getters[this.guid+"/keyList"][this.layer-1].childrenKey||"children"},configKey:function(){return this.$store.getters[this.guid+"/keyList"][this.layer-1].configKey||"colConfig"},layerKey:function(){return this.$store.getters[this.guid+"/keyList"][this.layer-1].layerKey||"layer"},setTitleLists:function(){return this.$store.getters[this.guid+"/baseTitleList"]},setPageData:function(){return this.$store.getters[this.guid+"/basePageData"]},showPageData:function(){return parseInt(this.setPageData.total)/parseInt(this.setPageData.size)>1},selectionLayer:function(){return this.$store.getters[this.guid+"/selectionLayer"]},selectionList:function(){return this.$store.getters[this.guid+"/selectionList"]}},created:function(){this.guid=Object(n.a)(),Object(n.k)(this,this.guid,this.maxLayer)},mounted:function(){},beforeDestroy:function(){Object(n.v)(this.$store,this.guid)},watch:{initData:function(){var e=this;this.formatedData.length&&this.formatedData.forEach(function(t){e.$refs.baseTable.toggleRowExpansion(t,!1)});var t=Object.assign({},this.initData),a=this.getListPage(JSON.parse(JSON.stringify(t.res)),t.customColumn,1);this.$store.commit(this.guid+"/SET_DATATREE",[a,this.layer]),this.$store.commit(this.guid+"/SET_CUSTOMCOL",t.customColumn)},childrenData:function(){var e=Object.assign({},this.childrenData);this.$store.commit(this.guid+"/UPDATA_DATATREE",e)},updateViewData:function(){console.log(this.updateViewData),Object(n.w)(this.updateViewData)}},methods:{selectable:function(e,t){return"1"===e.rowState},expandChange:function(e,t){var a=this;t.some(function(t){return t.id===e.id})&&(this.expandOne&&this.toggleRowExpands(t,e),e[this.childrenKey].length||this.sendChildrenRow(e,this.layer+1,[],this.layerKey,1),this.setLoadings[this.getRowIndex(e)]=!0),this.$refs.baseTable.setCurrentRow(e),this.$refs.baseTable.$nextTick(function(e){a.$refs.baseTable.doLayout()})},getRowIndex:function(e){return this.formatedData.findIndex(function(t){return e.id===t.id})},toggleRowExpands:function(e,t){var a=this;e.forEach(function(e){a.$refs.baseTable.toggleRowExpansion(e,e.id===t.id)})},getListPage:function(e,t,a){if(e){e.result.titles="string"==typeof e.result.titles?JSON.parse(e.result.titles):e.result.titles,e.result.varList="string"==typeof e.result.varList?JSON.parse(e.result.varList):e.result.varList,e.result.pageData="string"==typeof e.result.pageData?JSON.parse(e.result.pageData):e.result.pageData;var i=Object(n.m)(e.result);return{titleList:this.addTableTitle(i,t,a),pageData:e.result.pageData,tableData:e.result.varList}}return{}},addTableTitle:function(e,t,a){return t[a]&&Array.isArray(t[a])&&t[a].forEach(function(t){Object(s.b)(t.columnIndex)?e.splice(t.columnIndex,0,t):"first"===t.columnIndex?e.unshift(t):"last"===t.columnIndex?e.push(t):e.some(function(e){if(e.prop===t.columnIndex)return Object.assign(e,t),!0})}),e},setStyle:function(e){},indexMethod:function(e){return e+1},tableRowClassName:function(e,t){e.index=t},selectItem:function(e,t){this.$emit("databridge",e)},selectAll:function(e){this.$emit("databridge",e)},databridge:function(e){this.$store.commit(this.guid+"/CHANGE_CHECKEDBOXSTATE",e),this.$emit("databridge",this.selectionList)},handleCurrentChange:function(e){this.$emit("update:currentpage",e)},sendChildrenRow:function(e,t,a,i,n){this.$emit("send-children-row",e,t,a,i,n)},doLayout:function(){var e=this;this.$refs.baseTable.$nextTick(function(t){e.$refs.baseTable.doLayout()})},changePage:function(e){console.log(e),Object(n.w)({_that:this,currentpage:e.currentpage,rowChain:e.rowChain})}}},h=(a("pK8k"),Object(l.a)(u,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"myCoustomTable",staticStyle:{height:"100%"}},[a("div",{staticClass:"boxStyle",style:{height:e.setTableHeight}},[a("div",{staticClass:"resetTableStyle",staticStyle:{position:"absolute",top:"0",left:"0",right:"0",bottom:"0",overflow:"auto"}},[a("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:e.formatedData,stripe:"",height:"100%",fit:"","highlight-current-row":"","tooltip-effect":"dark","header-cell-class-name":e.setStyle,"row-key":e.getRowKey,"expand-row-keys":e.expandRowKeys,"default-expand-all":e.defaultExpandAll},on:{"expand-change":e.expandChange,select:e.selectItem,"select-all":e.selectAll}},[e.formatedData.length?a("el-table-column",{attrs:{type:"expand",width:"55",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("children-table",{attrs:{data:t.row[e.childrenKey],layer:e.layer+1,isLoading:t.row._loading&&!e.defaultExpandAll,colConfigs:t.row[e.configKey],pageData:t.row.pageData,sets:e.configs,guid:e.guid,parentData:[t.row],rowChain:[],maxLayer:e.setMaxLayer,"default-expand-all":e.defaultExpandAll},on:{"send-children-row":e.sendChildrenRow,"do-layout":e.doLayout,databridge:e.databridge,"change-page":e.changePage}})]}}])}):e._e(),e._v(" "),e.setShowCheckBox?[a("el-table-column",{attrs:{type:"selection",selectable:e.selectable,width:"55",align:"center"}})]:e._e(),e._v(" "),e.setShowIndex?[a("el-table-column",{attrs:{type:"index",index:e.indexMethod,label:"序号",width:"60",align:"center"}})]:e._e(),e._v(" "),e._l(e.setTitleLists,function(t,i){return[t.component?a(t.component,{key:i,tag:"component",attrs:{"col-config":t}}):a("el-table-column",e._b({key:i,attrs:{"show-overflow-tooltip":"",align:"center"}},"el-table-column",t,!1))]})],2)],1)]),e._v(" "),e.showPageData?a("div",{staticStyle:{height:"40px","text-align":"center","margin-top":"5px"}},[a("el-pagination",{attrs:{background:"","current-page":e.setPageData.current,"page-size":e.setPageData.size,layout:"prev, pager, next, jumper",total:e.setPageData.total-0},on:{"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.setPageData,"current",t)}}})],1):e._e()])},[],!1,null,null,null));h.options.__file="index.vue";t.a=h.exports},pK8k:function(e,t,a){"use strict";var i=a("QSvI");a.n(i).a},qQoz:function(e,t,a){"use strict";a.r(t);a("rGqo"),a("91GP");var i=a("lX1r"),n=a("uTIz"),s=a("KC3E"),r={components:{expandTable:i.a,searchBar:n.a,dialogAdd:s.default},props:["initData","visible"],data:function(){return{customerId:"",deliverDtlState:"1",searchList:[{label:"发货单编号",type:"input",ruleType:"string",mapKey:"deliverCode",configs:{},placeholder:"发货单编号"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"}],searchObj:{},guid:"",customColumn:{},tableSets:{1:{showCheckBox:!1,showIndex:!1,expandOne:!1},2:{showCheckBox:!0,showIndex:!1,isExpands:!1,isSortable:!1,isSingle:!1}},initDataByTable:{},childrenData:{},currentpage:1,maxLayer:2,expandTableApiList:["listPageSaleDeliver","listPageSaleDeliverDetail"],expandTableApiParams:[{customerId:"",detailState:"",fieldCode:""},{isNeedRetreat:"true",parentId:"",state:"",fieldCode:""}],updateViewData:{},rowTableList:[],resState:"",openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,showDialog:!1,inLinVisible:!1,dialogData:{customerId:"",deliverDtlIds:"",dialog_width:"",orderDetail_style:"",title:"",temp:null,tempLable:null}}},beforeCreate:function(){},created:function(){this.customerId=this.initData.customerId,this.expandTableApiParams[0].customerId=this.customerId,this.expandTableApiParams[0].detailState=this.deliverDtlState,this.expandTableApiParams[0].fieldCode="deliverCode,customerCode,customerName,customerTypeName,stateName,deliverDate",this.expandTableApiParams[1].state=this.deliverDtlState,this.expandTableApiParams[1].fieldCode="productCode,productName,productSpec,productGenreName,orderUnitName,nowDeliverCount,nowDeliverSum,remark",this.initExpandTable()},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{setParams:function(e,t,a){var i=Object.assign({},this.expandTableApiParams[e-1]);for(var n in i)i.hasOwnProperty(n)&&!i[n]&&(i[n]=t[n]||"");return Object.assign({},i,this.searchObj,{pageNo:a})},initExpandTable:function(){var e=this;this.$api[this.expandTableApiList[0]](this.setParams(1,this.expandTableApiParams[0],this.currentpage)).then(function(t){e.initDataByTable={row:null,layer:1,res:t,customColumn:e.customColumn}}).catch(function(e){})},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.initExpandTable()},tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},databridge:function(e){this.rowTableList=e},findChildByRow:function(e,t,a,i,n){var s=this;this.$api[this.expandTableApiList[t-1]](this.setParams(t,e,n)).then(function(a){s.childrenData={row:e,layer:t,res:a,customColumn:s.customColumn}}).catch(function(e){})},save:function(){var e="";if(null!=this.rowTableList&&0!=this.rowTableList.length||(e="请选择一行数据！"),e.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:e});else{var t="";this.rowTableList.forEach(function(e){null!=e.id&&e.id.trim().length>0&&(t=t+e.id.trim()+",")}),this.dialogData.deliverDtlIds=t,this.dialogData.customerId=this.customerId;var a=document.body.clientWidth,i=(document.body.clientHeight,.7*a);this.dialogData.dialog_width=i+"px";var n=.666*(.618*i)+"px";this.dialogData.orderDetail_style="height:"+n+";width: 96%;margin-left: 2%;",this.dialogData.title="退货列表",this.openDialogName="dialogAdd",this.showDialog=!0,this.inLinVisible=!0}},dialogOpen:function(){},dialogClose:function(e){this.customerId="",(e={}).resState=this.resState,this.$emit("close-dialog",e||{})},closeDialog:function(e){e.resState&&(this.resState=e.resState),this.isVisible=!1}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},o=a("KHd+"),l=Object(o.a)(r,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{style:e.initData.orderDetail_style},[a("expand-table",{attrs:{initData:e.initDataByTable,childrenData:e.childrenData,configs:e.tableSets,currentpage:e.currentpage,maxLayer:e.maxLayer,apiObj:{apiName:e.expandTableApiList,apiParams:e.expandTableApiParams},updateViewData:e.updateViewData},on:{"update:currentpage":function(t){e.currentpage=t},databridge:e.databridge,"send-children-row":e.findChildByRow}})],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("下一步")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogDeliver.vue";t.default=l.exports},v0Ex:function(e,t,a){"use strict";var i=a("6gk9");a.n(i).a}}]);