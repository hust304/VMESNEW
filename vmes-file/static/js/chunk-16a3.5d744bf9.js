(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-16a3"],{"50Ol":function(e,t,i){"use strict";i("rGqo"),i("KKXr"),i("91GP");var a={name:"custom-summary-option",props:{customSummary:{type:Object,default:function(){return{}}},tableData:{type:Array,default:function(){return[]}},tempData:{type:Object,default:function(){return{}}}},data:function(){return{boxDefaultStyle:{width:"600px",float:"left"},data:{}}},directives:{"send-height":{inserted:function(e,t,i){i.context.$emit("send-height",e.clientHeight)}}},computed:{setStyle:function(){return this.customSummary.boxStyle||this.boxDefaultStyle},setData:function(){return this.customSummary.computes&&this.createFormula(this.customSummary.computes,this.tableData,this.tempData),this.data}},created:function(){this.data=this.customSummary.data,this.customSummary.apiObj&&this.customSummary.apiObj.apiName&&this.httpRequests()},mounted:function(){},methods:{httpRequests:function(){var e=this;try{this.$api[this.customSummary.apiObj.apiName](Object.assign({},this.customSummary.apiObj.params)).then(function(t){t.result&&e.assignmentFn(t.result)}).catch(function(e){console.log(e)})}catch(e){console.log(e)}},assignmentFn:function(e){for(var t in this.data)this.data.hasOwnProperty(t)&&(this.data[t]=e[t])},createFormula:function(e,t,i){for(var a in e)if(e.hasOwnProperty(a)){var r=e[a].split(/\([\\+|\-|\\*|\\/]\)/);if(r.length>1)r.forEach(function(e){});else{var o=e[a].split("@");"table"===o[0]&&(this.data[a]=this.getSum(o[1],t))}}},getSum:function(e,t){var i=0;return t.forEach(function(t){i+=t[e]-0}),i},customSummaryValue:function(e){this.$emit("custom-summary-value",e)}}},r=(i("MtNS"),i("KHd+")),o=Object(r.a)(a,function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"customSummaryOption clearfix"},[t(this.customSummary.component,{directives:[{name:"send-height",rawName:"v-send-height"}],tag:"component",attrs:{data:this.setData,tempData:this.tempData,setStyle:this.customSummary.boxStyle},on:{"custom-summary-value":this.customSummaryValue}})],1)},[],!1,null,null,null);o.options.__file="index.vue";t.a=o.exports},"5Fd+":function(e,t,i){"use strict";i.r(t);var a=i("WIyV"),r=i("8Vv6"),o={components:{customBaseTable:a.a},name:"dialog-edit",props:["initData","visible"],data:function(){return{orderId:"",orderObject:{},orderCollect:{},isShowText:!1,rowData:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",tempLable:null,data:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tableData_orderDetail:[],apiObj_orderDetail:{apiName:"listPageOrderDetailCollectByInfo",params:{pageNo:1,parentId:"",fieldCode:"productCode,productName,productSpec,productGenreName,orderUnitName,orderCount,productPrice,productSum,deliverCount,deliverSum,invoiceCount,invoiceSum,deliverDate,remark"}},customColumn_orderDetail:[],mergeTitle_orderDetail:[],mergeColumn_orderDetail:[],mergeRow_orderDetail:[],keyMapping_orderDetail:{},tempData_orderDetail:{},tableData_deliverDetail:[],apiObj_deliverDetail:{apiName:"listPageSaleDeliverDetail",params:{pageNo:1,state:"1",orderId:"",orderStr:"detail.product_id,detail.cdate asc",fieldCode:"productCode,productName,productSpec,productGenreName,orderUnitName,orderCount,productPrice,sum,cdate,deliverDate"}},customColumn_deliverDetail:[],mergeTitle_deliverDetail:[],mergeColumn_deliverDetail:[],mergeRow_deliverDetail:[],keyMapping_deliverDetail:{},tempData_deliverDetail:{}}},beforeCreate:function(){},created:function(){this.orderObject=this.initData.orderObject,this.orderId=this.initData.orderId,this.apiObj_orderDetail.params.parentId=this.orderId,this.apiObj_deliverDetail.params.orderId=this.orderId,this.findOrderCollectByOrderId(this.orderId)},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},findOrderCollectByOrderId:function(e){var t=this;this.dialogLoading=!0,Object(r.getSaleOrderCollectByOrderId)({id:e}).then(function(e){t.dialogLoading=!1,0===e.code&&null!=e.result&&null!=e.result.varList&&e.result.varList.length>0&&(t.orderCollect=e.result.varList[0])}).catch(function(e){console.log(e),t.dialogLoading=!1})}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},setInputState:function(){return""===this.orderCollect.receiveDaysRemaining||void 0===this.orderCollect.receiveDaysRemaining||(this.orderCollect.receiveDaysRemaining-0>=0||(this.orderCollect.receiveDaysRemaining=-1*this.orderCollect.receiveDaysRemaining,this.isShowText=!0,!1))}}},s=(i("ghff"),i("KHd+")),c=Object(s.a)(o,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{margin:"2em 2.3em"}},[i("el-row",{staticStyle:{"margin-bottom":"10px"}},[i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("客户名称  :  ")]),e._v(e._s(e.orderCollect.customerName))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("下单日期  :  ")]),e._v(e._s(e.orderCollect.orderDate))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("制单人  :  ")]),e._v(e._s(e.orderCollect.makeName))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("备注  :  ")]),e._v(e._s(e.orderCollect.remark))])])],1),e._v(" "),i("el-row",{staticStyle:{"margin-bottom":"10px"}},[i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("订单编号  :  ")]),e._v(e._s(e.orderCollect.sysCode))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("约定交期  :  ")]),e._v(e._s(e.orderCollect.expectDate))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("发票类型  :  ")]),e._v(e._s(e.orderCollect.receiptTypeName))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("审核人:")]),e._v(e._s(e.orderCollect.auditName))])])],1),e._v(" "),i("el-row",{staticStyle:{"margin-bottom":"10px"}},[i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("发货完成日期  :  ")]),e._v(e._s(e.orderCollect.deliverDate))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("付款完成日期  :  ")]),e._v(e._s(e.orderCollect.payDate))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("账期截止日  :  ")]),e._v(e._s(e.orderCollect.deadlineDate))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",{style:{color:e.setInputState?"#606266":"#ff0000"}},[e._v(e._s(e.setInputState?"账期剩余(天)  :  ":"逾期(天)  :  ")+"  ")]),e._v(e._s(e.orderCollect.receiveDaysRemaining))])])],1),e._v(" "),i("el-row",{staticStyle:{"margin-bottom":"10px"}},[i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("发货金额  :  ")]),e._v(e._s(e.orderCollect.deliverAmount))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("折扣金额  :  ")]),e._v(e._s(e.orderCollect.discountedAmount))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("实收金额  :  ")]),e._v(e._s(e.orderCollect.receivedAmount))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("应收金额  :  ")]),e._v(e._s(e.orderCollect.nowReceiveAmount))])])],1),e._v(" "),i("el-row",{staticStyle:{"margin-bottom":"10px"}},[i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("订单金额  :  ")]),e._v(e._s(e.orderCollect.orderAmount))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",[i("b",[e._v("开票金额  :  ")]),e._v(e._s(e.orderCollect.invoiceAmount))])]),e._v(" "),i("el-col",{attrs:{span:6}},[i("div",{directives:[{name:"show",rawName:"v-show",value:e.isShowText,expression:"isShowText"}],staticStyle:{color:"red"}},[i("b",[e._v("逾期金额  :  ")]),e._v(e._s(e.orderCollect.receivables))])]),e._v(" "),i("el-col",{attrs:{span:6}}),e._v(" "),i("el-col",{attrs:{span:6}})],1)],1),e._v(" "),i("el-row",{style:e.initData.orderDetail_style},[i("custom-base-table",{ref:"orderDetailDialog",attrs:{isSortable:!1,varList:e.tableData_orderDetail,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn_orderDetail,apiObj:e.apiObj_orderDetail,mergeTitle:e.mergeTitle_orderDetail,mergeColumn:e.mergeColumn_orderDetail,mergeRow:e.mergeRow_orderDetail,tempData:e.tempData_orderDetail,componentId:"orderDetailDialog",useDefaultBtn:!1,showAll:!1,keyMapping:e.keyMapping_orderDetail,hidePages:!0},on:{databridge:e.databridge}})],1),i("br"),e._v(" "),i("el-row",{style:e.initData.deliverDetail_style},[i("custom-base-table",{ref:"deliverDetailDialog",attrs:{isSortable:!1,varList:e.tableData_deliverDetail,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn_deliverDetail,apiObj:e.apiObj_deliverDetail,mergeTitle:e.mergeTitle_deliverDetail,mergeColumn:e.mergeColumn_deliverDetail,mergeRow:e.mergeRow_deliverDetail,tempData:e.tempData_deliverDetail,componentId:"deliverDetailDialog",useDefaultBtn:!1,showAll:!1,keyMapping:e.keyMapping_deliverDetail,hidePages:!0},on:{databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);c.options.__file="orderCollect.vue";t.default=c.exports},DKCI:function(e,t,i){"use strict";i("rGqo"),i("INYr");var a={name:"table-filter",props:{headerList:{type:Array,default:function(){return[]}},showAll:{type:Boolean,default:!1},storeId:{type:String,default:""},componentId:{type:String,default:""}},directives:{"auto-width":{inserted:function(e,t,i){i.context.widthList[t.value]=e.clientWidth}}},data:function(){return{checkList:[],widthSwitch:!1,checkViewWidth:0,checkViewHeight:0,checkViewWidthTimer:"",widthList:[],userConfig:"",storeKey:"",userId:"",localStoreKey:"",useStore:!1,tempList:""}},created:function(){this.storeKey="tableFilter"+this.storeId,this.userId=this.$storage.get("userInfo").userId||"",this.tempList=this.localStore(this.componentId,this.storeKey,this.userId),this.$emit("checked-list",this.tempList)},computed:{setHeight:function(){return this.checkViewHeight&&this.widthSwitch?(this.$emit("checked-height",this.checkViewHeight),this.checkViewHeight):(this.$emit("checked-height",20),20)},setHeaderList:function(){var e=this;return this.headerList.filter(function(t){return e.showAll?t:!t.component})}},methods:{checkedList:function(e){localStorage.setItem(this.localStoreKey,JSON.stringify(e)),this.$emit("checked-list",e)},viewSwitch:function(){this.widthSwitch=!this.widthSwitch},localStore:function(e,t,i){return this.localStoreKey="_"+e+t+i,JSON.parse(localStorage.getItem(this.localStoreKey))||""},setChecked:function(e){return!this.tempList||!Array.isArray(this.tempList)||this.tempList.findIndex(function(t){return t===e.label})>-1}},watch:{widthSwitch:function(){var e=this;this.widthSwitch&&!this.checkViewHeight&&(clearTimeout(this.checkViewWidthTimer),this.checkViewWidthTimer=setTimeout(function(t){var i=0;e.widthList.forEach(function(e){e-0&&(i+=e+15)}),e.checkViewHeight=20*Math.ceil(i/e.$refs.checkBoxView.clientWidth)},200))}}},r=(i("DlFo"),i("KHd+")),o=Object(r.a)(a,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"tableFilter",style:{height:e.setHeight+"px"}},[i("div",{staticClass:"msg",attrs:{title:"列开关"},on:{click:e.viewSwitch}},[i("svg-icon",{attrs:{"icon-class":"tableSetting"}})],1),e._v(" "),i("div",{ref:"checkBoxView",staticClass:"checkView",class:{setWidth:e.widthSwitch}},[i("div",{staticStyle:{position:"relative"}},[i("div",{staticStyle:{position:"absolute",top:"0",left:"0"}},[i("el-checkbox-group",{attrs:{size:"mini"},on:{change:e.checkedList},model:{value:e.checkList,callback:function(t){e.checkList=t},expression:"checkList"}},e._l(e.setHeaderList,function(t,a){return i("el-checkbox",{directives:[{name:"auto-width",rawName:"v-auto-width",value:a,expression:"index"}],key:t.prop,attrs:{label:t.label,checked:e.setChecked(t)}})}),1)],1)])])])},[],!1,null,"2ad1a997",null);o.options.__file="index.vue";t.a=o.exports},DlFo:function(e,t,i){"use strict";var a=i("kjwg");i.n(a).a},F9dT:function(e,t,i){"use strict";i.d(t,"a",function(){return d}),i.d(t,"c",function(){return l}),i.d(t,"b",function(){return u});i("pIFo"),i("SRfc"),i("KKXr"),i("INYr"),i("rGqo");var a=i("Yfch"),r=i("TB3a"),o=i("YP4+"),s=i("z0WU"),c=function(){return function(e,t,i){var r,o,s;t?(o=t-0,r=!0,s=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,i){i<e.ops.length-1&&(s?Object(a.a)(t-0)?(!Object(a.a)(o)||t-0>o)&&(r=!1):t-0>o&&(r=!1):Object(a.a)(t-0)?(!Object(a.a)(o)||t-0>=o)&&(r=!1):t-0>=o&&(r=!1))}),r?i():i(new Error(e.message))):i(new Error("不能为空"))}},n=function(){return function(e,t,i){var r,o,s;t?(o=t-0,r=!0,s=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,i){i<e.ops.length-1&&(s?Object(a.a)(t-0)?(!Object(a.a)(o-0)||o>t-0)&&(r=!1):o>t-0&&(r=!1):Object(a.a)(t-0)?(!Object(a.a)(o-0)||o>=t-0)&&(r=!1):o>=t-0&&(r=!1))}),r?i():i(new Error(e.message))):i(new Error("不能为空"))}};function d(e,t,i,a,r,o,s,d,u,p,m){var h,b,f,g,v;return e&&(h=l(e.greaterThan,r,o,u,!0,p)),g=d.findIndex(function(e){return e.greaterThan}),t&&(b=l(t.lessThan,r,o,u,!1,p)),v=d.findIndex(function(e){return e.lessThan}),f=[],h&&f.push({validator:c(),trigger:"blur",message:s[m||g],ops:h}),b&&f.push({validator:n(),trigger:"blur",message:s[m||v],ops:b}),f}function l(e,t,i,a,r,o,s){var c;"boolean"==typeof(e=JSON.parse(JSON.stringify(e)))[e.length-1]&&(c=e.pop());var n=e.map(function(e){return""});return e.forEach(function(e,c){var d=e.split(/\([\\+|\-|\\*|\\/]\)/);if(d.length>1)n.splice(c,1,u(d,t,i,a,e,o,s));else if(-1!==e.indexOf("@")){var l=e.split("@");2===l.length&&"self"===l[0]&&n.splice(c,1,t[l[1]]),2===l.length&&"parent"===l[0]&&n.splice(c,1,i[0][l[1]]),2===l.length&&"tempData"===l[0]&&n.splice(c,1,o[l[1]]),2===l.length&&"sibling"===l[0]&&n.splice(c,1,p(l[1],a,t,!1,r)),3===l.length&&"parent"===l[0]&&n.splice(c,1,JSON.parse(JSON.stringify(i)).reverse()[l[1]-1][l[2]])}else n.splice(c,1,e)}),"boolean"==typeof c?n.push(c):n.push(!0),n}function u(e,t,i,c,n,d,l){var u=e.map(function(e){return""});e.forEach(function(e,a){var r=e.split("@"),o=0;if(2===r.length)switch(r[0]){case"self":o=t[r[1]];break;case"parent":o=i[i.length-1][r[1]];break;case"tempData":o=d[r[1]];break;case"sibling":o=p(r[1],c,t,!0)}else 3===r.length?o=JSON.parse(JSON.stringify(i)).reverse()[r[1]-1][r[2]]:1===r.length&&(o=r[0]-0);u.splice(a,1,o||0)});var m=n.match(/\([\\+|\-|\\*|\\/]\)/g).map(function(e){return e.replace(/\(|\)/g,"")}),h="",b=function(e){if(Object(a.a)(e))return"number";if("string"==typeof e&&/^[0-9]{4}\-[0-9]{2}\-[0-9]{2}/.test(e))return"date"}(u[0]);return"number"===b?(u.forEach(function(e,t){m[t]?h+=e+m[t]:h+=e}),parseFloat(Object(s.i)(h).toFixed(l||o.a.precision))):"date"===b?(u.forEach(function(e,t){var i=r.a.timeStamp(e);m[t]?h+=i+m[t]:h+=i}),r.a.formatDate(Object(s.i)(h))):0}function p(e,t,i,a,r){var o=[],s=0,c=t.findIndex(function(e){return e.id===i.id});return t.forEach(function(t,i){c!==i&&o.push(t[e])}),a?o.forEach(function(e){s+=e-0}):s=r?Math.min.apply(Math,o):Math.max.apply(Math,o),s}},MtNS:function(e,t,i){"use strict";var a=i("Mugr");i.n(a).a},Mugr:function(e,t,i){},S8Ej:function(e,t,i){},TB3a:function(e,t,i){"use strict";i("a1Th"),i("SRfc"),i("KKXr");t.a={timeStamp:function(e){if("string"==typeof e){var t=e.split(" ");if(1===t.length){var i=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);return null===i?(new Date).getTime():new Date(i[1],i[3]-1,i[4]).getTime()}var a=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/),r=t[1].match(/^(\d{1,2})(-|\:)(\d{1,2})\2(\d{1,2})$/);return a&&r?new Date(a[1],a[3]-1,a[4],r[1],r[3],r[4]).getTime():(new Date).getTime()}return"number"==typeof e?864e5*e:(new Date).getTime()},formatDate:function(e,t){var i=e?new Date(e):new Date,a=i.getFullYear(),r=i.getMonth()+1,o=i.getDate(),s=i.getHours(),c=i.getMinutes(),n=i.getSeconds(),d=function(e){return(e=e.toString())[1]?e:"0"+e};return[a,r,o].map(d).join(t||"-")+" "+[s,c,n].map(d).join(":")}}},ghff:function(e,t,i){"use strict";var a=i("S8Ej");i.n(a).a},kjwg:function(e,t,i){},mwzG:function(e,t,i){"use strict";t.a={code:0,msg:"执行成功!",result:{hideTitles:["id","productGenre","productUnit","parentId","warehouseId","productId","code","executeCount","state","cuser","uuser","remark","isdisable","qrcode","businessId"],pageData:{current:1,pages:"1",records:[],size:10,total:"1"},titles:[{progress:"进度"},{warehouseOutCode:"出库单编码"},{productCode:"货品编码"},{productName:"货品名称"},{productSpec:" 规格/型号"},{productGenreName:"货品属性"},{productUnitName:"计量单位"},{count:"出库数量"},{id:"id"},{productGenre:"货品属性ID"},{productUnit:"计量单位ID"},{parentId:"出库单ID"},{warehouseId:" (推荐)货位ID"},{productId:"产品ID"},{code:"批次号"},{executeCount:"已出库数量"},{state:"状态"},{cuser:"创建用户id"},{cdate:"创建时间"},{uuser:"修改用户id"},{udate:"修改时间"},{remark:"备注"},{isdisable:"是否启用"},{qrcode:"二维码"},{businessId:"业务id"}],varList:[{businessId:"",cdate:"3",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",isdisable1:"1",isdisable2:"0",isdisable3:"1",isdisable4:"1",name:"12",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.jpg",imgPath:"fileUpload/QRCode/product/1539142716704586.png",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",isdisable2:"1",isdisable3:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"219967d2f6704d868b11002caef9885c",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"2",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"1",productSpec:"22222222222222222222",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"55",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"3"},{businessId:"",cdate:"1",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"885c219967d2f6704d868b11002caef9",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"3",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"0",productSpec:"2111111111111111111",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"2"}]}}}}]);