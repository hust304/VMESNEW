(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-3afb"],{ddId:function(t,e,i){"use strict";i.d(e,"c",function(){return a}),i.d(e,"e",function(){return o}),i.d(e,"d",function(){return l}),i.d(e,"b",function(){return r}),i.d(e,"a",function(){return s});var n=i("t3Un");function a(t){return Object(n.a)({url:"/sale/saleOrderAudit/listPageSaleOrderDetailByLockStock",method:"post",data:t})}function o(t){return Object(n.a)({url:"/sale/saleOrderAudit/updateSaleOrderDetailByLockStock",method:"post",data:t})}function l(t){return Object(n.a)({url:"/sale/saleOrderAudit/updateSaleOrderByAudit",method:"post",data:t})}function r(t){return Object(n.a)({url:"/sale/saleOrderAudit/auditPassSaleOrder",method:"post",data:t})}function s(t){return Object(n.a)({url:"/sale/saleOrderAudit/auditDisagreeSaleOrder",method:"post",data:t})}},kyJt:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("Oyvg"),i("rGqo");var n=i("ddId"),a=i("z0WU"),o=i("mSNy");function l(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}function r(t){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var s={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.needDeliverCount" @change="colConfig.needDeliverCountChange(scope.row,scope.$index)"/>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},c={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{orderId:"",needLockStockOrderDtlIds:"",rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,isNeedRepeat:!1,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],selectList:null,initConfigs:{tableOperates:{}},configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1}},created:function(){var t="";null!=this.initData.detailIds&&this.initData.detailIds.trim().length>0&&(t=this.initData.detailIds.trim()),this.initTable(t)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=r(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(a.k)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var n=t[i];n.indexOf("_")>0&&("en"==o.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==o.a.locale&&(n=n.substring(0,n.indexOf("_")))),e.tempLable[i]=n}})},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==o.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==o.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"needDeliverCount"===t.prop&&(t.component=s,t.needDeliverCountChange=e.needDeliverCountChange)}),this.internationalConfig(),t},internationalConfig:function(){"en"==o.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==o.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTable:function(t){var e=this;this.$loading({spinner:"none",text:"云上企业"}),Object(n.c)(function(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},n=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),n.forEach(function(e){l(t,e,i[e])})}return t}({},this.tempQuery,{detailIds:t,pageNo:this.pageNo})).then(function(t){e.getListPage(t),e.$loading().close()}).catch(function(t){e.$loading().close()})},dataBridge:function(t){},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},deleteBtns:function(t,e){this.tableData.splice(e,1)},isNumberByValue:function(t){return null!=t&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t)},checkColumn:function(t){for(var e="",i=0;i<t.length;i++){var n=t[i],a=n.orderCount,o=n.allowStockCount;null!=o&&(o=(o+="").trim(),this.isNumberByValue(o));var l=n.needDeliverCount;null==l||0==(l+"").trim().length?e=e+"第 "+(i+1)+" 行: 锁定货品数量("+l+")为空或空字符串！":null!=(l+="")&&l.trim().length>0&&!this.isNumberByValue(l.trim())?e=e+"第 "+(i+1)+" 行: 锁定货品数量("+l+") 输入错误，请输入大于零的正整数或(1,2)位小数！":(l=(l+"").trim(),a-o>0&&l-o>0?e=e+"第 "+(i+1)+" 行: 锁定货品数量("+l+") 输入错误，必须输入小于或等于库存可用数量！":a-o<=0&&l-a>0&&(e=e+"第 "+(i+1)+" 行: 锁定货品数量("+l+") 输入错误，必须输入小于或等于订购数量！"))}return e},saveSaleOrder:function(){var t=this;if(null!=this.tableData&&0!=this.tableData.length){var e=this.checkColumn(this.tableData);if(null!=e&&e.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:e});else{var i="",a=[];this.tableData.forEach(function(t){var e=t.productId;null!=e&&e.trim().length>0&&(i=i+e.trim()+","),a.push({id:t.id,productId:t.productId,versionLockCount:t.versionLockCount,needDeliverCount:t.needDeliverCount,prodUnitFormulaP2N:t.prodUnitFormulaP2N})});var o=JSON.stringify(a);Object(n.e)({productIds:i,dtlJsonStr:o}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.isVisible=!1,t.dialogClose({resState:"ok",pageName:"dialogLockStock"}))}).catch(function(t){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前订单明细中的货品在系统中无可用库存，无需锁定库存！"})},needDeliverCountChange:function(t,e){var i=t.needDeliverCount+"";null!=i&&i.trim().length>0&&!this.isNumberByValue(i.trim())&&this.$message({showClose:!0,message:"第 "+(e+1)+" 行: 锁定货品数量("+i.trim()+") 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3})},closeDialog:function(t){}}},u=i("KHd+"),d=Object(u.a)(c,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2),t._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.saveSaleOrder}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);d.options.__file="dialogLockStock.vue";e.default=d.exports}}]);