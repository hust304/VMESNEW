(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-f90b","chunk-9023"],{"+0ON":function(t,e,a){"use strict";var i=a("jB0T");a.n(i).a},"3d3b":function(t,e,a){"use strict";a("rE2o"),a("ioFf"),a("KKXr"),a("91GP");var i=a("f/WR"),n=a("uTIz");a("xMja");function s(t){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{transferTable:i.a,searchBar:n.a},name:"productTableDialog",props:["initData","visible"],data:function(){return{fieldCode_default:"code,name,spec,unitName,genreName,stockCount,safetyCount,lockCount,productStockCount",isConfirm:!1,temp:{},tempLable:{},rules:{},guid:"",tempQuery:{},searchList:[{label:"货品编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"spec",configs:{},placeholder:"请输入规格型号"},{label:"货品属性",type:"select",ruleType:"string",mapKey:"genreName",configs:{clearable:!0,name:"",options:[{value:"成品",label:"成品"},{value:"原材料",label:"原材料"},{value:"辅料",label:"辅料"},{value:"半成品",label:"半成品"},{value:"备件",label:"备件"},{value:"办公用品",label:"办公用品"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!0,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},pageData:null,pageNo:1,btnList:[{name:"确定",isShow:!0,state:!0,method:this.toAddWarehouseIn},{name:"取消",state:!1,method:this.closeWin,isShow:!0}],apiData:{apiName:"listPageProducts",params:{}},tableSelectList:[],stateBtnData:{title:"是否低于安全库存",keyName:"lowStock"},tableConfigs:{showIndex:!0},tempList:[]}},created:function(){var t=this.fieldCode_default;null!=this.initData.fieldCode&&this.initData.fieldCode.trim().length>0&&(t=this.initData.fieldCode.trim());var e="";null!=this.initData.queryStr&&(e=this.initData.queryStr);var a="";a=null!=this.initData.orderStr?this.initData.orderStr:"prod.stock_count desc";var i="";if(null!=this.initData.data&&this.initData.data.length>0)for(var n=0;n<this.initData.data.length;n++){var s=this.initData.data[n];null!=s.productId&&s.productId.trim().length>0&&(i=i+s.productId+",")}var o=!0;null!=this.initData.isNeedRepeat&&(o=this.initData.isNeedRepeat),o||null!=i&&i.trim().length>0&&(i=i.substring(0,i.lastIndexOf(",")),e="prod.id not in ("+(i=this.findQueryProductIds(i))+")");var l="false";null!=this.initData.isNeedCustomerPrice&&1==this.initData.isNeedCustomerPrice&&(l="true");var r="";null!=this.initData.customerId&&this.initData.customerId.trim().length>0&&(r=this.initData.customerId.trim());var c="false";null!=this.initData.isNeedWarehouseProduct&&(c=this.initData.isNeedWarehouseProduct);var u="";null!=this.initData.warehouseId&&(u=this.initData.warehouseId);var d="";null!=this.initData.genreNames&&(d=this.initData.genreNames);var h="";null!=this.initData.stockCountQuery&&(h=this.initData.stockCountQuery),this.apiData.params={fieldCode:t,queryStr:e,orderStr:a,genreNames:d,isNeedWarehouseProduct:c,warehouseId:u,isNeedCustomerPrice:l,customerId:r,stockCountQuery:h,isdisable:"1"};var m=this.initData.querySpare;"isNeedSpare"==m?this.apiData.params.isNeedGenreSpare="true":null!=m&&0!=m.trim().length&&"isNotNeedSpare"!=m||(this.apiData.params.isNeedNotInGenreSpare="true")},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{tableHeight:function(){},dialogWidth:function(){if(this.initData.width){var t=s(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{sendGuid:function(t){this.guid=t},searchMap:function(t){this.apiData.params=Object.assign({},this.apiData.params,t)},dialogOpen:function(){},closeWin:function(){this.isVisible=!1},dialogClose:function(t){this.$emit("close-dialog",t||{isConfirm:this.isConfirm,selectList:this.tempList})},toAddWarehouseIn:function(){this.isConfirm=!0,this.isVisible=!1},resetQuery:function(){this.$refs.trabsferTables.clearTableSelected()},tableSelected:function(t){this.tempList=t},findQueryProductIds:function(t){var e="";if(null==t||0==t.trim().length)return e;var a=t.split(",");if(null!=a&&a.length>0)for(var i=a.length,n=0;n<a.length;n++){var s="'"+a[n]+"'";n<i-1?e=e+s+",":n==i-1&&(e+=s)}return e},closeDialog:function(t){this.showDialog=!1}}},l=a("KHd+"),r=Object(l.a)(o,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{width:"100%"}},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{style:{"margin-top":t.searchList.length?"10px":"0"}},[a("transfer-table",{ref:"trabsferTables",attrs:{tableConfigs:t.tableConfigs,btnList:t.btnList,stateBtn:t.stateBtnData,apiData:t.apiData},on:{"table-selected":t.tableSelected}})],1)],1)],1)},[],!1,null,null,null);r.options.__file="productTableDialog.vue";e.a=r.exports},AZ8z:function(t,e,a){"use strict";a.d(e,"a",function(){return o});a("rE2o"),a("ioFf"),a("dRSK"),a("Oyvg"),a("a1Th");function i(t){return(i="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}function n(t){return Object.prototype.toString.call(t).slice(8,-1)}function s(t){var e="";t.global&&(e+="g"),t.ignoreCase&&(e+="i"),t.multiline&&(e+="m");var a=new RegExp(t,e);return a.lastIndex=t.lastIndex,a}function o(t){if(null==t||"object"!==i(t))return t;var e;switch(n(t)){case"RegExp":return s(t);case"Date":return new Date(t.getTime());case"Function":return t;case"Array":e=[];break;default:e=Object.create(Object.getPrototypeOf(t))}for(var a=[],o=[{parent:e,key:void 0,data:t}],l=function(){var t=o.pop(),e=t.parent,l=t.key,r=t.data,c=e;if(void 0!==l)switch(n(r)){case"RegExp":return e[l]=s(r),"continue";case"Date":return e[l]=new Date(r.getTime()),"continue";case"Function":return e[l]=r,"continue";case"Array":c=e[l]=[];break;default:var u=Object.getPrototypeOf(r);c=e[l]=Object.create(u)}var d=a.find(function(t){return t.source===r});if(d)return e[l]=d.target,"continue";for(var h in a.push({source:r,target:c}),r)r.hasOwnProperty(h)&&(null==r[h]||"object"!==i(r[h])?c[h]=r[h]:o.push({parent:c,key:h,data:r[h]}))};o.length;)l();return e}},BOGe:function(t,e,a){"use strict";var i=a("YqjF");a.n(i).a},CU5c:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf"),a("f3/d");var i=a("3d3b"),n=a("WIyV"),s=a("cTe8");a("QD6Y"),a("z0WU");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{productTableDialog:i.a,customBaseTable:n.a},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{remark:"",makeId:"",makeName:"",dtlJsonStr:"",isAutoCommit:""},tempLable:{},tempQuery:{},tableData:[],tableList:[],rowData:{},selectList:null,configs:{topBarBtnList:[{name:"选择货品",nameEn:"add",isShow:!0,icon:"add",method:this.addProduct}]},apiObj:{apiName:"listPagePurchasePlanDetails",params:{pageNo:1,parentId:"null",fieldCode:"productCode,productName,spec,genre,unit,count,reason,edate,remark"}},customColumn:[{columnIndex:"spec",width:"85",_cellConfig:{hideTitle:!0}},{columnIndex:"count",width:"120",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"reason",componentName:"select",_cellConfig:{asyn:{apiName:"getDictionarys",params:{dictionaryKey:"purchaseReason",isglobal:"1"}},rules:[{required:!0}],outputData:!0}},{columnIndex:"edate",width:"180",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy-MM-dd",valueFormat:"yyyy-MM-dd",greaterThan:["tempData@minDate",!0]}},{columnIndex:"remark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{minDate:new Date},MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择制单人",tableUrl:"/system/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}}}},created:function(){var t=this.$storage.get("userInfo");this.temp.makeId=t.userId,this.temp.makeName=t.userName,this.apiObj.params.parentId="null"},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(t){Array.isArray(t)?(this.tableList=[],this.tableList=t):(this.rowData=null,null!=t.row&&(this.rowData=t.row))},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},addProduct:function(){this.dialogData.data=this.tableList,this.dialogData.querySpare="isSpareAll",this.dialogData.title="选择货品",this.openDialogName="productTableDialog",this.showDialog=!0,this.inLinVisible=!0},save:function(){var t=this;this.tableList=[],this.$refs.planAddDialog.getData(),setTimeout(function(){t.savePlan()},1e3)},savePlan:function(){var t=this,e="";if(null!=this.tableList&&0!=this.tableList.length){for(var a=[],i=0;i<this.tableList.length;i++){var n=this.tableList[i],o={productId:"",count:"",reason:"",edate:"",remark:"",id:""};o.productId=n.productId,o.count=n.count,o.remark=n.remark,o.edate=n.edate,o.reason=n.reason.item.id,o.id=n.id,a.push(o)}e=JSON.stringify(a),this.temp.dtlJsonStr=e,this.$refs.submitForm.validate(function(e){e&&t.$confirm("添加计划后，是否将该计划提交？","提示",{distinguishCancelAndClose:!0,confirmButtonText:"是",cancelButtonText:"否",type:"warning"}).then(function(){t.dialogLoading=!0,t.temp.isAutoCommit="true",Object(s.addPurchasePlan)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1})}).catch(function(e){"cancel"==e&&(t.dialogLoading=!0,t.temp.isAutoCommit="false",Object(s.addPurchasePlan)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1}))})})}},makeSelect:function(t){t[0]&&(this.temp.makeId=t[0].id,this.temp.makeName=t[0].name)},closeDialog:function(t){this.showDialog=!1;var e=!1;null!=t.isConfirm&&(e=t.isConfirm);var a=[];null!=t.selectList&&(a=t.selectList),this.tableSelected(e,a)},tableSelected:function(t,e){if(t&&null!=e&&e.length>0)for(var a=0;a<e.length;a++){var i=e[a],n={productId:"",productCode:"",productName:"",spec:"",genre:"",unit:"",count:"",reason:"",edate:"",remark:"",id:""};n.productId=i.id.trim(),null!=i.code&&i.code.trim().length>0&&(n.productCode=i.code.trim()),null!=i.name&&i.name.trim().length>0&&(n.productName=i.name.trim()),null!=i.spec&&i.spec.trim().length>0&&(n.spec=i.spec.trim()),null!=i.genreName&&i.genreName.trim().length>0&&(n.genre=i.genreName.trim()),null!=i.unitName&&i.unitName.trim().length>0&&(n.unit=i.unitName.trim()),n.id=i.id.trim()||a,this.tableData.push(n)}}},watch:{}},r=(a("+0ON"),a("JOdR"),a("KHd+")),c=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1250px",layoutType:3},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog,"table-selected":t.tableSelected}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{"padding-top":"10px"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:t.MakeDialog.dialog},on:{callback:t.makeSelect},model:{value:t.temp.makeName,callback:function(e){t.$set(t.temp,"makeName",e)},expression:"temp.makeName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[a("el-input",{staticStyle:{width:"200px"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1)],1),t._v(" "),t.configs.topBarBtnList&&t.configs.topBarBtnList.length?a("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2):t._e(),t._v(" "),a("el-row",{staticStyle:{width:"96%","margin-left":"2%"}},[a("custom-base-table",{ref:"planAddDialog",attrs:{"data-custom-table-id":"views_purchase_planManager_dialogAdd0",isSortable:!1,varList:t.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:t.customColumn,apiObj:t.apiObj,mergeTitle:t.mergeTitle,mergeColumn:t.mergeColumn,mergeRow:t.mergeRow,tempData:t.tempData,componentId:"planAddDialog",useDefaultBtn:!0,showAll:!1,keyMapping:t.keyMapping},on:{databridge:t.databridge}})],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);c.options.__file="dialogAdd.vue";e.default=c.exports},JOdR:function(t,e,a){"use strict";var i=a("sRvh");a.n(i).a},UFNq:function(t,e,a){"use strict";var i=a("lfPC");a.n(i).a},WIyV:function(t,e,a){"use strict";a("91GP"),a("dRSK"),a("rGqo"),a("INYr"),a("xfY5");var i=a("8WZi"),n=a("z0WU"),s=a("DKCI"),o=a("50Ol"),l=(a("F9dT"),a("Yfch"),a("YP4+")),r=a("WwWg"),c=a("AZ8z"),u=a("mwzG"),d={name:"single-table",mixins:[i.a],provide:function(){return{rootVm:this}},props:{varList:{type:Array,default:function(){return[]}},isFixed:{type:Number,default:1},isSortable:{type:Boolean,default:!1},isRemoval:{type:Boolean,default:!1},useDefaultBtn:{type:Boolean,default:!1},rowKey:{type:String,default:"id"}},data:function(){return{componentName:"singleTable",data:null,fixedList:[],scrollTimer:"",checkedViewHeight:0,pageId:"",initLoading:!0,headerWidthList:[],headerWidthTimerList:[],listLength:-1,selectOptionList:[],selectLoading:!1,tempVarList:[],guid:"",pageNo:1,defaultOperation:{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",method:this.defaultDeleteRow}]},constantWidth:l.a.tableComponentWidth,autoWidthTimer:{},autoWidthList:[],setScrollWidthTimer:-2,autoWidthSwitch:!1,autoWidths:[],columnWidth:{},isLoading:!0,fileList:[],removalVarListTimer:null}},components:{tableFilter:s.a,customSummaryOption:o.a},directives:{"auto-width":{inserted:function(t,e,a){var i=a.context,n=e.value.component?e.value.component.length:0;n>1&&t.clientHeight>60&&i.$set(i.columnWidth,e.value.prop,60*Math.ceil(n/2)+25+"px")}},"merga-width":{bind:function(t,e,a){!a.context.autoWidthTimer[e.value.id]&&(a.context.autoWidthTimer[e.value.id]=-1)},inserted:function(t,e,a){!a.context.autoWidthList.length&&(a.context.autoWidthList=a.context.setTitleList.map(function(t){return[]})),a.context.$nextTick(function(i){-1===a.context.autoWidthTimer[e.value.id]&&(a.context.autoWidthTimer[e.value.id]=setTimeout(function(i){var n=t.offsetWidth,s=e.value,o=a.context.autoWidthList;if(o[s.parentLayer].length)if(o[s.parentLayer][s.selfLayer]>-1){var l=o[s.parentLayer][s.selfLayer];o[s.parentLayer].splice(s.selfLayer,1,n+l)}else o[s.parentLayer][s.selfLayer]=n;else{var r=[];r[s.selfLayer]=n,o.splice(s.parentLayer,1,r)}},20))})}}},computed:{setColumnGlobalStyle:function(){return this.columnGlobalStyle},setVarList:function(){return this.varList.concat([])},removalVarList:function(){return this.removalVarLists(this.setVarList)},setInitLoading:function(){return this.mergeTitle.length?this.initLoading||this.isLoading:this.initLoading},setTableLoading:function(){return this.showTableSet?this.showTableSet&&this.setInitLoading:this.setInitLoading},tableData:function(){return this.$store.getters[this.guid+"/tableData"]||{}},resetPageDataHeight:function(){var t=0;return"boolean"==typeof this.hidePages?!this.hidePages&&this.hasPageData&&(t=this.setSmallPageHeight):void 0===this.hidePages&&(t=this.setSmallPageHeight),t},resetHeight:function(){return this.checkedViewHeight+this.customSummaryOptionHeight+this.resetPageDataHeight},tempCustomColumn:function(){return this.customColumn.concat([])},setCustomColumn:function(){if(this.useDefaultBtn){var t=this.tempCustomColumn.findIndex(function(t){return"last"===t.columnIndex});return t>-1?this.tempCustomColumn.splice(t,1,this.defaultOperation):this.tempCustomColumn.push(this.defaultOperation),this.tempCustomColumn}return this.tempCustomColumn}},created:function(){var t=this;console.log(this.setApiObj),this.guid=Object(n.a)(),Object(r.c)(this),this.setApiObj.apiName&&("0"===this.userInfo.userId?setTimeout(function(){t.data=u.a,t.data.result.varList&&t.data.result.varList.length>0&&t.data.result.varList.forEach(function(t){t.rowState="1"}),t.$store.commit(t.guid+"/SET_TABLEDATA",{res:t.data,vm:t}),t.pageId=t.$storage.get("menuId"),t.setDragTable&&t.setSort(),t.$store.commit(t.guid+"/SET_TABLERULELIST",{cb:t.tableRuleForm,ruleId:"root",vm:t}),t.initLoading=!1},1e3):this.httpRequests())},mounted:function(){this.setFixed(),this.setTableCheckBoxDisplay()},beforeDestroy:function(){!this.layer&&Object(r.g)(this.$store,this.guid)},updated:function(){},watch:{"tableData.tableData":function(){this.setFixed(),this.setTableCheckBoxDisplay()},"setApiObj.params":function(){this.httpRequests()},autoWidthList:{deep:!0,handler:function(t,e){var a=this;clearTimeout(this.setScrollWidthTimer),this.setScrollWidthTimer=setTimeout(function(e){a.autoWidths=t.map(function(t){var e=Math.max.apply(null,t);return e>-9999&&e<9999?e+20:0});var i=0;a.autoWidths.forEach(function(t){i+=t}),a.setShowCheckBox&&(i+=55),a.setShowIndex&&(i+=50),a.setDragTable&&(i+=50);var n=a.$el.clientWidth>i?(a.$el.clientWidth-i)/a.autoWidthList.length:0;a.autoWidths=a.autoWidths.map(function(t){return t?t+n:null}),a.setFixed(),a.autoWidthSwitch=!0,a.isLoading=!1},100)}},removalVarList:function(){var t=this;clearInterval(this.removalVarListTimer),this.removalVarListTimer=setInterval(function(e){t.tableData.titleList&&t.tableData.titleList.length&&(clearInterval(t.removalVarListTimer),t.pushData(t.removalVarList))},200)},initData:function(){var t=this;this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:null,ruleId:"root"});var e=JSON.parse(JSON.stringify(this.initData));this.$store.commit(this.setGuid+"/SET_TABLEDATA",{res:e,vm:this}),this.pageId=this.$storage.get("menuId"),this.setDragTable&&this.setSort(),this.pageNo=this.tableData.pageData&&this.tableData.pageData.current||1,this.initLoading=!1,this.$nextTick(function(e){t.scrollTable()}),this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:this.tableRuleForm,ruleId:"root",vm:this})}},methods:{defaultDeleteRow:function(t,e,a){this.deleteData(t)},removalVarLists:function(t){var e=this;if("transferTable"===this.useScenarios)return Object(c.a)(t);var a=[];return t.forEach(function(t,i){!t._internalId&&(t._internalId=Object(n.n)());var s=JSON.parse(JSON.stringify(t));!e.tempVarList.find(function(t){return t._internalId===s._internalId})&&a.push(s)}),a.length&&(this.tempVarList=this.tempVarList.concat(a)),a},httpRequests:function(t){var e=this;this.initLoading=!0,this.$store.commit(this.guid+"/SET_TABLERULELIST",{cb:null,ruleId:"root"}),this.$api[this.setApiObj.apiName](Object.assign({},this.setApiObj.params,{pageNo:t||1})).then(function(a){e.data=a,e.pageNo=a.result.pageData&&a.result.pageData.current||1,e.data.result.varList&&e.data.result.varList.length&&e.data.result.varList.forEach(function(t){t.rowState="1",t._internalId=Object(n.n)()}),e.$store.commit(e.guid+"/SET_TABLEDATA",{res:e.data,vm:e}),e.pageId=e.$storage.get("menuId"),e.setDragTable&&e.setSort(),e.initLoading=!1,t&&e.$nextTick(function(t){e.scrollTable()}),e.$store.commit(e.guid+"/SET_TABLERULELIST",{cb:e.tableRuleForm,ruleId:"root",vm:e})}).catch(function(t){console.log(t),e.initLoading=!1})},setStyle:function(t){},selectItem:function(t,e){this.$emit("databridge",t,e),this.isSingle&&(t.length?(this.tableData[this.dataName].forEach(function(t){t.rowState="0"}),t[0].rowState="1"):this.tableData[this.dataName].forEach(function(t){t.rowState="1"}))},selectAllItem:function(t){if(this.isSingle){if(t.length)for(var e=t.length-1;e>=0;e--)t.splice(e,1)}else this.$emit("databridge",t)},handleCurrentChange:function(t){t!==this.pageNo&&(this.setApiObj.apiName?this.httpRequests(t)&&(this.tempVarList=[]):this.$emit("current-change",t))},updateTable:function(){this.setApiObj&&this.setApiObj.apiName&&this.httpRequests()},updateData:function(){this.setApiObj&&this.setApiObj.apiName&&this.httpRequests()}}},h=(a("BOGe"),a("KHd+")),m=Object(h.a)(d,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:!t.disableLoading&&t.setTableLoading,expression:"!disableLoading && setTableLoading"}],ref:"tableWrapper",staticClass:"columnBaseTable myCoustomTable resetCoustomTableStyle",staticStyle:{height:"100%",position:"relative"}},[t.showTableSet&&"outside"===t.tableSetMode?a("table-filter",{attrs:{headerList:t.setColConfigs,tableSwitchState:t.setTableSwitch,storeId:t.pageId,componentId:t.componentId},on:{"checked-list":t.checkedList,"checked-height":t.checkedHeight}}):t._e(),t._v(" "),a("div",{style:{height:t.setTableHeight}},[a("el-form",{ref:"ruleForm",style:{height:"100%"},attrs:{model:t.ruleForm,"status-icon":""},nativeOn:{submit:function(t){t.preventDefault()}}},[a("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:t.tableData.tableData,stripe:"",border:"","current-row-key":t.rowKey,"tooltip-effect":"dark",height:"100%",fit:"","header-cell-class-name":t.setStyle,"row-key":"_internalId","default-sort":t.setSortableConfig["default-sort"],"show-summary":t.setSysSummary},on:{select:t.selectItem,"select-all":t.selectAllItem,"selection-change":t.selectionChange,"sort-change":t.sortChange,"row-click":t.rowClick,"row-dblclick":t.rowDblclick}},[t.setShowCheckBox?[a("el-table-column",{attrs:{type:"selection",fixed:t.fixedState,selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.setShowIndex?[a("el-table-column",{attrs:{type:"index",index:t.indexMethod,fixed:t.fixedState,label:"序号",width:"50",align:"center"}})]:t._e(),t._v(" "),t._l(t.setTitleList,function(e,i){return[e.slot?a("tempalte",[t._t(e.slot,null,{fixed:t.setFixedList[i]})],2):Array.isArray(e.component)?[a("el-table-column",t._b({key:i,attrs:{"show-overflow-tooltip":"",fixed:t.setFixedList[i],"min-width":e.width||t.setColumnWidth[e.prop],align:"center"},scopedSlots:t._u([{key:"header",fn:function(n){return[a("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:i,isComponent:!0,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,isComponent: true,label:colConfig.label,prop:colConfig.prop}"}],staticStyle:{display:"inline-flex","white-space":"nowrap"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(i){return[a("div",{directives:[{name:"auto-width",rawName:"v-auto-width",value:e,expression:"colConfig"}],staticClass:"btnBox",staticStyle:{display:"flex","white-space":"normal","flex-wrap":"wrap"},style:{"justify-content":t.setColumnWidth[e.prop]?"space-between":"center"}},t._l(e.component,function(e,n){return void 0!==e.editBtns_isShow&&!e.editBtns_isShow||!e.rowState||t.setButtonState(i.$index,i.row,e)?a("el-button",{key:n,staticStyle:{height:"30px",width:"60px",padding:"0",margin:"0","font-size":"12px","max-width":"60px"},attrs:{type:"text"},on:{click:function(t){e.method(i.row,i.$index,i)}}},[t._v(t._s(e.name))]):t._e()}),1)]}}])},"el-table-column",e,!1))]:"object"!=typeof e.component||Array.isArray(e.component)?[e._isShow||"outside"!==t.tableSetMode?a("el-table-column",{key:i,attrs:{"show-overflow-tooltip":"",prop:e.prop,width:e._isShow?"":t.setTableColumnState?"20":"","min-width":e._isShow?e.width||t.constantWidth[e.componentName]||t.autoWidths[i]||null:"",sortable:void 0===e.sortable?t.isSortable:e.sortable,fixed:t.setFixedList[i],align:"center"},scopedSlots:t._u([{key:"header",fn:function(n){return[a("span",{directives:[{name:"auto-tran",rawName:"v-auto-tran",value:{state:e._isShow,index:i,label:e.label,prop:e.prop},expression:"{state:colConfig._isShow,index:infoIndex,label:colConfig.label,prop:colConfig.prop}"},{name:"custom-table-switch",rawName:"v-custom-table-switch",value:{config:e,index:i,showSwitch:t.setTableColumnState},expression:"{config:colConfig,index:infoIndex,showSwitch:setTableColumnState}"}],style:{display:e._isShow?"inline-flex":"none","white-space":"nowrap"},domProps:{textContent:t._s(e.label)}})]}},{key:"default",fn:function(n){return[a("core-index",{directives:[{name:"show",rawName:"v-show",value:!!e._isShow||"outside"===t.tableSetMode,expression:"colConfig._isShow?true:tableSetMode === 'outside'"}],attrs:{scope:n,"info-index":i,"col-config":e,runTime:"base"}})]}}])}):t._e()]:[a(e.component,{key:i,tag:"component",attrs:{"col-config":e,fixed:t.setFixedList[i]}})]]}),t._v(" "),t.setDragTable?[a("el-table-column",{attrs:{label:"拖拽",width:"50",align:"center"},scopedSlots:t._u([{key:"default",fn:function(t){return[a("el-tooltip",{attrs:{effect:"dark",content:"拖拽当前行",placement:"bottom","open-delay":1500,"hide-after":3e3,enterable:!1}},[a("svg-icon",{staticClass:"drag-handler theDragHandle",attrs:{"icon-class":"drag"}})],1)]}}])})]:t._e()],2)],1),t._v(" "),t.setUseSummary&&t.setCustomSummary.component?[a("custom-summary-option",{attrs:{customSummary:t.setCustomSummary,tempData:t.setTempData,tableData:t.tableData.tableData},on:{"send-height":t.customSummaryHeight,"custom-summary-value":t.customSummaryValue}})]:t._e()],2),t._v(" "),!t.hidePages&&t.hasPageData?a("div",{staticStyle:{"text-align":"center"},style:{"margin-top":(t.customSummaryOptionHeight||5)+"px",height:this.setSmallPageHeight+"px"}},[a("el-pagination",{attrs:{background:!t.smallPage,small:t.smallPage,"current-page":t.tableData.pageData.current,"page-size":t.tableData.pageData.size,layout:"prev, pager, next, jumper",total:t.tableData.pageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.tableData.pageData,"current",e)}}})],1):t._e()],1)},[],!1,null,"61133ff4",null);m.options.__file="index.vue";e.a=m.exports},YqjF:function(t,e,a){},"f/WR":function(t,e,a){"use strict";a("XfO3"),a("HEwt"),a("a1Th"),a("rE2o"),a("ioFf"),a("dRSK"),a("rGqo"),a("91GP");var i=a("z0WU"),n=a("Yfch");function s(t){return function(t){if(Array.isArray(t))return t}(t)||function(t){if(Symbol.iterator in Object(t)||"[object Arguments]"===Object.prototype.toString.call(t))return Array.from(t)}(t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}()}var o={props:["colConfig","fixed"],template:'<el-table-column :label="colConfig.label" :fixed="fixed" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t  <template v-for="(item, index) in colConfig.rowMethods">\n    \t\t\t\t\t    <el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="item.method(scope.row,scope.$index)" v-text="item.name"></el-button>\n                </template>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},l={components:{},name:"transfer-table",props:{tableConfigs:{type:Object,default:function(){return{}}},btnList:{type:Array,default:function(){return[]}},upTableBtnTemplate:{type:Array,default:function(){return[]}},downTableBtnTemplate:{type:Array,default:function(){return[]}},apiData:{type:Object,default:function(){return{}}},stateBtn:{type:Object,default:function(){return{}}}},data:function(){return{btnsBoxHeight:0,currentpage:1,tableLoading:!1,tableData:[],resultTableData:[],titleList:[],pageData:{},tableBtns:{columnIndex:"last",prop:"operate",label:"操作",component:o,rowMethods:[{name:"删除",method:this.deleteRow}]},rowKey:"",tempSelectList:[],stateBtnChecked:!1}},computed:{setTablesHeight:function(){return this.stateBtn.title?{height:"calc(50% - 15px)"}:{height:"calc(50% - 6px)"}},setResultBtnState:function(){var t=this;return function(e){return!t.resultTableData.length&&e.state}},setTableConfigs:function(){var t=s(this.titleList).slice(0);return{titleList:this.addTableTitle(t,this.upTableBtnTemplate),showIndex:void 0!==this.tableConfigs.showIndex&&this.tableConfigs.showIndex,isSingle:void 0!==this.tableConfigs.isSingle&&this.tableConfigs.isSingle,isSortable:void 0!==this.tableConfigs.isSortable&&this.tableConfigs.isSortable}},setResultTableConfigs:function(){var t=s(this.titleList).slice(0);return this.downTableBtnTemplate.length?this.addTableTitle(t,this.downTableBtnTemplate):this.addTableTitle(t,[this.tableBtns])},setResultTableData:function(){return[].concat(this.resultTableData)}},watch:{currentpage:function(){var t=Object.assign({},this.apiData.params);t.pageNo=this.currentpage,this.httpTableMethod(this.apiData.apiName,t)},setResultTableData:function(){this.$emit("table-selected",this.setResultTableData)},stateBtnChecked:function(){var t={};t[this.stateBtn.keyName?this.stateBtn.keyName:"isShow"]=this.stateBtnChecked,this.httpTableMethod(this.apiData.apiName,this.apiData.params,t)},"apiData.params":function(){console.log(this.apiData.params),this.httpTableMethod(this.apiData.apiName,this.apiData.params)}},created:function(){this.apiData.apiName?(this.httpTableMethod(this.apiData.apiName,this.apiData.params),this.rowKey=this.tableConfigs.rowKey||"id"):this.$message({message:"没有设置接口名",type:"error",duration:1e4})},mounted:function(){this.$nextTick(function(){this.btnsBoxHeight=this.$refs.btnsBox.clientHeight+5})},methods:{clearTableSelected:function(){var t=this;this.resultTableData=[],this.tempSelectList=[],this.tableData.forEach(function(e){t.$refs.selectTable.$refs.baseTable.clearSelection()})},httpTableMethod:function(t,e,a){var i=this;this.tableLoading=!0,this.$api[t](Object.assign({},e,a)).then(function(t){console.log(t),i.getListPage(t),i.tableLoading=!1}).catch(function(t){i.tableLoading=!1})},getListPage:function(t){var e=this;t&&(t.result.titles="string"==typeof t.result.titles?JSON.parse(t.result.titles):t.result.titles,t.result.varList="string"==typeof t.result.varList?JSON.parse(t.result.varList):t.result.varList,t.result.pageData="string"==typeof t.result.pageData?JSON.parse(t.result.pageData):t.result.pageData,this.titleList=Object(i.l)(t.result),this.pageData=t.result.pageData,this.tableData=t.result.varList||[],this.tempSelectList=[],this.$nextTick(function(t){e.toggleRowSelected()}))},toggleRowSelected:function(){var t=this;this.tableData.forEach(function(e){t.resultTableData.some(function(a){return e[t.rowKey]===a[t.rowKey]})?(t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!0),!t.tempSelectList.some(function(a){return a[t.rowKey]===e[t.rowKey]})&&t.tempSelectList.push(e)):t.$refs.selectTable&&t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!1)})},addTableTitle:function(t,e){return e&&e.length&&e.forEach(function(e){Object(n.b)(e.columnIndex)?t.splice(e.columnIndex,0,e):"first"===e.columnIndex?t.unshift(e):"last"===e.columnIndex?t.push(e):t.some(function(t){if(t.prop===e.columnIndex)return Object.assign(t,e),!0})}),t},dataBridge:function(t,e){this.getChecked(e,t)?this.addRowData(e):this.removeRowData(e)},resultDataBridge:function(t,e){console.log(t),console.log(e)},deleteRow:function(t,e){var a=this;console.log(t),console.log(e),this.resultTableData.find(function(e,i){if(t[a.rowKey]===e[a.rowKey])return a.resultTableData.splice(i,1),e}),this.toggleRowSelected()},updateView:function(t,e){this.resultTableData.splice(e-1,1,t)},getChecked:function(t,e){var a=this;return t?e.some(function(e){return t[a.rowKey]===e[a.rowKey]}):(e.length&&(this.tempSelectList=e),!!e.length)},addRowData:function(t){var e=this;t?!this.resultTableData.some(function(a){return t[e.rowKey]===a[e.rowKey]})&&this.resultTableData.push(t):this.addAllRowData()},addAllRowData:function(){var t=this;this.resultTableData.length?this.tempSelectList.forEach(function(e){t.addRowData(e)}):this.resultTableData=this.tempSelectList},removeRowData:function(t){var e=this;t?this.resultTableData.some(function(a,i){if(t[e.rowKey]===a[e.rowKey])return e.resultTableData.splice(i,1),!0}):this.tableData.forEach(function(t){e.removeRowData(t)})}}},r=(a("UFNq"),a("KHd+")),c=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"myCoustomTable resetTransferTableStyle",staticStyle:{height:"100%",padding:"10px"}},[t.stateBtn.title?a("div",{staticStyle:{"text-align":"right"}},[a("el-checkbox",{model:{value:t.stateBtnChecked,callback:function(e){t.stateBtnChecked=e},expression:"stateBtnChecked"}},[t._v(t._s(t.stateBtn.title))])],1):t._e(),t._v(" "),a("div",{style:t.setTablesHeight},[a("base-table",{directives:[{name:"loading",rawName:"v-loading",value:t.tableLoading,expression:"tableLoading"}],ref:"selectTable",attrs:{data:t.tableData,colConfigs:t.setTableConfigs.titleList,showCheckBox:!0,showIndex:t.setTableConfigs.showIndex,pageData:t.pageData,currentpage:t.currentpage,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.dataBridge}})],1),t._v(" "),a("div",{staticStyle:{height:"11px"}}),t._v(" "),a("div",{ref:"resultBox",staticStyle:{position:"relative"},style:t.setTablesHeight},[a("div",{staticStyle:{height:"100%"},style:{paddingBottom:t.btnsBoxHeight+"px"}},[a("base-table",{ref:"resultTable",attrs:{data:t.setResultTableData,colConfigs:t.setResultTableConfigs,showCheckBox:!1,showIndex:t.setTableConfigs.showIndex,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{databridge:t.resultDataBridge}})],1),t._v(" "),a("div",{ref:"btnsBox",staticStyle:{position:"absolute",bottom:"0",right:"0"}},[t.btnList.length?[t._l(t.btnList,function(e,i){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],key:i,attrs:{name:e.name,icon:e.icon,plain:e.plain,state:t.setResultBtnState(e)},on:{myclick:e.method}})]})]:t._e()],2)])])},[],!1,null,"58fcd14e",null);c.options.__file="index.vue";e.a=c.exports},jB0T:function(t,e,a){},lfPC:function(t,e,a){},sRvh:function(t,e,a){}}]);