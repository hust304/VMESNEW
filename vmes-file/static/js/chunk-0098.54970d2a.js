(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-0098"],{"50Ol":function(e,t,i){"use strict";i("rGqo"),i("KKXr"),i("91GP");var a={name:"custom-summary-option",props:{customSummary:{type:Object,default:function(){return{}}},tableData:{type:Array,default:function(){return[]}},tempData:{type:Object,default:function(){return{}}}},data:function(){return{boxDefaultStyle:{width:"600px",float:"left"},data:{}}},directives:{"send-height":{inserted:function(e,t,i){i.context.$emit("send-height",e.clientHeight)}}},computed:{setStyle:function(){return this.customSummary.boxStyle||this.boxDefaultStyle},setData:function(){return this.customSummary.computes&&this.createFormula(this.customSummary.computes,this.tableData,this.tempData),this.data}},created:function(){this.data=this.customSummary.data,this.customSummary.apiObj&&this.customSummary.apiObj.apiName&&this.httpRequests()},mounted:function(){},methods:{httpRequests:function(){var e=this;try{this.$api[this.customSummary.apiObj.apiName](Object.assign({},this.customSummary.apiObj.params)).then(function(t){t.result&&e.assignmentFn(t.result)}).catch(function(e){console.log(e)})}catch(e){console.log(e)}},assignmentFn:function(e){for(var t in this.data)this.data.hasOwnProperty(t)&&(this.data[t]=e[t])},createFormula:function(e,t,i){for(var a in e)if(e.hasOwnProperty(a)){var s=e[a].split(/\([\\+|\-|\\*|\\/]\)/);if(s.length>1)s.forEach(function(e){});else{var n=e[a].split("@");"table"===n[0]&&(this.data[a]=this.getSum(n[1],t))}}},getSum:function(e,t){var i=0;return t.forEach(function(t){i+=t[e]-0}),i},customSummaryValue:function(e){this.$emit("custom-summary-value",e)}}},s=(i("MtNS"),i("KHd+")),n=Object(s.a)(a,function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"customSummaryOption clearfix"},[t(this.customSummary.component,{directives:[{name:"send-height",rawName:"v-send-height"}],tag:"component",attrs:{data:this.setData,tempData:this.tempData,setStyle:this.customSummary.boxStyle},on:{"custom-summary-value":this.customSummaryValue}})],1)},[],!1,null,null,null);n.options.__file="index.vue";t.a=n.exports},"8ptq":function(e,t,i){"use strict";i.r(t);i("Oyvg");var a=i("WIyV"),s=i("CK78"),n={components:{customBaseTable:a.a},props:["initData","visible"],data:function(){return{receiptType:"1",productUnit:{},rowData:{},rules:{},openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],rowTableList:[],configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},apiObj:{apiName:"listPageSaleInvoiceDetail",params:{pageNo:1,fieldCode:"",parentId:""}},customColumn:[{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"sum",_cellConfig:{hideTitle:!0,compute:"self@count(*)self@productPrice"}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.temp=this.initData.temp,null!=this.initData.temp.receiptType&&this.initData.temp.receiptType.trim().length>0&&(this.receiptType=this.initData.temp.receiptType.trim()),null!=this.initData.temp.id&&this.initData.temp.id.trim().length>0&&(this.apiObj.params.parentId=this.initData.temp.id.trim())},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){Array.isArray(e)&&(this.rowTableList=[],this.rowTableList=e,this.saveSaleOrder(this.rowTableList))},save:function(){this.$refs.orderAddByInvoiceDialog.getData()},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i].count;null!=a&&0!=a.trim().length||(t=t+"第 "+(i+1)+" 行: 开票数量为空或空字符串！"),null!=a&&a.trim().length>0&&!this.isNumberByValue(a.trim())&&(t=t+"第 "+(index+1)+" 行: 开票数量("+a+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return t},saveSaleOrder:function(e){var t=this,i=this.checkColumn(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{for(var a=[],n=0;n<e.length;n++){var o=e[n];a.push(o)}this.temp.dtlJsonStr="",null!=a&&a.length>0&&(this.temp.dtlJsonStr=JSON.stringify(a)),this.dialogLoading=!0,Object(s.updateSaleInvoice)(this.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},o=i("KHd+"),c=Object(o.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",{staticStyle:{margin:"10px 50px"}},[i("el-radio-group",{model:{value:e.receiptType,callback:function(t){e.receiptType=t},expression:"receiptType"}},[i("el-radio",{attrs:{label:"1"}},[e._v("不开票")]),e._v(" "),i("el-radio",{attrs:{label:"2"}},[e._v("增值税普通发票")]),e._v(" "),i("el-radio",{attrs:{label:"3"}},[e._v("增值税专用发票")])],1)],1),e._v(" "),i("div",{staticStyle:{"padding-left":"50px"}},[i("p",[i("a",[e._v("公司名称:")]),e._v(e._s(e.temp.custInvoiceCompanyName))]),e._v(" "),i("p",[i("a",[e._v("发票税号:")]),e._v(e._s(e.temp.custInvoiceNumber))]),e._v(" "),i("p",[i("a",[e._v("地址:")]),e._v(e._s(e.temp.custInvoiceAddress))]),e._v(" "),i("p",[i("a",[e._v("电话:")]),e._v(e._s(e.temp.custInvoiceMobile))]),e._v(" "),i("p",[i("a",[e._v("开户银行:")]),e._v(e._s(e.temp.custInvoiceBankName))]),e._v(" "),i("p",[i("a",[e._v("银行账号:")]),e._v(e._s(e.temp.custInvoiceBankCode))])]),e._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[i("custom-base-table",{ref:"orderAddByInvoiceDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"orderAddByInvoiceDialog",useDefaultBtn:!0,showAll:!1},on:{databridge:e.databridge}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);c.options.__file="dialogEdit.vue";t.default=c.exports},DKCI:function(e,t,i){"use strict";i("rGqo"),i("INYr");var a={name:"table-filter",props:{headerList:{type:Array,default:function(){return[]}},showAll:{type:Boolean,default:!1},storeId:{type:String,default:""},componentId:{type:String,default:""}},directives:{"auto-width":{inserted:function(e,t,i){i.context.widthList[t.value]=e.clientWidth}}},data:function(){return{checkList:[],widthSwitch:!1,checkViewWidth:0,checkViewHeight:0,checkViewWidthTimer:"",widthList:[],userConfig:"",storeKey:"",userId:"",localStoreKey:"",useStore:!1,tempList:""}},created:function(){this.storeKey="tableFilter"+this.storeId,this.userId=this.$storage.get("userInfo").userId||"",this.tempList=this.localStore(this.componentId,this.storeKey,this.userId),this.$emit("checked-list",this.tempList)},computed:{setHeight:function(){return this.checkViewHeight&&this.widthSwitch?(this.$emit("checked-height",this.checkViewHeight),this.checkViewHeight):(this.$emit("checked-height",20),20)},setHeaderList:function(){var e=this;return this.headerList.filter(function(t){return e.showAll?t:!t.component})}},methods:{checkedList:function(e){localStorage.setItem(this.localStoreKey,JSON.stringify(e)),this.$emit("checked-list",e)},viewSwitch:function(){this.widthSwitch=!this.widthSwitch},localStore:function(e,t,i){return this.localStoreKey="_"+e+t+i,JSON.parse(localStorage.getItem(this.localStoreKey))||""},setChecked:function(e){return!this.tempList||!Array.isArray(this.tempList)||this.tempList.findIndex(function(t){return t===e.label})>-1}},watch:{widthSwitch:function(){var e=this;this.widthSwitch&&!this.checkViewHeight&&(clearTimeout(this.checkViewWidthTimer),this.checkViewWidthTimer=setTimeout(function(t){var i=0;e.widthList.forEach(function(e){e-0&&(i+=e+15)}),e.checkViewHeight=20*Math.ceil(i/e.$refs.checkBoxView.clientWidth)},200))}}},s=(i("DlFo"),i("KHd+")),n=Object(s.a)(a,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"tableFilter",style:{height:e.setHeight+"px"}},[i("div",{staticClass:"msg",attrs:{title:"列开关"},on:{click:e.viewSwitch}},[i("svg-icon",{attrs:{"icon-class":"tableSetting"}})],1),e._v(" "),i("div",{ref:"checkBoxView",staticClass:"checkView",class:{setWidth:e.widthSwitch}},[i("div",{staticStyle:{position:"relative"}},[i("div",{staticStyle:{position:"absolute",top:"0",left:"0"}},[i("el-checkbox-group",{attrs:{size:"mini"},on:{change:e.checkedList},model:{value:e.checkList,callback:function(t){e.checkList=t},expression:"checkList"}},e._l(e.setHeaderList,function(t,a){return i("el-checkbox",{directives:[{name:"auto-width",rawName:"v-auto-width",value:a,expression:"index"}],key:t.prop,attrs:{label:t.label,checked:e.setChecked(t)}})}),1)],1)])])])},[],!1,null,"2ad1a997",null);n.options.__file="index.vue";t.a=n.exports},DlFo:function(e,t,i){"use strict";var a=i("kjwg");i.n(a).a},F9dT:function(e,t,i){"use strict";i.d(t,"a",function(){return d}),i.d(t,"c",function(){return u}),i.d(t,"b",function(){return l});i("pIFo"),i("SRfc"),i("KKXr"),i("INYr"),i("rGqo");var a=i("Yfch"),s=i("TB3a"),n=i("YP4+"),o=i("z0WU"),c=function(){return function(e,t,i){var s,n,o;t?(n=t-0,s=!0,o=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,i){i<e.ops.length-1&&(o?Object(a.b)(t-0)?(!Object(a.b)(n)||t-0>n)&&(s=!1):t-0>n&&(s=!1):Object(a.b)(t-0)?(!Object(a.b)(n)||t-0>=n)&&(s=!1):t-0>=n&&(s=!1))}),s?i():i(new Error(e.message))):i(new Error("不能为空"))}},r=function(){return function(e,t,i){var s,n,o;t?(n=t-0,s=!0,o=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,i){i<e.ops.length-1&&(o?Object(a.b)(t-0)?(!Object(a.b)(n-0)||n>t-0)&&(s=!1):n>t-0&&(s=!1):Object(a.b)(t-0)?(!Object(a.b)(n-0)||n>=t-0)&&(s=!1):n>=t-0&&(s=!1))}),s?i():i(new Error(e.message))):i(new Error("不能为空"))}};function d(e,t,i,a,s,n,o,d,l,p,h){var m,f,b,g,v;return e&&(m=u(e.greaterThan,s,n,l,!0,p)),g=d.findIndex(function(e){return e.greaterThan}),t&&(f=u(t.lessThan,s,n,l,!1,p)),v=d.findIndex(function(e){return e.lessThan}),b=[],m&&b.push({validator:c(),trigger:"blur",message:o[h||g],ops:m}),f&&b.push({validator:r(),trigger:"blur",message:o[h||v],ops:f}),b}function u(e,t,i,a,s,n,o){var c;"boolean"==typeof(e=JSON.parse(JSON.stringify(e)))[e.length-1]&&(c=e.pop());var r=e.map(function(e){return""});return e.forEach(function(e,c){var d=e.split(/\([\\+|\-|\\*|\\/]\)/);if(d.length>1)r.splice(c,1,l(d,t,i,a,e,n,o));else if(-1!==e.indexOf("@")){var u=e.split("@");2===u.length&&"self"===u[0]&&r.splice(c,1,t[u[1]]),2===u.length&&"parent"===u[0]&&r.splice(c,1,i[0][u[1]]),2===u.length&&"tempData"===u[0]&&r.splice(c,1,n[u[1]]),2===u.length&&"sibling"===u[0]&&r.splice(c,1,p(u[1],a,t,!1,s)),3===u.length&&"parent"===u[0]&&r.splice(c,1,JSON.parse(JSON.stringify(i)).reverse()[u[1]-1][u[2]])}else r.splice(c,1,e)}),"boolean"==typeof c?r.push(c):r.push(!0),r}function l(e,t,i,c,r,d,u){var l=e.map(function(e){return""});e.forEach(function(e,a){var s=e.split("@"),n=0;if(2===s.length)switch(s[0]){case"self":n=t[s[1]];break;case"parent":n=i[i.length-1][s[1]];break;case"tempData":n=d[s[1]];break;case"sibling":n=p(s[1],c,t,!0)}else 3===s.length?n=JSON.parse(JSON.stringify(i)).reverse()[s[1]-1][s[2]]:1===s.length&&(n=s[0]-0);l.splice(a,1,n||0)});var h=r.match(/\([\\+|\-|\\*|\\/]\)/g).map(function(e){return e.replace(/\(|\)/g,"")}),m="",f=function(e){if(Object(a.b)(e))return"number";if("string"==typeof e&&/^[0-9]{4}\-[0-9]{2}\-[0-9]{2}/.test(e))return"date"}(l[0]);return"number"===f?(l.forEach(function(e,t){h[t]?m+=e+h[t]:m+=e}),parseFloat(Object(o.j)(m).toFixed(u||n.a.precision))):"date"===f?(l.forEach(function(e,t){var i=s.a.timeStamp(e);h[t]?m+=i+h[t]:m+=i}),s.a.formatDate(Object(o.j)(m))):0}function p(e,t,i,a,s){var n=[],o=0,c=t.findIndex(function(e){return e.id===i.id});return t.forEach(function(t,i){c!==i&&n.push(t[e])}),a?n.forEach(function(e){o+=e-0}):o=s?Math.min.apply(Math,n):Math.max.apply(Math,n),o}},MtNS:function(e,t,i){"use strict";var a=i("Mugr");i.n(a).a},Mugr:function(e,t,i){},TB3a:function(e,t,i){"use strict";i("a1Th"),i("SRfc"),i("KKXr");t.a={timeStamp:function(e){if("string"==typeof e){var t=e.split(" ");if(1===t.length){var i=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);return null===i?(new Date).getTime():new Date(i[1],i[3]-1,i[4]).getTime()}var a=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/),s=t[1].match(/^(\d{1,2})(-|\:)(\d{1,2})\2(\d{1,2})$/);return a&&s?new Date(a[1],a[3]-1,a[4],s[1],s[3],s[4]).getTime():(new Date).getTime()}return"number"==typeof e?864e5*e:(new Date).getTime()},formatDate:function(e,t){var i=e?new Date(e):new Date,a=i.getFullYear(),s=i.getMonth()+1,n=i.getDate(),o=i.getHours(),c=i.getMinutes(),r=i.getSeconds(),d=function(e){return(e=e.toString())[1]?e:"0"+e};return[a,s,n].map(d).join(t||"-")+" "+[o,c,r].map(d).join(":")}}},kjwg:function(e,t,i){},mwzG:function(e,t,i){"use strict";t.a={code:0,msg:"执行成功!",result:{hideTitles:["id","productGenre","productUnit","parentId","warehouseId","productId","code","executeCount","state","cuser","uuser","remark","isdisable","qrcode","businessId"],pageData:{current:1,pages:"1",records:[],size:10,total:"1"},titles:[{progress:"进度"},{warehouseOutCode:"出库单编码"},{productCode:"货品编码"},{productName:"货品名称"},{productSpec:" 规格/型号"},{productGenreName:"货品属性"},{productUnitName:"计量单位"},{count:"出库数量"},{id:"id"},{productGenre:"货品属性ID"},{productUnit:"计量单位ID"},{parentId:"出库单ID"},{warehouseId:" (推荐)货位ID"},{productId:"产品ID"},{code:"批次号"},{executeCount:"已出库数量"},{state:"状态"},{cuser:"创建用户id"},{cdate:"创建时间"},{uuser:"修改用户id"},{udate:"修改时间"},{remark:"备注"},{isdisable:"是否启用"},{qrcode:"二维码"},{businessId:"业务id"}],varList:[{businessId:"",cdate:"3",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",isdisable1:"1",isdisable2:"0",isdisable3:"1",isdisable4:"1",name:"12",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.jpg",imgPath:"fileUpload/QRCode/product/1539142716704586.png",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",isdisable2:"1",isdisable3:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"219967d2f6704d868b11002caef9885c",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"2",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"1",productSpec:"22222222222222222222",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"55",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"3"},{businessId:"",cdate:"1",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"11.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"885c219967d2f6704d868b11002caef9",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"3",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"0",productSpec:"2111111111111111111",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"2"}]}}}}]);