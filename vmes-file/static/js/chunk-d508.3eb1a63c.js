(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-d508"],{"3d3b":function(t,e,i){"use strict";i("rE2o"),i("ioFf"),i("91GP"),i("pIFo");var a=i("f/WR"),s=i("uTIz");i("xMja");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{transferTable:a.a,searchBar:s.a},name:"productTableDialog",props:["initData","visible"],data:function(){return{fieldCode_default:"code,name,spec,unitName,genreName,stockCount,safetyCount,lockCount,productStockCount",fieldCode:"",isConfirm:!1,temp:{productIds:""},tempLable:{},rules:{},guid:"",tempQuery:{},searchList:[{label:"货品编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"spec",configs:{},placeholder:"请输入规格型号"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"unitName",configs:{},placeholder:"请输入计量单位"},{label:"货品属性",type:"select",ruleType:"string",mapKey:"genreName",configs:{clearable:!0,name:"",options:[{value:"成品",label:"成品"},{value:"原材料",label:"原材料"},{value:"辅料",label:"辅料"},{value:"半成品",label:"半成品"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!0,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},pageData:null,pageNo:1,btnList:[{name:"确定",isShow:!0,state:!0,method:this.toAddWarehouseIn},{name:"取消",state:!1,method:this.closeWin,isShow:!0}],apiData:{apiName:"listPageProducts",params:{}},tableSelectList:[],stateBtnData:{},tableConfigs:{showIndex:!0},tempList:[]}},created:function(){var t="";if(null!=this.initData.data&&this.initData.data.length>0)for(var e=0;e<this.initData.data.length;e++){var i=this.initData.data[e];null!=i.productId&&i.productId.trim().length>0&&(t=t+i.productId+",")}this.temp.productIds=t;var a="";null!=this.initData.queryStr&&(a=this.initData.queryStr);var s="";null==(s=null!=this.initData.fieldCode?this.initData.queryStr:this.fieldCode_default)||0==s.trim().length?this.fieldCode=this.fieldCode_default:null!=s&&s.trim().length>0&&(this.fieldCode=s.trim());var n="";n=null!=this.initData.orderStr?this.initData.queryStr:"prod.stock_count desc";var o=!0;null!=this.initData.isNeedRepeat&&(o=this.initData.isNeedRepeat),o||null!=t&&t.trim().length>0&&(a="prod.id not in ("+(t="'"+(t=t.substring(0,t.lastIndexOf(","))).replace(",","','")+"'")+")");var r="false";null!=this.initData.isNeedCustomerPrice&&this.initData.isNeedCustomerPrice&&(r="true");var l="";null!=this.initData.customerId&&this.initData.customerId.trim().length>0&&(l=this.initData.customerId.trim()),this.apiData.params={fieldCode:s,queryStr:a,orderStr:n,isNeedCustomerPrice:r,customerId:l,isdisable:"1"}},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{tableHeight:function(){},dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{sendGuid:function(t){this.guid=t},searchMap:function(t){this.apiData.params=Object.assign({},t),this.apiData.params.fieldCode=this.fieldCode},dialogOpen:function(){},closeWin:function(){this.isVisible=!1},dialogClose:function(t){this.$emit("close-dialog",t||{isConfirm:this.isConfirm,selectList:this.tempList})},toAddWarehouseIn:function(){this.isConfirm=!0,this.isVisible=!1},resetQuery:function(){this.$refs.trabsferTables.clearTableSelected()},tableSelected:function(t){this.tempList=t},closeDialog:function(t){this.showDialog=!1}}},r=i("KHd+"),l=Object(r.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"margin-top":"15px","margin-left":"10px"}},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{height:"500px"},style:{"margin-top":t.searchList.length?"10px":"0"}},[i("transfer-table",{ref:"trabsferTables",attrs:{tableConfigs:t.tableConfigs,btnList:t.btnList,stateBtn:t.stateBtnData,apiData:t.apiData},on:{"table-selected":t.tableSelected}})],1)],1)],1)},[],!1,null,null,null);l.options.__file="productTableDialog.vue";e.a=l.exports},"50Ol":function(t,e,i){"use strict";i("rGqo"),i("KKXr"),i("91GP");var a={name:"custom-summary-option",props:{customSummary:{type:Object,default:function(){return{}}},tableData:{type:Array,default:function(){return[]}},tempData:{type:Object,default:function(){return{}}}},data:function(){return{boxDefaultStyle:{width:"600px",float:"left"},data:{}}},directives:{"send-height":{inserted:function(t,e,i){i.context.$emit("send-height",t.clientHeight)}}},computed:{setStyle:function(){return this.customSummary.boxStyle||this.boxDefaultStyle},setData:function(){return this.customSummary.computes&&this.createFormula(this.customSummary.computes,this.tableData,this.tempData),this.data}},created:function(){this.data=this.customSummary.data,this.customSummary.apiObj&&this.customSummary.apiObj.apiName&&this.httpRequests()},mounted:function(){},methods:{httpRequests:function(){var t=this;try{this.$api[this.customSummary.apiObj.apiName](Object.assign({},this.customSummary.apiObj.params)).then(function(e){e.result&&t.assignmentFn(e.result)}).catch(function(t){console.log(t)})}catch(t){console.log(t)}},assignmentFn:function(t){for(var e in this.data)this.data.hasOwnProperty(e)&&(this.data[e]=t[e])},createFormula:function(t,e,i){for(var a in t)if(t.hasOwnProperty(a)){var s=t[a].split(/\([\\+|\-|\\*|\\/]\)/);if(s.length>1)s.forEach(function(t){});else{var n=t[a].split("@");"table"===n[0]&&(this.data[a]=this.getSum(n[1],e))}}},getSum:function(t,e){var i=0;return e.forEach(function(e){i+=e[t]-0}),i},customSummaryValue:function(t){this.$emit("custom-summary-value",t)}}},s=(i("MtNS"),i("KHd+")),n=Object(s.a)(a,function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"customSummaryOption clearfix"},[e(this.customSummary.component,{directives:[{name:"send-height",rawName:"v-send-height"}],tag:"component",attrs:{data:this.setData,tempData:this.tempData,setStyle:this.customSummary.boxStyle},on:{"custom-summary-value":this.customSummaryValue}})],1)},[],!1,null,null,null);n.options.__file="index.vue";e.a=n.exports},ADOs:function(t,e,i){"use strict";var a=i("S4Mt");i.n(a).a},DKCI:function(t,e,i){"use strict";i("rGqo"),i("INYr");var a={name:"table-filter",props:{headerList:{type:Array,default:function(){return[]}},showAll:{type:Boolean,default:!1},storeId:{type:String,default:""},componentId:{type:String,default:""}},directives:{"auto-width":{inserted:function(t,e,i){i.context.widthList[e.value]=t.clientWidth}}},data:function(){return{checkList:[],widthSwitch:!1,checkViewWidth:0,checkViewHeight:0,checkViewWidthTimer:"",widthList:[],userConfig:"",storeKey:"",userId:"",localStoreKey:"",useStore:!1,tempList:""}},created:function(){this.storeKey="tableFilter"+this.storeId,this.userId=this.$storage.get("userInfo").userId||"",this.tempList=this.localStore(this.componentId,this.storeKey,this.userId),this.$emit("checked-list",this.tempList)},computed:{setHeight:function(){return this.checkViewHeight&&this.widthSwitch?(this.$emit("checked-height",this.checkViewHeight),this.checkViewHeight):(this.$emit("checked-height",20),20)},setHeaderList:function(){var t=this;return this.headerList.filter(function(e){return t.showAll?e:!e.component})}},methods:{checkedList:function(t){localStorage.setItem(this.localStoreKey,JSON.stringify(t)),this.$emit("checked-list",t)},viewSwitch:function(){this.widthSwitch=!this.widthSwitch},localStore:function(t,e,i){return this.localStoreKey="_"+t+e+i,JSON.parse(localStorage.getItem(this.localStoreKey))||""},setChecked:function(t){return!this.tempList||!Array.isArray(this.tempList)||this.tempList.findIndex(function(e){return e===t.label})>-1}},watch:{widthSwitch:function(){var t=this;this.widthSwitch&&!this.checkViewHeight&&(clearTimeout(this.checkViewWidthTimer),this.checkViewWidthTimer=setTimeout(function(e){var i=0;t.widthList.forEach(function(t){t-0&&(i+=t+15)}),t.checkViewHeight=20*Math.ceil(i/t.$refs.checkBoxView.clientWidth)},200))}}},s=(i("DlFo"),i("KHd+")),n=Object(s.a)(a,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"tableFilter",style:{height:t.setHeight+"px"}},[i("div",{staticClass:"msg",attrs:{title:"列开关"},on:{click:t.viewSwitch}},[i("svg-icon",{attrs:{"icon-class":"tableSetting"}})],1),t._v(" "),i("div",{ref:"checkBoxView",staticClass:"checkView",class:{setWidth:t.widthSwitch}},[i("div",{staticStyle:{position:"relative"}},[i("div",{staticStyle:{position:"absolute",top:"0",left:"0"}},[i("el-checkbox-group",{attrs:{size:"mini"},on:{change:t.checkedList},model:{value:t.checkList,callback:function(e){t.checkList=e},expression:"checkList"}},t._l(t.setHeaderList,function(e,a){return i("el-checkbox",{directives:[{name:"auto-width",rawName:"v-auto-width",value:a,expression:"index"}],key:e.prop,attrs:{label:e.label,checked:t.setChecked(e)}})}),1)],1)])])])},[],!1,null,"2ad1a997",null);n.options.__file="index.vue";e.a=n.exports},DlFo:function(t,e,i){"use strict";var a=i("kjwg");i.n(a).a},F9dT:function(t,e,i){"use strict";i.d(e,"a",function(){return c}),i.d(e,"c",function(){return u}),i.d(e,"b",function(){return d});i("pIFo"),i("SRfc"),i("KKXr"),i("INYr"),i("rGqo");var a=i("Yfch"),s=i("TB3a"),n=i("YP4+"),o=i("z0WU"),r=function(){return function(t,e,i){var s,n,o;e?(n=e-0,s=!0,o=t.ops[t.ops.length-1],t.ops&&t.ops.length&&t.ops.forEach(function(e,i){i<t.ops.length-1&&(o?Object(a.a)(e-0)?(!Object(a.a)(n)||e-0>n)&&(s=!1):e-0>n&&(s=!1):Object(a.a)(e-0)?(!Object(a.a)(n)||e-0>=n)&&(s=!1):e-0>=n&&(s=!1))}),s?i():i(new Error(t.message))):i(new Error("不能为空"))}},l=function(){return function(t,e,i){var s,n,o;e?(n=e-0,s=!0,o=t.ops[t.ops.length-1],t.ops&&t.ops.length&&t.ops.forEach(function(e,i){i<t.ops.length-1&&(o?Object(a.a)(e-0)?(!Object(a.a)(n-0)||n>e-0)&&(s=!1):n>e-0&&(s=!1):Object(a.a)(e-0)?(!Object(a.a)(n-0)||n>=e-0)&&(s=!1):n>=e-0&&(s=!1))}),s?i():i(new Error(t.message))):i(new Error("不能为空"))}};function c(t,e,i,a,s,n,o,c,d,h,p){var m,f,b,g,y;return t&&(m=u(t.greaterThan,s,n,d,!0,h)),g=c.findIndex(function(t){return t.greaterThan}),e&&(f=u(e.lessThan,s,n,d,!1,h)),y=c.findIndex(function(t){return t.lessThan}),b=[],m&&b.push({validator:r(),trigger:"blur",message:o[p||g],ops:m}),f&&b.push({validator:l(),trigger:"blur",message:o[p||y],ops:f}),b}function u(t,e,i,a,s,n,o){var r;"boolean"==typeof(t=JSON.parse(JSON.stringify(t)))[t.length-1]&&(r=t.pop());var l=t.map(function(t){return""});return t.forEach(function(t,r){var c=t.split(/\([\\+|\-|\\*|\\/]\)/);if(c.length>1)l.splice(r,1,d(c,e,i,a,t,n,o));else if(-1!==t.indexOf("@")){var u=t.split("@");2===u.length&&"self"===u[0]&&l.splice(r,1,e[u[1]]),2===u.length&&"parent"===u[0]&&l.splice(r,1,i[0][u[1]]),2===u.length&&"tempData"===u[0]&&l.splice(r,1,n[u[1]]),2===u.length&&"sibling"===u[0]&&l.splice(r,1,h(u[1],a,e,!1,s)),3===u.length&&"parent"===u[0]&&l.splice(r,1,JSON.parse(JSON.stringify(i)).reverse()[u[1]-1][u[2]])}else l.splice(r,1,t)}),"boolean"==typeof r?l.push(r):l.push(!0),l}function d(t,e,i,r,l,c,u){var d=t.map(function(t){return""});t.forEach(function(t,a){var s=t.split("@"),n=0;if(2===s.length)switch(s[0]){case"self":n=e[s[1]];break;case"parent":n=i[i.length-1][s[1]];break;case"tempData":n=c[s[1]];break;case"sibling":n=h(s[1],r,e,!0)}else 3===s.length?n=JSON.parse(JSON.stringify(i)).reverse()[s[1]-1][s[2]]:1===s.length&&(n=s[0]-0);d.splice(a,1,n||0)});var p=l.match(/\([\\+|\-|\\*|\\/]\)/g).map(function(t){return t.replace(/\(|\)/g,"")}),m="",f=function(t){if(Object(a.a)(t))return"number";if("string"==typeof t&&/^[0-9]{4}\-[0-9]{2}\-[0-9]{2}/.test(t))return"date"}(d[0]);return"number"===f?(d.forEach(function(t,e){p[e]?m+=t+p[e]:m+=t}),parseFloat(Object(o.j)(m).toFixed(u||n.a.precision))):"date"===f?(d.forEach(function(t,e){var i=s.a.timeStamp(t);p[e]?m+=i+p[e]:m+=i}),s.a.formatDate(Object(o.j)(m))):0}function h(t,e,i,a,s){var n=[],o=0,r=e.findIndex(function(t){return t.id===i.id});return e.forEach(function(e,i){r!==i&&n.push(e[t])}),a?n.forEach(function(t){o+=t-0}):o=s?Math.min.apply(Math,n):Math.max.apply(Math,n),o}},IJLS:function(t,e,i){"use strict";var a=i("SeFu");i.n(a).a},MtNS:function(t,e,i){"use strict";var a=i("Mugr");i.n(a).a},Mugr:function(t,e,i){},QXqY:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("f3/d");var a=i("3d3b"),s=i("WIyV"),n=i("cTe8");i("QD6Y"),i("z0WU");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var r={components:{productTableDialog:a.a,customBaseTable:s.a},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{remark:"",makeId:"",makeName:"",dtlJsonStr:""},tempLable:{},tempQuery:{},tableData:[],tableList:[],rowData:{},selectList:null,configs:{topBarBtnList:[{name:"选择货品",nameEn:"add",isShow:!0,icon:"add",method:this.addProduct}]},apiObj:{apiName:"listPagePurchasePlanDetails",params:{pageNo:1,parentId:"null",fieldCode:"productCode,productName,spec,genre,unit,count,reason,edate,remark"}},customColumn:[{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"reason",componentName:"select",_cellConfig:{asyn:{apiName:"getDictionarys",params:{dictionaryKey:"purchaseReason",isglobal:"1"}},rules:[{required:!0}],outputData:!0}},{columnIndex:"edate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy-MM-dd",valueFormat:"yyyy-MM-dd",greaterThan:["tempData@minDate",!0]}},{columnIndex:"remark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{minDate:new Date},MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择制单人",tableUrl:"/system/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}}}},created:function(){this.$storage.get("userInfo");this.temp=this.initData.temp,this.apiObj.params.parentId=this.initData.temp.id},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(t){Array.isArray(t)?(this.tableList=[],this.tableList=t):(this.rowData=null,null!=t.row&&(this.rowData=t.row))},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},addProduct:function(){this.dialogData.data=this.tableList,this.dialogData.title="选择货品",this.openDialogName="productTableDialog",this.showDialog=!0,this.inLinVisible=!0},editPlan:function(){var t=this,e="";if(this.$refs.planAddDialog.getData(),null!=this.tableList&&0!=this.tableList.length){for(var i=[],a=0;a<this.tableList.length;a++){var s=this.tableList[a],o={productId:"",count:"",reason:"",edate:"",remark:"",id:""};o.productId=s.productId,o.count=s.count,o.remark=s.remark,o.edate=s.edate,s.reason.item?o.reason=s.reason.item.id:o.reason=s.reasonId,o.id=s.id,i.push(o)}e=JSON.stringify(i),this.temp.dtlJsonStr=e,this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(n.editPurchasePlan)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){}))})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})},makeSelect:function(t){t[0]&&(this.temp.makeId=t[0].id,this.temp.makeName=t[0].name)},closeDialog:function(t){this.showDialog=!1;var e=!1;null!=t.isConfirm&&(e=t.isConfirm);var i=[];null!=t.selectList&&(i=t.selectList),this.tableSelected(e,i)},tableSelected:function(t,e){if(t&&null!=e&&e.length>0)for(var i=0;i<e.length;i++){var a=e[i],s={productId:"",productCode:"",productName:"",spec:"",genre:"",unit:"",count:"",reason:"",edate:"",remark:"",id:""};s.productId=a.id.trim(),null!=a.code&&a.code.trim().length>0&&(s.productCode=a.code.trim()),null!=a.name&&a.name.trim().length>0&&(s.productName=a.name.trim()),null!=a.spec&&a.spec.trim().length>0&&(s.spec=a.spec.trim()),null!=a.genreName&&a.genreName.trim().length>0&&(s.genre=a.genreName.trim()),null!=a.unitName&&a.unitName.trim().length>0&&(s.unit=a.unitName.trim()),s.id=a.id.trim()||i,this.tableData.push(s)}}},watch:{}},l=(i("IJLS"),i("KHd+")),c=Object(l.a)(r,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1250px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog,"table-selected":t.tableSelected}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[i("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:t.MakeDialog.dialog},on:{callback:t.makeSelect},model:{value:t.temp.makeName,callback:function(e){t.$set(t.temp,"makeName",e)},expression:"temp.makeName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1),t._v(" "),i("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2),t._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[i("custom-base-table",{ref:"planAddDialog",attrs:{isSortable:!1,varList:t.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:t.customColumn,apiObj:t.apiObj,mergeTitle:t.mergeTitle,mergeColumn:t.mergeColumn,mergeRow:t.mergeRow,tempData:t.tempData,componentId:"planAddDialog",useDefaultBtn:!0,showAll:!1,keyMapping:t.keyMapping},on:{databridge:t.databridge}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.editPlan}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);c.options.__file="dialogEdit.vue";e.default=c.exports},S4Mt:function(t,e,i){},SeFu:function(t,e,i){},TB3a:function(t,e,i){"use strict";i("a1Th"),i("SRfc"),i("KKXr");e.a={timeStamp:function(t){if("string"==typeof t){var e=t.split(" ");if(1===e.length){var i=e[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);return null===i?(new Date).getTime():new Date(i[1],i[3]-1,i[4]).getTime()}var a=e[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/),s=e[1].match(/^(\d{1,2})(-|\:)(\d{1,2})\2(\d{1,2})$/);return a&&s?new Date(a[1],a[3]-1,a[4],s[1],s[3],s[4]).getTime():(new Date).getTime()}return"number"==typeof t?864e5*t:(new Date).getTime()},formatDate:function(t,e){var i=t?new Date(t):new Date,a=i.getFullYear(),s=i.getMonth()+1,n=i.getDate(),o=i.getHours(),r=i.getMinutes(),l=i.getSeconds(),c=function(t){return(t=t.toString())[1]?t:"0"+t};return[a,s,n].map(c).join(e||"-")+" "+[o,r,l].map(c).join(":")}}},"f/WR":function(t,e,i){"use strict";i("XfO3"),i("HEwt"),i("a1Th"),i("rE2o"),i("ioFf"),i("dRSK"),i("rGqo"),i("91GP");var a=i("z0WU"),s=i("Yfch");function n(t){return function(t){if(Array.isArray(t))return t}(t)||function(t){if(Symbol.iterator in Object(t)||"[object Arguments]"===Object.prototype.toString.call(t))return Array.from(t)}(t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}()}var o={props:["colConfig","fixed"],template:'<el-table-column :label="colConfig.label" :fixed="fixed" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t  <template v-for="(item, index) in colConfig.rowMethods">\n    \t\t\t\t\t    <el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="item.method(scope.row,scope.$index)" v-text="item.name"></el-button>\n                </template>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},r={components:{},name:"transfer-table",props:{tableConfigs:{type:Object,default:function(){return{}}},btnList:{type:Array,default:function(){return[]}},upTableBtnTemplate:{type:Array,default:function(){return[]}},downTableBtnTemplate:{type:Array,default:function(){return[]}},apiData:{type:Object,default:function(){return{}}},stateBtn:{type:Object,default:function(){return{}}}},data:function(){return{btnsBoxHeight:0,currentpage:1,tableLoading:!1,tableData:[],resultTableData:[],titleList:[],pageData:{},tableBtns:{columnIndex:"last",prop:"operate",label:"操作",component:o,rowMethods:[{name:"删除",method:this.deleteRow}]},rowKey:"",tempSelectList:[],stateBtnChecked:!1}},computed:{setTablesHeight:function(){return this.stateBtn.title?{height:"calc(50% - 15px)"}:{height:"calc(50% - 6px)"}},setResultBtnState:function(){var t=this;return function(e){return!t.resultTableData.length&&e.state}},setTableConfigs:function(){var t=n(this.titleList).slice(0);return{titleList:this.addTableTitle(t,this.upTableBtnTemplate),showIndex:void 0!==this.tableConfigs.showIndex&&this.tableConfigs.showIndex,isSingle:void 0!==this.tableConfigs.isSingle&&this.tableConfigs.isSingle,isSortable:void 0!==this.tableConfigs.isSortable&&this.tableConfigs.isSortable}},setResultTableConfigs:function(){var t=n(this.titleList).slice(0);return this.downTableBtnTemplate.length?this.addTableTitle(t,this.downTableBtnTemplate):this.addTableTitle(t,[this.tableBtns])},setResultTableData:function(){return[].concat(this.resultTableData)}},watch:{currentpage:function(){var t=Object.assign({},this.apiData.params);t.pageNo=this.currentpage,this.httpTableMethod(this.apiData.apiName,t)},setResultTableData:function(){this.$emit("table-selected",this.setResultTableData)},stateBtnChecked:function(){var t={};t[this.stateBtn.keyName?this.stateBtn.keyName:"isShow"]=this.stateBtnChecked,this.httpTableMethod(this.apiData.apiName,this.apiData.params,t)},"apiData.params":function(){console.log(this.apiData.params),this.httpTableMethod(this.apiData.apiName,this.apiData.params)}},created:function(){this.apiData.apiName?(this.httpTableMethod(this.apiData.apiName,this.apiData.params),this.rowKey=this.tableConfigs.rowKey||"id"):this.$message({message:"没有设置接口名",type:"error",duration:1e4})},mounted:function(){this.$nextTick(function(){this.btnsBoxHeight=this.$refs.btnsBox.clientHeight+5})},methods:{clearTableSelected:function(){var t=this;this.resultTableData=[],this.tempSelectList=[],this.tableData.forEach(function(e){t.$refs.selectTable.$refs.baseTable.clearSelection()})},httpTableMethod:function(t,e,i){var a=this;this.tableLoading=!0,this.$api[t](Object.assign({},e,i)).then(function(t){console.log(t),a.getListPage(t),a.tableLoading=!1}).catch(function(t){a.tableLoading=!1})},getListPage:function(t){var e=this;t&&(t.result.titles="string"==typeof t.result.titles?JSON.parse(t.result.titles):t.result.titles,t.result.varList="string"==typeof t.result.varList?JSON.parse(t.result.varList):t.result.varList,t.result.pageData="string"==typeof t.result.pageData?JSON.parse(t.result.pageData):t.result.pageData,this.titleList=Object(a.m)(t.result),this.pageData=t.result.pageData,this.tableData=t.result.varList||[],this.tempSelectList=[],this.$nextTick(function(t){e.toggleRowSelected()}))},toggleRowSelected:function(){var t=this;this.tableData.forEach(function(e){t.resultTableData.some(function(i){return e[t.rowKey]===i[t.rowKey]})?(t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!0),!t.tempSelectList.some(function(i){return i[t.rowKey]===e[t.rowKey]})&&t.tempSelectList.push(e)):t.$refs.selectTable&&t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!1)})},addTableTitle:function(t,e){return e&&e.length&&e.forEach(function(e){Object(s.a)(e.columnIndex)?t.splice(e.columnIndex,0,e):"first"===e.columnIndex?t.unshift(e):"last"===e.columnIndex?t.push(e):t.some(function(t){if(t.prop===e.columnIndex)return Object.assign(t,e),!0})}),t},dataBridge:function(t,e){this.getChecked(e,t)?this.addRowData(e):this.removeRowData(e)},resultDataBridge:function(t,e){console.log(t),console.log(e)},deleteRow:function(t,e){var i=this;console.log(t),console.log(e),this.resultTableData.find(function(e,a){if(t[i.rowKey]===e[i.rowKey])return i.resultTableData.splice(a,1),e}),this.toggleRowSelected()},updateView:function(t,e){this.resultTableData.splice(e-1,1,t)},getChecked:function(t,e){var i=this;return t?e.some(function(e){return t[i.rowKey]===e[i.rowKey]}):(e.length&&(this.tempSelectList=e),!!e.length)},addRowData:function(t){var e=this;t?!this.resultTableData.some(function(i){return t[e.rowKey]===i[e.rowKey]})&&this.resultTableData.push(t):this.addAllRowData()},addAllRowData:function(){var t=this;this.resultTableData.length?this.tempSelectList.forEach(function(e){t.addRowData(e)}):this.resultTableData=this.tempSelectList},removeRowData:function(t){var e=this;t?this.resultTableData.some(function(i,a){if(t[e.rowKey]===i[e.rowKey])return e.resultTableData.splice(a,1),!0}):this.tableData.forEach(function(t){e.removeRowData(t)})}}},l=(i("ADOs"),i("KHd+")),c=Object(l.a)(r,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"myCoustomTable",staticStyle:{height:"100%",padding:"10px"}},[t.stateBtn.title?i("div",{staticStyle:{"text-align":"right"}},[i("el-checkbox",{model:{value:t.stateBtnChecked,callback:function(e){t.stateBtnChecked=e},expression:"stateBtnChecked"}},[t._v(t._s(t.stateBtn.title))])],1):t._e(),t._v(" "),i("div",{style:t.setTablesHeight},[i("base-table",{directives:[{name:"loading",rawName:"v-loading",value:t.tableLoading,expression:"tableLoading"}],ref:"selectTable",attrs:{data:t.tableData,colConfigs:t.setTableConfigs.titleList,showCheckBox:!0,showIndex:t.setTableConfigs.showIndex,pageData:t.pageData,currentpage:t.currentpage,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.dataBridge}})],1),t._v(" "),i("div",{staticStyle:{height:"11px"}}),t._v(" "),i("div",{ref:"resultBox",staticStyle:{position:"relative"},style:t.setTablesHeight},[i("div",{staticStyle:{height:"100%"},style:{paddingBottom:t.btnsBoxHeight+"px"}},[i("base-table",{ref:"resultTable",attrs:{data:t.setResultTableData,colConfigs:t.setResultTableConfigs,showCheckBox:!1,showIndex:t.setTableConfigs.showIndex,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{databridge:t.resultDataBridge}})],1),t._v(" "),i("div",{ref:"btnsBox",staticStyle:{position:"absolute",bottom:"0",right:"0"}},[t.btnList.length?[t._l(t.btnList,function(e,a){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],key:a,attrs:{name:e.name,icon:e.icon,plain:e.plain,state:t.setResultBtnState(e)},on:{myclick:e.method}})]})]:t._e()],2)])])},[],!1,null,"68c26095",null);c.options.__file="index.vue";e.a=c.exports},kjwg:function(t,e,i){},mwzG:function(t,e,i){"use strict";e.a={code:0,msg:"执行成功!",result:{hideTitles:["id","productGenre","productUnit","parentId","warehouseId","productId","code","executeCount","state","cuser","uuser","remark","isdisable","qrcode","businessId"],pageData:{current:1,pages:"1",records:[],size:10,total:"1"},titles:[{progress:"进度"},{warehouseOutCode:"出库单编码"},{productCode:"货品编码"},{productName:"货品名称"},{productSpec:" 规格/型号"},{productGenreName:"货品属性"},{productUnitName:"计量单位"},{count:"出库数量"},{id:"id"},{productGenre:"货品属性ID"},{productUnit:"计量单位ID"},{parentId:"出库单ID"},{warehouseId:" (推荐)货位ID"},{productId:"产品ID"},{code:"批次号"},{executeCount:"已出库数量"},{state:"状态"},{cuser:"创建用户id"},{cdate:"创建时间"},{uuser:"修改用户id"},{udate:"修改时间"},{remark:"备注"},{isdisable:"是否启用"},{qrcode:"二维码"},{businessId:"业务id"}],varList:[{businessId:"",cdate:"3",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",isdisable1:"1",isdisable2:"0",isdisable3:"1",isdisable4:"1",name:"12",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.jpg",imgPath:"fileUpload/QRCode/product/1539142716704586.png",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",isdisable2:"1",isdisable3:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"219967d2f6704d868b11002caef9885c",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"2",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"1",productSpec:"22222222222222222222",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"55",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"3"},{businessId:"",cdate:"1",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"885c219967d2f6704d868b11002caef9",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"3",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"0",productSpec:"2111111111111111111",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"2"}]}}}}]);