(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-38ae","chunk-7b78"],{"+Jge":function(t,e,n){},"6Tkm":function(t,e,n){},"9CiS":function(t,e,n){},AZ8z:function(t,e,n){"use strict";n.d(e,"a",function(){return r});n("rE2o"),n("ioFf"),n("dRSK"),n("Oyvg"),n("a1Th");function a(t){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}function i(t){return Object.prototype.toString.call(t).slice(8,-1)}function o(t){var e="";t.global&&(e+="g"),t.ignoreCase&&(e+="i"),t.multiline&&(e+="m");var n=new RegExp(t,e);return n.lastIndex=t.lastIndex,n}function r(t){if(null==t||"object"!==a(t))return t;var e;switch(i(t)){case"RegExp":return o(t);case"Date":return new Date(t.getTime());case"Function":return t;case"Array":e=[];break;default:e=Object.create(Object.getPrototypeOf(t))}for(var n=[],r=[{parent:e,key:void 0,data:t}],s=function(){var t=r.pop(),e=t.parent,s=t.key,l=t.data,u=e;if(void 0!==s)switch(i(l)){case"RegExp":return e[s]=o(l),"continue";case"Date":return e[s]=new Date(l.getTime()),"continue";case"Function":return e[s]=l,"continue";case"Array":u=e[s]=[];break;default:var c=Object.getPrototypeOf(l);u=e[s]=Object.create(c)}var d=n.find(function(t){return t.source===l});if(d)return e[s]=d.target,"continue";for(var m in n.push({source:l,target:u}),l)l.hasOwnProperty(m)&&(null==l[m]||"object"!==a(l[m])?u[m]=l[m]:r.push({parent:u,key:m,data:l[m]}))};r.length;)s();return e}},B7Ix:function(t,e,n){"use strict";var a=n("oeZg");n.n(a).a},Cg3q:function(t,e,n){"use strict";var a=n("mdfD");n.n(a).a},EiiD:function(t,e,n){},GzjI:function(t,e,n){"use strict";var a=n("6Tkm");n.n(a).a},MngD:function(t,e,n){"use strict";n("rGqo"),n("yt8O"),n("RW0V"),n("KKXr");function a(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{},a=Object.keys(n);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(n).filter(function(t){return Object.getOwnPropertyDescriptor(n,t).enumerable}))),a.forEach(function(e){i(t,e,n[e])})}return t}function i(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}var o={name:"EditShape",props:{active:{type:Boolean,default:!1},defaultStyle:{require:!0,type:Object},data:{type:Object,default:function(){return null}},uuid:String,showOnly:{type:Boolean,default:!1}},data:function(){return{pointList:["lt","rt","lb","rb","l","r","t","b"],directionKey:{t:"n",b:"s",l:"w",r:"e"}}},created:function(){},mounted:function(){},methods:{getPointStyle:function(t){var e=this;if(!this.showOnly){var n=this.defaultStyle,a=n.height,i=n.width,o=/t/.test(t),r=/b/.test(t),s=/l/.test(t),l=/r/.test(t),u=0,c=0;return 2===t.length?(u=s?0:i,c=o?0:a):((o||r)&&(u=i/2-("t"===t||"b"===t?5:0),c=o?0:a),(s||l)&&(u=s?0:i,c=a/2-("l"===t||"r"===t?5:0))),{marginLeft:s||l?"-5px":0,marginTop:o||r?"-5px":0,left:"".concat(u,"px"),top:"".concat(c,"px"),cursor:t.split("").reverse().map(function(t){return e.directionKey[t]}).join("")+"-resize"}}},handleTopWrapperClick:function(t){t.stopPropagation(),t.preventDefault()},handleMouseDownOnElement:function(t){var e=this;if(!this.showOnly){this.$emit("handleElementClick",this.uuid);var n,i=a({},this.defaultStyle),o=t.clientY,r=t.clientX,s=i.top,l=i.left;n=(new Date).getTime();var u=function(t){t.stopPropagation(),t.preventDefault();var n=t.clientX,a=t.clientY;i.top=a-o+s,i.left=n-r+l,e.$emit("resize",i)};return document.addEventListener("mousemove",u,!0),document.addEventListener("mouseup",function t(){(new Date).getTime()-n>200&&e.$emit("resize"),document.removeEventListener("mousemove",u,!0),document.removeEventListener("mouseup",t,!0)},!0),!0}},handleMouseDownOnPoint:function(t){var e=this;if(!this.showOnly){var n=event;this.$emit("handleElementClick",this.uuid),n.stopPropagation(),n.preventDefault();var i=a({},this.defaultStyle),o=i.height,r=i.width,s=i.top,l=i.left,u=n.clientX,c=n.clientY,d=function(n){var a=n.clientX,d=n.clientY-c,m=a-u,p=/t/.test(t),h=/b/.test(t),f=/l/.test(t),g=/r/.test(t),b=+o+(p?-d:h?d:0),v=+r+(f?-m:g?m:0);i.height=b>0?b:0,i.width=v>0?v:0,i.left=+l+(f?m:0),i.top=+s+(p?d:0),e.$emit("resize",i)};document.addEventListener("mousemove",d),document.addEventListener("mouseup",function t(){e.$emit("resize"),document.removeEventListener("mousemove",d),document.removeEventListener("mouseup",t)})}},escUserSelectComponents:function(){this.showOnly||this.active&&this.$emit("reset-active",{uuid:this.uuid,type:this.data.type})},deleteUserSelectComponents:function(){this.showOnly||this.active&&this.$emit("delete-active",this.uuid)}}},r=(n("uVyu"),n("KHd+")),s=Object(r.a)(o,function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"components-edit-shape",class:{active:this.active},attrs:{tabindex:"0"},on:{click:t.handleTopWrapperClick,mousedown:t.handleMouseDownOnElement,keyup:[function(e){return"button"in e||!t._k(e.keyCode,"esc",27,e.key,["Esc","Escape"])?t.escUserSelectComponents(e):null},function(e){return"button"in e||46===e.keyCode?t.deleteUserSelectComponents(e):null}]}},["custom"!==t.data.type?t._l(t.active?t.pointList:[],function(e){return n("div",{key:e,staticClass:"edit-shape-point",style:t.getPointStyle(e),on:{mousedown:function(n){t.handleMouseDownOnPoint(e)}}})}):t._e(),t._v(" "),t._t("default")],2)},[],!1,null,"7e868dae",null);s.options.__file="editShape.vue";e.a=s.exports},OlIr:function(t,e,n){"use strict";var a=n("eLDl");n.n(a).a},"W2P+":function(t,e,n){},WIyV:function(t,e,n){"use strict";n("91GP"),n("dRSK"),n("rGqo"),n("INYr"),n("xfY5");var a=n("8WZi"),i=n("z0WU"),o=n("DKCI"),r=n("50Ol"),s=(n("F9dT"),n("Yfch"),n("YP4+")),l=n("WwWg"),u=n("AZ8z"),c=n("mwzG"),d={name:"single-table",mixins:[a.a],provide:function(){return{rootVm:this}},props:{varList:{type:Array,default:function(){return[]}},isFixed:{type:Number,default:1},isSortable:{type:Boolean,default:!1},useDefaultBtn:{type:Boolean,default:!1},rowKey:{type:String,default:"id"}},data:function(){return{componentName:"singleTable",data:null,fixedList:[],scrollTimer:"",checkedViewHeight:0,pageId:"",initLoading:!0,headerWidthList:[],headerWidthTimerList:[],listLength:-1,selectOptionList:[],selectLoading:!1,tempVarList:[],guid:"",pageNo:1,defaultOperation:{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",method:this.defaultDeleteRow}]},constantWidth:s.a.tableComponentWidth,autoWidthTimer:{},autoWidthList:[],setScrollWidthTimer:-2,autoWidthSwitch:!1,autoWidths:[],columnWidth:{},isLoading:!0,fileList:[],removalVarListTimer:null}},components:{tableFilter:o.a,customSummaryOption:r.a},directives:{"auto-width":{inserted:function(t,e,n){var a=n.context,i=e.value.component?e.value.component.length:0;i>1&&t.clientHeight>60&&a.$set(a.columnWidth,e.value.prop,60*Math.ceil(i/2)+25+"px")}},"merga-width":{bind:function(t,e,n){!n.context.autoWidthTimer[e.value.id]&&(n.context.autoWidthTimer[e.value.id]=-1)},inserted:function(t,e,n){!n.context.autoWidthList.length&&(n.context.autoWidthList=n.context.setTitleList.map(function(t){return[]})),n.context.$nextTick(function(a){-1===n.context.autoWidthTimer[e.value.id]&&(n.context.autoWidthTimer[e.value.id]=setTimeout(function(a){var i=t.offsetWidth,o=e.value,r=n.context.autoWidthList;if(r[o.parentLayer].length)if(r[o.parentLayer][o.selfLayer]>-1){var s=r[o.parentLayer][o.selfLayer];r[o.parentLayer].splice(o.selfLayer,1,i+s)}else r[o.parentLayer][o.selfLayer]=i;else{var l=[];l[o.selfLayer]=i,r.splice(o.parentLayer,1,l)}},20))})}}},computed:{setColumnGlobalStyle:function(){return this.columnGlobalStyle},setVarList:function(){return this.varList.concat([])},removalVarList:function(){return this.removalVarLists(this.setVarList)},setInitLoading:function(){return this.mergeTitle.length?this.initLoading||this.isLoading:this.initLoading},setTableLoading:function(){return this.showTableSet?this.showTableSet&&this.setInitLoading:this.setInitLoading},tableData:function(){return this.$store.getters[this.guid+"/tableData"]||{}},resetPageDataHeight:function(){var t=0;return"boolean"==typeof this.hidePages?!this.hidePages&&this.hasPageData&&(t=this.setSmallPageHeight):void 0===this.hidePages&&(t=this.setSmallPageHeight),t},resetHeight:function(){return this.checkedViewHeight+this.customSummaryOptionHeight+this.resetPageDataHeight},tempCustomColumn:function(){return this.customColumn.concat([])},setCustomColumn:function(){if(this.useDefaultBtn){var t=this.tempCustomColumn.findIndex(function(t){return"last"===t.columnIndex});return t>-1?this.tempCustomColumn.splice(t,1,this.defaultOperation):this.tempCustomColumn.push(this.defaultOperation),this.tempCustomColumn}return this.tempCustomColumn}},created:function(){var t=this;this.guid=Object(i.a)(),Object(l.c)(this),this.setApiObj.apiName&&("0"===this.userInfo.userId?setTimeout(function(){t.data=c.a,t.data.result.varList&&t.data.result.varList.length>0&&t.data.result.varList.forEach(function(t){t.rowState="1"}),t.$store.commit(t.guid+"/SET_TABLEDATA",{res:t.data,vm:t}),t.pageId=t.$storage.get("menuId"),t.setDragTable&&t.setSort(),t.$store.commit(t.guid+"/SET_TABLERULELIST",{cb:t.tableRuleForm,ruleId:"root",vm:t}),t.initLoading=!1},1e3):this.httpRequests())},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},beforeDestroy:function(){!this.layer&&Object(l.g)(this.$store,this.guid)},updated:function(){},watch:{"tableData.tableData":function(){this.setFixed(),this.setTableCheckBoxDisplay()},"setApiObj.params":function(){this.httpRequests()},autoWidthList:{deep:!0,handler:function(t,e){var n=this;clearTimeout(this.setScrollWidthTimer),this.setScrollWidthTimer=setTimeout(function(e){n.autoWidths=t.map(function(t){var e=Math.max.apply(null,t);return e>-9999&&e<9999?e+20:0});var a=0;n.autoWidths.forEach(function(t){a+=t}),n.setShowCheckBox&&(a+=55),n.setShowIndex&&(a+=50),n.setDragTable&&(a+=50);var i=n.$el.clientWidth>a?(n.$el.clientWidth-a)/n.autoWidthList.length:0;n.autoWidths=n.autoWidths.map(function(t){return t?t+i:null}),n.setFixed(),n.autoWidthSwitch=!0,n.isLoading=!1},100)}},removalVarList:function(){var t=this;clearInterval(this.removalVarListTimer),this.removalVarListTimer=setInterval(function(e){t.tableData.titleList&&t.tableData.titleList.length&&(clearInterval(t.removalVarListTimer),t.pushData(t.removalVarList))},200)},initData:function(){var t=this;this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:null,ruleId:"root"});var e=JSON.parse(JSON.stringify(this.initData));this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setDragTable&&this.setSort(),this.pageNo=this.tableData.pageData&&this.tableData.pageData.current||1,this.initLoading=!1,this.$nextTick(function(e){t.scrollTable()}),this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:"root",vm:this})}},methods:{defaultDeleteRow:function(t,e,n){this.deleteData(t)},removalVarLists:function(t){var e=this;if("transferTable"===this.useScenarios)return Object(u.a)(t);var n=[];return t.forEach(function(t,a){!t._internalId&&(t._internalId=Object(i.p)());var o=JSON.parse(JSON.stringify(t));!e.tempVarList.find(function(t){return t._internalId===o._internalId})&&n.push(o)}),n.length&&(this.tempVarList=this.tempVarList.concat(n)),n},httpRequests:function(t){var e=this;this.initLoading=!0,this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:null,ruleId:"root"}),this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:t||1})).then(function(n){e.data=n,e.pageNo=n.result.pageData&&n.result.pageData.current||1,e.data.result.varList&&e.data.result.varList.length&&e.data.result.varList.forEach(function(t){t.rowState="1",t._internalId=Object(i.p)()}),e.$store.commit(e.guid+"/SET_TABLEDATA",{res:e.data,vm:e}),e.pageId=e.$storage.get("menuId"),e.setDragTable&&e.setSort(),e.initLoading=!1,t&&e.$nextTick(function(t){e.scrollTable()}),e.$store.commit(e.guid+"/SET_TABLERULELIST",{cb:e.tableRuleForm,ruleId:"root",vm:e})}).catch(function(t){console.log(t),e.initLoading=!1})},setStyle:function(t){},selectItem:function(t,e){this.$emit("databridge",t,e),this.isSingle&&(t.length?(this.tableData[this.dataName].forEach(function(t){t.rowState="0"}),t[0].rowState="1"):this.tableData[this.dataName].forEach(function(t){t.rowState="1"}))},selectAllItem:function(t){if(this.isSingle){if(t.length)for(var e=t.length-1;e>=0;e--)t.splice(e,1)}else this.$emit("databridge",t)},handleCurrentChange:function(t){t!==this.pageNo&&(this.setApiObj.apiName?this.httpRequests(t)&&(this.tempVarList=[]):this.$emit("current-change",t))},updateTable:function(){this.setApiObj&&this.setApiObj.apiName&&this.httpRequests()},updateData:function(){this.setApiObj&&this.setApiObj.apiName&&this.httpRequests()}}},m=(n("Cg3q"),n("KHd+")),p=Object(m.a)(d,function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{directives:[{name:"loading",rawName:"v-loading",value:!t.disableLoading&&t.setTableLoading,expression:"!disableLoading && setTableLoading"}],ref:"tableWrapper",staticClass:"columnBaseTable myCoustomTable resetCoustomTableStyle",staticStyle:{height:"100%",position:"relative"}},[t.showTableSet&&"outside"===t.tableSetMode?n("table-filter",{attrs:{headerList:t.setColConfigs,tableSwitchState:t.setTableSwitch,storeId:t.pageId,componentId:t.componentId},on:{"checked-list":t.checkedList,"checked-height":t.checkedHeight}}):t._e(),t._v(" "),n("div",{style:{height:t.setTableHeight}},[n("el-form",{ref:"ruleForm",style:{height:"100%"},attrs:{model:t.ruleForm,"status-icon":""},nativeOn:{submit:function(t){t.preventDefault()}}},[n("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:t.tableData.tableData,stripe:"",border:"","current-row-key":t.rowKey,"tooltip-effect":"dark",height:"100%",fit:"","header-cell-class-name":t.setStyle,"row-key":"_internalId","default-sort":t.setSortableConfig["default-sort"],"show-summary":t.setSysSummary,"cell-style":t.setCellStyle,"header-cell-style":t.setHeaderCellStyle},on:{select:t.selectItem,"select-all":t.selectAllItem,"selection-change":t.selectionChange,"sort-change":t.sortChange,"row-click":t.rowClick,"row-dblclick":t.rowDblclick}},[t.setShowCheckBox?[n("el-table-column",{attrs:{type:"selection",fixed:t.fixedState,selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.setShowIndex?[n("el-table-column",{attrs:{type:"index",index:t.indexMethod,fixed:t.fixedState,label:"序号",width:"50",align:"center"}})]:t._e(),t._v(" "),t._l(t.setTitleList,function(e,a){return[e.slot?n("tempalte",[t._t(e.slot,null,{fixed:t.setFixedList[a]})],2):Array.isArray(e.component)?[n("el-table-column",t._b({key:a,attrs:{"show-overflow-tooltip":"",fixed:t.setFixedList[a],"min-width":e.width||t.setColumnWidth[e.prop],align:"center"},scopedSlots:t._u([{key:"header",fn:function(i){return[n("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:a,isComponent:!0,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}],staticStyle:{display:"inline-flex","white-space":"nowrap"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(a){return[n("div",{directives:[{name:"auto-width",rawName:"v-auto-width",value:e,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":t.setColumnWidth[e.prop]?"space-between":"center"}},t._l(e.component,function(e,i){return void 0!==e.editBtns_isShow&&!e.editBtns_isShow||!e.rowState||t.setButtonState(a.$index,a.row,e)?n("el-button",{key:i,style:t.setButtonStyle||{height:"24px",width:"46px",padding:0,margin:0,"font-size":"12px","max-width":"46px"},attrs:{type:"text"},on:{click:function(t){e.method(a.row,a.$index,a)}}},[t._v(t._s(e.name))]):t._e()}),1)]}}])},"el-table-column",e,!1))]:"object"!=typeof e.component||Array.isArray(e.component)?[e._isShow||"outside"!==t.tableSetMode?n("el-table-column",{key:a,attrs:{"show-overflow-tooltip":"",prop:e.prop,width:e._isShow?"":t.setTableColumnState?"20":"","min-width":e._isShow?e.width||t.constantWidth[e.componentName]||t.autoWidths[a]||null:"",sortable:void 0===e.sortable?t.isSortable:e.sortable,fixed:t.setFixedList[a],align:"center"},scopedSlots:t._u([{key:"header",fn:function(i){return[n("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:a,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"},{name:"custom-table-switch",rawName:"v-custom-table-switch",value:{config:e,index:a,showSwitch:t.setTableColumnState},expression:"{config:colConfig,index:infoIndex,showSwitch:setTableColumnState}"}],style:{display:e._isShow?"inline-flex":"none","white-space":"nowrap"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(i){return[n("core-index",{directives:[{name:"show",rawName:"v-show",value:!!e._isShow||"outside"===t.tableSetMode,expression:"colConfig._isShow?true:tableSetMode === 'outside'"}],attrs:{scope:i,"info-index":a,"col-config":e,runTime:"base"}})]}}])}):t._e()]:[n(e.component,{key:a,tag:"component",attrs:{"col-config":e,fixed:t.setFixedList[a]}})]]}),t._v(" "),t.setDragTable?[n("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:t._u([{key:"default",fn:function(t){return[n("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[n("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)]}}])})]:t._e()],2)],1),t._v(" "),t.setUseSummary&&t.setCustomSummary.component?[n("custom-summary-option",{attrs:{customSummary:t.setCustomSummary,tempData:t.setTempData,tableData:t.tableData.tableData},on:{"send-height":t.customSummaryHeight,"custom-summary-value":t.customSummaryValue}})]:t._e()],2),t._v(" "),!t.hidePages&&t.hasPageData?n("div",{staticStyle:{"text-align":"center"},style:{"margin-top":(t.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[n("el-pagination",{attrs:{background:!t.smallPage,small:t.smallPage,"current-page":t.tableData.pageData.current,"page-size":t.tableData.pageData.size,layout:"prev, pager, next, jumper",total:t.tableData.pageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.tableData.pageData,"current",e)}}})],1):t._e()],1)},[],!1,null,"15f01db1",null);p.options.__file="index.vue";e.a=p.exports},YhG6:function(t,e,n){},cSvC:function(t,e,n){"use strict";var a=n("W2P+");n.n(a).a},eLDl:function(t,e,n){},i6nb:function(t,e,n){"use strict";var a=n("jEHv");n.n(a).a},jEHv:function(t,e,n){},jq09:function(t,e,n){"use strict";n("rGqo"),n("yt8O"),n("RW0V"),n("Z2Ku");var a=n("z0WU"),i=n("LvDl");function o(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{},a=Object.keys(n);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(n).filter(function(t){return Object.getOwnPropertyDescriptor(n,t).enumerable}))),a.forEach(function(e){r(t,e,n[e])})}return t}function r(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}var s={elName:"",animations:[],commonStyle:{position:"absolute",width:300,height:30,top:200,left:0,rotate:0,paddingTop:0,paddingLeft:0,paddingRight:0,paddingBottom:0,marginTop:0,marginLeft:0,marginRight:0,marginBottom:0,borderWidth:0,borderColor:"",borderStyle:"solid",borderRadius:0,boxShadow:"",fontSize:16,fontWeight:500,lineHeight:1.4,letterSpacing:0,textAlign:"center",color:"#000000",backgroundColor:"",backgroundImage:"",backgroundSize:"cover",opacity:1,zIndex:1},events:[],propsValue:{},value:"",valueType:"String"},l={name:"",elements:[],commonStyle:{backgroundColor:"",backgroundImage:"",backgroundSize:"cover"},config:{}},u={name:"",title:"未命名场景",description:"我用夸克可视化编辑器做了一个超酷炫的H5，快来看看吧。",coverImage:"",auther:"",script:"",width:300,height:300,pages:[]},c=function(t){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{};return(t=Object(i.cloneDeep)(t)).uuid=Object(a.f)(),t.commonStyle=Object(i.merge)(t.commonStyle,e),t.commonStyle.top=t.commonStyle.top+10,t.commonStyle.left=t.commonStyle.left+10,t},d=function(){return o({uuid:Object(a.f)()},Object(i.cloneDeep)(l))};e.a={elementConfig:s,pageConfig:l,projectConfig:u,getElementConfig:function(t){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{},n=Object(i.cloneDeep)(t),r=n.valueType||"String",l=Object(i.cloneDeep)(s),u=o({uuid:Object(a.f)()},l,{elName:n.elName,propsValue:Object(a.h)(n.needProps||{})});return u.commonStyle=Object(i.merge)(u.commonStyle,n.defaultStyle),u.commonStyle=Object(i.merge)(u.commonStyle,e),u.value=t.defaultValue||{Sting:"",Array:[],Object:{},Boolean:!1,Number:0}[r],u.valueType=r,u.isForm=!!t.isForm,u},getPageConfig:d,getProjectConfig:function(){var t=Object(i.cloneDeep)(u),e=d();return t.pages.push(o({},e)),o({},t)},copyPage:function(t){var e=Object(i.cloneDeep)(t);return e.uuid=Object(a.f)(),e.elements=e.elements.map(function(t){return c(t)}),e},copyElement:c,getCommonStyle:function(t,e,n,i){var o=["width","left"],r=["height","top"],s=["fontSize"],l=Object(a.h)(t),u={};for(var c in l)o.includes(c)?u[c]="".concat(l[c]/e*100,"%"):r.includes(c)?u[c]="".concat(l[c]/n*100,"%"):s.includes(c)?u[c]="".concat(l[c]*((i||e)/e),"px"):u[c]=l[c];return u.transform="rotate(".concat(u.rotate,"deg)"),u.backgroundImage=u.backgroundImage?"url(".concat(u.backgroundImage,")"):"",u}}},mdfD:function(t,e,n){},o3SY:function(t,e,n){"use strict";var a=n("+Jge");n.n(a).a},oeZg:function(t,e,n){},ozwT:function(t,e,n){"use strict";n.r(e);n("rGqo"),n("yt8O"),n("RW0V");var a=n("e+jF"),i=n("MngD"),o=n("jq09"),r=n("z1Gy");function s(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}var l={name:"visualization-preview",components:function(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{},a=Object.keys(n);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(n).filter(function(t){return Object.getOwnPropertyDescriptor(n,t).enumerable}))),a.forEach(function(e){s(t,e,n[e])})}return t}({GridLayout:a.GridLayout,GridItem:a.GridItem,editShape:i.a},r.a),data:function(){return{layoutBoxHeight:0,visualizationConfig:null,getCommonStyle:o.a.getCommonStyle}},computed:{tempLayout:function(){return this.visualizationConfig?this.visualizationConfig.layout:[]},setRowHeight:function(){return this.layoutBoxHeight/24}},methods:{goHome:function(){this.$router.push({path:"/"})}},mounted:function(){var t=this;this.layoutBoxHeight=this.$el.clientHeight,this.$nextTick(function(e){t.visualizationConfig=t.$storage.get("visualizationConfig")})}},u=(n("qnkF"),n("KHd+")),c=Object(u.a)(l,function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"visualizationPreview"},[t.visualizationConfig?n("div",{staticClass:"visualizationPreviewView"},[n("grid-layout",{attrs:{layout:t.tempLayout,"col-num":24,"row-height":t.setRowHeight,"max-rows":24,"vertical-compact":!0,margin:[0,0],"use-css-transforms":!0},on:{"update:layout":function(e){t.tempLayout=e}}},t._l(t.tempLayout,function(e){return n("grid-item",{key:e.i,staticStyle:{"background-color":"rgb(10,24,40)"},attrs:{x:e.x,y:e.y,w:e.w,h:e.h,i:e.i,"is-resizable":!1,"is-draggable":!1}},[n("div",{staticStyle:{position:"relative",height:"100%"}},t._l(e.userComponents||[],function(e){return n("edit-shape",{key:e.uuid,style:t.getCommonStyle(e.defaultStyle),attrs:{uuid:e.uuid,defaultStyle:e.defaultStyle,active:!1,data:e}},[n(e.elName,t._b({tag:"component",staticClass:"element-on-edit-pane",attrs:{id:e.uuid}},"component",{value:e.value,item:e},!1))],1)}),1)])}),1)],1):n("div",{staticStyle:{height:"100%","text-align":"center","padding-top":"200px","font-size":"30px"}},[n("div",[t._v("没有可用的配置")]),t._v(" "),n("div",[n("el-button",{on:{click:t.goHome}},[t._v("返回首页")])],1)])])},[],!1,null,"11c8f24b",null);c.options.__file="visualizationPreview.vue";e.default=c.exports},qnkF:function(t,e,n){"use strict";var a=n("9CiS");n.n(a).a},r6V5:function(t,e,n){"use strict";var a=n("zY7s");n.n(a).a},uVyu:function(t,e,n){"use strict";var a=n("EiiD");n.n(a).a},"y+pX":function(t,e,n){"use strict";var a=n("YhG6");n.n(a).a},z1Gy:function(t,e,n){"use strict";n("rGqo"),n("f3/d");var a={name:"QkImage",props:{imageSrc:{type:String,default:"http://seopic.699pic.com/photo/50051/4111.jpg_wh1200.jpg"},id:{type:String,default:""}},methods:{}},i=(n("B7Ix"),n("KHd+")),o=Object(i.a)(a,function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"qk-image"},[e("img",{attrs:{id:this.id,src:this.imageSrc}})])},[],!1,null,"3b18bde8",null);o.options.__file="index.vue";var r=o.exports;r.install=function(t){t.component(r.name,r)};var s=r,l=(n("KKXr"),n("TB3a")),u={name:"QkDate",props:{value:{type:String,default:""},item:{type:Object,default:function(){return null}}},data:function(){return{dateValue:"",dateTimer:""}},created:function(){var t=this;this.dateValue=l.a.formatDate().split(" ")[0];var e=864e5+60*(new Date).getTimezoneOffset()*1e3-((new Date).getTime()-new Date(this.dateValue).getTime());this.dateTimer=setTimeout(function(e){t.dateValue=l.a.formatDate().split(" ")[0]},e)},beforeDestroy:function(){clearTimeout(this.dateTimer)}},c=(n("cSvC"),Object(i.a)(u,function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"qk-date",domProps:{textContent:this._s(this.dateValue)}})},[],!1,null,"0a731891",null));c.options.__file="index.vue";var d=c.exports;d.install=function(t){t.component(d.name,d)};var m=d,p={name:"QkDatetime",props:{value:{type:String,default:""},item:{type:Object,default:function(){return null}}},data:function(){return{dateValue:"",dateTimer:""}},created:function(){var t=this;this.dateValue=l.a.formatDate(),this.dateTimer=setInterval(function(e){t.dateValue=l.a.formatDate()},1e3)},beforeDestroy:function(){clearInterval(this.dateTimer)}},h=(n("y+pX"),Object(i.a)(p,function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"qk-datetime",domProps:{textContent:this._s(this.dateValue)}})},[],!1,null,"8e1adfbc",null));h.options.__file="index.vue";var f=h.exports;f.install=function(t){t.component(f.name,f)};var g=f,b={name:"QkTime",props:{value:{type:String,default:""},item:{type:Object,default:function(){return null}}},data:function(){return{timeValue:"",dateTimer:""}},created:function(){var t=this;this.timeValue=l.a.formatDate().split(" ")[1],this.dateTimer=setInterval(function(e){t.timeValue=l.a.formatDate().split(" ")[1]},1e3)},beforeDestroy:function(){clearInterval(this.dateTimer)}},v=(n("i6nb"),Object(i.a)(b,function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"qk-time",domProps:{textContent:this._s(this.timeValue)}})},[],!1,null,"726f3bfc",null));v.options.__file="index.vue";var y=v.exports;y.install=function(t){t.component(y.name,y)};var w=y,S={name:"QkInput",props:{value:{type:String,default:""},readonly:{type:Boolean,default:!1},item:{type:Object,default:function(){return null}}},data:function(){return{userValue:this.value}},watch:{userValue:function(){this.$emit("value-bus",{value:this.userValue,uuid:this.item.uuid})}}},x=(n("r6V5"),Object(i.a)(S,function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"qk-input"},[n("input",{directives:[{name:"model",rawName:"v-model",value:t.userValue,expression:"userValue"}],staticClass:"qk-input-item",attrs:{placeholder:t.readonly?"":"请输入",type:"text",readonly:t.readonly},domProps:{value:t.userValue},on:{input:function(e){e.target.composing||(t.userValue=e.target.value)}}})])},[],!1,null,"32c6f443",null));x.options.__file="index.vue";var C=x.exports;C.install=function(t){t.component(C.name,C)};var T=C,D={name:"QkTextarea",props:{value:{require:!1},readonly:{type:Boolean,default:!1},item:{type:Object,default:function(){return null}}},data:function(){return{tempValue:this.value}},watch:{tempValue:function(){this.$emit("value-bus",{value:this.tempValue,uuid:this.item.uuid})}}},_=(n("o3SY"),Object(i.a)(D,function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"qk-textarea"},[n("textarea",{directives:[{name:"model",rawName:"v-model",value:t.tempValue,expression:"tempValue"}],staticClass:"qk-textarea-item",style:{width:t.item.defaultStyle.width+"px",height:t.item.defaultStyle.height+"px"},attrs:{placeholder:t.readonly?"":"请输入",readonly:t.readonly},domProps:{value:t.tempValue},on:{input:function(e){e.target.composing||(t.tempValue=e.target.value)}}})])},[],!1,null,"1400af3b",null));_.options.__file="index.vue";var O=_.exports;O.install=function(t){t.component(O.name,O)};var L=O,I={code:0,msg:"执行成功!",result:{hideTitles:["id","productGenre","productUnit","warehouseId","state","cuser","cdate","uuser","udate","remark","isdisable","qrcode","businessId"],pageData:{},titles:[{progress:"进度"},{warehouseOutCode:"出库单编码"},{productCode:"货品编码"},{productName:"货品名称"},{productSpec:" 规格/型号"},{productGenreName:"货品属性"},{productUnitName:"计量单位"},{count:"出库数量"},{id:"id"},{productGenre:"货品属性ID"},{productUnit:"计量单位ID"},{parentId:"出库单ID"},{warehouseId:" (推荐)货位ID"},{productId:"产品ID"},{code:"批次号"},{executeCount:"已出库数量"},{state:"状态"},{cuser:"创建用户id"},{cdate:"创建时间"},{uuser:"修改用户id"},{udate:"修改时间"},{remark:"备注"},{isdisable:"是否启用"},{qrcode:"二维码"},{businessId:"业务id"}],varList:[{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:(new Date).getTime(),isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"55",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000007"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:(new Date).getTime(),isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000008"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:(new Date).getTime(),isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"}]}},k={name:"QkTable",components:{customBaseTable:n("WIyV").a},props:{value:{type:String,default:""},readonly:{type:Boolean,default:!1},item:{type:Object,default:function(){return null}}},data:function(){return{tableData:null,customColumn:[{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{lessThan:["tempData@count",!1]},{lessThan:["tempData@count(-)sibling@count",!0]}],message:["须小于自定义的count","出库数量总和须小于等于自定义count"],icon:"search"}},{columnIndex:"udate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy年MM月dd日",valueFormat:"yyyy-MM-dd",greaterThan:["self@cdate",!0],lessThan:["2019-7-31",!1]}},{columnIndex:"productGenreName",componentName:"cascader",_cellConfig:{asyn:{apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},rules:[{required:!0}],outputData:!0,formulaName:"_formula"}},{columnIndex:"progress",componentName:"dynaContent",_cellConfig:{states:"self@count",contentConfigs:[{style:{color:"rgb(228,13,8)"}},{innerText:"盘平"},{componentName:"tag",_cellConfig:{success:{state:"3",text:"审核通过"},info:{state:"-1",text:"已过期"},warning:{state:"1",text:"已退回"},danger:{state:"2",text:"已拒绝"},default:{state:"0",text:"审核中"}}}],compute:"self@count(*)self@productName",hideTitle:!0,titleStyle:{}}},{columnIndex:"productName",componentName:"input",width:300,_cellConfig:{rules:[{regexp:/\d/g}],message:["必须为数字"]}},{columnIndex:"warehouseOutCode",componentName:"steps",_cellConfig:{titleStyle:{"font-weight":600},componentConfig:{titleList:["待审核","待出库","待发货","已发货","已完成"]}}},{columnIndex:"productCode",componentName:"progress",_cellConfig:{titleStyle:{"font-weight":600,color:"#FF9900"},componentConfig:{"text-inside":!0,"stroke-width":18,color:"#009933","show-text":!0,baseValue:"count",showInitValue:!1,width:200}}},{columnIndex:"cdate",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"审核通过"},info:{state:"-1",text:"已过期"},warning:{state:"1",text:"已退回"},danger:{state:"2",text:"已拒绝"},default:{state:"0",text:"审核中"}}},{columnIndex:"productSpec",_cellConfig:{bodyStyle:{color:"#199ED4","font-weight":600},events:{type:"navigation",path:"encapsulation/treeFormTable"},hideTitle:!0}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"新增",nameEn:"add",editBtns_isShow:!0,icon:"add",method:this.addChild},{name:"删除",nameEn:"delete",editBtns_isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteAllRow},{name:"删除",nameEn:"delete",editBtns_isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteAllRow},{name:"删除",nameEn:"delete",editBtns_isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteAllRow}]}],apiObj:{apiName:"listPageWarehouseOutDetailsDispatch",params:{pageNo:1,queryStr:"detail.id in ('219967d2f6704d868b11002caef9885c')"}},mergeTitle:[{index:4,alias:"合并后的列",columns:["productUnitName","warehouseOutCode","productCode"],width:450}],mergeColumn:[],mergeRow:[],keyMapping:{resultKey:{P:"productName"},variableKey:{N:"productSpec"}},varList:[],tempList:[],tempData:{count:100,defaultDate:"2019-01-21"},pushIndex:1,tempItem:null}},computed:{showIndex:function(){return!(!this.tableData||!this.item.config)&&this.item.config.showIndex},colConfigs:function(){return this.tableData?this.tableData.titleList:[]},dataList:function(){return this.tableData?this.tableData.tableData:[]},setApiObj:function(){}},watch:{},methods:{indexMethod:function(t){return t+1},rowClassName:function(t,e){console.log(t,e)},databridge:function(){}},created:function(){console.log(this.item),console.log(I)}},j=(n("GzjI"),n("OlIr"),Object(i.a)(k,function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"qk-table"},[e("custom-base-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"components_visualization_components_plugins_table_src_index0",varList:this.varList,showIndex:!1,showCheckBox:!1,customColumn:this.customColumn,apiObj:this.setApiObj,rowKey:"id"},on:{databridge:this.databridge}})],1)},[],!1,null,"3a1ac63a",null));j.options.__file="index.vue";var E=j.exports;E.install=function(t){t.component(E.name,E)};var N=E;n.d(e,"a",function(){return W});var V=[s,m,g,w,T,L,N],P=function t(e){t.installed||(t.installed=!0,V.map(function(t){return e.component(t.name,t)}))};"undefined"!=typeof window&&window.Vue&&P(window.Vue);var W={};V.forEach(function(t){W[t.name]=t})},zY7s:function(t,e,n){}}]);