(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4e55"],{"50Ol":function(e,t,a){"use strict";a("rGqo"),a("KKXr"),a("91GP");var i={name:"custom-summary-option",props:{customSummary:{type:Object,default:function(){return{}}},tableData:{type:Array,default:function(){return[]}},tempData:{type:Object,default:function(){return{}}}},data:function(){return{boxDefaultStyle:{width:"600px",float:"left"},data:{}}},directives:{"send-height":{inserted:function(e,t,a){a.context.$emit("send-height",e.clientHeight)}}},computed:{setStyle:function(){return this.customSummary.boxStyle||this.boxDefaultStyle},setData:function(){return this.customSummary.computes&&this.createFormula(this.customSummary.computes,this.tableData,this.tempData),this.data}},created:function(){this.data=this.customSummary.data,this.customSummary.apiObj&&this.customSummary.apiObj.apiName&&this.httpRequests()},mounted:function(){},methods:{httpRequests:function(){var e=this;try{this.$api[this.customSummary.apiObj.apiName](Object.assign({},this.customSummary.apiObj.params)).then(function(t){t.result&&e.assignmentFn(t.result)}).catch(function(e){})}catch(e){}},assignmentFn:function(e){for(var t in this.data)this.data.hasOwnProperty(t)&&(this.data[t]=e[t])},createFormula:function(e,t,a){for(var i in e)if(e.hasOwnProperty(i)){var s=e[i].split(/\([\\+|\-|\\*|\\/]\)/);if(s.length>1)s.forEach(function(e){});else{var o=e[i].split("@");"table"===o[0]&&(this.data[i]=this.getSum(o[1],t))}}},getSum:function(e,t){var a=0;return t.forEach(function(t){a+=t[e]-0}),a},customSummaryValue:function(e){this.$emit("custom-summary-value",e)}}},s=(a("MtNS"),a("KHd+")),o=Object(s.a)(i,function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"customSummaryOption clearfix"},[t(this.customSummary.component,{directives:[{name:"send-height",rawName:"v-send-height"}],tag:"component",attrs:{data:this.setData,tempData:this.tempData,setStyle:this.customSummary.boxStyle},on:{"custom-summary-value":this.customSummaryValue}})],1)},[],!1,null,null,null);o.options.__file="index.vue";t.a=o.exports},"7MTH":function(e,t,a){"use strict";a.r(t);a("f3/d");var i=a("sNnr"),s=a("2+ib"),o=(a("z0WU"),{components:{multilevelTable:s.a},name:"dialog-add",props:["initData","visible"],data:function(){var e=this;return{rules:{typeName:[{required:!0,trigger:"change",validator:function(t,a,i){e.typeData.defaultSelected.length<=0?i(new Error("请选择出库类型")):i()}}],warehouseName:[{required:!0,trigger:"change",message:"请选择仓库"}],deptName:[{required:!0,message:"请选择接收单位",trigger:"change"}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{type:"",typeName:"",warehouseId:"",warehouseName:"",deptId:"",deptName:"",makeId:"",makeName:"",dtlJsonStr:""},tempLable:{},tableData:[],selectList:[],configs:{topBarBtnList:[]},tableConfigList:[{customColumn:[{columnIndex:"arrivingCount",width:150,componentName:"input",_cellConfig:{rules:[{lessThan:["self@count(-)self@arriveCount",!0]}],message:["须小于自定义的count","出库数量总和须小于等于自定义count"]}}],apiObj:{apiName:"listPagePurchaseOrderDetails",params:{parentId:this.initData.temp.id,queryStr:" detail.count > detail.arrive_count ",fieldCode:"productCode,productName,spec,genre,unit,count,arriveCount,arrivingCount,remark"}},tempData:{},showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!1,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],typeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"warehouseInType",isglobal:"1",id:"d78ceba5beef41f5be16f0ceee775399"}},defaultSelected:["d78ceba5beef41f5be16f0ceee775399"]},WarehouseDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择仓库",tableUrl:"/warehouse/warehouseBase/listPageWarehouse",tableParm:{nodeId:"2d75e49bcb9911e884ad00163e105f05",queryStr:"a.layer = 2 and a.isdisable = '1' "},temp:{}},dialogName:"dialogOption"}},DeptDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择接收单位",tableUrl:"/base/departmentCustomer/listPageDepartmentCustomer",tableParm:{type:"4"},temp:{}},dialogName:"dialogOption"}},MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择制单人",tableUrl:"/system/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}}}},created:function(){var e=this.$storage.get("userInfo");this.temp.makeId=e.userId,this.temp.makeName=e.userName},mounted:function(){this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},save:function(){this.getData(),this.signPurchaseOrder()},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},databridge:function(e){this.selectList=e},dialogClose:function(e){this.$emit("close-dialog",e||{})},typeSelect:function(e){this.DeptDialog.dialog.data.tableUrl="/base/departmentCustomer/listPageDepartmentCustomer",this.DeptDialog.dialog.data.tableParm={type:"4"},this.temp.deptId=null,this.temp.deptName=null},warehouseSelect:function(e){e[0]&&(this.temp.warehouseId=e[0].id,this.temp.warehouseName=e[0].name)},deptSelect:function(e){e[0]&&(this.temp.deptId=e[0].id,this.temp.deptName=e[0].name)},makeSelect:function(e){e[0]&&(this.temp.makeId=e[0].id,this.temp.makeName=e[0].name)},closeDialog:function(e){this.showDialog=!1;null!=e.selectList&&e.selectList},signPurchaseOrder:function(){var e=this,t="";if(null!=this.selectList&&0!=this.selectList.length){for(var a=[],s=0;s<this.selectList.length;s++){var o=this.selectList[s],r={productId:"",count:"",remark:"",orderDetailId:""};r.productId=o.productId,r.count=o.arrivingCount,r.remark=o.remark,r.orderDetailId=o.id,a.push(r)}t=JSON.stringify(a),this.temp.dtlJsonStr=t,null!=this.temp.type&&0!=this.temp.type.trim().length||(this.temp.type=this.typeData.defaultSelected[0]),this.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(i.signPurchaseOrder)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1}))})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})}},watch:{}}),r=(a("a2Z7"),a("KHd+")),n=Object(r.a)(o,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1300px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog,"table-selected":e.tableSelected}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"90px"}},[a("el-row",[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"入库类型:",prop:"typeName"}},[a("base-input-select",{attrs:{data:e.typeData.data},on:{callback:e.typeSelect},model:{value:e.typeData.defaultSelected,callback:function(t){e.$set(e.typeData,"defaultSelected",t)},expression:"typeData.defaultSelected"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"仓库:",prop:"warehouseName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.WarehouseDialog.dialog},on:{callback:e.warehouseSelect},model:{value:e.temp.warehouseName,callback:function(t){e.$set(e.temp,"warehouseName",t)},expression:"temp.warehouseName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"来源单位:",prop:"deptName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.DeptDialog.dialog},on:{callback:e.deptSelect},model:{value:e.temp.deptName,callback:function(t){e.$set(e.temp,"deptName",t)},expression:"temp.deptName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.MakeDialog.dialog},on:{callback:e.makeSelect},model:{value:e.temp.makeName,callback:function(t){e.$set(e.temp,"makeName",t)},expression:"temp.makeName"}})],1)],1)],1),e._v(" "),a("el-row",{staticClass:"tableContent",staticStyle:{height:"500px",width:"96%","margin-left":"2%"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{databridge:e.databridge}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);n.options.__file="dialogSign.vue";t.default=n.exports},DKCI:function(e,t,a){"use strict";a("rGqo"),a("INYr");var i={name:"table-filter",props:{headerList:{type:Array,default:function(){return[]}},showAll:{type:Boolean,default:!1},storeId:{type:String,default:""},componentId:{type:String,default:""}},directives:{"auto-width":{inserted:function(e,t,a){a.context.widthList[t.value]=e.clientWidth}}},data:function(){return{checkList:[],widthSwitch:!1,checkViewWidth:0,checkViewHeight:0,checkViewWidthTimer:"",widthList:[],userConfig:"",storeKey:"",userId:"",localStoreKey:"",useStore:!1,tempList:""}},created:function(){this.storeKey="tableFilter"+this.storeId,this.userId=this.$storage.get("userInfo").userId||"",this.tempList=this.localStore(this.componentId,this.storeKey,this.userId),this.$emit("checked-list",this.tempList)},computed:{setHeight:function(){return this.checkViewHeight&&this.widthSwitch?(this.$emit("checked-height",this.checkViewHeight),this.checkViewHeight):(this.$emit("checked-height",20),20)},setHeaderList:function(){var e=this;return this.headerList.filter(function(t){return e.showAll?t:!t.component})}},methods:{checkedList:function(e){localStorage.setItem(this.localStoreKey,JSON.stringify(e)),this.$emit("checked-list",e)},viewSwitch:function(){this.widthSwitch=!this.widthSwitch},localStore:function(e,t,a){return this.localStoreKey="_"+e+t+a,JSON.parse(localStorage.getItem(this.localStoreKey))||""},setChecked:function(e){return!this.tempList||!Array.isArray(this.tempList)||this.tempList.findIndex(function(t){return t===e.label})>-1}},watch:{widthSwitch:function(){var e=this;this.widthSwitch&&!this.checkViewHeight&&(clearTimeout(this.checkViewWidthTimer),this.checkViewWidthTimer=setTimeout(function(t){var a=0;e.widthList.forEach(function(e){e-0&&(a+=e+15)}),e.checkViewHeight=20*Math.ceil(a/e.$refs.checkBoxView.clientWidth)},200))}}},s=(a("DlFo"),a("KHd+")),o=Object(s.a)(i,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"tableFilter",style:{height:e.setHeight+"px"}},[a("div",{staticClass:"msg",attrs:{title:"列开关"},on:{click:e.viewSwitch}},[a("svg-icon",{attrs:{"icon-class":"tableSetting"}})],1),e._v(" "),a("div",{ref:"checkBoxView",staticClass:"checkView",class:{setWidth:e.widthSwitch}},[a("div",{staticStyle:{position:"relative"}},[a("div",{staticStyle:{position:"absolute",top:"0",left:"0"}},[a("el-checkbox-group",{attrs:{size:"mini"},on:{change:e.checkedList},model:{value:e.checkList,callback:function(t){e.checkList=t},expression:"checkList"}},e._l(e.setHeaderList,function(t,i){return a("el-checkbox",{directives:[{name:"auto-width",rawName:"v-auto-width",value:i,expression:"index"}],key:t.prop,attrs:{label:t.label,checked:e.setChecked(t)}})}),1)],1)])])])},[],!1,null,"2ad1a997",null);o.options.__file="index.vue";t.a=o.exports},DlFo:function(e,t,a){"use strict";var i=a("kjwg");a.n(i).a},F9dT:function(module,__webpack_exports__,__webpack_require__){"use strict";__webpack_require__.d(__webpack_exports__,"a",function(){return createRules}),__webpack_require__.d(__webpack_exports__,"c",function(){return searchVal}),__webpack_require__.d(__webpack_exports__,"b",function(){return getVal});var core_js_modules_es6_regexp_replace__WEBPACK_IMPORTED_MODULE_0__=__webpack_require__("pIFo"),core_js_modules_es6_regexp_replace__WEBPACK_IMPORTED_MODULE_0___default=__webpack_require__.n(core_js_modules_es6_regexp_replace__WEBPACK_IMPORTED_MODULE_0__),core_js_modules_es6_regexp_match__WEBPACK_IMPORTED_MODULE_1__=__webpack_require__("SRfc"),core_js_modules_es6_regexp_match__WEBPACK_IMPORTED_MODULE_1___default=__webpack_require__.n(core_js_modules_es6_regexp_match__WEBPACK_IMPORTED_MODULE_1__),core_js_modules_es6_regexp_split__WEBPACK_IMPORTED_MODULE_2__=__webpack_require__("KKXr"),core_js_modules_es6_regexp_split__WEBPACK_IMPORTED_MODULE_2___default=__webpack_require__.n(core_js_modules_es6_regexp_split__WEBPACK_IMPORTED_MODULE_2__),core_js_modules_es6_array_find_index__WEBPACK_IMPORTED_MODULE_3__=__webpack_require__("INYr"),core_js_modules_es6_array_find_index__WEBPACK_IMPORTED_MODULE_3___default=__webpack_require__.n(core_js_modules_es6_array_find_index__WEBPACK_IMPORTED_MODULE_3__),core_js_modules_web_dom_iterable__WEBPACK_IMPORTED_MODULE_4__=__webpack_require__("rGqo"),core_js_modules_web_dom_iterable__WEBPACK_IMPORTED_MODULE_4___default=__webpack_require__.n(core_js_modules_web_dom_iterable__WEBPACK_IMPORTED_MODULE_4__),_validate__WEBPACK_IMPORTED_MODULE_5__=__webpack_require__("Yfch"),_dateTools__WEBPACK_IMPORTED_MODULE_6__=__webpack_require__("TB3a"),_constant__WEBPACK_IMPORTED_MODULE_7__=__webpack_require__("YP4+"),rulesG=function(){return function(e,t,a){var i,s,o;t?(s=t-0,i=!0,o=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,a){a<e.ops.length-1&&(o?Object(_validate__WEBPACK_IMPORTED_MODULE_5__.a)(t-0)?(!Object(_validate__WEBPACK_IMPORTED_MODULE_5__.a)(s)||t-0>s)&&(i=!1):t-0>s&&(i=!1):Object(_validate__WEBPACK_IMPORTED_MODULE_5__.a)(t-0)?(!Object(_validate__WEBPACK_IMPORTED_MODULE_5__.a)(s)||t-0>=s)&&(i=!1):t-0>=s&&(i=!1))}),i?a():a(new Error(e.message))):a(new Error("不能为空"))}},rulesL=function(){return function(e,t,a){var i,s,o;t?(s=t-0,i=!0,o=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,a){a<e.ops.length-1&&(o?Object(_validate__WEBPACK_IMPORTED_MODULE_5__.a)(t-0)?(!Object(_validate__WEBPACK_IMPORTED_MODULE_5__.a)(s-0)||s>t-0)&&(i=!1):s>t-0&&(i=!1):Object(_validate__WEBPACK_IMPORTED_MODULE_5__.a)(t-0)?(!Object(_validate__WEBPACK_IMPORTED_MODULE_5__.a)(s-0)||s>=t-0)&&(i=!1):s>=t-0&&(i=!1))}),i?a():a(new Error(e.message))):a(new Error("不能为空"))}};function createRules(e,t,a,i,s,o,r,n,c,l,d){var u,_,p,m,h;return e&&(u=searchVal(e.greaterThan,s,o,c,!0,l)),m=n.findIndex(function(e){return e.greaterThan}),t&&(_=searchVal(t.lessThan,s,o,c,!1,l)),h=n.findIndex(function(e){return e.lessThan}),p=[],u&&p.push({validator:rulesG(),trigger:"blur",message:r[d||m],ops:u}),_&&p.push({validator:rulesL(),trigger:"blur",message:r[d||h],ops:_}),p}function searchVal(e,t,a,i,s,o){var r;"boolean"==typeof(e=JSON.parse(JSON.stringify(e)))[e.length-1]&&(r=e.pop());var n=e.map(function(e){return""});return e.forEach(function(e,r){var c=e.split(/\([\\+|\-|\\*|\\/]\)/);if(c.length>1)n.splice(r,1,getVal(c,t,a,i,e,o));else if(-1!==e.indexOf("@")){var l=e.split("@");2===l.length&&"self"===l[0]&&n.splice(r,1,t[l[1]]),2===l.length&&"parent"===l[0]&&n.splice(r,1,a[0][l[1]]),2===l.length&&"tempData"===l[0]&&n.splice(r,1,o[l[1]]),2===l.length&&"sibling"===l[0]&&n.splice(r,1,getSiblingSum(l[1],i,t,!1,s)),3===l.length&&"parent"===l[0]&&n.splice(r,1,JSON.parse(JSON.stringify(a)).reverse()[l[1]-1][l[2]])}else n.splice(r,1,e)}),"boolean"==typeof r?n.push(r):n.push(!0),n}function getVal(list,row,rowChain,siblingList,baseStr,tempData){var valList=list.map(function(e){return""});list.forEach(function(e,t){var a=e.split("@"),i=0;if(2===a.length)switch(a[0]){case"self":i=row[a[1]];break;case"parent":i=rowChain[rowChain.length-1][a[1]];break;case"tempData":i=tempData[a[1]];break;case"sibling":i=getSiblingSum(a[1],siblingList,row,!0)}else 3===a.length?i=JSON.parse(JSON.stringify(rowChain)).reverse()[a[1]-1][a[2]]:1===a.length&&(i=a[0]-0);valList.splice(t,1,i||0)});var operatorList=baseStr.match(/\([\\+|\-|\\*|\\/]\)/g).map(function(e){return e.replace(/\(|\)/g,"")}),tempStr="",dataType=checkType(valList[0]);return"number"===dataType?valList.forEach(function(e,t){operatorList[t]?tempStr+=e+operatorList[t]:tempStr+=e}):"date"===dataType&&valList.forEach(function(e,t){var a=_dateTools__WEBPACK_IMPORTED_MODULE_6__.a.timeStamp(e);operatorList[t]?tempStr+=a+operatorList[t]:tempStr+=a}),"number"===dataType?eval(tempStr).toFixed(_constant__WEBPACK_IMPORTED_MODULE_7__.a.precision)-0:eval(tempStr)}function checkType(e){return Object(_validate__WEBPACK_IMPORTED_MODULE_5__.a)(e)?"number":"string"==typeof e&&/^[0-9]{4}\-[0-9]{2}\-[0-9]{2}/.test(e)?"date":void 0}function getSiblingSum(e,t,a,i,s){var o=[],r=0,n=t.findIndex(function(e){return e.id===a.id});return t.forEach(function(t,a){n!==a&&o.push(t[e])}),i?o.forEach(function(e){r+=e-0}):r=s?Math.min.apply(Math,o):Math.max.apply(Math,o),r}},MtNS:function(e,t,a){"use strict";var i=a("Mugr");a.n(i).a},Mugr:function(e,t,a){},TB3a:function(e,t,a){"use strict";a("a1Th"),a("SRfc"),a("KKXr");t.a={timeStamp:function(e){if("string"==typeof e){var t=e.split(" ");if(1===t.length){var a=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);return null===a?(new Date).getTime():new Date(a[1],a[3]-1,a[4]).getTime()}var i=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/),s=t[1].match(/^(\d{1,2})(-|\:)(\d{1,2})\2(\d{1,2})$/);return i&&s?new Date(i[1],i[3]-1,i[4],s[1],s[3],s[4]).getTime():(new Date).getTime()}return"number"==typeof e?864e5*e:(new Date).getTime()},formatDate:function(e,t){var a=e?new Date(e):new Date,i=a.getFullYear(),s=a.getMonth()+1,o=a.getDate(),r=a.getHours(),n=a.getMinutes(),c=a.getSeconds(),l=function(e){return(e=e.toString())[1]?e:"0"+e};return[i,s,o].map(l).join(t||"-")+" "+[r,n,c].map(l).join(":")}}},a2Z7:function(e,t,a){"use strict";var i=a("stqV");a.n(i).a},kjwg:function(e,t,a){},mwzG:function(e,t,a){"use strict";t.a={code:0,msg:"执行成功!",result:{hideTitles:["id","productGenre","productUnit","parentId","warehouseId","productId","code","executeCount","state","cuser","uuser","remark","isdisable","qrcode","businessId"],pageData:{current:1,pages:"1",records:[],size:10,total:"1"},titles:[{progress:"进度"},{warehouseOutCode:"出库单编码"},{productCode:"货品编码"},{productName:"货品名称"},{productSpec:" 规格/型号"},{productGenreName:"货品属性"},{productUnitName:"计量单位"},{count:"出库数量"},{id:"id"},{productGenre:"货品属性ID"},{productUnit:"计量单位ID"},{parentId:"出库单ID"},{warehouseId:" (推荐)货位ID"},{productId:"产品ID"},{code:"批次号"},{executeCount:"已出库数量"},{state:"状态"},{cuser:"创建用户id"},{cdate:"创建时间"},{uuser:"修改用户id"},{udate:"修改时间"},{remark:"备注"},{isdisable:"是否启用"},{qrcode:"二维码"},{businessId:"业务id"}],varList:[{businessId:"",cdate:"3",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",isdisable1:"1",isdisable2:"0",isdisable3:"1",isdisable4:"1",name:"12",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.jpg",imgPath:"fileUpload/QRCode/product/1539142716704586.png",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",isdisable2:"1",isdisable3:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"219967d2f6704d868b11002caef9885c",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"2",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"111",productSpec:"22222222222222222222",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"55",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"3"},{businessId:"",cdate:"1",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"885c219967d2f6704d868b11002caef9",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"3",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2111111111111111111",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"2"}]}}},stqV:function(e,t,a){}}]);