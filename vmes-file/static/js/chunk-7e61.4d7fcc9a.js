(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7e61"],{"+0ON":function(t,e,a){"use strict";var i=a("map8");a.n(i).a},"3d3b":function(t,e,a){"use strict";a("rE2o"),a("ioFf"),a("91GP"),a("pIFo");var i=a("f/WR"),n=a("uTIz");a("xMja");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var s={components:{transferTable:i.a,searchBar:n.a},name:"productTableDialog",props:["initData","visible"],data:function(){return{isConfirm:!1,temp:{productIds:""},tempLable:{},rules:{},guid:"",tempQuery:{},searchList:[{label:"货品编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入货品名称"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!0,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},pageData:null,pageNo:1,btnList:[{name:"确定",isShow:!0,state:!0,method:this.toAddWarehouseIn},{name:"清空",icon:"refresh",state:!0,plain:!0,method:this.resetQuery,isShow:!0}],apiData:{apiName:"listPageProducts",params:{}},tableSelectList:[],stateBtnData:{},tableConfigs:{showIndex:!0},tempList:[]}},created:function(){var t="";if(null!=this.initData.data&&this.initData.data.length>0)for(var e=0;e<this.initData.data.length;e++){var a=this.initData.data[e];null!=a.productId&&a.productId.trim().length>0&&(t=t+a.productId+",")}this.temp.productIds=t;var i="";null!=this.initData.queryStr&&(i=this.initData.queryStr);var n="";n=null!=this.initData.fieldCode?this.initData.queryStr:"code,name,spec,unitName,genreName,stockCount,safetyCount,lockCount,productStockCount,cdate";var o="";o=null!=this.initData.orderStr?this.initData.queryStr:"prod.stock_count desc";var s=!0;null!=this.initData.isNeedRepeat&&(s=this.initData.isNeedRepeat),s||null!=t&&t.trim().length>0&&(i="prod.id not in ("+(t="'"+(t=t.substring(0,t.lastIndexOf(","))).replace(",","','")+"'")+")"),this.apiData.params={fieldCode:n,queryStr:i,orderStr:o}},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{tableHeight:function(){},dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{sendGuid:function(t){this.guid=t},searchMap:function(t){this.apiData.params=Object.assign({},t)},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{isConfirm:this.isConfirm,selectList:this.tempList})},toAddWarehouseIn:function(){this.isConfirm=!0,this.isVisible=!1},resetQuery:function(){this.$refs.trabsferTables.clearTableSelected()},tableSelected:function(t){this.tempList=t},closeDialog:function(t){this.showDialog=!1}}},l=a("KHd+"),r=Object(l.a)(s,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"margin-top":"15px","margin-left":"10px"}},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticStyle:{"border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px","margin-top":t.searchList.length?"10px":"0"}},[a("div",{staticStyle:{float:"left",width:"calc(100%)",height:"650px"}},[a("transfer-table",{ref:"trabsferTables",attrs:{tableConfigs:t.tableConfigs,btnList:t.btnList,stateBtn:t.stateBtnData,apiData:t.apiData},on:{"table-selected":t.tableSelected}})],1)])],1)],1)},[],!1,null,null,null);r.options.__file="productTableDialog.vue";e.a=r.exports},CU5c:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf"),a("f3/d");var i=a("3d3b"),n=a("WIyV"),o=a("cTe8");a("QD6Y"),a("z0WU");function s(t){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{productTableDialog:i.a,customBaseTable:n.a},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{remark:"",makeId:"",makeName:"",dtlJsonStr:""},tempLable:{},tempQuery:{},tableData:[],tableList:[],rowData:{},selectList:null,configs:{topBarBtnList:[{name:"选择货品",nameEn:"add",isShow:!0,icon:"add",method:this.addProduct}]},apiObj:{apiName:"listPagePurchasePlanDetails",params:{pageNo:1,parentId:"null",fieldCode:"productCode,productName,spec,genre,unit,count,reason,edate,remark"}},customColumn:[{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"reason",componentName:"select",_cellConfig:{asyn:{apiName:"getDictionarys",params:{dictionaryKey:"purchaseReason",isglobal:"1"}},rules:[{required:!0}],outputData:!0}},{columnIndex:"edate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy-MM-dd",valueFormat:"yyyy-MM-dd",greaterThan:["tempData@minDate",!0]}},{columnIndex:"remark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{minDate:new Date},MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择制单人",tableUrl:"/system/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}}}},created:function(){var t=this.$storage.get("userInfo");this.temp.makeId=t.userId,this.temp.makeName=t.userName,this.apiObj.params.parentId="null"},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=s(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(t){Array.isArray(t)?(this.tableList=[],this.tableList=t):(this.rowData=null,null!=t.row&&(this.rowData=t.row))},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},addProduct:function(){this.dialogData.data=this.tableList,this.dialogData.title="选择货品",this.openDialogName="productTableDialog",this.showDialog=!0,this.inLinVisible=!0},savePlan:function(){var t=this,e="";if(this.$refs.planAddDialog.getData(),null!=this.tableList&&0!=this.tableList.length){for(var a=[],i=0;i<this.tableList.length;i++){var n=this.tableList[i],s={productId:"",count:"",reason:"",edate:"",remark:"",id:""};s.productId=n.productId,s.count=n.count,s.remark=n.remark,s.edate=n.edate,s.reason=n.reason.item.id,s.id=n.id,a.push(s)}e=JSON.stringify(a),this.temp.dtlJsonStr=e,this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(o.addPurchasePlan)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){}))})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})},makeSelect:function(t){t[0]&&(this.temp.makeId=t[0].id,this.temp.makeName=t[0].name)},closeDialog:function(t){this.showDialog=!1;var e=!1;null!=t.isConfirm&&(e=t.isConfirm);var a=[];null!=t.selectList&&(a=t.selectList),this.tableSelected(e,a)},tableSelected:function(t,e){if(t&&null!=e&&e.length>0)for(var a=0;a<e.length;a++){var i=e[a],n={productId:"",productCode:"",productName:"",spec:"",genre:"",unit:"",count:"",reason:"",edate:"",remark:"",id:""};n.productId=i.id.trim(),null!=i.code&&i.code.trim().length>0&&(n.productCode=i.code.trim()),null!=i.name&&i.name.trim().length>0&&(n.productName=i.name.trim()),null!=i.spec&&i.spec.trim().length>0&&(n.spec=i.spec.trim()),null!=i.genreName&&i.genreName.trim().length>0&&(n.genre=i.genreName.trim()),null!=i.unitName&&i.unitName.trim().length>0&&(n.unit=i.unitName.trim()),n.id=i.id.trim()||a,this.tableData.push(n)}}},watch:{}},r=(a("+0ON"),a("KHd+")),c=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1250px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog,"table-selected":t.tableSelected}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:t.MakeDialog.dialog},on:{callback:t.makeSelect},model:{value:t.temp.makeName,callback:function(e){t.$set(t.temp,"makeName",e)},expression:"temp.makeName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[a("el-input",{staticStyle:{width:"200px"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2),t._v(" "),a("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[a("custom-base-table",{ref:"planAddDialog",attrs:{isSortable:!1,varList:t.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:t.customColumn,apiObj:t.apiObj,mergeTitle:t.mergeTitle,mergeColumn:t.mergeColumn,mergeRow:t.mergeRow,tempData:t.tempData,componentId:"planAddDialog",useDefaultBtn:!0,showAll:!1,keyMapping:t.keyMapping},on:{databridge:t.databridge}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.savePlan}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);c.options.__file="dialogAdd.vue";e.default=c.exports},IJLS:function(t,e,a){"use strict";var i=a("SeFu");a.n(i).a},QXqY:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf"),a("f3/d");var i=a("3d3b"),n=a("WIyV"),o=a("cTe8");a("QD6Y"),a("z0WU");function s(t){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{productTableDialog:i.a,customBaseTable:n.a},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{remark:"",makeId:"",makeName:"",dtlJsonStr:""},tempLable:{},tempQuery:{},tableData:[],tableList:[],rowData:{},selectList:null,configs:{topBarBtnList:[{name:"选择货品",nameEn:"add",isShow:!0,icon:"add",method:this.addProduct}]},apiObj:{apiName:"listPagePurchasePlanDetails",params:{pageNo:1,parentId:"null",fieldCode:"productCode,productName,spec,genre,unit,count,reason,edate,remark"}},customColumn:[{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"reason",componentName:"select",_cellConfig:{asyn:{apiName:"getDictionarys",params:{dictionaryKey:"purchaseReason",isglobal:"1"}},rules:[{required:!0}],outputData:!0}},{columnIndex:"edate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy-MM-dd",valueFormat:"yyyy-MM-dd",greaterThan:["tempData@minDate",!0]}},{columnIndex:"remark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{minDate:new Date},MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择制单人",tableUrl:"/system/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}}}},created:function(){this.$storage.get("userInfo");this.temp=this.initData.temp,this.apiObj.params.parentId=this.initData.temp.id},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=s(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(t){Array.isArray(t)?(this.tableList=[],this.tableList=t):(this.rowData=null,null!=t.row&&(this.rowData=t.row))},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},addProduct:function(){this.dialogData.data=this.tableList,this.dialogData.title="选择货品",this.openDialogName="productTableDialog",this.showDialog=!0,this.inLinVisible=!0},editPlan:function(){var t=this,e="";if(this.$refs.planAddDialog.getData(),null!=this.tableList&&0!=this.tableList.length){for(var a=[],i=0;i<this.tableList.length;i++){var n=this.tableList[i],s={productId:"",count:"",reason:"",edate:"",remark:"",id:""};s.productId=n.productId,s.count=n.count,s.remark=n.remark,s.edate=n.edate,n.reason.item?s.reason=n.reason.item.id:s.reason=n.reasonId,s.id=n.id,a.push(s)}e=JSON.stringify(a),this.temp.dtlJsonStr=e,this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(o.editPurchasePlan)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){}))})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})},makeSelect:function(t){t[0]&&(this.temp.makeId=t[0].id,this.temp.makeName=t[0].name)},closeDialog:function(t){this.showDialog=!1;var e=!1;null!=t.isConfirm&&(e=t.isConfirm);var a=[];null!=t.selectList&&(a=t.selectList),this.tableSelected(e,a)},tableSelected:function(t,e){if(t&&null!=e&&e.length>0)for(var a=0;a<e.length;a++){var i=e[a],n={productId:"",productCode:"",productName:"",spec:"",genre:"",unit:"",count:"",reason:"",edate:"",remark:"",id:""};n.productId=i.id.trim(),null!=i.code&&i.code.trim().length>0&&(n.productCode=i.code.trim()),null!=i.name&&i.name.trim().length>0&&(n.productName=i.name.trim()),null!=i.spec&&i.spec.trim().length>0&&(n.spec=i.spec.trim()),null!=i.genreName&&i.genreName.trim().length>0&&(n.genre=i.genreName.trim()),null!=i.unitName&&i.unitName.trim().length>0&&(n.unit=i.unitName.trim()),n.id=i.id.trim()||a,this.tableData.push(n)}}},watch:{}},r=(a("IJLS"),a("KHd+")),c=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1250px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog,"table-selected":t.tableSelected}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:t.MakeDialog.dialog},on:{callback:t.makeSelect},model:{value:t.temp.makeName,callback:function(e){t.$set(t.temp,"makeName",e)},expression:"temp.makeName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[a("el-input",{staticStyle:{width:"200px"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2),t._v(" "),a("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[a("custom-base-table",{ref:"planAddDialog",attrs:{isSortable:!1,varList:t.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:t.customColumn,apiObj:t.apiObj,mergeTitle:t.mergeTitle,mergeColumn:t.mergeColumn,mergeRow:t.mergeRow,tempData:t.tempData,componentId:"planAddDialog",useDefaultBtn:!0,showAll:!1,keyMapping:t.keyMapping},on:{databridge:t.databridge}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.editPlan}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);c.options.__file="dialogEdit.vue";e.default=c.exports},SeFu:function(t,e,a){},Ty1E:function(t,e,a){},UNMF:function(t,e,a){"use strict";var i=a("Ty1E");a.n(i).a},XkgR:function(t,e,a){"use strict";var i=a("q2Tj");a.n(i).a},YDId:function(t,e,a){"use strict";a.r(e);a("rGqo");var i=a("2+ib"),n=a("uTIz"),o=a("CU5c"),s=a("QXqY"),l=a("Vobf"),r=a("cTe8"),c=a("QD6Y");function u(t,e,a){return e in t?Object.defineProperty(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}var d={components:{multilevelTable:i.a,searchBar:n.a,dialogAdd:o.default,dialogEdit:s.default},data:function(){var t,e;return{configs:{topBarBtnList:[{name:"新增采购计划",nameEn:"addPlan",isShow:!0,icon:"add",method:this.addPlan},{name:"提交",nameEn:"submitPlan",isShow:!0,icon:"save",method:this.submitPlan}]},searchList:[{label:"计划号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入计划号"},{label:"经办人",type:"input",ruleType:"string",mapKey:"cuserName",configs:{},placeholder:"请输入经办人"},{label:"状态",type:"select",ruleType:"number",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"待执行"},{value:"3",label:"执行中"},{value:"4",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"请输入货品名称"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:(t={success:{state:"4",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"待执行"}},u(t,"info",{state:"3",text:"执行中"}),u(t,"default",{state:"0",text:"待提交"}),t)},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"编辑",nameEn:"edit",editBtns_isShow:!0,icon:"edit",method:this.edit},{name:"删除",nameEn:"delete",editBtns_isShow:!0,icon:"delete",method:this.delete},{name:"取消",nameEn:"cancel",editBtns_isShow:!0,icon:"cancel",method:this.cancel},{name:"恢复",nameEn:"recovery",editBtns_isShow:!0,icon:"recovery",method:this.recovery}]}],apiObj:{apiName:"listPagePurchasePlans"},tempData:{},showHeader:!1,showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:(e={success:{state:"4",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"待执行"}},u(e,"info",{state:"3",text:"执行中"}),u(e,"default",{state:"0",text:"待提交"}),e)},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",nameEn:"deleteRow",editBtns_isShow:!0,icon:"deleteRow",method:this.deleteRow},{name:"取消",nameEn:"cancelRow",editBtns_isShow:!0,icon:"cancelRow",method:this.cancelRow},{name:"恢复",nameEn:"recoveryRow",editBtns_isShow:!0,icon:"recoveryRow",method:this.recoveryRow}]}],apiObj:{apiName:"listPagePurchasePlanDetails",params:{}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!0,isSingle:!1,componentId:"twoLevelTable"}],selectList:[],searchObj:{},temp:{},tempLable:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,a=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(l.initMenuButtons)({menuId:a,roleId:e}).then(function(e){t.$loading().close();var a=e.buttonList;a&&a.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){console.log(e),t.$loading().close()}))},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(this.searchObj)},databridge:function(t){this.selectList=t},delete:function(t,e){var a=this,i=this;i.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(r.deletePurchasePlan)(t.id).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(t){console.log(t)})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},cancel:function(t,e){var a=this,i=this;i.$confirm("此操作将该记录从待提交状态变更为已取消状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(r.cancelPurchasePlan)(t.id).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(t){console.log(t)})}).catch(function(){i.$message({type:"info",message:"已取消操作"})})},recovery:function(t,e){var a=this,i=this;i.$confirm("此操作将该记录从取消状态恢复到待提交状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(r.recoveryPurchasePlan)(t.id).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(t){console.log(t)})}).catch(function(){i.$message({type:"info",message:"已取消操作"})})},edit:function(t,e){this.resetTemp(),this.dialogData.temp=t,this.dialogData.tempLable=this.tempLable,this.dialogData.title="编辑",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0},deleteRow:function(t,e){var a=this,i=this;i.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(c.deletePurchasePlanDetail)(t.id).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(t){console.log(t)})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},cancelRow:function(t,e,a){var i=this,n=this;n.$confirm("此操作将该记录从待提交状态变更为已取消状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(c.cancelPurchasePlanDetail)(t.id).then(function(t){0===t.code&&(n.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),i.updateData(i.searchObj))}).catch(function(t){console.log(t)})}).catch(function(){n.$message({type:"info",message:"已取消操作"})})},recoveryRow:function(t,e,a){var i=this,n=this;n.$confirm("此操作将该记录从取消状态恢复到待提交状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(c.recoveryPurchasePlanDetail)(t.id).then(function(t){0===t.code&&(n.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),i.updateData(i.searchObj))}).catch(function(t){console.log(t)})}).catch(function(){n.$message({type:"info",message:"已取消操作"})})},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},addPlan:function(){this.resetTemp(),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="新增采购计划",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0},submitPlan:function(){var t=this,e=this,a="";e.selectList.forEach(function(t){"0"==t.state&&(a+=""==a?t.id:"','"+t.id)}),""!=a?Object(r.submitPurchasePlan)(a).then(function(a){0===a.code&&(e.$notify({title:"成功",message:"提交成功",type:"success",duration:2e3}),t.updateData(t.searchObj))}).catch(function(t){console.log(t)}):e.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条待提交状态的记录！"})},resetTemp:function(){for(var t in this.temp)this.temp[t]=""}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},m=(a("UNMF"),a("KHd+")),h=Object(m.a)(d,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"purchasePlan"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);h.options.__file="index.vue";e.default=h.exports},"f/WR":function(t,e,a){"use strict";a("XfO3"),a("HEwt"),a("a1Th"),a("rE2o"),a("ioFf"),a("dRSK"),a("rGqo"),a("91GP");var i=a("z0WU"),n=a("Yfch");function o(t){return function(t){if(Array.isArray(t))return t}(t)||function(t){if(Symbol.iterator in Object(t)||"[object Arguments]"===Object.prototype.toString.call(t))return Array.from(t)}(t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}()}var s={props:["colConfig","fixed"],template:'<el-table-column :label="colConfig.label" :fixed="fixed" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t  <template v-for="(item, index) in colConfig.rowMethods">\n    \t\t\t\t\t    <el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="item.method(scope.row,scope.$index)" v-text="item.name"></el-button>\n                </template>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},l={components:{},name:"transfer-table",props:{tableConfigs:{type:Object,default:function(){return{}}},btnList:{type:Array,default:function(){return[]}},upTableBtnTemplate:{type:Array,default:function(){return[]}},downTableBtnTemplate:{type:Array,default:function(){return[]}},apiData:{type:Object,default:function(){return{}}},stateBtn:{type:Object,default:function(){return{}}}},data:function(){return{btnsBoxHeight:0,currentpage:1,tableLoading:!1,tableData:[],resultTableData:[],titleList:[],pageData:{},tableBtns:{columnIndex:"last",prop:"operate",label:"操作",component:s,rowMethods:[{name:"删除",method:this.deleteRow}]},rowKey:"",tempSelectList:[],stateBtnChecked:!1}},computed:{setTablesHeight:function(){return this.stateBtn.title?{height:"calc(50% - 15px)"}:{height:"calc(50% - 6px)"}},setResultBtnState:function(){var t=this;return function(e){return!t.resultTableData.length&&e.state}},setTableConfigs:function(){var t=o(this.titleList).slice(0);return{titleList:this.addTableTitle(t,this.upTableBtnTemplate),showIndex:void 0!==this.tableConfigs.showIndex&&this.tableConfigs.showIndex,isSingle:void 0!==this.tableConfigs.isSingle&&this.tableConfigs.isSingle,isSortable:void 0!==this.tableConfigs.isSortable&&this.tableConfigs.isSortable}},setResultTableConfigs:function(){var t=o(this.titleList).slice(0);return this.downTableBtnTemplate.length?this.addTableTitle(t,this.downTableBtnTemplate):this.addTableTitle(t,[this.tableBtns])},setResultTableData:function(){return[].concat(this.resultTableData)}},watch:{currentpage:function(){var t=Object.assign({},this.apiData.params);t.pageNo=this.currentpage,this.httpTableMethod(this.apiData.apiName,t)},setResultTableData:function(){this.$emit("table-selected",this.setResultTableData)},stateBtnChecked:function(){var t={};t[this.stateBtn.keyName?this.stateBtn.keyName:"isShow"]=this.stateBtnChecked,this.httpTableMethod(this.apiData.apiName,this.apiData.params,t)},"apiData.params":function(){console.log(this.apiData.params),this.httpTableMethod(this.apiData.apiName,this.apiData.params)}},created:function(){this.apiData.apiName?(this.httpTableMethod(this.apiData.apiName,this.apiData.params),this.rowKey=this.tableConfigs.rowKey||"id"):this.$message({message:"没有设置接口名",type:"error",duration:1e4})},mounted:function(){this.$nextTick(function(){this.btnsBoxHeight=this.$refs.btnsBox.clientHeight+5})},methods:{clearTableSelected:function(){var t=this;this.resultTableData=[],this.tempSelectList=[],this.tableData.forEach(function(e){t.$refs.selectTable.$refs.baseTable.clearSelection()})},httpTableMethod:function(t,e,a){var i=this;this.tableLoading=!0,this.$api[t](Object.assign({},e,a)).then(function(t){console.log(t),i.getListPage(t),i.tableLoading=!1}).catch(function(t){i.tableLoading=!1})},getListPage:function(t){var e=this;t&&(t.result.titles="string"==typeof t.result.titles?JSON.parse(t.result.titles):t.result.titles,t.result.varList="string"==typeof t.result.varList?JSON.parse(t.result.varList):t.result.varList,t.result.pageData="string"==typeof t.result.pageData?JSON.parse(t.result.pageData):t.result.pageData,this.titleList=Object(i.k)(t.result),this.pageData=t.result.pageData,this.tableData=t.result.varList||[],this.tempSelectList=[],this.$nextTick(function(t){e.toggleRowSelected()}))},toggleRowSelected:function(){var t=this;this.tableData.forEach(function(e){t.resultTableData.some(function(a){return e[t.rowKey]===a[t.rowKey]})?(t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!0),!t.tempSelectList.some(function(a){return a[t.rowKey]===e[t.rowKey]})&&t.tempSelectList.push(e)):t.$refs.selectTable&&t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!1)})},addTableTitle:function(t,e){return e&&e.length&&e.forEach(function(e){Object(n.a)(e.columnIndex)?t.splice(e.columnIndex,0,e):"first"===e.columnIndex?t.unshift(e):"last"===e.columnIndex?t.push(e):t.some(function(t){if(t.prop===e.columnIndex)return Object.assign(t,e),!0})}),t},dataBridge:function(t,e){this.getChecked(e,t)?this.addRowData(e):this.removeRowData(e)},resultDataBridge:function(t,e){console.log(t),console.log(e)},deleteRow:function(t,e){var a=this;console.log(t),console.log(e),this.resultTableData.find(function(e,i){if(t[a.rowKey]===e[a.rowKey])return a.resultTableData.splice(i,1),e}),this.toggleRowSelected()},updateView:function(t,e){this.resultTableData.splice(e-1,1,t)},getChecked:function(t,e){var a=this;return t?e.some(function(e){return t[a.rowKey]===e[a.rowKey]}):(e.length&&(this.tempSelectList=e),!!e.length)},addRowData:function(t){var e=this;t?!this.resultTableData.some(function(a){return t[e.rowKey]===a[e.rowKey]})&&this.resultTableData.push(t):this.addAllRowData()},addAllRowData:function(){var t=this;this.resultTableData.length?this.tempSelectList.forEach(function(e){t.addRowData(e)}):this.resultTableData=this.tempSelectList},removeRowData:function(t){var e=this;t?this.resultTableData.some(function(a,i){if(t[e.rowKey]===a[e.rowKey])return e.resultTableData.splice(i,1),!0}):this.tableData.forEach(function(t){e.removeRowData(t)})}}},r=(a("XkgR"),a("KHd+")),c=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{height:"100%",padding:"10px"}},[t.stateBtn.title?a("div",{staticStyle:{"text-align":"right"}},[a("el-checkbox",{model:{value:t.stateBtnChecked,callback:function(e){t.stateBtnChecked=e},expression:"stateBtnChecked"}},[t._v(t._s(t.stateBtn.title))])],1):t._e(),t._v(" "),a("div",{style:t.setTablesHeight},[a("base-table",{directives:[{name:"loading",rawName:"v-loading",value:t.tableLoading,expression:"tableLoading"}],ref:"selectTable",attrs:{data:t.tableData,colConfigs:t.setTableConfigs.titleList,showCheckBox:!0,showIndex:t.setTableConfigs.showIndex,pageData:t.pageData,currentpage:t.currentpage,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.dataBridge}})],1),t._v(" "),a("div",{staticStyle:{height:"11px"}}),t._v(" "),a("div",{ref:"resultBox",staticStyle:{position:"relative"},style:t.setTablesHeight},[a("div",{staticStyle:{height:"100%"},style:{paddingBottom:t.btnsBoxHeight+"px"}},[a("base-table",{ref:"resultTable",attrs:{data:t.setResultTableData,colConfigs:t.setResultTableConfigs,showCheckBox:!1,showIndex:t.setTableConfigs.showIndex,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{databridge:t.resultDataBridge}})],1),t._v(" "),a("div",{ref:"btnsBox",staticStyle:{position:"absolute",bottom:"0",right:"0"}},[t.btnList.length?[t._l(t.btnList,function(e,i){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],key:i,attrs:{name:e.name,icon:e.icon,plain:e.plain,state:t.setResultBtnState(e)},on:{myclick:e.method}})]})]:t._e()],2)])])},[],!1,null,"d9fe0b9e",null);c.options.__file="index.vue";e.a=c.exports},map8:function(t,e,a){},q2Tj:function(t,e,a){}}]);