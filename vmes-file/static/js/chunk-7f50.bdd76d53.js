(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7f50","chunk-042c","chunk-c9f5"],{"50Ol":function(e,t,i){"use strict";i("rGqo"),i("KKXr"),i("91GP");var a={name:"custom-summary-option",props:{customSummary:{type:Object,default:function(){return{}}},tableData:{type:Array,default:function(){return[]}},tempData:{type:Object,default:function(){return{}}}},data:function(){return{boxDefaultStyle:{width:"600px",float:"left"},data:{}}},directives:{"send-height":{inserted:function(e,t,i){i.context.$emit("send-height",e.clientHeight)}}},computed:{setStyle:function(){return this.customSummary.boxStyle||this.boxDefaultStyle},setData:function(){return this.customSummary.computes&&this.createFormula(this.customSummary.computes,this.tableData,this.tempData),this.data}},created:function(){this.data=this.customSummary.data,this.customSummary.apiObj&&this.customSummary.apiObj.apiName&&this.httpRequests()},mounted:function(){},methods:{httpRequests:function(){var e=this;try{this.$api[this.customSummary.apiObj.apiName](Object.assign({},this.customSummary.apiObj.params)).then(function(t){t.result&&e.assignmentFn(t.result)}).catch(function(e){console.log(e)})}catch(e){console.log(e)}},assignmentFn:function(e){for(var t in this.data)this.data.hasOwnProperty(t)&&(this.data[t]=e[t])},createFormula:function(e,t,i){for(var a in e)if(e.hasOwnProperty(a)){var o=e[a].split(/\([\\+|\-|\\*|\\/]\)/);if(o.length>1)o.forEach(function(e){});else{var s=e[a].split("@");"table"===s[0]&&(this.data[a]=this.getSum(s[1],t))}}},getSum:function(e,t){var i=0;return t.forEach(function(t){i+=t[e]-0}),i},customSummaryValue:function(e){this.$emit("custom-summary-value",e)}}},o=(i("MtNS"),i("KHd+")),s=Object(o.a)(a,function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"customSummaryOption clearfix"},[t(this.customSummary.component,{directives:[{name:"send-height",rawName:"v-send-height"}],tag:"component",attrs:{data:this.setData,tempData:this.tempData,setStyle:this.customSummary.boxStyle},on:{"custom-summary-value":this.customSummaryValue}})],1)},[],!1,null,null,null);s.options.__file="index.vue";t.a=s.exports},DKCI:function(e,t,i){"use strict";i("rGqo"),i("INYr");var a={name:"table-filter",props:{headerList:{type:Array,default:function(){return[]}},showAll:{type:Boolean,default:!1},storeId:{type:String,default:""},componentId:{type:String,default:""}},directives:{"auto-width":{inserted:function(e,t,i){i.context.widthList[t.value]=e.clientWidth}}},data:function(){return{checkList:[],widthSwitch:!1,checkViewWidth:0,checkViewHeight:0,checkViewWidthTimer:"",widthList:[],userConfig:"",storeKey:"",userId:"",localStoreKey:"",useStore:!1,tempList:""}},created:function(){this.storeKey="tableFilter"+this.storeId,this.userId=this.$storage.get("userInfo").userId||"",this.tempList=this.localStore(this.componentId,this.storeKey,this.userId),this.$emit("checked-list",this.tempList)},computed:{setHeight:function(){return this.checkViewHeight&&this.widthSwitch?(this.$emit("checked-height",this.checkViewHeight),this.checkViewHeight):(this.$emit("checked-height",20),20)},setHeaderList:function(){var e=this;return this.headerList.filter(function(t){return e.showAll?t:!t.component})}},methods:{checkedList:function(e){localStorage.setItem(this.localStoreKey,JSON.stringify(e)),this.$emit("checked-list",e)},viewSwitch:function(){this.widthSwitch=!this.widthSwitch},localStore:function(e,t,i){return this.localStoreKey="_"+e+t+i,JSON.parse(localStorage.getItem(this.localStoreKey))||""},setChecked:function(e){return!this.tempList||!Array.isArray(this.tempList)||this.tempList.findIndex(function(t){return t===e.label})>-1}},watch:{widthSwitch:function(){var e=this;this.widthSwitch&&!this.checkViewHeight&&(clearTimeout(this.checkViewWidthTimer),this.checkViewWidthTimer=setTimeout(function(t){var i=0;e.widthList.forEach(function(e){e-0&&(i+=e+15)}),e.checkViewHeight=20*Math.ceil(i/e.$refs.checkBoxView.clientWidth)},200))}}},o=(i("DlFo"),i("KHd+")),s=Object(o.a)(a,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"tableFilter",style:{height:e.setHeight+"px"}},[i("div",{staticClass:"msg",attrs:{title:"列开关"},on:{click:e.viewSwitch}},[i("svg-icon",{attrs:{"icon-class":"tableSetting"}})],1),e._v(" "),i("div",{ref:"checkBoxView",staticClass:"checkView",class:{setWidth:e.widthSwitch}},[i("div",{staticStyle:{position:"relative"}},[i("div",{staticStyle:{position:"absolute",top:"0",left:"0"}},[i("el-checkbox-group",{attrs:{size:"mini"},on:{change:e.checkedList},model:{value:e.checkList,callback:function(t){e.checkList=t},expression:"checkList"}},e._l(e.setHeaderList,function(t,a){return i("el-checkbox",{directives:[{name:"auto-width",rawName:"v-auto-width",value:a,expression:"index"}],key:t.prop,attrs:{label:t.label,checked:e.setChecked(t)}})}),1)],1)])])])},[],!1,null,"2ad1a997",null);s.options.__file="index.vue";t.a=s.exports},DlFo:function(e,t,i){"use strict";var a=i("kjwg");i.n(a).a},F9dT:function(e,t,i){"use strict";i.d(t,"a",function(){return c}),i.d(t,"c",function(){return d}),i.d(t,"b",function(){return u});i("pIFo"),i("SRfc"),i("KKXr"),i("INYr"),i("rGqo");var a=i("Yfch"),o=i("TB3a"),s=i("YP4+"),n=i("z0WU"),r=function(){return function(e,t,i){var o,s,n;t?(s=t-0,o=!0,n=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,i){i<e.ops.length-1&&(n?Object(a.a)(t-0)?(!Object(a.a)(s)||t-0>s)&&(o=!1):t-0>s&&(o=!1):Object(a.a)(t-0)?(!Object(a.a)(s)||t-0>=s)&&(o=!1):t-0>=s&&(o=!1))}),o?i():i(new Error(e.message))):i(new Error("不能为空"))}},l=function(){return function(e,t,i){var o,s,n;t?(s=t-0,o=!0,n=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,i){i<e.ops.length-1&&(n?Object(a.a)(t-0)?(!Object(a.a)(s-0)||s>t-0)&&(o=!1):s>t-0&&(o=!1):Object(a.a)(t-0)?(!Object(a.a)(s-0)||s>=t-0)&&(o=!1):s>=t-0&&(o=!1))}),o?i():i(new Error(e.message))):i(new Error("不能为空"))}};function c(e,t,i,a,o,s,n,c,u,h,p){var m,g,f,b,v;return e&&(m=d(e.greaterThan,o,s,u,!0,h)),b=c.findIndex(function(e){return e.greaterThan}),t&&(g=d(t.lessThan,o,s,u,!1,h)),v=c.findIndex(function(e){return e.lessThan}),f=[],m&&f.push({validator:r(),trigger:"blur",message:n[p||b],ops:m}),g&&f.push({validator:l(),trigger:"blur",message:n[p||v],ops:g}),f}function d(e,t,i,a,o,s,n){var r;"boolean"==typeof(e=JSON.parse(JSON.stringify(e)))[e.length-1]&&(r=e.pop());var l=e.map(function(e){return""});return e.forEach(function(e,r){var c=e.split(/\([\\+|\-|\\*|\\/]\)/);if(c.length>1)l.splice(r,1,u(c,t,i,a,e,s,n));else if(-1!==e.indexOf("@")){var d=e.split("@");2===d.length&&"self"===d[0]&&l.splice(r,1,t[d[1]]),2===d.length&&"parent"===d[0]&&l.splice(r,1,i[0][d[1]]),2===d.length&&"tempData"===d[0]&&l.splice(r,1,s[d[1]]),2===d.length&&"sibling"===d[0]&&l.splice(r,1,h(d[1],a,t,!1,o)),3===d.length&&"parent"===d[0]&&l.splice(r,1,JSON.parse(JSON.stringify(i)).reverse()[d[1]-1][d[2]])}else l.splice(r,1,e)}),"boolean"==typeof r?l.push(r):l.push(!0),l}function u(e,t,i,r,l,c,d){var u=e.map(function(e){return""});e.forEach(function(e,a){var o=e.split("@"),s=0;if(2===o.length)switch(o[0]){case"self":s=t[o[1]];break;case"parent":s=i[i.length-1][o[1]];break;case"tempData":s=c[o[1]];break;case"sibling":s=h(o[1],r,t,!0)}else 3===o.length?s=JSON.parse(JSON.stringify(i)).reverse()[o[1]-1][o[2]]:1===o.length&&(s=o[0]-0);u.splice(a,1,s||0)});var p=l.match(/\([\\+|\-|\\*|\\/]\)/g).map(function(e){return e.replace(/\(|\)/g,"")}),m="",g=function(e){if(Object(a.a)(e))return"number";if("string"==typeof e&&/^[0-9]{4}\-[0-9]{2}\-[0-9]{2}/.test(e))return"date"}(u[0]);return"number"===g?(u.forEach(function(e,t){p[t]?m+=e+p[t]:m+=e}),parseFloat(Object(n.h)(m).toFixed(d||s.a.precision))):"date"===g?(u.forEach(function(e,t){var i=o.a.timeStamp(e);p[t]?m+=i+p[t]:m+=i}),o.a.formatDate(Object(n.h)(m))):0}function h(e,t,i,a,o){var s=[],n=0,r=t.findIndex(function(e){return e.id===i.id});return t.forEach(function(t,i){r!==i&&s.push(t[e])}),a?s.forEach(function(e){n+=e-0}):n=o?Math.min.apply(Math,s):Math.max.apply(Math,s),n}},KC3E:function(e,t,i){"use strict";i.r(t);i("rGqo"),i("Oyvg");var a=i("WIyV"),o=i("91ra"),s={components:{customBaseTable:a.a,dialogAdd:l},props:["initData","visible"],data:function(){return{customerId:"",deliverDtlIds:"",openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",orderDetail_style:"",title:"",temp:null,tempLable:null},tableData:[],rowTableList:[],apiObj:{apiName:"listPageDeliverDetailByRetreat",params:{pageNo:1,deliverDtlIds:"",state:"1",fieldCode:"sysOrderCode,deliverCode,productCode,productName,productSpec,orderUnitName,receiveAmount,notRetreatSum,orderCount,notRetreatCount,retreatOrderCount,productPrice,retreatOrderSum,retreatRemark"}},customColumn:[{columnIndex:"retreatOrderCount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"retreatOrderSum",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"],compute:"self@retreatOrderCount(*)self@productPrice",editable:!0}},{columnIndex:"retreatRemark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.customerId=this.initData.customerId,this.deliverDtlIds=this.initData.deliverDtlIds,this.apiObj.params.deliverDtlIds=this.deliverDtlIds},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){this.rowTableList=[],Array.isArray(e)&&(this.rowTableList=e)},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i],o=a.retreatOrderCount;o-a.notRetreatCount>0&&(t=t+"第 "+(i+1)+" 行: 本次退货数量("+o+") 输入错误，本次退货数量不可大于可退货数量！");var s=a.notRetreatSum,n=a.retreatOrderSum;s-0==0&&n-s>0?t=t+"第 "+(i+1)+" 行: 退货金额("+n+") 输入错误，退货金额必须等于零！":s-0!=0&&n-s>0&&(t=t+"第 "+(i+1)+" 行: 退货金额("+n+") 输入错误，退货金额不可大于可退金额！")}return t},save:function(){this.$refs.retreatAddDialog.getData(),this.saveSaleRetreat(this.rowTableList)},saveSaleRetreat:function(e){var t=this;if(null!=e&&0!=e.length){var i=this.checkColumn(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{var a=[];e.forEach(function(e){var t={deliverDetailId:e.id,orderDetailId:e.orderDetaiId,productId:e.productId,orderSum:e.retreatOrderSum,orderUnit:e.orderUnit,orderCount:e.retreatOrderCount,productUnit:e.productUnit,remark:e.retreatRemark,sysOrderCode:e.orderId,orderId:e.orderId,receiveAmount:e.receiveAmount,notRetreatSum:e.notRetreatSum,n2pFormula:e.n2pFormula,p2nFormula:e.p2nFormula};a.push(t)});var s="";null!=a&&a.length>0&&(s=JSON.stringify(a)),null!=s&&0!=s?Object(o.addSaleRetreat)({customerId:this.customerId,dtlJsonStr:s}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"暂无发货单明细！"})}}},dialogOpen:function(){},dialogClose:function(e){this.rowTableList=[],this.customerId="",this.deliverDtlIds="",this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},n=i("KHd+"),r=Object(n.a)(s,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{style:e.initData.orderDetail_style},[i("custom-base-table",{ref:"retreatAddDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"retreatAddDialog",useDefaultBtn:!0,showAll:!1},on:{databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="dialogAdd.vue";var l=t.default=r.exports},MtNS:function(e,t,i){"use strict";var a=i("Mugr");i.n(a).a},Mugr:function(e,t,i){},TB3a:function(e,t,i){"use strict";i("a1Th"),i("SRfc"),i("KKXr");t.a={timeStamp:function(e){if("string"==typeof e){var t=e.split(" ");if(1===t.length){var i=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);return null===i?(new Date).getTime():new Date(i[1],i[3]-1,i[4]).getTime()}var a=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/),o=t[1].match(/^(\d{1,2})(-|\:)(\d{1,2})\2(\d{1,2})$/);return a&&o?new Date(a[1],a[3]-1,a[4],o[1],o[3],o[4]).getTime():(new Date).getTime()}return"number"==typeof e?864e5*e:(new Date).getTime()},formatDate:function(e,t){var i=e?new Date(e):new Date,a=i.getFullYear(),o=i.getMonth()+1,s=i.getDate(),n=i.getHours(),r=i.getMinutes(),l=i.getSeconds(),c=function(e){return(e=e.toString())[1]?e:"0"+e};return[a,o,s].map(c).join(t||"-")+" "+[n,r,l].map(c).join(":")}}},Uv1H:function(e,t,i){"use strict";i.r(t);var a=i("WIyV"),o=i("qQoz"),s={components:{customBaseTable:a.a,dialogDeliver:o.default},props:["initData","visible"],data:function(){return{rules:{},resState:"",openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",orderDetail_style:"",customerId:"",title:"",temp:null,tempLable:null},tableData:[],rowTableList:[],apiObj:{apiName:"listPageCustomers",params:{pageNo:1,genre:"df7cb67fca4148bc9632c908e4a7fdea",fieldCode:"code,name,typeName"}},customColumn:[],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){this.rowTableList=[],Array.isArray(e)&&(this.rowTableList=e)},save:function(){var e="";if(null==this.rowTableList||0==this.rowTableList.length?e="请选择一行数据！":this.rowTableList.length>1&&(e="请选择一行数据，只允许单选！"),e.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:e});else{var t=this.rowTableList[0].id;this.dialogData.customerId=t;var i=document.body.clientWidth,a=(document.body.clientHeight,.7*i);this.dialogData.dialog_width=a+"px";var o=.666*(.618*a)+"px";this.dialogData.orderDetail_style="height:"+o+";width: 96%;margin-left: 2%;",this.dialogData.title="发货单列表",this.openDialogName="dialogDeliver",this.showDialog=!0,this.inLinVisible=!0}},dialogOpen:function(){},dialogClose:function(e){(e={}).resState=this.resState,this.$emit("close-dialog",e||{})},closeDialog:function(e){e.resState&&(this.resState=e.resState),this.isVisible=!1}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},n=i("KHd+"),r=Object(n.a)(s,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{style:e.initData.orderDetail_style},[i("custom-base-table",{ref:"customerDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,showCheckBox:!0,isSingle:!0,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"customerDialog",useDefaultBtn:!0,showAll:!1},on:{databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="dialogCustomer.vue";t.default=r.exports},kjwg:function(e,t,i){},mwzG:function(e,t,i){"use strict";t.a={code:0,msg:"执行成功!",result:{hideTitles:["id","productGenre","productUnit","parentId","warehouseId","productId","code","executeCount","state","cuser","uuser","remark","isdisable","qrcode","businessId"],pageData:{current:1,pages:"1",records:[],size:10,total:"1"},titles:[{progress:"进度"},{warehouseOutCode:"出库单编码"},{productCode:"货品编码"},{productName:"货品名称"},{productSpec:" 规格/型号"},{productGenreName:"货品属性"},{productUnitName:"计量单位"},{count:"出库数量"},{id:"id"},{productGenre:"货品属性ID"},{productUnit:"计量单位ID"},{parentId:"出库单ID"},{warehouseId:" (推荐)货位ID"},{productId:"产品ID"},{code:"批次号"},{executeCount:"已出库数量"},{state:"状态"},{cuser:"创建用户id"},{cdate:"创建时间"},{uuser:"修改用户id"},{udate:"修改时间"},{remark:"备注"},{isdisable:"是否启用"},{qrcode:"二维码"},{businessId:"业务id"}],varList:[{businessId:"",cdate:"3",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",isdisable1:"1",isdisable2:"0",isdisable3:"1",isdisable4:"1",name:"12",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.jpg",imgPath:"fileUpload/QRCode/product/1539142716704586.png",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",isdisable2:"1",isdisable3:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"219967d2f6704d868b11002caef9885c",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"2",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"111",productSpec:"22222222222222222222",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"55",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"3"},{businessId:"",cdate:"1",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"885c219967d2f6704d868b11002caef9",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"3",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2111111111111111111",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"2"}]}}},qQoz:function(e,t,i){"use strict";i.r(t);i("rGqo"),i("91GP");var a=i("lX1r"),o=i("uTIz"),s=i("KC3E"),n={components:{expandTable:a.a,searchBar:o.a,dialogAdd:s.default},props:["initData","visible"],data:function(){return{customerId:"",deliverDtlState:"1",searchList:[{label:"发货单编号",type:"input",ruleType:"string",mapKey:"deliverCode",configs:{},placeholder:"发货单编号"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"}],searchObj:{},guid:"",customColumn:{},tableSets:{1:{showCheckBox:!1,showIndex:!1,expandOne:!1},2:{showCheckBox:!0,showIndex:!1,isExpands:!1,isSortable:!1,isSingle:!1}},initDataByTable:{},childrenData:{},currentpage:1,maxLayer:2,expandTableApiList:["listPageSaleDeliver","listPageSaleDeliverDetail"],expandTableApiParams:[{customerId:"",detailState:"",fieldCode:""},{parentId:"",state:"",fieldCode:""}],updateViewData:{},rowTableList:[],resState:"",openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,showDialog:!1,inLinVisible:!1,dialogData:{customerId:"",deliverDtlIds:"",dialog_width:"",orderDetail_style:"",title:"",temp:null,tempLable:null}}},beforeCreate:function(){},created:function(){this.customerId=this.initData.customerId,this.expandTableApiParams[0].customerId=this.customerId,this.expandTableApiParams[0].detailState=this.deliverDtlState,this.expandTableApiParams[0].fieldCode="deliverCode,customerCode,customerName,customerTypeName,stateName,deliverDate",this.expandTableApiParams[1].state=this.deliverDtlState,this.expandTableApiParams[1].fieldCode="productCode,productName,productSpec,productGenreName,orderUnitName,orderCount,sum,remark",this.initExpandTable()},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{setParams:function(e,t,i){var a=Object.assign({},this.expandTableApiParams[e-1]);for(var o in a)a.hasOwnProperty(o)&&!a[o]&&(a[o]=t[o]||"");return Object.assign({},a,this.searchObj,{pageNo:i})},initExpandTable:function(){var e=this;this.$api[this.expandTableApiList[0]](this.setParams(1,this.expandTableApiParams[0],this.currentpage)).then(function(t){e.initDataByTable={row:null,layer:1,res:t,customColumn:e.customColumn}}).catch(function(e){})},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.initExpandTable()},tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},databridge:function(e){this.rowTableList=e},findChildByRow:function(e,t,i,a,o){var s=this;this.$api[this.expandTableApiList[t-1]](this.setParams(t,e,o)).then(function(i){s.childrenData={row:e,layer:t,res:i,customColumn:s.customColumn}}).catch(function(e){})},save:function(){var e="";if(null!=this.rowTableList&&0!=this.rowTableList.length||(e="请选择一行数据！"),e.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:e});else{var t="";this.rowTableList.forEach(function(e){null!=e.id&&e.id.trim().length>0&&(t=t+e.id.trim()+",")}),this.dialogData.deliverDtlIds=t,this.dialogData.customerId=this.customerId;var i=document.body.clientWidth,a=(document.body.clientHeight,.7*i);this.dialogData.dialog_width=a+"px";var o=.666*(.618*a)+"px";this.dialogData.orderDetail_style="height:"+o+";width: 96%;margin-left: 2%;",this.dialogData.title="退货列表",this.openDialogName="dialogAdd",this.showDialog=!0,this.inLinVisible=!0}},dialogOpen:function(){},dialogClose:function(e){this.customerId="",(e={}).resState=this.resState,this.$emit("close-dialog",e||{})},closeDialog:function(e){e.resState&&(this.resState=e.resState),this.isVisible=!1}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},r=i("KHd+"),l=Object(r.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{style:e.initData.orderDetail_style},[i("expand-table",{attrs:{initData:e.initDataByTable,childrenData:e.childrenData,configs:e.tableSets,currentpage:e.currentpage,maxLayer:e.maxLayer,apiObj:{apiName:e.expandTableApiList,apiParams:e.expandTableApiParams},updateViewData:e.updateViewData},on:{"update:currentpage":function(t){e.currentpage=t},databridge:e.databridge,"send-children-row":e.findChildByRow}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogDeliver.vue";t.default=l.exports}}]);