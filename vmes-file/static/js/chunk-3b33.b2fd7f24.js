(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-3b33"],{"/RvK":function(e,t,a){"use strict";a.r(t);a("yt8O"),a("RW0V"),a("rE2o"),a("ioFf"),a("Oyvg"),a("rGqo");var i=a("ddId"),n=a("rwyD"),o=(a("a0Xs"),a("z0WU")),r=a("mSNy");function l(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}function s(e){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var c={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.productPrice" @change="colConfig.productPriceChange(scope.row,scope.$index)" />\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},u={components:{},name:"dialog-add",props:["initData","visible"],data:function(){var e=this;return{fieldCode:"productCode,productName,productSpec,productGenreName,orderUnitName,orderCount,productPrice,productSum,deliverDate,remark",rules:{customerName:[{required:!0,message:"请选择客户名称",trigger:"change"}],receiptTypeName:[{required:!0,trigger:"change",validator:function(t,a,i){e.temp.receiptType.length<=0?i(new Error("请选择发票类型")):i()}}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}],orderDate:[{required:!0,message:"请填写下单日期",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,isNeedRepeat:!1,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{id:"",discountSum:"",advanceSum:"",dtlJsonStr:""},tempLable:{},tempQuery:{},tableData:[],selectList:null,initConfigs:{tableOperates:{}},configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1}},created:function(){this.temp=this.initData.temp,this.initTable(null,this.initData.temp.id)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=s(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(o.m)(e.result),a=this.addTableTitle(t);this.configs.tableConfigs=a,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var a in e){var i=e[a];i.indexOf("_")>0&&("en"==r.a.locale?i=i.substring(i.indexOf("_")+1):"zh"==r.a.locale&&(i=i.substring(0,i.indexOf("_")))),t.tempLable[a]=i}})},addTableTitle:function(e){var t=this;return e.forEach(function(e){var a=e.label;a.indexOf("_")>0&&("en"==r.a.locale?e.label=a.substring(a.indexOf("_")+1):"zh"==r.a.locale&&(e.label=a.substring(0,a.indexOf("_")))),"productPrice"===e.prop&&(e.component=c,e.productPriceChange=t.productPriceChange)}),this.internationalConfig(),e},internationalConfig:function(){"en"==r.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==r.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTable:function(e,t){var a=this;this.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(n.listPageSaleOrderDetail)(function(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{},i=Object.keys(a);"function"==typeof Object.getOwnPropertySymbols&&(i=i.concat(Object.getOwnPropertySymbols(a).filter(function(e){return Object.getOwnPropertyDescriptor(a,e).enumerable}))),i.forEach(function(t){l(e,t,a[t])})}return e}({},this.tempQuery,{fieldCode:this.fieldCode,parentId:t,pageNo:this.pageNo})).then(function(e){a.getListPage(e),a.$loading().close()}).catch(function(e){a.$loading().close()})},dataBridge:function(e){},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},deleteBtns:function(e,t){this.tableData.splice(t,1)},checkNumber:function(e,t){null!=e&&e.trim().length>0&&!this.isNumberByValue(e.trim())&&this.$message({type:"warning",duration:5e3,showClose:!0,message:t+"("+e+") 输入错误，请输入大于零的正整数或(1,2)位小数！"})},checkDiscountSum:function(e){this.checkNumber(e,"折扣金额")},checkAdvanceSum:function(e){null!=e&&e.trim().length>0&&!this.isNumberByValue(e.trim())&&this.checkNumber(e,"预付款")},checkColumn:function(e){for(var t="",a=0;a<e.length;a++){var i=e[a].productPrice;null!=i&&0!=i.trim().length||(t=t+"第 "+(a+1)+" 行: 单价为空或空字符串！"),null!=i&&i.trim().length>0&&!this.isNumberByValue(i.trim())&&(t=t+"第 "+(index+1)+" 行: 单价("+i+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return t},saveSaleOrder:function(){var e,t=this,a=this.temp.discountSum;null!=a&&a.trim().length>0&&this.checkNumber(a,"折扣金额");var n=this.temp.advanceSum;null!=n&&n.trim().length>0&&this.checkNumber(n,"预付款");var o=this.checkColumn(this.tableData);if(null!=o&&o.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:o});else{for(var r=[],l=0;l<this.tableData.length;l++){var s=this.tableData[l],c={id:"",productPrice:"",productSum:""};c.id=s.id,c.productPrice=s.productPrice,c.productSum=s.productSum,r.push(c)}e=JSON.stringify(r),this.temp.dtlJsonStr=e,this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(i.d)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){}))})}},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},productPriceChange:function(e,t){var a=e.productPrice;if(null!=a&&a.trim().length>0&&!this.isNumberByValue(a))this.$message({showClose:!0,message:"第 "+(t+1)+" 行: 单价("+a+") 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3});else{var i=e.count;if(null!=i&&i.trim().length>0){if(!this.isNumberByValue(i))return void this.$message({showClose:!0,message:"第 "+(t+1)+" 行: 订购数量("+i+") 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3});e.productSum=(i.trim()*a.trim()).toFixed(2)}}},closeDialog:function(e){}},watch:{pageNo:function(){this.initTable("add","")}}},d=a("KHd+"),p=Object(d.a)(u,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"客户名称:",prop:"customerName"}},[a("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:e.temp.customerName,callback:function(t){e.$set(e.temp,"customerName",t)},expression:"temp.customerName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"发票类型:",prop:"receiptTypeName"}},[a("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:e.temp.receiptTypeName,callback:function(t){e.$set(e.temp,"receiptTypeName",t)},expression:"temp.receiptTypeName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:e.temp.makeName,callback:function(t){e.$set(e.temp,"makeName",t)},expression:"temp.makeName"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"下单日期:",prop:"orderDate"}},[a("el-date-picker",{staticStyle:{width:"230px"},attrs:{type:"date",placeholder:"下单日期","value-format":"yyyy-MM-dd",disabled:!0},model:{value:e.temp.orderDate,callback:function(t){e.$set(e.temp,"orderDate",t)},expression:"temp.orderDate"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"约定交期:",prop:"deliverDate"}},[a("el-date-picker",{staticStyle:{width:"230px"},attrs:{type:"date",placeholder:"约定交期","value-format":"yyyy-MM-dd",disabled:!0},model:{value:e.temp.deliverDate,callback:function(t){e.$set(e.temp,"deliverDate",t)},expression:"temp.deliverDate"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[a("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"折扣金额:",prop:"discountSum"}},[a("el-input",{staticStyle:{width:"230px"},on:{change:e.checkDiscountSum},model:{value:e.temp.discountSum,callback:function(t){e.$set(e.temp,"discountSum",t)},expression:"temp.discountSum"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"预付款:",prop:"advanceSum"}},[a("el-input",{staticStyle:{width:"230px"},on:{change:e.checkAdvanceSum},model:{value:e.temp.advanceSum,callback:function(t){e.$set(e.temp,"advanceSum",t)},expression:"temp.advanceSum"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:8}})],1),e._v(" "),a("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2),e._v(" "),a("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[a("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.saveSaleOrder}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);p.options.__file="dialogEdit.vue";t.default=p.exports},ddId:function(e,t,a){"use strict";a.d(t,"c",function(){return n}),a.d(t,"e",function(){return o}),a.d(t,"d",function(){return r}),a.d(t,"b",function(){return l}),a.d(t,"a",function(){return s});var i=a("t3Un");function n(e){return Object(i.a)({url:"/sale/saleOrderAudit/listPageSaleOrderDetailByLockStock",method:"post",data:e})}function o(e){return Object(i.a)({url:"/sale/saleOrderAudit/updateSaleOrderDetailByLockStock",method:"post",data:e})}function r(e){return Object(i.a)({url:"/sale/saleOrderAudit/updateSaleOrderByAudit",method:"post",data:e})}function l(e){return Object(i.a)({url:"/sale/saleOrderAudit/auditPassSaleOrder",method:"post",data:e})}function s(e){return Object(i.a)({url:"/sale/saleOrderAudit/auditDisagreeSaleOrder",method:"post",data:e})}}}]);