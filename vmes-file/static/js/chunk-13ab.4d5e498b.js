(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-13ab"],{"3d3b":function(t,e,a){"use strict";a("rE2o"),a("ioFf"),a("91GP"),a("pIFo");var i=a("f/WR"),o=a("uTIz");a("xMja");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{transferTable:i.a,searchBar:o.a},name:"productTableDialog",props:["initData","visible"],data:function(){return{fieldCode_default:"code,name,spec,unitName,genreName,stockCount,safetyCount,lockCount,productStockCount",fieldCode:"",isConfirm:!1,temp:{productIds:""},tempLable:{},rules:{},guid:"",tempQuery:{},searchList:[{label:"货品编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"spec",configs:{},placeholder:"请输入规格型号"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"unitName",configs:{},placeholder:"请输入计量单位"},{label:"货品属性",type:"select",ruleType:"string",mapKey:"genreName",configs:{clearable:!0,name:"",options:[{value:"成品",label:"成品"},{value:"原材料",label:"原材料"},{value:"辅料",label:"辅料"},{value:"半成品",label:"半成品"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!0,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},pageData:null,pageNo:1,btnList:[{name:"确定",isShow:!0,state:!0,method:this.toAddWarehouseIn},{name:"取消",state:!1,method:this.closeWin,isShow:!0}],apiData:{apiName:"listPageProducts",params:{}},tableSelectList:[],stateBtnData:{},tableConfigs:{showIndex:!0},tempList:[]}},created:function(){var t="";if(null!=this.initData.data&&this.initData.data.length>0)for(var e=0;e<this.initData.data.length;e++){var a=this.initData.data[e];null!=a.productId&&a.productId.trim().length>0&&(t=t+a.productId+",")}this.temp.productIds=t;var i="";null!=this.initData.queryStr&&(i=this.initData.queryStr);var o="";null==(o=null!=this.initData.fieldCode?this.initData.queryStr:this.fieldCode_default)||0==o.trim().length?this.fieldCode=this.fieldCode_default:null!=o&&o.trim().length>0&&(this.fieldCode=o.trim());var n="";n=null!=this.initData.orderStr?this.initData.queryStr:"prod.stock_count desc";var l=!0;null!=this.initData.isNeedRepeat&&(l=this.initData.isNeedRepeat),l||null!=t&&t.trim().length>0&&(i="prod.id not in ("+(t="'"+(t=t.substring(0,t.lastIndexOf(","))).replace(",","','")+"'")+")");var r="false";null!=this.initData.isNeedCustomerPrice&&this.initData.isNeedCustomerPrice&&(r="true");var s="";null!=this.initData.customerId&&this.initData.customerId.trim().length>0&&(s=this.initData.customerId.trim()),this.apiData.params={fieldCode:o,queryStr:i,orderStr:n,isNeedCustomerPrice:r,customerId:s,isdisable:"1"}},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{tableHeight:function(){},dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{sendGuid:function(t){this.guid=t},searchMap:function(t){this.apiData.params=Object.assign({},t),this.apiData.params.fieldCode=this.fieldCode},dialogOpen:function(){},closeWin:function(){this.isVisible=!1},dialogClose:function(t){this.$emit("close-dialog",t||{isConfirm:this.isConfirm,selectList:this.tempList})},toAddWarehouseIn:function(){this.isConfirm=!0,this.isVisible=!1},resetQuery:function(){this.$refs.trabsferTables.clearTableSelected()},tableSelected:function(t){this.tempList=t},closeDialog:function(t){this.showDialog=!1}}},r=a("KHd+"),s=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"margin-top":"15px","margin-left":"10px"}},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticStyle:{height:"500px"},style:{"margin-top":t.searchList.length?"10px":"0"}},[a("transfer-table",{ref:"trabsferTables",attrs:{tableConfigs:t.tableConfigs,btnList:t.btnList,stateBtn:t.stateBtnData,apiData:t.apiData},on:{"table-selected":t.tableSelected}})],1)],1)],1)},[],!1,null,null,null);s.options.__file="productTableDialog.vue";e.a=s.exports},ADOs:function(t,e,a){"use strict";var i=a("S4Mt");a.n(i).a},"MR/n":function(t,e,a){"use strict";a.r(e);a("f3/d"),a("Oyvg");var i=a("3d3b"),o=a("WIyV"),n=a("8Vv6"),l=a("aZSg"),r=(a("rwyD"),a("a0Xs")),s={components:{customBaseTable:o.a,productTableDialog:i.a},props:["initData","visible"],data:function(){var t=this;return{productUnit:{},rowData:{},rules:{customerName:[{required:!0,message:"请选择客户名称",trigger:"change"}],receiptTypeName:[{required:!0,trigger:"change",validator:function(e,a,i){t.temp.receiptType.length<=0?i(new Error("请选择发票类型")):i()}}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}],orderDate:[{required:!0,message:"请填写下单日期",trigger:"change"}],expectDate:[{required:!0,message:"请填写约定交期",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,isNeedRepeat:!1,tempLable:null,isNeedCustomerPrice:!1,customerId:""},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{priceType:"1",customerId:"",customerName:"",receiptType:"",receiptTypeName:"",orderDate:new Date,expectDate:new Date,makeId:"",makeName:"",remark:"",dtlJsonStr:""},tempLable:{},tempQuery:{},tableData:[],orderDtlList:[],configs:{topBarBtnList:[{name:"选择货品",nameEn:"add",isShow:!0,icon:"add",method:this.addProduct}],tableConfigs:[],showCheckBox:!1,showIndex:!1},CustomerDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择客户名称",tableUrl:"/base/departmentCustomer/listPageDepartmentCustomer",tableParm:{queryStr:"a.type = '3'"},temp:{}},dialogName:"dialogOption"}},MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择制单人",tableUrl:"/system/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}},apiObj:{apiName:"listPageSaleOrderDetail",params:{pageNo:1,type:"add",fieldCode:"productCode,productName,productSpec,productGenreName,orderUnitName,orderCount,productPrice,productSum,stockCountByPrice,productStockCountByPrice,deliverDate,remark"}},customColumn:[{columnIndex:"orderUnitName",componentName:"select",_cellConfig:{asyn:{apiName:"findListProductUnitByProduct",params:{productId:""}},rules:[{required:!0}],outputData:!0}},{columnIndex:"orderCount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"productPrice",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"productSum",_cellConfig:{hideTitle:!0,compute:"self@orderCount(*)self@productPrice"}},{columnIndex:"deliverDate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy-MM-dd",valueFormat:"yyyy-MM-dd",lessThan:["tempData@maxExpectDate",!0]}},{columnIndex:"remark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{maxExpectDate:""},isValidate:!1}},beforeCreate:function(){},created:function(){var t=this.$storage.get("userInfo");null!=t.userId&&t.userId.trim().length>0&&(this.temp.makeId=t.userId.trim()),null!=t.userName&&t.userName.trim().length>0&&(this.temp.makeName=t.userName.trim())},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(t){this.isValidate=!0,Array.isArray(t)?(this.orderDtlList=[],this.orderDtlList=t):(this.productUnit=null,null!=t.item&&(this.productUnit=t.item),this.rowData=null,null!=t.item&&(this.rowData=t.row),this.setProductPrice(this.productUnit,this.rowData),this.formulaReckonByProductCount_n2p(this.productUnit.n2pFormula,this.rowData),this.setProductSum(this.rowData))},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&(t.isValidate=!1,t.$refs.orderAddDialog.getData(),t.isValidate&&t.saveSaleOrder(t.orderDtlList))})},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t.trim())},checkColumn:function(t){for(var e="",a=this.temp.expectDate,i=0;i<t.length;i++){var o=t[i],n=o.productPrice;null!=n&&0!=n.trim().length||(e=e+"第 "+(i+1)+" 行: 单价为空或空字符串！");var l=o.deliverDate;null==l&&(e=e+"第 "+(i+1)+" 行: 约定交期为空或空字符串！"),null!=a&&null!=l&&a<l&&(e=e+"第 "+(i+1)+" 行: 约定交期不可大于("+a+")！"),null!=n&&n.trim().length>0&&!this.isNumberByValue(n.trim())&&(e=e+"第 "+(i+1)+" 行: 单价("+n+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return e},saveSaleOrder:function(t){var e=this;if(null!=t&&0!=t.length){var a=this.checkColumn(t);if(null!=a&&a.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:a});else{for(var i=[],o=0;o<t.length;o++){var l=t[o],r={productId:"",productPrice:"",p2nFormula:"",n2pFormula:"",orderCount:"",orderUnit:"",productUnit:"",priceUnit:"",productSum:"",deliverDate:"",remark:""};r.productId=l.productId,r.productPrice=l.productPrice,r.p2nFormula=l.p2nFormula,r.n2pFormula=l.n2pFormula,r.orderCount=l.orderCount,r.orderUnit=l.orderUnit,r.productUnit=l.productUnit,r.priceUnit=l.priceUnit,r.productSum=l.productSum,r.deliverDate=l.deliverDate,r.remark=l.remark,i.push(r)}this.temp.dtlJsonStr="",null!=i&&i.length>0&&(this.temp.dtlJsonStr=JSON.stringify(i)),this.dialogLoading=!0,Object(n.addSaleOrder)(this.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})},customerSelect:function(t){t[0]&&(this.temp.customerId=t[0].id,this.temp.customerName=t[0].name)},makeSelect:function(t){t[0]&&(this.temp.makeId=t[0].id,this.temp.makeName=t[0].name)},checkNumber:function(t,e){null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&this.$message({type:"warning",duration:5e3,showClose:!0,message:e+"("+t+") 输入错误，请输入大于零的正整数或(1,2)位小数！"})},changeAdvanceSum:function(t){null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&this.checkNumber(t,"预付款")},addProduct:function(){this.$refs.orderAddDialog.getData(),this.dialogData.data=this.orderDtlList,this.dialogData.isNeedRepeat=!1,this.dialogData.isNeedCustomerPrice=!0,this.dialogData.customerId=this.temp.customerId,this.dialogData.title="选择货品",this.openDialogName="productTableDialog",this.showDialog=!0,this.inLinVisible=!0},setProductPrice:function(t,e){null!=t&&null!=e&&(null!=t.id&&(e.priceUnit=t.id,e.orderUnit=t.id),null!=t.productPrice&&(e.productPrice=t.productPrice),null!=t.n2pFormula&&(e.n2pFormula=t.n2pFormula),null!=t.p2nFormula&&(e.p2nFormula=t.p2nFormula))},formulaReckonByProductCount_n2p:function(t,e){if(null!=t&&0!=t.trim().length){var a="";null!=e.stockCount&&e.stockCount.trim().length>0&&(a=e.stockCount.trim());var i="";null!=e.productStockCount&&e.productStockCount.trim().length>0&&(i=e.productStockCount.trim()),Object(r.formulaReckonByProductCount)({parmKey:"N",stockCount:a,productStockCount:i,formula:t}).then(function(t){0===t.code&&(a-0!=0&&null!=t.stockCount_n2p&&t.stockCount_n2p.trim().length>0&&(e.stockCountByPrice=t.stockCount_n2p),i-0!=0&&null!=t.productStockCount_n2p&&t.productStockCount_n2p.trim().length>0&&(e.productStockCountByPrice=t.productStockCount_n2p))}).catch(function(t){})}},setProductSum:function(t){if(null!=t){t.productSum="";var e=t.orderCount,a=t.productPrice;null!=e&&e.trim().length>0&&null!=a&&a.trim().length>0&&(t.productSum=(e.trim()*a.trim()).toFixed(2))}},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},closeDialog:function(t){this.showDialog=!1;var e=!1;null!=t.isConfirm&&(e=t.isConfirm);var a=[];null!=t.selectList&&(a=t.selectList),this.tableSelected(e,a)},tableSelected:function(t,e){if(t&&null!=e&&e.length>0)for(var a=this.temp.expectDate,i=0;i<e.length;i++){var o=e[i],n={productId:"",productCode:"",productName:"",productSpec:"",productGenreName:"",productPrice:"",n2pFormula:"",p2nFormula:"",orderUnit:"",orderCount:"",productUnit:"",productUnitName:"",productCount:"",stockCount:"",productStockCount:"",priceUnit:"",priceCount:"",stockCountByPrice:"",productStockCountByPrice:"",productSum:"",deliverDate:"",stateName:"",remark:""};null!=o.code&&o.code.trim().length>0&&(n.productCode=o.code.trim()),null!=o.name&&o.name.trim().length>0&&(n.productName=o.name.trim()),null!=o.spec&&o.spec.trim().length>0&&(n.productSpec=o.spec.trim()),null!=o.genreName&&o.genreName.trim().length>0&&(n.productGenreName=o.genreName.trim()),null!=o.unitName&&o.unitName.trim().length>0&&(n.productUnitName=o.unitName.trim()),n.orderUnit=o.unit,n.orderUnitName=o.unitName,n.productPrice=o.price,n.p2nFormula=o.p2nFormula,n.n2pFormula=o.n2pFormula,n.stockCountByPrice=o.stockCount,n.productStockCountByPrice=o.productStockCount,n.productId=o.id.trim(),n.productUnit=o.unit.trim(),n.stockCount=o.stockCount.trim(),n.productStockCount=o.productStockCount.trim(),null!=a&&(n.deliverDate=a,n.maxExpectDate=a,this.tempData.maxExpectDate=a);var l=this.temp.customerId;null!=l&&l.trim().length>0&&null!=o.id&&o.id.trim().length>0&&null!=o.unit&&o.unit.trim().length>0&&this.findProductPrice(n,l,o.id.trim(),o.unit.trim()),this.tableData.push(n)}},findProductPrice:function(t,e,a,i){return Object(l.a)({customerId:e,productId:a,unit:i}).then(function(e){0===e.code&&null!=e.productPrice&&e.productPrice.trim().length>0&&(t.productPrice=e.productPrice)}).catch(function(t){}),""}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},watch:{"temp.expectDate":function(){this.tempData.maxExpectDate=this.temp.expectDate}}},c=a("KHd+"),u=Object(c.a)(s,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"客户名称:",prop:"customerName"}},[a("base-input-option",{staticStyle:{width:"230px"},attrs:{dialog:t.CustomerDialog.dialog},on:{callback:t.customerSelect},model:{value:t.temp.customerName,callback:function(e){t.$set(t.temp,"customerName",e)},expression:"temp.customerName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"发票类型:",prop:"receiptTypeName"}},[a("el-select",{staticStyle:{width:"230px"},attrs:{placeholder:"发票类型"},model:{value:t.temp.receiptType,callback:function(e){t.$set(t.temp,"receiptType",e)},expression:"temp.receiptType"}},[a("el-option",{attrs:{label:"不开票",value:"1"}}),t._v(" "),a("el-option",{attrs:{label:"增值税普通发票",value:"2"}}),t._v(" "),a("el-option",{attrs:{label:"增值税专用发票",value:"3"}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("base-input-option",{staticStyle:{width:"230px"},attrs:{dialog:t.MakeDialog.dialog},on:{callback:t.makeSelect},model:{value:t.temp.makeName,callback:function(e){t.$set(t.temp,"makeName",e)},expression:"temp.makeName"}})],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"下单日期:",prop:"orderDate"}},[a("el-date-picker",{staticStyle:{width:"230px"},attrs:{type:"date",placeholder:"下单日期","value-format":"yyyy-MM-dd"},model:{value:t.temp.orderDate,callback:function(e){t.$set(t.temp,"orderDate",e)},expression:"temp.orderDate"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"约定交期:",prop:"expectDate"}},[a("el-date-picker",{staticStyle:{width:"230px"},attrs:{type:"date",placeholder:"约定交期","value-format":"yyyy-MM-dd"},model:{value:t.temp.expectDate,callback:function(e){t.$set(t.temp,"expectDate",e)},expression:"temp.expectDate"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"预付款:",prop:"advanceSum"}},[a("el-input",{staticStyle:{width:"230px"},on:{change:t.changeAdvanceSum},model:{value:t.temp.advanceSum,callback:function(e){t.$set(t.temp,"advanceSum",e)},expression:"temp.advanceSum"}})],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[a("el-input",{staticStyle:{width:"230px"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:8}}),t._v(" "),a("el-col",{attrs:{span:8}})],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2),t._v(" "),a("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[a("custom-base-table",{ref:"orderAddDialog",attrs:{isSortable:!1,varList:t.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:t.customColumn,apiObj:t.apiObj,mergeTitle:t.mergeTitle,mergeColumn:t.mergeColumn,mergeRow:t.mergeRow,tempData:t.tempData,componentId:"orderAddDialog",useDefaultBtn:!0,showAll:!1,keyMapping:t.keyMapping},on:{databridge:t.databridge}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);u.options.__file="dialogAdd.vue";e.default=u.exports},S4Mt:function(t,e,a){},aZSg:function(t,e,a){"use strict";a.d(e,"d",function(){return o}),a.d(e,"b",function(){return n}),a.d(e,"e",function(){return l}),a.d(e,"c",function(){return r}),a.d(e,"a",function(){return s});var i=a("t3Un");function o(t){return Object(i.a)({url:"/sale/saleUnitPrice/listPageSaleUnitPrices",method:"post",data:t})}function n(t){return Object(i.a)({url:"/sale/saleUnitPrice/listPageCustomerUnitPrices",method:"post",data:t})}function l(t){return Object(i.a)({url:"/sale/saleUnitPrice/update",method:"post",data:t})}function r(t){return Object(i.a)({url:"/sale/saleUnitPrice/listPageCustomerUnitPricesHis",method:"post",data:t})}function s(t){return Object(i.a)({url:"/sale/saleUnitPrice/findSaleUnitPrice",method:"post",data:t})}},"f/WR":function(t,e,a){"use strict";a("XfO3"),a("HEwt"),a("a1Th"),a("rE2o"),a("ioFf"),a("dRSK"),a("rGqo"),a("91GP");var i=a("z0WU"),o=a("Yfch");function n(t){return function(t){if(Array.isArray(t))return t}(t)||function(t){if(Symbol.iterator in Object(t)||"[object Arguments]"===Object.prototype.toString.call(t))return Array.from(t)}(t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}()}var l={props:["colConfig","fixed"],template:'<el-table-column :label="colConfig.label" :fixed="fixed" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t  <template v-for="(item, index) in colConfig.rowMethods">\n    \t\t\t\t\t    <el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="item.method(scope.row,scope.$index)" v-text="item.name"></el-button>\n                </template>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},r={components:{},name:"transfer-table",props:{tableConfigs:{type:Object,default:function(){return{}}},btnList:{type:Array,default:function(){return[]}},upTableBtnTemplate:{type:Array,default:function(){return[]}},downTableBtnTemplate:{type:Array,default:function(){return[]}},apiData:{type:Object,default:function(){return{}}},stateBtn:{type:Object,default:function(){return{}}}},data:function(){return{btnsBoxHeight:0,currentpage:1,tableLoading:!1,tableData:[],resultTableData:[],titleList:[],pageData:{},tableBtns:{columnIndex:"last",prop:"operate",label:"操作",component:l,rowMethods:[{name:"删除",method:this.deleteRow}]},rowKey:"",tempSelectList:[],stateBtnChecked:!1}},computed:{setTablesHeight:function(){return this.stateBtn.title?{height:"calc(50% - 15px)"}:{height:"calc(50% - 6px)"}},setResultBtnState:function(){var t=this;return function(e){return!t.resultTableData.length&&e.state}},setTableConfigs:function(){var t=n(this.titleList).slice(0);return{titleList:this.addTableTitle(t,this.upTableBtnTemplate),showIndex:void 0!==this.tableConfigs.showIndex&&this.tableConfigs.showIndex,isSingle:void 0!==this.tableConfigs.isSingle&&this.tableConfigs.isSingle,isSortable:void 0!==this.tableConfigs.isSortable&&this.tableConfigs.isSortable}},setResultTableConfigs:function(){var t=n(this.titleList).slice(0);return this.downTableBtnTemplate.length?this.addTableTitle(t,this.downTableBtnTemplate):this.addTableTitle(t,[this.tableBtns])},setResultTableData:function(){return[].concat(this.resultTableData)}},watch:{currentpage:function(){var t=Object.assign({},this.apiData.params);t.pageNo=this.currentpage,this.httpTableMethod(this.apiData.apiName,t)},setResultTableData:function(){this.$emit("table-selected",this.setResultTableData)},stateBtnChecked:function(){var t={};t[this.stateBtn.keyName?this.stateBtn.keyName:"isShow"]=this.stateBtnChecked,this.httpTableMethod(this.apiData.apiName,this.apiData.params,t)},"apiData.params":function(){console.log(this.apiData.params),this.httpTableMethod(this.apiData.apiName,this.apiData.params)}},created:function(){this.apiData.apiName?(this.httpTableMethod(this.apiData.apiName,this.apiData.params),this.rowKey=this.tableConfigs.rowKey||"id"):this.$message({message:"没有设置接口名",type:"error",duration:1e4})},mounted:function(){this.$nextTick(function(){this.btnsBoxHeight=this.$refs.btnsBox.clientHeight+5})},methods:{clearTableSelected:function(){var t=this;this.resultTableData=[],this.tempSelectList=[],this.tableData.forEach(function(e){t.$refs.selectTable.$refs.baseTable.clearSelection()})},httpTableMethod:function(t,e,a){var i=this;this.tableLoading=!0,this.$api[t](Object.assign({},e,a)).then(function(t){console.log(t),i.getListPage(t),i.tableLoading=!1}).catch(function(t){i.tableLoading=!1})},getListPage:function(t){var e=this;t&&(t.result.titles="string"==typeof t.result.titles?JSON.parse(t.result.titles):t.result.titles,t.result.varList="string"==typeof t.result.varList?JSON.parse(t.result.varList):t.result.varList,t.result.pageData="string"==typeof t.result.pageData?JSON.parse(t.result.pageData):t.result.pageData,this.titleList=Object(i.m)(t.result),this.pageData=t.result.pageData,this.tableData=t.result.varList||[],this.tempSelectList=[],this.$nextTick(function(t){e.toggleRowSelected()}))},toggleRowSelected:function(){var t=this;this.tableData.forEach(function(e){t.resultTableData.some(function(a){return e[t.rowKey]===a[t.rowKey]})?(t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!0),!t.tempSelectList.some(function(a){return a[t.rowKey]===e[t.rowKey]})&&t.tempSelectList.push(e)):t.$refs.selectTable&&t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!1)})},addTableTitle:function(t,e){return e&&e.length&&e.forEach(function(e){Object(o.b)(e.columnIndex)?t.splice(e.columnIndex,0,e):"first"===e.columnIndex?t.unshift(e):"last"===e.columnIndex?t.push(e):t.some(function(t){if(t.prop===e.columnIndex)return Object.assign(t,e),!0})}),t},dataBridge:function(t,e){this.getChecked(e,t)?this.addRowData(e):this.removeRowData(e)},resultDataBridge:function(t,e){console.log(t),console.log(e)},deleteRow:function(t,e){var a=this;console.log(t),console.log(e),this.resultTableData.find(function(e,i){if(t[a.rowKey]===e[a.rowKey])return a.resultTableData.splice(i,1),e}),this.toggleRowSelected()},updateView:function(t,e){this.resultTableData.splice(e-1,1,t)},getChecked:function(t,e){var a=this;return t?e.some(function(e){return t[a.rowKey]===e[a.rowKey]}):(e.length&&(this.tempSelectList=e),!!e.length)},addRowData:function(t){var e=this;t?!this.resultTableData.some(function(a){return t[e.rowKey]===a[e.rowKey]})&&this.resultTableData.push(t):this.addAllRowData()},addAllRowData:function(){var t=this;this.resultTableData.length?this.tempSelectList.forEach(function(e){t.addRowData(e)}):this.resultTableData=this.tempSelectList},removeRowData:function(t){var e=this;t?this.resultTableData.some(function(a,i){if(t[e.rowKey]===a[e.rowKey])return e.resultTableData.splice(i,1),!0}):this.tableData.forEach(function(t){e.removeRowData(t)})}}},s=(a("ADOs"),a("KHd+")),c=Object(s.a)(r,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"myCoustomTable",staticStyle:{height:"100%",padding:"10px"}},[t.stateBtn.title?a("div",{staticStyle:{"text-align":"right"}},[a("el-checkbox",{model:{value:t.stateBtnChecked,callback:function(e){t.stateBtnChecked=e},expression:"stateBtnChecked"}},[t._v(t._s(t.stateBtn.title))])],1):t._e(),t._v(" "),a("div",{style:t.setTablesHeight},[a("base-table",{directives:[{name:"loading",rawName:"v-loading",value:t.tableLoading,expression:"tableLoading"}],ref:"selectTable",attrs:{data:t.tableData,colConfigs:t.setTableConfigs.titleList,showCheckBox:!0,showIndex:t.setTableConfigs.showIndex,pageData:t.pageData,currentpage:t.currentpage,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.dataBridge}})],1),t._v(" "),a("div",{staticStyle:{height:"11px"}}),t._v(" "),a("div",{ref:"resultBox",staticStyle:{position:"relative"},style:t.setTablesHeight},[a("div",{staticStyle:{height:"100%"},style:{paddingBottom:t.btnsBoxHeight+"px"}},[a("base-table",{ref:"resultTable",attrs:{data:t.setResultTableData,colConfigs:t.setResultTableConfigs,showCheckBox:!1,showIndex:t.setTableConfigs.showIndex,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{databridge:t.resultDataBridge}})],1),t._v(" "),a("div",{ref:"btnsBox",staticStyle:{position:"absolute",bottom:"0",right:"0"}},[t.btnList.length?[t._l(t.btnList,function(e,i){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],key:i,attrs:{name:e.name,icon:e.icon,plain:e.plain,state:t.setResultBtnState(e)},on:{myclick:e.method}})]})]:t._e()],2)])])},[],!1,null,"68c26095",null);c.options.__file="index.vue";e.a=c.exports}}]);