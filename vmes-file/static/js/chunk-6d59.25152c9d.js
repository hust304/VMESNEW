(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-6d59"],{"8ptq":function(e,t,a){"use strict";a.r(t);a("Oyvg");var i=a("WIyV"),_=a("CK78"),r={components:{customBaseTable:i.a},props:["initData","visible"],data:function(){return{receiptType:"1",productUnit:{},rowData:{},rules:{},openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],rowTableList:[],configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},apiObj:{apiName:"listPageSaleInvoiceDetail",params:{pageNo:1,fieldCode:"",parentId:""}},customColumn:[{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"sum",_cellConfig:{hideTitle:!0,compute:"self@count(*)self@productPrice"}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.temp=this.initData.temp,null!=this.initData.temp.receiptType&&this.initData.temp.receiptType.trim().length>0&&(this.receiptType=this.initData.temp.receiptType.trim()),null!=this.initData.temp.id&&this.initData.temp.id.trim().length>0&&(this.apiObj.params.parentId=this.initData.temp.id.trim())},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){Array.isArray(e)&&(this.rowTableList=[],this.rowTableList=e,this.saveSaleOrder(this.rowTableList))},save:function(){this.$refs.orderAddByInvoiceDialog.getData()},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkColumn:function(e){for(var t="",a=0;a<e.length;a++){var i=e[a].count;null!=i&&0!=i.trim().length||(t=t+"第 "+(a+1)+" 行: 开票数量为空或空字符串！"),null!=i&&i.trim().length>0&&!this.isNumberByValue(i.trim())&&(t=t+"第 "+(index+1)+" 行: 开票数量("+i+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return t},saveSaleOrder:function(e){var t=this,a=this.checkColumn(e);if(null!=a&&a.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:a});else{for(var i=[],r=0;r<e.length;r++){var n=e[r];i.push(n)}this.temp.dtlJsonStr="",null!=i&&i.length>0&&(this.temp.dtlJsonStr=JSON.stringify(i)),this.dialogLoading=!0,Object(_.updateSaleInvoice)(this.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},n=a("KHd+"),o=Object(n.a)(r,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[a("el-row",{staticStyle:{margin:"10px 50px"}},[a("el-radio-group",{model:{value:e.receiptType,callback:function(t){e.receiptType=t},expression:"receiptType"}},[a("el-radio",{attrs:{label:"1"}},[e._v("不开票")]),e._v(" "),a("el-radio",{attrs:{label:"2"}},[e._v("增值税普通发票")]),e._v(" "),a("el-radio",{attrs:{label:"3"}},[e._v("增值税专用发票")])],1)],1),e._v(" "),a("div",{staticStyle:{"padding-left":"50px"}},[a("p",[a("a",[e._v("公司名称:")]),e._v(e._s(e.temp.custInvoiceCompanyName))]),e._v(" "),a("p",[a("a",[e._v("发票税号:")]),e._v(e._s(e.temp.custInvoiceNumber))]),e._v(" "),a("p",[a("a",[e._v("地址:")]),e._v(e._s(e.temp.custInvoiceAddress))]),e._v(" "),a("p",[a("a",[e._v("电话:")]),e._v(e._s(e.temp.custInvoiceMobile))]),e._v(" "),a("p",[a("a",[e._v("开户银行:")]),e._v(e._s(e.temp.custInvoiceBankName))]),e._v(" "),a("p",[a("a",[e._v("银行账号:")]),e._v(e._s(e.temp.custInvoiceBankCode))])]),e._v(" "),a("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[a("custom-base-table",{ref:"orderAddByInvoiceDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"orderAddByInvoiceDialog",useDefaultBtn:!0,showAll:!1},on:{databridge:e.databridge}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);o.options.__file="dialogEdit.vue";t.default=o.exports},F9dT:function(module,__webpack_exports__,__webpack_require__){"use strict";__webpack_require__.d(__webpack_exports__,"a",function(){return createRules}),__webpack_require__.d(__webpack_exports__,"c",function(){return searchVal}),__webpack_require__.d(__webpack_exports__,"b",function(){return getVal});var core_js_modules_es6_regexp_replace__WEBPACK_IMPORTED_MODULE_0__=__webpack_require__("pIFo"),core_js_modules_es6_regexp_replace__WEBPACK_IMPORTED_MODULE_0___default=__webpack_require__.n(core_js_modules_es6_regexp_replace__WEBPACK_IMPORTED_MODULE_0__),core_js_modules_es6_regexp_match__WEBPACK_IMPORTED_MODULE_1__=__webpack_require__("SRfc"),core_js_modules_es6_regexp_match__WEBPACK_IMPORTED_MODULE_1___default=__webpack_require__.n(core_js_modules_es6_regexp_match__WEBPACK_IMPORTED_MODULE_1__),core_js_modules_es6_regexp_split__WEBPACK_IMPORTED_MODULE_2__=__webpack_require__("KKXr"),core_js_modules_es6_regexp_split__WEBPACK_IMPORTED_MODULE_2___default=__webpack_require__.n(core_js_modules_es6_regexp_split__WEBPACK_IMPORTED_MODULE_2__),core_js_modules_es6_array_find_index__WEBPACK_IMPORTED_MODULE_3__=__webpack_require__("INYr"),core_js_modules_es6_array_find_index__WEBPACK_IMPORTED_MODULE_3___default=__webpack_require__.n(core_js_modules_es6_array_find_index__WEBPACK_IMPORTED_MODULE_3__),core_js_modules_web_dom_iterable__WEBPACK_IMPORTED_MODULE_4__=__webpack_require__("rGqo"),core_js_modules_web_dom_iterable__WEBPACK_IMPORTED_MODULE_4___default=__webpack_require__.n(core_js_modules_web_dom_iterable__WEBPACK_IMPORTED_MODULE_4__),_validate__WEBPACK_IMPORTED_MODULE_5__=__webpack_require__("Yfch"),_dateTools__WEBPACK_IMPORTED_MODULE_6__=__webpack_require__("TB3a"),rulesG=function(){return function(e,t,a){var i,_,r;t?(_=t-0,i=!0,r=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,a){a<e.ops.length-1&&(r?Object(_validate__WEBPACK_IMPORTED_MODULE_5__.b)(t-0)?(!Object(_validate__WEBPACK_IMPORTED_MODULE_5__.b)(_)||t-0>_)&&(i=!1):t-0>_&&(i=!1):Object(_validate__WEBPACK_IMPORTED_MODULE_5__.b)(t-0)?(!Object(_validate__WEBPACK_IMPORTED_MODULE_5__.b)(_)||t-0>=_)&&(i=!1):t-0>=_&&(i=!1))}),i?a():a(new Error(e.message))):a(new Error("不能为空"))}},rulesL=function(){return function(e,t,a){var i,_,r;t?(_=t-0,i=!0,r=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,a){a<e.ops.length-1&&(r?Object(_validate__WEBPACK_IMPORTED_MODULE_5__.b)(t-0)?(!Object(_validate__WEBPACK_IMPORTED_MODULE_5__.b)(_-0)||_>t-0)&&(i=!1):_>t-0&&(i=!1):Object(_validate__WEBPACK_IMPORTED_MODULE_5__.b)(t-0)?(!Object(_validate__WEBPACK_IMPORTED_MODULE_5__.b)(_-0)||_>=t-0)&&(i=!1):_>=t-0&&(i=!1))}),i?a():a(new Error(e.message))):a(new Error("不能为空"))}};function createRules(e,t,a,i,_,r,n,o,s,l,c){var u,p,d,m,g;return e&&(u=searchVal(e.greaterThan,_,r,s,!0,l)),m=o.findIndex(function(e){return e.greaterThan}),t&&(p=searchVal(t.lessThan,_,r,s,!1,l)),g=o.findIndex(function(e){return e.lessThan}),d=[],u&&d.push({validator:rulesG(),trigger:"blur",message:n[c||m],ops:u}),p&&d.push({validator:rulesL(),trigger:"blur",message:n[c||g],ops:p}),d}function searchVal(e,t,a,i,_,r){var n;"boolean"==typeof(e=JSON.parse(JSON.stringify(e)))[e.length-1]&&(n=e.pop());var o=e.map(function(e){return""});return e.forEach(function(e,n){var s=e.split(/\([\\+|\-|\\*|\\/]\)/);if(s.length>1)o.splice(n,1,getVal(s,t,a,i,e,r));else if(-1!==e.indexOf("@")){var l=e.split("@");2===l.length&&"self"===l[0]&&o.splice(n,1,t[l[1]]),2===l.length&&"parent"===l[0]&&o.splice(n,1,a[0][l[1]]),2===l.length&&"tempData"===l[0]&&o.splice(n,1,r[l[1]]),2===l.length&&"sibling"===l[0]&&o.splice(n,1,getSiblingSum(l[1],i,t,!1,_)),3===l.length&&"parent"===l[0]&&o.splice(n,1,JSON.parse(JSON.stringify(a)).reverse()[l[1]-1][l[2]])}else o.splice(n,1,e)}),"boolean"==typeof n?o.push(n):o.push(!0),o}function getVal(list,row,rowChain,siblingList,baseStr,tempData){var valList=list.map(function(e){return""});list.forEach(function(e,t){var a=e.split("@"),i=0;if(2===a.length)switch(a[0]){case"self":i=row[a[1]];break;case"parent":i=rowChain[rowChain.length-1][a[1]];break;case"tempData":i=tempData[a[1]];break;case"sibling":i=getSiblingSum(a[1],siblingList,row,!0)}else 3===a.length?i=JSON.parse(JSON.stringify(rowChain)).reverse()[a[1]-1][a[2]]:1===a.length&&(i=a[0]-0);valList.splice(t,1,i||0)});var operatorList=baseStr.match(/\([\\+|\-|\\*|\\/]\)/g).map(function(e){return e.replace(/\(|\)/g,"")}),tempStr="",dataType=checkType(valList[0]);return"number"===dataType?valList.forEach(function(e,t){operatorList[t]?tempStr+=e+operatorList[t]:tempStr+=e}):"date"===dataType&&valList.forEach(function(e,t){var a=_dateTools__WEBPACK_IMPORTED_MODULE_6__.a.timeStamp(e);operatorList[t]?tempStr+=a+operatorList[t]:tempStr+=a}),eval(tempStr)}function checkType(e){return Object(_validate__WEBPACK_IMPORTED_MODULE_5__.a)(e)?"number":"string"==typeof e&&/^[0-9]{4}\-[0-9]{2}\-[0-9]{2}/.test(e)?"date":void 0}function getSiblingSum(e,t,a,i,_){var r=[],n=0,o=t.findIndex(function(e){return e.id===a.id});return t.forEach(function(t,a){o!==a&&r.push(t[e])}),i?r.forEach(function(e){n+=e-0}):n=_?Math.min.apply(Math,r):Math.max.apply(Math,r),n}},TB3a:function(e,t,a){"use strict";a("a1Th"),a("SRfc"),a("KKXr");t.a={timeStamp:function(e){if("string"==typeof e){var t=e.split(" ");if(1===t.length){var a=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);return null===a?(new Date).getTime():new Date(a[1],a[3]-1,a[4]).getTime()}var i=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/),_=t[1].match(/^(\d{1,2})(-|\:)(\d{1,2})\2(\d{1,2})$/);return i&&_?new Date(i[1],i[3]-1,i[4],_[1],_[3],_[4]).getTime():(new Date).getTime()}return"number"==typeof e?864e5*e:(new Date).getTime()},formatDate:function(e,t){var a=e?new Date(e):new Date,i=a.getFullYear(),_=a.getMonth()+1,r=a.getDate(),n=a.getHours(),o=a.getMinutes(),s=a.getSeconds(),l=function(e){return(e=e.toString())[1]?e:"0"+e};return[i,_,r].map(l).join(t||"-")+" "+[n,o,s].map(l).join(":")}}},yO6P:function(e,t,a){"use strict";var i=a("YP4+"),_={};_[i.a.code]="^[A-Za-z0-9]{placeholder}$",_[i.a.number]="\\d{placeholder}$",_[i.a.date]="^[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}$",_[i.a.time]="^([0-2][0-9]\\:[0-5][0-9]\\:[0-5][0-9])|([0-2][0-9]\\:[0-5][0-9])$",_[i.a.mobile]="^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$",_[i.a.email]="[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?",_[i.a.url]="[a-zA-z]+:\\/\\/[^\\s]*",_[i.a.zh]="^[一-龥]{placeholder}$",_[i.a.en]="^[A-Za-z]{placeholder}$",_[i.a.identity]="^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X|x)$",_[i.a.float]="^(-?\\d+\\.\\d+)?$",_[i.a.int]="^-?\\d+$",t.a=_}}]);