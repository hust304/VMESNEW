(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-f764"],{"3yzq":function(e,t,i){},"MpF+":function(e,t,i){"use strict";var a=i("3yzq");i.n(a).a},WIyV:function(e,t,i){"use strict";i("91GP"),i("dRSK"),i("rGqo"),i("INYr"),i("xfY5");var a=i("4Q6Z"),n=i("z0WU"),o=i("DKCI"),l=i("50Ol"),s=(i("F9dT"),i("Yfch"),i("YP4+")),r=i("WwWg"),c=i("mwzG"),d={name:"single-table",mixins:[a.a],provide:function(){return{rootVm:this}},props:{varList:{type:Array,default:function(){return[]}},isFixed:{type:Number,default:1},isSortable:{type:Boolean,default:!0},isRemoval:{type:Boolean,default:!1},useDefaultBtn:{type:Boolean,default:!1},rowKey:{type:String,default:"id"}},data:function(){return{componentName:"singleTable",data:null,fixedList:[],scrollTimer:"",checkedViewHeight:0,pageId:"",initLoading:!0,showColList:"",headerWidthList:[],headerWidthTimerList:[],listLength:-1,debounce:300,selectOptionList:[],selectLoading:!1,tempVarList:[],varListPushState:!1,guid:"",pageNo:1,defaultOperation:{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",method:this.defaultDeleteRow}]},constantWidth:s.a.tableComponentWidth,autoWidthTimer:{},autoWidthList:[],setScrollWidthTimer:-2,autoWidthSwitch:!1,autoWidths:[],columnWidth:{},isLoading:!0,fileList:[],removalVarListTimer:null}},components:{tableFilter:o.a,customSummaryOption:l.a},directives:{"auto-width":{inserted:function(e,t,i){var a=i.context,n=t.value.component?t.value.component.length:0;n>1&&e.clientHeight>60&&a.$set(a.columnWidth,t.value.prop,60*Math.ceil(n/2)+25+"px")}},"merga-width":{bind:function(e,t,i){!i.context.autoWidthTimer[t.value.id]&&(i.context.autoWidthTimer[t.value.id]=-1)},inserted:function(e,t,i){!i.context.autoWidthList.length&&(i.context.autoWidthList=i.context.setTitleList.map(function(e){return[]})),i.context.$nextTick(function(a){-1===i.context.autoWidthTimer[t.value.id]&&(i.context.autoWidthTimer[t.value.id]=setTimeout(function(a){var n=e.offsetWidth,o=t.value,l=i.context.autoWidthList;if(l[o.parentLayer].length)if(l[o.parentLayer][o.selfLayer]>-1){var s=l[o.parentLayer][o.selfLayer];l[o.parentLayer].splice(o.selfLayer,1,n+s)}else l[o.parentLayer][o.selfLayer]=n;else{var r=[];r[o.selfLayer]=n,l.splice(o.parentLayer,1,r)}},20))})}}},computed:{setColumnGlobalStyle:function(){return{0:this.columnGlobalStyle}},setVarList:function(){return this.varList.concat([])},removalVarList:function(){return this.removalVarLists(this.setVarList)},setInitLoading:function(){return this.mergeTitle.length?this.initLoading||this.isLoading:this.initLoading},setTableLoading:function(){return this.showTableSet?this.showTableSet&&this.setInitLoading:this.setInitLoading},tableData:function(){return this.$store.getters[this.guid+"/tableData"]||{}},resetPageDataHeight:function(){var e=0;return"boolean"==typeof this.hidePages?!this.hidePages&&this.hasPageData&&(e=this.setSmallPageHeight):void 0===this.hidePages&&(e=this.setSmallPageHeight),e},resetHeight:function(){return this.checkedViewHeight+this.customSummaryOptionHeight+this.resetPageDataHeight},tempCustomColumn:function(){return this.customColumn.concat([])},setCustomColumn:function(){if(this.useDefaultBtn){var e=this.tempCustomColumn.findIndex(function(e){return"last"===e.columnIndex});return e>-1?this.tempCustomColumn.splice(e,1,this.defaultOperation):this.tempCustomColumn.push(this.defaultOperation),this.tempCustomColumn}return this.tempCustomColumn}},created:function(){var e=this;this.guid=Object(n.a)(),this.userInfo=this.$storage.get("userInfo"),Object(r.c)(this),this.apiObj.apiName&&("0"===this.userInfo.userId?setTimeout(function(){e.data=c.a,e.data.result.varList&&e.data.result.varList.length>0&&e.data.result.varList.forEach(function(e){e.rowState="1"}),e.$store.commit(e.guid+"/SET_TABLEDATA",{res:e.data,vm:e}),e.pageId=e.$storage.get("menuId"),e.setDragTable&&e.setSort(),e.initLoading=!1},1e3):this.httpRequests())},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},updated:function(){},watch:{"tableData.tableData":function(){this.setFixed(),this.setTableCheckBoxDisplay()},"apiObj.params":function(){this.httpRequests()},autoWidthList:{deep:!0,handler:function(e,t){var i=this;clearTimeout(this.setScrollWidthTimer),this.setScrollWidthTimer=setTimeout(function(t){i.autoWidths=e.map(function(e){var t=Math.max.apply(null,e);return t>-9999&&t<9999?t+20:0});var a=0;i.autoWidths.forEach(function(e){a+=e}),i.setShowCheckBox&&(a+=55),i.setShowIndex&&(a+=50),i.setDragTable&&(a+=50);var n=i.$el.clientWidth>a?(i.$el.clientWidth-a)/i.autoWidthList.length:0;i.autoWidths=i.autoWidths.map(function(e){return e?e+n:null}),i.setFixed(),i.autoWidthSwitch=!0,i.isLoading=!1},100)}},removalVarList:function(){var e=this;clearTimeout(this.removalVarListTimer),this.removalVarListTimer=setTimeout(function(t){e.pushData(e.removalVarList)})},initData:function(){var e=JSON.parse(JSON.stringify(this.initData));this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setDragTable&&this.setSort(),this.initLoading=!1}},methods:{defaultDeleteRow:function(e,t,i){this.deleteData(e)},removalVarLists:function(e){var t=this,i=[];return e.forEach(function(e,a){!e._internalId&&(e._internalId=Object(n.o)());var o=JSON.parse(JSON.stringify(e));!t.tempVarList.find(function(e){return e._internalId===o._internalId})&&i.push(o)}),i.length&&(this.tempVarList=this.tempVarList.concat(i)),i.length&&(this.varListPushState=!0),i},httpRequests:function(e){var t=this;this.initLoading=!0,this.$api[this.apiObj.apiName](Object.assign({},this.apiObj.params,{pageNo:e||1})).then(function(i){t.data=i,t.pageNo=i.result.pageData&&i.result.pageData.current||1,t.data.result.varList&&t.data.result.varList.length&&t.data.result.varList.forEach(function(e){e.rowState="1",e._internalId=Object(n.o)()}),t.$store.commit(t.guid+"/SET_TABLEDATA",{res:t.data,vm:t}),t.pageId=t.$storage.get("menuId"),t.setDragTable&&t.setSort(),t.initLoading=!1,e&&t.scrollTable()}).catch(function(e){console.log(e),t.initLoading=!1})},setStyle:function(e){},selectItem:function(e,t){this.$emit("databridge",e,t),this.isSingle&&(e.length?(this.tableData[this.dataName].forEach(function(e){e.rowState="0"}),e[0].rowState="1"):this.tableData[this.dataName].forEach(function(e){e.rowState="1"}))},selectAllItem:function(e){if(this.isSingle){if(e.length)for(var t=e.length-1;t>=0;t--)e.splice(t,1)}else this.$emit("databridge",e)},handleCurrentChange:function(e){e!==this.pageNo&&this.httpRequests(e)&&(this.tempVarList=[])},updateTable:function(){this.httpRequests()},updateData:function(){this.httpRequests()}}},u=(i("MpF+"),i("KHd+")),h=Object(u.a)(d,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:!e.disableLoading&&e.setTableLoading,expression:"!disableLoading && setTableLoading"}],ref:"tableWrapper",staticClass:"columnBaseTable myCoustomTable resetCoustomTableStyle",staticStyle:{height:"100%",position:"relative"}},[e.showTableSet?i("table-filter",{attrs:{headerList:e.setColConfigs,storeId:e.pageId,componentId:e.componentId,showAll:e.showAll},on:{"checked-list":e.checkedList,"checked-height":e.checkedHeight}}):e._e(),e._v(" "),i("div",{style:{height:e.setTableHeight}},[i("el-form",{ref:"ruleForm",style:{height:"100%"},attrs:{model:e.ruleForm,"status-icon":""},nativeOn:{submit:function(e){e.preventDefault()}}},[i("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:e.tableData.tableData,stripe:"",border:"","current-row-key":e.rowKey,"tooltip-effect":"dark",height:"100%",fit:"","header-cell-class-name":e.setStyle,"row-key":"_internalId","default-sort":e.setSortableConfig["default-sort"],"show-summary":e.setSysSummary},on:{select:e.selectItem,"select-all":e.selectAllItem,"sort-change":e.sortChange}},[e.setShowCheckBox?[i("el-table-column",{attrs:{type:"selection",fixed:e.fixedState,selectable:e.selectable,width:"55",align:"center"}})]:e._e(),e._v(" "),e.setShowIndex?[i("el-table-column",{attrs:{type:"index",index:e.indexMethod,fixed:e.fixedState,label:"序号",width:"50",align:"center"}})]:e._e(),e._v(" "),e._l(e.setTitleList,function(t,a){return[t.slot&&t._isShow?e._t(t.slot,null,{fixed:e.setFixedList[a]}):Array.isArray(t.component)&&t._isShow?[i("el-table-column",e._b({key:a,attrs:{"show-overflow-tooltip":"",fixed:e.setFixedList[a],width:e.setColumnWidth[t.prop]||null,align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[i("div",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:a,isComponent:!0,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"},{name:"custom-table-switch",rawName:"v-custom-table-switch",value:{config:t,index:a,showSwitch:e.setShowTableSet},expression:"{config:colConfig,index:infoIndex,showSwitch:setShowTableSet,}"}]},[e._v(e._s(t.label))])]}},{key:"default",fn:function(a){return["button"===t.componentName?i("div",{directives:[{name:"auto-width",rawName:"v-auto-width",value:t,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":e.setColumnWidth[t.prop]?"space-between":"center"}},e._l(t.component,function(t,n){return void 0!==t.editBtns_isShow&&!t.editBtns_isShow||!t.rowState||e.setButtonState(a.$index,a.row,t)?i("el-button",{key:n,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(e){t.method(a.row,a.$index,a)}}},[e._v(e._s(t.name))]):e._e()}),1):e._e()]}}])},"el-table-column",t,!1))]:"object"==typeof t.component&&t._isShow?i(t.component,{key:a,tag:"component",attrs:{"col-config":t,fixed:e.setFixedList[a]}}):[t._isShow?i("el-table-column",e._b({key:a,attrs:{"show-overflow-tooltip":"","min-width":e.constantWidth[t.componentName]||e.autoWidths[a]||t.width||null,sortable:void 0===t.sortable?e.isSortable:t.sortable,fixed:e.setFixedList[a],label:t.label,align:"center"},scopedSlots:e._u([{key:"header",fn:function(n){return[i("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:t._isShow,index:a,label:t.label,prop:t.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"},{name:"custom-table-switch",rawName:"v-custom-table-switch",value:{config:t,index:a,showSwitch:e.setShowTableSet},expression:"{config:colConfig,index:infoIndex,showSwitch:setShowTableSet}"}],style:{display:t._isShow?"inline-flex":"none"},domProps:{textContent:e._s(t.label)}})]}},{key:"default",fn:function(n){return[t.mergeTitles&&t.mergeTitles.length?[e._l(t.mergeTitles,function(o,l){return[o.componentName?["input"===o.componentName?[o._cellConfig.asyn?[i("el-form-item",{key:l,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-autocomplete",{attrs:{_scope:n,"child-colconfig":o},on:{"call-table-fn":e.callTableFn}})],1)]:[i("el-form-item",{key:l,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-input",{attrs:{_scope:n,"child-colconfig":o},on:{"call-table-fn":e.callTableFn}})],1)]]:"date"===o.componentName?[i("table-date-picker",{attrs:{_scope:n,"child-colconfig":o}})]:"time"===o.componentName?[i("table-time-picker",{attrs:{_scope:n,"child-colconfig":o}})]:"select"===o.componentName?[i("el-form-item",{key:l,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-select",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"cascader"===o.componentName?[i("el-form-item",{key:l,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-cascader",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"switch"===o.componentName?[i("div",[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[e._v("\n                            "+e._s(o.label+":")+" \n                          ")]),e._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-switch",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"dateTime"===o.componentName?[i("table-date-time",{attrs:{_scope:n,"child-colconfig":o}})]:"inputNumber"===o.componentName?[i("el-form-item",{key:l,attrs:{prop:"tableData."+n.$index+"."+o.prop,rules:e.baseRules(n.$index,n.row,o),"inline-message":!0}},[i("table-input-number",{attrs:{_scope:n,"child-colconfig":o}})],1)]:"steps"===o.componentName?[i("div",{key:l,staticClass:"resetElStepStyle"},[o._cellConfig.hideTitle?e._e():i("div",{directives:[{name:"merga-width",rawName:"v-merga-width",value:{parentLayer:a,selfLayer:l,id:"_0"+o.prop},expression:"{parentLayer:infoIndex,selfLayer:cIndex,id:'_0'+childColconfig.prop}"}],style:o._cellConfig.titleStyle||{}},[e._v(e._s(o.label+":")+" ")]),e._v(" "),i("div",{directives:[{name:"merga-width",rawName:"v-merga-width",value:{parentLayer:a,selfLayer:l,id:"_1"+o.prop},expression:"{parentLayer:infoIndex,selfLayer:cIndex,id:'_1'+childColconfig.prop}"}]},[i("table-steps",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"progress"===o.componentName?[i("div",{key:l,staticStyle:{"text-align":"left"}},[o._cellConfig.hideTitle?e._e():i("div",{directives:[{name:"merga-width",rawName:"v-merga-width",value:{parentLayer:a,selfLayer:l,id:"_0"+o.prop},expression:"{parentLayer:infoIndex,selfLayer:cIndex,id:'_0'+childColconfig.prop}"}],staticStyle:{display:"inline-block"},style:[{"line-height":o._cellConfig.componentConfig["stroke-width"]>23?2:""},o._cellConfig.titleStyle||(e.setColumnGlobalStyle[e.layer]?e.setColumnGlobalStyle[e.layer].titleStyle:{})||{}]},[e._v(e._s(o.label+":"+(o._cellConfig.componentConfig.showInitValue?n.row[o.prop]:""))+" ")]),e._v(" "),i("div",{directives:[{name:"merga-width",rawName:"v-merga-width",value:{parentLayer:a,selfLayer:l,id:"_1"+o.prop},expression:"{parentLayer:infoIndex,selfLayer:cIndex,id:'_1'+childColconfig.prop}"}],staticClass:"resetProgressStyle",staticStyle:{display:"inline-block",overflow:"hidden","vertical-align":"middle"},style:{width:(o._cellConfig.componentConfig.width||e.constantWidth[o.componentName])+"px"}},[i("table-progress",{attrs:{_scope:n,"child-colconfig":o}})],1)])]:"upload"===o.componentName?[i("table-upload",{attrs:{_scope:n,"child-colconfig":o}})]:"tag"===o.componentName?[i("table-tag",{attrs:{_scope:n,"child-colconfig":o}})]:"button"===o.componentName?[o._cellConfig.hideTitle?e._e():i("div",{staticStyle:{display:"inline-block"},style:o._cellConfig.titleStyle||{}},[e._v("\n                          "+e._s(o.label+":")+" \n                        ")]),e._v(" "),i("div",{staticStyle:{display:"inline-block"}},[i("table-button",{attrs:{_scope:n,"child-colconfig":o}})],1)]:[i("span",{key:l,staticStyle:{"margin-left":"10px"},domProps:{textContent:e._s(n.row[o.prop])}})]]:[i("div",{key:l,style:{"text-align":o._cellConfig&&o._cellConfig.hideTitle?"center":"left"}},[o._cellConfig?[o._cellConfig.hideTitle?e._e():[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:l,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"},{name:"merga-width",rawName:"v-merga-width",value:{parentLayer:a,selfLayer:l,id:"_0"+o.prop},expression:"{parentLayer:infoIndex,selfLayer:cIndex,id:'_0'+childColconfig.prop}"}],style:[o._cellConfig.titleStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.titleStyle:{}),e.setMiddleValue[a]?e.setMiddleValue[a].title:{}],domProps:{textContent:e._s(o.label+":")}},[e._v(" ")])]]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:l,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!0},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:true}"},{name:"merga-width",rawName:"v-merga-width",value:{parentLayer:a,selfLayer:l,id:"_0"+o.prop},expression:"{parentLayer:infoIndex,selfLayer:cIndex,id:'_0'+childColconfig.prop}"}],style:e.setMiddleValue[a]?e.setMiddleValue[a].title:{},domProps:{textContent:e._s(o.label+":")}},[e._v(" ")])],e._v(" "),o._cellConfig&&o._cellConfig.events?[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:l,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"},{name:"merga-width",rawName:"v-merga-width",value:{parentLayer:a,selfLayer:l,id:"_1"+o.prop},expression:"{parentLayer:infoIndex,selfLayer:cIndex,id:'_1'+childColconfig.prop}"}],style:[o._cellConfig.bodyStyle||(e.setColumnGlobalStyle?e.setColumnGlobalStyle.bodyStyle:{}),e.setMiddleValue[a]?e.setMiddleValue[a].body:{}]},[i("a",{domProps:{textContent:e._s(n.row[o.prop])},on:{click:function(t){e.mergeColumnEvents(o,n)}}})])]:[i("span",{directives:[{name:"reset-content-width",rawName:"v-reset-content-width",value:{index:a,cIndex:l,colConfig:t,childColconfig:o,rowIndex:n.$index,isTitle:!1},expression:"{index:infoIndex,cIndex,colConfig,childColconfig,rowIndex:scope.$index,isTitle:false}"},{name:"merga-width",rawName:"v-merga-width",value:{parentLayer:a,selfLayer:l,id:"_1"+o.prop},expression:"{parentLayer:infoIndex,selfLayer:cIndex,id:'_1'+childColconfig.prop}"},{name:"content-set",rawName:"v-content-set",value:{config:o,row:n.row},expression:"{config: childColconfig,row: scope.row}"}],class:{resetContent:e.setMiddleValue[a],ellipsis:!!e.setMiddleValue[a]&&e.isEllipsis(n.row[o.columnIndex||o.prop],parseInt(e.setMiddleValue[a].body.width))},style:[o._cellConfig?o._cellConfig.bodyStyle:{},e.setColumnGlobalStyle?e.setColumnGlobalStyle.bodyStyle:{},e.setMiddleValue[a]?e.setMiddleValue[a].body:{}],domProps:{textContent:e._s(n.row[o.columnIndex||o.prop])}})]],2)]]})]:[e._v("\n                  "+e._s(n.row[t.prop])+"\n                ")]]}}])},"el-table-column",t,!1)):e._e()]]}),e._v(" "),e.setDragTable?[i("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:e._u([{key:"default",fn:function(e){return[i("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[i("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)]}}])})]:e._e()],2)],1),e._v(" "),e.setUseSummary&&e.setCustomSummary.component?[i("custom-summary-option",{attrs:{customSummary:e.setCustomSummary,tempData:e.setTempData,tableData:e.tableData.tableData},on:{"send-height":e.customSummaryHeight,"custom-summary-value":e.customSummaryValue}})]:e._e()],2),e._v(" "),!e.hidePages&&e.hasPageData?i("div",{staticStyle:{"text-align":"center"},style:{"margin-top":(e.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[i("el-pagination",{attrs:{background:!e.smallPage,small:e.smallPage,"current-page":e.tableData.pageData.current,"page-size":e.tableData.pageData.size,layout:"prev, pager, next, jumper",total:e.tableData.pageData.total-0},on:{"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.tableData.pageData,"current",t)}}})],1):e._e()],1)},[],!1,null,"f65d1176",null);h.options.__file="index.vue";t.a=h.exports}}]);