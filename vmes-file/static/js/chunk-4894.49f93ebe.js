(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4894"],{"50Ol":function(e,t,i){"use strict";i("rGqo"),i("KKXr"),i("91GP");var a={name:"custom-summary-option",props:{customSummary:{type:Object,default:function(){return{}}},tableData:{type:Array,default:function(){return[]}},tempData:{type:Object,default:function(){return{}}}},data:function(){return{boxDefaultStyle:{width:"600px",float:"left"},data:{}}},directives:{"send-height":{inserted:function(e,t,i){i.context.$emit("send-height",e.clientHeight)}}},computed:{setStyle:function(){return this.customSummary.boxStyle||this.boxDefaultStyle},setData:function(){return this.customSummary.computes&&this.createFormula(this.customSummary.computes,this.tableData,this.tempData),this.data}},created:function(){this.data=this.customSummary.data,this.customSummary.apiObj&&this.customSummary.apiObj.apiName&&this.httpRequests()},mounted:function(){},methods:{httpRequests:function(){var e=this;try{this.$api[this.customSummary.apiObj.apiName](Object.assign({},this.customSummary.apiObj.params)).then(function(t){t.result&&e.assignmentFn(t.result)}).catch(function(e){console.log(e)})}catch(e){console.log(e)}},assignmentFn:function(e){for(var t in this.data)this.data.hasOwnProperty(t)&&(this.data[t]=e[t])},createFormula:function(e,t,i){for(var a in e)if(e.hasOwnProperty(a)){var o=e[a].split(/\([\\+|\-|\\*|\\/]\)/);if(o.length>1)o.forEach(function(e){});else{var n=e[a].split("@");"table"===n[0]&&(this.data[a]=this.getSum(n[1],t))}}},getSum:function(e,t){var i=0;return t.forEach(function(t){i+=t[e]-0}),i},customSummaryValue:function(e){this.$emit("custom-summary-value",e)}}},o=(i("MtNS"),i("KHd+")),n=Object(o.a)(a,function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"customSummaryOption clearfix"},[t(this.customSummary.component,{directives:[{name:"send-height",rawName:"v-send-height"}],tag:"component",attrs:{data:this.setData,tempData:this.tempData,setStyle:this.customSummary.boxStyle},on:{"custom-summary-value":this.customSummaryValue}})],1)},[],!1,null,null,null);n.options.__file="index.vue";t.a=n.exports},DKCI:function(e,t,i){"use strict";i("rGqo"),i("INYr");var a={name:"table-filter",props:{headerList:{type:Array,default:function(){return[]}},showAll:{type:Boolean,default:!1},storeId:{type:String,default:""},componentId:{type:String,default:""}},directives:{"auto-width":{inserted:function(e,t,i){i.context.widthList[t.value]=e.clientWidth}}},data:function(){return{checkList:[],widthSwitch:!1,checkViewWidth:0,checkViewHeight:0,checkViewWidthTimer:"",widthList:[],userConfig:"",storeKey:"",userId:"",localStoreKey:"",useStore:!1,tempList:""}},created:function(){this.storeKey="tableFilter"+this.storeId,this.userId=this.$storage.get("userInfo").userId||"",this.tempList=this.localStore(this.componentId,this.storeKey,this.userId),this.$emit("checked-list",this.tempList)},computed:{setHeight:function(){return this.checkViewHeight&&this.widthSwitch?(this.$emit("checked-height",this.checkViewHeight),this.checkViewHeight):(this.$emit("checked-height",20),20)},setHeaderList:function(){var e=this;return this.headerList.filter(function(t){return e.showAll?t:!t.component})}},methods:{checkedList:function(e){localStorage.setItem(this.localStoreKey,JSON.stringify(e)),this.$emit("checked-list",e)},viewSwitch:function(){this.widthSwitch=!this.widthSwitch},localStore:function(e,t,i){return this.localStoreKey="_"+e+t+i,JSON.parse(localStorage.getItem(this.localStoreKey))||""},setChecked:function(e){return!this.tempList||!Array.isArray(this.tempList)||this.tempList.findIndex(function(t){return t===e.label})>-1}},watch:{widthSwitch:function(){var e=this;this.widthSwitch&&!this.checkViewHeight&&(clearTimeout(this.checkViewWidthTimer),this.checkViewWidthTimer=setTimeout(function(t){var i=0;e.widthList.forEach(function(e){e-0&&(i+=e+15)}),e.checkViewHeight=20*Math.ceil(i/e.$refs.checkBoxView.clientWidth)},200))}}},o=(i("DlFo"),i("KHd+")),n=Object(o.a)(a,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"tableFilter",style:{height:e.setHeight+"px"}},[i("div",{staticClass:"msg",attrs:{title:"列开关"},on:{click:e.viewSwitch}},[i("svg-icon",{attrs:{"icon-class":"tableSetting"}})],1),e._v(" "),i("div",{ref:"checkBoxView",staticClass:"checkView",class:{setWidth:e.widthSwitch}},[i("div",{staticStyle:{position:"relative"}},[i("div",{staticStyle:{position:"absolute",top:"0",left:"0"}},[i("el-checkbox-group",{attrs:{size:"mini"},on:{change:e.checkedList},model:{value:e.checkList,callback:function(t){e.checkList=t},expression:"checkList"}},e._l(e.setHeaderList,function(t,a){return i("el-checkbox",{directives:[{name:"auto-width",rawName:"v-auto-width",value:a,expression:"index"}],key:t.prop,attrs:{label:t.label,checked:e.setChecked(t)}})}),1)],1)])])])},[],!1,null,"2ad1a997",null);n.options.__file="index.vue";t.a=n.exports},DlFo:function(e,t,i){"use strict";var a=i("kjwg");i.n(a).a},F9dT:function(e,t,i){"use strict";i.d(t,"a",function(){return d}),i.d(t,"c",function(){return u}),i.d(t,"b",function(){return l});i("pIFo"),i("SRfc"),i("KKXr"),i("INYr"),i("rGqo");var a=i("Yfch"),o=i("TB3a"),n=i("YP4+"),s=i("z0WU"),r=function(){return function(e,t,i){var o,n,s;t?(n=t-0,o=!0,s=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,i){i<e.ops.length-1&&(s?Object(a.a)(t-0)?(!Object(a.a)(n)||t-0>n)&&(o=!1):t-0>n&&(o=!1):Object(a.a)(t-0)?(!Object(a.a)(n)||t-0>=n)&&(o=!1):t-0>=n&&(o=!1))}),o?i():i(new Error(e.message))):i(new Error("不能为空"))}},c=function(){return function(e,t,i){var o,n,s;t?(n=t-0,o=!0,s=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,i){i<e.ops.length-1&&(s?Object(a.a)(t-0)?(!Object(a.a)(n-0)||n>t-0)&&(o=!1):n>t-0&&(o=!1):Object(a.a)(t-0)?(!Object(a.a)(n-0)||n>=t-0)&&(o=!1):n>=t-0&&(o=!1))}),o?i():i(new Error(e.message))):i(new Error("不能为空"))}};function d(e,t,i,a,o,n,s,d,l,h,p){var m,f,b,g,w;return e&&(m=u(e.greaterThan,o,n,l,!0,h)),g=d.findIndex(function(e){return e.greaterThan}),t&&(f=u(t.lessThan,o,n,l,!1,h)),w=d.findIndex(function(e){return e.lessThan}),b=[],m&&b.push({validator:r(),trigger:"blur",message:s[p||g],ops:m}),f&&b.push({validator:c(),trigger:"blur",message:s[p||w],ops:f}),b}function u(e,t,i,a,o,n,s){var r;"boolean"==typeof(e=JSON.parse(JSON.stringify(e)))[e.length-1]&&(r=e.pop());var c=e.map(function(e){return""});return e.forEach(function(e,r){var d=e.split(/\([\\+|\-|\\*|\\/]\)/);if(d.length>1)c.splice(r,1,l(d,t,i,a,e,n,s));else if(-1!==e.indexOf("@")){var u=e.split("@");2===u.length&&"self"===u[0]&&c.splice(r,1,t[u[1]]),2===u.length&&"parent"===u[0]&&c.splice(r,1,i[0][u[1]]),2===u.length&&"tempData"===u[0]&&c.splice(r,1,n[u[1]]),2===u.length&&"sibling"===u[0]&&c.splice(r,1,h(u[1],a,t,!1,o)),3===u.length&&"parent"===u[0]&&c.splice(r,1,JSON.parse(JSON.stringify(i)).reverse()[u[1]-1][u[2]])}else c.splice(r,1,e)}),"boolean"==typeof r?c.push(r):c.push(!0),c}function l(e,t,i,r,c,d,u){var l=e.map(function(e){return""});e.forEach(function(e,a){var o=e.split("@"),n=0;if(2===o.length)switch(o[0]){case"self":n=t[o[1]];break;case"parent":n=i[i.length-1][o[1]];break;case"tempData":n=d[o[1]];break;case"sibling":n=h(o[1],r,t,!0)}else 3===o.length?n=JSON.parse(JSON.stringify(i)).reverse()[o[1]-1][o[2]]:1===o.length&&(n=o[0]-0);l.splice(a,1,n||0)});var p=c.match(/\([\\+|\-|\\*|\\/]\)/g).map(function(e){return e.replace(/\(|\)/g,"")}),m="",f=function(e){if(Object(a.a)(e))return"number";if("string"==typeof e&&/^[0-9]{4}\-[0-9]{2}\-[0-9]{2}/.test(e))return"date"}(l[0]);return"number"===f?(l.forEach(function(e,t){p[t]?m+=e+p[t]:m+=e}),parseFloat(Object(s.j)(m).toFixed(u||n.a.precision))):"date"===f?(l.forEach(function(e,t){var i=o.a.timeStamp(e);p[t]?m+=i+p[t]:m+=i}),o.a.formatDate(Object(s.j)(m))):0}function h(e,t,i,a,o){var n=[],s=0,r=t.findIndex(function(e){return e.id===i.id});return t.forEach(function(t,i){r!==i&&n.push(t[e])}),a?n.forEach(function(e){s+=e-0}):s=o?Math.min.apply(Math,n):Math.max.apply(Math,n),s}},MtNS:function(e,t,i){"use strict";var a=i("Mugr");i.n(a).a},Mugr:function(e,t,i){},QjqE:function(e,t,i){"use strict";i.r(t);i("rGqo"),i("Oyvg");var a=i("WIyV"),o=i("91ra"),n={components:{customBaseTable:a.a},props:["initData","visible"],data:function(){return{parentId:"",customerId:"",openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",orderDetail_style:"",title:"",temp:null,tempLable:null},tableData:[],rowTableList:[],apiObj:{apiName:"listPageRetreatDetailByEdit",params:{pageNo:1,parentId:"",isRetreatByInfo:"true",fieldCode:"sysOrderCode,deliverCode,productCode,productName,productSpec,orderUnitName,receiveAmount,deliverOrderCount,orderCount,productPrice,orderSum,remark"}},customColumn:[{columnIndex:"orderSum",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"],editable:!0}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.parentId=this.initData.data.parentId,this.customerId=this.initData.data.customerId,this.apiObj.params.parentId=this.parentId},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){this.rowTableList=[],Array.isArray(e)&&(this.rowTableList=e)},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i],o=a.receiveAmount,n=a.orderSum;o-0==0&&n-o>0?t=t+"第 "+(i+1)+" 行: 退货金额("+n+") 输入错误，退货金额必须等于零！":o-0!=0&&n-o>0&&(t=t+"第 "+(i+1)+" 行: 退货金额("+n+") 输入错误，退货金额不可大于实收金额！")}return t},save:function(){this.$refs.moneyRetreatDialog.getData(),this.saveSaleRetreat(this.rowTableList)},saveSaleRetreat:function(e){var t=this;if(null!=e&&0!=e.length){var i=this.checkColumn(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{var a=[];e.forEach(function(e){var t={id:e.id,orderSum:e.orderSum,sysOrderCode:e.sysOrderCode,orderId:e.orderId,receiveAmount:e.receiveAmount,notRetreatSum:e.notRetreatSum};a.push(t)});var n="";null!=a&&a.length>0&&(n=JSON.stringify(a)),null!=n&&0!=n?Object(o.updateRetreatByMoney)({parentId:this.parentId,customerId:this.customerId,dtlJsonStr:n}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"暂无发货单明细！"})}}},dialogOpen:function(){},dialogClose:function(e){this.rowTableList=[],this.customerId="",this.deliverDtlIds="",this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},s=i("KHd+"),r=Object(s.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{style:e.initData.orderDetail_style},[i("custom-base-table",{ref:"moneyRetreatDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"moneyRetreatDialog",useDefaultBtn:!1,showAll:!1},on:{databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="dialogMoneyRetreat.vue";t.default=r.exports},TB3a:function(e,t,i){"use strict";i("a1Th"),i("SRfc"),i("KKXr");t.a={timeStamp:function(e){if("string"==typeof e){var t=e.split(" ");if(1===t.length){var i=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);return null===i?(new Date).getTime():new Date(i[1],i[3]-1,i[4]).getTime()}var a=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/),o=t[1].match(/^(\d{1,2})(-|\:)(\d{1,2})\2(\d{1,2})$/);return a&&o?new Date(a[1],a[3]-1,a[4],o[1],o[3],o[4]).getTime():(new Date).getTime()}return"number"==typeof e?864e5*e:(new Date).getTime()},formatDate:function(e,t){var i=e?new Date(e):new Date,a=i.getFullYear(),o=i.getMonth()+1,n=i.getDate(),s=i.getHours(),r=i.getMinutes(),c=i.getSeconds(),d=function(e){return(e=e.toString())[1]?e:"0"+e};return[a,o,n].map(d).join(t||"-")+" "+[s,r,c].map(d).join(":")}}},kjwg:function(e,t,i){},mwzG:function(e,t,i){"use strict";t.a={code:0,msg:"执行成功!",result:{hideTitles:["id","productGenre","productUnit","parentId","warehouseId","productId","code","executeCount","state","cuser","uuser","remark","isdisable","qrcode","businessId"],pageData:{current:1,pages:"1",records:[],size:10,total:"1"},titles:[{progress:"进度"},{warehouseOutCode:"出库单编码"},{productCode:"货品编码"},{productName:"货品名称"},{productSpec:" 规格/型号"},{productGenreName:"货品属性"},{productUnitName:"计量单位"},{count:"出库数量"},{id:"id"},{productGenre:"货品属性ID"},{productUnit:"计量单位ID"},{parentId:"出库单ID"},{warehouseId:" (推荐)货位ID"},{productId:"产品ID"},{code:"批次号"},{executeCount:"已出库数量"},{state:"状态"},{cuser:"创建用户id"},{cdate:"创建时间"},{uuser:"修改用户id"},{udate:"修改时间"},{remark:"备注"},{isdisable:"是否启用"},{qrcode:"二维码"},{businessId:"业务id"}],varList:[{businessId:"",cdate:"3",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",isdisable1:"1",isdisable2:"0",isdisable3:"1",isdisable4:"1",name:"12",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.jpg",imgPath:"fileUpload/QRCode/product/1539142716704586.png",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",isdisable2:"1",isdisable3:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"219967d2f6704d868b11002caef9885c",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"2",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"1",productSpec:"22222222222222222222",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"55",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"3"},{businessId:"",cdate:"1",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"885c219967d2f6704d868b11002caef9",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"3",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"0",productSpec:"2111111111111111111",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"2"}]}}}}]);