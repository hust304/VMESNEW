(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-c4b4","a0Xs"],{"/RvK":function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("Oyvg"),i("rGqo");var a=i("ddId"),n=i("rwyD"),r=(i("a0Xs"),i("z0WU")),o=i("mSNy");function l(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}function s(t){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var c={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.productPrice" @change="colConfig.productPriceChange(scope.row,scope.$index)" />\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},u={components:{},name:"dialog-add",props:["initData","visible"],data:function(){var t=this;return{fieldCode:"productCode,productName,productSpec,productGenreName,priceUnitName,count,productPrice,productSum,deliverDate,remark",rules:{customerName:[{required:!0,message:"请选择客户名称",trigger:"change"}],receiptTypeName:[{required:!0,trigger:"change",validator:function(e,i,a){t.temp.receiptType.length<=0?a(new Error("请选择发票类型")):a()}}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}],orderDate:[{required:!0,message:"请填写下单日期",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,isNeedRepeat:!1,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{id:"",discountSum:"",advanceSum:"",dtlJsonStr:""},tempLable:{},tempQuery:{},tableData:[],selectList:null,initConfigs:{tableOperates:{}},configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1}},created:function(){this.temp=this.initData.temp,this.initTable(null,this.initData.temp.id)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=s(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(r.j)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var a=t[i];a.indexOf("_")>0&&("en"==o.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==o.a.locale&&(a=a.substring(0,a.indexOf("_")))),e.tempLable[i]=a}})},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==o.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==o.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"productPrice"===t.prop&&(t.component=c,t.productPriceChange=e.productPriceChange)}),this.internationalConfig(),t},internationalConfig:function(){"en"==o.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==o.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTable:function(t,e){var i=this;this.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(n.listPageSaleOrderDetail)(function(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){l(t,e,i[e])})}return t}({},this.tempQuery,{fieldCode:this.fieldCode,parentId:e,pageNo:this.pageNo})).then(function(t){i.getListPage(t),i.$loading().close()}).catch(function(t){i.$loading().close()})},dataBridge:function(t){},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},deleteBtns:function(t,e){this.tableData.splice(e,1)},checkNumber:function(t,e){null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&this.$message({type:"warning",duration:5e3,showClose:!0,message:e+"("+t+") 输入错误，请输入大于零的正整数或(1,2)位小数！"})},checkDiscountSum:function(t){this.checkNumber(t,"折扣金额")},checkAdvanceSum:function(t){null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&this.checkNumber(t,"预付款")},checkColumn:function(t){for(var e="",i=0;i<t.length;i++){var a=t[i].productPrice;null!=a&&0!=a.trim().length||(e=e+"第 "+(i+1)+" 行: 单价为空或空字符串！"),null!=a&&a.trim().length>0&&!this.isNumberByValue(a.trim())&&(e=e+"第 "+(index+1)+" 行: 单价("+a+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return e},saveSaleOrder:function(){var t,e=this,i=this.temp.discountSum;null!=i&&i.trim().length>0&&this.checkNumber(i,"折扣金额");var n=this.temp.advanceSum;null!=n&&n.trim().length>0&&this.checkNumber(n,"预付款");var r=this.checkColumn(this.tableData);if(null!=r&&r.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:r});else{for(var o=[],l=0;l<this.tableData.length;l++){var s=this.tableData[l],c={id:"",productPrice:"",productSum:""};c.id=s.id,c.productPrice=s.productPrice,c.productSum=s.productSum,o.push(c)}t=JSON.stringify(o),this.temp.dtlJsonStr=t,this.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(a.e)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){}))})}},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t.trim())},productPriceChange:function(t,e){var i=t.productPrice;if(null!=i&&i.trim().length>0&&!this.isNumberByValue(i))this.$message({showClose:!0,message:"第 "+(e+1)+" 行: 单价("+i+") 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3});else{var a=t.count;if(null!=a&&a.trim().length>0){if(!this.isNumberByValue(a))return void this.$message({showClose:!0,message:"第 "+(e+1)+" 行: 订购数量("+a+") 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3});t.productSum=(a.trim()*i.trim()).toFixed(2)}}},closeDialog:function(t){}},watch:{pageNo:function(){this.initTable("add","")}}},d=i("KHd+"),p=Object(d.a)(u,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"客户名称:",prop:"customerName"}},[i("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:t.temp.customerName,callback:function(e){t.$set(t.temp,"customerName",e)},expression:"temp.customerName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"发票类型:",prop:"receiptTypeName"}},[i("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:t.temp.receiptTypeName,callback:function(e){t.$set(t.temp,"receiptTypeName",e)},expression:"temp.receiptTypeName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[i("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:t.temp.makeName,callback:function(e){t.$set(t.temp,"makeName",e)},expression:"temp.makeName"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"下单日期:",prop:"orderDate"}},[i("el-date-picker",{staticStyle:{width:"230px"},attrs:{type:"date",placeholder:"下单日期","value-format":"yyyy-MM-dd",disabled:!0},model:{value:t.temp.orderDate,callback:function(e){t.$set(t.temp,"orderDate",e)},expression:"temp.orderDate"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"交付日期:",prop:"deliverDate"}},[i("el-date-picker",{staticStyle:{width:"230px"},attrs:{type:"date",placeholder:"交付日期","value-format":"yyyy-MM-dd",disabled:!0},model:{value:t.temp.deliverDate,callback:function(e){t.$set(t.temp,"deliverDate",e)},expression:"temp.deliverDate"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"折扣金额:",prop:"discountSum"}},[i("el-input",{staticStyle:{width:"230px"},on:{change:t.checkDiscountSum},model:{value:t.temp.discountSum,callback:function(e){t.$set(t.temp,"discountSum",e)},expression:"temp.discountSum"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"预付款:",prop:"advanceSum"}},[i("el-input",{staticStyle:{width:"230px"},on:{change:t.checkAdvanceSum},model:{value:t.temp.advanceSum,callback:function(e){t.$set(t.temp,"advanceSum",e)},expression:"temp.advanceSum"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}})],1),t._v(" "),i("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2),t._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.saveSaleOrder}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);p.options.__file="dialogEdit.vue";e.default=p.exports},a0Xs:function(t,e,i){"use strict";i.d(e,"e",function(){return n}),i.d(e,"d",function(){return r}),i.d(e,"f",function(){return o}),i.d(e,"g",function(){return l}),i.d(e,"h",function(){return s}),i.d(e,"a",function(){return c}),i.d(e,"i",function(){return u}),i.d(e,"j",function(){return d}),i.d(e,"b",function(){return p}),i.d(e,"c",function(){return m});var a=i("t3Un");function n(t){return Object(a.a)({url:"/productUnit/listPageProductUnits",method:"post",data:t})}function r(t){return Object(a.a)({url:"/productUnitPrice/listPageProductUnitPrices",method:"post",data:t})}function o(t){return Object(a.a)({url:"/productUnit/save",method:"post",data:t})}function l(t,e){return Object(a.a)({url:"/productUnit/update",method:"post",data:{id:t,isdisable:e}})}function s(t,e,i){return Object(a.a)({url:"/productUnit/updateIsDefaultProductUnit",method:"post",data:{id:t,isdefault:e,productId:i}})}function c(t){return Object(a.a)({url:"/productUnit/deleteByIds",method:"post",data:{ids:t}})}function u(t){return Object(a.a)({url:"/productUnit/update",method:"post",data:t})}function d(t){return Object(a.a)({url:"/productUnit/updateProductUnitPrice",method:"post",data:t})}function p(t){return Object(a.a)({url:"/productUnit/findListProductUnit",method:"post",data:{productId:t}})}function m(t){return Object(a.a)({url:"/productUnit/formulaReckonByProductCount",method:"post",data:t})}},ddId:function(t,e,i){"use strict";i.d(e,"d",function(){return n}),i.d(e,"c",function(){return r}),i.d(e,"f",function(){return o}),i.d(e,"e",function(){return l}),i.d(e,"b",function(){return s}),i.d(e,"a",function(){return c});var a=i("t3Un");function n(t){return Object(a.a)({url:"/saleOrderAudit/listPageSaleOrderDetailByLockStock",method:"post",data:t})}function r(t){return Object(a.a)({url:"/saleOrderAudit/checkSaleOrderByAudit",method:"post",data:t})}function o(t){return Object(a.a)({url:"/saleOrderAudit/updateSaleOrderDetailByLockStock",method:"post",data:t})}function l(t){return Object(a.a)({url:"/saleOrderAudit/updateSaleOrderByAudit",method:"post",data:t})}function s(t){return Object(a.a)({url:"/saleOrderAudit/auditPassSaleOrder",method:"post",data:t})}function c(t){return Object(a.a)({url:"/saleOrderAudit/auditDisagreeSaleOrder",method:"post",data:t})}}}]);