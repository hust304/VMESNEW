(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-0241"],{"50Ol":function(e,t,i){"use strict";i("rGqo"),i("KKXr"),i("91GP");var a={name:"custom-summary-option",props:{customSummary:{type:Object,default:function(){return{}}},tableData:{type:Array,default:function(){return[]}},tempData:{type:Object,default:function(){return{}}}},data:function(){return{boxDefaultStyle:{width:"600px",float:"left"},data:{}}},directives:{"send-height":{inserted:function(e,t,i){i.context.$emit("send-height",e.clientHeight)}}},computed:{setStyle:function(){return this.customSummary.boxStyle||this.boxDefaultStyle},setData:function(){return this.customSummary.computes&&this.createFormula(this.customSummary.computes,this.tableData,this.tempData),this.data}},created:function(){this.data=this.customSummary.data,this.customSummary.apiObj&&this.customSummary.apiObj.apiName&&this.httpRequests()},mounted:function(){},methods:{httpRequests:function(){var e=this;try{this.$api[this.customSummary.apiObj.apiName](Object.assign({},this.customSummary.apiObj.params)).then(function(t){t.result&&e.assignmentFn(t.result)}).catch(function(e){})}catch(e){}},assignmentFn:function(e){for(var t in this.data)this.data.hasOwnProperty(t)&&(this.data[t]=e[t])},createFormula:function(e,t,i){for(var a in e)if(e.hasOwnProperty(a)){var o=e[a].split(/\([\\+|\-|\\*|\\/]\)/);if(o.length>1)o.forEach(function(e){});else{var s=e[a].split("@");"table"===s[0]&&(this.data[a]=this.getSum(s[1],t))}}},getSum:function(e,t){var i=0;return t.forEach(function(t){i+=t[e]-0}),i},customSummaryValue:function(e){this.$emit("custom-summary-value",e)}}},o=(i("MtNS"),i("KHd+")),s=Object(o.a)(a,function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"customSummaryOption clearfix"},[t(this.customSummary.component,{directives:[{name:"send-height",rawName:"v-send-height"}],tag:"component",attrs:{data:this.setData,tempData:this.tempData,setStyle:this.customSummary.boxStyle},on:{"custom-summary-value":this.customSummaryValue}})],1)},[],!1,null,null,null);s.options.__file="index.vue";t.a=s.exports},"67kp":function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("91GP");var a=i("fFUy"),o=i("uTIz"),s=i("HltP");function n(e){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var c={props:["colConfig","scope"],template:'<div class="btnBox">\n              <el-button v-show="colConfig.infoByParent_isShow" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.infoByParent(scope.row,scope.$index)">详情</el-button>\n    \t\t\t\t </div>'},r={components:{searchBar:o.a,customRowTable:a.a,dialogAdd:s.default},name:"dialog-add",props:["initData","visible"],data:function(){return{rowTableList:[],orderData:{id:"",customerId:"",receiptType:"",receiptTypeName:"",custInvoiceCompanyName:"",custInvoiceNumber:"",custInvoiceAddress:"",custInvoiceBankName:"",custInvoiceBankCode:"",custInvoiceMobile:"",custInvoicePhone:""},guid:"",searchList:[{label:"订单编号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单编号"}],openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",temp:null,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,resState:"",temp:{},tempLable:{},currentpage:1,searchObj:{},customColumn:{0:[{columnIndex:"last",prop:"operate",label:"操作",component:c,infoByParent_isShow:!0}],1:[{}]},tableSets:{0:{showCheckBox:!0,showIndex:!0,expandOne:!1,isSortable:!1,showPageData:!0,isSingle:!0},1:{showCheckBox:!1,showIndex:!1,isSortable:!1,isSingle:!0}},precision:2,apiObj:{apiName:"listPageOrderByInvoice",params:{pageNo:1}},mergeColumn:{0:[{index:3,columns:["orderDate","expectDate"]},{index:6,columns:["orderSum","receiveSum"]},{index:7,columns:["deliverSum","invoiceSum"]}]}}},created:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=n(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName},setApiObj:function(){var e=Object.assign({},this.apiObj.params,this.searchObj);return{apiName:this.apiObj.apiName,params:e}}},methods:{getData:function(){this.$refs.orderTableByInvoice.getData()},formData:function(e){},databridge:function(e){Array.isArray(e)&&(this.rowTableList=[],this.rowTableList=e)},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",{resState:this.resState})},rowTableList2OrderData:function(e){if(this.orderData={id:"",customerId:"",receiptType:"",receiptTypeName:"",custInvoiceCompanyName:"",custInvoiceNumber:"",custInvoiceAddress:"",custInvoiceBankName:"",custInvoiceBankCode:"",custInvoiceMobile:"",custInvoicePhone:""},null!=e&&0!=e.length){var t=e[0];this.orderData.id=t.id,this.orderData.customerId=t.customerId,this.orderData.receiptType=t.receiptType,this.orderData.receiptTypeName=t.receiptTypeName,this.orderData.custInvoiceCompanyName=t.custInvoiceCompanyName,this.orderData.custInvoiceNumber=t.custInvoiceNumber,this.orderData.custInvoiceAddress=t.custInvoiceAddress,this.orderData.custInvoiceBankName=t.custInvoiceBankName,this.orderData.custInvoiceBankCode=t.custInvoiceBankCode,this.orderData.custInvoiceMobile=t.custInvoiceMobile,this.orderData.custInvoicePhone=t.custInvoicePhone}},addInvoice:function(){this.$refs.orderTableByInvoice.getData(),null!=this.rowTableList&&0!=this.rowTableList.length?(this.rowTableList2OrderData(this.rowTableList),this.dialogData.temp=this.orderData,this.dialogData.title="选择订单",this.openDialogName="dialogAdd",this.showDialog=!0,this.inLinVisible=!0):this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条数据！"})},closeDialog:function(e){"ok"==e.resState&&(this.resState="ok",this.isVisible=!1)}}},d=i("KHd+"),l=Object(d.a)(r,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticStyle:{height:"450px",width:"98%",margin:"0 1%",border:"1px solid #ebeef5"}},[i("custom-row-table",{ref:"orderTableByInvoice",attrs:{"expand-all":!0,keyValue:!0,configs:e.tableSets,currentpage:e.currentpage,customColumn:e.customColumn,editable:{},precision:e.precision,apiObj:e.setApiObj,mergeColumn:e.mergeColumn},on:{"update:currentpage":function(t){e.currentpage=t},"get-data":e.formData,databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.addInvoice}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogOrderByInvoice.vue";t.default=l.exports},DKCI:function(e,t,i){"use strict";i("rGqo"),i("INYr");var a={name:"table-filter",props:{headerList:{type:Array,default:function(){return[]}},showAll:{type:Boolean,default:!1},storeId:{type:String,default:""},componentId:{type:String,default:""}},directives:{"auto-width":{inserted:function(e,t,i){i.context.widthList[t.value]=e.clientWidth}}},data:function(){return{checkList:[],widthSwitch:!1,checkViewWidth:0,checkViewHeight:0,checkViewWidthTimer:"",widthList:[],userConfig:"",storeKey:"",userId:"",localStoreKey:"",useStore:!1,tempList:""}},created:function(){this.storeKey="tableFilter"+this.storeId,this.userId=this.$storage.get("userInfo").userId||"",this.tempList=this.localStore(this.componentId,this.storeKey,this.userId),this.$emit("checked-list",this.tempList)},computed:{setHeight:function(){return this.checkViewHeight&&this.widthSwitch?(this.$emit("checked-height",this.checkViewHeight),this.checkViewHeight):(this.$emit("checked-height",20),20)},setHeaderList:function(){var e=this;return this.headerList.filter(function(t){return e.showAll?t:!t.component})}},methods:{checkedList:function(e){localStorage.setItem(this.localStoreKey,JSON.stringify(e)),this.$emit("checked-list",e)},viewSwitch:function(){this.widthSwitch=!this.widthSwitch},localStore:function(e,t,i){return this.localStoreKey="_"+e+t+i,JSON.parse(localStorage.getItem(this.localStoreKey))||""},setChecked:function(e){return!this.tempList||!Array.isArray(this.tempList)||this.tempList.findIndex(function(t){return t===e.label})>-1}},watch:{widthSwitch:function(){var e=this;this.widthSwitch&&!this.checkViewHeight&&(clearTimeout(this.checkViewWidthTimer),this.checkViewWidthTimer=setTimeout(function(t){var i=0;e.widthList.forEach(function(e){e-0&&(i+=e+15)}),e.checkViewHeight=20*Math.ceil(i/e.$refs.checkBoxView.clientWidth)},200))}}},o=(i("DlFo"),i("KHd+")),s=Object(o.a)(a,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"tableFilter",style:{height:e.setHeight+"px"}},[i("div",{staticClass:"msg",attrs:{title:"列开关"},on:{click:e.viewSwitch}},[i("svg-icon",{attrs:{"icon-class":"tableSetting"}})],1),e._v(" "),i("div",{ref:"checkBoxView",staticClass:"checkView",class:{setWidth:e.widthSwitch}},[i("div",{staticStyle:{position:"relative"}},[i("div",{staticStyle:{position:"absolute",top:"0",left:"0"}},[i("el-checkbox-group",{attrs:{size:"mini"},on:{change:e.checkedList},model:{value:e.checkList,callback:function(t){e.checkList=t},expression:"checkList"}},e._l(e.setHeaderList,function(t,a){return i("el-checkbox",{directives:[{name:"auto-width",rawName:"v-auto-width",value:a,expression:"index"}],key:t.prop,attrs:{label:t.label,checked:e.setChecked(t)}})}),1)],1)])])])},[],!1,null,"2ad1a997",null);s.options.__file="index.vue";t.a=s.exports},DlFo:function(e,t,i){"use strict";var a=i("kjwg");i.n(a).a},HltP:function(e,t,i){"use strict";i.r(t);i("Oyvg");var a=i("WIyV"),o=i("CK78"),s={components:{customBaseTable:a.a},props:["initData","visible"],data:function(){return{fieldCode:"productCode,productName,productSpec,productGenreName,priceUnitName,orderCount,productPrice,productSum,notInvoiceCount,count,nowInvoiceSum",receiptType:"1",productUnit:{},rowData:{},rules:{},openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],rowTableList:[],configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},apiObj:{apiName:"listPageOrderDetailByInvoice",params:{pageNo:1,fieldCode:"",parentId:""}},customColumn:[{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"nowInvoiceSum",_cellConfig:{hideTitle:!0,compute:"self@count(*)self@productPrice"}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.temp=this.initData.temp,null!=this.initData.temp.receiptType&&this.initData.temp.receiptType.trim().length>0&&(this.receiptType=this.initData.temp.receiptType.trim()),null!=this.initData.temp.id&&this.initData.temp.id.trim().length>0&&(this.apiObj.params.parentId=this.initData.temp.id.trim()),this.apiObj.params.fieldCode=this.fieldCode},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){Array.isArray(e)&&(this.rowTableList=[],this.rowTableList=e,this.saveSaleOrder(this.rowTableList))},save:function(){this.$refs.orderAddByInvoiceDialog.getData()},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i],o=a.notInvoiceCount,s=a.count;null==s||0==s.trim().length?t=t+"第 "+(i+1)+" 行: 开票数量为空或空字符串！":null!=s&&s.trim().length>0&&!this.isNumberByValue(s.trim())&&(t=t+"第 "+(i+1)+" 行: 开票数量("+s+") 输入错误，请输入大于零的正整数或(1,2)位小数！"),s-o>0&&(t=t+"第 "+(i+1)+" 行: 开票数量("+s+") 输入错误，开票数量不可大于未开票数量！")}return t},saveSaleOrder:function(e){var t=this,i=this.checkColumn(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{for(var a=[],s=0;s<e.length;s++){var n=e[s];n.orderCount=n.count,a.push(n)}this.temp.dtlJsonStr="",null!=a&&a.length>0&&(this.temp.dtlJsonStr=JSON.stringify(a)),this.dialogLoading=!0,Object(o.addSaleInvoice)(this.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},n=i("KHd+"),c=Object(n.a)(s,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",{staticStyle:{margin:"10px 50px"}},[i("el-radio-group",{model:{value:e.receiptType,callback:function(t){e.receiptType=t},expression:"receiptType"}},[i("el-radio",{attrs:{label:"1"}},[e._v("不开票")]),e._v(" "),i("el-radio",{attrs:{label:"2"}},[e._v("增值税普通发票")]),e._v(" "),i("el-radio",{attrs:{label:"3"}},[e._v("增值税专用发票")])],1)],1),e._v(" "),i("div",{staticStyle:{"padding-left":"50px"}},[i("p",[i("a",[e._v("公司名称:")]),e._v(e._s(e.temp.custInvoiceCompanyName))]),e._v(" "),i("p",[i("a",[e._v("发票税号:")]),e._v(e._s(e.temp.custInvoiceNumber))]),e._v(" "),i("p",[i("a",[e._v("地址:")]),e._v(e._s(e.temp.custInvoiceAddress))]),e._v(" "),i("p",[i("a",[e._v("电话:")]),e._v(e._s(e.temp.custInvoiceMobile))]),e._v(" "),i("p",[i("a",[e._v("开户银行:")]),e._v(e._s(e.temp.custInvoiceBankName))]),e._v(" "),i("p",[i("a",[e._v("银行账号:")]),e._v(e._s(e.temp.custInvoiceBankCode))])]),e._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[i("custom-base-table",{ref:"orderAddByInvoiceDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"orderAddByInvoiceDialog",useDefaultBtn:!0,showAll:!1},on:{databridge:e.databridge}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);c.options.__file="dialogAdd.vue";t.default=c.exports},MtNS:function(e,t,i){"use strict";var a=i("Mugr");i.n(a).a},Mugr:function(e,t,i){},kjwg:function(e,t,i){},mwzG:function(e,t,i){"use strict";t.a={code:0,msg:"执行成功!",result:{hideTitles:["id","productGenre","productUnit","parentId","warehouseId","productId","code","executeCount","state","cuser","uuser","remark","isdisable","qrcode","businessId"],pageData:{current:1,pages:"1",records:[],size:10,total:"1"},titles:[{progress:"进度"},{warehouseOutCode:"出库单编码"},{productCode:"货品编码"},{productName:"货品名称"},{productSpec:" 规格/型号"},{productGenreName:"货品属性"},{productUnitName:"计量单位"},{count:"出库数量"},{id:"id"},{productGenre:"货品属性ID"},{productUnit:"计量单位ID"},{parentId:"出库单ID"},{warehouseId:" (推荐)货位ID"},{productId:"产品ID"},{code:"批次号"},{executeCount:"已出库数量"},{state:"状态"},{cuser:"创建用户id"},{cdate:"创建时间"},{uuser:"修改用户id"},{udate:"修改时间"},{remark:"备注"},{isdisable:"是否启用"},{qrcode:"二维码"},{businessId:"业务id"}],varList:[{businessId:"",cdate:"3",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",isdisable1:"1",isdisable2:"0",isdisable3:"1",isdisable4:"1",name:"12",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.jpg",imgPath:"fileUpload/QRCode/product/1539142716704586.png",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",isdisable2:"1",isdisable3:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"219967d2f6704d868b11002caef9885c",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"2",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"111",productSpec:"22222222222222222222",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"55",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"3"},{businessId:"",cdate:"1",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"885c219967d2f6704d868b11002caef9",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"3",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2111111111111111111",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"2"}]}}}}]);