(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-75ff","chunk-54be"],{"0UPH":function(t,e,a){"use strict";var i=a("JvdH");a.n(i).a},AZ8z:function(t,e,a){"use strict";a.d(e,"a",function(){return s});a("rE2o"),a("ioFf"),a("dRSK"),a("Oyvg"),a("a1Th");function i(t){return(i="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}function n(t){return Object.prototype.toString.call(t).slice(8,-1)}function o(t){var e="";t.global&&(e+="g"),t.ignoreCase&&(e+="i"),t.multiline&&(e+="m");var a=new RegExp(t,e);return a.lastIndex=t.lastIndex,a}function s(t){if(null==t||"object"!==i(t))return t;var e;switch(n(t)){case"RegExp":return o(t);case"Date":return new Date(t.getTime());case"Function":return t;case"Array":e=[];break;default:e=Object.create(Object.getPrototypeOf(t))}for(var a=[],s=[{parent:e,key:void 0,data:t}],l=function(){var t=s.pop(),e=t.parent,l=t.key,r=t.data,c=e;if(void 0!==l)switch(n(r)){case"RegExp":return e[l]=o(r),"continue";case"Date":return e[l]=new Date(r.getTime()),"continue";case"Function":return e[l]=r,"continue";case"Array":c=e[l]=[];break;default:var u=Object.getPrototypeOf(r);c=e[l]=Object.create(u)}var h=a.find(function(t){return t.source===r});if(h)return e[l]=h.target,"continue";for(var d in a.push({source:r,target:c}),r)r.hasOwnProperty(d)&&(null==r[d]||"object"!==i(r[d])?c[d]=r[d]:s.push({parent:c,key:d,data:r[d]}))};s.length;)l();return e}},G9HT:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf"),a("f3/d"),a("91GP"),a("pIFo");var i=a("uTIz"),n=a("varj"),o=a("K3g7");function s(t){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{customTransferTable:n.a,searchBar:i.a},name:"productTableDialog",props:["initData","visible"],data:function(){return{temp:{},tempLable:{},tempQuery:{},resState:"",dialogLoading:!0,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1,showSearch:!0,showDisable:!1},selectTree:{pid:"",id:"",layer:"",name:""},isConfirm:!1,btnList:[{name:"确定",isShow:!0,state:!0,method:this.toDialogAdd},{name:"取消",state:!1,method:this.closeWin,isShow:!0}],stateBtnData:{},aboveTableConfig:{apiObj:{apiName:"listPageProducts",params:{fieldCode:"code,name,spec,unitName,genreName,productStockCount,cdate",notInProductIds:"",isdisable:"1",isNeedWarehouseProduct:"true",warehouseId:"",orderStr:"prod.cdate desc"}},customColumn:[],tempData:{count:100,defaultDate:"2019-01-21"},showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,leftFixed:2,rightFixed:1,sortableConfig:{"default-sort":{prop:"count",order:"descending"},progress:{},count:{}},dragTable:!1,entireRowDrag:!1},belowTableConfig:{customColumn:[],tempData:{count:100,defaultDate:"2019-01-21"},showIndex:!0,showCheckBox:!1,leftFixed:2,rightFixed:1,dragTable:!1,entireRowDrag:!1},addColumns:[],hideColumns:["remark"],tableSelectList:[],tempList:[]}},created:function(){var t="";if(null!=this.initData.data&&this.initData.data.length>0)for(var e=0;e<this.initData.data.length;e++){var a=this.initData.data[e];null!=a.productId&&a.productId.trim().length>0&&(t=t+a.productId+",")}var i=!0;null!=this.initData.isNeedRepeat&&(i=this.initData.isNeedRepeat),i||null!=t&&t.trim().length>0&&(t="'"+(t=t.substring(0,t.lastIndexOf(","))).replace(",","','")+"'",this.aboveTableConfig.apiObj.params.notInProductIds=t),this.initTree()},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{tableHeight:function(){},dialogWidth:function(){if(this.initData.width){var t=s(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){},closeWin:function(){this.isVisible=!1},dialogClose:function(t){this.$emit("close-dialog",t||{isConfirm:this.isConfirm,selectList:this.tempList})},closeDialog:function(t){this.showDialog=!1},tableSelected:function(t){this.tempList=t},queryTable:function(){this.aboveTableConfig.apiObj.params=Object.assign({},this.aboveTableConfig.apiObj.params,this.tempQuery)},resetQueryTemp:function(){for(var t in this.tempQuery)this.tempQuery[t]="";this.aboveTableConfig.apiObj.params=Object.assign({},this.aboveTableConfig.apiObj.params,this.tempQuery)},initTree:function(){var t=this;this.dialogLoading=!0,Object(o.treeWarehouse)({isNeedEntity:"true"}).then(function(e){t.loadTree(e)}).catch(function(e){t.dialogLoading=!1})},loadTree:function(t){var e=[],a=t.result.treeList;this.selectTree={pid:a.pid,id:a.id,layer:a.layer,name:a.name},e.push(a),this.treeData=e,this.dialogLoading=!1},treeDataBridge:function(t){this.selectTree={pid:t.nodeData.pid,id:t.nodeData.id,layer:t.nodeData.layer,name:t.nodeData.name},this.aboveTableConfig.apiObj.params=Object.assign({},this.aboveTableConfig.apiObj.params,this.tempQuery,{warehouseId:this.selectTree.id})},toDialogAdd:function(){this.$refs.trabsferTables.getTableSelected(),this.isConfirm=!0,this.isVisible=!1}}},r=a("KHd+"),c=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("el-row",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("el-col",{staticStyle:{"background-color":"#F9FAFC","overflow-y":"auto",padding:"8px"},attrs:{span:4}},[a("base-tree",{ref:"tree",attrs:{data:t.treeData,treeConfigs:t.treeConfigs},on:{treedatabridge:t.treeDataBridge}})],1),t._v(" "),a("el-col",{staticStyle:{height:"100%"},attrs:{span:20}},[a("div",{staticStyle:{height:"50px","box-sizing":"border-box",padding:"7px 20px 7px 7px"}},[a("el-form",{staticClass:"form-inline",staticStyle:{width:"1200px",margin:"10px auto"},attrs:{inline:!0,model:t.tempQuery,"label-width":"90px"}},[a("el-col",{staticStyle:{"max-width":"280px"},attrs:{span:5}},[a("el-form-item",{attrs:{label:"货品编码："}},[a("el-input",{attrs:{placeholder:"货品编码"},model:{value:t.tempQuery.code,callback:function(e){t.$set(t.tempQuery,"code",e)},expression:"tempQuery.code"}})],1)],1),t._v(" "),a("el-col",{staticStyle:{"max-width":"280px"},attrs:{span:5}},[a("el-form-item",{attrs:{label:"货品名称："}},[a("el-input",{attrs:{placeholder:"货品名称"},model:{value:t.tempQuery.name,callback:function(e){t.$set(t.tempQuery,"name",e)},expression:"tempQuery.name"}})],1)],1),t._v(" "),a("el-col",{staticStyle:{"max-width":"280px"},attrs:{span:5}},[a("el-form-item",{attrs:{label:"规格型号："}},[a("el-input",{attrs:{placeholder:"规格型号"},model:{value:t.tempQuery.spec,callback:function(e){t.$set(t.tempQuery,"spec",e)},expression:"tempQuery.spec"}})],1)],1),t._v(" "),a("el-col",{staticStyle:{"max-width":"90px"},attrs:{span:3}},[a("el-form-item",[a("base-button",{attrs:{name:"查询",icon:"search"},on:{myclick:this.queryTable}})],1)],1),t._v(" "),a("el-col",{staticStyle:{"max-width":"95px"},attrs:{span:3}},[a("el-form-item",[a("base-button",{attrs:{name:"重置",icon:"refresh",plain:!0},on:{myclick:this.resetQueryTemp}})],1)],1)],1)],1),t._v(" "),a("el-row",{style:{"margin-top":"10px"}},[a("custom-transfer-table",{ref:"trabsferTables",attrs:{aboveTableConfig:t.aboveTableConfig,belowTableConfig:t.belowTableConfig,deDuplication:!1,addColumns:t.addColumns,hideColumns:t.hideColumns,btnList:t.btnList,stateBtn:t.stateBtnData},on:{"table-selected":t.tableSelected}})],1)],1)],1)],1)},[],!1,null,null,null);c.options.__file="selectProductByEntity.vue";e.default=c.exports},JvdH:function(t,e,a){},WIyV:function(t,e,a){"use strict";a("91GP"),a("dRSK"),a("rGqo"),a("INYr"),a("xfY5");var i=a("8WZi"),n=a("z0WU"),o=a("DKCI"),s=a("50Ol"),l=(a("F9dT"),a("Yfch"),a("YP4+")),r=a("WwWg"),c=a("AZ8z"),u=a("mwzG"),h={name:"single-table",mixins:[i.a],provide:function(){return{rootVm:this}},props:{varList:{type:Array,default:function(){return[]}},isFixed:{type:Number,default:1},isSortable:{type:Boolean,default:!1},isRemoval:{type:Boolean,default:!1},useDefaultBtn:{type:Boolean,default:!1},rowKey:{type:String,default:"id"}},data:function(){return{componentName:"singleTable",data:null,fixedList:[],scrollTimer:"",checkedViewHeight:0,pageId:"",initLoading:!0,showColList:"",headerWidthList:[],headerWidthTimerList:[],listLength:-1,selectOptionList:[],selectLoading:!1,tempVarList:[],guid:"",pageNo:1,defaultOperation:{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",method:this.defaultDeleteRow}]},constantWidth:l.a.tableComponentWidth,autoWidthTimer:{},autoWidthList:[],setScrollWidthTimer:-2,autoWidthSwitch:!1,autoWidths:[],columnWidth:{},isLoading:!0,fileList:[],removalVarListTimer:null}},components:{tableFilter:o.a,customSummaryOption:s.a},directives:{"auto-width":{inserted:function(t,e,a){var i=a.context,n=e.value.component?e.value.component.length:0;n>1&&t.clientHeight>60&&i.$set(i.columnWidth,e.value.prop,60*Math.ceil(n/2)+25+"px")}},"merga-width":{bind:function(t,e,a){!a.context.autoWidthTimer[e.value.id]&&(a.context.autoWidthTimer[e.value.id]=-1)},inserted:function(t,e,a){!a.context.autoWidthList.length&&(a.context.autoWidthList=a.context.setTitleList.map(function(t){return[]})),a.context.$nextTick(function(i){-1===a.context.autoWidthTimer[e.value.id]&&(a.context.autoWidthTimer[e.value.id]=setTimeout(function(i){var n=t.offsetWidth,o=e.value,s=a.context.autoWidthList;if(s[o.parentLayer].length)if(s[o.parentLayer][o.selfLayer]>-1){var l=s[o.parentLayer][o.selfLayer];s[o.parentLayer].splice(o.selfLayer,1,n+l)}else s[o.parentLayer][o.selfLayer]=n;else{var r=[];r[o.selfLayer]=n,s.splice(o.parentLayer,1,r)}},20))})}}},computed:{setColumnGlobalStyle:function(){return this.columnGlobalStyle},setVarList:function(){return this.varList.concat([])},removalVarList:function(){return this.removalVarLists(this.setVarList)},setInitLoading:function(){return this.mergeTitle.length?this.initLoading||this.isLoading:this.initLoading},setTableLoading:function(){return this.showTableSet?this.showTableSet&&this.setInitLoading:this.setInitLoading},tableData:function(){return this.$store.getters[this.guid+"/tableData"]||{}},resetPageDataHeight:function(){var t=0;return"boolean"==typeof this.hidePages?!this.hidePages&&this.hasPageData&&(t=this.setSmallPageHeight):void 0===this.hidePages&&(t=this.setSmallPageHeight),t},resetHeight:function(){return this.checkedViewHeight+this.customSummaryOptionHeight+this.resetPageDataHeight},tempCustomColumn:function(){return this.customColumn.concat([])},setCustomColumn:function(){if(this.useDefaultBtn){var t=this.tempCustomColumn.findIndex(function(t){return"last"===t.columnIndex});return t>-1?this.tempCustomColumn.splice(t,1,this.defaultOperation):this.tempCustomColumn.push(this.defaultOperation),this.tempCustomColumn}return this.tempCustomColumn}},created:function(){var t=this;this.guid=Object(n.a)(),this.userInfo=this.$storage.get("userInfo"),Object(r.c)(this),this.apiObj.apiName&&("0"===this.userInfo.userId?setTimeout(function(){t.data=u.a,t.data.result.varList&&t.data.result.varList.length>0&&t.data.result.varList.forEach(function(t){t.rowState="1"}),t.$store.commit(t.guid+"/SET_TABLEDATA",{res:t.data,vm:t}),t.pageId=t.$storage.get("menuId"),t.setDragTable&&t.setSort(),t.initLoading=!1},1e3):this.httpRequests())},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},beforeDestroy:function(){!this.layer&&Object(r.g)(this.$store,this.guid)},updated:function(){},watch:{"tableData.tableData":function(){this.setFixed(),this.setTableCheckBoxDisplay()},"apiObj.params":function(){this.httpRequests()},autoWidthList:{deep:!0,handler:function(t,e){var a=this;clearTimeout(this.setScrollWidthTimer),this.setScrollWidthTimer=setTimeout(function(e){a.autoWidths=t.map(function(t){var e=Math.max.apply(null,t);return e>-9999&&e<9999?e+20:0});var i=0;a.autoWidths.forEach(function(t){i+=t}),a.setShowCheckBox&&(i+=55),a.setShowIndex&&(i+=50),a.setDragTable&&(i+=50);var n=a.$el.clientWidth>i?(a.$el.clientWidth-i)/a.autoWidthList.length:0;a.autoWidths=a.autoWidths.map(function(t){return t?t+n:null}),a.setFixed(),a.autoWidthSwitch=!0,a.isLoading=!1},100)}},removalVarList:function(){var t=this;clearInterval(this.removalVarListTimer),this.removalVarListTimer=setInterval(function(e){t.tableData.titleList&&t.tableData.titleList.length&&(clearInterval(t.removalVarListTimer),t.pushData(t.removalVarList))},200)},initData:function(){var t=this,e=JSON.parse(JSON.stringify(this.initData));this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setDragTable&&this.setSort(),this.pageNo=this.tableData.pageData&&this.tableData.pageData.current||1,this.initLoading=!1,this.$nextTick(function(e){t.scrollTable()})}},methods:{defaultDeleteRow:function(t,e,a){this.deleteData(t)},removalVarLists:function(t){var e=this;if("transferTable"===this.useScenarios)return Object(c.a)(t);var a=[];return t.forEach(function(t,i){!t._internalId&&(t._internalId=Object(n.n)());var o=JSON.parse(JSON.stringify(t));!e.tempVarList.find(function(t){return t._internalId===o._internalId})&&a.push(o)}),a.length&&(this.tempVarList=this.tempVarList.concat(a)),a},httpRequests:function(t){var e=this;this.initLoading=!0,this.$api[this.apiObj.apiName](Object.assign({},this.apiObj.params,{pageNo:t||1})).then(function(a){e.data=a,e.pageNo=a.result.pageData&&a.result.pageData.current||1,e.data.result.varList&&e.data.result.varList.length&&e.data.result.varList.forEach(function(t){t.rowState="1",t._internalId=Object(n.n)()}),e.$store.commit(e.guid+"/SET_TABLEDATA",{res:e.data,vm:e}),e.pageId=e.$storage.get("menuId"),e.setDragTable&&e.setSort(),e.initLoading=!1,t&&e.$nextTick(function(t){e.scrollTable()})}).catch(function(t){console.log(t),e.initLoading=!1})},setStyle:function(t){},selectItem:function(t,e){this.$emit("databridge",t,e),this.isSingle&&(t.length?(this.tableData[this.dataName].forEach(function(t){t.rowState="0"}),t[0].rowState="1"):this.tableData[this.dataName].forEach(function(t){t.rowState="1"}))},selectAllItem:function(t){if(this.isSingle){if(t.length)for(var e=t.length-1;e>=0;e--)t.splice(e,1)}else this.$emit("databridge",t)},handleCurrentChange:function(t){t!==this.pageNo&&(this.apiObj.apiName?this.httpRequests(t)&&(this.tempVarList=[]):this.$emit("current-change",t))},updateTable:function(){this.apiObj&&this.apiObj.apiName&&this.httpRequests()},updateData:function(){this.apiObj&&this.apiObj.apiName&&this.httpRequests()}}},d=(a("0UPH"),a("KHd+")),b=Object(d.a)(h,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:!t.disableLoading&&t.setTableLoading,expression:"!disableLoading && setTableLoading"}],ref:"tableWrapper",staticClass:"columnBaseTable myCoustomTable resetCoustomTableStyle",staticStyle:{height:"100%",position:"relative"}},[t.showTableSet?a("table-filter",{attrs:{headerList:t.setColConfigs,storeId:t.pageId,componentId:t.componentId,showAll:t.showAll},on:{"checked-list":t.checkedList,"checked-height":t.checkedHeight}}):t._e(),t._v(" "),a("div",{style:{height:t.setTableHeight}},[a("el-form",{ref:"ruleForm",style:{height:"100%"},attrs:{model:t.ruleForm,"status-icon":""},nativeOn:{submit:function(t){t.preventDefault()}}},[a("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:t.tableData.tableData,stripe:"",border:"","current-row-key":t.rowKey,"tooltip-effect":"dark",height:"100%",fit:"","header-cell-class-name":t.setStyle,"row-key":"_internalId","default-sort":t.setSortableConfig["default-sort"],"show-summary":t.setSysSummary},on:{select:t.selectItem,"select-all":t.selectAllItem,"selection-change":t.selectionChange,"sort-change":t.sortChange,"row-click":t.rowClick,"row-dblclick":t.rowDblclick}},[t.setShowCheckBox?[a("el-table-column",{attrs:{type:"selection",fixed:t.fixedState,selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.setShowIndex?[a("el-table-column",{attrs:{type:"index",index:t.indexMethod,fixed:t.fixedState,label:"序号",width:"50",align:"center"}})]:t._e(),t._v(" "),t._l(t.setTitleList,function(e,i){return[e.slot&&e._isShow?t._t(e.slot,null,{fixed:t.setFixedList[i]}):Array.isArray(e.component)&&e._isShow?[a("el-table-column",t._b({key:i,attrs:{"show-overflow-tooltip":"",fixed:t.setFixedList[i],"min-width":t.setColumnWidth[e.prop]||null,align:"center"},scopedSlots:t._u([{key:"header",fn:function(n){return[a("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:i,isComponent:!0,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"},{name:"custom-table-switch",rawName:"v-custom-table-switch",value:{config:e,index:i,showSwitch:t.setShowTableSet},expression:"{config:colConfig,index:infoIndex,showSwitch:setShowTableSet,}"}]},[t._v(t._s(e.label))])]}},{key:"default",fn:function(i){return["button"===e.componentName?a("div",{directives:[{name:"auto-width",rawName:"v-auto-width",value:e,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":t.setColumnWidth[e.prop]?"space-between":"center"}},t._l(e.component,function(e,n){return void 0!==e.editBtns_isShow&&!e.editBtns_isShow||!e.rowState||t.setButtonState(i.$index,i.row,e)?a("el-button",{key:n,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(t){e.method(i.row,i.$index,i)}}},[t._v(t._s(e.name))]):t._e()}),1):t._e()]}}])},"el-table-column",e,!1))]:"object"==typeof e.component&&e._isShow?a(e.component,{key:i,tag:"component",attrs:{"col-config":e,fixed:t.setFixedList[i]}}):[e._isShow?a("el-table-column",t._b({key:i,attrs:{"show-overflow-tooltip":"","min-width":t.constantWidth[e.componentName]||t.autoWidths[i]||e.width||null,sortable:void 0===e.sortable?t.isSortable:e.sortable,fixed:t.setFixedList[i],label:e.label,align:"center"},scopedSlots:t._u([{key:"header",fn:function(n){return[a("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:i,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"},{name:"custom-table-switch",rawName:"v-custom-table-switch",value:{config:e,index:i,showSwitch:t.setShowTableSet},expression:"{config:colConfig,index:infoIndex,showSwitch:setShowTableSet}"}],style:{display:e._isShow?"inline-flex":"none"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(t){return[a("core-index",{attrs:{scope:t,"info-index":i,"col-config":e,runTime:"base"}})]}}])},"el-table-column",e,!1)):t._e()]]}),t._v(" "),t.setDragTable?[a("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:t._u([{key:"default",fn:function(t){return[a("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[a("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)]}}])})]:t._e()],2)],1),t._v(" "),t.setUseSummary&&t.setCustomSummary.component?[a("custom-summary-option",{attrs:{customSummary:t.setCustomSummary,tempData:t.setTempData,tableData:t.tableData.tableData},on:{"send-height":t.customSummaryHeight,"custom-summary-value":t.customSummaryValue}})]:t._e()],2),t._v(" "),!t.hidePages&&t.hasPageData?a("div",{staticStyle:{"text-align":"center"},style:{"margin-top":(t.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[a("el-pagination",{attrs:{background:!t.smallPage,small:t.smallPage,"current-page":t.tableData.pageData.current,"page-size":t.tableData.pageData.size,layout:"prev, pager, next, jumper",total:t.tableData.pageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.tableData.pageData,"current",e)}}})],1):t._e()],1)},[],!1,null,"c0a30828",null);b.options.__file="index.vue";e.a=b.exports},varj:function(t,e,a){"use strict";a("dRSK"),a("INYr"),a("91GP"),a("rGqo"),a("z0WU"),a("Yfch");var i=a("AZ8z"),n={props:["colConfig","fixed"],template:'<el-table-column :label="colConfig.label" :fixed="fixed" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t  <template v-for="(item, index) in colConfig.rowMethods">\n    \t\t\t\t\t    <el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="item.method(scope.row,scope.$index)" v-text="item.name"></el-button>\n                </template>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},o={components:{customBaseTable:a("WIyV").a},name:"custom-transfer-table",props:{btnList:{type:Array,default:function(){return[]}},stateBtn:{type:Object,default:function(){return{}}},aboveTableConfig:{type:Object,default:function(){return{}}},belowTableConfig:{type:Object,default:function(){return{}}},addColumns:{type:Array,default:function(){return[]}},hideColumns:{type:Array,default:function(){return[]}},deDuplication:{type:Boolean,default:!1},useDefaultBtn:{type:Boolean,default:!0},rowKey:{type:String,default:"id"}},data:function(){return{selectTableGuid:"",resultTableGuid:"",aboveTableLoading:!0,belowTableLoading:!0,btnsBoxHeight:0,currentpage:1,tableLoading:!1,resultTableData:[],titleList:[],pageData:{},tableBtns:{columnIndex:"last",prop:"operate",label:"操作",component:n,rowMethods:[{name:"删除",method:this.deleteRow}]},tempSelectList:[],stateBtnChecked:!1,aboveTableInitData:{},belowTableInitData:null,belowTableDataTimer:""}},computed:{apiData:function(){return this.aboveTableConfig.apiObj||null},belowApiData:function(){return this.belowTableConfig.apiObj||null},setBelowTableLoading:function(){return!!this.belowApiData&&this.belowTableLoading},setCustomTransferTableLoading:function(){return this.aboveTableLoading||this.setBelowTableLoading},setTablesHeight:function(){return this.stateBtn.title?{height:"calc(50% - 15px)"}:{height:"calc(50% - 6px)"}},setResultBtnState:function(){var t=this;return function(e){return!t.resultTableData.length&&e.state}},mixCustomColumn:function(){return[].concat([],this.addColumns,this.belowTableConfig.customColumn||[],this.useDefaultBtn?[this.tableBtns]:[])},setResultTableData:function(){return[].concat(this.resultTableData)},selectTableData:function(){return this.selectTableGuid?this.$store.getters[this.selectTableGuid+"/tableData"]:{}},tableData:function(){return this.selectTableData.tableData||[]},belowTableData:function(){return this.resultTableGuid&&this.$store.getters[this.resultTableGuid+"/tableData"].tableData||[]}},watch:{setResultTableData:function(){var t=this,e=Object(i.a)(this.setResultTableData);(e||[]).forEach(function(e){t.addColumns.forEach(function(a){e.hasOwnProperty([a.prop])||(e[a.prop]=t.initRowDataValue(a.componentName))})}),this.$refs.resultTable.updataTableRow&&this.$refs.resultTable.updataTableRow(e)},stateBtnChecked:function(){var t={};t[this.stateBtn.keyName?this.stateBtn.keyName:"isShow"]=this.stateBtnChecked,this.httpAboveTableData(this.apiData.apiName,this.apiData.params,t)},"apiData.params":function(){console.log(this.apiData.params),this.httpAboveTableData(this.apiData.apiName,this.apiData.params)}},created:function(){this.apiData&&this.httpAboveTableData(this.apiData.apiName,this.apiData.params),this.belowApiData&&this.httpBelowTableData(this.belowApiData.apiName,this.belowApiData.params)},mounted:function(){this.$nextTick(function(){this.selectTableGuid=this.$refs.selectTable.guid,this.resultTableGuid=this.$refs.resultTable.guid,this.btnsBoxHeight=this.$refs.btnsBox.clientHeight+5})},methods:{initRowDataValue:function(t){return t?"cascader"===t?[]:"inputNumber"===t||"progress"===t?0:"":""},clearTableSelected:function(){var t=this;this.resultTableData=[],this.tempSelectList=[],this.tableData.forEach(function(e){t.$refs.selectTable.$refs.baseTable.clearSelection()})},httpAboveTableData:function(t,e,a){var i=this;this.aboveTableLoading=!0,this.$api[t](Object.assign({},e,a)).then(function(t){i.aboveTableInitData=t,i.belowApiData||i.belowTableInitData||(i.belowTableInitData=i.initBelowTableData(t)),i.tempSelectList=[],i.$nextTick(function(t){i.toggleRowSelected()}),i.aboveTableLoading=!1}).catch(function(t){i.aboveTableLoading=!1})},httpBelowTableData:function(t,e,a){var i=this;this.belowTableLoading=!0,this.$api[t](Object.assign({},e,a)).then(function(t){i.belowTableInitData=i.initBelowTableData(t),i.belowTableLoading=!1}).catch(function(t){i.belowTableLoading=!1})},initBelowTableData:function(t){if(t){var e=this.belowApiData?t:Object(i.a)(t),a=this.belowApiData?Object(i.a)("string"==typeof e.result.varList?JSON.parse(e.result.varList):e.result.varList):[];return e.result.titles="string"==typeof e.result.titles?JSON.parse(e.result.titles):e.result.titles,e.result.hideTitles="string"==typeof e.result.hideTitles?JSON.parse(e.result.hideTitles):e.result.hideTitles,this.hideColumns.forEach(function(t){!(e.result.hideTitles.findIndex(function(e){return t===e})>-1)&&e.result.hideTitles.push(t)}),e.result.varList=[],this.belowApiData&&this.addBelowTableData(a),e}},addBelowTableData:function(t){var e=this;clearInterval(this.belowTableDataTimer),this.belowTableDataTimer=setInterval(function(a){e.selectTableData.titleList&&e.selectTableData.tableData&&(clearInterval(e.belowTableDataTimer),e.dataBridge(t),e.toggleRowSelected())},50)},toggleRowSelected:function(){var t=this;this.tableData.forEach(function(e){t.resultTableData.some(function(a){return e[t.rowKey]===a[t.rowKey]})?(t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!0),!t.tempSelectList.some(function(a){return a[t.rowKey]===e[t.rowKey]})&&t.tempSelectList.push(e)):t.$refs.selectTable&&t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!1)})},currentChange:function(t){this.httpAboveTableData(this.apiData.apiName,this.apiData.params,{pageNo:t})},dataBridge:function(t,e){this.getChecked(e,t)?this.addRowData(e):this.removeRowData(e)},resultDataBridge:function(t,e){},deleteRow:function(t,e){var a=this;this.resultTableData.find(function(e,i){if(t[a.rowKey]===e[a.rowKey])return a.resultTableData.splice(i,1),e}),this.toggleRowSelected()},getChecked:function(t,e){var a=this;return t?e.some(function(e){return t[a.rowKey]===e[a.rowKey]}):(e.length&&(this.tempSelectList=e),!!e.length)},addRowData:function(t){var e=this;t?!this.resultTableData.some(function(a){return t[e.rowKey]===a[e.rowKey]})&&this.resultTableData.push(t):this.addAllRowData()},addAllRowData:function(){var t=this;this.resultTableData.length?this.tempSelectList.forEach(function(e){t.addRowData(e)}):this.resultTableData=this.tempSelectList},removeRowData:function(t){var e=this;t?this.resultTableData.some(function(a,i){if(t[e.rowKey]===a[e.rowKey])return e.resultTableData.splice(i,1),!0}):this.tableData.forEach(function(t){e.removeRowData(t)})},getTableSelected:function(){this.$emit("table-selected",this.belowTableData)}}},s=a("KHd+"),l=Object(s.a)(o,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.setCustomTransferTableLoading,expression:"setCustomTransferTableLoading"}],staticClass:"myCoustomTable resetTransferTableStyle",staticStyle:{height:"100%",padding:"10px"}},[t.stateBtn&&t.stateBtn.title?a("div",{staticStyle:{"text-align":"right"}},[a("el-checkbox",{model:{value:t.stateBtnChecked,callback:function(e){t.stateBtnChecked=e},expression:"stateBtnChecked"}},[t._v(t._s(t.stateBtn.title))])],1):t._e(),t._v(" "),a("div",{style:t.setTablesHeight},[a("custom-base-table",{ref:"selectTable",attrs:{useScenarios:"transferTable",isRemoval:t.aboveTableConfig.isRemoval||!1,showIndex:t.aboveTableConfig.showIndex||!1,showCheckBox:t.aboveTableConfig.showCheckBox||!1,showTableSet:t.aboveTableConfig.showTableSet||!1,customColumn:t.aboveTableConfig.customColumn,initData:t.aboveTableInitData,mergeTitle:t.aboveTableConfig.mergeTitle,componentId:"transferAboveTable",tempData:t.aboveTableConfig.tempData,dragTable:t.aboveTableConfig.dragTable,entireRowDrag:t.aboveTableConfig.entireRowDrag},on:{"current-change":t.currentChange,databridge:t.dataBridge}})],1),t._v(" "),a("div",{staticStyle:{height:"11px"}}),t._v(" "),a("div",{ref:"resultBox",staticStyle:{position:"relative"},style:t.setTablesHeight},[a("div",{staticStyle:{height:"100%"},style:{paddingBottom:t.btnsBoxHeight+"px"}},[a("custom-base-table",{ref:"resultTable",attrs:{useScenarios:"transferTable",isRemoval:t.belowTableConfig.isRemoval||!1,showIndex:t.belowTableConfig.showIndex||!1,showCheckBox:t.belowTableConfig.showCheckBox||!1,showTableSet:t.belowTableConfig.showTableSet||!1,hidePages:t.belowTableConfig.hidePages||!0,customColumn:t.mixCustomColumn,initData:t.belowTableInitData,mergeTitle:t.belowTableConfig.mergeTitle,componentId:"transferBelowTable",tempData:t.belowTableConfig.tempData,dragTable:t.belowTableConfig.dragTable,entireRowDrag:t.belowTableConfig.entireRowDrag},on:{databridge:t.resultDataBridge}})],1),t._v(" "),a("div",{ref:"btnsBox",staticStyle:{position:"absolute",bottom:"0",right:"0"}},[t.btnList.length?[t._l(t.btnList,function(e,i){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],key:i,attrs:{name:e.name,icon:e.icon,plain:e.plain,state:t.setResultBtnState(e)},on:{myclick:e.method}})]})]:t._e()],2)])])},[],!1,null,null,null);l.options.__file="index.vue";e.a=l.exports}}]);